import java.util.Scanner;
public class PcmGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int students = sc.nextInt();
        //Calling generateScores
        int [][] scores = generateScores(students); 
        //Calling results
        double [][] results = results(scores);
        //Calling grades
        String [][] grades = grades(results);
        for(int i=0; i<students; i++){
            System.out.println("Student "+(i+1)+" | Total : "+results[i][0]+" | Average : "+results[i][1]+ " | Percentage : "+results[i][2]+" | Grade : "+grades[i][0]);
        }
    }
    //Generate random 2-digit PCM scores
    public static int[][] generateScores(int students) {
        int[][] scores = new int[students][3];
        for(int i=0; i<students; i++){
            scores[i][0] = (int)(Math.random() * 51) + 50; // Physics
            scores[i][1] = (int)(Math.random() * 51) + 50; // Chemistry
            scores[i][2] = (int)(Math.random() * 51) + 50; // Maths
        }
        return scores;
    }
    //Calculate total, average, percentage
    public static double[][] results(int[][] scores) {
        double[][] result = new double[scores.length][3];
        for(int i=0; i<scores.length; i++){
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total/3.0;
            double percent = (total/300.0)*100;
            result[i][0] = total;
            result[i][1] = Math.round(avg * 100.0) / 100.0;
            result[i][2] = Math.round(percent * 100.0) / 100.0;
        }
        return result;
    }
    //Calculate grades
    public static String[][] grades(double[][] results) {
        String[][] grade = new String[results.length][1];
        for (int i=0; i<results.length; i++){
            double p = results[i][2];
            if (p >= 80) grade[i][0] = "A";
            else if (p >= 70) grade[i][0] = "B";
            else if (p >= 60) grade[i][0] = "C";
            else if (p >= 50) grade[i][0] = "D";
            else if (p >= 40) grade[i][0] = "E";
            else grade[i][0] = "R";
        }
        return grade;
    }
}