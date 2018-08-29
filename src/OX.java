
public class OX {
    String table[][]= {{" ","0","1","2"},
            {"0","-","-","-"},
            {"1","-","-","-"},
            {"2","-","-","-"}};
    private String currentPlayer;
    private int turncount;
    private int scorex;
    private int scoreo;
    private int scoreDraw;
    public OX() {
        currentPlayer="x";
        turncount = 0;
        scorex=0;
        scoreo=0;
        scoreDraw=0;
    }
    public String getTableString() {
        String result ="";
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++) {
                result = result+table[i][j];
            }
            result=result+"\n";
        }
        return result;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public void switchPlayer() {
        if(currentPlayer.equals("x")) {
            currentPlayer="o";
        }else {
            currentPlayer="x";
        }
    }

    public boolean put(int col,int row) {
        try {if(!(table[row+1][col+1].equals("-"))) {
            return false;
        }
            table[row+1][col+1]=currentPlayer;

        }catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        turncount++;
        if(checkWin(col, row)) {
            if(currentPlayer.equals("x")) {
                scorex++;
            }else if(currentPlayer.equals("o")) {
                scoreo++;
            }

        }
        if(isDraw()) {
            scoreDraw++;
        }
        return true;
    }

    public String get(int col,int row) {
        if(col>2||col<0||row<0||row>2) {
            return null;
        }
        return table[row+1][col+1];
    }

    public boolean checkWin(int col,int row) {
        boolean colWin=true;
        for(int i=0;i<3;i++) {
            if(!table[i+1][col+1].equals(currentPlayer)) {
                colWin=false;
            }

        }
        if(colWin) {
            return true;
        }
        boolean rowWin=true;
        for(int i=0;i<3;i++) {
            if(!table[row+1][i+1].equals(currentPlayer)) {
                rowWin=false;
            }

        }
        if(rowWin) {
            return true;
        }
        boolean esWin=true;
        for(int i=0;i<3;i++) {
            if(!table[i+1][i+1].equals(currentPlayer)) {
                esWin=false;
            }

        }
        if(esWin) {
            return true;
        }
        boolean ssWin=true;
        for(int i=0;i<3;i++) {
            if(!table[i+1][3-i].equals(currentPlayer)) {
                ssWin=false;
            }

        }
        if(ssWin) {
            return true;
        }

        return false;
    }
    public void reset() {
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                table[i+1][j+1]="-";
            }
        }
        currentPlayer="x";
        turncount=0;
    }
    public int getTurnCount() {
        return turncount;

    }
    public boolean isDraw() {
        if(turncount<9) {
            return false;
        }
        return true;
    }
    public int getScorex() {
        return scorex;
    }
    public int getScoreo() {
        return scoreo;
    }
    public int getScoreDraw() {
        return scoreDraw;
    }
}
