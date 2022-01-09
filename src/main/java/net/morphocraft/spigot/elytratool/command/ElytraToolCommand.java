package net.morphocraft.spigot.elytratool.command;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ElytraToolCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        Player player = (Player) sender;
        ItemStack itemStack=new ItemStack(Material.STICK);
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName("§e神奇的木棍");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§3Elytra Tool");
        meta.setLore(lore);
        itemStack.setItemMeta(meta);
        player.getInventory().addItem(itemStack);
        return true;
    }
}
