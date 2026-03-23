package com.blueair.android.util;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.material3.MenuKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
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
import okhttp3.internal.ws.WebSocketProtocol;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u001e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0002\u001a\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\r\u001a\u001f\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0003¢\u0006\u0002\u0010\u0011\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012²\u0006\n\u0010\u0005\u001a\u00020\u0006X\u0002²\u0006\n\u0010\u0013\u001a\u00020\u0006X\u0002²\u0006\n\u0010\u0014\u001a\u00020\u0010X\u0002"}, d2 = {"aqiHaloColor", "", "", "aqiMidPointColor", "getMidPointColor", "airQuality", "", "getHaloColor", "getInterpolatedColor", "colorList", "AqiAnimationBackground", "", "aqiValue", "(FLandroidx/compose/runtime/Composer;I)V", "DrawAqiAnimationBackground", "blurEnabled", "", "(FZLandroidx/compose/runtime/Composer;II)V", "app_otherRelease", "animationBaseTimer", "haveBeenInitialized"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* compiled from: AqiAnimationBackground.kt */
public final class AqiAnimationBackgroundKt {
    private static final List<Integer> aqiHaloColor = CollectionsKt.listOf(871786086, 872056904, 865256959, 859608831, 2134677247);
    private static final List<Integer> aqiMidPointColor = CollectionsKt.listOf(872277991, 872277991, 863681535, 869525503, 2144593919);

