import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

/**
 * Un client peut acheter des articles dans un magasin et sert à augmenter les bénéfices d'un magasin et faire diminuer son stock pour simuler une pénurie
 */
public class Client {

    /**
     * L'identifiant du client
     */
    private int id;

    /**
     * Le panier du client
     */
    private Map<String, Integer> panier = new HashMap<String, Integer>();
    /**
     * Le magasin dans lequel se trouve le client
     */
    private Magasin magasin;
    /**
     * Etat caractérisant la satisfaction du client si les articles voulus sont disponibles ou non
     */
    private boolean estMecontent = false;

    /**
     * Crée un client avec un identifiant et un magasin attribué
     *
     * @param id      l'identifiant attribué
     * @param magasin le magasin attribué
     */
    public Client(int id, Magasin magasin) {
        this.id = id;
        this.magasin = magasin;
    }

    /**
     * Permet d'obtenir l'état de satisfaction du client
     *
     * @return l'état de satisfaction du client
     */
    public boolean isEstMecontent() {
        return estMecontent;
    }

    /**
     * Permet d'obtenir l'identifiant du client
     *
     * @return l'identifiant du client
     */
    public int getId() {
        return this.id;
    }

    /**
     * Permet d'obtenir le panier du client
     *
     * @return le panier du client
     */
    public Map<String, Integer> getPanier() {
        return this.panier;
    }

    /**
     * Permet d'ajouter un article au panier
     *
     * @param article  l'article à ajouter au panier
     * @param quantite la quantité de l'article à ajouter au panier
     */
    public void addArticle(Article article, int quantite) {
        //si le stock ne contient pas l'article
        if (!magasin.getStock().containsValue(article)) {
            System.out.println("L'article " + article.getNom() + " n'est pas disponible dans ce magasin !");
        }
        // Si l'article est disponible
        else if (article.getQuantite() >= quantite) {
            //si le panier ne contient pas encore l'article
            if (!this.panier.containsKey(article.getNom())) {
                //on enleve du stock la quantite prise
                this.panier.put(article.getNom(), quantite);
                article.setQuantite(article.getQuantite() - quantite);
            } else {
                this.panier.replace(article.getNom(), this.panier.get(article.getNom()) + quantite);
                article.retirerQuantite(quantite);
            }
        }
        //si l'article est disponible mais pas dans la quantité voulue
        else {
            //Le Client est mécontant
            this.estMecontent = true;

            //on prend les derniers articles restant
            if (article.getQuantite() > 0) {
                //si le panier ne contient pas l'article encore
                if (!this.panier.containsKey(article.getNom())) {
                    //on enleve du stock la quantite prise
                    this.panier.put(article.getNom(), article.getQuantite());
                    article.setQuantite(0);
                } else {
                    this.panier.replace(article.getNom(), this.panier.get(article.getNom()) + article.getQuantite());
                    article.setQuantite(0);
                }
            }

        }
    }

    /**
     * Ajoute la somme du prix de vente de chacun des articles du panier du client à l'argent total du magasin
     */
    //Le client passe en caisse
    public void passageCaisse() {
        double prix = 0;
        for (Map.Entry<String, Integer> articleActuel : panier.entrySet()) { //Parcours la Map
            //Calcul du prix total du panier nbArticle*LeurPrix
            prix += (double) articleActuel.getValue() * this.magasin.getStock().get(articleActuel.getKey()).getPrixVente();
        }
        // Ajout du bénéfice à l'argent restant du magasin
        this.magasin.setArgent(this.magasin.getArgent() + prix);
    }
}
