package main.commands;

import main.devices.Device;

import java.util.List;
import java.util.Scanner;

public class SwitchOffCommand implements Command {
    private final Scanner scanner = new Scanner(System.in);
    private final List<Device> devices;
    private final List<Device> switchedOnDevices;

    public SwitchOffCommand(List<Device> devices, List<Device> switchedOnDevices) {
        this.devices = devices;
        this.switchedOnDevices = switchedOnDevices;
    }

    @Override
    public void execute() {
        if (devices.isEmpty()) {
            System.out.println("There are no created devices, please add at least 1 device");
            return;
        }
        boolean anyDeviceSwitchedOn = false;
        for (Device device : devices) {
            if (device.isOn()) {
                anyDeviceSwitchedOn = true;
                break;
            }
        }
        if (!anyDeviceSwitchedOn) {
            System.out.println("There are no switched on devices");
            return;
        }

        System.out.println("Please, enter the name of the device which you want to turn off: ");

        for (int i = 0; i < switchedOnDevices.size(); i++) {
            if (switchedOnDevices.get(i).isOn()) {
                System.out.println(i + 1 + ". " + switchedOnDevices.get(i));
            }
        }

        String selectedDeviceName = scanner.nextLine();
        boolean foundDevice = false;
        for (Device device : devices) {
            if (device.getName().equalsIgnoreCase(selectedDeviceName)) {
                foundDevice = true;
                if (!device.isOn()) {
                    System.out.println("The selected device is already turned off.");
                } else {
                    device.turnOff();
                    switchedOnDevices.remove(device);
                    System.out.println(device.getName() + " turned off. ");
                }
                break;
            }
        }

        if (!foundDevice) {
            System.out.println("Device not found. Please enter a valid device name.");
        }
    }
}