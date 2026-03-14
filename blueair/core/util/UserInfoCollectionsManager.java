package com.blueair.core.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.blueair.core.BuildEnvironment;
import com.blueair.core.R;
import com.blueair.core.model.I18nConfig;
import com.blueair.core.model.IpConfig;
import com.blueair.core.model.UserInfoCollectionGroup;
import com.blueair.core.model.UserInfoCollectionItem;
import com.blueair.core.model.UserInfoCollectionRecord;
import com.blueair.core.model.UserInfoCollections;
import com.blueair.core.model.UserInfoExtras;
import com.blueair.core.model.UserInfoGroup;
import com.blueair.core.model.UserInfoItem;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010#\u001a\u0004\u0018\u00010\u001a2\u0006\u0010$\u001a\u00020%J\u0010\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)J\u0010\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020\u000eH\u0002J\b\u0010,\u001a\u00020\u001fH\u0002J\u0012\u0010-\u001a\u0004\u0018\u00010\u000e2\u0006\u0010.\u001a\u00020\"H\u0002J*\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\b\u00102\u001a\u00020\u001fH\u0002J \u00103\u001a\u00020\u001f2\u0006\u00104\u001a\u00020)2\u0006\u0010\u000f\u001a\u00020\"2\b\b\u0002\u00102\u001a\u00020\u0005J\u0006\u00105\u001a\u00020\u001fJ\u000e\u00106\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\tJ\u000e\u00107\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\tJ\u0006\u00108\u001a\u00020\u000eJ\u000e\u00109\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0015@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R*\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006:"},
   d2 = {"Lcom/blueair/core/util/UserInfoCollectionsManager;", "", "<init>", "()V", "enabled", "", "getEnabled", "()Z", "MAX_RECORD_SIZE", "", "context", "Landroid/content/Context;", "serializer", "Lcom/blueair/core/util/MoshiSerializer;", "Lcom/blueair/core/model/UserInfoCollections;", "value", "version", "getVersion", "()I", "series", "getSeries", "Lcom/blueair/core/model/UserInfoExtras;", "extras", "getExtras", "()Lcom/blueair/core/model/UserInfoExtras;", "", "Lcom/blueair/core/model/UserInfoCollectionGroup;", "collections", "getCollections", "()Ljava/util/List;", "initialize", "", "initializeCollections", "email", "", "findUserInfoGroup", "group", "Lcom/blueair/core/model/UserInfoGroup;", "findUserInfoItem", "Lcom/blueair/core/model/UserInfoCollectionItem;", "item", "Lcom/blueair/core/model/UserInfoItem;", "setData", "data", "loadFromFile", "loadFromJson", "json", "merge", "old", "new", "saveData", "addRecord", "type", "clearData", "setVersion", "setChinaPrivacyConsentVersion", "toUserInfoCollections", "update", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class UserInfoCollectionsManager {
   public static final UserInfoCollectionsManager INSTANCE = new UserInfoCollectionsManager();
   private static final int MAX_RECORD_SIZE = 100;
   private static List collections;
   private static Context context;
   private static final boolean enabled;
   private static UserInfoExtras extras;
   private static final MoshiSerializer serializer;
   private static int series;
   private static int version;

   static {
      enabled = BuildEnvironment.INSTANCE.isChina();
      serializer = new MoshiSerializer((Type)UserInfoCollections.class, new Object[]{I18nConfig.Adapter.INSTANCE, IpConfig.Adapter.INSTANCE});
      extras = new UserInfoExtras(0, 1, (DefaultConstructorMarker)null);
      collections = CollectionsKt.emptyList();
   }

   private UserInfoCollectionsManager() {
   }

   // $FF: synthetic method
   public static void addRecord$default(UserInfoCollectionsManager var0, UserInfoItem var1, String var2, boolean var3, int var4, Object var5) {
      if ((var4 & 4) != 0) {
         var3 = true;
      }

      var0.addRecord(var1, var2, var3);
   }

   private final void loadFromFile() {
      if (enabled) {
         Throwable var10000;
         label4313: {
            try {
               Result.Companion var1 = Result.Companion;
               UserInfoCollectionsManager var654 = this;
            } catch (Throwable var653) {
               var10000 = var653;
               boolean var10001 = false;
               break label4313;
            }

            Object var663;
            label4314: {
               label4315: {
                  Context var2;
                  try {
                     Result.Companion var655 = Result.Companion;
                     var2 = context;
                  } catch (Throwable var652) {
                     var10000 = var652;
                     boolean var684 = false;
                     break label4315;
                  }

                  Context var656 = var2;
                  if (var2 == null) {
                     try {
                        Intrinsics.throwUninitializedPropertyAccessException("context");
                     } catch (Throwable var651) {
                        var10000 = var651;
                        boolean var685 = false;
                        break label4315;
                     }

                     var656 = null;
                  }

                  label4294: {
                     try {
                        FileInputStream var657 = var656.openFileInput("user_info_collections.json");
                        Intrinsics.checkNotNullExpressionValue(var657, "openFileInput(...)");
                        InputStream var672 = (InputStream)var657;
                        Charset var658 = Charsets.UTF_8;
                        InputStreamReader var3 = new InputStreamReader(var672, var658);
                        var659 = (Reader)var3;
                        if (var659 instanceof BufferedReader) {
                           var660 = (BufferedReader)var659;
                           break label4294;
                        }
                     } catch (Throwable var650) {
                        var10000 = var650;
                        boolean var686 = false;
                        break label4315;
                     }

                     try {
                        var660 = new BufferedReader(var659, 8192);
                     } catch (Throwable var649) {
                        var10000 = var649;
                        boolean var687 = false;
                        break label4315;
                     }
                  }

                  try {
                     var661 = (Closeable)var660;
                  } catch (Throwable var648) {
                     var10000 = var648;
                     boolean var688 = false;
                     break label4315;
                  }

                  try {
                     var674 = TextStreamsKt.readText((Reader)((BufferedReader)var661));
                  } catch (Throwable var647) {
                     Throwable var673 = var647;

                     try {
                        throw var673;
                     } finally {
                        try {
                           CloseableKt.closeFinally(var661, var673);
                        } catch (Throwable var643) {
                           var10000 = var643;
                           boolean var689 = false;
                           break label4315;
                        }
                     }
                  }

                  label4280:
                  try {
                     CloseableKt.closeFinally(var661, (Throwable)null);
                     var663 = Result.constructor-impl(this.loadFromJson(var674));
                     break label4314;
                  } catch (Throwable var646) {
                     var10000 = var646;
                     boolean var690 = false;
                     break label4280;
                  }
               }

               Throwable var675 = var10000;

               try {
                  Result.Companion var662 = Result.Companion;
                  var663 = Result.constructor-impl(ResultKt.createFailure(var675));
               } catch (Throwable var645) {
                  var10000 = var645;
                  boolean var691 = false;
                  break label4313;
               }
            }

            Object var676 = var663;

            label4266: {
               try {
                  if (!Result.isFailure-impl(var663)) {
                     break label4266;
                  }
               } catch (Throwable var642) {
                  var10000 = var642;
                  boolean var692 = false;
                  break label4313;
               }

               var676 = null;
            }

            try {
               var664 = (UserInfoCollections)var676;
            } catch (Throwable var641) {
               var10000 = var641;
               boolean var693 = false;
               break label4313;
            }

            if (var664 == null) {
               try {
                  var677 = context;
               } catch (Throwable var639) {
                  var10000 = var639;
                  boolean var694 = false;
                  break label4313;
               }

               Context var665 = var677;
               if (var677 == null) {
                  try {
                     Intrinsics.throwUninitializedPropertyAccessException("context");
                  } catch (Throwable var638) {
                     var10000 = var638;
                     boolean var695 = false;
                     break label4313;
                  }

                  var665 = null;
               }

               label4254: {
                  try {
                     InputStream var678 = var665.getResources().openRawResource(R.raw.user_info_collections);
                     Intrinsics.checkNotNullExpressionValue(var678, "openRawResource(...)");
                     Charset var666 = Charsets.UTF_8;
                     InputStreamReader var681 = new InputStreamReader(var678, var666);
                     var667 = (Reader)var681;
                     if (var667 instanceof BufferedReader) {
                        var668 = (BufferedReader)var667;
                        break label4254;
                     }
                  } catch (Throwable var640) {
                     var10000 = var640;
                     boolean var696 = false;
                     break label4313;
                  }

                  try {
                     var668 = new BufferedReader(var667, 8192);
                  } catch (Throwable var637) {
                     var10000 = var637;
                     boolean var697 = false;
                     break label4313;
                  }
               }

               try {
                  var669 = (Closeable)var668;
               } catch (Throwable var636) {
                  var10000 = var636;
                  boolean var698 = false;
                  break label4313;
               }

               try {
                  var679 = TextStreamsKt.readText((Reader)((BufferedReader)var669));
               } catch (Throwable var635) {
                  Throwable var682 = var635;

                  try {
                     throw var682;
                  } finally {
                     try {
                        CloseableKt.closeFinally(var669, var682);
                     } catch (Throwable var629) {
                        var10000 = var629;
                        boolean var699 = false;
                        break label4313;
                     }
                  }
               }

               try {
                  CloseableKt.closeFinally(var669, (Throwable)null);
                  var670 = this.loadFromJson(var679);
               } catch (Throwable var634) {
                  var10000 = var634;
                  boolean var700 = false;
                  break label4313;
               }

               if (var670 == null) {
                  return;
               }

               try {
                  this.setData(var670);
                  this.saveData();
               } catch (Throwable var633) {
                  var10000 = var633;
                  boolean var701 = false;
                  break label4313;
               }
            } else {
               try {
                  this.setData(var664);
               } catch (Throwable var632) {
                  var10000 = var632;
                  boolean var702 = false;
                  break label4313;
               }
            }

            label4232:
            try {
               Result.constructor-impl(Unit.INSTANCE);
               return;
            } catch (Throwable var631) {
               var10000 = var631;
               boolean var703 = false;
               break label4232;
            }
         }

         Throwable var671 = var10000;
         Result.Companion var680 = Result.Companion;
         Result.constructor-impl(ResultKt.createFailure(var671));
      }

   }

   private final UserInfoCollections loadFromJson(String var1) {
      return (UserInfoCollections)serializer.fromJson(var1);
   }

   private final List merge(List var1, List var2) {
      List var5 = (List)(new ArrayList());

      for(UserInfoCollectionGroup var6 : (Iterable)var2) {
         Iterator var8 = ((Iterable)var1).iterator();

         do {
            if (!var8.hasNext()) {
               var13 = null;
               break;
            }

            var13 = var8.next();
         } while(!Intrinsics.areEqual(((UserInfoCollectionGroup)var13).getId(), var6.getId()));

         UserInfoCollectionGroup var16 = (UserInfoCollectionGroup)var13;
         if (var16 == null) {
            var5.add(var6);
         } else {
            List var11 = (List)(new ArrayList());

            for(UserInfoCollectionItem var9 : (Iterable)var6.getItems()) {
               Iterator var12 = ((Iterable)var16.getItems()).iterator();

               do {
                  if (!var12.hasNext()) {
                     var14 = null;
                     break;
                  }

                  var14 = var12.next();
               } while(!Intrinsics.areEqual(((UserInfoCollectionItem)var14).getId(), var9.getId()));

               UserInfoCollectionItem var15 = (UserInfoCollectionItem)var14;
               if (var15 == null) {
                  var11.add(var9);
               } else {
                  List var17 = CollectionsKt.toMutableList((Collection)CollectionsKt.filterNotNull((Iterable)var9.getRecords()));
                  var17.addAll((Collection)CollectionsKt.filterNotNull((Iterable)var15.getRecords()));
                  if (var17.size() > 1) {
                     CollectionsKt.sortWith(var17, new Comparator() {
                        public final int compare(Object var1, Object var2) {
                           return ComparisonsKt.compareValues((Comparable)((UserInfoCollectionRecord)var1).getTime(), (Comparable)((UserInfoCollectionRecord)var2).getTime());
                        }
                     });
                  }

                  int var4 = var17.size() - 100;
                  if (var4 > 0) {
                     for(int var3 = 0; var3 < var4; ++var3) {
                        CollectionsKt.removeFirstOrNull(var17);
                     }
                  }

                  var11.add(UserInfoCollectionItem.copy$default(var9, (String)null, (I18nConfig)null, (I18nConfig)null, (I18nConfig)null, var9.getOmitted() + Math.max(0, var4), var17, 15, (Object)null));
               }
            }

            var5.add(UserInfoCollectionGroup.copy$default(var6, (String)null, (I18nConfig)null, var11, 3, (Object)null));
         }
      }

      return var5;
   }

   private final void saveData() {
      Throwable var10000;
      label758: {
         try {
            Result.Companion var1 = Result.Companion;
            UserInfoCollectionsManager var115 = this;
            if (!enabled) {
               return;
            }
         } catch (Throwable var114) {
            var10000 = var114;
            boolean var10001 = false;
            break label758;
         }

         Context var2;
         String var3;
         try {
            var3 = serializer.toJson(this.toUserInfoCollections());
            var2 = context;
         } catch (Throwable var113) {
            var10000 = var113;
            boolean var127 = false;
            break label758;
         }

         Context var116 = var2;
         if (var2 == null) {
            try {
               Intrinsics.throwUninitializedPropertyAccessException("context");
            } catch (Throwable var112) {
               var10000 = var112;
               boolean var128 = false;
               break label758;
            }

            var116 = null;
         }

         label741: {
            try {
               FileOutputStream var117 = var116.openFileOutput("user_info_collections.json", 0);
               Intrinsics.checkNotNullExpressionValue(var117, "openFileOutput(...)");
               OutputStream var123 = (OutputStream)var117;
               Charset var118 = Charsets.UTF_8;
               OutputStreamWriter var4 = new OutputStreamWriter(var123, var118);
               var119 = (Writer)var4;
               if (var119 instanceof BufferedWriter) {
                  var120 = (BufferedWriter)var119;
                  break label741;
               }
            } catch (Throwable var111) {
               var10000 = var111;
               boolean var129 = false;
               break label758;
            }

            try {
               var120 = new BufferedWriter(var119, 8192);
            } catch (Throwable var110) {
               var10000 = var110;
               boolean var130 = false;
               break label758;
            }
         }

         try {
            var121 = (Closeable)var120;
         } catch (Throwable var109) {
            var10000 = var109;
            boolean var131 = false;
            break label758;
         }

         try {
            ((BufferedWriter)var121).write(var3);
            Unit var125 = Unit.INSTANCE;
         } catch (Throwable var108) {
            Throwable var124 = var108;

            try {
               throw var124;
            } finally {
               try {
                  CloseableKt.closeFinally(var121, var124);
               } catch (Throwable var105) {
                  var10000 = var105;
                  boolean var132 = false;
                  break label758;
               }
            }
         }

         label727:
         try {
            CloseableKt.closeFinally(var121, (Throwable)null);
            Result.constructor-impl(Unit.INSTANCE);
            return;
         } catch (Throwable var107) {
            var10000 = var107;
            boolean var133 = false;
            break label727;
         }
      }

      Throwable var126 = var10000;
      Result.Companion var122 = Result.Companion;
      Result.constructor-impl(ResultKt.createFailure(var126));
   }

   private final void setData(UserInfoCollections var1) {
      if (enabled) {
         Throwable var10000;
         label762: {
            List var3;
            label755: {
               try {
                  if (!((Collection)collections).isEmpty()) {
                     var3 = this.merge(collections, var1.getCollections());
                     break label755;
                  }
               } catch (Throwable var94) {
                  var10000 = var94;
                  boolean var10001 = false;
                  break label762;
               }

               try {
                  var3 = var1.getCollections();
               } catch (Throwable var93) {
                  var10000 = var93;
                  boolean var102 = false;
                  break label762;
               }
            }

            try {
               collections = var3;
               var98 = StringsKt.toIntOrNull(var1.getVersion());
            } catch (Throwable var92) {
               var10000 = var92;
               boolean var103 = false;
               break label762;
            }

            int var2;
            if (var98 != null) {
               try {
                  var2 = var98;
               } catch (Throwable var91) {
                  var10000 = var91;
                  boolean var104 = false;
                  break label762;
               }
            } else {
               var2 = 0;
            }

            try {
               version = var2;
               var99 = StringsKt.toIntOrNull(var1.getSeries());
            } catch (Throwable var90) {
               var10000 = var90;
               boolean var105 = false;
               break label762;
            }

            if (var99 != null) {
               try {
                  var2 = var99;
               } catch (Throwable var89) {
                  var10000 = var89;
                  boolean var106 = false;
                  break label762;
               }
            } else {
               var2 = 0;
            }

            try {
               series = var2;
               var100 = var1.getExtras();
            } catch (Throwable var88) {
               var10000 = var88;
               boolean var107 = false;
               break label762;
            }

            UserInfoExtras var95 = var100;
            if (var100 == null) {
               try {
                  var95 = new UserInfoExtras(0, 1, (DefaultConstructorMarker)null);
               } catch (Throwable var87) {
                  var10000 = var87;
                  boolean var108 = false;
                  break label762;
               }
            }

            label723:
            try {
               extras = var95;
               return;
            } catch (Throwable var86) {
               var10000 = var86;
               boolean var109 = false;
               break label723;
            }
         }

         Throwable var96 = var10000;
         Timber.Forest var4 = Timber.Forest;
         StringBuilder var101 = new StringBuilder("setData failed: ");
         var101.append(var96.getLocalizedMessage());
         var4.e(var96, var101.toString(), new Object[0]);
      }
   }

   public final void addRecord(UserInfoItem var1, String var2, boolean var3) {
      synchronized(this){}

      Throwable var10000;
      label1961: {
         boolean var6;
         try {
            Intrinsics.checkNotNullParameter(var1, "type");
            Intrinsics.checkNotNullParameter(var2, "value");
            var6 = enabled;
         } catch (Throwable var219) {
            var10000 = var219;
            boolean var10001 = false;
            break label1961;
         }

         if (!var6) {
            return;
         }

         UserInfoCollectionItem var8;
         try {
            var8 = this.findUserInfoItem(var1);
         } catch (Throwable var218) {
            var10000 = var218;
            boolean var230 = false;
            break label1961;
         }

         if (var8 == null) {
            return;
         }

         int var4;
         try {
            var4 = UserInfoCollectionsManager.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
         } catch (Throwable var217) {
            var10000 = var217;
            boolean var231 = false;
            break label1961;
         }

         String var220 = null;
         UserInfoCollectionRecord var7 = null;
         switch (var4) {
            case 1:
            case 2:
            case 3:
               try {
                  var4 = var8.getRecordsCount();
               } catch (Throwable var215) {
                  var10000 = var215;
                  boolean var237 = false;
                  break label1961;
               }

               if (var4 > 0) {
                  return;
               }
               break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
               try {
                  var7 = (UserInfoCollectionRecord)CollectionsKt.lastOrNull(var8.getRecords());
               } catch (Throwable var214) {
                  var10000 = var214;
                  boolean var234 = false;
                  break label1961;
               }

               if (var7 != null) {
                  try {
                     var220 = var7.getValue();
                  } catch (Throwable var213) {
                     var10000 = var213;
                     boolean var235 = false;
                     break label1961;
                  }
               }

               try {
                  var6 = Intrinsics.areEqual(var220, var2);
               } catch (Throwable var212) {
                  var10000 = var212;
                  boolean var236 = false;
                  break label1961;
               }

               if (var6) {
                  return;
               }
               break;
            case 12:
            case 13:
               Iterator var9;
               try {
                  var9 = ((Iterable)var8.getRecords()).iterator();
               } catch (Throwable var211) {
                  var10000 = var211;
                  boolean var232 = false;
                  break label1961;
               }

               do {
                  var221 = var7;

                  try {
                     if (!var9.hasNext()) {
                        break;
                     }

                     var221 = var9.next();
                     var6 = Intrinsics.areEqual(((UserInfoCollectionRecord)var221).getValue(), var2);
                  } catch (Throwable var216) {
                     var10000 = var216;
                     boolean var233 = false;
                     break label1961;
                  }
               } while(!var6);

               if (var221 != null) {
                  return;
               }
         }

         int var5;
         try {
            List var229 = var8.getRecords();
            UserInfoCollectionRecord var222 = new UserInfoCollectionRecord(var2, 0L, 2, (DefaultConstructorMarker)null);
            var229.add(var222);
            var5 = var8.getRecords().size() - 100;
         } catch (Throwable var210) {
            var10000 = var210;
            boolean var238 = false;
            break label1961;
         }

         if (var5 > 0) {
            try {
               var8.setOmitted(var8.getOmitted() + var5);
            } catch (Throwable var209) {
               var10000 = var209;
               boolean var239 = false;
               break label1961;
            }

            for(int var225 = 0; var225 < var5; ++var225) {
               try {
                  CollectionsKt.removeFirstOrNull(var8.getRecords());
               } catch (Throwable var208) {
                  var10000 = var208;
                  boolean var240 = false;
                  break label1961;
               }
            }
         }

         if (var3) {
            try {
               this.saveData();
            } catch (Throwable var207) {
               var10000 = var207;
               boolean var241 = false;
               break label1961;
            }
         }

         return;
      }

      while(true) {
         Throwable var223 = var10000;

         try {
            throw var223;
         } catch (Throwable var206) {
            var10000 = var206;
            boolean var242 = false;
            continue;
         }
      }
   }

   public final void clearData() {
      if (enabled) {
         Throwable var10000;
         label125: {
            Context var2;
            try {
               Result.Companion var1 = Result.Companion;
               UserInfoCollectionsManager var15 = this;
               var2 = context;
            } catch (Throwable var14) {
               var10000 = var14;
               boolean var10001 = false;
               break label125;
            }

            Context var16 = var2;
            if (var2 == null) {
               try {
                  Intrinsics.throwUninitializedPropertyAccessException("context");
               } catch (Throwable var13) {
                  var10000 = var13;
                  boolean var19 = false;
                  break label125;
               }

               var16 = null;
            }

            label112:
            try {
               Result.constructor-impl(var16.deleteFile("user_info_collections.json"));
               return;
            } catch (Throwable var12) {
               var10000 = var12;
               boolean var20 = false;
               break label112;
            }
         }

         Throwable var18 = var10000;
         Result.Companion var17 = Result.Companion;
         Result.constructor-impl(ResultKt.createFailure(var18));
      }
   }

   public final UserInfoCollectionGroup findUserInfoGroup(UserInfoGroup var1) {
      Intrinsics.checkNotNullParameter(var1, "group");
      boolean var2 = enabled;
      Object var4 = null;
      if (!var2) {
         return null;
      } else {
         Iterator var5 = ((Iterable)collections).iterator();

         Object var3;
         do {
            var3 = var4;
            if (!var5.hasNext()) {
               break;
            }

            var3 = var5.next();
         } while(!Intrinsics.areEqual(((UserInfoCollectionGroup)var3).getId(), var1.getId()));

         return (UserInfoCollectionGroup)var3;
      }
   }

   public final UserInfoCollectionItem findUserInfoItem(UserInfoItem var1) {
      Intrinsics.checkNotNullParameter(var1, "item");
      boolean var2 = enabled;
      Object var5 = null;
      Object var4 = null;
      if (!var2) {
         return null;
      } else {
         UserInfoCollectionGroup var6 = this.findUserInfoGroup(var1.getGroup());
         UserInfoCollectionItem var3 = (UserInfoCollectionItem)var5;
         if (var6 != null) {
            List var9 = var6.getItems();
            var3 = (UserInfoCollectionItem)var5;
            if (var9 != null) {
               Iterator var8 = ((Iterable)var9).iterator();

               do {
                  var7 = var4;
                  if (!var8.hasNext()) {
                     break;
                  }

                  var7 = var8.next();
               } while(!Intrinsics.areEqual(((UserInfoCollectionItem)var7).getId(), var1.getId()));

               var3 = (UserInfoCollectionItem)var7;
            }
         }

         return var3;
      }
   }

   public final List getCollections() {
      return collections;
   }

   public final boolean getEnabled() {
      return enabled;
   }

   public final UserInfoExtras getExtras() {
      return extras;
   }

   public final int getSeries() {
      return series;
   }

   public final int getVersion() {
      return version;
   }

   public final void initialize(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      if (enabled) {
         context = var1;
         this.loadFromFile();
      }
   }

   public final boolean initializeCollections(String var1, Context var2) {
      Intrinsics.checkNotNullParameter(var1, "email");
      Intrinsics.checkNotNullParameter(var2, "context");
      if (!enabled) {
         return false;
      } else {
         UserInfoCollectionItem var6 = this.findUserInfoItem(UserInfoItem.USER_EMAIL);
         int var3;
         if (var6 != null) {
            var3 = var6.getRecordsCount();
         } else {
            var3 = 0;
         }

         if (var3 > 0) {
            return false;
         } else {
            Timber.Forest var20 = Timber.Forest;
            StringBuilder var7 = new StringBuilder("initializeCollections: ");
            var7.append(var1);
            var20.d(var7.toString(), new Object[0]);
            this.addRecord(UserInfoItem.USER_EMAIL, var1, false);
            this.addRecord(UserInfoItem.USER_PASSWORD, "", false);
            this.addRecord(UserInfoItem.USER_AGE, "", false);
            this.addRecord(UserInfoItem.ANDROID_ID, "", false);
            UserInfoItem var21 = UserInfoItem.PHONE_MODEL;
            var1 = Build.MODEL;
            Intrinsics.checkNotNullExpressionValue(var1, "MODEL");
            this.addRecord(var21, var1, false);
            UserInfoItem var9 = UserInfoItem.PHONE_SYSTEM_VERSION;
            StringBuilder var22 = new StringBuilder();
            var22.append(VERSION.BASE_OS);
            var22.append(' ');
            var22.append(VERSION.RELEASE);
            var22.append(' ');
            var22.append(VERSION.SDK_INT);
            this.addRecord(var9, StringsKt.trim((CharSequence)var22.toString()).toString(), false);
            this.addRecord(UserInfoItem.BLUEAIR_APP_VERSION, BuildEnvironment.INSTANCE.getDisplayVersion(), false);
            var9 = UserInfoItem.PHONE_BRAND;
            String var23 = Build.BRAND;
            Intrinsics.checkNotNullExpressionValue(var23, "BRAND");
            this.addRecord(var9, var23, false);
            Object var11 = var2.getSystemService("activity");
            ActivityManager var12;
            if (var11 instanceof ActivityManager) {
               var12 = (ActivityManager)var11;
            } else {
               var12 = null;
            }

            if (var12 != null) {
               ActivityManager.MemoryInfo var16 = new ActivityManager.MemoryInfo();
               var12.getMemoryInfo(var16);
               long var4 = var16.totalMem / (long)1048576;
               UserInfoItem var13 = UserInfoItem.PHONE_RAM_SIZE;
               StringBuilder var17 = new StringBuilder();
               var17.append(var4);
               var17.append(" MB");
               this.addRecord(var13, var17.toString(), false);
            }

            UserInfoItem var18 = UserInfoItem.PHONE_VENDOR;
            String var14 = Build.MANUFACTURER;
            Intrinsics.checkNotNullExpressionValue(var14, "MANUFACTURER");
            this.addRecord(var18, var14, false);
            var18 = UserInfoItem.PHONE_COUNTRY_CODE;
            var14 = Locale.getDefault().getCountry();
            Intrinsics.checkNotNullExpressionValue(var14, "getCountry(...)");
            this.addRecord(var18, var14, false);
            this.addRecord(UserInfoItem.BLUEAIR_APP_INFO, BuildEnvironment.INSTANCE.getApplicationId(), false);
            this.saveData();
            return true;
         }
      }
   }

   public final void setChinaPrivacyConsentVersion(int var1) {
      if (enabled) {
         extras.setChinaPrivacyConsentVersion(var1);
         this.saveData();
      }
   }

   public final void setVersion(int var1) {
      if (enabled) {
         version = var1;
         this.saveData();
      }
   }

   public final UserInfoCollections toUserInfoCollections() {
      return new UserInfoCollections(String.valueOf(version), String.valueOf(series), extras, collections);
   }

   public final boolean update(UserInfoCollections var1) {
      Intrinsics.checkNotNullParameter(var1, "data");
      if (!enabled) {
         return false;
      } else {
         Integer var3 = StringsKt.toIntOrNull(var1.getSeries());
         int var2 = series;
         if (var3 != null && var3 == var2) {
            var3 = StringsKt.toIntOrNull(var1.getVersion());
            if (var3 != null) {
               var2 = var3;
            } else {
               var2 = 0;
            }

            if (var2 > version) {
               this.setData(var1);
               this.saveData();
               return true;
            }
         }

         return false;
      }
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
         int[] var0 = new int[UserInfoItem.values().length];

         try {
            var0[UserInfoItem.USER_EMAIL.ordinal()] = 1;
         } catch (NoSuchFieldError var14) {
         }

         try {
            var0[UserInfoItem.USER_PASSWORD.ordinal()] = 2;
         } catch (NoSuchFieldError var13) {
         }

         try {
            var0[UserInfoItem.USER_AGE.ordinal()] = 3;
         } catch (NoSuchFieldError var12) {
         }

         try {
            var0[UserInfoItem.PHONE_MODEL.ordinal()] = 4;
         } catch (NoSuchFieldError var11) {
         }

         try {
            var0[UserInfoItem.PHONE_SYSTEM_VERSION.ordinal()] = 5;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[UserInfoItem.BLUEAIR_APP_VERSION.ordinal()] = 6;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[UserInfoItem.PHONE_BRAND.ordinal()] = 7;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[UserInfoItem.PHONE_RAM_SIZE.ordinal()] = 8;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[UserInfoItem.PHONE_VENDOR.ordinal()] = 9;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[UserInfoItem.PHONE_COUNTRY_CODE.ordinal()] = 10;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[UserInfoItem.BLUEAIR_APP_INFO.ordinal()] = 11;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[UserInfoItem.DEVICE_SERIAL.ordinal()] = 12;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[UserInfoItem.DEVICE_MAC.ordinal()] = 13;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
