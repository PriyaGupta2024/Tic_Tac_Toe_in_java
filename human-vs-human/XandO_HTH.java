
import java.util.Scanner;
class TicTacToe 
{
    static char[][] board;     // declare one variable as board but not create actual array so proceed further
    //create constructor
    public TicTacToe()
    {
     board = new char[3][3]; // Array is object in java and object is automaticaly initialize with a deafaul value
       initBoard(); 
    }

    void initBoard()   // deafault value = /u0000=>null character we have to repalce this value with space
   {
    for(int i=0; i<board.length; i++){
        for(int j=0; j<board[i].length; j++){
            board[i][j] = ' ';
        }
    }
   }
    static void dispBoard(){
    System.out.println("------------");
    for(int i=0; i<board.length; i++){
        System.out.print("|");
        for(int j=0; j<board[i].length; j++){
           System.out.print(board[i][j] + " | ");
        }
        System.out.println();
        System.out.println("------------");
    }

   }


  static void placeMark(int row, int col, char mark)// How can  on place mark x or 0 &how to place it
   {
    if(row>=0 && row <=2 && col>=0 && col<=2){
     board[row][col] = mark;
   }
   else {
    System.out.println("Invalid Position");
   }
}
//check the condition for win if column wise all mark are same   
     static boolean CheckColWin()
    {
       for(int j=0; j<=2; j++){
        if(board[0][j] != ' ' &&  board[0][j] == board[1][j] && board[1][j] == board[2][j]){
            return true;
        }
       } 
       return false;
    }

// check the condition for win  if row wise all mark are same
 static boolean CheckRowWin(){
    for(int i=0; i<=2; i++){
        if(board[i][0] != ' ' &&  board[i][0] == board[i][1] && board[i][1] == board[i][2]){
           return true;
        }
    }
    return false;

}
//  check the condition for win  if daigonal wise all mark are same
   static boolean CheckDaigWin(){
    if(board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2] || 
    board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]){
        return true;
    }
    else{
        return false;
    }
  }
static  boolean checkTie()
{
    for(int i=0; i<=2; i++){
        for(int j=0; j<=2; j++){
            if(board[i][j] == ' '){
                return false;
            }
            
        }
    }
    return true;
}

}


class HumanPlayer 
{
    String name;
    char mark;

    HumanPlayer(String name, char mark)
    {
        this.name = name;
        this.mark = mark;
    }
    void makeMove()
    {
// when we taken row and col from user if those row & col are valid or invalid 
// if that valid then mark the char and if that is invalid then we have to give another chance to move
// let's see how {{WITH USING DO WHILE CONDITION}
           Scanner scan = new Scanner(System.in);
            int row;
            int col;
           do{
            System.out.println("Enter the row and col:");
             row = scan.nextInt();
             col = scan.nextInt();

           } while(!isValidMove(row, col));

           TicTacToe.placeMark(row, col, mark);         // if row and col are valid then going to be place mark the char
         
    }
    boolean isValidMove( int row , int col)
           {
               if(row>=0 && row <=2 && col>=0 && col<=2)
               {
       // the board which is in tictactoe class how to use this board in humanplayer class 
        // ANS=>we have to define that varible(board) as STATIC
        // if we just want to something  access   DECALARE AS STATIC            
                   if(TicTacToe.board[row][col] == ' '){
                       return true;
                   }                         
               }
               return false;
           }
    
}


public class XandO_HTH
{
    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();

// CREATE TWO OBJECT WHICH REFLECT TWO HUMAN BEING PLAYING EACH OTHER
        HumanPlayer p1 = new HumanPlayer("Jack" , 'X');
        HumanPlayer  p2 = new HumanPlayer("Lucy" , 'O');
        
    //giving reference who is current player
        
       HumanPlayer cp;
       cp = p1;

       while(true)
       {
        System.out.println(cp.name + " Play ");
       cp.makeMove();
       TicTacToe.dispBoard();
       //check winner are not for that we have to call checkrowWin,checkcolwin,CheckdiagWin 
       // without creating object with declare that condition as STATIC

       if(TicTacToe.CheckColWin() || TicTacToe.CheckRowWin() || TicTacToe.CheckDaigWin())
       {
            System.out.println(cp.name + " * WINNER * ");
            break;
       }
       else if( TicTacToe.checkTie()){
        System.out.println("Game is Tie or Draw");
        break;
       }
       else
       {
        if(cp == p1)
        {
            cp = p2;
        }
        else{
            cp = p1;
        }
       }

       }  
    }

}



