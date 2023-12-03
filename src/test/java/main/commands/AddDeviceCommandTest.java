package main.commands;

import main.devices.Device;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddDeviceCommandTest {
    AddDeviceCommand addDeviceCommand = new AddDeviceCommand("TestDevice", 50);

    @Test
    public void testExecute_CorrectDeviceAdded() {
        // Введення даних пристрою для тестування
        String testName = "TestDevice";
        float testPower = 50.0f;

        // Перевірка, чи правильно доданий пристрій з визначеними параметрами
        addDeviceCommand.execute();
        assertFalse(addDeviceCommand.getDevices().isEmpty());
        Device addedDevice = addDeviceCommand.getDevices().get(0);
        assertEquals(testName, addedDevice.getName());
        assertEquals(testPower, addedDevice.getPower(), 0.001); // Перевірка з деякою точністю
    }
}