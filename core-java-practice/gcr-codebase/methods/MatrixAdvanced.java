public class MatrixAdvanced {
    public static void main(String[] args) {
        //Creating random 2x2 and 3x3 matrices
        double[][] matrix2x2 = createRandomMatrix(2, 2);
        double[][] matrix3x3 = createRandomMatrix(3, 3);
        System.out.println("2x2 Matrix:");
        displayMatrix(matrix2x2);
        System.out.println("\nTranspose of 2x2 Matrix:");
        displayMatrix(findTranspose(matrix2x2));
        double det2 = findDeterminant2x2(matrix2x2);
        System.out.println("\nDeterminant of 2x2 Matrix: " + det2);
        if(det2 != 0){
            System.out.println("\nInverse of 2x2 Matrix:");
            displayMatrix(findInverse2x2(matrix2x2));
        }else{
            System.out.println("\nInverse not possible for 2x2 Matrix");
        }
        System.out.println("\n3x3 Matrix:");
        displayMatrix(matrix3x3);
        System.out.println("\nTranspose of 3x3 Matrix:");
        displayMatrix(findTranspose(matrix3x3));
        double det3 = findDeterminant3x3(matrix3x3);
        System.out.println("\nDeterminant of 3x3 Matrix: " + det3);
        if(det3 != 0){
            System.out.println("\nInverse of 3x3 Matrix:");
            displayMatrix(findInverse3x3(matrix3x3));
        }else{
            System.out.println("\nInverse not possible for 3x3 Matrix");
        }
    }
    //Method to create a random matrix
    public static double[][] createRandomMatrix(int rows, int cols){
        double[][] matrix = new double[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                matrix[i][j] = Math.round(Math.random() * 9 + 1);
            }
        }
        return matrix;
    }
    //Method to find transpose of a matrix
    public static double[][] findTranspose(double[][] matrix){
        double[][] transpose = new double[matrix[0].length][matrix.length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }
    //Method to find determinant of 2x2 matrix
    public static double findDeterminant2x2(double[][] m){
        return (m[0][0] * m[1][1]) - (m[0][1] * m[1][0]);
    }
    //Method to find determinant of 3x3 matrix
    public static double findDeterminant3x3(double[][] m){
        return m[0][0] * (m[1][1] * m[2][2] - m[1][2] * m[2][1])
             - m[0][1] * (m[1][0] * m[2][2] - m[1][2] * m[2][0])
             + m[0][2] * (m[1][0] * m[2][1] - m[1][1] * m[2][0]);
    }
    //Method to find inverse of 2x2 matrix
    public static double[][] findInverse3x3(double[][] m){
        double det = findDeterminant3x3(m);
        double[][] inverse = new double[3][3];
        inverse[0][0] =  (m[1][1]*m[2][2] - m[1][2]*m[2][1]) / det;
        inverse[0][1] = -(m[0][1]*m[2][2] - m[0][2]*m[2][1]) / det;
        inverse[0][2] =  (m[0][1]*m[1][2] - m[0][2]*m[1][1]) / det;
        inverse[1][0] = -(m[1][0]*m[2][2] - m[1][2]*m[2][0]) / det;
        inverse[1][1] =  (m[0][0]*m[2][2] - m[0][2]*m[2][0]) / det;
        inverse[1][2] = -(m[0][0]*m[1][2] - m[0][2]*m[1][0]) / det;
        inverse[2][0] =  (m[1][0]*m[2][1] - m[1][1]*m[2][0]) / det;
        inverse[2][1] = -(m[0][0]*m[2][1] - m[0][1]*m[2][0]) / det;
        inverse[2][2] =  (m[0][0]*m[1][1] - m[0][1]*m[1][0]) / det;
        return inverse;
    }
    //Method to find inverse of 3x3 matrix
    public static double[][] findInverse2x2(double[][] m){
        double det = findDeterminant2x2(m);
        double[][] inverse = new double[2][2];
        inverse[0][0] =  m[1][1] / det;
        inverse[0][1] = -m[0][1] / det;
        inverse[1][0] = -m[1][0] / det;
        inverse[1][1] =  m[0][0] / det;
        return inverse;
    }
    //Method to display matrix
    public static void displayMatrix(double[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}