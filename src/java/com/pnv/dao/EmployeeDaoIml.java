/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pnv.dao;

import com.pnv.models.Departments;
import com.pnv.models.Employees;
import com.pnv.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
public class EmployeeDaoIml implements EmployeeDao{

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    @Override
    public void saveOrUpdate(Employees employee) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            
            session.saveOrUpdate( employee );
            transaction.commit();
            
        } catch (HibernateException hb) {
            transaction.rollback();
            System.err.println("error" + hb);
        } finally {
            session.close();
        }
    }


    @Override
    public void delete(Employees employee) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(employee);
            transaction.commit();
        } catch (HibernateException hb) {
            transaction.rollback();
            System.err.println("error" + hb);
        } finally {
            session.close();
        }
    }

    @Override
    public List<Employees> findAll() {
        Session session = sessionFactory.openSession();
        List<Employees> employeesList = session.createQuery("from Employees").list();
        session.close();
        return employeesList;
    }

    @Override
    public Employees findByEmployeeId(int id) {
        Employees employee = null;
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            employee = (Employees) session.get(Departments.class, id);
        } catch (HibernateException hb) {
            transaction.rollback();
            System.err.println("error" + hb);
        } finally {
            session.close();
        }
        return employee;
    }

    @Override
    public List<Employees> findByEmployeeName(String employeeName) {
       Departments department = null;
        String strQuery = "from Employees WHERE employeeName LIKE :employeeName ";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(strQuery);
        query.setParameter( "employeeName", "%" + employeeName + "%" );
        List<Employees> employeesList = query.list();
        session.close();
        return employeesList;
    }
    
}
