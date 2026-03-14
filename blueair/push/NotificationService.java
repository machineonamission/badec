package com.blueair.push;

import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Context;
import android.media.RingtoneManager;
import android.os.Build.VERSION;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.blueair.android.BlueairApp$$ExternalSyntheticApiModelOutline0;
import com.blueair.auth.AuthService;
import com.blueair.core.BuildEnvironment;
import com.blueair.core.util.PhoneUtil;
import com.blueair.sdk.FirebaseSdk;
import com.blueair.sdk.KlaviyoSdk;
import com.blueair.viewcore.activity.Actions;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.json.JSONObject;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\u001aH\u0002J\u0015\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0000¢\u0006\u0002\b\u001fJ-\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020%H\u0000¢\u0006\u0002\b&J(\u0010 \u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u001eH\u0007J$\u0010*\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u001e2\b\u0010'\u001a\u0004\u0018\u00010\u001e2\b\u0010+\u001a\u0004\u0018\u00010\u001eH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"},
   d2 = {"Lcom/blueair/push/NotificationService;", "", "context", "Landroid/content/Context;", "authService", "Lcom/blueair/auth/AuthService;", "<init>", "(Landroid/content/Context;Lcom/blueair/auth/AuthService;)V", "useFCM", "", "getUseFCM", "()Z", "useKlaviyo", "getUseKlaviyo", "useJPush", "getUseJPush", "enabled", "getEnabled", "requestCode", "", "getRequestCode", "()I", "_requestCode", "Ljava/util/concurrent/atomic/AtomicInteger;", "smallIcon", "initialize", "", "createNotificationChannel", "setNotificationToken", "token", "", "setNotificationToken$push_otherRelease", "showNotification", "userId", "deviceId", "templateId", "params", "Lorg/json/JSONObject;", "showNotification$push_otherRelease", "title", "message", "actionType", "showStopAlarmNotification", "body", "Companion", "push_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class NotificationService {
   public static final String ACTION_DEVICE_DETAILS = "device_details";
   public static final String ACTION_TYPE_FILTER = "filter";
   public static final String ACTION_TYPE_FILTER_PURCHASE = "filter_purchase";
   public static final String ACTION_TYPE_FILTER_STATUS = "filter_status";
   public static final String ACTION_TYPE_REFRESHER_PURCHASE = "refresher_purchase";
   public static final String ACTION_TYPE_REFRESHER_STATUS = "refresher_status";
   public static final String ACTION_TYPE_STOP_ALARM = "stop_alarm";
   public static final String ACTION_TYPE_WICK_PURCHASE = "wick_purchase";
   public static final String ACTION_TYPE_WICK_STATUS = "wick_status";
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final String TEMPLATE_ALARM_STOP = "alarm_stop";
   private static final String TEMPLATE_FILTER_DOOR_OPEN = "filter_door_open";
   private static final String TEMPLATE_FILTER_USAGE_REPLACE = "filter_usage_replace";
   private static final String TEMPLATE_FILTER_USAGE_REPLACE_URGENT = "filter_usage_replace_urgent";
   private static final String TEMPLATE_PREFILTER_USAGE_CLEAN = "prefilter_usage_clean";
   private static final String TEMPLATE_REFRESHER_USAGE_REPLACE = "ywrm_usage_replace";
   private static final String TEMPLATE_REFRESHER_USAGE_REPLACE_URGENT = "ywrm_usage_replace_urgent";
   private static final String TEMPLATE_WATER_SHORTAGE = "water_shortage";
   private static final String TEMPLATE_WATER_TANK_FAILURE = "water_tank_failure";
   private static final String TEMPLATE_WATER_TANK_FULL = "water_full";
   private static final String TEMPLATE_WICK_USAGE_REPLACE = "wick_usage_replace";
   private static final String TEMPLATE_WICK_USAGE_REPLACE_URGENT = "wick_usage_replace_urgent";
   private final AtomicInteger _requestCode;
   private final AuthService authService;
   private final Context context;
   private final int smallIcon;
   private final boolean useFCM;

   // $FF: synthetic method
   public static Unit $r8$lambda$Ii_28JlWuRFHuxf3IYP96NCia_o/* $FF was: $r8$lambda$Ii-28JlWuRFHuxf3IYP96NCia_o*/(NotificationService var0, Result var1) {
      return initialize$lambda$0(var0, var1);
   }

   public NotificationService(Context var1, AuthService var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "authService");
      super();
      this.context = var1;
      this.authService = var2;
      this.useFCM = BuildEnvironment.INSTANCE.isChina() ^ true;
      this._requestCode = new AtomicInteger(0);
      int var3;
      if (PhoneUtil.INSTANCE.isGoogleServicesAvailable(var1)) {
         var3 = R.drawable.ic_notification;
      } else {
         var3 = R.drawable.ic_launcher;
      }

      this.smallIcon = var3;
   }

   private final void createNotificationChannel() {
      if (VERSION.SDK_INT >= 26) {
         BlueairApp$$ExternalSyntheticApiModelOutline0.m();
         NotificationChannel var1 = BlueairApp$$ExternalSyntheticApiModelOutline0.m(this.context.getString(R.string.channel_id), (CharSequence)this.context.getString(R.string.channel_name), 3);
         BlueairApp$$ExternalSyntheticApiModelOutline0.m(var1, this.context.getString(R.string.channel_description));
         NotificationManagerCompat.from(this.context).createNotificationChannel(var1);
      }

   }

   private final int getRequestCode() {
      return this._requestCode.getAndIncrement();
   }

   private static final Unit initialize$lambda$0(NotificationService var0, Result var1) {
      if (Result.isSuccess-impl(var1.unbox-impl())) {
         Timber.Forest var4 = Timber.Forest;
         StringBuilder var5 = new StringBuilder("Firebase token = ");
         Object var3 = var1.unbox-impl();
         Object var2 = var3;
         if (Result.isFailure-impl(var3)) {
            var2 = null;
         }

         var5.append((String)var2);
         var4.d(var5.toString(), new Object[0]);
         var2 = var1.unbox-impl();
         Object var6 = var2;
         if (Result.isFailure-impl(var2)) {
            var6 = "";
         }

         var0.setNotificationToken$push_otherRelease((String)var6);
      }

      return Unit.INSTANCE;
   }

   public final boolean getEnabled() {
      return this.useFCM || this.getUseJPush();
   }

   public final boolean getUseFCM() {
      return this.useFCM;
   }

   public final boolean getUseJPush() {
      return this.authService.getUseJPush();
   }

   public final boolean getUseKlaviyo() {
      return KlaviyoSdk.INSTANCE.getEnabled();
   }

   public final void initialize() {
      if (this.getEnabled()) {
         this.createNotificationChannel();
         if (this.useFCM) {
            FirebaseSdk.INSTANCE.getMessagingToken(new NotificationService$$ExternalSyntheticLambda3(this));
         }
      }

   }

   public final void setNotificationToken$push_otherRelease(String var1) {
      Intrinsics.checkNotNullParameter(var1, "token");
      AuthService var2 = this.authService;
      BuildersKt.launch$default(var2, (CoroutineContext)null, (CoroutineStart)null, new Function2(var2, var1, (Continuation)null) {
         final AuthService $this_run;
         final String $token;
         int label;

         {
            this.$this_run = var1;
            this.$token = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$this_run, this.$token, var2));
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
               var1 = this.$this_run;
               String var4 = this.$token;
               Continuation var5 = (Continuation)this;
               this.label = 1;
               if (var1.setPushToken(var4, var5) == var3) {
                  return var3;
               }
            }

            return Unit.INSTANCE;
         }
      }, 3, (Object)null);
   }

   public final void showNotification(String var1, String var2, String var3, String var4) {
      Intrinsics.checkNotNullParameter(var1, "deviceId");
      Intrinsics.checkNotNullParameter(var2, "title");
      Intrinsics.checkNotNullParameter(var3, "message");
      Intrinsics.checkNotNullParameter(var4, "actionType");
      String var5 = this.context.getString(R.string.channel_id);
      Intrinsics.checkNotNullExpressionValue(var5, "getString(...)");
      NotificationCompat.Builder var7 = (new NotificationCompat.Builder(this.context, var5)).setAutoCancel(true).setSmallIcon(this.smallIcon).setColorized(true).setColor(this.context.getColor(com.blueair.viewcore.R.color.colorPrimary)).setContentTitle((CharSequence)var2);
      CharSequence var8 = (CharSequence)var3;
      NotificationCompat.Builder var6 = var7.setContentText(var8).setStyle((NotificationCompat.Style)(new NotificationCompat.BigTextStyle()).bigText(var8)).setSound(RingtoneManager.getDefaultUri(2)).setVisibility(1).setContentIntent(PendingIntent.getActivity(this.context, this.getRequestCode(), Actions.INSTANCE.openNotificationIntent(this.context, var1, var4), 1140850688));
      Intrinsics.checkNotNullExpressionValue(var6, "setContentIntent(...)");
      NotificationManagerCompat.from(this.context).notify(Random.Default.nextInt(), var6.build());
   }

   public final void showNotification$push_otherRelease(String var1, String var2, String var3, JSONObject var4) {
      Intrinsics.checkNotNullParameter(var1, "userId");
      Intrinsics.checkNotNullParameter(var2, "deviceId");
      Intrinsics.checkNotNullParameter(var3, "templateId");
      Intrinsics.checkNotNullParameter(var4, "params");
      if (Intrinsics.areEqual(var1, this.authService.getUserIdForBlueCloud())) {
         Throwable var10000;
         label4154: {
            int var5;
            try {
               var5 = var3.hashCode();
            } catch (Throwable var710) {
               var10000 = var710;
               boolean var10001 = false;
               break label4154;
            }

            String var7;
            String var8;
            String var714;
            label4136: {
               label4135: {
                  label4134: {
                     var8 = "device_details";
                     switch (var5) {
                        case -2003314351:
                           try {
                              if (!var3.equals("wick_usage_replace")) {
                                 return;
                              }
                           } catch (Throwable var699) {
                              var10000 = var699;
                              boolean var751 = false;
                              break label4154;
                           }

                           try {
                              String var724 = var4.getString("device_name");
                              var5 = RangesKt.coerceAtLeast(var4.getInt("filter_life_left"), 0);
                              var7 = this.context.getString(com.blueair.viewcore.R.string.notification_template_title_wick_usage_prompt, new Object[]{var5});
                              Intrinsics.checkNotNullExpressionValue(var7, "getString(...)");
                              var714 = this.context.getString(com.blueair.viewcore.R.string.notification_template_content_wick_usage_prompt, new Object[]{var724});
                              Intrinsics.checkNotNullExpressionValue(var714, "getString(...)");
                              break label4134;
                           } catch (Throwable var698) {
                              var10000 = var698;
                              boolean var752 = false;
                              break label4154;
                           }
                        case -1923137593:
                           try {
                              if (!var3.equals("prefilter_usage_clean")) {
                                 return;
                              }
                           } catch (Throwable var689) {
                              var10000 = var689;
                              boolean var749 = false;
                              break label4154;
                           }

                           try {
                              String var723 = var4.getString("device_name");
                              var7 = this.context.getString(com.blueair.viewcore.R.string.notification_template_title_prefilter_usage_clean);
                              Intrinsics.checkNotNullExpressionValue(var7, "getString(...)");
                              var714 = this.context.getString(com.blueair.viewcore.R.string.notification_template_content_prefilter_usage_clean, new Object[]{var723});
                              Intrinsics.checkNotNullExpressionValue(var714, "getString(...)");
                              break;
                           } catch (Throwable var688) {
                              var10000 = var688;
                              boolean var750 = false;
                              break label4154;
                           }
                        case -1016813516:
                           try {
                              if (!var3.equals("filter_door_open")) {
                                 return;
                              }
                           } catch (Throwable var695) {
                              var10000 = var695;
                              boolean var747 = false;
                              break label4154;
                           }

                           try {
                              String var722 = var4.getString("device_name");
                              var7 = this.context.getString(com.blueair.viewcore.R.string.notification_template_title_filter_door_open);
                              Intrinsics.checkNotNullExpressionValue(var7, "getString(...)");
                              var714 = this.context.getString(com.blueair.viewcore.R.string.notification_template_content_filter_door_open, new Object[]{var722});
                              Intrinsics.checkNotNullExpressionValue(var714, "getString(...)");
                              break label4136;
                           } catch (Throwable var694) {
                              var10000 = var694;
                              boolean var748 = false;
                              break label4154;
                           }
                        case -956559056:
                           try {
                              if (!var3.equals("alarm_stop")) {
                                 return;
                              }
                           } catch (Throwable var686) {
                              var10000 = var686;
                              boolean var745 = false;
                              break label4154;
                           }

                           try {
                              this.showStopAlarmNotification(var2, (String)null, var4.getString("alarm_name"));
                              return;
                           } catch (Throwable var685) {
                              var10000 = var685;
                              boolean var746 = false;
                              break label4154;
                           }
                        case -732600995:
                           try {
                              if (!var3.equals("water_tank_failure")) {
                                 return;
                              }
                           } catch (Throwable var697) {
                              var10000 = var697;
                              boolean var743 = false;
                              break label4154;
                           }

                           try {
                              String var721 = var4.getString("device_name");
                              var7 = this.context.getString(com.blueair.viewcore.R.string.notification_template_title_water_tank_failure);
                              Intrinsics.checkNotNullExpressionValue(var7, "getString(...)");
                              var714 = this.context.getString(com.blueair.viewcore.R.string.notification_template_content_water_tank_failure, new Object[]{var721});
                              Intrinsics.checkNotNullExpressionValue(var714, "getString(...)");
                              break label4136;
                           } catch (Throwable var696) {
                              var10000 = var696;
                              boolean var744 = false;
                              break label4154;
                           }
                        case 475990511:
                           try {
                              if (!var3.equals("wick_usage_replace_urgent")) {
                                 return;
                              }
                           } catch (Throwable var701) {
                              var10000 = var701;
                              boolean var741 = false;
                              break label4154;
                           }

                           try {
                              String var720 = var4.getString("device_name");
                              var7 = this.context.getString(com.blueair.viewcore.R.string.notification_template_title_wick_usage_warning);
                              Intrinsics.checkNotNullExpressionValue(var7, "getString(...)");
                              var714 = this.context.getString(com.blueair.viewcore.R.string.notification_template_content_wick_usage_warning, new Object[]{var720});
                              Intrinsics.checkNotNullExpressionValue(var714, "getString(...)");
                              break label4134;
                           } catch (Throwable var700) {
                              var10000 = var700;
                              boolean var742 = false;
                              break label4154;
                           }
                        case 483913713:
                           try {
                              if (!var3.equals("filter_usage_replace_urgent")) {
                                 return;
                              }
                           } catch (Throwable var691) {
                              var10000 = var691;
                              boolean var739 = false;
                              break label4154;
                           }

                           try {
                              String var719 = var4.getString("device_name");
                              var7 = this.context.getString(com.blueair.viewcore.R.string.notification_template_title_filter_usage_warning);
                              Intrinsics.checkNotNullExpressionValue(var7, "getString(...)");
                              var714 = this.context.getString(com.blueair.viewcore.R.string.notification_template_content_filter_usage_warning, new Object[]{var719});
                              Intrinsics.checkNotNullExpressionValue(var714, "getString(...)");
                              break;
                           } catch (Throwable var690) {
                              var10000 = var690;
                              boolean var740 = false;
                              break label4154;
                           }
                        case 1378289963:
                           try {
                              if (!var3.equals("water_shortage")) {
                                 return;
                              }
                           } catch (Throwable var703) {
                              var10000 = var703;
                              boolean var737 = false;
                              break label4154;
                           }

                           try {
                              String var718 = var4.getString("device_name");
                              var7 = this.context.getString(com.blueair.viewcore.R.string.notification_template_title_water_shortage_new);
                              Intrinsics.checkNotNullExpressionValue(var7, "getString(...)");
                              var714 = this.context.getString(com.blueair.viewcore.R.string.notification_template_content_water_shortage_new, new Object[]{var718});
                              Intrinsics.checkNotNullExpressionValue(var714, "getString(...)");
                              break label4136;
                           } catch (Throwable var702) {
                              var10000 = var702;
                              boolean var738 = false;
                              break label4154;
                           }
                        case 1388897328:
                           try {
                              if (!var3.equals("ywrm_usage_replace_urgent")) {
                                 return;
                              }
                           } catch (Throwable var705) {
                              var10000 = var705;
                              boolean var735 = false;
                              break label4154;
                           }

                           try {
                              String var717 = var4.getString("device_name");
                              var7 = this.context.getString(com.blueair.viewcore.R.string.refresher_usage_state, new Object[]{0});
                              Intrinsics.checkNotNullExpressionValue(var7, "getString(...)");
                              var714 = this.context.getString(com.blueair.viewcore.R.string.notification_template_content_refresher_usage_warning, new Object[]{var717});
                              Intrinsics.checkNotNullExpressionValue(var714, "getString(...)");
                              break label4135;
                           } catch (Throwable var704) {
                              var10000 = var704;
                              boolean var736 = false;
                              break label4154;
                           }
                        case 1716033072:
                           try {
                              if (!var3.equals("ywrm_usage_replace")) {
                                 return;
                              }
                           } catch (Throwable var707) {
                              var10000 = var707;
                              boolean var733 = false;
                              break label4154;
                           }

                           try {
                              String var716 = var4.getString("device_name");
                              var5 = RangesKt.coerceAtLeast(var4.getInt("filter_life_left"), 0);
                              var7 = this.context.getString(com.blueair.viewcore.R.string.refresher_usage_state, new Object[]{var5});
                              Intrinsics.checkNotNullExpressionValue(var7, "getString(...)");
                              var714 = this.context.getString(com.blueair.viewcore.R.string.notification_template_content_refresher_usage_prompt, new Object[]{var716});
                              Intrinsics.checkNotNullExpressionValue(var714, "getString(...)");
                              break label4135;
                           } catch (Throwable var706) {
                              var10000 = var706;
                              boolean var734 = false;
                              break label4154;
                           }
                        case 1797312911:
                           try {
                              if (!var3.equals("filter_usage_replace")) {
                                 return;
                              }
                           } catch (Throwable var693) {
                              var10000 = var693;
                              boolean var731 = false;
                              break label4154;
                           }

                           try {
                              String var715 = var4.getString("device_name");
                              var5 = RangesKt.coerceAtLeast(var4.getInt("filter_life_left"), 0);
                              String var726 = this.context.getString(com.blueair.viewcore.R.string.notification_template_title_filter_usage_prompt);
                              Intrinsics.checkNotNullExpressionValue(var726, "getString(...)");
                              var7 = String.format(var726, Arrays.copyOf(new Object[]{var5}, 1));
                              Intrinsics.checkNotNullExpressionValue(var7, "format(...)");
                              var714 = this.context.getString(com.blueair.viewcore.R.string.notification_template_content_filter_usage_prompt, new Object[]{var715});
                              Intrinsics.checkNotNullExpressionValue(var714, "getString(...)");
                              break;
                           } catch (Throwable var692) {
                              var10000 = var692;
                              boolean var732 = false;
                              break label4154;
                           }
                        case 1961012407:
                           try {
                              if (!var3.equals("water_full")) {
                                 return;
                              }
                           } catch (Throwable var709) {
                              var10000 = var709;
                              boolean var729 = false;
                              break label4154;
                           }

                           try {
                              String var6 = var4.getString("device_name");
                              var7 = this.context.getString(com.blueair.viewcore.R.string.notification_template_title_water_tank_full);
                              Intrinsics.checkNotNullExpressionValue(var7, "getString(...)");
                              var714 = this.context.getString(com.blueair.viewcore.R.string.notification_template_content_water_tank_full, new Object[]{var6});
                              Intrinsics.checkNotNullExpressionValue(var714, "getString(...)");
                              break label4136;
                           } catch (Throwable var708) {
                              var10000 = var708;
                              boolean var730 = false;
                              break label4154;
                           }
                        default:
                           return;
                     }

                     var8 = "filter";
                     break label4136;
                  }

                  var8 = "wick_status";
                  break label4136;
               }

               var8 = "refresher_status";
            }

            label4086:
            try {
               this.showNotification(var2, var7, var714, var8);
               return;
            } catch (Throwable var687) {
               var10000 = var687;
               boolean var753 = false;
               break label4086;
            }
         }

         Throwable var727 = var10000;
         Timber.Forest var725 = Timber.Forest;
         StringBuilder var728 = new StringBuilder("error parsing notification: userId=");
         var728.append(var1);
         var728.append(", deviceId=");
         var728.append(var2);
         var728.append(", templateId=");
         var728.append(var3);
         var728.append(", params=");
         var728.append(var4);
         var725.e(var727, var728.toString(), new Object[0]);
      }
   }

   public final void showStopAlarmNotification(String var1, String var2, String var3) {
      Intrinsics.checkNotNullParameter(var1, "deviceId");
      String var6 = this.context.getString(R.string.channel_id);
      Intrinsics.checkNotNullExpressionValue(var6, "getString(...)");
      int var4 = this.getRequestCode();
      RemoteViews var5 = new RemoteViews(this.context.getPackageName(), com.blueair.viewcore.R.layout.notification_stop_alarm);
      if (var2 != null) {
         var5.setTextViewText(com.blueair.viewcore.R.id.title, (CharSequence)var2);
      }

      if (var3 != null) {
         var5.setTextViewText(com.blueair.viewcore.R.id.body, (CharSequence)var3);
      }

      var5.setOnClickPendingIntent(com.blueair.viewcore.R.id.btn_stop, PendingIntent.getService(this.context, this.getRequestCode(), Actions.INSTANCE.stopAlarmIntent(this.context, var1, var4), 67108864));
      NotificationCompat.Builder var7 = (new NotificationCompat.Builder(this.context, var6)).setAutoCancel(true).setSmallIcon(this.smallIcon).setColorized(true).setColor(this.context.getColor(com.blueair.viewcore.R.color.colorPrimary)).setStyle((NotificationCompat.Style)(new NotificationCompat.DecoratedCustomViewStyle())).setCustomContentView(var5).setSound(RingtoneManager.getDefaultUri(2)).setVisibility(1);
      Intrinsics.checkNotNullExpressionValue(var7, "setVisibility(...)");
      NotificationManagerCompat.from(this.context).notify(var4, var7.build());
   }

   @Metadata(
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001a"},
      d2 = {"Lcom/blueair/push/NotificationService$Companion;", "", "<init>", "()V", "TEMPLATE_PREFILTER_USAGE_CLEAN", "", "TEMPLATE_FILTER_USAGE_REPLACE", "TEMPLATE_FILTER_USAGE_REPLACE_URGENT", "TEMPLATE_WICK_USAGE_REPLACE", "TEMPLATE_WICK_USAGE_REPLACE_URGENT", "TEMPLATE_REFRESHER_USAGE_REPLACE", "TEMPLATE_REFRESHER_USAGE_REPLACE_URGENT", "TEMPLATE_WATER_SHORTAGE", "TEMPLATE_WATER_TANK_FULL", "TEMPLATE_WATER_TANK_FAILURE", "TEMPLATE_ALARM_STOP", "TEMPLATE_FILTER_DOOR_OPEN", "ACTION_DEVICE_DETAILS", "ACTION_TYPE_FILTER", "ACTION_TYPE_FILTER_STATUS", "ACTION_TYPE_FILTER_PURCHASE", "ACTION_TYPE_WICK_STATUS", "ACTION_TYPE_WICK_PURCHASE", "ACTION_TYPE_REFRESHER_STATUS", "ACTION_TYPE_REFRESHER_PURCHASE", "ACTION_TYPE_STOP_ALARM", "push_otherRelease"},
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
