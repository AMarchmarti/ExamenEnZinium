package enzinium;

import java.security.PublicKey;
import java.util.LinkedHashMap;
import java.util.Map;

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

    public void setBalances(PublicKey key, Double balance) {
        this.balances.put(key, balance);
    }

    /*----------------------Getters-----------------------*/

        public String getName() {
            return this.name;
        }

        public double totalSupply() {
            return this.totalSupply;
        }

        public String symbol() {
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
                    "symbol = " + symbol() + "\n" +
                    "totalSupply = " + totalSupply() + "\n"+
                    "owner Pk = " + getPK().hashCode();
        }


        public void addOwner(PublicKey key, Double balance){
                if (!getBalances().containsKey(key)) {
                    setBalances(key, balance);
                }else{
                    setBalances(key, 100.0);
                }
                }



        public Integer numOwners(){
            int count = 0;
            for(PublicKey key : getBalances().keySet()){
                count += 1;
            }
            return count;
        }

        public Double balanceOf(PublicKey key){
            for (PublicKey pkey : getBalances().keySet()){
                if (pkey.equals(key)){
                    return getBalances().get(pkey);
                }
            }
            return 0d;
        }
}
