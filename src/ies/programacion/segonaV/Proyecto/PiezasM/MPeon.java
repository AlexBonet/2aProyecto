package ies.programacion.segonaV.Proyecto.PiezasM;

import ies.programacion.segonaV.Proyecto.Celda;
import ies.programacion.segonaV.Proyecto.ChessType;
import ies.programacion.segonaV.Proyecto.Coordenada;
import ies.programacion.segonaV.Proyecto.Pieza;
import ies.programacion.segonaV.Proyecto.PiezasB.BQueen;
import ies.programacion.segonaV.Proyecto.PiezasW.WQueen;

/**
 * @override
 * bolean moveTO(cordenada c){
 * super.moveTo(c);
 * if(c.getNumbres==1 || ==8)
 *     createReina();
 *
 * protect abstract void createQueen();
 */

public abstract class MPeon  extends Pieza{
    public MPeon(Celda cell, ChessType tipo) {
        super(cell, tipo);
    }
    
    public boolean moveTo(Coordenada c){
        super.moveTo(c);
        if (c.getNum()==1 || c.getNum()==8){
            createReina();
            return  true;
        }else 
            return false;
    }
    
    protected abstract void createReina();




}
