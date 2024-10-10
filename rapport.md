# DAA - Rapport Laboratoire 2

###### auteurs: Rachel Tranchida, Massimo Stefani, Eva Ray

## Application

L'application contient 4 activités: 

## Manipulations

### Les activités

#### Que se passe-t-il si l’utilisateur appuie sur « back » lorsqu’il se trouve sur la seconde Activité ?

Si on n'a pas encore entré de nom et qu'on appuie sur "back" lorsqu'on se trouve sur la deuxième
activité, on retourne sur la première activité et le texte affichl est "Bienvenue, veuillez entrer
votre nom". Si on a déjà entré un nom précédemment, par exemple, "John" et qu'on appuie sur "back"
lorsqu'on se trouve sur
la seconde activité, on retourne sur la première activité et le texte affiché est "Bienvenue
John !".

Cela se passe car lorqu'on appuie sur "back" depuis la première activité sans avoir sauvé, c'est
un objet null qui est passé à la première activité. Dans la fonction 'getName', on update le champ
'username' uniquement si l'objet reçu n'est pas null. La fonction 'updateName' est ensuite appelée
et affiche la string de base si le username est null ou le string qui souhaite la bienvenue de
manière
personnelle si le username n'est pas null. C'est donc pour cela que nous avons le résultat observé.

#### Veuillez réaliser un diagramme des changements d’état des deux Activités pour les utilisations suivantes, vous mettrez en évidence les différentes instances de chaque Activité

- L’utilisateur ouvre l’application, clique sur le bouton éditer, renseigne son prénom et
  sauve
- L’utilisateur ouvre l’application en mode portrait, clique sur le bouton éditer, bascule en
  mode paysage, renseigne son prénom et sauve.

#### Que faut-il mettre en place pour que vos Activités supportent la rotation de l’écran ? Est-ce nécessaire de le réaliser pour les deux Activités, quelle est la différence ?

Lorsqu'on tourne l'écran, Android relance l'activité qui est en train de run ('onDestroy()' est
appelée, suivie de 'onCreate()'). Par conséquent, le champ "username" est réinitialisé. C'est pour
cela que lorsqu'on entre son nom, qu'on sauve et qu'on tourne l'écran, la string affichée est
"Bienvenue, veuillez entrer votre nom" et non pas celle qui shouhaite la bienvenue.

Si on souhaite que les activités supportent la rotation de l'écran, il faut override les fonctions
'onSaveInstanceState' et 'onRestoreInstanceState'. La méthode 'onSaveInstanceState' permet de
sauvegarder l'état actuel de l'activité dans un bundle avant sa destruction, et
'onRestoreInstanceState' permet de restaurer cet état lorsque l'activité est recréée. 

Il est nécessaire d'override ces méthodes uniquement pour la première activité. En effet, 
c'est elle qui contient l'état 'username' qui doit être sauvegardé. En ce qui concerne la deuxième
activité, son 'EditText' conserve son état automatiquement grâce à la sauvegarde automatique des
vues d'Android, puisqu'il hérite directement de 'View'.

### Les fragments, premiers pas

#### Les deux Fragments fournis implémentent la restauration de leur état. Si on enlève la sauvegarde de l’état sur le ColorFragment sa couleur sera tout de même restaurée, comment pouvons-nous expliquer cela ?

#### Si nous plaçons deux fois le CounterFragment dans l’Activité, nous aurons deux instances indépendantes de celui-ci. Comment est-ce que la restauration de l’état se passe en cas de rotation de l’écran ?

### Le FragmentManager

#### A l’initialisation de l’Activité, comment peut-on faire en sorte que la première étape s’affiche automatiquement ?

#### Comment pouvez-vous faire en sorte que votre implémentation supporte la rotation de l’écran ? Nous nous intéressons en particulier au maintien de l’état de la pile de Fragments et de l’étape en cours lors de la rotation.

#### Dans une transaction sur le Fragment, quelle est la différence entre les méthodes add et replace ?


