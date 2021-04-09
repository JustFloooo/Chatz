package chatz.chats;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.Map;

import static chatz.api.VaultHook.*;
import static chatz.res.Number.round;
import static chatz.Main.getMessageRange;
import static chatz.res.Colors.getNamecolor;

public class MessageFormatter {

    static ChatColor g = ChatColor.DARK_GRAY;
    static ChatColor w = ChatColor.WHITE;
    static final Map<String, ChatColor> namecolor = getNamecolor();

    public static String format(Player p){
        String primary = getPrimaryGroup(p);
        String prefix = ChatColor.translateAlternateColorCodes('&', getPrefix(p));
        String suffix = ChatColor.translateAlternateColorCodes('&', getSuffix(p));
        ChatColor c = namecolor.get(primary);
        return prefix + c + p.getDisplayName() + " " + w +suffix + g + ": " + w;
    }

    public static String format(Player p, String hook){
        ChatColor cc = ChatColor.GRAY;
        return cc + "[" + hook + cc + "] " + w + format(p);
    }

    public static String format(Player p, String msg, double distance){
        int radius = getMessageRange();
        ChatColor cc = ChatColor.GRAY;
        if(distance<radius*0.33){
            cc = w;
        } else if(distance>radius*0.66){
            cc = g;
        }
        return cc + "(" + round(distance, 1) + "m)" + format(p) + cc + msg;
    }

}
