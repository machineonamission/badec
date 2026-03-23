package com.blueair.devicedetails.util;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\bH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/blueair/devicedetails/util/DeviceWelcomeHomeProvider;", "", "homeAddress", "", "getHomeAddress", "()Ljava/lang/String;", "fetchRadius", "isEnabled", "", "isHomeLocationExist", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceWelcomeHomeProvider.kt */
public interface DeviceWelcomeHomeProvider {
    String fetchRadius();

    String getHomeAddress();

    boolean isEnabled();

    boolean isHomeLocationExist();
}
