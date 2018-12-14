package com.nlpige.tourist.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ on Wednesday, 12 December, 2018 at 13:46.
 *
 * @author Joseph Maria
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResetPasswordParam {
    private String email, otp, newPass;
}
