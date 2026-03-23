package com.blueair.viewcore.extensions;

import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\b¢\u0006\u0002\u0010\u0006\u001a#\u0010\u0007\u001a\u00020\b\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\b\u001aE\u0010\t\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00010\fH\bø\u0001\u0000¢\u0006\u0002\u0010\r\u001aJ\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000526\u0010\u0012\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000f0\u0013\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0018"}, d2 = {"findByTag", "DF", "Landroidx/fragment/app/DialogFragment;", "Landroidx/fragment/app/FragmentManager;", "tag", "", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)Landroidx/fragment/app/DialogFragment;", "hasTag", "", "show", "commitNow", "factory", "Lkotlin/Function0;", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;)Landroidx/fragment/app/DialogFragment;", "setFragmentResultListenerWithClear", "", "Landroidx/fragment/app/Fragment;", "requestKey", "listener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Landroid/os/Bundle;", "bundle", "viewcore_otherRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* compiled from: FragmentExtensions.kt */
public final class FragmentExtensionsKt {
    public static /* synthetic */ DialogFragment findByTag$default(FragmentManager fragmentManager, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            Intrinsics.reifiedOperationMarker(4, "DF");
            Class<DialogFragment> cls = DialogFragment.class;
            Class cls2 = cls;
            str = cls.getSimpleName();
            Intrinsics.checkNotNullExpressionValue(str, "getSimpleName(...)");
            String str2 = str;
        }
        Intrinsics.checkNotNullParameter(fragmentManager, "<this>");
        Intrinsics.checkNotNullParameter(str, "tag");
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(str);
        Intrinsics.reifiedOperationMarker(2, "DF");
        return (DialogFragment) findFragmentByTag;
    }

    public static final /* synthetic */ <DF extends DialogFragment> DF findByTag(FragmentManager fragmentManager, String str) {
        Intrinsics.checkNotNullParameter(fragmentManager, "<this>");
        Intrinsics.checkNotNullParameter(str, "tag");
        DF findFragmentByTag = fragmentManager.findFragmentByTag(str);
        Intrinsics.reifiedOperationMarker(2, "DF");
        return (DialogFragment) findFragmentByTag;
    }

    public static /* synthetic */ boolean hasTag$default(FragmentManager fragmentManager, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            Intrinsics.reifiedOperationMarker(4, "DF");
            Class<DialogFragment> cls = DialogFragment.class;
            Class cls2 = cls;
            str = cls.getSimpleName();
            Intrinsics.checkNotNullExpressionValue(str, "getSimpleName(...)");
            String str2 = str;
        }
        Intrinsics.checkNotNullParameter(fragmentManager, "<this>");
        Intrinsics.checkNotNullParameter(str, "tag");
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(str);
        Intrinsics.reifiedOperationMarker(3, "DF");
        return findFragmentByTag instanceof DialogFragment;
    }

    public static final /* synthetic */ <DF extends DialogFragment> boolean hasTag(FragmentManager fragmentManager, String str) {
        Intrinsics.checkNotNullParameter(fragmentManager, "<this>");
        Intrinsics.checkNotNullParameter(str, "tag");
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(str);
        Intrinsics.reifiedOperationMarker(3, "DF");
        return findFragmentByTag instanceof DialogFragment;
    }

    public static /* synthetic */ DialogFragment show$default(FragmentManager fragmentManager, String str, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            Intrinsics.reifiedOperationMarker(4, "DF");
            Class<DialogFragment> cls = DialogFragment.class;
            Class cls2 = cls;
            str = cls.getSimpleName();
            Intrinsics.checkNotNullExpressionValue(str, "getSimpleName(...)");
            String str2 = str;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(fragmentManager, "<this>");
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(function0, "factory");
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(str);
        Intrinsics.reifiedOperationMarker(3, "DF");
        if ((findFragmentByTag instanceof DialogFragment) || fragmentManager.isStateSaved()) {
            return null;
        }
        DialogFragment dialogFragment = (DialogFragment) function0.invoke();
        dialogFragment.show(fragmentManager, str);
        if (z) {
            fragmentManager.executePendingTransactions();
        }
        return dialogFragment;
    }

    public static final void setFragmentResultListenerWithClear(Fragment fragment, String str, Function2<? super String, ? super Bundle, Unit> function2) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(str, "requestKey");
        Intrinsics.checkNotNullParameter(function2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        fragment.getParentFragmentManager().clearFragmentResult(str);
        fragment.getParentFragmentManager().setFragmentResultListener(str, fragment, new FragmentExtensionsKt$$ExternalSyntheticLambda0(function2));
    }

    /* access modifiers changed from: private */
    public static final void setFragmentResultListenerWithClear$lambda$0(Function2 function2, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "p0");
        Intrinsics.checkNotNullParameter(bundle, "p1");
        function2.invoke(str, bundle);
    }

    public static final /* synthetic */ <DF extends DialogFragment> DF show(FragmentManager fragmentManager, String str, boolean z, Function0<? extends DF> function0) {
        Intrinsics.checkNotNullParameter(fragmentManager, "<this>");
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(function0, "factory");
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(str);
        Intrinsics.reifiedOperationMarker(3, "DF");
        if ((findFragmentByTag instanceof DialogFragment) || fragmentManager.isStateSaved()) {
            return null;
        }
        DF df = (DialogFragment) function0.invoke();
        df.show(fragmentManager, str);
        if (z) {
            fragmentManager.executePendingTransactions();
        }
        return df;
    }
}
