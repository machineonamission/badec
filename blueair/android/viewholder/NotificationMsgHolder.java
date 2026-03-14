package com.blueair.android.viewholder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.adapter.NotificationItem;
import com.blueair.android.databinding.CardItemNotificationBinding;
import com.blueair.core.model.AqiHumLevel;
import com.blueair.core.model.AwsLinkConfig;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.DeviceImage;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.FilterConfig;
import com.blueair.core.model.FilterInfo;
import com.blueair.core.model.FilterLifeLevel;
import com.blueair.core.model.NotificationAqiSubType;
import com.blueair.core.model.NotificationMessage;
import com.blueair.core.model.NotificationMsgType;
import com.blueair.core.model.SimpleEvent;
import com.blueair.viewcore.R;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.blueair.viewcore.view.IndoorAirStatusLabel;
import com.google.android.material.button.MaterialButton;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 $2\u00020\u0001:\u0002$%B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J.\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\u000e\u0018\u00010\rJ.\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\u000e\u0018\u00010\rH\u0002J.\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\u000e\u0018\u00010\rH\u0002J,\u0010\u0012\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J(\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J$\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0006\u0012\u0004\u0018\u00010 0\u00132\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006&"},
   d2 = {"Lcom/blueair/android/viewholder/NotificationMsgHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/android/databinding/CardItemNotificationBinding;", "<init>", "(Lcom/blueair/android/databinding/CardItemNotificationBinding;)V", "getBinding", "()Lcom/blueair/android/databinding/CardItemNotificationBinding;", "hydrate", "", "item", "Lcom/blueair/android/adapter/NotificationItem;", "clickPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/core/model/SimpleEvent;", "", "hydrateAqi", "hydrateFilterLife", "fetchPurchaseLinkAndVideoRes", "Lkotlin/Pair;", "", "Lcom/blueair/core/model/FilterInfo;", "device", "Lcom/blueair/core/model/Device;", "deviceFilterType", "Lcom/blueair/core/model/DeviceFilterType;", "hydrateFilterInfo", "filterType", "filterLifeLevel", "Lcom/blueair/core/model/FilterLifeLevel;", "convertAqiLevelToStatusLabel", "", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel;", "subType", "Lcom/blueair/core/model/NotificationAqiSubType;", "subLevel", "Companion", "StringSet", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class NotificationMsgHolder extends RecyclerView.ViewHolder {
   public static final int $stable = 8;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final String EVENT_ADJUST = "event_adjust";
   public static final String EVENT_BUY_FILTER = "event_buy_filter";
   public static final String EVENT_CLOSE = "event_close";
   public static final String EVENT_CONTENT = "event_content";
   public static final String EVENT_REPLACE_FILTER = "event_replace_filter";
   private final CardItemNotificationBinding binding;

   // $FF: synthetic method
   public static void $r8$lambda$5LhTbrSjCQLY6hvD9jjgYEM55yA(PublishSubject var0, NotificationItem var1, View var2) {
      hydrateAqi$lambda$4$lambda$3(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$FdL_mJNGHEVZWPZv7QWQjEKemgU/* $FF was: $r8$lambda$FdL-mJNGHEVZWPZv7QWQjEKemgU*/(PublishSubject var0, NotificationItem var1, View var2) {
      hydrateFilterLife$lambda$6(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$cZDjWMZfPPrmT_fU38K5ay0imTo(PublishSubject var0, NotificationItem var1, View var2) {
      hydrate$lambda$2$lambda$1(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$iQYhHIToR7E8SF6yjVhkqkaoxqs(PublishSubject var0, NotificationItem var1, View var2) {
      hydrate$lambda$2$lambda$0(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$tVb__vIdZG9D7_k_HA0xXHeHFoY/* $FF was: $r8$lambda$tVb--vIdZG9D7_k-HA0xXHeHFoY*/(PublishSubject var0, NotificationItem var1, View var2) {
      hydrateFilterLife$lambda$5(var0, var1, var2);
   }

   public NotificationMsgHolder(CardItemNotificationBinding var1) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      super((View)var1.getRoot());
      this.binding = var1;
   }

   private final Pair fetchPurchaseLinkAndVideoRes(Device var1, DeviceFilterType var2) {
      FilterConfig var3;
      label48: {
         var3 = DeviceConfigProvider.INSTANCE.getFilterConfig(var1, var2);
         if (var3 != null) {
            List var8 = var3.getFilters();
            if (var8 != null) {
               Iterable var4 = (Iterable)var8;
               Collection var10 = (Collection)(new ArrayList());

               for(Object var13 : var4) {
                  FilterInfo var7 = (FilterInfo)var13;
                  CharSequence var6 = (CharSequence)DeviceConfigProvider.INSTANCE.getIpConfigValue(var7.getLinkPurchase());
                  if (var6 == null || var6.length() == 0) {
                     var6 = (CharSequence)DeviceConfigProvider.INSTANCE.getIpConfigValue(var7.getLinkSubscribe());
                     if (var6 == null || var6.length() == 0) {
                        continue;
                     }
                  }

                  var10.add(var13);
               }

               var9 = (List)var10;
               break label48;
            }
         }

         var9 = CollectionsKt.emptyList();
      }

      DeviceConfigProvider var14 = DeviceConfigProvider.INSTANCE;
      AwsLinkConfig var11;
      if (var3 != null) {
         var11 = var3.getVideo();
      } else {
         var11 = null;
      }

      String var12 = var14.getAwsLinkValue(var11);
      if (DeviceKt.useV2UI(var1) || !DeviceKt.useNewFilterConfig(var1)) {
         var12 = "";
      }

      return new Pair(var9, var12);
   }

   // $FF: synthetic method
   public static void hydrate$default(NotificationMsgHolder var0, NotificationItem var1, PublishSubject var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = null;
      }

      var0.hydrate(var1, var2);
   }

   private static final void hydrate$lambda$2$lambda$0(PublishSubject var0, NotificationItem var1, View var2) {
      if (var0 != null) {
         var0.onNext(new SimpleEvent("event_close", var1));
      }

   }

   private static final void hydrate$lambda$2$lambda$1(PublishSubject var0, NotificationItem var1, View var2) {
      if (var0 != null) {
         var0.onNext(new SimpleEvent("event_content", var1));
      }

   }

   private final void hydrateAqi(NotificationItem var1, PublishSubject var2) {
      NotificationMessage var4 = var1.getMessage();
      Pair var6 = this.convertAqiLevelToStatusLabel(NotificationAqiSubType.valueOf(var4.getSubType()), var4.getSubLevel());
      int var3 = ((Number)var6.getFirst()).intValue();
      IndoorAirStatusLabel var5 = (IndoorAirStatusLabel)var6.getSecond();
      CardItemNotificationBinding var7 = this.binding;
      if (var3 == 0) {
         var7.tvMessage.setText((CharSequence)"");
      } else {
         var7.tvMessage.setText(var3);
      }

      if (var5 == null) {
         var7.tvState.setText((CharSequence)"");
      } else {
         var7.tvState.setText(var5.getTextResId());
         var7.ivIndicator.setBackgroundTintList(AppCompatResources.getColorStateList(var7.ivIndicator.getContext(), var5.getColorRes()));
         View var8 = var7.ivIndicator;
         Intrinsics.checkNotNullExpressionValue(var8, "ivIndicator");
         ViewExtensionsKt.show$default(var8, false, 1, (Object)null);
      }

      var7.tvState.setBackground((Drawable)null);
      MaterialButton var9 = var7.btnAdjust;
      Intrinsics.checkNotNullExpressionValue(var9, "btnAdjust");
      ViewExtensionsKt.show$default((View)var9, false, 1, (Object)null);
      var7.btnAdjust.setOnClickListener(new NotificationMsgHolder$$ExternalSyntheticLambda2(var2, var1));
   }

   // $FF: synthetic method
   static void hydrateAqi$default(NotificationMsgHolder var0, NotificationItem var1, PublishSubject var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = null;
      }

      var0.hydrateAqi(var1, var2);
   }

   private static final void hydrateAqi$lambda$4$lambda$3(PublishSubject var0, NotificationItem var1, View var2) {
      if (var0 != null) {
         var0.onNext(new SimpleEvent("event_adjust", var1));
      }

   }

   private final void hydrateFilterInfo(CardItemNotificationBinding var1, Device var2, DeviceFilterType var3, FilterLifeLevel var4) {
      Context var11 = var1.getRoot().getContext();
      String var12 = var2.getName();
      boolean var10 = DeviceKt.shouldMergeFilter(var2);
      int var5 = NotificationMsgHolder.WhenMappings.$EnumSwitchMapping$1[var3.ordinal()];
      StringSet var14;
      if (var5 != 1) {
         if (var5 != 2) {
            if (var5 != 3) {
               throw new NoWhenBranchMatchedException();
            }

            int var7 = R.string.refresher_usage_state;
            if (var10) {
               var5 = R.string.btn_buy;
            } else {
               var5 = R.string.action_buy_refresher;
            }

            int var6;
            if (var10) {
               var6 = R.string.action_replace;
            } else {
               var6 = R.string.replace_water_refresher;
            }

            var14 = new StringSet(var7, var5, var6, R.string.notification_template_content_refresher_usage_warning, R.string.notification_template_content_refresher_usage_prompt);
         } else {
            int var22 = R.string.wick_filter_usage_state;
            if (var10) {
               var5 = R.string.btn_buy;
            } else {
               var5 = R.string.action_buy_wick_filter;
            }

            int var19;
            if (var10) {
               var19 = R.string.action_replace;
            } else {
               var19 = R.string.replace_wick_filter;
            }

            var14 = new StringSet(var22, var5, var19, R.string.notification_template_content_wick_usage_warning, R.string.notification_template_content_wick_usage_prompt);
         }
      } else {
         int var23 = R.string.notification_template_title_filter_usage_prompt;
         if (var10) {
            var5 = R.string.btn_buy;
         } else {
            var5 = R.string.action_buy_filter;
         }

         int var20;
         if (var10) {
            var20 = R.string.action_replace;
         } else {
            var20 = R.string.replace_filter;
         }

         var14 = new StringSet(var23, var5, var20, R.string.notification_template_content_filter_usage_warning, R.string.notification_template_content_filter_usage_prompt);
      }

      int var9 = var14.component1();
      int var8 = var14.component2();
      int var24 = var14.component3();
      var5 = var14.component4();
      int var21 = var14.component5();
      var1.tvState.setText((CharSequence)var11.getString(var9, new Object[]{var4.getMaxValue()}));
      var1.btnBuyFilter.setText((CharSequence)var11.getString(var8));
      var1.btnReplaceFilter.setText((CharSequence)var11.getString(var24));
      AppCompatTextView var13 = var1.tvMessage;
      if (var4 != FilterLifeLevel.URGENT) {
         var5 = var21;
      }

      var13.setText((CharSequence)var11.getString(var5, new Object[]{var12}));
   }

   private final void hydrateFilterLife(NotificationItem var1, PublishSubject var2) {
      this.binding.btnBuyFilter.setOnClickListener(new NotificationMsgHolder$$ExternalSyntheticLambda0(var2, var1));
      this.binding.btnReplaceFilter.setOnClickListener(new NotificationMsgHolder$$ExternalSyntheticLambda1(var2, var1));
      NotificationMessage var6 = var1.getMessage();
      DeviceFilterType var8 = DeviceFilterType.valueOf(var6.getSubType());
      FilterLifeLevel var7 = FilterLifeLevel.Companion.fromLevel(var6.getSubLevel());
      this.hydrateFilterInfo(this.binding, var6.getDevice(), var8, var7);
      List var15 = var1.getDeviceFilters();
      byte var4 = 0;
      if (var15 == null) {
         Pair var9 = this.fetchPurchaseLinkAndVideoRes(var6.getDevice(), var8);
         var1.setDeviceFilters((List)var9.getFirst());
         boolean var5;
         if (var9.getSecond() != null) {
            var5 = true;
         } else {
            var5 = false;
         }

         var1.setHasVideo(var5);
      }

      MaterialButton var10 = this.binding.btnBuyFilter;
      Intrinsics.checkNotNullExpressionValue(var10, "btnBuyFilter");
      View var11 = (View)var10;
      byte var3;
      if (var1.canBuy()) {
         var3 = 0;
      } else {
         var3 = 8;
      }

      var11.setVisibility(var3);
      MaterialButton var12 = this.binding.btnReplaceFilter;
      Intrinsics.checkNotNullExpressionValue(var12, "btnReplaceFilter");
      View var13 = (View)var12;
      if (var1.getHasVideo()) {
         var3 = var4;
      } else {
         var3 = 8;
      }

      var13.setVisibility(var3);
      this.binding.tvState.setBackgroundResource(R.drawable.notification_state_warning_bg);
   }

   // $FF: synthetic method
   static void hydrateFilterLife$default(NotificationMsgHolder var0, NotificationItem var1, PublishSubject var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = null;
      }

      var0.hydrateFilterLife(var1, var2);
   }

   private static final void hydrateFilterLife$lambda$5(PublishSubject var0, NotificationItem var1, View var2) {
      if (var0 != null) {
         var0.onNext(new SimpleEvent("event_buy_filter", var1));
      }

   }

   private static final void hydrateFilterLife$lambda$6(PublishSubject var0, NotificationItem var1, View var2) {
      if (var0 != null) {
         var0.onNext(new SimpleEvent("event_replace_filter", var1));
      }

   }

   public final Pair convertAqiLevelToStatusLabel(NotificationAqiSubType var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "subType");
      IndoorAirStatusLabel var4;
      if (var1 == NotificationAqiSubType.HUM) {
         AqiHumLevel var3 = AqiHumLevel.Companion.fromLevel(var2);
         var2 = NotificationMsgHolder.WhenMappings.$EnumSwitchMapping$2[var3.ordinal()];
         if (var2 == 1 || var2 == 2) {
            var2 = R.string.notification_content_dry_air;
            var4 = IndoorAirStatusLabel.Dry.INSTANCE;
            return new Pair(var2, var4);
         }

         if (var2 == 3 || var2 == 4) {
            var2 = R.string.notification_content_moist_air;
            var4 = IndoorAirStatusLabel.Moist.INSTANCE;
            return new Pair(var2, var4);
         }

         if (var2 != 5) {
            throw new NoWhenBranchMatchedException();
         }
      }

      var2 = 0;
      var4 = null;
      return new Pair(var2, var4);
   }

   public final CardItemNotificationBinding getBinding() {
      return this.binding;
   }

   public final void hydrate(NotificationItem var1, PublishSubject var2) {
      if (var1 != null) {
         NotificationMessage var4 = var1.getMessage();
         AppCompatImageView var6 = this.binding.ivDevice;
         DeviceImage var5 = DeviceConfigProvider.INSTANCE.getDeviceImage(var4.getDevice());
         int var3;
         if (var5 != null) {
            var3 = var5.getDevice();
         } else {
            var3 = 0;
         }

         var6.setImageResource(var3);
         this.binding.tvDeviceName.setText((CharSequence)var4.getDevice().getName());
         this.binding.ivClose.setOnClickListener(new NotificationMsgHolder$$ExternalSyntheticLambda3(var2, var1));
         this.binding.getRoot().setOnClickListener(new NotificationMsgHolder$$ExternalSyntheticLambda4(var2, var1));
         MaterialButton var9 = this.binding.btnBuyFilter;
         Intrinsics.checkNotNullExpressionValue(var9, "btnBuyFilter");
         ViewExtensionsKt.hide((View)var9);
         var9 = this.binding.btnReplaceFilter;
         Intrinsics.checkNotNullExpressionValue(var9, "btnReplaceFilter");
         ViewExtensionsKt.hide((View)var9);
         var9 = this.binding.btnAdjust;
         Intrinsics.checkNotNullExpressionValue(var9, "btnAdjust");
         ViewExtensionsKt.hide((View)var9);
         View var12 = this.binding.ivIndicator;
         Intrinsics.checkNotNullExpressionValue(var12, "ivIndicator");
         ViewExtensionsKt.hide(var12);
         NotificationMsgType var8 = var4.getType();
         var3 = NotificationMsgHolder.WhenMappings.$EnumSwitchMapping$0[var8.ordinal()];
         if (var3 != 1) {
            if (var3 == 2) {
               this.hydrateAqi(var1, var2);
            } else {
               throw new NoWhenBranchMatchedException();
            }
         } else {
            this.hydrateFilterLife(var1, var2);
         }
      }
   }

   @Metadata(
      d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"},
      d2 = {"Lcom/blueair/android/viewholder/NotificationMsgHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/android/viewholder/NotificationMsgHolder;", "parent", "Landroid/view/ViewGroup;", "EVENT_BUY_FILTER", "", "EVENT_REPLACE_FILTER", "EVENT_CLOSE", "EVENT_CONTENT", "EVENT_ADJUST", "app_otherRelease"},
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

      public final NotificationMsgHolder newInstance(ViewGroup var1) {
         Intrinsics.checkNotNullParameter(var1, "parent");
         CardItemNotificationBinding var2 = CardItemNotificationBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var2, "inflate(...)");
         return new NotificationMsgHolder(var2);
      }
   }

   @Metadata(
      d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"},
      d2 = {"Lcom/blueair/android/viewholder/NotificationMsgHolder$StringSet;", "", "state", "", "buy", "replace", "urgentMsg", "normalMsg", "<init>", "(IIIII)V", "getState", "()I", "getBuy", "getReplace", "getUrgentMsg", "getNormalMsg", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "app_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   private static final class StringSet {
      private final int buy;
      private final int normalMsg;
      private final int replace;
      private final int state;
      private final int urgentMsg;

      public StringSet(int var1, int var2, int var3, int var4, int var5) {
         this.state = var1;
         this.buy = var2;
         this.replace = var3;
         this.urgentMsg = var4;
         this.normalMsg = var5;
      }

      // $FF: synthetic method
      public static StringSet copy$default(StringSet var0, int var1, int var2, int var3, int var4, int var5, int var6, Object var7) {
         if ((var6 & 1) != 0) {
            var1 = var0.state;
         }

         if ((var6 & 2) != 0) {
            var2 = var0.buy;
         }

         if ((var6 & 4) != 0) {
            var3 = var0.replace;
         }

         if ((var6 & 8) != 0) {
            var4 = var0.urgentMsg;
         }

         if ((var6 & 16) != 0) {
            var5 = var0.normalMsg;
         }

         return var0.copy(var1, var2, var3, var4, var5);
      }

      public final int component1() {
         return this.state;
      }

      public final int component2() {
         return this.buy;
      }

      public final int component3() {
         return this.replace;
      }

      public final int component4() {
         return this.urgentMsg;
      }

      public final int component5() {
         return this.normalMsg;
      }

      public final StringSet copy(int var1, int var2, int var3, int var4, int var5) {
         return new StringSet(var1, var2, var3, var4, var5);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof StringSet)) {
            return false;
         } else {
            var1 = var1;
            if (this.state != var1.state) {
               return false;
            } else if (this.buy != var1.buy) {
               return false;
            } else if (this.replace != var1.replace) {
               return false;
            } else if (this.urgentMsg != var1.urgentMsg) {
               return false;
            } else {
               return this.normalMsg == var1.normalMsg;
            }
         }
      }

      public final int getBuy() {
         return this.buy;
      }

      public final int getNormalMsg() {
         return this.normalMsg;
      }

      public final int getReplace() {
         return this.replace;
      }

      public final int getState() {
         return this.state;
      }

      public final int getUrgentMsg() {
         return this.urgentMsg;
      }

      public int hashCode() {
         return (((this.state * 31 + this.buy) * 31 + this.replace) * 31 + this.urgentMsg) * 31 + this.normalMsg;
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("StringSet(state=");
         var1.append(this.state);
         var1.append(", buy=");
         var1.append(this.buy);
         var1.append(", replace=");
         var1.append(this.replace);
         var1.append(", urgentMsg=");
         var1.append(this.urgentMsg);
         var1.append(", normalMsg=");
         var1.append(this.normalMsg);
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
      public static final int[] $EnumSwitchMapping$1;
      public static final int[] $EnumSwitchMapping$2;

      static {
         int[] var0 = new int[NotificationMsgType.values().length];

         try {
            var0[NotificationMsgType.FILTER_LIFE.ordinal()] = 1;
         } catch (NoSuchFieldError var11) {
         }

         try {
            var0[NotificationMsgType.AQI.ordinal()] = 2;
         } catch (NoSuchFieldError var10) {
         }

         $EnumSwitchMapping$0 = var0;
         var0 = new int[DeviceFilterType.values().length];

         try {
            var0[DeviceFilterType.FILTER.ordinal()] = 1;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[DeviceFilterType.WICK.ordinal()] = 2;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[DeviceFilterType.REFRESHER.ordinal()] = 3;
         } catch (NoSuchFieldError var7) {
         }

         $EnumSwitchMapping$1 = var0;
         var0 = new int[AqiHumLevel.values().length];

         try {
            var0[AqiHumLevel.DRY.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[AqiHumLevel.VERY_DRY.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[AqiHumLevel.MOSIT.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[AqiHumLevel.VERY_MOSIT.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[AqiHumLevel.IDEAL.ordinal()] = 5;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$2 = var0;
      }
   }
}
