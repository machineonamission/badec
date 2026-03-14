package com.blueair.android.util;

import android.content.res.Configuration;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.DurationBasedAnimationSpec;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.BlurKt;
import androidx.compose.ui.draw.BlurredEdgeTreatment;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Brush.Companion;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.DrawScope._CC;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000&\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u001e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0002\u001a\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\r\u001a\u001f\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0003¢\u0006\u0002\u0010\u0011\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012²\u0006\n\u0010\u0005\u001a\u00020\u0006X\u008a\u0084\u0002²\u0006\n\u0010\u0013\u001a\u00020\u0006X\u008a\u0084\u0002²\u0006\n\u0010\u0014\u001a\u00020\u0010X\u008a\u008e\u0002"},
   d2 = {"aqiHaloColor", "", "", "aqiMidPointColor", "getMidPointColor", "airQuality", "", "getHaloColor", "getInterpolatedColor", "colorList", "AqiAnimationBackground", "", "aqiValue", "(FLandroidx/compose/runtime/Composer;I)V", "DrawAqiAnimationBackground", "blurEnabled", "", "(FZLandroidx/compose/runtime/Composer;II)V", "app_otherRelease", "animationBaseTimer", "haveBeenInitialized"},
   k = 2,
   mv = {2, 2, 0},
   xi = 48
)
public final class AqiAnimationBackgroundKt {
   private static final List aqiHaloColor = CollectionsKt.listOf(new Integer[]{871786086, 872056904, 865256959, 859608831, 2134677247});
   private static final List aqiMidPointColor;

