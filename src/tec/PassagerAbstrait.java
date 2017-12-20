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
	public final String nom() {
		return nom;
	}

	@Override
	public final boolean estDehors() {
		if (etat.estExterieur())
			return true;
		return false;
	}

	@Override
	public final boolean estAssis() {
		if(etat.estAssis())
			return true;
		return false;
	}

	@Override
	public final boolean estDebout() {
		if(etat.estDebout())
			return true;
		return false;
	}

	@Override
	public final void accepterSortie() {
		etat.setMonEtat(Etat.dehors);
	}

	@Override
	public final void accepterPlaceAssise() {
		etat.setMonEtat(Etat.assis);
		
	}

	@Override
	public final void accepterPlaceDebout() {
		etat.setMonEtat(Etat.debout);
		
	}
	protected abstract void choixPlaceMontee(Bus b);
	
	protected abstract void choixChangerPlace(Bus b, int arret);

	@Override
	public void nouvelArret(Bus bus, int numeroArret) {
		if(numeroArret==this.getDestination())
			bus.demanderSortie(this);	
		choixChangerPlace(bus, numeroArret);
	};

	@Override
	public void monterDans(Transport t) throws UsagerInvalideException{
		choixPlaceMontee((Bus)t);
	};

	@Override
	public String toString() {
		return nom+" "+etat.toString();
	}
}
