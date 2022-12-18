package Graph;

public class Prims {
    public static void main(String[] args) {

    }


    static void prim(int[][] graph){
        int[] weight = new int[graph.length];
        int[] parent = new int[graph.length];
        boolean[] tree = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            weight[i] = Integer.MAX_VALUE;
        }

        weight[0] = 0;
        parent[0] = -1;

        for (int i = 0; i < graph.length-1; i++) {
            int u = min_weight(weight,tree);
            tree[u] = true;
            for (int j = 0; j < graph.length; j++) {
                if(graph[u][j]!=0 && !tree[j] && graph[u][j]<weight[j]){
                    parent[j]  = u;
                    weight[j] = graph[u][j];
                }
            }
        }
    }

    private static int min_weight(int[] weight, boolean[] tree) {
        int min = Integer.MAX_VALUE , idx = -1;
        for (int i = 0; i < weight.length; i++) {
            if(weight[i]<min && !tree[i]){
                min = weight[i];
                idx = i;
            }
        }
        return idx;
    }


    static void print(int[][] graph, int[] parent){
        System.out.println("EDGE \tWeight");
        for (int i = 0; i < graph.length; i++) {
            System.out.println(parent[i]+" -> "+i+" \t" + graph[i][parent[i]]);
        }
    }
}
