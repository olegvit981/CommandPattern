package devices;

public class GarageDoor implements Device {
    private boolean state = false;
    private String location;
    
    public GarageDoor(String location) {
        this.setLocation(location);
    }

    @Override
    public void on() {
        this.setState(true);
        System.out.println(getLocation() + " garage Door is on");
    }

    @Override
    public void off() {
        this.setState(false);
        System.out.println(getLocation() + " garage Door is off");
    }
    
    public void up() {
        System.out.println(getLocation() + " garage Door is Up");
    }
    
    public void down() {
        System.out.println(getLocation() + " garage Door is Down");
    }
    
    public void stop() {
        System.out.println(getLocation() + " garage Door is Stopped");
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

}
