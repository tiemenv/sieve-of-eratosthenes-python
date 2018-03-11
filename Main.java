/*
This program attempts to find new primes by using the mathematical Sieve of Eratosthenes method,
it prompts the user for a limit integer where it will stop searching, after it searched it outputs
the primes to the console.
*/
package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("This program attempts to find primes by using the Sieve Of Eratosthenes method.");
        Scanner reader = new Scanner(System.in);
        System.out.println("Until what integer should I sieve?");
        int limit = reader.nextInt();
        reader.close();
        long startTime = System.currentTimeMillis();
        boolean[] array = new boolean[limit - 2];
        //initialize the array
        for (int i = 0; i < array.length; i++) {
            array[i] = true;
        }
        //commence the sieving
        for (int i = 0; i < array.length; i++) {
            if (array[i]) {
                //we do 2*i+2 as initializer for j because we want to skip the loop the first time a true number is found
                for (int j = 2 * i + 2; j < array.length; j = i + j + 2) {
                    array[j] = false;
                }
            }
        }
        //convert the boolean array to human readable numbers
        int arrayOfPrimesLength = 0;
        for (boolean anArray : array) {
            if (anArray) {
                arrayOfPrimesLength++;
            }
        }
        int[] arrayOfPrimes = new int[arrayOfPrimesLength];
        int arrayPointer = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]) {
                arrayOfPrimes[arrayPointer] = i + 2;
                arrayPointer++;
            }
        }
        System.out.println(Arrays.toString(arrayOfPrimes));
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(elapsedTime + "ms");
    }
}
