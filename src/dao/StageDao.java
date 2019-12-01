package dao;

import domaine.*;
import exceptions.InvalidParsedParameterException;
import outils.FileToStr;

import java.util.ArrayList;
import java.util.HashMap;

public class StageDao {

    private static HashMap<Integer, CategorieAge> categoriesAge = FileToStr.listeDesCategoriesAge();
    private static ArrayList<Activite> activites = FileToStr.listeDesActivites();

    /* Retourne un ArrayList contenant tous les stages lus dans le fichier dont le nom est fourni en paramètre.
     * La méthode FileToStr.lireFichier retourne un ArrayList<String[]> contenant tous les stages.
     * Pour chaque stage, on reçoit :
     *   - le numéro du stage
     *   - le jour de début du stage
     *   - le nombre de jours
     *   - l'heure de début
     *   - l'heure de fin
     *   - le numéro de la catégorie d'âge
     *   - la liste des activités :
     *       - s'il n'y a qu'une seule activité, il s'agit d'un StageSport: il n'y a donc que le n° de l'activité.
     *       - s'il y a plusieurs activités, il s'agit d'un StageMulti: le 1er champ indique le niveau, les suivants sont les n° d'activité.
     * Tous les champs sont des entiers, à l'exception du niveau pour les stages mutli-activités qui est un String.
     * @param filename  indique le nom du fichier à lire contenant toutes les données de tous les stages.
     * @return un ArrayList contenant tous les stages. */
    public static ArrayList<Stage> chargerStages(String filename) {
        ArrayList<Stage> stages = new ArrayList<>();
        int noLigne = 0;
        for (String[] ligne : FileToStr.lireFichier(filename)) {
            noLigne++;
            int no = Integer.parseInt(ligne[0]);
            int jourDebut = Integer.parseInt(ligne[1]);
            int nbJours = Integer.parseInt(ligne[2]);
            int heureDebut = Integer.parseInt(ligne[3]);
            int heureFin = Integer.parseInt(ligne[4]);
            int noCategorieAge = Integer.parseInt(ligne[5]);
            CategorieAge categorieAge = categoriesAge.get(noCategorieAge);

            // categorie d'age inconnue
            try {
                if (categorieAge == null) throw new InvalidParsedParameterException("catégorie age");
            } catch (InvalidParsedParameterException e) {
                System.out.println(e + " à la ligne " + noLigne);
            }

            if (ligne.length == 7) {

                // numéro d'activité inconnu et erreur paramètre création stage
                try {
                    stages.add(new StageSport(no, jourDebut, nbJours, heureDebut, heureFin, categorieAge, activites.get(activites.indexOf(new Activite(Integer.parseInt(ligne[6]))))));
                } catch (InvalidParsedParameterException e) {
                    System.out.println(e + " à la ligne " + noLigne);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Erreur de lecture du fichier, paramètre numéro activité à la ligne " + noLigne);
                }
            } else {
                String niveau = ligne[6];
                ArrayList<Activite> aLstAct = new ArrayList<>();
                for (int i = 7; i < ligne.length; i++) {

                    // numéro d'activité inconnu
                    try {
                        aLstAct.add(activites.get(activites.indexOf(new Activite(Integer.parseInt(ligne[i])))));
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Erreur de lecture du fichier, paramètre numéro activité à la ligne " + noLigne);
                    }
                }

                // erreur paramètre création stage
                try {
                    stages.add(new StageMulti(no, jourDebut, nbJours, heureDebut, heureFin, categorieAge, niveau, aLstAct));
                } catch (InvalidParsedParameterException e) {
                    System.out.println(e + " à la ligne " + noLigne);
                }
            }
        }
        return stages;
    }
}