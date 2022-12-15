public abstract class Employe {

    private int id;
    private int salaire;

    public Employe(int id, int salaire) {
        this.id = id;
        this.salaire = salaire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getSalaire() {
        return salaire;
    }
    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

}
