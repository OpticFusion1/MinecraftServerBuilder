package optic_fusion1.msb.installer;

public class BungeeCordInstaller extends Installer {

  @Override
  public void install(String version) {
    try {
      Version ver = Version.valueOf(version.toUpperCase().replaceAll("\\.", "_"));
      versionedSetup("bungeecord", ver.getUrl(), version);
    } catch (Exception e) {
    }
  }

  @Override
  public void listVersions() {
    System.out.println("BungeeCord versions");
    for (SpongeForge.Version ver : SpongeForge.Version.values()) {
      System.out.println(ver.toString().replaceAll("_", "."));
    }
  }

  @Override
  public void finishInstall() {
  }

  public enum Version {
    v1_4_7("https://ci.md-5.net/job/BungeeCord/251/artifact/bootstrap/target/BungeeCord.jar"),
    v1_5_0("https://ci.md-5.net/job/BungeeCord/386/artifact/bootstrap/target/BungeeCord.jar"),
    v1_5_2("https://ci.md-5.net/job/BungeeCord/548/artifact/bootstrap/target/BungeeCord.jar"),
    v1_6_2("https://ci.md-5.net/job/BungeeCord/666/artifact/bootstrap/target/BungeeCord.jar"),
    v1_6_4("https://ci.md-5.net/job/BungeeCord/701/artifact/bootstrap/target/BungeeCord.jar"),
    v1_7_10("https://ci.md-5.net/job/BungeeCord/1119/artifact/bootstrap/target/BungeeCord.jar"),
    latest("https://ci.md-5.net/job/BungeeCord/lastSuccessfulBuild/artifact/bootstrap/target/BungeeCord.jar");

    private String url;

    Version(String url) {
      this.url = url;
    }

    public String getUrl() {
      return url;
    }
  }

}
