import java.util.*;

public class Main {

    public static void main(String[] args) {

        // creation d'un generateur de nombres pseudo-aleatoires
        Random rand = new Random();

        // Création de l'objet magasin
        Magasin m1 = new Magasin();

        // Création des divers articles avec leur nom, prix de vente et achat, leur intervalle de réaprovisonnement et quantité
        Article pates = new Article("pates", 1.12, 0.9, 1, 20, 50);
        Article riz = new Article("riz", 1.29, 1, 2, 25, 40);
        Article pain = new Article("pain", 0.9, 0.5, 1, 50, 50);
        Article pomme = new Article("pomme", 0.18, 0.1, 2, 40, 40);
        Article haricots = new Article("haricots",2.67,1.5,4,45,50);
        Article poisson = new Article("poisson",2.99,2.2,3,25,30);
        Article steakhache = new Article("steakhache",1.8,1.3,2,40,50);
        Article champagne = new Article("champagne",39.37,30,10,12,20);
        Article eau = new Article("eau",0.7,0.2,1,60,100);
        Article coca = new Article("coca",1.63,1.2,2,42,54);
        Article yahourt = new Article("yahourt",0.8,0.5,3,70,80);
        Article fromage = new Article("fromage",2.49,2,3,40,50);
        Article shampoing = new Article("shampoing",1.57,1.2,4,40,60);
        Article lessive = new Article("lessive",4.4,3.8,5,45,60);

        // Création des objets caissiers et agent d'entretien
        Caissier cais1 = new Caissier(1);
        Caissier cais2 = new Caissier(2);
        AgentEntretien agent1 = new AgentEntretien(1);
        AgentEntretien agent2 = new AgentEntretien(2);
        m1.addCaissier(cais1, cais2);
        m1.addAgentEntretien(agent1, agent2);


        //ajout des articles dans le magasin
        m1.addArticle(pates ,riz, pain, pomme, haricots, poisson, steakhache, champagne, eau, coca, yahourt ,fromage, shampoing, lessive);

        //transforme les valeurs de la map en liste
        Article[] listArticleMagasin = m1.getStock().values().toArray(new Article[0]);

        // Appliquer le format au nombre
        System.out.println("------------------");
        System.out.print("Argent restant avant ouverture : ");
        System.out.println(m1.calculArgentRestant());

        boolean continuer = true;
        int compteurVague = 0;

        while(continuer) {
            m1.payerEmployes();
            compteurVague += 1;

            int compteurClient = 0;
            int compteurClientMecontent = 0;

            /*  HORS VAGUE  */

            //18 Tours
            for (int i = 0; i < 18; ++i) {
                //15 clients par tour
                for (int j = 0; i < 15; ++i) {
                    //On génére un nombre aléatoire d'articles différents que le client prend
                    int nbArticlesDiff = rand.nextInt(10);
                    // création des objets clients
                    Client c1 = new Client(i, m1);
                    compteurClient += 1;
                    for(int k = 0; k < nbArticlesDiff; k++) {
                        //On générer un nombre aléatoire pour savoir ce quel article le client prend
                        int quelArticle = rand.nextInt(listArticleMagasin.length);
                        //On générer un nombre aléatoire pour savoir combien le client en prend
                        int quelQuantite = rand.nextInt(5);

                        c1.addArticle(listArticleMagasin[quelArticle], quelQuantite);
                    }

                    c1.passageCaisse();

                    //coefficient de mécontentements des clients
                    int val = c1.isEstMecontent() ? 1 : 0;
                    compteurClientMecontent += val;
                }
            }
            System.out.println(compteurClient);
            //Vague
            for (int i = 0; i < 230; ++i) {
                // On générer un nombre aléatoire pour savoir ce quel article le client prend
                int quelArticle = rand.nextInt(listArticleMagasin.length);
                // On générer un nombre aléatoire pour savoir combien le client en prend
                int quelQuantite = rand.nextInt(5);

                Client c1 = new Client(i, m1);
                c1.addArticle(listArticleMagasin[quelArticle], quelQuantite);
                c1.passageCaisse();
                compteurClient += 1;
                int val = c1.isEstMecontent() ? 1 : 0;
                compteurClientMecontent += val;
            }
            // Résumé de chaque journée, à la fin de la vague journalière
            System.out.println("------------------");
            System.out.print("Vague n°");
            System.out.println(compteurVague);
            System.out.print("Argent restant : ");
            System.out.println(m1.calculArgentRestant());
            System.out.print("Nombre de clients : ");
            System.out.println(compteurClient);
            System.out.print("Pourcentage de clients mécontents: ");
            System.out.print((compteurClientMecontent * 100) / compteurClient);
            System.out.println("%");


            Scanner monScanner = new Scanner(System.in);  // Créer l'objet scanner
            System.out.println("pour continuer, écrivez C");
            String reponse = monScanner.nextLine();  // Lire l'entrée de l'utilisateur

            //Si l'utilisateur ne veut pas continuer la simulation
            if (!reponse.equalsIgnoreCase("c"))
            {
                System.out.println("OK on ferme !");
                continuer = false;
            }
            //Sinon on réapprovisionne et relance la simulation
            else {
                // On réapprovisionne
                System.out.println("-------RESTOCK-------");
                m1.restock(compteurVague);
                System.out.println("------------------");
            }
        }
    }
}