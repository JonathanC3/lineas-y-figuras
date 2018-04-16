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
public class ThousandLines extends JPanel{

    public ThousandLines() {
        this.setPreferredSize(new Dimension(800, 600));
    } // constructor
    
    private void draw(Graphics g){
        // dibujar los ejes del plano cartesiano
        g.setColor(Color.red);    
        
        g.setColor(Color.black);
        //linearFunction(g, 0, 0, 600, 600);
        linearFunction(g, 0, 0, 600, 600);

    } // draw
    
    // funcion lineal f(x) = m x + b
    // x1 y x2 es el rango en el que se graficara la funcion
    private void linearFunction(Graphics g, double x0, double y0, double x1, double y1){        
        
        double y;
        
        //prueba
            for(int i=0; i<1000; i++){
                y1=Math.random()*590;//define borde superior
                x1=Math.random()*790;//define borde derecho
                y0=Math.random()*600;
                x0=Math.random()*600;
                
                while(x0>x1){
                  x0=Math.random()*600;  
                }//valida la entrada al for pinta lineas
                
                double m = (y0 - y1) / (x0 - x1);
                double b = y0 - (m) * x0;
                for(double x = x0; x <= x1; x= x+0.01){
                    //System.out.println("Hi");
                    y = (m * x + b);
                    g.drawLine((int)coord_x(x), (int)coord_y(y), (int)coord_x(x), (int)coord_y(y)); 
                }//pinta lineas
            }// 1000 veces
        //prueba

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
        window.setContentPane(new ThousandLines());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        window.pack();
        window.setResizable(false);
        window.setLocation(150, 100);
        window.setVisible(true);         
    }
    
} // fin clase
