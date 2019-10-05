package com.ninjafarm.util;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/*GET
RID
OF
LATER
 */

public class getUUIDCommand implements ICommand
{
    private final List aliases;

    public getUUIDCommand()
    {
        aliases = new ArrayList();
        aliases.add("getUUID");
        aliases.add("getu");
    }

    @Override
    public String getName() {
        return "getUUID";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "getUUID";
    }

    @Override
    public List<String> getAliases() {
        return aliases;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        sender.sendMessage(new TextComponentString("" + sender.getEntityWorld().getPlayerEntityByName(sender.getName()).getUniqueID()));
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        if (sender.getEntityWorld().getPlayerEntityByName(sender.getName()).isCreative()) {
            return true;
        }
        return false;
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }

    @Override
    public int compareTo(ICommand o) {
        return 0;
    }
}
