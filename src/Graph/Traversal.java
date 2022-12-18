package Graph;

import java.util.*;

public class Traversal {

    public static void main(String[] args) {
        Graph g = new Graph(10);
        g.add_Edge(1, 2);
        g.add_Edge(1, 6);
        g.add_Edge(2, 3);
        g.add_Edge(2, 4);
        g.add_Edge(4, 5);
        g.add_Edge(5, 8);
        g.add_Edge(6, 7);
        g.add_Edge(6, 9);
        g.add_Edge(7, 8);
        g.add_Edge(5, 8);
        g.DFS(1);
    }
}

class Graph {
    private int V;
    private ArrayList<ArrayList<Integer>> adj;
    private int[][] matrix;

    Graph(int V) {
        this.V = V;
        adj = new ArrayList<>(V + 1);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        matrix = new int[V + 1][V + 1];
    }

    void add_Edge_Matrix(int v, int w) {
        matrix[v][w] = 1;
    }

    void add_Edge(int v, int w) {
        adj.get(v).add(w);
        adj.get(w).add(v);
    }

    void BFS(int s) {
        boolean[] visited = new boolean[V + 1];
        Queue<Integer> q = new LinkedList<>();

        visited[s] = true;
        q.add(s);

        while (!q.isEmpty()) {
            Integer node = q.poll();
            System.out.print(node + " ");

            int size = adj.get(node).size();
            for (int i = 0; i < size; i++) {
                int n = adj.get(node).get(i);
                if (!visited[n]) {
                    q.add(n);
                    visited[n] = true;
                }
            }
        }
    }

    void BFS_matrix(int s) {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        visited[s] = true;
        q.add(s);
        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");
            for (int i = 1; i <= V; i++) {
                if (matrix[node][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }


    //DFS


    void DFS(int s) {
        boolean[] visited = new boolean[V + 1];
        Stack<Integer> st = new Stack<>();

        visited[s] = true;
        st.push(s);
        while (!st.isEmpty()) {
            Integer node = st.pop();
            System.out.print(node + " ");
            int size = adj.get(node).size();
            for (int i = 0; i < size; i++) {
                int n = adj.get(node).get(i);
                if (!visited[n]) {
                    st.push(n);
                    visited[n] = true;
                }
            }
        }
    }
}
