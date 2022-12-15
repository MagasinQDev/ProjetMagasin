import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class Client {
    private int id;
    private Map<String, Integer> panier = new HashMap<String, Integer>();
    private Magasin magasin;
    private boolean estMecontent = false;

        public Client(int id, Magasin magasin) {
            this.id = id;
            this.magasin = magasin;
        }

    public boolean isEstMecontent() {
        return estMecontent;
    }

    public int getId() {
        return this.id;
    }

    public Map<String, Integer> getPanier() {
        return this.panier;
    }

    public void addArticle(Article article, int quantite) {
        //si le stock ne contient pas l'article
        if(!magasin.getStock().containsValue(article)) {
            System.out.println("L'article " + article.getNom() + " n'est pas disponible dans ce magasin !");
        }
        // Si l'article est disponible
        else if(article.getQuantite() >= quantite) {
            //si le panier ne contient pas encore l'article
            if(!this.panier.containsKey(article.getNom())) {
                //on enleve du stock la quantite prise
                this.panier.put(article.getNom(), quantite);
                article.setQuantite(article.getQuantite() - quantite);
            }
            else {
                this.panier.replace(article.getNom(), this.panier.get(article.getNom()) + quantite);
                article.setQuantite(article.getQuantite() - quantite);
            }
        }
        //si l'article est disponible mais pas dans la quantité voulue
        else {
            //Le Client est mécontant
            this.estMecontent =  true;

            //on prend les derniers articles restant
            if (article.getQuantite() > 0){
                //si le panier ne contient pas l'article encore
                if(!this.panier.containsKey(article.getNom())) {
                    //on enleve du stock la quantite prise
                    this.panier.put(article.getNom(), article.getQuantite());
                    article.setQuantite(0);
                }
                else {
                    this.panier.replace(article.getNom(), this.panier.get(article.getNom()) + article.getQuantite());
                    article.setQuantite(0);
                }
            }

        }
    }

    //Le client passe en caisse
    public void passageCaisse(){
        double prix = 0;
        for (Map.Entry<String, Integer> articleActuel : panier.entrySet()) {
            prix += (double) articleActuel.getValue() * this.magasin.getStock().get(articleActuel.getKey()).getPrixVente();
        }
        this.magasin.setArgent(this.magasin.getArgent() + prix);
    }

    public void afficherPanier() {
        System.out.println();
    }

}
