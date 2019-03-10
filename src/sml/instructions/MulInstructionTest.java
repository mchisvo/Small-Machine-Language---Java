package sml.instructions;

import org.junit.Test;
import sml.Instruction;
import sml.Machine;
import sml.Registers;

import static junit.framework.TestCase.assertEquals;

public class MulInstructionTest {
    private final Machine mtest = new Machine();
    private Registers registers = new Registers();

    @Test
    public void execute() {
        mtest.setRegisters(registers);
        mtest.getRegisters().setRegister(2,2);
        mtest.getRegisters().setRegister(3,3);
        Instruction mulinstruction = new MulInstruction("L1", 1, 2,3 );
        mulinstruction.execute(mtest);
        assertEquals(6,mtest.getRegisters().getRegister(1));
    }

    @Test
    public void testtoString() {
        assertEquals("L1: mul 2 * 3 to 1", new MulInstruction("L1", 1, 2,3 ).toString());
    }
}