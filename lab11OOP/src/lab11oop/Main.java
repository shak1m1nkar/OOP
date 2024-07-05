/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab11oop;

import java.util.*;

// Task1.java
class Task1 {
    public static <E extends Comparable<E>> int linearSearch(E[] list, E key) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].compareTo(key) == 0) {
                return i; // Return the index if found
            }
        }
        return -1; // Return -1 if not found
    }
}

// Task2.java
class Task2 {
    public static <E extends Comparable<E>> E max(E[] list) {
        if (list == null || list.length == 0) {
            return null; // Return null if array is empty
        }
        E max = list[0];
        for (int i = 1; i < list.length; i++) {
            if (list[i].compareTo(max) > 0) {
                max = list[i]; // Update max if current element is greater
            }
        }
        return max;
    }
}

// Task3.java
class Task3 {
    public static <E extends Comparable<E>> E max(ArrayList<E> list) {
        if (list == null || list.isEmpty()) {
            return null; // Return null if list is empty
        }
        E max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(max) > 0) {
                max = list.get(i); // Update max if current element is greater
            }
        }
        return max;
    }
}

// Task4.java
class Task4 {
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        // Use a HashSet to store unique elements
        HashSet<E> set = new HashSet<>(list);
        // Create a new ArrayList from the HashSet (which contains only unique elements)
        return new ArrayList<>(set);
    }
}

// Point.java
class Point implements Comparable<Point> {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int compareTo(Point other) {
        if (this.x == other.x) {
            return Integer.compare(this.y, other.y);
        }
        return Integer.compare(this.x, other.x);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

// CompareY.java
class CompareY implements Comparator<Point> {
    @Override
    public int compare(Point p1, Point p2) {
        if (p1.getY() == p2.getY()) {
            return Integer.compare(p1.getX(), p2.getX());
        }
        return Integer.compare(p1.getY(), p2.getY());
    }
}

// Task5.java
class Task5 {
    public static void main(String[] args) {
        Point[] points = generatePoints(100);

        // Sort points by x-coordinates
        Arrays.sort(points);
        System.out.println("Points sorted by x-coordinates:");
        printPoints(points);

        // Sort points by y-coordinates
        Arrays.sort(points, new CompareY());
        System.out.println("\nPoints sorted by y-coordinates:");
        printPoints(points);
    }

    private static Point[] generatePoints(int n) {
        Random random = new Random();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = random.nextInt(100);
            int y = random.nextInt(100);
            points[i] = new Point(x, y);
        }
        return points;
    }

    private static void printPoints(Point[] points) {
        for (Point point : points) {
            System.out.print(point + " ");
        }
        System.out.println();
    }
}

// Task6.java
class Task6 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        Random random = new Random();

        // Insert 1 million integers into the linked list
        for (int i = 0; i < 1000000; i++) {
            list.add(random.nextInt());
        }

        // Test traversal time using iterator
        long startTime = System.currentTimeMillis();
        ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        long endTime = System.currentTimeMillis();
        System.out.
println("Time taken using iterator: " + (endTime - startTime) + " ms");

        // Test traversal time using get(index)
        startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken using get(index): " + (endTime - startTime) + " ms");
    }
}

public class Main {
    public static void main(String[] args) {
        // Test Task1: Generic Linear Search
        Integer[] numbers = {1, 3, 5, 7, 9, 2, 4, 6, 8};
        int index = Task1.linearSearch(numbers, 5);
        System.out.println("Task1 - Index of 5: " + index); // Output: Task1 - Index of 5: 2

        // Test Task2: Maximum Element in an Array
        Integer maxNumber = Task2.max(numbers);
        System.out.println("Task2 - Max number: " + maxNumber); // Output: Task2 - Max number: 9

        // Test Task3: Largest Element in ArrayList
        ArrayList<Double> numberList = new ArrayList<>(Arrays.asList(1.2, 3.4, 5.6, 7.8, 2.3));
        Double maxDouble = Task3.max(numberList);
        System.out.println("Task3 - Max number: " + maxDouble); // Output: Task3 - Max number: 7.8

        // Test Task4: Distinct Elements in ArrayList
        ArrayList<Integer> intList = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 4, 1));
        ArrayList<Integer> uniqueList = Task4.removeDuplicates(intList);
        System.out.println("Task4 - Unique numbers: " + uniqueList); // Output: Task4 - Unique numbers: [1, 2, 3, 4]

        // Test Task5: Sort Points in a Plane
        System.out.println("Task5 - Sorting points:");
        Task5.main(args); // Output points sorted by x-coordinates and y-coordinates

        // Test Task6: Use Iterators on Linked Lists
        System.out.println("Task6 - Traversal times:");
        Task6.main(args); // Output traversal times using iterator and get(index)
    }
}