/**
 * Un employé travaille dans un magasin et touche un salaire qui sert à simuler les charges du magasin
 */
public abstract class Employe {

    /**
     * L'identifiant de l'employé
     */
    private int id;

    /**
     * Le salaire de l'employé
     */
    private int salaire;

    /**
     * Permet de donner des attributs communs aux classes qui hériteront de celle-ci
     * @param id l'identifiant d'un employé
     * @param salaire le salaire d'un employé
     */
    public Employe(int id, int salaire) {
        this.id = id;
        this.salaire = salaire;
    }

    /**
     * permet d'obtenir l'identifiant d'un employé
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Permet d'attribuer un identifiant à l'employé
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Permet d'obtenir le salaire de l'employé
     * @return le salaire de l'employé
     */
    public int getSalaire() {
        return salaire;
    }

    /**
     * Permet d'attribuer un salaire à l'employé
     * @param salaire le salaire à attribuer à l'employé
     */
    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

}
