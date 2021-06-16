package optic_fusion1.msb.installer;

public class SpongeForge extends Installer {

  @Override
  public void install(String version) {
    try {
      Version ver = Version.valueOf(version.toUpperCase().replaceAll("\\.", "_"));
      versionedSetup("spongeforge", ver.getUrl(), version);
    } catch (Exception e) {
      System.out.println(version + " is not a supported version");
    }
  }

  @Override
  public void listVersions() {
    System.out.println("SpongeVanilla versions");
    for (Version ver : Version.values()) {
      System.out.println(ver.toString().replaceAll("_", "."));
    }
  }

  @Override
  public void finishInstall() {
  }

  public enum Version {

    V1_10_2("https://repo.spongepowered.org/maven/org/spongepowered/spongeforge/1.10.2-2477-5.2.0-BETA-2793/spongeforge-1.10.2-2477-5.2.0-BETA-2793.jar"),
    V1_11("https://repo.spongepowered.org/maven/org/spongepowered/spongeforge/1.11-2195-6.0.0-BETA-2004/spongeforge-1.11-2195-6.0.0-BETA-2004.jar"),
    V1_11_2("https://repo.spongepowered.org/maven/org/spongepowered/spongeforge/1.11.2-2476-6.1.0-BETA-2792/spongeforge-1.11.2-2476-6.1.0-BETA-2792.jar"),
    V1_12("https://repo.spongepowered.org/maven/org/spongepowered/spongeforge/1.12-2443-7.0.0-BETA-2498/spongeforge-1.12-2443-7.0.0-BETA-2498.jar"),
    V1_12_1("https://repo.spongepowered.org/maven/org/spongepowered/spongeforge/1.12.1-2480-7.0.0-BETA-2643/spongeforge-1.12.1-2480-7.0.0-BETA-2643.jar"),
    V1_12_2("https://repo.spongepowered.org/maven/org/spongepowered/spongeforge/1.12.2-2838-7.3.0/spongeforge-1.12.2-2838-7.3.0.jar");

    private String url;

    Version(String url) {
      this.url = url;
    }

    public String getUrl() {
      return url;
    }

  }

}
