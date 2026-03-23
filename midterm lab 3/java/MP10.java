import java.io.*;
import java.util.*;

// MP10 - Detect duplicate records
public class MP10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter CSV file path: ");
            String filePath = scanner.nextLine();

            BufferedReader br = new BufferedReader(new FileReader(filePath));

            HashSet<String> unique = new HashSet<>();
            HashSet<String> duplicates = new HashSet<>();

            String line;

            // Read each row
            while ((line = br.readLine()) != null) {
                if (!unique.add(line)) {
                    duplicates.add(line); // already exists
                }
            }

            br.close();

            System.out.println("\nDuplicate Records:");
            if (duplicates.isEmpty()) {
                System.out.println("No duplicates found.");
            } else {
                for (String dup : duplicates) {
                    System.out.println(dup);
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}