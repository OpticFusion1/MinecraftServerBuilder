package optic_fusion1.msb;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import optic_fusion1.msb.installer.GlowstoneInstaller;
import optic_fusion1.msb.installer.Installer;
import optic_fusion1.msb.installer.SpigotInstaller;
import optic_fusion1.msb.installer.SpongeForge;
import optic_fusion1.msb.installer.SpongeVanilla;
import optic_fusion1.msb.installer.VanillaInstaller;

public class MSB extends Thread {

  private static final Scanner SCANNER = new Scanner(System.in);
  private static final Map<String, Installer> INSTALLERS = new HashMap<>();
  private boolean running = true;

  public MSB() {
    INSTALLERS.put("vanilla", new VanillaInstaller());
    INSTALLERS.put("spigot", new SpigotInstaller());
    INSTALLERS.put("spongevanilla", new SpongeVanilla());
    INSTALLERS.put("spongeforge", new SpongeForge());
    INSTALLERS.put("glowstone", new GlowstoneInstaller());
  }

  @Override
  public void run() {
    System.out.println("Use the 'help' command to get a help menu");
    while (running) {
      handleInput();
    }
  }

  private void handleInput() {
    String input = SCANNER.nextLine();
    if (input.equalsIgnoreCase("help")) {
      printHelp();
      return;
    } else if (input.equalsIgnoreCase("exit")) {
      running = false;
      return;
    } else if (input.toLowerCase().startsWith("listversions")) {
      String[] args = input.split(" ");
      if (args.length != 2) {
        System.out.println("You did not enter enough arguments");
        return;
      }
      if (!INSTALLERS.containsKey(args[1].toLowerCase())) {
        System.out.println(args[1] + " is not a valid server type");
        return;
      }
      INSTALLERS.get(args[1]).listVersions();
      return;
    } else if (input.toLowerCase().startsWith("setup")) {
      String[] args = input.split(" ");
      if (args.length != 3) {
        System.out.println("You did not enter enough arguments");
        return;
      }
      if (!INSTALLERS.containsKey(args[1].toLowerCase())) {
        System.out.println(args[1] + " is not a valid server type");
        return;
      }
      INSTALLERS.get(args[1]).install(args[2]);
      return;
    }
    System.out.println("You did not enter a valid command");
    printHelp();
  }

  private void printHelp() {
    String help = """
                  install vanilla
                  listversions vanilla
                  exit - exit the program
                  """;
    System.out.println(help);
  }

}
