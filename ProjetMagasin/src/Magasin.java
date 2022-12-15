import java.text.DecimalFormat;
import java.util.*;

public class Magasin {
    private String nomMagasin;
    private Map<String, Article> stock = new HashMap<String, Article>();
    private Set<Employe> listEmployes = new HashSet<Employe>();
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

    public Set<Employe> getListEmployes() {
        return this.listEmployes;
    }

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

    //Fonction pour ajouter un caissier à la liste d'employé
    public void addCaissier(Caissier... caissiers) {
        for (Caissier caissier : caissiers) {
            this.listEmployes.add(caissier);
        }
    }

    //Fonction pour ajouter un agent d'entretien à la liste d'employé
    public void addAgentEntretien(AgentEntretien... agents) {
        for (AgentEntretien agent : agents) {
            this.listEmployes.add(agent);
        }
    }

    //diminue la quantité d'un article du montant mis un paramètre
    public void diminutionStock(Article article, int quantité) {
        article.retirerQuantite(quantité);
    }

    //
    public void payerEmployes() {
        Iterator<Employe> iter = this.listEmployes.iterator();
        while(iter.hasNext()) { //parcours HashSet de la liste d'employés
            this.argent -= iter.next().getSalaire()/30; //retire de l'argent du magasin en fonction du salaire des employés
        }
    }

    //Argent restant du magasin
    public double calculArgentRestant() {
        return Math.round(this.argent);
    }

    public void restock(int numeroVague) {
        //On parcourt tous les articles
        for (Map.Entry<String, Article> article : this.stock.entrySet()) {
            Article articleActuel = article.getValue();

            //Si l'article peut etre restock (en fonction du numéro de la vague)
            if ((numeroVague % articleActuel.getTempsRestock()) == 0) {
                articleActuel.restock();
                System.out.println("RESTOCK: Restock de " + articleActuel.getNom() + ", quantite restockee: " + articleActuel.getNombreRestock() + ", quantite totale: " + articleActuel.getQuantite());
            }
        }
    }

    public Article[] triParPrix() {
        Article[] tabArticle = this.stock.values().toArray(new Article[0]);

        for(int i = 1; i < tabArticle.length; i++)  { //parcours le tableau d'article
            Article index = tabArticle[i];
            int j = i-1;

            while(j >= 0 && tabArticle[j].getPrixVente() > index.getPrixVente()) { //tri par insertion
                tabArticle[j+1] = tabArticle[j];
                j--;
            }
            tabArticle[j+1] = index;
        }

        return tabArticle;
    }


}


