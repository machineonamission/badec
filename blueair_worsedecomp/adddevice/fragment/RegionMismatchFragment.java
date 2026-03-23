package com.blueair.adddevice.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.blueair.adddevice.R;
import com.blueair.auth.LogOutService;
import com.blueair.auth.LogoutReason;
import com.blueair.viewcore.activity.Actions;
import com.google.android.material.button.MaterialButton;
import kotlin.Lazy;
import kotlin.Metadata;
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

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068VX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/blueair/adddevice/fragment/RegionMismatchFragment;", "Landroidx/fragment/app/DialogFragment;", "Lorg/kodein/di/DIAware;", "<init>", "()V", "di", "Lorg/kodein/di/DI;", "getDi", "()Lorg/kodein/di/DI;", "di$delegate", "Lkotlin/Lazy;", "logOutService", "Lcom/blueair/auth/LogOutService;", "getLogOutService", "()Lcom/blueair/auth/LogOutService;", "logOutService$delegate", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: RegionMismatchFragment.kt */
public final class RegionMismatchFragment extends DialogFragment implements DIAware {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Lazy di$delegate;
    private final Lazy logOutService$delegate;

    static {
        Class<RegionMismatchFragment> cls = RegionMismatchFragment.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "di", "getDi()Lorg/kodein/di/DI;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "logOutService", "getLogOutService()Lcom/blueair/auth/LogOutService;", 0))};
    }

    public RegionMismatchFragment() {
        DIPropertyDelegateProvider<Object> closestDI = ClosestKt.closestDI((Fragment) this);
        KProperty<Object>[] kPropertyArr = $$delegatedProperties;
        this.di$delegate = closestDI.provideDelegate(this, kPropertyArr[0]);
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new RegionMismatchFragment$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.logOutService$delegate = DIAwareKt.Instance(this, new GenericJVMTypeTokenDelegate(typeToken, LogOutService.class), (Object) null).provideDelegate(this, kPropertyArr[1]);
    }

    public DIContext<?> getDiContext() {
        return DIAware.DefaultImpls.getDiContext(this);
    }

    public DITrigger getDiTrigger() {
        return DIAware.DefaultImpls.getDiTrigger(this);
    }

    public DI getDi() {
        return (DI) this.di$delegate.getValue();
    }

    private final LogOutService getLogOutService() {
        return (LogOutService) this.logOutService$delegate.getValue();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        MaterialButton materialButton;
        MaterialButton materialButton2;
        Window window;
        FragmentActivity activity = getActivity();
        View view = null;
        LayoutInflater layoutInflater = activity != null ? activity.getLayoutInflater() : null;
        if (layoutInflater != null) {
            view = layoutInflater.inflate(R.layout.fragment_region_mismatch, (ViewGroup) null);
        }
        Dialog dialog = new Dialog(requireContext());
        if (view != null) {
            dialog.setContentView(view);
        }
        FragmentActivity activity2 = getActivity();
        if (!(activity2 == null || (window = dialog.getWindow()) == null)) {
            window.setBackgroundDrawable(ContextCompat.getDrawable(activity2, com.blueair.viewcore.R.drawable.rounded_rectangle_white));
        }
        if (!(view == null || (materialButton2 = (MaterialButton) view.findViewById(R.id.buttonRegister)) == null)) {
            materialButton2.setOnClickListener(new RegionMismatchFragment$$ExternalSyntheticLambda0(this));
        }
        if (!(view == null || (materialButton = (MaterialButton) view.findViewById(R.id.buttonClose)) == null)) {
            materialButton.setOnClickListener(new RegionMismatchFragment$$ExternalSyntheticLambda1(this));
        }
        return dialog;
    }

    /* access modifiers changed from: private */
    public static final void onCreateDialog$lambda$3(RegionMismatchFragment regionMismatchFragment, View view) {
        regionMismatchFragment.getLogOutService().logOutRegistered(LogoutReason.REGION_MISMATCH);
        FragmentActivity activity = regionMismatchFragment.getActivity();
        if (activity != null) {
            regionMismatchFragment.startActivity(Actions.openWelcomeIntent$default(Actions.INSTANCE, activity, false, 2, (Object) null));
        }
        regionMismatchFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void onCreateDialog$lambda$4(RegionMismatchFragment regionMismatchFragment, View view) {
        regionMismatchFragment.dismiss();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/adddevice/fragment/RegionMismatchFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/fragment/RegionMismatchFragment;", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: RegionMismatchFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RegionMismatchFragment newInstance() {
            return new RegionMismatchFragment();
        }
    }
}
