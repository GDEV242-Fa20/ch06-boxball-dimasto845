import java.awt.*;
import java.awt.geom.*;
import java.awt.Color;

/**
 * Generates the bouncing balls t bounce within
 * the given rectangle at random positions at random speed
 *
 * @author (Dmitriy Stomma)
 * @version (10/12/2020)
 */
public class BoxBall
{
    // instance variables - replace the example below with your own
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final int height;
    private final int width;
    private Canvas canvas;
    private int xSpeed;
    private int ySpeed;
    private int const_Distance = 10;

    /**
     * Constructor for objects of class BoxBall
     * 
     * @param xPos - the horizontal coordinate of ball
     * 
     * @param yPos - the vertical coordinate of ball
     * 
     * @param ballDiameter - the diameter of ball in pixels
     * 
     * @param ballColor - the color of ball
     * 
     * @param box_width - the width of the box
     * 
     * @param box_height - the height of the bpx
     * 
     * @param drawingCanvas - where ball will be drawn 
     */
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor,
    int box_width, int box_height, Canvas drawingCanvas)
    {
        if (xPos >= box_width) 
            xPosition = xPos - const_Distance;
            
        
        else
            xPosition = xPos;
            
        if (yPos >= box_height)
            yPosition = yPos - const_Distance;
            
        else 
            yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        width = box_width;
        height = box_height;
        canvas = drawingCanvas;
        xSpeed = (int) (Math.random() * 20) + 1;
        ySpeed = (int) (Math.random() * 20) + 1;
        
        
            
    }
    
    /**
     * draws this ball at its current position
     **/
     public void draw()
     {
         canvas.setForegroundColor(color);
         canvas.fillCircle(xPosition, yPosition, diameter);
        }
        
        public void erase()
        {
         canvas.eraseCircle(xPosition, yPosition, diameter);   
        }
        
        public void move()
        {
         // remove from canvas at the current position
         erase();
         
         //define the radius
         int radius = diameter / 2;
         
         //set the position with respect to the speed
         yPosition += ySpeed;
         xPosition += xSpeed;
         
         //if x position of the ball is less than 0,
         //then alther the speed and set x position of the ball
         if (xPosition - radius - const_Distance < 0){
             //bouncing the ball within the walls of the box
             xSpeed = -xSpeed;
             xPosition = radius + const_Distance;
            }
        
         //if the x position of the ball is greater than or equal to width,
         //then alter the speed and set the x position of the ball
         else if (xPosition + radius >= width)
         {
             xSpeed = -xSpeed;
             xPosition = width - radius;
         }
         //if y position of the ball is less than 0,
         //then alther the speed and set x position of the ball
         if (yPosition - radius - const_Distance < 0){
             //bouncing the ball within the walls of the box
             ySpeed = -ySpeed;
             yPosition = radius + const_Distance;
            }
        
         //if the y position of the ball is greater than or equal to width,
         //then alter the speed and set the x position of the ball
         else if (yPosition + radius >= width)
         {
             ySpeed = -ySpeed;
             yPosition = width - radius;
         }
         //draw again at new position
         draw();
         
         
        }
        
        public int getXPosition()
        {
            return xPosition;
        }
        
        /**
         * return the vertical position of this ball
         */
        public int getYPosition()
        {
            return yPosition;
        }
        
}
