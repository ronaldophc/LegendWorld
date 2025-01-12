package com.ronaldophc;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private static final String LOG_FILE_ERROR = "error.log";
    private static final String LOG_FILE_DEBUG = "debug.log";
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public static void logError(String message) {
        try (FileWriter fw = new FileWriter(LOG_FILE_ERROR, true);
             PrintWriter pw = new PrintWriter(fw)) {
            String timestamp = dtf.format(LocalDateTime.now());
            pw.println(timestamp + " - LegendWorld - ERROR: " + message);
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (player.isOp()) {
                    LegendWorld.logger.info("Um erro ocorreu com LegendWorld, verifique os logs.");
                    player.sendMessage("4Ocorreu um erro no LegendWorld, verifique o log error.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void debug(String message) {
        try (FileWriter fw = new FileWriter(LOG_FILE_DEBUG, true);
             PrintWriter pw = new PrintWriter(fw)) {
            String timestamp = dtf.format(LocalDateTime.now());
            pw.println(timestamp + " - LegendWorld - DEBUG: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
