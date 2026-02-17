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
import saki.skins.models.Skin;
import saki.skins.models.SkinCategory;
import saki.skins.utils.ItemBuilder;
import saki.skins.utils.SkinApplier;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SkinCategoryMenu implements Listener {
    private final AkiSkins plugin;
    private final Player player;
    private final Inventory inv;
    private final SkinCategory category;
    private final Map<Integer, Skin> skinSlots = new HashMap<>();

    public SkinCategoryMenu(AkiSkins plugin, Player player, SkinCategory category) {
        this.plugin = plugin;
        this.player = player;
        this.category = category;
        this.inv = Bukkit.createInventory(null, 54, "§8" + category.getName());

        if (!plugin.getSkinManager().hasPermission(player, category)) {
            player.sendMessage("§cVocê não tem permissão para ver esta categoria");
            player.closeInventory();
            return;
        }

        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        setupItems();
        player.openInventory(inv);
    }

    private void setupItems() {
        List<Skin> skins = plugin.getSkinManager().getSkinsByCategory(category);
        int slot = 10;

        for (Skin skin : skins) {
            while (slot % 9 == 0 || slot % 9 == 8 || slot < 10 || slot > 43) {
                slot++;
            }

            ItemStack item = new ItemBuilder(Material.SKULL_ITEM)
                .durability(3)
                .owner(skin.getName())
                .name("§a" + skin.getName())
                .lore("", "§eClique para aplicar")
                .build();

            inv.setItem(slot, item);
            skinSlots.put(slot, skin);
            slot++;
        }

        ItemStack back = new ItemBuilder(Material.ARROW)
            .name("§c§lVoltar")
            .lore("§7Clique para voltar")
            .build();
        inv.setItem(49, back);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getInventory() != inv || e.getWhoClicked() != player) {
            return;
        }
        e.setCancelled(true);
        
        if (e.getCurrentItem() == null) return;

        int slot = e.getSlot();

        if (slot == 49) {
            new SkinMenu(plugin, player);
            return;
        }

        if (skinSlots.containsKey(slot)) {
            Skin skin = skinSlots.get(slot);
            SkinApplier.applySkin(player, skin.getTexture(), skin.getSignature());
            player.sendMessage("§aSkin " + skin.getName() + " aplicada! Reconecte-se para ver.");
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
