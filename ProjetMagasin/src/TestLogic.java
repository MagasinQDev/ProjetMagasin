import org.junit.Test;

import java.text.DecimalFormat;

import static org.junit.Assert.*;

public class TestLogic {

    @Test
    public void TestArticleUnique(){
        Article pates = new Article("pates", 1.12, 0.9, 1, 20, 50);
        assertEquals("pates",pates.getNom());
        for(int i = 0; i < 10; ++i){
            pates.setQuantite(pates.getQuantite() - 1);
            System.out.print(i);
        }
        assertEquals(40,pates.getQuantite());
    }

    @Test
    public void TestArticle(){

        Article pates = new Article("pates", 1.12, 0.9, 1, 20, 50);
        Article riz = new Article("riz", 1.29, 1, 2, 25, 40);
        Article pomme = new Article("pomme", 0.18, 0.1, 2, 40, 40);

        for(int i = 0; i < 3; ++i){
            pates.setQuantite(pates.getQuantite() - 10);
            riz.setQuantite(riz.getQuantite() - 5);
            pomme.setQuantite(pomme.getQuantite()-1);
        }
        assertEquals(20,pates.getQuantite());
        assertEquals(25, riz.getQuantite());
        assertEquals(37, pomme.getQuantite());
    }


    @Test
    public void testRestock(){

        Magasin m1 = new Magasin();

        Article pates = new Article("pates", 1.12, 0.9, 1, 20, 50);
        Article riz = new Article("riz", 1.29, 1, 2, 25, 40);
        Article pomme = new Article("pomme", 0.18, 0.1, 2, 40, 40);

        m1.addArticle(pates ,riz, pomme);

        Client c1 = new Client(0, m1);

        c1.addArticle(pates, 1);
        c1.addArticle(riz, 1);
        c1.addArticle(pomme, 3);

        //System.out.println(c1.passageCaisse());
        System.out.println(c1.getPanier());
    }

    @Test
    public void testBenefice(){

        Magasin m1 = new Magasin();

        Article pates = new Article("pates", 1.12, 0.9, 1, 20, 50);
        Article riz = new Article("riz", 1.29, 1, 2, 25, 40);
        Article pomme = new Article("pomme", 0.18, 0.1, 2, 40, 40);

        m1.addArticle(pates ,riz, pomme);

        double nombre = m1.calculArgentRestant();

        // Appliquer le format au nombre
        System.out.println(nombre);
    }

    @Test
    public void testAjoutProduitPanier(){

        Magasin m1 = new Magasin();

        Article pates = new Article("pates", 1.12, 0.9, 1, 20, 50);
        m1.addArticle(pates);

        Client c1 = new Client(1, m1);
        c1.addArticle(pates, 10);
        c1.passageCaisse();
        assertEquals(10, (int)c1.getPanier().get("pates"));
    }

    @Test
    public void testProduitQuantiteLimitee(){

        Magasin m1 = new Magasin();

        Article pates = new Article("pates", 1.12, 0.9, 1, 20, 5);
        m1.addArticle(pates);

        Client c1 = new Client(1, m1);
        c1.addArticle(pates, 10);
        c1.passageCaisse();
        assertEquals(5, (int)c1.getPanier().get("pates"));
    }

    @Test
    public void testProduitRuptureStock(){

        Magasin m1 = new Magasin();

        Article pates = new Article("pates", 1.12, 0.9, 1, 20, 0);
        m1.addArticle(pates);

        Client c1 = new Client(1, m1);
        c1.addArticle(pates, 10);
        c1.passageCaisse();
        assertFalse(c1.getPanier().containsKey("pates"));
    }

    @Test
    public void testTriPrix(){

        Magasin m1 = new Magasin();

        Article pates = new Article("pates", 1.12, 0.9, 1, 20, 50);
        Article riz = new Article("riz", 1.29, 1, 2, 25, 40);
        Article pain = new Article("pain", 0.9, 0.5, 1, 50, 50);
        Article pomme = new Article("pomme", 0.18, 0.1, 2, 40, 40);
        Article haricots = new Article("haricots",2.67,1.5,4,45,50);
        Article poisson = new Article("poisson",2.99,2.2,3,25,30);
        Article steakhache = new Article("steakhache",1.8,1.3,2,40,50);

        m1.addArticle(pates, riz, pain, pomme, haricots, poisson, steakhache);

        Article[] articles = m1.triParPrix();
        Article articleActuel = articles[0];
        for(int i = 1; i < articles.length; i++) {
            assertTrue(articleActuel.getPrixVente() <= articles[i].getPrixVente());
            articleActuel = articles[i];
        }
    }


}
