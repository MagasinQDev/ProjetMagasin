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

-Système de vague :  
1 jour = 500 personnes en 20s  -> 15 personnes par seconde et 230 les deux dernières secondes.

-Pourcentage de satisfaction : 
A chaque fin de vague, un pourcentage de satisfaction sera établi en fonction du client et des articles qu'il a pu acheter

-Stock dans le rouge:
A chaque fin de vague on liste les produits qui ont anormalement diminué.
