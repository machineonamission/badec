package com.blueair.viewcore.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(
   d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001:\u0001qB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\u0007H\u0014J\u0010\u0010O\u001a\u00020J2\u0006\u0010P\u001a\u00020QH\u0015J\u0010\u0010R\u001a\u00020J2\u0006\u0010P\u001a\u00020QH\u0002J\u0010\u0010S\u001a\u00020J2\u0006\u0010P\u001a\u00020QH\u0002J\u0010\u0010T\u001a\u00020J2\u0006\u0010P\u001a\u00020QH\u0002J\u0010\u0010U\u001a\u00020J2\u0006\u0010P\u001a\u00020QH\u0002J\u0010\u0010V\u001a\u00020J2\u0006\u0010P\u001a\u00020QH\u0002J \u0010W\u001a\u00020J2\u0006\u0010P\u001a\u00020Q2\u0006\u0010X\u001a\u00020\u000b2\u0006\u0010Y\u001a\u00020\u000bH\u0002J\u0010\u0010Z\u001a\u00020*2\u0006\u0010[\u001a\u00020\\H\u0017J\u0010\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\u000bH\u0002J\u0018\u0010`\u001a\u00020\u000b2\u0006\u0010a\u001a\u00020\u000b2\u0006\u0010b\u001a\u00020\u000bH\u0002J(\u0010c\u001a\u00020\u000b2\u0006\u0010d\u001a\u00020\u000b2\u0006\u0010e\u001a\u00020\u000b2\u0006\u0010f\u001a\u00020\u000b2\u0006\u0010g\u001a\u00020\u000bH\u0002J\u000e\u0010h\u001a\u00020J2\u0006\u0010i\u001a\u000200J\u0016\u0010j\u001a\u00020J2\u0006\u0010k\u001a\u00020\u00072\u0006\u0010l\u001a\u00020\u0007J\u000e\u0010m\u001a\u00020J2\u0006\u0010n\u001a\u00020\u0007J\u0010\u0010o\u001a\u00020J2\b\u0010p\u001a\u0004\u0018\u000105R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020CX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020CX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020CX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020GX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020GX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006r"},
   d2 = {"Lcom/blueair/viewcore/view/CirculatorFanView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "density", "", "activeColor", "activeColorStart", "activeColorEnd", "backgroundColor", "backgroundTrackColor", "handleColorWhite", "borderColor", "handleInnerDiameter", "handleInnerRadius", "handleBorderWidth", "handleOuterRadius", "strokeWidthActiveArc", "strokeWidthTrackArc", "strokeWidthLine", "topWhiteSectorRadius", "startAngle", "endAngle", "pointAngle", "minStartAngle", "maxEndAngle", "getMaxEndAngle", "()F", "setMaxEndAngle", "(F)V", "stepAngle", "minSweepAngle", "centerX", "topPivotY", "arcRadius", "isDraggingStart", "", "isDraggingEnd", "isDraggingPoint", "isOverlapMode", "lastTouchAngle", "angleTextView", "Landroid/widget/TextView;", "activeGradient", "Landroid/graphics/LinearGradient;", "fixed", "onAngleChangeListener", "Lcom/blueair/viewcore/view/CirculatorFanView$OnAngleChangeListener;", "touchThresholdSquared", "activeArcPaint", "Landroid/graphics/Paint;", "backgroundTrackPaint", "activeLinePaint", "backgroundLinePaint", "activeSectorPaint", "backgroundSectorPaint", "topWhiteSectorPaint", "handleOuterPaint", "handleBorderPaint", "handleInnerPaint", "sectorPath", "Landroid/graphics/Path;", "backgroundSectorPath", "topWhiteSectorPath", "arcRect", "Landroid/graphics/RectF;", "topWhiteSectorRect", "onSizeChanged", "", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawBackgroundSector", "drawBackgroundNetwork", "drawTopWhiteSector", "drawActiveSector", "drawActiveNetwork", "drawHandle", "cx", "cy", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "getPointOnCircle", "Landroid/graphics/PointF;", "angleDegrees", "getAngleFromPoint", "x", "y", "getDistanceSquared", "x1", "y1", "x2", "y2", "bindAngleTextView", "view", "setSwingAngle", "start", "end", "setFixAngle", "angle", "setOnAngleChangeListener", "listener", "OnAngleChangeListener", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class CirculatorFanView extends View {
   private final Paint activeArcPaint;
   private final int activeColor;
   private final int activeColorEnd;
   private final int activeColorStart;
   private LinearGradient activeGradient;
   private final Paint activeLinePaint;
   private final Paint activeSectorPaint;
   private TextView angleTextView;
   private float arcRadius;
   private final RectF arcRect;
   private final int backgroundColor;
   private final Paint backgroundLinePaint;
   private final Paint backgroundSectorPaint;
   private final Path backgroundSectorPath;
   private final int backgroundTrackColor;
   private final Paint backgroundTrackPaint;
   private final int borderColor;
   private float centerX;
   private final float density;
   private float endAngle;
   private boolean fixed;
   private final Paint handleBorderPaint;
   private final float handleBorderWidth;
   private final int handleColorWhite;
   private final float handleInnerDiameter;
   private final Paint handleInnerPaint;
   private final float handleInnerRadius;
   private final Paint handleOuterPaint;
   private final float handleOuterRadius;
   private boolean isDraggingEnd;
   private boolean isDraggingPoint;
   private boolean isDraggingStart;
   private boolean isOverlapMode;
   private float lastTouchAngle;
   private float maxEndAngle;
   private final float minStartAngle;
   private final float minSweepAngle;
   private OnAngleChangeListener onAngleChangeListener;
   private float pointAngle;
   private final Path sectorPath;
   private float startAngle;
   private final float stepAngle;
   private final float strokeWidthActiveArc;
   private final float strokeWidthLine;
   private final float strokeWidthTrackArc;
   private float topPivotY;
   private final Paint topWhiteSectorPaint;
   private final Path topWhiteSectorPath;
   private final float topWhiteSectorRadius;
   private final RectF topWhiteSectorRect;
   private final float touchThresholdSquared;

   public CirculatorFanView(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      this(var1, (AttributeSet)null, 0, 6, (DefaultConstructorMarker)null);
   }

   public CirculatorFanView(Context var1, AttributeSet var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      this(var1, var2, 0, 4, (DefaultConstructorMarker)null);
   }

   public CirculatorFanView(Context var1, AttributeSet var2, int var3) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super(var1, var2, var3);
      float var4 = var1.getResources().getDisplayMetrics().density;
      this.density = var4;
      var3 = Color.parseColor("#3096FF");
      this.activeColor = var3;
      this.activeColorStart = Color.parseColor("#D3E7FF");
      this.activeColorEnd = Color.parseColor("#2F3096FF");
      int var11 = Color.parseColor("#F2F2F2");
      this.backgroundColor = var11;
      int var10 = Color.parseColor("#D6D6D6");
      this.backgroundTrackColor = var10;
      this.handleColorWhite = -1;
      this.borderColor = -16777216;
      float var5 = var4 * 12.0F;
      this.handleInnerDiameter = var5;
      this.handleInnerRadius = var5 / (float)2;
      float var9 = var4 * 2.0F;
      this.handleBorderWidth = var9;
      float var6 = 12.0F * var4;
      this.handleOuterRadius = var6;
      float var8 = var4 * 8.0F;
      this.strokeWidthActiveArc = var8;
      float var7 = 8.0F * var4;
      this.strokeWidthTrackArc = var7;
      var5 = var4 * 2.0F;
      this.strokeWidthLine = var5;
      this.topWhiteSectorRadius = 40.0F * var4;
      this.startAngle = 30.0F;
      this.endAngle = 60.0F;
      this.pointAngle = 30.0F;
      this.minStartAngle = 30.0F;
      this.maxEndAngle = 150.0F;
      this.stepAngle = 5.0F;
      this.minSweepAngle = 30.0F;
      this.touchThresholdSquared = (float)Math.pow((double)(var6 * (float)4), (double)2);
      Paint var12 = new Paint(1);
      var12.setStyle(Style.STROKE);
      var12.setColor(Color.parseColor("#70B2FF"));
      var12.setStrokeWidth(var8);
      var12.setStrokeCap(Cap.ROUND);
      this.activeArcPaint = var12;
      var12 = new Paint(1);
      var12.setStyle(Style.STROKE);
      var12.setColor(var10);
      var12.setStrokeWidth(var7);
      var12.setStrokeCap(Cap.BUTT);
      this.backgroundTrackPaint = var12;
      var12 = new Paint(1);
      var12.setStyle(Style.STROKE);
      var12.setStrokeWidth(var5);
      var12.setStrokeCap(Cap.ROUND);
      this.activeLinePaint = var12;
      var12 = new Paint(1);
      var12.setStyle(Style.STROKE);
      var12.setStrokeWidth(var4 * 1.2F);
      var12.setStrokeCap(Cap.ROUND);
      this.backgroundLinePaint = var12;
      var12 = new Paint(1);
      var12.setStyle(Style.FILL);
      this.activeSectorPaint = var12;
      var12 = new Paint(1);
      var12.setStyle(Style.FILL);
      var12.setColor(var11);
      this.backgroundSectorPaint = var12;
      var12 = new Paint(1);
      var12.setStyle(Style.FILL);
      var12.setColor(-1);
      this.topWhiteSectorPaint = var12;
      var12 = new Paint(1);
      var12.setStyle(Style.FILL);
      var12.setColor(-1);
      var12.setShadowLayer(4.0F, 0.0F, 2.0F, Color.parseColor("#40000000"));
      this.handleOuterPaint = var12;
      var12 = new Paint(1);
      var12.setStyle(Style.STROKE);
      var12.setColor(-16777216);
      var12.setStrokeWidth(var9);
      this.handleBorderPaint = var12;
      var12 = new Paint(1);
      var12.setStyle(Style.FILL);
      var12.setColor(var3);
      this.handleInnerPaint = var12;
      this.sectorPath = new Path();
      this.backgroundSectorPath = new Path();
      this.topWhiteSectorPath = new Path();
      this.arcRect = new RectF();
      this.topWhiteSectorRect = new RectF();
   }

   // $FF: synthetic method
   public CirculatorFanView(Context var1, AttributeSet var2, int var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 2) != 0) {
         var2 = null;
      }

      if ((var4 & 4) != 0) {
         var3 = 0;
      }

      this(var1, var2, var3);
   }

   private final void drawActiveNetwork(Canvas var1) {
      PointF var5 = this.getPointOnCircle(this.startAngle);
      PointF var6 = this.getPointOnCircle(this.endAngle);
      var1.drawLine(this.centerX, this.topPivotY, var5.x, var5.y, this.activeLinePaint);
      var1.drawLine(this.centerX, this.topPivotY, var6.x, var6.y, this.activeLinePaint);
      RectF var8 = this.arcRect;
      float var2 = this.centerX;
      float var4 = this.arcRadius;
      float var3 = this.topPivotY;
      var8.set(var2 - var4, var3 - var4, var2 + var4, var3 + var4);
      var8 = this.arcRect;
      var2 = this.startAngle;
      var1.drawArc(var8, var2, this.endAngle - var2, false, this.activeArcPaint);
   }

   private final void drawActiveSector(Canvas var1) {
      this.sectorPath.reset();
      this.sectorPath.moveTo(this.centerX, this.topPivotY);
      RectF var5 = this.arcRect;
      float var4 = this.centerX;
      float var2 = this.arcRadius;
      float var3 = this.topPivotY;
      var5.set(var4 - var2, var3 - var2, var4 + var2, var3 + var2);
      Path var6 = this.sectorPath;
      var5 = this.arcRect;
      var2 = this.startAngle;
      var6.arcTo(var5, var2, this.endAngle - var2);
      this.sectorPath.close();
      var1.drawPath(this.sectorPath, this.activeSectorPaint);
   }

   private final void drawBackgroundNetwork(Canvas var1) {
      PointF var6 = this.getPointOnCircle(this.minStartAngle);
      PointF var7 = this.getPointOnCircle(this.maxEndAngle);
      float var2 = this.maxEndAngle;
      float var3 = this.minStartAngle;
      PointF var5 = this.getPointOnCircle((var2 - var3) / (float)2 + var3);
      var1.drawLine(this.centerX, this.topPivotY, var6.x, var6.y, this.backgroundLinePaint);
      var1.drawLine(this.centerX, this.topPivotY, var7.x, var7.y, this.backgroundLinePaint);
      var1.drawLine(this.centerX, this.topPivotY, var5.x, var5.y, this.backgroundLinePaint);
      if (this.fixed) {
         RectF var11 = this.arcRect;
         var3 = this.centerX;
         var2 = this.arcRadius;
         float var4 = this.topPivotY;
         var11.set(var3 - var2, var4 - var2, var3 + var2, var4 + var2);
         var11 = this.arcRect;
         var2 = this.minStartAngle;
         var1.drawArc(var11, var2, this.maxEndAngle - var2, false, this.backgroundTrackPaint);
      }

   }

   private final void drawBackgroundSector(Canvas var1) {
      this.backgroundSectorPath.reset();
      this.backgroundSectorPath.moveTo(this.centerX, this.topPivotY);
      RectF var5 = this.arcRect;
      float var4 = this.centerX;
      float var3 = this.arcRadius;
      float var2 = this.topPivotY;
      var5.set(var4 - var3, var2 - var3, var4 + var3, var2 + var3);
      Path var6 = this.backgroundSectorPath;
      var5 = this.arcRect;
      var2 = this.minStartAngle;
      var6.arcTo(var5, var2, this.maxEndAngle - var2);
      this.backgroundSectorPath.close();
      var1.drawPath(this.backgroundSectorPath, this.backgroundSectorPaint);
   }

   private final void drawHandle(Canvas var1, float var2, float var3) {
      var1.drawCircle(var2, var3, this.handleOuterRadius, this.handleOuterPaint);
      var1.drawCircle(var2, var3, this.handleOuterRadius, this.handleBorderPaint);
      var1.drawCircle(var2, var3, this.handleInnerRadius, this.handleInnerPaint);
   }

   private final void drawTopWhiteSector(Canvas var1) {
      this.topWhiteSectorPath.reset();
      this.topWhiteSectorPath.moveTo(this.centerX, this.topPivotY);
      Path var3 = this.topWhiteSectorPath;
      RectF var4 = this.topWhiteSectorRect;
      float var2 = this.minStartAngle;
      var3.arcTo(var4, var2, this.maxEndAngle - var2);
      this.topWhiteSectorPath.close();
      var1.drawPath(this.topWhiteSectorPath, this.topWhiteSectorPaint);
   }

   private final float getAngleFromPoint(float var1, float var2) {
      float var3 = this.centerX;
      var2 = (float)Math.toDegrees(Math.atan2((double)(var2 - this.topPivotY), (double)(var1 - var3)));
      var1 = var2;
      if (var2 < 0.0F) {
         if (var2 > -90.0F) {
            return 0.0F;
         }

         var1 = 180.0F;
      }

      return var1;
   }

   private final float getDistanceSquared(float var1, float var2, float var3, float var4) {
      var1 -= var3;
      var2 -= var4;
      return var1 * var1 + var2 * var2;
   }

   private final PointF getPointOnCircle(float var1) {
      double var2 = Math.toRadians((double)var1);
      return new PointF(this.centerX + this.arcRadius * (float)Math.cos(var2), this.topPivotY + this.arcRadius * (float)Math.sin(var2));
   }

   public final void bindAngleTextView(TextView var1) {
      Intrinsics.checkNotNullParameter(var1, "view");
      this.angleTextView = var1;
   }

   public final float getMaxEndAngle() {
      return this.maxEndAngle;
   }

   protected void onDraw(Canvas var1) {
      Intrinsics.checkNotNullParameter(var1, "canvas");
      super.onDraw(var1);
      this.drawBackgroundSector(var1);
      this.drawBackgroundNetwork(var1);
      if (this.fixed) {
         PointF var5 = this.getPointOnCircle(this.pointAngle);
         var1.drawLine(this.centerX, this.topPivotY, var5.x, var5.y, this.activeLinePaint);
         this.drawTopWhiteSector(var1);
         this.drawHandle(var1, var5.x, var5.y);
         float var3 = this.maxEndAngle;
         if (var3 == 150.0F) {
            float var2 = this.minStartAngle;
            var2 = (var3 - var2) / (float)2 - this.pointAngle + var2;
            TextView var11 = this.angleTextView;
            if (var11 != null) {
               StringBuilder var7;
               if (var2 > 0.0F) {
                  var7 = new StringBuilder("+");
               } else {
                  var7 = new StringBuilder();
               }

               var7.append((int)var2);
               var7.append('°');
               var11.setText((CharSequence)var7.toString());
               return;
            }
         } else {
            TextView var8 = this.angleTextView;
            if (var8 != null) {
               StringBuilder var12 = new StringBuilder();
               var12.append((int)(this.pointAngle - this.minStartAngle));
               var12.append('°');
               var8.setText((CharSequence)var12.toString());
               return;
            }
         }
      } else {
         this.drawActiveSector(var1);
         this.drawTopWhiteSector(var1);
         this.drawActiveNetwork(var1);
         PointF var13 = this.getPointOnCircle(this.startAngle);
         PointF var6 = this.getPointOnCircle(this.endAngle);
         this.drawHandle(var1, var13.x, var13.y);
         this.drawHandle(var1, var6.x, var6.y);
         int var4 = (int)(this.endAngle - this.startAngle);
         TextView var14 = this.angleTextView;
         if (var14 != null) {
            StringBuilder var9 = new StringBuilder();
            var9.append(var4);
            var9.append('°');
            var14.setText((CharSequence)var9.toString());
         }
      }

   }

   protected void onSizeChanged(int var1, int var2, int var3, int var4) {
      super.onSizeChanged(var1, var2, var3, var4);
      this.centerX = (float)var1 / 2.0F;
      float var6 = (float)(var2 - this.getPaddingTop() - this.getPaddingBottom());
      float var5 = this.topWhiteSectorRadius;
      this.arcRadius = var6 - var5;
      RectF var8 = this.topWhiteSectorRect;
      var6 = this.centerX;
      float var7 = this.topPivotY;
      var8.set(var6 - var5, var7 - var5, var6 + var5, var7 + var5);
      var5 = this.centerX;
      var6 = this.topPivotY;
      LinearGradient var16 = new LinearGradient(var5, var6, var5, var6 + this.arcRadius, this.activeColorStart, this.activeColorEnd, TileMode.CLAMP);
      this.activeGradient = var16;
      this.activeSectorPaint.setShader((Shader)var16);
      Paint var17 = this.activeLinePaint;
      var6 = this.centerX;
      var5 = this.topPivotY;
      var17.setShader((Shader)(new LinearGradient(var6, var5, var6, var5 + this.arcRadius, -1, this.activeColor, TileMode.CLAMP)));
      var5 = this.centerX;
      var6 = this.topPivotY;
      LinearGradient var18 = new LinearGradient(var5, var6, var5, var6 + this.arcRadius, 0, this.backgroundTrackColor, TileMode.CLAMP);
      this.backgroundLinePaint.setShader((Shader)var18);
   }

   public boolean onTouchEvent(MotionEvent var1) {
      Intrinsics.checkNotNullParameter(var1, "event");
      float var4 = var1.getX();
      float var5 = var1.getY();
      int var7 = var1.getAction();
      boolean var8 = false;
      if (var7 != 0) {
         if (var7 != 1) {
            if (var7 == 2) {
               float var2 = (float)MathKt.roundToInt(this.getAngleFromPoint(var4, var5) / this.stepAngle) * this.stepAngle;
               if (this.fixed) {
                  if (this.isDraggingPoint) {
                     var2 = RangesKt.coerceIn(var2, this.minStartAngle, this.maxEndAngle);
                     this.pointAngle = var2;
                     OnAngleChangeListener var9 = this.onAngleChangeListener;
                     if (var9 != null) {
                        var9.onFixAngleChange((int)(var2 - this.minStartAngle));
                     }

                     this.invalidate();
                     return super.onTouchEvent(var1);
                  }

                  return super.onTouchEvent(var1);
               } else {
                  if (this.isOverlapMode) {
                     float var3 = var2 - this.lastTouchAngle;
                     if (Math.abs(var3) > 0.5F) {
                        if (var3 > 0.0F) {
                           this.isDraggingEnd = true;
                           this.isDraggingStart = false;
                        } else {
                           this.isDraggingStart = true;
                           this.isDraggingEnd = false;
                        }

                        this.isOverlapMode = false;
                     }
                  }

                  if (this.isDraggingStart) {
                     float var15 = RangesKt.coerceIn(var2, this.minStartAngle, this.maxEndAngle);
                     var5 = this.endAngle;
                     var4 = var5 - this.minSweepAngle;
                     var2 = var15;
                     if (var15 > var4) {
                        var2 = var4;
                     }

                     var4 = this.minStartAngle;
                     var15 = var2;
                     if (var2 < var4) {
                        var15 = var4;
                     }

                     this.startAngle = var15;
                     OnAngleChangeListener var26 = this.onAngleChangeListener;
                     if (var26 != null) {
                        var26.onSwing((int)(var15 - var4), (int)(var5 - var4));
                     }

                     this.invalidate();
                  } else if (this.isDraggingEnd) {
                     float var17 = RangesKt.coerceIn(var2, this.minStartAngle, this.maxEndAngle);
                     var5 = this.startAngle;
                     var4 = this.minSweepAngle + var5;
                     var2 = var17;
                     if (var17 < var4) {
                        var2 = var4;
                     }

                     this.endAngle = var2;
                     OnAngleChangeListener var27 = this.onAngleChangeListener;
                     if (var27 != null) {
                        var17 = this.minStartAngle;
                        var27.onSwing((int)(var5 - var17), (int)(var2 - var17));
                     }

                     this.invalidate();
                     return super.onTouchEvent(var1);
                  }

                  return super.onTouchEvent(var1);
               }
            }

            if (var7 != 3) {
               return super.onTouchEvent(var1);
            }
         }

         this.isDraggingStart = false;
         this.isDraggingEnd = false;
         this.isDraggingPoint = false;
         this.isOverlapMode = false;
         this.getParent().requestDisallowInterceptTouchEvent(false);
      } else if (this.fixed) {
         PointF var28 = this.getPointOnCircle(this.pointAngle);
         if (this.getDistanceSquared(var4, var5, var28.x, var28.y) <= this.touchThresholdSquared) {
            this.isDraggingPoint = true;
            this.getParent().requestDisallowInterceptTouchEvent(true);
            return true;
         }
      } else {
         PointF var10 = this.getPointOnCircle(this.startAngle);
         PointF var29 = this.getPointOnCircle(this.endAngle);
         float var19 = this.getDistanceSquared(var4, var5, var10.x, var10.y);
         float var6 = this.getDistanceSquared(var4, var5, var29.x, var29.y);
         float var14 = this.touchThresholdSquared;
         if (var19 <= var14) {
            var7 = 1;
         } else {
            var7 = 0;
         }

         if (var6 <= var14) {
            var8 = true;
         }

         if (var7 && var8) {
            this.isOverlapMode = true;
            this.lastTouchAngle = this.getAngleFromPoint(var4, var5);
            this.getParent().requestDisallowInterceptTouchEvent(true);
            return true;
         }

         if (var7) {
            this.isDraggingStart = true;
            this.getParent().requestDisallowInterceptTouchEvent(true);
            return true;
         }

         if (var8) {
            this.isDraggingEnd = true;
            this.getParent().requestDisallowInterceptTouchEvent(true);
            return true;
         }
      }

      return super.onTouchEvent(var1);
   }

   public final void setFixAngle(int var1) {
      this.pointAngle = (float)var1 + this.minStartAngle;
      this.fixed = true;
      this.invalidate();
   }

   public final void setMaxEndAngle(float var1) {
      this.maxEndAngle = var1;
   }

   public final void setOnAngleChangeListener(OnAngleChangeListener var1) {
      this.onAngleChangeListener = var1;
   }

   public final void setSwingAngle(int var1, int var2) {
      float var4 = (float)var1;
      float var3 = this.minStartAngle;
      float var6 = var4 + var3;
      this.startAngle = var6;
      var4 = (float)var2 + var3;
      float var7 = this.minSweepAngle;
      var3 = var4;
      if (var4 < var6 + var7) {
         var3 = var6 + var7;
      }

      float var5 = this.maxEndAngle;
      var4 = var3;
      if (var3 > var5) {
         if (var6 > var5 - var7) {
            this.startAngle = var5 - var7;
         }

         var4 = var5;
      }

      this.endAngle = var4;
      this.fixed = false;
      this.invalidate();
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H&¨\u0006\tÀ\u0006\u0003"},
      d2 = {"Lcom/blueair/viewcore/view/CirculatorFanView$OnAngleChangeListener;", "", "onSwing", "", "start", "", "end", "onFixAngleChange", "angle", "viewcore_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public interface OnAngleChangeListener {
      void onFixAngleChange(int var1);

      void onSwing(int var1, int var2);
   }
}
