public class AgentEntretien extends Employe {

    private static int salaire = 1788;

    public AgentEntretien(int id) {
        super(id, AgentEntretien.salaire);
    }

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }
}
