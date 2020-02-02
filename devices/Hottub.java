package devices;

public class Hottub implements Device {
    private boolean state = false;
    private int temperature;

    @Override
    public void on() {
        this.state = true;
    }

    @Override
    public void off() {
        this.state = false;
    }
    
    public void bubblesOn() {
        if (isState()) {
            System.out.println("Hottub is bubbling");
        }
    }
    
    public void bubblesOff() {
        if (isState()) {
            System.out.println("Hottub is not bubbling");
        }
    }
    
    public void jetsOn() {
        if (isState()) {
            System.out.println("Hottub jets are on");
        }
    }
    
    public void jetsOff() {
        if (isState()) {
            System.out.println("Hottub jets are off");
        }
    }
    
    public void cool() {
        this.setTemperature(98);
        System.out.println("Hottub is cooling to 98 degrees");
    }
    
    public void heat() {
        this.setTemperature(105);
        System.out.println("Hottub is heating to a steaming 105 degrees");
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public boolean isState() {
        return state;
    }

}
