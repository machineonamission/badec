package com.blueair.api.model;

import com.blueair.api.utils.BlueCloudSensor;
import com.blueair.core.model.IndoorDatapoint;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(
   d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"},
   d2 = {"toIndoorDatapoint", "Lcom/blueair/core/model/IndoorDatapoint;", "", "Lcom/blueair/api/model/SensorData;", "api_otherRelease"},
   k = 2,
   mv = {2, 2, 0},
   xi = 48
)
public final class SensorDataKt {
   public static final IndoorDatapoint toIndoorDatapoint(List var0) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      Iterable var6 = (Iterable)var0;
      Iterator var5 = var6.iterator();

      do {
         if (!var5.hasNext()) {
            var16 = null;
            break;
         }

         var16 = var5.next();
      } while(((SensorData)var16).getTimeDelta() == null);

      long var1;
      label308: {
         SensorData var17 = (SensorData)var16;
         if (var17 != null) {
            Long var18 = var17.getTimeDelta();
            if (var18 != null) {
               var1 = var18;
               break label308;
            }
         }

         var1 = 0L;
      }

      var5 = var6.iterator();

      do {
         if (!var5.hasNext()) {
            var19 = null;
            break;
         }

         var19 = var5.next();
      } while(((SensorData)var19).getBaseTime() == null);

      long var3;
      label296: {
         SensorData var20 = (SensorData)var19;
         if (var20 != null) {
            Long var21 = var20.getBaseTime();
            if (var21 != null) {
               var3 = var21;
               break label296;
            }
         }

         var3 = System.currentTimeMillis() / 1000L;
      }

      var5 = var6.iterator();

      do {
         if (!var5.hasNext()) {
            var22 = null;
            break;
         }

         var22 = var5.next();
      } while(!StringsKt.endsWith$default(((SensorData)var22).getName(), BlueCloudSensor.PM1.INSTANCE.getName(), false, 2, (Object)null));

      SensorData var23 = (SensorData)var22;
      Object var24;
      if (var23 != null) {
         var24 = (SensorData)var23.getValue();
      } else {
         var24 = null;
      }

      Double var57 = StringsKt.toDoubleOrNull(String.valueOf(var24));
      Iterator var7 = var6.iterator();

      do {
         if (!var7.hasNext()) {
            var24 = null;
            break;
         }

         var24 = var7.next();
      } while(!StringsKt.endsWith$default(((SensorData)var24).getName(), BlueCloudSensor.PM10.INSTANCE.getName(), false, 2, (Object)null));

      var24 = (SensorData)var24;
      if (var24 != null) {
         var24 = (SensorData)var24.getValue();
      } else {
         var24 = null;
      }

      Double var8 = StringsKt.toDoubleOrNull(String.valueOf(var24));
      Iterator var9 = var6.iterator();

      while(true) {
         if (var9.hasNext()) {
            Object var62 = var9.next();
            SensorData var10 = (SensorData)var62;
            var24 = (SensorData)var62;
            if (StringsKt.endsWith$default(var10.getName(), BlueCloudSensor.PM25.INSTANCE.getName(), false, 2, (Object)null)) {
               break;
            }

            if (!StringsKt.endsWith$default(var10.getName(), "pm2.5", false, 2, (Object)null)) {
               continue;
            }

            var24 = (SensorData)var62;
            break;
         }

         var24 = null;
         break;
      }

      var24 = var24;
      if (var24 != null) {
         var24 = (SensorData)var24.getValue();
      } else {
         var24 = null;
      }

      Double var78 = StringsKt.toDoubleOrNull(String.valueOf(var24));
      Iterator var80 = var6.iterator();

      while(true) {
         if (var80.hasNext()) {
            Object var63 = var80.next();
            SensorData var11 = (SensorData)var63;
            String var32 = var11.getName();
            Locale var12 = Locale.ENGLISH;
            Intrinsics.checkNotNullExpressionValue(var12, "ENGLISH");
            String var86 = var32.toLowerCase(var12);
            Intrinsics.checkNotNullExpressionValue(var86, "toLowerCase(...)");
            var24 = (SensorData)var63;
            if (StringsKt.endsWith$default(var86, BlueCloudSensor.VOC.INSTANCE.getName(), false, 2, (Object)null)) {
               break;
            }

            var32 = var11.getName();
            Locale var83 = Locale.ENGLISH;
            Intrinsics.checkNotNullExpressionValue(var83, "ENGLISH");
            var32 = var32.toLowerCase(var83);
            Intrinsics.checkNotNullExpressionValue(var32, "toLowerCase(...)");
            if (!StringsKt.endsWith$default(var32, "voc", false, 2, (Object)null)) {
               continue;
            }

            var24 = (SensorData)var63;
            break;
         }

         var24 = null;
         break;
      }

      var24 = var24;
      if (var24 != null) {
         var24 = (SensorData)var24.getValue();
      } else {
         var24 = null;
      }

      Double var81 = StringsKt.toDoubleOrNull(String.valueOf(var24));
      var7 = var6.iterator();

      do {
         if (!var7.hasNext()) {
            var24 = null;
            break;
         }

         var24 = (SensorData)var7.next();
      } while(!StringsKt.endsWith$default(((SensorData)var24).getName(), BlueCloudSensor.HCHO.INSTANCE.getName(), false, 2, (Object)null));

      var24 = var24;
      if (var24 != null) {
         var24 = (SensorData)var24.getValue();
      } else {
         var24 = null;
      }

      Double var84 = StringsKt.toDoubleOrNull(String.valueOf(var24));
      Iterator var87 = var6.iterator();

