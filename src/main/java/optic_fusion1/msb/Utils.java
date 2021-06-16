package optic_fusion1.msb;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import optic_fusion1.msb.installer.Installer;

public class Utils {

  private static int BUFFER_SIZE = 4096;

  public Utils() {
    super();
  }

  public static boolean download(String urlStr, String output) {
    try {
      URL url = new URL(urlStr);
      try ( BufferedInputStream bis = new BufferedInputStream(url.openStream());  FileOutputStream fis = new FileOutputStream(output)) {
        byte[] buffer = new byte[1024];
        int count = 0;
        while ((count = bis.read(buffer, 0, 1024)) != -1) {
          fis.write(buffer, 0, count);
        }
      }
    } catch (MalformedURLException ex) {
      ex.printStackTrace();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return true;
  }

  // TODO: Make this support linux
  public static void executeCommand(Installer installer, String command) {
    try {
      String[] commands = {"cmd.exe", "/c", command};
      ProcessBuilder builder = new ProcessBuilder(commands);
      builder.directory(new File("data/buildtools"));
      builder.redirectErrorStream(true);
      Process proc = builder.start();
      BufferedReader r = new BufferedReader(new InputStreamReader(proc.getInputStream()));
      String line;
      while (true) {
        line = r.readLine();
        if (line == null) {
          break;
        }
        System.out.println(line);
      }
      int exit = proc.waitFor();
      installer.finishInstall();
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void extract(ZipInputStream zip, File target) throws IOException {
    try (zip) {
      ZipEntry entry;
      while ((entry = zip.getNextEntry()) != null) {
        File file = new File(target, entry.getName());
        if (!file.toPath().normalize().startsWith(target.toPath())) {
          throw new IOException("Bad zip entry");
        }
        if (entry.isDirectory()) {
          file.mkdirs();
          continue;
        }
        byte[] buffer = new byte[BUFFER_SIZE];
        file.getParentFile().mkdirs();
        try ( BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file))) {
          int count;
          while ((count = zip.read(buffer)) != -1) {
            out.write(buffer, 0, count);
          }
        }
      }
    }
  }

}
