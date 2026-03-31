public class SnakesAndLadders {
    static final int WIN_POSITION = 100;
    static int player1Pos = 0;
    static int player2Pos = 0;
    static int diceCount = 0;
    static boolean isPlayer1Turn = true;
    public static void main(String[] args) {
        playGame();
    }
    //Use Case 1
    static int rollDie() {
        diceCount++;
        return (int) (Math.random() * 6) + 1;
    }
    //Use Case 2
    static int getPlayerOption() {
        return (int) (Math.random() * 3);
    }
    //Use Case 3
    static int applyOption(int position, int die, int option) {
        switch (option) {
            case 0:
                break;
            case 1:
                position += die;
                break;
            case 2:
                position -= die;
                if (position < 0)
                    position = 0;
                break;
        }
        return position;
    }
    //Use Case 4
    static int checkExactWin(int oldPos, int newPos) {
        if (newPos > WIN_POSITION)
            return oldPos;
        return newPos;
    }
    //Use Case 5
    static void displayStatus(int player, int die, int position) {
        System.out.println("Player " + player +" rolled " + die +" | Position: " + position);
    }
    //Use Case 6
    static void playTurn() {
        int die = rollDie();
        int option = getPlayerOption();
        if (isPlayer1Turn) {
            int oldPos = player1Pos;
            player1Pos = applyOption(player1Pos, die, option);
            player1Pos = checkExactWin(oldPos, player1Pos);
            displayStatus(1, die, player1Pos);
            if (option != 1)
                isPlayer1Turn = false;
        } else {
            int oldPos = player2Pos;
            player2Pos = applyOption(player2Pos, die, option);
            player2Pos = checkExactWin(oldPos, player2Pos);
            displayStatus(2, die, player2Pos);
            if (option != 1)
                isPlayer1Turn = true;
        }
    }
    //Use Case 7
    static void playGame() {
        while (player1Pos < WIN_POSITION && player2Pos < WIN_POSITION) {
            playTurn();
        }
        if (player1Pos == WIN_POSITION)
            System.out.println("\nPlayer 1 Wins!");
        else
            System.out.println("\nPlayer 2 Wins!");

        System.out.println("Total Dice Rolls: " + diceCount);
    }
}