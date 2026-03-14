package com.blueair.core.util;

import android.content.Context;
import com.squareup.moshi.Types;
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
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlin.text.Charsets;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B;\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00028\u0000\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u000b\"\u00020\t¢\u0006\u0004\b\f\u0010\rJ$\u0010\u0012\u001a\u00028\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0015H\u0086\u0002¢\u0006\u0002\u0010\u0016J,\u0010\u0017\u001a\u00020\u00182\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u0019\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00028\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006\u001b"},
   d2 = {"Lcom/blueair/core/util/PersistentObjectDelegate;", "T", "", "context", "Landroid/content/Context;", "fileName", "", "default", "objectType", "Ljava/lang/reflect/Type;", "typeArguments", "", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/reflect/Type;[Ljava/lang/reflect/Type;)V", "serializer", "Lcom/blueair/core/util/MoshiSerializer;", "field", "Ljava/lang/Object;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "value", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class PersistentObjectDelegate {
   private final Context context;
   private Object field;
   private final String fileName;
   private final MoshiSerializer serializer;

   public PersistentObjectDelegate(Context var1, String var2, Object var3, Type var4, Type... var5) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "fileName");
      Intrinsics.checkNotNullParameter(var4, "objectType");
      Intrinsics.checkNotNullParameter(var5, "typeArguments");
      super();
      this.context = var1;
      this.fileName = var2;
      ParameterizedType var70 = Types.newParameterizedType(var4, (Type[])Arrays.copyOf(var5, var5.length));
      Intrinsics.checkNotNullExpressionValue(var70, "newParameterizedType(...)");
      MoshiSerializer var71 = new MoshiSerializer((Type)var70, new Object[0]);
      this.serializer = var71;

      label500: {
         try {
            var69 = (Closeable)var1.openFileInput(var2);
         } catch (Throwable var62) {
            boolean var10001 = false;
            break label500;
         }

         label498: {
            Throwable var10000;
            label486: {
               label485: {
                  try {
                     FileInputStream var63 = (FileInputStream)var69;
                     Intrinsics.checkNotNull(var63);
                     InputStream var64 = (InputStream)var63;
                     Charset var6 = Charsets.UTF_8;
                     InputStreamReader var73 = new InputStreamReader(var64, var6);
                     var65 = (Reader)var73;
                     if (var65 instanceof BufferedReader) {
                        var66 = (BufferedReader)var65;
                        break label485;
                     }
                  } catch (Throwable var61) {
                     var10000 = var61;
                     boolean var74 = false;
                     break label486;
                  }

                  try {
                     var66 = new BufferedReader(var65, 8192);
                  } catch (Throwable var60) {
                     var10000 = var60;
                     boolean var75 = false;
                     break label486;
                  }
               }

               label477:
               try {
                  var67 = TextStreamsKt.readText((Reader)var66);
                  break label498;
               } catch (Throwable var59) {
                  var10000 = var59;
                  boolean var76 = false;
                  break label477;
               }
            }

            Throwable var72 = var10000;

            try {
               throw var72;
            } finally {
               try {
                  CloseableKt.closeFinally(var69, var72);
               } catch (Throwable var56) {
                  boolean var77 = false;
                  break label500;
               }
            }
         }

         try {
            CloseableKt.closeFinally(var69, (Throwable)null);
            var68 = var71.fromJson(var67);
         } catch (Throwable var58) {
            boolean var78 = false;
            break label500;
         }

         if (var68 != null) {
            var3 = var68;
         }
      }

      this.field = var3;
   }

   public final Object getValue(Object var1, KProperty var2) {
      Intrinsics.checkNotNullParameter(var2, "property");
      return this.field;
   }

   public final void setValue(Object var1, KProperty var2, Object var3) {
      Intrinsics.checkNotNullParameter(var2, "property");
      if (!Intrinsics.areEqual(this.field, var3)) {
         this.field = var3;

         Throwable var10000;
         label434: {
            label427: {
               try {
                  FileOutputStream var61 = this.context.openFileOutput(this.fileName, 0);
                  Intrinsics.checkNotNullExpressionValue(var61, "openFileOutput(...)");
                  OutputStream var4 = (OutputStream)var61;
                  Charset var67 = Charsets.UTF_8;
                  OutputStreamWriter var62 = new OutputStreamWriter(var4, var67);
                  var63 = (Writer)var62;
                  if (var63 instanceof BufferedWriter) {
                     var64 = (BufferedWriter)var63;
                     break label427;
                  }
               } catch (Throwable var60) {
                  var10000 = var60;
                  boolean var10001 = false;
                  break label434;
               }

               try {
                  var64 = new BufferedWriter(var63, 8192);
               } catch (Throwable var59) {
                  var10000 = var59;
                  boolean var72 = false;
                  break label434;
               }
            }

            try {
               var65 = (Closeable)var64;
            } catch (Throwable var58) {
               var10000 = var58;
               boolean var73 = false;
               break label434;
            }

            try {
               ((BufferedWriter)var65).write(this.serializer.toJson(var3));
               Unit var69 = Unit.INSTANCE;
            } catch (Throwable var57) {
               Throwable var68 = var57;

               try {
                  throw var68;
               } finally {
                  try {
                     CloseableKt.closeFinally(var65, var68);
                  } catch (Throwable var54) {
                     var10000 = var54;
                     boolean var74 = false;
                     break label434;
                  }
               }
            }

            label413:
            try {
               CloseableKt.closeFinally(var65, (Throwable)null);
               return;
            } catch (Throwable var56) {
               var10000 = var56;
               boolean var75 = false;
               break label413;
            }
         }

         Throwable var70 = var10000;
         Timber.Forest var71 = Timber.Forest;
         StringBuilder var66 = new StringBuilder("failed to write ");
         var66.append(this.fileName);
         var71.e(var70, var66.toString(), new Object[0]);
      }
   }
}
