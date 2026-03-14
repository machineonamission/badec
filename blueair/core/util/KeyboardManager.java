package com.blueair.core.util;

import android.graphics.Rect;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J*\u0010\u0006\u001a&\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b \t*\u0012\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b\u0018\u00010\u00070\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"},
   d2 = {"Lcom/blueair/core/util/KeyboardManager;", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "<init>", "(Landroidx/fragment/app/FragmentActivity;)V", "status", "Lio/reactivex/Observable;", "Lcom/blueair/core/util/KeyboardStatus;", "kotlin.jvm.PlatformType", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class KeyboardManager {
   private final FragmentActivity activity;

   // $FF: synthetic method
   public static void $r8$lambda$WvPvF6_2iNzcSAUVy2qvBXIL1Lo(View var0, ObservableEmitter var1) {
      status$lambda$2$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$mMOR81TsYK0_tpY8s1gCEtQLy8Y(KeyboardManager var0, ObservableEmitter var1) {
      status$lambda$2(var0, var1);
   }

   public KeyboardManager(FragmentActivity var1) {
      Intrinsics.checkNotNullParameter(var1, "activity");
      super();
      this.activity = var1;
   }

   private static final void status$lambda$2(KeyboardManager var0, ObservableEmitter var1) {
      Intrinsics.checkNotNullParameter(var1, "emitter");
      View var2 = var0.activity.findViewById(16908290);
      KeyboardManager$$ExternalSyntheticLambda0 var3 = new KeyboardManager$$ExternalSyntheticLambda0(var2, var1);
      var2.getViewTreeObserver().addOnGlobalLayoutListener(var3);
   }

   private static final void status$lambda$2$lambda$1(View var0, ObservableEmitter var1) {
      Rect var3 = new Rect();
      var0.getWindowVisibleDisplayFrame(var3);
      int var2 = var0.getHeight();
      if ((double)(var2 - var3.bottom) > (double)var2 * 0.15) {
         var1.onNext(KeyboardStatus.OPEN);
      } else {
         var1.onNext(KeyboardStatus.CLOSED);
      }
   }

   public final Observable status() {
      return Observable.create(new KeyboardManager$$ExternalSyntheticLambda1(this)).distinctUntilChanged();
   }
}
