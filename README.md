# LeVraiJauge V
last station of Via Dolorosa Jesus had to take before being nailed to the cross ;)

Préoccupations:
1. éviter la duplication de code ;
2. ajouter des caract`eres sans modifier le code existant dans notre paquetage

## 1 Pourquoi l'heritage
Scenario 1: IF ELSE dans la même classe pour réaliser les passagers lunatiques et passagerStressé
Quelle conclusion par rapport à nos deux préoccupations ?
- Par rapport à notre prémière préoccupation nous trouvons que nous ne sommes pas très 
préoccupé: il n'y a pas de code dupliqué...
- par contre, on est obligé de remanier du code existant à chaque fois qu'un nouveau attribut
doit être modifié

Scenario 2: Nouvelle classe pour chaqu'un de ces spécimen.
Quelle conclusion par rapport à nos deux préoccupations ?
- La notion de copier/coller ne colle pas vraiment avec notre premiere préoccupation
- Par contre on ne va certainement plus toucher au PassagerStandard après.

Scenario 3: L'héritage est un concept humain ancien. On va créer des classes filles de PassagerStandard.
Quelle conclusion par rapport à nos deux préoccupations ?
- On va laisser faire le compilateur le boulot sale de copier/coller (car un héritage se réalise par rien
d'autre que de copier-coller au niveau du compilateur (Cours Combemale). Mais, on pourra faire semblant de 
ne pas copier du tout. Très bien!
- Et en plus on ne va rien changer dans le code existant de PassagerStandard.

Quel code dupliqué?
- Le code pour tester les passagers de classe fille

