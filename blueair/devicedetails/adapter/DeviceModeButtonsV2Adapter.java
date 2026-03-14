package com.blueair.devicedetails.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.core.model.MainMode;
import com.blueair.devicedetails.viewholder.DeviceModeButtonV2Holder;
import com.blueair.viewcore.utils.ModeIcon;
import com.blueair.viewcore.utils.ModeIconKt;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(
   d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\"\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B6\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012%\b\u0002\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006¢\u0006\u0004\b\f\u0010\rJ\b\u00102\u001a\u00020\u000bH\u0002J\b\u00103\u001a\u000204H\u0016J\u0018\u00105\u001a\u00020\u00022\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000204H\u0016J\u0018\u00109\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\u00022\u0006\u0010;\u001a\u000204H\u0016J\u000e\u0010<\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR+\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u0018\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR0\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u001d2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u001d@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R0\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070\u001d2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u001d@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00070'X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010)\u001a\u0004\u0018\u00010(2\b\u0010\u0011\u001a\u0004\u0018\u00010(@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u000f\"\u0004\b0\u00101¨\u0006>"},
   d2 = {"Lcom/blueair/devicedetails/adapter/DeviceModeButtonsV2Adapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/devicedetails/viewholder/DeviceModeButtonV2Holder;", "forMainMode", "", "onModeSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/viewcore/utils/ModeIcon;", "Lkotlin/ParameterName;", "name", "mode", "", "<init>", "(ZLkotlin/jvm/functions/Function1;)V", "getForMainMode", "()Z", "hideModeIcon", "value", "Lcom/blueair/core/model/MainMode;", "mainMode", "getMainMode", "()Lcom/blueair/core/model/MainMode;", "setMainMode", "(Lcom/blueair/core/model/MainMode;)V", "modeValue", "getModeValue", "()Lcom/blueair/viewcore/utils/ModeIcon;", "setModeValue", "(Lcom/blueair/viewcore/utils/ModeIcon;)V", "", "disableModeValues", "getDisableModeValues", "()Ljava/util/Set;", "setDisableModeValues", "(Ljava/util/Set;)V", "stayOffModeValues", "getStayOffModeValues", "setStayOffModeValues", "modes", "", "Lcom/blueair/core/model/Device;", "device", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "forceOffline", "getForceOffline", "setForceOffline", "(Z)V", "refreshItems", "getItemCount", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "registerModeIconForHide", "modeIcon", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceModeButtonsV2Adapter extends RecyclerView.Adapter {
   private Device device;
   private Set disableModeValues;
   private final boolean forMainMode;
   private boolean forceOffline;
   private ModeIcon hideModeIcon;
   private MainMode mainMode;
   private ModeIcon modeValue;
   private List modes;
   private final Function1 onModeSelectedListener;
   private Set stayOffModeValues;

   // $FF: synthetic method
   public static void $r8$lambda$9XkFSWQ_TLQmwRimAIQau_HflV4/* $FF was: $r8$lambda$9XkFSWQ-TLQmwRimAIQau_HflV4*/(DeviceModeButtonsV2Adapter var0, ModeIcon var1, View var2) {
      onBindViewHolder$lambda$2(var0, var1, var2);
   }

   public DeviceModeButtonsV2Adapter(boolean var1, Function1 var2) {
      this.forMainMode = var1;
      this.onModeSelectedListener = var2;
      this.disableModeValues = SetsKt.emptySet();
      this.stayOffModeValues = SetsKt.emptySet();
      this.modes = CollectionsKt.emptyList();
   }

   // $FF: synthetic method
   public DeviceModeButtonsV2Adapter(boolean var1, Function1 var2, int var3, DefaultConstructorMarker var4) {
      if ((var3 & 2) != 0) {
         var2 = null;
      }

      this(var1, var2);
   }

   private static final void onBindViewHolder$lambda$2(DeviceModeButtonsV2Adapter var0, ModeIcon var1, View var2) {
      Function1 var3 = var0.onModeSelectedListener;
      if (var3 != null) {
         var3.invoke(var1);
      }

   }

   private final void refreshItems() {
      this.notifyItemRangeChanged(0, this.getItemCount());
   }

   public final Device getDevice() {
      return this.device;
   }

   public final Set getDisableModeValues() {
      return this.disableModeValues;
   }

   public final boolean getForMainMode() {
      return this.forMainMode;
   }

   public final boolean getForceOffline() {
      return this.forceOffline;
   }

   public int getItemCount() {
      return this.modes.size();
   }

   public final MainMode getMainMode() {
      return this.mainMode;
   }

   public final ModeIcon getModeValue() {
      return this.modeValue;
   }

   public final Set getStayOffModeValues() {
      return this.stayOffModeValues;
   }

   public void onBindViewHolder(DeviceModeButtonV2Holder var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "holder");
      ModeIcon var3 = (ModeIcon)this.modes.get(var2);
      ModeIcon var5 = this.modeValue;
      if (var5 != null) {
         HashSet var4 = SetsKt.hashSetOf(new ModeIcon[]{var5});
         if (var5 == ModeIcon.ECO && this.device instanceof DeviceNewClassic && var3 == ModeIcon.AUTO) {
            var4.add(var3);
         }

         Unit var7 = Unit.INSTANCE;
         var1.updateMode(var3, (Set)var4, this.stayOffModeValues, this.disableModeValues);
      } else {
         Device var6 = this.device;
         Intrinsics.checkNotNull(var6);
         var1.updateMode(var3, var6, this.forceOffline);
      }

      var1.getBinding().modeRoot.setOnClickListener(new DeviceModeButtonsV2Adapter$$ExternalSyntheticLambda0(this, var3));
   }

   public DeviceModeButtonV2Holder onCreateViewHolder(ViewGroup var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "parent");
      return DeviceModeButtonV2Holder.Companion.newInstance(var1, this.forMainMode);
   }

   public final void registerModeIconForHide(ModeIcon var1) {
      Intrinsics.checkNotNullParameter(var1, "modeIcon");
      this.hideModeIcon = var1;
   }

   public final void setDevice(Device var1) {
      if (!Intrinsics.areEqual(this.device, var1)) {
         this.device = var1;
         MainMode var2 = this.mainMode;
         this.modes = ModeIconKt.getSupportedModes(var1, true, this.forMainMode, var2);
         this.refreshItems();
      }

   }

   public final void setDisableModeValues(Set var1) {
      Intrinsics.checkNotNullParameter(var1, "value");
      if (!Intrinsics.areEqual(this.disableModeValues, var1)) {
         this.disableModeValues = var1;
         this.notifyDataSetChanged();
      }
   }

   public final void setForceOffline(boolean var1) {
      if (this.forceOffline != var1) {
         this.forceOffline = var1;
         this.refreshItems();
      }

   }

   public final void setMainMode(MainMode var1) {
      if (this.mainMode != var1) {
         this.mainMode = var1;
         List var5 = CollectionsKt.toMutableList((Collection)ModeIconKt.getSupportedModes(this.device, true, this.forMainMode, var1));
         int var2 = this.getItemCount();
         ModeIcon var3 = this.hideModeIcon;
         if (var3 != null && CollectionsKt.contains((Iterable)var5, var3)) {
            Collection var6 = (Collection)var5;
            ModeIcon var4 = this.hideModeIcon;
            TypeIntrinsics.asMutableCollection(var6).remove(var4);
         }

         this.modes = var5;
         if (this.getItemCount() != var2) {
            this.notifyDataSetChanged();
            return;
         }

         this.refreshItems();
      }

   }

   public final void setModeValue(ModeIcon var1) {
      if (this.modeValue != var1) {
         this.modeValue = var1;
         this.refreshItems();
      }
   }

   public final void setStayOffModeValues(Set var1) {
      Intrinsics.checkNotNullParameter(var1, "value");
      if (!Intrinsics.areEqual(this.stayOffModeValues, var1)) {
         this.stayOffModeValues = var1;
         this.notifyDataSetChanged();
      }
   }
}
