package ies.programacion.segonaV.Proyecto.DynamicStruct;

import ies.programacion.segonaV.Proyecto.ChessType;
import ies.programacion.segonaV.Proyecto.Pieza;

public interface IDeletePieceManager {
    void add(Pieza pieza);
    Pieza getFirst();
    void remove(Pieza pieza);
    int count (ChessType chessType);
}
