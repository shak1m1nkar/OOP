package lab10ooop;

abstract class Battery {
    public abstract double getPower();
    public abstract double getLifeTime();
}

class ToshibaBattery extends Battery {
    private double voltage; // Voltage in volts
    private double currency; // Currency in amperes
    private double energy; // Total energy in joules
    private double extraEnergy; // Extra energy in joules

    // Constructors
    public ToshibaBattery() {}

    public ToshibaBattery(double voltage, double currency, double energy, double extraEnergy) {
        this.voltage = voltage;
        this.currency = currency;
        this.energy = energy;
        this.extraEnergy = extraEnergy;
    }

    // Getters and Setters
    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public double getCurrency() {
        return currency;
    }

    public void setCurrency(double currency) {
        this.currency = currency;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public double getExtraEnergy() {
        return extraEnergy;
    }

    public void setExtraEnergy(double extraEnergy) {
        this.extraEnergy = extraEnergy;
    }

    @Override
    public double getPower() {
        return voltage * currency;
    }

    @Override
    public double getLifeTime() {
        return (energy + extraEnergy) / getPower();
    }

    @Override
    public String toString() {
        return "ToshibaBattery{" +
                "voltage=" + voltage +
                ", currency=" + currency +
                ", energy=" + energy +
                ", extraEnergy=" + extraEnergy +
                ", power=" + getPower() +
                ", lifeTime=" + getLifeTime() +
                '}';
    }
}

class DuracellBattery extends Battery {
    private double voltage; // Voltage in volts
    private double currency; // Currency in amperes
    private double energy; // Total energy in joules
    private double internalVoltage; // Internal voltage of battery in volts. (ɛ - epsilon)

    // Constructors
    public DuracellBattery() {}

    public DuracellBattery(double voltage, double currency, double energy, double internalVoltage) {
        this.voltage = voltage;
        this.currency = currency;
        this.energy = energy;
        this.internalVoltage = internalVoltage;
    }

    // Getters and Setters
    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public double getCurrency() {
        return currency;
    }

    public void setCurrency(double currency) {
        this.currency = currency;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public double getInternalVoltage() {
        return internalVoltage;
    }

    public void setInternalVoltage(double internalVoltage) {
        this.internalVoltage = internalVoltage;
    }

    @Override
    public double getPower() {
        return (voltage - internalVoltage) * currency;
    }

    @Override
    public double getLifeTime() {
        return energy / getPower();
    }

    @Override
    public String toString() {
        return "DuracellBattery{" +
                "voltage=" + voltage +
                ", currency=" + currency +
                ", energy=" + energy +
                ", internalVoltage=" + internalVoltage +
                ", power=" + getPower() +
                ", lifeTime=" + getLifeTime() +
                '}';
    }
}

class FlashLight {
    private Battery[] batteries;

    // Constructors
    public FlashLight() {}

    public FlashLight(Battery[] batteries) {
        this.batteries = batteries;
    }

    // Getters and Setters
    public Battery[] getBatteries() {
        return batteries;
    }

    public void setBatteries(Battery[] batteries) {
        this.batteries = batteries;
    }

    public double getTotalPower() {
        double totalPower = 0;
        for (Battery battery : batteries) {
            totalPower += battery.getPower();
        }
        return totalPower;
    }

    public double getTotalEnergy() {
        double totalEnergy = 0;
        for (Battery battery : batteries) {
            totalEnergy += battery.getLifeTime() * battery.getPower();
        }
        return totalEnergy;
    }

    public double getTotalLifeTime() {
        return getTotalEnergy() / getTotalPower();
    }

    @Override
    public String toString() {
        return "FlashLight{" +
                "batteries=" + java.util.Arrays.toString(batteries) +
                ", totalPower=" + getTotalPower() +
                ", totalEnergy=" + getTotalEnergy() +
                ", totalLifeTime=" + getTotalLifeTime() +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        // Create 5 Toshiba batteries
        ToshibaBattery tb1 = new ToshibaBattery(3.7, 2.0, 10000, 500);
        ToshibaBattery tb2 = new ToshibaBattery(3.6, 1.8, 9000, 450);
        ToshibaBattery tb3 = new ToshibaBattery(3.8, 2.1, 11000, 550);
        ToshibaBattery tb4 = new ToshibaBattery(3.5, 2.2, 12000, 600);
        ToshibaBattery tb5 = new ToshibaBattery(3.9, 1.9, 9500, 475);

        // Create 5 Duracell batteries
        DuracellBattery db1 = new DuracellBattery(1.5, 2.0, 5000, 0.1);
        DuracellBattery db2 = new DuracellBattery(1.6, 1.8, 4500, 0.2);
        DuracellBattery db3 = new DuracellBattery(1.4, 2.1, 5500, 0.3);
        DuracellBattery db4 = new DuracellBattery(1.7, 2.2, 6000, 0.2);
        DuracellBattery db5 = new DuracellBattery(1.8, 1.9, 4750, 0.1);

        // Create 5 FlashLights with different parameters
        FlashLight fl1 = new FlashLight(new Battery[]{tb1, db1});
        FlashLight fl2 = new FlashLight(new Battery[]{tb2, db2});
        FlashLight fl3 = new FlashLight(new Battery[]{tb3, db3});
        FlashLight fl4 = new FlashLight(new Battery[]{tb4, db4});
        FlashLight fl5 = new FlashLight(new Battery[]{tb5, db5});

        FlashLight[] flashLights = {fl1, fl2, fl3, fl4, fl5};

        // Print lifetimes of all flashlights
        for (FlashLight flashLight : flashLights) {
            System.out.println(flashLight);
        }

        // Find and print the flashlight with the maximum lifetime
        FlashLight maxLifeTimeFlashLight = flashLights[0];
        for (FlashLight flashLight : flashLights) {
            if (flashLight.getTotalLifeTime() > maxLifeTimeFlashLight.getTotalLifeTime()) {
                maxLifeTimeFlashLight = flashLight;
            }
        }
        System.out.println("Flashlight with maximum lifetime: " + maxLifeTimeFlashLight);
    }
}

