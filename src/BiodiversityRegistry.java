import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class BiodiversityRegistry {
    public static void main(String[] args) {

        HashMap<String, Integer> species = new HashMap<>();

        // Add 5 starting species
        species.put("Deer", 45);
        species.put("Fox", 20);
        species.put("Rabbit", 60);
        species.put("Eagle", 12);
        species.put("Bear", 8);

        // Read the sightings file
        try {
            Scanner fileScanner = new Scanner(new File("sightings.txt"));

            while (fileScanner.hasNextLine()) {
                String name = fileScanner.nextLine().trim();

                if (name.isEmpty()) {
                    continue;
                }

                if (species.containsKey(name)) {
                    species.put(name, species.get(name) + 1);
                } else {
                    species.put(name, 1);
                }
            }

            fileScanner.close();

            // Display all species
            System.out.println("Updated Species Populations:");

            for (String name : species.keySet()) {
                System.out.println(name + ": " + species.get(name));
            }

        } catch (FileNotFoundException e) {
            System.out.println("Could not find sightings.txt");
        }
    }
}
