package com.fastaccess.helper;

/**
 * Created by thermatk on 12.04.17.
 */

public class GithubConfigHelper {
    private static final String REDIRECT_URL = "fasthub://login";

    public static String getRedirectUrl() {
        return REDIRECT_URL;
    }

    public static String getClientId() {
        return "969222fa457d135861bb";
    }

    public static String getSecret() {
        return "fe5ac0279edb84b583fe9a06ba82f6000ecf54bb";
    }
}