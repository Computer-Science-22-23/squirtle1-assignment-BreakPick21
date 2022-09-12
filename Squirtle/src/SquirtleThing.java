public class SquirtleThing extends PokeThing {

	int squaresMoved = 0;
	
	/**
	 * SquirtleThing Constructor
	 * Creates a new <code>SquirtleThing</code> object.
	 * Associated graphics file will be squirtle.png
	 */
	public SquirtleThing()
	{
		super("Squirtle", "", 0);	
		setImageFileType(IMAGETYPE_PNG);
	}
	
	
	/**
	 * step method -- this method is called over and over
	 * <code>SquirtleThing</code> moves in a pattern and prints how far it has gone
	 */	
	public void step()
	{
		movementPattern();
		
		Gui g = getBoard().getGui();
		g.appendTextWindow("Squirtle has moved " + squaresMoved + " squares.");
	}
	
	
	/**
	 * movement in a repeating pattern
	 * <code>SquirtleThing</code> turns right if it is blocked or encounters a wall
	 */	
	public void movementPattern()
	{
		Board b = getBoard();
		// Check the 'next' Location.  If there is a PokeThing or wall there, turn.
		boolean blocked;
		boolean stuck;
		boolean flower;
		
		Location nextLoc = getDirection().getNextLocation(getLocation()); 
		blocked = getBoard().thingAt(nextLoc) instanceof PokeThing;
		stuck = !(nextLoc.isValid(getBoard()));
		flower = getBoard().thingAt(nextLoc) instanceof FlowerThing;
		if (blocked)
		{
			setDirection(getDirection().left());
			Gui g = getBoard().getGui();
			g.appendTextWindow("Squirtle sees a bulbasaur!");
		}
		if (stuck)
		{
			setDirection(getDirection().left());
		}
		if (flower)
		{
			FlowerThing f = (FlowerThing) b.thingAt(nextLoc);
			b.remove(f); 
		}
		move();
		squaresMoved += 1; //updates the # value of squares SquirtleThing travels by 1
	}
}
