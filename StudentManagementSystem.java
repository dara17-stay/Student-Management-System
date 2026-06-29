import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n====================================");
            System.out.println("     STUDENT MANAGEMENT SYSTEM");
            System.out.println("====================================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Best Student");
            System.out.println("7. Exit");
            System.out.print("Enter Choice: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    bestStudent();
                    break;

                case 7:
                    System.out.println("Thank you for using the system.");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 7);
    }

    // Add Student
    public static void addStudent() {

        System.out.print("Enter Matric Number: ");
        String matric = input.nextLine();

        System.out.print("Enter Name: ");
        String name = input.nextLine();

        System.out.print("Enter Department: ");
        String dept = input.nextLine();

        System.out.print("Enter Level: ");
        int level = input.nextInt();

        System.out.print("Enter GPA: ");
        double gpa = input.nextDouble();
        input.nextLine();

        Student student = new Student(matric, name, dept, level, gpa);
        students.add(student);

        System.out.println("Student Added Successfully!");
    }

    // View Students
    public static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        for (Student s : students) {
            System.out.println(s);
        }
    }

    // Search Student
    public static void searchStudent() {

        System.out.print("Enter Matric Number: ");
        String matric = input.nextLine();

        for (Student s : students) {

            if (s.getMatricNo().equalsIgnoreCase(matric)) {

                System.out.println("Student Found:");
                System.out.println(s);
                return;
            }
        }

        System.out.println("Student Not Found.");
    }

    // Update Student
    public static void updateStudent() {

        System.out.print("Enter Matric Number: ");
        String matric = input.nextLine();

        for (Student s : students) {

            if (s.getMatricNo().equalsIgnoreCase(matric)) {

                System.out.print("New Name: ");
                s.setName(input.nextLine());

                System.out.print("New Department: ");
                s.setDepartment(input.nextLine());

                System.out.print("New Level: ");
                s.setLevel(input.nextInt());

                System.out.print("New GPA: ");
                s.setGpa(input.nextDouble());

                input.nextLine();

                System.out.println("Student Updated Successfully!");
                return;
            }
        }

        System.out.println("Student Not Found.");
    }

    // Delete Student
    public static void deleteStudent() {

        System.out.print("Enter Matric Number: ");
        String matric = input.nextLine();

        for (Student s : students) {

            if (s.getMatricNo().equalsIgnoreCase(matric)) {

                students.remove(s);
                System.out.println("Student Deleted Successfully!");
                return;
            }
        }

        System.out.println("Student Not Found.");
    }

    // Best Student (Unique Feature)
    public static void bestStudent() {

        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        Student best = students.get(0);

        for (Student s : students) {

            if (s.getGpa() > best.getGpa()) {
                best = s;
            }
        }

        System.out.println("\n===== BEST STUDENT =====");
        System.out.println(best);
    }
}