package br.com.glp.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Dhyego Pedroso
 */
public class TesteSenhaMD5 {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        String retorno = "";
        String senha = "3033";
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(senha.getBytes(), 0, senha.length());
        retorno = new BigInteger(1, md.digest()).toString(16);
        System.out.println("MD5: " + retorno);
    }
}