      while(true) {
         if (var87.hasNext()) {
            Object var65 = var87.next();
            SensorData var13 = (SensorData)var65;
            var24 = (SensorData)var65;
            if (Intrinsics.areEqual(var13.getName(), BlueCloudSensor.Temperature.INSTANCE.getName())) {
               break;
            }

            if (!StringsKt.endsWith$default(var13.getName(), "tmp", false, 2, (Object)null)) {
               continue;
            }

            var24 = (SensorData)var65;
            break;
         }

         var24 = null;
         break;
      }

      var24 = var24;
      if (var24 != null) {
         var24 = (SensorData)var24.getValue();
      } else {
         var24 = null;
      }

      Double var88 = StringsKt.toDoubleOrNull(String.valueOf(var24));
      Iterator var90 = var6.iterator();

      while(true) {
         if (var90.hasNext()) {
            Object var66 = var90.next();
            SensorData var14 = (SensorData)var66;
            var24 = (SensorData)var66;
            if (Intrinsics.areEqual(var14.getName(), BlueCloudSensor.Humidity.INSTANCE.getName())) {
               break;
            }

            if (!StringsKt.endsWith$default(var14.getName(), "hum", false, 2, (Object)null)) {
               continue;
            }

            var24 = (SensorData)var66;
            break;
         }

         var24 = null;
         break;
      }

      var24 = var24;
      if (var24 != null) {
         var24 = (SensorData)var24.getValue();
      } else {
         var24 = null;
      }

      Double var91 = StringsKt.toDoubleOrNull(String.valueOf(var24));
      Iterator var93 = var6.iterator();

      while(true) {
         if (var93.hasNext()) {
            Object var67 = var93.next();
            SensorData var15 = (SensorData)var67;
            var24 = (SensorData)var67;
            if (StringsKt.endsWith$default(var15.getName(), BlueCloudSensor.Fan.INSTANCE.getName(), false, 2, (Object)null)) {
               break;
            }

            if (!StringsKt.endsWith$default(var15.getName(), "fan", false, 2, (Object)null)) {
               continue;
            }

            var24 = (SensorData)var67;
            break;
         }

         var24 = null;
         break;
      }

      var24 = var24;
      if (var24 != null) {
         var24 = (SensorData)var24.getValue();
      } else {
         var24 = null;
      }

      Double var68 = StringsKt.toDoubleOrNull(String.valueOf(var24));
      var93 = var6.iterator();

      do {
         if (!var93.hasNext()) {
            var24 = null;
            break;
         }

         var24 = (SensorData)var93.next();
      } while(!StringsKt.endsWith$default(((SensorData)var24).getName(), "disinftime", false, 2, (Object)null));

      var24 = var24;
      if (var24 != null) {
         var24 = (SensorData)var24.getValue();
      } else {
         var24 = null;
      }

      Double var95 = StringsKt.toDoubleOrNull(String.valueOf(var24));
      Iterator var96 = var6.iterator();
      Double var52 = var68;

      do {
         if (!var96.hasNext()) {
            var69 = null;
            break;
         }

         var69 = var96.next();
      } while(!StringsKt.endsWith$default(((SensorData)var69).getName(), BlueCloudSensor.Weight.INSTANCE.getName(), false, 2, (Object)null));

      SensorData var70 = (SensorData)var69;
      Object var71;
      if (var70 != null) {
         var71 = var70.getValue();
      } else {
         var71 = null;
      }

      Double var72 = StringsKt.toDoubleOrNull(String.valueOf(var71));
      var96 = var6.iterator();
      Double var60 = var72;

      do {
         if (!var96.hasNext()) {
            var73 = null;
            break;
         }

         var73 = var96.next();
      } while(!StringsKt.endsWith$default(((SensorData)var73).getName(), BlueCloudSensor.RPM.INSTANCE.getName(), false, 2, (Object)null));

      SensorData var74 = (SensorData)var73;
      Object var75;
      if (var74 != null) {
         var75 = var74.getValue();
      } else {
         var75 = null;
      }

      Double var98 = StringsKt.toDoubleOrNull(String.valueOf(var75));
      Float var58;
      if (var57 != null) {
         var58 = (float)var57;
      } else {
         var58 = null;
      }

      Float var76;
      if (var8 != null) {
         var76 = (float)var8;
      } else {
         var76 = null;
      }

      Float var77;
      if (var78 != null) {
         var77 = (float)var78;
      } else {
         var77 = null;
      }

      Float var79;
      if (var81 != null) {
         var79 = (float)var81;
      } else {
         var79 = null;
      }

      Float var82;
      if (var84 != null) {
         var82 = (float)var84;
      } else {
         var82 = null;
      }

      Float var85;
      if (var88 != null) {
         var85 = (float)var88;
      } else {
         var85 = null;
      }

      Float var89;
      if (var91 != null) {
         var89 = (float)var91;
      } else {
         var89 = null;
      }

      Float var53;
      if (var52 != null) {
         var53 = (float)var52;
      } else {
         var53 = null;
      }

      Float var61;
      if (var60 != null) {
         var61 = (float)var60;
      } else {
         var61 = null;
      }

      Float var92;
      if (var98 != null) {
         var92 = (float)var98;
      } else {
         var92 = null;
      }

      IndoorDatapoint var59 = new IndoorDatapoint(var3 - var1, var58, var76, var77, var79, var82, var85, var89, var53, var61, var92);
      Integer var54;
      if (var95 != null) {
         var54 = (int)var95;
      } else {
         var54 = null;
      }

      var59.setDisinftime(var54);
      return var59.isEmpty() ? null : var59;
   }
}
