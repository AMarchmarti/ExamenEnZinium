package enzinium;

import java.security.PrivateKey;
import java.security.PublicKey;

public class Address {

        private PublicKey PK = null;
        private PrivateKey SK = null;

/*------------------Setters-------------------------------------------*/

        public void setPK(PublicKey PK) {
            this.PK = PK;
        }

        public void setSK(PrivateKey SK) {
            this.SK = SK;
        }

/*----------------------Getters----------------------------------*/

        public PublicKey getPK() {
            return PK;
        }

        public PrivateKey getSK() {
            return SK;
        }

/*--------------------Lógica-----------------------------------*/

        public void generateKeyPair(){
            setPK(GenSig.generateKeyPair().getPublic());
            setSK(GenSig.generateKeyPair().getPrivate());
        }
}
