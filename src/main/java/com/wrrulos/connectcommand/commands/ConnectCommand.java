package com.wrrulos.connectcommand.commands;

import com.wrrulos.connectcommand.utils.ChatUtil;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import java.net.InetSocketAddress;

public class ConnectCommand extends Command {

    public ConnectCommand() {
        super("connect");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            ChatUtil.tell(sender, "&7[&5ConnectCommand&7] &cYou cannot use this command in the console");
            return;
        }

        ProxiedPlayer proxiedPlayer = (ProxiedPlayer) sender;

        if (args.length == 1) {
            try {
                if(!args[0].contains(":")) {
                    String host = args[0];
                    int port = 25565;

                    ChatUtil.tell(proxiedPlayer, "&7[&5ConnectCommand&7] &aConnecting to " + args[0] + "...");
                    proxiedPlayer.connect(ProxyServer.getInstance().constructServerInfo("tempserver", new InetSocketAddress(host, port), "Temp-MOTD", false));
                    return;
                }

                String host = args[0].split(":")[0];
                int port = Integer.parseInt(args[0].split(":")[1]);

                ChatUtil.tell(proxiedPlayer, "&7[&5ConnectCommand&7] &aConnecting to " + args[0] + "...");
                proxiedPlayer.connect(ProxyServer.getInstance().constructServerInfo("tempserver", new InetSocketAddress(host, port), "Temp-MOTD", false));
                return;

            } catch (NumberFormatException e) {
                return;
            }
        }
        ChatUtil.tell(proxiedPlayer, "&7[&5ConnectCommand&7] &fUse /connect [ip]");
    }
}