package com.mz.data.controller;


import com.mz.data.model.Actor;
import com.mz.data.model.Pagination;
import com.mz.data.service.interfaces.IActorService;
import com.mz.data.view.ActorView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorController {

    @Autowired
    private IActorService actorService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody Actor actor) {
        actorService.save(actor);
    }

    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public Actor load(@PathVariable Integer id) {
        return actorService.load(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        actorService.delete(id);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public void edit(@RequestBody Actor actor) {
        actorService.edit(actor);
    }

    @RequestMapping(value = "/getAllActor", method = RequestMethod.GET)
    public List<Actor> getAll() {
        return actorService.getAll();
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Pagination<Actor> save(@RequestBody ActorView actorView){
        Actor actor = new Actor();
        actor.setfName(actorView.getfName());
        actor.setlName(actorView.getlName());
        return actorService.findAll(actorView.getPage(), actorView.getSize() , actor);
    }
}
