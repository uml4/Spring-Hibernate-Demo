/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pnv.dao;

import com.pnv.models.Titles;
import com.pnv.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrator
 */
@Repository("TitlesDao")
public class TitlesDaoImpl implements TitlesDao {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public TitlesDaoImpl() {

    }

    @Override
    public void saveOrUpdate(Titles title) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(title);
            transaction.commit();
        } catch (HibernateException hb) {
            transaction.rollback();
            System.err.println("error" + hb);
        } finally {
            session.close();
        }
    }

    
    @Override
    public void delete(Titles title) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(title);
//            session.flush();
            transaction.commit();
        } catch (HibernateException hb) {
            transaction.rollback();
            System.err.println("error" + hb);
        } finally {
            session.close();
        }
    }

    @Override
    public Titles findByTitleId(int id) {
        Titles title = null;
        Session session = sessionFactory.getCurrentSession();
         Transaction transaction = session.beginTransaction();
        try {
          title =  (Titles) session.get(Titles.class, id);
        } catch (HibernateException hb) {
            transaction.rollback();
            System.err.println("error" + hb);
        } finally {
            session.close();
        }
        return title;
    }

    @Override
    public Titles findByTitleCode(String titleCode) {
        Titles title = null;
        String strQuery = "from Titles WHERE titleCode =:titleCode ";
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(strQuery);
        query.setParameter("titleCode", titleCode);
        title = (Titles) query.uniqueResult();
        session.close();
        return title;
    }

    @Override
    public List<Titles> findAll() {
        Session session = sessionFactory.openSession();
        List<Titles> titlesList = session.createQuery("from Titles").list();
        session.close();
        return titlesList;

    }

}
