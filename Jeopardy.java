// The "Jeopardy" class.
import java.awt.*;
import java.io.*;
import hsa.Console;
import hsa.Message;

public class Jeopardy
{
    static Console c;

    String user1 = "Jason";
    int score1 = 0;
    String user2 = "Rogina";
    int score2 = 0;

    boolean user1turn = true;
    String answer;

    static final int ROW = 6;
    static final int COLUMN = 20;

    String[] [] questions = new String [ROW] [COLUMN];
    String[] [] answers = new String [ROW] [COLUMN];

    static final int col1 = randomNum (0, 1);
    static final int col2 = randomNum (2, 3);
    static final int col3 = randomNum (4, 5);
    static final int col4 = randomNum (6, 7);
    static final int col5 = randomNum (8, 9);

    int colChoice;
    int rowChoice;
    int colNum;

    Color purple = new Color (84, 31, 109);
    Color gold = new Color (193, 191, 63);
    Color cobalt = new Color (13, 36, 130);
    Color paper = new Color (234, 236, 242);



    public void level1 ()
    {

	questions [0] [0] = "Controversies";
	questions [1] [0] = "This artist in 2005 claimed President Bush 'doesn't care about black people'.";
	questions [2] [0] = "This R & B artist came under fire when he physically abused the 'Umbrella' artist.";
	questions [3] [0] = "This former child star shaved her entire head in 2007 to cover up drug use.";
	questions [4] [0] = "This former child star wore a paper bag on top of his head to a movie premiere in 2014.";
	questions [5] [0] = "This Hip-Hop legend, after infidelity rumours, was beat up by the 'Single Ladies' singers' sister.";

	questions [0] [1] = "Sports";
	questions [1] [1] = "Only MLB Team based in Canada";
	questions [2] [1] = "This NBA Basketball player is commonly known as 'The King'.";
	questions [3] [1] = "The national football team with the most World Cup wins.";
	questions [4] [1] = "The name of the Trophy presented to the winner of the NHL playofs";
	questions [5] [1] = "The height of an official NBA Basketball Hoop";

	questions [0] [2] = "History";
	questions [1] [2] = "Canada's First Prime Minister";
	questions [2] [2] = "This woman is feautured on the Canadian 20 dollar bill.";
	questions [3] [2] = "This term was used to descrive the severe economic hardships of the 1930's";
	questions [4] [2] = "Canada's newest province as of 2018.";
	questions [5] [2] = "What Canadian city was severely damaged by a massive expolision in its' harbor in 1917.";

	questions [0] [3] = "Science";
	questions [1] [3] = "Periodic Table symbol for Potassium";
	questions [2] [3] = "The chemical responsible for making plants green.";
	questions [3] [3] = "This lifeform is not considered as living.";
	questions [4] [3] = "This process is known as Cell Division.";
	questions [5] [3] = "This famous physician suffered from a nervous disease known as ALS.";

	questions [0] [4] = "Technology";
	questions [1] [4] = "In 2004, this young man created Facebook in his basement.";
	questions [2] [4] = "This self-made entrepreneur is credited with the first ";
	questions [3] [4] = "This scientist was credited with inventing the lightbulb.";
	questions [4] [4] = "Common acronym that stands for Operating System.";
	questions [5] [4] = "The city of the Main Office of Google";

	questions [0] [5] = "War";
	questions [1] [5] = "The year in which WWI began.";
	questions [2] [5] = "A war that involved the American military in the 1950's";
	questions [3] [5] = "This country held a famous war commonly known as 'The Six Days' War'.";
	questions [4] [5] = "Canadians landed on this beach on D-Day 1944";
	questions [5] [5] = "This president started the so-called 'War on Drugs'.";

	questions [0] [6] = "TV Shows";
	questions [1] [6] = "The breed of Scooby-Doo";
	questions [2] [6] = "Longest Running TV Series";
	questions [3] [6] = "Acronym of the television network owned and operated by the host of the 'Oprah Winfrey Show'.";
	questions [4] [6] = "Actor who plays NBC's Michael Scott from 'The Office'.";
	questions [5] [6] = "This TV Show was created and executively produced by Seth McFarlane.";

	questions [0] [7] = "Films";
	questions [1] [7] = "Highest Grossing Movie as of (2017)";
	questions [2] [7] = "This film feautured a fight to the death between teenagers in a dystopian future.";
	questions [3] [7] = "This day-time TV host was the voice actor for Dory in 'Finding Nemo' and 'FInding Dory'.";
	questions [4] [7] = "This film feautured a juvenile delinquent camp in which teenage boys were tasked with digging holes.";
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



	c.setColor (purple);
	c.fillRect (0, 0, 1024, 768);
	c.setColor (gold);
	c.setFont (new Font ("Gyparody", Font.BOLD, 50));
	c.drawString ("Jeopardy", 400, 50);
	drawJeopardyBox ();
	c.setColor (paper);
	c.fillRect (50, 590, 904, 168);

	while (true)
	{
	    c.setFont (new Font ("Gyparody", 1, 26));
	    c.setColor (purple);
	    c.fillRect (20, 35, 200, 35);
	    c.fillRect (800, 35, 200, 35);
	    c.setColor (paper);
	    c.drawString (user1, 20, 30);
	    c.drawString (("Score: $" + (score1)), 20, 55);
	    c.drawString (user2, 800, 30);
	    c.drawString (("Score: $" + (score2)), 800, 55);


	    user1turn = userTurn (user1turn);
	    c.setColor (cobalt);
	    c.fillRect (160 + ((colNum - 1) * 140), 90 + (rowChoice * 80), 135, 75);
	    c.setColor (paper);
	    c.fillRect (50, 590, 904, 168);
	}

    }


