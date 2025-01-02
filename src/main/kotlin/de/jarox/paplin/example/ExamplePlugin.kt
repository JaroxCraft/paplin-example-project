package de.jarox.paplin.example

import de.jarox.paplin.PaplinPlugin

@Suppress("unused")
class ExamplePlugin : PaplinPlugin() {
    override fun enable() {
        logger.info("Hello, Paplin!")
    }
}