package me.azzy.utils;

public enum ColorPalette {

    GOLD("#ffaa00"),
    GREEN("#55ff55"),
    GREEN_DARK("#00aa00"),
    GREEN_DARK2("#00aa00"),
    LIME("#aaff55"),
    SKY("#55aaff"),
    TEAL("#2affaa"),
    AQUA("#2ad4d4"),
    AQUA_LIGHT("#55ffff"),
    AQUA_DARK("#00aaaa"),
    AQUA_DARK_3("#00aaaa"),
    GRAY_DARK("#555555"),
    MAGENTA_DARK("#aa00aa"),
    GRAY("#808080"),
    GRAY_LIGHT("#aaaaaa"),
    GRAY_LIGHT2("#d4d4d4"),
    RED_DARK("#aa0000"),
    BROWN_DARK("#ffaa00"),
    ORANGE("#ff5500"),
    RED("#ff0000"),
    BLACK("#000000"),
    ROSE("#FF7FAA"),

    HEADER("#71ffe0");



    private final String code;

    ColorPalette(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
