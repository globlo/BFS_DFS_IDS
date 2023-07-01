import java.util.Scanner; 


public class Main {
    
    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);

        // System.out.println("Enter Search Method");
        // String algo = myObj.nextLine();

        // System.out.println("Enter Start City");
        // String Start = myObj.nextLine();
        
        // // System.out.println("Enter Destination");
        // String Goal = myObj.nextLine();


        String algo = "IDS";
        String Start = "Arad";
         String Goal = "Bucharest";

    
        Graph.generate_vertices();
        Graph.generate_adjMtx();
        Graph.print_adjMtx();
        File_Handler.write_to_txtFile(Graph.adjMat);

        Algorithms.execute(algo,Start,Goal);
        Algorithms.print_visited(algo);
        Algorithms.print_path(algo);
        // Algorithms.print_distances(algo);

    }
}
