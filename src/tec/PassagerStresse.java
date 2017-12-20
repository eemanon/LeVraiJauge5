package tec;


import tec.EtatPassager.Etat;


public class PassagerStresse extends PassagerAbstrait implements Passager, Usager{	
	public PassagerStresse(String string, int i) {
		super(string, i);
	}
	public PassagerStresse(int destination) {
		super(PassagerStandard.class.toString()+destination, destination);
	}

	@Override
	public void nouvelArret(Bus bus, int numeroArret) {
		super.nouvelArret(bus, numeroArret);
		if(numeroArret==this.getDestination()-3)
			bus.demanderPlaceDebout(this);
	}

	@Override
	public void monterDans(Transport t) throws UsagerInvalideException {
		Bus b = (Bus)t;
		b.demanderPlaceAssise(this);
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
