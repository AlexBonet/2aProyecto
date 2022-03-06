package ies.programacion.segonaV.Proyecto.PiezasB;

import ies.programacion.segonaV.Proyecto.Celda;
import ies.programacion.segonaV.Proyecto.ChessType;
import ies.programacion.segonaV.Proyecto.PiezasM.MKing;

import java.io.Serializable;

/**
 * Rey negro
 */
public class BKing extends MKing implements Serializable {
    public BKing(Celda cell) {
        super(cell, ChessType.B_king);
        place();
    }
}

