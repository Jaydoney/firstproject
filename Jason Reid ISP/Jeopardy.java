/*
    FINAL VERSION
    Jason Reid
    June 5th, 2018
    Mr. Rosen
    This program  allows two users to play a turn-based game of Jeopardy.
    It feautures two levels, then a final Jeopardy question where users can wager all their money on the final question.

    The splashScreen() method displays a graphic of two contestants receiving money falling from the sky, then a lightning strike followed by the program name and studio name faded in.
    The mainMenu () method prompts the user to either play the game, learn how to play the game, view highscores or quit the program
    The instructions() method educates the user on how to play Jeopardy and the rules of Jeopardy.
    The highScores() method displays the top ten highscores stored in a file named "highscores.txt".
    The goodBye() method informs the user that the program is over.
    The askData() method reads and stores the two usernames and location.
    The level1() method allows the users to play the first level of Jeopardy.
    The level2() method allows the users to play the second level of Jeopardy.
    The finalJeopardy() method allows the users to play the final level of Jeopardy.
    The congrats () method declares a win, congratulates the winning user and if the score is in the top ten, outputs it to the file "highscores.txt".

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    VARIABLE DICTIONARY


    NAME        VARIABLE        DESCRIPTION
		TYPES
    ---------------------------------------------------------------------------------------------
    user1       String          This variable stores user1's username
    location1   String          This variable stores user1's location
    score1      int             This variable stores user1's score
    wager1      int             This variable stores user1's wager
    answer      String          This variable stores the answer for both users in level 1 and 2, but only user1 in final Jeopardy

    user2       String          This variable stores user2's username
    location2   String          This variable stores user2's location
    score2      int             This variable stores user2's score
    wager2      int             This variable stores user2's wager
    answer2     String          This variable stores user2's answer in final Jeopardy

    user1turn   boolean         This variable stores who's turn it is. If true, it's user1's turn. If false, it's user 2's turn.

    choice      char            This variable stores the character correlated with the user's menu selection
    fileName    String          This variable stores the name of the input/output file
    in          Object          This variable stores the class of BufferedReader for use

    round       int             This variable stores what round it is.
    ROW         int             This variable stores the amount of rows in questions and answers
    COLUMN      int             This variable stores the amount of columns in questions and answers
    colNum      int             This variable stores the column number that the user chose(msinly used for deleting boxes)
    colChoice   int             This variable stores the column choice.
    rowChoice   int             This variable stores the row choice.

    col1        int             These variable stores the category number of its respective column designation
    col2        int
    col3        int
    col4        int
    col5        int
    col6        int
    col7        int
    col8        int
    col9        int
    col10       int

    dailyDoubleRow1     int     This variable stores the row of the level 1 Daily Double question.
    dailyDoubleCol1     int     This variable stores the column of the level 1 Daily Double question.
    dailyDoubleRow2     int     This variable stores the row of the first level 2 Daily Double question.
    dailyDoubleCol2     int     This variable stores the column of the first level 2 Daily Double question.
    dailyDoubleRow3     int     This variable stores the row of the second level 2 Daily Double question.
    dailyDoubleCol3     int     This variable stores the column of the second level 2 Daily Double question.


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


*/
import java.awt.*;
import java.io.*;
import hsa.Console;
import hsa.Message;

public class Jeopardy
{
    static Console c;

    //variables for questions and answers
    static final int ROW = 6;
    static final int COLUMN = 31;

    String[] [] questions = new String [ROW] [COLUMN];
    String[] [] answers = new String [ROW] [COLUMN];

    //global variables for user1
    static String user1;
    static String location1;
    static int score1 = 0;
    int wager1;
    static String answer;

    //global variables for user 2
    static String user2;
    static String location2;
    static int score2 = 0;
    int wager2;
    String answer2;

    static char choice;

    //file io variables
    String fileName = "highscores.txt";
    BufferedReader in;
    PrintWriter out;

    boolean user1turn = true;
    int round = 0;
    int count = 0;

    int colChoice;
    int rowChoice;
    int colNum;


    //column variables
    static int[] columnNumbers = new int [10];
    int col1 = randomNum (0, 2);
    int col2 = randomNum (3, 4);
    int col3 = randomNum (5, 6);
    int col4 = randomNum (7, 8);
    int col5 = randomNum (9, 10);
    int col6 = randomNum (11, 12);
    int col7 = randomNum (13, 14);
    int col8 = randomNum (15, 16);
    int col9 = randomNum (17, 18);
    int col10 = randomNum (19, 20);

    int dailyDoubleRow1;
    int dailyDoubleCol1;
    int dailyDoubleRow2;
    int dailyDoubleCol2;
    int dailyDoubleRow3;
    int dailyDoubleCol3;




    //global color variables
    Color purple = new Color (84, 31, 109);
    Color gold = new Color (193, 191, 63);
    Color cobalt = new Color (13, 36, 130);
    Color paper = new Color (234, 236, 242);
    Color silver = new Color (196, 199, 206);
    Color green = new Color (40, 196, 23);

    //PROCEDURAL METHODS

    /*
    This method displays a splashscreen to the user before they use the program.
    ---------------------------------------------------------------------------------------------------------------
    Local Variables:
    Global Variables Used: Color green, Color skyblue, Color yellow
    ---------------------------------------------------------------------------------------------------------------
    */
    public void splashScreen ()
    {
	//local colour variable for sky
	Color skyblue = new Color (27, 64, 124);
	//local colour variable for lightning
	Color yellow = new Color (243, 255, 26);

	//draws the sky blue
	c.setColor (skyblue);
	c.fillRect (0, 0, 1000, 550);

	//draws the ground green
	c.setColor (green);
	c.fillRect (0, 550, 1000, 300);


	//this nested for-loop draws the clouds
	// the i variable controls how many bubbles are in one part of a cloud
	//the j variable controls how many cloud parts they are to a cloud(around 5-6)
	//the k variable controls how many clouds there are in the sky(around 3.2)
	for (int k = 0 ; k <= 800 ; k += 250)
	{
	    c.setColor (new Color (150, 150, 150));
	    for (int j = 0 ; j <= 200 ; j += 35)
	    {

		for (int i = 0 ; i < 30 ; i++)
		{
		    c.drawOval (((5 + k) + j) + i, 35 + i, 44 - 2 * i, 44 - 2 * i);
		    c.drawOval (((45 + k) + j) + i, 35 + i, 44 - 2 * i, 44 - 2 * i);
		    c.drawOval (((-15 + k) + j) + i, 20 + i, 44 - 2 * i, 44 - 2 * i);
		    c.drawOval (((25 + k) + j) + i, 20 + i, 44 - 2 * i, 44 - 2 * i);
		    c.drawOval (((65 + k) + j) + i, 20 + i, 44 - 2 * i, 44 - 2 * i);
		    c.drawOval (((05 + k) + j) + i, 5 + i, 44 - 2 * i, 44 - 2 * i);
		    c.drawOval (((50 + k) + j) + i, 5 + i, 44 - 2 * i, 44 - 2 * i);
		    c.drawOval (((25 + k) + j) + i, -10 + i, 44 - 2 * i, 44 - 2 * i);
		    c.drawOval (((25 + k) + j) + i, 45 + i, 44 - 2 * i, 44 - 2 * i);


		}
	    }
	}



	//draws the legs and arms for the human figures
	c.setColor (Color.black);
	for (int x = 0 ; x < 13 ; x++)
	{
	    c.drawLine (120 + x, 600, 120 + x, 675); //left leg
	    c.drawLine (145 + x, 600, 145 + x, 675); //right leg
	    c.drawLine (120 + x, 550, 60 + x, 470);  //left arm
	    c.drawLine (145 + x, 550, 205 + x, 470); //right arm

	    c.drawLine (720 + x, 550, 720 + x, 635); //left leg
	    c.drawLine (745 + x, 550, 745 + x, 635); //right leg
	    c.drawLine (720 + x, 525, 660 + x, 455); //left arm
	    c.drawLine (745 + x, 475, 785 + x, 605); // right arm
	}


	//black guy
	//sets the shirt color and shirt location
	c.setColor (Color.red);
	c.fillOval (100, 500, 80, 150);
	//sets the skin tone and body location
	c.setColor (new Color (132, 86, 21));
	c.fillOval (110, 470, 60, 60);

	//white guy
	//sets the shirt color and shirt location
	c.setColor (Color.blue);
	c.fillOval (700, 470, 80, 130);
	//sets the skin tone and body location
	c.setColor (new Color (234, 220, 199));
	c.fillOval (710, 440, 60, 60);

	//for loop that animates the money movement
	for (int z = 0 ; z < 300 ; z++)
	{
	    //draws dollar bills
	    getMoney (100, 100 + z);
	    getMoney (200, 200 + z);
	    getMoney (645, 130 + z);
	    getMoney (433, 155 + z);
	    getMoney (532, 182 + z);
	    getMoney (342, 187 + z);
	    getMoney (262, 144 + z);
	    getMoney (898, 112 + z);
	    getMoney (948, 147 + z);
	    getMoney (612, 174 + z);
	    getMoney (970, 149 + z);
	    getMoney (42, 199 + z);
	    getMoney (834, 132 + z);
	    getMoney (312, 99 + z);


	    //animates the dollar bills
	    try
	    {
		Thread.sleep (1 / 10000);
	    }
	    catch (Exception e)
	    {
	    }
	    //erases the dollar bills
	    c.setColor (skyblue);
	    c.fillRect (100, 100 + z, 25, 50);
	    c.fillRect (200, 200 + z, 25, 50);
	    c.fillRect (645, 130 + z, 25, 50);
	    c.fillRect (433, 155 + z, 25, 50);
	    c.fillRect (532, 182 + z, 25, 50);
	    c.fillRect (342, 187 + z, 25, 50);
	    c.fillRect (262, 144 + z, 25, 50);
	    c.fillRect (898, 112 + z, 25, 50);
	    c.fillRect (948, 147 + z, 25, 50);
	    c.fillRect (612, 174 + z, 25, 50);
	    c.fillRect (970, 149 + z, 25, 50);
	    c.fillRect (42, 199 + z, 25, 50);
	    c.fillRect (834, 132 + z, 25, 50);
	    c.fillRect (312, 99 + z, 25, 50);
	}

	airplane ();
	//array of local int varibles of x coordinates to make lightning
	int lightningAx[] = {700, 750, 690, 660};
	//array of local int varibles of y coordinates to make lightning
	int lightningAy[] = {150, 90, 90, 150};
	//array of local int varibles of x coordinates to make lightning
	int lightningBx[] = {770, 700, 660, 740};
	//array of local int varibles of y coordinates to make lightning
	int lightningBy[] = {200, 150, 150, 200};
	//array of local int varibles of x coordinates to make lightning
	int lightningCx[] = {590, 770, 740, 590};
	//array of local int varibles of y coordinates to make lightning
	int lightningCy[] = {300, 200, 200, 300};

	//loop used to animate the lightning
	for (int x = 0 ; x < 40 ; x++)
	{
	    //draws the lightning
	    c.setColor (yellow);
	    c.fillPolygon (lightningAx, lightningAy, 4);
	    c.fillPolygon (lightningBx, lightningBy, 4);
	    c.fillPolygon (lightningCx, lightningCy, 4);

	    //used to create a flashing effect
	    try
	    {
		Thread.sleep (2 * x);
	    }
	    catch (Exception e)
	    {
	    }
	    //erases the lightning
	    c.setColor (skyblue);
	    c.fillPolygon (lightningAx, lightningAy, 4);
	    c.fillPolygon (lightningBx, lightningBy, 4);
	    c.fillPolygon (lightningCx, lightningCy, 4);
	    c.setColor (new Color (150, 150, 150));
	    c.fillOval (705, 60, 35, 35);
	    c.fillOval (670, 60, 35, 35);
	    try
	    {
		Thread.sleep (2 * x);
	    }
	    catch (Exception e)
	    {
	    }
	}


	//draws the lightning one final time
	c.setColor (yellow);
	c.fillPolygon (lightningAx, lightningAy, 4);
	c.fillPolygon (lightningBx, lightningBy, 4);
	c.fillPolygon (lightningCx, lightningCy, 4);

	//used to delay the drawing of the ligtning
	try
	{
	    Thread.sleep (500);
	}


	catch (Exception e)
	{
	}


	//sets the entire screen black
	c.setColor (Color.black);
	c.fillRect (0, 0, 1000, 700);

	//a for loop that creates a fading effect with the title of my project and name
	for (int i = 0 ; i < 256 ; i++)
	{
	    c.setColor (new Color (0 + i, 0 + i, 0 + i));
	    c.setFont (new Font ("Anonymous", Font.BOLD, 100));
	    c.drawString ("Jeopardy!", 275, 325);
	    c.setFont (new Font ("Anonymous", Font.BOLD, 30));
	    c.drawString ("Jason Reid Studios", 400, 400);
	    //slightly fades every ten milliseconds
	    try
	    {
		Thread.sleep (10);
	    }
	    catch (Exception e)
	    {
	    }
	}


	pauseProgram ();
    }


