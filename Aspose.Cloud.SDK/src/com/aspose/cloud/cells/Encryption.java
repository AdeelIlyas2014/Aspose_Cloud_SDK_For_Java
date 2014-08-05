package com.aspose.cloud.cells;
import java.lang.String;

public class Encryption
    {
        public Encryption()
        { 
        
        }

        private EncryptionType encryptionType ;
        private String password ;
        private int keylength ;     
        
        public EncryptionType getEncryptionType(){return encryptionType;}
        public String getPassword(){return password;}
        public int getKeylength(){return keylength;}      
        
        
        public void setEncryptionType(EncryptionType EncryptionType){ this.encryptionType=EncryptionType;}
        public void setPassword(String Password){ this.password=Password;}
        public void setKeylength(int Keylength){ this.keylength=Keylength;}

    }