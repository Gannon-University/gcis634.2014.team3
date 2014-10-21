import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * JVM Interpreter
 */
public class Interpreter
{
    public Opcode[] opcodes;    //Public for testing
    int[] stack;
    int sp;

    //for testing only.
    public Interpreter()
    {
        opcodes = new Opcode[12];
        stack = new int[10];
        sp = 0;

        opcodes[0] = new Opcode("iload",0,null);
        opcodes[1] = new Opcode("iload",1,null);
        opcodes[2] = new Opcode("iadd",0,null);
        opcodes[3] = new Opcode("ireturn",0,null);
    }

    public Interpreter(String filename, String method) throws FileNotFoundException
    {
        Scanner scanner = new Scanner(new File("triangleType.txt")); //to read from the file containing bytecode instructions.
        opcodes = new Opcode[1000];
        stack = new int[10];
        sp = 0;
        boolean skip = true;

        while (scanner.hasNext()) //stops when there are no more instructions.
        {
            String line = scanner.nextLine().trim();
            if (line.equals(method))
            {
                skip = false;
                scanner.nextLine();     //Skip Code: line
                continue;
            }
            if (skip) continue;
            if (line.equals("}")) break;    //End of method
            String[] parts = line.split("\\s+", 4);     //4 parts at most
            int address = Integer.parseInt(parts[0].substring(0, parts[0].length() - 1));
            String instr = parts[1];
            int value = 0;
            String constant = "";
            if (parts.length > 2)
            {
                if (parts[2].startsWith("#")) parts[2] = parts[2].substring(1);
                value = Integer.parseInt(parts[2]);
                if (parts.length == 4)
                {
                    int space = parts[3].indexOf(' ', 6) + 1;   //After // there is field, string or method
                    constant = parts[3].substring(space);
                }
            }
            if (instr.contains("_"))        //Split instructions like ILOAD_1
            {
                int index = instr.indexOf('_');
                if (Character.isDigit(instr.charAt(index + 1)))
                {
                    value = Integer.parseInt(instr.substring(index+1));
                    instr = instr.substring(0, index);
                }
                if (instr.equals("iconst_m1"))
                {
                    value = -1;
                    instr = "iconst";
                }
            }
            opcodes[address] = new Opcode(instr, value, constant);
           
        }
    }

    public int run(int a, int b, int c)//check the Interpreter
    {
        int[] locals = new int[10];
        String constant = null;
        int pc = 0;
        locals[0] = a;
        locals[1] = b;
        locals[2] = c;

        Opcode opcode;
        while (true)
        {
           
            opcode = opcodes[pc++];
            switch (opcode.inst)
            {
                case ILOAD:
                    push(locals[opcode.value]);
                    break;
                case ISTORE:
                    locals[opcode.value] = pop();
                    break;
                case IADD:
                    push(pop() + pop());
                    break;
                case IOR:
                    push(pop() | pop());
                    break;
                case LDC:
                    constant = opcode.constant;
                    break;
                case INVOKEVIRTUAL:
                    System.out.println(constant);
                    break;
                case ICONST:
                case SIPUSH:
                    push(opcode.value);
                    break;
                case GOTO:
                    pc = opcode.value;
                    break;
                case IRETURN:
                    return pop();
                case IF_ICMPLT:
                    if (pop() > pop()) pc = opcode.value;
                    break;
                case IF_ICMPLE:
                    if (pop() >= pop()) pc = opcode.value;
                    break;
                case IF_ICMPNE:
                    if (pop() != pop()) pc = opcode.value;
                    break;
                case IF_ICMPEQ:
                    if (pop() == pop()) pc = opcode.value;
                    break;
                case IFEQ:
                    if (pop() == 0) pc = opcode.value;
                    break;
                case GETSTATIC:
                    break;
                default:
                    System.out.println(pc + ":" + opcode);
                    return 0;

            }
           
            while (opcodes[pc] == null) pc++;
        }
    }

    private void push(int value)
    {
        stack[sp++] = value;
    }

    private int pop()
    {
        return stack[--sp];
    }
}
