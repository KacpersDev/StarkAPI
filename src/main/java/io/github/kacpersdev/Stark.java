package io.github.kacpersdev;

import org.bukkit.plugin.java.JavaPlugin;

public final class Stark extends JavaPlugin {

    private static Stark instance;
    @Override
    public void onEnable() {
        instance = this;

    }

    public static Stark getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {

    }
}
