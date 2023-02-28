package com.service;

import java.util.List;

import com.repositories.ImpiegatoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Impiegato;

@Repository
@Transactional
@Service
@Component
public class ImpiegatoServiceImpl implements ImpiegatoService {
	
	@Autowired
	private ImpiegatoRepository impiegatoRepository;

	@Transactional
	public void insertImpiegato(Impiegato impiegato) {
		impiegatoRepository.save(impiegato);
	}

	@Transactional
	public void updateImpiegato(Impiegato impiegato) {
		impiegatoRepository.save(impiegato);
	}

	@Transactional
	public void deleteImpiegato(int matricola) {
         impiegatoRepository.deleteById(matricola);
	}


	@Transactional
	public List<Impiegato> findImpByCognome(String cognome) {
		   return impiegatoRepository.findByCognome(cognome);
	}

	@Transactional
	public Impiegato findImpiegatoBycodicefiscale(String codicefiscale) {
		   return impiegatoRepository.findImpBycodicefiscale(codicefiscale);
	}
}
