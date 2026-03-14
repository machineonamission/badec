package com.blueair.android.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupKt;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.blueair.android.R;
import com.blueair.android.databinding.ActivityInfoBinding;
import com.blueair.android.fragment.PoliciesFragment;
import com.blueair.android.fragment.SmartIntegrationsFragment;
import com.blueair.android.viewmodel.HomeViewModel;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.service.AnalyticsService;
import com.blueair.core.util.LinkUtils;
import com.blueair.devicedetails.activity.DeviceSettingsActivityKt;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.fragment.WebViewFragment;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u001aH\u0014J\u0012\u0010\u001e\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010 \u001a\u00020\u001aH\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\"H\u0016J\b\u0010&\u001a\u00020\u001aH\u0017R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0016\u0010\u0017¨\u0006("},
   d2 = {"Lcom/blueair/android/activity/InfoActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewModel", "Lcom/blueair/android/viewmodel/HomeViewModel;", "getViewModel", "()Lcom/blueair/android/viewmodel/HomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "infoActivityDataBinding", "Lcom/blueair/android/databinding/ActivityInfoBinding;", "getInfoActivityDataBinding", "()Lcom/blueair/android/databinding/ActivityInfoBinding;", "setInfoActivityDataBinding", "(Lcom/blueair/android/databinding/ActivityInfoBinding;)V", "display", "", "getDisplay", "()I", "display$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "setToolbar", "title", "bindViewModel", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onSupportNavigateUp", "onBackPressed", "Companion", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class InfoActivity extends BaseActivity {
   public static final int $stable = 8;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final int DISPLAY_BLUEAIR_FILTER = 9;
   public static final int DISPLAY_BLUEAIR_STORE = 8;
   public static final int DISPLAY_INTEGRATIONS = 5;
   public static final String DISPLAY_KEY = "display_key";
   public static final int DISPLAY_POLICIES = 4;
   public static final int DISPLAY_SUPPORT = 6;
   public static final int DISPLAY_TROUBLESHOOT_CONNECTION = 7;
   public static final int DISPLAY_WEBVIEW = 2;
   public static final String TOOLBAR_TITLE_KEY = "toolbar_key";
   public static final String URL_KEY = "url_key";
   private final Lazy display$delegate;
   public ActivityInfoBinding infoActivityDataBinding;
   private final String screenName;
   private final Lazy viewModel$delegate;

   // $FF: synthetic method
   public static void $r8$lambda$N8Xb2KDYN6Ee_0_r5liVB76CIXA/* $FF was: $r8$lambda$N8Xb2KDYN6Ee-0-r5liVB76CIXA*/(InfoActivity var0, View var1) {
      setToolbar$lambda$10(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$O4sKYYgE4mU5ORI2rQ_wcAV5LsU(InfoActivity var0, String var1) {
      return onResume$lambda$7(var0, var1);
   }

   // $FF: synthetic method
   public static int $r8$lambda$kK0G3U1JvMecpkfS47EkgenOYjM(InfoActivity var0) {
      return display_delegate$lambda$0(var0);
   }

   public InfoActivity() {
      ComponentActivity var2 = (ComponentActivity)this;
      Function0 var1 = new Function0(var2) {
         final ComponentActivity $this_viewModels;

         public {
            this.$this_viewModels = var1;
         }

         public final ViewModelProvider.Factory invoke() {
            return this.$this_viewModels.getDefaultViewModelProviderFactory();
         }
      };
      this.viewModel$delegate = (Lazy)(new ViewModelLazy(Reflection.getOrCreateKotlinClass(HomeViewModel.class), new Function0(var2) {
         final ComponentActivity $this_viewModels;

         public {
            this.$this_viewModels = var1;
         }

         public final ViewModelStore invoke() {
            return this.$this_viewModels.getViewModelStore();
         }
      }, var1, new Function0((Function0)null, var2) {
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
      this.display$delegate = LazyKt.lazy(new InfoActivity$$ExternalSyntheticLambda1(this));
   }

   private final void bindViewModel() {
      ActivityInfoBinding var1 = DataBindingUtil.setContentView((Activity)this, R.layout.activity_info);
      Intrinsics.checkNotNullExpressionValue(var1, "setContentView(...)");
      this.setInfoActivityDataBinding(var1);
      var1 = this.getInfoActivityDataBinding();
      var1.setHomeViewModel(this.getViewModel());
      var1.setLifecycleOwner((LifecycleOwner)this);
   }

   private static final int display_delegate$lambda$0(InfoActivity var0) {
      return var0.getIntent().getIntExtra("display_key", -1);
   }

   private final int getDisplay() {
      return ((Number)this.display$delegate.getValue()).intValue();
   }

   private final HomeViewModel getViewModel() {
      return (HomeViewModel)this.viewModel$delegate.getValue();
   }

   private static final Unit onResume$lambda$7(InfoActivity var0, String var1) {
      Intrinsics.checkNotNullParameter(var1, "ablRegion");
      TextView var2 = var0.getInfoActivityDataBinding().errorText;
      Intrinsics.checkNotNullExpressionValue(var2, "errorText");
      ((View)var2).setVisibility(8);
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var9 = new StringBuilder("user ablRegion : ");
      var9.append(var1);
      var9.append(" & display = ");
      var9.append(var0.getDisplay());
      var3.d(var9.toString(), new Object[0]);
      var1 = var1.toLowerCase(Locale.ROOT);
      Intrinsics.checkNotNullExpressionValue(var1, "toLowerCase(...)");
      switch (var0.getDisplay()) {
         case 6:
            WebViewFragment var8 = WebViewFragment.Companion.newInstance(LinkUtils.INSTANCE.getSupportLink(var1));
            FragmentManager var16 = var0.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var16, "getSupportFragmentManager(...)");
            FragmentTransaction var17 = var16.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(var17, "beginTransaction()");
            var17.replace(var0.getInfoActivityDataBinding().infoContainer.getId(), var8);
            var17.commit();
            break;
         case 7:
            WebViewFragment var7 = WebViewFragment.Companion.newInstance(LinkUtils.INSTANCE.getConnectionTroubleShootingLink(var1));
            FragmentManager var14 = var0.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var14, "getSupportFragmentManager(...)");
            FragmentTransaction var15 = var14.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(var15, "beginTransaction()");
            var15.replace(var0.getInfoActivityDataBinding().infoContainer.getId(), var7);
            var15.commit();
            break;
         case 8:
            WebViewFragment var6 = WebViewFragment.Companion.newInstance(LinkUtils.INSTANCE.getBlueairStoreLink(var1));
            FragmentManager var12 = var0.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var12, "getSupportFragmentManager(...)");
            FragmentTransaction var13 = var12.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(var13, "beginTransaction()");
            var13.replace(var0.getInfoActivityDataBinding().infoContainer.getId(), var6);
            var13.commit();
            break;
         case 9:
            WebViewFragment var5 = WebViewFragment.Companion.newInstance(LinkUtils.INSTANCE.getVisitBlueairLinkFromCountryCode(var1));
            FragmentManager var10 = var0.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var10, "getSupportFragmentManager(...)");
            FragmentTransaction var11 = var10.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(var11, "beginTransaction()");
            var11.replace(var0.getInfoActivityDataBinding().infoContainer.getId(), var5);
            var11.commit();
      }

      return Unit.INSTANCE;
   }

   private final void setToolbar(String var1) {
      this.setSupportActionBar(this.getInfoActivityDataBinding().toolbar);
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

      Toolbar var3 = this.getInfoActivityDataBinding().toolbar;
      Intrinsics.checkNotNullExpressionValue(var3, "toolbar");
      Context var10 = (Context)this;
      DeviceSettingsActivityKt.changeToolbarFont(var3, var10, com.blueair.viewcore.R.font.apercu_bold);
      this.getInfoActivityDataBinding().toolbar.setTitleTextColor(ContextCompat.getColor(var10, com.blueair.viewcore.R.color.colorOnPrimary));
      this.getInfoActivityDataBinding().toolbar.setTitle((CharSequence)var1);
      Toolbar var11 = this.getInfoActivityDataBinding().toolbar;
      Intrinsics.checkNotNullExpressionValue(var11, "toolbar");
      Iterator var4 = ViewGroupKt.getChildren((ViewGroup)var11).iterator();

      while(true) {
         if (var4.hasNext()) {
            Object var12 = var4.next();
            View var13 = (View)var12;
            if (!(var13 instanceof TextView) || !Intrinsics.areEqual(((TextView)var13).getText(), var1)) {
               continue;
            }

            var5 = var12;
            break;
         }

         var5 = null;
         break;
      }

      View var6 = (View)var5;
      if (var6 != null) {
         ViewCompat.setAccessibilityHeading(var6, true);
      }

      this.getInfoActivityDataBinding().toolbar.setNavigationOnClickListener(new InfoActivity$$ExternalSyntheticLambda0(this));
   }

   private static final void setToolbar$lambda$10(InfoActivity var0, View var1) {
      var0.finish();
   }

   public final ActivityInfoBinding getInfoActivityDataBinding() {
      ActivityInfoBinding var1 = this.infoActivityDataBinding;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("infoActivityDataBinding");
         return null;
      }
   }

   protected String getScreenName() {
      return this.screenName;
   }

   @Deprecated(
      message = "Deprecated in Java"
   )
   public void onBackPressed() {
      FragmentManager var1 = this.getSupportFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var1, "getSupportFragmentManager(...)");
      if (var1.getBackStackEntryCount() > 0) {
         var1.popBackStack();
      } else {
         this.finish();
      }
   }

   protected void onCreate(Bundle var1) {
      this.setTheme(com.blueair.viewcore.R.style.AppTheme_NoActionBar);
      super.onCreate(var1);
      this.bindViewModel();
      Flow var5 = this.getViewModel().getUserAblRegionFetchErrorFlow();
      Object var4 = null;
      Object var3 = null;
      FlowKt.launchIn(FlowKt.onEach(var5, new Function2(this, (Continuation)null) {
         int label;
         final InfoActivity this$0;

         {
            this.this$0 = var1;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, var2));
         }

         public final Object invoke(Unit var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
               ResultKt.throwOnFailure(var1);
               TextView var2 = this.this$0.getInfoActivityDataBinding().errorText;
               Intrinsics.checkNotNullExpressionValue(var2, "errorText");
               ((View)var2).setVisibility(0);
               return Unit.INSTANCE;
            } else {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
         }
      }), (CoroutineScope)LifecycleOwnerKt.getLifecycleScope((LifecycleOwner)this));
      Intent var6 = this.getIntent();
      String var7;
      if (var6 != null) {
         var7 = var6.getStringExtra("toolbar_key");
      } else {
         var7 = null;
      }

      this.setToolbar(var7);
      if (this.getDisplay() == 6 || this.getDisplay() == 7 || this.getDisplay() == 8 || this.getDisplay() == 9) {
         BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, (Continuation)null) {
            int label;
            final InfoActivity this$0;

            {
               this.this$0 = var1;
            }

            public final Continuation create(Object var1, Continuation var2) {
               return (Continuation)(new <anonymous constructor>(this.this$0, var2));
            }

            public final Object invoke(CoroutineScope var1, Continuation var2) {
               return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object var1) {
               Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
               int var2 = this.label;
               if (var2 != 0) {
                  if (var2 != 1) {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }

                  ResultKt.throwOnFailure(var1);
               } else {
                  ResultKt.throwOnFailure(var1);
                  HomeViewModel var5 = this.this$0.getViewModel();
                  Continuation var4 = (Continuation)this;
                  this.label = 1;
                  if (var5.fetchAblGranularRegion(var4) == var3) {
                     return var3;
                  }
               }

               return Unit.INSTANCE;
            }
         }, 2, (Object)null);
      }

      int var2 = this.getDisplay();
      BaseFragment var8;
      if (var2 != 2) {
         if (var2 != 4) {
            if (var2 != 5) {
               var8 = (BaseFragment)var4;
            } else {
               var8 = SmartIntegrationsFragment.Companion.newInstance();
            }
         } else {
            var8 = PoliciesFragment.Companion.newInstance();
         }
      } else {
         Intent var12 = this.getIntent();
         String var9 = (String)var3;
         if (var12 != null) {
            var9 = var12.getStringExtra("url_key");
         }

         Intrinsics.checkNotNull(var9, "null cannot be cast to non-null type kotlin.String");
         var8 = WebViewFragment.Companion.newInstance(var9);
      }

      if (var8 != null) {
         FragmentManager var10 = this.getSupportFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var10, "getSupportFragmentManager(...)");
         FragmentTransaction var11 = var10.beginTransaction();
         Intrinsics.checkNotNullExpressionValue(var11, "beginTransaction()");
         var11.replace(this.getInfoActivityDataBinding().infoContainer.getId(), var8);
         var11.commit();
      }

   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      Intrinsics.checkNotNullParameter(var1, "item");
      Timber.Forest.d("onOptionsItemSelected", new Object[0]);
      if (var1.getItemId() == 16908332) {
         this.onSupportNavigateUp();
      } else {
         super.onOptionsItemSelected(var1);
      }

      return true;
   }

   protected void onResume() {
      super.onResume();
      int var1 = this.getDisplay();
      String var2;
      if (var1 != 4) {
         if (var1 != 5) {
            if (var1 != 6) {
               if (var1 != 8) {
                  var2 = null;
               } else {
                  var2 = "side_menu_store";
               }
            } else {
               var2 = "side_menu_customer_support";
            }
         } else {
            var2 = "side_menu_voice_assistant";
         }
      } else {
         var2 = "side_menu_policy";
      }

      if (var2 != null) {
         AnalyticsService var4 = this.getAnalytics();
         String var3 = this.getClass().getSimpleName();
         Intrinsics.checkNotNullExpressionValue(var3, "getSimpleName(...)");
         var4.event(new AnalyticEvent.ScreenViewEvent(var2, var3));
      }

      this.getRxSubs().add(RxExtensionsKt.subscribeAndLogE(RxExtensionsKt.uiThread(this.getViewModel().getUserAblRegionObserver()), new InfoActivity$$ExternalSyntheticLambda2(this)));
   }

   public boolean onSupportNavigateUp() {
      if (!super.onSupportNavigateUp()) {
         this.onBackPressed();
      }

      return true;
   }

   public final void setInfoActivityDataBinding(ActivityInfoBinding var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.infoActivityDataBinding = var1;
   }

   @Metadata(
      d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005J\u0016\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0005J\u0016\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0005J\u0016\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0005J\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u001e\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u000e\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u001dR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001e"},
      d2 = {"Lcom/blueair/android/activity/InfoActivity$Companion;", "", "<init>", "()V", "DISPLAY_KEY", "", "DISPLAY_WEBVIEW", "", "DISPLAY_POLICIES", "DISPLAY_INTEGRATIONS", "DISPLAY_SUPPORT", "DISPLAY_TROUBLESHOOT_CONNECTION", "DISPLAY_BLUEAIR_STORE", "DISPLAY_BLUEAIR_FILTER", "TOOLBAR_TITLE_KEY", "URL_KEY", "gotoWebView", "Landroid/content/Intent;", "activity", "Landroid/app/Activity;", "url", "toolbarTitle", "gotoPolicies", "gotoIntegrations", "gotoSupport", "gotoBlueairStore", "gotoBlueairFilter", "gotoInstance", "destinationActivityClass", "Ljava/lang/Class;", "app_otherRelease"},
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

      public final Intent gotoBlueairFilter(Activity var1) {
         Intrinsics.checkNotNullParameter(var1, "activity");
         Intent var2 = this.gotoInstance(var1, InfoActivity.class);
         var2.putExtra("display_key", 9);
         return var2;
      }

      public final Intent gotoBlueairStore(Activity var1) {
         Intrinsics.checkNotNullParameter(var1, "activity");
         Intent var2 = this.gotoInstance(var1, InfoActivity.class);
         var2.putExtra("display_key", 8);
         var2.putExtra("toolbar_key", var1.getString(com.blueair.viewcore.R.string.action_blueair_store));
         return var2;
      }

      public final Intent gotoInstance(Activity var1, Class var2) {
         Intrinsics.checkNotNullParameter(var1, "activity");
         Intrinsics.checkNotNullParameter(var2, "destinationActivityClass");
         return new Intent((Context)var1, var2);
      }

      public final Intent gotoIntegrations(Activity var1, String var2) {
         Intrinsics.checkNotNullParameter(var1, "activity");
         Intrinsics.checkNotNullParameter(var2, "toolbarTitle");
         Intent var3 = this.gotoInstance(var1, InfoActivity.class);
         var3.putExtra("display_key", 5);
         var3.putExtra("toolbar_key", var2);
         return var3;
      }

      public final Intent gotoPolicies(Activity var1, String var2) {
         Intrinsics.checkNotNullParameter(var1, "activity");
         Intrinsics.checkNotNullParameter(var2, "toolbarTitle");
         Intent var3 = this.gotoInstance(var1, InfoActivity.class);
         var3.putExtra("display_key", 4);
         var3.putExtra("toolbar_key", var2);
         return var3;
      }

      public final Intent gotoSupport(Activity var1, String var2) {
         Intrinsics.checkNotNullParameter(var1, "activity");
         Intrinsics.checkNotNullParameter(var2, "toolbarTitle");
         Intent var3 = this.gotoInstance(var1, InfoActivity.class);
         var3.putExtra("display_key", 6);
         var3.putExtra("toolbar_key", var2);
         return var3;
      }

      public final Intent gotoWebView(Activity var1, String var2, String var3) {
         Intrinsics.checkNotNullParameter(var1, "activity");
         Intrinsics.checkNotNullParameter(var2, "url");
         Intrinsics.checkNotNullParameter(var3, "toolbarTitle");
         Intent var4 = this.gotoInstance(var1, InfoActivity.class);
         var4.putExtra("display_key", 2);
         var4.putExtra("url_key", var2);
         var4.putExtra("toolbar_key", var3);
         return var4;
      }
   }
}
