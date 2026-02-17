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

package saki.skins.commands;

import saki.skins.AkiSkins;
import saki.skins.menu.SkinMenu;
import saki.skins.menu.SkinCategoryMenu;
import saki.skins.models.SkinCategory;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SkinCommand implements CommandExecutor {
    private final AkiSkins plugin;

    public SkinCommand(AkiSkins plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cApenas jogadores podem usar este comando!");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 1) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null && player.hasPermission("orbskins.others")) {
                new SkinMenu(plugin, target);
                player.sendMessage("§aAbrindo skins de " + target.getName());
                return true;
            }
            player.sendMessage("§cJogador não encontrado!");
            return true;
        }

        new SkinMenu(plugin, player);
        return true;
    }
}
