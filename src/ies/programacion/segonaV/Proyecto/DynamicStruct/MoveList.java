package ies.programacion.segonaV.Proyecto.DynamicStruct;

import ies.programacion.segonaV.Proyecto.Movimiento;

import java.util.LinkedList;
import java.util.List;

public class MoveList {

    List<Movimiento> listaMovimientos;

    public MoveList(){
        listaMovimientos=new LinkedList<>();
    }

    public void add(Movimiento movimiento){
        listaMovimientos.add(movimiento);
    }

    public void remove(){
        listaMovimientos.remove(0);
    }

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

    public String showAllMov(){
        String output="";
        for (int i=1;i<=listaMovimientos.size();i++)
            output+=(listaMovimientos.get(listaMovimientos.size()-i));
        return output;
    }

    public String showLastOne(){
        return listaMovimientos.get(listaMovimientos.size()-1).toString();
    }

    public String showX(int x){
        String output="";
        for (int i=1;i<=x;i++)
            output+=(listaMovimientos.get(listaMovimientos.size()-i));
        return output;
    }

}
