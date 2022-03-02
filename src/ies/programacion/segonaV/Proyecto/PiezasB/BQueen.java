package ies.programacion.segonaV.Proyecto.PiezasB;

import ies.programacion.segonaV.Proyecto.Celda;
import ies.programacion.segonaV.Proyecto.ChessType;
import ies.programacion.segonaV.Proyecto.PiezasM.MQueen;

/**
 * Reina negra
 */
public class BQueen extends MQueen {
    public BQueen(Celda cell) {
        super(cell, ChessType.B_queen);
        place();
    }
}

