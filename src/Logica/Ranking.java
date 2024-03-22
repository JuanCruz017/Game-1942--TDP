package Logica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ranking {
    class Player {
        private String name;
        private int score;

        public Player(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }

        public String toString() {
            return name + " - " + score;
        }
    }

    private List<Player> players;
    private String fileName;

    public Ranking() {
        fileName = System.getProperty("user.dir")+("/Ranking.txt");
        players = new ArrayList<>(5);
        loadRanking();
    }

    public void addPlayer(String player, int puntaje) {
        Player formateado = new Player(player, puntaje);
        players.add(formateado);
        Collections.sort(players, (p1, p2) -> Integer.compare(p2.getScore(), p1.getScore()));
        while (players.size() > 5) {
            players.remove(players.size() - 1);
        }
        saveRanking();
    }

    public String jugador_rango(int rango) {
        return players.get(rango).toString();
    }

    public String nombreJugador(int row) {
        if (row >= 0 && row < players.size()) {
            return players.get(row).getName();
        }
        return null; 
    }

    public String puntajeJugador(int row) {
        if (row >= 0 && row < players.size()) {
            return String.valueOf(players.get(row).getScore());
        }
        return null; 
    }

    public void displayRanking() {
        System.out.println("Ranking:");
        for (int i = 0; i < players.size(); i++) {
            System.out.println((i + 1) + ". " + players.get(i));
        }
    }

    private void loadRanking() {
    	File file = new File(fileName);
    	try {
			if(file.createNewFile()) {
				createDummyPlayers();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    	
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" - ");
                if (parts.length == 2) {
                    String name = parts[0];
                    int score = Integer.parseInt(parts[1]);
                    Player player = new Player(name, score);
                    players.add(player);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void saveRanking() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Player player : players) {
                writer.write(player.getName() + " - " + player.getScore());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void createDummyPlayers() {
    	try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
    		for (int i = 0; i < 5; i++) {
                writer.write("Player" + i + " - " + (i * 100));  
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
