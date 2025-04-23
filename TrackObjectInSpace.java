import java.util.Scanner;

/**
 * Menu for Track Object in Space in Scientist menu
 * @author Christin Moreno
 * @version 1.0
 */
public abstract class TrackObjectInSpace {

    /**
     * Menu
     */
    public static void toisMenu(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("-------- Track Objects in Space Menu -------");
            System.out.println("1. Rocket Body ");
            System.out.println("2. Debris ");
            System.out.println("3. Payload ");
            System.out.println("4. Unknown \n");
            System.out.println("5. Back");
            System.out.println("Please pick a number option.");
            choice = scanner.nextInt();

            switch(choice){
                case 1:
                    break;
                case 2:
                    //Debris.printDebrisData(debrisArray);
                    break;
                case 3:
                    break;
                case 4:
                    //Unknown.printUnknownList(unknownArr);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again. \n");
            } 
        }while(choice != 5);

    }
}
