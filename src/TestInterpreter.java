import junit.framework.Assert;
import org.junit.Test;

/**
 * JUnit testing
 */
public class TestInterpreter
{
    @Test
    public void testAdd() {
        Interpreter interpreter = new Interpreter();
        Assert.assertEquals(interpreter.run(1, 2, 3), 3);   //Test add
    }

    @Test
    public void testOr() {
        Interpreter interpreter = new Interpreter();
        interpreter.opcodes[2] = new Opcode("ior", 0, null);
        Assert.assertEquals(interpreter.run(3, 9, 3), 11);   //Test or
    }

    @Test
    public void testConstant() {
        Interpreter interpreter = new Interpreter();
        interpreter.opcodes[2] = new Opcode("iconst", 3, null);
        Assert.assertEquals(interpreter.run(3, 9, 3), 3);   //Test constant
    }

    @Test
    public void testSipush() {
        Interpreter interpreter = new Interpreter();
        interpreter.opcodes[2] = new Opcode("sipush", 123, null);
        Assert.assertEquals(interpreter.run(3, 9, 3), 123);   //Test push
    }

    @Test
    public void testGoto() {
        Interpreter interpreter = new Interpreter();
        interpreter.opcodes[2] = new Opcode("goto", 5, null);
        interpreter.opcodes[5] = new Opcode("iconst", 99, null);
        interpreter.opcodes[6] = new Opcode("ireturn", 123, null);
        Assert.assertEquals(interpreter.run(3, 9, 3), 99);   //Test goTo
    }

}

