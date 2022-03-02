package ies.programacion.segonaV.Proyecto.PiezasW;

import ies.programacion.segonaV.Proyecto.Celda;
import ies.programacion.segonaV.Proyecto.ChessType;
import ies.programacion.segonaV.Proyecto.Coordenada;
import ies.programacion.segonaV.Proyecto.PiezasM.MCaballo;

import java.util.Set;

/**
 * Caballo blanco
 */
public class WCaballo extends MCaballo {
    public WCaballo(Celda cell) {
        super(cell, ChessType.W_caballo);
        place();
    }

}
