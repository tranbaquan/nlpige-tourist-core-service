package com.nlpige.tourist.utils;

import de.mkammerer.argon2.Argon2;

import static de.mkammerer.argon2.Argon2Factory.Argon2Types;
import static de.mkammerer.argon2.Argon2Factory.create;

/**
 * Created by IntelliJ on Sunday, 09 December, 2018 at 23:13.
 *
 * @author Joseph Maria
 */
public class Hashing {
    private static final Argon2 ARGON2 = create(Argon2Types.ARGON2id);

    public static final String hashPassword(char[] password) {
        try {
            return ARGON2.hash(2, 65536, 4, password);
        } finally {
            ARGON2.wipeArray(password);
        }
    }

    public static final boolean verifyPassword(String hashedPassword, char[] password) {
        try {
            return ARGON2.verify(hashedPassword, password);
        } finally {
            ARGON2.wipeArray(password);
        }
    }
}
