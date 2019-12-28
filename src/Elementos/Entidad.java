package Elementos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 50241
 */
public abstract class Entidad extends Thread{
    protected int VidaActual,Ataque;  
    protected int X,Y;
    protected Tablero Tabla;
    public Entidad(int Vida,int X,int Y,int Ataque,Tablero Tabla){
        this.X=X;
        this.Y=Y;
        this.Ataque=Ataque;
        this.VidaActual=Vida;
        this.Tabla=Tabla;
    }
    @Override
    public void run() {
        Esperar();
    }
     protected int Margen(int Coordenada,int Random){
        switch(Random){
            case 0:
                Random=0;
                break;
            case 1:
                Random=1;
                break;
            default:
                Random=-1;
                break;
        }
        
        if(Coordenada+Random<=11 && Coordenada+Random>=0){
            Coordenada=Coordenada+Random;
        }
        return Coordenada;
    }
    public abstract void Esperar();
    public abstract int Tipo();
    public abstract String Info();
    public abstract void Mover();
    public void RecibirDaño(int Daño){
        this.VidaActual--;
    }
    public int Atacar(){
        return Ataque;
    }
    public boolean EsJugador(){
        return false;
    }
    public int VidaActual(){
        return VidaActual;
    }
}