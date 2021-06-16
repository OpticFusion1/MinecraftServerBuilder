package optic_fusion1.msb.installer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.zip.ZipInputStream;
import optic_fusion1.msb.Utils;

public abstract class Installer {

  public abstract void install(String version);

  public abstract void listVersions();

  public abstract void finishInstall();

  // Support .sh files
  public void setup(File dir) {
    try {
      try ( PrintWriter pw = new PrintWriter(dir + "/eula.txt")) {
        pw.write("eula=true");
      }
      try ( PrintWriter pw = new PrintWriter(dir + "/run.bat")) {
        pw.write("java -jar server.jar");
        pw.write("\nPAUSE");
      }
    } catch (FileNotFoundException ex) {
      ex.printStackTrace();
    }
  }

  public File setupDir(String name) {
    File f = new File(name);
    if (!f.exists()) {
      f.mkdirs();
    }
    return f;
  }

  public File setupOutput(String dir, String output) {
    File f = new File(dir, output);
    if (!f.exists()) {
      try {
        f.createNewFile();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
    return f;
  }

  public void basicSetup(String serverType, String url) {
    setupDir("data/" + serverType);
    System.out.println("Downloading server jar");
    Utils.download(url, "data/" + serverType + "/server.jar");
    System.out.println("Finished downloading the server jar");
    setup(new File("data/" + serverType));
    System.out.println("Finished setting up " + serverType.toUpperCase());
  }

  public void versionedSetup(String serverType, String url, String version) {
    try {
      System.out.println("Downloading server jar");
      while (!Utils.download(url, "data" + (url.endsWith(".jar") ? ".jar" : ".zip"))) {

      }
      System.out.println("Finished downloading server jar");
      File serverDir = new File("data/" + serverType, version);
      if (!serverDir.exists()) {
        serverDir.mkdirs();
      }
      System.out.println("Extracting server jar");
      if (!url.endsWith(".jar")) {
        Utils.extract(new ZipInputStream(new FileInputStream(new File("data.zip"))), serverDir);
      } else {
        Files.move(new File("data.jar").toPath(), new File(serverDir, "server.jar").toPath());
      }
      setup(serverDir);
      System.out.println("Finished setting up " + serverType.toUpperCase() + " v" + version.toUpperCase());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
