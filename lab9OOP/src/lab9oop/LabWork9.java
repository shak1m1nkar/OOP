
package lab9oop;



import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class LabWork9 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Select a task to run:");
        System.out.println("1. Count characters, words, and lines in a file");
        System.out.println("2. Create a file, write random integers, read and sort");
        System.out.println("3. Remove occurrences of a specified string from a text file");
        System.out.println("4. Check if strings in a file are in increasing order");
        System.out.println("5. Create a data file with 1,000 lines of faculty data");
        System.out.println("6. Count occurrences of each letter in a file");
        int choice = input.nextInt();
        input.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                countCharactersWordsLines();
                break;
            case 2:
                createFileWriteReadSort();
                break;
            case 3:
                removeStringFromFile();
                break;
            case 4:
                checkSortedStrings();
                break;
            case 5:
                generateFacultyData();
                break;
            case 6:
                countLetterOccurrences();
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    // Task 1
    private static void countCharactersWordsLines() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the filename: ");
        String filename = input.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            int charCount = 0, wordCount = 0, lineCount = 0;
            String line;

            while ((line = br.readLine()) != null) {
                lineCount++;
                charCount += line.length();
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }

            System.out.println("Number of characters: " + charCount);
            System.out.println("Number of words: " + wordCount);
            System.out.println("Number of lines: " + lineCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Task 2
    private static void createFileWriteReadSort() {
        String filename = "LabWork9.txt";

        // Create file and write 100 random integers
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            Random rand = new Random();
            for (int i = 0; i < 100; i++) {
                writer.print(rand.nextInt(1000) + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read integers from file and sort them
        try (Scanner scanner = new Scanner(new File(filename))) {
            List<Integer> numbers = new ArrayList<>();
            while (scanner.hasNextInt()) {
                numbers.add(scanner.nextInt());
            }
            Collections.sort(numbers);

            // Display sorted numbers
            System.out.println("Sorted numbers: " + numbers);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Task 3
    private static void removeStringFromFile() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the filename: ");
        String filename = input.nextLine();
        System.out.print("Enter the string to remove: ");
        String stringToRemove = input.nextLine();

        try {
            String content = new String(Files.readAllBytes(Paths.get(filename)));
            content = content.replace(stringToRemove, "");

            Files.write(Paths.get(filename), content.getBytes());
            System.out.println("String \"" + stringToRemove + "\" removed from the file.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Task 4
private static void checkSortedStrings() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the filename: ");
        String filename = input.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String previous = br.readLine();
            String current;
            boolean sorted = true;

            while ((current = br.readLine()) != null) {
                if (previous.compareTo(current) > 0) {
                    System.out.println("Strings not sorted. First out-of-order pair: " + previous + ", " + current);
                    sorted = false;
                    break;
                }
                previous = current;
            }

            if (sorted) {
                System.out.println("Strings are sorted.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Task 5
    private static void generateFacultyData() {
        String filename = "Salary.txt";
        String[] ranks = {"assistant", "associate", "full"};
        Random rand = new Random();

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (int i = 1; i <= 1000; i++) {
                String firstName = "FirstName" + i;
                String lastName = "LastName" + i;
                String rank = ranks[rand.nextInt(ranks.length)];
                double salary = generateSalary(rank, rand);
                writer.printf("%s %s %s %.2f%n", firstName, lastName, rank, salary);
            }
            System.out.println("Faculty data generated in " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double generateSalary(String rank, Random rand) {
        switch (rank) {
            case "assistant":
                return 50000 + (30000 * rand.nextDouble());
            case "associate":
                return 60000 + (50000 * rand.nextDouble());
            case "full":
                return 75000 + (55000 * rand.nextDouble());
            default:
                return 0;
        }
    }

    // Task 6
    private static void countLetterOccurrences() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the filename: ");
        String filename = input.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            int[] letterCounts = new int[26];
            String line;

            while ((line = br.readLine()) != null) {
                line = line.toLowerCase();
                for (char c : line.toCharArray()) {
                    if (Character.isLetter(c)) {
                        letterCounts[c - 'a']++;
                    }
                }
            }

            for (int i = 0; i < letterCounts.length; i++) {
                System.out.println((char) ('a' + i) + ": " + letterCounts[i]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}