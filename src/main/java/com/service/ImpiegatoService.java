package com.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import model.Impiegato;

@Service
@Component
public interface ImpiegatoService {
	
    void insertImpiegato(Impiegato impiegato);
	
	void updateImpiegato(Impiegato impiegato);
	
	void deleteImpiegato(int matricola);
	
	List<Impiegato> findImpByCognome(String cognome);
	
	Impiegato findImpiegatoBycodicefiscale(String codicefiscale);

}

