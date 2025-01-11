import java.io.*;
import java.nio.file.*;

public class FileCopyWithHyphens {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";

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
            System.out.println("Plik został skopiowany z zamienionymi spacjami na myślniki.");
        } catch (IOException e) {
            System.err.println("Wystąpił błąd przy kopiowaniu pliku: " + e.getMessage());
        }
    }
}
