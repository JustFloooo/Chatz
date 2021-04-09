package chatz.tablist;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class TabTitle {

    public TabTitle() {}

    public static void sendTabTitle(Player player, String header, String footer) {
        if (header == null) {
            header = "";
        }
        header = ChatColor.translateAlternateColorCodes('&', header);

        if (footer == null) {
            footer = "";
        }
        footer = ChatColor.translateAlternateColorCodes('&',footer);

        try {
            Object cbt;
            try {
                Object tabHeader = Packets.getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, "{\"text\":\"" + header + "\"}");
                cbt = Packets.getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, "{\"text\":\"" + footer + "\"}");
                Constructor<?> titleConstructor = Packets.getNMSClass("PacketPlayOutPlayerListHeaderFooter").getConstructor();
                Object packet = titleConstructor.newInstance();

                Field aField;
                aField = packet.getClass().getDeclaredField("header");
                aField.setAccessible(true);
                aField.set(packet, tabHeader);

                Field bField;
                bField = packet.getClass().getDeclaredField("footer");
                bField.setAccessible(true);
                bField.set(packet, cbt);

                Packets.sendPacket(player, packet);

            } catch (Throwable ex) {
                cbt = new CBTabPacket();
                ((CBTabPacket) cbt).sendTab(player, header, footer);
            }
        } catch (Throwable ex) {
            ex.printStackTrace();
        }

    }
}
