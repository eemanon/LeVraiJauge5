package tec;

/**
 * R�alisation d'une Jauge avec des entiers naturels.
 * <p>
 * Un objet Jauge d�finit un niveau et un intervalle ouvert ]vigieMin, vigieMax[.
 * Le niveau d'une jauge n'est pas limit� aux valeurs dans l'intervalle.
 * <p>
 * L'�tat d'une jauge correspond � la position de son niveau par rapport �
 * l'intervalle ]vigieMin, vigieMax[.
 * Une jauge d�finit trois etats :
 * <ul>
 * <li>vert niveau dans l'intervalle,
 * <li>rouge niveau sup�rieur � l'intervalle,
 * <li>bleu niveau inf�rieur � l'intervalle.
 * </ul>
 *
 * @author georgy
 * @since 2006-2007
 */
class JaugeNaturel implements IJauge{
  private long valeur;
  private final long min;
  private final long max;

  /**
   * Construit une instance en pr�cisant la valeur de d�part de la Jauge
   * et l'intervalle de vigie.
   *
   * @param vigieMin valeur minimale de l'intervalle de vigie.
   * @param vigieMax valeur maximale de l'intervalle de vigie.
   * @param depart   valeur initiale de la jauge.
 */  
  public JaugeNaturel(long vigieMin, long vigieMax, long depart){	 
    setValeur(depart);
    min = vigieMin;
    max = vigieMax;
	validParams();
    /* Le constructeur d'une classe permet d'initialiser l'etat de l'instance creee.
     * Son nom correspond toujours au nom de la classe. Il n'y a pas de type de retour.
     */
  }


  /**
   * L'�tat de la jauge est-il rouge ?
   *
   * @return vrai si niveau >=  vigieMax.
   *
   */
  public boolean estRouge() {
    return getVal().getTlong() >= getMax().getTlong();
  }

  /**
   * L'�tat de la jauge est-il vert ?
   *
   * @return vrai si niveau appartient � ]vigieMin, vigieMax[.
   *
   */
  public boolean estVert() {
    //return !(estBleu() && estRouge());
    return getVal().getTlong() > getMin().getTlong() && getVal().getTlong() < getMax().getTlong();
  }

  /**
   * L'�tat de la jauge est-il bleu ?
   *
   * @return vrai si niveau <= vigieMin.
   */
  public boolean estBleu() {
    return getVal().getTlong() <= getMin().getTlong();
  }

  /**
   * Incr�mente le niveau d'une unit�.
   * L'�tat peut devenir sup�rieur � vigieMax.
   */
  public void incrementer() {
    setValeur(getValeur() + 1);
  }

  /**
   * D�cr�mente le niveau d'une unit�.
   * L'�tat peut devenir inf�rieur � la vigieMin.
   */
  public void decrementer() {
	    setValeur(getValeur() - 1);
  }


  /**
   * Cette m�thode est h�rit�e de la classe {@link java.lang.Object}.
   * Tr�s utile pour le d�bogage, elle permet de fournir une
   * cha�ne de caract�res correspondant a l'�tat d'un objet.
   * <p> Un code par d�faut est d�finit dans
   * {@link java.lang.Object#toString() la classe Object}
   * Il faut adapter (red�finir) le code de cette m�thode � chaque classe.
   *
   * Pour les cha�nes de cararct�res, l'op�rateur + correspond a la concat�nation.
   * Les valeurs num�riques sont alors convertit en ascii.
   * Si l'�tat d'une instance de cette classe est min=-456, max=23,
   * valeur=-7, la concat�nation donne la cha�ne "<-7 [-456,23]>".
   */
  @Override
  public String toString() {
    return "<" + getValeur() + " [" + getMin() + "," + getMax() + "]>";
  }


public long getValeur() {
	return valeur;
}


public void setValeur(long valeur) {
	this.valeur = valeur;
}

@Override
public Placeholder getVal() {
	return new Placeholder(0, 0, this.valeur);
}


@Override
public void setVal(Placeholder p) {
	this.valeur = p.getTlong();
	
}


@Override
public Placeholder getMin() {
	return new Placeholder(0, 0, this.min);
}


@Override
public Placeholder getMax() {
	return new Placeholder(0,0, this.max);
}


@Override
public void validParams() throws IllegalArgumentException{
	if(this.min>=this.max || this.valeur>this.max  || this.valeur < this.min)
		throw new IllegalArgumentException("ce n'est pas tr�s naturel");
}

}
