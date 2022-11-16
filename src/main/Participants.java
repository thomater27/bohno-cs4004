import java.util.ArrayList;

public class Participants {

    private ArrayList<Meeting> exclusionSet = new ArrayList<>();
    private Meeting exceptions ;
    private String name;
    private int password ;

    public Participants(String name){ //participant
        this.exceptions = new Meeting(cantWork);
        exclusionSet.add(exceptions);
        this.name = name;
    }

    public Participants(String name, int password){ //privileged participant
        exclusionSet.add(exceptions);
        this.name = name;
        this.password = password;
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

    public int getPassword() {
        return password;
    }
}