    /*
    This method displays a mainMenu to the user where they can select where in the program they'd like to go.
    They can play the game, read instructions, see highscores or exit.
    ---------------------------------------------------------------------------------------------------------------
    Local Variables: Char input
    Global Variables Used: Color purple, choice input
    ---------------------------------------------------------------------------------------------------------------
    */
    public void mainMenu ()
    {
	//Declaration of a local variable
	char input;

	//graphically draws the main menu title and sets the font
	title ();
	c.setColor (Color.white);
	c.setFont (new Font ("Swiss 911", 1, 70));
	c.drawString ("Main Menu", 335, 275);

	//sets the choice to 1 so the first box is automatically highlighted
	choice = 1;
	while (true)
	{

	    //draws the purple base box
	    c.setColor (purple);
	    c.fillRect (0, 325, 1068, 968);

	    //draws the menu option boxes
	    for (int i = 0 ; i < 250 ; i++)
	    {
		c.setColor (new Color (0 + i, 30, 0 + i));
		c.fill3DRect (100 + i, 350, 250 - i, 120, true);
		c.fill3DRect (100 + i, 550, 250 - i, 120, true);
		c.fill3DRect (650 + i, 350, 250 - i, 120, true);
		c.fill3DRect (650 + i, 550, 250 - i, 120, true);
	    }

	    //draws the strings inside the menu boxes as well as a promt for the user near the title
	    c.setColor (Color.white);
	    c.setFont (new Font ("Swiss 911", 1, 32));
	    c.drawString ("1. Play Game", 110, 425);
	    c.drawString ("3. HighScores", 110, 625);
	    c.drawString ("2. Instructions", 660, 425);
	    c.drawString ("4. Exit Game", 660, 625);
	    c.drawString ("Hit SPACE For Enter", 150, 175);

	    //once the computer accepts input from the user
	    //the program checks if it's one of the 4 options
	    //if choice is equal to either 1,2,3 or 4, it will highlight the corresponding box and promt the user to hit space which selects the option.
	    //if the choice is not any of those options, an error message will popup.
	    if (choice == '1')
	    {
		for (int i = 0 ; i < 5 ; i++)
		{
		    c.setColor (Color.yellow);
		    c.drawRect (95 + i, 345 + i, 250, 125);

		}
	    }
	    else if (choice == '2')
	    {
		for (int i = 0 ; i < 5 ; i++)
		{
		    c.setColor (Color.yellow);
		    c.drawRect (645 + i, 345 + i, 250, 125);
		}
	    }
	    else if (choice == '3')
	    {
		for (int i = 0 ; i < 5 ; i++)
		{
		    c.setColor (Color.yellow);
		    c.drawRect (95 + i, 545 + i, 250, 125);
		}
	    }
	    else if (choice == '4')
	    {
		for (int i = 0 ; i < 5 ; i++)
		{
		    c.setColor (Color.yellow);
		    c.drawRect (645 + i, 545 + i, 250, 125);
		}
	    }

	    choice = c.getChar ();

	    c.setColor (purple);
	    c.fillRect (0, 325, 1068, 968);

	    for (int i = 0 ; i < 250 ; i++)
	    {
		c.setColor (new Color (0 + i, 0, 0 + i));
		c.fill3DRect (100 + i, 350, 250 - i, 120, true);
		c.fill3DRect (100 + i, 550, 250 - i, 120, true);
		c.fill3DRect (650 + i, 350, 250 - i, 120, true);
		c.fill3DRect (650 + i, 550, 250 - i, 120, true);
	    }
	    c.setColor (Color.white);
	    c.setFont (new Font ("Swiss 911", 1, 32));
	    c.drawString ("1. Play Game", 110, 425);
	    c.drawString ("3. HighScores", 110, 625);
	    c.drawString ("2. Instructions", 660, 425);
	    c.drawString ("4. Exit Game", 660, 625);
	    c.drawString ("Hit SPACE For Enter", 150, 175);

	    //I put this segment of code in a while loop so it would automatically draw over the highlights

	    if (choice == '1')
	    {
		for (int i = 0 ; i < 5 ; i++)
		{
		    c.setColor (Color.yellow);
		    c.drawRect (95 + i, 345 + i, 250, 125);

		}
		input = c.getChar ();
		if (input == ' ')
		    return;
		else
		    choice = input;
	    }
	    else if (choice == '2')
	    {
		for (int i = 0 ; i < 5 ; i++)
		{
		    c.setColor (Color.yellow);
		    c.drawRect (645 + i, 345 + i, 250, 125);
		}
		input = c.getChar ();
		if (input == ' ')
		    return;
		else
		    choice = input;

	    }
	    else if (choice == '3')
	    {
		for (int i = 0 ; i < 5 ; i++)
		{

		    c.setColor (Color.yellow);
		    c.drawRect (95 + i, 545 + i, 250, 125);
		}
		input = c.getChar ();
		if (input == ' ')
		    return;
		else
		    choice = input;
	    }
	    else if (choice == '4')
	    {
		for (int i = 0 ; i < 5 ; i++)
		{
		    c.setColor (Color.yellow);
		    c.drawRect (645 + i, 545 + i, 250, 125);
		}
		input = c.getChar ();
		if (input == ' ')
		    return;
		else
		    choice = input;

	    }
	    else
	    {
		new Message ("Please input a menu number shown here.");
		choice = 1;
	    }

	}
    }


    /*
    This method displays instructions and rules to the user so they can play the program properly.

    ---------------------------------------------------------------------------------------------------------------
    Local Variables:
    Global Variables Used:
    ---------------------------------------------------------------------------------------------------------------
    */

    public void instructions ()
    {
	//draws the background and title
	title ();
	c.setColor (Color.white);
	c.setFont (new Font ("Swiss 911", 1, 60));
	c.drawString ("Instructions", 340, 250);

	//sets the font for the writinh
	c.setFont (new Font ("Swiss 911", 1, 25));

	//these next methods display to the user how to play the game
	c.drawString ("Welcome to Jeopardy!: Jason Reid Style", 280, 300);
	c.drawString ("This is a game show where if contestants answer right, they win money.", 80, 330);
	c.drawString ("If contestants answer incorrectly, they lose money.", 190, 360);
	c.drawString ("This game has three levels: ", 330, 390);
	c.drawString ("Level 1(5 questions per 5 categories)", 290, 420);
	c.drawString ("Level 2(5 questions per 5 categories)", 290, 450);
	c.drawString ("Final Jeopardy where both contestants can wager all", 190, 480);
	c.drawString ("their money on a do-or-die question.", 300, 510);
	c.drawString ("When a contestant answers a question correctly, ", 180, 540);
	c.drawString ("they have the ability to choose the next question.", 185, 570);
	c.drawString ("If they get it wrong, the next contestant can either answer or pass.", 85, 600);
	c.drawString ("The contestant with the most money at the end of the game wins!", 100, 630);

	//pauses the program
	pauseProgram ();

    }


    /*
    This method stores reads a file that stores high scores, uses a blackbox method to sort the file by highest to lowest
    and then displays it to the user. It then gives the user the choice to clear the file.
    ---------------------------------------------------------------------------------------------------------------
    Local Variables: String fileName
    Global Variables Used: String nullchecker
    ---------------------------------------------------------------------------------------------------------------
    */

    public void highscores () throws IOException
    {
	//this int array stores the first 10 integer scores in the file
	int[] highscores = new int [10];
	//this String array stores the first 10 string name/locations in the files
	String[] name = new String [10];

	//this local variable is used to store any output from the file
	//it is a string so it can hold both string and integer input
	//it can then either be converted to an integer using parsing or remain as a string
	//must be a string as integer variables cannot hold the value null as it is an object
	String nullchecker;

	//draws the title + background
	title ();
	c.setColor (Color.white);
	c.setFont (new Font ("Swiss 911", 1, 60));
	c.drawString ("High Scores", 340, 200);
	c.setFont (new Font ("Swiss 911", 1, 27));


	// reads the highscores file
	try
	{
	    //declares in as reading the highscores file
	    in = new BufferedReader (new FileReader (fileName));
	    for (int x = 1 ; x <= 10 ; x++)
	    {
		//this line is just for the space separating high score entries
		in.readLine ();

		nullchecker = in.readLine ();
		//first checks to see if the score line is null or already has been declared as 'Empty' or 0.
		//if the score line does not have a relevant value, the score imported to the array is 0
		if (nullchecker == null || nullchecker.equals ("Empty") || Integer.parseInt (nullchecker) == 0)
		    highscores [x - 1] = 0;
		//if the score line has relevant value, the score imported to the array is the value
		else
		    highscores [x - 1] = Integer.parseInt (nullchecker);

		nullchecker = in.readLine ();
		//first checks to see if the name line is null or already has been declared as 'Empty' or 0.
		//if the name line does not have a relevant value, the name imported to the array is 'Empty'
		if (nullchecker == null || nullchecker.equals ("Empty"))
		    name [x - 1] = "Empty";
		//if the name line has relevant value, the name imported to the array is the value
		else
		    name [x - 1] = nullchecker;

	    }
	    //closes inputstream
	    in.close ();

	}
	catch (IOException e)
	{
	    //error message
	    new Message ("Sorry, that didn't work");
	}

	//blackbox method used to sort highscores
	sort (highscores, name);

	try
	{
	    //once highscores are sorted it writes the high scores back to the file
	    out = new PrintWriter (new FileWriter (fileName));
	    for (int x = 1 ; x <= 10 ; x++)
	    {
		// buffer line
		out.println ();
		//score line
		out.println (highscores [x - 1]);
		//name line
		out.println (name [x - 1]);
	    }
	    //closes output stream
	    out.close ();

	}
	catch (IOException e)
	{
	    //error message
	    new Message ("Sorry, that didn't work");
	}

	try
	{
	    //reads the file again
	    in = new BufferedReader (new FileReader (fileName));

	    //outputs the highscores to the screen for the user for a loop of 5 times
	    for (int i = 240 ; i <= 640 ; i += 100)
	    {
		//buffer line
		in.readLine ();

		nullchecker = in.readLine ();

		//if score line is equal to 0 output highscore of 0 or else output the actual high score
		if (nullchecker == null)
		    c.drawString (i / 127 + ". 0", 50, i);
		else
		    c.drawString (i / 127 + ". " + nullchecker, 50, i);

		nullchecker = in.readLine ();
		//if name line 'equals' to empty output 'nobody from nowhere' or else ouput actual name/location
		if (nullchecker.equals ("Empty"))
		    c.drawString ("Nobody from Nowhere", 50, i + 50);
		else
		    c.drawString (nullchecker, 50, i + 50);
	    }

	    //outputs the highscores to the screen for the user for a loop of 5 times
	    for (int i = 240 ; i <= 640 ; i += 100)
	    {
		in.readLine ();

		nullchecker = in.readLine ();
		//if score line is equal to 0 output highscore of 0 or else output the actual high score
		if (nullchecker == null)
		    c.drawString (i / 127 + 5 + ". 0", 700, i);
		else
		    c.drawString (i / 127 + 5 + ". " + nullchecker, 700, i);

		nullchecker = in.readLine ();
		//if name line 'equals' to empty output 'nobody from nowhere' or else ouput actual name/location
		if (nullchecker.equals ("Empty"))
		    c.drawString ("Nobody from Nowhere", 700, i + 50);
		else
		    c.drawString (nullchecker, 700, i + 50);
	    }

	    //closes input stream
	    in.close ();
	}
	catch (IOException e)
	{
	    new Message ("Sorry, that didn't work");
	}


	//This segment of the code is responsible for clearing the file
	c.setFont (new Font ("Swiss 911", 1, 20));
	c.drawString ("Enter 'X' to clear highScores or ", 15, 150);
	c.drawString ("any other key to continue.", 15, 190);
	//if the user inputs X, the computer writes to the file, but it writes a blank page
	char input = c.getChar ();
	if (input == 'X' || input == 'x')
	{
	    try
	    {
		//popup message alerting user of the consequences
		new Message ("Clearing High Score File!");
		out = new PrintWriter (new FileWriter (fileName));
		out.println ("");
		//closes output stream
		out.close ();
	    }
	    catch (IOException e)
	    {
	    }
	}
	//pauses program
	pauseProgram ();
    }