   // $FF: synthetic method
   public static Unit $r8$lambda$AaMnqhqZqa2RJECuVXeVpbzji_0(float var0, boolean var1, int var2, int var3, Composer var4, int var5) {
      return DrawAqiAnimationBackground$lambda$17(var0, var1, var2, var3, var4, var5);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$aWxA_BBOPqWP_aWHxXQlV_ZEIf4/* $FF was: $r8$lambda$aWxA-BBOPqWP-aWHxXQlV_ZEIf4*/(float var0, int var1, Composer var2, int var3) {
      return AqiAnimationBackground$lambda$1(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$jOQdHoFQMvyA12burhuHM3dIYNM(float var0, int var1, float[] var2, float[] var3, float[] var4, float[] var5, float[] var6, float var7, int var8, State var9, DrawScope var10) {
      return DrawAqiAnimationBackground$lambda$16$lambda$15(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$vObCLaTeblQvH83uvhjmNdwPxlc(GraphicsLayerScope var0) {
      return DrawAqiAnimationBackground$lambda$14$lambda$13(var0);
   }

   static {
      Integer var0 = 872277991;
      aqiMidPointColor = CollectionsKt.listOf(new Integer[]{var0, var0, 863681535, 869525503, 2144593919});
   }

   public static final void AqiAnimationBackground(float var0, Composer var1, int var2) {
      var1 = var1.startRestartGroup(1095347378);
      ComposerKt.sourceInformation(var1, "C(AqiAnimationBackground)82@2866L174,87@3045L38:AqiAnimationBackground.kt#f148wk");
      int var6;
      if ((var2 & 6) == 0) {
         if (var1.changed(var0)) {
            var6 = 4;
         } else {
            var6 = 2;
         }

         var6 |= var2;
      } else {
         var6 = var2;
      }

      if ((var6 & 3) == 2 && var1.getSkipping()) {
         var1.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1095347378, var6, -1, "com.blueair.android.util.AqiAnimationBackground (AqiAnimationBackground.kt:81)");
         }

         DrawAqiAnimationBackground(AqiAnimationBackground$lambda$0(AnimateAsStateKt.animateFloatAsState(var0, (AnimationSpec)AnimationSpecKt.tween$default(2000, 0, EasingKt.getLinearEasing(), 2, (Object)null), 0.0F, "airQualityTransition", (Function1)null, var1, var6 & 14 | 3072, 20)), false, var1, 0, 2);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      ScopeUpdateScope var5 = var1.endRestartGroup();
      if (var5 != null) {
         var5.updateScope(new AqiAnimationBackgroundKt$$ExternalSyntheticLambda0(var0, var2));
      }

   }

   private static final float AqiAnimationBackground$lambda$0(State var0) {
      return ((Number)var0.getValue()).floatValue();
   }

   private static final Unit AqiAnimationBackground$lambda$1(float var0, int var1, Composer var2, int var3) {
      AqiAnimationBackground(var0, var2, RecomposeScopeImplKt.updateChangedFlags(var1 | 1));
      return Unit.INSTANCE;
   }

   private static final void DrawAqiAnimationBackground(float var0, boolean var1, Composer var2, int var3, int var4) {
      Composer var18 = var2.startRestartGroup(1249619186);
      ComposerKt.sourceInformation(var18, "C(DrawAqiAnimationBackground)93@3269L61,97@3550L277,108@3897L37,109@3950L38,110@4004L36,111@4061L36,112@4122L36,113@4202L7,116@4289L34,118@4363L7,119@4450L7,139@5165L22,140@5194L1109,136@5057L1246:AqiAnimationBackground.kt#f148wk");
      int var42;
      if ((var3 & 6) == 0) {
         if (var18.changed(var0)) {
            var42 = 4;
         } else {
            var42 = 2;
         }

         var42 |= var3;
      } else {
         var42 = var3;
      }

      int var9 = var4 & 2;
      int var8;
      if (var9 != 0) {
         var8 = var42 | 48;
      } else {
         var8 = var42;
         if ((var3 & 48) == 0) {
            if (var18.changed(var1)) {
               var8 = 32;
            } else {
               var8 = 16;
            }

            var8 = var42 | var8;
         }
      }

      if ((var8 & 19) == 18 && var18.getSkipping()) {
         var18.skipToGroupEnd();
      } else {
         if (var9 != 0) {
            var1 = true;
         }

         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1249619186, var8, -1, "com.blueair.android.util.DrawAqiAnimationBackground (AqiAnimationBackground.kt:91)");
         }

         Timber.Forest var17 = Timber.Forest;
         StringBuilder var26 = new StringBuilder("AqiAnimationBackground: ");
         var26.append(var0);
         var17.d(var26.toString(), new Object[0]);
         State var19 = InfiniteTransitionKt.animateFloat(InfiniteTransitionKt.rememberInfiniteTransition("haloAnimationTransition", var18, 6, 0), 0.0F, 10000.0F, AnimationSpecKt.infiniteRepeatable-9IiC70o$default((DurationBasedAnimationSpec)AnimationSpecKt.tween$default(200000000, 0, EasingKt.getLinearEasing(), 2, (Object)null), RepeatMode.Restart, 0L, 4, (Object)null), "haloAnimationTimer", var18, InfiniteTransition.$stable | 25008 | InfiniteRepeatableSpec.$stable << 9, 0);
         ComposerKt.sourceInformationMarkerStart(var18, -1706779177, "CC(remember):AqiAnimationBackground.kt#9igjgp");
         Object var46 = var18.rememberedValue();
         Object var27 = var46;
         if (var46 == Composer.Companion.getEmpty()) {
            var27 = new float[11];
            var18.updateRememberedValue(var27);
         }

         float[] var20 = (float[])var27;
         ComposerKt.sourceInformationMarkerEnd(var18);
         ComposerKt.sourceInformationMarkerStart(var18, -1706777480, "CC(remember):AqiAnimationBackground.kt#9igjgp");
         var46 = var18.rememberedValue();
         var27 = var46;
         if (var46 == Composer.Companion.getEmpty()) {
            var27 = new float[11];
            var18.updateRememberedValue(var27);
         }

         float[] var21 = (float[])var27;
         ComposerKt.sourceInformationMarkerEnd(var18);
         ComposerKt.sourceInformationMarkerStart(var18, -1706775754, "CC(remember):AqiAnimationBackground.kt#9igjgp");
         var46 = var18.rememberedValue();
         var27 = var46;
         if (var46 == Composer.Companion.getEmpty()) {
            var27 = new float[11];
            var18.updateRememberedValue(var27);
         }

         float[] var22 = (float[])var27;
         ComposerKt.sourceInformationMarkerEnd(var18);
         ComposerKt.sourceInformationMarkerStart(var18, -1706773930, "CC(remember):AqiAnimationBackground.kt#9igjgp");
         var46 = var18.rememberedValue();
         var27 = var46;
         if (var46 == Composer.Companion.getEmpty()) {
            var27 = new float[11];
            var18.updateRememberedValue(var27);
         }

         float[] var23 = (float[])var27;
         ComposerKt.sourceInformationMarkerEnd(var18);
         ComposerKt.sourceInformationMarkerStart(var18, -1706771978, "CC(remember):AqiAnimationBackground.kt#9igjgp");
         var46 = var18.rememberedValue();
         var27 = var46;
         if (var46 == Composer.Companion.getEmpty()) {
            var27 = new float[11];
            var18.updateRememberedValue(var27);
         }

         float[] var24 = (float[])var27;
         ComposerKt.sourceInformationMarkerEnd(var18);
         CompositionLocal var32 = (CompositionLocal)AndroidCompositionLocals_androidKt.getLocalConfiguration();
         ComposerKt.sourceInformationMarkerStart(var18, 2023513938, "CC:CompositionLocal.kt#9igjgp");
         Object var33 = var18.consume(var32);
         ComposerKt.sourceInformationMarkerEnd(var18);
         Configuration var25 = (Configuration)var33;
         ComposerKt.sourceInformationMarkerStart(var18, -1706766636, "CC(remember):AqiAnimationBackground.kt#9igjgp");
         var46 = var18.rememberedValue();
         var33 = var46;
         if (var46 == Composer.Companion.getEmpty()) {
            var33 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy)null, 2, (Object)null);
            var18.updateRememberedValue(var33);
         }

         MutableState var35 = (MutableState)var33;
         ComposerKt.sourceInformationMarkerEnd(var18);
         CompositionLocal var52 = (CompositionLocal)CompositionLocalsKt.getLocalDensity();
         ComposerKt.sourceInformationMarkerStart(var18, 2023513938, "CC:CompositionLocal.kt#9igjgp");
         Object var53 = var18.consume(var52);
         ComposerKt.sourceInformationMarkerEnd(var18);
         float var6 = ((Density)var53).toPx-0680j_4(Dp.constructor-impl((float)var25.screenHeightDp));
         CompositionLocal var54 = (CompositionLocal)CompositionLocalsKt.getLocalDensity();
         ComposerKt.sourceInformationMarkerStart(var18, 2023513938, "CC:CompositionLocal.kt#9igjgp");
         Object var55 = var18.consume(var54);
         ComposerKt.sourceInformationMarkerEnd(var18);
         float var5 = ((Density)var55).toPx-0680j_4(Dp.constructor-impl((float)var25.screenWidthDp));
         if (!DrawAqiAnimationBackground$lambda$9(var35)) {
            DrawAqiAnimationBackground$lambda$10(var35, true);
            var42 = 0;

            while(true) {
               if (var42 < 7) {
                  var20[var42] = (float)2 * var5 / 5.5F;
               } else {
                  var20[var42] = 2.2F * var5 / 5.5F;
               }

               var22[var42] = Random.Default.nextFloat() * (var6 / (float)8);
               var21[var42] = Random.Default.nextFloat() * var5;
               var23[var42] = (float)2 * Random.Default.nextFloat() + 0.8F;
               var24[var42] = 0.0F;
               if (var42 == 10) {
                  break;
               }

               ++var42;
            }
         }

         if (var1) {
            var5 = Dp.constructor-impl((float)30);
         } else {
            var5 = Dp.constructor-impl((float)0);
         }

         Modifier var58 = BlurKt.blur-F8QBwvs$default(SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0.0F, 1, (Object)null), var5, (BlurredEdgeTreatment)null, 2, (Object)null);
         ComposerKt.sourceInformationMarkerStart(var18, -1706738616, "CC(remember):AqiAnimationBackground.kt#9igjgp");
         var55 = var18.rememberedValue();
         Object var36 = var55;
         if (var55 == Composer.Companion.getEmpty()) {
            var36 = new AqiAnimationBackgroundKt$$ExternalSyntheticLambda1();
            var18.updateRememberedValue(var36);
         }

         Function1 var37 = (Function1)var36;
         ComposerKt.sourceInformationMarkerEnd(var18);
         Modifier var57 = GraphicsLayerModifierKt.graphicsLayer(var58, var37);
         ComposerKt.sourceInformationMarkerStart(var18, -1706736601, "CC(remember):AqiAnimationBackground.kt#9igjgp");
         if ((var8 & 14) == 4) {
            var42 = 1;
         } else {
            var42 = 0;
         }

         boolean var16 = var18.changed(var19);
         boolean var15 = var18.changedInstance(var24);
         boolean var10 = var18.changedInstance(var23);
         boolean var14 = var18.changedInstance(var21);
         boolean var13 = var18.changedInstance(var22);
         boolean var12 = var18.changedInstance(var20);
         boolean var11 = var18.changed(var6);
         Object var38 = var18.rememberedValue();
         if (var16 | var42 | var15 | var10 | var14 | var13 | var12 | var11 || var38 == Composer.Companion.getEmpty()) {
            var38 = new AqiAnimationBackgroundKt$$ExternalSyntheticLambda2(var0, 10, var24, var23, var21, var22, var20, var6, 7, var19);
            var18.updateRememberedValue(var38);
         }

         Function1 var39 = (Function1)var38;
         ComposerKt.sourceInformationMarkerEnd(var18);
         CanvasKt.Canvas(var57, var39, var18, 0);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      ScopeUpdateScope var40 = var18.endRestartGroup();
      if (var40 != null) {
         var40.updateScope(new AqiAnimationBackgroundKt$$ExternalSyntheticLambda3(var0, var1, var3, var4));
      }

   }

