package com.blueair.adddevice.service;

import android.app.Activity;
import com.blueair.adddevice.activity.AddDeviceActivityLegacy;
import kotlin.Metadata;
import no.nordicsemi.android.dfu.DfuBaseService;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H\u0014¨\u0006\u0007"}, d2 = {"Lcom/blueair/adddevice/service/DfuService;", "Lno/nordicsemi/android/dfu/DfuBaseService;", "<init>", "()V", "getNotificationTarget", "Ljava/lang/Class;", "Landroid/app/Activity;", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DfuService.kt */
public final class DfuService extends DfuBaseService {
    /* access modifiers changed from: protected */
    public Class<? extends Activity> getNotificationTarget() {
        return AddDeviceActivityLegacy.class;
    }
}
