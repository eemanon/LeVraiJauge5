package tec;

import static org.junit.Assert.*;

import org.junit.Test;

public abstract class PassagerAbstraitTest {

	
	protected abstract PassagerAbstrait creerPassager(String nom, int destination);
	
	@Test
	public void instancation() {
		Passager p = creerPassager("Nathalie", 0);
		assert(p.estDehors());
	}
	@Test
	public void accepterPlaceAssise() {
		Passager p = creerPassager("Jean-Marc", 0);
		p.accepterPlaceAssise();
		assert(p.estAssis());
	}
	@Test
	public void accepterPlaceDebout() {
		Passager p1 = creerPassager("Pierre-Jean", 0);
		p1.accepterPlaceDebout();
		assert(p1.estDebout());
	}
	@Test
	public void accepterSortie() {
		Passager p1 = creerPassager("Fabris", 0);
		p1.accepterSortie();
		assert(p1.estDehors());
	}
	@Test
	public void monterDans() {
		PassagerAbstrait p1 = creerPassager("Bernard", 0);
		FauxBusVide ghostbus = new FauxBusVide();
		try {
			p1.monterDans(ghostbus);
			assert(!p1.estDehors());
		} catch (UsagerInvalideException e) {
			System.out.println("Oh la honte! Le conducteur laisse pas monter Bernard malgré le fait que le bus est vide!");
		}
		PassagerAbstrait ghostbuster = creerPassager("Benoit", 0);
		FauxBusPlein ghostbus42 = new FauxBusPlein();
		try {
			ghostbuster.monterDans(ghostbus42);
			assert(!ghostbuster.estDehors());
		} catch (UsagerInvalideException e) {
			System.out.println("OMG il ne peut pas monter dans le bus plein!!!!");
		}		
		PassagerAbstrait petitpotter = creerPassager("Harry", 0);
		FauxBusDebout busdePoudlard = new FauxBusDebout();
		try {
			petitpotter.monterDans(busdePoudlard);
			assert(!petitpotter.estDehors());
		} catch (UsagerInvalideException e) {
			System.out.println("tout le monde est debout et refuse de laisser Harry monter et voyager a Poudlard.");
		}		
		PassagerAbstrait madameBilleEnTete  = creerPassager("Valerie", 0);
		FauxBusAssis busmagique = new FauxBusAssis();
		try {
			madameBilleEnTete.monterDans(busmagique);
			assert(!madameBilleEnTete.estDehors());
		} catch (UsagerInvalideException e) {
			System.out.println("Oh non! Les enfants font la greve et empechent Madame Bille en Tete de monter!");
		}
	}
	
	@Test
	public void nouvelArret() {
		Passager p1 = creerPassager("Cathérine", 0);
		p1.nouvelArret(new FauxBusVide(), 0);
		assert(p1.estDehors());
		Passager p2 = creerPassager("Emmanuel", 0);
		p2.nouvelArret(new FauxBusAssis(), 0);
		assert(p2.estDehors());
		Passager p3 = creerPassager("Brahim", 0);
		p3.nouvelArret(new FauxBusDebout(), 0);
		assert(p3.estDehors());
		Passager p4 = creerPassager("Thierry", 0);
		p4.nouvelArret(new FauxBusPlein(), 0);
		assert(p4.estDehors());		
	}
}
