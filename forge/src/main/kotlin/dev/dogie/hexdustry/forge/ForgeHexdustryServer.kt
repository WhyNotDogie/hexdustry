package dev.dogie.hexdustry.forge

import dev.dogie.hexdustry.Hexdustry
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent

object ForgeHexdustryServer {
    @Suppress("UNUSED_PARAMETER")
    fun init(event: FMLDedicatedServerSetupEvent) {
        Hexdustry.initServer()
    }
}
