/*Name: Jason Reid
Date: 03/29/18
Teacher: Mr.Rosen
This class contains the information needed to animate an overloaded method which can draw three different types of airplanes based on arguments passed. The plane can either be a basic plane, or change color or speed.
*/
import java.awt.*;
import hsa.Console;
import java.lang.*;

public class Airplane extends Thread
{
    static Console c;

    //color for the airplane glass
    Color glass = new Color (174, 209, 244);
    //Color for the air plane body
    Color airPlane = new Color (150, 30, 150);
    //local colour variable for sky
    Color skyblue = new Color (27, 64, 124);
    //setting the speed of the plane to 5; note this can be changed later.
    int speed = 10;


    public void drawAirplane ()
    {
    c.setFont(new Font("Swiss 911", Font.BOLD, 40));
	//draws the actual plane
	for (int x = 0 ; x < 520 ; x++)
	{
	    c.setColor (airPlane);
	    c.fillOval (0 + x, 300, 80, 20);
	    c.fillRect (50 + x, 280, 10, 63);
	    c.setColor (glass);
	    c.fillOval (25 + x, 305, 7, 7);
	    c.fillOval (35 + x, 305, 7, 7);
	    c.fillOval (45 + x, 305, 7, 7);
	    c.fillOval (55 + x, 305, 10, 10);
	    c.setColor (airPlane);
	    int xcor[] = {5 + x, 20 + x, 5 + x};
	    int ycor[] = {310, 310, 290};
	    c.fillPolygon (xcor, ycor, 3);
	    c.setColor (Color.red);
	    c.fillMapleLeaf (10 + x, 304, 10, 10);
	    c.setColor (Color.black);
	    c.drawLine (0 + x, 300, -40 + x, 260);
	    c.drawLine (0 + x, 300, -40 + x, 340);
	    c.fillRect (-290 + x, 260, 250, 80);
	    c.setColor (Color.red);
	    c.drawString ("JEOPARDY!", -285 + x, 300);

	    //animates the plane
	    try
	    {
		Thread.sleep (speed);
	    }
	    catch (Exception e)
	    {
	    }
	    //erases the plane
	    c.setColor (skyblue);
	    c.fillRect (0 + x, 280, 80, 65);
	    c.drawLine (0 + x, 300, -40 + x, 260);
	    c.drawLine (0 + x, 300, -40 + x, 340);
	    c.fillRect (-290 + x, 260, 250, 80);
	    c.drawString ("JEOPARDY!", -285 + x, 300);
	}
	//draws the plane one more time so it stays still
	c.setColor (airPlane);
	c.fillOval (0 + 520, 300, 80, 20);
	c.fillRect (50 + 520, 280, 10, 63);
	c.setColor (glass);
	c.fillOval (25 + 520, 305, 7, 7);
	c.fillOval (35 + 520, 305, 7, 7);
	c.fillOval (45 + 520, 305, 7, 7);
	c.fillOval (55 + 520, 305, 10, 10);
	c.setColor (airPlane);
	int xcor[] = {5 + 520, 20 + 520, 5 + 520};
	int ycor[] = {310, 310, 290};
	c.fillPolygon (xcor, ycor, 3);
	c.setColor (Color.red);
	c.fillMapleLeaf (10 + 520, 304, 10, 10);
	c.setColor (Color.black);
	c.drawLine (0 + 520, 300, -40 + 520, 260);
	c.drawLine (0 + 520, 300, -40 + 520, 340);
	c.fillRect (-290 + 520, 260, 250, 80);
	c.setColor (Color.red);
	c.drawString ("JEOPARDY!", -285 + 520, 300);
    }


    //this is a plane with one argument passed, console.
    public Airplane (Console con)
    {
	c = con;
    }





    //this method tells MyCreation which class to run
    public void run ()
    {
	drawAirplane ();
    }
} // main method



