package ua.ithillel.lesson7.classwork.secure;

import ua.ithillel.lesson7.classwork.BasicPrinter;

/**
 * Design Pattern: Template Method
 */
public abstract class SecurePrinter extends BasicPrinter {

    protected abstract byte[] decrypt(byte[] encryptedData);

    @Override
    public void print(byte[] data) {
        super.print(decrypt(data));
    }

}
