package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import org.apache.http.client.fluent.Request;

public class Main {
    public static void main(String[] args) throws IOException {
    String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
        Date dateNow = new Date();
        System.out.println("Players from FIN " + dateNow);

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        
        ArrayList<Player> filteredPlayers = new ArrayList<>();
        
        for (Player player : players) {
            if (player.getNationality().equals("FIN")) {
                filteredPlayers.add(player);
            }
        }
        Collections.sort(filteredPlayers);
        for (Player player : filteredPlayers) {
            System.out.println(player);
        }
        
    }
}
