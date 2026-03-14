package com.blueair.core.service;

import io.flatcircle.preferenceshelper2.PreferencesHelper;
import io.flatcircle.preferenceshelper2.Prefs;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.ranges.LongRange;
import kotlin.reflect.KProperty;

@Metadata(
   d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b'\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u0000 W2\u00020\u0001:\u0001WB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010I\u001a\u00020JJ\u000e\u0010K\u001a\u00020J2\u0006\u0010L\u001a\u00020\u0007J\b\u0010M\u001a\u00020\u0007H\u0002J\b\u0010N\u001a\u00020\u0007H\u0002J\u0006\u0010O\u001a\u00020\u0007J\u0006\u0010P\u001a\u00020\u0007J\u0006\u0010Q\u001a\u00020\u0007J\u0006\u0010R\u001a\u00020\u0007J\u0006\u0010S\u001a\u00020JJ\u0015\u0010T\u001a\u00020J2\b\u0010U\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010VR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR+\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00148F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R+\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001b\u0010\t\"\u0004\b\u001c\u0010\u000bR+\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00148F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b!\u0010\u0013\u001a\u0004\b\u001f\u0010\u0017\"\u0004\b \u0010\u0019R+\u0010#\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00020\"8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b(\u0010\u0013\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R+\u0010)\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00148F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b,\u0010\u0013\u001a\u0004\b*\u0010\u0017\"\u0004\b+\u0010\u0019R+\u0010-\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00148F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b0\u0010\u0013\u001a\u0004\b.\u0010\u0017\"\u0004\b/\u0010\u0019R+\u00101\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00020\"8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b4\u0010\u0013\u001a\u0004\b2\u0010%\"\u0004\b3\u0010'R+\u00105\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00148F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b8\u0010\u0013\u001a\u0004\b6\u0010\u0017\"\u0004\b7\u0010\u0019R+\u00109\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00148B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b<\u0010\u0013\u001a\u0004\b:\u0010\u0017\"\u0004\b;\u0010\u0019R+\u0010=\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00020\"8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b@\u0010\u0013\u001a\u0004\b>\u0010%\"\u0004\b?\u0010'R+\u0010A\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00020\"8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bD\u0010\u0013\u001a\u0004\bB\u0010%\"\u0004\bC\u0010'R+\u0010E\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00148B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bH\u0010\u0013\u001a\u0004\bF\u0010\u0017\"\u0004\bG\u0010\u0019¨\u0006X"},
   d2 = {"Lcom/blueair/core/service/HappyUserService;", "", "prefs", "Lcom/blueair/core/service/UnsecurePrefs;", "<init>", "(Lcom/blueair/core/service/UnsecurePrefs;)V", "countryAvailable", "", "getCountryAvailable", "()Z", "setCountryAvailable", "(Z)V", "validSignUpRange", "Lkotlin/ranges/LongRange;", "<set-?>", "shouldShowDev", "getShouldShowDev", "setShouldShowDev", "shouldShowDev$delegate", "Lkotlin/properties/ReadWriteProperty;", "", "signUpStamp", "getSignUpStamp", "()J", "setSignUpStamp", "(J)V", "signUpStamp$delegate", "isRateUsShown", "setRateUsShown", "isRateUsShown$delegate", "g4NewBlueOnboardStamp", "getG4NewBlueOnboardStamp", "setG4NewBlueOnboardStamp", "g4NewBlueOnboardStamp$delegate", "", "appLaunchCount", "getAppLaunchCount", "()I", "setAppLaunchCount", "(I)V", "appLaunchCount$delegate", "scheduleCreatedStamp", "getScheduleCreatedStamp", "setScheduleCreatedStamp", "scheduleCreatedStamp$delegate", "customReviewStamp", "getCustomReviewStamp", "setCustomReviewStamp", "customReviewStamp$delegate", "attemptCount", "getAttemptCount", "setAttemptCount", "attemptCount$delegate", "lastAttempt", "getLastAttempt", "setLastAttempt", "lastAttempt$delegate", "resetTimestamp", "getResetTimestamp", "setResetTimestamp", "resetTimestamp$delegate", "happyPoints", "getHappyPoints", "setHappyPoints", "happyPoints$delegate", "unhappyPoints", "getUnhappyPoints", "setUnhappyPoints", "unhappyPoints$delegate", "nativeReviewLaunchedStamp", "getNativeReviewLaunchedStamp", "setNativeReviewLaunchedStamp", "nativeReviewLaunchedStamp$delegate", "initResetTimeStamp", "", "incrementPoints", "isHappy", "shouldNotShowRateUsDialog", "shouldShowRateUsDialogByPoints", "shouldShowRateUsDialogT1", "shouldShowRateUsDialogT2", "shouldShowRateUsDialogT3", "shouldShowNativeInAppReview", "onLogOut", "reset", "timestamp", "(Ljava/lang/Long;)V", "Companion", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class HappyUserService {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(HappyUserService.class, "shouldShowDev", "getShouldShowDev()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(HappyUserService.class, "signUpStamp", "getSignUpStamp()J", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(HappyUserService.class, "isRateUsShown", "isRateUsShown()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(HappyUserService.class, "g4NewBlueOnboardStamp", "getG4NewBlueOnboardStamp()J", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(HappyUserService.class, "appLaunchCount", "getAppLaunchCount()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(HappyUserService.class, "scheduleCreatedStamp", "getScheduleCreatedStamp()J", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(HappyUserService.class, "customReviewStamp", "getCustomReviewStamp()J", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(HappyUserService.class, "attemptCount", "getAttemptCount()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(HappyUserService.class, "lastAttempt", "getLastAttempt()J", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(HappyUserService.class, "resetTimestamp", "getResetTimestamp()J", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(HappyUserService.class, "happyPoints", "getHappyPoints()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(HappyUserService.class, "unhappyPoints", "getUnhappyPoints()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(HappyUserService.class, "nativeReviewLaunchedStamp", "getNativeReviewLaunchedStamp()J", 0)))};
   private static final long ACCOUNT_REQUIRED_TIME_PASS;
   private static final long CUSTOM_REVIEW_REQUIRED_TIME_PASS;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final String KEY_APP_LAUNCH_COUNT = "key_app_launch_count";
   private static final String KEY_CUSTOM_REVIEW_SHOWED_STAMP = "key_custom_review_showed_stamp";
   private static final String KEY_G4_NEW_BLUE_ONBOARD_STAMP = "key_g4_new_blue_onboard_stamp";
   private static final String KEY_HAPPY_POINTS = "key_happy_points";
   private static final String KEY_IS_RATE_US_SHOWN = "key_is_rate_us_shown";
   private static final String KEY_LAST_ATTEMPT = "key_last_attempt";
   private static final String KEY_NATIVE_REVIEW_LAUNCHED_STAMP = "key_native_review_launched_stamp";
   private static final String KEY_RATE_US_SHOW_ATTEMPT_COUNT = "key_rate_us_show_attempt_count";
   private static final String KEY_RESET_TIMESTAMP = "key_reset_timestamp";
   private static final String KEY_SCHEDULE_CREATED_STAMP = "key_schedule_created_stamp";
   private static final String KEY_SHOULD_SHOW_DEV = "key_should_show_dev";
   private static final String KEY_SIGN_UP_STAMP = "key_sign_up_stamp";
   private static final String KEY_UNHAPPY_POINTS = "key_unhappy_points";
   private static final int MAX_SHOW_ATTEMPT = 3;
   private static final long NATIVE_REVIEW_REQUIRED_TIME_PASS;
   private static final long ONBOARD_REQUIRED_TIME_PASS;
   private static final long REQUIRED_TIME_PASS_BETWEEN_ATTEMPT;
   private static final long SCHEDULE_REQUIRED_TIME_PASS;
   private final ReadWriteProperty appLaunchCount$delegate;
   private final ReadWriteProperty attemptCount$delegate;
   private boolean countryAvailable;
   private final ReadWriteProperty customReviewStamp$delegate;
   private final ReadWriteProperty g4NewBlueOnboardStamp$delegate;
   private final ReadWriteProperty happyPoints$delegate;
   private final ReadWriteProperty isRateUsShown$delegate;
   private final ReadWriteProperty lastAttempt$delegate;
   private final ReadWriteProperty nativeReviewLaunchedStamp$delegate;
   private final UnsecurePrefs prefs;
   private final ReadWriteProperty resetTimestamp$delegate;
   private final ReadWriteProperty scheduleCreatedStamp$delegate;
   private final ReadWriteProperty shouldShowDev$delegate;
   private final ReadWriteProperty signUpStamp$delegate;
   private final ReadWriteProperty unhappyPoints$delegate;
   private final LongRange validSignUpRange;

   static {
      REQUIRED_TIME_PASS_BETWEEN_ATTEMPT = TimeUnit.DAYS.toMillis(4L);
      ACCOUNT_REQUIRED_TIME_PASS = TimeUnit.DAYS.toMillis(14L);
      ONBOARD_REQUIRED_TIME_PASS = TimeUnit.DAYS.toMillis(5L);
      SCHEDULE_REQUIRED_TIME_PASS = TimeUnit.DAYS.toMillis(3L);
      CUSTOM_REVIEW_REQUIRED_TIME_PASS = TimeUnit.DAYS.toMillis(7L);
      NATIVE_REVIEW_REQUIRED_TIME_PASS = TimeUnit.DAYS.toMillis(30L);
   }

   public HappyUserService(UnsecurePrefs var1) {
      Intrinsics.checkNotNullParameter(var1, "prefs");
      super();
      this.prefs = var1;
      this.validSignUpRange = new LongRange(7200000L, 604800000L);
      Prefs var3 = var1;
      Boolean var4 = false;
      Integer var2 = 0;
      this.shouldShowDev$delegate = (ReadWriteProperty)(new ObservableProperty(var3, "key_should_show_dev", var4, PreferencesHelper.INSTANCE.get(var3.getBackend(), "key_should_show_dev", var4, Reflection.getOrCreateKotlinClass(Boolean.class))) {
         final Object $initialDefault;
         final String $key;
         final Prefs $prefs;

         public {
            this.$prefs = var1;
            this.$key = var2;
            this.$initialDefault = var3;
         }

         protected void afterChange(KProperty var1, Object var2, Object var3) {
            Intrinsics.checkParameterIsNotNull(var1, "property");
            Intrinsics.checkParameterIsNotNull(var2, "oldValue");
            Intrinsics.checkParameterIsNotNull(var3, "newValue");
            if (!Intrinsics.areEqual(var3, var2)) {
               Prefs var4 = this.$prefs;
               String var5 = this.$key;
               PreferencesHelper.INSTANCE.set(var4.getBackend(), var5, var3, Reflection.getOrCreateKotlinClass(Boolean.class));
            }

         }
      });
      Prefs var5 = var1;
      Long var7 = -1L;
      this.signUpStamp$delegate = (ReadWriteProperty)(new ObservableProperty(var5, "key_sign_up_stamp", var7, PreferencesHelper.INSTANCE.get(var5.getBackend(), "key_sign_up_stamp", var7, Reflection.getOrCreateKotlinClass(Long.class))) {
         final Object $initialDefault;
         final String $key;
         final Prefs $prefs;

         public {
            this.$prefs = var1;
            this.$key = var2;
            this.$initialDefault = var3;
         }

         protected void afterChange(KProperty var1, Object var2, Object var3) {
            Intrinsics.checkParameterIsNotNull(var1, "property");
            Intrinsics.checkParameterIsNotNull(var2, "oldValue");
            Intrinsics.checkParameterIsNotNull(var3, "newValue");
            if (!Intrinsics.areEqual(var3, var2)) {
               Prefs var5 = this.$prefs;
               String var4 = this.$key;
               PreferencesHelper.INSTANCE.set(var5.getBackend(), var4, var3, Reflection.getOrCreateKotlinClass(Long.class));
            }

         }
      });
      var5 = var1;
      this.isRateUsShown$delegate = (ReadWriteProperty)(new ObservableProperty(var5, "key_is_rate_us_shown", var4, PreferencesHelper.INSTANCE.get(var5.getBackend(), "key_is_rate_us_shown", var4, Reflection.getOrCreateKotlinClass(Boolean.class))) {
         final Object $initialDefault;
         final String $key;
         final Prefs $prefs;

         public {
            this.$prefs = var1;
            this.$key = var2;
            this.$initialDefault = var3;
         }

         protected void afterChange(KProperty var1, Object var2, Object var3) {
            Intrinsics.checkParameterIsNotNull(var1, "property");
            Intrinsics.checkParameterIsNotNull(var2, "oldValue");
            Intrinsics.checkParameterIsNotNull(var3, "newValue");
            if (!Intrinsics.areEqual(var3, var2)) {
               Prefs var4 = this.$prefs;
               String var5 = this.$key;
               PreferencesHelper.INSTANCE.set(var4.getBackend(), var5, var3, Reflection.getOrCreateKotlinClass(Boolean.class));
            }

         }
      });
      Prefs var8 = var1;
      this.g4NewBlueOnboardStamp$delegate = (ReadWriteProperty)(new ObservableProperty(var8, "key_g4_new_blue_onboard_stamp", var7, PreferencesHelper.INSTANCE.get(var8.getBackend(), "key_g4_new_blue_onboard_stamp", var7, Reflection.getOrCreateKotlinClass(Long.class))) {
         final Object $initialDefault;
         final String $key;
         final Prefs $prefs;

         public {
            this.$prefs = var1;
            this.$key = var2;
            this.$initialDefault = var3;
         }

         protected void afterChange(KProperty var1, Object var2, Object var3) {
            Intrinsics.checkParameterIsNotNull(var1, "property");
            Intrinsics.checkParameterIsNotNull(var2, "oldValue");
            Intrinsics.checkParameterIsNotNull(var3, "newValue");
            if (!Intrinsics.areEqual(var3, var2)) {
               Prefs var5 = this.$prefs;
               String var4 = this.$key;
               PreferencesHelper.INSTANCE.set(var5.getBackend(), var4, var3, Reflection.getOrCreateKotlinClass(Long.class));
            }

         }
      });
      var8 = var1;
      this.appLaunchCount$delegate = (ReadWriteProperty)(new ObservableProperty(var8, "key_app_launch_count", var2, PreferencesHelper.INSTANCE.get(var8.getBackend(), "key_app_launch_count", var2, Reflection.getOrCreateKotlinClass(Integer.class))) {
         final Object $initialDefault;
         final String $key;
         final Prefs $prefs;

         public {
            this.$prefs = var1;
            this.$key = var2;
            this.$initialDefault = var3;
         }

         protected void afterChange(KProperty var1, Object var2, Object var3) {
            Intrinsics.checkParameterIsNotNull(var1, "property");
            Intrinsics.checkParameterIsNotNull(var2, "oldValue");
            Intrinsics.checkParameterIsNotNull(var3, "newValue");
            if (!Intrinsics.areEqual(var3, var2)) {
               Prefs var5 = this.$prefs;
               String var4 = this.$key;
               PreferencesHelper.INSTANCE.set(var5.getBackend(), var4, var3, Reflection.getOrCreateKotlinClass(Integer.class));
            }

         }
      });
      var8 = var1;
      this.scheduleCreatedStamp$delegate = (ReadWriteProperty)(new ObservableProperty(var8, "key_schedule_created_stamp", var7, PreferencesHelper.INSTANCE.get(var8.getBackend(), "key_schedule_created_stamp", var7, Reflection.getOrCreateKotlinClass(Long.class))) {
         final Object $initialDefault;
         final String $key;
         final Prefs $prefs;

         public {
            this.$prefs = var1;
            this.$key = var2;
            this.$initialDefault = var3;
         }

         protected void afterChange(KProperty var1, Object var2, Object var3) {
            Intrinsics.checkParameterIsNotNull(var1, "property");
            Intrinsics.checkParameterIsNotNull(var2, "oldValue");
            Intrinsics.checkParameterIsNotNull(var3, "newValue");
            if (!Intrinsics.areEqual(var3, var2)) {
               Prefs var5 = this.$prefs;
               String var4 = this.$key;
               PreferencesHelper.INSTANCE.set(var5.getBackend(), var4, var3, Reflection.getOrCreateKotlinClass(Long.class));
            }

         }
      });
      var8 = var1;
      this.customReviewStamp$delegate = (ReadWriteProperty)(new ObservableProperty(var8, "key_custom_review_showed_stamp", var7, PreferencesHelper.INSTANCE.get(var8.getBackend(), "key_custom_review_showed_stamp", var7, Reflection.getOrCreateKotlinClass(Long.class))) {
         final Object $initialDefault;
         final String $key;
         final Prefs $prefs;

         public {
            this.$prefs = var1;
            this.$key = var2;
            this.$initialDefault = var3;
         }

         protected void afterChange(KProperty var1, Object var2, Object var3) {
            Intrinsics.checkParameterIsNotNull(var1, "property");
            Intrinsics.checkParameterIsNotNull(var2, "oldValue");
            Intrinsics.checkParameterIsNotNull(var3, "newValue");
            if (!Intrinsics.areEqual(var3, var2)) {
               Prefs var5 = this.$prefs;
               String var4 = this.$key;
               PreferencesHelper.INSTANCE.set(var5.getBackend(), var4, var3, Reflection.getOrCreateKotlinClass(Long.class));
            }

         }
      });
      var8 = var1;
      this.attemptCount$delegate = (ReadWriteProperty)(new ObservableProperty(var8, "key_rate_us_show_attempt_count", var2, PreferencesHelper.INSTANCE.get(var8.getBackend(), "key_rate_us_show_attempt_count", var2, Reflection.getOrCreateKotlinClass(Integer.class))) {
         final Object $initialDefault;
         final String $key;
         final Prefs $prefs;

         public {
            this.$prefs = var1;
            this.$key = var2;
            this.$initialDefault = var3;
         }

         protected void afterChange(KProperty var1, Object var2, Object var3) {
            Intrinsics.checkParameterIsNotNull(var1, "property");
            Intrinsics.checkParameterIsNotNull(var2, "oldValue");
            Intrinsics.checkParameterIsNotNull(var3, "newValue");
            if (!Intrinsics.areEqual(var3, var2)) {
               Prefs var4 = this.$prefs;
               String var5 = this.$key;
               PreferencesHelper.INSTANCE.set(var4.getBackend(), var5, var3, Reflection.getOrCreateKotlinClass(Integer.class));
            }

         }
      });
      var8 = var1;
      this.lastAttempt$delegate = (ReadWriteProperty)(new ObservableProperty(var8, "key_last_attempt", var7, PreferencesHelper.INSTANCE.get(var8.getBackend(), "key_last_attempt", var7, Reflection.getOrCreateKotlinClass(Long.class))) {
         final Object $initialDefault;
         final String $key;
         final Prefs $prefs;

         public {
            this.$prefs = var1;
            this.$key = var2;
            this.$initialDefault = var3;
         }

         protected void afterChange(KProperty var1, Object var2, Object var3) {
            Intrinsics.checkParameterIsNotNull(var1, "property");
            Intrinsics.checkParameterIsNotNull(var2, "oldValue");
            Intrinsics.checkParameterIsNotNull(var3, "newValue");
            if (!Intrinsics.areEqual(var3, var2)) {
               Prefs var4 = this.$prefs;
               String var5 = this.$key;
               PreferencesHelper.INSTANCE.set(var4.getBackend(), var5, var3, Reflection.getOrCreateKotlinClass(Long.class));
            }

         }
      });
      var8 = var1;
      this.resetTimestamp$delegate = (ReadWriteProperty)(new ObservableProperty(var8, "key_reset_timestamp", var7, PreferencesHelper.INSTANCE.get(var8.getBackend(), "key_reset_timestamp", var7, Reflection.getOrCreateKotlinClass(Long.class))) {
         final Object $initialDefault;
         final String $key;
         final Prefs $prefs;

         public {
            this.$prefs = var1;
            this.$key = var2;
            this.$initialDefault = var3;
         }

         protected void afterChange(KProperty var1, Object var2, Object var3) {
            Intrinsics.checkParameterIsNotNull(var1, "property");
            Intrinsics.checkParameterIsNotNull(var2, "oldValue");
            Intrinsics.checkParameterIsNotNull(var3, "newValue");
            if (!Intrinsics.areEqual(var3, var2)) {
               Prefs var5 = this.$prefs;
               String var4 = this.$key;
               PreferencesHelper.INSTANCE.set(var5.getBackend(), var4, var3, Reflection.getOrCreateKotlinClass(Long.class));
            }

         }
      });
      var8 = var1;
      this.happyPoints$delegate = (ReadWriteProperty)(new ObservableProperty(var8, "key_happy_points", var2, PreferencesHelper.INSTANCE.get(var8.getBackend(), "key_happy_points", var2, Reflection.getOrCreateKotlinClass(Integer.class))) {
         final Object $initialDefault;
         final String $key;
         final Prefs $prefs;

         public {
            this.$prefs = var1;
            this.$key = var2;
            this.$initialDefault = var3;
         }

         protected void afterChange(KProperty var1, Object var2, Object var3) {
            Intrinsics.checkParameterIsNotNull(var1, "property");
            Intrinsics.checkParameterIsNotNull(var2, "oldValue");
            Intrinsics.checkParameterIsNotNull(var3, "newValue");
            if (!Intrinsics.areEqual(var3, var2)) {
               Prefs var5 = this.$prefs;
               String var4 = this.$key;
               PreferencesHelper.INSTANCE.set(var5.getBackend(), var4, var3, Reflection.getOrCreateKotlinClass(Integer.class));
            }

         }
      });
      var8 = var1;
      this.unhappyPoints$delegate = (ReadWriteProperty)(new ObservableProperty(var8, "key_unhappy_points", var2, PreferencesHelper.INSTANCE.get(var8.getBackend(), "key_unhappy_points", var2, Reflection.getOrCreateKotlinClass(Integer.class))) {
         final Object $initialDefault;
         final String $key;
         final Prefs $prefs;

         public {
            this.$prefs = var1;
            this.$key = var2;
            this.$initialDefault = var3;
         }

         protected void afterChange(KProperty var1, Object var2, Object var3) {
            Intrinsics.checkParameterIsNotNull(var1, "property");
            Intrinsics.checkParameterIsNotNull(var2, "oldValue");
            Intrinsics.checkParameterIsNotNull(var3, "newValue");
            if (!Intrinsics.areEqual(var3, var2)) {
               Prefs var4 = this.$prefs;
               String var5 = this.$key;
               PreferencesHelper.INSTANCE.set(var4.getBackend(), var5, var3, Reflection.getOrCreateKotlinClass(Integer.class));
            }

         }
      });
      Prefs var6 = var1;
      this.nativeReviewLaunchedStamp$delegate = (ReadWriteProperty)(new ObservableProperty(var6, "key_native_review_launched_stamp", var7, PreferencesHelper.INSTANCE.get(var6.getBackend(), "key_native_review_launched_stamp", var7, Reflection.getOrCreateKotlinClass(Long.class))) {
         final Object $initialDefault;
         final String $key;
         final Prefs $prefs;

         public {
            this.$prefs = var1;
            this.$key = var2;
            this.$initialDefault = var3;
         }

         protected void afterChange(KProperty var1, Object var2, Object var3) {
            Intrinsics.checkParameterIsNotNull(var1, "property");
            Intrinsics.checkParameterIsNotNull(var2, "oldValue");
            Intrinsics.checkParameterIsNotNull(var3, "newValue");
            if (!Intrinsics.areEqual(var3, var2)) {
               Prefs var5 = this.$prefs;
               String var4 = this.$key;
               PreferencesHelper.INSTANCE.set(var5.getBackend(), var4, var3, Reflection.getOrCreateKotlinClass(Long.class));
            }

         }
      });
   }

   private final int getHappyPoints() {
      return ((Number)this.happyPoints$delegate.getValue(this, $$delegatedProperties[10])).intValue();
   }

   private final long getNativeReviewLaunchedStamp() {
      return ((Number)this.nativeReviewLaunchedStamp$delegate.getValue(this, $$delegatedProperties[12])).longValue();
   }

   private final long getResetTimestamp() {
      return ((Number)this.resetTimestamp$delegate.getValue(this, $$delegatedProperties[9])).longValue();
   }

   private final int getUnhappyPoints() {
      return ((Number)this.unhappyPoints$delegate.getValue(this, $$delegatedProperties[11])).intValue();
   }

   private final void setHappyPoints(int var1) {
      this.happyPoints$delegate.setValue(this, $$delegatedProperties[10], var1);
   }

   private final void setNativeReviewLaunchedStamp(long var1) {
      this.nativeReviewLaunchedStamp$delegate.setValue(this, $$delegatedProperties[12], var1);
   }

   private final void setResetTimestamp(long var1) {
      this.resetTimestamp$delegate.setValue(this, $$delegatedProperties[9], var1);
   }

   private final void setUnhappyPoints(int var1) {
      this.unhappyPoints$delegate.setValue(this, $$delegatedProperties[11], var1);
   }

   private final boolean shouldNotShowRateUsDialog() {
      if (!this.countryAvailable) {
         return true;
      } else if (this.isRateUsShown()) {
         return true;
      } else if (this.getAttemptCount() >= 3) {
         return true;
      } else if (this.getShouldShowDev()) {
         return true;
      } else {
         return this.getLastAttempt() != -1L && REQUIRED_TIME_PASS_BETWEEN_ATTEMPT > System.currentTimeMillis() - this.getLastAttempt();
      }
   }

   private final boolean shouldShowRateUsDialogByPoints() {
      int var1 = this.getHappyPoints();
      return this.getUnhappyPoints() + var1 >= 5 && var1 >= 4;
   }

   public final int getAppLaunchCount() {
      return ((Number)this.appLaunchCount$delegate.getValue(this, $$delegatedProperties[4])).intValue();
   }

   public final int getAttemptCount() {
      return ((Number)this.attemptCount$delegate.getValue(this, $$delegatedProperties[7])).intValue();
   }

   public final boolean getCountryAvailable() {
      return this.countryAvailable;
   }

   public final long getCustomReviewStamp() {
      return ((Number)this.customReviewStamp$delegate.getValue(this, $$delegatedProperties[6])).longValue();
   }

   public final long getG4NewBlueOnboardStamp() {
      return ((Number)this.g4NewBlueOnboardStamp$delegate.getValue(this, $$delegatedProperties[3])).longValue();
   }

   public final long getLastAttempt() {
      return ((Number)this.lastAttempt$delegate.getValue(this, $$delegatedProperties[8])).longValue();
   }

   public final long getScheduleCreatedStamp() {
      return ((Number)this.scheduleCreatedStamp$delegate.getValue(this, $$delegatedProperties[5])).longValue();
   }

   public final boolean getShouldShowDev() {
      return (Boolean)this.shouldShowDev$delegate.getValue(this, $$delegatedProperties[0]);
   }

   public final long getSignUpStamp() {
      return ((Number)this.signUpStamp$delegate.getValue(this, $$delegatedProperties[1])).longValue();
   }

   public final void incrementPoints(boolean var1) {
      if (this.getSignUpStamp() != -1L && !this.isRateUsShown() && !this.getShouldShowDev()) {
         if (var1) {
            this.setHappyPoints(this.getHappyPoints() + 1);
            return;
         }

         this.setUnhappyPoints(this.getUnhappyPoints() + 1);
      }

   }

   public final void initResetTimeStamp() {
      if (this.getResetTimestamp() == -1L) {
         this.setResetTimestamp(System.currentTimeMillis());
      }

   }

   public final boolean isRateUsShown() {
      return (Boolean)this.isRateUsShown$delegate.getValue(this, $$delegatedProperties[2]);
   }

   public final void onLogOut() {
      this.prefs.remove("key_sign_up_stamp");
      this.prefs.remove("key_happy_points");
      this.prefs.remove("key_unhappy_points");
   }

   public final void reset(Long var1) {
      long var2 = System.currentTimeMillis();
      if (var1 != null && var1 > this.getResetTimestamp()) {
         this.setResetTimestamp(var2);
         this.setRateUsShown(false);
         if (this.getG4NewBlueOnboardStamp() != -1L) {
            this.setG4NewBlueOnboardStamp(var2);
         }

         this.setAppLaunchCount(0);
         if (this.getScheduleCreatedStamp() != -1L) {
            this.setScheduleCreatedStamp(var2);
         }

         this.setCustomReviewStamp(var2);
         this.setNativeReviewLaunchedStamp(-1L);
         this.setAttemptCount(0);
         this.setLastAttempt(-1L);
      }

   }

   public final void setAppLaunchCount(int var1) {
      this.appLaunchCount$delegate.setValue(this, $$delegatedProperties[4], var1);
   }

   public final void setAttemptCount(int var1) {
      this.attemptCount$delegate.setValue(this, $$delegatedProperties[7], var1);
   }

   public final void setCountryAvailable(boolean var1) {
      this.countryAvailable = var1;
   }

   public final void setCustomReviewStamp(long var1) {
      this.customReviewStamp$delegate.setValue(this, $$delegatedProperties[6], var1);
   }

   public final void setG4NewBlueOnboardStamp(long var1) {
      this.g4NewBlueOnboardStamp$delegate.setValue(this, $$delegatedProperties[3], var1);
   }

   public final void setLastAttempt(long var1) {
      this.lastAttempt$delegate.setValue(this, $$delegatedProperties[8], var1);
   }

   public final void setRateUsShown(boolean var1) {
      this.isRateUsShown$delegate.setValue(this, $$delegatedProperties[2], var1);
   }

   public final void setScheduleCreatedStamp(long var1) {
      this.scheduleCreatedStamp$delegate.setValue(this, $$delegatedProperties[5], var1);
   }

   public final void setShouldShowDev(boolean var1) {
      this.shouldShowDev$delegate.setValue(this, $$delegatedProperties[0], var1);
   }

   public final void setSignUpStamp(long var1) {
      this.signUpStamp$delegate.setValue(this, $$delegatedProperties[1], var1);
   }

   public final boolean shouldShowNativeInAppReview() {
      if (this.getShouldShowDev()) {
         return false;
      } else if (!this.countryAvailable) {
         return false;
      } else if (!this.isRateUsShown()) {
         return false;
      } else {
         long var1 = System.currentTimeMillis();
         if (var1 - this.getCustomReviewStamp() < CUSTOM_REVIEW_REQUIRED_TIME_PASS) {
            return false;
         } else if (this.getNativeReviewLaunchedStamp() != -1L && var1 - this.getNativeReviewLaunchedStamp() < NATIVE_REVIEW_REQUIRED_TIME_PASS) {
            return false;
         } else {
            this.setNativeReviewLaunchedStamp(var1);
            return true;
         }
      }
   }

   public final boolean shouldShowRateUsDialogT1() {
      boolean var6 = this.shouldNotShowRateUsDialog();
      boolean var7 = false;
      if (var6) {
         return false;
      } else {
         long var4 = System.currentTimeMillis() - this.getSignUpStamp();
         LongRange var8 = this.validSignUpRange;
         long var2 = var8.getFirst();
         var6 = var7;
         if (var4 <= var8.getLast()) {
            var6 = var7;
            if (var2 <= var4) {
               var6 = var7;
               if (this.shouldShowRateUsDialogByPoints()) {
                  int var1 = this.getAttemptCount();
                  var6 = true;
                  this.setAttemptCount(var1 + 1);
                  this.setLastAttempt(System.currentTimeMillis());
                  this.setCustomReviewStamp(System.currentTimeMillis());
               }
            }
         }

         return var6;
      }
   }

   public final boolean shouldShowRateUsDialogT2() {
      boolean var3 = this.shouldNotShowRateUsDialog();
      boolean var2 = false;
      if (var3) {
         return false;
      } else if (this.getG4NewBlueOnboardStamp() == -1L) {
         return false;
      } else if (System.currentTimeMillis() - this.getG4NewBlueOnboardStamp() < ONBOARD_REQUIRED_TIME_PASS) {
         return false;
      } else if (System.currentTimeMillis() - this.getSignUpStamp() < ACCOUNT_REQUIRED_TIME_PASS && this.getAppLaunchCount() < 5) {
         return false;
      } else {
         if (this.shouldShowRateUsDialogByPoints()) {
            int var1 = this.getAttemptCount();
            var2 = true;
            this.setAttemptCount(var1 + 1);
            this.setLastAttempt(System.currentTimeMillis());
            this.setCustomReviewStamp(System.currentTimeMillis());
         }

         return var2;
      }
   }

   public final boolean shouldShowRateUsDialogT3() {
      boolean var3 = this.shouldNotShowRateUsDialog();
      boolean var2 = false;
      if (var3) {
         return false;
      } else if (this.getScheduleCreatedStamp() == -1L) {
         return false;
      } else {
         if (System.currentTimeMillis() - this.getScheduleCreatedStamp() >= SCHEDULE_REQUIRED_TIME_PASS) {
            int var1 = this.getAttemptCount();
            var2 = true;
            this.setAttemptCount(var1 + 1);
            this.setLastAttempt(System.currentTimeMillis());
            this.setCustomReviewStamp(System.currentTimeMillis());
         }

         return var2;
      }
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"},
      d2 = {"Lcom/blueair/core/service/HappyUserService$Companion;", "", "<init>", "()V", "KEY_SIGN_UP_STAMP", "", "KEY_SHOULD_SHOW_DEV", "KEY_IS_RATE_US_SHOWN", "KEY_HAPPY_POINTS", "KEY_UNHAPPY_POINTS", "KEY_RESET_TIMESTAMP", "KEY_RATE_US_SHOW_ATTEMPT_COUNT", "KEY_LAST_ATTEMPT", "REQUIRED_TIME_PASS_BETWEEN_ATTEMPT", "", "MAX_SHOW_ATTEMPT", "", "KEY_APP_LAUNCH_COUNT", "KEY_G4_NEW_BLUE_ONBOARD_STAMP", "ACCOUNT_REQUIRED_TIME_PASS", "ONBOARD_REQUIRED_TIME_PASS", "KEY_SCHEDULE_CREATED_STAMP", "SCHEDULE_REQUIRED_TIME_PASS", "KEY_CUSTOM_REVIEW_SHOWED_STAMP", "CUSTOM_REVIEW_REQUIRED_TIME_PASS", "KEY_NATIVE_REVIEW_LAUNCHED_STAMP", "NATIVE_REVIEW_REQUIRED_TIME_PASS", "core_otherRelease"},
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
}
