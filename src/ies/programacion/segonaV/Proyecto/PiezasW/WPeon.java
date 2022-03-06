package ies.programacion.segonaV.Proyecto.PiezasW;

import ies.programacion.segonaV.Proyecto.*;
import ies.programacion.segonaV.Proyecto.PiezasB.BQueen;
import ies.programacion.segonaV.Proyecto.PiezasM.MPeon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Peón blanco
 */
public class WPeon extends MPeon implements Serializable {
    public WPeon(Celda cell) {
        super(cell, ChessType.W_peon);
        place();
    }

    @Override
    public List<Coordenada> getNextMove() {
        List<Coordenada> nextMovements = new ArrayList<>();
        TableroChess board = celda.getTablero();
        Coordenada position = celda.getCoordenada();
        Coordenada aux;

        //Opciones
        //Avance 1
        aux=position.coorTop();
        if (canMoveTo(aux) && !esRival(aux))
            nextMovements.add(aux);

        //Avance 2
        if (position.getNum()==7) {
            aux = position.coorTop().coorTop();
            if (canMoveTo(aux))
                nextMovements.add(aux);
        }

        //KILL der
        aux=position.diagonalTopRight();
        if (!estaLibre(aux) && esRival(aux))
            nextMovements.add(aux);

        //KILL izq
        aux=position.diagonalTopLeft();
        if (!estaLibre(aux) && esRival(aux))
            nextMovements.add(aux);

        return nextMovements;
    }

    @Override
    protected void createReina() {
        TableroChess board= celda.getTablero();
        board.getStore4InBoard().remove(this);
        celda.setPieza(null);
        celda.setPieza(new WQueen(celda));
//        board.getStore4InBoard().add(this);
    }
}
