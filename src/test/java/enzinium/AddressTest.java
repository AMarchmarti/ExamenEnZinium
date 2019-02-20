package enzinium;

import org.junit.Test;

import static org.junit.Assert.*;


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

    @Test
    public void balanceTest(){
        Address address = new Address();
        address.setBalance(10);
        assertEquals(10.0,address.getBalance(),0);
    }
}
