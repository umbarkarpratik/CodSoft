package CodSoft.StudentManagement;


import java.util.Scanner;

public class StudentManagementSystemUI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem studentManagementSystem = new StudentManagementSystem();

        int choice;
        do {
            System.out.println("Options:");
            System.out.println("1. Add a new student");
            System.out.println("2. Remove a student");
            System.out.println("3. Search for a student");
            System.out.println("4. Display all students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student roll number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter student grade: ");
                    String grade = scanner.nextLine();

                    Student newStudent = new Student(name, rollNumber, grade);
                    studentManagementSystem.addStudent(newStudent);
                    break;

                case 2:
                    System.out.print("Enter the roll number of the student to remove: ");
                    int rollToRemove = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    Student studentToRemove = studentManagementSystem.searchStudent(rollToRemove);
                    if (studentToRemove != null) {
                        studentManagementSystem.removeStudent(studentToRemove);
                        System.out.println("Student removed successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter the roll number of the student to search: ");
                    int rollToSearch = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    Student foundStudent = studentManagementSystem.searchStudent(rollToSearch);
                    if (foundStudent != null) {
                        System.out.println("Student found:");
                        System.out.println(foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    studentManagementSystem.displayAllStudents();
                    break;

                case 5:
                    System.out.println("Exiting the application.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
