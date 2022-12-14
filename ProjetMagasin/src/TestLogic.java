import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.text.DecimalFormat;

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
    public void TestRestock(){

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
    public void Benefice(){

        Magasin m1 = new Magasin();

        Article pates = new Article("pates", 1.12, 0.9, 1, 20, 50);
        Article riz = new Article("riz", 1.29, 1, 2, 25, 40);
        Article pomme = new Article("pomme", 0.18, 0.1, 2, 40, 40);

        m1.addArticle(pates ,riz, pomme);

        double nombre = m1.calculArgentRestant();

        // Appliquer le format au nombre
        System.out.println(nombre);
    }

}