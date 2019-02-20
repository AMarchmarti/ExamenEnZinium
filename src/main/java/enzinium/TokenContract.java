package enzinium;

import java.security.PublicKey;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class TokenContract {

        private Address PK = null;
        private String name = null;
        private double totalSupply = 0d;
        private String symboll = null;
        private Map<PublicKey, Double> balances = new LinkedHashMap<>();

        //Constructor
        public TokenContract(Address address){
            this.PK = address;
        }

/*----------------------Setters----------------------*/

        public void setName(String name) {
            this.name = name;
        }

        public void setTotalSupply(double numentradas) {
            this.totalSupply = numentradas;
        }

        public void setSymbol(String symboll) {
            this.symboll = symboll;
        }

    public void setBalances(Map<PublicKey, Double> balances) {
        this.balances = balances;
    }

    /*----------------------Getters-----------------------*/

        public String getName() {
            return this.name;
        }

        public double totalSupply() {
            return this.totalSupply;
        }

        public String getSymbol() {
            return this.symboll;
        }

        public PublicKey getPK(){
            return PK.getPK();
        }

        public Map<PublicKey, Double> getBalances() {
            return this.balances;
        }

    /*--------------------Lógica-------------------------*/

        @Override
        public String toString(){
            return "\n" + "name = " + getName() +"\n"+
                    "symbol = " + getSymbol() + "\n" +
                    "totalSupply = " + totalSupply() + "\n"+
                    "owner Pk = " + getPK().hashCode();
        }


        public void addOwner(PublicKey key, Double balance){
            Map<PublicKey, Double> entrada = new LinkedHashMap<>();
            for (PublicKey pKey : entrada.keySet())
                if (key.equals(pKey)) {
                    continue;
                }else {
                    entrada.put(key, balance);
                }
            setBalances(entrada);
        }
}
