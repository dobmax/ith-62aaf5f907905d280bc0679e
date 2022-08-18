package ua.ithillel.lesson7.classwork;

import java.util.Arrays;

public class DecryptoPrinter extends BasicPrinter {

    @Override
    public void print(byte[] data) {
        // decryptedData = decryptOp(data)
        super.print(data);
    }

    public void decrypt() {
        System.out.println("Decrypting...");
    }


}
