package tec;

import static org.junit.Assert.*;

import org.junit.Test;

public class PassagerLunatiqueTest extends PassagerAbstraitTest{
		
	@Override
	protected PassagerAbstrait creerPassager(String nom, int destination) {
		PassagerLunatique p = new PassagerLunatique(nom, destination);
		return p;
	}
}