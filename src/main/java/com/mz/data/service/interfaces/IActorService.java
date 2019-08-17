package com.mz.data.service.interfaces;

import com.mz.data.model.Actor;

import java.util.List;

public interface IActorService extends IGenericService <Actor, Integer> {

    List<Actor> listActors();
}
