package dev.thource.runelite.walkhere;

import java.awt.event.KeyEvent;
import javax.inject.Inject;
import lombok.Getter;
import net.runelite.client.input.KeyListener;

public class WalkHereKeyListener implements KeyListener {

  @Inject private WalkHereConfig config;

  @Getter private boolean pressed;

  @Override
  public void keyTyped(KeyEvent keyEvent) {
    // not needed
  }

  @Override
  public void keyPressed(KeyEvent keyEvent) {
    if (config.keybind().matches(keyEvent)) {
      pressed = true;
    }
  }

  @Override
  public void keyReleased(KeyEvent keyEvent) {
    if (config.keybind().matches(keyEvent)) {
      pressed = false;
    }
  }
}
