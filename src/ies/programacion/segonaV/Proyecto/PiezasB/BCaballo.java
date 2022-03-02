package ies.programacion.segonaV.Proyecto.PiezasB;

import ies.programacion.segonaV.Proyecto.Celda;
import ies.programacion.segonaV.Proyecto.ChessType;
import ies.programacion.segonaV.Proyecto.PiezasM.MCaballo;

/**
 * Caballo negro
 */
public class BCaballo extends MCaballo {
    public BCaballo(Celda cell) {
        super(cell, ChessType.B_caballo);
        place();
    }
}
