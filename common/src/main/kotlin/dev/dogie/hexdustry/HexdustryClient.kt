package dev.dogie.hexdustry

import dev.dogie.hexdustry.config.HexdustryClientConfig
import me.shedaniel.autoconfig.AutoConfig
import net.minecraft.client.gui.screens.Screen

object HexdustryClient {
    fun init() {
        HexdustryClientConfig.init()
    }

    fun getConfigScreen(parent: Screen): Screen {
        return AutoConfig.getConfigScreen(HexdustryClientConfig.GlobalConfig::class.java, parent).get()
    }
}
