package crt;

import org.springframework.http.MediaType;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.service.ImpiegatoService;

import model.Impiegato;

@RestController
@RequestMapping("/impiegati")
public class ImpiegatoRestController {

    @Autowired
    private ImpiegatoService impiegatoService;
    
    @GetMapping(value = "/inserisci/{impiegato}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createImpiegato(@RequestBody Impiegato impiegato) {
        impiegatoService.insertImpiegato(impiegato);
        return new ResponseEntity<>("Impiegato creato", HttpStatus.CREATED);
    }
    
    @GetMapping(value = "/aggiorna/{impiegato}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateImpiegato(@RequestBody Impiegato impiegato) {
        impiegatoService.updateImpiegato(impiegato);
        return new ResponseEntity<>("Impiegato creato", HttpStatus.CREATED);
    }


    @DeleteMapping(value = "/eliminaImpiegato/{matricola}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteImpiegato(@PathVariable int matricola) {
        
            impiegatoService.deleteImpiegato(matricola);
            return new ResponseEntity<>("Impiegato eliminato", HttpStatus.CREATED);
    }

    @GetMapping(value = "/cognome/{cognome}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Impiegato> findImpByCognome(@PathVariable String cognome) {
        return impiegatoService.findImpByCognome(cognome);
    }

    
    @GetMapping(value = "/codicefiscale/{codicefiscale}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Impiegato getImpiegatoByCodiceFiscale(@PathVariable String codicefiscale) {
        return impiegatoService.findImpiegatoBycodicefiscale(codicefiscale);
    }
    }


