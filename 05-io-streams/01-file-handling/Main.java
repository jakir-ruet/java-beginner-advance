import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "example.txt";

        while (true) {
            System.out.println("\n===== FILE HANDLING MENU =====");
            System.out.println("1. Create File");
            System.out.println("2. Write to File");
            System.out.println("3. Read File");
            System.out.println("4. Delete File");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1 -> createFile(fileName);

                case 2 -> {
                    System.out.print("Enter text to write: ");
                    String text = sc.nextLine();
                    writeFile(fileName, text);
                }

                case 3 -> readFile(fileName);

                case 4 -> deleteFile(fileName);

                case 5 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }

                default -> System.out.println("Invalid choice!");
            }
        }
    }

    // Create File
    public static void createFile(String fileName) {
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("Error creating file.");
        }
    }

    // Write File
    public static void writeFile(String fileName, String content) {
        try {
            FileWriter writer = new FileWriter(fileName, true); // append mode
            writer.write(content + "\n");
            writer.close();
            System.out.println("Written to file successfully.");
        } catch (IOException e) {
            System.out.println("Error writing file.");
        }
    }

    // Read File
    @SuppressWarnings("ConvertToTryWithResources")
    public static void readFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);

            System.out.println("\n----- File Content -----");
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }

    // Delete File
    public static void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.delete()) {
            System.out.println("File deleted successfully.");
        } else {
            System.out.println("Failed to delete file.");
        }
    }
}
