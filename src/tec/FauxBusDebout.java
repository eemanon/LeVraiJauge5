package tec;

/**
 * Cette classe est un substitut de autobus pour tester la classe autobus.
 * son utilite se justifie par le fait qu'elle enlève les erreurs liées au code de passager
 * il est composé de places debout dans ce cas
 */

class FauxBusDebout implements Transport, Bus{
  String message = "???";

  /** 
   * ne contenant que des places debout, il renvoie faux.
   */
  public boolean aPlaceAssise() {
    return false;
  }
  /** 
   * ne contenant que des places debout, il renvoie vrai.
   */
  public boolean aPlaceDebout() {
    return true;
  }

  public  void demanderPlaceAssise(Passager p) {
    message = ":demanderPlaceAssise:";
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
  }

  public void demanderSortie(Passager p) {
    message = ":demanderSortie:";    
    p.accepterSortie();
  }

  public void allerArretSuivant() { //throws UsagerInvalideException {
  }
}
