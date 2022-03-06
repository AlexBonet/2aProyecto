package ies.programacion.segonaV.Proyecto.PiezasM;

import ies.programacion.segonaV.Proyecto.*;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase padre para el alfil
 */
public abstract class MAlfil extends Pieza implements Serializable {
    public MAlfil(Celda cell, ChessType tipo) {
        super(cell, tipo);
    }

    @Override
    public List<Coordenada> getNextMove() {
        return getMovAsAlfil(this);

    }

    /**
     * Obtener los siguientes movimientos
     * @return lista con los posibles siguientes movimientos
     */
    public static List<Coordenada> getMovAsAlfil(Pieza p){
        List<Coordenada> nextMovements =  new ArrayList<>();
        TableroChess board =p.getCelda().getTablero();
        Coordenada position=p.getCelda().getCoordenada();
        Coordenada aux;

        //TopLeft
        aux=position.diagonalTopLeft();
        while (board.containsCellAt(aux) && !board.containsPieceAt(aux)){
            nextMovements.add(aux);
            aux=aux.diagonalTopLeft();
        }
        if (board.containsPieceAt(aux) && esRival(aux,p))
            nextMovements.add(aux);


        //TopRight
        aux=position.diagonalTopRight();
        while (board.containsCellAt(aux) && !board.containsPieceAt(aux)){
            nextMovements.add(aux);
            aux=aux.diagonalTopRight();
        }
        if (board.containsPieceAt(aux) && esRival(aux,p))
            nextMovements.add(aux);

        //BotLeft
        aux=position.diagonalBotLeft();
        while (board.containsCellAt(aux) && !board.containsPieceAt(aux)){
            nextMovements.add(aux);
            aux=aux.diagonalBotLeft();
        }
        if (board.containsPieceAt(aux) && esRival(aux,p))
            nextMovements.add(aux);

        //BotRight
        aux=position.diagonalBotRight();
        while (board.containsCellAt(aux) && !board.containsPieceAt(aux)){
            nextMovements.add(aux);
            aux=aux.diagonalBotRight();
        }
        if (board.containsPieceAt(aux) && esRival(aux,p))
            nextMovements.add(aux);

        return nextMovements;
    }

    /**
     * Comprueba que es lo que hay en la la coordenada
     * @param aux coordenada
     * @param p pieza
     * @return true si puede, false si no puede
     */
    public static boolean canMoveTo(Coordenada aux, Pieza p){
        TableroChess board = p.getCelda().getTablero();
        return estaLibre(aux,p) || esRival(aux,p);
    }

    /**
     * Comprueba si la celda está libre
     * @param aux
     * @return
     */
    public static boolean estaLibre(Coordenada aux, Pieza p){
        TableroChess board = p.getCelda().getTablero();
        return board.containsCellAt(aux) && !board.containsPieceAt(aux);
    }

    /**
     * Comprueba si en la celda hay un rival
     * @param aux
     * @return
     */
    public static boolean esRival(Coordenada aux, Pieza p){
        TableroChess board = p.getCelda().getTablero();
        return (board.containsCellAt(aux) &&
                board.containsPieceAt(aux) &&
                board.getCellAt(aux).getPieza().getColor()!=p.getColor());
    }
}
