package com.mz.data.service.impl;

import com.mz.data.dao.ActorRepository;
import com.mz.data.model.Actor;
import com.mz.data.service.GenericService;
import com.mz.data.service.interfaces.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ActorService extends GenericService <Actor , Integer> implements IActorService {

    @Autowired
    private ActorRepository actorRepository;

    @Override
    protected JpaRepository<Actor, Integer> jpaRepository() {
        return actorRepository;
    }

    @Override
    public void save(Actor entity) {
        entity.setlUpdate(new Date());
        super.save(entity);
    }

    @Override
    public void edit(Actor entity) {
        entity.setlUpdate(new Date());
        super.save(entity);
    }

    @Override
    public List<Actor> listActors() {
        return actorRepository.listActors();
    }
}
