package domaine;

public abstract class Stage {
    private int no;
    private int jourDebut;
    private int nbJours;
    private int heureDebut;
    private int heureFin;
    private CategorieAge categorieAge;

    public Stage(int no, int jourDebut, int nbJours, int heureDebut, int heureFin, CategorieAge categorieAge) {
        this.no = no;
        this.jourDebut = jourDebut;
        this.nbJours = nbJours;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.categorieAge = categorieAge;
    }

    public boolean equals(Object obj) {
        return no == ((Stage) obj).no;
    }

    public String toString() {
        return "Stage n°" + no + " pour " + categorieAge + ": " + nbJours + " jours depuis le " + jourDebut + " de " + heureDebut + "h-" + heureFin + "h: ";
    }
}