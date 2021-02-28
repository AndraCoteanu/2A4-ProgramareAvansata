public class Solution {

    public Solution() {
    }

    @Override
    public String toString() {
        return "Solutia pentru problema data este:";
    }

    /* declar un obiect de tipul Problem pentru ai putea accesa functionalitatile */
    Problem problema = new Problem();

    public int[] Row = new int[problema.MATRIX_DIM];
    public int[] Column = new int[problema.MATRIX_DIM];

    public int verificareLivrari() {
        for (int i = 0; i < problema.MATRIX_DIM; i++) {
            for (int j = 0; j < problema.MATRIX_DIM; j++) {
                if (problema.cost[i][j] <= 10) {
                    return 0; //adica nu e gata
                }
            }
        }
        return 1; //gata livrarile
    }

    public void diffRow() {
        int min1, min2;
        for (int i = 0; i < problema.MATRIX_DIM; i++) {
            min1 = 20;
            min2 = 20;
            for (int j = 0; j < problema.MATRIX_DIM; j++) {
                if (problema.cost[i][j] < min1) {
                    min2 = min1;
                    min1 = problema.cost[i][j];
                } else if (problema.cost[i][j] < min2) {
                    min2 = problema.cost[i][j];
                }
            }
            Row[i] = min2 - min1;
        }
    }

    public void diffColumn() {
        int min1, min2;
        for (int i = 0; i < problema.MATRIX_DIM; i++) {
            min1 = 20;
            min2 = 20;
            for (int j = 0; j < problema.MATRIX_DIM; j++) {
                if (problema.cost[j][i] < min1) {
                    min2 = min1;
                    min1 = problema.cost[j][i];
                } else if (problema.cost[j][i] < min2) {
                    min2 = problema.cost[j][i];
                }
            }
            Column[i] = min2 - min1;
        }
    }

    public void solutia() {
        /* se initializeaza datele problemei */
        problema.makeProblem();
        int costTotal = 0;
        int livrare;
        livrare = verificareLivrari();
        while (livrare == 0) {

            diffColumn();
            diffRow();

            int locatie; //0-rand sau 1-coloana, in functie de unde se afla penalitatea maxima
            locatie = -1;
            int rand, coloana; //numarul randului/coloanei unde este penalitatea maxima
            rand = -1;
            coloana = -1;
            int penality = -1;
            for (int i = 0; i < problema.MATRIX_DIM; i++) {
                if (Row[i] > penality) {
                    penality = Row[i];
                    locatie = 0;
                    rand = i;
                } else if (Column[i] > penality) {
                    penality = Column[i];
                    locatie = 1;
                    coloana = i;
                }
            }

            int costMin = 20;
            int coordRand, coordColoana;
            coordColoana = 0;
            coordRand = 0;
            int i = -1;

            if (locatie == 0) //rand
            {
                for (i = 0; i < problema.MATRIX_DIM; i++) {
                    if (problema.cost[rand][i] < costMin) {
                        costMin = problema.cost[rand][i];
                        coordColoana = i;
                    }
                }

                if (problema.destinatii.get(coordColoana).commodity > problema.surse.get(rand).capacity) {
                    System.out.println(problema.surse.get(rand).name + " -> " + problema.destinatii.get(coordColoana).name + ": "
                            + problema.surse.get(rand).capacity + " units * cost " + problema.cost[rand][coordColoana] + " = "
                            + problema.surse.get(rand).capacity * problema.cost[rand][coordColoana]);

                    costTotal += problema.surse.get(rand).capacity * problema.cost[rand][coordColoana];
                    problema.destinatii.get(coordColoana).commodity -= problema.surse.get(rand).capacity;
                    problema.surse.get(rand).capacity = 0;
                    for (i = 0; i < problema.MATRIX_DIM; i++) {
                        problema.cost[rand][i] = 100;
                    }
                } else if (problema.destinatii.get(coordColoana).commodity < problema.surse.get(rand).capacity) {
                    System.out.println(problema.surse.get(rand).name + " -> " + problema.destinatii.get(coordColoana).name + ": "
                            + problema.destinatii.get(coordColoana).commodity + " units * cost " + problema.cost[rand][coordColoana] + " = "
                            + problema.destinatii.get(coordColoana).commodity * problema.cost[rand][coordColoana]);

                    costTotal += problema.destinatii.get(coordColoana).commodity * problema.cost[rand][coordColoana];
                    problema.surse.get(rand).capacity -= problema.destinatii.get(coordColoana).commodity;
                    problema.destinatii.get(coordColoana).commodity = 0;
                    for (i = 0; i < problema.MATRIX_DIM; i++) {
                        problema.cost[i][coordColoana] = 100;
                    }
                } else {
                    System.out.println(problema.surse.get(rand).name + " -> " + problema.destinatii.get(coordColoana).name + ": "
                            + problema.destinatii.get(coordColoana).commodity + " units * cost " + problema.cost[rand][coordColoana] + " = "
                            + problema.destinatii.get(coordColoana).commodity * problema.cost[rand][coordColoana]);

                    costTotal += problema.destinatii.get(coordColoana).commodity * problema.cost[rand][coordColoana];
                    problema.surse.get(rand).capacity = 0;
                    problema.destinatii.get(coordColoana).commodity = 0;
                    for (i = 0; i < problema.MATRIX_DIM; i++) {
                        problema.cost[rand][i] = 100;
                        problema.cost[i][coordColoana] = 100;
                    }
                }

            } else if (locatie == 1) // coloana
            {
                for (i = 0; i < problema.MATRIX_DIM; i++) {
                    if (problema.cost[i][coloana] < costMin) {
                        costMin = problema.cost[i][coloana];
                        coordRand = i;
                    }
                }

                if (problema.destinatii.get(coloana).commodity > problema.surse.get(coordRand).capacity) {
                    System.out.println(problema.surse.get(coordRand).name + " -> " + problema.destinatii.get(coloana).name + ": "
                            + problema.surse.get(coordRand).capacity + " units * cost " + problema.cost[coordRand][coloana] + " = "
                            + problema.surse.get(coordRand).capacity * problema.cost[coordRand][coloana]);

                    costTotal += problema.surse.get(coordRand).capacity * problema.cost[coordRand][coloana];
                    problema.destinatii.get(coloana).commodity -= problema.surse.get(coordRand).capacity;
                    problema.surse.get(coordRand).capacity = 0;
                    for (i = 0; i < problema.MATRIX_DIM; i++) {
                        problema.cost[coordRand][i] = 100;
                    }
                } else if (problema.destinatii.get(coloana).commodity < problema.surse.get(coordRand).capacity) {
                    System.out.println(problema.surse.get(coordRand).name + " -> " + problema.destinatii.get(coloana).name + ": "
                            + problema.destinatii.get(coloana).commodity + " units * cost " + problema.cost[coordRand][coloana] + " = "
                            + problema.destinatii.get(coloana).commodity * problema.cost[coordRand][coloana]);

                    costTotal += problema.destinatii.get(coloana).commodity * problema.cost[coordRand][coloana];
                    problema.surse.get(coordRand).capacity -= problema.destinatii.get(coloana).commodity;
                    problema.destinatii.get(coloana).commodity = 0;
                    for (i = 0; i < problema.MATRIX_DIM; i++) {
                        problema.cost[i][coloana] = 100;
                    }
                } else {
                    System.out.println(problema.surse.get(coordRand).name + " -> " + problema.destinatii.get(coloana).name + ": "
                            + problema.destinatii.get(coloana).commodity + " units * cost " + problema.cost[coordRand][coloana] + " = "
                            + problema.destinatii.get(coloana).commodity * problema.cost[coordRand][coloana]);

                    costTotal += problema.destinatii.get(coloana).commodity * problema.cost[coordRand][coloana];
                    problema.surse.get(coordRand).capacity = 0;
                    problema.destinatii.get(coloana).commodity = 0;
                    for (i = 0; i < problema.MATRIX_DIM; i++) {
                        problema.cost[coordRand][i] = 100;
                        problema.cost[i][coloana] = 100;
                    }
                }
            }
            livrare = verificareLivrari();
        }
        System.out.println("Costul total este: " + costTotal);
    }
}