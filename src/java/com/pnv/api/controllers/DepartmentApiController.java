/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pnv.api.controllers;

import com.pnv.dao.DepartmentDao;
import com.pnv.models.Departments;
import com.pnv.models.Employees;
import com.pnv.models.Titles;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Administrator
 */
@Controller
@RequestMapping(value = "api/department")
public class DepartmentApiController {

    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping(method = RequestMethod.GET)
    public  @ResponseBody List<Departments> viewDepartmentPage() {
        /**
         * Get all titles
         */
        List<Departments> departments_list = departmentDao.findAll();
        return departments_list;
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public  @ResponseBody Departments getDepartmentByID(@PathVariable(value = "id") Integer id) {
        
//        Employees emp = new Employees();
//        emp.setEmpName("ddd");
//        emp.setAddress("ssss");
//        List<Employees> emp_lst = new ArrayList<Employees>();
        Departments dep = departmentDao.findByDepartmentId(id);
       // dep.setEmployees(emp_lst);
        return departmentDao.findByDepartmentId(id);
    }
}
