# 🎭 AkiSkins

**AkiSkins** é um plugin completo de skins para servidores Minecraft (Spigot/Paper 1.8-1.20). Permite que jogadores visualizem e apliquem skins organizadas por categorias com sistema de permissões.

## ✨ Funcionalidades

- 📂 **Menu interativo** com categorias organizadas
- 👑 **Sistema de permissões** por categoria
- 🎮 **Comando /skin** com suporte para outros jogadores
- 🔄 **Aplicação de skins** (requer relog para versão sem ProtocolLib)
- 🎨 **Categorias**: YouTuber, Staff, VIP, Eventos, Especiais e Comuns
- ⚙️ **Totalmente configurável** via arquivos YML
- 📦 **Leve e otimizado** - sem dependências externas

## 📋 Comandos

| Comando | Descrição | Permissão |
|---------|-----------|-----------|
| `/skin` | Abre o menu de skins | `akiskins.use` |
| `/skin <jogador>` | Abre skins de outro jogador | `akiskins.others` |

## 🔐 Permissões

| Permissão | Descrição |
|-----------|-----------|
| `akiskins.*` | Todas as permissões |
| `akiskins.use` | Usar o comando /skin |
| `akiskins.others` | Ver skins de outros jogadores |
| `akiskins.category.youtuber` | Acesso a skins de YouTuber |
| `akiskins.category.staff` | Acesso a skins de Staff |
| `akiskins.category.vip` | Acesso a skins VIP |
| `akiskins.category.eventos` | Acesso a skins de Eventos |
| `akiskins.category.especiais` | Acesso a skins Especiais |
| `akiskins.category.comuns` | Acesso a skins Comuns |

## 🚀 Como usar

1. Coloque o arquivo `AkiSkins.jar` na pasta `plugins/`
2. Reinicie o servidor
3. Configure as skins na pasta `plugins/AkiSkins/skins/`
4. Use `/skin` no jogo

## 📁 Estrutura de Skins

As skins são configuradas em arquivos YML na pasta `skins/`:

```yaml
skins:
  skin_id:
    name: "Nome da Skin"
    texture: "textura_base64"
    signature: "assinatura_base64"
    category: "youtuber" # youtuber, staff, vip, eventos, especiais, comuns
```
### 🛠️ Compilação

```bash
mvn clean package
```

### 📦 Dependências

· Spigot/Paper 1.8 - 1.20
· ProtocolLib (opcional, para skin em tempo real)

### 👤 Autor

Saki - Desenvolvido com 💜 para a comunidade Minecraft

📄 Licença

```
Copyright (c) 2025 Saki. Todos os direitos reservados.
Este código é propriedade exclusiva de Saki.
Proibida a distribuição ou modificação sem autorização.
```
