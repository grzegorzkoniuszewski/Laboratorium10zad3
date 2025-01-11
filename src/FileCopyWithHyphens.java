import java.io.*;
import java.nio.file.*;

public class FileCopyWithHyphens {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(inputFile))) {
            writer.write("This is a test file with spaces.");
            writer.newLine();
            writer.write("This line also has spaces.");
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error creating input file: " + e.getMessage());
        }

        try (
                BufferedReader reader = Files.newBufferedReader(Paths.get(inputFile));
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFile))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                String modifiedLine = line.replace(" ", "-");
                writer.write(modifiedLine);
                writer.newLine();
            }
            System.out.println("File copied with spaces replaced by hyphens.");
        } catch (IOException e) {
            System.err.println("An error occurred while copying the file: " + e.getMessage());
        }
    }
}
