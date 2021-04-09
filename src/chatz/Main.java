package chatz;

import chatz.chats.ChatListener;
import chatz.tablist.JoinListener;
import chatz.tablist.Tablist;
import net.milkbowl.vault.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Chat chat = null;
    private static boolean papi = false;
    private static final int timer = 1;


    @Override
    public void onDisable() {
        getLogger().info("Shutting down Chatz.");
    }

    @Override
    public void onEnable() {
        getLogger().info("Loading Chatz Plugin.");

        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            getLogger().warning(" Disarming Chatz. Vault is not present.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        if(!setupChat()){
            getLogger().warning("Chatz could not hook into chat.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null){
            papi = true;
        } else {
            getLogger().warning("Chatz will not work properly without PlaceholderAPI");
        }

        getLogger().info("Registering Chatz Listeners.");
        registerListeners();

        getLogger().info("Initializing Chart Schedulers.");
        Bukkit.getScheduler().runTaskTimer(this, Tablist::updateAll, (long)10*timer, (long)10*timer);

        getLogger().info("Chatz primed and ready.");
    }

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        if (rsp == null) {
            return false;
        }
        chat = rsp.getProvider();
        return true;
    }

    private void registerListeners() {
        Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
    }

    public static Chat getChat() {
        return chat;
    }

    public static boolean isPapi() {
        return papi;
    }
}