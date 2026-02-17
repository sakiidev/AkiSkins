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

package saki.skins;

import saki.skins.commands.SkinCommand;
import saki.skins.listeners.SkinListener;
import saki.skins.manager.SkinManager;
import org.bukkit.plugin.java.JavaPlugin;

public class AkiSkins extends JavaPlugin {
    private static AkiSkins instance;
    private SkinManager skinManager;

    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        this.skinManager = new SkinManager(this);
        getCommand("skin").setExecutor(new SkinCommand(this));
        getServer().getPluginManager().registerEvents(new SkinListener(this), this);
        getLogger().info("AkiSkins ativado!");
    }

    public void onDisable() {
        getLogger().info("AkiSkins desativado!");
    }

    public static AkiSkins getInstance() {
        return instance;
    }

    public SkinManager getSkinManager() {
        return skinManager;
    }
}
