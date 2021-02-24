//import java.util.Scanner;

public class Lab1
{
    /* autor: Coteanu Andra 2A4 */
    /* am initializat niste stringuri cu nume mai sugestiv cu coduri de culori */
    public static final String PURPLE = "\u001B[35m";
    public static final String PURPLE_BOLD = "\033[1;35m";
    public static final String RESET = "\u001B[0m";

    /* DFS recursiv */
    public static void DFS(int i, int[][] graf, int m, int[] vizitat)
    {
        if(vizitat[i] == 0)
        {
            vizitat[i] = 1; // a fost vizitat
            System.out.print(i + " ");
            int j;

            for(j=0;j<m;j++)
            {
                if (graf[i][j]==1 && vizitat[j]==0)
                {
                    DFS(j, graf, m, vizitat);
                }
            }
        }
    }

    /* oarecum similar cu DFS-ul se verifica daca exista cicluri in graf*/
    public static int esteCerc(int[][] graf, int n, int u, int[] vizitat, int tata)
    {
        vizitat[u] = 1;
        for(int v = 0; v<n; v++)
        {
            if(graf[u][v]==1)
            {
                if(vizitat[v]==0)
                {
                    if(esteCerc(graf, n, v, vizitat, u)==1)
                    {
                        return 1;
                    }
                }
                else if(v != tata)
                {
                    return 1;    //este cerc
                }
            }
        }
        return 0; //nu este cerc
    }

    //Compulsory (1p)
    public static void main(String[] args)
    {
        //        Write a Java application that implements the following operations:
        //        Display on the screen the message "Hello World!". Run the application. If it works, go to step 2 :)

        System.out.println(PURPLE_BOLD + "Compulsory:" + RESET);

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

        System.out.println(" ");
        System.out.println(PURPLE_BOLD + "Optional:" + RESET);

        System.out.println("Input a number for the matrix: ");
        n=0;
        /* Scanner keyboard = new Scanner(System.in);
        int m = keyboard.nextInt(); */ //initial am citit m de la tastatura => merge doar RUN din IDE


        /* pentru rulat din cmd: */

        /* nu pot fi decomentate sau comentate ambele linii cu "int m" */
        //int m = Integer.parseInt(args[0]); //decomentat => merge rulat din cmd/terminal
        int m=10; //decomentat => (un artificiu) la run in inteliji afiseaza si unicodurile

        if(m<=0) //nu exista matrici adiacente de -5 x -5 sau 0 x 0
        {
            System.out.println("Invalid number for a matrix. Try smth else.");
        }
        else
        {
            long start = System.nanoTime(); //timpul in nanosecunde in momentul cand programul ajunge aici

            System.out.println("The matrix is " + m + "x" + m + " and the data it's stored like this:");

            int i,j;
            n = m;
            m = n + 1;

            int[][] graf = new int[m][m];

            if(n<1000) //pentru un numar "decent" de afisat matricea se pregateste afisarea acesteia
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

            /* se genereaza matricea de adiacenta */
            for(i=1;i<m;i++)
            {
                for (j = 1; j < m; j++)
                {
                    if (i == j) graf[i][j] = 0;
                    else
                    {
                        int k = (int) (Math.random() * 2);
                        graf[i][j] = k;
                        graf[j][i] = k;
                    }
                }
            }

            //        For larger n display the running time of the application in nanoseconds (DO NOT display the matrices). Try n > 30_000. You might want to adjust the JVM Heap Space using the VM options -Xms4G -Xmx4G.

            long stop = System.nanoTime(); //timpul in nanosecunde dupa ce s-a generat matricea
            long timp = stop - start; //timpul de rulare in nanosecunde

            if(n<1000) //se afiseaza matricea
            {
                for(i=1;i<m;i++)
                {
                    if(i<10) System.out.print(" " + i + " | ");
                    else System.out.print(i + " | ");
                    for(j=1;j<m;j++)
                    {
                        if(graf[i][j]<10) System.out.print(" " + graf[i][j] + " ");
                        else System.out.print(graf[i][j] + " ");
                    }
                    System.out.println("");
                }

                System.out.println(" ");
                System.out.println("Your matrix looks like this:");

                /* matricea folosint unicoduri */
                for(i=1;i<m;i++)
                {
                    for(j=1;j<m;j++)
                    {
                        if(graf[i][j]==1)
                        {
                            System.out.print(PURPLE + "\u25C8 " + RESET);
                        }
                        else
                        {
                            System.out.print("\u25C7 ");
                        }
                    }
                    System.out.println(" ");
                }
            }
            else //pentru n>1000 se afiseaza unning time in nanosecunde
            {
                System.out.println("Running time: " + timp + " nanoseconds.");
            }


            //        Verify if the generated graph is connected and display the connected components (if it is not).

            /* se parcurge in adancime matricea si se afiseaza componentele si daca graful este conex */
            int[] vizitat = new int[1000];
            int count = 0; // numarul de componente conexe
            for(i = 1; i < m; i++)
            {
                if(vizitat[i]==0)
                {
                    System.out.print("Componenta: " );
                    DFS(i,graf, m, vizitat);
                    System.out.println("");
                    ++count;
                }
            }
            if(count>0)
            {
                System.out.println("Graful este conex si are " + count + " componente cu nodurile afisate mai sus.");
            }
            else
            {
                System.out.println("Graful nu este conex.");
            }


            //        Assuming that the generated graph is connected, implement an algorithm that creates a partial tree of the graph. Display the adjacency matrix of the tree.

            /* crearea unui arbore partial */

            /* ideea ar fi: daca in graful de mai sus exista cicluri, acestea sa fie sparte prin eliminarea unei muchii */
            /* am incercat un algoritm care sa aleaga random o muchie dar exista foarte multe posibilitati => dureaza prea mult sa ruleze si se cam blocheaza aici*/
            int ok, id1, id2;
            int arbore_partial=0; //0 = nu avem arbore partial
            int[] viz = new int[1000];
            int[][] graf2 =  new int[m][m];

            while(arbore_partial==0)
            {
                /* se genereaza o pozitie random a unui element din graf */
                id1 = (int) (Math.random() * m);
                id2 = (int) (Math.random() * m);
                while(graf[id1][id2]==0)
                {
                    /* se genereaza pozitia pana se gaseste o muchie */
                    id1 = (int) (Math.random() * m);
                    id2 = (int) (Math.random() * m);
                }

                /* se face o copie matricei */
                for(i=1;i<m;i++)
                {
                    for(j=1;j<m;j++)
                    {
                        graf2[i][j]=graf[i][j];
                    }
                }

                /* se sterge o muchie din graf pentru a se elimina ciclul daca acesta exista */
                graf2[id1][id2]=0;

                /* se verifica daca subgraful obtinut este arbore partial */
                ok = esteCerc(graf2, n,1, viz,1);
                if(ok==1)
                {
                    arbore_partial=0;
                    //System.out.println("Nu este arbore.");
                }
                else if(ok==0 && count==1) //arbore = nu are ciclu + are o componenta conexa
                {
                    arbore_partial=1;
                    System.out.println("Este arbore.");
                }
            }
        }

        //        Launch the application from the command line, for example: java Lab1 100.

        /* Pasi:
        * 1. localizez fisierul .java si deschid cmd-ul (sau direct din terminalul din inteliji)
        * 2. setez locatia jdk-ului cu set path
        * 3. compilez programul: javac Lab1.java
        * 4. rulez executabilul si ii dau un parametru pentru m: java Lab1 10 */
    }
}