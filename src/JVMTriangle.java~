/**
 * JVMTriangle, simple class that determines the type of a triangle
 */
public class JVMTriangle
{
    public static int type(int a, int b, int c)
    {
        boolean c1 = a < 1 || a > 200; //False if a is in range; otherwise True.
        boolean c2 = b < 1 || b > 200;  //False if a is in range; otherwise True.
        boolean c3 = c < 1 || c > 200;  //False if a is in range; otherwise True.
        boolean c4 = a > b + c; 	//Check if a is greater than both b + c.
        boolean c5 = b > a + c;		//Check if b is greater than both a + c.
        boolean c6 = c > a + b;		//Check if c is greater than both a + b.
        if (c1 | c2 | c3 | c4 | c5 | c6) //if any of them is True, return -1 with the appropriate messege.
        {
            if (c1) System.out.println("Value of a is not in range of valid values");
            if (c2) System.out.println("Value of b is not in range of valid values");
            if (c3) System.out.println("Value of c is not in range of valid values");
            return -1;
        }
        //check the tringle type
        if (a == b && b == c) return 0;     //Equilateral
        if (a == b || a == c || b == c) return 1;   //Isosceles
        return 2;                           //Must be scalene
    }
}
