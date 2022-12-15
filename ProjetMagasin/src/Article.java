import java.util.Map;

/**
 * Un article est ce que va pouvoir acheter un client et ce qui sera contenu dans le stock d'un magasin
 */
public class Article {

    /**
     * Le nom de l'article
     */
    private String nom;

    /**
     * Le prix auquel est vendu l'article aux clients
     */
    private double prixVente;

    /**
     * Le prix auquel le magasin achète l'article
     */
    private double prixAchat;

    /**
     * Le temps qui s'écoulera entre chaque réapprovisionnement (en jours)
     */
    private int tempsRestock;
    /**
     * La quantité qui est réapprovisionnée à chaque réapprovisionnement
     */
    private int nombreRestock;
    /**
     * La quantité actuelle de l'article
     */
    private int quantite;

    /**
     * Crée un article possédant des informations essentiels au fonctionnement du magasin (stock, réapprovisionnement...)
     *
     * @param nom           le nom de l'article
     * @param prixVente     le prix que l'on doit payer pour acheter l'article dans le magasin
     * @param prixAchat     le prix que doit payer le magasin pour réapprovisionner l'article
     * @param tempsRestock  la fréquence de réapprovisionnement de l'article en jours
     * @param nombreRestock le nombre d'articles de ce type ajoutés à chaque réapprovisionnement
     * @param quantite      la quantité actuelle de l'article
     */
    public Article(String nom, double prixVente, double prixAchat, int tempsRestock, int nombreRestock, int quantite) {
        this.nom = nom;
        this.prixVente = prixVente;
        this.prixAchat = prixAchat;
        this.tempsRestock = tempsRestock;
        this.nombreRestock = nombreRestock;
        this.quantite = quantite;
    }

    /**
     * Permet d'obtenir le nom de l'article
     *
     * @return le nom de l'article
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Permet de changer le nom de l'article
     *
     * @param nom le nouveau nom de l'article
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Permet d'obtenir le prix de vente de l'article
     *
     * @return le prix de vente de l'article
     */
    public double getPrixVente() {
        return prixVente;
    }

    /**
     * Permet d'attribuer un prix de vente à l'article
     *
     * @param prixVente le prix de vente à attribuer à l'article
     */
    public void setPrixVente(double prixVente) {
        this.prixVente = prixVente;
    }

    /**
     * Permet d'obtenir le prix d'achat de l'article
     *
     * @return le prix d'achat de l'article
     */
    public double getPrixAchat() {
        return prixAchat;
    }

    /**
     * Permet d'attribuer un prix d'achat à l'article
     *
     * @param prixAchat le prix d'achat à attribuer à l'article
     */
    public void setPrixAchat(double prixAchat) {
        this.prixAchat = prixAchat;
    }

    /**
     * Permet d'obtenir la fréquence de réapprovisionnement de l'article
     *
     * @return la fréquence (en jours) de réapprovisionnement de l'article
     */
    public int getTempsRestock() {
        return tempsRestock;
    }

    /**
     * Permet d'attribuer une fréquence de réapprovisionnement à l'article
     *
     * @param tempsRestock la fréquence de réapprovisionnement à attribuer à l'article
     */
    public void setTempsRestock(int tempsRestock) {
        this.tempsRestock = tempsRestock;
    }

    /**
     * Permet d'obtenir la quantité qui sera réapprovisionnée à chaque réapprovisionnement pour cet article
     *
     * @return la quantité qui est réapprovisionnée à chaque réapprovisionnement
     */
    public int getNombreRestock() {
        return nombreRestock;
    }

    /**
     * Permet d'attribuer une quantité qui sera réapprovisionnée à chaque réapprovisionnement
     *
     * @param nombreRestock la quantité qui sera réapprovisionnée à chaque réapprovisionnement
     */
    public void setNombreRestock(int nombreRestock) {
        this.nombreRestock = nombreRestock;
    }

    /**
     * Permet d'obtenir la quantité actuelle d'un produit
     *
     * @return la quantité actuelle d'un produit
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * Permet d'attribuer une quantité à un produit
     *
     * @param quantite la quantité à attribuer au produit
     */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    /**
     * Permet de retirer la quantité indiquée à l'article
     *
     * @param quantite la quantité qui sera retirée
     */
    public void retirerQuantite(int quantite) {
        this.quantite -= quantite;
    }

    /**
     * Permet d'ajouter à la quantité actuelle de l'article sa quantité de réapprovisionnement
     */
    public void restock() {
        this.quantite += this.nombreRestock;
    }
}


