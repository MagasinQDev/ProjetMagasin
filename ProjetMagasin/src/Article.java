public class Article {

    private String nom;
    private double prixVente;
    private double prixAchat;
    private int tempsRestock;
    private int nombreRestock;
    private int quantite;

    public Article(String nom, double prixVente, double prixAchat, int tempsRestock, int nombreRestock, int quantite) {
        this.nom = nom;
        this.prixVente = prixVente;
        this.prixAchat = prixAchat;
        this.tempsRestock = tempsRestock;
        this.nombreRestock = nombreRestock;
        this.quantite = quantite;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(double prixVente) {
        this.prixVente = prixVente;
    }

    public double getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(double prixAchat) {
        this.prixAchat = prixAchat;
    }

    public int getTempsRestock() {
        return tempsRestock;
    }

    public void setTempsRestock(int tempsRestock) {
        this.tempsRestock = tempsRestock;
    }

    public int getNombreRestock() {
        return nombreRestock;
    }

    public void setNombreRestock(int nombreRestock) {
        this.nombreRestock = nombreRestock;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void restock(){
        this.quantite += this.nombreRestock;
    }

}
