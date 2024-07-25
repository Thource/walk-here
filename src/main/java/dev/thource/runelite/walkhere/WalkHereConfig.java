package dev.thource.runelite.walkhere;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Keybind;

@SuppressWarnings("SameReturnValue")
@ConfigGroup("walkHere")
public interface WalkHereConfig extends Config {

  String CONFIG_GROUP = "walkHere";

  @ConfigItem(
      keyName = "keybind",
      name = "Keybind",
      description = "Move \"walk here\" to the top of the menu when this key is held.")
  default Keybind keybind() {
    return Keybind.CTRL;
  }
}
