import java.util.Scanner;
public class Game {
    private static OX ox;
    private static Scanner nn=new Scanner(System.in);
    private static int col,row;

    public static void main(String[] args) {
        ox=new OX();
        while(true) {

            print();
            input();
            if(ox.checkWin(col, row)) {
                print();
                System.out.println(ox.getCurrentPlayer()+" Win");
                printScore();
                ox.reset();
                continue;
            }
            if(ox.isDraw()) {
                print();
                System.out.println("Draw");
                printScore();
                ox.reset();
                continue;
            }
            ox.switchPlayer();
        }

    }

    private static void printScore() {
        System.out.println("x win: = "+ox.getScorex());
        System.out.println("o win: = "+ox.getScoreo());
        System.out.println("Draw: = "+ox.getScoreDraw());
    }

    private static void input() {
        boolean canPut = true;
        do {
            System.out.println(ox.getCurrentPlayer()+" col : ");
            col =nn.nextInt();
            System.out.println(ox.getCurrentPlayer()+" row : ");
            row =nn.nextInt();
            canPut = ox.put(col, row);
            if(!canPut) {
                System.out.println("Please input number between 0-2");
            }
        }while(!canPut);
    }

    private static void print() {
        System.out.print(ox.getTableString());

    }

}
