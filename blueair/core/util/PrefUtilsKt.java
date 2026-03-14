package com.blueair.core.util;

import io.flatcircle.preferenceshelper2.PreferencesHelper;
import io.flatcircle.preferenceshelper2.Prefs;
import io.flatcircle.preferenceshelper2.PrefsBackend;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@Metadata(
   d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a@\u0010\u0000\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\n\b\u0000\u0010\u0003\u0018\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u0002H\u0003H\u0086\b¢\u0006\u0002\u0010\t¨\u0006\n"},
   d2 = {"ObservableVolatilePreference", "Lkotlin/properties/ReadWriteProperty;", "", "T", "prefs", "Lio/flatcircle/preferenceshelper2/Prefs;", "key", "", "initialDefault", "(Lio/flatcircle/preferenceshelper2/Prefs;Ljava/lang/String;Ljava/lang/Object;)Lkotlin/properties/ReadWriteProperty;", "core_otherRelease"},
   k = 2,
   mv = {2, 2, 0},
   xi = 48
)
public final class PrefUtilsKt {
   // $FF: synthetic method
   public static final ReadWriteProperty ObservableVolatilePreference(Prefs var0, String var1, Object var2) {
      Intrinsics.checkNotNullParameter(var0, "prefs");
      Intrinsics.checkNotNullParameter(var1, "key");
      Intrinsics.checkNotNullParameter(var2, "initialDefault");
      PreferencesHelper var3 = PreferencesHelper.INSTANCE;
      PrefsBackend var4 = var0.getBackend();
      Intrinsics.reifiedOperationMarker(4, "T");
      Object var5 = var3.get(var4, var1, var2, Reflection.getOrCreateKotlinClass(Object.class));
      Intrinsics.needClassReification();
      return (ReadWriteProperty)(new ObservableProperty(var0, var1, var2, var5) {
         final Object $initialDefault;
         final String $key;
         final Prefs $prefs;

         public {
            this.$prefs = var1;
            this.$key = var2;
            this.$initialDefault = var3;
         }

         protected void afterChange(KProperty var1, Object var2, Object var3) {
            Intrinsics.checkNotNullParameter(var1, "property");
            Intrinsics.checkNotNullParameter(var2, "oldValue");
            Intrinsics.checkNotNullParameter(var3, "newValue");
            if (!Intrinsics.areEqual(var3, var2)) {
               Prefs var4 = this.$prefs;
               String var5 = this.$key;
               PreferencesHelper var6 = PreferencesHelper.INSTANCE;
               PrefsBackend var7 = var4.getBackend();
               Intrinsics.reifiedOperationMarker(4, "T");
               var6.set(var7, var5, var3, Reflection.getOrCreateKotlinClass(Object.class));
            }

         }

         public Object getValue(Object var1, KProperty var2) {
            Intrinsics.checkNotNullParameter(var2, "property");
            Prefs var4 = this.$prefs;
            String var3 = this.$key;
            var1 = this.$initialDefault;
            PreferencesHelper var6 = PreferencesHelper.INSTANCE;
            PrefsBackend var7 = var4.getBackend();
            Intrinsics.reifiedOperationMarker(4, "T");
            return var6.get(var7, var3, var1, Reflection.getOrCreateKotlinClass(Object.class));
         }

         public void setValue(Object var1, KProperty var2, Object var3) {
            Intrinsics.checkNotNullParameter(var2, "property");
            Intrinsics.checkNotNullParameter(var3, "value");
            var1 = this.getValue(var1, var2);
            if (this.beforeChange(var2, var1, var3)) {
               this.afterChange(var2, var1, var3);
            }
         }
      });
   }
}
