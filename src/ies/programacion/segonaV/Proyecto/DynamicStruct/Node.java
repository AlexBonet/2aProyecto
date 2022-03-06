package ies.programacion.segonaV.Proyecto.DynamicStruct;

import ies.programacion.segonaV.Proyecto.Pieza;

import java.io.Serializable;

public class Node implements Serializable {
    private Pieza info;
    private Node next;
    private Node prev;
    public Node(Pieza pieza){
        info=pieza;
        next=null;
    }

    public Node getNext() {
        return next;
    }

    public Pieza getInfo() {
        return info;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return info.toString();
    }
}
