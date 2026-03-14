package com.blueair.android.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.blueair.android.databinding.ActivityAccountLinkingBinding;
import com.blueair.android.fragment.integration.Integration;
import com.blueair.android.viewmodel.AccountLinkingViewModel;
import com.blueair.android.viewmodel.LinkingState;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.service.AnalyticsService;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.activity.LoginPendingAction;
import com.blueair.viewcore.utils.ActivityUtils;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.material.button.MaterialButton;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(
   d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001c\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0011H\u0014J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0014R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001e"},
   d2 = {"Lcom/blueair/android/activity/AccountLinkingActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewModel", "Lcom/blueair/android/viewmodel/AccountLinkingViewModel;", "getViewModel", "()Lcom/blueair/android/viewmodel/AccountLinkingViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "binding", "Lcom/blueair/android/databinding/ActivityAccountLinkingBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "handleIntent", "intent", "Landroid/content/Intent;", "closeClicked", "linked", "", "onNewIntent", "Companion", "LinkingText", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AccountLinkingActivity extends BaseActivity {
   public static final int $stable = 8;
   private static final LinkingText ALEXA_LINKING_TEXT;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final String EXTRA_LINKED = "EXTRA_LINKED";
   public static final String EXTRA_NAME = "EXTRA_NAME";
   public static final String EXTRA_STATE = "EXTRA_STATE";
   private static final LinkingText GOOGLE_LINKING_TEXT;
   public static final String STATE_FAILED = "FAILED";
   public static final String STATE_FETCHING = "FETCHING";
   private ActivityAccountLinkingBinding binding;
   private final String screenName;
   private final Lazy viewModel$delegate;

   // $FF: synthetic method
   public static void $r8$lambda$3WFa209OzeFKfflbyuqDwkA5P64(AccountLinkingActivity var0, View var1) {
      onCreate$lambda$2$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$Sz6WfJj0a6z4D8nTPm1cvd7dFwA(boolean var0, AccountLinkingActivity var1, View var2) {
      onCreate$lambda$2$lambda$0(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$UukkVqFkhW4MN23KKB2_Adn17OU/* $FF was: $r8$lambda$UukkVqFkhW4MN23KKB2-Adn17OU*/(AccountLinkingActivity var0, Intent var1, View var2) {
      handleIntent$lambda$6(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$iczywm_JKRRBzizof7jybbCEJFw(AccountLinkingActivity var0, boolean var1, OnBackPressedCallback var2) {
      return onCreate$lambda$3(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$vGb3Hf0c1YgtC44Z5nfI4mMzWs4(AccountLinkingActivity var0, Intent var1, View var2) {
      handleIntent$lambda$5(var0, var1, var2);
   }

   static {
      ALEXA_LINKING_TEXT = new LinkingText(R.string.alexa_connect_question, R.string.alexa_connect_hint, R.string.alexa_linking_success, R.string.alexa_linking_start_saying, R.string.alexa_linking_command, R.string.alexa_connect_error, R.string.alexa_disconnect_question, R.string.alexa_disconnect_hint, R.string.alexa_unlink_success, R.string.alexa_unlink_error);
      GOOGLE_LINKING_TEXT = new LinkingText(R.string.google_connect_question, R.string.google_connect_hint, R.string.google_linking_success, R.string.google_linking_start_saying, R.string.google_linking_command, R.string.google_connect_error, R.string.google_disconnect_question, R.string.google_disconnect_hint, R.string.google_unlink_success, R.string.google_unlink_error);
   }

   public AccountLinkingActivity() {
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
      this.viewModel$delegate = (Lazy)(new ViewModelLazy(Reflection.getOrCreateKotlinClass(AccountLinkingViewModel.class), new Function0(var2) {
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
   }

   private final void closeClicked(boolean var1) {
      this.setResult(-1, (new Intent()).putExtra("EXTRA_LINKED", var1));
      if (!ActivityUtils.INSTANCE.isActivityInStack((Context)this, HomeActivity.class)) {
         InfoActivity.Companion var4 = InfoActivity.Companion;
         Activity var2 = (Activity)this;
         String var3 = this.getString(R.string.voice_assistants);
         Intrinsics.checkNotNullExpressionValue(var3, "getString(...)");
         this.startActivity(var4.gotoIntegrations(var2, var3));
      }

      this.finish();
   }

   private final AccountLinkingViewModel getViewModel() {
      return (AccountLinkingViewModel)this.viewModel$delegate.getValue();
   }

   private final void handleIntent(Intent var1) {
      Integration var4 = this.getViewModel().getAccountType();
      int var2 = AccountLinkingActivity.WhenMappings.$EnumSwitchMapping$0[var4.ordinal()];
      if (var2 != 1) {
         if (var2 == 2) {
            String var8 = var1.getStringExtra("EXTRA_STATE");
            if (var8 != null) {
               var2 = var8.hashCode();
               if (var2 != 1019825896) {
                  if (var2 == 2066319421 && var8.equals("FAILED")) {
                     this.getViewModel().setState(LinkingState.Failed.INSTANCE);
                     return;
                  }
               } else if (var8.equals("FETCHING")) {
                  this.getViewModel().fetchLinkingStatus(var1.getBooleanExtra("EXTRA_LINKED", false) ^ true);
                  return;
               }
            }
         }
      } else {
         Uri var9 = var1.getData();
         if (var9 != null) {
            String var6 = var9.getPath();
            if (var6 != null) {
               boolean var3 = this.getViewModel().isUserLoggedIn();
               Object var5 = null;
               if (var3) {
                  if (StringsKt.startsWith$default(var6, "/app/alexa-linking/start-from-alexa", false, 2, (Object)null)) {
                     ActivityAccountLinkingBinding var12 = this.binding;
                     ActivityAccountLinkingBinding var10 = var12;
                     if (var12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        var10 = null;
                     }

                     var10.btnAllow.setOnClickListener(new AccountLinkingActivity$$ExternalSyntheticLambda3(this, var1));
                     var10 = this.binding;
                     if (var10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        var10 = (ActivityAccountLinkingBinding)var5;
                     }

                     var10.btnNotNow.setOnClickListener(new AccountLinkingActivity$$ExternalSyntheticLambda4(this, var1));
                     return;
                  }

                  this.getViewModel().finishAlexaLinking(var1.getData());
                  return;
               }

               this.getViewModel().setLoginPendingAction(LoginPendingAction.Companion.alexaLinking(var9));
               this.startActivity(Actions.openWelcomeIntent$default(Actions.INSTANCE, (Context)this, false, 2, (Object)null));
               return;
            }
         }
      }

   }

   private static final void handleIntent$lambda$5(AccountLinkingActivity var0, Intent var1, View var2) {
      var0.getViewModel().startAlexaLinking(var1.getData(), true);
   }

   private static final void handleIntent$lambda$6(AccountLinkingActivity var0, Intent var1, View var2) {
      var0.getViewModel().startAlexaLinking(var1.getData(), false);
   }

   private static final void onCreate$lambda$2$lambda$0(boolean var0, AccountLinkingActivity var1, View var2) {
      if (var0) {
         var1.getViewModel().unlink();
      } else {
         var1.getViewModel().startLinking();
      }
   }

   private static final void onCreate$lambda$2$lambda$1(AccountLinkingActivity var0, View var1) {
      var0.finish();
   }

   private static final Unit onCreate$lambda$3(AccountLinkingActivity var0, boolean var1, OnBackPressedCallback var2) {
      Intrinsics.checkNotNullParameter(var2, "$this$addCallback");
      var0.closeClicked(var1);
      return Unit.INSTANCE;
   }

   protected String getScreenName() {
      return this.screenName;
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      String var5 = this.getIntent().getStringExtra("EXTRA_NAME");
      String var3 = var5;
      if (var5 == null) {
         var3 = "AmazonAlexa";
      }

      boolean var2 = this.getIntent().getBooleanExtra("EXTRA_LINKED", false);
      LinkingText var6;
      if (Intrinsics.areEqual(var3, "GoogleAssistant")) {
         var6 = GOOGLE_LINKING_TEXT;
      } else {
         var6 = ALEXA_LINKING_TEXT;
      }

      this.getViewModel().setAccountType(Integration.valueOf(var3));
      this.getViewModel().setGoogleLinkRequested(false);
      ActivityAccountLinkingBinding var4 = ActivityAccountLinkingBinding.inflate(this.getLayoutInflater());
      Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
      this.binding = var4;
      ActivityAccountLinkingBinding var9 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var9 = null;
      }

      this.setContentView((View)var9.getRoot());
      var9 = this.binding;
      if (var9 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var9 = null;
      }

      var9.btnAllow.setOnClickListener(new AccountLinkingActivity$$ExternalSyntheticLambda0(var2, this));
      var9.btnNotNow.setOnClickListener(new AccountLinkingActivity$$ExternalSyntheticLambda1(this));
      if (var2) {
         var9.body.setText(var6.getUnlinkBody());
         var9.txtAllowDescription.setText(var6.getUnlinkHint());
         var9.btnAllow.setText(R.string.alexa_disconnect);
      } else {
         var9.body.setText(var6.getLinkBody());
         var9.txtAllowDescription.setText(var6.getLinkHint());
      }

      FlowKt.launchIn(FlowKt.onEach((Flow)this.getViewModel().getState(), new Function2(var9, this, var2, var6, (Continuation)null) {
         final boolean $linked;
         final LinkingText $linkingText;
         final ActivityAccountLinkingBinding $this_apply;
         Object L$0;
         int label;
         final AccountLinkingActivity this$0;

         // $FF: synthetic method
         public static void $r8$lambda$1JJ4BsppXqGZVmMWwP1sQGknHCo(AccountLinkingActivity var0, View var1) {
            invokeSuspend$lambda$0(var0, var1);
         }

         // $FF: synthetic method
         public static void $r8$lambda$F_bDaNxoanL0Q2JYP0V0mRy2Nn0(AccountLinkingActivity var0, View var1) {
            invokeSuspend$lambda$3(var0, var1);
         }

         // $FF: synthetic method
         public static void $r8$lambda$gzssZo3qXbWTFrnxnwnWBHGCpME(AccountLinkingActivity var0, View var1) {
            invokeSuspend$lambda$2(var0, var1);
         }

         // $FF: synthetic method
         public static void $r8$lambda$zOyiMnlQ6FjK0mLarwRq0LTAhP4(AccountLinkingActivity var0, View var1) {
            invokeSuspend$lambda$1(var0, var1);
         }

         {
            this.$this_apply = var1;
            this.this$0 = var2;
            this.$linked = var3;
            this.$linkingText = var4;
         }

         private static final void invokeSuspend$lambda$0(AccountLinkingActivity var0, View var1) {
            var0.closeClicked(false);
         }

         private static final void invokeSuspend$lambda$1(AccountLinkingActivity var0, View var1) {
            var0.closeClicked(true);
         }

         private static final void invokeSuspend$lambda$2(AccountLinkingActivity var0, View var1) {
            var0.closeClicked(true);
         }

         private static final void invokeSuspend$lambda$3(AccountLinkingActivity var0, View var1) {
            var0.closeClicked(false);
         }

         public final Continuation create(Object var1, Continuation var2) {
            Function2 var3 = new <anonymous constructor>(this.$this_apply, this.this$0, this.$linked, this.$linkingText, var2);
            var3.L$0 = var1;
            return (Continuation)var3;
         }

         public final Object invoke(LinkingState var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            LinkingState var3 = (LinkingState)this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
               ResultKt.throwOnFailure(var1);
               ProgressBlockerView var4 = this.$this_apply.loading;
               Intrinsics.checkNotNullExpressionValue(var4, "loading");
               View var5 = (View)var4;
               byte var2;
               if (Intrinsics.areEqual(var3, LinkingState.Loading.INSTANCE)) {
                  var2 = 0;
               } else {
                  var2 = 8;
               }

               var5.setVisibility(var2);
               if (var3 instanceof LinkingState.UrlGot) {
                  this.this$0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(((LinkingState.UrlGot)var3).getUrl())));
               } else if (var3 instanceof LinkingState.Success) {
                  if (this.$linked) {
                     this.$this_apply.title.setText(this.$linkingText.getUnlinkedTitle());
                     AppCompatTextView var6 = this.$this_apply.title;
                     Intrinsics.checkNotNullExpressionValue(var6, "title");
                     ((View)var6).setVisibility(0);
                     var6 = this.$this_apply.body;
                     Intrinsics.checkNotNullExpressionValue(var6, "body");
                     ((View)var6).setVisibility(8);
                     var6 = this.$this_apply.txtAllowDescription;
                     Intrinsics.checkNotNullExpressionValue(var6, "txtAllowDescription");
                     ((View)var6).setVisibility(8);
                     this.$this_apply.btnAllow.setText(R.string.close);
                     this.$this_apply.btnAllow.setOnClickListener(new AccountLinkingActivity$onCreate$1$3$$ExternalSyntheticLambda0(this.this$0));
                     MaterialButton var9 = this.$this_apply.btnNotNow;
                     Intrinsics.checkNotNullExpressionValue(var9, "btnNotNow");
                     ((View)var9).setVisibility(8);
                  } else {
                     this.$this_apply.title.setText(this.$linkingText.getLinkedTitle());
                     AppCompatTextView var10 = this.$this_apply.title;
                     Intrinsics.checkNotNullExpressionValue(var10, "title");
                     ((View)var10).setVisibility(0);
                     this.$this_apply.subtitle.setText(this.$linkingText.getLinkedSubTitle());
                     var10 = this.$this_apply.subtitle;
                     Intrinsics.checkNotNullExpressionValue(var10, "subtitle");
                     ((View)var10).setVisibility(0);
                     this.$this_apply.body.setText(this.$linkingText.getLinkedBody());
                     var10 = this.$this_apply.txtAllowDescription;
                     Intrinsics.checkNotNullExpressionValue(var10, "txtAllowDescription");
                     ((View)var10).setVisibility(8);
                     this.$this_apply.btnAllow.setText(R.string.close);
                     this.$this_apply.btnAllow.setOnClickListener(new AccountLinkingActivity$onCreate$1$3$$ExternalSyntheticLambda1(this.this$0));
                     MaterialButton var13 = this.$this_apply.btnNotNow;
                     Intrinsics.checkNotNullExpressionValue(var13, "btnNotNow");
                     ((View)var13).setVisibility(8);
                  }
               } else if (Intrinsics.areEqual(var3, LinkingState.Failed.INSTANCE)) {
                  if (this.$linked) {
                     this.$this_apply.title.setText(this.$linkingText.getUnlinkFailedTitle());
                     AppCompatTextView var14 = this.$this_apply.title;
                     Intrinsics.checkNotNullExpressionValue(var14, "title");
                     ((View)var14).setVisibility(0);
                     AppCompatImageView var15 = this.$this_apply.imgError;
                     Intrinsics.checkNotNullExpressionValue(var15, "imgError");
                     ((View)var15).setVisibility(0);
                     AppCompatTextView var16 = this.$this_apply.body;
                     Intrinsics.checkNotNullExpressionValue(var16, "body");
                     ((View)var16).setVisibility(8);
                     var16 = this.$this_apply.txtAllowDescription;
                     Intrinsics.checkNotNullExpressionValue(var16, "txtAllowDescription");
                     ((View)var16).setVisibility(8);
                     this.$this_apply.btnAllow.setText(R.string.close);
                     this.$this_apply.btnAllow.setOnClickListener(new AccountLinkingActivity$onCreate$1$3$$ExternalSyntheticLambda2(this.this$0));
                     MaterialButton var18 = this.$this_apply.btnNotNow;
                     Intrinsics.checkNotNullExpressionValue(var18, "btnNotNow");
                     ((View)var18).setVisibility(8);
                  } else {
                     this.$this_apply.title.setText(this.$linkingText.getLinkFailedTitle());
                     AppCompatTextView var19 = this.$this_apply.title;
                     Intrinsics.checkNotNullExpressionValue(var19, "title");
                     ((View)var19).setVisibility(0);
                     AppCompatImageView var20 = this.$this_apply.imgError;
                     Intrinsics.checkNotNullExpressionValue(var20, "imgError");
                     ((View)var20).setVisibility(0);
                     AppCompatTextView var21 = this.$this_apply.body;
                     Intrinsics.checkNotNullExpressionValue(var21, "body");
                     ((View)var21).setVisibility(8);
                     var21 = this.$this_apply.txtAllowDescription;
                     Intrinsics.checkNotNullExpressionValue(var21, "txtAllowDescription");
                     ((View)var21).setVisibility(8);
                     this.$this_apply.btnAllow.setText(R.string.close);
                     this.$this_apply.btnAllow.setOnClickListener(new AccountLinkingActivity$onCreate$1$3$$ExternalSyntheticLambda3(this.this$0));
                     MaterialButton var23 = this.$this_apply.btnNotNow;
                     Intrinsics.checkNotNullExpressionValue(var23, "btnNotNow");
                     ((View)var23).setVisibility(8);
                  }
               } else if (Intrinsics.areEqual(var3, LinkingState.Cancel.INSTANCE)) {
                  this.this$0.finish();
               }

               return Unit.INSTANCE;
            } else {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
         }
      }), (CoroutineScope)LifecycleOwnerKt.getLifecycleScope((LifecycleOwner)this));
      OnBackPressedDispatcher var7 = this.getOnBackPressedDispatcher();
      Intrinsics.checkNotNullExpressionValue(var7, "<get-onBackPressedDispatcher>(...)");
      OnBackPressedDispatcherKt.addCallback$default(var7, (LifecycleOwner)null, false, new AccountLinkingActivity$$ExternalSyntheticLambda2(this, var2), 3, (Object)null);
      Intent var8 = this.getIntent();
      Intrinsics.checkNotNullExpressionValue(var8, "getIntent(...)");
      this.handleIntent(var8);
   }

   protected void onNewIntent(Intent var1) {
      Intrinsics.checkNotNullParameter(var1, "intent");
      super.onNewIntent(var1);
      this.handleIntent(var1);
   }

   protected void onResume() {
      super.onResume();
      Integration var2 = this.getViewModel().getAccountType();
      int var1 = AccountLinkingActivity.WhenMappings.$EnumSwitchMapping$0[var2.ordinal()];
      String var5;
      if (var1 != 1) {
         if (var1 != 2) {
            var5 = null;
         } else {
            var5 = "side_menu_voice_assistant_google";
         }
      } else {
         var5 = "side_menu_voice_assistant_alexa";
      }

      if (var5 != null) {
         AnalyticsService var4 = this.getAnalytics();
         String var3 = this.getClass().getSimpleName();
         Intrinsics.checkNotNullExpressionValue(var3, "getSimpleName(...)");
         var4.event(new AnalyticEvent.ScreenViewEvent(var5, var3));
      }

      if (this.getViewModel().getGoogleLinkRequested()) {
         this.getViewModel().setGoogleLinkRequested(false);
         this.getViewModel().fetchLinkingStatus(true ^ this.getIntent().getBooleanExtra("EXTRA_LINKED", false));
      } else {
         if (this.getViewModel().getAlexaRedirectUrlRequested()) {
            this.getViewModel().setAlexaRedirectUrlRequested(false);
            this.getViewModel().fetchLinkingStatus(true);
         }

      }
   }

   @Metadata(
      d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"},
      d2 = {"Lcom/blueair/android/activity/AccountLinkingActivity$Companion;", "", "<init>", "()V", "EXTRA_NAME", "", "EXTRA_LINKED", "EXTRA_STATE", "STATE_FETCHING", "STATE_FAILED", "ALEXA_LINKING_TEXT", "Lcom/blueair/android/activity/AccountLinkingActivity$LinkingText;", "GOOGLE_LINKING_TEXT", "app_otherRelease"},
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
   }

   @Metadata(
      d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003Jm\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006+"},
      d2 = {"Lcom/blueair/android/activity/AccountLinkingActivity$LinkingText;", "", "linkBody", "", "linkHint", "linkedTitle", "linkedSubTitle", "linkedBody", "linkFailedTitle", "unlinkBody", "unlinkHint", "unlinkedTitle", "unlinkFailedTitle", "<init>", "(IIIIIIIIII)V", "getLinkBody", "()I", "getLinkHint", "getLinkedTitle", "getLinkedSubTitle", "getLinkedBody", "getLinkFailedTitle", "getUnlinkBody", "getUnlinkHint", "getUnlinkedTitle", "getUnlinkFailedTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "toString", "", "app_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   private static final class LinkingText {
      private final int linkBody;
      private final int linkFailedTitle;
      private final int linkHint;
      private final int linkedBody;
      private final int linkedSubTitle;
      private final int linkedTitle;
      private final int unlinkBody;
      private final int unlinkFailedTitle;
      private final int unlinkHint;
      private final int unlinkedTitle;

      public LinkingText(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
         this.linkBody = var1;
         this.linkHint = var2;
         this.linkedTitle = var3;
         this.linkedSubTitle = var4;
         this.linkedBody = var5;
         this.linkFailedTitle = var6;
         this.unlinkBody = var7;
         this.unlinkHint = var8;
         this.unlinkedTitle = var9;
         this.unlinkFailedTitle = var10;
      }

      // $FF: synthetic method
      public static LinkingText copy$default(LinkingText var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, Object var12) {
         if ((var11 & 1) != 0) {
            var1 = var0.linkBody;
         }

         if ((var11 & 2) != 0) {
            var2 = var0.linkHint;
         }

         if ((var11 & 4) != 0) {
            var3 = var0.linkedTitle;
         }

         if ((var11 & 8) != 0) {
            var4 = var0.linkedSubTitle;
         }

         if ((var11 & 16) != 0) {
            var5 = var0.linkedBody;
         }

         if ((var11 & 32) != 0) {
            var6 = var0.linkFailedTitle;
         }

         if ((var11 & 64) != 0) {
            var7 = var0.unlinkBody;
         }

         if ((var11 & 128) != 0) {
            var8 = var0.unlinkHint;
         }

         if ((var11 & 256) != 0) {
            var9 = var0.unlinkedTitle;
         }

         if ((var11 & 512) != 0) {
            var10 = var0.unlinkFailedTitle;
         }

         return var0.copy(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
      }

      public final int component1() {
         return this.linkBody;
      }

      public final int component10() {
         return this.unlinkFailedTitle;
      }

      public final int component2() {
         return this.linkHint;
      }

      public final int component3() {
         return this.linkedTitle;
      }

      public final int component4() {
         return this.linkedSubTitle;
      }

      public final int component5() {
         return this.linkedBody;
      }

      public final int component6() {
         return this.linkFailedTitle;
      }

      public final int component7() {
         return this.unlinkBody;
      }

      public final int component8() {
         return this.unlinkHint;
      }

      public final int component9() {
         return this.unlinkedTitle;
      }

      public final LinkingText copy(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
         return new LinkingText(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof LinkingText)) {
            return false;
         } else {
            var1 = var1;
            if (this.linkBody != var1.linkBody) {
               return false;
            } else if (this.linkHint != var1.linkHint) {
               return false;
            } else if (this.linkedTitle != var1.linkedTitle) {
               return false;
            } else if (this.linkedSubTitle != var1.linkedSubTitle) {
               return false;
            } else if (this.linkedBody != var1.linkedBody) {
               return false;
            } else if (this.linkFailedTitle != var1.linkFailedTitle) {
               return false;
            } else if (this.unlinkBody != var1.unlinkBody) {
               return false;
            } else if (this.unlinkHint != var1.unlinkHint) {
               return false;
            } else if (this.unlinkedTitle != var1.unlinkedTitle) {
               return false;
            } else {
               return this.unlinkFailedTitle == var1.unlinkFailedTitle;
            }
         }
      }

      public final int getLinkBody() {
         return this.linkBody;
      }

      public final int getLinkFailedTitle() {
         return this.linkFailedTitle;
      }

      public final int getLinkHint() {
         return this.linkHint;
      }

      public final int getLinkedBody() {
         return this.linkedBody;
      }

      public final int getLinkedSubTitle() {
         return this.linkedSubTitle;
      }

      public final int getLinkedTitle() {
         return this.linkedTitle;
      }

      public final int getUnlinkBody() {
         return this.unlinkBody;
      }

      public final int getUnlinkFailedTitle() {
         return this.unlinkFailedTitle;
      }

      public final int getUnlinkHint() {
         return this.unlinkHint;
      }

      public final int getUnlinkedTitle() {
         return this.unlinkedTitle;
      }

      public int hashCode() {
         return ((((((((this.linkBody * 31 + this.linkHint) * 31 + this.linkedTitle) * 31 + this.linkedSubTitle) * 31 + this.linkedBody) * 31 + this.linkFailedTitle) * 31 + this.unlinkBody) * 31 + this.unlinkHint) * 31 + this.unlinkedTitle) * 31 + this.unlinkFailedTitle;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("LinkingText(linkBody=");
         var1.append(this.linkBody);
         var1.append(", linkHint=");
         var1.append(this.linkHint);
         var1.append(", linkedTitle=");
         var1.append(this.linkedTitle);
         var1.append(", linkedSubTitle=");
         var1.append(this.linkedSubTitle);
         var1.append(", linkedBody=");
         var1.append(this.linkedBody);
         var1.append(", linkFailedTitle=");
         var1.append(this.linkFailedTitle);
         var1.append(", unlinkBody=");
         var1.append(this.unlinkBody);
         var1.append(", unlinkHint=");
         var1.append(this.unlinkHint);
         var1.append(", unlinkedTitle=");
         var1.append(this.unlinkedTitle);
         var1.append(", unlinkFailedTitle=");
         var1.append(this.unlinkFailedTitle);
         var1.append(')');
         return var1.toString();
      }
   }

   // $FF: synthetic class
   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WhenMappings {
      public static final int[] $EnumSwitchMapping$0;

      static {
         int[] var0 = new int[Integration.values().length];

         try {
            var0[Integration.AmazonAlexa.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[Integration.GoogleAssistant.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
