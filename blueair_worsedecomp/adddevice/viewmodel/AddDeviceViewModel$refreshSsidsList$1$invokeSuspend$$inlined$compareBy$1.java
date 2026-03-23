package com.blueair.adddevice.viewmodel;

import com.blueair.core.model.Ssid;
import java.util.Comparator;
import kotlin.Metadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: Comparisons.kt */
public final class AddDeviceViewModel$refreshSsidsList$1$invokeSuspend$$inlined$compareBy$1<T> implements Comparator {
    final /* synthetic */ Comparator $comparator;

    public AddDeviceViewModel$refreshSsidsList$1$invokeSuspend$$inlined$compareBy$1(Comparator comparator) {
        this.$comparator = comparator;
    }

    public final int compare(T t, T t2) {
        Comparator comparator = this.$comparator;
        String ssid = ((Ssid) t).getSsid();
        String str = "";
        if (ssid == null) {
            ssid = str;
        }
        String ssid2 = ((Ssid) t2).getSsid();
        if (ssid2 != null) {
            str = ssid2;
        }
        return comparator.compare(ssid, str);
    }
}
