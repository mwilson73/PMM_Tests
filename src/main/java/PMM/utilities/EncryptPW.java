package PMM.utilities;

import java.util.Base64;

public class EncryptPW {
    public static void main(String[] args) {
        //public String EncodeBase64Java (String Password)

        {
            String Password = "Put your password here";
            byte[] endPwd = Base64.getEncoder().encode(Password.getBytes());
            System.out.println("Encoded : " + Password + " is :" + new String(endPwd));
            //return new String(endPwd);
        }

/*        public String DecodeBase64Java (String EncryptedPW)
        {
            byte[] decodePwd = Base64.getDecoder().decode(EncryptedPW);
            System.out.println("Password Decoded Success...");
            return new String(decodePwd);

        }*/
    }
}

