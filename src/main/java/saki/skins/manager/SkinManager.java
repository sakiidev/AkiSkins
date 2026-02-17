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

package saki.skins.manager;

import saki.skins.AkiSkins;
import saki.skins.models.Skin;
import saki.skins.models.SkinCategory;
import saki.skins.utils.SkinApplier;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SkinManager {
    private final AkiSkins plugin;
    private final Map<String, Skin> skins = new HashMap<>();
    private final Map<SkinCategory, List<Skin>> skinsByCategory = new HashMap<>();

    public SkinManager(AkiSkins plugin) {
        this.plugin = plugin;
        for (SkinCategory cat : SkinCategory.values()) {
            skinsByCategory.put(cat, new ArrayList<>());
        }
        loadSkins();
    }

    private void loadSkins() {
        File skinsFolder = new File(plugin.getDataFolder(), "skins");
        if (!skinsFolder.exists()) skinsFolder.mkdirs();
        
        File[] files = skinsFolder.listFiles((dir, name) -> name.endsWith(".yml"));
        if (files == null) return;

        for (File file : files) {
            YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
            ConfigurationSection sec = config.getConfigurationSection("skins");
            if (sec == null) continue;

            for (String key : sec.getKeys(false)) {
                String name = sec.getString(key + ".name");
                String texture = sec.getString(key + ".texture");
                String signature = sec.getString(key + ".signature");
                String catId = sec.getString(key + ".category", "comuns").toLowerCase();
                
                SkinCategory category = null;
                for (SkinCategory c : SkinCategory.values()) {
                    if (c.getId().equals(catId)) category = c;
                }
                if (category == null) category = SkinCategory.COMUNS;

                Skin skin = new Skin(key, name, texture, signature, category);
                skins.put(key.toLowerCase(), skin);
                skinsByCategory.get(category).add(skin);
            }
        }
        plugin.getLogger().info("Carregadas " + skins.size() + " skins");
    }

    public Skin getSkin(String id) {
        return skins.get(id.toLowerCase());
    }

    public List<Skin> getSkinsByCategory(SkinCategory category) {
        return skinsByCategory.get(category);
    }

    public boolean hasPermission(Player player, SkinCategory category) {
        return player.hasPermission("orbskins.category." + category.getId()) || player.hasPermission("orbskins.*");
    }

    public void applySkin(Player player, Skin skin) {
        SkinApplier.applySkin(player, skin.getTexture(), skin.getSignature());
        player.sendMessage("§aSkin " + skin.getName() + " aplicada!");
    }
}
