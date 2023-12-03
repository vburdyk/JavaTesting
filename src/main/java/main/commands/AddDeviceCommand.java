package main.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.devices.Device;

public class AddDeviceCommand implements Command {
    private final List<Device> devices = new ArrayList<>();

    String name;
    float power;

    public AddDeviceCommand(String name, float power) {
        this.name = name;
        this.power = power;
    }

    public List<Device> getDevices() {
        return devices;
    }

    @Override
    public void execute() {

        Device newDevice = new Device();
        newDevice.setName(name);
        newDevice.setPower(power);

        devices.add(newDevice);
        System.out.println("Device " + newDevice.getName() + " successfully created!");

        System.out.println("List of devices: ");

        for (int i = 0; i < devices.size(); i++) {
            System.out.println(i + 1 + ". " + devices.get(i));
        }
    }

}
