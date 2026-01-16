package dev.dogie.hexdustry.fabric

import dev.dogie.hexdustry.HexdustryClient
import net.fabricmc.api.ClientModInitializer

object FabricHexdustryClient : ClientModInitializer {
    override fun onInitializeClient() {
        HexdustryClient.init()
    }
}
