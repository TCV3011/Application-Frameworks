package be.ehb.werkcollege1.opdracht3.models;

import java.util.ArrayList;

// singleton
public class DataSource {
    public static DataSource instance = new DataSource();
    private static ArrayList<Evenement> evenements;

    private DataSource() {
        if(evenements == null){
            evenements = new ArrayList<>();
            evenements.add(new Evenement(1, "Rock Werchter", "Concert"));
        }
    }

    public static ArrayList<Evenement> getEvenements() {
        return evenements;
    }

    public static Evenement getEvenementById(int id) {
        return (Evenement) evenements.stream().filter(x -> x.getId() == id);
    }

    public static void addEvenement(Evenement evenement) {
        evenements.add(evenement);
    }
}
