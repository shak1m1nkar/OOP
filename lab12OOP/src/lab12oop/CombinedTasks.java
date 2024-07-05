
package lab12oop;


import java.util.*;

public class CombinedTasks {
    public static void main(String[] args) {
        // Task 1: Perform set operations on hash sets
        LinkedHashSet<String> set1 = new LinkedHashSet<>(Arrays.asList("George", "Jim", "John", "Blake", "Kevin", "Michael"));
        LinkedHashSet<String> set2 = new LinkedHashSet<>(Arrays.asList("George", "Katie", "Kevin", "Michelle", "Ryan"));

        LinkedHashSet<String> unionSet = new LinkedHashSet<>(set1);
        unionSet.addAll(set2);
        System.out.println("Union: " + unionSet);

        LinkedHashSet<String> differenceSet = new LinkedHashSet<>(set1);
        differenceSet.removeAll(set2);
        System.out.println("Difference (set1 - set2): " + differenceSet);

        LinkedHashSet<String> intersectionSet = new LinkedHashSet<>(set1);
        intersectionSet.retainAll(set2);
        System.out.println("Intersection: " + intersectionSet);

        // Task 2: Display the first 50 prime numbers in descending order using a stack
        Stack<Integer> primeStack = new Stack<>();
        int count = 0;
        int number = 2;

        while (count < 50) {
            if (isPrime(number)) {
                primeStack.push(number);
                count++;
            }
            number++;
        }

        System.out.println("\nFirst 50 prime numbers in descending order:");
        while (!primeStack.isEmpty()) {
            System.out.println(primeStack.pop());
        }

        // Task 3: Implement GenericQueue using inheritance
        GenericQueue<Integer> queue = new GenericQueue<>();
        for (int i = 1; i <= 10; i++) {
            queue.offer(i);
        }

        System.out.println("\nGenericQueue elements:");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

        // Task 4: Generic PriorityQueue using Comparator
        Comparator<Integer> descComparator = Comparator.reverseOrder();
        MyPriorityQueue<Integer> priorityQueue = new MyPriorityQueue<>(descComparator);
        priorityQueue.offer(3);
        priorityQueue.offer(1);
        priorityQueue.offer(4);
        priorityQueue.offer(2);

        System.out.println("\nMyPriorityQueue elements in descending order:");
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }

    // Helper method to check if a number is prime
    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;

        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    // Task 3: GenericQueue using inheritance from LinkedList
    static class GenericQueue<E> extends LinkedList<E> {
        // No additional implementation required for this example
    }

    // Task 4: Generic PriorityQueue using Comparator
    static class MyPriorityQueue<E> extends PriorityQueue<E> {
        public MyPriorityQueue(Comparator<? super E> comparator) {
            super(comparator);
        }
    }
}