package tec;

import static org.junit.Assert.*;

import org.junit.Test;

public class PassagerStresseTest extends PassagerAbstraitTest {

	@Override
	protected PassagerAbstrait creerPassager(String nom, int destination) {
		PassagerStresse p = new PassagerStresse(nom, destination);
		return p;
	}

}
