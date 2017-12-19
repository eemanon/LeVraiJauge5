package tec;
/**
 * Cette classe est un substitut de autobus pour tester la classe autobus.
 * son utilite se justifie par le fait qu'elle enl�ve les erreurs li�es au code de passager
 * il est plein dans ce cas
 */

class FauxBusPlein implements Transport, Bus{
  String message = "???";

  /** 
   * �tant plein, il renvoie faux.
   */
  public boolean aPlaceAssise() {
    return false;
  }

  /** 
   * �tant plein, il renvoie faux.
   */
  public boolean aPlaceDebout() {
    return false;
  }

  public void demanderPlaceAssise(Passager p) {
    message = ":demanderPlaceAssise:";
  }

  public void demanderPlaceDebout(Passager p) {
    message = ":demanderPlaceDebout:";
  }

  public void demanderChangerEnDebout(Passager p) {
    message = ":demanderChangerEnDebout:";
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
