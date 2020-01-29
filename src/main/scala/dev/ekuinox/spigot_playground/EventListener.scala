package dev.ekuinox.spigot_playground

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent

class EventListener(plugin: Plugin) extends Listener {
  @EventHandler
  def onPlayerInteractEvent(event: PlayerInteractEvent): Unit = {
    
  }
}
