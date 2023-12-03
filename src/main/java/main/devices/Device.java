package main.devices;

public class Device {
    private String name;
    private float power;
    private boolean isOn;

    public Device(String name, float power){
        this.name = name;
        this.power = power;
        this.isOn = false;
    }
    public Device(){}

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public float getPower() {
        return power;
    }

    public void setPower(float power) {
        this.power = power;
    }

    public boolean isOn() {
        return isOn;
    }

    public void turnOn(){
        isOn = true;
    }
    public void turnOff(){
        isOn = false;
    }

    @Override
    public String toString() {
        return "Device{" +
                "name='" + name + '\'' +
                ", power=" + power +
                ", isOn=" + isOn +
                '}';
    }
}
