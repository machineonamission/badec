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

@Metadata(
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0016"},
   d2 = {"Lcom/blueair/viewcore/activity/WebViewActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "_screenName", "binding", "Lcom/blueair/viewcore/databinding/ActivityWebViewBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setToolbar", "title", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "Companion", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class WebViewActivity extends BaseActivity {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final String EXTRA_TITLE = "extra_title";
   private static final String EXTRA_URL = "extra_url";
   private String _screenName;
   private ActivityWebViewBinding binding;

   private final void setToolbar(String var1) {
      ActivityWebViewBinding var4 = this.binding;
      Object var3 = null;
      ActivityWebViewBinding var2 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      this.setSupportActionBar(var2.toolbar);
      ActionBar var6 = this.getSupportActionBar();
      if (var6 != null) {
         var6.setDisplayHomeAsUpEnabled(true);
      }

      var6 = this.getSupportActionBar();
      if (var6 != null) {
         var6.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white);
      }

      var6 = this.getSupportActionBar();
      if (var6 != null) {
         var6.setDisplayShowTitleEnabled(false);
      }

      var4 = this.binding;
      ActivityWebViewBinding var9 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var9 = null;
      }

      Toolbar var10 = var9.toolbar;
      Intrinsics.checkNotNullExpressionValue(var10, "toolbar");
      Context var5 = (Context)this;
      ToolbarExtensionsKt.changeToolbarFont(var10, var5, R.font.apercu_bold);
      var4 = this.binding;
      ActivityWebViewBinding var11 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var11 = null;
      }

      var11.toolbar.setTitleTextColor(ContextCompat.getColor(var5, R.color.colorOnPrimary));
      var11 = this.binding;
      if (var11 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var11 = (ActivityWebViewBinding)var3;
      }

      var11.toolbar.setTitle((CharSequence)var1);
   }

   protected String getScreenName() {
      return this._screenName;
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      ActivityWebViewBinding var2 = ActivityWebViewBinding.inflate(this.getLayoutInflater());
      Intrinsics.checkNotNullExpressionValue(var2, "inflate(...)");
      this.binding = var2;
      ActivityWebViewBinding var3 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var3 = null;
      }

      this.setContentView((View)var3.getRoot());
      this._screenName = this.getIntent().getStringExtra("screen_name");
      this.setToolbar(this.getIntent().getStringExtra("extra_title"));
      String var6 = this.getIntent().getStringExtra("extra_url");
      WebViewFragment.Companion var4 = WebViewFragment.Companion;
      Intrinsics.checkNotNull(var6);
      WebViewFragment var5 = var4.newInstance(var6);
      FragmentManager var7 = this.getSupportFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var7, "getSupportFragmentManager(...)");
      FragmentTransaction var8 = var7.beginTransaction();
      Intrinsics.checkNotNullExpressionValue(var8, "beginTransaction()");
      var8.replace(R.id.container, var5);
      var8.commit();
   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      Intrinsics.checkNotNullParameter(var1, "item");
      this.finish();
      return true;
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"},
      d2 = {"Lcom/blueair/viewcore/activity/WebViewActivity$Companion;", "", "<init>", "()V", "EXTRA_TITLE", "", "EXTRA_URL", "launch", "", "context", "Landroid/content/Context;", "screenName", "title", "url", "viewcore_otherRelease"},
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

      public final void launch(Context var1, String var2, String var3, String var4) {
         Intrinsics.checkNotNullParameter(var1, "context");
         Intrinsics.checkNotNullParameter(var3, "title");
         Intrinsics.checkNotNullParameter(var4, "url");
         Intent var5 = new Intent(var1, WebViewActivity.class);
         var5.putExtra("screen_name", var2);
         var5.putExtra("extra_title", var3);
         var5.putExtra("extra_url", var4);
         var1.startActivity(var5);
      }
   }
}
