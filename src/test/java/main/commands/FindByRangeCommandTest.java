package main.commands;

import main.devices.Device;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class FindByRangeCommandTest {

    @Test
    public void testExecute() {
        List<Device> devicesList = new ArrayList<>();
        devicesList.add(new Device("Device1", 30));
        devicesList.add(new Device("Device2", 40));
        devicesList.add(new Device("Device3", 50));
        devicesList.add(new Device("Device4", 60));

        float initialLimit = 20;
        float finalLimit = 50;

        FindByRangeCommand findByRangeCommand = new FindByRangeCommand(devicesList, initialLimit, finalLimit);

        findByRangeCommand.execute();

        List<Device> foundDevices = findByRangeCommand.getDevicesWithinRange();
        assertEquals(3, foundDevices.size());
        for (Device device : foundDevices) {
            float power = device.getPower();
            assertTrue(power >= initialLimit && power <= finalLimit);
        }
    }
}