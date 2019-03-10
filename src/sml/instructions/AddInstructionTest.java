package sml.instructions;

import org.junit.Test;
import sml.Instruction;
import sml.Machine;
import sml.Registers;

import static junit.framework.TestCase.assertEquals;

public class AddInstructionTest {
    private final Machine mtest = new Machine();
    private Registers registers = new Registers();

    @Test
    public void execute() {
        mtest.setRegisters(registers);
        mtest.getRegisters().setRegister(2,1);
        mtest.getRegisters().setRegister(3,3);
        Instruction addinstruction = new AddInstruction("L1", 1, 2,3 );
        addinstruction.execute(mtest);
        assertEquals(4,mtest.getRegisters().getRegister(1));

    }

    @Test
    public void testtoString() {
        assertEquals("L1: add 2 + 3 to 1", new AddInstruction("L1", 1, 2,3 ).toString());
    }
}