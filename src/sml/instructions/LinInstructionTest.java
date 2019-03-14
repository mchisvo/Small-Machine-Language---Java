package sml.instructions;

import org.junit.Test;
import sml.Machine;
import sml.Registers;

import static junit.framework.TestCase.assertEquals;

public class LinInstructionTest {
    private final Machine mtest = new Machine();
    private Registers registers =  Registers.getInstance();

    @Test
    public void execute() {
        mtest.setRegisters(registers);
        LinInstruction loadInstruction = new LinInstruction("L1", 0, 5);
        LinInstruction loadInstruction2 = new LinInstruction("L2", 31, 10);
        loadInstruction.execute(mtest);
        loadInstruction2.execute(mtest);
        // Check register 0 is 5
        assertEquals(5,mtest.getRegisters().getRegister(0));
        // Check register 31 is 10
        assertEquals(10,mtest.getRegisters().getRegister(31));


    }

    @Test
    public void testtoString() {
        assertEquals("L1: lin register 0 value is 5", new LinInstruction("L1", 0, 5).toString());
    }
}