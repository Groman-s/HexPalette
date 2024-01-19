package com.goyanov.hexpalette.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.*;
import net.md_5.bungee.api.chat.hover.content.Item;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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
                        TextComponent extra = new TextComponent("§l|");
                        extra.setColor(ChatColor.of(hex));
                        extra.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click to copy").create()));
                        extra.setClickEvent(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, hex));
                        message.addExtra(extra);
                    }
                }
            }
        }
        p.spigot().sendMessage(message);

        return true;
    }
}
