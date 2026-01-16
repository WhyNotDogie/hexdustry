@file:JvmName("HexdustryAbstractionsImpl")

package dev.dogie.hexdustry.forge

import dev.dogie.hexdustry.registry.HexdustryRegistrar
import net.minecraftforge.registries.RegisterEvent
import thedarkcolour.kotlinforforge.forge.MOD_BUS

fun <T : Any> initRegistry(registrar: HexdustryRegistrar<T>) {
    MOD_BUS.addListener { event: RegisterEvent ->
        event.register(registrar.registryKey) { helper ->
            registrar.init(helper::register)
        }
    }
}
