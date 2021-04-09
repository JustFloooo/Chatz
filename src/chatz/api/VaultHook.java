package chatz.api;

import chatz.Main;
import net.milkbowl.vault.chat.Chat;
import org.bukkit.entity.Player;

public class VaultHook {

    private static final Chat chat = Main.getChat();

    public static String getPrimaryGroup(Player p) {
        return chat.getPrimaryGroup(p).contains("vip") ? "vip" : chat.getPrimaryGroup(p);
    }

    public static String getSuffix(Player p) {
        return chat.getPlayerSuffix(p);
    }

    public static String getPrefix(Player p) {
        return chat.getPlayerPrefix(p);
    }

}
