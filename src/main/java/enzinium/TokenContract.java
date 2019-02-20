package enzinium;

import java.security.PublicKey;
import java.util.LinkedHashSet;
import java.util.Set;

public class TokenContract {

        private Address PK = null;
        private Set<Address> entradas = new LinkedHashSet<>();
        private String name = null;
        private double totalSupply = 0d;
        private String symboll = null;

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

/*----------------------Getters-----------------------*/

        public String getName() {
            return this.name;
        }

        public double getTotalSupply() {
            return this.totalSupply;
        }

        public String getSymbol() {
            return this.symboll;
        }

        public PublicKey getPK(){
            return PK.getPK();
        }

/*--------------------Lógica-------------------------*/

        @Override
        public String toString(){
            return "\n" + "name = " + getName() +"\n"+
                    "symbol = " + getSymbol() + "\n" +
                    "totalSupply = " + getTotalSupply() + "\n"+
                    "owner Pk = " + getPK().hashCode();
        }
}
