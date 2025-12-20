import java.util.Scanner;
public class TwoDToOneD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //2D Array
        int rows = sc.nextInt();
        int columns = sc.nextInt();
        int [][] matrix = new int[rows][columns];
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("2D Array : ");
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        //Copy to 1D Array
        int [] array = new int[rows*columns];
        int index = 0; //Index pointer for array
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                array[index++] = matrix[i][j];
            }
        }
        System.out.println("1D Array : ");
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
    }
}