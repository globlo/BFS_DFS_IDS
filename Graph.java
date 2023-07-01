import java.util.HashMap;
import java.util.Map;

public class Graph {  // this class contain Original graph info, adjMat generator, and print methods

    // static Dictionary<Integer, String> vertices= new Hashtable<>();
    static Map<Integer,String> vertices = new HashMap<Integer,String>();

    public static void generate_vertices(){

        vertices.put(0, "Orandea");
        vertices.put(1, "Zerind");
        vertices.put(2, "Arad");
        vertices.put(3, "Timisoara");
        vertices.put(4, "Sibiu");
        vertices.put(5, "Lugoj");
        vertices.put(6, "Mehadia");
        vertices.put(7, "Drobeta");
        vertices.put(8, "Craivoa");
        vertices.put(9, "Rimnicu Velcea");
        vertices.put(10, "Fagaras");
        vertices.put(11, "Pitesti");
        vertices.put(12, "Bucharest");
        vertices.put(13, "Giurgiu");
        vertices.put(14, "Urziceni");
        vertices.put(15, "Hirsova");
        vertices.put(16, "Eforie");
        vertices.put(17, "Vaslui");
        vertices.put(18, "Iasi");
        vertices.put(19, "Neamt");
        
    }

    static int[][] neighbors = {
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

    public static int[][] adjMat = new int[20][20];

    public static void generate_adjMtx(){

        for (int i = 0; i < neighbors.length; i++) { // 0 - 19
            for (int j = 0; j < neighbors[i].length; j++) {
                adjMat[i][neighbors[i][j]] = 1;
            }
        }

    }

    public static void print_adjMtx(){
        System.out.println("\n\nAdjacency Matrices: ");
        for (int[] subMat : adjMat) { // print out the Adjacency matrix  
            for (int val :  subMat){
                  
                System.out.print(val+ " ");               
            }    
            System.out.println(" ");
        }
        System.out.println("\n\n");

    }

    public static Integer get_key(String value){

        for(Integer key : Graph.vertices.keySet()) {
            if( Graph.vertices.get(key).equals(value)) {  
                return key;
            }  
        }
        return -1;
    }
    public static void print_vertices(){

        System.out.println("The all locations and assigned value: ");

        for(Integer key : Graph.vertices.keySet()) {
            System.out.print(Graph.vertices.get(key)+"("+key+")");
            if (key < Graph.vertices.size() - 1)  System.out.print(", ");
        }
        System.out.println("\n");
        
    }
}