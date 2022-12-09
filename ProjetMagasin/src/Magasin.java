import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Magasin {
    private String nomMagasin;
    private Map<String, Article> stock = new HashMap<String, Article>();
    private Set<Caissier> listCaissiers = new HashSet<Caissier>();

    public String getNomMagasin() {
        return this.nomMagasin;
    }
    
    public Map<String, Article> getStock() {
        return this.stock;
    }

    public Set<Caissier> getListCaissiers() {
        return this.listCaissiers;
    }

    public void addArticle(Article article) {
        this.stock.put(article.getNom(), article);
    }

    public void addArticle(Article... articles) {
        for(Article article : articles){
            this.stock.put(article.getNom(), article);
        }
    }

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
}

