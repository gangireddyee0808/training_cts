package com.cts.skills.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.skills.bean.Skills;

public interface SkillRepository extends JpaRepository<Skills, Long> {
	
	Optional<Skills> findByName(String name);
	
	List<Skills> findByDescr(String descr);
	List<Skills> findByLevel(String Level);

}
