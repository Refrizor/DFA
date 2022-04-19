package com.mcdiamondfire.rank;

import com.mcdiamondfire.utils.ColorHelper;
import com.mcdiamondfire.utils.ColorPalette;

public enum Prefixes {

    OWNER(ColorHelper.translate(ColorPalette.BLACK.getCode()) + "[" + ColorHelper.translate(ColorPalette.RED.getCode()) + "Owner" + ColorHelper.translate(ColorPalette.BLACK.getCode()) + "]",
            ColorHelper.translate(ColorPalette.BLACK.getCode()) + "[" + ColorHelper.translate(ColorPalette.RED.getCode()) + "◆" + ColorHelper.translate(ColorPalette.BLACK.getCode()) + "]"),

    ADMIN(ColorHelper.translate(ColorPalette.GRAY_DARK.getCode()) + "[" + ColorHelper.translate(ColorPalette.RED.getCode()) + "Admin" + ColorHelper.translate(ColorPalette.GRAY_DARK.getCode()) + "]",
            ColorHelper.translate(ColorPalette.GRAY_DARK.getCode()) + "[" + ColorHelper.translate(ColorPalette.RED.getCode()) + "A" + ColorHelper.translate(ColorPalette.GRAY_DARK.getCode()) + "]"),

    DEV(ColorHelper.translate(ColorPalette.GRAY_DARK.getCode()) + "[" + ColorHelper.translate(ColorPalette.ORANGE.getCode()) + "Dev" + ColorHelper.translate(ColorPalette.GRAY_DARK.getCode()) + "]",
            ColorHelper.translate(ColorPalette.GRAY_DARK.getCode()) + "[" + ColorHelper.translate(ColorPalette.ORANGE.getCode()) + "D" + ColorHelper.translate(ColorPalette.GRAY_DARK.getCode()) + "]"),

    SRMOD(ColorHelper.translate(ColorPalette.GRAY.getCode()) + "[" + ColorHelper.translate(ColorPalette.LIME.getCode()) + "SrMod" + ColorHelper.translate(ColorPalette.GRAY.getCode()) + "]",
            ColorHelper.translate(ColorPalette.GRAY.getCode()) + "[" + ColorHelper.translate(ColorPalette.LIME.getCode()) + "SrM" + ColorHelper.translate(ColorPalette.GRAY.getCode()) + "]"),

    MOD(ColorHelper.translate(ColorPalette.GRAY_LIGHT.getCode()) + "[" + ColorHelper.translate(ColorPalette.GREEN.getCode()) + "Mod" + ColorHelper.translate(ColorPalette.GRAY_LIGHT.getCode()) + "]",
            ColorHelper.translate(ColorPalette.GRAY_LIGHT.getCode()) + "[" + ColorHelper.translate(ColorPalette.GREEN.getCode()) + "M" + ColorHelper.translate(ColorPalette.GRAY_LIGHT.getCode()) + "]"),

    JRMOD(ColorHelper.translate(ColorPalette.GRAY_LIGHT.getCode()) + "[" + ColorHelper.translate(ColorPalette.GREEN_DARK.getCode()) + "JrMod" + ColorHelper.translate(ColorPalette.GRAY_LIGHT.getCode()) + "]",
            ColorHelper.translate(ColorPalette.GRAY_LIGHT.getCode()) + "[" + ColorHelper.translate(ColorPalette.GREEN_DARK.getCode()) + "JrM" + ColorHelper.translate(ColorPalette.GRAY_LIGHT.getCode()) + "]"),

    SRHELPER(ColorHelper.translate(ColorPalette.GRAY.getCode()) + "[" + ColorHelper.translate(ColorPalette.TEAL.getCode()) + "SrHelper" + ColorHelper.translate(ColorPalette.GRAY.getCode()) + "]",
            ColorHelper.translate(ColorPalette.GRAY.getCode()) + "[" + ColorHelper.translate(ColorPalette.TEAL.getCode()) + "SrH" + ColorHelper.translate(ColorPalette.GRAY.getCode()) + "]"),

