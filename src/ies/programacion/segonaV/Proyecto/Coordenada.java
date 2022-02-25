package ies.programacion.segonaV.Proyecto;

import java.util.Objects;

public class Coordenada {
    private char x; //letra
    private int y;  //numero

    public Coordenada(char x, int y){
        this.x=String.valueOf(x).toUpperCase().charAt(0); //lee x siempre la pasará a MAYUS
        this.y=y;//lee Y
    }

    /**
     * COORDENADAS RECTAS
     * @return coordenada nueva
     */
    public Coordenada coorTop(){
        return new Coordenada(x,y-1);
    }
    public Coordenada coorBot(){
        return new Coordenada(x,y+1);
    }
    public Coordenada coorLeft(){
        return new Coordenada((char) (x-1),y);
    }
    public Coordenada coorRigth(){
        return new Coordenada((char) (x+1),y);
    }
    /**
     * COORDENADAS DIAGONAL
     * @return coordenada nueva
     */
    public Coordenada diagonalTopLeft(){
        return new Coordenada((char) (x-1),y-1);
    }
    public Coordenada diagonalTopRight(){
        return new Coordenada((char) (x+1),y-1);
    }
    public Coordenada diagonalBotLeft(){
        return new Coordenada((char) (x-1),y+1);
    }
    public Coordenada diagonalBotRight(){
        return new Coordenada((char) (x+1),y+1);
    }
/**
 * diagonal mejorado
 * return coorTop().coorLeft();
 * reutiliza las cordanas rectas y las junta
 */

    public char getLetter() {
        return x;
    }
    public int getNum() {
        return y;
    }

    public String toString(){
        return "("+x+","+y+")";
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Coordenada))	return false;
        return ((Coordenada) o).getLetter() == this.x && ((Coordenada) o).getNum() == this.y;
    }

    @Override
    public int hashCode() {
        return y+x;
    }
}
