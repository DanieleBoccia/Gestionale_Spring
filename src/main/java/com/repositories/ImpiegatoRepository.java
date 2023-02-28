package com.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Impiegato;

@Repository("impiegatoRepository")
public interface ImpiegatoRepository extends JpaRepository<Impiegato, Integer> {
	
	List<Impiegato> findByCognome(String cognome);
	
	Impiegato findImpBycodicefiscale(String codicefiscale);

}
