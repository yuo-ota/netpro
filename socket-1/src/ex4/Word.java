package ex4;

import java.io.Serializable;

public class Word implements Serializable {
    String targetWord;

    public Word(String targetWord) {
        this.targetWord = targetWord;
    }

    public Word() {
        targetWord = "ばなな";
    }

    public String getWord() {
        return targetWord;
    }
}
