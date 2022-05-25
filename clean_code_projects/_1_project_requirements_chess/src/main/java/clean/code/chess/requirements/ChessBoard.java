package clean.code.chess.requirements;

public class ChessBoard {

    public static int MAX_BOARD_WIDTH = 7;
    public static int MAX_BOARD_HEIGHT = 7;

    private Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[MAX_BOARD_WIDTH][MAX_BOARD_HEIGHT];

    }

    public void Add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        boolean isValidPosition = IsLegalBoardPosition(xCoordinate,yCoordinate);
        pawn.setChessBoard(this);
        if(isValidPosition){
            if(yCoordinate <= 6){
                if(pieces[xCoordinate][yCoordinate] == null){
                    pawn.setYCoordinate(yCoordinate);
                    pawn.setXCoordinate(xCoordinate);
                    pieces[xCoordinate][yCoordinate] = pawn;
                }else{
                    pawn.setXCoordinate(-1);
                    pawn.setYCoordinate(-1);
                }
            }else{
                pawn.setXCoordinate(-1);
                pawn.setYCoordinate(-1);
            }

        }else{
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
        }
        //throw new UnsupportedOperationException("Need to implement ChessBoard.add()");
    }


    public boolean IsLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return 0 <= xCoordinate && xCoordinate <= MAX_BOARD_WIDTH && 0 <= yCoordinate && yCoordinate <= MAX_BOARD_WIDTH;

        //throw new UnsupportedOperationException("Need to implement ChessBoard.IsLegalBoardPosition()");
    }
}

