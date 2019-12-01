package domaine;

import exceptions.*;

public class StageSport extends Stage {
    private Activite activite;

    public StageSport(int no, int jourDebut, int nbJours, int heureDebut, int heureFin, CategorieAge categorieAge, Activite activite) throws InvalidParsedParameterException {
        super(no, jourDebut, nbJours, heureDebut, heureFin, categorieAge);
        this.activite = activite;
    }

    public Activite getActivite() {
        return activite;
    }

    public String toString() {
        return super.toString() + activite;
    }
}