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

    public void setArgent(double argent) {
        this.argent = argent;
    }

    public double getArgent() {
        return argent;
    }

    public Map<String, Article> getStock() {
        return this.stock;
    }

    public Set<Caissier> getListCaissiers() {
        return this.listCaissiers;
    }

    public void addArticle(Article... articles) {

        // Créer un objet DecimalFormat avec le format souhaité
        DecimalFormat formatter = new DecimalFormat("#0.00");

        for(Article article : articles){
            this.stock.put(article.getNom(), article);
            for (int i = 0; i < article.getQuantite(); ++i){
                this.argent -= Math.round(article.getPrixAchat());
            }
        }
    }

    public void addCaissier(Caissier... caissiers) {
        for(Caissier caissier : caissiers){
            this.listCaissiers.add(caissier);
        }
    }

    public void diminutionStock(Article article, int quantité) {

    }

    public double calculArgentRestant(){
        return Math.round(this.argent);
    }

    public void restock() {
        for (Map.Entry<String, Article> articleActuel : this.stock.entrySet()) {
            articleActuel.getValue().restock();
        }
    }
}


