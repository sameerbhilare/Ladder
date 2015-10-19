package com.laddermaster.game.elements;

/**
 * Represents the Dice for the Game board.
 * 
 * @author Sameer Bhilare
 *
 */
public class Dice {

	public static final int NUMBER_OF_DICE_FACES = 6;
	
	/**
	 * This method returns a RANDOM number between 1 to 6 (both inclusive).
	 * Sequence of the generated number is not guaranteed.
	 * 
	 * @return
	 */
	public int rollDice(){
		return ((int)(Math.random()*10) % NUMBER_OF_DICE_FACES ) + 1;
	}
	
}
