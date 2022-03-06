package ies.programacion.segonaV.Proyecto.PiezasM;

import ies.programacion.segonaV.Proyecto.Celda;
import ies.programacion.segonaV.Proyecto.ChessType;
import ies.programacion.segonaV.Proyecto.Coordenada;
import ies.programacion.segonaV.Proyecto.Pieza;
import ies.programacion.segonaV.Proyecto.PiezasB.BQueen;
import ies.programacion.segonaV.Proyecto.PiezasW.WQueen;

import java.io.Serializable;

/**
 * Clase padre para el peón
 */
public abstract class MPeon extends Pieza implements Serializable {
    public MPeon(Celda cell, ChessType tipo) {
        super(cell, tipo);
    }

    /**
     * Cambiar el peon a Reina
     * @param c
     * @return
     */
    public boolean moveTo(Coordenada c){
        super.moveTo(c);
        if (c.getNum()==1 || c.getNum()==8){
            createReina();
            return  true;
        }else 
            return false;
    }

    /**
     * Metodo para crear una reina
     */
    protected abstract void createReina();




}
