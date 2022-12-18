package Graph;

public class warshall {
    public static void main(String[] args) {
        
    }
    void floydWarshall(int dist[][])
    {
        int i, j, k;
        for (k = 0; k < dist.length; k++) {
            for (i = 0; i < dist.length; i++) {
                for (j = 0; j < dist.length; j++) {
                    if (dist[i][k] + dist[k][j]
                            < dist[i][j])
                        dist[i][j]
                                = dist[i][k] + dist[k][j];
                }
            }
        }

        // Print the shortest distance matrix
//        print(dist);
    }
}
