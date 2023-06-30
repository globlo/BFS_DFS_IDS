
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class File_Handler {
    
    //Purpose: Save the graph object to the text file
    public static void write_to_txtFile(int[][] graphToWrite) {
        try{

            File file = new File("graphOutput.txt"); //Output file name where graph object will be saved
            FileWriter filewriter = new FileWriter(file);
            // PrintWriter outputFile = new PrintWriter();
            for (int[] subArr : graphToWrite) {
                for (int value : subArr) {
                    filewriter.write(value+ " ");
                }
                filewriter.write("\n");
            }

            filewriter.close();

        }catch(IOException e){
            System.out.println(e);
        }
        
    }


}
