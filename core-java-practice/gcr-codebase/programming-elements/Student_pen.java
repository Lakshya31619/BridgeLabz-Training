public class Student_pen {
    public static void main(String[] args) {
        int pen = 14; //Number of Pens
        int s = 3; //Numebr of Students
        int d = pen/s; //Pens distributed per Student
        int nd = pen%s; //Remaining Pens
        System.out.println("The Pen Per Student is "+d+" and the remaining pen not distributed is "+nd);
    }
}
