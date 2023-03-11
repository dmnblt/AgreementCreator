package kz.law.AppCreator.utils;

import lombok.experimental.UtilityClass;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@UtilityClass
public class Utils {
    private static final int[] IIN_B1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11},
            IIN_B2 = {3, 4, 5, 6, 7, 8, 9, 10, 11, 1, 2};

    private static boolean validateBin(String bin) {
        if (!Pattern.matches("^[0-9]{12}$", bin)) return false;
        int[] a = new int[12];
        int checkSum = 0;
        for (int i = 0; i < 12; i++) {
            a[i] = Integer.parseInt(bin.charAt(i) + "");
            if (i < 11) checkSum += a[i] * IIN_B1[i];
        }
        checkSum = checkSum % 11;
        if (checkSum == 10) {
            checkSum = 0;
            for (int i = 0; i < 11; i++)
                checkSum += a[i] * IIN_B2[i];
            checkSum = checkSum % 11;
        }
        return checkSum == a[11];
    }
}
