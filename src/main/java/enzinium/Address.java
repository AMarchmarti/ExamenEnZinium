package enzinium;

import java.security.PrivateKey;
import java.security.PublicKey;

public class Address {

        private PublicKey PK = null;
        private PrivateKey SK = null;
        private double balance = 0d;

/*------------------Setters-------------------------------------------*/

        public void setPK(PublicKey PK) {
            this.PK = PK;
        }

        public void setSK(PrivateKey SK) {
            this.SK = SK;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

    /*----------------------Getters----------------------------------*/

        public PublicKey getPK() {
            return PK;
        }

        public PrivateKey getSK() {
            return SK;
        }

        public double getBalance() {
            return this.balance;
        }

    /*--------------------Lógica-----------------------------------*/

        public void generateKeyPair(){
            setPK(GenSig.generateKeyPair().getPublic());
            setSK(GenSig.generateKeyPair().getPrivate());
        }

        @Override
        public String toString(){
            return "\n" + "PK = " + getPK().hashCode() +  "\n"+
                    "Balance = " + getBalance() + " EZI" + "\n";
        }
}
