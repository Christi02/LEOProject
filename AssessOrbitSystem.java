import java.util.Scanner;
/**
 * Menu for Assess ORbit System in Scientist menu
 * @author Christin Moreno
 * @version 1.0
 */
public abstract class AssessOrbitSystem {
    /**
     * Menu 
     */
    public static void aosMenu(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("-------- Assess Orbit System Menu -------");
            System.out.println("1. Track Objects in LEO ");
            System.out.println("2. If debris is still in Orbit ");
            System.out.println("Please pick a number option.");
            choice = scanner.nextInt();

            switch(choice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again. \n");
            } 
        }while(choice != 3);

    }
}