    public void level2 ()
    {
	questions [0] [10] = "Art";
	questions [1] [10] = "";
	questions [2] [10] = "";
	questions [3] [10] = "";
	questions [4] [10] = "";
	questions [5] [10] = "";
    }


    static public int randomNum (int min, int max)
    {
	int range = (max - min) + 1;
	return (int) (Math.random () * range) + min;
    }


    public void drawJeopardyBox ()
    {

	c.setColor (cobalt);
	c.fillRect (150, 80, 710, 500);
	c.setColor (Color.black);


	for (int xcor = 0 ; xcor <= 580 ; xcor += 140)
	{
	    c.setColor (paper);
	    c.setFont (new Font ("Gyparody", 1, 20));
	    c.drawString ("1", 220, 110);
	    c.drawString ("2", 360, 110);
	    c.drawString ("3", 500, 110);
	    c.drawString ("4", 640, 110);
	    c.drawString ("5", 780, 110);
	    c.setFont (new Font ("Gyparody", 1, 16));
	    c.drawString (questions [0] [col1], 170, 140);
	    c.drawString (questions [0] [col2], 310, 140);
	    c.drawString (questions [0] [col3], 450, 140);
	    c.drawString (questions [0] [col4], 590, 140);
	    c.drawString (questions [0] [col5], 730, 140);
	    c.setColor (gold);
	    c.setFont (new Font ("Gyparody", Font.BOLD, 20));
	    c.drawString ("$100", 200 + xcor, 210);
	    c.drawString ("$200", 200 + xcor, 290);
	    c.drawString ("$300", 200 + xcor, 370);
	    c.drawString ("$400", 200 + xcor, 450);
	    c.drawString ("$500", 200 + xcor, 530);
	    for (int ycor = 0 ; ycor <= 470 ; ycor += 80)
	    {
		c.setColor (Color.black);
		c.drawRect (160 + xcor, 90 + ycor, 130, 70);
	    }
	}
    }


