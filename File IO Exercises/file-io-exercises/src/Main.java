import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Main {
    public static void main(String[] args) {
//        System.out.println("Working directory/Absolute Path: " + System.getProperty("user.dir"));
//        File file = new File("data/student_data.txt");
//        System.out.println("Relative Path: " + file.getPath());


//         Create and Write to File
//        PrintWriter writer = null;
//        try {
//            writer = new PrintWriter("data/student_data.txt");
////            writer.println("Alice, A");
////            writer.println("Bob, B");
////            writer.println("Charlie, A+");
//        } catch (FileNotFoundException ex) {
//            ex.printStackTrace();
////        } finally {
////            if (writer != null) {
////                writer.close();
////            }
//        }

        // Check if file exists
//        File file = new File("data/student_data.txt");
//        System.out.println(file.exists());

//        try (FileWriter fileWriter = new FileWriter("data/student_data.txt", true);
//             PrintWriter writer = new PrintWriter(fileWriter)) {
//            writer.println("David, B+");
//            writer.println("Eva, A");
//        } catch (IOException ex) {
//            ex.printStackTrace();
//            }

//        try (BufferedReader reader = new BufferedReader(new FileReader("data/student_data.txt"))) {
//            String line;
//
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//            System.out.println(e);
//        }
//    }

    Path filePath = Paths.get("data/student_data.txt");

    try {
        boolean success = Files.deleteIfExists(filePath);
        if (success) {
            System.out.println("data/student_data.txt was deleted.");
        } else {
            System.out.println("data/student_data.txt was NOT deleted");
        }
    } catch (IOException e) {
        System.out.println("An error occurred while trying to delete the file");
        e.printStackTrace();
    }
}
}









