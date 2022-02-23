/*
 * VitalEnchant is a Spigot Plugin that gives players the ability to enchant items.
 * Copyright © 2022 Leopold Meinel
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see https://github.com/TamrielNetwork/VitalEnchant/blob/main/LICENSE
 */

package com.tamrielnetwork.vitalenchant.utils.commands;

import com.tamrielnetwork.vitalenchant.VitalEnchant;
import com.tamrielnetwork.vitalenchant.utils.Chat;
import org.apache.commons.lang.StringUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CmdSpec {

	private static final VitalEnchant main = JavaPlugin.getPlugin(VitalEnchant.class);

	public static List<String> getValidEnchantStrings(ItemStack itemStack) {

		List<String> validEnchantmentStrings = new ArrayList<>();

		for (Enchantment enchantment : Enchantment.values()) {
			if (enchantment.getItemTarget().includes(itemStack)) {
				validEnchantmentStrings.add(enchantment.getKey().getKey());
			}
		}

		return validEnchantmentStrings;
	}

	public static boolean isInvalidCmd(@NotNull CommandSender sender, @NotNull String[] args, Enchantment enchantment, ItemStack itemStack) {

		if (Cmd.isNotPermitted(sender, "vitalenchant.enchant")) {
			return true;
		}
		if (isInvalidItem(sender, itemStack)) {
			return true;
		}
		if (isInvalidEnchantment(sender, args[0], enchantment, itemStack)) {
			return true;
		}
		if (isInvalidNumber(sender, args[1])) {
			return true;
		}
		return isOverLimit(sender, args[1]);
	}

	private static boolean isInvalidItem(@NotNull CommandSender sender, @NotNull ItemStack itemStack) {

		if (itemStack.getType().isAir()) {
			Chat.sendMessage(sender, "invalid-item");
			return true;
		}
		return false;
	}

	private static boolean isInvalidEnchantment(@NotNull CommandSender sender, @NotNull String arg, Enchantment enchantment, ItemStack itemStack) {

		if (enchantment == null) {
			Chat.sendMessage(sender, "invalid-enchant");
			return true;
		}
		if (!CmdSpec.getValidEnchantStrings(itemStack).contains(arg)) {
			Chat.sendMessage(sender, "invalid-enchant");
			return true;
		}
		return false;
	}

	private static boolean isInvalidNumber(@NotNull CommandSender sender, @NotNull String arg) {

		if (!StringUtils.isNumeric(arg)) {
			Chat.sendMessage(sender, "invalid-amount");
			return true;
		}
		if (Integer.parseInt(arg) < 0) {
			Chat.sendMessage(sender, "invalid-amount");
			return true;
		}
		return false;
	}

	private static boolean isOverLimit(@NotNull CommandSender sender, @NotNull String arg) {

		if (Integer.parseInt(arg) > main.getConfig().getInt("max-level")) {
			Chat.sendMessage(sender, "max-level");
			return true;
		}
		return false;
	}

}
