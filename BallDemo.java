
import java.awt.Color;
import java.util.HashSet;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class BallDemo   
{
    private Canvas myCanvas;
    
    //variables
    int boxheight = 600;
    int boxwidth = 550;
    int canvasWidth = 700;
    int canvasHeight = 700;
    int xPos = 10;
    int yPos = 10;
   
    //define the HashSet object of type
    //BouncingBall
    HashSet<BoxBall> balls = new HashSet <BoxBall>();
    
    //add the random class variable
    private Random randomGenerator;
    
    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 575);
        
        randomGenerator = new Random();
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int numberOfBalls)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);
        
        boxBounce(numberOfBalls);

        // make them bounce
        boolean finished =  false;
        while (!finished) {
            myCanvas.wait(50);           // small delay
            // stop once ball has travelled a certain distance on x axis
            for(BoxBall boxBall : balls)
            {
                boxBall.move();
            if(boxBall.getXPosition() >= boxheight + 30 * numberOfBalls) {
                finished = true;
            }
        }
        }
    }
    
    private void boxBounce (int numberOfBalls)
    {
        myCanvas.drawRectangle(xPos, yPos, boxwidth, boxheight);
        
        for (int i = 0; i < numberOfBalls; i++)
        {
            int x = randomPosition();
            int y = randomPosition();
            
            BoxBall boxBall = new BoxBall (x, y, 16, Color.RED, boxwidth,
            boxheight, myCanvas);
            
            balls.add(boxBall);
            
            boxBall.draw();
            
            
        }
        
        
        
    }
    private int randomPosition()
    {
        int pos = (int)(boxheight);
        
        return randomGenerator.nextInt(pos);
    }
}
