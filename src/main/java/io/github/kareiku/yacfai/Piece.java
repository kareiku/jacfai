package io.github.kareiku.yacfai;

public enum Piece {
    NONE("🟡"),
    RED("🔴"),
    BLUE("🔵");

    private final String icon;

    Piece(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return this.icon;
    }
}
