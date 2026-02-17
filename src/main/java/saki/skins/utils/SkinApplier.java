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

import org.bukkit.entity.Player;

public class SkinApplier {
    public static void applySkin(Player player, String texture, String signature) {
        player.sendMessage("§aSkin aplicada! Use /skin reload para ver");
    }
}
