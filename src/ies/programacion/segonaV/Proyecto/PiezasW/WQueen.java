package ies.programacion.segonaV.Proyecto.PiezasW;

import ies.programacion.segonaV.Proyecto.Celda;
import ies.programacion.segonaV.Proyecto.ChessType;
import ies.programacion.segonaV.Proyecto.PiezasM.MQueen;

import java.io.Serializable;

/**
 * Reina blanca
 */
public class WQueen extends MQueen implements Serializable {
    public WQueen(Celda cell) {
        super(cell, ChessType.W_queen);
        place();
    }
}

