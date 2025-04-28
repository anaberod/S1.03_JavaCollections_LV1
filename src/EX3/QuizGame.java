package EX3;

import java.text.Normalizer;
import java.util.*;

import static java.text.Normalizer.normalize;

public class QuizGame {

    private static final String COUNTRIES_FILE = "countries.txt";
    private static final String SCORES_FILE = "scores.txt";
    private HashMap<String, String> countriesCapitals;
    private Scanner scanner;
    private FileManager fileManager;


    private String normalize(String input) {
        input = input.toLowerCase();
        input = Normalizer.normalize(input, Normalizer.Form.NFD);
        input = input.replaceAll("\\p{M}", "");
        input = input.replace("_", " ");
        input = input.replaceAll("\\s+", " ").trim();
        return input;
    }


    public QuizGame() {
        fileManager = new FileManager();
        countriesCapitals = fileManager.loadCountries(COUNTRIES_FILE);
        scanner = new Scanner(System.in);

    }

    public void start() {
        System.out.print("Enter your name: ");
        String username = scanner.nextLine();
        int score = 0;

        if (countriesCapitals.isEmpty()) {
            System.out.println("No countries loaded. Please check 'countries.txt'.");
            return;

        }
        List<String> countries = new ArrayList<>(countriesCapitals.keySet());
        Collections.shuffle(countries);


        System.out.println("\n--- Starting the Quiz! ---\n");

        for (int i = 0; i < 10; i++) {
            String randomCountry = countries.get(i);
            System.out.printf("What's the capital of %s?: ", randomCountry);
            String userAnswer = scanner.nextLine().trim();


            String correctCapital = countriesCapitals.get(randomCountry);


            if (normalize(userAnswer).equals(normalize(correctCapital))) {
                score++;
                System.out.println("Correct!\n");
            } else {
                System.out.printf("Wrong, the correct answer is %s.\n\n", correctCapital.replace(" ", "_"));
            }
        }


        fileManager.saveScore(SCORES_FILE, username, score);
        System.out.printf("Game finished! Your score (%d) has been saved in '%s'.\n", score, SCORES_FILE);

        scanner.close();


    }
}
