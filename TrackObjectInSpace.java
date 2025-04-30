import java.util.Scanner;

/**
 * Menu for Track Object in Space in Scientist menu
 * @author Christin Moreno
 * @author Joseth Sanjay Valdez
 * @version 1.0
 */
public abstract class TrackObjectInSpace {

    /**
     * Menu
     */
    public static void toisMenu(Debris[] debrisArray, UnknownTypeObject[] objects, RocketBody[] rocketBodyArray, Payload[] payloadArray){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("-------- Track Objects in Space Menu -------");
            System.out.println("1. Rocket Body ");
            System.out.println("2. Debris ");
            System.out.println("3. Payload ");
            System.out.println("4. Unknown");
            System.out.println("5. Back \n");
            System.out.println("Please pick a number option.");
            choice = scanner.nextInt();

            switch(choice){
                case 1:
                    RocketBody.printRocketBodyData(rocketBodyArray);
                    break;
                case 2:
                    Debris.printDebrisData(debrisArray);
                    break;
                case 3:
                    Payload.printPayloadData(payloadArray);
                    break;
                case 4:
                    UnknownTypeObject.printUnknownObjectsData(objects);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again. \n");
            } 
        }while(choice != 5);

    }
}
