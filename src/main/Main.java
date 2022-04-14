package main;

import bridges.validation.RateLimitException;
import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException, RateLimitException {
    Client cl = new Client();
    cl.addGames(600);
    // Let the records show me and chris where able to get this to 71k before the heroku server
    // began melting

    cl.searchRank(4);
    // SEARCHES FOR AN ELEMENT BASED ON RANK, If U WaAT TO to search for something thats
    // not on there search for a negitive or masive number

    cl.visualize();
  }
}
