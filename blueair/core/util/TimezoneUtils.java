package com.blueair.core.util;

import android.content.Context;
import android.os.Build.VERSION;
import com.blueair.android.BlueairApp$$ExternalSyntheticApiModelOutline0;
import com.blueair.core.R;
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
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010¨\u0006\u0011"},
   d2 = {"Lcom/blueair/core/util/TimezoneUtils;", "", "<init>", "()V", "getDisplayName", "", "context", "Landroid/content/Context;", "timezone", "Ljava/util/TimeZone;", "ensureValidTimezone", "getTimezoneList", "Lcom/blueair/core/util/TimezoneList;", "updateTimezoneList", "", "timezoneList", "Lcom/blueair/core/util/TimezoneNames;", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class TimezoneUtils {
   public static final TimezoneUtils INSTANCE = new TimezoneUtils();

   private TimezoneUtils() {
   }

   public final TimeZone ensureValidTimezone(Context var1, TimeZone var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "timezone");
      return var2;
   }

   public final String getDisplayName(Context var1, TimeZone var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "timezone");
      if (VERSION.SDK_INT >= 24) {
         String var4 = var1.getString(R.string.timezone_display_name);
         Intrinsics.checkNotNullExpressionValue(var4, "getString(...)");
         var4 = String.format(var4, Arrays.copyOf(new Object[]{BlueairApp$$ExternalSyntheticApiModelOutline0.m(BlueairApp$$ExternalSyntheticApiModelOutline0.m(Locale.getDefault()), var2.getID())}, 1));
         Intrinsics.checkNotNullExpressionValue(var4, "format(...)");
         return var4;
      } else {
         String var3 = var2.getDisplayName();
         Intrinsics.checkNotNullExpressionValue(var3, "getDisplayName(...)");
         return var3;
      }
   }

   public final TimezoneList getTimezoneList(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      String[] var6 = TimeZone.getAvailableIDs();
      Intrinsics.checkNotNullExpressionValue(var6, "getAvailableIDs(...)");
      List var8 = ArraysKt.asList((Object[])var6);

      label912: {
         label913: {
            label906: {
               try {
                  FileInputStream var105 = var1.openFileInput("timezones");
                  Intrinsics.checkNotNullExpressionValue(var105, "openFileInput(...)");
                  InputStream var9 = (InputStream)var105;
                  Charset var106 = Charsets.UTF_8;
                  InputStreamReader var7 = new InputStreamReader(var9, var106);
                  var107 = (Reader)var7;
                  if (var107 instanceof BufferedReader) {
                     var108 = (BufferedReader)var107;
                     break label906;
                  }
               } catch (Throwable var99) {
                  boolean var10001 = false;
                  break label913;
               }

               try {
                  var108 = new BufferedReader(var107, 8192);
               } catch (Throwable var98) {
                  boolean var122 = false;
                  break label913;
               }
            }

            Closeable var112;
            try {
               var112 = (Closeable)var108;
            } catch (Throwable var97) {
               boolean var123 = false;
               break label913;
            }

            try {
               var109 = TextStreamsKt.readLines((Reader)((BufferedReader)var112));
            } catch (Throwable var96) {
               Throwable var121 = var96;

               try {
                  throw var121;
               } finally {
                  try {
                     CloseableKt.closeFinally(var112, var121);
                  } catch (Throwable var93) {
                     boolean var124 = false;
                     break label913;
                  }
               }
            }

            label892:
            try {
               CloseableKt.closeFinally(var112, (Throwable)null);
               break label912;
            } catch (Throwable var95) {
               boolean var125 = false;
               break label892;
            }
         }

         InputStream var100 = var1.getResources().openRawResource(R.raw.timezones);
         Intrinsics.checkNotNullExpressionValue(var100, "openRawResource(...)");
         Reader var101 = (Reader)(new InputStreamReader(var100, Charsets.UTF_8));
         BufferedReader var102;
         if (var101 instanceof BufferedReader) {
            var102 = (BufferedReader)var101;
         } else {
            var102 = new BufferedReader(var101, 8192);
         }

         Closeable var103 = (Closeable)var102;

         try {
            var109 = TextStreamsKt.readLines((Reader)((BufferedReader)var103));
         } catch (Throwable var92) {
            Throwable var113 = var92;

            try {
               throw var113;
            } finally {
               CloseableKt.closeFinally(var103, var92);
            }
         }

         CloseableKt.closeFinally(var103, (Throwable)null);
      }

      String var114 = "0";
      long var4 = 0L;
      long var2 = var4;
      String var104 = var114;
      if (var109 != null) {
         String var120 = (String)CollectionsKt.getOrNull(var109, 0);
         var104 = var114;
         if (var120 != null) {
            var104 = var120;
         }

         var114 = (String)CollectionsKt.getOrNull(var109, 1);
         var2 = var4;
         if (var114 != null) {
            Long var116 = StringsKt.toLongOrNull(var114);
            var2 = var4;
            if (var116 != null) {
               var2 = ((Number)var116).longValue();
            }
         }

         var8 = CollectionsKt.drop((Iterable)var109, 2);
         Timber.Forest var117 = Timber.Forest;
         StringBuilder var110 = new StringBuilder("timezone list version: ");
         var110.append(var104);
         var110.append(", time: ");
         var110.append(var2);
         var110.append(", count: ");
         var110.append(var8.size());
         var117.d(var110.toString(), new Object[0]);
      }

      Iterable var118 = (Iterable)var8;
      Collection var111 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var118, 10)));
      Iterator var119 = var118.iterator();

      while(var119.hasNext()) {
         var111.add(TimeZone.getTimeZone((String)var119.next()));
      }

      return new TimezoneList(var104, var2, (List)var111);
   }

   public final void updateTimezoneList(Context var1, TimezoneNames var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "timezoneList");
      if (!((Collection)var2.getTimezoneNames()).isEmpty()) {
         Timber.Forest var3 = Timber.Forest;
         StringBuilder var4 = new StringBuilder("update timezone list:");
         var4.append(var2.getVersion());
         var3.d(var4.toString(), new Object[0]);
         StringBuilder var70 = new StringBuilder();
         var70.append(var2.getVersion());
         var70.append('\n');
         var70.append(System.currentTimeMillis());
         Intrinsics.checkNotNullExpressionValue(var70, "append(...)");
         var70.append('\n');
         Iterator var67 = ((Iterable)var2.getTimezoneNames()).iterator();

         while(var67.hasNext()) {
            var70.append((String)var67.next());
            var70.append('\n');
         }

         String var68 = var70.toString();
         Intrinsics.checkNotNullExpressionValue(var68, "toString(...)");

         Throwable var10000;
         label506: {
            label499: {
               try {
                  FileOutputStream var61 = var1.openFileOutput("timezones", 0);
                  Intrinsics.checkNotNullExpressionValue(var61, "openFileOutput(...)");
                  OutputStream var71 = (OutputStream)var61;
                  Charset var73 = Charsets.UTF_8;
                  OutputStreamWriter var62 = new OutputStreamWriter(var71, var73);
                  var63 = (Writer)var62;
                  if (var63 instanceof BufferedWriter) {
                     var64 = (BufferedWriter)var63;
                     break label499;
                  }
               } catch (Throwable var60) {
                  var10000 = var60;
                  boolean var10001 = false;
                  break label506;
               }

               try {
                  var64 = new BufferedWriter(var63, 8192);
               } catch (Throwable var59) {
                  var10000 = var59;
                  boolean var74 = false;
                  break label506;
               }
            }

            try {
               var65 = (Closeable)var64;
            } catch (Throwable var58) {
               var10000 = var58;
               boolean var75 = false;
               break label506;
            }

            try {
               ((BufferedWriter)var65).write(var68);
               Unit var69 = Unit.INSTANCE;
            } catch (Throwable var57) {
               Throwable var72 = var57;

               try {
                  throw var72;
               } finally {
                  try {
                     CloseableKt.closeFinally(var65, var72);
                  } catch (Throwable var54) {
                     var10000 = var54;
                     boolean var76 = false;
                     break label506;
                  }
               }
            }

            label484:
            try {
               CloseableKt.closeFinally(var65, (Throwable)null);
               return;
            } catch (Throwable var56) {
               var10000 = var56;
               boolean var77 = false;
               break label484;
            }
         }

         Throwable var66 = var10000;
         Timber.Forest.e(var66, "error writing internal file: timezones", new Object[0]);
      }

   }
}
