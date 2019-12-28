/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 50241
 */
public class Bomba extends Entidad{

    public Bomba(int Vida, int X, int Y, int Ataque, Tablero Tabla) {
        super(Vida, X, Y, Ataque, Tabla);
    }

  

    @Override
    public int Tipo() {
        return 2;
    }

    @Override
    public String Info() {
        return "Bomba: "+super.X+","+super.Y;    
    }
  
    @Override
    public void Mover() {
        //No Se Mueve
    }
    private void Explotar(){
        //Daña En Forma de cruz
        // Y Estatica X Variable
        for(int i=0;i<12;i++){
           Tabla.DañarEntidad(i, Y,super.Ataque);
        }
        // X Estatica Y Variable
        for(int j=0;j<12;j++){
            Tabla.DañarEntidad(X, j, super.Ataque);
        }
    }
    @Override
    public void Esperar() {
        try {
            Thread.sleep(800);
            Explotar();
        } catch (InterruptedException ex) {
            Logger.getLogger(Bomba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}