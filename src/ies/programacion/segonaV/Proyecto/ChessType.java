package ies.programacion.segonaV.Proyecto;

import java.io.Serializable;

/**
 * Enumerador de las piezas que hay
 */
public enum ChessType implements Serializable {
    B_king("♚",ColorPieza.BLACK),
    B_queen("♛",ColorPieza.BLACK),
    B_alfil("♝",ColorPieza.BLACK),
    B_caballo("♞",ColorPieza.BLACK),
    B_torre("♜",ColorPieza.BLACK),
    B_peon("♟",ColorPieza.BLACK),
    W_king("♚",ColorPieza.WHITE),
    W_queen("♛",ColorPieza.WHITE),
    W_alfil("♝",ColorPieza.WHITE),
    W_caballo("♞",ColorPieza.WHITE),
    W_torre("♜",ColorPieza.WHITE),
    W_peon("♟",ColorPieza.WHITE);

    private String forma;
    private ColorPieza color;

    ChessType(String forma, ColorPieza color){
        this.forma=forma;
        this.color=color;
    }

    public String getForma(){
        return forma;
    }
    public ColorPieza getColor(){
        return color;
    }

    @Override
    public String toString() {
        return forma+color.toString();
    }
}
