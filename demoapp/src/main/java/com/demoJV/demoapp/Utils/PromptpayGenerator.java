package com.demoJV.demoapp.Utils;

public class PromptpayGenerator {

    private PromptpayGenerator(){}
    public static String generatePromptPayPayload(String id, int amount) {
        String formattedAmount = String.format("%.2f", (double)amount);
        String payload = "000201010211"
                + "29370016A000000677010111"
                + String.format("01130066%s", id)
                + "5303764"
                + String.format("5406%04d", (amount * 100))
                + "5802TH"
                + "6304";

        return payload + calculateCRC(payload);
    }

    public static String calculateCRC(String input) {
        int crc = 0xFFFF;
        for (int i = 0; i < input.length(); i++) {
            crc ^= (int) input.charAt(i) << 8;
            for (int j = 0; j < 8; j++) {
                if ((crc & 0x8000) != 0) {
                    crc = (crc << 1) ^ 0x1021;
                } else {
                    crc <<= 1;
                }
            }
        }
        return String.format("%04X", crc & 0xFFFF);
    }
}
