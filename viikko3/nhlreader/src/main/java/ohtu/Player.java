
package ohtu;

public class Player implements Comparable<Player> {
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
    
    public int getGoals() {
        return goals;
    }
    
    public int getAssists() {
        return assists;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }
   
    @Override
    public int compareTo(Player player) {
        return (player.getAssists() + player.getGoals()) - (assists + goals);
    }
    
    @Override
    public String toString() {
        return name + " " + team + " " + goals +  " + " + assists + " = " + (goals + assists);
    }
      
}
