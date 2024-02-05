package org.mwatt.utilities;

import java.util.Optional;

public class StrUtil {
    public static String join(String[] strings, String separator) {
        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            sb.append(string);
            sb.append(separator);
        }
        return sb.toString();
    }

    public static String join(String[] strings) {
        return join(strings, "");
    }

    public static boolean isNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }

    public static String mapOptional(String string, String defaultValue) {
        return isNullOrEmpty(string) ? defaultValue : string;
    }

    public static Optional<String> mapOptional(String string) {
        return isNullOrEmpty(string) ? Optional.empty() : Optional.of(string);
    }
}
