public class BulbasaurThing extends PokeThing {

	/**
	 * Creates a new <code>BulbasaurThing</code> object.
	 * Associated graphics file will be bulbasaur.gif
	 */
	public BulbasaurThing()
	{
		super("Bulbasaur", "", 0);	
	}
	
	
	/**
	 * Place a <code>FlowerThing</code> at the <code>BulbasaurThing</code>'s current <code>Location</code>
	 * The <code>FlowerThing</code> will be placed under the <code>BulbasaurThing</code>
	 */
	public void putFlower()
	{
		FlowerThing k = new FlowerThing();
		getBoard().addUnder(k, getLocation());
	}
	
	
	/**
	 * Step function to define the <code>BulbasaurThing</code>'s behavior
	 * <code>BulbasaurThing</code> places a <code>FlowerThing</code> in the current spot and moves
	 */	
	public void step()
	{
		putFlower();
		move();
		movementPattern();
	}
	
	/**
	 * Behavior to occur when the Thing has been clicked on
	 */
	public void mouseClick() 
	{
		Gui g = getBoard().getGui();
		g.appendTextWindow("Bulbasaur has been tickled.");
	}

public void movementPattern()
{
	// Check the 'next' Location.  If there is a PokeThing or wall there, turn.
	boolean blocked;
	boolean stuck;
		
	Location nextLoc = getDirection().getNextLocation(getLocation()); 
	stuck = !(nextLoc.isValid(getBoard()));
	if (stuck)
	{
		setDirection(getDirection().left());
	}
}
}