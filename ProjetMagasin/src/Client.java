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
        //si le stock ne contient pas l'article
        if(!magasin.getStock().containsValue(article)) {
            System.out.println("L'article " + article.getNom() + " n'est pas disponible dans ce magasin !");
        }
        //si la quantite dispo est supérieure à la demande
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
        //si stock article < quantité demandée
        else {
            //note: peut-être voir si on fait pas en sorte que le client prenne qd mm l'article dans la quantité qu'il reste
            System.out.println("L'article " + article.getNom() + " n'est pas disponible dans la quantité demandée !");
        }
    }
    /*
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
    }*/

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
    /*
    public void allerEncaisse(){

    }*/

}
