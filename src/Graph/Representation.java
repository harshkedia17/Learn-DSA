package Graph;

import java.util.ArrayList;

public class Representation {
    public static void main(String[] args) {

    }

    //undirected and non weighted graph
    static void matrix_insert( int arr[][],int i,int j){
        arr[i][j] = 1;
        arr[j][i] = 1;
    }

    static void list_insert(ArrayList<ArrayList<Integer>> l, int i, int j){
        l.get(i).add(j);
        l.get(j).add(i);
    }
}
