package ies.programacion.segonaV.Proyecto.PiezasW;

import ies.programacion.segonaV.Proyecto.Celda;
import ies.programacion.segonaV.Proyecto.ChessType;
import ies.programacion.segonaV.Proyecto.PiezasM.MQueen;

public class WQueen extends MQueen {
    public WQueen(Celda cell) {
        super(cell, ChessType.W_queen);
        place();
    }
}

