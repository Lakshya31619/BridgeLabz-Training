import java.util.Scanner;
public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input
        int turns = sc.nextInt();
        //User turns
        String [] user = new String[turns];
        for(int i=0; i<turns; i++){
            //Enter rock, paper, scissors
            user[i] = sc.next();
        }
        //Calling getRandom function
        String [] computer = getRandom(turns);
        //Calling getStats Function
        String [][] stats = getStats(user, computer);
        //Output
        for(int i=0; i<2; i++){
            System.out.println("Player : "+stats[i][0]+" | Average : "+stats[i][1]+" | Percentage : "+stats[i][2]);
        }
    }
    //Function getStats
    public static String[][] getStats(String[] user, String[] computer){
        String [][] stats = new String[2][3];
        int userWins = 0;
        int computerWins = 0;
        //check who won
        for(int i=0; i<user.length; i++){
            if(user[i].equals(computer[i])){
                continue;
            }
            else if((user[i].equals("rock") && computer[i].equals("scissors")) || (user[i].equals("paper") && computer[i].equals("rock")) || (user[i].equals("scissors") && computer[i].equals("paper"))){
                userWins++;
            }
            else{
                computerWins++;
            }
        }
        //average calculation
        double userAvg = (double)userWins/user.length;
        double compAvg = (double)computerWins/user.length;
        //percentage calculation
        double userPer = userAvg*100;
        double compPer = compAvg*100;
        stats[0][0] = "User";
        stats[0][1] = String.valueOf(userAvg);
        stats[0][2] = String.format("%.2f", userPer) + "%";
        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(compAvg);
        stats[1][2] = String.format("%.2f", compPer) + "%";
        return stats;
    }
    //Function getRandom
    public static String[] getRandom(int turns){
        String [] computer = new String[turns];
        for(int i=0; i<turns; i++){
            int r = (int)(Math.random()*3);
            if(r==0){
                computer[i] = "rock";
            }else if(r==1){
                computer[i] = "paper";
            }else{
                computer[i] = "scissors";
            }
        }
        return computer;
    }
}