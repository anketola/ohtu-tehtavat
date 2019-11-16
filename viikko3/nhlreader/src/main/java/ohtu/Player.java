
package ohtu;

public class Player {
    private String name;
    private int goals;
    private int assists;
    private int penalties;
    private String nationality;
    private String team;
    private String birthdate;
    
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }

    @Override
    public String toString() {
        return name + " team " + team + " goals " + goals +  " assists " + assists;
    }
      
}
