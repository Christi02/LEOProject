import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Lets the Administrator manage the user.
 * To update username or password or both. 
 * @author Christin Moreno
 * @author Joseth Valdez
 * @version  1.0
 */
public class ManageUser {
    /**
     * Main menu of the managing.
     * Will check the user that the Administrator wants to update.
     */
    public static void manage(){
        Scanner scanner = new Scanner(System.in); 
        String currentUsers = "UserInfo.csv";
        List<String []> rows = new ArrayList<>();
        String user = "" ;
        String position = "" ;
        String answer = "";
        String newUsername = "";
        String newPassword = "";

        //Shows all of the available users
        currentUsers();
        System.out.println("");
        System.out.println("Please choose a user to manage");
        user = scanner.nextLine();
        System.out.println("Please choose the users position");
        position = scanner.nextLine();

        //will execute if the user exists
        while(userExists(user, position)){
            //reads the file of the current users
            try(BufferedReader reader = new BufferedReader(new FileReader(currentUsers))) {
                String line;
                while((line = reader.readLine()) != null){
                    rows.add(line.split(","));
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

            System.out.println("Would you like to change the username?");
            answer = scanner.nextLine();
            if(answer.equalsIgnoreCase("yes")){
                System.out.println("Please choose a new username: ");
                newUsername = scanner.nextLine();
                if(userExists(newUsername, position)){ //if the username already exists for the given position
                    System.out.println("Username taken");
                    break;
                }
                else{
                //The username will be updated
                String[] headers = rows.get(0);
                for (int i = 0; i < rows.size(); i++) {
                    if(rows.get(i)[0].equals(user)){ //makes sure it is looking at the same user
                        rows.get(i)[0] = newUsername;
                        user = newUsername; //old username will be forgotten
                        System.out.println("Username successfully changed \n");
                        break;
                        }
                    }
                }
            }
            System.out.println("Would you like to change the passowrd?");
            answer = scanner.nextLine();
            if(answer.equalsIgnoreCase("yes")){
                System.out.println("Please choose a new password: ");
                newPassword = scanner.nextLine();

                //changes password
                String[] headers = rows.get(0);
                for (int i = 0; i < rows.size(); i++) {
                    if(rows.get(i)[0].equals(user)){
                        rows.get(i)[1] = newPassword;
                        System.out.println("password successfully changed \n");
                        break;
                    }
                }
            }
            else{
                break;
            }
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(currentUsers))){
                for(String[] row: rows){
                    writer.write(String.join(",", row));
                    writer.newLine();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }

    }
    /**
     * Shows the current users to the administrator
     */
    public static void currentUsers(){
        String currentUsers = "UserInfo.csv";
        System.out.println("");
        System.out.println("-------- Current Users -------"); 

        try(BufferedReader reader = new BufferedReader(new FileReader(currentUsers))) {
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**
     * Checks if the user exists for an update based on their position and username
     * @param username expected user
     * @param position of expected user their position
     * @return if the user exits 
     */
    public static Boolean userExists(String username, String position){
        String currentUsers = "UserInfo.csv";
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(currentUsers));
            List<String[]> rows = new ArrayList<>();
            String line;

                
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if(row.length >= 3 && (row[0].equals(username) && row[2].equalsIgnoreCase(position))){
                    return true;
                }
            } 
        } catch (Exception e) {
        }
        return false;
    }
    /**
     * Checks if the user exists for an update based on their password and username
     * @param username expected user
     * @param password of expected user their position
     * @return if the user exits 
     */
    public static Boolean userExistsPassword(String username, String password){
        String currentUsers = "UserInfo.csv";
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(currentUsers));
            List<String[]> rows = new ArrayList<>();
            String line;

                
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if(row.length >= 3 && (row[0].equals(username) && row[1].equalsIgnoreCase(password))){
                    return true;
                }
            } 
        } catch (Exception e) {
        }
        return false;
    }
}

