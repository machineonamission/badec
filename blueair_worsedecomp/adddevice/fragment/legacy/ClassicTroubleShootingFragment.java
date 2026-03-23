package com.blueair.adddevice.fragment.legacy;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.blueair.adddevice.databinding.FragmentClassicTroubleshootingBinding;
import com.blueair.viewcore.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X.¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/ClassicTroubleShootingFragment;", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceBaseFragment;", "<init>", "()V", "binding", "Lcom/blueair/adddevice/databinding/FragmentClassicTroubleshootingBinding;", "radioButtons", "", "Landroid/widget/CompoundButton;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ClassicTroubleShootingFragment.kt */
public final class ClassicTroubleShootingFragment extends AddDeviceBaseFragment {
    private FragmentClassicTroubleshootingBinding binding;
    private Set<? extends CompoundButton> radioButtons;

    public ConstraintLayout getRootView() {
        return null;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentClassicTroubleshootingBinding inflate = FragmentClassicTroubleshootingBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        View root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        FragmentClassicTroubleshootingBinding fragmentClassicTroubleshootingBinding = this.binding;
        FragmentClassicTroubleshootingBinding fragmentClassicTroubleshootingBinding2 = null;
        if (fragmentClassicTroubleshootingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentClassicTroubleshootingBinding = null;
        }
        Drawable drawable = fragmentClassicTroubleshootingBinding.imgWifiBlinking.getDrawable();
        Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        ((AnimationDrawable) drawable).start();
        FragmentClassicTroubleshootingBinding fragmentClassicTroubleshootingBinding3 = this.binding;
        if (fragmentClassicTroubleshootingBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentClassicTroubleshootingBinding3 = null;
        }
        Drawable drawable2 = fragmentClassicTroubleshootingBinding3.imgWifiFading.getDrawable();
        Intrinsics.checkNotNull(drawable2, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable2;
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();
        FragmentClassicTroubleshootingBinding fragmentClassicTroubleshootingBinding4 = this.binding;
        if (fragmentClassicTroubleshootingBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentClassicTroubleshootingBinding4 = null;
        }
        Drawable drawable3 = fragmentClassicTroubleshootingBinding4.imgWifiFadingFast.getDrawable();
        Intrinsics.checkNotNull(drawable3, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        AnimationDrawable animationDrawable2 = (AnimationDrawable) drawable3;
        animationDrawable2.setEnterFadeDuration(2000);
        animationDrawable2.setExitFadeDuration(2000);
        animationDrawable2.start();
        FragmentClassicTroubleshootingBinding fragmentClassicTroubleshootingBinding5 = this.binding;
        if (fragmentClassicTroubleshootingBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentClassicTroubleshootingBinding2 = fragmentClassicTroubleshootingBinding5;
        }
        this.radioButtons = SetsKt.setOf(fragmentClassicTroubleshootingBinding2.radioBtnWifiBlinking, fragmentClassicTroubleshootingBinding2.radioBtnWifiFading, fragmentClassicTroubleshootingBinding2.radioBtnWifiFadingFast, fragmentClassicTroubleshootingBinding2.radioBtnWifiSolid);
        fragmentClassicTroubleshootingBinding2.radioBtnWifiBlinking.setOnCheckedChangeListener(new ClassicTroubleShootingFragment$$ExternalSyntheticLambda0(this, fragmentClassicTroubleshootingBinding2));
        fragmentClassicTroubleshootingBinding2.radioBtnWifiFading.setOnCheckedChangeListener(new ClassicTroubleShootingFragment$$ExternalSyntheticLambda0(this, fragmentClassicTroubleshootingBinding2));
        fragmentClassicTroubleshootingBinding2.radioBtnWifiFadingFast.setOnCheckedChangeListener(new ClassicTroubleShootingFragment$$ExternalSyntheticLambda0(this, fragmentClassicTroubleshootingBinding2));
        fragmentClassicTroubleshootingBinding2.radioBtnWifiSolid.setOnCheckedChangeListener(new ClassicTroubleShootingFragment$$ExternalSyntheticLambda0(this, fragmentClassicTroubleshootingBinding2));
        fragmentClassicTroubleshootingBinding2.btnNext.setOnClickListener(new ClassicTroubleShootingFragment$$ExternalSyntheticLambda1(this, fragmentClassicTroubleshootingBinding2));
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$7$onCheckedChange(ClassicTroubleShootingFragment classicTroubleShootingFragment, FragmentClassicTroubleshootingBinding fragmentClassicTroubleshootingBinding, CompoundButton compoundButton, boolean z) {
        Set<? extends CompoundButton> set = classicTroubleShootingFragment.radioButtons;
        if (set == null) {
            Intrinsics.throwUninitializedPropertyAccessException("radioButtons");
            set = null;
        }
        Collection arrayList = new ArrayList();
        for (Object next : set) {
            if (((CompoundButton) next).getId() != compoundButton.getId() && z) {
                arrayList.add(next);
            }
        }
        for (CompoundButton checked : (List) arrayList) {
            checked.setChecked(false);
        }
        Unit unit = Unit.INSTANCE;
        TextView textView = fragmentClassicTroubleshootingBinding.txtError;
        Intrinsics.checkNotNullExpressionValue(textView, "txtError");
        ViewExtensionsKt.hide(textView);
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$7$lambda$6(ClassicTroubleShootingFragment classicTroubleShootingFragment, FragmentClassicTroubleshootingBinding fragmentClassicTroubleshootingBinding, View view) {
        Object obj;
        Set<? extends CompoundButton> set = classicTroubleShootingFragment.radioButtons;
        if (set == null) {
            Intrinsics.throwUninitializedPropertyAccessException("radioButtons");
            set = null;
        }
        Iterator it = set.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((CompoundButton) obj).isChecked()) {
                break;
            }
        }
        CompoundButton compoundButton = (CompoundButton) obj;
        Integer valueOf = compoundButton != null ? Integer.valueOf(compoundButton.getId()) : null;
        int id = fragmentClassicTroubleshootingBinding.radioBtnWifiBlinking.getId();
        if (valueOf != null && valueOf.intValue() == id) {
            classicTroubleShootingFragment.getAddService().startManualConfigClassic();
            return;
        }
        int id2 = fragmentClassicTroubleshootingBinding.radioBtnWifiFading.getId();
        if (valueOf != null && valueOf.intValue() == id2) {
            classicTroubleShootingFragment.getAddService().startManualConfigStep2Classic();
            return;
        }
        int id3 = fragmentClassicTroubleshootingBinding.radioBtnWifiFadingFast.getId();
        if (valueOf != null && valueOf.intValue() == id3) {
            classicTroubleShootingFragment.getAddService().startAutoOrManualClassic();
            return;
        }
        int id4 = fragmentClassicTroubleshootingBinding.radioBtnWifiSolid.getId();
        if (valueOf != null && valueOf.intValue() == id4) {
            classicTroubleShootingFragment.getAddService().startActivateDeviceWifiClassic();
            return;
        }
        TextView textView = fragmentClassicTroubleshootingBinding.txtError;
        Intrinsics.checkNotNullExpressionValue(textView, "txtError");
        ViewExtensionsKt.show$default(textView, false, 1, (Object) null);
    }

    public void onResume() {
        super.onResume();
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        ActionBar supportActionBar = ((AppCompatActivity) activity).getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle((CharSequence) getString(R.string.troubleshooting));
        }
        Set<? extends CompoundButton> set = this.radioButtons;
        if (set == null) {
            Intrinsics.throwUninitializedPropertyAccessException("radioButtons");
            set = null;
        }
        for (CompoundButton checked : set) {
            checked.setChecked(false);
        }
    }
}
