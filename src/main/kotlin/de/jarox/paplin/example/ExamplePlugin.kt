package de.jarox.paplin.example

import de.jarox.paplin.PaplinPlugin
import de.jarox.paplin.chat.component
import de.jarox.paplin.command.argument
import de.jarox.paplin.command.command
import de.jarox.paplin.command.runs
import de.jarox.paplin.event.listen
import de.jarox.paplin.extension.broadcast
import net.kyori.adventure.text.Component
import org.bukkit.event.block.BlockBreakEvent

class ExamplePlugin : PaplinPlugin() {

    override fun enable() {
        // register a simple command
        command("mycommand") {
            runs {
                // automatically only allow players to execute this command
                player.sendMessage(Component.text("Hello, world!"))
            }

            // simple argument
            argument<String>("message") {
                runs {
                    this.source.sender.sendMessage(component(getArgument("message")))
                }
            }
        }

        // register a simple listener
        listen<BlockBreakEvent> { event ->
            broadcast(event.player.name().append(component(" broke a block!")))
        }
    }
}