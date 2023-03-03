import java.util.Scanner;

public class TicTacToe {
    final char SIGN_X = 'x';
    final char SIGN_O = 'o';
    final char SIGN_EMPTY = '.';
    char[][] field;
    Scanner scanner;
    String player1Name, player2Name;

    public static void main(String[] args) {

        new TicTacToe().game();

    }
        TicTacToe(){
            scanner = new Scanner(System.in);
            field = new char[3][3];
        }

        void game(){                                                        //логика игры

            initField();

            System.out.println("Player 1, please, input your name: ");
            player1Name = scanner.nextLine();
            System.out.println("Hello, " + player1Name + "!");

            System.out.println("Player 2, please, input your name: ");
            player2Name = scanner.nextLine();
            System.out.println("Hello, " + player2Name + "!");


            while (true){
                turnPlayerOne();
                if (checkWin(SIGN_X)){
                    System.out.println("You win, " + player1Name);
                    break;
                } else if (isFieldFull()){
                    System.out.println("DRAW!");
                    break;
                }

                turnPlayerTwo();
                printField();
                if(checkWin(SIGN_O)){
                    System.out.println("You win, " + player2Name);
                    break;
                } else if (isFieldFull()){
                    System.out.println("DRAW!");
                    break;
                }
            }
            System.out.println("GAME OVER");
            printField();
    }
        void initField(){                                                //инициализация игровой таблицы
            int row, col = 0;
            for (row = 0; row < field.length; row++){
                for (col = 0; col < field.length; col++) {
                    System.out.print(field[row][col] = SIGN_EMPTY);
                }
                System.out.println();
            }

        }

        void printField() {                                                 //текущее состояние игрового поля
            int row, col = 0;
            for (row = 0; row < field.length; row++) {
                for (col = 0; col < field.length; col++) {
                    System.out.print(field[row][col] + " ");
                }
                System.out.println();
            }
        }

        void turnPlayerOne(){                                               //ход первого игрока
        int x, y;
        do {
            System.out.println(player1Name + ", Enter X and Y (1..3): ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        field[y][x] = SIGN_X;
        }

    void turnPlayerTwo(){                                                   //ход второго игрока
        int x, y;
        do {
            System.out.println(player2Name + ", Enter X and Y (1..3): ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        field[y][x] = SIGN_O;
    }

        boolean isCellValid(int x, int y){                                     //проверка координат поля
            if (x < 0 || y < 0 || x >= 3 || y >= 3)
                return false;
            return field[y][x] == SIGN_EMPTY;
        }


        boolean checkWin(char dot) {                                            //проверка победы
            for (int i = 0; i < field.length; i++) {
                if ((field[i][0] == dot &&
                        field[i][1] == dot &&
                        field[i][2] == dot) ||
                        (field[0][i] == dot &&
                                field[1][i] == dot &&
                                field[2][i] == dot))
                    return true;

                if ((field[0][0] == dot &&
                        field[1][1] == dot &&
                        field[2][2] == dot) ||
                        (field[2][0] == dot &&
                                field[2][1] == dot &&
                                field[0][2] == dot))
                    return true;


            } return false;
        }

    boolean isFieldFull() {                                     //проверка на ничью
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field.length; col++)
                if (field[row][col] == SIGN_EMPTY)
                    return false;
        }   return true;
    }

}

