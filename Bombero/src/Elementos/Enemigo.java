/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

/**
 *
 * @author 50241
 */
public class Enemigo extends Entidad {

    public Enemigo(int Vida, int X, int Y, int Ataque, Tablero Tabla) {
         
        super(Vida, X, Y, Ataque, Tabla);
    }

 

   

    @Override    
    public void Mover() {
       
        int EjeX = (int) (Math.random() * 3 + 0);
        int EjeY = (int) (Math.random() * 3 + 0);
        //Mover
        EjeX=Margen(X,EjeX);  
        EjeY=Margen(Y,EjeY);  
        //Casilla Vacia
        //Mover en X
        if(Tabla.CasillaVacia(EjeX, Y)){
            Tabla.MoverANuevaCasilla(X, Y, EjeX, Y);
            X=EjeX;
        }
        //Mover en Y
        if(Tabla.CasillaVacia(X, EjeY)){
            Tabla.MoverANuevaCasilla(X, Y, X, EjeY);
            Y=EjeY;
        }
        //Hay Objeto  Jugador
        else if(Tabla.EsJugador(EjeX, EjeY)){
            Tabla.DañarEntidad(EjeX, EjeY, Ataque);
        }else{
            //No Se Mueve
        }
    }

    @Override
    public int Tipo() {
        return 1;
    }

    @Override
    public String Info() {
        return "Enemigo: " + super.X + "," + super.Y;
    }

    
    @Override
    public void Esperar() {
        try {
            while(this.VidaActual>0){
                Mover();
                Thread.sleep(500);
            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

}
