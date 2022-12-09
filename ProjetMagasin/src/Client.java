import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class Client {
    private int id;
    private Map<String, Integer> panier = new HashMap<String, Integer>();
    private Magasin magasin;

        public Client(int id, Magasin magasin) {
            this.id = id;
            this.magasin = magasin;
        }

    public int getId() {
        return this.id;
    }

    public Map<String, Integer> getPanier() {
        return this.panier;
    }

    public void addArticle(Article article, int quantite) {
            //on regarde si le stock contient l'article et si la quantite dispo est supérieure à la demande
            if(magasin.getStock().containsValue(article) && article.getQuantite() >= quantite) {
                //on regarde si le panier contient déjà l'article demandé
                if(!this.panier.containsKey(article.getNom())) {
                    article.setQuantite(article.getQuantite() - quantite);
                    this.panier.put(article.getNom(), quantite);
                }
                //si le panier contient déjà l'article, on additionne l'ancienne quantité à la nouvelle quantité demandée
                else {
                    this.panier.replace(article.getNom(), this.panier.get(article.getNom()) + quantite);
                }
            }
    }

    public double calculerPrixPanier(){
        double prix = 0;
        for (Map.Entry<String, Integer> articleActuel : panier.entrySet()) {
            prix += articleActuel.getValue() * this.magasin.getStock().get(articleActuel.getKey()).getPrixVente();
        }
        return prix;
    }

    public void afficherPanier() {
        System.out.println();
    }

}
