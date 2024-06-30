plugins {
    id("fabric-loom") version "1.7-SNAPSHOT"
}

group = "com.github.mooziii"
version = "1.0.1"

repositories {
    mavenCentral()
    maven("https://maven.parchmentmc.org")
    maven("https://maven.ladysnake.org/releases")
}

dependencies {
    minecraft("com.mojang:minecraft:1.21")
    mappings(loom.layered {
        //parchment("org.parchmentmc.data:parchment-1.21:2024.06.23@zip") not working
        officialMojangMappings()
    })
    modImplementation("net.fabricmc:fabric-loader:0.15.11")
    modImplementation("net.fabricmc.fabric-api:fabric-api:0.100.4+1.21")
    include(modImplementation("org.ladysnake.cardinal-components-api:cardinal-components-base:6.1.0")!!)
    include(modImplementation("org.ladysnake.cardinal-components-api:cardinal-components-entity:6.1.0")!!)

}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}