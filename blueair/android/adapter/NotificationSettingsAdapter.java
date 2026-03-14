package com.blueair.android.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.viewholder.NotificationSettingsViewHolder;
import com.blueair.core.model.NotificationSetting;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020#H\u0016J\u0018\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020#H\u0016R0\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR7\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016RL\u0010\u0017\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006("},
   d2 = {"Lcom/blueair/android/adapter/NotificationSettingsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/android/viewholder/NotificationSettingsViewHolder;", "<init>", "()V", "value", "", "Lcom/blueair/core/model/NotificationSetting;", "settings", "getSettings", "()Ljava/util/List;", "setSettings", "(Ljava/util/List;)V", "onShowInfoListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "setting", "", "getOnShowInfoListener", "()Lkotlin/jvm/functions/Function1;", "setOnShowInfoListener", "(Lkotlin/jvm/functions/Function1;)V", "onSettingChangedListener", "Lkotlin/Function2;", "old", "new", "getOnSettingChangedListener", "()Lkotlin/jvm/functions/Function2;", "setOnSettingChangedListener", "(Lkotlin/jvm/functions/Function2;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "holder", "position", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class NotificationSettingsAdapter extends RecyclerView.Adapter {
   public static final int $stable = 8;
   private Function2 onSettingChangedListener;
   private Function1 onShowInfoListener;
   private List settings = CollectionsKt.emptyList();

   // $FF: synthetic method
   public static void $r8$lambda$_Tvjl_rpybNCa1KKHoAHbmkaqAA/* $FF was: $r8$lambda$-Tvjl_rpybNCa1KKHoAHbmkaqAA*/(NotificationSettingsAdapter var0, NotificationSetting var1, CompoundButton var2, boolean var3) {
      onBindViewHolder$lambda$1(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static void $r8$lambda$HwIW__yMP9CFO148LsXtDoeKv74/* $FF was: $r8$lambda$HwIW_-yMP9CFO148LsXtDoeKv74*/(NotificationSettingsAdapter var0, NotificationSetting var1, View var2) {
      onBindViewHolder$lambda$0(var0, var1, var2);
   }

   private static final void onBindViewHolder$lambda$0(NotificationSettingsAdapter var0, NotificationSetting var1, View var2) {
      Function1 var3 = var0.onShowInfoListener;
      if (var3 != null) {
         var3.invoke(var1);
      }

   }

   private static final void onBindViewHolder$lambda$1(NotificationSettingsAdapter var0, NotificationSetting var1, CompoundButton var2, boolean var3) {
      Function2 var4 = var0.onSettingChangedListener;
      if (var4 != null) {
         var4.invoke(var1, NotificationSetting.copy$default(var1, (String)null, var3, (Integer)null, 5, (Object)null));
      }

   }

   public int getItemCount() {
      return this.settings.size();
   }

   public final Function2 getOnSettingChangedListener() {
      return this.onSettingChangedListener;
   }

   public final Function1 getOnShowInfoListener() {
      return this.onShowInfoListener;
   }

   public final List getSettings() {
      return this.settings;
   }

   public void onBindViewHolder(NotificationSettingsViewHolder var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "holder");
      NotificationSetting var3 = (NotificationSetting)this.settings.get(var2);
      var1.bind(var3);
      var1.getBinding().typeText.setOnClickListener(new NotificationSettingsAdapter$$ExternalSyntheticLambda0(this, var3));
      var1.getBinding().typeSwitch.setOnCheckedChangeListener(new NotificationSettingsAdapter$$ExternalSyntheticLambda1(this, var3));
   }

   public NotificationSettingsViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "parent");
      return NotificationSettingsViewHolder.Companion.newInstance(var1);
   }

   public final void setOnSettingChangedListener(Function2 var1) {
      this.onSettingChangedListener = var1;
   }

   public final void setOnShowInfoListener(Function1 var1) {
      this.onShowInfoListener = var1;
   }

   public final void setSettings(List var1) {
      Intrinsics.checkNotNullParameter(var1, "value");
      this.settings = var1;
      this.notifyDataSetChanged();
   }
}
