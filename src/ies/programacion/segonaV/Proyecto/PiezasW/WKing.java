package ies.programacion.segonaV.Proyecto.PiezasW;

import ies.programacion.segonaV.Proyecto.Celda;
import ies.programacion.segonaV.Proyecto.ChessType;
import ies.programacion.segonaV.Proyecto.PiezasM.MKing;

public class WKing extends MKing {
    public WKing(Celda cell) {
        super(cell, ChessType.W_king);
        place();
    }

//    @Override
//    public Celda getCellKing() {
//        return celda;
//    }
}

