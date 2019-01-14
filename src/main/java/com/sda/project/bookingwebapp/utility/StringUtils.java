package com.sda.project.bookingwebapp.utility;

import java.util.Arrays;
import java.util.List;

public class StringUtils {

    public static List<String> splitStingByComma(final String param) {

        if (param == null) {
            throw new IllegalStateException("Param should not be empty");
        }
        String[] params = param.split(",");
        return Arrays.asList(params);
    }

}
