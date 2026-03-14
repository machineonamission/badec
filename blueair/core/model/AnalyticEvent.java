package com.blueair.core.model;

import android.content.Context;
import android.os.Build;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(
   d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \f2\u00020\u0001:!\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,B%\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0082\u0001 -./0123456789:;<=>?@ABCDEFGHIJKL¨\u0006M"},
   d2 = {"Lcom/blueair/core/model/AnalyticEvent;", "", "eventName", "", "payload", "", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "getEventName", "()Ljava/lang/String;", "getPayload", "()Ljava/util/Map;", "Companion", "ScreenViewEvent", "LogoutEvent", "ForgotPasswordEvent", "OnboardingLogEvent", "GigyaErrorEvent", "CloudJwtExpiredEvent", "AppUpgradeEvent", "GigyaCloudRegionMismatchEvent", "GigyaGetAccountErrorEvent", "BT_SUCCESS", "BT_PRODUCT_FOUND", "BT_PRODUCT_SELECTED", "BT_PRODUCT_SELECTED_ERROR", "BT_INCORRECT_PW", "BT_EVENT", "BT_EVENT_FAILURE", "BT_REGISTER_ONBOARDING_ERROR", "BT_CHOOSE_DEFAULT_NAME", "BT_FINALIZE", "DeviceSettingEvent", "DeviceBatchSettingEvent", "OPEN_FAN_HISTORY", "SET_SCHEDULE", "SAVE_OUTDOOR_LOCATION", "ENABLE_GPS_LOCATION", "TAP_TROUBLESHOOTING", "TAP_CUSTOMER_SUPPORT", "REFRESH_GIGYA_JWT", "BreezoApiEvent", "BugEvent", "KlaviyoEvent", "FilterClickEvent", "Lcom/blueair/core/model/AnalyticEvent$AppUpgradeEvent;", "Lcom/blueair/core/model/AnalyticEvent$BT_CHOOSE_DEFAULT_NAME;", "Lcom/blueair/core/model/AnalyticEvent$BT_EVENT;", "Lcom/blueair/core/model/AnalyticEvent$BT_EVENT_FAILURE;", "Lcom/blueair/core/model/AnalyticEvent$BT_FINALIZE;", "Lcom/blueair/core/model/AnalyticEvent$BT_INCORRECT_PW;", "Lcom/blueair/core/model/AnalyticEvent$BT_PRODUCT_FOUND;", "Lcom/blueair/core/model/AnalyticEvent$BT_PRODUCT_SELECTED;", "Lcom/blueair/core/model/AnalyticEvent$BT_PRODUCT_SELECTED_ERROR;", "Lcom/blueair/core/model/AnalyticEvent$BT_REGISTER_ONBOARDING_ERROR;", "Lcom/blueair/core/model/AnalyticEvent$BT_SUCCESS;", "Lcom/blueair/core/model/AnalyticEvent$BreezoApiEvent;", "Lcom/blueair/core/model/AnalyticEvent$BugEvent;", "Lcom/blueair/core/model/AnalyticEvent$CloudJwtExpiredEvent;", "Lcom/blueair/core/model/AnalyticEvent$DeviceBatchSettingEvent;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "Lcom/blueair/core/model/AnalyticEvent$ENABLE_GPS_LOCATION;", "Lcom/blueair/core/model/AnalyticEvent$FilterClickEvent;", "Lcom/blueair/core/model/AnalyticEvent$ForgotPasswordEvent;", "Lcom/blueair/core/model/AnalyticEvent$GigyaCloudRegionMismatchEvent;", "Lcom/blueair/core/model/AnalyticEvent$GigyaErrorEvent;", "Lcom/blueair/core/model/AnalyticEvent$GigyaGetAccountErrorEvent;", "Lcom/blueair/core/model/AnalyticEvent$KlaviyoEvent;", "Lcom/blueair/core/model/AnalyticEvent$LogoutEvent;", "Lcom/blueair/core/model/AnalyticEvent$OPEN_FAN_HISTORY;", "Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent;", "Lcom/blueair/core/model/AnalyticEvent$REFRESH_GIGYA_JWT;", "Lcom/blueair/core/model/AnalyticEvent$SAVE_OUTDOOR_LOCATION;", "Lcom/blueair/core/model/AnalyticEvent$SET_SCHEDULE;", "Lcom/blueair/core/model/AnalyticEvent$ScreenViewEvent;", "Lcom/blueair/core/model/AnalyticEvent$TAP_CUSTOMER_SUPPORT;", "Lcom/blueair/core/model/AnalyticEvent$TAP_TROUBLESHOOTING;", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public abstract class AnalyticEvent {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final String KEY_CITY = "city";
   public static final String KEY_ERROR_CODE = "error_code";
   public static final String KEY_ERROR_DESCRIPTION = "error_description";
   public static final String KEY_EVENT_NAME = "event_name";
   public static final String KEY_MAC = "mac";
   public static final String KEY_NAME = "name";
   public static final String KEY_ONLINE_TIME = "online_time";
   public static final String KEY_PLATFORM = "platform";
   public static final String KEY_SETTING = "setting";
   public static final String KEY_TIMESTAMP = "time";
   public static final String KEY_TIME_END = "end_time";
   public static final String KEY_TIME_START = "start_time";
   public static final String KEY_TYPE = "type";
   public static final String KEY_UUID = "uuid";
   public static final String KEY_VALUE = "value";
   public static final String VALUE_PLATFORM = "android";
   private final String eventName;
   private final Map payload;

   private AnalyticEvent(String var1, Map var2) {
      this.eventName = var1;
      this.payload = var2;
   }

   // $FF: synthetic method
   public AnalyticEvent(String var1, Map var2, DefaultConstructorMarker var3) {
      this(var1, var2);
   }

   public final String getEventName() {
      return this.eventName;
   }

   public final Map getPayload() {
      return this.payload;
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"},
      d2 = {"Lcom/blueair/core/model/AnalyticEvent$AppUpgradeEvent;", "Lcom/blueair/core/model/AnalyticEvent;", "gigyaUid", "", "fromCode", "", "fromName", "toCode", "toName", "<init>", "(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;)V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class AppUpgradeEvent extends AnalyticEvent {
      public AppUpgradeEvent(String var1, int var2, String var3, int var4, String var5) {
         Intrinsics.checkNotNullParameter(var1, "gigyaUid");
         Intrinsics.checkNotNullParameter(var3, "fromName");
         Intrinsics.checkNotNullParameter(var5, "toName");
         super("blueair_app_upgrade", MapsKt.mapOf(new Pair[]{TuplesKt.to("gigyaUid", var1), TuplesKt.to("fromCode", var2), TuplesKt.to("fromName", var3), TuplesKt.to("toCode", var4), TuplesKt.to("toName", var5), TuplesKt.to("platform", "android"), TuplesKt.to("time", System.currentTimeMillis())}), (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/core/model/AnalyticEvent$BT_CHOOSE_DEFAULT_NAME;", "Lcom/blueair/core/model/AnalyticEvent;", "name", "", "<init>", "(Ljava/lang/String;)V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class BT_CHOOSE_DEFAULT_NAME extends AnalyticEvent {
      public BT_CHOOSE_DEFAULT_NAME(String var1) {
         Intrinsics.checkNotNullParameter(var1, "name");
         super("bt_choose_default_name", MapsKt.mapOf(TuplesKt.to("name", var1)), (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"},
      d2 = {"Lcom/blueair/core/model/AnalyticEvent$BT_EVENT;", "Lcom/blueair/core/model/AnalyticEvent;", "uuid", "", "eventName", "errorCode", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class BT_EVENT extends AnalyticEvent {
      public BT_EVENT(String var1, String var2, int var3) {
         Intrinsics.checkNotNullParameter(var1, "uuid");
         Intrinsics.checkNotNullParameter(var2, "eventName");
         super("bt_event", MapsKt.mapOf(new Pair[]{TuplesKt.to("uuid", var1), TuplesKt.to("event_name", var2), TuplesKt.to("error_code", var3)}), (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"},
      d2 = {"Lcom/blueair/core/model/AnalyticEvent$BT_EVENT_FAILURE;", "Lcom/blueair/core/model/AnalyticEvent;", "uuid", "", "eventName", "errorCode", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class BT_EVENT_FAILURE extends AnalyticEvent {
      public BT_EVENT_FAILURE(String var1, String var2, int var3) {
         Intrinsics.checkNotNullParameter(var1, "uuid");
         Intrinsics.checkNotNullParameter(var2, "eventName");
         super("bt_event_failure", MapsKt.mapOf(new Pair[]{TuplesKt.to("uuid", var1), TuplesKt.to("event_name", var2), TuplesKt.to("error_code", var3)}), (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/core/model/AnalyticEvent$BT_FINALIZE;", "Lcom/blueair/core/model/AnalyticEvent;", "duration", "", "<init>", "(I)V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class BT_FINALIZE extends AnalyticEvent {
      public BT_FINALIZE(int var1) {
         super("bt_finalizing", MapsKt.mapOf(TuplesKt.to("online_time", var1)), (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/AnalyticEvent$BT_INCORRECT_PW;", "Lcom/blueair/core/model/AnalyticEvent;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class BT_INCORRECT_PW extends AnalyticEvent {
      public BT_INCORRECT_PW() {
         super("bt_incorrect_pw", MapsKt.emptyMap(), (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/core/model/AnalyticEvent$BT_PRODUCT_FOUND;", "Lcom/blueair/core/model/AnalyticEvent;", "mac", "", "<init>", "(Ljava/lang/String;)V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class BT_PRODUCT_FOUND extends AnalyticEvent {
      public BT_PRODUCT_FOUND(String var1) {
         Intrinsics.checkNotNullParameter(var1, "mac");
         super("bt_product_found", MapsKt.mapOf(TuplesKt.to("mac", var1)), (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/core/model/AnalyticEvent$BT_PRODUCT_SELECTED;", "Lcom/blueair/core/model/AnalyticEvent;", "mac", "", "<init>", "(Ljava/lang/String;)V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class BT_PRODUCT_SELECTED extends AnalyticEvent {
      public BT_PRODUCT_SELECTED(String var1) {
         Intrinsics.checkNotNullParameter(var1, "mac");
         super("bt_product_selected", MapsKt.mapOf(TuplesKt.to("mac", var1)), (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/core/model/AnalyticEvent$BT_PRODUCT_SELECTED_ERROR;", "Lcom/blueair/core/model/AnalyticEvent;", "errorDescription", "", "<init>", "(Ljava/lang/String;)V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class BT_PRODUCT_SELECTED_ERROR extends AnalyticEvent {
      public BT_PRODUCT_SELECTED_ERROR(String var1) {
         Intrinsics.checkNotNullParameter(var1, "errorDescription");
         super("bt_product_selected_error", MapsKt.mapOf(TuplesKt.to("error_description", var1)), (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/core/model/AnalyticEvent$BT_REGISTER_ONBOARDING_ERROR;", "Lcom/blueair/core/model/AnalyticEvent;", "errorDescription", "", "<init>", "(Ljava/lang/String;)V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class BT_REGISTER_ONBOARDING_ERROR extends AnalyticEvent {
      public BT_REGISTER_ONBOARDING_ERROR(String var1) {
         Intrinsics.checkNotNullParameter(var1, "errorDescription");
         super("bt_register_onboarding_error", MapsKt.mapOf(TuplesKt.to("error_description", var1)), (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/core/model/AnalyticEvent$BT_SUCCESS;", "Lcom/blueair/core/model/AnalyticEvent;", "uuid", "", "<init>", "(Ljava/lang/String;)V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class BT_SUCCESS extends AnalyticEvent {
      public BT_SUCCESS(String var1) {
         Intrinsics.checkNotNullParameter(var1, "uuid");
         super("bt_success", MapsKt.mapOf(TuplesKt.to("uuid", var1)), (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0006\u0007B\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0001\u0002\b\t¨\u0006\n"},
      d2 = {"Lcom/blueair/core/model/AnalyticEvent$BreezoApiEvent;", "Lcom/blueair/core/model/AnalyticEvent;", "type", "", "<init>", "(Ljava/lang/String;)V", "Volatile", "Historical", "Lcom/blueair/core/model/AnalyticEvent$BreezoApiEvent$Historical;", "Lcom/blueair/core/model/AnalyticEvent$BreezoApiEvent$Volatile;", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public abstract static class BreezoApiEvent extends AnalyticEvent {
      private BreezoApiEvent(String var1) {
         super("breezometer_api_call", MapsKt.mapOf(TuplesKt.to("type", var1)), (DefaultConstructorMarker)null);
      }

      // $FF: synthetic method
      public BreezoApiEvent(String var1, DefaultConstructorMarker var2) {
         this(var1);
      }

      @Metadata(
         d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$BreezoApiEvent$Historical;", "Lcom/blueair/core/model/AnalyticEvent$BreezoApiEvent;", "<init>", "()V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class Historical extends BreezoApiEvent {
         public Historical() {
            super("historical", (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$BreezoApiEvent$Volatile;", "Lcom/blueair/core/model/AnalyticEvent$BreezoApiEvent;", "<init>", "()V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class Volatile extends BreezoApiEvent {
         public Volatile() {
            super("location", (DefaultConstructorMarker)null);
         }
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0007\b\t\nB\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0001\u0004\u000b\f\r\u000e¨\u0006\u000f"},
      d2 = {"Lcom/blueair/core/model/AnalyticEvent$BugEvent;", "Lcom/blueair/core/model/AnalyticEvent;", "eventName", "", "message", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "StompConnectFail", "BlueAirSdkFail", "LogoutFail", "KlaviyoFail", "Lcom/blueair/core/model/AnalyticEvent$BugEvent$BlueAirSdkFail;", "Lcom/blueair/core/model/AnalyticEvent$BugEvent$KlaviyoFail;", "Lcom/blueair/core/model/AnalyticEvent$BugEvent$LogoutFail;", "Lcom/blueair/core/model/AnalyticEvent$BugEvent$StompConnectFail;", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public abstract static class BugEvent extends AnalyticEvent {
      private BugEvent(String var1, String var2) {
         super(var1, MapsKt.mapOf(TuplesKt.to("error_description", var2)), (DefaultConstructorMarker)null);
      }

      // $FF: synthetic method
      public BugEvent(String var1, String var2, DefaultConstructorMarker var3) {
         this(var1, var2);
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$BugEvent$BlueAirSdkFail;", "Lcom/blueair/core/model/AnalyticEvent$BugEvent;", "message", "", "<init>", "(Ljava/lang/String;)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class BlueAirSdkFail extends BugEvent {
         public BlueAirSdkFail(String var1) {
            Intrinsics.checkNotNullParameter(var1, "message");
            super("blueair_sdk_failure", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$BugEvent$KlaviyoFail;", "Lcom/blueair/core/model/AnalyticEvent$BugEvent;", "message", "", "<init>", "(Ljava/lang/String;)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class KlaviyoFail extends BugEvent {
         public KlaviyoFail(String var1) {
            Intrinsics.checkNotNullParameter(var1, "message");
            super("klaviyo_failure", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$BugEvent$LogoutFail;", "Lcom/blueair/core/model/AnalyticEvent$BugEvent;", "message", "", "<init>", "(Ljava/lang/String;)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class LogoutFail extends BugEvent {
         public LogoutFail(String var1) {
            Intrinsics.checkNotNullParameter(var1, "message");
            super("logout_failure", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$BugEvent$StompConnectFail;", "Lcom/blueair/core/model/AnalyticEvent$BugEvent;", "message", "", "<init>", "(Ljava/lang/String;)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class StompConnectFail extends BugEvent {
         public StompConnectFail(String var1) {
            Intrinsics.checkNotNullParameter(var1, "message");
            super("stomp_connection_failure", var1, (DefaultConstructorMarker)null);
         }
      }
   }

   @Metadata(
      d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"},
      d2 = {"Lcom/blueair/core/model/AnalyticEvent$CloudJwtExpiredEvent;", "Lcom/blueair/core/model/AnalyticEvent;", "expiredCount", "", "messages", "", "iat", "Ljava/util/Date;", "exp", "<init>", "(ILjava/lang/String;Ljava/util/Date;Ljava/util/Date;)V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class CloudJwtExpiredEvent extends AnalyticEvent {
      public CloudJwtExpiredEvent(int var1, String var2, Date var3, Date var4) {
         Intrinsics.checkNotNullParameter(var2, "messages");
         super("cloud_jwt_expired", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("expired_count", var1), TuplesKt.to("messages", var2), TuplesKt.to("iat", String.valueOf(var3)), TuplesKt.to("exp", String.valueOf(var4)), TuplesKt.to("timezone", TimeZone.getDefault().getID()), TuplesKt.to("local_time", (new Date()).toString())}), (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"},
      d2 = {"Lcom/blueair/core/model/AnalyticEvent$Companion;", "", "<init>", "()V", "KEY_UUID", "", "KEY_MAC", "KEY_NAME", "KEY_EVENT_NAME", "KEY_ERROR_DESCRIPTION", "KEY_ERROR_CODE", "KEY_SETTING", "KEY_VALUE", "KEY_CITY", "KEY_TIME_START", "KEY_TIME_END", "KEY_ONLINE_TIME", "KEY_TYPE", "KEY_PLATFORM", "VALUE_PLATFORM", "KEY_TIMESTAMP", "core_otherRelease"},
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
      d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\n\u000b\f\r\u000eB+\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u00060\u0005¢\u0006\u0004\b\b\u0010\t\u0082\u0001\u0005\u000f\u0010\u0011\u0012\u0013¨\u0006\u0014"},
      d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceBatchSettingEvent;", "Lcom/blueair/core/model/AnalyticEvent;", "name", "", "settings", "", "Lkotlin/Pair;", "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "SET_OSCILLATION_PARAMS", "SET_COOL_AUTO_PRESETS", "SET_COOL_ECO_PRESETS", "SET_DUAL_OSCILLATION_SWING", "SET_DUAL_OSCILLATION_FIXED", "Lcom/blueair/core/model/AnalyticEvent$DeviceBatchSettingEvent$SET_COOL_AUTO_PRESETS;", "Lcom/blueair/core/model/AnalyticEvent$DeviceBatchSettingEvent$SET_COOL_ECO_PRESETS;", "Lcom/blueair/core/model/AnalyticEvent$DeviceBatchSettingEvent$SET_DUAL_OSCILLATION_FIXED;", "Lcom/blueair/core/model/AnalyticEvent$DeviceBatchSettingEvent$SET_DUAL_OSCILLATION_SWING;", "Lcom/blueair/core/model/AnalyticEvent$DeviceBatchSettingEvent$SET_OSCILLATION_PARAMS;", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public abstract static class DeviceBatchSettingEvent extends AnalyticEvent {
      private DeviceBatchSettingEvent(String var1, List var2) {
         super("device_batch_setting", MapsKt.mapOf(new Pair[]{TuplesKt.to("setting", var1), TuplesKt.to("value", CollectionsKt.joinToString$default((Iterable)var2, (CharSequence)null, (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)null, 63, (Object)null))}), (DefaultConstructorMarker)null);
      }

      // $FF: synthetic method
      public DeviceBatchSettingEvent(String var1, List var2, DefaultConstructorMarker var3) {
         this(var1, var2);
      }

      @Metadata(
         d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0013\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceBatchSettingEvent$SET_COOL_AUTO_PRESETS;", "Lcom/blueair/core/model/AnalyticEvent$DeviceBatchSettingEvent;", "tag", "", "presets", "", "<init>", "(I[D)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_COOL_AUTO_PRESETS extends DeviceBatchSettingEvent {
         public SET_COOL_AUTO_PRESETS(int var1, double[] var2) {
            Pair var4;
            label11: {
               var4 = TuplesKt.to("coolautotag", var1);
               if (var2 != null) {
                  String var3 = Arrays.toString(var2);
                  Intrinsics.checkNotNullExpressionValue(var3, "toString(...)");
                  var5 = var3;
                  if (var3 != null) {
                     break label11;
                  }
               }

               var5 = "null";
            }

            super("cool_auto_presets", CollectionsKt.listOf(new Pair[]{var4, TuplesKt.to("coolautofs", var5)}), (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0013\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceBatchSettingEvent$SET_COOL_ECO_PRESETS;", "Lcom/blueair/core/model/AnalyticEvent$DeviceBatchSettingEvent;", "tag", "", "presets", "", "<init>", "(I[D)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_COOL_ECO_PRESETS extends DeviceBatchSettingEvent {
         public SET_COOL_ECO_PRESETS(int var1, double[] var2) {
            Pair var4;
            label11: {
               var4 = TuplesKt.to("coolecotag", var1);
               if (var2 != null) {
                  String var3 = Arrays.toString(var2);
                  Intrinsics.checkNotNullExpressionValue(var3, "toString(...)");
                  var5 = var3;
                  if (var3 != null) {
                     break label11;
                  }
               }

               var5 = "null";
            }

            super("cool_eco_presets", CollectionsKt.listOf(new Pair[]{var4, TuplesKt.to("coolecofs", var5)}), (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceBatchSettingEvent$SET_DUAL_OSCILLATION_FIXED;", "Lcom/blueair/core/model/AnalyticEvent$DeviceBatchSettingEvent;", "horizontal", "", "state", "", "fixedAngle", "<init>", "(ZII)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_DUAL_OSCILLATION_FIXED extends DeviceBatchSettingEvent {
         public SET_DUAL_OSCILLATION_FIXED(boolean var1, int var2, int var3) {
            String var4;
            if (var1) {
               var4 = "oscstateh";
            } else {
               var4 = "oscstatev";
            }

            Pair var5 = TuplesKt.to(var4, var2);
            if (var1) {
               var4 = "oscfixh";
            } else {
               var4 = "oscfixv";
            }

            super("dual_oscillation_config", CollectionsKt.listOf(new Pair[]{var5, TuplesKt.to(var4, var3)}), (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t¨\u0006\n"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceBatchSettingEvent$SET_DUAL_OSCILLATION_SWING;", "Lcom/blueair/core/model/AnalyticEvent$DeviceBatchSettingEvent;", "horizontal", "", "state", "", "minAngle", "maxAngle", "<init>", "(ZIII)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_DUAL_OSCILLATION_SWING extends DeviceBatchSettingEvent {
         public SET_DUAL_OSCILLATION_SWING(boolean var1, int var2, int var3, int var4) {
            String var5;
            if (var1) {
               var5 = "oscstateh";
            } else {
               var5 = "oscstatev";
            }

            Pair var6 = TuplesKt.to(var5, var2);
            if (var1) {
               var5 = "oscminh";
            } else {
               var5 = "oscminv";
            }

            Pair var7 = TuplesKt.to(var5, var3);
            if (var1) {
               var5 = "oscmaxh";
            } else {
               var5 = "oscmaxv";
            }

            super("dual_oscillation_config", CollectionsKt.listOf(new Pair[]{var6, var7, TuplesKt.to(var5, var4)}), (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceBatchSettingEvent$SET_OSCILLATION_PARAMS;", "Lcom/blueair/core/model/AnalyticEvent$DeviceBatchSettingEvent;", "angle", "", "direction", "fanSpeed", "<init>", "(III)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_OSCILLATION_PARAMS extends DeviceBatchSettingEvent {
         public SET_OSCILLATION_PARAMS(int var1, int var2, int var3) {
            super("osc_params", CollectionsKt.listOf(new Pair[]{TuplesKt.to("osc", var1), TuplesKt.to("oscdir", var2), TuplesKt.to("oscfs", var3)}), (DefaultConstructorMarker)null);
         }
      }
   }

   @Metadata(
      d1 = {"\u0000ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b6\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:4\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123456789:;B\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007\u0082\u00014<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmno¨\u0006p"},
      d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "Lcom/blueair/core/model/AnalyticEvent;", "setting", "", "value", "", "<init>", "(Ljava/lang/String;Ljava/lang/Object;)V", "SET_FAN_SPEED", "SET_GERM_SHIELD", "SET_GERM_SHIELD_NIGHT_MODE", "SET_STANDBY", "SET_ECO", "SET_HINS_MODE", "SET_HINS_NIGHT_MODE", "SET_AUTO_MODE", "SET_NIGHT_MODE", "SET_CHILD_LOCK", "SET_BRIGHTNESS", "SET_DISINFECTION", "SET_WICK_DRY_ENABLED", "SET_WICK_DRY_ON", "SET_AUTO_RH", "SET_TIMER_STATUS", "SET_TIMER_DURATION", "SET_TEMPERATURE_UNIT", "SET_OSCILLATION_STATE", "SET_MAIN_MODE", "SET_AP_SUBMODE", "SET_AP_FANSPEED", "SET_HEAT_SUBMODE", "SET_HEAT_FANSPEED", "SET_HEAT_AUTO_TMP", "SET_HEAT_ECO_TMP", "SET_COOL_SUBMODE", "SET_COOL_FANSPEED", "SET_COOL_FANSPEED_LEVEL", "SET_COOL_AUTO_LEVEL", "SET_MODE", "SET_HUM_MODE", "SET_DEH_SUBMODE", "SET_SMART_SUBMODE", "SET_TARE", "SET_PANEL_DISPLAY_MODE", "SET_HOVER_ENABLED", "SET_AIR_REFRESH_STATUS", "SET_AIR_REFRESH_ENABLED", "SET_NIGHT_LAMP_BRIGHTNESS", "SET_NIGHT_LAMP_STEPLESS_BRIGHTNESS", "SET_WICK_DRY_DURATION", "SET_YWRM_ENABLED", "SET_ALARM", "PLAY_ALARM", "STOP_ALARM", "SET_HUM_SUBMODE", "SET_USE_24_HOUR", "SET_SENSOR_MODE", "CALIBRATE_OSCILLATION_POSITION", "SET_OSCILLATION_MODE", "SET_DUAL_OSCILLATION_STATE", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$CALIBRATE_OSCILLATION_POSITION;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$PLAY_ALARM;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_AIR_REFRESH_ENABLED;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_AIR_REFRESH_STATUS;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_ALARM;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_AP_FANSPEED;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_AP_SUBMODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_AUTO_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_AUTO_RH;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_BRIGHTNESS;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_CHILD_LOCK;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_COOL_AUTO_LEVEL;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_COOL_FANSPEED;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_COOL_FANSPEED_LEVEL;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_COOL_SUBMODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_DEH_SUBMODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_DISINFECTION;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_DUAL_OSCILLATION_STATE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_ECO;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_FAN_SPEED;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_GERM_SHIELD;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_GERM_SHIELD_NIGHT_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_HEAT_AUTO_TMP;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_HEAT_ECO_TMP;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_HEAT_FANSPEED;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_HEAT_SUBMODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_HINS_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_HINS_NIGHT_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_HOVER_ENABLED;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_HUM_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_HUM_SUBMODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_MAIN_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_NIGHT_LAMP_BRIGHTNESS;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_NIGHT_LAMP_STEPLESS_BRIGHTNESS;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_NIGHT_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_OSCILLATION_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_OSCILLATION_STATE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_PANEL_DISPLAY_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_SENSOR_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_SMART_SUBMODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_STANDBY;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_TARE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_TEMPERATURE_UNIT;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_TIMER_DURATION;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_TIMER_STATUS;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_USE_24_HOUR;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_WICK_DRY_DURATION;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_WICK_DRY_ENABLED;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_WICK_DRY_ON;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_YWRM_ENABLED;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$STOP_ALARM;", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public abstract static class DeviceSettingEvent extends AnalyticEvent {
      private DeviceSettingEvent(String var1, Object var2) {
         super("device_setting", MapsKt.mapOf(new Pair[]{TuplesKt.to("setting", var1), TuplesKt.to("value", var2)}), (DefaultConstructorMarker)null);
      }

      // $FF: synthetic method
      public DeviceSettingEvent(String var1, Object var2, DefaultConstructorMarker var3) {
         this(var1, var2);
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$CALIBRATE_OSCILLATION_POSITION;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class CALIBRATE_OSCILLATION_POSITION extends DeviceSettingEvent {
         public CALIBRATE_OSCILLATION_POSITION(int var1) {
            super("calibration", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$PLAY_ALARM;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "sound", "", "volume", "<init>", "(II)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class PLAY_ALARM extends DeviceSettingEvent {
         public PLAY_ALARM(int var1, int var2) {
            StringBuilder var3 = new StringBuilder();
            var3.append(var1);
            var3.append('_');
            var3.append(var2);
            super("alarmpreview", var3.toString(), (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_AIR_REFRESH_ENABLED;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(Z)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_AIR_REFRESH_ENABLED extends DeviceSettingEvent {
         public SET_AIR_REFRESH_ENABLED(boolean var1) {
            super("airrefresh", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_AIR_REFRESH_STATUS;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_AIR_REFRESH_STATUS extends DeviceSettingEvent {
         public SET_AIR_REFRESH_STATUS(int var1) {
            super("arstate", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_ALARM;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "index", "", "<init>", "(I)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_ALARM extends DeviceSettingEvent {
         public SET_ALARM(int var1) {
            StringBuilder var2 = new StringBuilder("alarm");
            var2.append(var1);
            super(var2.toString(), "", (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_AP_FANSPEED;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_AP_FANSPEED extends DeviceSettingEvent {
         public SET_AP_FANSPEED(int var1) {
            super("fsp0", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_AP_SUBMODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_AP_SUBMODE extends DeviceSettingEvent {
         public SET_AP_SUBMODE(int var1) {
            super("apsubmode", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_AUTO_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(Z)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_AUTO_MODE extends DeviceSettingEvent {
         public SET_AUTO_MODE(boolean var1) {
            super("automode", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_AUTO_RH;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_AUTO_RH extends DeviceSettingEvent {
         public SET_AUTO_RH(int var1) {
            super("autorh", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_BRIGHTNESS;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_BRIGHTNESS extends DeviceSettingEvent {
         public SET_BRIGHTNESS(int var1) {
            super("brightness", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_CHILD_LOCK;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(Z)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_CHILD_LOCK extends DeviceSettingEvent {
         public SET_CHILD_LOCK(boolean var1) {
            super("childlock", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_COOL_AUTO_LEVEL;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_COOL_AUTO_LEVEL extends DeviceSettingEvent {
         public SET_COOL_AUTO_LEVEL(int var1) {
            super("coolauto", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_COOL_FANSPEED;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_COOL_FANSPEED extends DeviceSettingEvent {
         public SET_COOL_FANSPEED(int var1) {
            super("coolfs", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_COOL_FANSPEED_LEVEL;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_COOL_FANSPEED_LEVEL extends DeviceSettingEvent {
         public SET_COOL_FANSPEED_LEVEL(int var1) {
            super("coolfslevel", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_COOL_SUBMODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_COOL_SUBMODE extends DeviceSettingEvent {
         public SET_COOL_SUBMODE(int var1) {
            super("coolsubmode", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_DEH_SUBMODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_DEH_SUBMODE extends DeviceSettingEvent {
         public SET_DEH_SUBMODE(int var1) {
            super("dehsubmode", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_DISINFECTION;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(Z)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_DISINFECTION extends DeviceSettingEvent {
         public SET_DISINFECTION(boolean var1) {
            super("disinfection", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_DUAL_OSCILLATION_STATE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "horizontal", "", "value", "", "<init>", "(ZI)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_DUAL_OSCILLATION_STATE extends DeviceSettingEvent {
         public SET_DUAL_OSCILLATION_STATE(boolean var1, int var2) {
            String var3;
            if (var1) {
               var3 = "oscstateh";
            } else {
               var3 = "oscstatev";
            }

            super(var3, var2, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_ECO;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(Z)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_ECO extends DeviceSettingEvent {
         public SET_ECO(boolean var1) {
            super("eco", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_FAN_SPEED;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_FAN_SPEED extends DeviceSettingEvent {
         public SET_FAN_SPEED(int var1) {
            super("fanspeed", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_GERM_SHIELD;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(Z)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_GERM_SHIELD extends DeviceSettingEvent {
         public SET_GERM_SHIELD(boolean var1) {
            super("germshield", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_GERM_SHIELD_NIGHT_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(Z)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_GERM_SHIELD_NIGHT_MODE extends DeviceSettingEvent {
         public SET_GERM_SHIELD_NIGHT_MODE(boolean var1) {
            super("gsnm", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_HEAT_AUTO_TMP;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(D)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_HEAT_AUTO_TMP extends DeviceSettingEvent {
         public SET_HEAT_AUTO_TMP(double var1) {
            super("heattemp", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_HEAT_ECO_TMP;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(D)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_HEAT_ECO_TMP extends DeviceSettingEvent {
         public SET_HEAT_ECO_TMP(double var1) {
            super("ecoheattemp", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_HEAT_FANSPEED;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_HEAT_FANSPEED extends DeviceSettingEvent {
         public SET_HEAT_FANSPEED(int var1) {
            super("heatfs", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_HEAT_SUBMODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_HEAT_SUBMODE extends DeviceSettingEvent {
         public SET_HEAT_SUBMODE(int var1) {
            super("heatsubmode", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_HINS_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(Z)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_HINS_MODE extends DeviceSettingEvent {
         public SET_HINS_MODE(boolean var1) {
            super("hins", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_HINS_NIGHT_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(Z)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_HINS_NIGHT_MODE extends DeviceSettingEvent {
         public SET_HINS_NIGHT_MODE(boolean var1) {
            super("nmhins", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_HOVER_ENABLED;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(Z)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_HOVER_ENABLED extends DeviceSettingEvent {
         public SET_HOVER_ENABLED(boolean var1) {
            super("hover", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_HUM_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(Z)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_HUM_MODE extends DeviceSettingEvent {
         public SET_HUM_MODE(boolean var1) {
            super("hummode", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_HUM_SUBMODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_HUM_SUBMODE extends DeviceSettingEvent {
         public SET_HUM_SUBMODE(int var1) {
            super("humsubmode", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_MAIN_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_MAIN_MODE extends DeviceSettingEvent {
         public SET_MAIN_MODE(int var1) {
            super("mainmode", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_MODE extends DeviceSettingEvent {
         public SET_MODE(int var1) {
            super("mode", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_NIGHT_LAMP_BRIGHTNESS;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_NIGHT_LAMP_BRIGHTNESS extends DeviceSettingEvent {
         public SET_NIGHT_LAMP_BRIGHTNESS(int var1) {
            super("nlbrightness", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_NIGHT_LAMP_STEPLESS_BRIGHTNESS;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_NIGHT_LAMP_STEPLESS_BRIGHTNESS extends DeviceSettingEvent {
         public SET_NIGHT_LAMP_STEPLESS_BRIGHTNESS(int var1) {
            super("nlstepless", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_NIGHT_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(Z)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_NIGHT_MODE extends DeviceSettingEvent {
         public SET_NIGHT_MODE(boolean var1) {
            super("nightmode", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_OSCILLATION_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_OSCILLATION_MODE extends DeviceSettingEvent {
         public SET_OSCILLATION_MODE(int var1) {
            super("oscmode", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_OSCILLATION_STATE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_OSCILLATION_STATE extends DeviceSettingEvent {
         public SET_OSCILLATION_STATE(int var1) {
            super("oscstate", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_PANEL_DISPLAY_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_PANEL_DISPLAY_MODE extends DeviceSettingEvent {
         public SET_PANEL_DISPLAY_MODE(int var1) {
            super("displaymode", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_SENSOR_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_SENSOR_MODE extends DeviceSettingEvent {
         public SET_SENSOR_MODE(int var1) {
            super("sensormode", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_SMART_SUBMODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_SMART_SUBMODE extends DeviceSettingEvent {
         public SET_SMART_SUBMODE(int var1) {
            super("smartsubmode", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_STANDBY;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(Z)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_STANDBY extends DeviceSettingEvent {
         public SET_STANDBY(boolean var1) {
            super("standby", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_TARE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "<init>", "()V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_TARE extends DeviceSettingEvent {
         public static final SET_TARE INSTANCE = new SET_TARE();

         private SET_TARE() {
            super("nw", 1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_TEMPERATURE_UNIT;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_TEMPERATURE_UNIT extends DeviceSettingEvent {
         public SET_TEMPERATURE_UNIT(int var1) {
            super("tu", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_TIMER_DURATION;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_TIMER_DURATION extends DeviceSettingEvent {
         public SET_TIMER_DURATION(int var1) {
            super("timdur", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_TIMER_STATUS;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_TIMER_STATUS extends DeviceSettingEvent {
         public SET_TIMER_STATUS(int var1) {
            super("timstate", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_USE_24_HOUR;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(Z)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_USE_24_HOUR extends DeviceSettingEvent {
         public SET_USE_24_HOUR(boolean var1) {
            super("hourformat", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_WICK_DRY_DURATION;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_WICK_DRY_DURATION extends DeviceSettingEvent {
         public SET_WICK_DRY_DURATION(int var1) {
            super("wickdrydur", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_WICK_DRY_ENABLED;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(Z)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_WICK_DRY_ENABLED extends DeviceSettingEvent {
         public SET_WICK_DRY_ENABLED(boolean var1) {
            super("wickdrye", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_WICK_DRY_ON;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(Z)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_WICK_DRY_ON extends DeviceSettingEvent {
         public SET_WICK_DRY_ON(boolean var1) {
            super("wickdrys", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_YWRM_ENABLED;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(Z)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SET_YWRM_ENABLED extends DeviceSettingEvent {
         public SET_YWRM_ENABLED(boolean var1) {
            super("wickdrydur", var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$STOP_ALARM;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "<init>", "()V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class STOP_ALARM extends DeviceSettingEvent {
         public static final STOP_ALARM INSTANCE = new STOP_ALARM();

         private STOP_ALARM() {
            super("alarmstop", 1, (DefaultConstructorMarker)null);
         }
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/AnalyticEvent$ENABLE_GPS_LOCATION;", "Lcom/blueair/core/model/AnalyticEvent;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class ENABLE_GPS_LOCATION extends AnalyticEvent {
      public ENABLE_GPS_LOCATION() {
         super("enabled_gps_location", MapsKt.emptyMap(), (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u000f\u0010\u0011\u0012\u0013BA\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000e\u0082\u0001\u0005\u0014\u0015\u0016\u0017\u0018¨\u0006\u0019"},
      d2 = {"Lcom/blueair/core/model/AnalyticEvent$FilterClickEvent;", "Lcom/blueair/core/model/AnalyticEvent;", "eventName", "", "clickTime", "", "filterType", "Lcom/blueair/core/model/DeviceFilterType;", "filterName", "device", "Lcom/blueair/core/model/Device;", "userId", "userRegion", "<init>", "(Ljava/lang/String;JLcom/blueair/core/model/DeviceFilterType;Ljava/lang/String;Lcom/blueair/core/model/Device;Ljava/lang/String;Ljava/lang/String;)V", "FilterCLickPurchase", "FilterCLickSubscribe", "OnboardingFilterCLickSubscribe", "HomepageFilterClickPurchase", "HomepageFilterClickSubscribe", "Lcom/blueair/core/model/AnalyticEvent$FilterClickEvent$FilterCLickPurchase;", "Lcom/blueair/core/model/AnalyticEvent$FilterClickEvent$FilterCLickSubscribe;", "Lcom/blueair/core/model/AnalyticEvent$FilterClickEvent$HomepageFilterClickPurchase;", "Lcom/blueair/core/model/AnalyticEvent$FilterClickEvent$HomepageFilterClickSubscribe;", "Lcom/blueair/core/model/AnalyticEvent$FilterClickEvent$OnboardingFilterCLickSubscribe;", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public abstract static class FilterClickEvent extends AnalyticEvent {
      private FilterClickEvent(String var1, long var2, DeviceFilterType var4, String var5, Device var6, String var7, String var8) {
         Map var15 = (Map)(new LinkedHashMap());
         var15.put("click_time", var2);
         var15.put("device_model", var6.getModelName());
         var15.put("device_uuid", var6.getUid());
         String var14 = DeviceKt.getSkuCompat(var6);
         String var13 = var14;
         if (var14 == null) {
            var13 = "";
         }

         var15.put("device_sku", var13);
         var15.put("device_mcu_firmware", var6.getMcuFirmware());
         int var10 = Device$_CC.getTimezone$default(var6, (Context)null, 1, (Object)null).getRawOffset();
         char var9;
         if (var10 >= 0) {
            var9 = '+';
         } else {
            var9 = '-';
         }

         long var11 = (long)Math.abs(var10);
         var2 = TimeUnit.MILLISECONDS.toHours(var11);
         var11 = TimeUnit.MILLISECONDS.toMinutes(var11 - (long)3600000 * var2);
         StringBuilder var23 = new StringBuilder();
         var23.append(var9);
         var23.append(var2);
         var23.append(":%02d");
         String var24 = String.format(var23.toString(), Arrays.copyOf(new Object[]{var11}, 1));
         Intrinsics.checkNotNullExpressionValue(var24, "format(...)");
         var15.put("device_timezone", var24);
         var10 = AnalyticEvent.FilterClickEvent.WhenMappings.$EnumSwitchMapping$0[var4.ordinal()];
         if (var10 != 1) {
            if (var10 != 2) {
               if (var10 != 3) {
                  throw new NoWhenBranchMatchedException();
               }

               var24 = "refresher";
            } else {
               var24 = "wick";
            }
         } else {
            var24 = "filter";
         }

         var15.put("device_filter_type", var24);
         var10 = AnalyticEvent.FilterClickEvent.WhenMappings.$EnumSwitchMapping$0[var4.ordinal()];
         if (var10 != 1) {
            if (var10 != 2) {
               if (var10 != 3) {
                  throw new NoWhenBranchMatchedException();
               }

               Intrinsics.checkNotNull(var6, "null cannot be cast to non-null type com.blueair.core.model.HasRemoveYellowWater");
               var10 = ((HasRemoveYellowWater)var6).getRefresherLifeLeft();
            } else {
               Intrinsics.checkNotNull(var6, "null cannot be cast to non-null type com.blueair.core.model.HasWick");
               var10 = RangesKt.coerceIn(100 - ((HasWick)var6).getWickUsage(), 0, 100);
            }
         } else {
            var10 = DeviceKt.getFilterLifeTime(var6).getFilterLife();
         }

         var15.put("device_filter_left_life", var10);
         if (((CharSequence)var5).length() > 0) {
            var15.put("filter_name", var5);
         }

         var15.put("user_id", var7);
         var15.put("user_region", var8);
         var15.put("phone_os", "android");
         String var17 = Build.MODEL;
         Intrinsics.checkNotNullExpressionValue(var17, "MODEL");
         var15.put("phone_device", var17);
         Unit var18 = Unit.INSTANCE;
         super(var1, var15, (DefaultConstructorMarker)null);
      }

      // $FF: synthetic method
      public FilterClickEvent(String var1, long var2, DeviceFilterType var4, String var5, Device var6, String var7, String var8, DefaultConstructorMarker var9) {
         this(var1, var2, var4, var5, var6, var7, var8);
      }

      @Metadata(
         d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$FilterClickEvent$FilterCLickPurchase;", "Lcom/blueair/core/model/AnalyticEvent$FilterClickEvent;", "clickTime", "", "filterType", "Lcom/blueair/core/model/DeviceFilterType;", "filterName", "", "device", "Lcom/blueair/core/model/Device;", "userId", "userRegion", "<init>", "(JLcom/blueair/core/model/DeviceFilterType;Ljava/lang/String;Lcom/blueair/core/model/Device;Ljava/lang/String;Ljava/lang/String;)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class FilterCLickPurchase extends FilterClickEvent {
         public FilterCLickPurchase(long var1, DeviceFilterType var3, String var4, Device var5, String var6, String var7) {
            Intrinsics.checkNotNullParameter(var3, "filterType");
            Intrinsics.checkNotNullParameter(var4, "filterName");
            Intrinsics.checkNotNullParameter(var5, "device");
            Intrinsics.checkNotNullParameter(var6, "userId");
            Intrinsics.checkNotNullParameter(var7, "userRegion");
            super("purchase_filter_click", var1, var3, var4, var5, var6, var7, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$FilterClickEvent$FilterCLickSubscribe;", "Lcom/blueair/core/model/AnalyticEvent$FilterClickEvent;", "clickTime", "", "filterType", "Lcom/blueair/core/model/DeviceFilterType;", "filterName", "", "device", "Lcom/blueair/core/model/Device;", "userId", "userRegion", "<init>", "(JLcom/blueair/core/model/DeviceFilterType;Ljava/lang/String;Lcom/blueair/core/model/Device;Ljava/lang/String;Ljava/lang/String;)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class FilterCLickSubscribe extends FilterClickEvent {
         public FilterCLickSubscribe(long var1, DeviceFilterType var3, String var4, Device var5, String var6, String var7) {
            Intrinsics.checkNotNullParameter(var3, "filterType");
            Intrinsics.checkNotNullParameter(var4, "filterName");
            Intrinsics.checkNotNullParameter(var5, "device");
            Intrinsics.checkNotNullParameter(var6, "userId");
            Intrinsics.checkNotNullParameter(var7, "userRegion");
            super("subscribe_filter_click", var1, var3, var4, var5, var6, var7, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$FilterClickEvent$HomepageFilterClickPurchase;", "Lcom/blueair/core/model/AnalyticEvent$FilterClickEvent;", "clickTime", "", "filterType", "Lcom/blueair/core/model/DeviceFilterType;", "filterName", "", "device", "Lcom/blueair/core/model/Device;", "userId", "userRegion", "<init>", "(JLcom/blueair/core/model/DeviceFilterType;Ljava/lang/String;Lcom/blueair/core/model/Device;Ljava/lang/String;Ljava/lang/String;)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class HomepageFilterClickPurchase extends FilterClickEvent {
         public HomepageFilterClickPurchase(long var1, DeviceFilterType var3, String var4, Device var5, String var6, String var7) {
            Intrinsics.checkNotNullParameter(var3, "filterType");
            Intrinsics.checkNotNullParameter(var4, "filterName");
            Intrinsics.checkNotNullParameter(var5, "device");
            Intrinsics.checkNotNullParameter(var6, "userId");
            Intrinsics.checkNotNullParameter(var7, "userRegion");
            super("purchase_filter_homepage_click", var1, var3, var4, var5, var6, var7, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$FilterClickEvent$HomepageFilterClickSubscribe;", "Lcom/blueair/core/model/AnalyticEvent$FilterClickEvent;", "clickTime", "", "filterType", "Lcom/blueair/core/model/DeviceFilterType;", "filterName", "", "device", "Lcom/blueair/core/model/Device;", "userId", "userRegion", "<init>", "(JLcom/blueair/core/model/DeviceFilterType;Ljava/lang/String;Lcom/blueair/core/model/Device;Ljava/lang/String;Ljava/lang/String;)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class HomepageFilterClickSubscribe extends FilterClickEvent {
         public HomepageFilterClickSubscribe(long var1, DeviceFilterType var3, String var4, Device var5, String var6, String var7) {
            Intrinsics.checkNotNullParameter(var3, "filterType");
            Intrinsics.checkNotNullParameter(var4, "filterName");
            Intrinsics.checkNotNullParameter(var5, "device");
            Intrinsics.checkNotNullParameter(var6, "userId");
            Intrinsics.checkNotNullParameter(var7, "userRegion");
            super("subscribe_filter_homepage_click", var1, var3, var4, var5, var6, var7, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$FilterClickEvent$OnboardingFilterCLickSubscribe;", "Lcom/blueair/core/model/AnalyticEvent$FilterClickEvent;", "clickTime", "", "filterType", "Lcom/blueair/core/model/DeviceFilterType;", "filterName", "", "device", "Lcom/blueair/core/model/Device;", "userId", "userRegion", "<init>", "(JLcom/blueair/core/model/DeviceFilterType;Ljava/lang/String;Lcom/blueair/core/model/Device;Ljava/lang/String;Ljava/lang/String;)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class OnboardingFilterCLickSubscribe extends FilterClickEvent {
         public OnboardingFilterCLickSubscribe(long var1, DeviceFilterType var3, String var4, Device var5, String var6, String var7) {
            Intrinsics.checkNotNullParameter(var3, "filterType");
            Intrinsics.checkNotNullParameter(var4, "filterName");
            Intrinsics.checkNotNullParameter(var5, "device");
            Intrinsics.checkNotNullParameter(var6, "userId");
            Intrinsics.checkNotNullParameter(var7, "userRegion");
            super("subscribe_filter_onboarding_click", var1, var3, var4, var5, var6, var7, (DefaultConstructorMarker)null);
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
            int[] var0 = new int[DeviceFilterType.values().length];

            try {
               var0[DeviceFilterType.FILTER.ordinal()] = 1;
            } catch (NoSuchFieldError var4) {
            }

            try {
               var0[DeviceFilterType.WICK.ordinal()] = 2;
            } catch (NoSuchFieldError var3) {
            }

            try {
               var0[DeviceFilterType.REFRESHER.ordinal()] = 3;
            } catch (NoSuchFieldError var2) {
            }

            $EnumSwitchMapping$0 = var0;
         }
      }
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/core/model/AnalyticEvent$ForgotPasswordEvent;", "Lcom/blueair/core/model/AnalyticEvent;", "success", "", "errorMessage", "", "<init>", "(ZLjava/lang/String;)V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class ForgotPasswordEvent extends AnalyticEvent {
      public ForgotPasswordEvent(boolean var1, String var2) {
         Intrinsics.checkNotNullParameter(var2, "errorMessage");
         super("forgot_password", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("success", var1), TuplesKt.to("error_message", var2)}), (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"},
      d2 = {"Lcom/blueair/core/model/AnalyticEvent$GigyaCloudRegionMismatchEvent;", "Lcom/blueair/core/model/AnalyticEvent;", "gigyaUid", "", "fromRegion", "toRegion", "cause", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class GigyaCloudRegionMismatchEvent extends AnalyticEvent {
      public GigyaCloudRegionMismatchEvent(String var1, String var2, String var3, String var4) {
         Intrinsics.checkNotNullParameter(var1, "gigyaUid");
         Intrinsics.checkNotNullParameter(var2, "fromRegion");
         Intrinsics.checkNotNullParameter(var3, "toRegion");
         Intrinsics.checkNotNullParameter(var4, "cause");
         super("cloud_region_mismatch", MapsKt.mapOf(new Pair[]{TuplesKt.to("gigyaUid", var1), TuplesKt.to("fromRegion", var2), TuplesKt.to("toRegion", var3), TuplesKt.to("cause", var4), TuplesKt.to("platform", "android"), TuplesKt.to("time", System.currentTimeMillis())}), (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/core/model/AnalyticEvent$GigyaErrorEvent;", "Lcom/blueair/core/model/AnalyticEvent;", "api", "", "errorCode", "errorMessage", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class GigyaErrorEvent extends AnalyticEvent {
      public GigyaErrorEvent(String var1, String var2, String var3) {
         Intrinsics.checkNotNullParameter(var1, "api");
         Intrinsics.checkNotNullParameter(var2, "errorCode");
         Intrinsics.checkNotNullParameter(var3, "errorMessage");
         super("gigya_error", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("api", var1), TuplesKt.to("error_code", var2), TuplesKt.to("error_message", var3)}), (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\t¨\u0006\n"},
      d2 = {"Lcom/blueair/core/model/AnalyticEvent$GigyaGetAccountErrorEvent;", "Lcom/blueair/core/model/AnalyticEvent;", "gigyaUid", "", "gigyaRegion", "errorCode", "errorMessage", "errorData", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class GigyaGetAccountErrorEvent extends AnalyticEvent {
      public GigyaGetAccountErrorEvent(String var1, String var2, String var3, String var4, String var5) {
         Intrinsics.checkNotNullParameter(var1, "gigyaUid");
         Intrinsics.checkNotNullParameter(var2, "gigyaRegion");
         Intrinsics.checkNotNullParameter(var3, "errorCode");
         Intrinsics.checkNotNullParameter(var4, "errorMessage");
         Intrinsics.checkNotNullParameter(var5, "errorData");
         super("gigya_get_account_error", MapsKt.mapOf(new Pair[]{TuplesKt.to("gigyaUid", var1), TuplesKt.to("gigyaRegion", var2), TuplesKt.to("errorCode", var3), TuplesKt.to("errorMessage", var4), TuplesKt.to("errorData", var5), TuplesKt.to("platform", "android"), TuplesKt.to("time", System.currentTimeMillis())}), (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\f\rB;\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000b\u0082\u0001\u0002\u000e\u000f¨\u0006\u0010"},
      d2 = {"Lcom/blueair/core/model/AnalyticEvent$KlaviyoEvent;", "Lcom/blueair/core/model/AnalyticEvent;", "eventName", "", "deeplink", "path", "type", "action", "device", "Lcom/blueair/core/model/Device;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/Device;)V", "Receive", "Click", "Lcom/blueair/core/model/AnalyticEvent$KlaviyoEvent$Click;", "Lcom/blueair/core/model/AnalyticEvent$KlaviyoEvent$Receive;", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public abstract static class KlaviyoEvent extends AnalyticEvent {
      private KlaviyoEvent(String var1, String var2, String var3, String var4, String var5, Device var6) {
         Map var8 = (Map)(new LinkedHashMap());
         var8.put("deeplink", var2);
         var8.put("deeplink_path", var3);
         var8.put("deeplink_type", var4);
         var8.put("deeplink_action", var5);
         if (var6 != null) {
            var8.put("device_model", var6.getModelName());
            var8.put("device_uuid", var6.getUid());
            HasSKU var9;
            if (var6 instanceof HasSKU) {
               var9 = (HasSKU)var6;
            } else {
               var9 = null;
            }

            if (var9 != null) {
               var4 = var9.getSku();
               var3 = var4;
               if (var4 == null) {
                  var3 = "";
               }

               var8.put("device_sku", var3);
               var8.put("device_serial", var9.getSerial());
            }

            var8.put("device_mac", var6.getMac());
            var8.put("device_mcu_firmware", var6.getMcuFirmware());
            var8.put("device_wifi_firmware", var6.getWifiFirmware());
            var8.put("device_timezone", var6.getTimeZone());
            HasFanSpeed var10;
            if (var6 instanceof HasFanSpeed) {
               var10 = (HasFanSpeed)var6;
            } else {
               var10 = null;
            }

            int var7;
            label28: {
               if (var10 != null) {
                  Integer var11 = var10.getFilterLife();
                  if (var11 != null) {
                     var7 = var11;
                     break label28;
                  }
               }

               var7 = 0;
            }

            var8.put("device_filter_life", var7);
            var8.put("device_status", var6.getConnectivityStatus().name());
         }

         Unit var12 = Unit.INSTANCE;
         super(var1, var8, (DefaultConstructorMarker)null);
      }

      // $FF: synthetic method
      public KlaviyoEvent(String var1, String var2, String var3, String var4, String var5, Device var6, DefaultConstructorMarker var7) {
         this(var1, var2, var3, var4, var5, var6);
      }

      @Metadata(
         d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$KlaviyoEvent$Click;", "Lcom/blueair/core/model/AnalyticEvent$KlaviyoEvent;", "deeplink", "", "path", "type", "action", "device", "Lcom/blueair/core/model/Device;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/Device;)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class Click extends KlaviyoEvent {
         public Click(String var1, String var2, String var3, String var4, Device var5) {
            Intrinsics.checkNotNullParameter(var1, "deeplink");
            Intrinsics.checkNotNullParameter(var2, "path");
            Intrinsics.checkNotNullParameter(var3, "type");
            Intrinsics.checkNotNullParameter(var4, "action");
            super("notification_click", var1, var2, var3, var4, var5, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$KlaviyoEvent$Receive;", "Lcom/blueair/core/model/AnalyticEvent$KlaviyoEvent;", "deeplink", "", "path", "type", "action", "device", "Lcom/blueair/core/model/Device;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/Device;)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class Receive extends KlaviyoEvent {
         public Receive(String var1, String var2, String var3, String var4, Device var5) {
            Intrinsics.checkNotNullParameter(var1, "deeplink");
            Intrinsics.checkNotNullParameter(var2, "path");
            Intrinsics.checkNotNullParameter(var3, "type");
            Intrinsics.checkNotNullParameter(var4, "action");
            super("notification_received", var1, var2, var3, var4, var5, (DefaultConstructorMarker)null);
         }
      }
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/core/model/AnalyticEvent$LogoutEvent;", "Lcom/blueair/core/model/AnalyticEvent;", "reason", "", "<init>", "(Ljava/lang/String;)V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class LogoutEvent extends AnalyticEvent {
      public LogoutEvent(String var1) {
         Intrinsics.checkNotNullParameter(var1, "reason");
         super("logout", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("reason", var1)}), (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/AnalyticEvent$OPEN_FAN_HISTORY;", "Lcom/blueair/core/model/AnalyticEvent;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class OPEN_FAN_HISTORY extends AnalyticEvent {
      public OPEN_FAN_HISTORY() {
         super("opened_fan_history", MapsKt.emptyMap(), (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \r2\u00020\u0001:\b\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014B=\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\f\u0082\u0001\u0007\u0015\u0016\u0017\u0018\u0019\u001a\u001b¨\u0006\u001c"},
      d2 = {"Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent;", "Lcom/blueair/core/model/AnalyticEvent;", "uuid", "", "step", "", "screen", "extra", "payload", "", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "Companion", "ScreenStayEvent", "SelectDevice", "ConnectInstructions", "Connecting", "WifiList", "WifiPassword", "Onboarding", "Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent$ConnectInstructions;", "Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent$Connecting;", "Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent$Onboarding;", "Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent$ScreenStayEvent;", "Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent$SelectDevice;", "Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent$WifiList;", "Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent$WifiPassword;", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public abstract static class OnboardingLogEvent extends AnalyticEvent {
      public static final String CONNECT_TYPE_DETECT = "detect";
      public static final String CONNECT_TYPE_FORCE = "force";
      public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
      public static final String PAIR_BTN_AUTO = "auto";
      public static final String PAIR_BTN_FAN = "fan";
      public static final String RESULT_FAILED = "failed";
      public static final String RESULT_SUCCESS = "success";
      public static final String TYPE_NULL = "null";
      public static final String UNKNOWN = "unknown";

      private OnboardingLogEvent(String var1, int var2, String var3, String var4, Map var5) {
         var5 = MapsKt.toMutableMap(var5);
         var5.put("session_uuid", var1);
         var5.put("step", var2);
         var5.put("screen", var3);
         var5.put("extra", var4);
         Unit var6 = Unit.INSTANCE;
         super("onboarding_log", var5, (DefaultConstructorMarker)null);
      }

      // $FF: synthetic method
      public OnboardingLogEvent(String var1, int var2, String var3, String var4, Map var5, DefaultConstructorMarker var6) {
         this(var1, var2, var3, var4, var5);
      }

      @Metadata(
         d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent$Companion;", "", "<init>", "()V", "RESULT_SUCCESS", "", "RESULT_FAILED", "UNKNOWN", "TYPE_NULL", "PAIR_BTN_AUTO", "PAIR_BTN_FAN", "CONNECT_TYPE_DETECT", "CONNECT_TYPE_FORCE", "core_otherRelease"},
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
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent$ConnectInstructions;", "Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent;", "uuid", "", "pairBtn", "connectType", "extra", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class ConnectInstructions extends OnboardingLogEvent {
         public ConnectInstructions(String var1, String var2, String var3, String var4) {
            Intrinsics.checkNotNullParameter(var1, "uuid");
            Intrinsics.checkNotNullParameter(var2, "pairBtn");
            Intrinsics.checkNotNullParameter(var3, "connectType");
            Intrinsics.checkNotNullParameter(var4, "extra");
            super(var1, 1, "connect_instructions", var4, MapsKt.mapOf(new Pair[]{TuplesKt.to("pair_btn", var2), TuplesKt.to("connect_type", var3)}), (DefaultConstructorMarker)null);
         }

         // $FF: synthetic method
         public ConnectInstructions(String var1, String var2, String var3, String var4, int var5, DefaultConstructorMarker var6) {
            if ((var5 & 8) != 0) {
               var4 = "";
            }

            this(var1, var2, var3, var4);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent$Connecting;", "Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent;", "uuid", "", "bleEstablishSession", "bleStartProvision", "extra", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class Connecting extends OnboardingLogEvent {
         public Connecting(String var1, String var2, String var3, String var4) {
            Intrinsics.checkNotNullParameter(var1, "uuid");
            Intrinsics.checkNotNullParameter(var2, "bleEstablishSession");
            Intrinsics.checkNotNullParameter(var3, "bleStartProvision");
            Intrinsics.checkNotNullParameter(var4, "extra");
            super(var1, 2, "connecting", var4, MapsKt.mapOf(new Pair[]{TuplesKt.to("ble_establish_session", var2), TuplesKt.to("ble_start_provision", var3)}), (DefaultConstructorMarker)null);
         }

         // $FF: synthetic method
         public Connecting(String var1, String var2, String var3, String var4, int var5, DefaultConstructorMarker var6) {
            if ((var5 & 8) != 0) {
               var4 = "";
            }

            this(var1, var2, var3, var4);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent$Onboarding;", "Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent;", "uuid", "", "blePollDeviceBound", "extra", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class Onboarding extends OnboardingLogEvent {
         public Onboarding(String var1, String var2, String var3) {
            Intrinsics.checkNotNullParameter(var1, "uuid");
            Intrinsics.checkNotNullParameter(var2, "blePollDeviceBound");
            Intrinsics.checkNotNullParameter(var3, "extra");
            super(var1, 5, "onboarding", var3, MapsKt.mapOf(TuplesKt.to("ble_poll_device_bound", var2)), (DefaultConstructorMarker)null);
         }

         // $FF: synthetic method
         public Onboarding(String var1, String var2, String var3, int var4, DefaultConstructorMarker var5) {
            if ((var4 & 4) != 0) {
               var3 = "";
            }

            this(var1, var2, var3);
         }
      }

      @Metadata(
         d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\t¨\u0006\n"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent$ScreenStayEvent;", "Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent;", "uuid", "", "screen", "time", "", "extra", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class ScreenStayEvent extends OnboardingLogEvent {
         public ScreenStayEvent(String var1, String var2, int var3, String var4) {
            Intrinsics.checkNotNullParameter(var1, "uuid");
            Intrinsics.checkNotNullParameter(var2, "screen");
            Intrinsics.checkNotNullParameter(var4, "extra");
            super(var1, -1, var2, var4, MapsKt.mapOf(TuplesKt.to("time", var3)), (DefaultConstructorMarker)null);
         }

         // $FF: synthetic method
         public ScreenStayEvent(String var1, String var2, int var3, String var4, int var5, DefaultConstructorMarker var6) {
            if ((var5 & 8) != 0) {
               var4 = "";
            }

            this(var1, var2, var3, var4);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent$SelectDevice;", "Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent;", "uuid", "", "sku", "mac", "family", "model", "extra", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SelectDevice extends OnboardingLogEvent {
         public SelectDevice(String var1, String var2, String var3, String var4, String var5, String var6) {
            Intrinsics.checkNotNullParameter(var1, "uuid");
            Intrinsics.checkNotNullParameter(var2, "sku");
            Intrinsics.checkNotNullParameter(var3, "mac");
            Intrinsics.checkNotNullParameter(var4, "family");
            Intrinsics.checkNotNullParameter(var5, "model");
            Intrinsics.checkNotNullParameter(var6, "extra");
            super(var1, 0, "select_device", var6, MapsKt.mapOf(new Pair[]{TuplesKt.to("sku", var2), TuplesKt.to("mac", var3), TuplesKt.to("family", var4), TuplesKt.to("model", var5)}), (DefaultConstructorMarker)null);
         }

         // $FF: synthetic method
         public SelectDevice(String var1, String var2, String var3, String var4, String var5, String var6, int var7, DefaultConstructorMarker var8) {
            if ((var7 & 32) != 0) {
               var6 = "";
            }

            this(var1, var2, var3, var4, var5, var6);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\t¨\u0006\n"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent$WifiList;", "Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent;", "uuid", "", "refreshCount", "", "ssidCount", "extra", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class WifiList extends OnboardingLogEvent {
         public WifiList(String var1, int var2, int var3, String var4) {
            Intrinsics.checkNotNullParameter(var1, "uuid");
            Intrinsics.checkNotNullParameter(var4, "extra");
            super(var1, 3, "wifi_list", var4, MapsKt.mapOf(new Pair[]{TuplesKt.to("refresh_count", var2), TuplesKt.to("ssid_count", var3)}), (DefaultConstructorMarker)null);
         }

         // $FF: synthetic method
         public WifiList(String var1, int var2, int var3, String var4, int var5, DefaultConstructorMarker var6) {
            if ((var5 & 8) != 0) {
               var4 = "";
            }

            this(var1, var2, var3, var4);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent$WifiPassword;", "Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent;", "uuid", "", "cloudRegion", "registerForOnboarding", "bleConfigProvision", "bleConfigWifi", "bleApplyWifi", "blePollWifiConnected", "extra", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "core_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class WifiPassword extends OnboardingLogEvent {
         public WifiPassword(String var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8) {
            Intrinsics.checkNotNullParameter(var1, "uuid");
            Intrinsics.checkNotNullParameter(var2, "cloudRegion");
            Intrinsics.checkNotNullParameter(var3, "registerForOnboarding");
            Intrinsics.checkNotNullParameter(var4, "bleConfigProvision");
            Intrinsics.checkNotNullParameter(var5, "bleConfigWifi");
            Intrinsics.checkNotNullParameter(var6, "bleApplyWifi");
            Intrinsics.checkNotNullParameter(var7, "blePollWifiConnected");
            Intrinsics.checkNotNullParameter(var8, "extra");
            super(var1, 4, "wifi_password", var8, MapsKt.mapOf(new Pair[]{TuplesKt.to("cloud_region", var2), TuplesKt.to("register_for_onboarding", var3), TuplesKt.to("ble_config_provision", var4), TuplesKt.to("ble_config_wifi", var5), TuplesKt.to("ble_apply_wifi", var6), TuplesKt.to("ble_poll_wifi_connected", var7)}), (DefaultConstructorMarker)null);
         }

         // $FF: synthetic method
         public WifiPassword(String var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, int var9, DefaultConstructorMarker var10) {
            if ((var9 & 128) != 0) {
               var8 = "";
            }

            this(var1, var2, var3, var4, var5, var6, var7, var8);
         }
      }
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/core/model/AnalyticEvent$REFRESH_GIGYA_JWT;", "Lcom/blueair/core/model/AnalyticEvent;", "gsResponseText", "", "<init>", "(Ljava/lang/String;)V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class REFRESH_GIGYA_JWT extends AnalyticEvent {
      public REFRESH_GIGYA_JWT(String var1) {
         Intrinsics.checkNotNullParameter(var1, "gsResponseText");
         super("refresh_gigya_jwt", MapsKt.mapOf(TuplesKt.to("gs_response", var1)), (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/core/model/AnalyticEvent$SAVE_OUTDOOR_LOCATION;", "Lcom/blueair/core/model/AnalyticEvent;", "city", "", "<init>", "(Ljava/lang/String;)V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class SAVE_OUTDOOR_LOCATION extends AnalyticEvent {
      public SAVE_OUTDOOR_LOCATION(String var1) {
         Intrinsics.checkNotNullParameter(var1, "city");
         super("saving_outdoor_location", MapsKt.mapOf(TuplesKt.to("city", var1)), (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"},
      d2 = {"Lcom/blueair/core/model/AnalyticEvent$SET_SCHEDULE;", "Lcom/blueair/core/model/AnalyticEvent;", "startTime", "", "endTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class SET_SCHEDULE extends AnalyticEvent {
      public SET_SCHEDULE(String var1, String var2) {
         Intrinsics.checkNotNullParameter(var1, "startTime");
         Intrinsics.checkNotNullParameter(var2, "endTime");
         super("schedule_set", MapsKt.mapOf(new Pair[]{TuplesKt.to("start_time", var1), TuplesKt.to("end_time", var2)}), (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"},
      d2 = {"Lcom/blueair/core/model/AnalyticEvent$ScreenViewEvent;", "Lcom/blueair/core/model/AnalyticEvent;", "screenName", "", "screenClass", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class ScreenViewEvent extends AnalyticEvent {
      public static final String ADD_DEVICE = "add_device";
      public static final String ADD_DEVICE_CONNECTING = "add_device_connecting";
      public static final String ADD_DEVICE_FINALIZE = "add_device_finalize";
      public static final String ADD_DEVICE_LEGACY = "add_device_legacy";
      public static final String ADD_DEVICE_PAIRING = "add_device_pairing";
      public static final String ADD_DEVICE_SCAN = "add_device_scan";
      public static final String ADD_DEVICE_SET_NAME = "add_device_set_name";
      public static final String ADD_DEVICE_WIFI_LIST = "add_device_wifi_list";
      public static final String ADD_DEVICE_WIFI_PASSWORD = "add_device_wifi_password";
      public static final String ANTIFAKE_INSTRUCTION = "antifake_instruction";
      public static final String ANTIFAKE_RESET = "antifake_reset";
      public static final String ANTIFAKE_RESET_BY_BLUETOOTH = "antifake_reset_reset_by_bluetooth";
      public static final String ANTIFAKE_RESET_BY_WIFI = "antifake_reset_reset_by_wifi";
      public static final String ANTIFAKE_RESET_VERIFYING = "antifake_reset_verifying";
      public static final String ANTIFAKE_RESET_VERIFY_RESULT = "antifake_reset_verify_result";
      public static final String ANTIFAKE_SCAN = "antifake_scan";
      public static final String ANTIFAKE_SCAN_BLUETOOTH = "antifake_reset_scan_bluetooth";
      public static final String ANTIFAKE_SELECT_DEVICE = "antifake_reset_select_device";
      public static final String CONNECT_DEVICE_GUIDE = "connect_device_guide";
      public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
      public static final String DEVICE_DETAILS = "device_details";
      public static final String DEVICE_DETAILS_ABOUT_AQI = "device_details_about_aqi";
      public static final String DEVICE_DETAILS_ALARM_DELETE = "device_details_alarm_delete";
      public static final String DEVICE_DETAILS_ALARM_DETAILS = "device_details_alarm_details";
      public static final String DEVICE_DETAILS_ALARM_LIST = "device_details_alarm_list";
      public static final String DEVICE_DETAILS_ALARM_SOUND = "device_details_alarm_sound";
      public static final String DEVICE_DETAILS_FILTER = "device_details_filter";
      public static final String DEVICE_DETAILS_SCHEDULE_DETAILS = "device_details_schedule_details";
      public static final String DEVICE_DETAILS_SCHEDULE_LIST = "device_details_schedule_list";
      public static final String DEVICE_DETAILS_SCHEDULE_MODE = "device_details_schedule_mode";
      public static final String DEVICE_FILTER_BUY = "device_filter_buy";
      public static final String DEVICE_FILTER_BUY_WEB = "device_filter_buy_web";
      public static final String DEVICE_FILTER_MANUAL = "device_filter_manual";
      public static final String DEVICE_FILTER_REPLACE = "device_filter_replace";
      public static final String DEVICE_FILTER_VIDEO = "device_filter_video";
      public static final String DEVICE_SETTINGS = "device_settings";
      public static final String DEVICE_SETTINGS_DELETE = "device_settings_delete";
      public static final String DEVICE_SETTINGS_DRY_MODE = "device_settings_dry_mode";
      public static final String DEVICE_SETTINGS_INFO = "device_settings_info";
      public static final String DEVICE_SETTINGS_MANUAL = "device_settings_manual";
      public static final String DEVICE_SETTINGS_SET_NAME = "device_settings_set_name";
      public static final String DEVICE_SETTINGS_TEMPERATURE = "device_settings_temperature";
      public static final String DEVICE_SETTINGS_TIMEZONE = "device_settings_timezone";
      public static final String DEVICE_SETTINGS_WELCOME_HOME = "device_settings_welcome_home";
      public static final String GOOGLE_APP_FLIP = "google_app_flip";
      public static final String HOME = "home";
      public static final String LOGIN = "login";
      public static final String NOTIFICATIONS = "notifications";
      public static final String NOTIFICATIONS_FILTER = "notifications_filter";
      public static final String OUTDOOR_MAP = "outdoor_map";
      public static final String OUTDOOR_MAP_ASSIGN_PRODUCTS = "outdoor_map_assign_products";
      public static final String OUTDOOR_MAP_SEARCH = "outdoor_map_search";
      public static final String REGISTER = "register";
      public static final String SIDE_MENU = "side_menu";
      public static final String SIDE_MENU_CUSTOMER_SUPPORT = "side_menu_customer_support";
      public static final String SIDE_MENU_DEV_SETTINGS = "side_menu_dev_settings";
      public static final String SIDE_MENU_POLICY = "side_menu_policy";
      public static final String SIDE_MENU_POLICY_USER_INFO_DETAILS = "side_menu_policy_user_info_details";
      public static final String SIDE_MENU_POLICY_USER_INFO_GROUPS = "side_menu_policy_user_info_groups";
      public static final String SIDE_MENU_PROFILE = "side_menu_profile";
      public static final String SIDE_MENU_PROFILE_DELETE_ACCOUNT = "side_menu_profile_delete_account";
      public static final String SIDE_MENU_PROFILE_MANAGE_ACCOUNT = "side_menu_profile_manage_account";
      public static final String SIDE_MENU_SETTINGS = "side_menu_settings";
      public static final String SIDE_MENU_SETTINGS_NOTIFICATION = "side_menu_settings_notification";
      public static final String SIDE_MENU_STORE = "side_menu_store";
      public static final String SIDE_MENU_VOICE_ASSISTANT = "side_menu_voice_assistant";
      public static final String SIDE_MENU_VOICE_ASSISTANT_ALEXA = "side_menu_voice_assistant_alexa";
      public static final String SIDE_MENU_VOICE_ASSISTANT_ALEXA_OLD = "side_menu_voice_assistant_alexa_old";
      public static final String SIDE_MENU_VOICE_ASSISTANT_GOOGLE = "side_menu_voice_assistant_google";
      public static final String UPLOAD_LOG = "upload_log";
      public static final String WELCOME = "welcome";

      public ScreenViewEvent(String var1, String var2) {
         Intrinsics.checkNotNullParameter(var1, "screenName");
         Intrinsics.checkNotNullParameter(var2, "screenClass");
         super("screen_view", MapsKt.mapOf(new Pair[]{TuplesKt.to("screen_name", var1), TuplesKt.to("screen_class", var2)}), (DefaultConstructorMarker)null);
      }

      @Metadata(
         d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\bF\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006K"},
         d2 = {"Lcom/blueair/core/model/AnalyticEvent$ScreenViewEvent$Companion;", "", "<init>", "()V", "WELCOME", "", "LOGIN", "REGISTER", "CONNECT_DEVICE_GUIDE", "HOME", "SIDE_MENU", "SIDE_MENU_STORE", "SIDE_MENU_PROFILE", "SIDE_MENU_PROFILE_MANAGE_ACCOUNT", "SIDE_MENU_PROFILE_DELETE_ACCOUNT", "SIDE_MENU_SETTINGS", "SIDE_MENU_SETTINGS_NOTIFICATION", "SIDE_MENU_DEV_SETTINGS", "SIDE_MENU_CUSTOMER_SUPPORT", "SIDE_MENU_VOICE_ASSISTANT", "SIDE_MENU_VOICE_ASSISTANT_ALEXA", "SIDE_MENU_VOICE_ASSISTANT_ALEXA_OLD", "SIDE_MENU_VOICE_ASSISTANT_GOOGLE", "SIDE_MENU_POLICY", "SIDE_MENU_POLICY_USER_INFO_GROUPS", "SIDE_MENU_POLICY_USER_INFO_DETAILS", "ADD_DEVICE", "ADD_DEVICE_LEGACY", "ADD_DEVICE_SCAN", "ADD_DEVICE_PAIRING", "ADD_DEVICE_WIFI_LIST", "ADD_DEVICE_WIFI_PASSWORD", "ADD_DEVICE_CONNECTING", "ADD_DEVICE_SET_NAME", "ADD_DEVICE_FINALIZE", "DEVICE_DETAILS", "DEVICE_DETAILS_ABOUT_AQI", "DEVICE_DETAILS_SCHEDULE_LIST", "DEVICE_DETAILS_SCHEDULE_DETAILS", "DEVICE_DETAILS_SCHEDULE_MODE", "DEVICE_DETAILS_ALARM_LIST", "DEVICE_DETAILS_ALARM_DETAILS", "DEVICE_DETAILS_ALARM_SOUND", "DEVICE_DETAILS_ALARM_DELETE", "DEVICE_DETAILS_FILTER", "DEVICE_FILTER_MANUAL", "DEVICE_FILTER_REPLACE", "DEVICE_FILTER_VIDEO", "DEVICE_FILTER_BUY", "DEVICE_FILTER_BUY_WEB", "DEVICE_SETTINGS", "DEVICE_SETTINGS_SET_NAME", "DEVICE_SETTINGS_TIMEZONE", "DEVICE_SETTINGS_WELCOME_HOME", "DEVICE_SETTINGS_DRY_MODE", "DEVICE_SETTINGS_TEMPERATURE", "DEVICE_SETTINGS_MANUAL", "DEVICE_SETTINGS_INFO", "DEVICE_SETTINGS_DELETE", "ANTIFAKE_INSTRUCTION", "ANTIFAKE_SCAN", "ANTIFAKE_RESET", "ANTIFAKE_RESET_VERIFYING", "ANTIFAKE_RESET_VERIFY_RESULT", "ANTIFAKE_SELECT_DEVICE", "ANTIFAKE_RESET_BY_WIFI", "ANTIFAKE_SCAN_BLUETOOTH", "ANTIFAKE_RESET_BY_BLUETOOTH", "NOTIFICATIONS", "NOTIFICATIONS_FILTER", "OUTDOOR_MAP", "OUTDOOR_MAP_SEARCH", "OUTDOOR_MAP_ASSIGN_PRODUCTS", "GOOGLE_APP_FLIP", "UPLOAD_LOG", "core_otherRelease"},
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

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/AnalyticEvent$TAP_CUSTOMER_SUPPORT;", "Lcom/blueair/core/model/AnalyticEvent;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class TAP_CUSTOMER_SUPPORT extends AnalyticEvent {
      public TAP_CUSTOMER_SUPPORT() {
         super("customer_support_tapped", MapsKt.emptyMap(), (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/AnalyticEvent$TAP_TROUBLESHOOTING;", "Lcom/blueair/core/model/AnalyticEvent;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class TAP_TROUBLESHOOTING extends AnalyticEvent {
      public TAP_TROUBLESHOOTING() {
         super("troubleshooting_tapped", MapsKt.emptyMap(), (DefaultConstructorMarker)null);
      }
   }
}
