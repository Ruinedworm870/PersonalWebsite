/**
 * Linked list to keep track of the names and high scores
 */

package com.example.smolinskiw_program12;

public class HighScoreList
{
    public String name;
    public int highScore;
    public HighScoreList next;
    public HighScoreList prev;

    /**
     * Constructor to create an unattached node
     * @param name Name of the player
     * @param highScore High score of the player
     */
    HighScoreList(String name, int highScore)
    {
        this.name = name;
        this.highScore = highScore;
        this.next = null;
        this.prev = null;
    }
}
