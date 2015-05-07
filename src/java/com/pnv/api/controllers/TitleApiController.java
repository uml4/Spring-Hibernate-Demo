/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pnv.api.controllers;

import com.pnv.dao.TitlesDao;
import com.pnv.models.Titles;
import com.pnv.utils.Constant;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Administrator
 */
@Controller
@RequestMapping(value = "api/title")
public class TitleApiController {

    @Autowired
    private TitlesDao titlesDao;

    public TitleApiController() {

    }

    @RequestMapping(method = RequestMethod.GET )
    public @ResponseBody    List<Titles> getTitles() {

        /**
         * Get all titles
         */ 
        List<Titles> titles_list = titlesDao.findAll();
        
        return titles_list;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public @ResponseBody    Titles getTitleByID( @PathVariable(value = "id") Integer id) {        
        return titlesDao.findByTitleId(id);
    }
    
    
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String viewEditTitlePage(@RequestParam(value = "id", required = true) int id, ModelMap map) {

        Titles titleForm = titlesDao.findByTitleId(id);
        map.addAttribute("titleForm", titleForm);
        return "title-addnew";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String viewAddNewPage(ModelMap map) {

        Titles titleForm = new Titles();
        map.addAttribute("titleForm", titleForm);
        return "title-add";

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String doAddNew(@Valid @ModelAttribute("titleForm") Titles titleForm,
            BindingResult result, ModelMap map) {

        if (result.hasErrors()) {
            map.addAttribute("titleForm", titleForm);
            return "title-add";
        }
        titlesDao.saveOrUpdate(titleForm);

        /**
         * Get all titles
         */
        List<Titles> titles_list = titlesDao.findAll();
        map.put("titles_list", titles_list);
        map.addAttribute("add_success", "ok");

        return "title";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String doDeleteTitle(@RequestParam(value = "id", required = true) int id, ModelMap map) {

        titlesDao.delete(titlesDao.findByTitleId(id));

        return Constant.REDIRECT + "/title";

    }

}
