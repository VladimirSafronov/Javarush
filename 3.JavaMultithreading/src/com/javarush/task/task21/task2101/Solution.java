package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/

public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] netAddress = new byte[ip.length];
        String ipStr = "";
        String maskStr = "";

        for (int i = 0; i < ip.length; i++) {
            ipStr = toBinar(ip[i]);
            maskStr = toBinar(mask[i]);
            netAddress[i] =(byte) toDecimal(conjunction(ipStr, maskStr));
        }
        return netAddress;
    }

    public static void print(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(toBinar(bytes[i])).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    public static int toDecimal(String binNumber) {
        int ans = 0;
        int count = 128;
        for (int i = 0; i < binNumber.length(); i++) {
            ans += count * Integer.parseInt(String.valueOf(binNumber.charAt(i)));
            count /= 2;
        }
        return ans;
    }

    public static String toBinar(int value) {
        if (value < 0) {
            value = 255 + value + 1;
        }
        StringBuilder ans = new StringBuilder();
        while (value != 0) {
            ans.append(value % 2);
            value /= 2;
        }
        int count = 8;
        while (ans.length() != count) {
            ans.append("0");
        }
        return ans.reverse().toString();
    }

    public static String conjunction(String value1, String value2) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < value1.length(); i++) {
            if (String.valueOf(value1.charAt(i)).equals("1") && String.valueOf(value2.charAt(i)).equals("1")) {
                ans.append("1");
            } else {
                ans.append("0");
            }
        }
        return ans.toString();
    }
}
