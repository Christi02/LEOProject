import java.util.Scanner;

/**
 * Date: April 2025
 * Course: CS 3331 CRN 21024
 * Instructor: Dr. Bhanukiran Gurijala
 * Project Part 1
 * Description: 
 * 
 * Honesty Statement: Both Joseth and Christin have worked on this project
 * entirely on our own collaboration without any outside sources including
 * peers, experts, online sources, or the like. Only recieved assistance from
 * the Dr. Gurijala, TA or IAs. 
 * 
 * 
 * @author Christin Moreno
 * @author Joseth Valdez
 * @version  1.0
 */
 


public class RunSimulation {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        userMenu();
    }
    public static void userMenu(){
        int choice;
        do { 
            System.out.println("-------- Welcome -------");
            System.out.println("1. Scientist");
            System.out.println("2. Space Agency Representative");
            System.out.println("3. Policymaker");
            System.out.println("4. Administrator");
            System.out.println("5. Exit\n");
            System.out.println("Please pick a user");
            choice = scanner.nextInt();
            
            switch(choice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Exiting the system. Thank you!\n");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        } while (choice != 5);
    }
}
