package com.blueair.adddevice;

import com.blueair.adddevice.DevicePairManager;
import com.hiflying.smartlink.OnSmartLinkListener;
import com.hiflying.smartlink.SmartLinkedModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, d2 = {"com/blueair/adddevice/DevicePairManager$performAutomaticPairing$1", "Lcom/hiflying/smartlink/OnSmartLinkListener;", "onLinked", "", "smartLinkedModule", "Lcom/hiflying/smartlink/SmartLinkedModule;", "onCompleted", "onTimeOut", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DevicePairManager.kt */
public final class DevicePairManager$performAutomaticPairing$1 implements OnSmartLinkListener {
    final /* synthetic */ DevicePairManager.AutoPairingListener $autoPairingListener;
    final /* synthetic */ Function0<Unit> $stopSmartLink;

    DevicePairManager$performAutomaticPairing$1(Function0<Unit> function0, DevicePairManager.AutoPairingListener autoPairingListener) {
        this.$stopSmartLink = function0;
        this.$autoPairingListener = autoPairingListener;
    }

    public void onLinked(SmartLinkedModule smartLinkedModule) {
        Intrinsics.checkNotNullParameter(smartLinkedModule, "smartLinkedModule");
        Timber.Forest forest = Timber.Forest;
        forest.d("SmartLinker linked to: " + smartLinkedModule.getIp() + ", " + smartLinkedModule + ", current thread = " + Thread.currentThread(), new Object[0]);
        int access$getSmartLinkerAttempt$p = DevicePairManager.smartLinkerAttempt;
        DevicePairManager devicePairManager = DevicePairManager.INSTANCE;
        DevicePairManager.smartLinkerAttempt = access$getSmartLinkerAttempt$p + 1;
        Timber.Forest forest2 = Timber.Forest;
        forest2.d("SmartLinker attempts = " + DevicePairManager.smartLinkerAttempt, new Object[0]);
        if (!Intrinsics.areEqual((Object) smartLinkedModule.getId(), (Object) DevicePairManager.DEFAULT_SMARTLINKER_UUID)) {
            this.$stopSmartLink.invoke();
            DevicePairManager.INSTANCE.onLinked(smartLinkedModule, this.$autoPairingListener);
        } else if (DevicePairManager.smartLinkerAttempt == 2) {
            this.$stopSmartLink.invoke();
            DevicePairManager.INSTANCE.onLinked(smartLinkedModule, this.$autoPairingListener);
        }
    }

    public void onCompleted() {
        Timber.Forest.d("SmartLinker completed", new Object[0]);
    }

    public void onTimeOut() {
        Timber.Forest.d("SmartLinker timeout occurred", new Object[0]);
        this.$stopSmartLink.invoke();
        this.$autoPairingListener.onCompleted((DeviceInformationLegacy) null);
    }
}
