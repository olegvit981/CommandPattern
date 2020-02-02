package devices;

public class Stereo implements Device {
    private boolean state = false;
    private String location;
    private int volume;
    
    public Stereo(String location) {
        this.setLocation(location);
    }

    @Override
    public void on() {
        this.setState(true);
        System.out.println(getLocation() + " stereo is on");
    }

    @Override
    public void off() {
        this.setState(false);
        System.out.println(getLocation() + " stereo is off");
    }
    
    public void setCD() {
        System.out.println(getLocation() + " stereo is set for CD input");
    }
    
    public void setDVD() {
        System.out.println(getLocation() + " stereo is set for DVD input");
    }
    
    public void setRadio() {
        System.out.println(getLocation() + " stereo is set for Radio");
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

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

}
