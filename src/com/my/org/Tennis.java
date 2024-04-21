package com.my.org;

import java.util.Scanner;

public class Tennis {

    public static void main(String[] args) {
	Player playerA = new Player("A");
	Player playerB = new Player("B");

	try (// Scanner definition
		Scanner scn = new Scanner(System.in)) {
	    String input = scn.next();

	    // print the input
	    System.out.println(String.format("Match input: %s", input));

	    // Loop through the input
	    for (int i = 0; i < input.length(); i++) {
		if (input.charAt(i) == 'A') {
		    if (playerA.getScore().ordinal() < Score.QUARANTE.ordinal()) {
			playerA.scorePoint();
		    } else if (playerA.getScore() == Score.QUARANTE && playerB.getScore() == Score.ADVANTAGE) {
			playerB.deuce();
		    } else if (playerA.getScore() == Score.ADVANTAGE && playerB.getScore() == Score.QUARANTE
			    || playerA.getScore() == Score.QUARANTE && playerB.getScore().ordinal() < Score.QUARANTE.ordinal()) {
			playerA.game();
		    } else if (playerA.getScore() == Score.QUARANTE && playerB.getScore() == Score.QUARANTE) {
			playerA.advantage();
		    } else {
			throw new IllegalArgumentException("unexpected error at position " + i + " in input string");
		    }
		} else if (input.charAt(i) == 'B') {
		    if (playerB.getScore().ordinal() < Score.QUARANTE.ordinal()) {
			playerB.scorePoint();
		    } else if (playerB.getScore() == Score.QUARANTE && playerA.getScore() == Score.ADVANTAGE) {
			playerA.deuce();
		    } else if (playerB.getScore() == Score.ADVANTAGE && playerA.getScore() == Score.QUARANTE
			    || playerB.getScore() == Score.QUARANTE && playerA.getScore().ordinal() < Score.QUARANTE.ordinal()) {
			playerB.game();
		    } else if (playerB.getScore() == Score.QUARANTE && playerA.getScore() == Score.QUARANTE) {
			playerB.advantage();
		    } else {
			throw new IllegalArgumentException("unexpected error at position " + i + " in input string");
		    }
		} else {
		    System.out.println(
			    String.format("unknown player %s at position %s in input string. Ignore !", input.charAt(i), i));
		}
		System.out.println(getScore(playerA, playerB));
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }


    private static String getScore(Player playerA, Player playerB) {

	if (Score.GAME == playerA.getScore() || Score.GAME == playerB.getScore()) {
	    return String.format("Player %s wins the game",
		    Score.GAME == playerA.getScore() ? playerA.getName() : playerB.getName());
	}

	if (playerA.getScore().ordinal() >= Score.QUARANTE.ordinal()
		&& playerB.getScore().ordinal() >= Score.QUARANTE.ordinal()) {
	    if (playerA.getScore() == playerB.getScore()) {
		return "Deuce";
	    } else if (playerA.getScore().ordinal() == playerB.getScore().ordinal() + 1) {
		return String.format("Advantage %s", playerA.getName());
	    } else if (playerB.getScore().ordinal() == playerA.getScore().ordinal() + 1) {
		return String.format("Advantage %s", playerB.getName());
	    }
	}

	return String.format("Player %s : %s / Player %s : %s",
		playerA.getName(), playerA.getScore(), playerB.getName(), playerB.getScore());
    }
}
