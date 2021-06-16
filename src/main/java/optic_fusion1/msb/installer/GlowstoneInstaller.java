package optic_fusion1.msb.installer;

public class GlowstoneInstaller extends Installer {

  @Override
  public void install(String version) {
    basicSetup("glowstone", "https://github.com/GlowstoneMC/Glowstone/releases/download/2018.9.0/glowstone.jar");
  }

  @Override
  public void listVersions() {
    System.out.println("latest");
  }

  @Override
  public void finishInstall() {
  }

}
