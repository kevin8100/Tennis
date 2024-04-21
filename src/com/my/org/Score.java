package com.my.org;

enum Score {
    ZERO(0), QUINZE(15), TRENTE(30), QUARANTE(40), ADVANTAGE(99), GAME(100);

    private final int value;

    Score(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public String toString() {
	return String.valueOf(this.value);
    }

}
