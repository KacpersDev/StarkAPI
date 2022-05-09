package io.github.kacpersdev.item;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Map;

@Getter
public class Item {

    private final ItemStack itemStack;
    private final ItemMeta meta;

    public Item(ItemStack itemStack){
        this.itemStack = itemStack;
        this.meta = itemStack.getItemMeta();
    }

    public void setItemName(String name) {
        this.meta.setDisplayName(name);
    }

    public void setItemLore(ArrayList<String> lore) {
        this.meta.setLore(lore);
    }

    public void addEnchantment(Map<Enchantment, Integer> enchantmentList) {
        this.itemStack.addEnchantments(enchantmentList);
    }

    public void givePlayer(Player player, int amount) {

        this.itemStack.setItemMeta(this.meta);
        this.itemStack.setAmount(amount);
        player.getInventory().addItem(this.itemStack);
    }

    public void giveAll(int amount) {
        this.itemStack.setItemMeta(this.meta);
        this.itemStack.setAmount(amount);
        for (final Player players : Bukkit.getOnlinePlayers()) {
            players.getInventory().addItem(this.itemStack);
        }
    }

    public void addToInventory(Inventory inventory, int amount) {
        this.itemStack.setItemMeta(this.meta);
        this.itemStack.setAmount(amount);
        inventory.addItem(this.itemStack);
    }

    public void setToInventory(Inventory inventory, int amount, int slot) {
        this.itemStack.setItemMeta(this.meta);
        this.itemStack.setAmount(amount);
        inventory.setItem(slot, this.itemStack);
    }

    public boolean containsEnchants(){
        return this.itemStack.getEnchantments().isEmpty();
    }

    public boolean containsEnchant(Enchantment enchantment){
        return this.itemStack.containsEnchantment(enchantment);
    }

    public boolean containsEnchant(Enchantment enchantment, int level){

        if (!this.itemStack.getEnchantments().containsKey(enchantment)) {
            return false;
        }

        Integer levelOfEnchantment = this.itemStack.getEnchantments().get(enchantment);
        return levelOfEnchantment == level;
    }


    public String getItemName() {
        if (itemStack.getItemMeta() != null) {
            return itemStack.getItemMeta().getDisplayName();
        }
        return null;
    }
}
