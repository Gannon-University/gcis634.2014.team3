<<<<<<< HEAD

/**
 * Interpreter.java
 *
 * Created on Nov 11, 2014, 6:00 PM
 *
 *
 * Copyright (c) 2014 Nasser.
 *
 * This program is free software
 * 
 * JVM Interpreter
 */


=======
>>>>>>> 494635e9c7d25b161b1b56ad97f9abfdd0b10c76
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

<<<<<<< HEAD

public class Interpreter{ //layout change with { }
    public Opcode[] opcodes;  //Public for testing
    private int[] stack;       //
    private  int sp;

    //for testing only.
    public Interpreter() //default Constructor
    {
       this.opcodes = new Opcode[12];//layout change (this.stack)
        this.stack = new int[10];
        this.sp = 0;
=======
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
>>>>>>> 494635e9c7d25b161b1b56ad97f9abfdd0b10c76

        opcodes[0] = new Opcode("iload",0,null);
        opcodes[1] = new Opcode("iload",1,null);
        opcodes[2] = new Opcode("iadd",0,null);
        opcodes[3] = new Opcode("ireturn",0,null);
    }

<<<<<<< HEAD
    public Interpreter(String filename, String method) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("triangleType.txt")); //to read from the file containing bytecode instructions.
        this.opcodes = new Opcode[1000];
        this.stack = new int[10];
        this.sp = 0;
        boolean skip = true;

        while (scanner.hasNext()){ //stops when there are no more instructions.
        
            String line = scanner.nextLine().trim();
            if (line.equals(method)){
=======
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
>>>>>>> 494635e9c7d25b161b1b56ad97f9abfdd0b10c76
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
<<<<<<< HEAD
        int counter = 0; //change the naming fro pc to counter.
=======
        int pc = 0;
>>>>>>> 494635e9c7d25b161b1b56ad97f9abfdd0b10c76
        locals[0] = a;
        locals[1] = b;
        locals[2] = c;

        Opcode opcode;
        while (true)
        {
           
<<<<<<< HEAD
            opcode = opcodes[counter++];
            switch (opcode.inst){
=======
            opcode = opcodes[pc++];
            switch (opcode.inst)
            {
>>>>>>> 494635e9c7d25b161b1b56ad97f9abfdd0b10c76
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
<<<<<<< HEAD
                    counter = opcode.value;
=======
                    pc = opcode.value;
>>>>>>> 494635e9c7d25b161b1b56ad97f9abfdd0b10c76
                    break;
                case IRETURN:
                    return pop();
                case IF_ICMPLT:
<<<<<<< HEAD
                    if (pop() > pop()) counter = opcode.value;
                    break;
                case IF_ICMPLE:
                    if (pop() >= pop()) counter = opcode.value;
                    break;
                case IF_ICMPNE:
                    if (pop() != pop()) counter = opcode.value;
                    break;
                case IF_ICMPEQ:
                    if (pop() == pop()) counter = opcode.value;
                    break;
                case IFEQ:
                    if (pop() == 0) counter = opcode.value;
=======
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
>>>>>>> 494635e9c7d25b161b1b56ad97f9abfdd0b10c76
                    break;
                case GETSTATIC:
                    break;
                default:
<<<<<<< HEAD
                    System.out.println(counter + ":" + opcode);
=======
                    System.out.println(pc + ":" + opcode);
>>>>>>> 494635e9c7d25b161b1b56ad97f9abfdd0b10c76
                    return 0;

            }
           
<<<<<<< HEAD
            while (opcodes[counter] == null) counter++;
=======
            while (opcodes[pc] == null) pc++;
>>>>>>> 494635e9c7d25b161b1b56ad97f9abfdd0b10c76
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
