/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab8oop;

// Tourist.java
class Tourist {
    private String name;
    private double incomeMoney;

    // Default constructor
    public Tourist() {
    }

    // Parameterized constructor
    public Tourist(String name, double incomeMoney) {
        this.name = name;
        this.incomeMoney = incomeMoney;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getIncomeMoney() {
        return incomeMoney;
    }

    public void setIncomeMoney(double incomeMoney) {
        this.incomeMoney = incomeMoney;
    }

    // toString method
    @Override
    public String toString() {
        return name + " " + incomeMoney + " USD";
    }
}

// ResortPlace.java
class ResortPlace {
    private String name;
    private String city;
    private Tourist[] tourists = new Tourist[1000];
    private int touristCount = 0;

    // Default constructor
    public ResortPlace() {
    }

    // Parameterized constructor
    public ResortPlace(String name, String city) {
        this.name = name;
        this.city = city;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // Add tourist
    public void addTourist(Tourist tourist) {
        if (touristCount < tourists.length) {
            tourists[touristCount] = tourist;
            touristCount++;
        }
    }

    // Get total income
    public double getTotalIncome() {
        double totalIncome = 0;
        for (int i = 0; i < touristCount; i++) {
            totalIncome += tourists[i].getIncomeMoney();
        }
        return totalIncome;
    }

    // Get total tourists
    public int getTotalTourists() {
        return touristCount;
    }

    // Get tourists
    public Tourist[] getTourists() {
        Tourist[] currentTourists = new Tourist[touristCount];
        System.arraycopy(tourists, 0, currentTourists, 0, touristCount);
        return currentTourists;
    }

    // toString method
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Resort Place: ").append(name).append(", City: ").append(city).append("\n");
        sb.append("_____________\n");
        sb.append("Tourists:\n");
        for (int i = 0; i < touristCount; i++) {
            sb.append(tourists[i].toString()).append("\n");
        }
        sb.append("_____________\n");
        sb.append("Total Income: ").append(getTotalIncome()).append(" USD\n");
        return sb.toString();
    }
}

// Country.java
class Country {
    private String name;
    private ResortPlace[] resortPlaces = new ResortPlace[1000];
    private int resortCount = 0;

    // Default constructor
    public Country() {
    }

    // Parameterized constructor
    public Country(String name) {
        this.name = name;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Add resort
    public void addResort(ResortPlace resort) {
        if (resortCount < resortPlaces.length) {
            resortPlaces[resortCount] = resort;
            resortCount++;
        }
    }

    // Print all resorts
    public void printAllResorts() {
        for (int i = 0; i < resortCount; i++) {
            System.out.println(resortPlaces[i].getName());
        }
    }

    // Get total income
    public double getTotalIncome() {
        double totalIncome = 0;
        for (int i = 0; i < resortCount; i++) {
            totalIncome += resortPlaces[i].getTotalIncome();
        }
        return totalIncome;
    }

    // Get total tourists
    public int getTotalTourists() {
        int totalTourists = 0;
        for (int i = 0; i < resortCount; i++) {
            totalTourists += resortPlaces[i].getTotalTourists();
        }
        return totalTourists;
    }

    // Get resort with max income
    public ResortPlace getMaxIncomeResort() {
        ResortPlace maxIncomeResort = null;
        double maxIncome = 0;

        for (int i = 0; i < resortCount; i++) {
            double income = resortPlaces[i].getTotalIncome();
            if (income > maxIncome) {
                maxIncome = income;
                maxIncomeResort = resortPlaces[i];
            }
        }
        return maxIncomeResort;
    }

    // Get richest tourist
    public Tourist getRichestTourist() {
        Tourist richestTourist = null;
        double maxIncome = 0;
        for (int i = 0; i < resortCount; i++) {
            for (int j = 0; j < resortPlaces[i].getTotalTourists(); j++) {
                Tourist tourist = resortPlaces[i].getTourists()[j];
                if (tourist.getIncomeMoney() > maxIncome) {
                    maxIncome = tourist.getIncomeMoney();
                    richestTourist = tourist;
                }
            }
        }
        return richestTourist;
    }

    public ResortPlace[] getResortPlaces() {
        return resortPlaces;
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        // Create a country
        Country country = new Country("Kazakhstan");

        // Create and add resorts
        for (int i = 1; i <= 5; i++) {
            ResortPlace resort = new ResortPlace("Resort" + i, "City" + i);
            // Add tourists to each resort
            for (int j = 1; j <= 5; j++) {
                resort.addTourist(new Tourist("Tourist" + j, j * 100));
            }
            country.addResort(resort);
        }

        // Print all resort names
        System.out.println("Names of all resort places in our country:");
        country.printAllResorts();

        // Print total amount of tourists
        System.out.println("\nTotal amount of tourists in our country: " + country.getTotalTourists());

        // Print total sum of incomes
        System.out.println("Total sum of incomes in our country: " + country.getTotalIncome() + " USD");

        // Print resort data which has maximum value of total income
        ResortPlace maxIncomeResort = country.getMaxIncomeResort();
        System.out.println("\nResort with maximum income:");
        System.out.println(maxIncomeResort);

        // Print the richest tourist in the country
        Tourist richestTourist = country.getRichestTourist();
        System.out.println("The richest tourist in the country: " + richestTourist);
    }
}
