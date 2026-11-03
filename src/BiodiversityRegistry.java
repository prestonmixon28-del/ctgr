import java.util.HashMap;
import java.util.Scanner;

public class BiodiversityRegistry {
    public static void main(String[] args) {

        // Create the HashMap
        HashMap<String, Integer> species = new HashMap<>();

        // Add 5 species
        species.put("Deer", 45);
        species.put("Fox", 20);
        species.put("Rabbit", 60);
        species.put("Eagle", 12);
        species.put("Bear", 8);

        // Ask the user for a species
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a species name: ");
        String name = scanner.nextLine();

        // Look up the population
        Integer population = species.get(name);

        if (population != null) {
            System.out.println(name + " population: " + population);
        } else {
            System.out.println(name + " is not currently in the registry.");
        }

        scanner.close();
    }
}
