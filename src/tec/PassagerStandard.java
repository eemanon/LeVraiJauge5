package tec;

import tec.EtatPassager.Etat;

/**
 * Passager, contructeur avec le nom et la destination (num�ro d'arret)
 * 
 */

public class PassagerStandard extends PassagerAbstrait implements Passager, Usager{	
	public PassagerStandard(String string, int i) {
		super(string, i);
	}
	public PassagerStandard(int destination) {
		super(PassagerStandard.class.toString()+destination, destination);
	}

	@Override
	public void nouvelArret(Bus bus, int numeroArret) {
		super.nouvelArret(bus, numeroArret);
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
	protected void choixPlaceMontee(Bus b) {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void choixChangerPlace(Bus b, int arret) {
		// TODO Auto-generated method stub
		
	}	
}
