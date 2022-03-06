package ies.programacion.segonaV.Proyecto.PiezasB;

import ies.programacion.segonaV.Proyecto.Celda;
import ies.programacion.segonaV.Proyecto.ChessType;
import ies.programacion.segonaV.Proyecto.PiezasM.MTorre;

import java.io.Serializable;

/**
 * Torre negra
 */
public class BTorre extends MTorre implements Serializable {
    public BTorre(Celda cell) {
        super(cell, ChessType.B_torre);
        place();
    }
}