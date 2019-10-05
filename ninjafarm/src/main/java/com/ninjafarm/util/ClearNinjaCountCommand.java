package com.ninjafarm.util;

import com.ninjafarm.util.cababilities.ninjacount.NinjaCountProvider;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/*GET
RID
OF
LATER
 */

public class ClearNinjaCountCommand implements ICommand {
    private final List aliases;

    public ClearNinjaCountCommand()
    {
        aliases = new ArrayList();
        aliases.add("clearninjacount");
        aliases.add("cnc");
    }

    @Override
    public String getName() {
        return "clearNinjaCount";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "clearNinjaCount";
    }

    @Override
    public List<String> getAliases() {
        return aliases;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        sender.getEntityWorld().getPlayerEntityByName(sender.getName()).getCapability(NinjaCountProvider.NINJA_COUNT, null).setNinjaCount(0);
        sender.sendMessage(new TextComponentString("Ninja Count: " + sender.getEntityWorld().getPlayerEntityByName(sender.getName()).getCapability(NinjaCountProvider.NINJA_COUNT, null).getNinjaCount()));
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

