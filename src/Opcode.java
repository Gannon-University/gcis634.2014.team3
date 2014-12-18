/**
 * Simple opcode class
 */
<<<<<<< HEAD
public class Opcode
{
=======
public class Opcode{
>>>>>>> 351920a82d42d3062a47449d8b8fc1657bd82c38
    public Instruction inst;
    public String instr;
    public int value;
    public String constant;

<<<<<<< HEAD
    public Opcode(String instr, int value, String constant)
    {
=======
    public Opcode(String instr, int value, String constant){
>>>>>>> 351920a82d42d3062a47449d8b8fc1657bd82c38
        inst = Instruction.valueOf(instr.toUpperCase());
        this.instr = instr;
        this.value = value;
        this.constant = constant;
    }

    @Override
<<<<<<< HEAD
    public String toString()
    {
        final StringBuffer sb = new StringBuffer(30);
        sb.append(inst);
        switch (inst)
        {
=======
    public String toString(){
        final StringBuffer sb = new StringBuffer(30);
        sb.append(inst);
        switch (inst){
>>>>>>> 351920a82d42d3062a47449d8b8fc1657bd82c38
            case GETSTATIC:
            case LDC:
            case INVOKEVIRTUAL:
                sb.append(' ');
                sb.append(constant);
                break;
            case IADD:
            case IOR:
            case IRETURN:
                break;
            default:
                sb.append(' ');
                sb.append(value);
                break;
        }
        return sb.toString();
    }
}
