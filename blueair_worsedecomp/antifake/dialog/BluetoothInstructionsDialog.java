package com.blueair.antifake.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.blueair.adddevice.utils.AddDeviceUtils;
import com.blueair.antifake.databinding.DialogBluetoothInstructionsBinding;
import com.blueair.bluetooth.utils.BluetoothUtils;
import com.blueair.core.util.LocationPermissionTracker;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.dialog.DialogUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.kodein.di.DI;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.DIContext;
import org.kodein.di.DITrigger;
import org.kodein.di.android.DIPropertyDelegateProvider;
import org.kodein.di.android.x.ClosestKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u0019H\u0016J\b\u0010#\u001a\u00020\u0019H\u0016J\b\u0010$\u001a\u00020\u0019H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068VX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR(\u0010\u0010\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0013 \u0014*\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00120\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/blueair/antifake/dialog/BluetoothInstructionsDialog;", "Landroidx/fragment/app/DialogFragment;", "Lorg/kodein/di/DIAware;", "<init>", "()V", "di", "Lorg/kodein/di/DI;", "getDi", "()Lorg/kodein/di/DI;", "di$delegate", "Lkotlin/Lazy;", "locationPermissionTracker", "Lcom/blueair/core/util/LocationPermissionTracker;", "getLocationPermissionTracker", "()Lcom/blueair/core/util/LocationPermissionTracker;", "locationPermissionTracker$delegate", "requestBluetoothPermissionsLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "kotlin.jvm.PlatformType", "nextClicked", "", "onNextListener", "Lkotlin/Function0;", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onResume", "ensurePermissionsAndDoAction", "Companion", "antifake_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BluetoothInstructionsDialog.kt */
public final class BluetoothInstructionsDialog extends DialogFragment implements DIAware {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Lazy di$delegate;
    private final Lazy locationPermissionTracker$delegate;
    private boolean nextClicked;
    /* access modifiers changed from: private */
    public Function0<Unit> onNextListener;
    private final ActivityResultLauncher<String[]> requestBluetoothPermissionsLauncher;

    static {
        Class<BluetoothInstructionsDialog> cls = BluetoothInstructionsDialog.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "di", "getDi()Lorg/kodein/di/DI;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "locationPermissionTracker", "getLocationPermissionTracker()Lcom/blueair/core/util/LocationPermissionTracker;", 0))};
    }

    public BluetoothInstructionsDialog() {
        DIPropertyDelegateProvider<Object> closestDI = ClosestKt.closestDI((Fragment) this);
        KProperty<Object>[] kPropertyArr = $$delegatedProperties;
        this.di$delegate = closestDI.provideDelegate(this, kPropertyArr[0]);
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new BluetoothInstructionsDialog$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.locationPermissionTracker$delegate = DIAwareKt.Instance(this, new GenericJVMTypeTokenDelegate(typeToken, LocationPermissionTracker.class), (Object) null).provideDelegate(this, kPropertyArr[1]);
        ActivityResultLauncher<String[]> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new BluetoothInstructionsDialog$$ExternalSyntheticLambda2(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.requestBluetoothPermissionsLauncher = registerForActivityResult;
    }

    public DIContext<?> getDiContext() {
        return DIAware.DefaultImpls.getDiContext(this);
    }

    public DITrigger getDiTrigger() {
        return DIAware.DefaultImpls.getDiTrigger(this);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¨\u0006\t"}, d2 = {"Lcom/blueair/antifake/dialog/BluetoothInstructionsDialog$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/antifake/dialog/BluetoothInstructionsDialog;", "onNextListener", "Lkotlin/Function0;", "", "antifake_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BluetoothInstructionsDialog.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BluetoothInstructionsDialog newInstance(Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "onNextListener");
            BluetoothInstructionsDialog bluetoothInstructionsDialog = new BluetoothInstructionsDialog();
            bluetoothInstructionsDialog.onNextListener = function0;
            return bluetoothInstructionsDialog;
        }
    }

    public DI getDi() {
        return (DI) this.di$delegate.getValue();
    }

    private final LocationPermissionTracker getLocationPermissionTracker() {
        return (LocationPermissionTracker) this.locationPermissionTracker$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final void requestBluetoothPermissionsLauncher$lambda$3(BluetoothInstructionsDialog bluetoothInstructionsDialog, Map map) {
        Object obj;
        DialogUtils.INSTANCE.hideRequestPermissionHints();
        Iterable values = map.values();
        boolean z = true;
        if (!(values instanceof Collection) || !((Collection) values).isEmpty()) {
            Iterator it = values.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (!((Boolean) it.next()).booleanValue()) {
                        z = false;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (BluetoothUtils.INSTANCE.shouldShowBluetoothRequestPermissionDialog(bluetoothInstructionsDialog) || z) {
            bluetoothInstructionsDialog.ensurePermissionsAndDoAction();
            return;
        }
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        StringBuilder sb = new StringBuilder("package:");
        Context context = bluetoothInstructionsDialog.getContext();
        Unit unit = null;
        sb.append(context != null ? context.getPackageName() : null);
        intent.setData(Uri.parse(sb.toString()));
        try {
            Result.Companion companion = Result.Companion;
            Context context2 = bluetoothInstructionsDialog.getContext();
            if (context2 != null) {
                context2.startActivity(intent);
                unit = Unit.INSTANCE;
            }
            obj = Result.m9366constructorimpl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m9366constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m9369exceptionOrNullimpl(obj) != null) {
            ViewUtils viewUtils = ViewUtils.INSTANCE;
            FragmentActivity requireActivity = bluetoothInstructionsDialog.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
            viewUtils.showSnackbar((Activity) requireActivity, R.string.bluetooth_permission_12, (ViewUtils.MessageType) ViewUtils.MessageType.INFO.INSTANCE);
        }
        Result.m9365boximpl(obj);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Dialog dialog = getDialog();
        if (dialog != null) {
            setStyle(0, R.style.DialogTheme);
            Window window2 = dialog.getWindow();
            if (window2 != null) {
                window2.setBackgroundDrawable(new ColorDrawable(0));
            }
            Dialog dialog2 = getDialog();
            if (!(dialog2 == null || (window = dialog2.getWindow()) == null)) {
                window.setWindowAnimations(R.style.dialog_animation_right);
            }
        }
        DialogBluetoothInstructionsBinding inflate = DialogBluetoothInstructionsBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        inflate.closeButton.setOnClickListener(new BluetoothInstructionsDialog$$ExternalSyntheticLambda0(this));
        inflate.nextButton.setOnClickListener(new BluetoothInstructionsDialog$$ExternalSyntheticLambda1(this));
        LinearLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$5(BluetoothInstructionsDialog bluetoothInstructionsDialog, View view) {
        bluetoothInstructionsDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$6(BluetoothInstructionsDialog bluetoothInstructionsDialog, View view) {
        bluetoothInstructionsDialog.nextClicked = true;
        bluetoothInstructionsDialog.ensurePermissionsAndDoAction();
    }

    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(-1, -1);
        }
    }

    public void onResume() {
        super.onResume();
        if (this.nextClicked) {
            ensurePermissionsAndDoAction();
        }
    }

    private final void ensurePermissionsAndDoAction() {
        if (!AddDeviceUtils.INSTANCE.showEnableLocationBluetooth(this, getLocationPermissionTracker(), this.requestBluetoothPermissionsLauncher)) {
            Function0<Unit> function0 = this.onNextListener;
            if (function0 != null) {
                function0.invoke();
            }
            dismiss();
        }
    }
}
