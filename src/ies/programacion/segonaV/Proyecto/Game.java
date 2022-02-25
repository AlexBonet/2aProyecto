package ies.programacion.segonaV.Proyecto;

import ies.programacion.segonaV.Proyecto.DynamicStruct.IDeletePieceManager;
import ies.programacion.segonaV.Proyecto.DynamicStruct.MoveList;
import ies.programacion.segonaV.Proyecto.DynamicStruct.MyLinkedStore;
import ies.programacion.segonaV.Proyecto.PiezasB.BKing;
import ies.programacion.segonaV.Proyecto.View.Screen;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author Alex Bonet
 * TODO JAQUE
 * TODO mirar de posar opcions de guardar y cargar partida
 * TODO Que si la pesa soles te un moviment que el faxa nomes elegirla
 */

public class Game {
    private TableroChess board;
    private String blackPlayer;
    private String whitePlayer;
    private ColorPieza turno;
    private MoveList historialDeMov;

    /**
     * Constructor
     * Crea un tablero nuevo
     * Crea els marcadors de peces
     * Posa que el blanc te el primer turno
     */
    public Game() {
        this.board = new TableroChess();
        historialDeMov=new MoveList();
        turno=ColorPieza.WHITE;
    }

    public void start(){
        whitePlayer=askName(turno);
        blackPlayer=askName(turno.next());
        Screen.show(board);
        boolean salir=false;//no salir

        do {
            salir=cadaRonda();

        }while (!salir);

        System.out.println("GG");

    }

    /**
     * Pregunta por el nombre de los jugadores
     * @param turno quien tiene que poner el nombre
     * @return el nombre
     */
    public String askName(ColorPieza turno){
        Scanner sc=new Scanner(System.in);
        System.out.print("Escriba el nombre para el jugador de las piezas " + turno + " :");
        String name=sc.next();
        return name;
    }

    /**
     * Elige la coordenada de la pieza que quiere mover
     */
    public void eligeCoordena(ColorPieza turno){
        Coordenada c;   //Coordenada a la que nos vamos a mover
        char y;         //Letra de la coordenada
        int x;          //Numero de la coordenada
        boolean vacia=false;  //
        List<Coordenada> nextMove=new LinkedList<>(); // Posibles siguientes movientos de la pieza
        do {
            System.out.println(getTurno() + ". Seleccione una coordenada: ");   //Mensage de texto
            tableros(); //metodo que muestra el tablero

            y=eligeLetraY();    //Elegir la letra de la coordenada
            x=eligeNumX();      //Elegir el numero de la coordenada
            c=new Coordenada(y,x);  //Inicializa la coordenada con los valores pasados anteriormente

            if (board.getCellAt(c).getPieza() == null) {  //Comprueba que no este vacia la celda
                System.out.println(mError() + "Esta celda está vacia, elija otra.");
                vacia= true;
            }

            else if (turno==ColorPieza.WHITE && board.getCellAt(c).getPieza().getColor()==ColorPieza.WHITE){    //comprobar de quien es el turno

                nextMove.addAll(board.getCellAt(c).getPieza().getNextMove());       //añade a la lista los movimientos

                if (nextMove.size()>0){         //si la se puede mover, enseña el tablero con las celdas coloreadas
                    board.hightLightSelect(c);
                    vacia=false;
//                        tableros();
                }else{
                    if (board.getCellAt(c).getPieza() != null) //si hay una pieza que no puede moverse
                        System.out.println(mError()+"Esta pieza no puede moverse, eliga otra.");
                }

            }else if (turno==ColorPieza.BLACK && board.getCellAt(c).getPieza().getColor()==ColorPieza.BLACK){

                nextMove.addAll(board.getCellAt(c).getPieza().getNextMove());

                if (nextMove.size()>0){
                    board.hightLightSelect(c);
                    vacia=false;
//                        tableros();
                }else{
                    if (board.getCellAt(c).getPieza() != null)
                        System.out.println(mError()+"Esta pieza no puede moverse, eliga otra.");
                }

            }else
                System.out.println(mError()+"No puedes mover las piezas del ribal");

        }while (nextMove.size()==0 || vacia);
        eligeNextMove(c,nextMove);

    }

