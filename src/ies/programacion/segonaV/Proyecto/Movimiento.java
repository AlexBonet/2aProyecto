package ies.programacion.segonaV.Proyecto;

import static com.diogonunes.jcolor.Ansi.colorize;

public class Movimiento {
    private static  int last_numero=1;
    private int numero;
    private ChessType chessType;
    private Coordenada origen;
    private Coordenada destino;

    /**
     * Constructor
     * @param chessType
     * @param origen
     * @param destino
     */
    public Movimiento (ChessType chessType, Coordenada origen,Coordenada destino){
        this.numero=last_numero++;
        this.chessType=chessType;
        this.origen=origen;
        this.destino=destino;
    }

    /**
     * Como se representa cada moviento
     * @return
     */
    @Override
    public String toString() {
        return "[" +"#" + numero +" | "
                + colorize(chessType.getForma(),chessType.getColor().getAttribute()) +
                " | " + origen + " | " + destino + "]" + "\n";
    }


}
