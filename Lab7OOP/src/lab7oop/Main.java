package lab7oop;

class Worker {
    private String fullName;
    private double energy; // in kilojoules - KJ
    private double power; // in kilowatts - KW
    private double efficiency; // efficiency coefficient, take from 0.1 to 0.4

    // Constructors
    public Worker() {}

    public Worker(String fullName, double energy, double power, double efficiency) {
        this.fullName = fullName;
        this.energy = energy;
        this.power = power;
        this.efficiency = efficiency;
    }

    // Getters and Setters
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public double getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(double efficiency) {
        this.efficiency = efficiency;
    }

    // toString method
    @Override
    public String toString() {
        return "Worker{" +
                "fullName='" + fullName + '\'' +
                ", energy=" + energy +
                ", power=" + power +
                ", efficiency=" + efficiency +
                '}';
    }

    // toWork method
    public double toWork(int time) {
        double totalWorkDone = 0;
        for (int i = 0; i < time; i++) {
            double workDone = (power * 1) * efficiency;
            if (energy <= 0) {
                break;
            }
            energy -= workDone;
            totalWorkDone += workDone;
        }
        return totalWorkDone;
    }
}

class Programmer extends Worker {
    private double moralMotivation; // Moral motivation coefficient of a programmer from 0.5 to 2.

    // Constructors
    public Programmer() {}

    public Programmer(String fullName, double energy, double power, double efficiency, double moralMotivation) {
        super(fullName, energy, power, efficiency);
        this.moralMotivation = moralMotivation;
    }

    // Getters and Setters
    public double getMoralMotivation() {
        return moralMotivation;
    }

    public void setMoralMotivation(double moralMotivation) {
        this.moralMotivation = moralMotivation;
    }

    // toString method
    @Override
    public String toString() {
        return "Programmer{" +
                "fullName='" + getFullName() + '\'' +
                ", energy=" + getEnergy() +
                ", power=" + getPower() +
                ", efficiency=" + getEfficiency() +
                ", moralMotivation=" + moralMotivation +
                '}';
    }

    // Overridden toWork method
    @Override
    public double toWork(int time) {
        double totalWorkDone = 0;
        for (int i = 0; i < time; i++) {
            double workDone = (getPower() * 1) * getEfficiency() * moralMotivation;
            if (getEnergy() <= 0) {
                break;
            }
            setEnergy(getEnergy() - workDone);
            totalWorkDone += workDone;
        }
        return totalWorkDone;
    }
}

class Teacher extends Worker {
    private double tiredness; // Tiredness coefficient of a teacher from 0.01 to 0.1

    // Constructors
    public Teacher() {}

    public Teacher(String fullName, double energy, double power, double efficiency, double tiredness) {
        super(fullName, energy, power, efficiency);
        this.tiredness = tiredness;
    }

    // Getters and Setters
    public double getTiredness() {
        return tiredness;
    }

    public void setTiredness(double tiredness) {
        this.tiredness = tiredness;
    }

    // toString method
    @Override
    public String toString() {
        return "Teacher{" +
                "fullName='" + getFullName() + '\'' +
                ", energy=" + getEnergy() +
                ", power=" + getPower() +
                ", efficiency=" + getEfficiency() +
", tiredness=" + tiredness +
                '}';
    }

    // Overridden toWork method
    @Override
    public double toWork(int time) {
        double totalWorkDone = 0;
        double currentEfficiency = getEfficiency();
        for (int i = 0; i < time; i++) {
            double workDone = (getPower() * 1) * currentEfficiency;
            if (getEnergy() <= 0) {
                break;
            }
            setEnergy(getEnergy() - workDone);
            totalWorkDone += workDone;
            currentEfficiency -= tiredness;
        }
        return totalWorkDone;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create 5 programmers
        Programmer p1 = new Programmer("Programmer One", 500, 100, 0.3, 1.5);
        Programmer p2 = new Programmer("Programmer Two", 600, 90, 0.35, 1.2);
        Programmer p3 = new Programmer("Programmer Three", 550, 110, 0.25, 1.7);
        Programmer p4 = new Programmer("Programmer Four", 480, 85, 0.4, 1.0);
        Programmer p5 = new Programmer("Programmer Five", 620, 95, 0.32, 1.4);

        // Create 5 teachers
        Teacher t1 = new Teacher("Teacher One", 700, 80, 0.3, 0.05);
        Teacher t2 = new Teacher("Teacher Two", 650, 75, 0.35, 0.03);
        Teacher t3 = new Teacher("Teacher Three", 600, 70, 0.25, 0.04);
        Teacher t4 = new Teacher("Teacher Four", 550, 85, 0.4, 0.02);
        Teacher t5 = new Teacher("Teacher Five", 720, 78, 0.32, 0.06);

        // Put them into one-dimensional array
        Worker[] workers = {p1, p2, p3, p4, p5, t1, t2, t3, t4, t5};

        // a. The total work done by all workers in 5 hours.
        double totalWork5Hours = 0;
        for (Worker worker : workers) {
            totalWork5Hours += worker.toWork(5);
        }
        System.out.println("Total work done by all workers in 5 hours: " + totalWork5Hours);

        // b. The total work done by all workers in 10 hours.
        double totalWork10Hours = 0;
        for (Worker worker : workers) {
            totalWork10Hours += worker.toWork(10);
        }
        System.out.println("Total work done by all workers in 10 hours: " + totalWork10Hours);

        // c. Print total work done by each worker in 10 hours.
        for (Worker worker : workers) {
            System.out.println(worker.getFullName() + " total work done in 10 hours: " + worker.toWork(10));
        }

        // d. The worker data (It may be teacher or programmer) with maximum power
        Worker maxPowerWorker = workers[0];
        for (Worker worker : workers) {
            if (worker.getPower() > maxPowerWorker.getPower()) {
                maxPowerWorker = worker;
            }
        }
        System.out.println("Worker with maximum power: " + maxPowerWorker);

        // e. The worker data (It may be teacher or programmer) with maximum work done in 10 hours
        Worker maxWorkDoneWorker = workers[0];
        double maxWorkDone = maxWorkDoneWorker.toWork(10);
        for (Worker worker : workers) {
            double workDone = worker.toWork(10);
            if (workDone > maxWorkDone) {
                maxWorkDoneWorker = worker;
                maxWorkDone = workDone;
            }
        }
        System.out.println("Worker with maximum work done in 10 hours: " + maxWorkDoneWorker);
    }
}
