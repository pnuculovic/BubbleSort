import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class BubbleSort {

    // Given arrayLength as argument, create an array of random integers between 0 and 100; return the created array.
    public static int[] createRandomArray(int arrayLength) {
        int[] array = new int[arrayLength];
        Random rand = new Random();
        for (int i = 0; i < arrayLength; i++) {
            array[i] = rand.nextInt(101);  // Generates a random number between 0 and 100
        }
        return array;
    }

    // Given an integer array and filename, write the array to the file, with each line containing one integer in the array.
    public static void writeArrayToFile(int[] array, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int num : array) {
                writer.write(Integer.toString(num));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    // This is the reverse of writeArrayToFile; Given the filename, read the integers (one line per integer) to an array, and return the array
    public static int[] readFileToArray(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            return reader.lines().mapToInt(Integer::parseInt).toArray();
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the file.");
            e.printStackTrace();
        }
        return new int[0];  // Return empty array in case of error
    }

    // Given an integer array, sort it in-place using bubble sort
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j+1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Main function to handle user input and call the relevant methods
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a random array
        System.out.print("Enter the length of the random array: ");
        int length = scanner.nextInt();
        int[] randomArray = createRandomArray(length);
        
        // Write array to a file
        System.out.print("Enter the filename to write the array: ");
        String filename = scanner.next();
        writeArrayToFile(randomArray, filename);

        // Read array from the file
        int[] fileArray = readFileToArray(filename);
        System.out.println("Array read from file: ");
        for (int num : fileArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Sort the array using bubble sort
        bubbleSort(fileArray);
        System.out.println("Sorted array: ");
        for (int num : fileArray) {
            System.out.print(num + " ");
        }
    }
}
