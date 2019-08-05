package com.mz.data.dao;

import com.mz.data.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository <Actor , Integer> {
}
