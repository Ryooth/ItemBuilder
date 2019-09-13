package net.racow.qsg.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;

public class ItemBuilder {

    ItemStack item;
    ItemMeta meta;

    public ItemBuilder(ItemStack item) {
        this.item = item;
        this.meta = item.getItemMeta();
    }

    public ItemBuilder(Material m) {
        this(new ItemStack(m));
    }

    public ItemBuilder(Material m, int amount) {
        this(new ItemStack(m, amount));
    }

    public ItemBuilder(Material m, short subID) {
        this(new ItemStack(m, 1, subID));
    }

    public ItemBuilder(Material m, int amount, short subID) {
        this(new ItemStack(m, amount, subID));
    }

    @SuppressWarnings("deprecation")
    public ItemBuilder(int ID) {
        this(new ItemStack(ID));
    }

    @SuppressWarnings("deprecation")
    public ItemBuilder(int ID, int amount) {
        this(new ItemStack(ID, amount));
    }

    @SuppressWarnings("deprecation")
    public ItemBuilder(int ID, short subID) {
        this(new ItemStack(ID, 1, subID));
    }

    @SuppressWarnings("deprecation")
    public ItemBuilder(int ID, int amount, short subID) {
        this(new ItemStack(ID, amount, subID));
    }

    public ItemBuilder setName(String name) {
        meta.setDisplayName(name);
        return this;
    }

    public ItemBuilder setUnbreakable() {
        meta.spigot().setUnbreakable(true);
        return this;
    }

    public ItemBuilder addLore(String... lores) {
        meta.setLore(Arrays.asList(lores));
        return this;
    }

    public ItemBuilder addEnchantment(Enchantment ench, int lvl) {
        meta.addEnchant(ench, lvl, true);
        return this;
    }

    public ItemBuilder removeEnchantments() {
        this.meta.getEnchants().keySet().forEach(ench -> meta.removeEnchant(ench));
        return this;
    }

    public ItemBuilder addItemFlag(ItemFlag... flag) {
        meta.addItemFlags(flag);
        return this;
    }

    public ItemBuilder removeItemFlags(ItemFlag... flag) {
        meta.removeItemFlags(flag);
        return this;
    }

    public ItemBuilder removeItemFlags() {
        meta.removeItemFlags();
        return this;
    }

    public ItemBuilder setDurability(short durability) {
        item.setDurability(durability);
        return this;
    }

    public ItemBuilder setAmount(int amount) {
        item.setAmount(amount);
        return this;
    }

    public ItemStack buildSkull(String owner) {
        SkullMeta meta = (SkullMeta) this.meta;
        meta.setOwner(owner);
        item.setItemMeta(meta);
        return this.item;
    }

    public ItemStack build() {
        item.setItemMeta(meta);
        return this.item;
    }

}

