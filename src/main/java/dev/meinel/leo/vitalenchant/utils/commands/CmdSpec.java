/*
 * VitalEnchant is a Spigot Plugin that gives players the ability to enchant items.
 * Copyright © 2022 Leopold Meinel & contributors
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
 * along with this program. If not, see https://github.com/LeoMeinel/VitalEnchant/blob/main/LICENSE
 */

package dev.meinel.leo.vitalenchant.utils.commands;

import dev.meinel.leo.vitalenchant.VitalEnchant;
import dev.meinel.leo.vitalenchant.utils.Chat;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CmdSpec {

	private static final VitalEnchant main = JavaPlugin.getPlugin(VitalEnchant.class);

	private CmdSpec() {
		throw new IllegalStateException("Utility class");
	}

	public static List<String> getValidEnchantStrings(ItemStack itemStack) {
		List<String> validEnchantmentStrings = new ArrayList<>();
		for (Enchantment enchantment : Enchantment.values()) {
			if (enchantment.getItemTarget()
			               .includes(itemStack)) {
				validEnchantmentStrings.add(enchantment.getKey()
				                                       .getKey());
			}
		}
		return validEnchantmentStrings;
	}

	public static boolean isInvalidCmd(@NotNull CommandSender sender, @NotNull String perm, @NotNull String[] args,
	                                   Enchantment enchantment, ItemStack itemStack) {
		return Cmd.isNotPermitted(sender, perm) || isInvalidItem(sender, itemStack) || isInvalidEnchantment(sender,
		                                                                                                    args[0].toLowerCase(),
		                                                                                                    enchantment,
		                                                                                                    itemStack)
		       || isInvalidNumber(sender, args[1]) || isOverLimit(sender, args[1]);
	}

	private static boolean isInvalidItem(@NotNull CommandSender sender, @NotNull ItemStack itemStack) {
		if (itemStack.getType()
		             .isAir()) {
			Chat.sendMessage(sender, "invalid-item");
			return true;
		}
		return false;
	}

	private static boolean isInvalidEnchantment(@NotNull CommandSender sender, @NotNull String arg,
	                                            Enchantment enchantment, ItemStack itemStack) {
		if (enchantment == null || !CmdSpec.getValidEnchantStrings(itemStack)
		                                   .contains(arg)) {
			Chat.sendMessage(sender, "invalid-enchant");
			return true;
		}
		return false;
	}

	private static boolean isInvalidNumber(@NotNull CommandSender sender, @NotNull String arg) {
		if (!isNumeric(arg) || Integer.parseInt(arg) < 0) {
			Chat.sendMessage(sender, "invalid-amount");
			return true;
		}
		return false;
	}

	private static boolean isOverLimit(@NotNull CommandSender sender, @NotNull String arg) {
		if (Integer.parseInt(arg) > main.getConfig()
		                                .getInt("max-level")) {
			Chat.sendMessage(sender, "max-level");
			return true;
		}
		return false;
	}

	private static boolean isNumeric(final CharSequence charSequence) {
		if (isEmpty(charSequence)) {
			return false;
		}
		final int sequenceSize = charSequence.length();
		return IntStream.range(0, sequenceSize)
		                .allMatch(i -> Character.isDigit(charSequence.charAt(i)));
	}

	private static boolean isEmpty(final CharSequence charSequence) {
		return charSequence == null || charSequence.length() == 0;
	}
}
