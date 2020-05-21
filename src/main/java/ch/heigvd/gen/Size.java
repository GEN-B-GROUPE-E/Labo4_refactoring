package ch.heigvd.gen;

public enum Size {
    XS("XS"),
    S("S"),
    M("M"),
    L("L"),
    XL("XL"),
    XXL("XXL"),
    NO_SIZE("Invalid Size");

    private String displaySize;
    Size(String displaySize){
        this.displaySize = displaySize;
    }

    @Override
    public String toString() {

        return "\""+displaySize+"\"";

    }
}
