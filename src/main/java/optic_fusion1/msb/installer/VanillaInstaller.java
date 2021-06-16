package optic_fusion1.msb.installer;

/*
Could handle this one better.
Doesn't support nogui and other server arguments.
Could handle versions better too probably
 */
public class VanillaInstaller extends Installer {

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
    System.out.println("Vanilla versions");
    for (Version ver : Version.values()) {
      System.out.println(ver.toString().replaceAll("_", "."));
    }
  }

  @Override
  public void finishInstall() {
  }

  public enum Version {
    C1_2("https://betacraft.pl/server-archive/minecraft/c1.2.zip"),
    C1_3("https://betacraft.pl/server-archive/minecraft/c1.3.zip"),
    C1_4("https://betacraft.pl/server-archive/minecraft/c1.4-1.zip"),
    C1_4_1("https://betacraft.pl/server-archive/minecraft/c1.4.1.zip"),
    C1_6("https://betacraft.pl/server-archive/minecraft/c1.6.zip"),
    C1_8_2("https://betacraft.pl/server-archive/minecraft/c1.8.2.zip"),
    C1_8_3("https://betacraft.pl/server-archive/minecraft/c1.8.3.zip"),
    C1_9_1("https://betacraft.pl/server-archive/minecraft/c1.9.1.zip"),
    C1_10("https://betacraft.pl/server-archive/minecraft/c1.10.zip"),
    C1_10_1("http://web.archive.org/web/20100611210644/http://minecraft.net/minecraft-server.zip"),
    A0_1_0("http://betacraft.pl/server-archive/minecraft/a0.1.0.jar"),
    A0_2_6("http://betacraft.pl/server-archive/minecraft/a0.2.6.jar"),
    B1_0("http://betacraft.pl/server-archive/minecraft/b1.0.jar"),
    B1_0_01("http://betacraft.pl/server-archive/minecraft/b1.0_01.jar"),
    B1_1("http://betacraft.pl/server-archive/minecraft/b1.1.jar"),
    B1_1_01("http://betacraft.pl/server-archive/minecraft/b1.1_01.jar"),
    B1_1_02("https://web.archive.org/web/20101229164428/http://www.minecraft.net/download/minecraft_server.jar?v=1293558297827"),
    B1_2("http://betacraft.pl/server-archive/minecraft/b1.2.jar"),
    B1_2_01("http://betacraft.pl/server-archive/minecraft/b1.2_01.jar"),
    B1_3_01("https://web.archive.org/web/20200601064044/http://betacraft.pl/server-archive/minecraft/b1.3-1.jar"),
    B1_3_02("https://web.archive.org/web/20200601064052/http://betacraft.pl/server-archive/minecraft/b1.3-2.jar"),
    B1_4("http://betacraft.pl/server-archive/minecraft/b1.4.jar"),
    B1_4_01("http://betacraft.pl/server-archive/minecraft/b1.4_01.jar"),
    B1_5("http://betacraft.pl/server-archive/minecraft/b1.5.jar"),
    B1_5_01("http://betacraft.pl/server-archive/minecraft/b1.5_01.jar"),
    B1_5_02("http://betacraft.pl/server-archive/minecraft/b1.5_02.jar"),
    B1_6_PRE("http://betacraft.pl/server-archive/minecraft/b1.6-trailer.jar"),
    B1_6("http://betacraft.pl/server-archive/minecraft/b1.6.jar"),
    B1_6_1("http://betacraft.pl/server-archive/minecraft/b1.6.1.jar"),
    B1_6_2("http://betacraft.pl/server-archive/minecraft/b1.6.2.jar"),
    B1_6_3("http://betacraft.pl/server-archive/minecraft/b1.6.3.jar"),
    B1_6_4("http://betacraft.pl/server-archive/minecraft/b1.6.4.jar"),
    B1_6_5("http://betacraft.pl/server-archive/minecraft/b1.6.5.jar"),
    B1_6_6("http://betacraft.pl/server-archive/minecraft/b1.6.6.jar"),
    B1_7("http://betacraft.pl/server-archive/minecraft/b1.7.jar"),
    B1_7_01("http://betacraft.pl/server-archive/minecraft/b1.7_01.jar"),
    B1_7_2("http://betacraft.pl/server-archive/minecraft/b1.7.2.jar"),
    B1_7_3("http://betacraft.pl/server-archive/minecraft/b1.7.3.jar"),
    B1_8("http://betacraft.pl/server-archive/minecraft/b1.8.jar"),
    B1_8_1("http://betacraft.pl/server-archive/minecraft/b1.8.1.jar"),
    F1_0_0("http://betacraft.pl/server-archive/minecraft/1.0.0.jar"),
    F1_0_1("http://betacraft.pl/server-archive/minecraft/1.0.1.jar"),
    F1_1("https://web.archive.org/web/20120208062853/https://s3.amazonaws.com/MinecraftDownload/launcher/minecraft_server.jar"),
    F1_2_1("http://betacraft.pl/server-archive/minecraft/1.2.1.jar"),
    F1_2_2("http://betacraft.pl/server-archive/minecraft/1.2.2.jar"),
    F1_2_3("http://betacraft.pl/server-archive/minecraft/1.2.3.jar"),
    F1_2_4("http://betacraft.pl/server-archive/minecraft/1.2.4.jar"),
    F1_2_5("https://launcher.mojang.com/v1/objects/d8321edc9470e56b8ad5c67bbd16beba25843336/server.jar"),
    F1_3_1("https://launcher.mojang.com/v1/objects/82563ce498bfc1fc8a2cb5bf236f7da86a390646/server.jar"),
    F1_3_2("https://launcher.mojang.com/v1/objects/3de2ae6c488135596e073a9589842800c9f53bfe/server.jar"),
    F1_4_2("https://launcher.mojang.com/v1/objects/5be700523a729bb78ef99206fb480a63dcd09825/server.jar"),
    F1_4_4("https://launcher.mojang.com/v1/objects/4215dcadb706508bf9d6d64209a0080b9cee9e71/server.jar"),
    F1_4_5("https://launcher.mojang.com/v1/objects/c12fd88a8233d2c517dbc8196ba2ae855f4d36ea/server.jar"),
    F1_4_6("https://launcher.mojang.com/v1/objects/a0aeb5709af5f2c3058c1cf0dc6b110a7a61278c/server.jar"),
    F1_4_7("https://launcher.mojang.com/v1/objects/2f0ec8efddd2f2c674c77be9ddb370b727dec676/server.jar"),
    F1_5("https://launcher.mojang.com/v1/objects/aedad5159ef56d69c5bcf77ed141f53430af43c3/server.jar"),
    F1_5_1("https://launcher.mojang.com/v1/objects/d07c71ee2767dabb79fb32dad8162e1b854d5324/server.jar"),
    F1_5_2("https://launcher.mojang.com/v1/objects/f9ae3f651319151ce99a0bfad6b34fa16eb6775f/server.jar"),
    F1_6_1("https://launcher.mojang.com/v1/objects/0252918a5f9d47e3c6eb1dfec02134d1374a89b4/server.jar"),
    F1_6_2("https://launcher.mojang.com/v1/objects/01b6ea555c6978e6713e2a2dfd7fe19b1449ca54/server.jar"),
    F1_6_4("https://launcher.mojang.com/v1/objects/050f93c1f3fe9e2052398f7bd6aca10c63d64a87/server.jar"),
    F1_7_2("https://launcher.mojang.com/v1/objects/3716cac82982e7c2eb09f83028b555e9ea606002/server.jar"),
    F1_7_4("https://launcher.mojang.com/v1/objects/61220311cef80aecc4cd8afecd5f18ca6b9461ff/server.jar"),
    F1_7_5O("https://betacraft.pl/server-archive/minecraft/1.7.5-1.jar"),
    F1_7_5R("https://launcher.mojang.com/v1/objects/e1d557b2e31ea881404e41b05ec15c810415e060/server.jar"),
    F1_7_6("https://launcher.mojang.com/v1/objects/41ea7757d4d7f74b95fc1ac20f919a8e521e910c/server.jar"),
    F1_7_7("https://launcher.mojang.com/v1/objects/a6ffc1624da980986c6cc12a1ddc79ab1b025c62/server.jar"),
    F1_7_8("https://launcher.mojang.com/v1/objects/c69ebfb84c2577661770371c4accdd5f87b8b21d/server.jar"),
    F1_7_9("https://launcher.mojang.com/v1/objects/4cec86a928ec171fdc0c6b40de2de102f21601b5/server.jar"),
    F1_7_10("https://launcher.mojang.com/v1/objects/952438ac4e01b4d115c5fc38f891710c4941df29/server.jar"),
    F1_8("https://launcher.mojang.com/v1/objects/a028f00e678ee5c6aef0e29656dca091b5df11c7/server.jar"),
    F1_8_1("https://launcher.mojang.com/v1/objects/68bfb524888f7c0ab939025e07e5de08843dac0f/server.jar"),
    F1_8_2("https://launcher.mojang.com/v1/objects/a37bdd5210137354ed1bfe3dac0a5b77fe08fe2e/server.jar"),
    F1_8_3("https://launcher.mojang.com/v1/objects/163ba351cb86f6390450bb2a67fafeb92b6c0f2f/server.jar"),
    F1_8_4("https://launcher.mojang.com/v1/objects/dd4b5eba1c79500390e0b0f45162fa70d38f8a3d/server.jar"),
    F1_8_5("https://launcher.mojang.com/v1/objects/ea6dd23658b167dbc0877015d1072cac21ab6eee/server.jar"),
    F1_8_6("https://launcher.mojang.com/v1/objects/2bd44b53198f143fb278f8bec3a505dad0beacd2/server.jar"),
    F1_8_7("https://launcher.mojang.com/v1/objects/35c59e16d1f3b751cd20b76b9b8a19045de363a9/server.jar"),
    F1_8_8("https://launcher.mojang.com/v1/objects/5fafba3f58c40dc51b5c3ca72a98f62dfdae1db7/server.jar"),
    F1_8_9("https://launcher.mojang.com/v1/objects/b58b2ceb36e01bcd8dbf49c8fb66c55a9f0676cd/server.jar"),
    F1_9("https://launcher.mojang.com/v1/objects/b4d449cf2918e0f3bd8aa18954b916a4d1880f0d/server.jar"),
    F1_9_1("https://launcher.mojang.com/v1/objects/bf95d9118d9b4b827f524c878efd275125b56181/server.jar"),
    F1_9_2("https://launcher.mojang.com/v1/objects/2b95cc7b136017e064c46d04a5825fe4cfa1be30/server.jar"),
    F1_9_3("https://launcher.mojang.com/v1/objects/8e897b6b6d784f745332644f4d104f7a6e737ccf/server.jar"),
    F1_9_4("https://launcher.mojang.com/v1/objects/edbb7b1758af33d365bf835eb9d13de005b1e274/server.jar"),
    F1_10("https://launcher.mojang.com/v1/objects/a96617ffdf5dabbb718ab11a9a68e50545fc5bee/server.jar"),
    F1_10_1("https://launcher.mojang.com/v1/objects/cb4c6f9f51a845b09a8861cdbe0eea3ff6996dee/server.jar"),
    F1_10_2("https://launcher.mojang.com/v1/objects/3d501b23df53c548254f5e3f66492d178a48db63/server.jar"),
    F1_11("https://launcher.mojang.com/v1/objects/48820c84cb1ed502cb5b2fe23b8153d5e4fa61c0/server.jar"),
    F1_11_1("https://launcher.mojang.com/v1/objects/1f97bd101e508d7b52b3d6a7879223b000b5eba0/server.jar"),
    F1_11_2("https://launcher.mojang.com/v1/objects/f00c294a1576e03fddcac777c3cf4c7d404c4ba4/server.jar"),
    F1_12("https://launcher.mojang.com/v1/objects/8494e844e911ea0d63878f64da9dcc21f53a3463/server.jar"),
    F1_12_1("https://launcher.mojang.com/v1/objects/561c7b2d54bae80cc06b05d950633a9ac95da816/server.jar"),
    F1_12_2("https://launcher.mojang.com/v1/objects/886945bfb2b978778c3a0288fd7fab09d315b25f/server.jar"),
    F1_13("https://launcher.mojang.com/v1/objects/d0caafb8438ebd206f99930cfaecfa6c9a13dca0/server.jar"),
    F1_13_1("https://launcher.mojang.com/v1/objects/fe123682e9cb30031eae351764f653500b7396c9/server.jar"),
    F1_13_2("https://launcher.mojang.com/v1/objects/3737db93722a9e39eeada7c27e7aca28b144ffa7/server.jar"),
    F1_14("https://launcher.mojang.com/v1/objects/f1a0073671057f01aa843443fef34330281333ce/server.jar"),
    F1_14_1("https://launcher.mojang.com/v1/objects/ed76d597a44c5266be2a7fcd77a8270f1f0bc118/server.jar"),
    F1_14_2("https://launcher.mojang.com/v1/objects/808be3869e2ca6b62378f9f4b33c946621620019/server.jar"),
    F1_14_3("https://launcher.mojang.com/v1/objects/d0d0fe2b1dc6ab4c65554cb734270872b72dadd6/server.jar"),
    F1_14_4("https://launcher.mojang.com/v1/objects/46a7ba37c15820f00d49eafb38afb4a9bb64a0be/server.txt"),
    F1_15("https://launcher.mojang.com/v1/objects/e9f105b3c5c7e85c7b445249a93362a22f62442d/server.jar"),
    F1_15_1("https://launcher.mojang.com/v1/objects/d10e23f8def30fcf7d0a0d027f48f2731d80208f/server.txt"),
    F1_15_2("https://launcher.mojang.com/v1/objects/e018f7413ad5b98d7427bc3027c95c78845e891b/server.txt"),
    F1_16O("https://launcher.mojang.com/v1/objects/7361a24df069a06748844cc7483c35d4abd2d80c/server.jar"),
    F1_16R("https://launcher.mojang.com/v1/objects/a0d03225615ba897619220e256a266cb33a44b6b/server.jar"),
    F1_16_1("https://launcher.mojang.com/v1/objects/a412fd69db1f81db3f511c1463fd304675244077/server.jar"),
    F1_16_2("https://launcher.mojang.com/v1/objects/c5f6fb23c3876461d46ec380421e42b289789530/server.jar"),
    F1_16_3("https://launcher.mojang.com/v1/objects/f02f4473dbf152c23d7d484952121db0b36698cb/server.jar"),
    F1_16_4("https://launcher.mojang.com/v1/objects/35139deedbd5182953cf1caa23835da59ca3d7cd/server.jar"),
    F1_16_5("https://launcher.mojang.com/v1/objects/1b557e7b033b583cd9f66746b7a9ab1ec1673ced/server.jar");

    private String url;

    Version(String url) {
      this.url = url;
    }

    public String getUrl() {
      return url;
    }
  }

}
