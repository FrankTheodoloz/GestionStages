package metier;

import domaine.*;

import java.util.ArrayList;
import static dao.StageDao.chargerStages;

public class GestionStages {

    private static ArrayList<Stage> stages;

    /* Affiche la liste des stages contenant une certaine activité.
     * @param nom indique le nom de l'activité à rechercher. */
    private static void afficherLesStagesAvecDu(String nom) {
        System.out.println("Liste des stages avec du " + nom + " :");
        // ===== À CODER =====
    }

    public static void main(String[] args) {
        stages = chargerStages("LstStages.csv");
        afficherLesStagesAvecDu("Tennis");
    }
}