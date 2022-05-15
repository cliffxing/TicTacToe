
import java.util.Scanner;

public class tictactoe {
     public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       Boolean game = true;
       int turnCount = 0;
       Boolean gameRunning = false;
       int[][] grid = {{0,0,0}, {0,0,0}, {0,0,0}};
       int turn = 1; // 1 for Player 1, -1 for player 2
       int gamestatus = 0; //0 game still running, 1 p1 wins, -1 p2 wins, 2 draw
       
      //Game Initilization:
       System.out.println("Welcome to Tic Tac Toe -This program was created Clifford Xing\n");
       
       System.out.println("When entering inputs, please enter the number assigned to each space below:");
       
       System.out.println("-------------");
       System.out.println("| 1 | 2 | 3 |");
       System.out.println("-------------");
       System.out.println("| 4 | 5 | 6 |");
       System.out.println("-------------");
       System.out.println("| 7 | 8 | 9 |");
       System.out.println("-------------");
       
       while (game == true){
          System.out.println("Please type 'start' to begin the game");
          String m = s.nextLine();
          
          if (m.equals("start")){
              gameRunning=true;
              break;
          }
       }
       
       while(gameRunning == true){
            if (gamestatus == 1){
                   System.out.println("Player 1 Wins!");
                   break;
                   
               }
               else if (gamestatus == -1){
                   System.out.println("Player 2 Wins!");
                    break;
               }
               else if (gamestatus == 2){
                   System.out.println("Draw!");
                    break;
            }
          int input = 0;
           if (turn == 1){
               System.out.println("Please enter Player 1 Input (Number between 1-9)");
               input = s.nextInt();
           }
           else{
               System.out.println("Please enter Player 2 Input (Number between 1-9)");
               input = s.nextInt();
           }
           
           
           if (input < 0 || input > 9){
               System.out.println("Invalid Input - Out of Bounds");
           }
           
           else if (valid_input(input, grid, turn) == false){
               System.out.println("Invalid Input - Space is Used");
           }
           
           else{
              
               place_input(input,grid, turn);
               print_grid(grid);
               turnCount++;
               turn = turn  * (-1);
               gamestatus = check_grid(grid,turnCount);
              
           }
           
           

       }
       

      
       
       
    }
    
    
        static Boolean valid_input(int input, int[][]grid, int turn) {
           int x = 0;
           int y = 0;
            if (input > 0 && input <=3){
                x = 0;
            }
            
            if (input > 3 && input <=6){
                x = 1;
            }
            
            if (input > 6 && input <=9){
                x = 2;
            }
            
            if (input % 3 == 0){
                y = 2;
            }
            
            if (input % 3 == 1){
                y = 0;
            }
            if (input % 3 == 2){
                y = 1;
            }

            if (grid[x][y] == 0){
                return true;
            }
            return false;
            
        }
        
        static void place_input(int input, int[][]grid, int turn) {
            int x = 0;
            int y = 0;
              if (input > 0 && input <=3){
                x = 0;
            }
            
            if (input > 3 && input <=6){
                x = 1;
            }
            
            if (input > 6 && input <=9){
                x = 2;
            }
            
             if (input % 3 == 0){
                y = 2;
            }
            
            if (input % 3 == 1){
                y = 0;
            }
            if (input % 3 == 2){
                y = 1;
            }
            

            if (turn == 1){
                grid[x][y] = 1;
            }
            else{
                grid[x][y] = -1;
            }
            
        }
        
        static void print_grid(int[][]grid){
            System.out.println("-------------");
            for (int i = 0; i<3; i++){
                System.out.print("|");
                for (int q = 0; q<3; q++){
                     if (grid[i][q]==1){
                         System.out.print(" x ");
                     }
                     else if (grid[i][q] == -1){
                         System.out.print(" o ");
                     }
                     else{
                         System.out.print("   ");
                     }
                     System.out.print("|");
                }
                System.out.print("\n");
                
                     System.out.println("-------------");
               
            }
        }
       
        static int check_grid(int[][]grid, int turnCount){
           
           //check rows
           for (int i = 0; i<3; i++){
               if (grid[i][0]==grid[i][1] && grid[i][1]==grid[i][2]){
                   return grid[i][0];
               }
           }
           
           //check columns
           for (int i = 0; i<3; i++){
               if (grid[0][i]==grid[1][i] && grid[1][i]==grid[2][i]){
                   return grid[0][i];
               }
           }
           
           //check diag
           if (grid[0][0]==grid[1][1] && grid[2][2]==grid[1][1]){
               return grid[0][0];
           }
           
           if (turnCount==9){
               return 2;
           }
           return 0;
           
       }
}