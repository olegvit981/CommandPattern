package commands;

import devices.GarageDoor;

public class GarageDoorDownCommand implements Command {
    private GarageDoor garageDoor;
    
    public GarageDoorDownCommand(GarageDoor garageDoor) {
        this.setGarageDoor(garageDoor);
    }

    @Override
    public void execute() {
        GarageDoor door = this.getGarageDoor();
        if (door.isState()) {
            
        } else {
            door.on();
        }
        door.down();
        door.off();
    }

    @Override
    public void undo() {
        GarageDoor door = this.getGarageDoor();
        if (door.isState()) {
            door.up();
        } else {
            door.on();
            door.up();
        }
    }

    public GarageDoor getGarageDoor() {
        return garageDoor;
    }

    public void setGarageDoor(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

}
