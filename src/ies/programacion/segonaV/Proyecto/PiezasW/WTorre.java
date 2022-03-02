package ies.programacion.segonaV.Proyecto.PiezasW;

import ies.programacion.segonaV.Proyecto.Celda;
import ies.programacion.segonaV.Proyecto.ChessType;
import ies.programacion.segonaV.Proyecto.PiezasM.MTorre;

/**
 * Torre blanca
 */
public class WTorre extends MTorre {
    public WTorre(Celda cell) {
        super(cell, ChessType.W_torre);
        place();
    }
}