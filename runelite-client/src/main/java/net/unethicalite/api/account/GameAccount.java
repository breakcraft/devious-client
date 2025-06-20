package net.unethicalite.api.account;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

public class GameAccount
{
        private static final String ALGO = "AES/GCM/NoPadding";
        private static final int GCM_TAG_LENGTH = 128;

        private final String username;
        private final SecretKey key;

        private byte[] password;
        private byte[] passwordIv;
        private byte[] auth;
        private byte[] authIv;

        public GameAccount(String username, String password)
        {
                this.username = username;
                this.key = generateKey();
                setPassword(password);
        }

        private static SecretKey generateKey()
        {
                byte[] keyBytes = new byte[16];
                new SecureRandom().nextBytes(keyBytes);
                return new SecretKeySpec(keyBytes, "AES");
        }

        private static byte[] generateIv()
        {
                byte[] iv = new byte[12];
                new SecureRandom().nextBytes(iv);
                return iv;
        }

        private byte[] encrypt(String value, byte[] iv)
        {
                try
                {
                        Cipher cipher = Cipher.getInstance(ALGO);
                        GCMParameterSpec spec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
                        cipher.init(Cipher.ENCRYPT_MODE, key, spec);
                        return cipher.doFinal(value.getBytes(StandardCharsets.UTF_8));
                }
                catch (Exception e)
                {
                        throw new RuntimeException("Unable to encrypt", e);
                }
        }

        private String decrypt(byte[] data, byte[] iv)
        {
                try
                {
                        Cipher cipher = Cipher.getInstance(ALGO);
                        GCMParameterSpec spec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);
                        cipher.init(Cipher.DECRYPT_MODE, key, spec);
                        return new String(cipher.doFinal(data), StandardCharsets.UTF_8);
                }
                catch (Exception e)
                {
                        throw new RuntimeException("Unable to decrypt", e);
                }
        }

        private void setPassword(String password)
        {
                this.passwordIv = generateIv();
                this.password = encrypt(password, this.passwordIv);
        }

        public String getUsername()
        {
                return username;
        }

        public String getPassword()
        {
                return decrypt(password, passwordIv);
        }

        public String getAuth()
        {
                if (auth == null)
                {
                        return null;
                }
                return decrypt(auth, authIv);
        }

        public void setAuth(String auth)
        {
                if (auth == null)
                {
                        this.auth = null;
                        this.authIv = null;
                }
                else
                {
                        this.authIv = generateIv();
                        this.auth = encrypt(auth, this.authIv);
                }
        }
}
