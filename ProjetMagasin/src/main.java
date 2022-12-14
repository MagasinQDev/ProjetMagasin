import java.util.*;

public class main {

    public static void main(String[] args) {

        // create instance of Random class
        Random rand = new Random();

        Magasin m1 = new Magasin();
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

        List<Article> listArticleMagasin = Arrays.asList( pates ,riz, pain, pomme, haricots, poisson, steakhache, champagne, eau, coca, yahourt ,fromage, shampoing, lessive);

        m1.addArticle(pates ,riz, pain, pomme, haricots, poisson, steakhache, champagne, eau, coca, yahourt ,fromage, shampoing, lessive);

        // Appliquer le format au nombre
        System.out.print("Argent restant avant ouverture : ");
        System.out.println(m1.calculArgentRestant());
        System.out.println(pain.getQuantite());


        int conteurClient = 0;
        int conteurClientMecontant = 0;

        //HORS VAGUE
        for (int i = 0; i < 18; ++i) {
            for (int j = 0; i < 15; ++i) {
                // On générer un nombre aléatoire pour savoir ce quel article le client prend
                int quelArticle = rand.nextInt(listArticleMagasin.size());
                // On générer un nombre aléatoire pour savoir combien le client en prend
                int quelQuantite = rand.nextInt(5);

                Client c1 = new Client(i, m1);
                c1.addArticle(listArticleMagasin.get(quelArticle), quelQuantite);
                c1.passageCaisse();
                conteurClient += 1;
                int val = c1.isEstMecontent() ? 1 : 0;
                conteurClientMecontant += val;

            }
        }
        //Vague
        for (int i = 0; i < 230; ++i) {
            // On générer un nombre aléatoire pour savoir ce quel article le client prend
            int quelArticle = rand.nextInt(listArticleMagasin.size());
            // On générer un nombre aléatoire pour savoir combien le client en prend
            int quelQuantite = rand.nextInt(5);

            Client c1 = new Client(i, m1);
            c1.addArticle(listArticleMagasin.get(quelArticle), quelQuantite);
            c1.passageCaisse();
            conteurClient += 1;
            int val = c1.isEstMecontent() ? 1 : 0;
            conteurClientMecontant += val;
        }

        System.out.println("------------------");
        System.out.println("Vague n°1");
        System.out.print("Argent restant : ");
        System.out.println(m1.calculArgentRestant());
        System.out.print("nombre Client : ");
        System.out.println(conteurClient);
        System.out.print("pourcentage Client mécontant: ");
        System.out.print((conteurClientMecontant * 100) / conteurClient);
        System.out.println("%");

    }
}
