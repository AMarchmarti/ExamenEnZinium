package enzinium;

import java.util.LinkedHashSet;
import java.util.Set;

public class TokenContract {

        private Set<Address> entradas = new LinkedHashSet<>();
        private String name = null;
        private double totalSupply = 0d;
        private String symboll = null;

        //Constructor
        public TokenContract(Address address){
            this.entradas.add(address);
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
            return name;
        }

        public double getTotalSupply() {
            return totalSupply;
        }

        public String getSymbol() {
            return symboll;
        }
}