   private static final void DrawAqiAnimationBackground$lambda$10(MutableState var0, boolean var1) {
      var0.setValue(var1);
   }

   private static final Unit DrawAqiAnimationBackground$lambda$14$lambda$13(GraphicsLayerScope var0) {
      Intrinsics.checkNotNullParameter(var0, "$this$graphicsLayer");
      var0.setAlpha(0.45F);
      return Unit.INSTANCE;
   }

   private static final Unit DrawAqiAnimationBackground$lambda$16$lambda$15(float var0, int var1, float[] var2, float[] var3, float[] var4, float[] var5, float[] var6, float var7, int var8, State var9, DrawScope var10) {
      Intrinsics.checkNotNullParameter(var10, "$this$Canvas");
      int var14 = getHaloColor(var0);
      Pair var16 = TuplesKt.to(0.0F, Color.box-impl(ColorKt.Color(getHaloColor(var0))));
      int var12 = 0;
      Pair var15 = TuplesKt.to(0.24F, Color.box-impl(ColorKt.Color(getMidPointColor(var0))));
      Pair var17 = TuplesKt.to(1.0F, Color.box-impl(Color.Companion.getWhite-0d7_KjU()));
      _CC.drawRect-AsUm42w$default(var10, Companion.verticalGradient-8A-3gB4$default(Brush.Companion, (Pair[])Arrays.copyOf(new Pair[]{var16, var15, var17}, 3), 0.0F, 0.0F, 0, 14, (Object)null), 0L, 0L, 0.0F, (DrawStyle)null, (ColorFilter)null, 0, 126, (Object)null);
      if (var1 >= 0) {
         while(true) {
            var0 = Size.getWidth-impl(var10.getSize-NH-jbRc()) * (DrawAqiAnimationBackground$lambda$2(var9) - var2[var12]) * var3[var12] + var4[var12];
            float var11 = var5[var12];
            if (var0 - var6[var12] > Size.getWidth-impl(var10.getSize-NH-jbRc()) || var2[var12] > DrawAqiAnimationBackground$lambda$2(var9)) {
               var5[var12] = Random.Default.nextFloat() * (var7 / (float)8);
               var4[var12] = -var6[var12];
               var2[var12] = DrawAqiAnimationBackground$lambda$2(var9);
            }

            int var13;
            if (var12 >= var8) {
               var13 = 285212672;
            } else {
               var13 = 855638016;
            }

            _CC.drawCircle-VaOC9Bg$default(var10, ColorKt.Color(var13 | 16777215 & var14), var6[var12], OffsetKt.Offset(var0, var11), 0.0F, (DrawStyle)null, (ColorFilter)null, 0, 120, (Object)null);
            if (var12 == var1) {
               break;
            }

            ++var12;
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit DrawAqiAnimationBackground$lambda$17(float var0, boolean var1, int var2, int var3, Composer var4, int var5) {
      DrawAqiAnimationBackground(var0, var1, var4, RecomposeScopeImplKt.updateChangedFlags(var2 | 1), var3);
      return Unit.INSTANCE;
   }

   private static final float DrawAqiAnimationBackground$lambda$2(State var0) {
      return ((Number)var0.getValue()).floatValue();
   }

   private static final boolean DrawAqiAnimationBackground$lambda$9(MutableState var0) {
      return (Boolean)((State)var0).getValue();
   }

   private static final int getHaloColor(float var0) {
      return getInterpolatedColor(var0, aqiHaloColor);
   }

   private static final int getInterpolatedColor(float var0, List var1) {
      int var4 = (int)(var0 / 25.0F);
      int var3 = var4;
      if (var4 > 3) {
         var3 = 3;
      }

      var4 = var3;
      if (var3 < 0) {
         var4 = 0;
      }

      float var2 = (var0 - (float)var4 * 25.0F) / 25.0F;
      var0 = var2;
      if (var2 < 0.0F) {
         var0 = 0.0F;
      }

      var2 = var0;
      if (var0 > 1.0F) {
         var2 = 1.0F;
      }

      var0 = 1.0F - var2;
      var3 = ((Number)var1.get(var4)).intValue();
      int var7 = ((Number)var1.get(var4 + 1)).intValue();
      var4 = (int)((float)(var3 >> 24 & 255) * var0 + (float)(var7 >> 24 & 255) * var2);
      int var6 = (int)((float)(var3 >> 16 & 255) * var0 + (float)(var7 >> 16 & 255) * var2);
      int var5 = (int)((float)(var3 >> 8 & 255) * var0 + (float)(var7 >> 8 & 255) * var2);
      return (int)((float)(var3 & 255) * var0 + (float)(var7 & 255) * var2) & 255 | (var4 & 255) << 24 | (var6 & 255) << 16 | (var5 & 255) << 8;
   }

   private static final int getMidPointColor(float var0) {
      return getInterpolatedColor(var0, aqiMidPointColor);
   }
}
