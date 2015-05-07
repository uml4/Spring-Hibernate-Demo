/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pnv.dao;

import com.pnv.models.Employees;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface EmployeeDao {

    public void saveOrUpdate(Employees employee);

    public void delete(Employees employee);

    public List<Employees> findAll();

    public Employees findByEmployeeId(int id);

    public List<Employees> findByEmployeeName(String employeeName);
}
