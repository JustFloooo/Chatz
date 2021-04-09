package chatz.res;

import org.bukkit.ChatColor;

public class Messages {

    private static final ChatColor fst = ChatColor.AQUA;
    private static final ChatColor snd = ChatColor.DARK_PURPLE;
    
    private static final String header1 = fst + "Willkommen " + snd + "%player_name% " + fst + "in der ";
    private static final String servername = Symbols.getStar() + ChatColor.GOLD + " Problemzone " + Symbols.getStar() + "";

    private static final String footer1 = fst + "Aktuell sind " + snd + "%server_online%" + fst + " Spieler online!";
    private static final String footerstats = snd + "%player_ping%ms" + fst + " || " + snd + "%player_world_time_24%" + " Uhr";

    public static String getHeader() {
        return header1;
    }

    public static String getFooter() {
        return footer1;
    }

    public static String getFooterstats() {
        return footerstats;
    }

    public static String getServername() {
        return servername;
    }
}
