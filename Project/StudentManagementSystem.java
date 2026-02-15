import java.util.ArrayList;
import java.util.Scanner;

// Student class to store student details
class Student {
    private int id;
    private String name;
    private int age;
    private String course;

    public Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void displayStudent() {
        System.out.println("ID: " + id + " | Name: " + name + " | Age: " + age + " | Course: " + course);
    }
}

// Student Management System
public class StudentManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Remove Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    removeStudent();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // Method to add a new student
    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Course: ");
        String course = scanner.nextLine();

        students.add(new Student(id, name, age, course));
        System.out.println("Student added successfully!");
    }

    // Method to display all students
    private static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            System.out.println("\nList of Students:");
            for (Student student : students) {
                student.displayStudent();
            }
        }
    }

    // Method to remove a student by ID
    private static void removeStudent() {
        System.out.print("Enter Student ID to remove: ");
        int id = scanner.nextInt();

        boolean found = false;
        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                System.out.println("Student removed successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found!");
        }
    }
}