package com.blueair.antifake.activity;

import android.os.Bundle;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.FragmentManager;
import com.blueair.antifake.databinding.ActivityScanBinding;
import com.blueair.antifake.dialog.AntiFakeInfoDialogFragment;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.HasSKU;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.Actions;
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

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\u0012\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0012H\u0002J\b\u0010\u0018\u001a\u00020\u0012H\u0014J\b\u0010\u0019\u001a\u00020\u0012H\u0014J\b\u0010\u001a\u001a\u00020\u0012H\u0002J-\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001d2\u000e\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u001f2\u0006\u0010 \u001a\u00020!H\u0016¢\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020\u0012H\u0002R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX.¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/blueair/antifake/activity/ScanActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/antifake/databinding/ActivityScanBinding;", "device", "Lcom/blueair/core/model/HasSKU;", "targetType", "Lcom/blueair/core/model/DeviceFilterType;", "cameraScan", "Lcom/king/camera/scan/CameraScan;", "Lcom/google/zxing/Result;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "createAnalyzer", "Lcom/king/camera/scan/analyze/Analyzer;", "startCamera", "onResume", "onDestroy", "ensurePermission", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "showPermissionDeniedDialog", "antifake_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ScanActivity.kt */
public final class ScanActivity extends BaseActivity {
    private ActivityScanBinding binding;
    private CameraScan<Result> cameraScan;
    private HasSKU device;
    private final String screenName = AnalyticEvent.ScreenViewEvent.ANTIFAKE_SCAN;
    private DeviceFilterType targetType;

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityScanBinding inflate = ActivityScanBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        ActivityScanBinding activityScanBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView((View) inflate.getRoot());
        ComponentActivity componentActivity = this;
        ActivityScanBinding activityScanBinding2 = this.binding;
        if (activityScanBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityScanBinding2 = null;
        }
        this.cameraScan = new BaseCameraScan(componentActivity, activityScanBinding2.previewView);
        this.device = (HasSKU) getIntent().getParcelableExtra("device");
        String stringExtra = getIntent().getStringExtra(Actions.EXTRA_FILTER_TYPE);
        this.targetType = stringExtra != null ? DeviceFilterType.valueOf(stringExtra) : null;
        CameraScan<Result> cameraScan2 = this.cameraScan;
        if (cameraScan2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraScan");
            cameraScan2 = null;
        }
        cameraScan2.setAnalyzer(createAnalyzer()).setOnScanResultCallback(new ScanActivity$$ExternalSyntheticLambda0(this));
        ActivityScanBinding activityScanBinding3 = this.binding;
        if (activityScanBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityScanBinding3 = null;
        }
        activityScanBinding3.btnInfo.setOnClickListener(new ScanActivity$$ExternalSyntheticLambda1(this));
        ActivityScanBinding activityScanBinding4 = this.binding;
        if (activityScanBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityScanBinding = activityScanBinding4;
        }
        activityScanBinding.btnBack.setOnClickListener(new ScanActivity$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$1(ScanActivity scanActivity, AnalyzeResult analyzeResult) {
        Intrinsics.checkNotNullParameter(analyzeResult, "result");
        CameraScan<Result> cameraScan2 = scanActivity.cameraScan;
        if (cameraScan2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraScan");
            cameraScan2 = null;
        }
        cameraScan2.setAnalyzeImage(false);
        HasSKU hasSKU = scanActivity.device;
        DeviceFilterType deviceFilterType = scanActivity.targetType;
        String text = ((Result) analyzeResult.getResult()).getText();
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        ResetActivity.Companion.launch(scanActivity, hasSKU, deviceFilterType, text);
        scanActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$4(ScanActivity scanActivity, View view) {
        CameraScan<Result> cameraScan2 = scanActivity.cameraScan;
        if (cameraScan2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraScan");
            cameraScan2 = null;
        }
        cameraScan2.setAnalyzeImage(false);
        FragmentManager supportFragmentManager = scanActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        Class<AntiFakeInfoDialogFragment> cls = AntiFakeInfoDialogFragment.class;
        Intrinsics.checkNotNullExpressionValue("AntiFakeInfoDialogFragment", "getSimpleName(...)");
        if (!(supportFragmentManager.findFragmentByTag("AntiFakeInfoDialogFragment") instanceof AntiFakeInfoDialogFragment) && !supportFragmentManager.isStateSaved()) {
            AntiFakeInfoDialogFragment.Companion.newInstance(new ScanActivity$$ExternalSyntheticLambda3(scanActivity)).show(supportFragmentManager, "AntiFakeInfoDialogFragment");
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onCreate$lambda$4$lambda$3$lambda$2(ScanActivity scanActivity) {
        CameraScan<Result> cameraScan2 = scanActivity.cameraScan;
        if (cameraScan2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraScan");
            cameraScan2 = null;
        }
        cameraScan2.setAnalyzeImage(true);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$5(ScanActivity scanActivity, View view) {
        scanActivity.getOnBackPressedDispatcher().onBackPressed();
    }

    private final Analyzer<Result> createAnalyzer() {
        return new MultiFormatAnalyzer(new DecodeConfig().setHints(DecodeFormatManager.QR_CODE_HINTS).setFullAreaScan(false).setAreaRectRatio(0.6f));
    }

    private final void startCamera() {
        CameraScan<Result> cameraScan2 = this.cameraScan;
        if (cameraScan2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraScan");
            cameraScan2 = null;
        }
        cameraScan2.startCamera();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (!getHasBeenPaused()) {
            ensurePermission();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        CameraScan<Result> cameraScan2 = this.cameraScan;
        if (cameraScan2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraScan");
            cameraScan2 = null;
        }
        cameraScan2.release();
    }

    private final void ensurePermission() {
        if (checkSelfPermission("android.permission.CAMERA") == 0) {
            startCamera();
            return;
        }
        DialogUtils.INSTANCE.showRequestPermissionHint(R.string.permission_request_title_camera, R.string.permission_request_message_camera);
        requestPermissions(new String[]{"android.permission.CAMERA"}, 1);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 1 && Intrinsics.areEqual(ArraysKt.firstOrNull((T[]) strArr), (Object) "android.permission.CAMERA")) {
            Integer firstOrNull = ArraysKt.firstOrNull(iArr);
            if (firstOrNull != null && firstOrNull.intValue() == 0) {
                startCamera();
            } else {
                showPermissionDeniedDialog();
            }
        }
    }

    private final void showPermissionDeniedDialog() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        Class<ConfirmationDialogLeftAligned> cls = ConfirmationDialogLeftAligned.class;
        Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
        if ((supportFragmentManager.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) || supportFragmentManager.isStateSaved()) {
        } else {
            ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.camera_permission_dialog_denied_title, (Integer) null, R.string.camera_permission_dialog_denied_content, Integer.valueOf(R.string.title_activity_settings), Integer.valueOf(R.string.btn_cancel), false, false, false, true, (String[]) null, (String) null, new ScanActivity$$ExternalSyntheticLambda4(this), 1632, (Object) null).show(supportFragmentManager, "ConfirmationDialogLeftAligned");
        }
    }

    /* access modifiers changed from: private */
    public static final Unit showPermissionDeniedDialog$lambda$7$lambda$6(ScanActivity scanActivity, boolean z) {
        if (z) {
            AppSettingsIntent.INSTANCE.start(scanActivity);
        }
        scanActivity.finish();
        return Unit.INSTANCE;
    }
}
