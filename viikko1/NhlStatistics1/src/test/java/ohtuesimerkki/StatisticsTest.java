package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class StatisticsTest {
    
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
    
    Statistics stats;
    
    
    @Before
    public void setUp() {
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }
    
    @Test
    public void returnsCorrectPlayerNameByTeam() {
        String playerName = stats.team("EDM").get(0).getName();
        // should return Semenko
        assertEquals("Semenko", playerName);
    }
    
    @Test
    public void topScoresGivesCorrectPlayer() {
        String topPlayer = stats.topScorers(1).get(0).getName();
        // should return Gretzky
        assertEquals("Gretzky", topPlayer);
    }
    
    @Test
    public void searchGivesCorrectPlayerTeam() {
        String playerTeam = stats.search("Kurri").getTeam();
        // should return EDM
        assertEquals(playerTeam, "EDM");
    }
    
    @Test
    public void searchGivesNullIfNotFound() {
        Player player = stats.search("NoPlayer");
        // should return null
        assertEquals(null, player);
    }
    
}
