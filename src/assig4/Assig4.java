
package assig4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Assig4 {

    public static Integer[] storeA;

    public static void main(String[] args) throws IOException {
        // getting user input for array size
        boolean isNumber = false;
        Scanner input = new Scanner(System.in);
        int size = 0;
        do {
            System.out.println("Enter Array Size: ");
            String num = input.next();
            try {
                size = Integer.parseInt(num);
                isNumber = true;
            } catch (Exception e) {
                isNumber = false;
                System.out.println("Invalid Number! Try again");
            }
        } while (!isNumber);

        // getting user input for the number of trials
        isNumber = false;
        int trials = 0;
        do {
            System.out.println("Enter Number of Trials: ");
            String num = input.next();
            try {
                trials = Integer.parseInt(num);
                isNumber = true;
            } catch (Exception e) {
                isNumber = false;
                System.out.println("Invalid Number! Try again");
            }
        } while (!isNumber);

        // getting user input for the File name
        System.out.println("Enter File Name");
        String name = input.next();
        File file = new File(name);
        FileWriter writer = new FileWriter(file);
        PrintWriter print = new PrintWriter(writer);

        int[] min_size = {3, 15, 25, 50, 100, 500};

        for (int i = 0; i < min_size.length; i++) {

            SortAlgorithms.MIN_SIZE = min_size[i];

// random sorted array
            setRandom(size);
            String algorithm = "random";
               simpleQuickSort(print, trials, algorithm);
               medianQuickSort(print, trials, algorithm);
              randomQuickSort(print, trials, algorithm);
              mergeSort(print, trials, algorithm);
              insertionSort(print,trials,algorithm);

// Sorted array
            setSorted(size);
            algorithm = "Sorted";
              simpleQuickSort(print, trials, algorithm);
              medianQuickSort(print, trials, algorithm);
            randomQuickSort(print, trials, algorithm);
             mergeSort(print, trials, algorithm);

// reverse sorted array
            setReverse(size);
            algorithm = "Reverse Sorted";
               simpleQuickSort(print, trials, algorithm);
             medianQuickSort(print, trials, algorithm);
            randomQuickSort(print, trials, algorithm);
             mergeSort(print, trials, algorithm);
        }
        print.close();

    }

    public static void setRandom(int size) {
        // adding random elements in array
        storeA = new Integer[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            storeA[i] = 1 + random.nextInt(100);
        }
    }

    public static void setSorted(int size) {
        // adding number from 1 to size in the array
        storeA = new Integer[size];
        int count = 1;
        for (int i = 0; i < size; i++) {
            storeA[i] = count;
            count++;
        }
    }

    public static void setReverse(int size) {
        // adding numbers from size to 1 in the array
        storeA = new Integer[size];
        int count = size;
        for (int i = 0; i < size; i++) {
            storeA[i] = count;
            count--;
        }
    }

    public static void copyArray(Integer[] newA) {
        // copying elements from old array into new array
        for (int i = 0; i < storeA.length; i++) {
            newA[i] = storeA[i];
        }
    }

    public static void simpleQuickSort(PrintWriter print, int trials, String s) {
        // method for simple quick sort
        Integer[] A = new Integer[storeA.length];
        copyArray(A);
        if (A.length <= 100000) {
            print.println("Algorithm: Simple Quick Sort");
            print.println("Array Size: " + A.length);
            print.println("Base Case: " + SortAlgorithms.MIN_SIZE);
            print.println("Data setup: " + s);
            if (A.length <= 20) {
                print.println("Data Before Sorted");
                for (int i = 0; i < A.length; i++) {
                    print.println(A[i]);
                }
                print.println("");
                print.println("");
                SortAlgorithms.SimplequickSort(A, A.length);
                print.println("Data After Sorted");
                for (int i = 0; i < A.length; i++) {
                    print.println(A[i]);
                }
            } else {
                // timing how long it takes to sort the array and taking the average
                // of the trials
                print.println("Number of trials: " + trials);
                double average = 0;
                for (int i = 0; i < trials; i++) {
                    long start = System.nanoTime();
                    SortAlgorithms.SimplequickSort(A, A.length);
                    long finish = System.nanoTime();
                    long delta = finish - start;
                    average += delta;
                }
                average = average / 10;
                average = average / 1000000000;
                print.println("Average Time per trial: " + average);
                print.println("");
                print.println("");
            }
        }
    }

    public static void medianQuickSort(PrintWriter print, int trials, String s) {
        // method for median of three quick sort
        Integer[] A = new Integer[storeA.length];
        copyArray(A);

        print.println("Algorithm: Median Of Three");
        print.println("Array Size: " + A.length);
        print.println("Base Case: " + SortAlgorithms.MIN_SIZE);
        print.println("Data setup: " + s);
        if (A.length <= 20) {

            print.println("Data Before Sorted");
            for (int i = 0; i < A.length; i++) {
                print.println(A[i]);
            }
            print.println("");
            print.println("");
            // sorting the array amd printing it out
            SortAlgorithms.MedianquickSort(A, A.length);
            print.println("Data After Sorted");
            for (int i = 0; i < A.length; i++) {
                print.println(A[i]);
            }
        } else {
            // timing how long it takes to sort the array 
            print.println("Number of trials: " + trials);
            double average = 0;
            for (int i = 0; i < trials; i++) {
                long start = System.nanoTime();
                SortAlgorithms.MedianquickSort(A, A.length);
                long finish = System.nanoTime();
                long delta = finish - start;
                average += delta;
            }
            average = average / trials;
            average = average / 1000000000;
            print.println("Average Time per trial: " + average);
            print.println("");
            print.println("");
        }

    }

    public static void randomQuickSort(PrintWriter print, int trials, String s) {
        // method for random pivot quick sort
        Integer[] A = new Integer[storeA.length];
        copyArray(A);

        print.println("Algorithm: Random Pivot");
        print.println("Array Size: " + A.length);
        print.println("Base Case: " + SortAlgorithms.MIN_SIZE);
        print.println("Data setup: " + s);
        if (A.length <= 20) {

            print.println("Data Before Sorted");
            for (int i = 0; i < A.length; i++) {
                print.println(A[i]);
            }
            print.println("");
            print.println("");
            // sorting the array and printing it out
            SortAlgorithms.RandomPivot(A, A.length);
            print.println("Data After Sorted");
            for (int i = 0; i < A.length; i++) {
                print.println(A[i]);
            }
        } else {
            // timing trials and taking the average
            print.println("Number of trials: " + trials);
            double average = 0;
            for (int i = 0; i < trials; i++) {
                long start = System.nanoTime();
                SortAlgorithms.RandomPivot(A, A.length);
                long finish = System.nanoTime();
                long delta = finish - start;
                average += delta;
            }
            average = average / trials;
            average = average / 1000000000;
            print.println("Average Time per trial: " + average);
            print.println("");
            print.println("");
        }

    }

    public static void mergeSort(PrintWriter print, int trials, String s) {
        // method for merge sort
        Integer[] A = new Integer[storeA.length];
        copyArray(A);

        print.println("Algorithm: MergeSort");
        print.println("Array Size: " + A.length);
        print.println("Base Case: " + SortAlgorithms.MIN_SIZE);
        print.println("Data setup: " + s);
        if (A.length <= 20) {
            print.println("Data Before Sorted");
            for (int i = 0; i < A.length; i++) {
                print.println(A[i]);
            }
            print.println("");
            print.println("");
            // doing the sort and then printing out data 
            SortAlgorithms.mergeSort(A, A.length);
            print.println("Data After Sorted");
            for (int i = 0; i < A.length; i++) {
                print.println(A[i]);
            }
        } else {
            // timing trials and calculating the average
            print.println("Number of trials: " + trials);
            double average = 0;
            for (int i = 0; i < trials; i++) {
                long start = System.nanoTime();
                SortAlgorithms.mergeSort(A, A.length);
                long finish = System.nanoTime();
                long delta = finish - start;
                average += delta;
            }
            average = average / trials;
            average = average / 1000000000;
            print.println("Average Time per trial: " + average);
            print.println("");
            print.println("");
        }
    }
     public static void insertionSort(PrintWriter print, int trials, String s) {
        Integer[] A = new Integer[storeA.length];
        copyArray(A);

        print.println("Algorithm: insertionSort");
        print.println("Array Size: " + A.length);
        print.println("Base Case: " + SortAlgorithms.MIN_SIZE);
        print.println("Data setup: " + s);
        if (A.length <= 20) {

            print.println("Data Before Sorted");
            for (int i = 0; i < A.length; i++) {
                print.println(A[i]);
            }
            print.println("");
            print.println("");
            // sorting the array amd printing it out
           SortAlgorithms.insertionSort(A, A.length);
            print.println("Data After Sorted");
            for (int i = 0; i < A.length; i++) {
                print.println(A[i]);
            }
        } else {
            // timing how long it takes to sort the array 
            print.println("Number of trials: " + trials);
            double average = 0;
            for (int i = 0; i < trials; i++) {
                long start = System.nanoTime();
                SortAlgorithms.insertionSort(A, A.length);
                long finish = System.nanoTime();
                long delta = finish - start;
                average += delta;
            }
            average = average / trials;
            average = average / 1000000000;
            print.println("Average Time per trial: " + average);
            print.println("");
            print.println("");
        }

    }
}
