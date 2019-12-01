package domaine;

public class Activite {
    private int no;
    private String nom;

    public Activite(int no, String nom) {
        this.no = no;
        this.nom = nom;
    }

    public Activite(int no) {
        this.no = no;
    }

    public Activite(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public boolean equals(Object obj) {
        return (no == ((Activite) obj).no) || ((nom != null) && (nom.equals(((Activite) obj).nom)));
    }

    public String toString() {
        return nom;
    }
}