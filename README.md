# Explication du Projet "Magasin" en Qualité de Developpement

### Equipe :

- Elisée LEYDIER  
- Ethan TESTA  
- Lucas MURATET  
- Aurélien MATTERA  

## Sujet :  
L'idée principale est de simuler un magasin avec différentes catégories d'article, tel que fruits, légumes, boissons, ...  
Le magasin est doté d'une gestion de stock de ces articles et une gestion de restock d'articles en simulant des fournisseurs.  
Le magasin est équipé de 3 caisses, pouvant être ouverte ou fermée. La file d'attente s'allonge si aucune caisse n'est libre et que les clients s'apprêtent à payer.  
Au lancement de l'application, 10 clients entrent dans le magasin. Puis, des clients entrent par vague toutes les 2 minutes.  
Le magasin aurait une note globale pouvant varier en fonction du temps d'attente des clients ou  de la quantité de produits en rupture de stock.  

## Présentation de la simulation:

-Système de journée :  
1 jour = 500 personnes en 20s  -> 15 personnes par seconde, suivi d'une vague de 230 les deux dernières secondes.

-Pourcentage de satisfaction :  
A chaque fin de journée, un pourcentage de satisfaction sera établi en fonction du client et des articles qu'il a pu acheter

## Manuel d'utilisaton :  

Pour utiliser notre application, il suffit d'exécuter le code situé dans le fichier src du github.  
A la fin de chaque journée (soit chaque fin de journée), l'utilisateur doit appuyer sur "c" pour continuer et enchainer sur la vague suivante, ou appuyer sur sur une autre touche pour mettre fin à la simulation.

Le résumé d'une journée se présente de la manière suivante (exemple) :  
-- 
(0) Argent restant avant ouverture : 8516.0  
(1) Journée n°1  
(2) Argent restant : 10114.0  
(3) nombre Client : 245  
(4) pourcentage clients mécontents : 4%  
(5) Appuyer sur c pour continuer   
 --  
(0) C’est l’argent restant du magasin avant son ouverture (donc au début de la journée).  
(1) Ici, le champ n°1 désigne le numéro de la journée (et donc le numéro de la vague car il y a 1 vague/jour).  
(2) Le champ n°2 désigne l'argent restant que possède le magasin.  
(3) Le champ n°3 désigne le nombre de client ayant réalisé un achat dans le magasin dans la journée.  
(4) Pour finir, le champ n°4 désigne le pourcentage de client mécontent (qui augmente lorsqu'un article est en rupture de stock ou qu'il y a de l'attente à la caisse).  
(5) C’est l’instruction pour poursuivre la simulation.
