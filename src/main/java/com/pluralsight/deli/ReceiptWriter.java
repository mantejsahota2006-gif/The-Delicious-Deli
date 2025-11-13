package com.pluralsight.deli;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {
    private static final DateTimeFormatter FILE_FMT = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

    public static Path saveOrderReceipt(Order order) throws IOException {
        Path receiptsDir = Path.of("receipts");
        if (!Files.exists(receiptsDir)) Files.createDirectories(receiptsDir);

        String filename = order.getOrderDate().format(FILE_FMT) + ".txt";
        Path file = receiptsDir.resolve(filename);

        Files.writeString(file, order.toReceiptString());
        return file;
    }
}