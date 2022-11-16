import java.util.ArrayList;

public class Participant {
    private ArrayList<Participant> allP = new ArrayList<>();
    private ArrayList<Meeting> exclusionSet = new ArrayList<>();
    private Meeting exceptions ;
    private String name;
    private String password;
    private boolean priveleged = false;

    public Participant(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Participant(String name, String password, boolean privileged) {
        this(name, password);
        this.priveleged = privileged;
    }

    public ArrayList<Participant> getAllP() {
        return allP;
    }

    public Meeting getExceptions() {
        return exceptions;
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
        return this.name.equals(name) && this.password.equals(password);
    }

    public boolean isPriveleged() {
        return priveleged;
    }

    public void addMeeting(Meeting m) {
        exclusionSet.add(m);
    }
}
