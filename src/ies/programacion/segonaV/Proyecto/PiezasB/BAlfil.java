package ies.programacion.segonaV.Proyecto.PiezasB;

import ies.programacion.segonaV.Proyecto.Celda;
import ies.programacion.segonaV.Proyecto.ChessType;
import ies.programacion.segonaV.Proyecto.PiezasM.MAlfil;

public class BAlfil extends MAlfil {
    public BAlfil(Celda cell) {
        super(cell, ChessType.B_alfil);
        place();
    }
}
