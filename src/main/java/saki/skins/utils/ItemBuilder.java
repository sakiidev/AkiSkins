/*
 * Copyright (c) 2025 Saki. Todos os direitos reservados.
 * Este código é propriedade exclusiva de Saki.
 * Proibida a distribuição ou modificação sem autorização.
 */

/*
 * Copyright (c) 2024 Saki. Todos os direitos reservados.
 * Este código é propriedade exclusiva de Saki.
 * Proibida a distribuição ou modificação sem autorização.
 */

package saki.skins.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import java.util.ArrayList;
import java.util.List;

public class ItemBuilder {
    private ItemStack item;
    private ItemMeta meta;

    public ItemBuilder(Material material) {
        this.item = new ItemStack(material, 1);
        this.meta = item.getItemMeta();
    }

    public ItemBuilder(Material material, int amount) {
        this.item = new ItemStack(material, amount);
        this.meta = item.getItemMeta();
    }

    public ItemBuilder name(String name) {
        if (meta != null) {
            meta.setDisplayName(name.replace("&", "§"));
        }
        return this;
    }

    public ItemBuilder lore(String... lines) {
        if (meta != null) {
            List<String> lore = new ArrayList<>();
            for (String line : lines) {
                lore.add(line.replace("&", "§"));
            }
            meta.setLore(lore);
        }
        return this;
    }

    public ItemBuilder durability(int durability) {
        item.setDurability((short) durability);
        return this;
    }

    public ItemBuilder owner(String owner) {
        if (meta instanceof SkullMeta) {
            ((SkullMeta) meta).setOwner(owner);
        }
        return this;
    }

    public ItemStack build() {
        if (meta != null) {
            item.setItemMeta(meta);
        }
        return item;
    }
}
