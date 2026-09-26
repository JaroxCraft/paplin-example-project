package de.jarox.paplin.example

import de.jarox.paplin.PaplinPlugin
import de.jarox.paplin.chat.component
import de.jarox.paplin.event.listen
import de.jarox.paplin.extension.broadcast
import de.jarox.paplin.scheduler.runSync
import dev.jorel.commandapi.kotlindsl.anyExecutor
import dev.jorel.commandapi.kotlindsl.commandTree
import dev.jorel.commandapi.kotlindsl.greedyStringArgument
import net.kyori.adventure.text.Component
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.player.PlayerJoinEvent

class ExamplePlugin : PaplinPlugin() {
    override fun enable() {
        // register a simple command
        commandTree("mycommand") {
            anyExecutor { sender, _ ->
                sender.sendMessage(Component.text("Hello, world!"))
            }

            greedyStringArgument("message") {
                anyExecutor { sender, args ->
                    val message = args["message"] as String
                    sender.sendMessage(component(message))
                }
            }
        }

        // register a simple listener
        listen<BlockBreakEvent>(this) {
            broadcast(component("${it.player.name} broke a block!"))
        }

        // greet joining players one second (20 ticks) later
        listen<PlayerJoinEvent>(this) {
            val player = it.player
            runSync(ticks = 20) {
                player.sendMessage(component("Welcome, ${player.name}!"))
            }
        }
    }
}
