package main.commands;

import main.devices.Device;

import main.devices.Device;

import java.util.ArrayList;
import java.util.List;

public class FindByRangeCommand implements Command {

    private final List<Device> devices;
    private final List<Device> rangeDevices = new ArrayList<>();
    private final float initPower;
    private final float finalPower;

    public FindByRangeCommand(List<Device> devices, float initPower, float finalPower) {
        this.devices = devices;
        this.initPower = initPower;
        this.finalPower = finalPower;
    }

    @Override
    public void execute() {
        System.out.println("Devices from " + initPower + " watts to " + finalPower + " watts");
        for (int i = 0; i < devices.size(); i++) {
            if (devices.get(i).getPower() >= initPower && devices.get(i).getPower() <= finalPower) {
                System.out.println(i + 1 + ". " + devices.get(i));
                rangeDevices.add(devices.get(i));
            }
        }
    }

    public List<Device> getDevicesWithinRange() {
        return rangeDevices;
    }
}
