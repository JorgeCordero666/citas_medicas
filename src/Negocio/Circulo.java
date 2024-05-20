
package Negocio;

import java.awt.Color;
import java.awt.Graphics;

public class Circulo {
    private int  x, y ;
    private double radio;

    public Circulo(int x, int y, double radio) {
        this.x = x;
        this.y = y;
        this.radio = radio;
    }
//DIBUJA UN CIRCULO ROJO PARA CUANDO LAS CITAS ESTAN RESERVADAS
    public void DibujarReserva (Graphics g, int x, int y, int radio){
        g.setColor(new Color(224,18,29)); //RGB (ROJO VERDE AZUL)
        g.fillOval(12, 7, 30, 30);
    }
    
//DIBUJA UN CIRCULO VERDE PARA CUANDO LAS CITAS ESTAN RESERVADAS
    public void DibujarLibre (Graphics g, int x, int y, int radio){
        g.setColor(Color.GREEN);
        g.fillOval(12, 7, 30, 30);
    }
}
    

    
