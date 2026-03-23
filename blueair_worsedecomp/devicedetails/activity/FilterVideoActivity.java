package com.blueair.devicedetails.activity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.devicedetails.databinding.ActivityFilterVideoBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.view.ProgressBlockerView;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0011H\u0014R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/blueair/devicedetails/activity/FilterVideoActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/devicedetails/databinding/ActivityFilterVideoBinding;", "mediaController", "Landroid/widget/MediaController;", "getMediaController", "()Landroid/widget/MediaController;", "mediaController$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onDestroy", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: FilterVideoActivity.kt */
public final class FilterVideoActivity extends BaseActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXTRA_VIDEO_URL = "EXTRA_VIDEO_URL";
    private ActivityFilterVideoBinding binding;
    private final Lazy mediaController$delegate = LazyKt.lazy(new FilterVideoActivity$$ExternalSyntheticLambda0(this));
    private final String screenName = AnalyticEvent.ScreenViewEvent.DEVICE_FILTER_VIDEO;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/blueair/devicedetails/activity/FilterVideoActivity$Companion;", "", "<init>", "()V", "EXTRA_VIDEO_URL", "", "launch", "", "context", "Landroid/content/Context;", "videoUrl", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: FilterVideoActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void launch(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "videoUrl");
            context.startActivity(new Intent(context, FilterVideoActivity.class).putExtra(FilterVideoActivity.EXTRA_VIDEO_URL, str));
        }
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    private final MediaController getMediaController() {
        return (MediaController) this.mediaController$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final MediaController mediaController_delegate$lambda$0(FilterVideoActivity filterVideoActivity) {
        MediaController mediaController = new MediaController(filterVideoActivity);
        mediaController.show(500);
        return mediaController;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        setTheme(R.style.AppTheme_NoActionBar);
        super.onCreate(bundle);
        ActivityFilterVideoBinding inflate = ActivityFilterVideoBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        ActivityFilterVideoBinding activityFilterVideoBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView((View) inflate.getRoot());
        ActivityFilterVideoBinding activityFilterVideoBinding2 = this.binding;
        if (activityFilterVideoBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityFilterVideoBinding2 = null;
        }
        activityFilterVideoBinding2.rootLayout.setOnClickListener(new FilterVideoActivity$$ExternalSyntheticLambda1(this));
        ActivityFilterVideoBinding activityFilterVideoBinding3 = this.binding;
        if (activityFilterVideoBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityFilterVideoBinding3 = null;
        }
        activityFilterVideoBinding3.closeIcon.setOnClickListener(new FilterVideoActivity$$ExternalSyntheticLambda2(this));
        String stringExtra = getIntent().getStringExtra(EXTRA_VIDEO_URL);
        if (stringExtra != null) {
            ActivityFilterVideoBinding activityFilterVideoBinding4 = this.binding;
            if (activityFilterVideoBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityFilterVideoBinding = activityFilterVideoBinding4;
            }
            VideoView videoView = activityFilterVideoBinding.videoView;
            Intrinsics.checkNotNullExpressionValue(videoView, "videoView");
            videoView.setMediaController(getMediaController());
            videoView.setVideoURI(Uri.parse(stringExtra));
            videoView.start();
            videoView.setOnInfoListener(new FilterVideoActivity$$ExternalSyntheticLambda3(this));
        }
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$1(FilterVideoActivity filterVideoActivity, View view) {
        filterVideoActivity.getMediaController().show();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$2(FilterVideoActivity filterVideoActivity, View view) {
        filterVideoActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final boolean onCreate$lambda$3(FilterVideoActivity filterVideoActivity, MediaPlayer mediaPlayer, int i, int i2) {
        Timber.Forest.d("video info: " + i + " | " + i2, new Object[0]);
        ActivityFilterVideoBinding activityFilterVideoBinding = null;
        if (i != 3) {
            if (i == 701) {
                ActivityFilterVideoBinding activityFilterVideoBinding2 = filterVideoActivity.binding;
                if (activityFilterVideoBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityFilterVideoBinding2 = null;
                }
                ProgressBlockerView progressBlockerView = activityFilterVideoBinding2.progressView;
                Intrinsics.checkNotNullExpressionValue(progressBlockerView, "progressView");
                ViewExtensionsKt.show$default(progressBlockerView, false, 1, (Object) null);
                return true;
            } else if (i != 702) {
                return false;
            }
        }
        ActivityFilterVideoBinding activityFilterVideoBinding3 = filterVideoActivity.binding;
        if (activityFilterVideoBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityFilterVideoBinding = activityFilterVideoBinding3;
        }
        ProgressBlockerView progressBlockerView2 = activityFilterVideoBinding.progressView;
        Intrinsics.checkNotNullExpressionValue(progressBlockerView2, "progressView");
        ViewExtensionsKt.hide(progressBlockerView2);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        ActivityFilterVideoBinding activityFilterVideoBinding = this.binding;
        if (activityFilterVideoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityFilterVideoBinding = null;
        }
        activityFilterVideoBinding.videoView.stopPlayback();
    }
}
