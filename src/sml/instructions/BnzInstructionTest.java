package sml.instructions;

import org.junit.Test;
import sml.Instruction;
import sml.Machine;
import sml.Registers;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class BnzInstructionTest {
    private final Machine mtest = new Machine();
    private Registers registers = new Registers();
    private  List<Instruction> prog = new ArrayList<>();

    @Test
    public void execute() {
        prog.add(new LinInstruction("L0", 0, 1));
        prog.add(new LinInstruction("L1", 0, -1));
        registers.setRegister(3, 10); // set register 3 to 10
        mtest.setRegisters(registers); // pass the registers to the machine to use
        // set the pc so we know we went backwards
        mtest.setPc(3);
        BnzInstruction bnzInstruction = new BnzInstruction("L2",3, "L0");
        // Should set program counter to the index the label is present in.
        bnzInstruction.execute(mtest);
        assertEquals(0,mtest.getPc());


    }

    @Test
    public void testtoString() {
    }
}