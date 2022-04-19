package com.mcdiamondfire.server;

public class Patchnotes {

    static String[] latest = {
            Patch.HEADER.getType() + Patch.LATEST.getType(),
            Patch.RELEASE.getType() + "?/?/2021",
            "\n",
            Patch.IMPORTANT.getType() + Patch.MAIN_COLOR.getType() + "Rank system & synchronization, permissions, the lobby, and much more has been complete.",
            "\n",
            Patch.ADD.getType() + Patch.MAIN_COLOR.getType() + "Sphere Battles is in development!",
            Patch.ADD.getType() + Patch.MAIN_COLOR.getType() + "User server badges are done",
            Patch.ADD.getType() + Patch.MAIN_COLOR.getType() + "Profile added. Will contain things like SB stats!\n",
            Patch.ADD.getType() + Patch.MAIN_COLOR.getType() + "Rank formatting has been reworked. More optimized & modular!",
            Patch.ADD.getType() + Patch.MAIN_COLOR.getType() + "Scoreboards have also been reworked. We now use instances per player allowing for flexibility.",
            "\n",
            Patch.FIX.getType() + Patch.MAIN_COLOR.getType() + "Fixed an issue with unregistered teams trying to be used",
            Patch.FIX.getType() + Patch.MAIN_COLOR.getType() + "Fixed an SB timer-related issue under one of the repeated tasks",
            Patch.FIX.getType() + Patch.MAIN_COLOR.getType() + "Organized lots of the infrastructure for it to be more modular",
    };

    public static String[] getLatest(){
        return latest;
    }
}
