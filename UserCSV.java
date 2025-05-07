import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Saves the user information for the creation of a new user
 * @author Christin Moreno
 * @author Joseth Valdez
 * @version  1.0
 */
public class UserCSV {
    
/**
 *  Reads through the CSV to add the new user or to make sure the user is valid to be added 
 * @param username to make the users username 
 * @param password to make the users password
 * @param position to assign the user to a position
 */
public static void infoSaved(String username, String password, String position) {
    Administrator administrator = new Administrator("Administrator");
    String userCSV = "UserInfo.csv";


    try {
        BufferedReader reader = new BufferedReader(new FileReader(userCSV));
        List<String[]> rows = new ArrayList<>(); // make a new list 
        String line;

            
        while ((line = reader.readLine()) != null) {
            String[] row = line.split(","); //split each string with , 
            // only 3 columns, makes sure if the user exists
            if(row.length >= 3 && (row[0].equals(username) && row[2].equalsIgnoreCase(position))){ 
                System.out.println("User already Exists, failed to create user.");
                administrator.userMenu();
            } 
            rows.add(row);
        }
        reader.close();  

            
        String[] headers = rows.get(0);  
        
        //if user does not exist, it will be created
        String[] newRow = new String[headers.length];
        for (int i = 0; i < headers.length; i++) {
            if (headers[i].equalsIgnoreCase("Username")) {
                newRow[i] = username;  
            } else if (headers[i].equalsIgnoreCase("Password")) {
                newRow[i] = password;  
            }else if (headers[i].equalsIgnoreCase("User Type")) {
                newRow[i] = position;  
            } else {
                newRow[i] = "";  
            }
        }

            
        rows.add(newRow);  // Add new row to the list of rows

            
        BufferedWriter writer = new BufferedWriter(new FileWriter(userCSV));
            
        if(rows.size() == 1){
            writer.write(String.join(",", headers));
            writer.newLine();  // New line after header
        }

            
        for (String[] row : rows) {
            writer.write(String.join(",", row));  // Join each row with a comma and write to file
            writer.newLine();
        }

        writer.close();  // Close writer

    } catch (IOException e) {
        e.printStackTrace();  // Handle any I/O exceptions
    }

    }
    
}
