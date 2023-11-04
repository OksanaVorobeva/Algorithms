package Seminar1;


import java.util.Random;


public class Task {

    public static void main(String[] args) {

        //sumNumber(3);
        //System.out.println(sum(3));

        /*
        int[] array1 = new int[10000];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = new Random().nextInt(100);
        }
        int[] array2 = new int[10000];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = new Random().nextInt(100);
        }

        long timeStart1 = System.currentTimeMillis();
        bubbleSort(array1);
        long timeEnd1 = System.currentTimeMillis();
        long timeStart2 = System.currentTimeMillis();
        bubbleSort2(array2);
        long timeEnd2 = System.currentTimeMillis();

        System.out.println(timeEnd1 - timeStart1);
        System.out.println(timeEnd2 - timeStart2);
        */

        /*
        long timeStart1 = System.nanoTime();
        System.out.println(fib(20));
        long timeEnd1 = System.nanoTime();
        long timeStart2 = System.nanoTime();
        System.out.println(fib2(20));
        long timeEnd2 = System.nanoTime();
        long timeStart3 = System.nanoTime();
        System.out.println(fib3(20));
        long timeEnd3 = System.nanoTime();

        System.out.println(timeEnd1 - timeStart1);
        System.out.println(timeEnd2 - timeStart2);
        System.out.println(timeEnd3 - timeStart3);

         */

        /*
        long startTime1 = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            fib(20);
        }
        long endTime1 = System.nanoTime();
        long time1 = (endTime1 -startTime1)/100;
        System.out.println(time1);

        long startTime2 = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            fib2(20,0,1);
        }
        long endTime2 = System.nanoTime();
        long time2 = (endTime2 -startTime2)/100;
        System.out.println(time2);

        long startTime3 = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            fib3(20);
        }
        long endTime3 = System.nanoTime();
        long time3 = (endTime3 -startTime3)/100;
        System.out.println(time3);

         */


    }


    public static int sumNumber(int number) {

        int sum = 0;
        for (int i = 0; i <= number; i++) {
            sum += i;
        }
        System.out.println(sum);
        return sum;
    }

    public static int sum(int number) {
        return number * (number + 1) / 2;
    }

    public static void bubbleSort(int[] array) { //O(n^2)


        for (int k = 0; k < array.length - 1; k++) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
        //for (int i :array) {
        // System.out.print(i + " ");
        //  }
    }

    public static void bubbleSort2(int[] array) { // O(n*(n^2-n)

        int lenght = array.length - 1;
        boolean flag = true;
        for (int k = 0; k < array.length - 1 && flag; k++) {
            flag = false;
            for (int i = 0; i < lenght; i++) {
                if (array[i] > array[i + 1]) {
                    flag = true;
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            lenght--;
        }
        //for (int i :array) {
        //   System.out.print(i + " ");
        //}
    }

    public static int fib(int n) {
        if (n < 1)
            return -1;
        if (n == 1)
            return 0;
        if (n <= 3)
            return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public static int fib2(int n) {
        if (n <= 0)
            return -1;
        if (n == 1)
            return 0;
        if (n <= 3)
            return 1;
        return fib2(n, 0, 1);
    }

    public static int fib2(int n, int left, int right) {
        if (n <= 2)
            return right;
        return fib2(n - 1, right, left + right);
    }

    public static int fib3(int n) {
        int left = 0;
        int right = 1;
        if (n <= 0)
            return -1;
        if (n == 1)
            return 0;
        for (int i = 2; i < n; i++) {
            right = left + right;
            left = right - left;
        }
        return right;
    }

}
