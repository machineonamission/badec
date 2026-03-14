package com.blueair.android.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.blueair.android.databinding.ActivityConnectDeviceGuideBinding;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.activity.BaseActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u000f"},
   d2 = {"Lcom/blueair/android/activity/ConnectDeviceGuideActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/android/databinding/ActivityConnectDeviceGuideBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ConnectDeviceGuideActivity extends BaseActivity {
   public static final int $stable = 8;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private ActivityConnectDeviceGuideBinding binding;
   private final String screenName = "connect_device_guide";

   // $FF: synthetic method
   public static void $r8$lambda$OUb7kTJyPfLEWIsK7vQ3ef1buYk(ConnectDeviceGuideActivity var0, View var1) {
      onCreate$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$fbE8HRmoGcIRxLnZtvIQjG9IXug(ConnectDeviceGuideActivity var0, View var1) {
      onCreate$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$mbR1g6ShjA01Go3komsuKtUgDJU(ConnectDeviceGuideActivity var0, View var1) {
      onCreate$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$ppHBrbfcCqcTCL4kVmbZQBml3xg(ConnectDeviceGuideActivity var0, View var1) {
      onCreate$lambda$3(var0, var1);
   }

   private static final void onCreate$lambda$0(ConnectDeviceGuideActivity var0, View var1) {
      var0.startActivity(Actions.INSTANCE.openAddDeviceIntent((Context)var0));
   }

   private static final void onCreate$lambda$1(ConnectDeviceGuideActivity var0, View var1) {
      var0.finish();
   }

   private static final void onCreate$lambda$2(ConnectDeviceGuideActivity var0, View var1) {
      var0.finish();
   }

   private static final void onCreate$lambda$3(ConnectDeviceGuideActivity var0, View var1) {
      var0.finish();
   }

   protected String getScreenName() {
      return this.screenName;
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      ActivityConnectDeviceGuideBinding var3 = ActivityConnectDeviceGuideBinding.inflate(this.getLayoutInflater());
      Intrinsics.checkNotNullExpressionValue(var3, "inflate(...)");
      this.binding = var3;
      Object var2 = null;
      ActivityConnectDeviceGuideBinding var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      this.setContentView((View)var4.getRoot());
      this.immersiveStatusBar(true);
      var3 = this.binding;
      var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      var4.btnSearchFor.setOnClickListener(new ConnectDeviceGuideActivity$$ExternalSyntheticLambda0(this));
      var3 = this.binding;
      var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      var4.btnSkip.setOnClickListener(new ConnectDeviceGuideActivity$$ExternalSyntheticLambda1(this));
      var3 = this.binding;
      var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      var4.ivBack.setOnClickListener(new ConnectDeviceGuideActivity$$ExternalSyntheticLambda2(this));
      var4 = this.binding;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = (ActivityConnectDeviceGuideBinding)var2;
      }

      var4.ivClose.setOnClickListener(new ConnectDeviceGuideActivity$$ExternalSyntheticLambda3(this));
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/android/activity/ConnectDeviceGuideActivity$Companion;", "", "<init>", "()V", "launch", "", "context", "Landroid/content/Context;", "app_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }

      public final void launch(Context var1) {
         Intrinsics.checkNotNullParameter(var1, "context");
         var1.startActivity(new Intent(var1, ConnectDeviceGuideActivity.class));
      }
   }
}
