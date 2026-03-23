package com.blueair.android.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.blueair.android.databinding.ActivityConnectDeviceGuideBinding;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.activity.BaseActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/blueair/android/activity/ConnectDeviceGuideActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/android/databinding/ActivityConnectDeviceGuideBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectDeviceGuideActivity.kt */
public final class ConnectDeviceGuideActivity extends BaseActivity {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private ActivityConnectDeviceGuideBinding binding;
    private final String screenName = AnalyticEvent.ScreenViewEvent.CONNECT_DEVICE_GUIDE;

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/android/activity/ConnectDeviceGuideActivity$Companion;", "", "<init>", "()V", "launch", "", "context", "Landroid/content/Context;", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: ConnectDeviceGuideActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, ConnectDeviceGuideActivity.class));
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityConnectDeviceGuideBinding inflate = ActivityConnectDeviceGuideBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        ActivityConnectDeviceGuideBinding activityConnectDeviceGuideBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView((View) inflate.getRoot());
        immersiveStatusBar(true);
        ActivityConnectDeviceGuideBinding activityConnectDeviceGuideBinding2 = this.binding;
        if (activityConnectDeviceGuideBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityConnectDeviceGuideBinding2 = null;
        }
        activityConnectDeviceGuideBinding2.btnSearchFor.setOnClickListener(new ConnectDeviceGuideActivity$$ExternalSyntheticLambda0(this));
        ActivityConnectDeviceGuideBinding activityConnectDeviceGuideBinding3 = this.binding;
        if (activityConnectDeviceGuideBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityConnectDeviceGuideBinding3 = null;
        }
        activityConnectDeviceGuideBinding3.btnSkip.setOnClickListener(new ConnectDeviceGuideActivity$$ExternalSyntheticLambda1(this));
        ActivityConnectDeviceGuideBinding activityConnectDeviceGuideBinding4 = this.binding;
        if (activityConnectDeviceGuideBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityConnectDeviceGuideBinding4 = null;
        }
        activityConnectDeviceGuideBinding4.ivBack.setOnClickListener(new ConnectDeviceGuideActivity$$ExternalSyntheticLambda2(this));
        ActivityConnectDeviceGuideBinding activityConnectDeviceGuideBinding5 = this.binding;
        if (activityConnectDeviceGuideBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityConnectDeviceGuideBinding = activityConnectDeviceGuideBinding5;
        }
        activityConnectDeviceGuideBinding.ivClose.setOnClickListener(new ConnectDeviceGuideActivity$$ExternalSyntheticLambda3(this));
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$0(ConnectDeviceGuideActivity connectDeviceGuideActivity, View view) {
        connectDeviceGuideActivity.startActivity(Actions.INSTANCE.openAddDeviceIntent(connectDeviceGuideActivity));
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$1(ConnectDeviceGuideActivity connectDeviceGuideActivity, View view) {
        connectDeviceGuideActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$2(ConnectDeviceGuideActivity connectDeviceGuideActivity, View view) {
        connectDeviceGuideActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$3(ConnectDeviceGuideActivity connectDeviceGuideActivity, View view) {
        connectDeviceGuideActivity.finish();
    }
}
