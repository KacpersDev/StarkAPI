package io.github.kacpersdev;

import org.bukkit.ChatColor;

public class Color {

    public static String translate(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}
