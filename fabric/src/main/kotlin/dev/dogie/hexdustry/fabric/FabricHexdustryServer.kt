package dev.dogie.hexdustry.fabric

import dev.dogie.hexdustry.Hexdustry
import net.fabricmc.api.DedicatedServerModInitializer

object FabricHexdustryServer : DedicatedServerModInitializer {
    override fun onInitializeServer() {
        Hexdustry.initServer()
    }
}
