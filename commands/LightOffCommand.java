package commands;

import devices.Light;

public class LightOffCommand implements Command {
    private Light light;
    
    public LightOffCommand(Light light) {
        this.setLight(light);
    }

    @Override
    public void execute() {
        this.getLight().off();
    }

    @Override
    public void undo() {
        this.getLight().on();
    }

    public Light getLight() {
        return light;
    }

    public void setLight(Light light) {
        this.light = light;
    }

}
