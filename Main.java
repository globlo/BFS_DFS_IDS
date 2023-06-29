public class Main {

    static int[][] arr = {
            {1,4}, // Orandea, 
            {0,2},  // Zerind
            {1,3,4}, // Arad
            {2,5},  // Timisoara
            {0,2,9,10}, // Sibiu
            {3,6},  // Lugoj
            {5,7}, // Mehadia
            {6,8},  // Drobeta
            {7,9,11}, // Craivoa
            {4,8,11},  // Rimnicu Velcea
            {4,12}, // Fagaras
            {8,9,12},  // Pitesti
            {10,11,13,14}, // Bucharest
            {12},  // Giurgiu
            {12,15,17}, // Urziceni
            {14,16},  // Hirsova
            {15}, // Eforie
            {14,18},  // Vaslui
            {17,19}, // Iasi
            {18}  // Neamt

        };

    public static void main(String[] args) {

        

        Graph.generate_adjMtx(arr);
        Graph.print(arr);
        // File_Handler.write_to_txtFile(Graph.adjMat);
        // BFS.search();

    }
}
