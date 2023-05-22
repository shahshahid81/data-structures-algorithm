public class MultiplyString {
    public String multiply(String a, String b) {
        int aLength = a.length(), bLength = b.length(); 
        if(aLength == 0 && bLength == 0) return "0";
        if(a.equals("0") || b.equals("0")) return "0";
        if(a.equals("1")) return b;
        if(b.equals("1")) return a;

        int[] result = new int[aLength + bLength];
        int aIndex = 0, bIndex = 0;

        for(int i = aLength - 1; i >= 0; i--) {
            int carry = 0;
            int num1 = a.charAt(i) - '0';

            bIndex = 0;
            for(int j = bLength - 1; j >= 0; j--) {
                int num2 = b.charAt(j) - '0';
                int sum = num1 * num2 + result[aIndex + bIndex] + carry;

                carry = sum / 10;
                result[aIndex + bIndex] = sum % 10;
                bIndex++;
            }

            if(carry > 0) {
                result[aIndex + bIndex] += carry;
            }

            aIndex++;
        }

        int i = result.length - 1;
        while(i >= 0 && result[i] == 0) i--;

        StringBuilder sb = new StringBuilder(i + 1);

        while(i >= 0) sb.append(result[i--]);

        return sb.toString();
    }
}