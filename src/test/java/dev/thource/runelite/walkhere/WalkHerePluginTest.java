package dev.thource.runelite.walkhere;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class WalkHerePluginTest {

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws Exception {
    ExternalPluginManager.loadBuiltin(WalkHerePlugin.class);
    RuneLite.main(args);
  }
}