    public boolean userTurn (boolean user1turn)
    {
	c.setColor (Color.black);
	c.setFont (new Font ("Gyparody", 1, 15));
	if (user1turn == true)
	{
	    c.drawString ((user1 + ", please enter category number: "), 100, 635);
	    while (true)
	    {
		try
		{
		    while (colChoice < 1 || 5 < colChoice)
		    {
			c.setColor (Color.black);
			c.setCursor (32, 44 + (user1.length ()));
			String numstr = c.readLine ();
			colChoice = Integer.parseInt (numstr);
			if (colChoice < 1 || 5 < colChoice)
			{
			    new Message ("Please enter valid integer input between 1 and 5.");
			    c.setColor (paper);
			    c.fillRect (380, 615, 574, 138);
			    c.setColor (purple);
			    c.fillRect (954, 595, 200, 400);
			}
		    }
		    break;
		}

		catch (NumberFormatException e)
		{
		    new Message ("Please enter valid integer input between 1 and 5.");
		    c.setColor (paper);
		    c.fillRect (380, 615, 574, 138);
		    c.setColor (purple);
		    c.fillRect (954, 595, 200, 400);
		}
	    }


	    colNum = colChoice;
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
	    c.drawString ((questions [0] [colChoice] + ", for how much: "), 100, 655);
	    c.setCursor (33, 29 + (questions [0] [colChoice]).length ());
	    c.setColor (Color.black);
	    while (true)
	    {
		try
		{
		    while (rowChoice < 1 || 5 < rowChoice)
		    {
			c.setColor (Color.black);
			c.setCursor (33, 29 + (questions [0] [colChoice]).length ());
			String numstr = c.readLine ();
			rowChoice = Integer.parseInt (numstr) / 100;
			if (rowChoice < 1 || 5 < rowChoice)
			{
			    new Message ("Please enter valid integer values of 100, 200, 300, 400 and 500.");
			    c.setColor (paper);
			    c.fillRect (285, 635, 669, 138);
			    c.setColor (purple);
			    c.fillRect (954, 595, 200, 400);
			}
		    }
		    break;
		}

		catch (NumberFormatException e)
		{
		    new Message ("Please enter valid integer integer values of 100, 200, 300, 400 and 500.");
		    c.setColor (paper);
		    c.fillRect (285, 635, 669, 138);
		    c.setColor (purple);
		    c.fillRect (954, 595, 200, 400);
		}
	    }
	    displayQuestion (colChoice, rowChoice);
	    c.setColor (Color.black);
	    c.setFont (new Font ("Gyparody", 1, 15));
	    c.drawString ((user1 + ", please answer: "), 100, 675);
	    c.setCursor (34, 30 + (user1.length ()));
	    c.setColor (Color.black);
	    answer = c.readLine ();
	    eraseInput ();
	    if (answer.equals (answers [rowChoice] [colChoice]))
	    {
		score1 += rowChoice * 100;
		return true;
	    }
	    else
	    {
		score1 -= rowChoice * 100;
		return false;
	    }
	}




	else
	{


	    c.drawString ((user2 + ", please enter category number: "), 100, 635);
	    while (true)
	    {
		try
		{
		    while (colChoice < 1 || 5 < colChoice)
		    {
			c.setColor (Color.black);
			c.setCursor (32, 44 + (user2.length ()));
			String numstr = c.readLine ();
			colChoice = Integer.parseInt (numstr);
			if (colChoice < 1 || 5 < colChoice)
			{
			    new Message ("Please enter valid integer input between 1 and 5.");
			    c.setColor (paper);
			    c.fillRect (380, 615, 574, 138);
			    c.setColor (purple);
			    c.fillRect (954, 595, 200, 400);
			}
		    }
		    break;
		}

		catch (NumberFormatException e)
		{
		    new Message ("Please enter valid integer input between 1 and 5.");
		    c.setColor (paper);
		    c.fillRect (380, 615, 574, 138);
		    c.setColor (purple);
		    c.fillRect (954, 595, 200, 400);
		}
	    }


	    colNum = colChoice;
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
	    c.drawString ((questions [0] [colChoice] + ", for how much: "), 100, 655);
	    c.setCursor (33, 29 + (questions [0] [colChoice]).length ());
	    c.setColor (Color.black);
	    while (true)
	    {
		try
		{
		    while (rowChoice < 1 || 5 < rowChoice)
		    {
			c.setColor (Color.black);
			c.setCursor (33, 29 + (questions [0] [colChoice]).length ());
			String numstr = c.readLine ();
			rowChoice = Integer.parseInt (numstr) / 100;
			if (rowChoice < 1 || 5 < rowChoice)
			{
			    new Message ("Please enter valid integer values of 100, 200, 300, 400 and 500.");
			    c.setColor (paper);
			    c.fillRect (285, 635, 669, 138);
			    c.setColor (purple);
			    c.fillRect (954, 595, 200, 400);
			}
		    }
		    break;
		}

		catch (NumberFormatException e)
		{
		    new Message ("Please enter valid integer integer values of 100, 200, 300, 400 and 500.");
		    c.setColor (paper);
		    c.fillRect (285, 635, 669, 138);
		    c.setColor (purple);
		    c.fillRect (954, 595, 200, 400);
		}
	    }
	    displayQuestion (colChoice, rowChoice);
	    c.setColor (Color.black);
	    c.setFont (new Font ("Gyparody", 1, 15));
	    c.drawString ((user2 + ", please answer: "), 100, 675);
	    c.setCursor (34, 30 + (user2.length ()));
	    c.setColor (Color.black);
	    answer = c.readLine ();
	    eraseInput ();
	    if (answer.equals (answers [rowChoice] [colChoice]))
	    {
		score2 += rowChoice * 100;
		return false;
	    }
	    else
	    {
		score2 -= rowChoice * 100;
		return true;
	    }
	}
    }





    public void displayQuestion (int colChoice, int rowChoice)
    {
	eraseInput ();
	c.fillRect (954, 595, 200, 300);
	c.setColor (cobalt);
	c.setFont (new Font ("Gyparody", 1, 20));
	c.drawString (questions [rowChoice] [colChoice], 100, 615);
    }


    public void eraseInput ()
    {
	c.setColor (paper);
	c.fillRect (100, 595, 854, 138);
	c.setColor (purple);
	c.fillRect (954, 595, 200, 400);
    }


    public Jeopardy ()
    {

	c = new Console (35, 125, "Jeopardy!");

    }


    public static void main (String[] args)
    {
	Jeopardy j = new Jeopardy ();
	j.level1 ();
    } // main method
} // Jeopardy class


