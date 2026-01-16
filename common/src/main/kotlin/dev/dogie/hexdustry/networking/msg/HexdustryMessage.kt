package dev.dogie.hexdustry.networking.msg

import dev.architectury.networking.NetworkChannel
import dev.architectury.networking.NetworkManager.PacketContext
import dev.dogie.hexdustry.Hexdustry
import dev.dogie.hexdustry.networking.HexdustryNetworking
import dev.dogie.hexdustry.networking.handler.applyOnClient
import dev.dogie.hexdustry.networking.handler.applyOnServer
import net.fabricmc.api.EnvType
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.server.level.ServerPlayer
import java.util.function.Supplier

sealed interface HexdustryMessage

sealed interface HexdustryMessageC2S : HexdustryMessage {
    fun sendToServer() {
        HexdustryNetworking.CHANNEL.sendToServer(this)
    }
}

sealed interface HexdustryMessageS2C : HexdustryMessage {
    fun sendToPlayer(player: ServerPlayer) {
        HexdustryNetworking.CHANNEL.sendToPlayer(player, this)
    }

    fun sendToPlayers(players: Iterable<ServerPlayer>) {
        HexdustryNetworking.CHANNEL.sendToPlayers(players, this)
    }
}

sealed interface HexdustryMessageCompanion<T : HexdustryMessage> {
    val type: Class<T>

    fun decode(buf: FriendlyByteBuf): T

    fun T.encode(buf: FriendlyByteBuf)

    fun apply(msg: T, supplier: Supplier<PacketContext>) {
        val ctx = supplier.get()
        when (ctx.env) {
            EnvType.SERVER, null -> {
                Hexdustry.LOGGER.debug("Server received packet from {}: {}", ctx.player.name.string, this)
                when (msg) {
                    is HexdustryMessageC2S -> msg.applyOnServer(ctx)
                    else -> Hexdustry.LOGGER.warn("Message not handled on server: {}", msg::class)
                }
            }
            EnvType.CLIENT -> {
                Hexdustry.LOGGER.debug("Client received packet: {}", this)
                when (msg) {
                    is HexdustryMessageS2C -> msg.applyOnClient(ctx)
                    else -> Hexdustry.LOGGER.warn("Message not handled on client: {}", msg::class)
                }
            }
        }
    }

    fun register(channel: NetworkChannel) {
        channel.register(type, { msg, buf -> msg.encode(buf) }, ::decode, ::apply)
    }
}
