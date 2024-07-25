package dev.thource.runelite.walkhere;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.MenuAction;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.ClientTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.input.KeyManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
    name = "Walk here",
    description = "Adds a configurable keybind to make \"walk here\" left click.",
    tags = {"walk here"})
public class WalkHerePlugin extends Plugin {

  @Inject private Client client;
  @Inject public WalkHereKeyListener keyListener;
  @Inject public KeyManager keyManager;

  @Override
  protected void startUp() {
    keyManager.registerKeyListener(keyListener);
  }

  @Override
  protected void shutDown() {
    keyManager.unregisterKeyListener(keyListener);
  }

  @Subscribe
  public void onClientTick(ClientTick clientTick) {
    if (client.isMenuOpen() || !keyListener.isPressed()) {
      return;
    }

    for (MenuEntry menuEntry : client.getMenuEntries()) {
      MenuAction type = menuEntry.getType();

      if (type != MenuAction.WALK) {
        menuEntry.setDeprioritized(true);
      }
    }
  }

  @Provides
  WalkHereConfig provideConfig(ConfigManager configManager) {
    return configManager.getConfig(WalkHereConfig.class);
  }
}
