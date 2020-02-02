package main;

import java.net.MalformedURLException;
import java.nio.file.Paths;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import commands.GarageDoorDownCommand;
import commands.GarageDoorUpCommand;
import commands.CeilingFanOffCommand;
import commands.CeilingFanOnCommand;
import commands.Command;
import commands.LightOffCommand;
import commands.LightOnCommand;
import devices.CeilingFan;
import devices.GarageDoor;
import devices.Light;
import devices.Speed;
import invoker.RemoteControl;

public class RemoteLoader01 {
    static {
        try {
            new DOMConfigurator().doConfigure(Paths.get("context\\log4j.xml").toUri().toURL(), LogManager.getLoggerRepository());
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
    }
    private static Logger logger = Logger.getLogger(RemoteLoader01.class);

    public static void main(String[] args) {
        logger.info("Starting application...");
        RemoteControl remoteControl = new RemoteControl();
        
        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");
        GarageDoor garageDoor = new GarageDoor("Garage One");
        CeilingFan livingRoomFan = new CeilingFan("Living Room");
        
        Command livingRoomLightOn = new LightOnCommand(livingRoomLight);
        Command livingRoomLightOff = new LightOffCommand(livingRoomLight);
        Command kitchenLightOn = new LightOnCommand(kitchenLight);
        Command kitchenLightOff = new LightOffCommand(kitchenLight);
        
        Command garageDoorUp = new GarageDoorUpCommand(garageDoor);
        Command garageDoorDown = new GarageDoorDownCommand(garageDoor);
        
        Command livingRoomFanOnLow = new CeilingFanOnCommand(livingRoomFan, Speed.LOW);
        Command livingRoomFanOnMedium = new CeilingFanOnCommand(livingRoomFan, Speed.MEDIUM);
        Command livingRoomFanOff = new CeilingFanOffCommand(livingRoomFan);
        
        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
        remoteControl.setCommand(2, garageDoorUp, garageDoorDown);
        remoteControl.setCommand(3, livingRoomFanOnLow, livingRoomFanOff);
        remoteControl.setCommand(4, livingRoomFanOnMedium, livingRoomFanOff);
        
        logger.info(remoteControl);
        
        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        remoteControl.onButtonWasPushed(1);
        remoteControl.undoButtonWasPushed();
        remoteControl.undoButtonWasPushed();
        remoteControl.undoButtonWasPushed();
        remoteControl.undoButtonWasPushed();
        remoteControl.undoButtonWasPushed();
        remoteControl.offButtonWasPushed(1);
        remoteControl.onButtonWasPushed(2);
        remoteControl.offButtonWasPushed(2);
        remoteControl.onButtonWasPushed(3);
        remoteControl.onButtonWasPushed(4);
        System.out.println(livingRoomFan.showBooleanStack());
        remoteControl.undoButtonWasPushed();
        remoteControl.undoButtonWasPushed();
        remoteControl.undoButtonWasPushed();
        remoteControl.undoButtonWasPushed();
    }
