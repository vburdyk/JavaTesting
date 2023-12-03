package main.commands;

import main.devices.Device;

import java.util.List;

public class ShowDeviceCommand implements Command {
    List<Device> devices;

    public ShowDeviceCommand(List<Device> devices) {
        this.devices = devices;
    }

    @Override
    public void execute() {
        System.out.println("List of devices: ");
        for (int i = 0; i < devices.size(); i++) {
            System.out.println(i + 1 + ". " + devices.get(i));
        }
    }
}
