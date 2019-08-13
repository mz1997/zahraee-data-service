package com.iansar.yara.repository.current;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iansar.yara.entity.current.CostCash;

@Repository
public interface CostCashRepository extends JpaRepository<CostCash, Long> {

	@Query("select e from CostCash e where e.vam.id = :payVamId")
	CostCash findByVamId(@Param("payVamId") Long payVamId);

	@Query(value = "select e from CostCash e where e.groupId = :groupId and e.person.id is not null and yearMember = :year")
	List<CostCash> findByGroupIdForYearMemer(@Param("groupId") Integer groupId, @Param("year") Integer year);

	@Query(value = "select distinct e.date from CostCash e where e.groupId=:groupId and e.person.id is not null and e.yearMember is not null")
	List<String> getAllDateMember(@Param("groupId") Integer groupId);

}
