import java.util.Arrays;
public class code_along {

    public static void main(String[] args) {

        // create an array
        String[] students;

        // initialize size, assign values later
        students = new String[5];

        // initialize literal values
        students[0] = "Jerry";
        students[1] = "Elaine";
        students[2] = "George";
        students[3] = "Kramer";
        students[4] = "Newman";

        double[] grades = {88.5, 97.8, 92.2, 78.7, 80.1};


//        // accessing arrays
        System.out.println("3rd student = " + students[2]);
        System.out.println("Last student = " + students[students.length - 1]);
//        System.out.println(Arrays.toString(students));

        // looping over arrays
        // print list of students and their grades
        for(int i = 0; i < students.length; i++){
            System.out.println("Student [" + i + "] = " + students[i] + ", grade = " + grades[i]);
        }

        // average grade
        // Initialize varaible to hold average grade
        double sum = 0.0;
        // Use for loop to iterate over each grade in array and return average grade of all students
        for(int i = 0; i < grades.length; i++){
            sum += grades[i];

        }
        System.out.println("Average grade is: " + (sum / grades.length));

    }
}
