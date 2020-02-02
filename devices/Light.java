package devices;

public class Light implements Device {
    private String location;
    
    public Light(String location) {
        this.setLocation(location);
    }

    @Override
    public void on() {
        System.out.println(getLocation() + " light is on");
    }

    @Override
    public void off() {
        System.out.println(getLocation() + " light is off");
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
