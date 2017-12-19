package tec;
/**
 * Cette classe est un substitut de autobus pour tester la classe autobus.
 * son utilite se justifie par le fait qu'elle enlève les erreurs liées au code de passager
 * il est composé de places assises dans ce cas
 */

class FauxBusAssis implements Transport, Bus{
  String message = "???";

  public boolean aPlaceAssise() {
    return true;
  }

  public boolean aPlaceDebout() {
    return false;
  }

  public void demanderPlaceAssise(Passager p) {
    message = ":demanderPlaceAssise:";
    p.accepterPlaceAssise();
  }

  public void demanderPlaceDebout(Passager p) {
    message = ":demanderPlaceDebout:";
  }

  public void demanderChangerEnDebout(Passager p) {
    message = ":demanderChangerEnDebout:";
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
