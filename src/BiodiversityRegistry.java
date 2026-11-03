import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class BiodiversityRegistry {
    public static void main(String[] args) {

        HashMap<String, Integer> species = new HashMap<>();

        species.put("Deer", 45);
        species.put("Fox", 20);
        species.put("Rabbit", 60);
        species.put("Eagle", 12);
        species.put("Bear", 8);

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

            // Display populations
            System.out.println("Species Populations:");

            for (String name : species.keySet()) {
                System.out.println(name + ": " + species.get(name));
            }

            // Find highest and lowest populations
            if (!species.isEmpty()) {

                String mostFrequent = "";
                String leastFrequent = "";

                int maxCount = Integer.MIN_VALUE;
                int minCount = Integer.MAX_VALUE;

                for (String name : species.keySet()) {
                    int count = species.get(name);

                    if (count > maxCount) {
                        maxCount = count;
                        mostFrequent = name;
                    }

                    if (count < minCount) {
                        minCount = count;
                        leastFrequent = name;
                    }
                }

                System.out.println("\nMost Frequent Species: "
                        + mostFrequent + " ( " + maxCount + ")");

                System.out.println("Least Frequent Species: "

                        + leastFrequent + " (" + minCount + ")");

            }

        } catch (FileNotFoundException e) {

            System.out.println("Could not find sightings.txt");

        }

    }

}
