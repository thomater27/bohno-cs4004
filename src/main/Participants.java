import java.util.ArrayList;

public class Participants {
    private ArrayList<Participants> allP = new ArrayList<>();
    private ArrayList<Meeting> exclusionSet = new ArrayList<>();
    private Meeting exceptions ;
    private String name;
    private int password ;

    public Participants(String name){ //participant
        this.name = name;
        allP.add(this);
    }

    public Participants(String name, int password){ //privileged participant
        this.name = name;
        this.password = password;
    }

    public ArrayList<Participants> getAllP() {
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

    public int getPassword() {
        return password;
    }
}
