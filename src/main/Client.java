package main;

import bridges.connect.Bridges;
import bridges.validation.RateLimitException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Client {

  private MyList<TwitchGame> games;
  private Bridges bridges;

  public Client() throws FileNotFoundException {
    games = new MyList<>();
    bridges = new Bridges(0, "ytaha093", "1128242610761");
    bridges.setTitle("Games played on Twitch");
    bridges.setDescription(
        "PURPLE = High viewer:streamer ratio, "
            + "RED = Med viewer:streamer ratio, "
            + "BLUE = Low viewer:streamer ratio, "
            + "BIGGER is higher rank and SMALER is lower rank.");
  }

  public void visualize() throws IOException, RateLimitException {
    bridges.setDataStructure(games.getHead());
    bridges.visualize();
  }

  public void searchRank(int search) {
    games.search(new TwitchGame("", search, 0, 0));
  }

  public void addGames(int amount) throws FileNotFoundException {
    Scanner scanner = new Scanner(new File("dataset/Twitch_game_data.csv"));
    scanner.useDelimiter(",");
    scanner.tokens();
    for (int i = 0; i < amount; i++) {
      scanner.nextLine();
      String name = scanner.next();
      int rank = scanner.nextInt();
      scanner.next();
      scanner.next();
      int hoursWatched = scanner.nextInt();
      double avgViewerRatio = scanner.nextDouble();
      games.add(new TwitchGame(name, rank, hoursWatched, avgViewerRatio));
    }
    scanner.close();
  }
}
