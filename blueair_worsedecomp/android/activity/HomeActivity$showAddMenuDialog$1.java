package com.blueair.android.activity;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blueair.android.R;
import com.blueair.android.fragment.IndoorFragment;
import com.blueair.antifake.dialog.AntiFakeActionDialogFragment;
import com.kongzue.dialogx.dialogs.CustomDialog;
import com.kongzue.dialogx.interfaces.OnBindView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/blueair/android/activity/HomeActivity$showAddMenuDialog$1", "Lcom/kongzue/dialogx/interfaces/OnBindView;", "Lcom/kongzue/dialogx/dialogs/CustomDialog;", "onBind", "", "dialog", "v", "Landroid/view/View;", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: HomeActivity.kt */
public final class HomeActivity$showAddMenuDialog$1 extends OnBindView<CustomDialog> {
    final /* synthetic */ HomeActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeActivity$showAddMenuDialog$1(HomeActivity homeActivity, int i) {
        super(i);
        this.this$0 = homeActivity;
    }

    public void onBind(CustomDialog customDialog, View view) {
        Intrinsics.checkNotNullParameter(customDialog, "dialog");
        Intrinsics.checkNotNullParameter(view, "v");
        View findViewById = view.findViewById(R.id.tv_addProduct);
        View findViewById2 = view.findViewById(R.id.tv_scanFilter);
        Intrinsics.checkNotNull(findViewById2);
        findViewById2.setVisibility(this.this$0.getViewModel().isInAntiFakeRegion() ? 0 : 8);
        findViewById2.setOnClickListener(new HomeActivity$showAddMenuDialog$1$$ExternalSyntheticLambda0(customDialog, this.this$0));
        findViewById.setOnClickListener(new HomeActivity$showAddMenuDialog$1$$ExternalSyntheticLambda1(customDialog, this.this$0));
    }

    /* access modifiers changed from: private */
    public static final void onBind$lambda$1(CustomDialog customDialog, HomeActivity homeActivity, View view) {
        customDialog.dismiss();
        FragmentManager supportFragmentManager = homeActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        Class<AntiFakeActionDialogFragment> cls = AntiFakeActionDialogFragment.class;
        Intrinsics.checkNotNullExpressionValue("AntiFakeActionDialogFragment", "getSimpleName(...)");
        if (!(supportFragmentManager.findFragmentByTag("AntiFakeActionDialogFragment") instanceof AntiFakeActionDialogFragment) && !supportFragmentManager.isStateSaved()) {
            AntiFakeActionDialogFragment.Companion.newInstance().show(supportFragmentManager, "AntiFakeActionDialogFragment");
        }
    }

    /* access modifiers changed from: private */
    public static final void onBind$lambda$2(CustomDialog customDialog, HomeActivity homeActivity, View view) {
        customDialog.dismiss();
        Fragment fragment = homeActivity.getSupportFragmentManager().getFragments().get(1);
        Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type com.blueair.android.fragment.IndoorFragment");
        ((IndoorFragment) fragment).connectDevice();
    }
}
