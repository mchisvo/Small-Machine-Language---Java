package sml.instructions;

import org.junit.Test;
import sml.Labels;
import sml.Machine;
import sml.Registers;

import static junit.framework.TestCase.assertEquals;

public class BnzInstructionTest {
    private final Machine mtest = new Machine();
    private Registers registers =  Registers.getInstance();
    //private  List<Instruction> prog = new ArrayList<>();
    private Labels labels = new Labels();

    @Test
    public void execute() {
        labels.addLabel("L0");
        labels.addLabel("L1");
        labels.addLabel("L2");
        mtest.setLabels(labels);
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