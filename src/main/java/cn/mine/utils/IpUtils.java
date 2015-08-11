package cn.mine.utils;

import org.apache.commons.lang3.StringUtils;

public class IpUtils {
    public static long ipv4Str2long(String ipStr) {

        long ipLong = 0;
        if (StringUtils.isNotBlank(ipStr)) {
            String[] parts = StringUtils.split(ipStr, ".");
            if (null != parts && 4 == parts.length) {
                for (int i = 0; i < parts.length; ++i) {
                    try {
                        ipLong += Long.valueOf(parts[i]) << (24 - (8 * i));
                    } catch (NumberFormatException e) {
                        return 0l;
                    }
                }
            }
        }
        return ipLong;
    }
    public static String longToIpv4(Long ipAddr) {

        StringBuffer builder = new StringBuffer("");
        builder.append(String.valueOf((ipAddr >>> 24)));
        builder.append(".");
        builder.append(String.valueOf((ipAddr & 0x00FFFFFF) >>> 16));
        builder.append(".");
        builder.append(String.valueOf((ipAddr & 0x0000FFFF) >>> 8));
        builder.append(".");
        builder.append(String.valueOf((ipAddr & 0x000000FF)));
        return builder.toString();

    }
}
