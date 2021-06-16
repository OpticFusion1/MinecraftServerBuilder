package optic_fusion1.msb.installer;

// TODO: Automatically gather the latest of every supported version
public class PaperInstaller extends Installer {

  @Override
  public void install(String version) {
    try {
      Version ver = Version.valueOf(version.toUpperCase().replaceAll("\\.", "_"));
      versionedSetup("vanilla", ver.getUrl(), version);
    } catch (Exception e) {
      System.out.println(version + " is not a supported version");
    }
  }

  @Override
  public void listVersions() {
  }

  @Override
  public void finishInstall() {
  }

  /*
latest - Do something with this https://papermc.io/api/v2/projects/paper/versions/1.16.5/
   */
  public enum Version {
    v1_8_8("https://papermc.io/api/v2/projects/paper/versions/1.8.8/builds/443/downloads/paper-1.8.8-443.jar"),
    v1_9_4("https://papermc.io/api/v2/projects/paper/versions/1.9.4/builds/773/downloads/paper-1.9.4-773.jar"),
    v1_10_2("https://papermc.io/api/v2/projects/paper/versions/1.10.2/builds/916/downloads/paper-1.10.2-916.jar"),
    v1_11_2("https://papermc.io/api/v2/projects/paper/versions/1.11.2/builds/1104/downloads/paper-1.11.2-1104.jar"),
    v1_12_2("https://papermc.io/api/v2/projects/paper/versions/1.12.2/builds/1618/downloads/paper-1.12.2-1618.jar"),
    v1_13_2("https://papermc.io/api/v2/projects/paper/versions/1.13.2/builds/655/downloads/paper-1.13.2-655.jar"),
    v1_14_4("https://papermc.io/api/v2/projects/paper/versions/1.14.4/builds/243/downloads/paper-1.14.4-243.jar"),
    v1_15_2("https://papermc.io/api/v2/projects/paper/versions/1.15.2/builds/391/downloads/paper-1.15.2-391.jar");

    String url;

    Version(String url) {
      this.url = url;
    }

    public String getUrl() {
      return url;
    }
  }

}
