import java.util.Scanner;

public class Lab1
{
    /* autor: Coteanu Andra 2A4 */

    //Compulsory (1p)
    public static void main(String[] args)
    {
        //        Write a Java application that implements the following operations:
        //        Display on the screen the message "Hello World!". Run the application. If it works, go to step 2 :)

        System.out.println("Hello World!");


        //        Define an array of strings languages, containing {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"}

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        for (String element: languages)
        {
            System.out.println(element);
        }


        //        Generate a random integer n: int n = (int) (Math.random() * 1_000_000);

        int n = (int) (Math.random() * 1_000_000);
        System.out.println("n = " + n);


        //        Compute the result obtained after performing the following calculations:
        //        multiply n by 3;

        n = n * 3;
        System.out.println("n*3 = " + n);

        //        add the binary number 10101 to the result;

        String binary="10101";
        int decimal=Integer.parseInt(binary,2);
        n = n + decimal;
        System.out.println("n*3+binary = " + n);

        //        add the hexadecimal number FF to the result;

        String hex="FF";
        decimal=Integer.parseInt(hex,16);
        n = n + decimal;
        System.out.println("n*3+binary+hex = " + n);

        //        multiply the result by 6;

        n = n * 6;
        System.out.println("(n*3+binary+hex)*6 = " + n);


        //        Compute the sum of the digits in the result obtained in the previous step. This is the new result. While the new result has more than one digit, continue to sum the digits of the result.

        int sum = n;
        while(sum > 9)
        {
            n = sum;
            sum = 0;
            while (n != 0)
            {
                sum = sum + n % 10;
                n = n/10;
            }
        }

        System.out.println("the diggit is " + sum);

        //        Display on the screen the message: "Willy-nilly, this semester I will learn " + languages[result].

        System.out.println("Willy-nilly, this semester I will learn " + languages[sum]);


        ////////////////////////////////////////////////////////////////////////////////////////////////////////

        //Optional (2p)

        //        Let n be an integer given as a command line argument. Validate the argument!
        //        Create a n x n matrix, representing the adjacency matrix of a random graph .
        //        Display on the screen the generated matrix (you might want to use the geometric shapes from the Unicode chart to create a "pretty" representation of the matrix).

        System.out.println("Input a number for the matrix: ");
        n=0;
        Scanner keyboard = new Scanner(System.in);
        int m = keyboard.nextInt();

        while(m<=0)
        {
            System.out.println("Invalid number for a matrix. Try smth else.");
            m = keyboard.nextInt();
        }

        long start = System.nanoTime(); //nanoseconds running time

        System.out.println("The matrix is " + m + "x" + m + ":");

        int i,j;
        n = m;
        m = n + 1;

        int[][] A = new int[m][m];

        if(n<100)
        {
            System.out.print("   | ");
            for(i=1;i<m;i++)
            {
                if(i<10) System.out.print(" " + i + " ");
                else System.out.print(i + " ");
            }
            System.out.println("");
            System.out.print("---+");
            for(i=1;i<m;i++)
            {
                System.out.print("---");
            }
            System.out.println("-");
        }

        for(i=1;i<m;i++)
        {
            for(j=1;j<m;j++)
            {
                if(i==j) A[i][j]=0;
                else
                {
                    int k = (int) (Math.random() * m);
                    A[i][j] = k;
                }
            }
        }

        //        For larger n display the running time of the application in nanoseconds (DO NOT display the matrices). Try n > 30_000. You might want to adjust the JVM Heap Space using the VM options -Xms4G -Xmx4G.

        long stop = System.nanoTime();
        long timp = stop - start;

        if(n<100)
        {
            for(i=1;i<m;i++)
            {
                if(i<10) System.out.print(" " + i + " | ");
                else System.out.print(i + " | ");
                for(j=1;j<m;j++)
                {
                    if(A[i][j]<10) System.out.print(" " + A[i][j] + " ");
                    else System.out.print(A[i][j] + " ");
                }
                System.out.println("");
            }
        }
        else
        {
            System.out.println("Running time: " + timp + " nanoseconds.");
        }

        //        Verify if the generated graph is connected and display the connected components (if it is not).

        //        Assuming that the generated graph is connected, implement an algorithm that creates a partial tree of the graph. Display the adjacency matrix of the tree.

        //        Launch the application from the command line, for example: java Lab1 100.
    }
}










