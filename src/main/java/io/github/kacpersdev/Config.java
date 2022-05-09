package io.github.kacpersdev;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {

    public Config(File file, FileConfiguration fileConfiguration, String dir){

        if (!(file.exists())) {
            file.getParentFile().mkdir();
            Stark.getInstance().saveResource(dir, false);
        }

        try {
            fileConfiguration.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    public void reload(File file, FileConfiguration fileConfiguration){

        try {
            fileConfiguration.save(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fileConfiguration.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }
    }
}
