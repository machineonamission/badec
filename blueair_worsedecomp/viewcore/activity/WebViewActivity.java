package com.blueair.viewcore.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.blueair.viewcore.R;
import com.blueair.viewcore.databinding.ActivityWebViewBinding;
import com.blueair.viewcore.extensions.ToolbarExtensionsKt;
import com.blueair.viewcore.fragment.WebViewFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058TX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/blueair/viewcore/activity/WebViewActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "_screenName", "binding", "Lcom/blueair/viewcore/databinding/ActivityWebViewBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setToolbar", "title", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "Companion", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: WebViewActivity.kt */
public final class WebViewActivity extends BaseActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXTRA_TITLE = "extra_title";
    private static final String EXTRA_URL = "extra_url";
    private String _screenName;
    private ActivityWebViewBinding binding;

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this._screenName;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityWebViewBinding inflate = ActivityWebViewBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView((View) inflate.getRoot());
        this._screenName = getIntent().getStringExtra("screen_name");
        setToolbar(getIntent().getStringExtra("extra_title"));
        String stringExtra = getIntent().getStringExtra(EXTRA_URL);
        WebViewFragment.Companion companion = WebViewFragment.Companion;
        Intrinsics.checkNotNull(stringExtra);
        WebViewFragment newInstance = companion.newInstance(stringExtra);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        beginTransaction.replace(R.id.container, newInstance);
        beginTransaction.commit();
    }

    private final void setToolbar(String str) {
        ActivityWebViewBinding activityWebViewBinding = this.binding;
        ActivityWebViewBinding activityWebViewBinding2 = null;
        if (activityWebViewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWebViewBinding = null;
        }
        setSupportActionBar(activityWebViewBinding.toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white);
        }
        ActionBar supportActionBar3 = getSupportActionBar();
        if (supportActionBar3 != null) {
            supportActionBar3.setDisplayShowTitleEnabled(false);
        }
        ActivityWebViewBinding activityWebViewBinding3 = this.binding;
        if (activityWebViewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWebViewBinding3 = null;
        }
        Toolbar toolbar = activityWebViewBinding3.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        Context context = this;
        ToolbarExtensionsKt.changeToolbarFont(toolbar, context, R.font.apercu_bold);
        ActivityWebViewBinding activityWebViewBinding4 = this.binding;
        if (activityWebViewBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWebViewBinding4 = null;
        }
        activityWebViewBinding4.toolbar.setTitleTextColor(ContextCompat.getColor(context, R.color.colorOnPrimary));
        ActivityWebViewBinding activityWebViewBinding5 = this.binding;
        if (activityWebViewBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityWebViewBinding2 = activityWebViewBinding5;
        }
        activityWebViewBinding2.toolbar.setTitle((CharSequence) str);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/blueair/viewcore/activity/WebViewActivity$Companion;", "", "<init>", "()V", "EXTRA_TITLE", "", "EXTRA_URL", "launch", "", "context", "Landroid/content/Context;", "screenName", "title", "url", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: WebViewActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void launch(Context context, String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(str3, "url");
            Intent intent = new Intent(context, WebViewActivity.class);
            intent.putExtra("screen_name", str);
            intent.putExtra("extra_title", str2);
            intent.putExtra(WebViewActivity.EXTRA_URL, str3);
            context.startActivity(intent);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        finish();
        return true;
    }
}
