package com.laddermaster.game.elements;

/**
 * Represents a Snake in the SnakeLadder game.
 * Snake's purpose - It's a bad luck. 
 * When a player moves to any of the Snake's head position, he will be eaten by the snake and will move to tail position of the snake.
 *  
 * @author Sameer Bhilare
 *
 */
public class Snake {

	private int headPosition = -1;
	private int tailposition = -1;
	
	public int getHeadPosition() {
		return headPosition;
	}
	public void setHeadPosition(int headPosition) {
		this.headPosition = headPosition;
	}
	public int getTailposition() {
		return tailposition;
	}
	public void setTailposition(int tailposition) {
		this.tailposition = tailposition;
	}
	
	@Override
	public String toString() {
		
		return " Snake (Head = "+headPosition+", Tail = "+tailposition+") ";
	}
}
