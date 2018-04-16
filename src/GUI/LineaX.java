/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author faubricioch
 */

public class LineaX extends JPanel{

    public LineaX() {
        this.setPreferredSize(new Dimension(800, 600));
    } // constructor
    
    private void draw(Graphics g){
        // dibujar los ejes del plano cartesiano
        g.setColor(Color.red);    
        
        g.setColor(Color.black);
        linearFunction(g, 0, 0, 20, 600);

    } // draw
    
    // funcion lineal f(x) = m x + b
    // x1 y x2 es el rango en el que se graficara la funcion
    private void linearFunction(Graphics g, double x0, double y0, double x1, double y1){        
        
        double y;
        
        //double punto;
        
        //calculo de pendiente y del termino b (interseccion con eje y)
        double m = (y0 - y1) / (x0 - x1);
        double b = y0 - ((y0 - y1) / (x0 - x1)) * x0;
        
        for(double x = x0; x <= x1; x += 0.001){
             y = (m * x + b);
             g.drawLine((int)coord_x(x), (int)coord_y(y), (int)coord_x(x), (int)coord_y(y)); 
        } // for

    }// linearFunction
    
    
    private double coord_x(double x)
    {
        return x;
    }
    
    private double coord_y(double y)
    {
        double real_y = (double)this.getHeight() - y;
        return real_y;
    }   
    
    
   @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // se llama al meto draw
        draw(g);

    }
    
    public static void main(String[] args) {
        JFrame window = new JFrame("Graphing Function");
        window.setContentPane(new LineaX());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        window.pack();
        window.setResizable(false);
        window.setLocation(150, 100);
        window.setVisible(true);         
    }
    
} // fin clase