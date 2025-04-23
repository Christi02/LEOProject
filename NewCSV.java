
import java.io.*;

public class NewCSV {
    public static void main(String[] args) {
        

        String oldRSOFile = "rso_metrics.csv";
        String newRSOFile = "new_rso_metrics.csv";

        newCSV(oldRSOFile, newRSOFile);

    }
    public static void newCSV(String oldRSOFile, String newRSOFile) {
        Debris[] debrisArray = new Debris[1000];

        try(
            BufferedReader br = new BufferedReader(new FileReader(oldRSOFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(newRSOFile))

        ){
            String line;
            boolean firstLine = true;

            while((line = br.readLine()) != null){
                String[] parts = line.split(",");

                if(firstLine){
                    bw.write(line + ",still_in_orbit,risk_level \n");
                    firstLine = false;
                }else{
                    Debris debris = new Debris(parts);

                    bw.write(line + "," + debris.stillInOrbit(debrisArray) + "," + debris.riskLevel(debrisArray) + "\n");
                }
            }
            System.out.println(newRSOFile);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
