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

@Metadata(
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"},
   d2 = {"Lcom/blueair/bluetooth/service/BluetoothConnectivityService;", "Lcom/blueair/bluetooth/utils/BluetoothConnectivitySink;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "statePublisher", "Lio/reactivex/subjects/PublishSubject;", "", "getStatePublisher", "()Lio/reactivex/subjects/PublishSubject;", "statePublisher$delegate", "Lkotlin/Lazy;", "stateObserver", "Lio/reactivex/Observable;", "getStateObserver", "()Lio/reactivex/Observable;", "isBluetoothEnabled", "()Z", "updateBluetoothConnectivityState", "", "isConnected", "bluetooth_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class BluetoothConnectivityService implements BluetoothConnectivitySink {
   private final Context context;
   private final Lazy statePublisher$delegate;

   // $FF: synthetic method
   public static PublishSubject $r8$lambda$k0m0jqsMsRgF_TmR_4Kd0m7IQ7M/* $FF was: $r8$lambda$k0m0jqsMsRgF-TmR-4Kd0m7IQ7M*/() {
      return statePublisher_delegate$lambda$0();
   }

   public BluetoothConnectivityService(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super();
      this.context = var1;
      this.statePublisher$delegate = LazyKt.lazy(new BluetoothConnectivityService$$ExternalSyntheticLambda0());
   }

   private final PublishSubject getStatePublisher() {
      Object var1 = this.statePublisher$delegate.getValue();
      Intrinsics.checkNotNullExpressionValue(var1, "getValue(...)");
      return (PublishSubject)var1;
   }

   private static final PublishSubject statePublisher_delegate$lambda$0() {
      return PublishSubject.create();
   }

   public final Observable getStateObserver() {
      Observable var1 = this.getStatePublisher().hide();
      Intrinsics.checkNotNullExpressionValue(var1, "hide(...)");
      return var1;
   }

   public final boolean isBluetoothEnabled() {
      return BluetoothUtils.INSTANCE.isBluetoothEnabled(this.context);
   }

   public void updateBluetoothConnectivityState(boolean var1) {
      this.getStatePublisher().onNext(var1);
   }
}
