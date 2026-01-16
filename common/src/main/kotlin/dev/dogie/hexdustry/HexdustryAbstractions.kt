@file:JvmName("HexdustryAbstractions")

package dev.dogie.hexdustry

import dev.architectury.injectables.annotations.ExpectPlatform
import dev.dogie.hexdustry.registry.HexdustryRegistrar

fun initRegistries(vararg registries: HexdustryRegistrar<*>) {
    for (registry in registries) {
        initRegistry(registry)
    }
}

@ExpectPlatform
fun <T : Any> initRegistry(registrar: HexdustryRegistrar<T>) {
    throw AssertionError()
}
