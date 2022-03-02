package ies.programacion.segonaV.Proyecto.DynamicStruct;

import ies.programacion.segonaV.Proyecto.ChessType;
import ies.programacion.segonaV.Proyecto.Pieza;

import java.util.LinkedList;
import java.util.List;

/**
 * Almacen de piezas
 */
public class MyLinkedStore implements IDeletePieceManager{
    private List<Pieza> piezas;

    /**
     * Constructor
     */
    public MyLinkedStore() {
        this.piezas = new LinkedList<>();
    }

    @Override
    public void add(Pieza pieza) {
        piezas.add(pieza);
    }

    @Override
    public Pieza getFirst() {
        return piezas.get(0);
    }

    @Override
    public void remove(Pieza pieza) {
        piezas.remove(pieza);
    }

    @Override
    public int count(ChessType chessType) {
        return (int) piezas.stream().filter(p->p.getChessType()==chessType).count();
//        int suma=0;
//        for (Pieza pieza:piezas)
//            if (pieza.getChessType()==chessType)
//                suma++;
//        return suma;
    }
}
