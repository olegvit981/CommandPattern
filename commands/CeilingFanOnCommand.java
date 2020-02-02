package commands;

import devices.CeilingFan;
import devices.Speed;

public class CeilingFanOnCommand implements Command {
    private CeilingFan ceilingFan;
    private Speed speed;
    
    public CeilingFanOnCommand(CeilingFan ceilingFan, Speed speed) {
        this.setCeilingFan(ceilingFan);
        this.setSpeed(speed);
    }

    @Override
    public void execute() {
        CeilingFan fan = this.getCeilingFan();
        fan.on();
        switch (getSpeed()) {
        case OFF:
            break;
        case LOW:
            fan.low();
            break;
        case MEDIUM:
            fan.medium();
            break;
        case HIGH:
            fan.high();
            break;
        default:
            break;
        }
    }

    @Override
    public void undo() {
        CeilingFan fan = this.getCeilingFan();
        if (fan.undoState().booleanValue()) {
            fan.undoOn();
            fan.undoSpeed();
        } else {
            fan.undoOff();
        }
    }

    public CeilingFan getCeilingFan() {
        return ceilingFan;
    }

    public void setCeilingFan(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    public Speed getSpeed() {
        return speed;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

}
