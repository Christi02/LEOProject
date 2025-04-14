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
                    //scientistMenu();
                    scientist.userMenu();
                    break;
                case "Space Agency Representative":
                    //spaceAgencyRepMenu();
                    sap.userMenu();
                    break;
                case "Policymaker":
                    //policyMakerMenu();
                    policymaker.userMenu();
                    break;
                case "Administrator":
                    //administratorMenu();
                    break;
                case "EXIT":
                    System.exit(0); //no errors, program ends
                    break;
                default:
                    System.out.println("Invalid choice. Please try again. \n");
            }
        } while(!choice.equals("EXIT"));
    }
    /**
     * Menu for Scientists. 
     */
    // public static void scientistMenu(){
    //     int choice;
    //     do {
    //         System.out.println("-------- Scientist's Menu -------");
    //         System.out.println("1. Track Object in Space");
    //         System.out.println("2. Assess Orbit Status");
    //         System.out.println("3. Back to main menu \n");
    //         System.out.println("Please pick a number option.");
    //         choice = scanner.nextInt();

    //         switch(choice){
    //             case 1:
    //                 break;
    //             case 2:
    //                 break;
    //             case 3:
    //                 System.out.println("Going back to the main menu. \n");
    //                 userMenu(); //sends back to main menu
    //                 break;
    //             default:
    //                 System.out.println("Invalid choice. Please try again. \n");
    //         }

    //     } while(choice != 3);
    // }
    // /**
    //  * Menu for Representatives.
    //  */
    // public static void spaceAgencyRepMenu(){
    //     int choice;
    //     do {
    //         System.out.println("-------- Space Agency Representative's Menu -------");
    //         System.out.println("1. Analyze Long-term Immpact");
    //         System.out.println("2. Generate Density Reports");
    //         System.out.println("3. Back to main menu \n");
    //         System.out.println("Please pick a number option.");
    //         choice = scanner.nextInt();

    //         switch(choice){
    //             case 1:
    //                 break;
    //             case 2:
    //                 break;
    //             case 3:
    //                 System.out.println("Going back to the main menu. \n");
    //                 userMenu(); //sends back to main menu
    //                 break;
    //             default:
    //                 System.out.println("Invalid choice. Please try again. \n");
    //         }

    //     } while(choice != 3);
    // }
    // /**
    //  * Menu for Policymakers.
    //  */
    // public static void policyMakerMenu(){
    //     int choice;
    //     do {
    //         System.out.println("-------- Policymaker's Menu -------");
    //         System.out.println("1. Review Reports on Debris Impact");
    //         System.out.println("2. Assess Risk Levels for Future Space Missions");
    //         System.out.println("3. Back to main menu \n");
    //         System.out.println("Please pick a number option.");
    //         choice = scanner.nextInt();

    //         switch(choice){
    //             case 1:
    //                 break;
    //             case 2:
    //                 break;
    //             case 3:
    //                 System.out.println("Going back to the main menu. \n");
    //                 userMenu(); //sends back to main menu
    //                 break;
    //             default:
    //                 System.out.println("Invalid choice. Please try again. \n");
    //         }

    //     } while(choice != 3);
    // }
    // /**
    //  * Menu for Administrators.
    //  */
    // public static void administratorMenu(){
    //     int choice;
    //     do {
    //         System.out.println("-------- Administrator's Menu -------");
    //         System.out.println("1. Create User");
    //         System.out.println("2. Manage User");
    //         System.out.println("3. Delete User");
    //         System.out.println("4. Back to main menu \n");
    //         System.out.println("Please pick a number option.");
    //         choice = scanner.nextInt();

    //         switch(choice){
    //             case 1:
    //                 break;
    //             case 2:
    //                 break;
    //             case 3:
    //                 break;
    //             case 4:
    //                 System.out.println("Going back to the main menu. \n");
    //                 userMenu(); //sends back to main menu 
    //                 break;
    //             default:
    //                 System.out.println("Invalid choice. Please try again. \n");
    //         }

    //     } while(choice != 4);
    // }
}
