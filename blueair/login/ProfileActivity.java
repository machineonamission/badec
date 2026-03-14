package com.blueair.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.blueair.login.databinding.ActivityProfileBinding;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.activity.BaseActivity;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u0017\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0002\u0010\u0014J\u0012\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u001b"},
   d2 = {"Lcom/blueair/login/ProfileActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewModel", "Lcom/blueair/login/ProfileViewModel;", "getViewModel", "()Lcom/blueair/login/ProfileViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "renderSuccess", "unit", "(Lkotlin/Unit;)V", "renderFailure", "msg", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "login_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ProfileActivity extends BaseActivity {
   private final String screenName = "side_menu_profile";
   private final Lazy viewModel$delegate;

   // $FF: synthetic method
   public static void $r8$lambda$WAGcX09RqUS69NFtTlD0TbV3JLU(ProfileActivity var0, View var1) {
      onCreate$lambda$2$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$rWKqwXMDp6AsxvMdxtCILXIuido(ProfileActivity var0, View var1) {
      onCreate$lambda$2$lambda$1(var0, var1);
   }

   public ProfileActivity() {
      ComponentActivity var1 = (ComponentActivity)this;
      Function0 var2 = new Function0(var1) {
         final ComponentActivity $this_viewModels;

         public {
            this.$this_viewModels = var1;
         }

         public final ViewModelProvider.Factory invoke() {
            return this.$this_viewModels.getDefaultViewModelProviderFactory();
         }
      };
      this.viewModel$delegate = (Lazy)(new ViewModelLazy(Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0(var1) {
         final ComponentActivity $this_viewModels;

         public {
            this.$this_viewModels = var1;
         }

         public final ViewModelStore invoke() {
            return this.$this_viewModels.getViewModelStore();
         }
      }, var2, new Function0((Function0)null, var1) {
         final Function0 $extrasProducer;
         final ComponentActivity $this_viewModels;

         public {
            this.$extrasProducer = var1;
            this.$this_viewModels = var2;
         }

         public final CreationExtras invoke() {
            Function0 var1 = this.$extrasProducer;
            if (var1 != null) {
               CreationExtras var2 = (CreationExtras)var1.invoke();
               if (var2 != null) {
                  return var2;
               }
            }

            return this.$this_viewModels.getDefaultViewModelCreationExtras();
         }
      }));
   }

   private final ProfileViewModel getViewModel() {
      return (ProfileViewModel)this.viewModel$delegate.getValue();
   }

   private static final void onCreate$lambda$2$lambda$0(ProfileActivity var0, View var1) {
      var0.finish();
   }

   private static final void onCreate$lambda$2$lambda$1(ProfileActivity var0, View var1) {
      var0.startActivity(new Intent((Context)var0, ManageMyAccountActivity.class));
   }

   private final void renderFailure(String var1) {
      if (Intrinsics.areEqual(var1, "400106")) {
         var1 = "Please check your internet connection";
      } else if (var1 == null) {
         var1 = null;
      } else {
         var1 = "There was an error processing this request. Please try again";
      }

      if (var1 != null) {
         ViewUtils.INSTANCE.showSnackbar((Activity)this, var1, ViewUtils.MessageType.ERROR.INSTANCE);
      }

   }

   private final void renderSuccess(Unit var1) {
      if (var1 != null) {
         ViewUtils.INSTANCE.showSnackbar((Activity)this, com.blueair.viewcore.R.string.msg_update_profile_success, ViewUtils.MessageType.SUCCESS.INSTANCE);
      }

   }

   protected String getScreenName() {
      return this.screenName;
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      ActivityProfileBinding var2 = (ActivityProfileBinding)DataBindingUtil.setContentView((Activity)this, R.layout.activity_profile);
      LifecycleOwner var3 = (LifecycleOwner)this;
      var2.setLifecycleOwner(var3);
      var2.setVariable(BR.viewModel, this.getViewModel());
      var2.btnClose.setOnClickListener(new ProfileActivity$$ExternalSyntheticLambda0(this));
      var2.btnManageMyAccount.setOnClickListener(new ProfileActivity$$ExternalSyntheticLambda1(this));
      ProfileViewModel var4 = this.getViewModel();
      BaseLoginViewModelKt.observe(var3, var4.getSuccess(), new Function1(this) {
         public final void invoke(Unit var1) {
            ((ProfileActivity)this.receiver).renderSuccess(var1);
         }
      });
      BaseLoginViewModelKt.observe(var3, var4.getFailure(), new Function1(this) {
         public final void invoke(String var1) {
            ((ProfileActivity)this.receiver).renderFailure(var1);
         }
      });
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
