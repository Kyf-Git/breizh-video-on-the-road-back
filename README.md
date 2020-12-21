# <p style="text-align:center;"> Breizh Video</br>Partie Back-end</p>

<p style="text-align:right;"> <i>Réalisé dans la souffrance </i></br><i>par Franck Isambert.</i></p>

<br/>
<br/>


## <a id="variable-notion">Explication du Back-end:</a>


Etant donné la charge de travail, le temps imparti et mon inexpérience coté Back, j'ai suivi les conseils de Manu et me suis principalement concentré sur la classe `Village`.

Je me suis (fortement) inspiré du tuto <a href="https://promo-java-go.netlify.app/docs/spring/web/simpleCrud/">Simple CRUD</a>, que j'ai adapté à la classe `Village`.

L'API Rest contient les classes controller, model, service et repository.

Je suis partis d'une base de données h2, mais mes capacités actuelles sur le sujet sont on ne peut plus légères... </br>

Au final j'esperais pouvoir accéder à la base de données, consulter, ajouter ou effacer un village mais au moment ou j'écris ces lignes ça n'est pas encore le cas (n'ayant pas encore intégrer de test via POSTMAN, l'application ne peut à l'heure actuelle pas être testée.).</br>

Pour l'instant nous n'avons à disposition qu'une route de test avec la méthode `getVillageSauzon()` qui permet de tester une requête simple (on ajoute un village et son code postal).</br>

#### <p>La route de test : </p>
`http://localhost:8080/backtest/villages/welcome`
