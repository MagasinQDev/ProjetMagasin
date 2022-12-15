/**
 * Un agent d'entretien permet de simuler les charges du magasin via le paiement de son salaire
 */
public class AgentEntretien extends Employe {

    /**
     * Le salaire d'un agent d'entretien
     */
    private static int salaire = 1788;

    /**
     * Crée un agent d'entretien avec un identifiant
     *
     * @param id l'identifiant attribué
     */
    public AgentEntretien(int id) {
        super(id, AgentEntretien.salaire);
    }

    /**
     * Permet d'obtenir le salaire de l'agent d'entretien
     *
     * @return le salaire de l'agent d'entretien
     */
    public int getSalaire() {
        return salaire;
    }

    /**
     * Permet d'attribuer un salaire à l'agent d'entretien
     *
     * @param salaire le salaire à attribuer à l'agent d'entretien
     */
    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }
}
