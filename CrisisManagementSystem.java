import java.util.*;

public class CrisisManagementSystem {

    private List<Crisis> crises;

    public CrisisManagementSystem() {
        this.crises = new ArrayList<>();
    }

    public void addCrisis(Crisis crisis) {
        this.crises.add(crisis);
    }

    public List<Crisis> getAllCrises() {
        return new ArrayList<>(this.crises); // Return a copy to avoid external modifications
    }

    public Crisis getCrisisById(int id) {
        for (Crisis crisis : this.crises) {
            if (crisis.getId() == id) {
                return crisis;
            }
        }
        return null; // Return null if the crisis with the given ID is not found
    }

    public void resolveCrisis(Crisis crisis) {
        crisis.setResolved(true);
    }

    public static void main(String[] args) {
        CrisisManagementSystem cms = new CrisisManagementSystem();

        Crisis crisis1 = new Crisis("Hurricane", "A hurricane is expected to make landfall in the next 24 hours.");
        Crisis crisis2 = new Crisis("Earthquake", "An earthquake has struck the city, causing widespread damage.");
        Crisis crisis3 = new Crisis("Cyberattack", "A major cyberattack has crippled the city's infrastructure.");

        cms.addCrisis(crisis1);
        cms.addCrisis(crisis2);
        cms.addCrisis(crisis3);

        List<Crisis> allCrises = cms.getAllCrises();

        for (Crisis crisis : allCrises) {
            System.out.println(crisis.toString());
        }

        Crisis crisisById = cms.getCrisisById(1);

        if (crisisById != null) {
            System.out.println(crisisById.toString());
        } else {
            System.out.println("Crisis with ID 1 not found.");
        }

        cms.resolveCrisis(crisis1);

        System.out.println(crisis1.toString());
    }
}

class Crisis {

    private static int nextId = 1;

    private final int id;
    private final String name;
    private final String description;
    private boolean resolved;

    public Crisis(String name, String description) {
        this.id = nextId++;
        this.name = name;
        this.description = description;
        this.resolved = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }

    @Override
    public String toString() {
        return "Crisis{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", resolved=" + resolved +
                '}';
    }
}
