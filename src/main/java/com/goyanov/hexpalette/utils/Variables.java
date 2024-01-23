package com.goyanov.hexpalette.utils;

import net.md_5.bungee.api.chat.ClickEvent;

public class Variables
{
    private static ClickEvent.Action clickEvent;
    public static ClickEvent.Action getClickEvent()
    {
        return clickEvent;
    }
    public static void setClickEvent(ClickEvent.Action clickEvent)
    {
        Variables.clickEvent = clickEvent;
    }

    private static String hoverText;
    public static String getHoverText()
    {
        return hoverText;
    }
    public static void setHoverText(String hoverText)
    {
        Variables.hoverText = hoverText;
    }

    private static String colorSymbol;
    public static String getColorSymbol()
    {
        return colorSymbol;
    }
    public static void setColorSymbol(String colorSymbol)
    {
        Variables.colorSymbol = colorSymbol;
    }
}
