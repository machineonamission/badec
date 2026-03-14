package com.blueair.core.model;

import com.blueair.core.util.SkuConfigurationManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;

@Metadata(
   d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 &2\u00020\u0001:\u0018\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&B\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0017'()*+,-./0123456789:;<=¨\u0006>"},
   d2 = {"Lcom/blueair/core/model/DeviceType;", "", "index", "", "name", "", "<init>", "(ILjava/lang/String;)V", "getIndex", "()I", "getName", "()Ljava/lang/String;", "isNewPlatform", "", "hasSafetySwitch", "Unknown", "Classic", "G4", "Aware", "Sense", "Icp", "ClassicWithoutSensor", "B4", "B4sp", "BluePremium", "Blue", "NewClassic", "Humidifier", "Combo3in1", "Combo2in1", "Dehumidifier", "Pet20", "Blue40", "Humidifier20", "MiniRestful", "Combo2in120", "FanTable", "FanPremium", "Companion", "Lcom/blueair/core/model/DeviceType$Aware;", "Lcom/blueair/core/model/DeviceType$B4;", "Lcom/blueair/core/model/DeviceType$B4sp;", "Lcom/blueair/core/model/DeviceType$Blue;", "Lcom/blueair/core/model/DeviceType$Blue40;", "Lcom/blueair/core/model/DeviceType$BluePremium;", "Lcom/blueair/core/model/DeviceType$Classic;", "Lcom/blueair/core/model/DeviceType$ClassicWithoutSensor;", "Lcom/blueair/core/model/DeviceType$Combo2in1;", "Lcom/blueair/core/model/DeviceType$Combo2in120;", "Lcom/blueair/core/model/DeviceType$Combo3in1;", "Lcom/blueair/core/model/DeviceType$Dehumidifier;", "Lcom/blueair/core/model/DeviceType$FanPremium;", "Lcom/blueair/core/model/DeviceType$FanTable;", "Lcom/blueair/core/model/DeviceType$G4;", "Lcom/blueair/core/model/DeviceType$Humidifier;", "Lcom/blueair/core/model/DeviceType$Humidifier20;", "Lcom/blueair/core/model/DeviceType$Icp;", "Lcom/blueair/core/model/DeviceType$MiniRestful;", "Lcom/blueair/core/model/DeviceType$NewClassic;", "Lcom/blueair/core/model/DeviceType$Pet20;", "Lcom/blueair/core/model/DeviceType$Sense;", "Lcom/blueair/core/model/DeviceType$Unknown;", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public abstract class DeviceType {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final String HEALTH_PROTECT = "HealthProtect";
   public static final String PROTECT = "Protect";
   private static boolean isInG4ProtectRegion;
   private final int index;
   private final String name;

   private DeviceType(int var1, String var2) {
      this.index = var1;
      this.name = var2;
   }

   // $FF: synthetic method
   public DeviceType(int var1, String var2, DefaultConstructorMarker var3) {
      this(var1, var2);
   }

   public final int getIndex() {
      return this.index;
   }

   public final String getName() {
      return this.name;
   }

   public final boolean hasSafetySwitch() {
      return SetsKt.setOf(new DeviceType[]{DeviceType.G4.INSTANCE, DeviceType.Combo2in120.INSTANCE}).contains(this);
   }

   public final boolean isNewPlatform() {
      return SetsKt.setOf(new DeviceType[]{DeviceType.Classic.INSTANCE, DeviceType.Aware.INSTANCE, DeviceType.Sense.INSTANCE, DeviceType.Icp.INSTANCE, DeviceType.ClassicWithoutSensor.INSTANCE}).contains(this) ^ true;
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/DeviceType$Aware;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Aware extends DeviceType {
      public static final Aware INSTANCE = new Aware();

      private Aware() {
         super(2, "Aware", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/DeviceType$B4;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class B4 extends DeviceType {
      public static final B4 INSTANCE = new B4();

      private B4() {
         super(7, "B4", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/DeviceType$B4sp;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class B4sp extends DeviceType {
      public static final B4sp INSTANCE = new B4sp();

      private B4sp() {
         super(8, "B4SP", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/DeviceType$Blue;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Blue extends DeviceType {
      public static final Blue INSTANCE = new Blue();

      private Blue() {
         super(10, "NB", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/DeviceType$Blue40;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Blue40 extends DeviceType {
      public static final Blue40 INSTANCE = new Blue40();

      private Blue40() {
         super(17, "blue40", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/DeviceType$BluePremium;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class BluePremium extends DeviceType {
      public static final BluePremium INSTANCE = new BluePremium();

      private BluePremium() {
         super(9, "NB", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/DeviceType$Classic;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Classic extends DeviceType {
      public static final Classic INSTANCE = new Classic();

      private Classic() {
         super(0, "Classic", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/DeviceType$ClassicWithoutSensor;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class ClassicWithoutSensor extends DeviceType {
      public static final ClassicWithoutSensor INSTANCE = new ClassicWithoutSensor();

      private ClassicWithoutSensor() {
         super(6, "Classic", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/DeviceType$Combo2in1;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Combo2in1 extends DeviceType {
      public static final Combo2in1 INSTANCE = new Combo2in1();

      private Combo2in1() {
         super(14, "Combo2in1", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/DeviceType$Combo2in120;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Combo2in120 extends DeviceType {
      public static final Combo2in120 INSTANCE = new Combo2in120();

      private Combo2in120() {
         super(20, "cmb2in120", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/DeviceType$Combo3in1;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Combo3in1 extends DeviceType {
      public static final Combo3in1 INSTANCE = new Combo3in1();

      private Combo3in1() {
         super(13, "Combo3in1", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005J\u0010\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0010\u0010\u0014\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u000e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005J\u0010\u0010\u0018\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0019"},
      d2 = {"Lcom/blueair/core/model/DeviceType$Companion;", "", "<init>", "()V", "HEALTH_PROTECT", "", "PROTECT", "isInG4ProtectRegion", "", "()Z", "setInG4ProtectRegion", "(Z)V", "fromIndex", "Lcom/blueair/core/model/DeviceType;", "input", "", "fromName", "fromSkuCompat", "skuCompat", "fromCompatibility", "modelNameFromSkuCompat", "modelNameFromCompatibility", "familyNameFromSku", "sku", "displayNameFromSkuCompat", "core_otherRelease"},
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

      private final DeviceType fromCompatibility(String var1) {
         var1 = var1.toLowerCase(Locale.ROOT);
         Intrinsics.checkNotNullExpressionValue(var1, "toLowerCase(...)");
         switch (var1) {
            case "sense+":
               return DeviceType.Sense.INSTANCE;
            case "classic_205":
               return DeviceType.ClassicWithoutSensor.INSTANCE;
            case "classic_260":
               return DeviceType.ClassicWithoutSensor.INSTANCE;
            case "classic_305":
               return DeviceType.ClassicWithoutSensor.INSTANCE;
            case "classic_405":
               return DeviceType.ClassicWithoutSensor.INSTANCE;
            case "classic_460":
               return DeviceType.ClassicWithoutSensor.INSTANCE;
            case "classic_505":
               return DeviceType.ClassicWithoutSensor.INSTANCE;
            case "classic_605":
               return DeviceType.ClassicWithoutSensor.INSTANCE;
            case "classic_660":
               return DeviceType.ClassicWithoutSensor.INSTANCE;
            case "classic_205s":
               return DeviceType.Classic.INSTANCE;
            case "classic_260i":
               return DeviceType.Classic.INSTANCE;
            case "classic_280i":
               return DeviceType.Classic.INSTANCE;
            case "classic_290i":
               return DeviceType.Classic.INSTANCE;
            case "classic_380i":
               return DeviceType.Classic.INSTANCE;
            case "classic_405s":
               return DeviceType.Classic.INSTANCE;
            case "classic_460i":
               return DeviceType.Classic.INSTANCE;
            case "classic_480i":
               return DeviceType.Classic.INSTANCE;
            case "classic_490i":
               return DeviceType.Classic.INSTANCE;
            case "classic_580i":
               return DeviceType.Classic.INSTANCE;
            case "classic_605s":
               return DeviceType.Classic.INSTANCE;
            case "classic_680i":
               return DeviceType.Classic.INSTANCE;
            case "classic_690i":
               return DeviceType.Classic.INSTANCE;
            case "aware":
               return DeviceType.Aware.INSTANCE;
            case "classic":
               return DeviceType.ClassicWithoutSensor.INSTANCE;
            case "icp_p2i":
               return DeviceType.Icp.INSTANCE;
         }

         return null;
      }

      private final String modelNameFromCompatibility(String var1) {
         var1 = var1.toLowerCase(Locale.ROOT);
         Intrinsics.checkNotNullExpressionValue(var1, "toLowerCase(...)");
         switch (var1) {
            case "sense+":
               return DeviceType.Sense.INSTANCE.getName();
            case "classic_205":
               return "Classic 205";
            case "classic_260":
               return "Classic 260";
            case "classic_305":
               return "Classic 305";
            case "classic_405":
               return "Classic 405";
            case "classic_460":
               return "Classic 460";
            case "classic_505":
               return "Classic 505";
            case "classic_560":
               return "Classic 560";
            case "classic_605":
               return "Classic 605";
            case "classic_660":
               return "Classic 660";
            case "classic_205s":
               return "Classic 205S";
            case "classic_260i":
               return "Classic 260i";
            case "classic_280i":
               return "Classic 280i";
            case "classic_290i":
               return "Classic 290i";
            case "classic_380i":
               return "Classic 380i";
            case "classic_405s":
               return "Classic 405S";
            case "classic_460i":
               return "Classic 460i";
            case "classic_480i":
               return "Classic 480i";
            case "classic_490i":
               return "Classic 490i";
            case "classic_580i":
               return "Classic 580i";
            case "classic_605s":
               return "Classic 605S";
            case "classic_680i":
               return "Classic 680i";
            case "classic_690i":
               return "Classic 690i";
            case "aware":
               return DeviceType.Aware.INSTANCE.getName();
            case "classic":
               return DeviceType.Classic.INSTANCE.getName();
            case "icp_p2i":
               return DeviceType.Icp.INSTANCE.getName();
         }

         return null;
      }

      public final String displayNameFromSkuCompat(String var1) {
         CharSequence var2 = (CharSequence)var1;
         if (var2 != null && var2.length() != 0) {
            String var3 = this.familyNameFromSku(var1);
            String var7 = this.modelNameFromSkuCompat(var1);
            var1 = var7;
            if (!Intrinsics.areEqual(var3, DeviceType.Unknown.INSTANCE.getName())) {
               if (((CharSequence)var3).length() == 0) {
                  var1 = var7;
               } else {
                  CharSequence var4 = (CharSequence)var7;
                  var1 = var7;
                  if (!StringsKt.contains$default(var4, (CharSequence)"PCBA", false, 2, (Object)null)) {
                     if (StringsKt.contains$default(var4, (CharSequence)"Control Board", false, 2, (Object)null)) {
                        var1 = var7;
                     } else {
                        StringBuilder var6 = new StringBuilder();
                        var6.append(var3);
                        var6.append(' ');
                        var6.append(var7);
                        var1 = var6.toString();
                     }
                  }
               }
            }

            return var1;
         } else {
            return DeviceType.Unknown.INSTANCE.getName();
         }
      }

      public final String familyNameFromSku(String var1) {
         Intrinsics.checkNotNullParameter(var1, "sku");
         DeviceConfig var2 = SkuConfigurationManager.INSTANCE.getConfig().getDeviceConfig(var1);
         if (var2 == null) {
            return DeviceType.Unknown.INSTANCE.getName();
         } else if (Intrinsics.areEqual(var2.getType(), DeviceType.G4.INSTANCE) && !SkuConfigurationManager.INSTANCE.getConfig().skuIsG4Plus(var1)) {
            return this.isInG4ProtectRegion() ? "Protect" : "HealthProtect";
         } else {
            I18nConfig var3 = var2.getFamilyName();
            if (var3 != null) {
               String var4 = var3.getValue();
               if (var4 != null) {
                  return var4;
               }
            }

            return DeviceType.Unknown.INSTANCE.getName();
         }
      }

      public final DeviceType fromIndex(int var1) {
         Iterable var3 = (Iterable)Reflection.getOrCreateKotlinClass(DeviceType.class).getNestedClasses();
         Collection var5 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var3, 10)));
         Iterator var6 = var3.iterator();

         while(true) {
            boolean var2 = var6.hasNext();
            Object var4 = null;
            DeviceType var7 = null;
            if (!var2) {
               Iterator var11 = ((Iterable)((List)var5)).iterator();

               do {
                  var7 = (DeviceType)var4;
                  if (!var11.hasNext()) {
                     break;
                  }

                  var7 = (DeviceType)var11.next();
                  var12 = var7;
               } while(var12 == null || var12.getIndex() != var1);

               var7 = var7;
               return var7 == null ? (DeviceType)DeviceType.Unknown.INSTANCE : var7;
            }

            var4 = ((KClass)var6.next()).getObjectInstance();
            if (var4 instanceof DeviceType) {
               var7 = (DeviceType)var4;
            }

            var5.add(var7);
         }
      }

      public final DeviceType fromName(String var1) {
         Intrinsics.checkNotNullParameter(var1, "input");
         String var3 = var1;
         if (Intrinsics.areEqual(var1, "G4P")) {
            var3 = "G4";
         }

         Iterable var7 = (Iterable)Reflection.getOrCreateKotlinClass(DeviceType.class).getNestedClasses();
         Collection var5 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var7, 10)));
         Iterator var6 = var7.iterator();

         while(true) {
            boolean var2 = var6.hasNext();
            Object var4 = null;
            DeviceType var8 = null;
            if (!var2) {
               var6 = ((Iterable)((List)var5)).iterator();

               while(true) {
                  var8 = (DeviceType)var4;
                  if (!var6.hasNext()) {
                     break;
                  }

                  Object var14 = var6.next();
                  var8 = (DeviceType)var14;
                  String var11;
                  if (var8 != null) {
                     var11 = var8.getName();
                  } else {
                     var11 = null;
                  }

                  if (Intrinsics.areEqual(var11, var3)) {
                     var8 = (DeviceType)var14;
                     break;
                  }
               }

               var8 = var8;
               return var8 == null ? (DeviceType)DeviceType.Unknown.INSTANCE : var8;
            }

            var4 = ((KClass)var6.next()).getObjectInstance();
            if (var4 instanceof DeviceType) {
               var8 = (DeviceType)var4;
            }

            var5.add(var8);
         }
      }

      public final DeviceType fromSkuCompat(String var1) {
         CharSequence var2 = (CharSequence)var1;
         if (var2 != null && var2.length() != 0) {
            DeviceConfig var4 = SkuConfigurationManager.INSTANCE.getConfig().getDeviceConfig(var1);
            if (var4 != null) {
               DeviceType var5 = var4.getType();
               if (var5 != null) {
                  return var5;
               }
            }

            DeviceType var6 = this.fromCompatibility(var1);
            DeviceType var3 = var6;
            if (var6 == null) {
               var3 = DeviceType.Unknown.INSTANCE;
            }

            return var3;
         } else {
            return DeviceType.Unknown.INSTANCE;
         }
      }

      public final boolean isInG4ProtectRegion() {
         return DeviceType.isInG4ProtectRegion;
      }

      public final String modelNameFromSkuCompat(String var1) {
         CharSequence var2 = (CharSequence)var1;
         if (var2 != null && var2.length() != 0) {
            DeviceConfig var4 = SkuConfigurationManager.INSTANCE.getConfig().getDeviceConfig(var1);
            if (var4 != null) {
               I18nConfig var5 = var4.getModelName();
               if (var5 != null) {
                  String var6 = var5.getValue();
                  if (var6 != null) {
                     return var6;
                  }
               }
            }

            String var7 = this.modelNameFromCompatibility(var1);
            var1 = var7;
            if (var7 == null) {
               var1 = DeviceType.Unknown.INSTANCE.getName();
            }

            return var1;
         } else {
            return DeviceType.Unknown.INSTANCE.getName();
         }
      }

      public final void setInG4ProtectRegion(boolean var1) {
         DeviceType.isInG4ProtectRegion = var1;
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/DeviceType$Dehumidifier;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Dehumidifier extends DeviceType {
      public static final Dehumidifier INSTANCE = new Dehumidifier();

      private Dehumidifier() {
         super(15, "Dehumidifier", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/DeviceType$FanPremium;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class FanPremium extends DeviceType {
      public static final FanPremium INSTANCE = new FanPremium();

      private FanPremium() {
         super(22, "fanpremium", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/DeviceType$FanTable;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class FanTable extends DeviceType {
      public static final FanTable INSTANCE = new FanTable();

      private FanTable() {
         super(21, "fantable", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/DeviceType$G4;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class G4 extends DeviceType {
      public static final G4 INSTANCE = new G4();

      private G4() {
         super(1, "G4", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/DeviceType$Humidifier;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Humidifier extends DeviceType {
      public static final Humidifier INSTANCE = new Humidifier();

      private Humidifier() {
         super(12, "Humidifier", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/DeviceType$Humidifier20;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Humidifier20 extends DeviceType {
      public static final Humidifier20 INSTANCE = new Humidifier20();

      private Humidifier20() {
         super(18, "Humidifier20", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/DeviceType$Icp;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Icp extends DeviceType {
      public static final Icp INSTANCE = new Icp();

      private Icp() {
         super(4, "Cabin Air P2i", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/DeviceType$MiniRestful;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class MiniRestful extends DeviceType {
      public static final MiniRestful INSTANCE = new MiniRestful();

      private MiniRestful() {
         super(19, "mrest", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/DeviceType$NewClassic;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class NewClassic extends DeviceType {
      public static final NewClassic INSTANCE = new NewClassic();

      private NewClassic() {
         super(11, "NC", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/DeviceType$Pet20;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Pet20 extends DeviceType {
      public static final Pet20 INSTANCE = new Pet20();

      private Pet20() {
         super(16, "pet20", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/DeviceType$Sense;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Sense extends DeviceType {
      public static final Sense INSTANCE = new Sense();

      private Sense() {
         super(3, "Sense+", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/DeviceType$Unknown;", "Lcom/blueair/core/model/DeviceType;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Unknown extends DeviceType {
      public static final Unknown INSTANCE = new Unknown();

      private Unknown() {
         super(-1, "Unknown", (DefaultConstructorMarker)null);
      }
   }
}
