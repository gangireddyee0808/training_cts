package com.cts.skills.resource;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cts.skills.bean.Skills;
import com.cts.skills.exception.SkillNotFoundException;
import com.cts.skills.repository.SkillRepository;

@RestController
@RequestMapping("/api")
public class SkillResource {

	@Autowired
	private SkillRepository SkillsRepository;
	
	@GetMapping("/Skills")
	public List<Skills> getAllSkillss() {
		return SkillsRepository.findAll();
		
	}
	
	@GetMapping("/Skills/{id}")
	public Optional<Skills> getSkillsById(@PathVariable Long id) {
		Optional<Skills> Skills = SkillsRepository.findById(id);
		if(!Skills.isPresent())
        {
            throw new SkillNotFoundException("The Skills with id - "+id+ " does not exists");
        }
			return Skills; 
				
	}
	
	@GetMapping("/Skills/description/{description}")
	public List<Skills> getSkillsByDescription(@PathVariable String description) {
		List<Skills> Skills = SkillsRepository.findByDescr(description);
		if(Skills.size()==0)
        {
            throw new SkillNotFoundException("The Skills with id - "+description+ " does not exists");
        }
			return Skills; 
				
	}
	
	@GetMapping("/Skills/level/{level}")
	public List<Skills> getSkillsByLevel(@PathVariable String level) {
		List<Skills> Skills = SkillsRepository.findByLevel(level);
		if(Skills.size()==0)
        {
            throw new SkillNotFoundException("The Skills with id - "+level+ " does not exists");
        }
			return Skills; 
				
	}
	
	

	
	@GetMapping("/Skills/name/{Skillsname}")
	public Optional<Skills> getSkillsByName(@PathVariable String Skillsname) {
			return  SkillsRepository.findByName(Skillsname);
				
	}
	
	@DeleteMapping("/Skills/{id}")
	public void deleteById(@PathVariable Long id) {
		Optional<Skills> Skills1 = SkillsRepository.findById(id);
		if(!Skills1.isPresent())
        {
            throw new SkillNotFoundException("The Skills with id - "+id+ " does not exists");
        }
		SkillsRepository.deleteById(id);
	}
	
	
	@PostMapping("/Skills")
	public Skills createSkills(@Valid @RequestBody Skills Skills) {
		Skills savedSkills=SkillsRepository.save(Skills);
		return savedSkills;
		
	}
	
	@PutMapping("/Skills/{id}")
	public ResponseEntity<Object> updateSkills(@Valid @RequestBody Skills Skills, @PathVariable Long id) {
		Optional<Skills> Skills1 = SkillsRepository.findById(id);
		if(!Skills1.isPresent())
        {
            throw new SkillNotFoundException("The Skills with id - "+id+ " does not exists");
        }
		SkillsRepository.save(Skills);
		return ResponseEntity.noContent().build();
	}
}
