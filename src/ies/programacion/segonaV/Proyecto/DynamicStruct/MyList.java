package ies.programacion.segonaV.Proyecto.DynamicStruct;

import ies.programacion.segonaV.Proyecto.ChessType;
import ies.programacion.segonaV.Proyecto.Pieza;

public class MyList implements IDeletePieceManager{

    private Node head;
    private int size;

    @Override
    public void add(Pieza pieza) {
        Node aux=new Node(pieza);
        if (head==null)
            head=aux;
        else {
            aux.setNext(head);
            head=aux;
        }
        size++;
    }

    @Override
    public Pieza getFirst() {
        if (head==null)
            return null;
        else{
            Pieza p=head.getInfo();
            head=head.getNext();
            return p;
        }
    }

    @Override
    public void remove(Pieza pieza) {
        if (head==null)
            return;
        if (head.getInfo().equals(pieza)) {
            head = head.getNext();
            size--;
        }else{
            Node aux2=head, aux1=head.getNext();
            while (aux1!=null && aux1.getInfo()!=pieza){
                aux2=aux1;
                aux1=aux1.getNext();
            }
        }
    }

    @Override
    public int count(ChessType chessType) {

        int count=0;
        Node aux=head;

        while (aux!=null){
            if (aux.getInfo().getChessType().equals(chessType))
                count++;

            aux=aux.getNext();
        }

        return count;
    }
}
