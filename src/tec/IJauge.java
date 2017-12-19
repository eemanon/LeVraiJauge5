package tec;

import tec.Placeholder;

/**
 * interface pour lier les classes de jauge entre elles
 */

interface IJauge {
	public boolean estRouge();
	public boolean estVert();
	public boolean estBleu();
	public void incrementer();
	public void decrementer();
	public Placeholder getMin();
	public Placeholder getMax();
	public Placeholder getVal();
	public void setVal(Placeholder p);
	public void validParams() throws IllegalArgumentException;
}
