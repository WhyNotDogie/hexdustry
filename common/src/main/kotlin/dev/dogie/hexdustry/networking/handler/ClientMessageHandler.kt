package dev.dogie.hexdustry.networking.handler

import dev.architectury.networking.NetworkManager.PacketContext
import dev.dogie.hexdustry.config.HexdustryServerConfig
import dev.dogie.hexdustry.networking.msg.*

fun HexdustryMessageS2C.applyOnClient(ctx: PacketContext) = ctx.queue {
    when (this) {
        is MsgSyncConfigS2C -> {
            HexdustryServerConfig.onSyncConfig(serverConfig)
        }

        // add more client-side message handlers here
    }
}
