package com.blueair.core.util;

import android.content.Context;
import com.blueair.core.R;
import com.blueair.core.model.ChinaPrivacy;
import com.blueair.core.model.I18nConfig;
import com.blueair.core.model.IpConfig;
import com.blueair.core.model.McuFirmwareVersions;
import com.blueair.core.model.SkuConfiguration;
import com.blueair.core.model.SkuConfigurationData;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

@Metadata(
   d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0006H\u0002J\u000e\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020(J\u0012\u0010)\u001a\u0004\u0018\u00010\u00062\u0006\u0010*\u001a\u00020\u0013H\u0002J\u0010\u0010+\u001a\u00020,2\u0006\u0010%\u001a\u00020\u0006H\u0002J\u0016\u0010-\u001a\u00020$2\u0006\u0010'\u001a\u00020(2\u0006\u0010.\u001a\u00020\u0006R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R6\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00122\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\u0018@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bRB\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u001c0\u00122\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u001c0\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u001e\u0010 \u001a\u00020\u001f2\u0006\u0010\u0007\u001a\u00020\u001f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006/"},
   d2 = {"Lcom/blueair/core/util/SkuConfigurationManager;", "", "<init>", "()V", "serializer", "Lcom/blueair/core/util/MoshiSerializer;", "Lcom/blueair/core/model/SkuConfigurationData;", "value", "", "version", "getVersion", "()I", "series", "getSeries", "Lcom/blueair/core/model/ChinaPrivacy;", "chinaPrivacy", "getChinaPrivacy", "()Lcom/blueair/core/model/ChinaPrivacy;", "", "", "Lcom/blueair/core/model/IpConfig;", "webLinks", "getWebLinks", "()Ljava/util/Map;", "Lcom/blueair/core/model/McuFirmwareVersions;", "mcuFirmwareVersions", "getMcuFirmwareVersions", "()Lcom/blueair/core/model/McuFirmwareVersions;", "", "specialHardwareSets", "getSpecialHardwareSets", "Lcom/blueair/core/model/SkuConfiguration;", "config", "getConfig", "()Lcom/blueair/core/model/SkuConfiguration;", "update", "", "data", "loadFromFile", "context", "Landroid/content/Context;", "loadFromJson", "json", "shouldUpdate", "", "updateSkuConfiguration", "skuConfigData", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class SkuConfigurationManager {
   public static final SkuConfigurationManager INSTANCE = new SkuConfigurationManager();
   private static ChinaPrivacy chinaPrivacy;
   private static SkuConfiguration config;
   private static McuFirmwareVersions mcuFirmwareVersions;
   private static final MoshiSerializer serializer;
   private static int series;
   private static Map specialHardwareSets;
   private static int version;
   private static Map webLinks;

   static {
      serializer = new MoshiSerializer((Type)SkuConfigurationData.class, new Object[]{I18nConfig.Adapter.INSTANCE, IpConfig.Adapter.INSTANCE});
      chinaPrivacy = new ChinaPrivacy(0, new I18nConfig("", (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, 2046, (DefaultConstructorMarker)null), new I18nConfig("", (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, 2046, (DefaultConstructorMarker)null), new I18nConfig("", (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, 2046, (DefaultConstructorMarker)null));
      webLinks = MapsKt.emptyMap();
      mcuFirmwareVersions = new McuFirmwareVersions((String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, 1023, (DefaultConstructorMarker)null);
      specialHardwareSets = MapsKt.emptyMap();
      config = new SkuConfiguration(0, 0, (Map)null, (Map)null, 15, (DefaultConstructorMarker)null);
   }

   private SkuConfigurationManager() {
   }

   private final SkuConfigurationData loadFromJson(String var1) {
      return (SkuConfigurationData)serializer.fromJson(var1);
   }

   private final boolean shouldUpdate(SkuConfigurationData var1) {
      if (series == 0) {
         return true;
      } else {
         return var1.getSeries() == series && var1.getVersion() > version;
      }
   }

   private final void update(SkuConfigurationData var1) {
      version = var1.getVersion();
      series = var1.getSeries();
      chinaPrivacy = var1.getChinaPrivacy();
      webLinks = var1.getWebLinks();
      mcuFirmwareVersions = var1.getMcuFirmwareVersions();
      specialHardwareSets = var1.getSpecialHardwareSets();
      config = var1.getSkuConfiguration();
   }

   public final ChinaPrivacy getChinaPrivacy() {
      return chinaPrivacy;
   }

   public final SkuConfiguration getConfig() {
      return config;
   }

   public final McuFirmwareVersions getMcuFirmwareVersions() {
      return mcuFirmwareVersions;
   }

   public final int getSeries() {
      return series;
   }

   public final Map getSpecialHardwareSets() {
      return specialHardwareSets;
   }

   public final int getVersion() {
      return version;
   }

   public final Map getWebLinks() {
      return webLinks;
   }

   public final void loadFromFile(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");

      Throwable var10000;
      label1740: {
         BufferedReader var254;
         label1734: {
            try {
               InputStream var2 = var1.getResources().openRawResource(R.raw.sku_configurations);
               Intrinsics.checkNotNullExpressionValue(var2, "openRawResource(...)");
               Charset var3 = Charsets.UTF_8;
               InputStreamReader var4 = new InputStreamReader(var2, var3);
               var253 = (Reader)var4;
               if (var253 instanceof BufferedReader) {
                  var254 = (BufferedReader)var253;
                  break label1734;
               }
            } catch (Throwable var244) {
               var10000 = var244;
               boolean var10001 = false;
               break label1740;
            }

            try {
               var254 = new BufferedReader(var253, 8192);
            } catch (Throwable var243) {
               var10000 = var243;
               boolean var263 = false;
               break label1740;
            }
         }

         try {
            var255 = (Closeable)var254;
         } catch (Throwable var242) {
            var10000 = var242;
            boolean var264 = false;
            break label1740;
         }

         String var261;
         try {
            var261 = TextStreamsKt.readText((Reader)((BufferedReader)var255));
         } catch (Throwable var241) {
            Throwable var245 = var241;

            try {
               throw var245;
            } finally {
               try {
                  CloseableKt.closeFinally(var255, var245);
               } catch (Throwable var232) {
                  var10000 = var232;
                  boolean var265 = false;
                  break label1740;
               }
            }
         }

         try {
            CloseableKt.closeFinally(var255, (Throwable)null);
            var256 = this.loadFromJson(var261);
         } catch (Throwable var240) {
            var10000 = var240;
            boolean var266 = false;
            break label1740;
         }

         if (var256 == null) {
            return;
         }

         label1715: {
            try {
               this.update(var256);
               FileInputStream var246 = var1.openFileInput("sku_configuration.json");
               Intrinsics.checkNotNullExpressionValue(var246, "openFileInput(...)");
               InputStream var262 = (InputStream)var246;
               Charset var257 = Charsets.UTF_8;
               InputStreamReader var247 = new InputStreamReader(var262, var257);
               var248 = (Reader)var247;
               if (var248 instanceof BufferedReader) {
                  var249 = (BufferedReader)var248;
                  break label1715;
               }
            } catch (Throwable var239) {
               var10000 = var239;
               boolean var267 = false;
               break label1740;
            }

            try {
               var249 = new BufferedReader(var248, 8192);
            } catch (Throwable var238) {
               var10000 = var238;
               boolean var268 = false;
               break label1740;
            }
         }

         try {
            var250 = (Closeable)var249;
         } catch (Throwable var237) {
            var10000 = var237;
            boolean var269 = false;
            break label1740;
         }

         try {
            var259 = TextStreamsKt.readText((Reader)((BufferedReader)var250));
         } catch (Throwable var236) {
            Throwable var258 = var236;

            try {
               throw var258;
            } finally {
               try {
                  CloseableKt.closeFinally(var250, var258);
               } catch (Throwable var230) {
                  var10000 = var230;
                  boolean var270 = false;
                  break label1740;
               }
            }
         }

         try {
            CloseableKt.closeFinally(var250, (Throwable)null);
            var251 = this.loadFromJson(var259);
         } catch (Throwable var235) {
            var10000 = var235;
            boolean var271 = false;
            break label1740;
         }

         if (var251 == null) {
            return;
         }

         label1697:
         try {
            if (this.shouldUpdate(var251)) {
               this.update(var251);
               return;
            }

            return;
         } catch (Throwable var234) {
            var10000 = var234;
            boolean var272 = false;
            break label1697;
         }
      }

      Throwable var260 = var10000;
      String var252 = var260.getMessage();
      if (var252 != null && StringsKt.startsWith$default(var252, "SkuConfiguration", false, 2, (Object)null)) {
         throw var260;
      }
   }

   public final void updateSkuConfiguration(Context var1, SkuConfigurationData var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "skuConfigData");
      if (this.shouldUpdate(var2)) {
         Throwable var10000;
         label410: {
            label405: {
               try {
                  Result.Companion var3 = Result.Companion;
                  SkuConfigurationManager var70 = this;
                  this.update(var2);
                  var67 = serializer.toJson(var2);
                  FileOutputStream var61 = var1.openFileOutput("sku_configuration.json", 0);
                  Intrinsics.checkNotNullExpressionValue(var61, "openFileOutput(...)");
                  OutputStream var4 = (OutputStream)var61;
                  Charset var71 = Charsets.UTF_8;
                  OutputStreamWriter var62 = new OutputStreamWriter(var4, var71);
                  var63 = (Writer)var62;
                  if (var63 instanceof BufferedWriter) {
                     var64 = (BufferedWriter)var63;
                     break label405;
                  }
               } catch (Throwable var60) {
                  var10000 = var60;
                  boolean var10001 = false;
                  break label410;
               }

               try {
                  var64 = new BufferedWriter(var63, 8192);
               } catch (Throwable var59) {
                  var10000 = var59;
                  boolean var73 = false;
                  break label410;
               }
            }

            try {
               var65 = (Closeable)var64;
            } catch (Throwable var58) {
               var10000 = var58;
               boolean var74 = false;
               break label410;
            }

            try {
               ((BufferedWriter)var65).write(var67);
               Unit var68 = Unit.INSTANCE;
            } catch (Throwable var57) {
               Throwable var72 = var57;

               try {
                  throw var72;
               } finally {
                  try {
                     CloseableKt.closeFinally(var65, var72);
                  } catch (Throwable var55) {
                     var10000 = var55;
                     boolean var75 = false;
                     break label410;
                  }
               }
            }

            label384:
            try {
               CloseableKt.closeFinally(var65, (Throwable)null);
               Result.constructor-impl(Unit.INSTANCE);
               return;
            } catch (Throwable var54) {
               var10000 = var54;
               boolean var76 = false;
               break label384;
            }
         }

         Throwable var69 = var10000;
         Result.Companion var66 = Result.Companion;
         Result.constructor-impl(ResultKt.createFailure(var69));
      }

   }
}
