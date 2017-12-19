package tec;

import tec.EtatPassager.Etat;

/**
 * Passager, contructeur avec le nom et la destination (numéro d'arret)
 * 
 */

public class PassagerStandard extends PassagerAbstrait implements Passager, Usager{	
	public PassagerStandard(String string, int i) {
		super(string, i);
	}
	public PassagerStandard(int destination) {
		this(PassagerStandard.class.toString()+destination, destination);
	}

	@Override
	public void nouvelArret(Bus bus, int numeroArret) {
		if(numeroArret==this.getDestination())
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
}
