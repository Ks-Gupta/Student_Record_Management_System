package Student_Record_Management_System;

import java.util.*;

class Student{
    private int id;
    private String name;
    private int marks;
    public Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getMarks(){
        return marks;
    }

    
    public void setName(String name) { 
        this.name = name; 
    }
    public void setMarks(int marks) { 
        this.marks = marks; 
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Marks: " + marks;
    }


}

public class Student_Management {
    private static List<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Student Record Management System 
        int choice;

        do {
            System.out.println("\n=== Student Record Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);
    

    }

    private static void addStudent() {
        // Code to add a student
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student marks: ");
        int marks = scanner.nextInt();

        Student student = new Student(id, name, marks);
        // Add student to the system (e.g., to a list or database)
        students.add(student);
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found!");
        } else {
            System.out.println("\n--- Student Records ---");
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    private static void updateStudent() {
        // Code to update a student
        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        for (Student s : students) {
            if (s.getId() == id) {
                System.out.print("Enter new name: ");
                String name = scanner.nextLine();
                System.out.print("Enter new marks: ");
                int marks = scanner.nextInt();

                s.setName(name);
                s.setMarks(marks);
                System.out.println("Student record updated.");
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    private static void deleteStudent() {
        // Code to delete a student
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();

        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student s = iterator.next();
            if (s.getId() == id) {
                iterator.remove();
                System.out.println("Student record deleted.");
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }   
}
