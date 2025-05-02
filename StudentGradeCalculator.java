import java.io.*;
import java.util.*;

public class StudentGradeCalculator {

    public static double calculateAverageGrade(String filename) {
        double total = 0;
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    int grade = Integer.parseInt(parts[1]);
                    total += grade;
                    count++;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return count > 0 ? total / count : 0;
    }

    public static void printStudentGrades(String filename) {
        System.out.println("Student Grades:");

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    System.out.println(parts[0] + ": " + parts[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filename = "grades.txt";
        printStudentGrades(filename);
        double average = calculateAverageGrade(filename);
        System.out.printf("\nAverage Grade: %.2f\n", average);
    }

    @Override
    public String toString() {
        return "StudentGradeCalculator []";
    }
}
