package chatz.res;

import org.bukkit.ChatColor;

import java.util.HashMap;
import java.util.Map;

public class Colors {

    private static final Map<String, ChatColor> namecolor = new HashMap<>();

    public static void fillHashmap(){
        namecolor.put("administrator", ChatColor.DARK_RED);
        namecolor.put("moderator", ChatColor.DARK_GREEN);
        namecolor.put("developer", ChatColor.AQUA);
        namecolor.put("builder", ChatColor.BLUE);
        namecolor.put("default", ChatColor.GREEN);
        namecolor.put("vip", ChatColor.GOLD);
    }


    public static Map<String, ChatColor> getNamecolor() {
        return namecolor;
    }

}
