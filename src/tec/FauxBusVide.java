package tec;

/**
 * Cette classe est un substitut de autobus pour tester la classe autobus.
 * son utilite se justifie par le fait qu'elle enlève les erreurs liées au code de passager
 * il est vide dans ce cas
 */
class FauxBusVide implements Transport, Bus{
  String message = "???";
 
 /** 
  * ne contenant que des places assises, il renvoie vrai.
  */
  public boolean aPlaceAssise() {
    return true;
  }
  /** 
   * ne contenant que des places assises, il renvoie faux.
   */
  public boolean aPlaceDebout() {
    return true;
  }

  public void demanderPlaceAssise(Passager p) {
    message = ":demanderPlaceAssise:";
    p.accepterPlaceAssise();
  }

  public void demanderPlaceDebout(Passager p) {
    message = ":demanderPlaceDebout:";
    p.accepterPlaceDebout();
  }

  public void demanderChangerEnDebout(Passager p) {
    message = ":demanderChangerEnDebout:";
    p.accepterPlaceDebout();
  }
  
  public void demanderChangerEnAssis(Passager p) {
    message = ":demanderChangerEnAssis:";
    p.accepterPlaceAssise();
  }

  public void demanderSortie(Passager p) {
    message = ":demanderSortie:";    
    p.accepterSortie();
  }

  public void allerArretSuivant() { //throws UsagerInvalideException {
  }
}
