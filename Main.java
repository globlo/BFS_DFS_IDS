import java.util.Scanner; 


public class Main {
    
    public static void main(String[] args) {

        Graph.generate_vertices();
        Graph.generate_adjMtx();
        Graph.print_adjMtx();
        File_Handler.write_to_txtFile(Graph.adjMat);
        Graph.print_vertices();

        Scanner myObj = new Scanner(System.in);

        // System.out.println("Enter Search Method (BFS, DFS, IDS)");
        // String algo = myObj.nextLine();

        // System.out.println("Enter Start City");
        // String Start = myObj.nextLine();
        
        // System.out.println("Enter Destination");
        // String Goal = myObj.nextLine();


        String algo = "IDS";
        String Start = "Vaslui";
         String Goal = "Bucharest";

        Algorithms.execute(algo,Start,Goal);
        

    }
}
