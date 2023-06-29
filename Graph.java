public class Graph {

    public static int[][] adjMat = new int[20][20];

    public static void generate_adjMtx(int [][]arr){

        for (int i = 0; i < arr.length; i++) { // 0 - 19
            for (int j = 0; j < arr[i].length; j++) {
                adjMat[i][arr[i][j]] = 1;
            }
        }

    }

    public static void print(int [][]arr){
        for (int i = 0; i < adjMat.length; i++) { // print out the adjacency matrix  
            for (int j = 0; j < adjMat[i].length; j++) {
                  
                System.out.print(adjMat[i][j]);               
            }    
            System.out.println(" ");
        }

    }
}