//creazione pacchetto dao
package dao;

import java.util.ArrayList;
//Eclipse importa automaticamente java.util.ArrayList in seguito alla creazione della lista 'listaImpiegato'
import java.util.List;

//importo la classe Impiegato in ImpiegatoDao per farle interagire
import model.Impiegato;

//creazione classe ImpiegatoDao
public class ImpiegatoDao {
	
	//creazione della lista listaImpiegato in cui storare le varie istanze di Impiegato
	private ArrayList<Impiegato> listaImpiegato = new ArrayList<Impiegato>();
	
	//Metodo pubblico che deve ritornare un impiegato nella lista per cui di tipo classe Impiegato
	//prende in ingresso la variabile privata codicefiscale precedentemente creata in Impiegato
	
	//Ho creato in un ciclo for each una variabile imp che scorre gli elementi storati in listaImpiegato
	//e confronta il codice fiscale immesso nel metodo in ingresso(variabile privata codice fiscale 
	//con il codice fiscale gi� storato nella lista (metodo getcodicefiscale).
	//qualora dovesse trovare una corrispondenza ritorna il nome di quell'impiegato, altrimenti null
	
	//.equals come uguaglianza tra stringhe
	
	//cose che ho dovuto ricercare: la sintassi dell'uguaglianza nella condizione If
	//e informazione su metodoget
	public Impiegato ricercaPerCodiceFiscale(String codicefiscale){
		for(Impiegato imp : listaImpiegato){
			if(imp.getCodicefiscale().equals(codicefiscale)){
				return imp;
			}
		}
		return null;
	}
	
	//il metodo per aggiungere un nuovo Impiegato con tutti suoi attributi alla listaImpiegato
	//utilizzando il .add. Quando andremo a richiamare il metodo, inseriremo tutti gli attributi in una
	//nuova istanza della classe impiegato (nome cognome matricola e codicefiscale)
	//il metodo automaticamente travaser� queste informazione all'interno di listaImpiegato
	//cose che ho dovuto ricercare: Prendi in ingresso una istanza i di impiegato
	//non conoscendo la sintassi avrei scritto Impiegato i = new Impiegato();
	public void inserisci(Impiegato i){
		
		    System.out.println("Inserimento impiegato: " + i.toString());
		    listaImpiegato.add(i);
	}
	
	//metodo pubblico che deve ritornare vero o falso, per cui ho impostato come tipo il booleano
	//come prima, istanza di Impiegato in ingresso
	//variaile imp che scorre la lista e confronta il codice fiscale di un nuova istanza di impiegato con i codici fiscali presenti in lista
	// esempio: Impiegato i5 = new Impiegato("Daniele", "Boccia", "BCCDNL", 123);
	// SE BCCDNL esiste gi� in listaImpiegato, allora aggiorner� tutti gli altri attributi con i nuovi
	
	//considerazioni: � stato indubbiamente il metodo pi� complicato da capire, sia come lettura delle
	//istruzioni, sia come sintassi. Ho richiesto aiuto di chatGPT per la sintassi di aggiornamento degli attributi
	public boolean aggiorna(Impiegato i){
		for(Impiegato imp : listaImpiegato){
			if(imp.getCodicefiscale().equals(i.getCodicefiscale())){
				imp.setNome(i.getNome());
	            imp.setCognome(i.getCognome());
	            imp.setMatricola(i.getMatricola());
				return true;
				}
		}
		return false;
	}
    
	//metodo pubblico che ritorna vero o falso, per cui metodo booleano
	//prende in ingresso la variabile Impiegato codicefiscale
	//la variabile imp scorre la lista, confronta il codice fiscale in ingresso, con quelli gi� in lista
	//quando ne incontra uno uguale rimuove quel determinato impiegato dalla lista
	//esempio: Impiegato i2 = new Impiegato("BCCDNL");
	//         Impiegato rimosso se in lista c'� un altro BCCDNL
	public boolean elimina(String codicefiscale){
		for(Impiegato imp : listaImpiegato){
			if(imp.getCodicefiscale().equals(codicefiscale)){
				listaImpiegato.remove(imp);
				return true;
			}
		}
		return false;
	}
	
	public List<Impiegato> ricercaPerCognome(String cognome){
		List<Impiegato> Impiegati = new ArrayList<Impiegato>();
		for(Impiegato imp : listaImpiegato){
			if(imp.getCognome().equals(cognome)){
				listaImpiegato.add(imp);
				return Impiegati;
			}
		}
		return null;
	}
	
}
