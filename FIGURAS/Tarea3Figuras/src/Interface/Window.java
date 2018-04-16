package Interface;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Window extends Application{
	
    @Override
    public void start(Stage stage) {
    	
    	Pane canvas = new Pane();
    	Scene scene = new Scene(canvas, 600, 600, Color.ALICEBLUE);
    	Circle circle = new Circle(30, Color.ROSYBROWN);
        Rectangle square=new Rectangle(50, 50, Color.DARKVIOLET);
        
        circle.relocate(50, 50);
        square.relocate(540, 540);
        
        canvas.getChildren().add(circle);
        canvas.getChildren().add(square);
        
        stage.setTitle("Figuras locas");
        stage.setScene(scene);
        stage.show();
        
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20), 
                new EventHandler<ActionEvent>() {

        	double dx = 7; //valor de x 
        	double dy = 4; //valor de y
                double xd=dx;
                double yd=dy;
                @Override
                public void handle(ActionEvent t) {
                    //mover las figuras
                    circle.setLayoutX(circle.getLayoutX() + dx);//eje x del circulo 
                    circle.setLayoutY(circle.getLayoutY() + dy);//eje y del circulo
                    square.setLayoutX(square.getLayoutX() - xd);//eje x del cuadrado
                    square.setLayoutY(square.getLayoutY() - yd);//eje y del cuadrado

                    Bounds bounds = canvas.getBoundsInLocal();

                    //Si el circulo alcanza el borde izquierdo o derecho, cambia de direccion
                    if(circle.getLayoutX()<=(bounds.getMinX()+circle.getRadius()) || circle.getLayoutX()>=(bounds.getMaxX()-circle.getRadius())){

                            dx = -dx;

                    }

                    //Si el circulo alcanza el borde arriba o abajo, cambia de direccion
                    if(circle.getLayoutY()>=(bounds.getMaxY()-circle.getRadius()) || circle.getLayoutY()<=(bounds.getMinY()+circle.getRadius())){

                            dy = -dy;

                    }
                    //Si el cuadrado alcanza el borde derecho o izquierdo, rebota
                    if(square.getLayoutX()<=(bounds.getMinX()) || square.getLayoutX()>=(bounds.getMaxX()-square.getWidth())){

                            xd = -xd;

                    }

                    //El cuadrado rebota si llega alcanzar el borde arriba o abajo
                    if(square.getLayoutY()>=(bounds.getMaxY()-square.getHeight()) || square.getLayoutY()<=(bounds.getMinY())){

                            yd = -yd;

                    }
                }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);//cuenta el tiempo
        timeline.play();//empieza a correr
    }
}