    HELPER(ColorHelper.translate(ColorPalette.GRAY_LIGHT.getCode()) + "[" + ColorHelper.translate(ColorPalette.AQUA_LIGHT.getCode()) + "Helper" + ColorHelper.translate(ColorPalette.GRAY_LIGHT.getCode()) + "]",
            ColorHelper.translate(ColorPalette.GRAY_LIGHT.getCode()) + "[" + ColorHelper.translate(ColorPalette.AQUA_LIGHT.getCode()) + "H" + ColorHelper.translate(ColorPalette.GRAY_LIGHT.getCode()) + "]"),

    JRHELPER(ColorHelper.translate(ColorPalette.GRAY_LIGHT.getCode()) + "[" + ColorHelper.translate(ColorPalette.SKY.getCode()) + "JrHelper" + ColorHelper.translate(ColorPalette.GRAY_LIGHT.getCode()) + "]",
            ColorHelper.translate(ColorPalette.GRAY_LIGHT.getCode()) + "[" + ColorHelper.translate(ColorPalette.SKY.getCode()) + "JrH" + ColorHelper.translate(ColorPalette.GRAY_LIGHT.getCode()) + "]"),

    OVERLORD(ColorHelper.translate(ColorPalette.AQUA_DARK.getCode()) + "[" + ColorHelper.translate(ColorPalette.GRAY_LIGHT.getCode()) + "◆" + ColorHelper.translate(ColorPalette.RED_DARK.getCode()) + "Overlord" + ColorHelper.translate(ColorPalette.GRAY_LIGHT.getCode()) + "◆" + ColorHelper.translate(ColorPalette.AQUA_DARK.getCode()) + "]",
            ColorHelper.translate(ColorPalette.AQUA_DARK.getCode()) + "[" + ColorHelper.translate(ColorPalette.RED_DARK.getCode()) + "O" + ColorHelper.translate(ColorPalette.AQUA_DARK.getCode()) + "]"),

    MYTHIC(ColorHelper.translate(ColorPalette.GRAY_DARK.getCode()) + "[" + ColorHelper.translate(ColorPalette.MAGENTA_DARK.getCode()) + "Mythic" + ColorHelper.translate(ColorPalette.GRAY_DARK.getCode()) + "]",
            ColorHelper.translate(ColorPalette.GRAY_DARK.getCode()) + "[" + ColorHelper.translate(ColorPalette.MAGENTA_DARK.getCode()) + "M" + ColorHelper.translate(ColorPalette.GRAY_DARK.getCode()) + "]"),

    EMPEROR(ColorHelper.translate(ColorPalette.GREEN_DARK.getCode()) + "[" + ColorHelper.translate(ColorPalette.AQUA_LIGHT.getCode()) + "Emperor" + ColorHelper.translate(ColorPalette.GREEN_DARK.getCode()) + "]",
            ColorHelper.translate(ColorPalette.GREEN_DARK.getCode()) + "[" + ColorHelper.translate(ColorPalette.AQUA_LIGHT.getCode()) + "E" + ColorHelper.translate(ColorPalette.GREEN_DARK.getCode()) + "]"),

    NOBLE(ColorHelper.translate(ColorPalette.GOLD.getCode()) + "[" + ColorHelper.translate(ColorPalette.GREEN.getCode()) + "Noble" + ColorHelper.translate(ColorPalette.GOLD.getCode()) + "]",
            ColorHelper.translate(ColorPalette.GOLD.getCode()) + "[" + ColorHelper.translate(ColorPalette.GREEN.getCode()) + "N" + ColorHelper.translate(ColorPalette.GOLD.getCode()) + "]"),

    YOUTUBER(ColorHelper.translate(ColorPalette.RED_DARK.getCode()) + "[" + ColorHelper.translate(ColorPalette.GRAY_LIGHT2.getCode()) + "YouTuber" + ColorHelper.translate(ColorPalette.RED_DARK.getCode()) + "]",
            ColorHelper.translate(ColorPalette.RED_DARK.getCode()) + "[" + ColorHelper.translate(ColorPalette.GRAY_LIGHT2.getCode()) + "YT" + ColorHelper.translate(ColorPalette.RED_DARK.getCode()) + "]");

    private final String tag;
    private final String shortTag;

    Prefixes(String tag, String shortTag){
        this.tag = tag;
        this.shortTag = shortTag;
    }

    public String getTag() {
        return tag;
    }

    public String getShortTag() {
        return shortTag;
    }
}