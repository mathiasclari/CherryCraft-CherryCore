/*
 * (c) 2024 CherryCraft. All rights reserved.
 *
 *  This software is the confidential and proprietary information of CherryCraft
 *  ("Confidential Information"). You shall not disclose such Confidential Information
 *  and shall use it only in accordance with the terms of the license agreement you
 *  entered into with CherryCraft.
 *
 *  UNAUTHORIZED COPYING, DISTRIBUTION, OR REPRODUCTION OF THIS SOFTWARE, IN WHOLE OR
 *  IN PART, IS STRICTLY PROHIBITED. UNLESS OTHERWISE EXPRESSLY AGREED UPON IN A
 *  WRITTEN AGREEMENT, CHERRYCRAFT PROVIDES THIS SOFTWARE "AS IS" WITHOUT WARRANTY OF ANY
 *  KIND, EITHER EXPRESS OR IMPLIED, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, OR
 *  NON-INFRINGEMENT.
 *
 *  For inquiries, please contact CherryCraft at copyright@cherrycraft.net.
 */

package net.cherrycraft.cherrycore.listener;

import net.cherrycraft.cherrycore.CherryCore;
import net.cherrycraft.cherrycore.command.CommandManager;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandListener implements CommandExecutor {

    private final CherryCore plugin;
    private CommandManager commandManager;

    public CommandListener(CherryCore plugin) {
        this.plugin = plugin;
        this.commandManager = plugin.getCommandManager();
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String commandname, String[] args) {
        if (this.commandManager == null) {
            this.commandManager = new CommandManager(this.plugin);
        }
        return commandManager.runCommand(sender, commandname, args);
    }
}
