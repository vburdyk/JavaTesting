package main.commands;

import main.devices.Device;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SortDeviceCommand implements Command {
    private final Scanner scanner = new Scanner(System.in);
    private final List<Device> devices;

    public SortDeviceCommand(List<Device> devices) {
        this.devices = devices;
    }

    @Override
    public void execute() {
        if (devices.isEmpty()) {
            System.out.println("There are no devices to sort.");
            return;
        }

        System.out.println("Choose sorting order: ");
        System.out.println("1. Sort by power ascending");
        System.out.println("2. Sort by power descending");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                sortByPowerAscending(devices);
                System.out.println("Devices sorted by power in ascending order.");
                printSortedDevices(devices);
                break;
            case 2:
                sortByPowerDescending(devices);
                System.out.println("Devices sorted by power in descending order.");
                printSortedDevices(devices);
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }
    public static void sortByPowerAscending(List<Device> devices) {
        devices.sort(Comparator.comparing(Device::getPower));
    }

    public static void sortByPowerDescending(List<Device> devices) {
        devices.sort(Comparator.comparing(Device::getPower).reversed());
    }

    public static void printSortedDevices(List<Device> devices){
        for (int i = 0; i < devices.size(); i++) {
            System.out.println(i + 1 + ". " + devices.get(i));
        }
    }
}
