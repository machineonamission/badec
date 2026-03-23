package com.blueair.core.service;

import com.blueair.graph.view.GraphView;
import io.flatcircle.preferenceshelper2.PreferencesHelper;
import io.flatcircle.preferenceshelper2.Prefs;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.ranges.LongRange;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b'\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u0000 W2\u00020\u0001:\u0001WB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010I\u001a\u00020JJ\u000e\u0010K\u001a\u00020J2\u0006\u0010L\u001a\u00020\u0007J\b\u0010M\u001a\u00020\u0007H\u0002J\b\u0010N\u001a\u00020\u0007H\u0002J\u0006\u0010O\u001a\u00020\u0007J\u0006\u0010P\u001a\u00020\u0007J\u0006\u0010Q\u001a\u00020\u0007J\u0006\u0010R\u001a\u00020\u0007J\u0006\u0010S\u001a\u00020JJ\u0015\u0010T\u001a\u00020J2\b\u0010U\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010VR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R+\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00078F@FX\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR+\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00148F@FX\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R+\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00078F@FX\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001b\u0010\t\"\u0004\b\u001c\u0010\u000bR+\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00148F@FX\u0002¢\u0006\u0012\n\u0004\b!\u0010\u0013\u001a\u0004\b\u001f\u0010\u0017\"\u0004\b \u0010\u0019R+\u0010#\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00020\"8F@FX\u0002¢\u0006\u0012\n\u0004\b(\u0010\u0013\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R+\u0010)\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00148F@FX\u0002¢\u0006\u0012\n\u0004\b,\u0010\u0013\u001a\u0004\b*\u0010\u0017\"\u0004\b+\u0010\u0019R+\u0010-\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00148F@FX\u0002¢\u0006\u0012\n\u0004\b0\u0010\u0013\u001a\u0004\b.\u0010\u0017\"\u0004\b/\u0010\u0019R+\u00101\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00020\"8F@FX\u0002¢\u0006\u0012\n\u0004\b4\u0010\u0013\u001a\u0004\b2\u0010%\"\u0004\b3\u0010'R+\u00105\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00148F@FX\u0002¢\u0006\u0012\n\u0004\b8\u0010\u0013\u001a\u0004\b6\u0010\u0017\"\u0004\b7\u0010\u0019R+\u00109\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00148B@BX\u0002¢\u0006\u0012\n\u0004\b<\u0010\u0013\u001a\u0004\b:\u0010\u0017\"\u0004\b;\u0010\u0019R+\u0010=\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00020\"8B@BX\u0002¢\u0006\u0012\n\u0004\b@\u0010\u0013\u001a\u0004\b>\u0010%\"\u0004\b?\u0010'R+\u0010A\u001a\u00020\"2\u0006\u0010\u000e\u001a\u00020\"8B@BX\u0002¢\u0006\u0012\n\u0004\bD\u0010\u0013\u001a\u0004\bB\u0010%\"\u0004\bC\u0010'R+\u0010E\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00148B@BX\u0002¢\u0006\u0012\n\u0004\bH\u0010\u0013\u001a\u0004\bF\u0010\u0017\"\u0004\bG\u0010\u0019¨\u0006X"}, d2 = {"Lcom/blueair/core/service/HappyUserService;", "", "prefs", "Lcom/blueair/core/service/UnsecurePrefs;", "<init>", "(Lcom/blueair/core/service/UnsecurePrefs;)V", "countryAvailable", "", "getCountryAvailable", "()Z", "setCountryAvailable", "(Z)V", "validSignUpRange", "Lkotlin/ranges/LongRange;", "<set-?>", "shouldShowDev", "getShouldShowDev", "setShouldShowDev", "shouldShowDev$delegate", "Lkotlin/properties/ReadWriteProperty;", "", "signUpStamp", "getSignUpStamp", "()J", "setSignUpStamp", "(J)V", "signUpStamp$delegate", "isRateUsShown", "setRateUsShown", "isRateUsShown$delegate", "g4NewBlueOnboardStamp", "getG4NewBlueOnboardStamp", "setG4NewBlueOnboardStamp", "g4NewBlueOnboardStamp$delegate", "", "appLaunchCount", "getAppLaunchCount", "()I", "setAppLaunchCount", "(I)V", "appLaunchCount$delegate", "scheduleCreatedStamp", "getScheduleCreatedStamp", "setScheduleCreatedStamp", "scheduleCreatedStamp$delegate", "customReviewStamp", "getCustomReviewStamp", "setCustomReviewStamp", "customReviewStamp$delegate", "attemptCount", "getAttemptCount", "setAttemptCount", "attemptCount$delegate", "lastAttempt", "getLastAttempt", "setLastAttempt", "lastAttempt$delegate", "resetTimestamp", "getResetTimestamp", "setResetTimestamp", "resetTimestamp$delegate", "happyPoints", "getHappyPoints", "setHappyPoints", "happyPoints$delegate", "unhappyPoints", "getUnhappyPoints", "setUnhappyPoints", "unhappyPoints$delegate", "nativeReviewLaunchedStamp", "getNativeReviewLaunchedStamp", "setNativeReviewLaunchedStamp", "nativeReviewLaunchedStamp$delegate", "initResetTimeStamp", "", "incrementPoints", "isHappy", "shouldNotShowRateUsDialog", "shouldShowRateUsDialogByPoints", "shouldShowRateUsDialogT1", "shouldShowRateUsDialogT2", "shouldShowRateUsDialogT3", "shouldShowNativeInAppReview", "onLogOut", "reset", "timestamp", "(Ljava/lang/Long;)V", "Companion", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: HappyUserService.kt */
public final class HappyUserService {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    private static final long ACCOUNT_REQUIRED_TIME_PASS = TimeUnit.DAYS.toMillis(14);
    private static final long CUSTOM_REVIEW_REQUIRED_TIME_PASS = TimeUnit.DAYS.toMillis(7);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
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
    private static final long NATIVE_REVIEW_REQUIRED_TIME_PASS = TimeUnit.DAYS.toMillis(30);
    private static final long ONBOARD_REQUIRED_TIME_PASS = TimeUnit.DAYS.toMillis(5);
    private static final long REQUIRED_TIME_PASS_BETWEEN_ATTEMPT = TimeUnit.DAYS.toMillis(4);
    private static final long SCHEDULE_REQUIRED_TIME_PASS = TimeUnit.DAYS.toMillis(3);
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
    private final LongRange validSignUpRange = new LongRange(7200000, GraphView.ONE_WEEK_IN_MILLIS);

    static {
        Class<HappyUserService> cls = HappyUserService.class;
        $$delegatedProperties = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "shouldShowDev", "getShouldShowDev()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "signUpStamp", "getSignUpStamp()J", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "isRateUsShown", "isRateUsShown()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "g4NewBlueOnboardStamp", "getG4NewBlueOnboardStamp()J", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "appLaunchCount", "getAppLaunchCount()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "scheduleCreatedStamp", "getScheduleCreatedStamp()J", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "customReviewStamp", "getCustomReviewStamp()J", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "attemptCount", "getAttemptCount()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "lastAttempt", "getLastAttempt()J", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "resetTimestamp", "getResetTimestamp()J", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "happyPoints", "getHappyPoints()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "unhappyPoints", "getUnhappyPoints()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "nativeReviewLaunchedStamp", "getNativeReviewLaunchedStamp()J", 0))};
    }

    public HappyUserService(UnsecurePrefs unsecurePrefs) {
        Intrinsics.checkNotNullParameter(unsecurePrefs, "prefs");
        this.prefs = unsecurePrefs;
        Prefs prefs2 = unsecurePrefs;
        this.shouldShowDev$delegate = new HappyUserService$special$$inlined$ObservablePreference$1(prefs2, KEY_SHOULD_SHOW_DEV, false, PreferencesHelper.INSTANCE.get(prefs2.getBackend(), KEY_SHOULD_SHOW_DEV, false, Reflection.getOrCreateKotlinClass(Boolean.class)));
        Prefs prefs3 = unsecurePrefs;
        this.signUpStamp$delegate = new HappyUserService$special$$inlined$ObservablePreference$2(prefs3, KEY_SIGN_UP_STAMP, -1L, PreferencesHelper.INSTANCE.get(prefs3.getBackend(), KEY_SIGN_UP_STAMP, -1L, Reflection.getOrCreateKotlinClass(Long.class)));
        Prefs prefs4 = unsecurePrefs;
        this.isRateUsShown$delegate = new HappyUserService$special$$inlined$ObservablePreference$3(prefs4, KEY_IS_RATE_US_SHOWN, false, PreferencesHelper.INSTANCE.get(prefs4.getBackend(), KEY_IS_RATE_US_SHOWN, false, Reflection.getOrCreateKotlinClass(Boolean.class)));
        Prefs prefs5 = unsecurePrefs;
        this.g4NewBlueOnboardStamp$delegate = new HappyUserService$special$$inlined$ObservablePreference$4(prefs5, KEY_G4_NEW_BLUE_ONBOARD_STAMP, -1L, PreferencesHelper.INSTANCE.get(prefs5.getBackend(), KEY_G4_NEW_BLUE_ONBOARD_STAMP, -1L, Reflection.getOrCreateKotlinClass(Long.class)));
        Prefs prefs6 = unsecurePrefs;
        this.appLaunchCount$delegate = new HappyUserService$special$$inlined$ObservablePreference$5(prefs6, KEY_APP_LAUNCH_COUNT, 0, PreferencesHelper.INSTANCE.get(prefs6.getBackend(), KEY_APP_LAUNCH_COUNT, 0, Reflection.getOrCreateKotlinClass(Integer.class)));
        Prefs prefs7 = unsecurePrefs;
        this.scheduleCreatedStamp$delegate = new HappyUserService$special$$inlined$ObservablePreference$6(prefs7, KEY_SCHEDULE_CREATED_STAMP, -1L, PreferencesHelper.INSTANCE.get(prefs7.getBackend(), KEY_SCHEDULE_CREATED_STAMP, -1L, Reflection.getOrCreateKotlinClass(Long.class)));
        Prefs prefs8 = unsecurePrefs;
        this.customReviewStamp$delegate = new HappyUserService$special$$inlined$ObservablePreference$7(prefs8, KEY_CUSTOM_REVIEW_SHOWED_STAMP, -1L, PreferencesHelper.INSTANCE.get(prefs8.getBackend(), KEY_CUSTOM_REVIEW_SHOWED_STAMP, -1L, Reflection.getOrCreateKotlinClass(Long.class)));
        Prefs prefs9 = unsecurePrefs;
        this.attemptCount$delegate = new HappyUserService$special$$inlined$ObservablePreference$8(prefs9, KEY_RATE_US_SHOW_ATTEMPT_COUNT, 0, PreferencesHelper.INSTANCE.get(prefs9.getBackend(), KEY_RATE_US_SHOW_ATTEMPT_COUNT, 0, Reflection.getOrCreateKotlinClass(Integer.class)));
        Prefs prefs10 = unsecurePrefs;
        this.lastAttempt$delegate = new HappyUserService$special$$inlined$ObservablePreference$9(prefs10, KEY_LAST_ATTEMPT, -1L, PreferencesHelper.INSTANCE.get(prefs10.getBackend(), KEY_LAST_ATTEMPT, -1L, Reflection.getOrCreateKotlinClass(Long.class)));
        Prefs prefs11 = unsecurePrefs;
        this.resetTimestamp$delegate = new HappyUserService$special$$inlined$ObservablePreference$10(prefs11, KEY_RESET_TIMESTAMP, -1L, PreferencesHelper.INSTANCE.get(prefs11.getBackend(), KEY_RESET_TIMESTAMP, -1L, Reflection.getOrCreateKotlinClass(Long.class)));
        Prefs prefs12 = unsecurePrefs;
        this.happyPoints$delegate = new HappyUserService$special$$inlined$ObservablePreference$11(prefs12, KEY_HAPPY_POINTS, 0, PreferencesHelper.INSTANCE.get(prefs12.getBackend(), KEY_HAPPY_POINTS, 0, Reflection.getOrCreateKotlinClass(Integer.class)));
        Prefs prefs13 = unsecurePrefs;
        this.unhappyPoints$delegate = new HappyUserService$special$$inlined$ObservablePreference$12(prefs13, KEY_UNHAPPY_POINTS, 0, PreferencesHelper.INSTANCE.get(prefs13.getBackend(), KEY_UNHAPPY_POINTS, 0, Reflection.getOrCreateKotlinClass(Integer.class)));
        Prefs prefs14 = unsecurePrefs;
        this.nativeReviewLaunchedStamp$delegate = new HappyUserService$special$$inlined$ObservablePreference$13(prefs14, KEY_NATIVE_REVIEW_LAUNCHED_STAMP, -1L, PreferencesHelper.INSTANCE.get(prefs14.getBackend(), KEY_NATIVE_REVIEW_LAUNCHED_STAMP, -1L, Reflection.getOrCreateKotlinClass(Long.class)));
    }

    public final boolean getCountryAvailable() {
        return this.countryAvailable;
    }

    public final void setCountryAvailable(boolean z) {
        this.countryAvailable = z;
    }

    public final boolean getShouldShowDev() {
        return ((Boolean) this.shouldShowDev$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final void setShouldShowDev(boolean z) {
        this.shouldShowDev$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    public final long getSignUpStamp() {
        return ((Number) this.signUpStamp$delegate.getValue(this, $$delegatedProperties[1])).longValue();
    }

    public final void setSignUpStamp(long j) {
        this.signUpStamp$delegate.setValue(this, $$delegatedProperties[1], Long.valueOf(j));
    }

    public final boolean isRateUsShown() {
        return ((Boolean) this.isRateUsShown$delegate.getValue(this, $$delegatedProperties[2])).booleanValue();
    }

    public final void setRateUsShown(boolean z) {
        this.isRateUsShown$delegate.setValue(this, $$delegatedProperties[2], Boolean.valueOf(z));
    }

    public final long getG4NewBlueOnboardStamp() {
        return ((Number) this.g4NewBlueOnboardStamp$delegate.getValue(this, $$delegatedProperties[3])).longValue();
    }

    public final void setG4NewBlueOnboardStamp(long j) {
        this.g4NewBlueOnboardStamp$delegate.setValue(this, $$delegatedProperties[3], Long.valueOf(j));
    }

    public final int getAppLaunchCount() {
        return ((Number) this.appLaunchCount$delegate.getValue(this, $$delegatedProperties[4])).intValue();
    }

    public final void setAppLaunchCount(int i) {
        this.appLaunchCount$delegate.setValue(this, $$delegatedProperties[4], Integer.valueOf(i));
    }

    public final long getScheduleCreatedStamp() {
        return ((Number) this.scheduleCreatedStamp$delegate.getValue(this, $$delegatedProperties[5])).longValue();
    }

    public final void setScheduleCreatedStamp(long j) {
        this.scheduleCreatedStamp$delegate.setValue(this, $$delegatedProperties[5], Long.valueOf(j));
    }

    public final long getCustomReviewStamp() {
        return ((Number) this.customReviewStamp$delegate.getValue(this, $$delegatedProperties[6])).longValue();
    }

    public final void setCustomReviewStamp(long j) {
        this.customReviewStamp$delegate.setValue(this, $$delegatedProperties[6], Long.valueOf(j));
    }

    public final int getAttemptCount() {
        return ((Number) this.attemptCount$delegate.getValue(this, $$delegatedProperties[7])).intValue();
    }

    public final void setAttemptCount(int i) {
        this.attemptCount$delegate.setValue(this, $$delegatedProperties[7], Integer.valueOf(i));
    }

    public final long getLastAttempt() {
        return ((Number) this.lastAttempt$delegate.getValue(this, $$delegatedProperties[8])).longValue();
    }

    public final void setLastAttempt(long j) {
        this.lastAttempt$delegate.setValue(this, $$delegatedProperties[8], Long.valueOf(j));
    }

    private final long getResetTimestamp() {
        return ((Number) this.resetTimestamp$delegate.getValue(this, $$delegatedProperties[9])).longValue();
    }

    private final void setResetTimestamp(long j) {
        this.resetTimestamp$delegate.setValue(this, $$delegatedProperties[9], Long.valueOf(j));
    }

    private final int getHappyPoints() {
        return ((Number) this.happyPoints$delegate.getValue(this, $$delegatedProperties[10])).intValue();
    }

    private final void setHappyPoints(int i) {
        this.happyPoints$delegate.setValue(this, $$delegatedProperties[10], Integer.valueOf(i));
    }

    private final int getUnhappyPoints() {
        return ((Number) this.unhappyPoints$delegate.getValue(this, $$delegatedProperties[11])).intValue();
    }

    private final void setUnhappyPoints(int i) {
        this.unhappyPoints$delegate.setValue(this, $$delegatedProperties[11], Integer.valueOf(i));
    }

    private final long getNativeReviewLaunchedStamp() {
        return ((Number) this.nativeReviewLaunchedStamp$delegate.getValue(this, $$delegatedProperties[12])).longValue();
    }

    private final void setNativeReviewLaunchedStamp(long j) {
        this.nativeReviewLaunchedStamp$delegate.setValue(this, $$delegatedProperties[12], Long.valueOf(j));
    }

    public final void initResetTimeStamp() {
        if (getResetTimestamp() == -1) {
            setResetTimestamp(System.currentTimeMillis());
        }
    }

    public final void incrementPoints(boolean z) {
        if (getSignUpStamp() != -1 && !isRateUsShown() && !getShouldShowDev()) {
            if (z) {
                setHappyPoints(getHappyPoints() + 1);
            } else {
                setUnhappyPoints(getUnhappyPoints() + 1);
            }
        }
    }

    private final boolean shouldNotShowRateUsDialog() {
        if (!this.countryAvailable || isRateUsShown() || getAttemptCount() >= 3 || getShouldShowDev()) {
            return true;
        }
        if (getLastAttempt() == -1 || REQUIRED_TIME_PASS_BETWEEN_ATTEMPT <= System.currentTimeMillis() - getLastAttempt()) {
            return false;
        }
        return true;
    }

    private final boolean shouldShowRateUsDialogByPoints() {
        int happyPoints = getHappyPoints();
        return getUnhappyPoints() + happyPoints >= 5 && happyPoints >= 4;
    }

    public final boolean shouldShowRateUsDialogT1() {
        if (shouldNotShowRateUsDialog()) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() - getSignUpStamp();
        LongRange longRange = this.validSignUpRange;
        long first = longRange.getFirst();
        if (currentTimeMillis > longRange.getLast() || first > currentTimeMillis || !shouldShowRateUsDialogByPoints()) {
            return false;
        }
        setAttemptCount(getAttemptCount() + 1);
        setLastAttempt(System.currentTimeMillis());
        setCustomReviewStamp(System.currentTimeMillis());
        return true;
    }

    public final boolean shouldShowRateUsDialogT2() {
        if (shouldNotShowRateUsDialog() || getG4NewBlueOnboardStamp() == -1 || System.currentTimeMillis() - getG4NewBlueOnboardStamp() < ONBOARD_REQUIRED_TIME_PASS) {
            return false;
        }
        if ((System.currentTimeMillis() - getSignUpStamp() < ACCOUNT_REQUIRED_TIME_PASS && getAppLaunchCount() < 5) || !shouldShowRateUsDialogByPoints()) {
            return false;
        }
        setAttemptCount(getAttemptCount() + 1);
        setLastAttempt(System.currentTimeMillis());
        setCustomReviewStamp(System.currentTimeMillis());
        return true;
    }

    public final boolean shouldShowRateUsDialogT3() {
        if (shouldNotShowRateUsDialog() || getScheduleCreatedStamp() == -1 || System.currentTimeMillis() - getScheduleCreatedStamp() < SCHEDULE_REQUIRED_TIME_PASS) {
            return false;
        }
        setAttemptCount(getAttemptCount() + 1);
        setLastAttempt(System.currentTimeMillis());
        setCustomReviewStamp(System.currentTimeMillis());
        return true;
    }

    public final boolean shouldShowNativeInAppReview() {
        if (getShouldShowDev() || !this.countryAvailable || !isRateUsShown()) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - getCustomReviewStamp() < CUSTOM_REVIEW_REQUIRED_TIME_PASS) {
            return false;
        }
        if (getNativeReviewLaunchedStamp() != -1 && currentTimeMillis - getNativeReviewLaunchedStamp() < NATIVE_REVIEW_REQUIRED_TIME_PASS) {
            return false;
        }
        setNativeReviewLaunchedStamp(currentTimeMillis);
        return true;
    }

    public final void onLogOut() {
        this.prefs.remove(KEY_SIGN_UP_STAMP);
        this.prefs.remove(KEY_HAPPY_POINTS);
        this.prefs.remove(KEY_UNHAPPY_POINTS);
    }

    public final void reset(Long l) {
        long currentTimeMillis = System.currentTimeMillis();
        if (l != null && l.longValue() > getResetTimestamp()) {
            setResetTimestamp(currentTimeMillis);
            setRateUsShown(false);
            if (getG4NewBlueOnboardStamp() != -1) {
                setG4NewBlueOnboardStamp(currentTimeMillis);
            }
            setAppLaunchCount(0);
            if (getScheduleCreatedStamp() != -1) {
                setScheduleCreatedStamp(currentTimeMillis);
            }
            setCustomReviewStamp(currentTimeMillis);
            setNativeReviewLaunchedStamp(-1);
            setAttemptCount(0);
            setLastAttempt(-1);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/blueair/core/service/HappyUserService$Companion;", "", "<init>", "()V", "KEY_SIGN_UP_STAMP", "", "KEY_SHOULD_SHOW_DEV", "KEY_IS_RATE_US_SHOWN", "KEY_HAPPY_POINTS", "KEY_UNHAPPY_POINTS", "KEY_RESET_TIMESTAMP", "KEY_RATE_US_SHOW_ATTEMPT_COUNT", "KEY_LAST_ATTEMPT", "REQUIRED_TIME_PASS_BETWEEN_ATTEMPT", "", "MAX_SHOW_ATTEMPT", "", "KEY_APP_LAUNCH_COUNT", "KEY_G4_NEW_BLUE_ONBOARD_STAMP", "ACCOUNT_REQUIRED_TIME_PASS", "ONBOARD_REQUIRED_TIME_PASS", "KEY_SCHEDULE_CREATED_STAMP", "SCHEDULE_REQUIRED_TIME_PASS", "KEY_CUSTOM_REVIEW_SHOWED_STAMP", "CUSTOM_REVIEW_REQUIRED_TIME_PASS", "KEY_NATIVE_REVIEW_LAUNCHED_STAMP", "NATIVE_REVIEW_REQUIRED_TIME_PASS", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: HappyUserService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
