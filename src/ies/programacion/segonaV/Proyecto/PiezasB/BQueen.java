package ies.programacion.segonaV.Proyecto.PiezasB;

import ies.programacion.segonaV.Proyecto.Celda;
import ies.programacion.segonaV.Proyecto.ChessType;
import ies.programacion.segonaV.Proyecto.PiezasM.MQueen;

import java.io.Serializable;

/**
 * Reina negra
 */
public class BQueen extends MQueen implements Serializable {
    public BQueen(Celda cell) {
        super(cell, ChessType.B_queen);
        place();
    }
}

