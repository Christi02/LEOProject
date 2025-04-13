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
    /**
     * Main menu of the system where the current user is selected. If there is no
     * user selected then the system will exit. 
     */
    public static void userMenu(){
        int choice;
        do { 
            System.out.println("-------- Welcome -------");
            System.out.println("1. Scientist");
            System.out.println("2. Space Agency Representative");
            System.out.println("3. Policymaker");
            System.out.println("4. Administrator");
            System.out.println("5. Exit\n");
            System.out.println("Please pick a user.");
            choice = scanner.nextInt();
            
            switch(choice){
                case 1:
                    scientistMenu();
                    break;
                case 2:
                    spaceAgencyRepMenu();
                    break;
                case 3:
                    policyMakerMenu();
                    break;
                case 4:
                    administratorMenu();
                    break;
                case 5:
                    System.out.println("Exiting the system. Thank you!\n");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        } while (choice != 5);
    }
    public static void scientistMenu(){
        int choice;
        do {
            System.out.println("-------- Scientist Menu -------");
            System.out.println("1. Track Object in Space");
            System.out.println("2. Assess Orbit Status");
            System.out.println("3. Back to main menu \n");
            System.out.println("Please pick an option.");
            choice = scanner.nextInt();

            switch(choice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("Going back to the main menu. \n");
                    userMenu();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again. \n");
            }

        } while(choice != 3);
    }
    public static void spaceAgencyRepMenu(){
        int choice;
        do {
            System.out.println("-------- Space Agency Representative Menu -------");
            System.out.println("1. Analyze Long-term Immpact");
            System.out.println("2. Generate Density Reports");
            System.out.println("3. Back to main menu \n");
            System.out.println("Please pick an option.");
            choice = scanner.nextInt();

            switch(choice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("Going back to the main menu. \n");
                    userMenu();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again. \n");
            }

        } while(choice != 3);
    }
    public static void policyMakerMenu(){
        int choice;
        do {
            System.out.println("-------- Policymaker Menu -------");
            System.out.println("1. Review Reports on Debris Impact");
            System.out.println("2. Assess Risk Levels for Future Space Missions");
            System.out.println("3. Back to main menu \n");
            System.out.println("Please pick an option.");
            choice = scanner.nextInt();

            switch(choice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("Going back to the main menu. \n");
                    userMenu();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again. \n");
            }

        } while(choice != 3);
    }
    public static void administratorMenu(){
        int choice;
        do {
            System.out.println("-------- Administrator Menu -------");
            System.out.println("1. Create User");
            System.out.println("2. Manage User");
            System.out.println("3. Delete User");
            System.out.println("4. Back to main menu \n");
            System.out.println("Please pick an option.");
            choice = scanner.nextInt();

            switch(choice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Going back to the main menu. \n");
                    userMenu();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again. \n");
            }

        } while(choice != 4);
    }
}
