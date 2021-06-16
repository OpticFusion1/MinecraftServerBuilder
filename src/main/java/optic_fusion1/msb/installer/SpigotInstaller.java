package optic_fusion1.msb.installer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import optic_fusion1.msb.Utils;

// Might be able to improve this, can't think of a way though
public class SpigotInstaller extends Installer {

  private String version;

  @Override
  public void install(String version) {
    this.version = version;
    System.out.println("Creating folders");
    File f = setupDir("data/buildtools");
    File output = setupOutput("data/buildtools", "BuildTools.jar");
    setupDir("data/spigot/" + version);
    System.out.println("Finished creating folders");
    System.out.println("Downloading BuildTools");
    Utils.download("https://hub.spigotmc.org/jenkins/job/BuildTools/lastSuccessfulBuild/artifact/target/BuildTools.jar", output.toString());
    System.out.println("Finished downloading BuildTools");
    // TODO: Support linux properly
    System.out.println("Running BuildTools.jar with version " + version);
    Utils.executeCommand(this, "cd " + f.getAbsolutePath() + " && java -jar BuildTools.jar --rev " + version);
  }

  @Override
  public void listVersions() {
    System.out.println("Check https://www.spigotmc.org/wiki/buildtools/ for a list of supported versions");
  }

  @Override
  public void finishInstall() {
    File file = null;
    for (File f : new File("data", "buildtools").listFiles()) {
      if (f.getName().contains("spigot")) {
        file = f;
        break;
      }
    }
    if (file == null) {
      System.out.println("Couldn't find compiled spigot jar");
      return;
    }
    System.out.println("Copying " + file.getName() + " to data/spigot/" + version);
    try {
      Files.move(new File("data/buildtools/", file.getName()).toPath(), new File("data/spigot/" + version + "/server.jar").toPath());
    } catch (IOException ex) {
      System.out.println(file + " already exists in data/spigot/" + version);
    }
    setup(new File("data/spigot", version));
    System.out.println("Finished setting up spigot v" + version);
  }

}
