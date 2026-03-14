package com.blueair.android.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.util.TypedValueCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bin.david.form.core.SmartTable;
import com.bin.david.form.core.TableConfig;
import com.bin.david.form.data.format.bg.BaseBackgroundFormat;
import com.bin.david.form.data.format.bg.IBackgroundFormat;
import com.bin.david.form.data.style.FontStyle;
import com.bin.david.form.data.style.LineStyle;
import com.blueair.android.databinding.ActivityInfoDetailBinding;
import com.blueair.core.model.I18nConfig;
import com.blueair.core.model.UserInfoCollectionGroup;
import com.blueair.core.model.UserInfoCollectionItem;
import com.blueair.core.model.UserInfoCollectionRecord;
import com.blueair.core.util.UserInfoCollectionsManager;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.activity.BaseLokaliseActivity;
import com.blueair.viewcore.dialog.DialogUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

@Metadata(
   d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\u0006\u0010\u0015\u001a\u00020\u0012J\b\u0010\u0016\u001a\u00020\u0012H\u0002J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\rH\u0002J\n\u0010\u0019\u001a\u00020\u0005*\u00020\u001aR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001c"},
   d2 = {"Lcom/blueair/android/activity/InfoDetailActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/android/databinding/ActivityInfoDetailBinding;", "selectedPeriodIndex", "", "periods", "", "groupId", "group", "Lcom/blueair/core/model/UserInfoCollectionGroup;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "configure", "refreshData", "loadCell", "Lcom/blueair/android/activity/InfoItemRecord;", "value", "Lcom/blueair/core/model/I18nConfig;", "Companion", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class InfoDetailActivity extends BaseActivity {
   public static final int $stable = 8;
   public static final String ARG_GROUP_ID = "group_id";
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private ActivityInfoDetailBinding binding;
   private UserInfoCollectionGroup group;
   private String groupId = "";
   private final List periods = CollectionsKt.listOf(new String[]{"7天", "30天", "一年"});
   private final String screenName = "side_menu_policy_user_info_details";
   private int selectedPeriodIndex;

   // $FF: synthetic method
   public static CharSequence $r8$lambda$2mr5FEtodQkTRX0bNtiZiyJv4mk(UserInfoCollectionRecord var0) {
      return loadCell$lambda$12$lambda$10(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$_0YIDSklwLMwEfU8ft5zdsVfkJ4(InfoDetailActivity var0, View var1) {
      configure$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$t7le2LFuRN2sn0LQYs45Yq1LjIo(InfoDetailActivity var0, int var1, String var2) {
      return configure$lambda$4$lambda$3(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$vNkRLsSo9zJq4gZnHsAKM5AwHQY(InfoDetailActivity var0, View var1) {
      configure$lambda$4(var0, var1);
   }

   private static final void configure$lambda$2(InfoDetailActivity var0, View var1) {
      var0.finish();
   }

   private static final void configure$lambda$4(InfoDetailActivity var0, View var1) {
      DialogUtils var3 = DialogUtils.INSTANCE;
      ActivityInfoDetailBinding var2 = var0.binding;
      ActivityInfoDetailBinding var4 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      TextView var5 = var4.tvPeriods;
      Intrinsics.checkNotNullExpressionValue(var5, "tvPeriods");
      DialogUtils.showDropDownList$default(var3, (View)var5, var0.periods, 0, 0, 0, 0, false, new InfoDetailActivity$$ExternalSyntheticLambda1(var0), 124, (Object)null);
   }

   private static final Unit configure$lambda$4$lambda$3(InfoDetailActivity var0, int var1, String var2) {
      Intrinsics.checkNotNullParameter(var2, "<unused var>");
      if (var1 != var0.selectedPeriodIndex) {
         var0.selectedPeriodIndex = var1;
         var0.refreshData();
      }

      return Unit.INSTANCE;
   }

   private final List loadCell() {
      List var10 = (List)(new ArrayList());
      int var1 = this.selectedPeriodIndex;
      long var3;
      if (var1 != 0) {
         if (var1 != 1) {
            var3 = 31536000000L;
         } else {
            var3 = 2592000000L;
         }
      } else {
         var3 = 604800000L;
      }

      long var5 = System.currentTimeMillis();
      UserInfoCollectionGroup var9 = this.group;
      UserInfoCollectionGroup var8 = var9;
      if (var9 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("group");
         var8 = null;
      }

      for(UserInfoCollectionItem var22 : (Iterable)var8.getItems()) {
         Iterable var18 = (Iterable)var22.getRecords();
         boolean var7 = var18 instanceof Collection;
         var1 = 0;
         int var2 = 0;
         if (!var7 || !((Collection)var18).isEmpty()) {
            Iterator var19 = var18.iterator();

            while(true) {
               var1 = var2;
               if (!var19.hasNext()) {
                  break;
               }

               if (((UserInfoCollectionRecord)var19.next()).getTime() >= var5 - var3) {
                  var1 = var2 + 1;
                  var2 = var1;
                  if (var1 < 0) {
                     CollectionsKt.throwCountOverflow();
                     var2 = var1;
                  }
               }
            }
         }

         var2 = var1;
         if (var1 == var22.getRecords().size()) {
            var2 = var1 + var22.getOmitted();
         }

         Iterable var12 = (Iterable)var22.getRecords();
         Collection var20 = (Collection)(new ArrayList());

         for(Object var25 : var12) {
            if (((CharSequence)((UserInfoCollectionRecord)var25).getValue()).length() > 0) {
               var20.add(var25);
            }
         }

         List var26 = (List)var20;
         String var21;
         if (var26.isEmpty()) {
            var21 = "/";
         } else {
            var21 = CollectionsKt.joinToString$default((Iterable)CollectionsKt.takeLast(var26, 2), (CharSequence)"\n", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, new InfoDetailActivity$$ExternalSyntheticLambda0(), 30, (Object)null);
            if (var26.size() > 2) {
               StringBuilder var27 = new StringBuilder();
               var27.append(var21);
               var27.append("\n......");
               var21 = var27.toString();
            }
         }

         String var28 = this.value(var22.getName());
         String var29 = this.value(var22.getScenario());
         String var14 = this.value(var22.getUsage());
         String var24;
         if (var2 > 0) {
            StringBuilder var23 = new StringBuilder("已收集");
            var23.append(var2);
            var23.append('次');
            var24 = var23.toString();
         } else {
            var24 = "未收集";
         }

         var10.add(new InfoItemRecord(var28, var29, var14, var24, var21));
      }

      return var10;
   }

   private static final CharSequence loadCell$lambda$12$lambda$10(UserInfoCollectionRecord var0) {
      Intrinsics.checkNotNullParameter(var0, "it");
      String var2 = var0.getValue();
      if (var2.length() >= 4) {
         StringBuilder var1 = new StringBuilder();
         var1.append(StringsKt.take(var2, 2));
         var1.append("***");
         var1.append(StringsKt.takeLast(var2, 2));
         var2 = var1.toString();
      }

      return (CharSequence)var2;
   }

   private final void refreshData() {
      ActivityInfoDetailBinding var3 = this.binding;
      Object var2 = null;
      ActivityInfoDetailBinding var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      var1.tvPeriods.setText((CharSequence)this.periods.get(this.selectedPeriodIndex));
      var1 = this.binding;
      if (var1 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = (ActivityInfoDetailBinding)var2;
      }

      SmartTable var5 = var1.tableView;
      var5.setData(this.loadCell());
      var5.invalidate();
   }

   public final void configure() {
      Intent var3 = this.getIntent();
      if (var3 != null) {
         String var7 = var3.getStringExtra("group_id");
         if (var7 != null) {
            this.groupId = var7;
         }
      }

      Iterator var5 = ((Iterable)UserInfoCollectionsManager.INSTANCE.getCollections()).iterator();

      Object var4;
      do {
         boolean var2 = var5.hasNext();
         var4 = null;
         if (!var2) {
            var8 = null;
            break;
         }

         var8 = var5.next();
      } while(!Intrinsics.areEqual(((UserInfoCollectionGroup)var8).getId(), this.groupId));

      UserInfoCollectionGroup var9 = (UserInfoCollectionGroup)var8;
      if (var9 != null) {
         this.group = var9;
         ActivityInfoDetailBinding var17 = this.binding;
         ActivityInfoDetailBinding var10 = var17;
         if (var17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var10 = null;
         }

         AppCompatTextView var6 = var10.tvTitle;
         UserInfoCollectionGroup var18 = this.group;
         UserInfoCollectionGroup var11 = var18;
         if (var18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("group");
            var11 = null;
         }

         var6.setText((CharSequence)var11.getName().getValue());
         ActivityInfoDetailBinding var19 = this.binding;
         ActivityInfoDetailBinding var12 = var19;
         if (var19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var12 = null;
         }

         var12.btnBack.setOnClickListener(new InfoDetailActivity$$ExternalSyntheticLambda2(this));
         var19 = this.binding;
         var12 = var19;
         if (var19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var12 = null;
         }

         var12.tvPeriods.setOnClickListener(new InfoDetailActivity$$ExternalSyntheticLambda3(this));
         var12 = this.binding;
         if (var12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var12 = (ActivityInfoDetailBinding)var4;
         }

         TableConfig var16 = var12.tableView.getConfig();
         int var1 = MathKt.roundToInt(TypedValueCompat.dpToPx(1.0F, this.getResources().getDisplayMetrics()) * (float)16);
         var16.setShowTableTitle(false);
         var16.setShowXSequence(false);
         var16.setShowYSequence(false);
         var16.setColumnTitleHorizontalPadding(var1);
         var16.setColumnTitleVerticalPadding(var1);
         var16.setHorizontalPadding(var1);
         var16.setVerticalPadding(var1);
         var16.setContentBackground((IBackgroundFormat)(new BaseBackgroundFormat(-1)));
         Context var15 = (Context)this;
         var16.setContentGridStyle(new LineStyle(var15, 1.0F, this.getColor(R.color.surface_dark_10)));
         var16.setColumnTitleGridStyle(var16.getContentGridStyle());
         var16.setSequenceGridStyle(var16.getContentGridStyle());
         var16.setColumnTitleStyle(new FontStyle(var15, 14, this.getColor(R.color.colorPrimaryText)));
         var16.setContentStyle(new FontStyle(var15, 14, this.getColor(R.color.surface_dark_65)));
         this.refreshData();
      }
   }

   protected String getScreenName() {
      return this.screenName;
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      ViewDataBinding var2 = DataBindingUtil.setContentView((Activity)this, com.blueair.android.R.layout.activity_info_detail);
      Intrinsics.checkNotNullExpressionValue(var2, "setContentView(...)");
      this.binding = (ActivityInfoDetailBinding)var2;
      BaseLokaliseActivity.setStatusBarColor$default(this, this.getColor(R.color.light_sliver), (Boolean)null, 2, (Object)null);
      this.configure();
   }

   public final String value(I18nConfig var1) {
      Intrinsics.checkNotNullParameter(var1, "<this>");
      String var2 = var1.getValue();
      String var3 = var2;
      if (var2 == null) {
         var3 = "/";
      }

      return var3;
   }

   @Metadata(
      d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"},
      d2 = {"Lcom/blueair/android/activity/InfoDetailActivity$Companion;", "", "<init>", "()V", "ARG_GROUP_ID", "", "launch", "", "context", "Landroid/content/Context;", "groupId", "app_otherRelease"},
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

      public final void launch(Context var1, String var2) {
         Intrinsics.checkNotNullParameter(var1, "context");
         Intrinsics.checkNotNullParameter(var2, "groupId");
         Intent var3 = new Intent(var1, InfoDetailActivity.class);
         if (!(var1 instanceof Activity)) {
            var3.addFlags(268435456);
         }

         var3.putExtra("group_id", var2);
         var1.startActivity(var3);
      }
   }
}
