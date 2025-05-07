
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * For the Administration to delete users.
 * @author Christin Moreno
 * @author Joseth Valdez
 * @version  1.0
 */
public class DeleteUser {

    /**
     * The required values to choose a user to delete
     */
    public static void deleteUserOption() {
        Scanner scanner = new Scanner(System.in); 
        String user = "";
        String position = "";

        ManageUser.currentUsers();
        System.out.println("Please choose a user you would like to delete: ");
        user = scanner.nextLine();
        if(user == null || user.equals("")){
            System.out.println("Please enter a valid answer. \n");
            return;
        }
        System.out.println("Please choose a the user's position: ");
        position = scanner.nextLine();
        if(position == null || position.equals("")){
            System.out.println("Please enter a valid position. \n");
            return;
        }
        if(ManageUser.userExists(user, position)){
            deleteUser(user, position);
        }
        else{
            System.out.println("User doesn't exist, please choose an existing user.");
            return;
        }


    }
    /**
     * Will delete the user by checking the username and the position to pinpoint.
     * @param user  username of the user
     * @param position position of the user 
     */
    public static void deleteUser(String user, String position){
        String currentUsers = "UserInfo.csv";
        List<String> rows = new ArrayList<>();

        //will focus on the current users
        try(BufferedReader reader = new BufferedReader(new FileReader(currentUsers))) {
                String line;
                while((line = reader.readLine()) != null){
                    rows.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
            //KeptRows so that it doesn't matter what row the user to delete is in
            List<String> KeptRows = new ArrayList<>(); //the rows that should not be impacted
            KeptRows.add(rows.get(0));

            for(int i=1; i<rows.size(); i++){
                String[] row = rows.get(i).split(",");
                if(!(row[0].equals(user) && row[2].equalsIgnoreCase(position))){ //pinpoints the expected user 
                    KeptRows.add(rows.get(i));
                }
            }
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(currentUsers))) {
                for(String line : KeptRows){
                    writer.write(line);
                    writer.newLine();
                }
                System.out.println("User deleted successfullu");
                
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
