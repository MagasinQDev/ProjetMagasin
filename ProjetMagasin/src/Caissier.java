/**
 * Un caissier permet de simuler les charges du magasin via le paiement de son salaire
 */
public class Caissier extends Employe {

    /**
     * Le salaire d'un caissier
     */
    // Salaire moyen d'un caissier
    private static int salaire = 1672;

    /**
     * Crée un caissier avec un identifiant
     * @param id l'identifiant attribué
     */
    public Caissier(int id) {
        super(id, Caissier.salaire);
    }

    /**
     * Permet d'obtenir le salaire du caissier
     * @return le salaire de l'agent d'entretien
     */
    public int getSalaire() {
        return this.salaire;
    }

    /**
     * Permet d'attribuer un salaire au caissier
     * @param salaire le salaire à attribuer au caissier
     */
    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }
    
}