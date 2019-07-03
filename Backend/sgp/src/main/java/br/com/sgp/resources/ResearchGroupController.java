package br.com.sgp.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgp.entities.ResearchGroup;
import br.com.sgp.repositories.ResearchGroupRepository;
import br.com.sgp.resources.responses.JsonSimpleResponse;

@RestController
@RequestMapping(value="/researchgroup")
@CrossOrigin(origins="*")
public class ResearchGroupController {
	
	@Autowired
	private ResearchGroupRepository researchGroupRepository; 
	
	@PostMapping(value="/addResearchGroup")
	public ResearchGroup addResearchGroup(@RequestBody ResearchGroup researchGroup) {
		return researchGroupRepository.save(researchGroup);
	}
	
	@PutMapping(value="/alterResearchGroup")
	public ResearchGroup alterResearchGroup(@RequestBody ResearchGroup researchGroup) {
		return researchGroupRepository.save(researchGroup);
	}
	
	@DeleteMapping(value="/remove/{id}")
	public void removeResearchGroup(@PathVariable("id") Integer id) {
		researchGroupRepository.deleteById(id);
	}
	
	@GetMapping(value="/search/{id}")
	public Optional<ResearchGroup> searchResearchGroup(@PathVariable("id") Integer id) {
		return researchGroupRepository.findById(id);
	}
	
	@GetMapping("/researchGroups")
	public JsonSimpleResponse searchAllResearchGroups() {
		List<ResearchGroup> rGroups = researchGroupRepository.findAll();
		JsonSimpleResponse response = new JsonSimpleResponse()
				.addPair("status", new Integer(HttpStatus.OK.value()))
				.addPair("data", rGroups);
		return response;
	}
}
