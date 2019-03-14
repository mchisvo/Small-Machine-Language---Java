package sml;

import java.lang.reflect.Constructor;


public class reflectplay {
    public static void main(String[] args) throws Exception { // Add this so you don't have lots of try catch blocks
        Class instructionClass = Class.forName("AddInstruction"); // need to capitalise the first letter of the operation
        String argz = "L0 1 2 3";
        // Split the string into individual arguments
        String[] splitArgs = argz.split(" ");
        // Check we have an array with 4 elements
        System.out.println(splitArgs.length);

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
            System.out.println(splitArgs[x] + " has type " + argTypes[x]);
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
        Instruction ins = (Instruction) insConstructor.newInstance(objs);
        System.out.println(ins);


    }
}