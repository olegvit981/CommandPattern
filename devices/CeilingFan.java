package devices;

import java.util.ArrayDeque;

public class CeilingFan implements Device {
    private boolean state;
    private String location;
    private Speed speed;
    private ArrayDeque<Speed> speedsStack;
    private ArrayDeque<Boolean> previousStates;
    
    public CeilingFan(String location) {
        this.setLocation(location);
        this.setState(false);
        this.setSpeed(Speed.OFF);
        speedsStack = new ArrayDeque<>();
        speedsStack.push(Speed.OFF);
        previousStates = new ArrayDeque<>();
    }

    @Override
    public void on() {
        previousStates.push(new Boolean(isState()));
        this.setState(true);
        System.out.println(getLocation() + " ceiling fan is on");
    }

    @Override
    public void off() {
        speedsStack.push(getSpeed());
        this.setSpeed(Speed.OFF);
        previousStates.push(new Boolean(isState()));
        this.setState(false);
        System.out.println(getLocation() + " ceiling fan is off");
    }

    public void low() {
        speedsStack.push(getSpeed());
        this.setSpeed(Speed.LOW);
        System.out.println(getLocation() + " ceiling fan is on low");
    }
    
    public void medium() {
        speedsStack.push(getSpeed());
        this.setSpeed(Speed.MEDIUM);
        System.out.println(getLocation() + " ceiling fan is on medium");
    }
    
    public void high() {
        speedsStack.push(getSpeed());
        this.setSpeed(Speed.HIGH);
        System.out.println(getLocation() + " ceiling fan is on high");
    }
    
    public void undoOn() {
        this.setState(true);
        System.out.println(getLocation() + " ceiling fan is on");
    }
    
    public void undoOff() {
        this.setSpeed(Speed.OFF);
        this.setState(false);
        System.out.println(getLocation() + " ceiling fan is off");
    }
    
    public Speed undoSpeed() {
        if (speedsStack.isEmpty()) {
            speedsStack.push(Speed.OFF);
        }
        Speed speed = speedsStack.pop();
        switch (speed) {
        case OFF:
            this.setSpeed(Speed.OFF);
            break;
        case LOW:
            this.setSpeed(speed);
            System.out.println(getLocation() + " ceiling fan is on low");
            break;
        case MEDIUM:
            this.setSpeed(speed);
            System.out.println(getLocation() + " ceiling fan is on medium");
            break;
        case HIGH:
            this.setSpeed(speed);
            System.out.println(getLocation() + " ceiling fan is on high");
            break;
        default:
            break;
        }
        return speed;
    }
    
    public Boolean undoState() {
        if (previousStates.isEmpty()) {
            previousStates.push(new Boolean(false));
        }
        return previousStates.pop();
    }
    
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Speed getSpeed() {
        return speed;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }
    
    public String showBooleanStack() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("\n------ Ceiling Fan \"" + getLocation() +"\" Boolean Stack -------\n");
        Object[] states = previousStates.toArray();
        for (int i = 0; i < previousStates.size(); i++) {
            buffer.append("[slot " + i + "] " + states[i] + "\n");
        }
        return buffer.toString();
    }

}
