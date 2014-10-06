/**
 * JVMTriangle, simple class that determines the type of a triangle
 */
public class JVMTriangle
{
    public static int type(int a, int b, int c)
    {
        boolean c1 = a < 1 || a > 200;
        boolean c2 = b < 1 || b > 200;
        boolean c3 = c < 1 || c > 200;
        boolean c4 = a > b + c;
        boolean c5 = b > a + c;
        boolean c6 = c > a + b;
        if (c1 | c2 | c3 | c4 | c5 | c6)
        {
            if (c1) System.out.println("Value of a is not in range of valid values");
            if (c2) System.out.println("Value of b is not in range of valid values");
            if (c3) System.out.println("Value of c is not in range of valid values");
            return -1;
        }
        if (a == b && b == c) return 0;     //Equilateral
        else if (a == b || a == c || b == c) return 1;   //Isosceles
        else
		   return 2;                           //Must be scalene
    }
}
