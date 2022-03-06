package ies.programacion.segonaV.Proyecto;

import com.diogonunes.jcolor.Attribute;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import static com.diogonunes.jcolor.Ansi.colorize;

public abstract class Pieza implements Serializable {
    private ChessType chessType;
    protected Celda celda;

    /**
     * Constrctor
     * @param cell
     * @param tipo
     */
    public Pieza(Celda cell, ChessType tipo){
        this.celda=cell;
        this.chessType=tipo;
    }

    /**
     * Coloca Pieza
     */
    public void place(){
        celda.setPieza(this);
    }

    /**
     * Gettets
     * @return
     */
    public Celda getCelda() {
        return celda;
    }
    public ColorPieza getColor(){
        return this.chessType.getColor();
    }
    public ChessType getChessType() {
        return chessType;
    }

    public void setCelda(Celda celda) {
        this.celda = celda;
    }

    @Override
    public String toString(){
        Attribute background=celda.getColor().getAttribute();
        Attribute textColor=chessType.getColor().getAttribute();
        Attribute[] myFormat=new Attribute[]{background,textColor};

        return colorize(" " + chessType.getForma()+" ", myFormat);
    }
    @Override
    public boolean equals(Object o){
        if (o instanceof Pieza){
            Pieza p = (Pieza) o;
            if (p.celda==this.celda && p.chessType==this.chessType)
                return true;
            else
                return false;
        }else return false;
    }

    /**
     * Que todas la piezas tengan este metodo
     * @return
     */
    public abstract List<Coordenada> getNextMove();

    /**
     * Donde se puede mover
     * @param aux
     * @return
     */
    public boolean canMoveTo(Coordenada aux){
        TableroChess board = celda.getTablero();
        return estaLibre(aux) || esRival(aux);
    }

    /**
     * Comprueba si la celda está libre
     * @param aux
     * @return
     */
    public boolean estaLibre(Coordenada aux){
        TableroChess board = celda.getTablero();
        return board.containsCellAt(aux) && !board.containsPieceAt(aux);
    }

    /**
     * Comprueba si en la celda hay un rival
     * @param aux
     * @return
     */
    public boolean esRival(Coordenada aux){
        TableroChess board = celda.getTablero();
        return (board.containsCellAt(aux) &&
                board.containsPieceAt(aux) &&
                board.getCellAt(aux).getPieza().getColor()!=getColor());
    }

    /**
     * Metodo que mueve una pieza a otra
     * @param c
     * @return
     */
    public boolean moveTo(Coordenada c) {
        if (celda==null || !celda.getTablero().containsCellAt(c))
            return false;

        if (getNextMove().contains(c)){
            TableroChess board=celda.getTablero();
            if (board.containsPieceAt(c)) {
                //Kill
                Pieza p = board.getCellAt(c).getPieza();
                p.celda=null;
//                board.getStore4Deleted().add(p);
            }
            celda.setPieza(null);
            celda=board.getCellAt(c);
            place();
            return true;
        }else
            return false;
    }
}
