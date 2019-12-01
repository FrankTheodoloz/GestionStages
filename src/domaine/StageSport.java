package domaine;

public class StageSport extends Stage {
    private Activite activite;

    public StageSport(int no, int jourDebut, int nbJours, int heureDebut, int heureFin, CategorieAge categorieAge, Activite activite) {
        super(no, jourDebut, nbJours, heureDebut, heureFin, categorieAge); this.activite=activite;
    }
    public String toString() { return super.toString() + activite; }
}