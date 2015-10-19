package com.laddermaster.game.elements;

/**
 * Represents a Ladder in the SnakeLadder game.
 * Ladder's purpose - It's a good luck charm. 
 * When a player moves to any of the Ladder's bottom position, he is meant to climb the ladder and move to top position of the ladder.
 *  
 * @author Sameer Bhilare
 *
 */
public class Ladder {

	private int bottomPosition = -1;
	private int topPosition = -1;
	
	public int getBottomPosition() {
		return bottomPosition;
	}
	public void setBottomPosition(int bottomPosition) {
		this.bottomPosition = bottomPosition;
	}
	public int getTopPosition() {
		return topPosition;
	}
	public void setTopPosition(int topPosition) {
		this.topPosition = topPosition;
	}
	
	@Override
	public String toString() {
		
		return " Ladder (bottom = "+bottomPosition+", top = "+topPosition+") ";
	}
	
}
