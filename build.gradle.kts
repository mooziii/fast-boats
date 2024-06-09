plugins {
    id("fabric-loom") version "1.6-SNAPSHOT"
}

group = "com.github.mooziii"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://maven.parchmentmc.org")
    maven("https://maven.ladysnake.org/releases")
}

dependencies {
    minecraft("com.mojang:minecraft:1.20.6")
    mappings(loom.layered {
        parchment("org.parchmentmc.data:parchment-1.20.6:2024.05.01@zip")
        officialMojangMappings()
    })
    modImplementation("net.fabricmc:fabric-loader:0.15.11")
    modImplementation("net.fabricmc.fabric-api:fabric-api:0.99.0+1.20.6")
    include(modImplementation("org.ladysnake.cardinal-components-api:cardinal-components-base:6.0.0-rc1")!!)
    include(modImplementation("org.ladysnake.cardinal-components-api:cardinal-components-entity:6.0.0-rc1")!!)

}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}