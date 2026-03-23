package com.blueair.viewcore;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0007²\u0006\n\u0010\b\u001a\u00020\tX\u0002²\u0006\n\u0010\n\u001a\u00020\tX\u0002²\u0006\n\u0010\u000b\u001a\u00020\tX\u0002²\u0006\n\u0010\f\u001a\u00020\tX\u0002"}, d2 = {"com/blueair/viewcore/ViewUtils$colorGradient$shaderFactory$1", "Landroid/graphics/drawable/ShapeDrawable$ShaderFactory;", "resize", "Landroid/graphics/Shader;", "width", "", "height", "viewcore_otherRelease", "x0", "", "x1", "y0", "y1"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ViewUtils.kt */
public final class ViewUtils$colorGradient$shaderFactory$1 extends ShapeDrawable.ShaderFactory {
    final /* synthetic */ int[] $colors;
    final /* synthetic */ GradientDrawable.Orientation $orientation;
    final /* synthetic */ float[] $positions;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: ViewUtils.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|19) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                android.graphics.drawable.GradientDrawable$Orientation[] r0 = android.graphics.drawable.GradientDrawable.Orientation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                android.graphics.drawable.GradientDrawable$Orientation r1 = android.graphics.drawable.GradientDrawable.Orientation.TL_BR     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                android.graphics.drawable.GradientDrawable$Orientation r1 = android.graphics.drawable.GradientDrawable.Orientation.LEFT_RIGHT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                android.graphics.drawable.GradientDrawable$Orientation r1 = android.graphics.drawable.GradientDrawable.Orientation.BL_TR     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                android.graphics.drawable.GradientDrawable$Orientation r1 = android.graphics.drawable.GradientDrawable.Orientation.TR_BL     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                android.graphics.drawable.GradientDrawable$Orientation r1 = android.graphics.drawable.GradientDrawable.Orientation.RIGHT_LEFT     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                android.graphics.drawable.GradientDrawable$Orientation r1 = android.graphics.drawable.GradientDrawable.Orientation.BR_TL     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                android.graphics.drawable.GradientDrawable$Orientation r1 = android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                android.graphics.drawable.GradientDrawable$Orientation r1 = android.graphics.drawable.GradientDrawable.Orientation.BOTTOM_TOP     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.viewcore.ViewUtils$colorGradient$shaderFactory$1.WhenMappings.<clinit>():void");
        }
    }

    ViewUtils$colorGradient$shaderFactory$1(int[] iArr, float[] fArr, GradientDrawable.Orientation orientation) {
        this.$colors = iArr;
        this.$positions = fArr;
        this.$orientation = orientation;
    }

    private static final float resize$lambda$1(Lazy<Float> lazy) {
        return lazy.getValue().floatValue();
    }

    public Shader resize(int i, int i2) {
        Lazy lazy = LazyKt.lazy(new ViewUtils$colorGradient$shaderFactory$1$$ExternalSyntheticLambda0(this.$orientation, i));
        Lazy lazy2 = LazyKt.lazy(new ViewUtils$colorGradient$shaderFactory$1$$ExternalSyntheticLambda1(this.$orientation, i));
        return new LinearGradient(resize$lambda$1(lazy), resize$lambda$5(LazyKt.lazy(new ViewUtils$colorGradient$shaderFactory$1$$ExternalSyntheticLambda2(this.$orientation, i2))), resize$lambda$3(lazy2), resize$lambda$7(LazyKt.lazy(new ViewUtils$colorGradient$shaderFactory$1$$ExternalSyntheticLambda3(this.$orientation, i2))), this.$colors, this.$positions, Shader.TileMode.REPEAT);
    }

    /* access modifiers changed from: private */
    public static final float resize$lambda$0(GradientDrawable.Orientation orientation, int i) {
        switch (WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()]) {
            case 1:
            case 2:
            case 3:
                return 0.0f;
            case 4:
            case 5:
            case 6:
                return (float) i;
            case 7:
            case 8:
                return ((float) i) / 2.0f;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final float resize$lambda$3(Lazy<Float> lazy) {
        return lazy.getValue().floatValue();
    }

    /* access modifiers changed from: private */
    public static final float resize$lambda$2(GradientDrawable.Orientation orientation, int i) {
        switch (WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()]) {
            case 1:
            case 2:
            case 3:
                return (float) i;
            case 4:
            case 5:
            case 6:
                return 0.0f;
            case 7:
            case 8:
                return ((float) i) / 2.0f;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final float resize$lambda$5(Lazy<Float> lazy) {
        return lazy.getValue().floatValue();
    }

    /* access modifiers changed from: private */
    public static final float resize$lambda$4(GradientDrawable.Orientation orientation, int i) {
        switch (WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()]) {
            case 1:
            case 4:
            case 7:
                return 0.0f;
            case 2:
            case 5:
                return ((float) i) / 2.0f;
            case 3:
            case 6:
            case 8:
                return (float) i;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final float resize$lambda$7(Lazy<Float> lazy) {
        return lazy.getValue().floatValue();
    }

    /* access modifiers changed from: private */
    public static final float resize$lambda$6(GradientDrawable.Orientation orientation, int i) {
        switch (WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()]) {
            case 1:
            case 4:
            case 7:
                return (float) i;
            case 2:
            case 5:
                return ((float) i) / 2.0f;
            case 3:
            case 6:
            case 8:
                return 0.0f;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
