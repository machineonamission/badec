package com.blueair.devicedetails.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.DeviceData;
import com.blueair.core.model.DeviceDehumidifier;
import com.blueair.core.model.DeviceHumidifier;
import com.blueair.core.model.DeviceHumidifier20;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.SensorType;
import com.blueair.core.util.IndoorAirRatingRanges;
import com.blueair.devicedetails.viewholder.DeviceSensorCardHolder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u00105\u001a\u0002032\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u00106\u001a\u0002032\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u00107\u001a\u0002032\u0006\u00108\u001a\u000209J\b\u0010:\u001a\u00020\u001aH\u0002J\b\u0010;\u001a\u00020<H\u0016J\u0018\u0010=\u001a\u00020\u00022\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020<H\u0016J\u0018\u0010A\u001a\u0002032\u0006\u0010B\u001a\u00020\u00022\u0006\u0010C\u001a\u00020<H\u0016R0\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR(\u0010 \u001a\u0004\u0018\u00010\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010+\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u001a@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010/\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u001a@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.¨\u0006D"},
   d2 = {"Lcom/blueair/devicedetails/adapter/DeviceSensorCardsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/devicedetails/viewholder/DeviceSensorCardHolder;", "<init>", "()V", "value", "", "Lcom/blueair/core/model/SensorType;", "sensors", "getSensors", "()Ljava/util/List;", "setSensors", "(Ljava/util/List;)V", "originSensors", "sensorValues", "", "", "dontSortSensorSet", "", "getDontSortSensorSet", "()Ljava/util/Set;", "dontSortSensorSet$delegate", "Lkotlin/Lazy;", "sensorValueUpdateTime", "", "isStandByOn", "", "isOffline", "liveSelectedSensorType", "Landroidx/lifecycle/MutableLiveData;", "getLiveSelectedSensorType", "()Landroidx/lifecycle/MutableLiveData;", "selectedSensorType", "getSelectedSensorType", "()Lcom/blueair/core/model/SensorType;", "setSelectedSensorType", "(Lcom/blueair/core/model/SensorType;)V", "device", "Lcom/blueair/core/model/HasSensorData;", "getDevice", "()Lcom/blueair/core/model/HasSensorData;", "setDevice", "(Lcom/blueair/core/model/HasSensorData;)V", "isCelsius", "()Z", "setCelsius", "(Z)V", "tintDark", "getTintDark", "setTintDark", "notifySensorItemChanged", "", "sensorType", "setStandBy", "setOffline", "updateSensorData", "data", "Lcom/blueair/core/model/DeviceData;", "shouldSortSensor", "getItemCount", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceSensorCardsAdapter extends RecyclerView.Adapter {
   public HasSensorData device;
   private final Lazy dontSortSensorSet$delegate = LazyKt.lazy(new DeviceSensorCardsAdapter$$ExternalSyntheticLambda1());
   private boolean isCelsius = true;
   private boolean isOffline;
   private boolean isStandByOn;
   private final MutableLiveData liveSelectedSensorType = new MutableLiveData((Object)null);
   private List originSensors = CollectionsKt.emptyList();
   private SensorType selectedSensorType;
   private long sensorValueUpdateTime;
   private final Map sensorValues = (Map)(new LinkedHashMap());
   private List sensors = CollectionsKt.emptyList();
   private boolean tintDark;

   // $FF: synthetic method
   public static void $r8$lambda$DfOrgnJaExcmOyh1fgCjJVuGKaE(DeviceSensorCardsAdapter var0, SensorType var1, View var2) {
      onBindViewHolder$lambda$10(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Set $r8$lambda$LSzQfBLrr_6Y8nkVWILjk1_xjBE() {
      return dontSortSensorSet_delegate$lambda$0();
   }

   private static final Set dontSortSensorSet_delegate$lambda$0() {
      return SetsKt.setOf(new SensorType[]{SensorType.HUM, SensorType.TMP});
   }

   private final Set getDontSortSensorSet() {
      return (Set)this.dontSortSensorSet$delegate.getValue();
   }

   private final void notifySensorItemChanged(SensorType var1) {
      if (var1 != null) {
         int var2 = this.sensors.indexOf(var1);
         if (var2 >= 0) {
            this.notifyItemChanged(var2);
         }
      }

   }

   private static final void onBindViewHolder$lambda$10(DeviceSensorCardsAdapter var0, SensorType var1, View var2) {
      var0.setSelectedSensorType(var1);
   }

   private final boolean shouldSortSensor() {
      return !(this.getDevice() instanceof DeviceDehumidifier) && !(this.getDevice() instanceof DeviceHumidifier) && !(this.getDevice() instanceof DeviceHumidifier20);
   }

   public final HasSensorData getDevice() {
      HasSensorData var1 = this.device;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("device");
         return null;
      }
   }

   public int getItemCount() {
      return this.sensors.size();
   }

   public final MutableLiveData getLiveSelectedSensorType() {
      return this.liveSelectedSensorType;
   }

   public final SensorType getSelectedSensorType() {
      return this.selectedSensorType;
   }

   public final List getSensors() {
      return this.sensors;
   }

   public final boolean getTintDark() {
      return this.tintDark;
   }

   public final boolean isCelsius() {
      return this.isCelsius;
   }

   public void onBindViewHolder(DeviceSensorCardHolder var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "holder");
      SensorType var9 = (SensorType)this.sensors.get(var2);
      var1.getBinding().getRoot().setOnClickListener(new DeviceSensorCardsAdapter$$ExternalSyntheticLambda0(this, var9));
      var1.setTintDark(this.tintDark);
      var1.setCelsius(this.isCelsius);
      HasSensorData var10 = this.getDevice();
      Float var8 = (Float)this.sensorValues.get(var9);
      long var3 = this.sensorValueUpdateTime;
      boolean var7 = this.isStandByOn;
      boolean var6 = this.isOffline;
      boolean var5;
      if (this.selectedSensorType == var9) {
         var5 = true;
      } else {
         var5 = false;
      }

      var1.update(var10, var9, var8, var3, var7, var6, var5);
   }

   public DeviceSensorCardHolder onCreateViewHolder(ViewGroup var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "parent");
      return DeviceSensorCardHolder.Companion.newInstance(var1, this.isCelsius);
   }

   public final void setCelsius(boolean var1) {
      if (this.isCelsius != var1) {
         this.isCelsius = var1;
         this.notifySensorItemChanged(SensorType.TMP);
      }

   }

   public final void setDevice(HasSensorData var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.device = var1;
   }

   public final void setOffline(boolean var1) {
      if (var1 != this.isOffline) {
         this.isOffline = var1;
         this.notifyDataSetChanged();
      }
   }

   public final void setSelectedSensorType(SensorType var1) {
      SensorType var2 = this.selectedSensorType;
      if (var2 != var1) {
         this.notifySensorItemChanged(var2);
         this.selectedSensorType = var1;
         this.notifySensorItemChanged(var1);
         this.liveSelectedSensorType.setValue(var1);
      }

   }

   public final void setSensors(List var1) {
      Intrinsics.checkNotNullParameter(var1, "value");
      this.sensors = var1;
      if (this.originSensors.isEmpty()) {
         this.originSensors = var1;
      }

   }

   public final void setStandBy(boolean var1) {
      if (var1 != this.isStandByOn) {
         this.isStandByOn = var1;
         this.notifyDataSetChanged();
      }
   }

   public final void setTintDark(boolean var1) {
      if (this.tintDark != var1) {
         this.tintDark = var1;
         this.notifyDataSetChanged();
      }

   }

   public final void updateSensorData(DeviceData var1) {
      Intrinsics.checkNotNullParameter(var1, "data");
      Iterator var11 = ((Iterable)var1.getRawDataPoints()).iterator();
      Object var15;
      if (!var11.hasNext()) {
         var15 = null;
      } else {
         var15 = var11.next();
         if (var11.hasNext()) {
            long var3 = ((IndoorDatapoint)var15).getTimeInSeconds();
            Object var9 = var15;

            do {
               Object var10 = var11.next();
               long var7 = ((IndoorDatapoint)var10).getTimeInSeconds();
               var15 = var9;
               long var5 = var3;
               if (var3 < var7) {
                  var15 = var10;
                  var5 = var7;
               }

               var9 = var15;
               var3 = var5;
            } while(var11.hasNext());
         }
      }

      IndoorDatapoint var30 = (IndoorDatapoint)var15;
      if (var30 == null) {
         for(SensorType var31 : (Iterable)this.originSensors) {
            this.sensorValues.put(var31, (Object)null);
         }
      } else {
         for(SensorType var32 : (Iterable)this.originSensors) {
            Map var12 = this.sensorValues;
            Float var17;
            switch (DeviceSensorCardsAdapter.WhenMappings.$EnumSwitchMapping$0[var32.ordinal()]) {
               case 1:
                  var17 = var30.getPm1();
                  break;
               case 2:
                  var17 = var30.getPm25();
                  break;
               case 3:
                  var17 = var30.getPm10();
                  break;
               case 4:
                  var17 = var30.getVoc();
                  break;
               case 5:
                  var17 = var30.getHcho();
                  break;
               case 6:
                  var17 = var30.getHum();
                  break;
               case 7:
                  var17 = var30.getTmp();
                  break;
               case 8:
                  var17 = var30.getFan();
                  break;
               case 9:
                  var17 = var30.getWeight();
                  break;
               case 10:
                  var17 = var30.getRpm();
                  break;
               default:
                  throw new NoWhenBranchMatchedException();
            }

            var12.put(var32, var17);
         }

         if (this.sensorValueUpdateTime == 0L && this.shouldSortSensor()) {
            IndoorAirRatingRanges var33 = IndoorAirRatingRanges.Companion.instance(this.getDevice());
            Iterable var41 = (Iterable)this.originSensors;
            ArrayList var18 = new ArrayList();
            ArrayList var38 = new ArrayList();

            for(Object var14 : var41) {
               SensorType var42 = (SensorType)var14;
               if (this.getDontSortSensorSet().contains(var42)) {
                  var18.add(var14);
               } else {
                  var38.add(var14);
               }
            }

            Pair var19 = new Pair(var18, var38);
            List var39 = (List)var19.component1();
            List var20 = (List)var19.component2();
            if (var20.isEmpty()) {
               var20 = this.originSensors;
            } else {
               Iterable var22 = (Iterable)var20;
               Collection var43 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var22, 10)));

               for(SensorType var45 : var22) {
                  Float var23 = (Float)this.sensorValues.get(var45);
                  Double var24;
                  if (var23 != null) {
                     var24 = (double)var23;
                  } else {
                     var24 = null;
                  }

                  int var2;
                  label99: {
                     if (var24 != null) {
                        IndoorAirRatingRanges.IndoorAirRating var25 = var33.rating(((Number)var24).doubleValue(), var45);
                        Integer var26;
                        if (var25 != null) {
                           var26 = var25.getRating();
                        } else {
                           var26 = null;
                        }

                        if (var26 != null) {
                           var2 = var26;
                           break label99;
                        }
                     }

                     var2 = -1;
                  }

                  var43.add(TuplesKt.to(var45, var2));
               }

               Iterable var34 = (Iterable)CollectionsKt.sortedWith((Iterable)((List)var43), new Comparator() {
                  public final int compare(Object var1, Object var2) {
                     return ComparisonsKt.compareValues((Comparable)((Number)((Pair)var2).component2()).intValue(), (Comparable)((Number)((Pair)var1).component2()).intValue());
                  }
               });
               Collection var27 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var34, 10)));
               Iterator var35 = var34.iterator();

               while(var35.hasNext()) {
                  var27.add((SensorType)((Pair)var35.next()).component1());
               }

               var20 = (List)var27;
               if (!var39.isEmpty()) {
                  ArrayDeque var40 = new ArrayDeque((Collection)var20);
                  Iterable var28 = (Iterable)this.originSensors;
                  Collection var36 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var28, 10)));

                  for(SensorType var29 : var28) {
                     if (!this.getDontSortSensorSet().contains(var29)) {
                        var29 = (SensorType)var40.removeFirst();
                     }

                     var36.add(var29);
                  }

                  var20 = (List)var36;
               }
            }

            this.setSensors(var20);
         }

         this.sensorValueUpdateTime = var30.getTimeInMillis();
      }

      this.notifyItemRangeChanged(0, this.getItemCount());
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
         int[] var0 = new int[SensorType.values().length];

         try {
            var0[SensorType.PM1.ordinal()] = 1;
         } catch (NoSuchFieldError var11) {
         }

         try {
            var0[SensorType.PM25.ordinal()] = 2;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[SensorType.PM10.ordinal()] = 3;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[SensorType.VOC.ordinal()] = 4;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[SensorType.HCHO.ordinal()] = 5;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[SensorType.HUM.ordinal()] = 6;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[SensorType.TMP.ordinal()] = 7;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[SensorType.FAN.ordinal()] = 8;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[SensorType.WEIGHT.ordinal()] = 9;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[SensorType.RPM.ordinal()] = 10;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
