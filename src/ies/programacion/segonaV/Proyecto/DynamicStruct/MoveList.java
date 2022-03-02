package ies.programacion.segonaV.Proyecto.DynamicStruct;

import ies.programacion.segonaV.Proyecto.Movimiento;

import java.util.LinkedList;
import java.util.List;

/**
 * Lista de Movimientos
 */

public class MoveList {

    List<Movimiento> listaMovimientos;

    /**
     * Contructor
     */
    public MoveList(){
        listaMovimientos=new LinkedList<>();
    }

    /**
     * Añadir un movimiento
     * @param movimiento
     */
    public void add(Movimiento movimiento){
        listaMovimientos.add(movimiento);
    }

    /**
     * Elimina el primer movimiento
     */
    public void remove(){
        listaMovimientos.remove(0);
    }

    /**
     * Muestra los ultimos 5 movimintos
     * @return un string con los moviminetos
     */
    public String showLast5(){
        String output="";
        if (listaMovimientos.size()>5) {
            for (int i = 1; i <= 5; i++)
                output += (listaMovimientos.get(listaMovimientos.size() - i));
        }else {
            for (int i = 1; i <= listaMovimientos.size(); i++)
                output += (listaMovimientos.get(listaMovimientos.size() - i));
        }
        return output;
    }

    /**
     * Muestra todos los movimientos
     * @return un string con los moviminetos
     */
    public String showAllMov(){
        String output="";
        for (int i=1;i<=listaMovimientos.size();i++)
            output+=(listaMovimientos.get(listaMovimientos.size()-i));
        return output;
    }

    /**
     * Muestra el ultimo movimiento
     * @return un string con los moviminetos
     */
    public String showLastOne(){
        if (listaMovimientos.size()==0)
            return " + No hay movimientos";
        else
            return listaMovimientos.get(listaMovimientos.size()-1).toString();
    }

    /**
     * Muestra los movimientos que indique
     * @param x numero de movimientos
     * @return un string con los moviminetos
     */
    public String showX(int x){
        String output="";
        for (int i=1;i<=x;i++)
            output+=(listaMovimientos.get(listaMovimientos.size()-i));
        return output;
    }

}
