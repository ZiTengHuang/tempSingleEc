package com.example.ppt.temp_coer.app;

import com.example.ppt.temp_coer.utils.storage.PptPreference;

public class AccountManager {

    private enum SignTag {
        SIGN_TAG
    }
    public static void setSignStater(boolean stater) {
        PptPreference.setAppFlag(SignTag.SIGN_TAG.name(), stater);
    }

    private static boolean isSignStater() {
        return PptPreference.getAppFlag(SignTag.SIGN_TAG.name());
    }

    public static void checkAccount(IUserChecker iUserChecker) {
        if (iUserChecker != null) {
            if (isSignStater()) {
                iUserChecker.onSignIn();
            } else {
                iUserChecker.onNotSignIn();
            }
        }
    }
}
