/*
Name-> Bhoomika Kapde
PRN-> 23070126025
Branch-> AIML A1
*/

package Assignment_8;


import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        int choice;

        do{
            System.out.println("\n===== Student Data Entry Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search by PRN");
            System.out.println("4. Search by Name");
            System.out.println("5. Search by Position");
            System.out.println("6. Update Student");
            System.out.println("7. Delete Student");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            try{
                switch(choice){
                    case 1 -> manager.addStudent(sc);
                    case 2 -> manager.displayStudents();
                    case 3 -> manager.searchByPRN(sc);
                    case 4 -> manager.searchByName(sc);
                    case 5 -> manager.searchByPosition(sc);
                    case 6 -> manager.updateStudent(sc);
                    case 7 -> manager.deleteStudent(sc);
                    case 8 -> System.out.println("Exiting program.");
                    default -> System.out.println("Invalid choice! Please try again.");
                }

            } catch (InvalidDataException | StudentNotFoundException e){
                System.out.println("Error: " + e.getMessage());
            }

        } while(choice != 8);

        sc.close();
    }
}
