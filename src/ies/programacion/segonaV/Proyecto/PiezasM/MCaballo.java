package ies.programacion.segonaV.Proyecto.PiezasM;

import ies.programacion.segonaV.Proyecto.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * Clase padre para el caballo
 */
public abstract class MCaballo extends Pieza implements Serializable {
    public MCaballo(Celda cell, ChessType tipo) {
        super(cell, tipo);
    }

    @Override
    public List<Coordenada> getNextMove() {
        List<Coordenada> nextMovements = new ArrayList<>();
        TableroChess board=celda.getTablero();
        Coordenada position=celda.getCoordenada();
        Coordenada aux;


        //TopTopLeft
        aux=position.coorTop().diagonalTopLeft();
        if (canMoveTo(aux))
            nextMovements.add(aux);

        //TopTopRight
        aux=position.coorTop().diagonalTopRight();
        if (canMoveTo(aux))
            nextMovements.add(aux);

        //BotBotLeft
        aux=position.coorBot().diagonalBotLeft();
        if (canMoveTo(aux))
            nextMovements.add(aux);

        //BotBotRight
        aux=position.coorBot().diagonalBotRight();
        if (canMoveTo(aux))
            nextMovements.add(aux);

        //LeftLeftTop
        aux=position.coorLeft().diagonalTopLeft();
        if (canMoveTo(aux))
            nextMovements.add(aux);

        //LeftLeftBot
        aux=position.coorLeft().diagonalBotLeft();
        if (canMoveTo(aux))
            nextMovements.add(aux);

        //RightRightBot
        aux=position.coorRigth().diagonalBotRight();
        if (canMoveTo(aux))
            nextMovements.add(aux);

        //RightRightTop
        aux=position.coorRigth().diagonalTopRight();
        if (canMoveTo(aux))
            nextMovements.add(aux);

        return nextMovements;
    }

}
