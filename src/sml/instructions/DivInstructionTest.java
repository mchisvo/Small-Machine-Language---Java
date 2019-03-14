package sml.instructions;

import org.junit.Test;
import sml.Instruction;
import sml.Machine;
import sml.Registers;

import static junit.framework.TestCase.assertEquals;

public class DivInstructionTest {
    private final Machine mtest = new Machine();
    private Registers registers =  Registers.getInstance();

    @Test
    public void execute() {
        mtest.setRegisters(registers);
        mtest.getRegisters().setRegister(2,50);
        mtest.getRegisters().setRegister(3,5);
        Instruction divinstruction = new DivInstruction("L1", 1, 2,3 );
        divinstruction.execute(mtest);
        assertEquals(10,mtest.getRegisters().getRegister(1));
    }

    @Test
    public void testtoString() {
        assertEquals("L1: div 2 / 3 to 1", new DivInstruction("L1", 1, 2,3 ).toString());

    }
}