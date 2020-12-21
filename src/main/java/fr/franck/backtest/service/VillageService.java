package fr.franck.backtest.service;

import java.util.List;
import java.util.Optional;

import fr.franck.backtest.model.Village;

public interface VillageService {

	Optional<Village> findById(Long id);
	List<Village> findAll(String search);
	Village insert(Village village);
	Village update(Long id, Village village);
	void delete(Long id);
}