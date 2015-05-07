/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pnv.controllers;

import com.pnv.dao.DepartmentDao;
import com.pnv.dao.EmployeeDao;
import com.pnv.dao.TitlesDao;
import com.pnv.models.Employees;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Administrator
 */
@Controller
@RequestMapping(value = "/employee")
public class EmployeeControllers {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private TitlesDao titlesDao;

    @RequestMapping(method = RequestMethod.GET)
    public String viewEmployeePage(@RequestParam(value = "titleId", required = false) Integer titleId, @RequestParam(value = "departmentId", required = false) Integer departmentId, ModelMap map) {

        List<Employees> employees_list;

        if (titleId != null) {
            employees_list = titlesDao.findByTitleId(titleId).getEmployees();
        } else if (departmentId != null) {
            employees_list = departmentDao.findByDepartmentId(departmentId).getEmployees();
        } else {
            employees_list = employeeDao.findAll();
        }

        map.put("employees_list", employees_list);
        return "employee";
    }

}
