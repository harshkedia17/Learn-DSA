package Heaps;

public class Heap_Sort {



    void sort(int[] arr){
        int n = arr.length;

        for (int i = n/2; i >=0 ; i--) {
            heapify(arr,n,i);
        }

        for (int i = n-1; i >=0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            heapify(arr,i,0);
        }
    }

    void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2*i+1;
        int r = 2*i+2;

        if(l<n && arr[l]>arr[largest]){
            largest = l;
        }
        if(r<n && arr[r]>arr[largest]){
            largest = r;
        }
        if(largest!=i){
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }
}
