import java.io.FileNotFoundException;

/**
 * Test the implementation of interpreter
 */
public class Main
{
<<<<<<< HEAD
    public static void main(String[] args) throws FileNotFoundException
    {
        
        Interpreter code = new Interpreter("triangleType.txt", "public static int type(int, int, int);");

        test(3, 4, 5, 2, code);       //Scalene (right angled)
        test(4, 4, 5, 1, code);       //Isosceles
        test(4, 4, 4, 0, code);       //Equilateral
        //Now tests that will fail
        test(0, 1, 1, -1, code);      //Error with a
        test(1, 201, 1, -1, code);    //Error with b
        test(1, 200, -1, -1, code);   //Error with c
        test(3, 1, 1, -1, code);      //Error a > b + c
        test(1, 3, 1, -1, code);      //Error b > a + c
        test(1, 1, 3, -1, code);      //Error c > a + b

             //Error c > a + b
    }

    private static void test(int a, int b, int c, int expected, Interpreter code)
    {
        //int type = JVMTriangle.type(a, b, c);
        int type = code.run(a, b, c);
        System.out.println("Triangle(" + a + "," + b + "," + c + ") is " + nameType(type));
        if (type != expected)
        {
=======
    public static void main(String[] args) throws FileNotFoundException{
        Interpreter code = new Interpreter("triangleType.txt", "public static int type(int, int, int);");
		
		//Equilateral:
		test(1, 1, 1, 0, code);   
		test(2, 2, 2, 0, code);   
		test(3, 3, 3, 0, code);   
		test(4, 4, 4, 0, code);   
         	test(5, 5, 5, 0, code);   
		test(6, 6, 6, 0, code);   
        	
		//Isosceles:
		test(4, 4, 5, 1, code);   
		test(4, 5, 5, 1, code);   
		test(7, 7, 6, 1, code);   
		test(8, 8, 6, 1, code);   
       		test(4, 3, 3, 1, code);   
		test(10, 9, 9, 1, code);   
		
		//Scalene:
        	test(3, 4, 5, 2, code);    
		test(4, 8, 12, 2, code);   
		test(6, 12, 14, 2, code);  
		test(4, 6, 9, 2, code);    
        	test(3, 4, 7, 2, code);    
		test(5, 8, 9, 2, code);    
		
		 //Now tests that will fail
		test(0, 1, 1, -1, code);      //Error with a
        	test(1, 201, 1, -1, code);    //Error with b
		test(1, 200, -1, -1, code);   //Error with c
		test(3, 1, 1, -1, code);      //Error a > b + c
		test(1, 3, 1, -1, code);      //Error b > a + c
  		test(1, 1, 3, -1, code);      //Error c > a + b
		test(1, 1, 203, -1, code);    //Error c > a + b
    }

    private static void test(int a, int b, int c, int expected, Interpreter code){
        //int type = JVMTriangle.type(a, b, c);
        int type = code.run(a, b, c);
        System.out.println("Triangle(" + a + "," + b + "," + c + ") is " + nameType(type));
        if (type != expected){
>>>>>>> 351920a82d42d3062a47449d8b8fc1657bd82c38
            System.out.println("Unexpected type, expected " + nameType(expected) + " and got " + nameType(type));
        }
    }

<<<<<<< HEAD
    private static String nameType(int type)
    {
        switch (type)
        {
            
=======
    private static String nameType(int type){
     switch (type){
>>>>>>> 351920a82d42d3062a47449d8b8fc1657bd82c38
            case 0:
                return "Equilateral";
            case 1:
                return "Isosceles";
            case 2:
                return "Scalene";
<<<<<<< HEAD
			default:
=======
	    default:
>>>>>>> 351920a82d42d3062a47449d8b8fc1657bd82c38
                return "NotATriangle";
        }
    }

}
