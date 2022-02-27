package ies.programacion.segonaV.Proyecto.PiezasB;

import ies.programacion.segonaV.Proyecto.Celda;
import ies.programacion.segonaV.Proyecto.ChessType;
import ies.programacion.segonaV.Proyecto.PiezasM.MKing;

public class BKing extends MKing {
    public BKing(Celda cell) {
        super(cell, ChessType.B_king);
        place();
    }

//    @Override
//    public Celda getCellKing() {
//        return celda;
//    }
}

