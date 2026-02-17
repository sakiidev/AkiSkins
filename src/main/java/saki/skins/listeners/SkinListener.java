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

package saki.skins.listeners;

import saki.skins.AkiSkins;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class SkinListener implements Listener {
    private final AkiSkins plugin;

    public SkinListener(AkiSkins plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {}

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {}
}
