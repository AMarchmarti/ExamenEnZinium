package enzinium;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TokenContract {

        private PublicKey propietario = null;
        private Address PK = null;
        private String name = null;
        private double totalSUpply = 0d;
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
            this.totalSUpply = numentradas;
        }

        public void setSymbol(String symboll) {
            this.symboll = symboll;
        }

        public void setBalances(PublicKey key, Double balance) {
            this.balances.put(key, balance);
        }

        public void setPropietario(PublicKey key){
            this.propietario = key;
        }

    /*----------------------Getters-----------------------*/

        public String getName() {
            return this.name;
        }

        public double totalSupply() {
            return this.totalSUpply;
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

        public PublicKey getPropietario() {
            return propietario;
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
                setPropietario(key);
                if (!getBalances().containsKey(key)) {
                    setBalances(key, balance);
                }else{
                    setBalances(getPropietario(), totalSupply());
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


        public void transfer(PublicKey key, Double cantidad){
            if (!getBalances().containsKey(key)) {
                setBalances(key, cantidad);
            }else{
                setBalances(key, getBalances().get(key) + cantidad);
            }
            setTotalSupply(getBalances().get(getPropietario()) - cantidad);
            addOwner(getPropietario(), cantidad);

        }


        public void refill(Double cantidad){
            if (getBalances().get(getPropietario()) < cantidad){

            }
        }


        public void transfer(PublicKey keyVendedor, PublicKey keyComprador, Double cantidad){
            if (!getBalances().containsKey(keyComprador)) {
                setBalances(keyVendedor, getBalances().get(keyVendedor) - cantidad);
                setBalances(keyComprador, cantidad);
            }else{
                setBalances(keyComprador, getBalances().get(keyComprador) + cantidad);

            }
        }

}
