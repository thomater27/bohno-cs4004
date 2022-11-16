import java.util.ArrayList;

public class Participant {
    private ArrayList<Participant> allP = new ArrayList<>();
    private ArrayList<Meeting> exclusionSet = new ArrayList<>();
    private final String name;
    private final String password;
    private boolean privileged = false;

    public Participant(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Participant(String name, String password, boolean privileged) {
        this(name, password);
        this.privileged = privileged;
    }

    public ArrayList<Participant> getAllP() {
        return allP;
    }

    public ArrayList<Meeting> getExclusionSet() {
        return exclusionSet;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public boolean checkLogin(String name, String password) {
        return this.name.equalsIgnoreCase(name) && this.password.equals(password);
    }

    public boolean isPrivileged() {
        return privileged;
    }

    public void addMeeting(Meeting m) {
        exclusionSet.add(m);
    }

    public boolean removeMeeting(String name) {
        int size = exclusionSet.size();
        for (int i = 0; i < size; i++) {
            if (exclusionSet.get(i).getDescription().equalsIgnoreCase(name)) {
                 exclusionSet.remove(i);
                 return true;
            }
        }
        return false;
    }
}
