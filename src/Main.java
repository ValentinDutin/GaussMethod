public class Main {
    public static void main(String[] args) {
        try {
            double matrA[][] = {
                    { 0.5757, -0.0758, 0.0152,  0.0303,  0.1061},
                    { 0.0788,  0.9014, 0.0000, -0.0606,  0.0606},
                    { 0.0455,  0.0000, 0.7242, -0.2121,  0.1212},
                    {-0.0909,  0.1909, 0.0000,  0.7121, -0.0303},
                    { 0.3788,  0.0000, 0.1364,  0.0152,  0.8484}
            };
            double vectorB[] = {
                     3.5148,
                     3.8542,
                    -4.9056,
                     2.3240,
                     0.1818
            };
            GaussMethod gs = new GaussMethod(matrA, vectorB);
            System.out.println("Matrix A with vector B");
            gs.print();
            System.out.println();
            gs.strightStep();
            System.out.println("Matrix A with vector B after stright step of Gauss method");
            gs.print();
            System.out.println();
            gs.createVectorX();
            System.out.println("Vector X");
            gs.printX();
            System.out.println();
            System.out.println("Discrepancy");
            System.out.println();
            gs.createDiscrepancy();
            System.out.println();
            gs.createDetA();
            double inverseMatr[][] = createInverseMatr(matrA);
            System.out.println("\nInverse matr:");
            printMatr(inverseMatr);
            gs.createDiscrepancyMatr(inverseMatr);
            gs.printDiscrepancyMatr();
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    public static void printMatr(double matr[][]){
        for( double[] row : createInverseMatr(matr)){
            for(double item: row){
                System.out.format("%25s", item + "    ");
            }
            System.out.println();
        }
    }

    public static double[][] createInverseMatr(double matrA[][]){
        int n = matrA.length;
        double matrE[][] = new double[n][n];
        double inverseMatr[][] = new double[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) {
                    matrE[i][j] = 1;
                }
                else{
                    matrE[i][j] = 0;
                }
            }
        }
        GaussMethod gs;
        for(int i = 0; i < n; i++){
            gs = new GaussMethod(matrA, matrE[i]);
            gs.strightStep();
            gs.createVectorX();
            for(int j = 0; j < n; j++){
                inverseMatr[j][i] = gs.getVectorX()[j];
            }
        }
        return inverseMatr;
    }


}
