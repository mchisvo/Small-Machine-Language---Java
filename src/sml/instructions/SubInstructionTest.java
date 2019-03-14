package sml.instructions;

import org.junit.Test;
import sml.Instruction;
import sml.Machine;
import sml.Registers;

import static junit.framework.TestCase.assertEquals;

public class SubInstructionTest {
    private final Machine mtest = new Machine();
    private Registers registers = new Registers();

    @Test
    public void execute() {
        mtest.setRegisters(registers);
        mtest.getRegisters().setRegister(2, 3);
        mtest.getRegisters().setRegister(3, 2);
        Instruction addinstruction = new SubInstruction("L1", 1, 2, 3);
        addinstruction.execute(mtest);
        assertEquals(1, mtest.getRegisters().getRegister(1));
        // check it works with negative numbers
        mtest.getRegisters().setRegister(3, -3);
        addinstruction.execute(mtest);
        assertEquals(6, mtest.getRegisters().getRegister(1));
    }

    @Test
    public void testToString() {
        assertEquals("L1: sub 2 - 3 to 1", new SubInstruction("L1", 1, 2, 3).toString());
    }
}