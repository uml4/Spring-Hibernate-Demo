/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pnv.dao;

import com.pnv.models.Departments;
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
public class DepartmentDaoImpl implements DepartmentDao {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void saveOrUpdate(Departments department) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(department);
            transaction.commit();
        } catch (HibernateException hb) {
            transaction.rollback();
            System.err.println("error" + hb);
        } finally {
            session.close();
        }
    }

   

    @Override
    public void delete(Departments department) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(department);
            transaction.commit();
        } catch (HibernateException hb) {
            transaction.rollback();
            System.err.println("error" + hb);
        } finally {
            session.close();
        }
    }

    @Override
    public List<Departments> findAll() {
        Session session = sessionFactory.openSession();
        List<Departments> departmentsList = session.createQuery("from Departments").list();
        session.close();
        return departmentsList;
    }

    @Override
    public Departments findByDepartmentId(int id) {
        Departments department = null;
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            department = (Departments) session.get(Departments.class, id);
        } catch (HibernateException hb) {
            transaction.rollback();
            System.err.println("error" + hb);
        } finally {
            session.close();
        }
        return department;
    }

    @Override
    public Departments findByDepartmentCode(String departmentsCode) {
        Departments department = null;
        String strQuery = "from Departments WHERE depCode = :depCode ";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(strQuery);
        query.setParameter("depCode", departmentsCode);
        department = (Departments) query.uniqueResult();
        session.close();
        return department;
    }

}
