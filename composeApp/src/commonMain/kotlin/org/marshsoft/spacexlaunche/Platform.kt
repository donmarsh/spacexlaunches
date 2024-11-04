package org.marshsoft.spacexlaunche

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform