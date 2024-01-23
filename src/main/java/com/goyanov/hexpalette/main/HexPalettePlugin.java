package com.goyanov.hexpalette.main;

import com.goyanov.hexpalette.commands.CommandHexPalette;
import com.goyanov.hexpalette.commands.CommandPalette;
import com.goyanov.hexpalette.utils.Metrics;
import com.goyanov.hexpalette.utils.Variables;
import com.goyanov.rglib.ConfigManager;
import net.md_5.bungee.api.chat.ClickEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class HexPalettePlugin extends JavaPlugin
{
    private static HexPalettePlugin instance;
    public static HexPalettePlugin inst() { return instance; }

    public void reloadPlugin()
    {
        ConfigManager.loadDefaultConfig(this);

        String configAction = HexPalettePlugin.inst().getConfig().getString("on-click-action").toUpperCase();
        ClickEvent.Action action = configAction.equals("COPY_TO_CLIPBOARD") ? ClickEvent.Action.COPY_TO_CLIPBOARD :
                configAction.equals("PASTE_IN_CHAT") ? ClickEvent.Action.SUGGEST_COMMAND : null;
        if (action == null)
        {
            HexPalettePlugin.inst().getLogger().severe("§cThere is unknown action in your config: " + configAction
                    + "! Set to COPY_TO_CLIPBOARD.");
            action = ClickEvent.Action.COPY_TO_CLIPBOARD;
        }
        Variables.setClickEvent(action);

        String hoverText = HexPalettePlugin.inst().getConfig().getString("on-hover-text");
        Variables.setHoverText(hoverText);

        String colorSymbol = HexPalettePlugin.inst().getConfig().getString("color-symbol");
        Variables.setColorSymbol(colorSymbol);
    }

    @Override
    public void onEnable()
    {
        instance = this;

        reloadPlugin();

        getCommand("palette").setExecutor(new CommandPalette());
        getCommand("hexpalette").setExecutor(new CommandHexPalette());

        new Metrics(this, 20789);
    }
}