    /*
	This method tells the user goodbye and says who created the program.
	---------------------------------------------------------------------------------------------------------------
	Local Variables:
	Global Variables Used: Color paper, Color purple
	---------------------------------------------------------------------------------------------------------------
	*/

    public void goodbye ()
    {
	//draws title and background
	title ();
	//creates an animated goodbye screen
	for (int x = 0 ; x < 300 ; x++)
	{

	    c.setColor (paper);
	    c.drawString ("Good Bye!", 0 + x, 425);
	    //animation moves every 10 miliseconds
	    try
	    {
		Thread.sleep (10);
	    }
	    catch (Exception e)
	    {
	    }
	    c.setColor (purple);
	    c.drawString ("Good Bye!", 0 + x, 425);
	}
	//displays final goodbye message along with who made the program
	c.setColor (paper);
	c.drawString ("Good Bye!", 300, 425);
	c.setFont (new Font ("Swiss 911", 1, 40));
	c.drawString ("Game Created By", 340, 475);
	c.setFont (new Font ("Swiss 911", Font.BOLD, 50));
	c.drawString ("Jason Reid", 380, 535);
    }


    /*
	This method asks user1 for a name and location, then asks user 2 for a name and location. It is errortrapped for 8 characters each.
	---------------------------------------------------------------------------------------------------------------
	Local Variables:
	Global Variables Used: String user1, String user2, String location1, String location2
	---------------------------------------------------------------------------------------------------------------
	*/
    public void askData ()
    {
	//draws title and background
	title ();
	c.setColor (Color.white);
	c.fillRect (0, 200, 1068, 968);
	c.setColor (purple);
	c.setFont (new Font ("Swiss 911", 1, 20));

	//INPUT FOR USER1
	c.drawString ("Enter a name for user 1 under 8 characters: ", 50, 255);

	//do-while loop to ensure user1 name is under 8 characters
	do
	{
	    c.setCursor (13, 62);
	    user1 = c.readLine ();
	    //error message if the user doesn't listen
	    if (user1.length () > 8)
		new Message ("Name must be under 8 characters!");
	}
	while (user1.length () > 8);

	c.drawString ("Enter a location for user 1 under 8 characters: ", 50, 335);

	do
	{
	    //do-while loop to ensure location1 is under 8 characters
	    c.setCursor (17, 65);
	    location1 = c.readLine ();
	    //error message if the user doesn't listen
	    if (location1.length () > 8)
		new Message ("Location must be under 8 characters!");
	}
	while (location1.length () > 8);

	//INPUT FOR USER2
	c.drawString ("Enter a name for user 2 under 8 characters: ", 50, 415);

	do
	{
	    //do-while loop to ensure user2 name is under 8 characters
	    c.setCursor (21, 62);
	    user2 = c.readLine ();
	    //error message if the user doesn't listen
	    if (user2.length () > 8)
		new Message ("Name must be under 8 characters!");
	}
	while (user2.length () > 8);

	c.drawString ("Enter a location for user 2 under 8 characters: ", 50, 495);

	do
	{
	    //do-while loop to ensure location2 is under 8 characters
	    c.setCursor (25, 65);
	    location2 = c.readLine ();
	    //error message if the user doesn't listen
	    if (location2.length () > 8)
		new Message ("Location must be under 8 characters!");
	}
	while (location2.length () > 8);
	pauseProgram ();
    }


    /*
    This method allows the user to play level1, it features one daily double question
    ---------------------------------------------------------------------------------------------------------------
    Local Variables:
    Global Variables Used: int round, int count, boolean user1turn, int user1, int user1, int wager1, int wager2, int score1, int score2, int colNum, int colChoice
    ---------------------------------------------------------------------------------------------------------------
    */
    public void level1 ()
    {
	//sets round to 1
	round = 1;

	//sets count to 0
	count = 0;
	//creates the background
	c.setColor (purple);
	c.fillRect (0, 0, 1024, 768);
	c.setColor (gold);
	c.setFont (new Font ("Anonymous", Font.BOLD, 50));
	c.drawString ("Jeopardy!", 400, 50);
	//draws the jeaopardy box
	drawJeopardyBox (round);
	c.setColor (Color.white);
	c.fillRect (0, 590, 1068, 168);

	//while loop that will keep going until all boxes have been opened which is 25
	while (true)
	{
	    //draws the user names and scores
	    c.setFont (new Font ("Swiss 911", 1, 25));
	    c.setColor (purple);
	    c.fillRect (20, 35, 170, 35);
	    c.fillRect (800, 35, 200, 35);
	    c.setColor (paper);

	    //user1 tings
	    c.drawString (user1, 10, 30);
	    c.drawString (("Score: $" + (score1)), 10, 55);

	    //user2 tings
	    c.drawString (user2, 790, 30);
	    c.drawString (("Score: $" + (score2)), 790, 55);

	    //this segment actually runs the game
	    //it first finds out who's turn it is and then runs their selection
	    if (user1turn == true)
		user1turn = userTurn (user1turn, user1, round, wager1, score1);
	    else
		user1turn = userTurn (user1turn, user2, round, wager2, score2);

	    //if at anytime the user answers all capital EXIT, they are escorted to the main menu
	    if (answer.equals ("EXIT"))
	    {
		new Message ("Exiting to Main Menu!");
		break;
	    }

	    //draws over boxes already answered using user input such as column and row choice
	    c.setColor (cobalt);
	    c.fillRect (160 + ((colNum - 1) * 140), 90 + (rowChoice * 80), 135, 75);

	    //if the users have opened all 25 boxes, the round is over!
	    if (count >= 25)
	    {
		roundOver (round);
		break;
	    }
	}
    }


    /*
	This method allows the user to play level2, it features two daily double question
	---------------------------------------------------------------------------------------------------------------
	Local Variables:
	Global Variables Used: int round, int count, boolean user1turn, int user1, int user1, int wager1, int wager2, int score1, int score2, int colNum, int colChoice
	---------------------------------------------------------------------------------------------------------------
	*/
    public void level2 ()
    {
	//sets round to 2
	round = 2;

	//sets count to 0
	count = 0;
	//creates the background
	c.setColor (purple);
	c.fillRect (0, 0, 1024, 768);
	c.setColor (gold);
	c.setFont (new Font ("Anonymous", Font.BOLD, 50));
	c.drawString ("Jeopardy!", 400, 50);
	//draws the jeaopardy box
	drawJeopardyBox (round);
	c.setColor (Color.white);
	c.fillRect (0, 590, 1068, 168);

	//while loop that will keep going until all boxes have been opened which is 25
	while (true)
	{
	    //draws the user names and scores
	    c.setFont (new Font ("Swiss 911", 1, 26));
	    c.setColor (purple);
	    c.fillRect (20, 35, 170, 35);
	    c.fillRect (800, 35, 200, 35);
	    c.setColor (paper);

	    //user1 tings
	    c.drawString (user1, 10, 30);
	    c.drawString (("Score: $" + (score1)), 10, 55);

	    //user2 tings
	    c.drawString (user2, 790, 30);
	    c.drawString (("Score: $" + (score2)), 790, 55);

	    //this segment actually runs the game
	    //it first finds out who's turn it is and then runs their selection
	    if (user1turn == true)
		user1turn = userTurn (user1turn, user1, round, wager1, score1);
	    else
		user1turn = userTurn (user1turn, user2, round, wager2, score2);

	    //if at anytime the user answers all capital EXIT, they are escorted to the main menu
	    if (answer.equals ("EXIT"))
	    {
		new Message ("Exiting to Main Menu!");
		break;
	    }

	    //draws over boxes already answered using user input such as column and row choice
	    c.setColor (cobalt);
	    c.fillRect (160 + ((colNum - 1) * 140), 90 + (rowChoice * 80), 135, 75);

	    //if the users have opened all 25 boxes, the round is over!
	    if (count >= 25)
	    {
		roundOver (round);
		break;
	    }
	}
    }


    /*
	This method allows the user to play finalJeopardy, where they can wager all their total money earned on one filan question.
	---------------------------------------------------------------------------------------------------------------
	Local Variables: int col,
	Global Variables Used: int user1, int user1, int wager1, int wager2, int score1, int score2,
	---------------------------------------------------------------------------------------------------------------
	*/

