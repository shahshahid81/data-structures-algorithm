import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddress {

  public List<String> restoreIpAddresses(String s) {
    int n = s.length();

    List<String> result = new ArrayList<>();
    if (n <= 3) {
      return result;
    }

    restoreIpAddresses(s, n, 0, result, new ArrayList<>(), new StringBuilder());

    return result;
  }

  private void restoreIpAddresses(
    String s,
    int n,
    int index,
    List<String> result,
    ArrayList<String> octets,
    StringBuilder octet
  ) {
    if (index >= n) {
      if (octets.size() == 4) {
        StringBuilder ip = new StringBuilder();
        for (String oct : octets) {
          ip.append(oct);
          ip.append(".");
        }
        ip.setLength(ip.length() - 1);
        result.add(ip.toString());
      }
      return;
    }

    for (int i = index; i < n; i++) {
      int start = i;
      if (octets.size() == 3) {
        while (i < n) {
          octet.append(s.charAt(i++));
        }
        i--;
      } else {
        octet.append(s.charAt(i));
      }

      octets.add(octet.toString());
      if (isValidOctet(octets, octet, n, start)) {
        restoreIpAddresses(s, n, i + 1, result, octets, new StringBuilder());
      }
      octets.remove(octets.size() - 1);

      if (octets.size() == 3) {
        break;
      } else {
        i = start;
      }
    }
  }

  private boolean isValidOctet(
    ArrayList<String> octets,
    StringBuilder octet,
    int n,
    int index
  ) {
    int octetLength = octet.length();
    if (octetLength > 3) {
      return false;
    }

    int value = Integer.parseInt(octet.toString());
    if (value < 0 || value > 255) {
      return false;
    }

    if (octetLength > 1 && octet.charAt(0) == '0') {
      return false;
    }

    return true;
  }
}
