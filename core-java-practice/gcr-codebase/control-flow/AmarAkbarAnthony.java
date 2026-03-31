import java.util.Scanner;
public class AmarAkbarAnthony {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input ages
        int amar_age = sc.nextInt();
        int akbar_age = sc.nextInt();
        int anthony_age = sc.nextInt();
        //Input heights
        int amar_height = sc.nextInt();
        int akbar_height = sc.nextInt();
        int anthony_height = sc.nextInt();
        //Youngest among three
        if(amar_age<akbar_age && amar_age<anthony_age){
            System.out.println("Amar is the youngest.");
        }else if(akbar_age<anthony_age && akbar_age<amar_age){
            System.out.println("Akbar is the youngest.");
        }else{
            System.out.println("Anthony is the youngest.");
        }
        //Tallest among three
        if(amar_height>akbar_height && amar_height>anthony_height){
            System.out.println("Amar is the tallest.");
        }else if(akbar_height>anthony_height && akbar_height>amar_height){
            System.out.println("Akbar is the tallest.");
        }else{
            System.out.println("Anthony is the tallest.");
        }
    }
}