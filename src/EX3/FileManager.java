package EX3;

import java.io.*;
import java.util.HashMap;


public class FileManager {

    public HashMap<String, String> loadCountries(String filePath) {
        HashMap<String, String> countriesCapitals = new HashMap<>();

        File file = new File("src/EX3/" + filePath);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ", 2);
                if (parts.length == 2) {
                    countriesCapitals.put(parts[0].trim(), parts[1].trim());
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return countriesCapitals;
    }

    public void saveScore(String filePath, String username, int score) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write(username + ", " + score);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error saving score: " + e.getMessage());
        }
    }


}
