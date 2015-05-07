/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pnv.dao;

import com.pnv.models.Titles;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface TitlesDao {

    public void saveOrUpdate(Titles title);

    public void delete(Titles title);

    public List<Titles> findAll();

    public Titles findByTitleId(int id);

    public Titles findByTitleCode(String titleCode);

}
