package dev.dogie.hexdustry.fabric

import com.terraformersmc.modmenu.api.ConfigScreenFactory
import com.terraformersmc.modmenu.api.ModMenuApi
import dev.dogie.hexdustry.HexdustryClient

object FabricHexdustryModMenu : ModMenuApi {
    override fun getModConfigScreenFactory() = ConfigScreenFactory(HexdustryClient::getConfigScreen)
}
