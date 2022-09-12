/*
 * File: VitalEnchantCmd.java
 * Author: Leopold Meinel (leo@meinel.dev)
 * -----
 * Copyright (c) 2022 Leopold Meinel & contributors
 * SPDX ID: GPL-3.0-or-later
 * URL: https://www.gnu.org/licenses/gpl-3.0-standalone.html
 * -----
 */

package dev.meinel.leo.vitalenchant.commands;

import dev.meinel.leo.vitalenchant.utils.commands.Cmd;
import dev.meinel.leo.vitalenchant.utils.commands.CmdSpec;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class VitalEnchantCmd
        implements TabExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label,
            @NotNull String[] args) {
        if (Cmd.isArgsLengthNotEqualTo(sender, args, 2)) {
            return false;
        }
        doEnchant(sender, args);
        return true;
    }

    private void doEnchant(@NotNull CommandSender sender, @NotNull String[] args) {
        if (Cmd.isInvalidSender(sender)) {
            return;
        }
        Player senderPlayer = (Player) sender;
        ItemStack itemStack = senderPlayer.getInventory()
                .getItemInMainHand();
        Enchantment enchantment = Enchantment.getByKey(NamespacedKey.minecraft(args[0].toLowerCase()));
        if (CmdSpec.isInvalidCmd(sender, "vitalenchant.enchant", args, enchantment, itemStack)) {
            return;
        }
        assert enchantment != null;
        if (Integer.parseInt(args[1]) == 0) {
            itemStack.removeEnchantment(enchantment);
            return;
        }
        itemStack.addUnsafeEnchantment(enchantment, Integer.parseInt(args[1]));
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command,
            @NotNull String alias, @NotNull String[] args) {
        @Nullable
        List<String> tabComplete = new ArrayList<>();
        if (args.length == 1) {
            Player senderPlayer = (Player) sender;
            ItemStack itemStack = senderPlayer.getInventory()
                    .getItemInMainHand();
            if (itemStack.getType()
                    .isAir()) {
                return null;
            }
            if (sender.hasPermission("vitalenchant.enchant")) {
                tabComplete.addAll(CmdSpec.getValidEnchantStrings(itemStack));
                return tabComplete;
            }
        }
        return tabComplete;
    }
}