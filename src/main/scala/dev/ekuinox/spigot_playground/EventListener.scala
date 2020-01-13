package dev.ekuinox.spigot_playground

import org.bukkit.block.data.{AnaloguePowerable, BlockData, Lightable, Powerable}
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.metadata.FixedMetadataValue

class EventListener(plugin: Plugin) extends Listener {
  var cnt = 0
  @EventHandler
  def onPlayerInteractEvent(event: PlayerInteractEvent): Unit = {
    val block = event.getClickedBlock
    if (block == null) return

    block.getBlockData match {
      case powerable: AnaloguePowerable => {
        powerable.setPower(15)
        block.setBlockData(powerable)
      }
      case powerable: Powerable => {
        powerable.setPowered(true)
        block.setBlockData(powerable)
      }
      case lightable: Lightable => {
        lightable.setLit(true)
        block.setBlockData(lightable)

        if (block.hasMetadata("foo")) {
          event.getPlayer.sendMessage(block.getMetadata("foo").get(0).asString())
        } else {
          block.setMetadata("foo", new FixedMetadataValue(plugin, s"${cnt += 1}") )
        }

      }
      case _ => println(block.getBlockData.getAsString)
    }

  }
}
