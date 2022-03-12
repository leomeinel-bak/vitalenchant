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
 * along with this program. If not, see https://github.com/TamrielNetwork/VitalEnchant/blob/main/LICENSE
 */

package com.tamrielnetwork.vitalenchant.commands;

import com.tamrielnetwork.vitalenchant.utils.commands.Cmd;
import com.tamrielnetwork.vitalenchant.utils.commands.CmdSpec;
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
		if (CmdSpec.isInvalidCmd(sender, args, enchantment, itemStack)) {
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
	public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias,
	                                            @NotNull String[] args) {
		@Nullable List<String> tabComplete = new ArrayList<>();
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