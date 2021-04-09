package chatz.tablist;

import net.minecraft.server.v1_16_R3.IChatBaseComponent;
import net.minecraft.server.v1_16_R3.PacketPlayOutPlayerListHeaderFooter;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;

public class CBTabPacket {
    public CBTabPacket() {
    }

    public void sendTab(Player p, String header, String footer) {
        IChatBaseComponent tabHeader = IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + header + "\"}");
        PacketPlayOutPlayerListHeaderFooter headerPacket = new PacketPlayOutPlayerListHeaderFooter();
        try {
            Field field = headerPacket.getClass().getDeclaredField("a");
            field.setAccessible(true);
            field.set(headerPacket, tabHeader);
            field.setAccessible(false);
        } catch (Throwable ex) {
            ex.printStackTrace();
        } finally {
            Packets.sendPacket(p, headerPacket);
        }

        IChatBaseComponent tabFooter = IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + footer + "\"}");
        PacketPlayOutPlayerListHeaderFooter footerPacket = new PacketPlayOutPlayerListHeaderFooter();
        try{
            Field field = footerPacket.getClass().getDeclaredField("b");
            field.setAccessible(true);
            field.set(footerPacket, tabFooter);
            field.setAccessible(false);
        } catch (Throwable ex) {
            ex.printStackTrace();
        } finally {
            Packets.sendPacket(p, headerPacket);
        }

    }
}
