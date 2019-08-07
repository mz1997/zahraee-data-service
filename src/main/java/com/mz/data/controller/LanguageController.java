package com.mz.data.controller;


import com.mz.data.loadView.LanguageLoad;
import com.mz.data.model.Language;
import com.mz.data.model.Pagination;
import com.mz.data.postView.LanguagePost;
import com.mz.data.service.interfaces.ILanguageService;
import com.mz.data.view.LanguageView;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/language")
public class LanguageController {

    @Autowired
    private ILanguageService languageService;

    @Autowired
    private Mapper mapper;

    //save:
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody LanguagePost languagePost) {
        Language language = mapper.map(languagePost ,Language.class);
        if (languagePost.getId()!= null){
            throw new RuntimeException();
        }
        languageService.save(language);
    }

    //edit:
    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public void edit(@RequestBody LanguagePost languagePost) {
        Language language = mapper.map(languagePost ,Language.class);
        if (languagePost.getId()== null){
            throw new RuntimeException();
        }
        languageService.edit(language);
    }

    //load:
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public LanguageLoad load(@PathVariable Integer id) {
        return convert(languageService.load(id));
    }

    //delete:
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        languageService.delete(id);
    }

    //get all
    @RequestMapping(value = "/getAllLanguage", method = RequestMethod.GET)
    public List<LanguageLoad> getAll() {
        List<Language> listLanguages = new ArrayList<Language>();
        listLanguages = languageService.getAll();
        List<LanguageLoad> list =  new ArrayList<LanguageLoad>();
        for(Language languageFor : listLanguages)
        {
            list.add(convert(languageFor));
        }
        return list;
    }

    //search:
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Pagination<Language> search (@RequestBody LanguageView languageView){
        Language language =  mapper.map(languageView ,Language.class);
        Page<Language> temps = languageService.findAll(languageView.getPage(), languageView.getSize() , language);
        List<Language> listLanguages = temps.getContent();
        List<LanguageLoad> list =  new ArrayList<LanguageLoad>();
        for(Language languageFor : listLanguages)
        {
            list.add(convert(languageFor));
        }
        return new Pagination(temps.getTotalPages(),temps.getTotalElements(),temps.getSize(),temps.getNumber(),list);
    }

    //convert to loadView
    private LanguageLoad convert(Language language)
    {
        LanguageLoad retuenValue =   mapper.map(language ,LanguageLoad.class);
        return retuenValue;
    }

}
