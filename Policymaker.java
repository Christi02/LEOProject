public class Policymaker extends User{

    public Policymaker(String position){
        super(position);
    }
    public void subMenuChoice(){
        System.out.println("1. Review reports on debris impact");
        System.out.println("2. Assess risk levels for future space missions");
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
