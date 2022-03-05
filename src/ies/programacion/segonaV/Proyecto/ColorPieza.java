package ies.programacion.segonaV.Proyecto;

import com.diogonunes.jcolor.Attribute;

/**
 * Enumerador del color para las piezas
 */
public enum ColorPieza {
    WHITE(Attribute.TEXT_COLOR(255,255,255)),//255,255,255
    BLACK(Attribute.TEXT_COLOR(0,0,0));

    private Attribute color;

    ColorPieza(Attribute color){
        this.color=color;
    }

    public Attribute getAttribute(){
        return color;
    }


    public ColorPieza next(){
//        return ColorPieza.values()[((ordinal()+1)%ColorPieza.values().length)]; //
        if (ordinal()==0)
            return BLACK;
        else
            return WHITE;
    }
}
