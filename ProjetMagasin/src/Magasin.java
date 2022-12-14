import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Magasin {
    private String nomMagasin;
    private Map<String, Article> stock = new HashMap<String, Article>();
    private Set<Caissier> listCaissiers = new HashSet<Caissier>();
    private double argent = 10000.00;

    public String getNomMagasin() {
        return this.nomMagasin;
    }
    
    public Map<String, Article> getStock() {
        return this.stock;
    }

    public Set<Caissier> getListCaissiers() {
        return this.listCaissiers;
    }

    /*
    public void addArticle(Article article) {
        this.stock.put(article.getNom(), article);
        this.argent -= article.getPrixAchat();
    }*/


    public void addArticle(Article... articles) {

        // Créer un objet DecimalFormat avec le format souhaité
        DecimalFormat formatter = new DecimalFormat("#0.00");

        for(Article article : articles){
            this.stock.put(article.getNom(), article);
            for (int i = 0; i < article.getQuantite(); ++i){
                this.argent -= article.getPrixAchat();

                this.argent = Double.parseDouble(formatter.format(this.argent));
            }
        }
    }
    /*
    public void addArticle(Article... articles) {
        for(Article article : articles){
            for (int i = 0; i < 40; ++i){
                this.stock.put(article.getNom(), article);
                System.out.println(article.getPrixAchat());
                this.argent -= article.getPrixAchat();
            }
        }
    }*/

    public void addCaissier(Caissier caissier) {
        this.listCaissiers.add(caissier);
    }

    public void addCaissier(Caissier... caissiers) {
        for(Caissier caissier : caissiers){
            this.listCaissiers.add(caissier);
        }
    }

    public void diminutionStock(Article article, int quantité) {

    }

    public double calculBenefice(){
        return this.argent;
    }
}

