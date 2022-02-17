import java.util.Scanner;
public class TicTacToe{
    static String[][] board = new String[3][3];
    static boolean isWon = false;
    public static void main(String[] args)
    {
        fillBoard();
        while(true){
            gameLoop();
            if(checkTie()){
                Scanner reader = new Scanner(System.in);
                System.out.print("It's a Tie! Go again? y/n ");
                String cont = reader.nextLine();
                if(cont.equals("y")){
                    fillBoard();
                }else{
                    break;
                }
            }
            if(isWon){
                Scanner reader = new Scanner(System.in);
                System.out.print("Go again? y/n ");
                String cont = reader.nextLine();
                if(cont.equals("y")){
                    isWon = false; 
                    fillBoard();
                }else{
                    break;
                }
            }
        }
        System.out.print("Thanks for Playing!");
    }
    public static void fillBoard(){
        for(int i =  0; i < 3; i++){
            for(int k = 0; k< 3; k++){
                board[i][k] = " ";
            }
        }
    }
    public static void printBoard(){
        System.out.println("     |     |     ");
        for(int i = 0; i< 2; i++){
            for(int k = 0; k< 2; k++){
                System.out.print("  "+board[i][k] + "  |");
            }
            System.out.println("  "+board[i][2]+" ");
            System.out.println("     |     |     ");
            System.out.println("-----------------");
            System.out.println("     |     |     ");
        }
        for(int i  = 0; i < 2; i++){
            System.out.print("  "+board[2][i] + "  |");
        }
        System.out.println("  "+board[2][2]+" ");
        System.out.println("     |     |     ");
    }
    public static boolean checkEmpty(int x, int y){
        if(board[y-1][x-1] == " "){
            return true;
        }else{
            return false;
        }
    }
    public static boolean checkVertical(String x){
        
        for(int i = 0; i< 3;i++){
            int count = 0;
            for(int k = 0; k < 3; k++){
                if(board[k][i] == x){
                    count++;
                }
            }
            if(count == 3){
                return true;
            }
        }
        return false;
    }
    public static boolean checkHorizontal(String x){
        for(int i = 0; i< 3;i++){
            int count = 0;
            for(int k = 0; k < 3; k++){
                if(board[i][k] == x){
                    count++;
                }
            }
            if(count == 3){
                return true;
            }
        }
        return false;
    }
    public static boolean checkDiagonal(String x){
        int count = 0;
        if(board[0][0] == x){// checks left top corner to right bottom corner
            count++;
        }
        if(board[1][1] == x){
            count++;
        }
        if(board[2][2] == x){
            count++;
        }
        if(count == 3){
            return true;
        }
        count = 0;
        if(board[2][0] == x){//checks right top to left bottom
            count++;
        }
        if(board[1][1] == x){
            count++;
        }
        if(board[0][2] == x){
            count++;
        }
        if(count == 3){
            return true;
        }
        return false;
        
    }
    public static boolean checkTie(){
        int count = 0;
        for(String[] balls: board){
            for(String ball: balls){
                if(ball!=" "){
                    count++;
                }
            }
        }
        if(count >= 9){
            return true;
        }
        return false;
    }
    public static void gameLoop(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Player One's turn!");
        
        while(true){
            System.out.print("Enter horizontal positon ");
            int posX = reader.nextInt();
            System.out.print("Enter Vertical postion ");
            int posY = reader.nextInt();
            if((posX > 3 || posY > 3) || (posX < 0 || posY < 0)){
                System.out.println("Please enter a valid position!");
                continue;
            }
            if(checkEmpty(posX, posY)){
                board[posY-1][posX-1] = "X";
                break;
            }else{
                System.out.println("That spot is taken! try  again!");
            }
            
        }
        printBoard();
        if(checkVertical("X") || checkHorizontal("X")){
            isWon = true;
            System.out.println("Player One Wins!");
            return;
        }
        else if(checkDiagonal("X")){
            isWon = true;
            System.out.println("Player One Wins!");
            return;
        }
        if(checkTie()){
            return;
        }
        System.out.println("Player two's turn!");
        while(true){
            System.out.print("Enter horizontal positon ");
            int posX = reader.nextInt();
            System.out.print("Enter Vertical postion ");
            int posY = reader.nextInt();
            if((posX > 3 || posY > 3) || (posX < 0 || posY < 0)){
                System.out.println("Please enter a valid position!");
                continue;
            }
            if(checkEmpty(posX, posY)){
                board[posY-1][posX-1] = "O";
                break;
            }else{
                System.out.println("That spot is taken! try  again!");
            }
            
        }
        printBoard();
        if(checkVertical("O") || checkHorizontal("O")){
            isWon = true;
            System.out.println("Player Two Wins!");
            return;
        }
        else if(checkDiagonal("O")){
            isWon = true;
            System.out.println("Player Two Wins!");
            return;
        }
    }
}