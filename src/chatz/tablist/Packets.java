package chatz.tablist;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Packets {
    private static final String version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];

    public Packets() {
    }

    public static Class<?> getNMSClass(String name) {
        try {
            return Class.forName("net.minecraft.server." + version + "." + name);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static void sendPacket(Player player, Object packet) {
        try {
            Object playerHandle = player.getClass().getMethod("getHandle").invoke(player);
            Object playerConnection = playerHandle.getClass().getField("playerConnection").get(playerHandle);
            playerConnection.getClass().getMethod("sendPacket", Class.forName("net.minecraft.server." + version + "." + "Packet")).invoke(playerConnection, packet);
        } catch (Throwable ex) {
            ex.printStackTrace();
        }

    }
}
