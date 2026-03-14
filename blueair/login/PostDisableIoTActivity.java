package com.blueair.login;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.activity.OnBackPressedCallback;
import androidx.databinding.DataBindingUtil;
import com.blueair.login.databinding.ActivityPostDisableIotBinding;
import com.blueair.viewcore.activity.BaseLokaliseActivity;
import kotlin.Metadata;

@Metadata(
   d1 = {"\u0000!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010\u000b\u001a\u00020\bH\u0002R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\f"},
   d2 = {"Lcom/blueair/login/PostDisableIoTActivity;", "Lcom/blueair/viewcore/activity/BaseLokaliseActivity;", "<init>", "()V", "onBackPressedCallback", "com/blueair/login/PostDisableIoTActivity$onBackPressedCallback$1", "Lcom/blueair/login/PostDisableIoTActivity$onBackPressedCallback$1;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onClose", "login_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class PostDisableIoTActivity extends BaseLokaliseActivity {
   private final <undefinedtype> onBackPressedCallback = new OnBackPressedCallback(this) {
      final PostDisableIoTActivity this$0;

      {
         this.this$0 = var1;
      }

      public void handleOnBackPressed() {
         this.this$0.onClose();
      }
   };

   // $FF: synthetic method
   public static void $r8$lambda$QsW3WmHd8xmtAvtAvL6y7BFdXwU(PostDisableIoTActivity var0, View var1) {
      onCreate$lambda$2$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$leYn_387XbS9AlwSOR5y8jxaR6U(PostDisableIoTActivity var0, View var1) {
      onCreate$lambda$2$lambda$0(var0, var1);
   }

   private final void onClose() {
      this.finish();
      this.startActivity(this.getPackageManager().getLaunchIntentForPackage(this.getPackageName()));
   }

   private static final void onCreate$lambda$2$lambda$0(PostDisableIoTActivity var0, View var1) {
      var0.onClose();
   }

   private static final void onCreate$lambda$2$lambda$1(PostDisableIoTActivity var0, View var1) {
      var0.onClose();
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      ActivityPostDisableIotBinding var2 = (ActivityPostDisableIotBinding)DataBindingUtil.setContentView((Activity)this, R.layout.activity_post_disable_iot);
      var2.btnClose.setOnClickListener(new PostDisableIoTActivity$$ExternalSyntheticLambda0(this));
      var2.btnOkay.setOnClickListener(new PostDisableIoTActivity$$ExternalSyntheticLambda1(this));
      this.getOnBackPressedDispatcher().addCallback(this.onBackPressedCallback);
   }
}