    public void finalJeopardy ()
    {
	//tells the computer to pick the remaining categories from the final 10 categories
	int col = randomNum (21, 30);

	//draws title + background
	title ();
	c.setColor (Color.white);
	c.setFont (new Font ("Anonymous", 1, 40));
	c.drawString ("Final Jeopardy Round", 315, 250);
	c.setFont (new Font ("Swiss 911", 1, 26));

	//outputs randomly selected category to the screen
	c.drawString ("The category is: ", 325, 300);
	c.drawString (questions [0] [col], 555, 300);

	//draws user names and scores on the background
	c.setColor (Color.white);
	c.fillRect (0, 325, 1000, 600);
	c.setColor (paper);
	c.drawString (user1, 5, 30);
	c.drawString (("Score: $" + (score1)), 5, 55);
	c.drawString (user2, 805, 30);
	c.drawString (("Score: $" + (score2)), 805, 55);
	c.setFont (new Font ("Swiss 911", 1, 20));

	//while loop that keeps running until the user places a bet between 5 and 5 dollars greater than their score
	while (true)
	{
	    try
	    {
		do
		{
		    //prompts the user to write their wager
		    //error traps it against Strings
		    c.setColor (Color.black);
		    c.drawString (user1 + ", place your wager here: ", 50, 355);
		    c.setCursor (18, 43 + user1.length ());
		    String numstr = c.readLine ();
		    wager1 = Integer.parseInt (numstr);
		    if (wager1 < 5 || score1 + 5 < wager1)
		    {
			//error message if the user does not enter a valid wager
			new Message ("Please enter a wager amount above $5 and below your minimum score plus 5 dollars:");
			c.setColor (Color.white);
			c.fillRect (0, 325, 1000, 600);
		    }
		}
		while (wager1 < 5 || score1 + 5 < wager1);
		break;
	    }

	    catch (NumberFormatException e)
	    {
		//error message if the user does not enter a valid wager
		new Message ("Please enter a wager amount above $5 and below your minimum score plus 5 dollars:");
		c.setColor (Color.white);
		c.fillRect (0, 325, 1000, 600);
	    }
	}

	//while loop that keeps running until the user places a bet between 5 and 5 dollars greater than their score
	while (true)
	{
	    try
	    {
		do
		{
		    //prompts the user to write their wager
		    //error traps it against Strings
		    c.setColor (Color.black);
		    c.drawString (user2 + ", place your wager here: ", 555, 355);
		    c.setCursor (18, 107 + user1.length ());
		    String numstr = c.readLine ();
		    wager2 = Integer.parseInt (numstr);
		    if (wager2 < 5 || score2 + 5 < wager2)
		    {
			//error message if the user does not enter a valid wager
			new Message ("Please enter a wager amount above $5 and below your minimum score plus 5 dollars:");
			c.setColor (Color.white);
			c.fillRect (550, 325, 1000, 600);
		    }
		}
		while (wager2 < 5 || score2 + 5 < wager2);
		break;
	    }

	    catch (NumberFormatException e)
	    {
		//error message if the user does not enter a valid wager
		new Message ("Please enter a wager amount above $5 and below your minimum score plus 5 dollars:");
		c.setColor (Color.white);
		c.fillRect (555, 325, 1000, 600);
	    }
	}
	c.setColor (cobalt);
	c.setFont (new Font ("ITC Korinna", Font.BOLD, 18));

	//outputs the final question
	c.drawString ("FINAL QUESTION: " + questions [1] [col], 15, 450);

	//timer feauture that forces users to think about the question for 60 seconds
	//for loop that makes an integr lower by 1 every second
	for (int i = 60 ; i >= 0 ; i--)
	{

	    c.setColor (new Color (17 / 4 * i, 17 / 4 * i, 255));
	    c.setFont (new Font ("ITC Korinna", Font.BOLD, 30));
	    c.drawString ("Timer: " + i, 30, 300);
	    try
	    {
		Thread.sleep (1000);
	    }
	    catch (Exception e)
	    {
	    }
	    c.setColor (purple);
	    c.fillRect (20, 275, 170, 50);
	}

	//prompts the users for their final questions
	c.setColor (Color.black);
	c.setFont (new Font ("ITC Korinna", Font.BOLD, 16));

	//user 1 prompt
	c.drawString (user1 + ", enter your final answer here: ", 15, 515);
	c.setCursor (26, 36 + user1.length ());
	answer = c.readLine ();

	//user 2 prompt
	c.drawString (user2 + ", enter your final answer here: ", 15, 555);
	c.setCursor (28, 36 + user2.length ());
	answer2 = c.readLine ();

	//if both answers are right
	//both wagers are added to their scores
	if (answer.equalsIgnoreCase (answers [1] [col]) && answer2.equalsIgnoreCase (answers [1] [col]))
	{
	    score1 += wager1;
	    score2 += wager2;
	    c.setColor (green);
	    c.drawString ("Correct!", 450, 520);
	    c.drawString ("Correct!", 450, 555);
	}

	//if only user 1 is right and user 2 is wrong
	//user 1 gets his wager added to his score, while user 2 gets it deducted
	else if (answer.equalsIgnoreCase (answers [1] [col]) && !answer2.equalsIgnoreCase (answers [1] [col]))
	{
	    score1 += wager1;
	    score2 -= wager2;

	    c.setColor (green);
	    c.drawString ("Correct!", 450, 520);
	    c.setColor (Color.red);
	    c.drawString ("Incorrect!", 450, 555);
	}
	//if user1 is wrong and user2 is right
	//user1 gets his wager deducted from his score, while user 2 has it added
	else if (!answer.equalsIgnoreCase (answers [1] [col]) && answer2.equalsIgnoreCase (answers [1] [col]))
	{
	    score1 -= wager1;
	    score2 += wager2;
	    c.setColor (Color.red);
	    c.drawString ("Incorrect!", 450, 520);
	    c.setColor (green);
	    c.drawString ("Correct!", 450, 555);
	}
	//if both answers are wrong
	//both wagers are deducted from their scores
	else if (!answer.equalsIgnoreCase (answers [1] [col]) && !answer2.equalsIgnoreCase (answers [1] [col]))
	{
	    score1 -= wager1;
	    score2 -= wager2;
	    c.setColor (Color.red);
	    c.drawString ("Incorrect!", 450, 520);
	    c.drawString ("Incorrect!", 450, 555);
	}
	//if any answer is equal to exit, the program quits to main menu
	else if (answer.equals ("EXIT") || answer2.equals ("EXIT"))
	{
	    new Message ("Exiting to Main Menu!");
	    return;
	}

	//this segment of code draws the new scores under the usernames
	c.setColor (cobalt);
	c.fillRect (10, 20, 200, 150);
	c.fillRect (810, 20, 300, 150);
	c.setColor (paper);
	c.setFont (new Font ("Swiss 911", 1, 26));
	c.drawString (user1, 5, 30);
	c.drawString (("Score: $" + (score1)), 5, 55);
	c.drawString (user2, 805, 30);
	c.drawString (("Score: $" + (score2)), 805, 55);

	//pauses program
	pauseProgram ();

    }


    /*
	    This method congratulates the winning user, checks to see if his score made the high score and then inputs the new highscore into the file removing the old1
	    ---------------------------------------------------------------------------------------------------------------
	    Local Variables:
	    Global Variables Used:  int user1, int user1, int score1, int score2,
	    ---------------------------------------------------------------------------------------------------------------
	    */

    public void congrats (String user, String location, int score) throws IOException
    {

	//int array that stores the integer highscores
	int[] highscores = new int [10];
	//string array that stores the string name + location
	String[] name = new String [10];

	//draws  the background + title
	title ();
	//animated graphic that changes color and congratulates user on victory
	for (int i = 0 ; i < 200 ; i++)
	{
	    c.setColor (new Color (255 - i, 0 + i, 0 + i));
	    c.setFont (new Font ("Helvetica", 1, 70));
	    c.drawString ("Congrats " + user + "!", -40 + i, 300);
	    try
	    {
		Thread.sleep (10);
	    }
	    catch (Exception e)
	    {
	    }
	    c.setColor (purple);
	    c.drawString ("Congrats " + user + "!", -40 + i, 300);
	}
	//a set graphic once the animation ends
	c.setColor (new Color (55, 200, 200));
	c.drawString ("Congrats " + user + "!", 160, 300);
	c.setFont (new Font ("Helvetica", 1, 30));
	c.drawString ("You won this game of Jeopardy with a final score of...", 120, 350);
	//this for loop allows the score to flash slowly, then quickly
	for (int j = 40 ; j >= 0 ; j--)
	{
	    c.setFont (new Font ("Helvetica", 1, 40));
	    c.setColor (new Color (55, 200, 200));
	    c.drawString ("$" + score, 450, 450);
	    try
	    {
		Thread.sleep (5 * j);
	    }
	    catch (Exception e)
	    {
	    }
	    c.setColor (purple);
	    c.drawString ("$" + score, 450, 450);
	    try
	    {
		Thread.sleep (5 * j);
	    }
	    catch (Exception e)
	    {
	    }
	}
	c.setColor (new Color (55, 200, 200));
	c.drawString ("$" + score, 450, 450);
	try
	{
	    //reads the file and stores the scores and names in an array
	    in = new BufferedReader (new FileReader (fileName));
	    for (int x = 1 ; x <= 10 ; x++)
	    {
		//buffer line
		in.readLine ();
		//score line
		highscores [x - 1] = Integer.parseInt (in.readLine ());
		//name line
		name [x - 1] = in.readLine ();
	    }
	    //closes input stream
	    in.close ();

	}
	catch (IOException e)
	{
	    new Message ("Sorry, that didn't work");
	}


	try
	{
	    //creates a class variable that can write to the high score file
	    PrintWriter out = new PrintWriter (new FileWriter (fileName));

	    //conditional statement
	    //if the recently made score is higher than the last high score in the array, add it to the file
	    if (score > highscores [9])
	    {
		new Message ("You made it to the Hall of Fame, kid!");
		for (int x = 1 ; x <= 9 ; x++)
		{
		    //buffer line
		    out.println ();
		    //score line
		    out.println (highscores [x - 1]);
		    //name line
		    out.println (name [x - 1]);
		}
		//buffer line
		out.println ();
		//score line
		out.println (score);
		//name line
		out.println (user + " from " + location);

		//closes output stream
		out.close ();
	    }
	}
	catch (IOException e)
	{
	    //error message
	    new Message ("Sorry, that really didn't work");
	}
	//pauses program
	pauseProgram ();

    }



    //GRAPHIC METHODS


    /*
	   This method creates an animated title as well as the background.
	   ---------------------------------------------------------------------------------------------------------------
	   Local Variables:
	   Global Variables Used:  Color purple, Color cobalt
	   ---------------------------------------------------------------------------------------------------------------
	   */
    public void title ()
    {
	//clears the console screen of any previous screen output to the user
	c.clear ();

	//draws a purple rectangle the size of the console screen
	c.setColor (purple);
	c.fillRect (0, 0, 1068, 968);

	//draws a blue rectgangle that only covers a top portion
	c.setColor (cobalt);
	c.fillRect (0, 0, 1068, 200);

	//for loop that changes the color of the title as well as makes it slightly smaller/concentrated
	for (int i = 0 ; i < 17 ; i++)
	{
	    c.setColor (new Color (200, 15 * i, 255));
	    c.setFont (new Font ("Anonymous", Font.BOLD, 100 - i));
	    c.drawString ("JEOPARDY!", 185 + i * 26 / 8, 100);
	    //draws a new title every 30 miliseconds
	    try
	    {
		Thread.sleep (30);
	    }
	    catch (Exception e)
	    {
	    }

	}
    }


    /*
	   This method draws a dollar bill based on the x and y coordinates passed.
	   ---------------------------------------------------------------------------------------------------------------
	   Local Variables:
	   Global Variables Used:
	   ---------------------------------------------------------------------------------------------------------------
	   */
    public void getMoney (int x, int y)
    {
	//sets the font
	c.setFont (new Font ("Anonymous", Font.BOLD, 20));

	//draws the green dollar bill
	c.setColor (new Color (84, 186, 29));
	c.fillRect (x, y, 25, 50);

	//draws the dollar sign on the bill
	c.setColor (new Color (51, 114, 17));
	c.drawString ("$", x + 7, y + 30);

    }


