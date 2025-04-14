public class SpaceAgencyRepresentative extends User{

    public SpaceAgencyRepresentative(String position){
        super(position);
    }
    public void subMenuChoice(){
        System.out.println("1. Analyse long-term Impact");
        System.out.println("2. Generate density reports");
    }
    public void subSwitchCases(int choice){
        switch(choice){
            case 1:
                break;
            case 2:
                break;
            case 3:
                System.out.println("Going back to the main menu. \n");
                RunSimulation.mainMenu(); //sends back to main menu
                break;
            default:
                System.out.println("Invalid choice. Please try again. \n");
        }
    }
}
