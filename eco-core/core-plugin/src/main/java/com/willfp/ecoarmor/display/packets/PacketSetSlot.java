package com.willfp.ecoarmor.display.packets;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketContainer;
import com.willfp.eco.util.plugin.AbstractEcoPlugin;
import com.willfp.eco.util.protocollib.AbstractPacketAdapter;
import com.willfp.ecoarmor.display.ArmorDisplay;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PacketSetSlot extends AbstractPacketAdapter {
    /**
     * Instantiate a new listener for {@link PacketType.Play.Server#SET_SLOT}.
     *
     * @param plugin The plugin to listen through.
     */
    public PacketSetSlot(@NotNull final AbstractEcoPlugin plugin) {
        super(plugin, PacketType.Play.Server.SET_SLOT, ListenerPriority.NORMAL, false);
    }

    @Override
    public void onSend(@NotNull final PacketContainer packet,
                       @NotNull final Player player) {
        packet.getItemModifier().modify(0, ArmorDisplay::display);
    }
}