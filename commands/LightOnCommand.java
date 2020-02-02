package commands;

import devices.Light;

public class LightOnCommand implements Command {
    private Light light;
    
    public LightOnCommand(Light light) {
        this.setLight(light);
    }

    @Override
    public void execute() {
        this.getLight().on();
    }

    @Override
    public void undo() {
        this.getLight().off();
    }

    public Light getLight() {
        return light;
    }

    public void setLight(Light light) {
        this.light = light;
    }

}
