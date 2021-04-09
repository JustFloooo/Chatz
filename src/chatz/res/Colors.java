package chatz.res;

import com.google.common.collect.ImmutableMap;
import org.bukkit.ChatColor;

import java.util.Map;

public class Colors {

    private static final Map<String, ChatColor> namecolor = ImmutableMap.of(
            "administrator", ChatColor.DARK_RED,
            "moderator", ChatColor.DARK_GREEN,
            "developer", ChatColor.AQUA,
            "default", ChatColor.GREEN,
            "vip", ChatColor.GOLD
    );

    public static Map<String, ChatColor> getNamecolor() {
        return namecolor;
    }

}
