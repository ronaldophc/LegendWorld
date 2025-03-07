package com.ronaldophc.command;

import com.ronaldophc.LegendWorld;
import com.ronaldophc.Utils;
import com.ronaldophc.api.bo3.StructureGenerator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BO3Command implements CommandExecutor, TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("bo3")) {
            if (strings.length == 1) {
                List<String> bo3Files = new ArrayList<>();
                File pluginFolder = LegendWorld.getInstance().getDataFolder();
                File[] files = pluginFolder.listFiles((dir, name) -> name.toLowerCase().endsWith(".bo3"));

                if (files != null) {
                    for (File file : files) {
                        bo3Files.add(file.getName().replace(".bo3", ""));
                    }
                }

                return bo3Files;
            }
        }
        return Collections.emptyList();
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("bo3")) {
            if (!(commandSender instanceof Player)) {
                commandSender.sendMessage(Utils.noConsole);
                return true;
            }

            Player player = (Player) commandSender;
            if (!commandSender.isOp() && !commandSender.hasPermission("legendworld.bo3")) {
                commandSender.sendMessage(Utils.noPermission);
                return true;
            }

            if (strings.length == 0) {
                commandSender.sendMessage(Utils.usage("/bo3 <file>"));
                return true;
            }

            String fileName = strings[0];
            File file = new File(LegendWorld.getInstance().getDataFolder(), fileName + ".bo3");
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
