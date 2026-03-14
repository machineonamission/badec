package com.blueair.antifake.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.blueair.antifake.databinding.ActivityScanBinding;
import com.blueair.antifake.dialog.AntiFakeInfoDialogFragment;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.HasSKU;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.dialog.DialogUtils;
import com.blueair.viewcore.utils.AppSettingsIntent;
import com.google.zxing.Result;
import com.king.camera.scan.AnalyzeResult;
import com.king.camera.scan.BaseCameraScan;
import com.king.camera.scan.CameraScan;
import com.king.camera.scan.analyze.Analyzer;
import com.king.zxing.DecodeConfig;
import com.king.zxing.DecodeFormatManager;
import com.king.zxing.analyze.MultiFormatAnalyzer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\u0012\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0012H\u0002J\b\u0010\u0018\u001a\u00020\u0012H\u0014J\b\u0010\u0019\u001a\u00020\u0012H\u0014J\b\u0010\u001a\u001a\u00020\u0012H\u0002J-\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001d2\u000e\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u001f2\u0006\u0010 \u001a\u00020!H\u0016¢\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020\u0012H\u0002R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082.¢\u0006\u0002\n\u0000¨\u0006$"},
   d2 = {"Lcom/blueair/antifake/activity/ScanActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/antifake/databinding/ActivityScanBinding;", "device", "Lcom/blueair/core/model/HasSKU;", "targetType", "Lcom/blueair/core/model/DeviceFilterType;", "cameraScan", "Lcom/king/camera/scan/CameraScan;", "Lcom/google/zxing/Result;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "createAnalyzer", "Lcom/king/camera/scan/analyze/Analyzer;", "startCamera", "onResume", "onDestroy", "ensurePermission", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "showPermissionDeniedDialog", "antifake_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ScanActivity extends BaseActivity {
   private ActivityScanBinding binding;
   private CameraScan cameraScan;
   private HasSKU device;
   private final String screenName = "antifake_scan";
   private DeviceFilterType targetType;

   // $FF: synthetic method
   public static Unit $r8$lambda$B1DW1zWmHSlGDrGVju8oq3ITv_U(ScanActivity var0) {
      return onCreate$lambda$4$lambda$3$lambda$2(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$I_SlIO_3TQzqn8R2nosErj7elMg/* $FF was: $r8$lambda$I-SlIO_3TQzqn8R2nosErj7elMg*/(ScanActivity var0, View var1) {
      onCreate$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$JTtHj5Ee7IPY261U9KdQG4I72vY(ScanActivity var0, boolean var1) {
      return showPermissionDeniedDialog$lambda$7$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$NolWFk1RhzEZnJg85FG6rcFrhA4(ScanActivity var0, View var1) {
      onCreate$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$UrmyKYW5mSYZaz_DtQ8R7woTjoE(ScanActivity var0, AnalyzeResult var1) {
      onCreate$lambda$1(var0, var1);
   }

   private final Analyzer createAnalyzer() {
      return (Analyzer)(new MultiFormatAnalyzer((new DecodeConfig()).setHints(DecodeFormatManager.QR_CODE_HINTS).setFullAreaScan(false).setAreaRectRatio(0.6F)));
   }

   private final void ensurePermission() {
      if (this.checkSelfPermission("android.permission.CAMERA") == 0) {
         this.startCamera();
      } else {
         DialogUtils.INSTANCE.showRequestPermissionHint(R.string.permission_request_title_camera, R.string.permission_request_message_camera);
         this.requestPermissions(new String[]{"android.permission.CAMERA"}, 1);
      }
   }

   private static final void onCreate$lambda$1(ScanActivity var0, AnalyzeResult var1) {
      Intrinsics.checkNotNullParameter(var1, "result");
      CameraScan var3 = var0.cameraScan;
      CameraScan var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("cameraScan");
         var2 = null;
      }

      var2.setAnalyzeImage(false);
      ResetActivity.Companion var4 = ResetActivity.Companion;
      Context var7 = (Context)var0;
      HasSKU var8 = var0.device;
      DeviceFilterType var5 = var0.targetType;
      String var6 = ((Result)var1.getResult()).getText();
      Intrinsics.checkNotNullExpressionValue(var6, "getText(...)");
      var4.launch(var7, var8, var5, var6);
      var0.finish();
   }

   private static final void onCreate$lambda$4(ScanActivity var0, View var1) {
      CameraScan var2 = var0.cameraScan;
      CameraScan var3 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("cameraScan");
         var3 = null;
      }

      var3.setAnalyzeImage(false);
      FragmentManager var4 = var0.getSupportFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var4, "getSupportFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("AntiFakeInfoDialogFragment", "getSimpleName(...)");
      if (!(var4.findFragmentByTag("AntiFakeInfoDialogFragment") instanceof AntiFakeInfoDialogFragment) && !var4.isStateSaved()) {
         ((DialogFragment)AntiFakeInfoDialogFragment.Companion.newInstance(new ScanActivity$$ExternalSyntheticLambda3(var0))).show(var4, "AntiFakeInfoDialogFragment");
      }

   }

   private static final Unit onCreate$lambda$4$lambda$3$lambda$2(ScanActivity var0) {
      CameraScan var1 = var0.cameraScan;
      CameraScan var2 = var1;
      if (var1 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("cameraScan");
         var2 = null;
      }

      var2.setAnalyzeImage(true);
      return Unit.INSTANCE;
   }

   private static final void onCreate$lambda$5(ScanActivity var0, View var1) {
      var0.getOnBackPressedDispatcher().onBackPressed();
   }

   private final void showPermissionDeniedDialog() {
      FragmentManager var1 = this.getSupportFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var1, "getSupportFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
      if (!(var1.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var1.isStateSaved()) {
         ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.camera_permission_dialog_denied_title, (Integer)null, R.string.camera_permission_dialog_denied_content, R.string.title_activity_settings, R.string.btn_cancel, false, false, false, true, (String[])null, (String)null, (Integer)null, new ScanActivity$$ExternalSyntheticLambda4(this), 3680, (Object)null)).show(var1, "ConfirmationDialogLeftAligned");
      }

   }

   private static final Unit showPermissionDeniedDialog$lambda$7$lambda$6(ScanActivity var0, boolean var1) {
      if (var1) {
         AppSettingsIntent.INSTANCE.start((Context)var0);
      }

      var0.finish();
      return Unit.INSTANCE;
   }

   private final void startCamera() {
      CameraScan var2 = this.cameraScan;
      CameraScan var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("cameraScan");
         var1 = null;
      }

      var1.startCamera();
   }

   protected String getScreenName() {
      return this.screenName;
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      ActivityScanBinding var3 = ActivityScanBinding.inflate(this.getLayoutInflater());
      Intrinsics.checkNotNullExpressionValue(var3, "inflate(...)");
      this.binding = var3;
      Object var2 = null;
      ActivityScanBinding var5 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var5 = null;
      }

      this.setContentView((View)var5.getRoot());
      ComponentActivity var4 = (ComponentActivity)this;
      var3 = this.binding;
      var5 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var5 = null;
      }

      this.cameraScan = (CameraScan)(new BaseCameraScan(var4, var5.previewView));
      this.device = (HasSKU)this.getIntent().getParcelableExtra("device");
      String var7 = this.getIntent().getStringExtra("filter_type");
      DeviceFilterType var8;
      if (var7 != null) {
         var8 = DeviceFilterType.valueOf(var7);
      } else {
         var8 = null;
      }

      this.targetType = var8;
      CameraScan var13 = this.cameraScan;
      CameraScan var9 = var13;
      if (var13 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("cameraScan");
         var9 = null;
      }

      var9.setAnalyzer(this.createAnalyzer()).setOnScanResultCallback(new ScanActivity$$ExternalSyntheticLambda0(this));
      ActivityScanBinding var14 = this.binding;
      ActivityScanBinding var10 = var14;
      if (var14 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var10 = null;
      }

      var10.btnInfo.setOnClickListener(new ScanActivity$$ExternalSyntheticLambda1(this));
      var10 = this.binding;
      if (var10 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var10 = (ActivityScanBinding)var2;
      }

      var10.btnBack.setOnClickListener(new ScanActivity$$ExternalSyntheticLambda2(this));
   }

   protected void onDestroy() {
      super.onDestroy();
      CameraScan var2 = this.cameraScan;
      CameraScan var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("cameraScan");
         var1 = null;
      }

      var1.release();
   }

   public void onRequestPermissionsResult(int var1, String[] var2, int[] var3) {
      Intrinsics.checkNotNullParameter(var2, "permissions");
      Intrinsics.checkNotNullParameter(var3, "grantResults");
      super.onRequestPermissionsResult(var1, var2, var3);
      if (var1 == 1 && Intrinsics.areEqual(ArraysKt.firstOrNull(var2), "android.permission.CAMERA")) {
         Integer var4 = ArraysKt.firstOrNull(var3);
         if (var4 != null && var4 == 0) {
            this.startCamera();
            return;
         }

         this.showPermissionDeniedDialog();
      }

   }

   protected void onResume() {
      super.onResume();
      if (!this.getHasBeenPaused()) {
         this.ensurePermission();
      }

   }
}
