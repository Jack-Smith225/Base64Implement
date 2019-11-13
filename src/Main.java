import Base64Util.MarinZhangBase64Util;

/**
 * @author zy
 */
public class Main {

  public static void main(String[] args) {

    System.out.println("f: " + MarinZhangBase64Util.encode("f".getBytes()).equals("Zg=="));
    System.out.println("fo: " + MarinZhangBase64Util.encode("fo".getBytes()).equals("Zm8="));
    System.out.println("foo: " + MarinZhangBase64Util.encode("foo".getBytes()).equals("Zm9v"));
    System.out.println("foob: " + MarinZhangBase64Util.encode("foob".getBytes()).equals("Zm9vYg=="));
    System.out.println("fooba: " + MarinZhangBase64Util.encode("fooba".getBytes()).equals("Zm9vYmE="));
    System.out.println("foobar: " + MarinZhangBase64Util.encode("foobar".getBytes()).equals("Zm9vYmFy"));
  }
}
