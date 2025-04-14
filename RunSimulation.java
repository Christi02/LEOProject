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
        mainMenu();
    }
    /**
     * Main menu of the system where the current user is selected. 
     * If there is no user selected then the system will exit. 
     * 
     */
    public static void mainMenu(){
        String choice;
        Scientist scientist = new Scientist("Scientist");
        SpaceAgencyRepresentative sap = new SpaceAgencyRepresentative("Space Agency Representative");
        Policymaker policymaker = new Policymaker("Policymaker");
        Administrator administrator = new Administrator("Administrator");

        do{ 
            System.out.println("-------- Welcome -------");
            System.out.println("Scientist");
            System.out.println("Space Agency Representative");
            System.out.println("Policymaker");
            System.out.println("Administrator");
            System.out.println("EXIT \n");
            System.out.println("Please pick a user or type EXIT.");
            choice = scanner.nextLine();
            System.out.println();

            switch(choice){
                case "Scientist":
                    scientist.userMenu();
                    break;
                case "Space Agency Representative":
                    sap.userMenu();
                    break;
                case "Policymaker":
                    policymaker.userMenu();
                    break;
                case "Administrator":
                    administrator.userMenu();
                    break;
                case "EXIT":
                    System.exit(0); //no errors, program ends
                    break;
                default:
                    System.out.println("Invalid choice. Please try again. \n");
            }
        } while(!choice.equals("EXIT"));
    }
    
}
