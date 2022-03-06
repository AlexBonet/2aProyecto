package ies.programacion.segonaV.Proyecto.PiezasB;

import ies.programacion.segonaV.Proyecto.Celda;
import ies.programacion.segonaV.Proyecto.ChessType;
import ies.programacion.segonaV.Proyecto.PiezasM.MCaballo;

import java.io.Serializable;

/**
 * Caballo negro
 */
public class BCaballo extends MCaballo implements Serializable {
    public BCaballo(Celda cell) {
        super(cell, ChessType.B_caballo);
        place();
    }
}
