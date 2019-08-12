package homework903;

public class Chars {
    private char ch;
    private int frequency;

    public Chars(char ch, int frequency) {
        super();
        this.ch = ch;
        this.frequency = frequency;
    }

    public Chars() {
        super();
    }

    public char getCh() {
        return ch;
    }

    public void setCh(char ch) {
        this.ch = ch;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "Chars{" +
                "ch=" + ch +
                ", frequency=" + frequency +
                '}';
    }
}
