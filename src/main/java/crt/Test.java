package crt;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import model.Impiegato;

public class Test {

    public static void main(String[] args) {
       
        RestTemplate restTemplate = new RestTemplate();
        
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        
        String URL = "http://localhost:8080/GestionaleMaven-0.0.1-SNAPSHOT/impiegati/cognome/Boccia";
        Impiegato[] response1 = restTemplate.getForObject(URL, Impiegato[].class);
       
        System.out.println("È STATA TROVATA " + response1.length +  " " + "CORRISPONDENZA");
        for(Impiegato imp : response1) {
        	System.out.print("IL NOME È " + imp.getNome() + " ");
        	System.out.print("IL COGNOME È " + imp.getCognome());
        	System.out.println();
        }
        
        
        String URL2 = "http://localhost:8080/GestionaleMaven-0.0.1-SNAPSHOT/impiegati/codicefiscale/BCCDNL";
        Impiegato imp = restTemplate.getForEntity(URL2, Impiegato.class).getBody();
        System.out.println("Imp con entity : " + imp);
        
    }
}
