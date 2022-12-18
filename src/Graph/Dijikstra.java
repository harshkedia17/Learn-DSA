package Graph;

public class Dijikstra {
    public static void main(String[] args) {

    }


    public static void dijikstra(int[][] adj, int s){
        int size = adj.length;
        int[] distance = new int[size];
        boolean[] visited = new boolean[size];
        for (int i = 0; i < size; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[s] = 0;
        visited[s] = true;

        for (int i = 0; i < size; i++) {
            int min = minDistance(distance,visited);
            visited[min] = true;
            for (int j = 0; j < size; j++) {
                if (!visited[j] && adj[min][j] != 0 && (distance[min] + adj[min][j] < distance[j])) {
                    distance[j] = distance[min] + adj[min][j];

                }
            }
        }
    }

    private static int minDistance(int[] distance, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int idx = -1;
        for (int i = 0; i < distance.length; i++) {
            if(!visited[i] && distance[i]<min){
                min = distance[i];
                idx = i;
            }
        }
        return idx;
    }
}
