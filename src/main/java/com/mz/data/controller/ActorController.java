package com.mz.data.controller;


import com.mz.data.loadView.ActorLoad;
import com.mz.data.model.Actor;
import com.mz.data.model.Pagination;
import com.mz.data.postView.ActorPost;
import com.mz.data.service.interfaces.IActorService;
import com.mz.data.view.ActorView;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorController {

    @Autowired
    private IActorService actorService;

    @Autowired
    private Mapper mapper;

    //save:
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody ActorPost actorPost) {
        Actor actor = mapper.map(actorPost ,Actor.class);
        if (actorPost.getId()!= null){
            throw new RuntimeException();
        }
        actorService.save(actor);
    }

    //edit:
    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public void edit(@RequestBody ActorPost actorPost) {
        Actor actor = mapper.map(actorPost ,Actor.class);
        if (actorPost.getId()== null){
            throw new RuntimeException();
        }
        actorService.edit(actor);
    }

    //load:
    @RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
    public ActorLoad load(@PathVariable Integer id) {
        return convert(actorService.load(id));
    }

    //delete:
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        actorService.delete(id);
    }

    //get all
    @RequestMapping(value = "/getAllActor", method = RequestMethod.GET)
    public List<ActorLoad> getAll() {
        List<Actor> listActors = new ArrayList<Actor>();
        listActors = actorService.getAll();
        List<ActorLoad> list =  new ArrayList<ActorLoad>();
        for(Actor actorFor : listActors)
        {
            list.add(convert(actorFor));
        }
        return list;
    }

    //search:
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Pagination<Actor> search (@RequestBody ActorView actorView){
        Actor actor =  mapper.map(actorView ,Actor.class);
        Page<Actor> temps = actorService.findAll(actorView.getPage(), actorView.getSize() , actor);
        List<Actor> listActors = temps.getContent();
        List<ActorLoad> list =  new ArrayList<ActorLoad>();
        for(Actor actorFor : listActors)
        {
            list.add(convert(actorFor));
        }
        return new Pagination(temps.getTotalPages(),temps.getTotalElements(),temps.getSize(),temps.getNumber(),list);
    }

    //convert to loadView
    private ActorLoad convert(Actor actor)
    {
        ActorLoad retuenValue =   mapper.map(actor ,ActorLoad.class);
        return retuenValue;
    }

}
