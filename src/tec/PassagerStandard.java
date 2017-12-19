package tec;

import tec.EtatPassager.Etat;

/**
 * Passager, contructeur avec le nom et la destination (numéro d'arret)
 * 
 */

public class PassagerStandard implements Passager, Usager{
	private EtatPassager etat;
	private String nom;
	private int destination;
	
	public PassagerStandard(String string, int i) {
		etat = EtatPassager.creerEtatPassager(Etat.dehors);
		this.nom = string;
		this.destination = i;
	}
	public PassagerStandard(int destination) {
		this(PassagerStandard.class.toString()+destination, destination);
	}
	@Override 
	public String nom() {
		return nom;
	}

	@Override
	public boolean estDehors() {
		if (etat.estExterieur())
			return true;
		return false;
	}

	@Override
	public boolean estAssis() {
		if(etat.estAssis())
			return true;
		return false;
	}

	@Override
	public boolean estDebout() {
		if(etat.estDebout())
			return true;
		return false;
	}

	@Override
	public void accepterSortie() {
		etat.setMonEtat(Etat.dehors);
	}

	@Override
	public void accepterPlaceAssise() {
		etat.setMonEtat(Etat.assis);
		
	}

	@Override
	public void accepterPlaceDebout() {
		etat.setMonEtat(Etat.debout);
		
	}

	@Override
	public void nouvelArret(Bus bus, int numeroArret) {
		if(numeroArret==this.destination)
			bus.demanderSortie(this);	
		if(this.estAssis())
			bus.demanderPlaceDebout(this);
	}

	@Override
	public void monterDans(Transport t) throws UsagerInvalideException {
		Bus b = (Bus)t;
		b.demanderPlaceAssise(this);
		if(this.estDehors())
			b.demanderPlaceDebout(this);
	}

	@Override
	public String toString() {
		return nom+" "+etat.toString();
	}
}
