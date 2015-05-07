/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pnv.dao;

import com.pnv.models.Departments;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface DepartmentDao {

    public void saveOrUpdate(Departments department);

    public void delete(Departments department);

    public List<Departments> findAll();

    public Departments findByDepartmentId(int id);

    public Departments findByDepartmentCode(String departmentsCode);
    
}
