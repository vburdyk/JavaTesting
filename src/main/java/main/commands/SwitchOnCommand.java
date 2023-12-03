package main.commands;

import main.devices.Device;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SwitchOnCommand implements Command {
    private final Scanner scanner = new Scanner(System.in);
    private final List<Device> devices;
    private final List<Device> switchedOnDevices;

    public SwitchOnCommand(List<Device> devices) {
        this.devices = devices;
        this.switchedOnDevices = new ArrayList<>();
    }

    public List<Device> getSwitchedOnDevices() {
        return switchedOnDevices;
    }

    @Override
    public void execute() {
        if (devices.isEmpty()) {
            System.out.println("There are no created devices, please add at least 1 device");
            return;
        }

        List<Device> turnedOffDevices = new ArrayList<>();

        System.out.println("List of turned off devices: ");
        for (Device device : devices) {
            if (!device.isOn()) {
                turnedOffDevices.add(device);
            }
        }

        if(turnedOffDevices.isEmpty()){
            System.out.println("All of your devices is already turned on. Try to add one more device.");
            return;
        }

        System.out.println("Please, enter the name of the device which you want to turn on: ");
        for (int i = 0; i < turnedOffDevices.size(); i++) {
            System.out.println(i + 1 + ". " + turnedOffDevices.get(i));
        }

        String selectedDeviceName = scanner.nextLine();
        boolean foundDevice = false;
        for (Device device : devices) {
            if (device.getName().equalsIgnoreCase(selectedDeviceName)) {
                foundDevice = true;
                if (device.isOn()) {
                    System.out.println("The selected device is already turned on.");
                } else {
                    device.turnOn();
                    switchedOnDevices.add(device);
                    System.out.println(device.getName() + " turned on.");
                    float totalPower = calculateTotalPower();
                    System.out.println("Total power consumption of all turned on devices: " + totalPower + " watts");
                    System.out.println("List of turned on devices: ");
                    for (int i = 0; i < switchedOnDevices.size(); i++) {
                        if (switchedOnDevices.get(i).isOn()) {
                            System.out.println(i + 1 + ". " + switchedOnDevices.get(i));
                        }
                    }
                }
                break;
            }
        }
        if (!foundDevice) {
            System.out.println("Device not found. Please enter a valid device name.");
        }
    }

    private float calculateTotalPower() {
        float totalPower = 0;
        for (Device device : switchedOnDevices) {
            totalPower += device.getPower();
        }
        return totalPower;
    }
}