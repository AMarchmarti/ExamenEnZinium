package enzinium;

import org.junit.Test;

import static org.junit.Assert.*;

public class TokenContractTest {

    @Test
    public void contractTest(){
        Address address = new Address();
        TokenContract contract = new TokenContract(address);
        assertNotNull(contract);
    }

    @Test
    public void contractSGTest(){
        Address address = new Address();
        TokenContract contract = new TokenContract(address);
        contract.setName("hola");
        assertEquals("hola", contract.getName());
        contract.setSymbol("Hola");
        assertEquals("Hola", contract.getSymbol());
        contract.setTotalSupply(100);
        assertEquals(100, contract.getTotalSupply(),0);
    }
}