    /*
     This method erases user input in levels one and two by drawing an entire rectangle over the entire user input portion
     ---------------------------------------------------------------------------------------------------------------
     Local Variables:
     Global Variables Used:
     ---------------------------------------------------------------------------------------------------------------
    */
    public void eraseInput ()
    {
	//sets color to white
	c.setColor (Color.white);
	//draws rectangle
	c.fillRect (100, 595, 954, 138);
	//sets color back to black
	c.setColor (Color.black);
    }


    /*
     This method draws the Jeopardy Box being used in levels 1 and 2.
     ---------------------------------------------------------------------------------------------------------------
     Local Variables:
     Global Variables Used: Color cobalt, Color paper, Color gold
     ---------------------------------------------------------------------------------------------------------------
    */
    public void drawJeopardyBox (int round)
    {

	//draws the blue board with questions
	c.setColor (cobalt);
	c.fillRect (150, 80, 710, 500);
	//writes a prompt that tells the user to exit by typing a keyword into the answer box
	c.setColor (Color.white);
	c.setFont (new Font ("Arial", 2, 15));
	c.drawString ("Type 'EXIT' into the answer box", 190, 25);
	c.drawString (" to exit to main menu...", 230, 50);
	c.setColor (Color.black);

	//for loop that draws the jeopardy box

	//this for loop runs 5 times
	for (int xcor = 0 ; xcor <= 580 ; xcor += 140)
	{
	    c.setColor (paper);

	    //draws the numbers that number the categories
	    c.setFont (new Font ("Swiss 911", 1, 20));
	    c.drawString ("1", 220, 110);
	    c.drawString ("2", 360, 110);
	    c.drawString ("3", 500, 110);
	    c.drawString ("4", 640, 110);
	    c.drawString ("5", 780, 110);
	    c.setFont (new Font ("Swiss 911", 1, 15));

	    //if the round is one, it prints the designated round 1 categories
	    if (round == 1)
	    {
		c.drawString (questions [0] [col1], 165, 140);
		c.drawString (questions [0] [col2], 310, 140);
		c.drawString (questions [0] [col3], 450, 140);
		c.drawString (questions [0] [col4], 590, 140);
		c.drawString (questions [0] [col5], 730, 140);
	    }

	    //if the round is two, it prints the designated round 2 categories
	    else if (round == 2)
	    {
		c.drawString (questions [0] [col6], 165, 140);
		c.drawString (questions [0] [col7], 305, 140);
		c.drawString (questions [0] [col8], 445, 140);
		c.drawString (questions [0] [col9], 585, 140);
		c.drawString (questions [0] [col10], 725, 140);
	    }

	    //draws all the dollar numbers on the hint boxes, regardless of round
	    c.setColor (gold);
	    c.setFont (new Font ("Swiss 911", Font.BOLD, 20));
	    c.drawString ("$" + 100 * round, 200 + xcor, 210);
	    c.drawString ("$" + 200 * round, 200 + xcor, 290);
	    c.drawString ("$" + 300 * round, 200 + xcor, 370);
	    c.drawString ("$" + 400 * round, 200 + xcor, 450);
	    c.drawString ("$" + 500 * round, 200 + xcor, 530);

	    //draws all 25 boxes
	    //this for loop runs 5 times
	    for (int ycor = 0 ; ycor <= 470 ; ycor += 80)
	    {
		c.setColor (Color.black);
		c.drawRect (160 + xcor, 90 + ycor, 130, 70);
	    }
	}
    }


    /*
     This method displays to the user that the round is over
     ---------------------------------------------------------------------------------------------------------------
     Local Variables: int round
     Global Variables Used: Color paper, Color purple
     ---------------------------------------------------------------------------------------------------------------
    */

    public void roundOver (int round)
    {
	//sets title + background
	title ();

	//creates an animated graphic that tells the users the round is over
	for (int x = 0 ; x < 1050 ; x++)
	{
	    //based on the round will tell user which round is over
	    c.setColor (paper);
	    c.drawString ("Round " + round + " over!", 0 + x, 425);
	    try
	    {
		Thread.sleep (8);
	    }
	    catch (Exception e)
	    {
	    }
	    c.setColor (purple);
	    c.drawString ("Round " + round + " over!", 0 + x, 425);
	}

	//creates an animated graphic that tells the next round is beginning
	for (int x = -100 ; x < 1050 ; x++)
	{
	    //based on the round will tell user which round is over
	    c.setColor (paper);
	    c.drawString ("Round " + (round + 1) + " BEGINS!", 0 + x, 425);
	    try
	    {
		Thread.sleep (8);
	    }
	    catch (Exception e)
	    {
	    }
	    c.setColor (purple);
	    c.drawString ("Round " + (round + 1) + " BEGINS!", 0 + x, 425);
	}

    }


    //BLACKBOX METHODS FOR THE PROGRAM FUNCTION

    /*
     This method error traps against selecting an invalid category choice or column choice and then acceps user input for use in selecting category
     ---------------------------------------------------------------------------------------------------------------
     Local Variables:
     Global Variables Used: String user1, String user2, String colChoice
     ---------------------------------------------------------------------------------------------------------------
    */

    public void categoryET (String user)
    {

	//while loop so that the computer will not take the user input until the column choice is greater than 1 and less than 6
	while (true)
	{
	    try
	    {
		do
		{
		    //prompts the user for category choice
		    c.drawString ((user + ", please enter category number: "), 100, 635);
		    c.setColor (Color.black);
		    c.setCursor (32, 44 + (user.length ()));

		    //stores input as a string and then parses it to an integer
		    String numstr = c.readLine ();
		    colChoice = Integer.parseInt (numstr);

		    //error trap so that if the column choice isn't between 1 and 5, an error message is produced
		    if (colChoice < 1 || 5 < colChoice)
		    {
			//error message
			new Message ("Please enter valid integer input between 1 and 5.");
			c.setColor (Color.white);
			c.fillRect (380, 615, 574, 138);
			eraseInput ();
		    }
		}
		while (colChoice < 1 || 5 < colChoice);
		//do while statement saying if conditions are met, break out the first while loop
		break;
	    }

	    //if the program catches that the user inputted a string and not a number, an error message is produced
	    catch (NumberFormatException e)
	    {
		//error message
		new Message ("Please enter valid integer input between 1 and 5.");
		c.setColor (Color.white);
		c.fillRect (380, 615, 574, 138);
		eraseInput ();
	    }
	}
    }


    /*
     This method error traps against selecting an invalid question choice or row choice and then acceps user input for use in selecting question
     ---------------------------------------------------------------------------------------------------------------
     Local Variables: int rowUserChoice
     Global Variables Used: String user1, String user2, String rowChoice, int round
     ---------------------------------------------------------------------------------------------------------------
    */

    public void rowET (int round, String user)
    {
	//this variable will be used to accept the user input as dollar amount
	//it will later be converted to rowChoice which is the number the question in the array is associated with
	int rowUserChoice;

	//while loop so that the computer will not take the user input until the column choice is equal to either 100, 200, 300, 400 or 500
	//if it's round 2 the numbers are 200, 400, 600, 800, 1000
	while (true)
	{
	    try
	    {
		do
		{

		    c.drawString ((user + ", please enter category number: "), 100, 635);

		    //prompts the user for which question they'd like
		    c.drawString ((questions [0] [colChoice] + ", for how much: "), 100, 655);
		    c.setColor (Color.black);
		    c.setCursor (33, 29 + (questions [0] [colChoice]).length ());

		    //stores input as a string and then parses it to an integer
		    String numstr = c.readLine ();
		    rowUserChoice = Integer.parseInt (numstr);
		    //converts rowUserChoice from dollar amount to an actual row choice
		    rowChoice = rowUserChoice / (100 * round);

		    //if the user enters a row choice that is not on the table, an error message is produced
		    if ((rowChoice < 1 || 5 < rowChoice) || (rowUserChoice != 100 * round && rowUserChoice != 200 * round && rowUserChoice != 300 * round && rowUserChoice != 400 * round && rowUserChoice != 500 * round))
		    {
			//error message
			new Message ("Please enter valid integer values of " + 100 * round + ", " + 200 * round + ", " + 300 * round + ", " + 400 * round + " and " + 500 * round);
			c.setColor (Color.white);
			c.fillRect (285, 635, 669, 138);
			eraseInput ();
		    }
		}
		while (rowUserChoice != 100 * round && rowUserChoice != 200 * round && rowUserChoice != 300 * round && rowUserChoice != 400 * round && rowUserChoice != 500 * round);
		//once the do while loop is exited, the first while loop is broken meaning the ET is successful
		break;
	    }

	    //if the program catches that the user inputted a string and not a number, an error message is produced
	    catch (NumberFormatException e)
	    {
		//error message
		new Message ("Please enter valid integer values of " + 100 * round + ", " + 200 * round + ", " + 300 * round + ", " + 400 * round + " and " + 500 * round);
		c.setColor (Color.white);
		c.fillRect (285, 635, 669, 138);
		eraseInput ();
	    }
	}
    }


    /*
     This method allows the user to play daily double!
     If the user gets the question right, his wager is added to his score total
     If the user gets the question wrong, his wager is deducted from his score total
     ---------------------------------------------------------------------------------------------------------------
     Local Variables: int rowUserChoice
     Global Variables Used: String user1, String user2, String rowChoice, int round
     ---------------------------------------------------------------------------------------------------------------
    */
    public void dailyDouble (String user, int score, int wager)
    {
	//error trap for the wager amount
	//while loop so that the computer will not take the user input until the wager is between 5 and his score + 5
	while (true)
	{
	    try
	    {
		do
		{
		    //prompts the user for wager amount
		    c.drawString ("This question is a daily double!!!", 100, 635);
		    c.drawString ("Enter a wager amount between $5 and your minimum score plus 5 dollars: ", 100, 655);
		    c.setColor (Color.black);
		    c.setCursor (33, 86);

		    //stores input as a string and then parses it to an integer
		    String numstr = c.readLine ();
		    wager = Integer.parseInt (numstr);

		    //if the user enters a wager that is not between 5 and his score + 5, an error message us produced
		    if (wager < 5 || score + 5 < wager)
		    {
			//error message
			new Message ("Please enter a wager amount between $5 and your minimum score plus 5 dollars:");
			c.setColor (Color.white);
			c.fillRect (380, 615, 574, 138);
			eraseInput ();
		    }
		}
		while (wager < 5 || score + 5 < wager);
		//once the do while loop is exited, the first while loop is broken meaning the ET is successful
		break;
	    }
	    //if the program catches that the user inputted a string and not a number, an error message is produced
	    catch (NumberFormatException e)
	    {
		//error message
		new Message ("Please enter a wager amount between $5 and your minimum score plus 5 dollars:");
		c.setColor (Color.white);
		c.fillRect (380, 615, 574, 138);
		eraseInput ();
	    }
	}

	//displays the user question
	displayQuestion (colChoice, rowChoice);

	//recieves user input
	c.setColor (Color.black);
	c.setFont (new Font ("Swiss 911", 1, 15));
	c.drawString ((user + ", please answer: "), 100, 675);
	c.setCursor (34, 30 + (user.length ()));
	answer = c.readLine ();

	//erases user input
	eraseInput ();
	c.setFont (new Font ("Swiss 911", 1, 18));

	//this segment only runs if it's user 1's turn
	if (user1turn == true)
	{
	    //this segment runs if the user is correct
	    if (answer.equalsIgnoreCase (answers [rowChoice] [colChoice]))
	    {
		//wager is added to score
		score1 += wager;
		c.setColor (green);
		//user is informed he was correct
		c.drawString ("The answer was correct!!!", 100, 635);
		try
		{
		    Thread.sleep (3000);
		}
		catch (Exception e)
		{
		}
		//nullifies the question in the array so it can't be used again
		questions [rowChoice] [colChoice] = null;
		//adds to count
		count++;
	    }
	    else if (answer.equals ("EXIT"))
	    {
		//if the user inputs 'EXIT' the program directs back to the level
		return;
	    }
	    else
	    {
		//wager is deducted from score
		score1 -= wager;
		//the user is informed he was incorrect
		c.setColor (Color.red);
		c.drawString ("The answer was incorrect...", 100, 635);
		try
		{
		    Thread.sleep (3000);
		}
		catch (Exception e)
		{
		}
		//displays answer
		displayAnswer (colChoice, rowChoice);
		//nullifies the question in the array so it can't be used again
		questions [rowChoice] [colChoice] = null;
		//adds to count
		count++;
	    }
	}

	//this segment only runs if it's user 2's turn
	else
	{
	    //this segment runs if the user is correct
	    if (answer.equalsIgnoreCase (answers [rowChoice] [colChoice]))
	    {
		//wager is added to score
		score2 += wager;
		c.setColor (green);
		//user is informed he was correct
		c.drawString ("The answer was correct!!!", 100, 635);
		try
		{
		    Thread.sleep (3000);
		}
		catch (Exception e)
		{
		}
		//nullifies the question in the array so it can't be used again
		questions [rowChoice] [colChoice] = null;
		//adds to count
		count++;
	    }
	    else if (answer.equals ("EXIT"))
	    {
		//if the user inputs 'EXIT' the program directs back to the level
		return;
	    }
	    else
	    {
		//wager is deducted from score
		score2 -= wager;
		//the user is informed he was incorrect
		c.setColor (Color.red);
		c.drawString ("The answer was incorrect...", 100, 635);
		try
		{
		    Thread.sleep (3000);
		}
		catch (Exception e)
		{
		}
		//displays answer
		displayAnswer (colChoice, rowChoice);
		//nullifies the question in the array so it can't be used again
		questions [rowChoice] [colChoice] = null;
		//adds to count
		count++;
	    }

	}
    }


