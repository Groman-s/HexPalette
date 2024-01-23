package com.goyanov.hexpalette.commands;

import com.goyanov.hexpalette.main.HexPalettePlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandHexPalette implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (args.length == 1 && args[0].equalsIgnoreCase("reload"))
        {
            HexPalettePlugin.inst().reloadPlugin();
            sender.sendMessage("§8§l §aPlugin reloaded!");
        }
        else
        {
            sender.sendMessage("§c/hexpalette reload - Reload the plugin");
        }

        return true;
    }
}
