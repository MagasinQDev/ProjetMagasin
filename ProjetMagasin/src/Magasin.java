import java.text.DecimalFormat;
import java.util.*;

/**
 * Un magasin sert à stocker des articles et à simuler une pénurie de ceux-ci via des clients qui vont acheter une certaine quantité de ces articles
 * Un magasin doit aussi assumer les charges de ses employés en les payant
 */
public class Magasin {
    /**
     * Le nom du magasin
     */
    private String nomMagasin;
    /**
     * Le stock du magasin
     */
    private Map<String, Article> stock = new HashMap<String, Article>();
    /**
     * La liste des employés du magasin
     */
    private Set<Employe> listEmployes = new HashSet<Employe>();
    /**
     * L'argent actuel du magasin
     */
    private double argent = 10000.00;

    /**
     * Permet d'obtenir le nom du magasin
     *
     * @return le nom du magasin
     */
    public String getNomMagasin() {
        return this.nomMagasin;
    }

    /**
     * Permet d'attribuer un montant d'argent au magasin
     *
     * @param argent le montant d'argent à attribuer au magasin
     */
    public void setArgent(double argent) {
        this.argent = argent;
    }

    /**
     * Permet d'obtenir le montant d'argent actuel du magasin
     *
     * @return le montant d'argent actuel du magasin
     */
    public double getArgent() {
        return argent;
    }

    /**
     * Permet d'obtenir le stock du magasin
     *
     * @return le stock du magasin
     */
    public Map<String, Article> getStock() {
        return this.stock;
    }

    /**
     * Permet d'obtenir la liste des employés
     *
     * @return la liste des employés
     */
    public Set<Employe> getListEmployes() {
        return this.listEmployes;
    }

    /**
     * Permet d'ajouter un nombre indéfini d'articles au stock du magasin
     *
     * @param articles les articles à ajouter au stock du magasin
     */
    public void addArticle(Article... articles) {

        // Créer un objet DecimalFormat avec le format souhaité
        DecimalFormat formatter = new DecimalFormat("#0.00");

        for (Article article : articles) {
            this.stock.put(article.getNom(), article);
            for (int i = 0; i < article.getQuantite(); ++i) {
                this.argent -= Math.round(article.getPrixAchat());
            }
        }
    }

    /**
     * Permet d'ajouter un nombre indéfini de caissiers à la liste des employés
     *
     * @param caissiers les caissiers à ajouter à la liste des employés
     */
    //Fonction pour ajouter un caissier à la liste d'employé
    public void addCaissier(Caissier... caissiers) {
        for (Caissier caissier : caissiers) {
            this.listEmployes.add(caissier);
        }
    }

    /**
     * Permet d'ajouter un nombre indéfini d'agents d'entretien à la liste des employés
     *
     * @param agents les agents d'entretien à ajouter à la liste des employés
     */
    //Fonction pour ajouter un agent d'entretien à la liste d'employé
    public void addAgentEntretien(AgentEntretien... agents) {
        for (AgentEntretien agent : agents) {
            this.listEmployes.add(agent);
        }
    }

    /**
     * Permet de retirer une certaine quantité d'un article du stock du magasin
     *
     * @param article  l'article dont la quantité va diminuer
     * @param quantité la quantité qui va être retirée
     */
    //diminue la quantité d'un article du montant mis un paramètre
    public void diminutionStock(Article article, int quantité) {
        article.retirerQuantite(quantité);
    }

    /**
     * Permet de payer les employés et donc simuler les charges du magasin
     */
    public void payerEmployes() {
        Iterator<Employe> iter = this.listEmployes.iterator();
        while (iter.hasNext()) { //parcours HashSet de la liste d'employés
            this.argent -= Math.round(iter.next().getSalaire() / 30); //retire de l'argent du magasin en fonction du salaire des employés
        }
    }

    /**
     * Permet d'obtenir le montant d'argent actuel du magasin
     *
     * @return le montant d'argent actuel du magasin
     */
    //Argent restant du magasin
    public double calculArgentRestant() {
        return Math.round(this.argent);
    }

    /**
     * Permet de réapprovisionner tous les articles du magasin dont c'est le jour de réapprovisionnement
     *
     * @param numeroVague le numero de vague (jour) actuel, permettant de calculer si oui ou non un réapprovisonnement doit être fait ce jour
     */
    public void restock(int numeroVague) {
        //On parcourt tous les articles
        for (Map.Entry<String, Article> article : this.stock.entrySet()) {
            Article articleActuel = article.getValue();

            //Si l'article peut etre restock (en fonction du numéro de la vague)
            if ((numeroVague % articleActuel.getTempsRestock()) == 0) {
                articleActuel.restock();
            }
        }
    }

    /**
     * Permet d'obtenir un tableau trié dans l'ordre croissant des prix des articles du stock du magasin
     *
     * @return un tableau d'articles triés dans l'ordre croissant des prix des articles du stock du magasin
     */
    public Article[] triParPrix() {
        Article[] tabArticle = this.stock.values().toArray(new Article[0]);

        for (int i = 1; i < tabArticle.length; i++) { //parcours le tableau d'article
            Article index = tabArticle[i];
            int j = i - 1;

            while (j >= 0 && tabArticle[j].getPrixVente() > index.getPrixVente()) { //tri par insertion
                tabArticle[j + 1] = tabArticle[j];
                j--;
            }
            tabArticle[j + 1] = index;
        }

        return tabArticle;
    }


}


