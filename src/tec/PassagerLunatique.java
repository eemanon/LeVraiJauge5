package tec;

public class PassagerLunatique extends PassagerAbstrait implements Passager, Usager{	
	public PassagerLunatique(String string, int i) {
		super(string, i);
	}
	public PassagerLunatique(int destination) {
		super(PassagerStandard.class.toString()+destination, destination);
	}

	@Override
	public void nouvelArret(Bus bus, int numeroArret) {
		super.nouvelArret(bus, numeroArret);
		if(this.estAssis())
			bus.demanderPlaceDebout(this);
		if(this.estDebout())
			bus.demanderPlaceAssise(this);
	}

	@Override
	public void monterDans(Transport t) throws UsagerInvalideException {
		Bus b = (Bus)t;
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