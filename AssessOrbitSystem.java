import java.util.Scanner;
/**
 * Menu for Assess ORbit System in Scientist menu
 * @author Christin Moreno
 * @author Joseth Sanjay Valdez
 * @version 1.0
 */
public abstract class AssessOrbitSystem {
    static String oldRSOFile = "rso_metrics.csv";
    static String newRSOFile = "new_rso_metrics.csv";

    /**
     * Menu for assess orbit system
     * @param trackObjectsInLEOarray
     */
    public static void aosMenu(TrackObjectsInLEO[] trackObjectsInLEOarray){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("-------- Assess Orbit System Menu -------");
            System.out.println("1. Track Objects in LEO ");
            System.out.println("2. If debris is still in Orbit ");
            System.out.println("3. Back to main menu");
            System.out.println("Please pick a number option.");
            choice = scanner.nextInt();

            switch(choice){
                case 1:
                    TrackObjectsInLEO.printLEOList(trackObjectsInLEOarray);
                    break;
                case 2:
                    NewCSV.main(null);
                    break;
                case 3: 
                    RunSimulation.mainMenu();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again. \n");
            } 
        }while(choice != 3);

    }
}
