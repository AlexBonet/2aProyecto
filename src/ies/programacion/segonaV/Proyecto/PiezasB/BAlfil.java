package ies.programacion.segonaV.Proyecto.PiezasB;

import ies.programacion.segonaV.Proyecto.Celda;
import ies.programacion.segonaV.Proyecto.ChessType;
import ies.programacion.segonaV.Proyecto.PiezasM.MAlfil;

import java.io.Serializable;

/**
 * Alfil negro
 */
public class BAlfil extends MAlfil implements Serializable {
    public BAlfil(Celda cell) {
        super(cell, ChessType.B_alfil);
        place();
    }
}
