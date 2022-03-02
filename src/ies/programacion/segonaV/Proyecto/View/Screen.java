package ies.programacion.segonaV.Proyecto.View;


import com.diogonunes.jcolor.Attribute;
import ies.programacion.segonaV.Proyecto.*;
import ies.programacion.segonaV.Proyecto.ChessType;
import ies.programacion.segonaV.Proyecto.Coordenada;
import ies.programacion.segonaV.Proyecto.DynamicStruct.IDeletePieceManager;
import ies.programacion.segonaV.Proyecto.TableroChess;
import static com.diogonunes.jcolor.Ansi.colorize;

public class Screen {
    /**
     * Muestra el tablero para que juegue el jugador blanco
     * @param board tablero que quieres mostrar
     */
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

    /**
     * Muestra el tablero para que juegue el jugardor negro
     * @param board
     */
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

    /**
     * Marcador de las piezas eliminadas
     * @param store lista que vamos a mostrar
     */
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

    /**
     * Marcador de las piezas que hay sobre el tablero
     * @param b tablero con las piezas
     */
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

    /**
     * Muestra el numero de piezas que hay
     * @param b tablero de referencia
     * @param cT tipo de las piezas
     * @return valor numero con cuantas piezas hay en el tablero
     */
    public static long showPieces(TableroChess b, ChessType cT){
        return b.getCeldas().stream()
                .filter(c -> c.getPieza() != null
                        && c.getPieza().getChessType() == cT)
                .count();
    }

    /**
     * Muestra mensajes en el final
     * @param g partida de referecia
     * @return mensaje
     */
    public static String mensajeFinal(Game g){
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
