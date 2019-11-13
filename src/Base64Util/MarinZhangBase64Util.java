package Base64Util;

/**
 * @author zy
 * 有相关经验的 网友的 博客参考：
 * https://blog.csdn.net/Newpidian/article/details/52751784
 */
public class MarinZhangBase64Util {

  /**
   * 64个base字符+一个=号字符
   * 注意alphabet[64] 为等号
   */
  private static final char[] Base64Alphabet =
    "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();

  /**
   * 将原始数据字节数组编码成为base64字符串
   *
   * @param byteArrayToEncode
   * @return
   */
  public static String encode(byte[] byteArrayToEncode) {
    // ##### 如何理解 扩充长度需要 ( length + 2 )/3 * 4
    // Answer： 为了保证 给结果数组 分配足够的 空间
    char[] resultCharArray = new char[((byteArrayToEncode.length + 2) / 3) * 4];
    for (int indexOfByteArrayToEncode = 0, index = 0; indexOfByteArrayToEncode < byteArrayToEncode.length;
         indexOfByteArrayToEncode += 3, index += 4
    ) {

      // tag::取 3个 8位字节
      boolean isThirdExist = false;
      boolean isSecondExist = false;
      int val = (0xFF & (int) byteArrayToEncode[indexOfByteArrayToEncode]);//取得 第一个 八位字节的 值
      val <<= 8;

      if ((indexOfByteArrayToEncode + 1) < byteArrayToEncode.length) {
        val |= (
          0xFF & (int) byteArrayToEncode[indexOfByteArrayToEncode + 1]
        );
        isSecondExist = true;
      }
      val <<= 8;

      if ((indexOfByteArrayToEncode + 2) < byteArrayToEncode.length) {
        val |= (0xFF & (int) byteArrayToEncode[indexOfByteArrayToEncode + 2]);
        isThirdExist = true;
      }
      // end::取 3个 8位字节

      // tag::将3个8位字节 转换为 4个6位字节
      resultCharArray[index + 3] = Base64Alphabet[isThirdExist ? val & 0x3F : 64];val >>= 6;
      resultCharArray[index + 2] = Base64Alphabet[isSecondExist ? val & 0x3F : 64];val >>= 6;
      resultCharArray[index + 1] = Base64Alphabet[val & 0x3F];val >>= 6;
      resultCharArray[index + 0] = Base64Alphabet[val & 0x3F];
      // tag::将3个8位字节 转换为 4个6位字节
    }
    return String.valueOf(resultCharArray);
  }
}
