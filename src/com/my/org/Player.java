package com.my.org;

public class Player {

    private String name;
    private Score score;

    public Player(String name) {
        this.name = name;
        this.score = Score.ZERO;
    }

    public String getName() {
        return name;
    }

    public Score getScore() {
        return score;
    }

    public void scorePoint() {
        if (score.ordinal() < Score.QUARANTE.ordinal())
            score = Score.values()[score.ordinal() + 1];
        else
            throw new IllegalStateException("Cannot increase score beyond " + Score.QUARANTE);
    }
    
    public void advantage() {
        if (score == Score.QUARANTE)
            score = Score.ADVANTAGE;
        else
	    throw new IllegalStateException("Cannot increase score beyond " + score);
    }
    
    public void deuce() {
	if (score == Score.ADVANTAGE)
	    score = Score.QUARANTE;
	else
	    throw new IllegalStateException("Cannot decrease score below " + score);
    }

    public void game() {
	score = Score.GAME;
    }

}
