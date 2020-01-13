package dev.ekuinox.spigot_playground

import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class Plugin extends JavaPlugin {
  override def onEnable(): Unit = {
    getServer.getPluginManager.registerEvents(new EventListener(this), this)

    super.onEnable()
  }
}
