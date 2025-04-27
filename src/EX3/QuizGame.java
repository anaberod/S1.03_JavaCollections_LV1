package EX3;

import java.text.Normalizer;
import java.util.*;

import static java.text.Normalizer.normalize;

public class QuizGame {

    private static final String COUNTRIES_FILE = "countries.txt"; // Archivo de países y capitales
    private static final String SCORES_FILE = "scores.txt";       // Archivo donde guardamos puntuaciones
    private HashMap<String, String> countriesCapitals;            // Donde guardamos los datos leídos
    private Scanner scanner;                                      // Para leer la respuesta del usuario
    private FileManager fileManager;                              // Para usar los métodos de FileManager

    // 🔵 Método para normalizar entradas de usuario y capitales
    private String normalize(String input) {
        input = input.toLowerCase(); // Poner todo en minúsculas
        input = Normalizer.normalize(input, Normalizer.Form.NFD); // Separar caracteres especiales
        input = input.replaceAll("\\p{M}", ""); // Quitar tildes
        input = input.replace("_", " "); // Cambiar guiones bajos por espacios
        input = input.replaceAll("\\s+", " ").trim(); // Eliminar espacios extra
        return input;
    }

    //constructor
    public QuizGame() {
        fileManager = new FileManager();
        countriesCapitals = fileManager.loadCountries(COUNTRIES_FILE);
        scanner = new Scanner(System.in);

    }
    // Método que inicia el juego
    public void start() {
        System.out.print("Enter your name: ");
        String username = scanner.nextLine();
        int score = 0;

        if (countriesCapitals.isEmpty()) {
            System.out.println("No countries loaded. Please check 'countries.txt'.");
            return;

        }
        List<String> countries = new ArrayList<>(countriesCapitals.keySet()); // Lista de países
        Collections.shuffle(countries); // Mezclamos los países para que salgan random y no se repitan


        System.out.println("\n--- Starting the Quiz! ---\n");

        for (int i = 0; i < 10; i++) {
            String randomCountry = countries.get(i);
            System.out.printf("What's the capital of %s?: ", randomCountry);
            String userAnswer = scanner.nextLine().trim();

            // Aquí convertimos los underscores _ en espacios en la capital correcta
            String correctCapital = countriesCapitals.get(randomCountry);

            // Comprobamos si la respuesta del usuario es correcta
            if (normalize(userAnswer).equals(normalize(correctCapital))) {
                score++;
                System.out.println("Correct!\n");
            } else {
                System.out.printf("Wrong, the correct answer is %s.\n\n", correctCapital.replace(" ","_"));
            }
        }

        // Guardamos la puntuación en el archivo
        fileManager.saveScore(SCORES_FILE, username, score);
        System.out.printf("Game finished! Your score (%d) has been saved in '%s'.\n", score, SCORES_FILE);

        scanner.close(); // Cerramos el lector de teclado




        }
    }
