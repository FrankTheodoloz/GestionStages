package domaine;

import java.util.ArrayList;

public class StageMulti extends Stage {
    private String niveau;
    private ArrayList<Activite> activites;

    public StageMulti(int no, int jourDebut, int nbJours, int heureDebut, int heureFin, CategorieAge categorieAge, String niveau, ArrayList<Activite> activites) {
        super(no, jourDebut, nbJours, heureDebut, heureFin, categorieAge);
        this.niveau = niveau;
        this.activites = activites;
    }

    public ArrayList<Activite> getActivites() {
        return activites;
    }

    public String toString() {
        return super.toString() + activites + " " + niveau;
    }
}