import java.util.Scanner;
public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of subjects: ");
        int numSubject = scanner.nextInt();
        int[] marks = new int[numSubject];
        for (int i = 0; i < numSubject; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }

        
        double avgPercentage = (double) totalMarks / numSubject;

    
        char grade;
        if (avgPercentage >= 90) {
            grade = 'A';
        } else if (avgPercentage >= 80) {
            grade = 'B';
        } else if (avgPercentage >= 70) {
            grade = 'C';
        } else if (avgPercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }


        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + avgPercentage);
        System.out.println("Grade: " + grade);

        
        scanner.close();
    }
}
