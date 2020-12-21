package fr.franck.backtest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.franck.backtest.model.Village;

public interface VillageRepository extends JpaRepository<Village, Long>{
	public List<Village> findByNameContaining(String name);
}