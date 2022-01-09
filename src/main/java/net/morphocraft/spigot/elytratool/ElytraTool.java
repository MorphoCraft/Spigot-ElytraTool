package net.morphocraft.spigot.elytratool;

import net.morphocraft.spigot.elytratool.command.ElytraToolCommand;
import net.morphocraft.spigot.elytratool.listener.UseItemEventListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ElytraTool extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginCommand("elytratool").setExecutor(new ElytraToolCommand());
        Bukkit.getPluginManager().registerEvents(new UseItemEventListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
