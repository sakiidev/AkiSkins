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

package saki.skins.menu;

import saki.skins.AkiSkins;
import saki.skins.models.SkinCategory;
import saki.skins.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class SkinMenu implements Listener {
    private final AkiSkins plugin;
    private final Player player;
    private final Inventory inv;

    public SkinMenu(AkiSkins plugin, Player player) {
        this.plugin = plugin;
        this.player = player;
        this.inv = Bukkit.createInventory(null, 54, "§8Skins - " + player.getName());
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        setupItems();
        player.openInventory(inv);
    }

    private void setupItems() {
        ItemStack youtuber = new ItemBuilder(Material.SKULL_ITEM, 1)
            .durability(3)
            .owner("MHF_Question")
            .name("§b§lYouTubers")
            .lore("§7Skins exclusivas", "", "§eClique para ver")
            .build();
        inv.setItem(10, youtuber);

        ItemStack staff = new ItemBuilder(Material.SKULL_ITEM, 1)
            .durability(3)
            .owner("MHF_Chest")
            .name("§c§lStaff")
            .lore("§7Skins da equipe", "", "§eClique para ver")
            .build();
        inv.setItem(11, staff);

        ItemStack vip = new ItemBuilder(Material.SKULL_ITEM, 1)
            .durability(3)
            .owner("MHF_Star")
            .name("§a§lVIP")
            .lore("§7Skins VIP", "", "§eClique para ver")
            .build();
        inv.setItem(12, vip);

        ItemStack eventos = new ItemBuilder(Material.SKULL_ITEM, 1)
            .durability(3)
            .owner("MHF_Present")
            .name("§6§lEventos")
            .lore("§7Skins de eventos", "", "§eClique para ver")
            .build();
        inv.setItem(13, eventos);

        ItemStack especiais = new ItemBuilder(Material.SKULL_ITEM, 1)
            .durability(3)
            .owner("MHF_Herobrine")
            .name("§d§lEspeciais")
            .lore("§7Skins raras", "", "§eClique para ver")
            .build();
        inv.setItem(14, especiais);

        ItemStack comuns = new ItemBuilder(Material.SKULL_ITEM, 1)
            .durability(3)
            .owner("MHF_Steve")
            .name("§7§lComuns")
            .lore("§7Skins para todos", "", "§eClique para ver")
            .build();
        inv.setItem(15, comuns);

        ItemStack voltar = new ItemBuilder(Material.BARRIER)
            .name("§c§lFechar")
            .lore("§7Clique para fechar")
            .build();
        inv.setItem(49, voltar);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getInventory() != inv || e.getWhoClicked() != player) {
            return;
        }
        e.setCancelled(true);
        
        if (e.getCurrentItem() == null) return;

        int slot = e.getSlot();
        
        if (slot == 10) {
            new SkinCategoryMenu(plugin, player, SkinCategory.YOUTUBER);
        } else if (slot == 11) {
            new SkinCategoryMenu(plugin, player, SkinCategory.STAFF);
        } else if (slot == 12) {
            new SkinCategoryMenu(plugin, player, SkinCategory.VIP);
        } else if (slot == 13) {
            new SkinCategoryMenu(plugin, player, SkinCategory.EVENTOS);
        } else if (slot == 14) {
            new SkinCategoryMenu(plugin, player, SkinCategory.ESPECIAIS);
        } else if (slot == 15) {
            new SkinCategoryMenu(plugin, player, SkinCategory.COMUNS);
        } else if (slot == 49) {
            player.closeInventory();
        }
    }

    @EventHandler
    public void onClose(InventoryCloseEvent e) {
        if (e.getPlayer() == player) {
            HandlerList.unregisterAll(this);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        if (e.getPlayer() == player) {
            HandlerList.unregisterAll(this);
        }
    }
}