    /* access modifiers changed from: private */
    public static final Unit AqiAnimationBackground$lambda$1(float f, int i, Composer composer, int i2) {
        AqiAnimationBackground(f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit DrawAqiAnimationBackground$lambda$17(float f, boolean z, int i, int i2, Composer composer, int i3) {
        DrawAqiAnimationBackground(f, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    private static final int getMidPointColor(float f) {
        return getInterpolatedColor(f, aqiMidPointColor);
    }

    private static final int getHaloColor(float f) {
        return getInterpolatedColor(f, aqiHaloColor);
    }

    private static final int getInterpolatedColor(float f, List<Integer> list) {
        int i = (int) (f / 25.0f);
        if (i > 3) {
            i = 3;
        }
        if (i < 0) {
            i = 0;
        }
        float f2 = (f - (((float) i) * 25.0f)) / 25.0f;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        float f3 = 1.0f - f2;
        int intValue = list.get(i).intValue();
        int intValue2 = list.get(i + 1).intValue();
        return (((int) ((((float) (intValue & 255)) * f3) + (((float) (intValue2 & 255)) * f2))) & 255) | ((((int) ((((float) ((intValue >> 24) & 255)) * f3) + (((float) ((intValue2 >> 24) & 255)) * f2))) & 255) << 24) | ((((int) ((((float) ((intValue >> 16) & 255)) * f3) + (((float) ((intValue2 >> 16) & 255)) * f2))) & 255) << 16) | ((((int) ((((float) ((intValue >> 8) & 255)) * f3) + (((float) ((intValue2 >> 8) & 255)) * f2))) & 255) << 8);
    }

    public static final void AqiAnimationBackground(float f, Composer composer, int i) {
        int i2;
        float f2;
        Composer startRestartGroup = composer.startRestartGroup(1095347378);
        ComposerKt.sourceInformation(startRestartGroup, "C(AqiAnimationBackground)82@2866L174,87@3045L38:AqiAnimationBackground.kt#f148wk");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(f) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1095347378, i2, -1, "com.blueair.android.util.AqiAnimationBackground (AqiAnimationBackground.kt:81)");
            }
            f2 = f;
            DrawAqiAnimationBackground(AqiAnimationBackground$lambda$0(AnimateAsStateKt.animateFloatAsState(f2, AnimationSpecKt.tween$default(2000, 0, EasingKt.getLinearEasing(), 2, (Object) null), 0.0f, "airQualityTransition", (Function1<? super Float, Unit>) null, startRestartGroup, (i2 & 14) | 3072, 20)), false, startRestartGroup, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            f2 = f;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AqiAnimationBackgroundKt$$ExternalSyntheticLambda0(f2, i));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x02e1  */
    /* JADX WARNING: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final void DrawAqiAnimationBackground(float r23, boolean r24, androidx.compose.runtime.Composer r25, int r26, int r27) {
        /*
            r1 = r23
            r11 = r26
            r12 = r27
            r0 = 1249619186(0x4a7bacf2, float:4123452.5)
            r2 = r25
            androidx.compose.runtime.Composer r7 = r2.startRestartGroup(r0)
            java.lang.String r2 = "C(DrawAqiAnimationBackground)93@3269L61,97@3550L277,108@3897L37,109@3950L38,110@4004L36,111@4061L36,112@4122L36,113@4202L7,116@4289L34,118@4363L7,119@4450L7,139@5160L22,140@5189L1109,136@5052L1246:AqiAnimationBackground.kt#f148wk"
            androidx.compose.runtime.ComposerKt.sourceInformation(r7, r2)
            r2 = r11 & 6
            r13 = 2
            if (r2 != 0) goto L_0x0024
            boolean r2 = r7.changed((float) r1)
            if (r2 == 0) goto L_0x0021
            r2 = 4
            goto L_0x0022
        L_0x0021:
            r2 = r13
        L_0x0022:
            r2 = r2 | r11
            goto L_0x0025
        L_0x0024:
            r2 = r11
        L_0x0025:
            r3 = r12 & 2
            if (r3 == 0) goto L_0x002c
            r2 = r2 | 48
            goto L_0x003f
        L_0x002c:
            r4 = r11 & 48
            if (r4 != 0) goto L_0x003f
            r4 = r24
            boolean r5 = r7.changed((boolean) r4)
            if (r5 == 0) goto L_0x003b
            r5 = 32
            goto L_0x003d
        L_0x003b:
            r5 = 16
        L_0x003d:
            r2 = r2 | r5
            goto L_0x0041
        L_0x003f:
            r4 = r24
        L_0x0041:
            r14 = r2
            r2 = r14 & 19
            r5 = 18
            if (r2 != r5) goto L_0x0055
            boolean r2 = r7.getSkipping()
            if (r2 != 0) goto L_0x004f
            goto L_0x0055
        L_0x004f:
            r7.skipToGroupEnd()
            r14 = r7
            goto L_0x02db
        L_0x0055:
            if (r3 == 0) goto L_0x005a
            r16 = 1
            goto L_0x005c
        L_0x005a:
            r16 = r4
        L_0x005c:
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L_0x0068
            r2 = -1
            java.lang.String r3 = "com.blueair.android.util.DrawAqiAnimationBackground (AqiAnimationBackground.kt:91)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r14, r2, r3)
        L_0x0068:
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "AqiAnimationBackground: "
            r2.<init>(r3)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            r3 = 0
            java.lang.Object[] r4 = new java.lang.Object[r3]
            r0.d(r2, r4)
            java.lang.String r0 = "haloAnimationTransition"
            r2 = 6
            androidx.compose.animation.core.InfiniteTransition r0 = androidx.compose.animation.core.InfiniteTransitionKt.rememberInfiniteTransition(r0, r7, r2, r3)
            r4 = 200000000(0xbebc200, float:9.0810606E-32)
            androidx.compose.animation.core.Easing r5 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            r6 = 0
            androidx.compose.animation.core.TweenSpec r4 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r4, r3, r5, r13, r6)
            r17 = r4
            androidx.compose.animation.core.DurationBasedAnimationSpec r17 = (androidx.compose.animation.core.DurationBasedAnimationSpec) r17
            androidx.compose.animation.core.RepeatMode r18 = androidx.compose.animation.core.RepeatMode.Restart
            r21 = 4
            r22 = 0
            r19 = 0
            androidx.compose.animation.core.InfiniteRepeatableSpec r5 = androidx.compose.animation.core.AnimationSpecKt.m442infiniteRepeatable9IiC70o$default(r17, r18, r19, r21, r22)
            int r4 = androidx.compose.animation.core.InfiniteTransition.$stable
            r4 = r4 | 25008(0x61b0, float:3.5044E-41)
            int r8 = androidx.compose.animation.core.InfiniteRepeatableSpec.$stable
            int r8 = r8 << 9
            r8 = r8 | r4
            r9 = 0
            r4 = r3
            r3 = 0
            r17 = r4
            r4 = 1176256512(0x461c4000, float:10000.0)
            r18 = r6
            java.lang.String r6 = "haloAnimationTimer"
            r10 = r2
            r2 = r0
            r0 = r10
            r10 = r18
            androidx.compose.runtime.State r2 = androidx.compose.animation.core.InfiniteTransitionKt.animateFloat(r2, r3, r4, r5, r6, r7, r8, r9)
            r3 = r7
            r4 = -1706779177(0xffffffff9a449dd7, float:-4.0659352E-23)
            java.lang.String r5 = "CC(remember):AqiAnimationBackground.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r4, r5)
            java.lang.Object r4 = r3.rememberedValue()
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            r7 = 11
            if (r4 != r6) goto L_0x00db
            float[] r4 = new float[r7]
            r3.updateRememberedValue(r4)
        L_0x00db:
            float[] r4 = (float[]) r4
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r6 = -1706777480(0xffffffff9a44a478, float:-4.0664707E-23)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r6, r5)
            java.lang.Object r6 = r3.rememberedValue()
            androidx.compose.runtime.Composer$Companion r8 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r8 = r8.getEmpty()
            if (r6 != r8) goto L_0x00f7
            float[] r6 = new float[r7]
            r3.updateRememberedValue(r6)
        L_0x00f7:
            float[] r6 = (float[]) r6
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r8 = -1706775754(0xffffffff9a44ab36, float:-4.0670153E-23)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r8, r5)
            java.lang.Object r8 = r3.rememberedValue()
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r9.getEmpty()
            if (r8 != r9) goto L_0x0113
            float[] r8 = new float[r7]
            r3.updateRememberedValue(r8)
        L_0x0113:
            float[] r8 = (float[]) r8
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r9 = -1706773930(0xffffffff9a44b256, float:-4.067591E-23)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r9, r5)
            java.lang.Object r9 = r3.rememberedValue()
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r0 = r18.getEmpty()
            if (r9 != r0) goto L_0x012f
            float[] r9 = new float[r7]
            r3.updateRememberedValue(r9)
        L_0x012f:
            float[] r9 = (float[]) r9
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            r0 = -1706771978(0xffffffff9a44b9f6, float:-4.0682068E-23)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r0, r5)
            java.lang.Object r0 = r3.rememberedValue()
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r15 = r18.getEmpty()
            if (r0 != r15) goto L_0x014b
            float[] r0 = new float[r7]
            r3.updateRememberedValue(r0)
        L_0x014b:
            float[] r0 = (float[]) r0
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalConfiguration()
            androidx.compose.runtime.CompositionLocal r7 = (androidx.compose.runtime.CompositionLocal) r7
            r15 = 2023513938(0x789c5f52, float:2.5372864E34)
            java.lang.String r10 = "CC:CompositionLocal.kt#9igjgp"
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r15, r10)
            java.lang.Object r7 = r3.consume(r7)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            android.content.res.Configuration r7 = (android.content.res.Configuration) r7
            r15 = -1706766636(0xffffffff9a44ced4, float:-4.0698924E-23)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r15, r5)
            java.lang.Object r15 = r3.rememberedValue()
            androidx.compose.runtime.Composer$Companion r21 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r21.getEmpty()
            if (r15 != r13) goto L_0x0187
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r17)
            r1 = 2
            r15 = 0
            androidx.compose.runtime.MutableState r13 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r13, r15, r1, r15)
            r3.updateRememberedValue(r13)
            r15 = r13
        L_0x0187:
            androidx.compose.runtime.MutableState r15 = (androidx.compose.runtime.MutableState) r15
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r1 = (androidx.compose.runtime.CompositionLocal) r1
            r13 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r13, r10)
            java.lang.Object r1 = r3.consume(r1)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.ui.unit.Density r1 = (androidx.compose.ui.unit.Density) r1
            int r13 = r7.screenHeightDp
            float r13 = (float) r13
            float r13 = androidx.compose.ui.unit.Dp.m7638constructorimpl(r13)
            float r1 = r1.m7574toPx0680j_4(r13)
            androidx.compose.runtime.ProvidableCompositionLocal r13 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            androidx.compose.runtime.CompositionLocal r13 = (androidx.compose.runtime.CompositionLocal) r13
            r21 = r14
            r14 = 2023513938(0x789c5f52, float:2.5372864E34)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r14, r10)
            java.lang.Object r10 = r3.consume(r13)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.ui.unit.Density r10 = (androidx.compose.ui.unit.Density) r10
            int r7 = r7.screenWidthDp
            float r7 = (float) r7
            float r7 = androidx.compose.ui.unit.Dp.m7638constructorimpl(r7)
            float r7 = r10.m7574toPx0680j_4(r7)
            boolean r10 = DrawAqiAnimationBackground$lambda$9(r15)
            r24 = 0
            r13 = 7
            if (r10 != 0) goto L_0x0221
            r10 = 1
            DrawAqiAnimationBackground$lambda$10(r15, r10)
            r10 = r17
        L_0x01dd:
            if (r10 >= r13) goto L_0x01e8
            r15 = 2
            float r13 = (float) r15
            float r13 = r13 * r7
            r15 = 6
            float r14 = (float) r15
            float r13 = r13 / r14
            r4[r10] = r13
            goto L_0x01f1
        L_0x01e8:
            r15 = 6
            r13 = 1074580685(0x400ccccd, float:2.2)
            float r13 = r13 * r7
            float r14 = (float) r15
            float r13 = r13 / r14
            r4[r10] = r13
        L_0x01f1:
            kotlin.random.Random$Default r13 = kotlin.random.Random.Default
            float r13 = r13.nextFloat()
            r14 = 8
            float r14 = (float) r14
            float r14 = r1 / r14
            float r13 = r13 * r14
            r8[r10] = r13
            kotlin.random.Random$Default r13 = kotlin.random.Random.Default
            float r13 = r13.nextFloat()
            float r13 = r13 * r7
            r6[r10] = r13
            r13 = 2
            float r14 = (float) r13
            kotlin.random.Random$Default r13 = kotlin.random.Random.Default
            float r13 = r13.nextFloat()
            float r14 = r14 * r13
            r13 = 1061997773(0x3f4ccccd, float:0.8)
            float r14 = r14 + r13
            r9[r10] = r14
            r0[r10] = r24
            r13 = 10
            if (r10 == r13) goto L_0x0223
            int r10 = r10 + 1
            r13 = 7
            goto L_0x01dd
        L_0x0221:
            r13 = 10
        L_0x0223:
            if (r16 == 0) goto L_0x0230
            r7 = 140(0x8c, float:1.96E-43)
            float r7 = (float) r7
            float r7 = androidx.compose.ui.unit.Dp.m7638constructorimpl(r7)
            r10 = r7
            r7 = r17
            goto L_0x0237
        L_0x0230:
            r7 = r17
            float r10 = (float) r7
            float r10 = androidx.compose.ui.unit.Dp.m7638constructorimpl(r10)
        L_0x0237:
            androidx.compose.ui.Modifier$Companion r14 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Modifier r14 = (androidx.compose.ui.Modifier) r14
            r15 = r24
            r7 = 1
            r13 = 0
            androidx.compose.ui.Modifier r14 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r14, r15, r7, r13)
            r15 = 2
            androidx.compose.ui.Modifier r10 = androidx.compose.ui.draw.BlurKt.m4213blurF8QBwvs$default(r14, r10, r13, r15, r13)
            r13 = -1706738776(0xffffffff9a453ba8, float:-4.0786835E-23)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r13, r5)
            java.lang.Object r13 = r3.rememberedValue()
            androidx.compose.runtime.Composer$Companion r14 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r14 = r14.getEmpty()
            if (r13 != r14) goto L_0x0262
            com.blueair.android.util.AqiAnimationBackgroundKt$$ExternalSyntheticLambda1 r13 = new com.blueair.android.util.AqiAnimationBackgroundKt$$ExternalSyntheticLambda1
            r13.<init>()
            r3.updateRememberedValue(r13)
        L_0x0262:
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r3)
            androidx.compose.ui.Modifier r13 = androidx.compose.ui.graphics.GraphicsLayerModifierKt.graphicsLayer(r10, r13)
            r10 = -1706736761(0xffffffff9a454387, float:-4.0793193E-23)
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r3, r10, r5)
            r5 = r21 & 14
            r10 = 4
            if (r5 != r10) goto L_0x0278
            r15 = r7
            goto L_0x0279
        L_0x0278:
            r15 = 0
        L_0x0279:
            boolean r5 = r3.changed((java.lang.Object) r2)
            r5 = r5 | r15
            boolean r7 = r3.changedInstance(r0)
            r5 = r5 | r7
            boolean r7 = r3.changedInstance(r9)
            r5 = r5 | r7
            boolean r7 = r3.changedInstance(r6)
            r5 = r5 | r7
            boolean r7 = r3.changedInstance(r8)
            r5 = r5 | r7
            boolean r7 = r3.changedInstance(r4)
            r5 = r5 | r7
            boolean r7 = r3.changed((float) r1)
            r5 = r5 | r7
            java.lang.Object r7 = r3.rememberedValue()
            if (r5 != 0) goto L_0x02b0
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r7 != r5) goto L_0x02ab
            goto L_0x02b0
        L_0x02ab:
            r15 = 0
            r1 = r23
            r14 = r3
            goto L_0x02c8
        L_0x02b0:
            r7 = r3
            r3 = r0
            com.blueair.android.util.AqiAnimationBackgroundKt$$ExternalSyntheticLambda2 r0 = new com.blueair.android.util.AqiAnimationBackgroundKt$$ExternalSyntheticLambda2
            r15 = 0
            r10 = r2
            r5 = r6
            r14 = r7
            r6 = r8
            r2 = 10
            r8 = r1
            r7 = r4
            r4 = r9
            r9 = 7
            r1 = r23
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r14.updateRememberedValue(r0)
            r7 = r0
        L_0x02c8:
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
            androidx.compose.foundation.CanvasKt.Canvas(r13, r7, r14, r15)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x02d9
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x02d9:
            r4 = r16
        L_0x02db:
            androidx.compose.runtime.ScopeUpdateScope r0 = r14.endRestartGroup()
            if (r0 == 0) goto L_0x02e9
            com.blueair.android.util.AqiAnimationBackgroundKt$$ExternalSyntheticLambda3 r2 = new com.blueair.android.util.AqiAnimationBackgroundKt$$ExternalSyntheticLambda3
            r2.<init>(r1, r4, r11, r12)
            r0.updateScope(r2)
        L_0x02e9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.util.AqiAnimationBackgroundKt.DrawAqiAnimationBackground(float, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final void DrawAqiAnimationBackground$lambda$10(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean DrawAqiAnimationBackground$lambda$9(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final Unit DrawAqiAnimationBackground$lambda$14$lambda$13(GraphicsLayerScope graphicsLayerScope) {
        Intrinsics.checkNotNullParameter(graphicsLayerScope, "$this$graphicsLayer");
        graphicsLayerScope.setAlpha(0.45f);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit DrawAqiAnimationBackground$lambda$16$lambda$15(float f, int i, float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, float[] fArr5, float f2, int i2, State state, DrawScope drawScope) {
        int i3 = i;
        DrawScope drawScope2 = drawScope;
        Intrinsics.checkNotNullParameter(drawScope2, "$this$Canvas");
        int haloColor = getHaloColor(f);
        int i4 = 0;
        DrawScope.CC.m5273drawRectAsUm42w$default(drawScope2, Brush.Companion.m4558verticalGradient8A3gB4$default(Brush.Companion, (Pair[]) Arrays.copyOf(new Pair[]{TuplesKt.to(Float.valueOf(0.0f), Color.m4601boximpl(ColorKt.Color(getHaloColor(f)))), TuplesKt.to(Float.valueOf(0.24f), Color.m4601boximpl(ColorKt.Color(getMidPointColor(f)))), TuplesKt.to(Float.valueOf(1.0f), Color.m4601boximpl(Color.Companion.m4648getWhite0d7_KjU()))}, 3), 0.0f, 0.0f, 0, 14, (Object) null), 0, 0, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, WebSocketProtocol.PAYLOAD_SHORT, (Object) null);
        if (i3 >= 0) {
            while (true) {
                float r2 = (Size.m4426getWidthimpl(drawScope.m5235getSizeNHjbRc()) * (DrawAqiAnimationBackground$lambda$2(state) - fArr[i4]) * fArr2[i4]) + fArr3[i4];
                float f3 = fArr4[i4];
                if (r2 - fArr5[i4] > Size.m4426getWidthimpl(drawScope.m5235getSizeNHjbRc()) || fArr[i4] > DrawAqiAnimationBackground$lambda$2(state)) {
                    fArr4[i4] = Random.Default.nextFloat() * (f2 / ((float) 8));
                    fArr3[i4] = -fArr5[i4];
                    fArr[i4] = DrawAqiAnimationBackground$lambda$2(state);
                }
                int i5 = i4 >= i2 ? 285212672 : 855638016;
                float f4 = fArr5[i4];
                DrawScope.CC.m5261drawCircleVaOC9Bg$default(drawScope, ColorKt.Color(i5 | (16777215 & haloColor)), f4, OffsetKt.Offset(r2, f3), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, MenuKt.InTransitionDuration, (Object) null);
                if (i4 == i3) {
                    break;
                }
                i4++;
            }
        }
        return Unit.INSTANCE;
    }

    private static final float AqiAnimationBackground$lambda$0(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float DrawAqiAnimationBackground$lambda$2(State<Float> state) {
        return state.getValue().floatValue();
    }
}
