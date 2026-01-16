package dev.dogie.hexdustry

import net.minecraft.resources.ResourceLocation
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import dev.dogie.hexdustry.config.HexdustryServerConfig
import dev.dogie.hexdustry.networking.HexdustryNetworking
import dev.dogie.hexdustry.registry.HexdustryActions

object Hexdustry {
    const val MODID = "hexdustry"

    @JvmField
    val LOGGER: Logger = LogManager.getLogger(MODID)

    @JvmStatic
    fun id(path: String) = ResourceLocation(MODID, path)

    fun init() {
        HexdustryServerConfig.init()
        initRegistries(
            HexdustryActions,
        )
        HexdustryNetworking.init()
    }

    fun initServer() {
        HexdustryServerConfig.initServer()
    }
}
