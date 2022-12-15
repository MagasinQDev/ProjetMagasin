public class Caissier extends Employe {

    private static int salaire = 1672;


    public Caissier(int id) {
        super(id, Caissier.salaire);
    }

    public int getSalaire() {
        return this.salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }
    
}