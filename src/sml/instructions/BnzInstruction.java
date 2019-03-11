package sml.instructions;

import sml.Instruction;
import sml.Machine;

/**
 * The Branch Instruction class
 *
 * @author ...
 */
public class BnzInstruction extends Instruction {

    private int register;
    private int value;

    /**
     * @param lab
     * @param op
     */
    public BnzInstruction(String lab, String op) {
        super(lab, op);
    }

    /**
     * Initialise the instruction
     *
     * @param lab of the instruction
     * @param reg to work with
     * @param val to load
     */
    public BnzInstruction(String lab, int reg, int val) {
        super(lab, "lin");
        this.register = reg;
        this.value = val;

    }

    /**
     * Execute the instruction in the context of the Machine
     *
     * @param m the machine
     */
    @Override
    public void execute(Machine m) {
        m.getRegisters().setRegister(register, value);
    }

    /**
     * String representation of the instruction
     *
     * @return incorporating the value
     */
    @Override
    public String toString() {
        return super.toString() + " register " + register + " value is " + value;
    }

}
