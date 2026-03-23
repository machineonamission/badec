package com.blueair.bluetooth.service;

import android.content.Context;
import com.blueair.bluetooth.utils.BluetoothConnectivitySink;
import com.blueair.bluetooth.utils.BluetoothUtils;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/blueair/bluetooth/service/BluetoothConnectivityService;", "Lcom/blueair/bluetooth/utils/BluetoothConnectivitySink;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "statePublisher", "Lio/reactivex/subjects/PublishSubject;", "", "getStatePublisher", "()Lio/reactivex/subjects/PublishSubject;", "statePublisher$delegate", "Lkotlin/Lazy;", "stateObserver", "Lio/reactivex/Observable;", "getStateObserver", "()Lio/reactivex/Observable;", "isBluetoothEnabled", "()Z", "updateBluetoothConnectivityState", "", "isConnected", "bluetooth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BluetoothConnectivityService.kt */
public final class BluetoothConnectivityService implements BluetoothConnectivitySink {
    private final Context context;
    private final Lazy statePublisher$delegate = LazyKt.lazy(new BluetoothConnectivityService$$ExternalSyntheticLambda0());

    public BluetoothConnectivityService(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    private final PublishSubject<Boolean> getStatePublisher() {
        Object value = this.statePublisher$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (PublishSubject) value;
    }

    /* access modifiers changed from: private */
    public static final PublishSubject statePublisher_delegate$lambda$0() {
        return PublishSubject.create();
    }

    public final Observable<Boolean> getStateObserver() {
        Observable<Boolean> hide = getStatePublisher().hide();
        Intrinsics.checkNotNullExpressionValue(hide, "hide(...)");
        return hide;
    }

    public final boolean isBluetoothEnabled() {
        return BluetoothUtils.INSTANCE.isBluetoothEnabled(this.context);
    }

    public void updateBluetoothConnectivityState(boolean z) {
        getStatePublisher().onNext(Boolean.valueOf(z));
    }
}