    /**
     * Elige a que coordenada va a mover la pieza
     * @param c coordenada en la que esta tu celda
     * @param nextMove
     */
    public void eligeNextMove(Coordenada c, List<Coordenada> nextMove) {
        System.out.println("Elija donde desea mover su pieza de " + c  );
        board.hightLight(board.getCellAt(c).getPieza().getNextMove());  //Muestra de otro color las celdas a las que podemos movernos
        tableros();
        char y;                                     //Iniciamos variables
        int x;                                      //Iniciamos variables
        Coordenada newC;                            //Iniciamos variables
        Pieza pieza=board.getCellAt(c).getPieza();  //Cojemos la pieza
        do {                                    //Repite hasta *
            y=eligeLetraY();
            x=eligeNumX();
            newC=new Coordenada(y,x);               //Iniciamos la variable de cordenada
            if (comparaCoor(newC,nextMove)) {       //Si la cordenada a la que quiere mover es valida:
//                System.out.println("OK");           //Mensaje de correcto
                historialDeMov.add(new Movimiento(pieza.getChessType(),c,newC));    //añade un movimiento al historial

                if (board.getCellAt(newC).getPieza()!=null)
                    updateStore(newC);



                pieza.moveTo(newC);                 //La pieza se mueve
            }else{
                System.out.println(mError()+"La celda elegida no está permitida pruebe con estas:");     //Mensaje de error
                System.out.print(nextMove);         //Muestra posibles coordenadas donde moverse
                System.out.println();
                System.out.println("----------------------------------------------------");
            }
        }while (!comparaCoor(newC,nextMove));    //* que pueda moverse
        board.resetColorBoard();
        tableros();
        turno=turno.next();
    }

    /**
     * TODO, esta es molt bona
     * combinar el que no hi hasca rey en el de caada ronda que diga si vols ixir
     *          y puc dirli algo del jaque mate
     *  agafar diferents opcions de final y tornar una
     *
     *  Si es false no se acaba
     */
    public boolean finDelJuego() {
        System.out.println("FIN DEL JUEGO");
        System.out.println("GANADOR: ");
        System.out.println("GG");
        return false;
    }

    /**
     * Electores
     */
    public char eligeLetraY(){
        Scanner sc=new Scanner(System.in);
        char y;
        do {
            System.out.println(" - Selecciona una la coordena horizontal [A-H]");
            y=sc.next().toUpperCase(Locale.ROOT).trim().charAt(0);
            if (y<'A' ||  y>'H'){ //y!='A' || y!='B' || y!='C' || y!='D' || y!='E' || y!='F' || y!='G' || y!='H'
                System.out.println(mError()+"Parametro no valido, vuelva a intentarlo");
                System.out.println("Parametros permitidos: 'A','B','C','D','E','F','G','H'");
            }
        }while(y<'A' ||  y>'H');

        return y;
    }
    public int eligeNumX(){
        Scanner sc=new Scanner(System.in);
        char x;
        do {
            System.out.println(" - Selecciona una la coordena vertical [1-8]");
            x=sc.next().trim().charAt(0);
            if (x<'1' ||  x>'8'){
                System.out.println(mError()+"Parametro no valido, vuelva a intentarlo");
                System.out.println("Parametros permitidos: '1','2','3','4','5','6','7','8'");
            }
        }while(x<'1' ||  x>'8');
        int xx= x;
        return xx-48;
    }

    public String getTurno(){
        String str="";
        if (turno==ColorPieza.WHITE)
            str+="Jugador '" + whitePlayer + "' de las piezas blancas";
        else
            str+="Jugador '" + blackPlayer + "' de las piezas negras";
        return str;
    }
    public String mError(){
        return "MENSAJE DE ERROR: ";
    }
    public boolean comparaCoor(Coordenada c, List<Coordenada> nextMove) {
        boolean toReturn=false;
        for (int i=0;i<nextMove.size();i++){
            if (c.equals(nextMove.get(i)))
                toReturn= true;
        }
        return toReturn;
    }

