package ies.programacion.segonaV.Proyecto.PiezasW;

import ies.programacion.segonaV.Proyecto.Celda;
import ies.programacion.segonaV.Proyecto.ChessType;
import ies.programacion.segonaV.Proyecto.PiezasM.MAlfil;

import java.io.Serializable;

/**
 * Alfil blanco
 */
public class WAlfil extends MAlfil implements Serializable {
    public WAlfil(Celda cell) {
        super(cell, ChessType.W_alfil);
        place();
    }
}
