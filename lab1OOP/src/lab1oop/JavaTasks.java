/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1oop;

import java.util.Scanner;

public class JavaTasks {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Task 1
        System.out.println("Task 1:");
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();
        if (num1 > num2) {
            System.out.println(num1 + " is greater than " + num2);
        } else if (num1 < num2) {
            System.out.println(num1 + " is less than " + num2);
        } else {
            System.out.println("Two numbers are equal");
        }

        // Task 2
        System.out.println("\nTask 2:");
        System.out.print("Enter a six-digit number: ");
        int sixDigitNum = scanner.nextInt();
        int firstHalf = sixDigitNum / 1000;
        int secondHalf = sixDigitNum % 1000;
        int sumFirstHalf = firstHalf / 100 + (firstHalf / 10 % 10) + (firstHalf % 10);
        int sumSecondHalf = secondHalf / 100 + (secondHalf / 10 % 10) + (secondHalf % 10);
        if (sumFirstHalf == sumSecondHalf) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        // Task 3
        System.out.println("\nTask 3:");
        System.out.print("Enter total distance A: ");
        double A = scanner.nextDouble();
        System.out.print("Enter time t1 (hours before noon): ");
        double t1 = scanner.nextDouble();
        System.out.print("Enter time t2 (hours after noon): ");
        double t2 = scanner.nextDouble();
        double velocityBeforeNoon = 20 / t1;
        double velocityAfterNoon = (A - 20) / t2;
        if (velocityBeforeNoon > velocityAfterNoon) {
            System.out.println("Before");
        } else {
            System.out.println("After");
        }

        // Task 4
        System.out.println("\nTask 4:");
        System.out.print("Enter x: ");
        double x = scanner.nextDouble();
        System.out.print("Enter y: ");
        double y = scanner.nextDouble();
        double calculatedY = 5 * x * x - 7 * x + 2;
        if (calculatedY == y) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        // Task 5
        System.out.println("\nTask 5:");
        int sumOdd = 0;
        int num;
        do {
            System.out.print("Enter an integer (0 to stop): ");
            num = scanner.nextInt();
            if (num % 2 != 0) {
                sumOdd += num;
            }
        } while (num != 0);
        System.out.println("Sum of odd integers: " + sumOdd);

        // Task 6
        System.out.println("\nTask 6:");
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        double sumSequence = 0.0;
        for (int i = 1; i <= n; i++) {
            sumSequence += 1.0 / i;
        }
        System.out.println("Sum of first " + n + " elements: " + sumSequence);

        // Task 7
        System.out.println("\nTask 7:");
        System.out.print("Enter n: ");
        double n7 = scanner.nextDouble();
        System.out.print("Enter m: ");
        double m7 = scanner.nextDouble();
        for (double i = n7; i <= m7; i += 0.5) {
            double y7 = -2.4 * i * i + 5 * i - 3;
            System.out.println(i + " " + y7);
        }

        // Task 8
        System.out.println("\nTask 8:");
        System.out.print("Enter n: ");
        int n8 = scanner.nextInt();
        double sumAlternatingSequence = 0.0;
        for (int i = 0; i < n8; i++) {
            sumAlternatingSequence += Math.pow(-1, i) / (2 * i + 1);
        }
        System.out.println("Sum of first " + n8 + " elements: " + sumAlternatingSequence);

        // Task 9
        System.out.println("\nTask 9:");
        System.out.print("Enter an integer: ");
        int num9 = scanner.nextInt();
        int sumDigits = 0;
        while (num9 != 0) {
            sumDigits += num9 % 10;
            num9 /= 10;
        }
        System.out.println("Sum of digits: " + sumDigits);
    }
}
