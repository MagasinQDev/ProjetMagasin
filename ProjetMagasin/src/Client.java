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
            //si le panier contient déjà l'article demandé
            if(!this.panier.containsKey(article.getNom())) {
                //on enleve du stock la quantite prise
                article.setQuantite(article.getQuantite() - quantite);
                this.panier.put(article.getNom(), quantite);
            }
            else {
                this.panier.replace(article.getNom(), this.panier.get(article.getNom()) + quantite);
            }
        }
        //si l'article est disponible mais pas dans la quantité voulue
        else {
            //note: peut-être voir si on fait pas en sorte que le client prenne qd mm l'article dans la quantité qu'il reste
            this.estMecontent =  true;
            System.out.println("L'article " + article.getNom() + " n'est pas disponible dans la quantité demandée !");
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
