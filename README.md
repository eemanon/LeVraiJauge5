# LeVraiJauge V
last station of Via Dolorosa Jesus had to take before being nailed to the cross ;)

Pr�occupations:
1. �viter la duplication de code ;
2. ajouter des caract`eres sans modifier le code existant dans notre paquetage

## 1 Pourquoi l'heritage
Scenario 1: IF ELSE dans la m�me classe pour r�aliser les passagers lunatiques et passagerStress�
Quelle conclusion par rapport � nos deux pr�occupations ?
- Par rapport � notre pr�mi�re pr�occupation nous trouvons que nous ne sommes pas tr�s 
pr�occup�: il n'y a pas de code dupliqu�...
- par contre, on est oblig� de remanier du code existant � chaque fois qu'un nouveau attribut
doit �tre modifi�

Scenario 2: Nouvelle classe pour chaqu'un de ces sp�cimen.
Quelle conclusion par rapport � nos deux pr�occupations ?
- La notion de copier/coller ne colle pas vraiment avec notre premiere pr�occupation
- Par contre on ne va certainement plus toucher au PassagerStandard apr�s.

Scenario 3: L'h�ritage est un concept humain ancien. On va cr�er des classes filles de PassagerStandard.
Quelle conclusion par rapport � nos deux pr�occupations ?
- On va laisser faire le compilateur le boulot sale de copier/coller (car un h�ritage se r�alise par rien
d'autre que de copier-coller au niveau du compilateur (Cours Combemale). Mais, on pourra faire semblant de 
ne pas copier du tout. Tr�s bien!
- Et en plus on ne va rien changer dans le code existant de PassagerStandard.

Quel code dupliqu�?
- Le code pour tester les passagers de classe fille

