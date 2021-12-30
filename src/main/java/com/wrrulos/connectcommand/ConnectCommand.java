package com.wrrulos.connectcommand;

import com.wrrulos.connectcommand.utils.ChatUtil;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

// https://www.github.com/wrrulos/ConnectCommand

public class ConnectCommand extends Plugin {

    private static ConnectCommand instance;

    public ConnectCommand getInstance() {
        return this.instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new com.wrrulos.connectcommand.commands.ConnectCommand());
        ChatUtil.tell(getProxy().getConsole(), "&7[&5ConnectCommand&7] &aConnectCommand loaded successfully!. &7By &b@wrrulos");

    }
}
