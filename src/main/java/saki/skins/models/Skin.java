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

public class Skin {
    private final String id;
    private final String name;
    private final String texture;
    private final String signature;
    private final SkinCategory category;

    public Skin(String id, String name, String texture, String signature, SkinCategory category) {
        this.id = id;
        this.name = name;
        this.texture = texture;
        this.signature = signature;
        this.category = category;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getTexture() { return texture; }
    public String getSignature() { return signature; }
    public SkinCategory getCategory() { return category; }
}
