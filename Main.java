public class Main {
    
    public static void main(String[] args) {

    
        Graph.generate_vertices();
        Graph.generate_adjMtx();
        // Graph.print_adjMtx();
        // File_Handler.write_to_txtFile(Graph.adjMat);


        // Algorithms.execute("BFS","Oradea","Lugoj");
        // Algorithms.print_distances("BFS");
        // Algorithms.print_visited("BFS");
        // Algorithms.print_path("BFS");

        // Algorithms.execute("DFS","Oradea","Lugoj");
        // Algorithms.print_distances("DFS");
        // Algorithms.print_visited("DFS");
        // Algorithms.print_path("DFS");

        Algorithms.execute("IDS","Oradea","Lugoj");
        Algorithms.print_distances("IDS");
        Algorithms.print_visited("IDS");
        Algorithms.print_path("IDS");

    }
}
