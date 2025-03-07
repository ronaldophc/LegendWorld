package com.ronaldophc.command;

import com.ronaldophc.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ExampleCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("example")) {
            if (!(commandSender instanceof Player)) {
                commandSender.sendMessage(Utils.noConsole);
                return true;
            }

            Player player = (Player) commandSender;
            if (!commandSender.isOp() && !commandSender.hasPermission("legendworld.example")) {
                commandSender.sendMessage(Utils.noPermission);
                return true;
            }

            return true;
        }
        return false;
    }
}
