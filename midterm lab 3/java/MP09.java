import java.io.*;
import java.util.*;

// MP09 - Display dataset statistics
public class MP09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter CSV file path: ");
            String filePath = scanner.nextLine();

            BufferedReader br = new BufferedReader(new FileReader(filePath));

            String line;
            int rowCount = 0;
            int columnCount = 0;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                
                // Count columns (only once)
                if (rowCount == 0) {
                    columnCount = data.length;
                }

                rowCount++;
            }

            br.close();

            // Display stats
            System.out.println("\nDataset Statistics:");
            System.out.println("Total Rows: " + rowCount);
            System.out.println("Total Columns: " + columnCount);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}