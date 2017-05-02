/*
 * Copyright RepCar AD 2017
 */

package com.repcar.ui.encrypt;

public interface EncryptDecryptService {

    String decrypt(String password);

    String encrypt(String password);

}