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
    private String nextLabel; // the label of the next instruction to be executed

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
    public BnzInstruction(String lab, int reg, String label) {
        super(lab, "bnz");
        this.register = reg;
        this.nextLabel = label;

    }

    /**
     * Execute the instruction in the context of the Machine
     *
     * @param m the machine
     */
    @Override
    public void execute(Machine m) {
        // If the contents of register s1 is not zero
        //m.getRegisters().setRegister(register, nextLabel);
    }

    /**
     * String representation of the instruction
     *
     * @return incorporating the value
     */
    @Override
    public String toString() {
        return super.toString() + " register " + register + " value is " + nextLabel;
    }

}
