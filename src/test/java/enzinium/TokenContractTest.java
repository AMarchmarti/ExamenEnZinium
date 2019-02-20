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
        assertEquals("Hola", contract.symbol());
        contract.setTotalSupply(100);
        assertEquals(100, contract.totalSupply(),0);
    }


    @Test
    public void mapTest(){
        Address rick = new Address();
        rick.generateKeyPair();
        TokenContract ricknillos = new TokenContract(rick);
        ricknillos.addOwner(rick.getPK(), 100d);
        assertNotNull(ricknillos.getBalances());
        assertTrue(ricknillos.getBalances().containsKey(rick.getPK()));
        assertTrue(ricknillos.getBalances().containsValue(100.0));

    }

    @Test
    public void transferTest(){
        Address rick = new Address();
        rick.generateKeyPair();
        TokenContract ricknillos = new TokenContract(rick);
        ricknillos.addOwner(rick.getPK(), 100d);
        Address morty = new Address();
        morty.generateKeyPair();
        ricknillos.transfer(morty.getPK(), 2.0);
        assertEquals(2, ricknillos.getBalances().get(morty.getPK()), 0);
        assertEquals(98, ricknillos.getBalances().get(rick.getPK()),0);

    }

    @Test
    public void reventaTest(){
        Address rick = new Address();
        rick.generateKeyPair();
        TokenContract ricknillos = new TokenContract(rick);
        ricknillos.addOwner(rick.getPK(), 100d);
        Address morty = new Address();
        morty.generateKeyPair();
        ricknillos.transfer(morty.getPK(), 4.0);
        Address jen = new Address();
        jen.generateKeyPair();
        ricknillos.transfer(morty.getPK(), jen.getPK(), 1.0);
        assertEquals(3, ricknillos.getBalances().get(morty.getPK()), 0);
        assertEquals(1, ricknillos.getBalances().get(jen.getPK()), 0);
    }
}
/*
    @Test
    public void payable_test() {

        Address rick = new Address();
        rick.generateKeyPair();
        TokenContract ricknillos = new TokenContract(rick);
        ricknillos.addOwner(rick.getPK(), 100d);
        Address morty = new Address();
        morty.generateKeyPair();

        morty.addEZI(20d);

        // verifico la transferencia de entradas
        ricknillos.payable(morty.getPK(), morty.getBalance());
        assertEquals(4d, ricknillos.balanceOf(morty.getPK()), 0d);

        // verifico la trasnferencia de EZI
        assertEquals(20d, ricknillos.owner().getBalance(), 0d);
    }
}
}*/
