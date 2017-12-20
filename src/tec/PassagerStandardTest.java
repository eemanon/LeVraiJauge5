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

public class PassagerStandardTest extends PassagerAbstraitTest implements Transport {
	
	@Before
	public void initialiser() throws Exception{
	}
	
	@After
	public void nettoyer() throws Exception{		
	}


	@Override
	public void allerArretSuivant() throws UsagerInvalideException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected PassagerAbstrait creerPassager(String nom, int destination) {
		PassagerStandard p = new PassagerStandard(nom, destination);
		return p;
	}
	
}
