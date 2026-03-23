package com.blueair.outdoor.ui.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J0\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J0\u0010\u001a\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/blueair/outdoor/ui/adapters/LocationPageIndicatorItemDecorator;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "currentLocationActiveBitmap", "Landroid/graphics/Bitmap;", "currentLocationInactiveBitmap", "savedLocationActiveBitmap", "savedLocationInactiveBitmap", "onDraw", "", "c", "Landroid/graphics/Canvas;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "drawInactive", "indicatorStartX", "", "startY", "itemCount", "hasCurrentLocation", "", "drawActive", "activeElement", "Companion", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: LocationPageIndicatorItemDecorator.kt */
public final class LocationPageIndicatorItemDecorator extends RecyclerView.ItemDecoration {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final float DP;
    private static final int mIndicatorHeightPadding;
    /* access modifiers changed from: private */
    public static final int mIndicatorItemLength;
    private static final int mIndicatorItemPadding;
    private Bitmap currentLocationActiveBitmap;
    private Bitmap currentLocationInactiveBitmap;
    private Bitmap savedLocationActiveBitmap;
    private Bitmap savedLocationInactiveBitmap;

    public LocationPageIndicatorItemDecorator(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int color = ContextCompat.getColor(context, R.color.marineblue);
        int color2 = ContextCompat.getColor(context, R.color.gray);
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.ic_gps);
        if (drawable != null) {
            Drawable mutate = drawable.mutate();
            Intrinsics.checkNotNullExpressionValue(mutate, "mutate(...)");
            mutate.setTint(color);
            Companion companion = Companion;
            this.currentLocationActiveBitmap = companion.convertToBitmap(mutate);
            Drawable mutate2 = drawable.mutate();
            Intrinsics.checkNotNullExpressionValue(mutate2, "mutate(...)");
            mutate2.setTint(color2);
            this.currentLocationInactiveBitmap = companion.convertToBitmap(mutate2);
        }
        Drawable drawable2 = ContextCompat.getDrawable(context, R.drawable.bg_circle);
        if (drawable2 != null) {
            Drawable mutate3 = drawable2.mutate();
            Intrinsics.checkNotNullExpressionValue(mutate3, "mutate(...)");
            mutate3.setTint(color);
            Companion companion2 = Companion;
            this.savedLocationActiveBitmap = companion2.convertToBitmap(mutate3);
            Drawable mutate4 = drawable2.mutate();
            Intrinsics.checkNotNullExpressionValue(mutate4, "mutate(...)");
            mutate4.setTint(color2);
            this.savedLocationInactiveBitmap = companion2.convertToBitmap(mutate4);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/blueair/outdoor/ui/adapters/LocationPageIndicatorItemDecorator$Companion;", "", "<init>", "()V", "DP", "", "mIndicatorHeightPadding", "", "mIndicatorItemLength", "mIndicatorItemPadding", "convertToBitmap", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: LocationPageIndicatorItemDecorator.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final Bitmap convertToBitmap(Drawable drawable) {
            if (drawable instanceof BitmapDrawable) {
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                Intrinsics.checkNotNullExpressionValue(bitmap, "getBitmap(...)");
                return bitmap;
            }
            Bitmap createBitmap = Bitmap.createBitmap(LocationPageIndicatorItemDecorator.mIndicatorItemLength, LocationPageIndicatorItemDecorator.mIndicatorItemLength, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        }
    }

    static {
        float f = Resources.getSystem().getDisplayMetrics().density;
        DP = f;
        mIndicatorHeightPadding = (int) (((float) 4) * f);
        float f2 = (float) 8;
        mIndicatorItemLength = (int) (f * f2);
        mIndicatorItemPadding = (int) (f * f2);
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(canvas, "c");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.onDraw(canvas, recyclerView, state);
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.blueair.outdoor.ui.adapters.LocationAdapter");
        LocationAdapter locationAdapter = (LocationAdapter) adapter;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type com.blueair.outdoor.ui.adapters.LocationLinearLayoutManager");
        LocationLinearLayoutManager locationLinearLayoutManager = (LocationLinearLayoutManager) layoutManager;
        int itemCount = locationAdapter.getItemCount();
        if (itemCount != 0) {
            int i = mIndicatorItemLength;
            float max = ((float) (i * itemCount)) + ((float) (Math.max(0, itemCount - 1) * mIndicatorItemPadding));
            int height = (recyclerView.getHeight() - i) - mIndicatorHeightPadding;
            int width = (int) ((((float) recyclerView.getWidth()) - max) / 2.0f);
            Canvas canvas2 = canvas;
            drawInactive(canvas2, width, height, itemCount, locationAdapter.getShowCurrentLocation());
            int findFirstCompletelyVisibleItemPosition = locationLinearLayoutManager.findFirstCompletelyVisibleItemPosition();
            if (findFirstCompletelyVisibleItemPosition != -1) {
                drawActive(canvas2, width, height, findFirstCompletelyVisibleItemPosition, locationAdapter.getShowCurrentLocation());
            }
        }
    }

    private final void drawInactive(Canvas canvas, int i, int i2, int i3, boolean z) {
        int i4 = mIndicatorItemLength;
        for (int i5 = 0; i5 < i3; i5++) {
            Rect rect = new Rect(i, i2, i + i4, i2 + i4);
            if (i5 != 0 || !z) {
                Bitmap bitmap = this.savedLocationInactiveBitmap;
                if (bitmap != null) {
                    canvas.drawBitmap(bitmap, (Rect) null, rect, (Paint) null);
                }
            } else {
                Bitmap bitmap2 = this.currentLocationInactiveBitmap;
                if (bitmap2 != null) {
                    canvas.drawBitmap(bitmap2, (Rect) null, rect, (Paint) null);
                }
            }
            i += mIndicatorItemPadding + i4;
        }
    }

    private final void drawActive(Canvas canvas, int i, int i2, int i3, boolean z) {
        int i4 = mIndicatorItemLength;
        int i5 = i + ((mIndicatorItemPadding + i4) * i3);
        Rect rect = new Rect(i5, i2, i5 + i4, i4 + i2);
        if (i3 != 0 || !z) {
            Bitmap bitmap = this.savedLocationActiveBitmap;
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, (Rect) null, rect, (Paint) null);
                return;
            }
            return;
        }
        Bitmap bitmap2 = this.currentLocationActiveBitmap;
        if (bitmap2 != null) {
            canvas.drawBitmap(bitmap2, (Rect) null, rect, (Paint) null);
        }
    }
}