    /*
     This method runs a complete user turn.
     It first stores what question the user wants, then it recieves input to see if the answer is correct, it then returns whether the user retains his turn or not.
     ---------------------------------------------------------------------------------------------------------------
     Local Variables:
     Global Variables Used: boolean user1turn, String user1, String user2, int wager1, int wager2, int score1, int score2, int colNum, int Colchoice  int rowChoice,  int round
     ---------------------------------------------------------------------------------------------------------------
    */

    public boolean userTurn (boolean user1turn, String user, int round, int wager, int score)
    {
	//erases user input before next user turn
	eraseInput ();
	c.setColor (Color.black);
	c.setFont (new Font ("Swiss 911", 1, 15));

	//do while loop to ensure user cannot select a box that is empty or is equal to null
	do
	{
	    //user can select category
	    categoryET (user);

	    //colNum is equal to colChoice so the level method knows which box to erase as colChoice will change in the future
	    colNum = colChoice;

	    if (round == 1)
	    {
		//switch case statement where the choice of the user's value is switched to match the random category selected previously
		//5 cases because there are 5 possible categories
		switch (colChoice)
		{
		    case 1:
			colChoice = col1;
			break;
		    case 2:
			colChoice = col2;
			break;
		    case 3:
			colChoice = col3;
			break;
		    case 4:
			colChoice = col4;
			break;
		    case 5:
			colChoice = col5;
			break;
		    default:
			break;
		}
	    }
	    else if (round == 2)
	    {
		//switch case statement where the choice of the user's value is switched to match the random category selected previously
		//5 cases because there are 5 possible categories
		switch (colChoice)
		{
		    case 1:
			colChoice = col6;
			break;
		    case 2:
			colChoice = col7;
			break;
		    case 3:
			colChoice = col8;
			break;
		    case 4:
			colChoice = col9;
			break;
		    case 5:
			colChoice = col10;
			break;
		    default:
			break;
		}
	    }

	    //user recieves input from the user to place a value for rowChoice
	    rowET (round, user);

	    //if the hint selected by the user is empty or null, an error message is produced
	    if (questions [rowChoice] [colChoice] == null)
		new Message ("Please select a box that has not already been selected.");

	    eraseInput ();
	}
	while (questions [rowChoice] [colChoice] == null);

	//if the column and row choices are equal to the dailyDouble rows and columns randomly selected
	//then the dailyDouble method is ran.


	if (rowChoice == dailyDoubleRow1 && colChoice == dailyDoubleCol1)
	{
	    //First Daily Double question in level1
	    dailyDouble (user, score, wager);

	    //ensures that it remains the user's turn for the next question
	    if (user1turn == true)
		return true;
	    else
		return false;
	}
	else if (rowChoice == dailyDoubleRow2 && colChoice == dailyDoubleCol2)
	{
	    //Second Daily Double question in level1
	    dailyDouble (user, score, wager);

	    //ensures that it remains the user's turn for the next question
	    if (user1turn == true)
		return true;
	    else
		return false;
	}
	else if (rowChoice == dailyDoubleRow3 && colChoice == dailyDoubleCol3)
	{
	    //Third Daily Double question in level1
	    dailyDouble (user, score, wager);

	    //ensures that it remains the user's turn for the next question
	    if (user1turn == true)
		return true;
	    else
		return false;
	}

	//if the question is not a daily double this segment of code is ran
	else
	{
	    //displays question
	    displayQuestion (colChoice, rowChoice);

	    //recieve user input for the answer of the question
	    c.setColor (Color.black);
	    c.setFont (new Font ("Swiss 911", 1, 15));
	    c.drawString ((user + ", please answer: "), 100, 675);
	    c.setCursor (34, 30 + (user.length ()));
	    answer = c.readLine ();

	    //erases input
	    eraseInput ();
	    c.setFont (new Font ("Swiss 911", 1, 20));

	    //if the answer of the user is equal to the answer in the answer array of the correlationg question
	    //the price of the question is added to the users score
	    if (answer.equalsIgnoreCase (answers [rowChoice] [colChoice]))
	    {
		//user 1's turn
		if (user1turn == true)
		{
		    //price of question is added to the users score
		    score1 += rowChoice * 100 * round;
		    //user is informed they are correct
		    c.setColor (green);
		    c.drawString ("The answer was correct!!!", 100, 635);
		    try
		    {
			Thread.sleep (3000);
		    }
		    catch (Exception e)
		    {
		    }
		    //the question is nullified and one is added to count
		    questions [rowChoice] [colChoice] = null;
		    count++;
		    //if it's user1's turn, it stays user1's turn
		    return true;
		}
		//user 2's turn
		else
		{
		    //price of question is added to the users score
		    score2 += rowChoice * 100 * round;
		    //user is informed they are correct
		    c.setColor (green);
		    c.drawString ("The answer was correct!!!", 100, 635);
		    try
		    {
			Thread.sleep (3000);
		    }
		    catch (Exception e)
		    {
		    }
		    //the question is nullified and one is added to count
		    questions [rowChoice] [colChoice] = null;
		    count++;
		    //if it's user2's turn, it stays user2's turn
		    return false;
		}
	    }
	    //if the answer is equal to 'EXIT', method returns to the level method
	    else if (answer.equals ("EXIT"))
	    {
		return false;
	    }

	    //if answer is wrong
	    else
	    {
		//user is informed he is incorrect
		c.setColor (Color.red);
		c.drawString ("The answer was incorrect...", 100, 635);
		try
		{
		    Thread.sleep (3000);
		}
		catch (Exception e)
		{
		}

		//user2's turn to steal this question from user1
		if (user1turn == true)
		{
		    //displays question
		    displayQuestion (colChoice, rowChoice);

		    //recieves answer input from the user
		    c.setColor (Color.black);
		    c.setFont (new Font ("Swiss 911", 1, 15));
		    c.drawString ((user2 + ", please answer: "), 100, 675);
		    c.setCursor (34, 30 + (user2.length ()));
		    answer = c.readLine ();

		    eraseInput ();
		    c.setFont (new Font ("Swiss 911", 1, 20));
		    //if user 2 is right
		    if (answer.equalsIgnoreCase (answers [rowChoice] [colChoice]))
		    {
			c.setColor (green);
			c.drawString ("The answer was correct!!!", 100, 635);
			try
			{
			    Thread.sleep (3000);
			}
			catch (Exception e)
			{
			}
			//score is deducted from wrong user
			//score is added to right user
			score1 -= rowChoice * 100 * round;
			score2 += rowChoice * 100 * round;
			questions [rowChoice] [colChoice] = null;
			count++;
			return false;
		    }
		    //if both users are wrong
		    else
		    {
			//displays the answer to both users
			displayAnswer (colChoice, rowChoice);
			questions [rowChoice] [colChoice] = null;
			count++;
			return true;
		    }
		}
		//user2's turn to steal this question from user1
		else
		{
		    //displays question
		    displayQuestion (colChoice, rowChoice);

		    //recieves answer input from the user
		    c.setColor (Color.black);
		    c.setFont (new Font ("Swiss 911", 1, 15));
		    c.drawString ((user1 + ", please answer: "), 100, 675);
		    c.setCursor (34, 30 + (user1.length ()));
		    answer = c.readLine ();
		    eraseInput ();
		    c.setFont (new Font ("Swiss 911", 1, 20));

		    //if user 1 is right
		    if (answer.equalsIgnoreCase (answers [rowChoice] [colChoice]))
		    {
			c.setColor (green);
			c.drawString ("The answer was correct!!!", 100, 635);
			try
			{
			    Thread.sleep (3000);
			}
			catch (Exception e)
			{
			}
			//score is deducted from wrong user
			//score is added to right user
			score2 -= rowChoice * 100 * round;
			score1 += rowChoice * 100 * round;
			questions [rowChoice] [colChoice] = null;
			count++;
			return true;
		    }
		    //if answer is equal to exit, returns to level method
		    else if (answer.equals ("EXIT"))
		    {
			return false;
		    }
		    //if both users are wrong
		    else
		    {
			//the answer is displayed to both users
			displayAnswer (colChoice, rowChoice);
			questions [rowChoice] [colChoice] = null;
			count++;
			return false;
		    }


		}
	    }
	}
    }


    //DISPLAY METHODS

    /*
     This method displays a question
     Displays the question based on the parameters passed
     ---------------------------------------------------------------------------------------------------------------
     Local Variables:
     Global Variables Used: int colChoice, int rowChoice, Color cobalt
     ---------------------------------------------------------------------------------------------------------------
    */

    public void displayQuestion (int colChoice, int rowChoice)
    {
	//erases input
	eraseInput ();
	c.setColor (cobalt);
	c.setFont (new Font ("ITC Korinna", 1, 20));
	//displays questions
	c.drawString (questions [rowChoice] [colChoice], 100, 615);
    }


    /*
     This method displays an answer
     Displays the answer based on the parameters passed
     ---------------------------------------------------------------------------------------------------------------
     Local Variables:
     Global Variables Used: int colChoice, int rowChoice, Color cobalt
     ---------------------------------------------------------------------------------------------------------------
    */

