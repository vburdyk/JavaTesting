package main.commands;

import main.devices.Device;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ShowDeviceCommandTest {

    @Test
    public void testExecute() {
        List<Device> devices = new ArrayList<>();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        devices.add(new Device("Device1", 30));

        ShowDeviceCommand showDeviceCommand = new ShowDeviceCommand(devices);

        showDeviceCommand.execute();

        String expectedOutput = "List of devices: \r\n1. Device{name='Device1', power=30.0, isOn=false}\r\n";
        String actualOutput = outputStream.toString();

        assertEquals(expectedOutput, actualOutput);
    }
}