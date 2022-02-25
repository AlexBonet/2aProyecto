package ies.programacion.segonaV.Proyecto.PiezasM;

import ies.programacion.segonaV.Proyecto.*;

import java.util.List;

import static ies.programacion.segonaV.Proyecto.PiezasM.MAlfil.getMovAsAlfil;
import static ies.programacion.segonaV.Proyecto.PiezasM.MTorre.getMovAsTorre;

public  abstract class MQueen extends Pieza {
    public MQueen(Celda cell, ChessType tipo) {
        super(cell, tipo);
    }
    @Override
    public List<Coordenada> getNextMove() {
        List<Coordenada> nextMovements=MAlfil.getMovAsAlfil(this);
        nextMovements.addAll(MTorre.getMovAsTorre(this));

        return nextMovements;
    }
}
