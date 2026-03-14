package com.blueair.core.model;

import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0016B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0017"},
   d2 = {"Lcom/blueair/core/model/AqiHumLevel;", "", "level", "", "minValue", "", "maxValue", "<init>", "(Ljava/lang/String;IIFF)V", "getLevel", "()I", "getMinValue", "()F", "getMaxValue", "VERY_DRY", "DRY", "IDEAL", "MOSIT", "VERY_MOSIT", "isWorseThan", "", "other", "Companion", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public enum AqiHumLevel {
   private static final EnumEntries $ENTRIES;
   private static final AqiHumLevel[] $VALUES;
   public static final Companion Companion;
   DRY,
   IDEAL,
   MOSIT,
   VERY_DRY,
   VERY_MOSIT;

   private static final Map worseRelations;
   private final int level;
   private final float maxValue;
   private final float minValue;

   // $FF: synthetic method
   private static final AqiHumLevel[] $values() {
      return new AqiHumLevel[]{VERY_DRY, DRY, IDEAL, MOSIT, VERY_MOSIT};
   }

   static {
      AqiHumLevel var4 = new AqiHumLevel("VERY_DRY", 0, 0, 0.0F, 10.0F);
      VERY_DRY = var4;
      AqiHumLevel var2 = new AqiHumLevel("DRY", 1, 1, 11.0F, 29.0F);
      DRY = var2;
      AqiHumLevel var1 = new AqiHumLevel("IDEAL", 2, 2, 30.0F, 50.0F);
      IDEAL = var1;
      AqiHumLevel var3 = new AqiHumLevel("MOSIT", 3, 3, 51.0F, 70.0F);
      MOSIT = var3;
      AqiHumLevel var0 = new AqiHumLevel("VERY_MOSIT", 4, 4, 71.0F, 100.0F);
      VERY_MOSIT = var0;
      AqiHumLevel[] var5 = $values();
      $VALUES = var5;
      $ENTRIES = EnumEntriesKt.enumEntries(var5);
      Companion = new Companion((DefaultConstructorMarker)null);
      worseRelations = MapsKt.mapOf(new Pair[]{TuplesKt.to(var0, new AqiHumLevel[]{var2, var4}), TuplesKt.to(var3, new AqiHumLevel[]{var2, var4, var0}), TuplesKt.to(var2, new AqiHumLevel[]{var3, var4, var0}), TuplesKt.to(var4, new AqiHumLevel[]{var3, var0}), TuplesKt.to(var1, new AqiHumLevel[]{var3, var0, var2, var4})});
   }

   private AqiHumLevel(int var3, float var4, float var5) {
      this.level = var3;
      this.minValue = var4;
      this.maxValue = var5;
   }

   public static EnumEntries getEntries() {
      return $ENTRIES;
   }

   public final int getLevel() {
      return this.level;
   }

   public final float getMaxValue() {
      return this.maxValue;
   }

   public final float getMinValue() {
      return this.minValue;
   }

   public final boolean isWorseThan(AqiHumLevel var1) {
      Intrinsics.checkNotNullParameter(var1, "other");
      var1 = (AqiHumLevel[])worseRelations.get(var1);
      return var1 != null && ArraysKt.contains(var1, this);
   }

   @Metadata(
      d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rR \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"},
      d2 = {"Lcom/blueair/core/model/AqiHumLevel$Companion;", "", "<init>", "()V", "worseRelations", "", "Lcom/blueair/core/model/AqiHumLevel;", "", "fromHumValue", "hum", "", "fromLevel", "level", "", "core_otherRelease"},
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

      public final AqiHumLevel fromHumValue(float var1) {
         for(AqiHumLevel var4 : AqiHumLevel.getEntries()) {
            float var2 = var4.getMinValue();
            if (var1 <= var4.getMaxValue() && var2 <= var1) {
               return var4;
            }
         }

         return AqiHumLevel.IDEAL;
      }

      public final AqiHumLevel fromLevel(int var1) {
         Iterator var3 = ((Iterable)AqiHumLevel.getEntries()).iterator();

         Object var2;
         do {
            if (!var3.hasNext()) {
               var2 = null;
               break;
            }

            var2 = var3.next();
         } while(((AqiHumLevel)var2).getLevel() != var1);

         AqiHumLevel var4 = (AqiHumLevel)var2;
         return var4 == null ? AqiHumLevel.IDEAL : var4;
      }
   }
}
