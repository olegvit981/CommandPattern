package commands;

import devices.GarageDoor;

public class GarageDoorUpCommand implements Command {
    private GarageDoor garageDoor;
    
    public GarageDoorUpCommand(GarageDoor garageDoor) {
        this.setGarageDoor(garageDoor);
    }

    @Override
    public void execute() {
        GarageDoor door = this.getGarageDoor();
        door.on();
        if (door.isState()) {
            door.up();
        }
    }

    @Override
    public void undo() {
        GarageDoor door = this.getGarageDoor();
        if (door.isState()) {
            door.down();
        } else {
            door.on();
            door.down();
        }
        door.off();
    }

    public GarageDoor getGarageDoor() {
        return garageDoor;
    }

    public void setGarageDoor(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

}
