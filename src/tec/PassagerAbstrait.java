package tec;

import tec.EtatPassager.Etat;

/**
 * Passager, contructeur avec le nom et la destination (numéro d'arret)
 * 
 */

public abstract class PassagerAbstrait implements Passager, Usager{
	private EtatPassager etat;
	private String nom;
	private int destination;
	
	protected int getDestination() {
		return destination;
	}
	public PassagerAbstrait(String string, int i) {
		etat = EtatPassager.creerEtatPassager(Etat.dehors);
		this.nom = string;
		this.destination = i;
	}
	public PassagerAbstrait(int destination) {
		this(PassagerAbstrait.class.toString()+destination, destination);
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
	public abstract void nouvelArret(Bus bus, int numeroArret);

	@Override
	public abstract void monterDans(Transport t) throws UsagerInvalideException;

	@Override
	public String toString() {
		return nom+" "+etat.toString();
	}
}
