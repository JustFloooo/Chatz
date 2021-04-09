package chatz.tablist;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Map;

import static chatz.api.VaultHook.getPrimaryGroup;
import static chatz.res.Colors.getNamecolor;

public class JoinListener implements Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        final Map<String, ChatColor> namecolor = getNamecolor();
        p.setPlayerListName(namecolor.get(getPrimaryGroup(p))+p.getDisplayName());
        Tablist.updateTab(p);
    }

}
