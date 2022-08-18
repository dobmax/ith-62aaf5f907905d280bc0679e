package ua.ithillel.lesson7.classwork;

import ua.ithillel.lesson7.classwork.secure.SecurePrinter;

public class HashSecurePrinter extends SecurePrinter {
    @Override
    protected byte[] decrypt(byte[] encryptedData) {
        return "Decrypted data".getBytes();
    }
}
