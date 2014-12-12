/**
 * Simple opcode class
 */
public class Opcode{
    public Instruction inst;
    public String instr;
    public int value;
    public String constant;

    public Opcode(String instr, int value, String constant){
        inst = Instruction.valueOf(instr.toUpperCase());
        this.instr = instr;
        this.value = value;
        this.constant = constant;
    }

    @Override
    public String toString(){
        final StringBuffer sb = new StringBuffer(30);
        sb.append(inst);
        switch (inst){
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
