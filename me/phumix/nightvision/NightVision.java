package me.phumix.nightvision;

import java.util.ArrayList;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
public class NightVision

extends JavaPlugin
{
    private ArrayList<Player> innv = new ArrayList<Player>();
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("nv")) {
            if (!(sender instanceof Player)) {
                return true;
            }
            Player p = (Player)sender;
            if (!p.hasPermission("night.vision")) {
                p.sendMessage("§4You don't have permision to use this command!");
                return true;
            }
            if (this.innv.contains(p)) {
                p.sendMessage("§3You are no longer using Night Vision.");
                p.removePotionEffect(PotionEffectType.NIGHT_VISION);
                this.innv.remove(p);
                } else {
                p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0));
                p.sendMessage("§3You are now using Night Vision.");
                this.innv.add(p);
            }
        }
        return true;
    }
}