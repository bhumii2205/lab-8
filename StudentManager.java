package Assignment_8;

import java.util.*;

public class StudentManager 
{
    private final ArrayList<Student> students = new ArrayList<>();

    //Add new student
    public void addStudent(Scanner sc) throws InvalidDataException 
    {
        System.out.print("Enter PRN: ");
        String prn = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter DoB: ");
        String dob = sc.nextLine();
        System.out.print("Enter Marks: ");
        float marks = sc.nextFloat();
        sc.nextLine();

        if(prn.isEmpty() || name.isEmpty() || marks < 0 || marks > 100) {
            throw new InvalidDataException("Invalid data provided for student.");
        }

        students.add(new Student(prn, name, dob, marks));
        System.out.println("Student added successfully.");
    }

    //Display all students
    public void displayStudents() 
    {
        if(students.isEmpty()) {
            System.out.println("No students to display.");
        } 
        
        else 
        {
            for(Student s : students) {
                s.display();
            }
        }
    }

    //Search by PRN
    public void searchByPRN(Scanner sc) throws StudentNotFoundException 
    {
        System.out.print("Enter PRN to search: ");
        String prn = sc.nextLine();

        for(Student s : students) 
        {
            if(s.getPrn().equalsIgnoreCase(prn)){
                s.display();
                return;
            }
        }

        throw new StudentNotFoundException("No student found with PRN: " + prn);
    }

    //Search by Name
    public void searchByName(Scanner sc) throws StudentNotFoundException 
    {
        System.out.print("Enter name to search: ");
        String name = sc.nextLine();
        boolean found = false;

        for(Student s : students) 
        {
            if(s.getName().equalsIgnoreCase(name)) {
                s.display();
                found = true;
            }
        }

        if(!found) throw new StudentNotFoundException("No student found with name: " + name);
    }

    //Search by position
    public void searchByPosition(Scanner sc) throws StudentNotFoundException 
    {
        System.out.print("Enter position(0 to " +(students.size() - 1) + "): ");
        int pos = sc.nextInt();
        sc.nextLine();

        if(pos < 0 || pos >= students.size()) {
            throw new StudentNotFoundException("Invalid position entered.");
        }

        students.get(pos).display();
    }

    //Update student
    public void updateStudent(Scanner sc) throws StudentNotFoundException, InvalidDataException 
    {
        System.out.print("Enter PRN of student to update: ");
        String prn = sc.nextLine();

        for(Student s : students) 
        {
            if(s.getPrn().equalsIgnoreCase(prn)) 
            {
                System.out.print("Enter new name: ");
                String name = sc.nextLine();
                System.out.print("Enter new DoB: ");
                String dob = sc.nextLine();
                System.out.print("Enter new marks: ");
                float marks = sc.nextFloat();
                sc.nextLine();

                if(name.isEmpty() || marks < 0 || marks > 100) {
                    throw new InvalidDataException("Invalid updated data.");
                }

                s.setName(name);
                s.setDob(dob);
                s.setMarks(marks);
                System.out.println("Student updated successfully.");
                return;
            }
        }

        throw new StudentNotFoundException("Student with PRN " + prn + " not found.");
    }

    //Delete student
    public void deleteStudent(Scanner sc) throws StudentNotFoundException 
    {
        System.out.print("Enter PRN of student to delete: ");
        String prn = sc.nextLine();

        Iterator<Student> iterator = students.iterator();

        while(iterator.hasNext()) 
        {
            Student s = iterator.next();
            
            if(s.getPrn().equalsIgnoreCase(prn)){
                iterator.remove();
                System.out.println("Student deleted successfully.");
                return;
            }
        }

        throw new StudentNotFoundException("Student with PRN " + prn + " not found.");
    }
}
