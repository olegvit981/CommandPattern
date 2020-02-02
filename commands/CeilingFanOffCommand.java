package commands;

import devices.CeilingFan;

public class CeilingFanOffCommand implements Command {
    private CeilingFan ceilingFan;
    
    public CeilingFanOffCommand(CeilingFan ceilingFan) {
        this.setCeilingFan(ceilingFan);
    }

    @Override
    public void execute() {
        this.getCeilingFan().off();
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

}
