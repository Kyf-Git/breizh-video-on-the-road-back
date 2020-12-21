package fr.franck.backtest.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.franck.backtest.model.Village;
import fr.franck.backtest.service.VillageService;

@RestController
@RequestMapping("/backtest")
public class VillageController {
	
	@Autowired
	VillageService service;
	
	@CrossOrigin
	@GetMapping("/villages/welcome")
	ResponseEntity<Village> getVillageSauzon() {
		Village welcome = new Village();
		welcome.setName("Sauzon");
		welcome.setPostCode("56360");
		return ResponseEntity.ok().body(welcome);
	}
	/**
	 * Liste des villages
	 * @param search : critère de recherche
	 * @return liste des villages
	 */
	@CrossOrigin
	@GetMapping("/villages")
	public ResponseEntity<List<Village>> getAllVillage(@RequestParam(value="search", defaultValue="") String search) {
		List<Village> listVillage;
		try {
			listVillage = service.findAll(search);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(listVillage);
	}

	/**
	 * recherche d'un village par son id
	 * @param id
	 * @return
	 */
	@CrossOrigin
	@GetMapping("/villages/{id}")
	ResponseEntity<Village> getVillageById(@PathVariable(value="id") long id) {
		Optional<Village> village = service.findById(id);
		if (village.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(village.get());
	}
	
	/**
	 * creation d'un village
	 * @param village
	 * @return
	 */
	@CrossOrigin
	@PostMapping("/villages")
	ResponseEntity<Village> addVillage(@Valid @RequestBody Village village){
		return ResponseEntity.ok().body(service.insert(village));
	}
	
	@CrossOrigin
	@PutMapping("/villages/{id}")
	ResponseEntity<Village> updateVillage(@PathVariable(value="id") long id, @Valid @RequestBody Village village){
		Village updatedVillage = service.update(id, village);
		if(updatedVillage == null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok().body(updatedVillage);
	}

	@CrossOrigin
	@DeleteMapping("/villages/{id}")
	ResponseEntity<Village> deleteVillage(@PathVariable(value="id") long id){
		Optional<Village> village = service.findById(id);
		if(village.isEmpty())
			return ResponseEntity.notFound().build();
		
		service.delete(village.get().getId());
		return ResponseEntity.accepted().build();
	}


}
