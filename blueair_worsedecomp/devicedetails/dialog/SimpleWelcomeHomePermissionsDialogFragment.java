package com.blueair.devicedetails.dialog;

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
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.blueair.devicedetails.databinding.DialogfragmentSimpleWhPermissionsBinding;
import com.blueair.devicedetails.viewmodel.DeviceWelcomeHomeViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtilsKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.button.MaterialButton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0012H\u0016J\b\u0010\u001e\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR+\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/blueair/devicedetails/dialog/SimpleWelcomeHomePermissionsDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/blueair/devicedetails/databinding/DialogfragmentSimpleWhPermissionsBinding;", "viewModel", "Lcom/blueair/devicedetails/viewmodel/DeviceWelcomeHomeViewModel;", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceWelcomeHomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "resultListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onStart", "openSettings", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SimpleWelcomeHomePermissionsDialogFragment.kt */
public final class SimpleWelcomeHomePermissionsDialogFragment extends DialogFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private DialogfragmentSimpleWhPermissionsBinding binding;
    /* access modifiers changed from: private */
    public Function1<? super Boolean, Unit> resultListener;
    private final Lazy viewModel$delegate;

    public SimpleWelcomeHomePermissionsDialogFragment() {
        Fragment fragment = this;
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new SimpleWelcomeHomePermissionsDialogFragment$special$$inlined$viewModels$default$2(new SimpleWelcomeHomePermissionsDialogFragment$special$$inlined$viewModels$default$1(fragment)));
        this.viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(DeviceWelcomeHomeViewModel.class), new SimpleWelcomeHomePermissionsDialogFragment$special$$inlined$viewModels$default$3(lazy), new SimpleWelcomeHomePermissionsDialogFragment$special$$inlined$viewModels$default$4((Function0) null, lazy), new SimpleWelcomeHomePermissionsDialogFragment$special$$inlined$viewModels$default$5(fragment, lazy));
    }

    private final DeviceWelcomeHomeViewModel getViewModel() {
        return (DeviceWelcomeHomeViewModel) this.viewModel$delegate.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        DialogfragmentSimpleWhPermissionsBinding inflate = DialogfragmentSimpleWhPermissionsBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        LinearLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        setStyle(0, R.style.DialogTheme);
        DialogfragmentSimpleWhPermissionsBinding dialogfragmentSimpleWhPermissionsBinding = this.binding;
        DialogfragmentSimpleWhPermissionsBinding dialogfragmentSimpleWhPermissionsBinding2 = null;
        if (dialogfragmentSimpleWhPermissionsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentSimpleWhPermissionsBinding = null;
        }
        dialogfragmentSimpleWhPermissionsBinding.btnGtsAutostart.setOnClickListener(new SimpleWelcomeHomePermissionsDialogFragment$$ExternalSyntheticLambda0(this));
        DialogfragmentSimpleWhPermissionsBinding dialogfragmentSimpleWhPermissionsBinding3 = this.binding;
        if (dialogfragmentSimpleWhPermissionsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentSimpleWhPermissionsBinding3 = null;
        }
        dialogfragmentSimpleWhPermissionsBinding3.btnGtsPowerManagement.setOnClickListener(new SimpleWelcomeHomePermissionsDialogFragment$$ExternalSyntheticLambda1(this));
        DialogfragmentSimpleWhPermissionsBinding dialogfragmentSimpleWhPermissionsBinding4 = this.binding;
        if (dialogfragmentSimpleWhPermissionsBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentSimpleWhPermissionsBinding4 = null;
        }
        MaterialButton materialButton = dialogfragmentSimpleWhPermissionsBinding4.btnNext;
        Intrinsics.checkNotNullExpressionValue(materialButton, "btnNext");
        ViewUtilsKt.setOnClickListener(materialButton, 200, new SimpleWelcomeHomePermissionsDialogFragment$$ExternalSyntheticLambda2(this));
        DialogfragmentSimpleWhPermissionsBinding dialogfragmentSimpleWhPermissionsBinding5 = this.binding;
        if (dialogfragmentSimpleWhPermissionsBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentSimpleWhPermissionsBinding5 = null;
        }
        MaterialButton materialButton2 = dialogfragmentSimpleWhPermissionsBinding5.btnBack;
        Intrinsics.checkNotNullExpressionValue(materialButton2, "btnBack");
        ViewUtilsKt.setOnClickListener(materialButton2, 200, new SimpleWelcomeHomePermissionsDialogFragment$$ExternalSyntheticLambda3(this));
        DialogfragmentSimpleWhPermissionsBinding dialogfragmentSimpleWhPermissionsBinding6 = this.binding;
        if (dialogfragmentSimpleWhPermissionsBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogfragmentSimpleWhPermissionsBinding2 = dialogfragmentSimpleWhPermissionsBinding6;
        }
        dialogfragmentSimpleWhPermissionsBinding2.ivClose.setOnClickListener(new SimpleWelcomeHomePermissionsDialogFragment$$ExternalSyntheticLambda4(this));
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(SimpleWelcomeHomePermissionsDialogFragment simpleWelcomeHomePermissionsDialogFragment, View view) {
        simpleWelcomeHomePermissionsDialogFragment.openSettings();
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(SimpleWelcomeHomePermissionsDialogFragment simpleWelcomeHomePermissionsDialogFragment, View view) {
        simpleWelcomeHomePermissionsDialogFragment.openSettings();
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$2(SimpleWelcomeHomePermissionsDialogFragment simpleWelcomeHomePermissionsDialogFragment, View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        Function1<? super Boolean, Unit> function1 = simpleWelcomeHomePermissionsDialogFragment.resultListener;
        if (function1 != null) {
            function1.invoke(true);
        }
        simpleWelcomeHomePermissionsDialogFragment.dismissAllowingStateLoss();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$3(SimpleWelcomeHomePermissionsDialogFragment simpleWelcomeHomePermissionsDialogFragment, View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        Function1<? super Boolean, Unit> function1 = simpleWelcomeHomePermissionsDialogFragment.resultListener;
        if (function1 != null) {
            function1.invoke(false);
        }
        simpleWelcomeHomePermissionsDialogFragment.dismissAllowingStateLoss();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$4(SimpleWelcomeHomePermissionsDialogFragment simpleWelcomeHomePermissionsDialogFragment, View view) {
        simpleWelcomeHomePermissionsDialogFragment.dismissAllowingStateLoss();
    }

    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setGravity(48);
        }
    }

    private final void openSettings() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        StringBuilder sb = new StringBuilder("package:");
        Context context = getContext();
        sb.append(context != null ? context.getPackageName() : null);
        intent.setData(Uri.parse(sb.toString()));
        Context context2 = getContext();
        if (context2 != null) {
            context2.startActivity(intent);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u0004\u001a\u00020\u00052%\b\u0002\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007¨\u0006\r"}, d2 = {"Lcom/blueair/devicedetails/dialog/SimpleWelcomeHomePermissionsDialogFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/dialog/SimpleWelcomeHomePermissionsDialogFragment;", "resultListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: SimpleWelcomeHomePermissionsDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ SimpleWelcomeHomePermissionsDialogFragment newInstance$default(Companion companion, Function1 function1, int i, Object obj) {
            if ((i & 1) != 0) {
                function1 = null;
            }
            return companion.newInstance(function1);
        }

        public final SimpleWelcomeHomePermissionsDialogFragment newInstance(Function1<? super Boolean, Unit> function1) {
            new Bundle();
            SimpleWelcomeHomePermissionsDialogFragment simpleWelcomeHomePermissionsDialogFragment = new SimpleWelcomeHomePermissionsDialogFragment();
            simpleWelcomeHomePermissionsDialogFragment.resultListener = function1;
            return simpleWelcomeHomePermissionsDialogFragment;
        }
    }
}
