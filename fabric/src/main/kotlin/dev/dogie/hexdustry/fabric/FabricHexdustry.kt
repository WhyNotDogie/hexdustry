package dev.dogie.hexdustry.fabric

import dev.dogie.hexdustry.Hexdustry
import net.fabricmc.api.ModInitializer

object FabricHexdustry : ModInitializer {
    override fun onInitialize() {
        Hexdustry.init()
    }
}
