package com.blueair.devicedetails.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.AlarmSound;
import com.blueair.devicedetails.databinding.HolderAlarmSoundBinding;
import com.blueair.devicedetails.viewholder.AlarmSoundHolder;
import com.blueair.viewcore.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u0018\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0019H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"},
   d2 = {"Lcom/blueair/devicedetails/adapter/AlarmSoundAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/devicedetails/viewholder/AlarmSoundHolder;", "mcuFirmware", "", "onSoundClicked", "Lkotlin/Function1;", "Lcom/blueair/core/model/AlarmSound;", "", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getMcuFirmware", "()Ljava/lang/String;", "value", "selectedSound", "getSelectedSound", "()Lcom/blueair/core/model/AlarmSound;", "setSelectedSound", "(Lcom/blueair/core/model/AlarmSound;)V", "items", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "holder", "position", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AlarmSoundAdapter extends RecyclerView.Adapter {
   private final List items;
   private final String mcuFirmware;
   private final Function1 onSoundClicked;
   private AlarmSound selectedSound;

   // $FF: synthetic method
   public static void $r8$lambda$BSWP40Lq9bx0_uCwfaT0Y7ajHiA/* $FF was: $r8$lambda$BSWP40Lq9bx0-uCwfaT0Y7ajHiA*/(AlarmSoundAdapter var0, AlarmSound var1, View var2) {
      onBindViewHolder$lambda$1$lambda$0(var0, var1, var2);
   }

   public AlarmSoundAdapter(String var1, Function1 var2) {
      Intrinsics.checkNotNullParameter(var1, "mcuFirmware");
      Intrinsics.checkNotNullParameter(var2, "onSoundClicked");
      super();
      this.mcuFirmware = var1;
      this.onSoundClicked = var2;
      this.selectedSound = AlarmSound.Birds;
      this.items = AlarmSound.Companion.entries(var1);
   }

   private static final void onBindViewHolder$lambda$1$lambda$0(AlarmSoundAdapter var0, AlarmSound var1, View var2) {
      var0.setSelectedSound(var1);
      var0.onSoundClicked.invoke(var1);
   }

   public int getItemCount() {
      return this.items.size();
   }

   public final String getMcuFirmware() {
      return this.mcuFirmware;
   }

   public final AlarmSound getSelectedSound() {
      return this.selectedSound;
   }

   public void onBindViewHolder(AlarmSoundHolder var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "holder");
      AlarmSound var3 = (AlarmSound)this.items.get(var2);
      HolderAlarmSoundBinding var4 = var1.getBinding();
      var4.getRoot().setOnClickListener(new AlarmSoundAdapter$$ExternalSyntheticLambda0(this, var3));
      var4.title.setText(var3.getName(this.mcuFirmware));
      TextView var5 = var4.title;
      if (var3 == this.selectedSound) {
         var2 = R.drawable.ic_tick_16;
      } else {
         var2 = 0;
      }

      var5.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, var2, 0);
   }

   public AlarmSoundHolder onCreateViewHolder(ViewGroup var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "parent");
      return AlarmSoundHolder.Companion.newInstance(var1);
   }

   public final void setSelectedSound(AlarmSound var1) {
      Intrinsics.checkNotNullParameter(var1, "value");
      this.selectedSound = var1;
      this.notifyItemRangeChanged(0, this.items.size());
   }
}
