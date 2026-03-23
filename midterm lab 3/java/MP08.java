import java.io.*;
import java.util.*;

// MP08 - Filter records using a keyword
public class MP08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Ask user for file path
            System.out.print("Enter CSV file path: ");
            String filePath = scanner.nextLine();

            // Ask for keyword
            System.out.print("Enter keyword to filter: ");
            String keyword = scanner.nextLine().toLowerCase();

            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            int count = 0;

            System.out.println("\nFiltered Records:");

            // Read CSV line by line
            while ((line = br.readLine()) != null) {
                // Check if line contains keyword
                if (line.toLowerCase().contains(keyword)) {
                    System.out.println(line);
                    count++;
                }
            }

            System.out.println("\nTotal matched records: " + count);
            br.close();

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}