package tec;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * jeu de test pour la classe passager standard.
 * il fait appelle à des faux bus pour éviter que les erreurs de bus n'interfèrent dans les tests.
 */
import tec.EtatPassager.Etat;

public class PassagerStandardTest implements Transport{
	
	@Before
	public void initialiser() throws Exception{
	}
	
	@After
	public void nettoyer() throws Exception{		
	}
	@Test
	public void instancation() {
		Passager p = new PassagerStandard("Nathalie", 0);
		assert(p.estDehors());
	}
	@Test
	public void accepterPlaceAssise() {
		Passager p = new PassagerStandard("Jean-Marc", 0);
		p.accepterPlaceAssise();
		assert(p.estAssis());
	}
	@Test
	public void accepterPlaceDebout() {
		Passager p1 = new PassagerStandard("Pierre-Jean", 0);
		p1.accepterPlaceDebout();
		assert(p1.estDebout());
	}
	@Test
	public void accepterSortie() {
		Passager p1 = new PassagerStandard("Fabris", 0);
		p1.accepterSortie();
		assert(p1.estDehors());
	}
	@Test
	public void monterDans() {
		PassagerStandard p1 = new PassagerStandard("Bernard", 0);
		FauxBusVide ghostbus = new FauxBusVide();
		try {
			p1.monterDans(ghostbus);
			assert(!p1.estDehors());
		} catch (UsagerInvalideException e) {
			System.out.println("Oh la honte! Le conducteur laisse pas monter Bernard malgré le fait que le bus est vide!");
		}
		PassagerStandard ghostbuster = new PassagerStandard("Benoit", 0);
		FauxBusPlein ghostbus42 = new FauxBusPlein();
		try {
			ghostbuster.monterDans(ghostbus42);
			assert(!ghostbuster.estDehors());
		} catch (UsagerInvalideException e) {
			System.out.println("OMG il ne peut pas monter dans le bus plein!!!!");
		}		
		PassagerStandard petitpotter = new PassagerStandard("Harry", 0);
		FauxBusDebout busdePoudlard = new FauxBusDebout();
		try {
			petitpotter.monterDans(busdePoudlard);
			assert(!petitpotter.estDehors());
		} catch (UsagerInvalideException e) {
			System.out.println("tout le monde est debout et refuse de laisser Harry monter et voyager a Poudlard.");
		}		
		PassagerStandard madameBilleEnTete  = new PassagerStandard("Valerie", 0);
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
		Passager p1 = new PassagerStandard("Cathérine", 0);
		p1.nouvelArret(new FauxBusVide(), 0);
		assert(p1.estDehors());
		Passager p2 = new PassagerStandard("Emmanuel", 0);
		p2.nouvelArret(new FauxBusAssis(), 0);
		assert(p2.estDehors());
		Passager p3 = new PassagerStandard("Brahim", 0);
		p3.nouvelArret(new FauxBusDebout(), 0);
		assert(p3.estDehors());
		Passager p4 = new PassagerStandard("Thierry", 0);
		p4.nouvelArret(new FauxBusPlein(), 0);
		assert(p4.estDehors());		
	}

	@Override
	public void allerArretSuivant() throws UsagerInvalideException {
		// TODO Auto-generated method stub
		
	}
	
}
