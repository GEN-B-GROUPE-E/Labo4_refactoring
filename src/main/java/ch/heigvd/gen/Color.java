package ch.heigvd.gen;

public enum Color {
    BLUE("blue"),
    RED("red"),
    YELLOW("yellow");

    private String displayColor;
    Color(String displayColor){
        this.displayColor = displayColor;
    }

    @Override
    public String toString() {
        return displayColor;
    }
}
