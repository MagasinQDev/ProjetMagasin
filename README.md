# Explication du Projet "Magasin" en Qualité de Developpement

### Equipe :

- Elisée LEYDIER  
- Ethan TESTA  
- Lucas MURATET  
- Aurélien MATTERA  

## Sujet :  
L'idée principale est de simuler un magasin avec différentes catégories d'article, tel que fruits, légumes, boissons, ...  
Le magasin est doté d'une gestion de stock de ces articles et une gestion de restock d'articles en simulant des fournisseurs.  
Le magasin est équipé de 3 caisses, pouvant être ouvertes ou fermées. La file d'attente s'allonge s'il n'y a pas assez de caisses de libres et que les clients s'apprêtent à payer.  
Au lancement de l'application, 10 clients entrent dans le magasin. Puis, des clients entrent par vague toutes les 2 minutes.  
Le magasin aurait une note globale pouvant varier en fonction du temps d'attente des clients et/ou de la quantité de produits en rupture de stock.  

## Présentation de la simulation:

-Système de journée :  
1 jour = 500 personnes en 20 tours  -> 15 personnes par tour, suivi d'une vague de 230 les deux derniers tours.

-Pourcentage de satisfaction :  
A chaque fin de journée, un pourcentage de satisfaction sera établi en fonction du client et des articles qu'il a pu acheter.

## Manuel d'utilisation :  

Pour utiliser notre application, il suffit d'exécuter le code situé dans le fichier [src](/ProjetMagasin/src) du dépôt GitHub du projet.
À la fin de chaque journée (soit chaque fin de journée), l'utilisateur peut appuyer sur la touche "C” pour continuer et enchainer sur la vague suivante, ou appuyer sur une autre touche pour mettre fin à la simulation.


Le résumé d'une journée se présente de la manière suivante (exemple) :  
-- 
(0) Argent restant avant ouverture : 8516.0  
(1) Journée n°1  
(2) Argent restant : 10114.0  
(3) nombre Client : 245  
(4) pourcentage clients mécontents : 4%  
(5) Appuyer sur c pour continuer   
 --  
(0) Le montant total d’argent du magasin avant son ouverture (donc au début de la journée).  
(1) Le numéro de la journée (et donc le numéro de la vague car il y a 1 vague/jour).  
(2) Le montant total d’argent restant dans le magasin.  
(3) Le nombre de clients ayant fait un passage dans le magasin dans la journée.  
(4) Le pourcentage de clients mécontents (qui augmente lorsqu'un article est en rupture de stock ou, dans une future implémentation, dès qu'il y a une attente trop longue à la caisse).  
(5) C’est l’instruction envoyée par le système afin de poursuivre la simulation.  
