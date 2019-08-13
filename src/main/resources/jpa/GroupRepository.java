package com.iansar.yara.repository.defination;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iansar.yara.entity.defination.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {

	@Query("select count(id) from Group e where e.cash.id = :cashId")
	Integer getCountByCashId(@Param("cashId") Integer cashId);

}
