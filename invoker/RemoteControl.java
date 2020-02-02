package invoker;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import commands.NoCommand;
import commands.Command;

public class RemoteControl {
    private List<Command> onCommands;
    private List<Command> offCommands;
    private Collection<Command> undoCommands;
    
    public RemoteControl() {
        onCommands = new LinkedList<>();
        offCommands = new LinkedList<>();
        undoCommands = new ArrayDeque<>();
        
        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands.add(noCommand);
            offCommands.add(noCommand);
        }
    }
    
    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands.set(slot, onCommand);
        offCommands.set(slot, offCommand);
    }
    
    public void onButtonWasPushed(int slot) {
        onCommands.get(slot).execute();
        ((ArrayDeque<Command>)undoCommands).push(onCommands.get(slot));
    }
    
    public void offButtonWasPushed(int slot) {
        offCommands.get(slot).execute();
        ((ArrayDeque<Command>)undoCommands).push(offCommands.get(slot));
    }
    
    public void undoButtonWasPushed() {
        if (((ArrayDeque<Command>)undoCommands).isEmpty()) {
            System.out.println("No command to \"undo\"");
        } else {
            ((ArrayDeque<Command>)undoCommands).pop().undo();
        }
    }
    
    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("\n------ Remote Control -------\n");
        for (int i = 0; i < onCommands.size(); i++) {
            buffer.append("[slot " + i + "] " + onCommands.get(i).getClass().getName());
            for (int j = 0; j < (62 - onCommands.get(i).getClass().getName().length()); j++) {
                buffer.append(' ');
            }
            buffer.append(offCommands.get(i).getClass().getName() + "\n");
        }
        return buffer.toString();
    }

}
