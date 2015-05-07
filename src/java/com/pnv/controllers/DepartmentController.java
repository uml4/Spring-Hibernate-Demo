/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pnv.controllers;

import com.pnv.dao.DepartmentDao;
import com.pnv.models.Departments;
import com.pnv.utils.Constant;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Administrator
 */
@Controller
@RequestMapping(value = "/department")
public class DepartmentController {

    @Autowired
    private DepartmentDao departmentDao;

    public DepartmentController() {
    }

    @RequestMapping(method = RequestMethod.GET)
    public String viewDepartmentPage(ModelMap map) {
        /**
         * Get all titles
         */
        List<Departments> departments_list = departmentDao.findAll();
        map.put("departments_list", departments_list);
        return "department";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String viewEditTitlePage(@RequestParam(value = "id", required = true) int id, ModelMap map) {

        Departments departmentForm = departmentDao.findByDepartmentId(id);
        map.addAttribute("departmentForm", departmentForm);
        return "department-add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String viewAddNewPage(ModelMap map) {

        Departments departmentForm = new Departments();
        map.addAttribute("departmentForm", departmentForm);
        return "department-add";

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String doAddNew(@Valid @ModelAttribute("departmentForm") Departments departmentForm,
            BindingResult result, ModelMap map) {

        if (result.hasErrors()) {
            map.addAttribute("departmentForm", departmentForm);
            return "department-add";
        }
        departmentDao.saveOrUpdate(departmentForm);

        /**
         * Get all titles
         */
        List<Departments> departments_list = departmentDao.findAll();
        map.put("departments_list", departments_list);
        map.addAttribute("add_success", "ok");

        return "department";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String doDeleteTitle(@RequestParam(value = "id", required = true) int id, ModelMap map) {

        departmentDao.delete(departmentDao.findByDepartmentId(id));

        return Constant.REDIRECT + "/department";

    }

}
