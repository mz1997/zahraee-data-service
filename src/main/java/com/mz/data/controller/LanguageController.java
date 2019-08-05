package com.mz.data.controller;


import com.mz.data.model.Film;
import com.mz.data.model.Language;
import com.mz.data.model.Pagination;
import com.mz.data.service.interfaces.ILanguageService;
import com.mz.data.view.FilmView;
import com.mz.data.view.LanguageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/language")
public class LanguageController {

    @Autowired
    private ILanguageService languageService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody Language language) {
        languageService.save(language);
    }

    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public Language load(@PathVariable Integer id) {
        return languageService.load(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        languageService.delete(id);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public void edit(@RequestBody Language language) {
        languageService.edit(language);
    }

    @RequestMapping(value = "/getAllLanguage", method = RequestMethod.GET)
    public List<Language> getAll() {
        return languageService.getAll();
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Pagination<Language> save(@RequestBody LanguageView languageView){
        Language language = new Language();
        language.setName(languageView.getName());
        return languageService.findAll(languageView.getPage(),languageView.getSize(),language);
    }

}
