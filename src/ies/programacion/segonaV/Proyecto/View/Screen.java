package ies.programacion.segonaV.Proyecto.View;


import com.diogonunes.jcolor.Attribute;
import ies.programacion.segonaV.Proyecto.*;
import ies.programacion.segonaV.Proyecto.ChessType;
import ies.programacion.segonaV.Proyecto.Coordenada;
import ies.programacion.segonaV.Proyecto.DynamicStruct.IDeletePieceManager;
import ies.programacion.segonaV.Proyecto.TableroChess;
import static com.diogonunes.jcolor.Ansi.colorize;

public class Screen {
    public static void show(TableroChess board){

        String salida="  ";
        Coordenada c;
        for (char let='A';let<'I';let++){
            salida+=" "+ let +" ";
        }
        salida+="\n";
        for (int row=0;row<8;row++){
            salida+=(row + 1 )+" ";
            for (int col=0;col<8;col++){
                c = new Coordenada((char)('A'+col),row+1);
                salida+=board.getCellAt(c).toString();
            }
            salida+="\n";
        }
        salida+="  ";
        for (char let='A';let<'I';let++){
            salida+=" "+ let +" ";
        }
        salida+="\n";
        System.out.println(salida);
    }

    public static void showBlackP(TableroChess board){

        String salida="  ";
        Coordenada c;
        for (char let='H';let>'A'-1;let--){
            salida+=" "+ let +" ";
        }
        salida+="\n";
        for (int row=8;row>0;row--){
            salida+=row+" ";
            for (char let='H';let>'A'-1;let--){
                c=new Coordenada(let,row);
                salida+=board.getCellAt(c).toString();
            }
            salida+="\n";
        }
        salida+="  ";
        for (char let='H';let>'A'-1;let--){
            salida+=" "+ let +" ";
        }
        salida+="\n";
        System.out.println(salida);
    }

    public static void showDeletedPiece(IDeletePieceManager store){
        String salida="  | Piezas eliminadas" + "\n";
        salida+="  ";
        for (ChessType chessTypes:ChessType.values()){
            salida+=colorize(" "+ chessTypes.getForma()+" ",
                    Celda.ColorCelda.BLACK_Cell.getAttribute(),
                    chessTypes.getColor().getAttribute());
        }
        salida+="\n  ";
        for (ChessType chessTypes:ChessType.values()){
            salida+=colorize(" "+ store.count(chessTypes)+" ",
                    Celda.ColorCelda.WHITE_Cell.getAttribute(),
                    Attribute.TEXT_COLOR(140,0,0));
        }
        System.out.println(salida);
    }

    public static void showPieceOnBoard(TableroChess b) {
        String output = "  | Piezas en el tablero" + "\n";
        output+="  ";
        for (ChessType chessTypes : ChessType.values()) {
            output += colorize(" " + chessTypes.getForma() + " ",
                    Celda.ColorCelda.BLACK_Cell.getAttribute(),
                    chessTypes.getColor().getAttribute());
        }
        output += "\n  ";
        for (ChessType chessTypes : ChessType.values()) {
            output += colorize(" " + showPieces(b, chessTypes) + " ",
                    Celda.ColorCelda.WHITE_Cell.getAttribute(),
                    Attribute.TEXT_COLOR(87,87,223));
        }
        System.out.println(output);
    }

    public static long showPieces(TableroChess b, ChessType cT){
        return b.getCeldas().stream()
                .filter(c -> c.getPieza() != null
                        && c.getPieza().getChessType() == cT)
                .count();
    }

    public static String mensageFinal(Game g){
        String msg="";
        if (g.hayReyBlanco() && !g.hayReyNegro())
            msg+=colorize( g.getTurno() + " ha GANADO",
                    Celda.ColorCelda.BLACK.getAttribute(),
                    Attribute.TEXT_COLOR(255,255,255));

        else if (g.hayReyNegro() && !g.hayReyBlanco())
            msg+=colorize( g.getTurno() + " ha GANADO",
                    Celda.ColorCelda.WHITE_Cell.getAttribute(),
                    Attribute.TEXT_COLOR(0,0,0));
        else
            msg+=colorize("  FIN DE LA PARTIDA: ALGUN JUGADOR HA ABANDONADO  ",
                    Celda.ColorCelda.HIGHLIGHT_King_JAQUE.getAttribute(),
                    Attribute.TEXT_COLOR(0,0,0));

        return msg;
    }
}
