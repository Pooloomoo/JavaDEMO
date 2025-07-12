package com.demoJV.demoapp.services.Impl;

import com.demoJV.demoapp.Utils.PromptpayGenerator;
import com.demoJV.demoapp.services.PromptPayService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Base64;

@Service
public class PromptPayServicelmpl implements PromptPayService {

    public String generatePromptPayQR(String id, int amount) {
        String payload = PromptpayGenerator.generatePromptPayPayload(id, amount);
        return createQRBase64(payload);
    }

    private String createQRBase64(String payload) {
        try {
            QRCodeWriter writer = new QRCodeWriter();
            BitMatrix bitMatrix = writer.encode(payload, BarcodeFormat.QR_CODE, 300, 300);
            BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "png", baos);
            return Base64.getEncoder().encodeToString(baos.toByteArray());
        } catch (Exception e) {
            throw new RuntimeException("QR code generation failed", e);
        }
    }

}
