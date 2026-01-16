package dev.dogie.hexdustry.networking

import dev.architectury.networking.NetworkChannel
import dev.dogie.hexdustry.Hexdustry
import dev.dogie.hexdustry.networking.msg.HexdustryMessageCompanion

object HexdustryNetworking {
    val CHANNEL: NetworkChannel = NetworkChannel.create(Hexdustry.id("networking_channel"))

    fun init() {
        for (subclass in HexdustryMessageCompanion::class.sealedSubclasses) {
            subclass.objectInstance?.register(CHANNEL)
        }
    }
}
