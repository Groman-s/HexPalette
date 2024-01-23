package com.goyanov.hexpalette.commands;

import com.google.errorprone.annotations.Var;
import com.goyanov.hexpalette.utils.Variables;
import com.goyanov.rglib.RGAPI;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandPalette implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (!(sender instanceof Player))
        {
            sender.sendMessage("§cThis command is for players only!");
            return true;
        }

        Player p = (Player) sender;
        TextComponent message = new TextComponent("  ");

        for (int r = 0; r < 256; r += 32)
        {
            for (int g = 0; g < 256; g += 32)
            {
                for (int b = 0; b < 256; b += 32)
                {
                    for (int i = 0; i < 256-32; i += 32)
                    {
                        int newR = r + i;
                        if (newR > 255) newR = 255;
                        int newG = g + i;
                        if (newG > 255) newG = 255;
                        int newB = b + i;
                        if (newB > 255) newB = 255;
                        String hex = String.format("#%02x%02x%02x", newR, newG, newB);
                        TextComponent extra = new TextComponent(RGAPI.getColoredMessage(Variables.getColorSymbol()));
                        extra.setColor(ChatColor.of(hex));
                        extra.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(RGAPI.formatWithColors(Variables.getHoverText())).create()));
                        extra.setClickEvent(new ClickEvent(Variables.getClickEvent(), hex));
                        message.addExtra(extra);
                    }
                }
            }
            p.spigot().sendMessage(message);
            message = new TextComponent("  ");
        }

        return true;
    }
}
