package com.blueair.devicedetails.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.viewmodel.UserManualViewModel;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.github.barteksc.pdfviewer.PDFView;
import java.io.File;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import timber.log.Timber;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u0005H\u0003J\b\u0010\u001f\u001a\u00020\u001bH\u0014R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058TX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/blueair/devicedetails/activity/UserManualActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "_screenName", "pdfView", "Lcom/github/barteksc/pdfviewer/PDFView;", "tvSubtitle", "Landroid/widget/TextView;", "progressView", "Lcom/blueair/viewcore/view/ProgressBlockerView;", "url", "defPageNum", "", "viewModel", "Lcom/blueair/devicedetails/viewmodel/UserManualViewModel;", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/UserManualViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "cacheFile", "Ljava/io/File;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "downloadFromUri", "onDestroy", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserManualActivity.kt */
public final class UserManualActivity extends BaseActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXTRA_PAGE_NUMBER = "EXTRA_PAGE_NUMBER";
    private static final String EXTRA_URL = "EXTRA_URL";
    private String _screenName;
    /* access modifiers changed from: private */
    public File cacheFile;
    /* access modifiers changed from: private */
    public int defPageNum = 1;
    /* access modifiers changed from: private */
    public PDFView pdfView;
    /* access modifiers changed from: private */
    public ProgressBlockerView progressView;
    /* access modifiers changed from: private */
    public TextView tvSubtitle;
    private String url;
    private final Lazy viewModel$delegate;

    public UserManualActivity() {
        ComponentActivity componentActivity = this;
        this.viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(UserManualViewModel.class), new UserManualActivity$special$$inlined$viewModels$default$2(componentActivity), new UserManualActivity$special$$inlined$viewModels$default$1(componentActivity), new UserManualActivity$special$$inlined$viewModels$default$3((Function0) null, componentActivity));
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this._screenName;
    }

    /* access modifiers changed from: private */
    public final UserManualViewModel getViewModel() {
        return (UserManualViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_user_manual);
        View findViewById = findViewById(R.id.pdf_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.pdfView = (PDFView) findViewById;
        View findViewById2 = findViewById(R.id.progressView);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.progressView = (ProgressBlockerView) findViewById2;
        Intent intent = getIntent();
        if (intent != null) {
            this._screenName = intent.getStringExtra("screen_name");
            String stringExtra = intent.getStringExtra(EXTRA_URL);
            if (stringExtra != null) {
                this.url = stringExtra;
                this.defPageNum = RangesKt.coerceAtLeast(intent.getIntExtra(EXTRA_PAGE_NUMBER, this.defPageNum) - 1, 0);
            } else {
                throw new IllegalStateException("Required value was null.".toString());
            }
        }
        View findViewById3 = findViewById(R.id.tv_subtitle);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.tvSubtitle = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.close_btn);
        View findViewById5 = findViewById(R.id.btnBack);
        findViewById4.setOnClickListener(new UserManualActivity$$ExternalSyntheticLambda0(this));
        findViewById5.setOnClickListener(new UserManualActivity$$ExternalSyntheticLambda1(this));
        String str = this.url;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("url");
            str = null;
        }
        downloadFromUri(str);
        String languageTag = Locale.getDefault().toLanguageTag();
        Timber.Forest forest = Timber.Forest;
        forest.d("LanguageCode: " + languageTag, new Object[0]);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$1(UserManualActivity userManualActivity, View view) {
        userManualActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$2(UserManualActivity userManualActivity, View view) {
        userManualActivity.finish();
    }

    private final void downloadFromUri(String str) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new UserManualActivity$downloadFromUri$1(this, str, (Continuation<? super UserManualActivity$downloadFromUri$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        try {
            Result.Companion companion = Result.Companion;
            PDFView pDFView = this.pdfView;
            Boolean bool = null;
            if (pDFView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pdfView");
                pDFView = null;
            }
            pDFView.recycle();
            File file = this.cacheFile;
            if (file != null) {
                bool = Boolean.valueOf(file.delete());
            }
            Result.m9366constructorimpl(bool);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m9366constructorimpl(ResultKt.createFailure(th));
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/blueair/devicedetails/activity/UserManualActivity$Companion;", "", "<init>", "()V", "EXTRA_URL", "", "EXTRA_PAGE_NUMBER", "launch", "", "context", "Landroid/content/Context;", "screenName", "url", "pageNum", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: UserManualActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, String str, String str2, int i, int i2, Object obj) {
            if ((i2 & 8) != 0) {
                i = 1;
            }
            companion.launch(context, str, str2, i);
        }

        public final void launch(Context context, String str, String str2, int i) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str2, "url");
            Intent intent = new Intent(context, UserManualActivity.class);
            intent.putExtra("screen_name", str);
            intent.putExtra(UserManualActivity.EXTRA_URL, str2);
            intent.putExtra(UserManualActivity.EXTRA_PAGE_NUMBER, i);
            context.startActivity(intent);
        }
    }
}
