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

@Metadata(
   d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0011H\u0014R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u001a"},
   d2 = {"Lcom/blueair/devicedetails/activity/FilterVideoActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/devicedetails/databinding/ActivityFilterVideoBinding;", "mediaController", "Landroid/widget/MediaController;", "getMediaController", "()Landroid/widget/MediaController;", "mediaController$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onDestroy", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class FilterVideoActivity extends BaseActivity {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final String EXTRA_VIDEO_URL = "EXTRA_VIDEO_URL";
   private ActivityFilterVideoBinding binding;
   private final Lazy mediaController$delegate = LazyKt.lazy(new FilterVideoActivity$$ExternalSyntheticLambda0(this));
   private final String screenName = "device_filter_video";

   // $FF: synthetic method
   public static void $r8$lambda$4iOHNswCYG8Fm7K7oUr0SetknaM(FilterVideoActivity var0, View var1) {
      onCreate$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static MediaController $r8$lambda$GpqORpY_WZsXAF0RWRiFRYXFAac(FilterVideoActivity var0) {
      return mediaController_delegate$lambda$0(var0);
   }

   // $FF: synthetic method
   public static boolean $r8$lambda$QtEeDzCiPNSrYjMOx8QxWocODI4(FilterVideoActivity var0, MediaPlayer var1, int var2, int var3) {
      return onCreate$lambda$3(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static void $r8$lambda$kITNV4J1c_azTO0Q01JApOuFC4A/* $FF was: $r8$lambda$kITNV4J1c-azTO0Q01JApOuFC4A*/(FilterVideoActivity var0, View var1) {
      onCreate$lambda$2(var0, var1);
   }

   private final MediaController getMediaController() {
      return (MediaController)this.mediaController$delegate.getValue();
   }

   private static final MediaController mediaController_delegate$lambda$0(FilterVideoActivity var0) {
      MediaController var1 = new MediaController((Context)var0);
      var1.show(500);
      return var1;
   }

   private static final void onCreate$lambda$1(FilterVideoActivity var0, View var1) {
      var0.getMediaController().show();
   }

   private static final void onCreate$lambda$2(FilterVideoActivity var0, View var1) {
      var0.finish();
   }

   private static final boolean onCreate$lambda$3(FilterVideoActivity var0, MediaPlayer var1, int var2, int var3) {
      Timber.Forest var9 = Timber.Forest;
      StringBuilder var4 = new StringBuilder("video info: ");
      var4.append(var2);
      var4.append(" | ");
      var4.append(var3);
      var9.d(var4.toString(), new Object[0]);
      Object var10 = null;
      if (var2 != 3) {
         if (var2 == 701) {
            ActivityFilterVideoBinding var11 = var0.binding;
            ActivityFilterVideoBinding var7 = var11;
            if (var11 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("binding");
               var7 = null;
            }

            ProgressBlockerView var8 = var7.progressView;
            Intrinsics.checkNotNullExpressionValue(var8, "progressView");
            ViewExtensionsKt.show$default((View)var8, false, 1, (Object)null);
            return true;
         }

         if (var2 != 702) {
            return false;
         }
      }

      ActivityFilterVideoBinding var5 = var0.binding;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var5 = (ActivityFilterVideoBinding)var10;
      }

      ProgressBlockerView var6 = var5.progressView;
      Intrinsics.checkNotNullExpressionValue(var6, "progressView");
      ViewExtensionsKt.hide((View)var6);
      return true;
   }

   protected String getScreenName() {
      return this.screenName;
   }

   protected void onCreate(Bundle var1) {
      this.setTheme(R.style.AppTheme_NoActionBar);
      super.onCreate(var1);
      ActivityFilterVideoBinding var3 = ActivityFilterVideoBinding.inflate(this.getLayoutInflater());
      Intrinsics.checkNotNullExpressionValue(var3, "inflate(...)");
      this.binding = var3;
      Object var2 = null;
      ActivityFilterVideoBinding var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      this.setContentView((View)var4.getRoot());
      var3 = this.binding;
      var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      var4.rootLayout.setOnClickListener(new FilterVideoActivity$$ExternalSyntheticLambda1(this));
      var3 = this.binding;
      var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      var4.closeIcon.setOnClickListener(new FilterVideoActivity$$ExternalSyntheticLambda2(this));
      String var11 = this.getIntent().getStringExtra("EXTRA_VIDEO_URL");
      if (var11 != null) {
         var4 = this.binding;
         if (var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var4 = (ActivityFilterVideoBinding)var2;
         }

         VideoView var8 = var4.videoView;
         Intrinsics.checkNotNullExpressionValue(var8, "videoView");
         var8.setMediaController(this.getMediaController());
         var8.setVideoURI(Uri.parse(var11));
         var8.start();
         var8.setOnInfoListener(new FilterVideoActivity$$ExternalSyntheticLambda3(this));
      }
   }

   protected void onDestroy() {
      super.onDestroy();
      ActivityFilterVideoBinding var2 = this.binding;
      ActivityFilterVideoBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      var1.videoView.stopPlayback();
   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      Intrinsics.checkNotNullParameter(var1, "item");
      if (var1.getItemId() == 16908332) {
         this.onBackPressed();
         return true;
      } else {
         return super.onOptionsItemSelected(var1);
      }
   }

   @Metadata(
      d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"},
      d2 = {"Lcom/blueair/devicedetails/activity/FilterVideoActivity$Companion;", "", "<init>", "()V", "EXTRA_VIDEO_URL", "", "launch", "", "context", "Landroid/content/Context;", "videoUrl", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }

      public final void launch(Context var1, String var2) {
         Intrinsics.checkNotNullParameter(var1, "context");
         Intrinsics.checkNotNullParameter(var2, "videoUrl");
         var1.startActivity((new Intent(var1, FilterVideoActivity.class)).putExtra("EXTRA_VIDEO_URL", var2));
      }
   }
}