    /**
     * TODO: millorar el codigo e implemetar lo de guardar partida
     * @return
     */
    public boolean seguirJugando(){
        Scanner sc=new Scanner(System.in);
        char option1;
        char option2;
        boolean salir=false;//no salir

        do {
            System.out.println(getTurno() + ", quiere seguir jugando? [1=Si | 2=No]");
            option1= sc.nextLine().charAt(0);

            if (option1!='1' && option1!='2') {
                System.out.println(mError()+"Parametro no valido, vuelva a intentarlo");
                System.out.println("Parametros permitidos: '1'='Si', '2'='No'");
            }

        }while (option1!='1' && option1!='2');

        if (option1=='1')
            salir= false;//no salir

        else{
            do {
                System.out.println("¿Quiere dejar de jugar?");
                System.out.println(" - 1.- Salir sin guardar");
                System.out.println(" - 2.- Salir y guardar");
                System.out.println(" - 3.- Cancelar");
                System.out.print("Selecciona una de esta opciones [Pulse 1, 2 o 3]: ");

                option2= sc.nextLine().charAt(0);

                if (option2<'1' || option2>'3'){
                    System.out.println(mError()+"Parametro no valido, vuelva a intentarlo");
                    System.out.println("Parametros permitidos: 1 , 2 , 3");

                }else if (option2=='1'){
                    salir= true;//Si salir

                }else if (option2=='2'){
                    //guardar
                    System.out.println("Guardando...");

                    salir= true;//Si salir

                }else {
                    salir= false;
                }



            }while (option2<'1' && option2>'3');
        }

        return salir;
    }

    /**
     * TODO: millorar el codigo e implemetar lo de cargar partida
     */
    public void antesDEmpezar(){
        Scanner sc=new Scanner(System.in);
        char option;

        System.out.println("BIENVENIDO");
        System.out.println();
        System.out.println();

        do {
            System.out.println("¿¿Quieres iniciar una partida nueva o cargar una partida guardada??");
            System.out.println(" - 1.- Iniciar partida NUEVA");
            System.out.println(" - 2.- Cargar partida");
            System.out.println(" - 3.- Jugar en linea");
            System.out.print("Selecciona una de esta opciones [Pulse 1, 2 o 3]");

            option= sc.nextLine().charAt(0);

            if (option<'1' || option>'3') {
                System.out.println(mError() + "Parametro no valido, vuelva a intentarlo");
                System.out.println("Parametros permitidos: 1 , 2 o , 3'");
            }else if (option=='1'){
                start();

            }else if (option=='2'){
                System.out.println("Cargando...");

                //cargar partida


            }else {
                System.out.println(mError() + "Esta opcion aún no esta disponible, seleccione otra de las opciones");
            }

        }while (option<'1' || option>'3');
    }

    /**
     * Cada ronda se pregunta que hacer
     * @return si seguimos jugando
     */
    public boolean cadaRonda(){
        Scanner sc=new Scanner(System.in);
        char option;
        boolean salir=false;

        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println();

        if (board.estaEnJaque(ColorPieza.WHITE)){
            System.out.println("¡¡JAQUE!!");
            System.out.println("El rey blanco está en apuros");
        }else if (board.estaEnJaque(ColorPieza.BLACK)){
            System.out.println("¡¡JAQUE!!");
            System.out.println("El rey negro está en apuros");
        }

        if (hayReyes()){
            do {
                System.out.println(getTurno() + " que desea hacer??");
                System.out.println(" - 1.- Mover una ficha");
                System.out.println(" - 2.- Ver ultimos 5 movimientos");
                System.out.println(" - 3.- Ver movimientos realizados");
                System.out.println(" - 4.- Salir");
                System.out.print("Selecciona una de esta opciones [Pulse 1, 2, 3 o 4]: ");

                option= sc.next().charAt(0);

                if (option<'1' || option>'5') {
                    System.out.println(mError() + "Parametro no valido, vuelva a intentarlo");
                    System.out.println("Parametros permitidos: 1 , 2 , 3 , 4");
                }else if (option=='1'){
                    eligeCoordena(turno);

                }else if (option=='2'){
                    System.out.println(historialDeMov.showLast5());

                }else if (option=='3'){
                    getHistorial();

                }else if (option=='4'){
                    salir=seguirJugando();

                }else if (option=='5') { //esto es porque suelo darle mucho al 5 para verlo
                    System.out.println(historialDeMov.showLast5());

                }else {
                    System.out.println(mError() + "Esta opcion aún no esta disponible, seleccione otra de las opciones");
                }

                if (!hayReyes())
                    salir=true;

            }while (option<'1' || option>'5' || !salir);
        }

        return salir;
    }

