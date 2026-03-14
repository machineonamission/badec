package com.blueair.android.dialog;

import android.app.Application;
import com.blueair.auth.LocationService;
import com.blueair.core.model.UserRateNoEvent;
import com.blueair.core.model.UserRateSkipEvent;
import com.blueair.core.model.UserRateYesEvent;
import com.blueair.core.service.HappyUserService;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.LazyDelegate;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012J\u000e\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012J\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012J\b\u0010\u001c\u001a\u00020\u0018H\u0002R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u001d"},
   d2 = {"Lcom/blueair/android/dialog/RateUsViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "locationService", "Lcom/blueair/auth/LocationService;", "getLocationService", "()Lcom/blueair/auth/LocationService;", "locationService$delegate", "Lkotlin/Lazy;", "happyUserService", "Lcom/blueair/core/service/HappyUserService;", "getHappyUserService", "()Lcom/blueair/core/service/HappyUserService;", "happyUserService$delegate", "marketLink", "", "getMarketLink", "()Ljava/lang/String;", "feedbackLink", "getFeedbackLink", "onSkip", "", "trigger", "onImprovePositive", "onImproveNegative", "setRateUsAsShown", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class RateUsViewModel extends BaseViewModel {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(RateUsViewModel.class, "locationService", "getLocationService()Lcom/blueair/auth/LocationService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(RateUsViewModel.class, "happyUserService", "getHappyUserService()Lcom/blueair/core/service/HappyUserService;", 0)))};
   public static final int $stable = 8;
   private final Lazy happyUserService$delegate;
   private final Lazy locationService$delegate;

   public RateUsViewModel(Application var1) {
      Intrinsics.checkNotNullParameter(var1, "application");
      super(var1);
      DIAware var4 = this;
      JVMTypeToken var2 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      LazyDelegate var3 = DIAwareKt.Instance(var4, (TypeToken)(new GenericJVMTypeTokenDelegate(var2, LocationService.class)), (Object)null);
      KProperty[] var5 = $$delegatedProperties;
      this.locationService$delegate = var3.provideDelegate(this, var5[0]);
      JVMTypeToken var6 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var6, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.happyUserService$delegate = DIAwareKt.Instance(var4, (TypeToken)(new GenericJVMTypeTokenDelegate(var6, HappyUserService.class)), (Object)null).provideDelegate(this, var5[1]);
   }

   private final HappyUserService getHappyUserService() {
      return (HappyUserService)this.happyUserService$delegate.getValue();
   }

   private final LocationService getLocationService() {
      return (LocationService)this.locationService$delegate.getValue();
   }

   private final void setRateUsAsShown() {
      this.getHappyUserService().setRateUsShown(true);
   }

   public final String getFeedbackLink() {
      boolean var1 = this.getLocationService().isInChina();
      if (var1) {
         return "https://www.wjx.cn/vj/Yh98xwA.aspx";
      } else if (!var1) {
         return "https://docs.google.com/forms/d/e/1FAIpQLSe67KIedm4zO_LP44cjgjtJ-tuQQU6HwNwsLRT4el43bKtJJg/viewform";
      } else {
         throw new NoWhenBranchMatchedException();
      }
   }

   public final String getMarketLink() {
      return this.getLocationService().getMarketLink();
   }

   public final void onImproveNegative(String var1) {
      Intrinsics.checkNotNullParameter(var1, "trigger");
      this.setRateUsAsShown();
      this.getAnalyticsService().amplitudeLog(new UserRateNoEvent(var1));
   }

   public final void onImprovePositive(String var1) {
      Intrinsics.checkNotNullParameter(var1, "trigger");
      this.setRateUsAsShown();
      this.getAnalyticsService().amplitudeLog(new UserRateYesEvent(var1));
   }

   public final void onSkip(String var1) {
      Intrinsics.checkNotNullParameter(var1, "trigger");
      this.getAnalyticsService().amplitudeLog(new UserRateSkipEvent(var1));
   }
}
