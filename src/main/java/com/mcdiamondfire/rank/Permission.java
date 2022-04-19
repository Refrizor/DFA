package com.mcdiamondfire.rank;

import com.mcdiamondfire.DiamondFire;
import com.mcdiamondfire.PlayerData;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

public class Permission {

    public PermissionAttachment permissionAttachment;

    public void deployPermissions(Player player) {
        permissionAttachment = player.addAttachment(DiamondFire.getInstance());

        int events = PlayerData.getBranchID(Branch.EVENTS, player);
        int admin = PlayerData.getBranchID(Branch.ADMINISTRATION, player);
        int moderation = PlayerData.getBranchID(Branch.MODERATION, player);
        int support = PlayerData.getBranchID(Branch.SUPPORT, player);
        int donor = PlayerData.getBranchID(Branch.DONOR, player);
        int youtuber = PlayerData.getBranchID(Branch.YOUTUBER, player);

        switch(admin){
            case 2:
                permissionAttachment.setPermission(Permissions.FLIGHT.getPermission(), true);
                break;
        }

        switch (donor){
            case 4:
            case 3:
            case 2:
                permissionAttachment.setPermission(Permissions.FLIGHT.getPermission(), true);
                break;
            case 1:
                permissionAttachment.setPermission(Permissions.FLIGHT.getPermission(), false);
                break;

        }
    }
}