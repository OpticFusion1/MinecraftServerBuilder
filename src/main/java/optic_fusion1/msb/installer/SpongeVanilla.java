package optic_fusion1.msb.installer;

public class SpongeVanilla extends Installer {

  @Override
  public void install(String version) {
    try {
      Version ver = Version.valueOf(version.toUpperCase().replaceAll("\\.", "_"));
      versionedSetup("spongevanilla", ver.getUrl(), version);
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
    V1_8_3("https://repo.spongepowered.org/maven/org/spongepowered/spongevanilla/1.8-3.1.0-BETA-171/spongevanilla-1.8-3.1.0-BETA-171.jar"),
    V1_8_9("https://repo.spongepowered.org/maven/org/spongepowered/spongevanilla/1.8.9-4.2.0-BETA-352/spongevanilla-1.8.9-4.2.0-BETA-352.jar"),
    V1_9("https://repo.spongepowered.org/maven/org/spongepowered/spongevanilla/1.9-5.0.0-BETA-17/spongevanilla-1.9-5.0.0-BETA-17.jar"),
    V1_9_4("https://repo.spongepowered.org/maven/org/spongepowered/spongevanilla/1.9.4-5.0.0-BETA-83/spongevanilla-1.9.4-5.0.0-BETA-83.jar"),
    V1_10_2("https://repo.spongepowered.org/maven/org/spongepowered/spongevanilla/1.10.2-5.2.0-BETA-403/spongevanilla-1.10.2-5.2.0-BETA-403.jar"),
    V1_11("https://repo.spongepowered.org/maven/org/spongepowered/spongevanilla/1.11-6.0.0-BETA-190/spongevanilla-1.11-6.0.0-BETA-190.jar"),
    V1_11_2("https://repo.spongepowered.org/maven/org/spongepowered/spongevanilla/1.11.2-6.1.0-BETA-27/spongevanilla-1.11.2-6.1.0-BETA-27.jar"),
    V1_12("https://repo.spongepowered.org/maven/org/spongepowered/spongevanilla/1.12-7.0.0-BETA-307/spongevanilla-1.12-7.0.0-BETA-307.jar"),
    V1_12_1("https://repo.spongepowered.org/maven/org/spongepowered/spongevanilla/1.12.1-7.0.0-BETA-329/spongevanilla-1.12.1-7.0.0-BETA-329.jar"),
    V1_12_2("https://repo.spongepowered.org/maven/org/spongepowered/spongevanilla/1.12.2-7.3.0/spongevanilla-1.12.2-7.3.0.jar");

    private String url;

    Version(String url) {
      this.url = url;
    }

    public String getUrl() {
      return url;
    }
  }

}