    public void displayAnswer (int colChoice, int rowChoice)
    {
	//erase input
	eraseInput ();
	c.setColor (cobalt);
	c.setFont (new Font ("ITC Korinna", 1, 20));
	//displays answer for 5 seconds
	c.drawString ("The correct answer was: " + answers [rowChoice] [colChoice], 100, 615);
	try
	{
	    Thread.sleep (5000);
	}


	catch (Exception e)
	{
	}
    }



    //MISCELLANEOUS METHODS

    /*
     This method pauses a program
     ---------------------------------------------------------------------------------------------------------------
     Local Variables:
     Global Variables Used:
     ---------------------------------------------------------------------------------------------------------------
    */
    public void pauseProgram ()
    {
	//tells the user to input a character to continue
	c.setColor (Color.lightGray);
	c.setFont (new Font ("Swiss 911", Font.BOLD, 28));
	c.drawString ("Press any key to continue", 338, 670);
	c.getChar ();
    }


    /*
     This method sorts the highscores array passed and the name array passed
     It is sorted by Selection Sort
     Two objects are passed in it's parameter
     ---------------------------------------------------------------------------------------------------------------
     Local Variables: int n, int max, int maxName, int temp, String stringTemp
     Global Variables Used:
     ---------------------------------------------------------------------------------------------------------------
    */
    public void sort (int highscores[], String name[])
    {
	//n is declared as the length of the high scores array
	int n = highscores.length;

	// for loop that runs for the duration of the array
	for (int i = 0 ; i < n - 1 ; i++)
	{
	    //finds the maximum number in the array
	    int max = i;
	    int maxName = i;
	    //checks substring for the lowest number and swaps it with the first number
	    for (int j = i + 1 ; j < n ; j++)
		if (highscores [j] > highscores [max])
		{
		    max = j;
		    maxName = j;
		}


	    int temp = highscores [max];
	    highscores [max] = highscores [i];
	    highscores [i] = temp;

	    //swaps the String array as well
	    String stringTemp = name [maxName];
	    name [maxName] = name [i];
	    name [i] = stringTemp;
	}
    }


    /*
     This method generates a random number based on the two integers passed
     ---------------------------------------------------------------------------------------------------------------
     Local Variables: int min, int max
     Global Variables Used:
     ---------------------------------------------------------------------------------------------------------------
    */

    static public int randomNum (int min, int max)
    {
	//returns the random number
	int range = (max - min) + 1;
	return (int) (Math.random () * range) + min;
    }


    //ARRAY METHODS(METHOD USED TO ORGANIZE AND STORE QUESTIONS AND ANSWERS)

    /*
     This method stores Column numbers and Daily Double Row and Column numbers.
     ---------------------------------------------------------------------------------------------------------------
     Local Variables:
     Global Variables Used: all col(n) numbers, all DailyDoubleRows and DailyDoubleCols
     ---------------------------------------------------------------------------------------------------------------
    */
    public void columnNumbers ()
    {
	//stores the designated column number to an array
	columnNumbers [0] = col1;
	columnNumbers [1] = col2;
	columnNumbers [2] = col3;
	columnNumbers [3] = col4;
	columnNumbers [4] = col5;
	columnNumbers [5] = col6;
	columnNumbers [6] = col7;
	columnNumbers [7] = col8;
	columnNumbers [8] = col9;
	columnNumbers [9] = col10;

	//the rows are random numbers between 1 and 5
	//the columns are a bit more specific
	//columns must drawn from a random index in the array
	dailyDoubleRow1 = randomNum (1, 5);
	//first daily double question
	dailyDoubleCol1 = columnNumbers [(randomNum (0, 4))];
	dailyDoubleRow2 = randomNum (1, 5);
	//second daily double question
	dailyDoubleCol2 = columnNumbers [randomNum (5, 7)];
	dailyDoubleRow3 = randomNum (1, 5);
	//third daily double question
	dailyDoubleCol3 = columnNumbers [randomNum (8, 9)];

    }


