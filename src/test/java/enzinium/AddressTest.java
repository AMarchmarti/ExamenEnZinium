package enzinium;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class AddressTest
{
    @Test
    public void addressTestClass(){
        Address address = new Address();
        assertNotNull(address);

    }

    @Test
    public void clavesTest(){
        Address address = new Address();
        address.generateKeyPair();
        assertNotNull(address.getPK());
        assertNotNull(address.getSK());
    }
}
