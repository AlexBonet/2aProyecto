package ies.programacion.segonaV.Proyecto;

import com.diogonunes.jcolor.Attribute;

import java.io.Serializable;

import static com.diogonunes.jcolor.Ansi.colorize;

public class Celda implements Serializable {
    private Coordenada coordenada;
    private ColorCelda color;
    private ColorCelda originalColor;
    private Pieza pieza;
    private TableroChess tablero;

    /**
     * Constructor
     * @param board tablero en el que está la celda
     * @param coor coordenada que representa
     */
    public Celda(TableroChess board,Coordenada coor){
        this.tablero=board;
        this.coordenada=coor;
        if(((coor.getLetter()-'A')+coor.getNum())%2==0)
            originalColor= ColorCelda.BLACK_Cell;
        else
            originalColor= ColorCelda.WHITE_Cell;

        color=originalColor;
    }

    /**
     * Formato en el que se ve la celda
     * @return
     */
    public String toString(){
        Attribute[] myFormat = new Attribute[]{color.getAttribute()};
        if(pieza!=null)
            return pieza.toString();
        else
            return colorize("   ",myFormat);
    }

    /**
     * Obtener la pieza que hay en la celda
     * @return Pieza
     */
    public Pieza getPieza() {
        return pieza;
    }

    /**
     * Obtener el color de la celda
     * @return
     */
    public ColorCelda getColor() {
        return color;
    }

    /**
     * Obtener el tablero de la celda
     * @return
     */
    public TableroChess getTablero() {
        return tablero;
    }

    /**
     * Obtener la coordenada de la celda
     * @return
     */
    public Coordenada getCoordenada() {
        return coordenada;
    }

    /**
     * Cambia la pieza de la celda
     * @param pieza que tomará la celda
     */
    public void setPieza(Pieza pieza) {
        this.pieza = pieza;
    }

    /**
     * Cambia el color de la celda
     * @param color que tomará la celda
     */
    public void setColor(ColorCelda color) {
        this.color = color;
    }

    /**
     * Devuelve al color original la celda
     */
    public void resetColor(){
        this.setColor(originalColor);
    }

    /**
     * Enumerador de Colores
     */
    public enum ColorCelda{
        WHITE_Cell(Attribute.BACK_COLOR(180,180,180)),
        BLACK_Cell(Attribute.BACK_COLOR(100,100,100)),
        BLACK(Attribute.BACK_COLOR(0,0,0)),

//        WHITE_Cell(Attribute.BACK_COLOR(169,175,148)),
//        BLACK_Cell(Attribute.BACK_COLOR(100,111,80)),

//        WHITE_Cell(Attribute.BACK_COLOR(226,208,189)),
//        BLACK_Cell(Attribute.BACK_COLOR(146,111,81)),

        HIGHLIGHT_MOV_WHITE(Attribute.BACK_COLOR(180,180,0)),
        HIGHLIGHT_MOV_BLACK(Attribute.BACK_COLOR(100,100,0)),


        HIGHLIGHT_King_JAQUE(Attribute.BACK_COLOR(253,134,0)),

        HIGHLIGHT_SELECT_WHITE(Attribute.BACK_COLOR(87,87,223)),
        HIGHLIGHT_SELECT_BLACK(Attribute.BACK_COLOR(61,61,149)),

        HIGHLIGHT_KILL_WHITE(Attribute.BACK_COLOR(200,0,0)),
        HIGHLIGHT_KILL_BLACK(Attribute.BACK_COLOR(140,0,0));

        private Attribute color;
        ColorCelda(Attribute color){
            this.color=color;
        }
        public Attribute getAttribute(){
            return color;
        }
    }


}
