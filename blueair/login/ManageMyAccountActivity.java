package com.blueair.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import com.blueair.login.databinding.ActivityManageMyAccountBinding;
import com.blueair.viewcore.activity.BaseActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"},
   d2 = {"Lcom/blueair/login/ManageMyAccountActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "login_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ManageMyAccountActivity extends BaseActivity {
   private final String screenName = "side_menu_profile_manage_account";

   // $FF: synthetic method
   public static void $r8$lambda$09LD7gEZZIVt13ZYa8PpogK8S9M(ManageMyAccountActivity var0, View var1) {
      onCreate$lambda$1$lambda$0(var0, var1);
   }

   private static final void onCreate$lambda$1$lambda$0(ManageMyAccountActivity var0, View var1) {
      var0.startActivity(new Intent((Context)var0, DeleteAccountConfirmActivity.class));
   }

   protected String getScreenName() {
      return this.screenName;
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      ActivityManageMyAccountBinding var3 = (ActivityManageMyAccountBinding)DataBindingUtil.setContentView((Activity)this, R.layout.activity_manage_my_account);
      this.setSupportActionBar((Toolbar)var3.toolbar);
      ActionBar var2 = this.getSupportActionBar();
      if (var2 != null) {
         var2.setDisplayHomeAsUpEnabled(true);
      }

      var2 = this.getSupportActionBar();
      if (var2 != null) {
         var2.setHomeAsUpIndicator(com.blueair.viewcore.R.drawable.ic_arrow_back_white);
      }

      var2 = this.getSupportActionBar();
      if (var2 != null) {
         var2.setHomeActionContentDescription(com.blueair.viewcore.R.string.home_as_up_content_description);
      }

      var2 = this.getSupportActionBar();
      if (var2 != null) {
         var2.setDisplayShowTitleEnabled(false);
      }

      var2 = this.getSupportActionBar();
      if (var2 != null) {
         var2.setHomeButtonEnabled(true);
      }

      var3.deleteAccountCell.setOnClickListener(new ManageMyAccountActivity$$ExternalSyntheticLambda0(this));
   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      Intrinsics.checkNotNullParameter(var1, "item");
      if (var1.getItemId() == 16908332) {
         this.finish();
         return true;
      } else {
         return super.onOptionsItemSelected(var1);
      }
   }
}
