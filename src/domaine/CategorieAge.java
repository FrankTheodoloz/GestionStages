package domaine;

public class CategorieAge {
    private int ageMin;
    private int ageMax;

    public CategorieAge(int ageMin, int ageMax) { this.ageMin=ageMin; this.ageMax=ageMax; }
    public boolean equals(Object obj) { return ageMin == ((CategorieAge)obj).ageMin && ageMax == ((CategorieAge)obj).ageMax; }
    public String toString() { return ageMin + "-" + ageMax + "ans"; }
}