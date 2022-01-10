package net.morphocraft.spigot.elytratool.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.util.Vector;

import java.util.List;

public class UseItemEventListener implements Listener {
    @EventHandler
    public void onPlayerItemDamageEvent(PlayerItemDamageEvent event){
        Player player=event.getPlayer();
        if (player.hasPermission("elytratool.use")||player.isOp()){
            if(event.getItem().getType()== Material.ELYTRA){
                ItemStack itemInHand=player.getInventory().getItemInMainHand();
                if (itemInHand.getType()==Material.STICK){
                    List<String> lore=itemInHand.getItemMeta().getLore();
                    if (lore!=null&&lore.contains("§3Elytra Tool")){
                        event.setCancelled(true);
                    }
                }
            }
        }
    }
    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event){
        Player player=event.getPlayer();
        if (player.hasPermission("elytratool.use")||player.isOp()){
            if (event.getHand()== EquipmentSlot.HAND&&event.getAction()==Action.RIGHT_CLICK_AIR){
                ItemStack itemInHand=event.getItem();
                if(itemInHand!=null&&itemInHand.getType()== Material.STICK){
                    List<String> lore=itemInHand.getItemMeta().getLore();
                    if (lore!=null&&lore.contains("§3Elytra Tool")){
                        if (player.isGliding()==false){
                            PlayerInventory playerInventory= player.getInventory();
                            ItemStack[] armorContents=playerInventory.getArmorContents();
                            if (armorContents[2]==null||armorContents[2].getType()==Material.AIR){
                                armorContents[2]=new ItemStack(Material.ELYTRA);
                                playerInventory.setArmorContents(armorContents);
                            }else if(armorContents[2].getType()!=Material.ELYTRA) {
                                player.sendMessage("胸甲栏不是空的，无法添加鞘翅");
                                return;
                            }
                        }
                        player.setGliding(true);
                        Vector playerRotationVector = player.getLocation().getDirection();
                        Vector playerVelocity = player.getVelocity();
                        player.setVelocity(playerVelocity.add(new Vector(playerRotationVector.getX() * 0.1 + (playerRotationVector.getX()  * 1.5 - playerVelocity.getX() ) * 0.5, playerRotationVector.getY()  * 0.1 + (playerRotationVector.getY()  * 1.5 - playerVelocity.getY() ) * 0.5, (playerRotationVector).getZ()  * 0.1 + (playerRotationVector.getZ()  * 1.5 - playerVelocity.getZ() ) * 0.5)));
                    }
                }
            }
        }
    }

}
