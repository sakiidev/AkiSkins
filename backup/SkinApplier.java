package com.freestyleprime.orbskins.utils;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import java.lang.reflect.Field;

public class SkinApplier {
    public static void applySkin(Player player, String texture, String signature) {
        try {
            CraftPlayer craftPlayer = (CraftPlayer) player;
            GameProfile profile = craftPlayer.getProfile();
            profile.getProperties().removeAll("textures");
            profile.getProperties().put("textures", new Property("textures", texture, signature));
            
            Field field = profile.getClass().getDeclaredField("properties");
            field.setAccessible(true);
            field.set(profile, profile.getProperties());
            
            for (Player p : Bukkit.getOnlinePlayers()) {
                if (p.equals(player)) continue;
                p.hidePlayer(player);
                p.showPlayer(player);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
