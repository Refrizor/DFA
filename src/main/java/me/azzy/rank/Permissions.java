package me.azzy.rank;

public enum Permissions {
    FLIGHT("FLIGHT");

    private final String permission;

    Permissions(String permission){
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
