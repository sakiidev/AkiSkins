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

package saki.skins.models;

public enum SkinCategory {
    YOUTUBER("youtuber", "YouTuber", "orbskins.category.youtuber", 10),
    STAFF("staff", "Staff", "orbskins.category.staff", 11),
    VIP("vip", "VIP", "orbskins.category.vip", 12),
    EVENTOS("eventos", "Eventos", "orbskins.category.eventos", 13),
    ESPECIAIS("especiais", "Especiais", "orbskins.category.especiais", 14),
    COMUNS("comuns", "Comuns", "orbskins.category.comuns", 15);

    private final String id;
    private final String name;
    private final String permission;
    private final int slot;

    SkinCategory(String id, String name, String permission, int slot) {
        this.id = id;
        this.name = name;
        this.permission = permission;
        this.slot = slot;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getPermission() { return permission; }
    public int getSlot() { return slot; }

    public static SkinCategory fromSlot(int slot) {
        for (SkinCategory cat : values()) {
            if (cat.slot == slot) return cat;
        }
        return null;
    }
}