    /*
     This method stores the questions[][] and answers[][]
     ---------------------------------------------------------------------------------------------------------------
     Local Variables:
     Global Variables Used:
     ---------------------------------------------------------------------------------------------------------------
    */
    public void questions ()
    {
	questions [0] [0] = "Controversies";
	questions [1] [0] = "This artist in 2005 claimed President Bush 'doesn't care about black people'.";
	questions [2] [0] = "This R & B artist came under fire when he physically abused the 'Umbrella' artist.";
	questions [3] [0] = "This former child star shaved her entire head in 2007 to cover up drug use.";
	questions [4] [0] = "This former child star wore a paper bag on top of his head to a movie premiere in 2014.";
	questions [5] [0] = "This rapper, after infidelity rumours, was beat up by the 'Single Ladies' singers' sister.";

	questions [0] [1] = "Sports";
	questions [1] [1] = "Only MLB Team based in Canada";
	questions [2] [1] = "This NBA Basketball player is commonly known as 'The King'.";
	questions [3] [1] = "The national football team with the most World Cup wins.";
	questions [4] [1] = "The name of the Trophy presented to the winner of the NHL playoffs";
	questions [5] [1] = "The height of an official NBA Basketball Hoop";

	questions [0] [2] = "History";
	questions [1] [2] = "Canada's First Prime Minister";
	questions [2] [2] = "This woman is feautured on the Canadian 20 dollar bill.";
	questions [3] [2] = "This term was used to descrive the severe economic hardships of the 1930's";
	questions [4] [2] = "Canada's newest province as of 2018.";
	questions [5] [2] = "What Canadian city was severely damaged by a massive exploision in its' harbor in 1917.";

	questions [0] [3] = "Science";
	questions [1] [3] = "Periodic Table symbol for Potassium";
	questions [2] [3] = "The chemical responsible for making plants green.";
	questions [3] [3] = "This lifeform is not considered as living.";
	questions [4] [3] = "This process is known as Cell Division.";
	questions [5] [3] = "This famous physician suffered from a nervous disease known as ALS.";

	questions [0] [4] = "Technology";
	questions [1] [4] = "In 2004, this young man created Facebook in his basement.";
	questions [2] [4] = "This word stands for Amps in the potiential diff. equation.";
	questions [3] [4] = "This scientist was credited with inventing the lightbulb.";
	questions [4] [4] = "Common acronym that stands for Operating System.";
	questions [5] [4] = "The city of the Main Office of Google";

	questions [0] [5] = "War";
	questions [1] [5] = "The year in which WWI began.";
	questions [2] [5] = "A war that involved the American military in the early 1950's";
	questions [3] [5] = "This country held a famous war commonly known as 'The Six Days' War'.";
	questions [4] [5] = "Canadians landed on this beach on D-Day 1944";
	questions [5] [5] = "This president started the so-called 'War on Drugs'.";

	questions [0] [6] = "TV Shows";
	questions [1] [6] = "The breed of Scooby-Doo";
	questions [2] [6] = "Longest Running TV Series";
	questions [3] [6] = "Acronym of the television network owned and operated by Oprah Winfrey Show.";
	questions [4] [6] = "Actor who plays NBC's Michael Scott from 'The Office'.";
	questions [5] [6] = "This TV Show was created and executively produced by Seth McFarlane.";

	questions [0] [7] = "Films";
	questions [1] [7] = "Highest Grossing Movie as of (2017)";
	questions [2] [7] = "This film feautured a fight to the death between teenagers in a dystopian future.";
	questions [3] [7] = "This day-time TV host was the voice actor for Dory in 'Finding Nemo' and 'FInding Dory'.";
	questions [4] [7] = "This film feautured a juvenile delinquents digging holes to 'build character'.";
	questions [5] [7] = "This actor played the original Spiderman in 2002.";

	questions [0] [8] = "Geography";
	questions [1] [8] = "This city is home to the the busiest airport in the world.";
	questions [2] [8] = "A strip of land surrounded by water on all sides except one.";
	questions [3] [8] = "This mountain range shares its' name with a boxer played by Sylvester Stallone.";
	questions [4] [8] = "This sea is known for its' high salt concentration.";
	questions [5] [8] = "Lowest known point on earth.";

	questions [0] [9] = "Music";
	questions [1] [9] = "This artist is famous for hits such as 'Beat It' and 'Thriller'.";
	questions [2] [9] = "She is the daughter of famous country singer, Billy Ray Cyrus.";
	questions [3] [9] = "His real name is Aubrey Graham.";
	questions [4] [9] = "This famous composer created his 9th symphony while deaf.";
	questions [5] [9] = "Recipient of the Album of the Year at the 2018 Grammy Awards,";

	questions [0] [10] = "Cartoons";
	questions [1] [10] = "Who lives in a pineapple under the sea?";
	questions [2] [10] = "This Looney Tunes character often says 'What's up Doc?'";
	questions [3] [10] = "This TV Show has three superheroes made of sugar, spice and evertyhing nice:)";
	questions [4] [10] = "Wanda is to pink as Cosmo is to _____";
	questions [5] [10] = "Futurama originally takes place in this year.";


	answers [0] [0] = "Controversies";
	answers [1] [0] = "Kanye West";
	answers [2] [0] = "Chris Brown";
	answers [3] [0] = "Britney Spears";
	answers [4] [0] = "Shia LaBoeuf";
	answers [5] [0] = "Jay-Z";

	answers [0] [1] = "Sports";
	answers [1] [1] = "Toronto Blue Jays";
	answers [2] [1] = "Lebron James";
	answers [3] [1] = "Brazil";
	answers [4] [1] = "Stanley Cup";
	answers [5] [1] = "Ten feet";

	answers [0] [2] = "History";
	answers [1] [2] = "Sir John A MacDonald";
	answers [2] [2] = "Queen Elizabeth II";
	answers [3] [2] = "The Great Depression";
	answers [4] [2] = "Newfoundland and Labrador";
	answers [5] [2] = "Halifax";

	answers [0] [3] = "Science";
	answers [1] [3] = "K";
	answers [2] [3] = "Chlorophyll";
	answers [3] [3] = "Virus";
	answers [4] [3] = "Mitosis";
	answers [5] [3] = "Stephen Hawking";

	answers [0] [4] = "Technology";
	answers [1] [4] = "Mark Zuckerberg";
	answers [2] [4] = "Amperes";
	answers [3] [4] = "Thomas Edison";
	answers [4] [4] = "OS";
	answers [5] [4] = "Mountain View";

	answers [0] [5] = "War";
	answers [1] [5] = "1914";
	answers [2] [5] = "Korean War";
	answers [3] [5] = "Israel";
	answers [4] [5] = "Juno Beach";
	answers [5] [5] = "Richard Nixon";

	answers [0] [6] = "TV Shows";
	answers [1] [6] = "Great Dane";
	answers [2] [6] = "The Simpsons";
	answers [3] [6] = "OWN";
	answers [4] [6] = "Steve Carrell";
	answers [5] [6] = "Family Guy";

	answers [0] [7] = "Films";
	answers [1] [7] = "Avatar";
	answers [2] [7] = "Hunger Games";
	answers [3] [7] = "Ellen DeGeneres";
	answers [4] [7] = "Holes";
	answers [5] [7] = "Tobey Maguire";

	answers [0] [8] = "Geography";
	answers [1] [8] = "Atlanta";
	answers [2] [8] = "Peninsula";
	answers [3] [8] = "Rocky Mountains";
	answers [4] [8] = "Dead Sea";
	answers [5] [8] = "Challenger Deep";

	answers [0] [9] = "Music";
	answers [1] [9] = "Michael Jackson";
	answers [2] [9] = "Miley Cyrus";
	answers [3] [9] = "Drake";
	answers [4] [9] = "Ludwig van Beethoven";
	answers [5] [9] = "Bruno Mars";

	answers [0] [10] = "Cartoons";
	answers [1] [10] = "Who lives in a pineapple under the sea?";
	answers [2] [10] = "This Looney Tunes character often says 'What's up Doc?'";
	answers [3] [10] = "This TV Show has three superheroes made of sugar, spice and evertyhing nice:)";
	answers [4] [10] = "Wanda is to pink as Cosmo is to _____";
	answers [5] [10] = "Futurama originally takes place in this year.";

	questions [0] [11] = "Art";
	questions [1] [11] = "This artist painted the 'Mona Lisa'.";
	questions [2] [11] = "Only female member of the 'Group of Seven'";
	questions [3] [11] = "This artist gave his ear to a prostitute.";
	questions [4] [11] = "This ninja turtle shares a name with 'Sistine Chapel' painter.";
	questions [5] [11] = "The first paintings known to mankind were discovered in this country.";

	questions [0] [12] = "Religion";
	questions [1] [12] = "This is the most popular religion in the world.";
	questions [2] [12] = "This religion has over 33 million gods";
	questions [3] [12] = "A holy day for Jews to rest on.";
	questions [4] [12] = "The disciple that betrayed Jesus Christ";
	questions [5] [12] = "All muslims ,when praying, must face this direction.";

	questions [0] [13] = "Rain Rhymes";
	questions [1] [13] = "A twisting of ligaments at a joint, such as the ankle";
	questions [2] [13] = "Something that's the cause of a decrease, such as 'on resources'";
	questions [3] [13] = "Abstain & this other 'ain' word both mean to just not do it";
	questions [4] [13] = "'Ow, my arm hurts, I am in such ____'";
	questions [5] [13] = "This orgran weighs on average about 3.3 lbs.";

	questions [0] [14] = "Authors";
	questions [1] [14] = "Author of Lord Of The Rings";
	questions [2] [14] = "Theodor Geisel, an author who wrote and illustarted many children books.";
	questions [3] [14] = "A famous playwright who wrote plays in the Elizabethan Era";
	questions [4] [14] = "This author wrote Anne of Green Gables in P.E.I.";
	questions [5] [14] = "This author wrote 'the Iliad' and 'the Odyssey'.";

	questions [0] [15] = "What Month?";
	questions [1] [15] = "Canada Day";
	questions [2] [15] = "Victoria Day";
	questions [3] [15] = "Thanksgiving";
	questions [4] [15] = "Civic Holiday";
	questions [5] [15] = "Family Day";

	questions [0] [16] = "What Continent?";
	questions [1] [16] = "Mongolia";
	questions [2] [16] = "Vatican City";
	questions [3] [16] = "Sierra Nevada";
	questions [4] [16] = "The Brisbane River";
	questions [5] [16] = "Home to the Jack-ass penguin";

	questions [0] [17] = "Planets";
	questions [1] [17] = "It's the largest & most massive of the planets in the solar system";
	questions [2] [17] = "In 2006 the Cassini spacecraft found yet another ring around this planet";
	questions [3] [17] = "The Greeks called this planet Ares";
	questions [4] [17] = "The brightest planet in the night sky that shines below and to the left of the moon";
	questions [5] [17] = "This planet, third largest in our solar system, was discovered by William Herschel in 1781";

	questions [0] [18] = "What Language?";
	questions [1] [18] = "'Adios'";
	questions [2] [18] = "'Au revoir'";
	questions [3] [18] = "'Aloha'";
	questions [4] [18] = "'Arrivederci'";
	questions [5] [18] = "'Sayonara'";

	questions [0] [19] = "Math";
	questions [1] [19] = "The base numeral system we use in Math.";
	questions [2] [19] = "This mathematician discovered the ratio between sides in right-angle triangles.";
	questions [3] [19] = "This mathematician founded the'Theory of Relativity'.";
	questions [4] [19] = "This mathemetician is commonly known as the 'father of geometry'.";
	questions [5] [19] = "The birthplace of the founder of 'Pascal's Triangles'.";

	questions [0] [20] = "'C to C'";
	questions [1] [20] = "It can mean 'universal' or refer to a particular Christian denomination";
	questions [2] [20] = "Mystifying, or using code";
	questions [3] [20] = "It's distilled from white wine & is named for a city in western France";
	questions [4] [20] = "Having a common center";
	questions [5] [20] = "This era of geologic time includes the Tertiary & Quaternary periods.";

	answers [0] [10] = "Cartoons";
	answers [1] [10] = "Spongebob Squarepants";
	answers [2] [10] = "Bugs Bunny";
	answers [3] [10] = "Powerpuff Girls";
	answers [4] [10] = "Green";
	answers [5] [10] = "3000";

	answers [0] [11] = "Art";
	answers [1] [11] = "Leonardo da Vinci";
	answers [2] [11] = "Emily Carr";
	answers [3] [11] = "Vincent van Gogh";
	answers [4] [11] = "Michelangelo";
	answers [5] [11] = "France";

	answers [0] [12] = "Religion";
	answers [1] [12] = "Christianity";
	answers [2] [12] = "Hinduism";
	answers [3] [12] = "Shabbat";
	answers [4] [12] = "Judas Iscariot";
	answers [5] [12] = "East";

	answers [0] [13] = "Rain Rhymes";
	answers [1] [13] = "sprain";
	answers [2] [13] = "drain";
	answers [3] [13] = "refrain";
	answers [4] [13] = "pain";
	answers [5] [13] = "brain";

	answers [0] [14] = "Authors";
	answers [1] [14] = "J.R.R. Tolkien";
	answers [2] [14] = "Dr. Seuss";
	answers [3] [14] = "William Shakespeare";
	answers [4] [14] = "Lucy Maud Montgomery";
	answers [5] [14] = "Homer";

	answers [0] [15] = "What Month?";
	answers [1] [15] = "July";
	answers [2] [15] = "May";
	answers [3] [15] = "October";
	answers [4] [15] = "August";
	answers [5] [15] = "February";

	answers [0] [16] = "What Continent?";
	answers [1] [16] = "Asia";
	answers [2] [16] = "Europe";
	answers [3] [16] = "Europe";
	answers [4] [16] = "Australia";
	answers [5] [16] = "Africa";

	answers [0] [17] = "Planets";
	answers [1] [17] = "Jupiter";
	answers [2] [17] = "Saturn";
	answers [3] [17] = "Mars";
	answers [4] [17] = "Venus";
	answers [5] [17] = "Uranus";

	answers [0] [18] = "What Language?";
	answers [1] [18] = "Spanish";
	answers [2] [18] = "French";
	answers [3] [18] = "Hawaiian";
	answers [4] [18] = "Italian";
	answers [5] [18] = "Japanese";

	answers [0] [19] = "Math";
	answers [1] [19] = "decimal";
	answers [2] [19] = "Pythagoras";
	answers [3] [19] = "Albert Einstein";
	answers [4] [19] = "Euclid";
	answers [5] [19] = "France";

	answers [0] [20] = "'C to C'";
	answers [1] [20] = "catholic";
	answers [2] [20] = "cryptic";
	answers [3] [20] = "cognac";
	answers [4] [20] = "concentric";
	answers [5] [20] = "cenozoic";

	questions [0] [21] = "Technology";
	questions [1] [21] = "This 'other Steve' founded apple alongside 'Steve Jobs'";

	questions [0] [22] = "Greek Mythology";
	questions [1] [22] = "Though Rhea was his mother, this god was riased by Capheira, the daughter of Oceanus.";

	questions [0] [23] = "Significant Figures";
	questions [1] [23] = "2 U.S. state capitals & 2 major Panamanian ports are named after this European.";

	questions [0] [24] = "Greek Mythology";
	questions [1] [24] = "This greek God shares a name with a sportswear brand, a name that also means 'victory'.";

	questions [0] [25] = "Etymology";
	questions [1] [25] = "This word referring to someone who is not an expert is from the Latin for 'love'.";

	questions [0] [26] = "Science";
	questions [1] [26] = "An atomic mass unit is defined as 1/12th the mass of the '12' isotope of this element.";

	questions [0] [27] = "History";
	questions [1] [27] = "The League of Nations assembly's first meeting in 1920 was in this Swiss city.";

	questions [0] [28] = "Religion";
	questions [1] [28] = "This title means enlightened one in Sanskrit.";

	questions [0] [29] = "Languages";
	questions [1] [29] = "It's the French word for head, boss, top man.";

	questions [0] [30] = "Sports";
	questions [1] [30] = "This state has 4 NBA basketball teams.";



	answers [0] [21] = "Technology";
	answers [1] [21] = "Steve Wozniak";

	answers [0] [22] = "Greek Mythology";
	answers [1] [22] = "Poseidon";

	answers [0] [23] = "Significant Figures";
	answers [1] [23] = "Christopher Columbus";

	answers [0] [24] = "Greek Mythology";
	answers [1] [24] = "Nike";

	answers [0] [25] = "Etymology";
	answers [1] [25] = "amateur";

	answers [0] [26] = "Science";
	answers [1] [26] = "carbon";

	answers [0] [27] = "History";
	answers [1] [27] = "Geneva";

	answers [0] [28] = "Religion";
	answers [1] [28] = "Buddha";

	answers [0] [29] = "Languages";
	answers [1] [29] = "chef";

	answers [0] [30] = "Sports";
	answers [1] [30] = "California";
    }


    //Class Constructor
    public Jeopardy ()
    {
	//creates a new console window
	//adjusts size and window title
	c = new Console (35, 125, "Jeopardy!");
    }


    //creates a method for the class airplane
    public void airplane ()
    {
	//creates a new object variable for the class Airplane
	Airplane a = new Airplane (c);
	//starts the thread
	a.start ();
	//joins the thread
	try
	{
	    a.join ();
	}
	catch (InterruptedException e)
	{
	}

    }


    //MAIN METHOD

    //throws IOException
    public static void main (String[] args) throws IOException
    {
	//creates a new object of the Jeopardy class
	Jeopardy j = new Jeopardy ();
	j.columnNumbers ();
	j.questions ();
	j.splashScreen ();
	//while loop so that it keeps running through the program and it won't break the loop until the user picks the exit method
	while (true)
	{
	    j.mainMenu ();

	    //if the user select play game
	    if (choice == '1')
	    {
		j.askData ();
		j.level1 ();
		//if the user decides to exit
		//the flow of the program goes to the top of the loop, effectively main menu
		if (answer.equals ("EXIT"))
		{
		    continue;
		}
		j.level2 ();
		//if the user decides to exit
		//the flow of the program goes to the top of the loop, effectively main menu
		if (answer.equals ("EXIT"))
		{
		    continue;
		}
		j.finalJeopardy ();
		//if the user decides to exit
		//the flow of the program goes to the top of the loop, effectively main menu
		if (answer.equals ("EXIT"))
		{
		    continue;
		}
		//congrats user on winning the game
		//in the event of a tie, user 1 wins
		if (score1 >= score2)
		{
		    j.congrats (user1, location1, score1);
		}
		else
		{
		    j.congrats (user2, location2, score2);
		}
	    }
	    //if the user selects instructions
	    else if (choice == '2')
		j.instructions ();
	    //if the user selects high scores
	    else if (choice == '3')
		j.highscores ();
	    // if the user selects goodbye
	    else if (choice == '4')
	    {
		j.goodbye ();
		break;
	    }
	}
    }
}


