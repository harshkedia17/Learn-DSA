package Tree;

import java.util.Scanner;

public class SearchProgram
{
    // Function prototypes
//    public static void linearSearch(int[] arr, int n, int elem);
//    public static void binarySearch(int[] arr, int n, int elem);

    public static void main(String[] args)
    {
        int choice, n, elem;
        int[] arr = new int[100]; // Declare an array of size 100
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        n = scan.nextInt();

        System.out.print("Enter the elements of the array: ");
        for (int i = 0; i < n; i++)
            arr[i] = scan.nextInt();

        System.out.print("Enter the element to search for: ");
        elem = scan.nextInt();

        System.out.print("Enter 1 for linear search or 2 for binary search: ");
        choice = scan.nextInt();

        // Call the appropriate search function based on the user's choice
        if (choice == 1)
            linearSearch(arr, n, elem);
        else if (choice == 2)
            binarySearch(arr, n, elem);
        else
            System.out.println("Invalid choice!");
    }

    // Function to perform linear search
    public static void linearSearch(int[] arr, int n, int elem)
    {
        // Loop through the array to search for the element
        for (int i = 0; i < n; i++)
        {
            if (arr[i] == elem)
            {
                System.out.println("Element found at index " + i);
                return;
            }
        }

        System.out.println("Element not found in the array");
    }

    // Function to perform binary search
    public static void binarySearch(int[] arr, int n, int elem)
    {
        int low = 0, high = n - 1, mid;

        // Loop until the low index is less than or equal to the high index
        while (low <= high)
        {
            mid = (low + high) / 2; // Calculate the midpoint of the array

            // Check if the element is at the midpoint
            if (arr[mid] == elem)
            {
                System.out.println("Element found at index " + mid);
                return;
            }
            // If the element is less than the midpoint, search the left half of the array
            else if (arr[mid] > elem)
                high = mid - 1;
                // If the element is greater than the midpoint, search the right half of the array
            else
                low = mid + 1;
        }

        System.out.println("Element not found in the array");}
}
