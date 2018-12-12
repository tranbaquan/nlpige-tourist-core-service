package edu.hcmuaf.nlpige.domain;

import edu.hcmuaf.nlpige.model.Collaborator;
import edu.hcmuaf.nlpige.model.Traveler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ on Tuesday, 11 December, 2018 at 23:54.
 *
 * @author Joseph Maria
 */
public class DataMaster {
    static List<Traveler> travelers = new ArrayList<>();
    static List<Collaborator> collaborators = new ArrayList<>();

    public static Traveler findTravelerByEmail(String email) {
        for (Traveler traveler : travelers) {
            if (traveler.getEmail().equalsIgnoreCase(email)) {
                return traveler;
            }
        }
        return null;
    }

    public static void save(Traveler traveler) {
        travelers.add(traveler);
    }

    public static Collaborator findCollaboratorByEmail(String email) {
        for (Collaborator collaborator : collaborators) {
            if (collaborator.getEmail().equalsIgnoreCase(email)) {
                return collaborator;
            }
        }
        return null;
    }

    public static void save(Collaborator collaborator) {
        collaborators.add(collaborator);
    }
}
