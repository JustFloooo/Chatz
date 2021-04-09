package chatz.tablist;

import chatz.res.Messages;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import static chatz.Main.isPapi;

public class Tablist {

    public static void updateAll(){
        if(Bukkit.getOnlinePlayers().size() != 0){
            for(Player p : Bukkit.getOnlinePlayers()){
                updateTab(p);
            }
        }
    }

    public static void updateTab(Player p){
        String header = Messages.getHeader() + Messages.getServername() + "\n";
        if(isPapi()) header = PlaceholderAPI.setPlaceholders(p, header);

        String footer = "\n" + Messages.getFooter() + "\n" + Messages.getFooterstats();
        if(isPapi()) footer = PlaceholderAPI.setPlaceholders(p, footer);

        TabTitle.sendTabTitle(p, header, footer);
    }
}
