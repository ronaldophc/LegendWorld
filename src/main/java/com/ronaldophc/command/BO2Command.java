package com.ronaldophc.command;

import com.ronaldophc.LegendWorld;
import com.ronaldophc.Utils;
import com.ronaldophc.api.bo2.StructureGenerator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BO2Command implements CommandExecutor, TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("bo2")) {
            if (strings.length == 1) {
                List<String> bo2Files = new ArrayList<>();
                File pluginFolder = LegendWorld.getInstance().getDataFolder();
                File[] files = pluginFolder.listFiles((dir, name) -> name.toLowerCase().endsWith(".bo2"));

                if (files != null) {
                    for (File file : files) {
                        bo2Files.add(file.getName().replace(".bo2", ""));
                    }
                }

                return bo2Files;
            }
        }
        return Collections.emptyList();
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("bo2")) {
            if (!(commandSender instanceof Player)) {
                commandSender.sendMessage(Utils.noConsole);
                return true;
            }

            Player player = (Player) commandSender;
            if (!commandSender.isOp() && !commandSender.hasPermission("legendworld.bo2")) {
                commandSender.sendMessage(Utils.noPermission);
                return true;
            }

            if (strings.length == 0) {
                commandSender.sendMessage(Utils.usage("/bo2 <file>"));
                return true;
            }

            String fileName = strings[0];
            File file = new File(LegendWorld.getInstance().getDataFolder(), fileName + ".bo2");
            if (!file.exists()) {
                player.sendMessage(Utils.error + ("File not found!"));
                return true;
            }
            StructureGenerator.generateStructure(player.getWorld(), player.getLocation(), file);
            player.sendMessage(Utils.admin + ("Structure generated!"));

            return true;
        }
        return true;
    }
}
