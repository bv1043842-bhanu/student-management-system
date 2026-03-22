import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    double marks;

    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
}

public class StudentManagementSystem {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student (by ID)");
            System.out.println("4. Search Student (by Name)");
            System.out.println("5. Update Student");
            System.out.println("6. Delete Student");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter a number.");
                sc.next();
                continue;
            }

            int choice = sc.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: searchById(); break;
                case 4: searchByName(); break;
                case 5: updateStudent(); break;
                case 6: deleteStudent(); break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    static boolean isIdExists(int id) {
        for (Student s : students) {
            if (s.id == id) return true;
        }
        return false;
    }

    static void addStudent() {
        System.out.print("Enter ID: ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid ID!");
            sc.next();
            return;
        }

        int id = sc.nextInt();
        sc.nextLine();

        if (isIdExists(id)) {
            System.out.println("ID already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Marks: ");
        if (!sc.hasNextDouble()) {
            System.out.println("Invalid marks!");
            sc.next();
            return;
        }

        double marks = sc.nextDouble();

        students.add(new Student(id, name, marks));
        System.out.println("Student added successfully!");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\nID\tName\tMarks");
        for (Student s : students) {
            System.out.println(s.id + "\t" + s.name + "\t" + s.marks);
        }
    }

    static void searchById() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.id == id) {
                System.out.println("Found: " + s.name + " - " + s.marks);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    static void searchByName() {
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        boolean found = false;
        for (Student s : students) {
            if (s.name.equalsIgnoreCase(name)) {
                System.out.println("ID: " + s.id + ", Marks: " + s.marks);
                found = true;
            }
        }

        if (!found) System.out.println("Student not found.");
    }

    static void updateStudent() {
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {
            if (s.id == id) {
                System.out.print("Enter new name: ");
                s.name = sc.nextLine();

                System.out.print("Enter new marks: ");
                s.marks = sc.nextDouble();

                System.out.println("Student updated!");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    static void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.id == id) {
                students.remove(s);
                System.out.println("Student deleted.");
                return;
            }
        }

        System.out.println("Student not found.");
    }
}