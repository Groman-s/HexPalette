package com.goyanov.hexpalette.main;

import com.goyanov.hexpalette.commands.CommandPalette;
import org.bukkit.plugin.java.JavaPlugin;

public class HexPalettePlugin extends JavaPlugin
{
    private static HexPalettePlugin instance;
    public static HexPalettePlugin inst() { return instance; }

    @Override
    public void onEnable()
    {
        instance = this;

        getCommand("palette").setExecutor(new CommandPalette());
    }
}
