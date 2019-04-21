package sml;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Creates instruction classes dynamically using reflection
 *
 * @author ...
 */
public class InstructionFactory {

    public Instruction create(String label, String line, String ins) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        String instructionClassName = "sml.instructions." + ins.substring(0, 1).toUpperCase() + ins.substring(1) + "Instruction";
        Class instructionClass = Class.forName(instructionClassName);
        String argz = label + line;
        // Split the string into individual arguments
        String[] splitArgs = argz.split(" ");
        // Create array of types
        Class[] argTypes = new Class[splitArgs.length];
        for (int x = 0; x < splitArgs.length; x++) {
            try {
                // Check if the input can be parsed to an int, if so assign integertype to the argTypes array
                // If its not an int allow string type to be assigned
                Integer.parseInt(splitArgs[x]);
                argTypes[x] = int.class;
            } catch (NumberFormatException e) {
                argTypes[x] = splitArgs[x].getClass();
            }
        }
        // Get the required constructor
        //throwing no such method exception.
        Constructor insConstructor = instructionClass.getDeclaredConstructor(argTypes);
        // Create object array to pass as arguments
        Object[] objs = new Object[splitArgs.length];
        for (int i = 0; i < objs.length; i++) {
            if (argTypes[i] == int.class) {
                objs[i] = Integer.parseInt(splitArgs[i]);
            } else {
                objs[i] = splitArgs[i];
            }
        }
        // Now the create an instance of the object
        return (Instruction) insConstructor.newInstance(objs);


    }
}
