@file:JvmName("HexdustryAbstractionsImpl")

package dev.dogie.hexdustry.fabric

import dev.dogie.hexdustry.registry.HexdustryRegistrar
import net.minecraft.core.Registry

fun <T : Any> initRegistry(registrar: HexdustryRegistrar<T>) {
    val registry = registrar.registry
    registrar.init { id, value -> Registry.register(registry, id, value) }
}