    /**
     * Muestra el tablero y los contadores
     */
    public void tableros(){
        System.out.println();
        if (turno==ColorPieza.WHITE)
            Screen.show(board);
        else
            Screen.showBlackP(board);
        Screen.showPieceOnBoard(board);
        System.out.println();
        Screen.showDeletedPiece(board.getStore4Deleted());
        System.out.println();

        System.out.println("blanc   " + board.estaEnJaque(ColorPieza.WHITE));
        System.out.println("negre   " + board.estaEnJaque(ColorPieza.BLACK));

        System.out.println();

    }

    /**
     * TODO
     * * @return
     */
    public boolean hayReyes(){
        boolean hayRey = false; //asi no hi hauria rey

        if (board.getBlackPiezas().get(7).getChessType().toString().equals(ChessType.B_king.toString()) &&
                board.getWhitePiezas().get(10).getChessType().toString().equals(ChessType.W_king.toString()))
            hayRey=true;    //esto es que hi ha reis

        return hayRey;
    }

    /**
     * Seleccionar y mostrar historial
     */
    public void getHistorial(){
        Scanner sc=new Scanner(System.in);
        char option;

        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println();

        do {
            System.out.println("¿¿Cuantos movimientos desea ver??");
            System.out.println(" - 1.- Ver todos los movimientos");
            System.out.println(" - 2.- Ver el ultimo movimiento");
            System.out.println(" - 3.- Ver los ultimos 5 movimientos");
            System.out.println(" - 4.- Ver los ultimos movimientos que indique");
            System.out.println(" - 5.- Salir");
            System.out.print("Selecciona una de esta opciones [Pulse 1, 2, 3, 4 o 5]: ");

            option= sc.nextLine().charAt(0);

            if (option<'1' || option>'4') {
                System.out.println(mError() + "Parametro no valido, vuelva a intentarlo");
                System.out.println("Parametros permitidos: 1 , 2 , 3 , 4 , 5");
            }else if (option=='1'){
                System.out.println(historialDeMov.showAllMov());
            }else if (option=='2'){
                System.out.println(historialDeMov.showLastOne());

            }else if (option=='3'){
                System.out.println(historialDeMov.showLast5());

            }else if (option=='4'){
                int x;
                do {
                    System.out.println("¿¿Especifica cuantos movimientos quieres ver??");
                    x=sc.nextInt();
                    if (x<0)
                        System.out.println("El numero tiene que ser mayor de 0");
                }while (x<0);
                System.out.println(historialDeMov.showX(x));

            }else if (option=='5'){
                cadaRonda();

            }else {
                System.out.println(mError() + "Esta opcion aún no esta disponible, seleccione otra de las opciones");
            }

        }while (option<'1' || option>'5');
    }

    public void updateStore(Coordenada c){
        board.getStore4Deleted().add(board.getCellAt(c).getPieza());
        board.getStore4InBoard().remove(board.getCellAt(c).getPieza());
    }

    public TableroChess getBoard() {
        return board;
    }

    public String getBlackPlayer() {
        return blackPlayer;
    }

    public String getWhitePlayer() {
        return whitePlayer;
    }

    public MoveList getHistorialDeMov() {
        return historialDeMov;
    }

    public boolean guardarPartida(){
        try( ObjectOutputStream oos = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream("gameSave")))){

            Game g = new Game();
            oos.writeObject(g);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try( ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream("gameSave")))){

            Game g = (Game) ois.readObject();
            System.out.println(g);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }
}
