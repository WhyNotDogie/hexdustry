package dev.dogie.hexdustry.forge

import dev.architectury.platform.forge.EventBuses
import dev.dogie.hexdustry.Hexdustry
import dev.dogie.hexdustry.forge.datagen.ForgeHexdustryDatagen
import net.minecraftforge.fml.common.Mod
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(Hexdustry.MODID)
class ForgeHexdustry {
    init {
        MOD_BUS.apply {
            EventBuses.registerModEventBus(Hexdustry.MODID, this)
            addListener(ForgeHexdustryClient::init)
            addListener(ForgeHexdustryDatagen::init)
            addListener(ForgeHexdustryServer::init)
        }
        Hexdustry.init()
    }
}
