package com.blueair.devicedetails.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import androidx.core.util.TypedValueCompat;
import androidx.core.view.ViewCompat;
import com.github.gzuliyujiang.wheelview.R;
import com.github.gzuliyujiang.wheelview.contract.TextProvider;
import com.github.gzuliyujiang.wheelview.contract.WheelFormatter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b8\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 â\u00012\u00020\u00012\u00020\u0002:\u0002â\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010g\u001a\u00020hH\u0002J\u0010\u0010i\u001a\u00020h2\b\b\u0001\u0010j\u001a\u00020\bJ*\u0010k\u001a\u00020h2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010l\u001a\u00020\bH\u0003J\b\u0010m\u001a\u00020hH\u0002J\b\u0010n\u001a\u00020hH\u0002J\u001d\u0010q\u001a\u0004\u0018\u0001Hr\"\u0004\b\u0000\u0010r2\u0006\u0010s\u001a\u00020\bH\u0002¢\u0006\u0002\u0010tJ\u0010\u0010u\u001a\u00020\b2\b\u0010v\u001a\u0004\u0018\u00010\u0014J\u0013\u0010w\u001a\u0004\u0018\u0001Hr\"\u0004\b\u0000\u0010r¢\u0006\u0002\u0010xJ\u0010\u0010y\u001a\u00020h2\b\b\u0001\u0010z\u001a\u00020\bJ\u0010\u0010{\u001a\u00020h2\b\u0010|\u001a\u0004\u0018\u00010FJ\u0014\u0010}\u001a\u00020h2\f\u0010~\u001a\b\u0012\u0002\b\u0003\u0018\u00010\fJ\u001f\u0010\u001a\u00020h2\f\u0010~\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f2\t\u0010\u0001\u001a\u0004\u0018\u00010\u0014J\u001f\u0010\u001a\u00020h2\f\u0010~\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f2\u0007\u0010\u0001\u001a\u00020\bH\u0002J\u0011\u0010\u0001\u001a\u00020h2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014J\u000f\u0010\u0001\u001a\u00020h2\u0006\u0010s\u001a\u00020\bJ\u0013\u0010\u0001\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014H\u0002J\u000f\u0010\u0001\u001a\u00020h2\u0006\u00101\u001a\u00020)J\u0012\u0010\u0001\u001a\u00020h2\t\u0010\u0001\u001a\u0004\u0018\u00010\u001cJ\u0012\u0010\u0001\u001a\u00020h2\t\b\u0001\u0010\u0001\u001a\u00020\bJ\u0012\u0010\u0001\u001a\u00020h2\t\b\u0001\u0010\u0001\u001a\u00020\bJ\u0010\u0010\u0001\u001a\u00020h2\u0007\u0010\u0001\u001a\u00020)J\u0012\u0010\u0001\u001a\u00020h2\t\b\u0001\u0010\u0001\u001a\u00020\bJ\u000f\u0010\u0001\u001a\u00020h2\u0006\u00102\u001a\u00020)J\u0012\u0010\u0001\u001a\u00020h2\t\b\u0001\u0010\u0001\u001a\u00020\u001fJ\u0012\u0010\u0001\u001a\u00020h2\t\b\u0001\u0010\u0001\u001a\u00020\bJ\u0012\u0010\u0001\u001a\u00020h2\t\b\u0001\u0010\u0001\u001a\u00020\bJ\u000f\u0010\u0001\u001a\u00020h2\u0006\u00103\u001a\u00020)J\u0012\u0010\u0001\u001a\u00020h2\t\b\u0001\u0010\u0001\u001a\u00020\bJ\u000f\u0010\u0001\u001a\u00020h2\u0006\u0010-\u001a\u00020\bJ\u0011\u0010\u0001\u001a\u00020h2\b\b\u0001\u0010.\u001a\u00020\u001fJ\u0007\u0010\u0001\u001a\u00020)J\u000f\u0010\u0001\u001a\u00020h2\u0006\u00104\u001a\u00020)J\u0010\u0010\u0001\u001a\u00020h2\u0007\u0010\u0001\u001a\u00020)J\u000f\u0010\u0001\u001a\u00020h2\u0006\u0010;\u001a\u00020\bJ\u0010\u0010\u0001\u001a\u00020h2\u0007\u0010\u0001\u001a\u00020\bJ\t\u0010\u0001\u001a\u00020hH\u0002J\u0012\u0010¦\u0001\u001a\u00020h2\u0007\u0010§\u0001\u001a\u00020\bH\u0002J\u001b\u0010¨\u0001\u001a\u00020h2\u0007\u0010©\u0001\u001a\u00020\b2\u0007\u0010ª\u0001\u001a\u00020\bH\u0014J$\u0010«\u0001\u001a\u00020\b2\u0007\u0010¬\u0001\u001a\u00020\b2\u0007\u0010­\u0001\u001a\u00020\b2\u0007\u0010®\u0001\u001a\u00020\bH\u0002J-\u0010¯\u0001\u001a\u00020h2\u0007\u0010°\u0001\u001a\u00020\b2\u0007\u0010±\u0001\u001a\u00020\b2\u0007\u0010²\u0001\u001a\u00020\b2\u0007\u0010³\u0001\u001a\u00020\bH\u0014J\t\u0010´\u0001\u001a\u00020hH\u0002J\t\u0010µ\u0001\u001a\u00020hH\u0002J\t\u0010¶\u0001\u001a\u00020hH\u0002J\t\u0010·\u0001\u001a\u00020hH\u0002J\u0013\u0010¸\u0001\u001a\u00020h2\b\u0010¹\u0001\u001a\u00030º\u0001H\u0014J\u0013\u0010»\u0001\u001a\u00020h2\b\u0010¹\u0001\u001a\u00030º\u0001H\u0002J.\u0010¼\u0001\u001a\u00020h2\b\u0010¹\u0001\u001a\u00030º\u00012\u0007\u0010½\u0001\u001a\u00020\b2\u0007\u0010¾\u0001\u001a\u00020)2\u0007\u0010¿\u0001\u001a\u00020\u001fH\u0002J%\u0010À\u0001\u001a\u00020h2\b\u0010¹\u0001\u001a\u00030º\u00012\u0007\u0010½\u0001\u001a\u00020\b2\u0007\u0010¿\u0001\u001a\u00020\u001fH\u0002J\u001b\u0010Á\u0001\u001a\u00020\u001f2\u0007\u0010Â\u0001\u001a\u00020\b2\u0007\u0010Ã\u0001\u001a\u00020\u001fH\u0002J#\u0010Ä\u0001\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u001f2\u0007\u0010Å\u0001\u001a\u00020\u001f2\u0007\u0010Æ\u0001\u001a\u00020\u001fH\u0002J\u0012\u0010Ç\u0001\u001a\u00020\u001c2\u0007\u0010È\u0001\u001a\u00020\bH\u0002J\u0011\u0010É\u0001\u001a\u00020\u001c2\u0006\u0010s\u001a\u00020\bH\u0002J\u0013\u0010É\u0001\u001a\u00020\u001c2\b\u0010v\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010Ê\u0001\u001a\u00020h2\u0007\u0010Ë\u0001\u001a\u00020\bH\u0002J\u0013\u0010Ì\u0001\u001a\u00020h2\b\u0010¹\u0001\u001a\u00030º\u0001H\u0002J\u0013\u0010Í\u0001\u001a\u00020h2\b\u0010¹\u0001\u001a\u00030º\u0001H\u0002J\u0019\u0010Î\u0001\u001a\u00020)2\u0006\u0010s\u001a\u00020\b2\u0006\u0010o\u001a\u00020\bH\u0002J\u0012\u0010Ï\u0001\u001a\u00020\u001f2\u0007\u0010Ð\u0001\u001a\u00020\u001fH\u0002J\u0012\u0010Ñ\u0001\u001a\u00020\u001f2\u0007\u0010Ð\u0001\u001a\u00020\u001fH\u0002J\u0012\u0010Ò\u0001\u001a\u00020\b2\u0007\u0010Ð\u0001\u001a\u00020\u001fH\u0002J\u0013\u0010Ó\u0001\u001a\u00020)2\b\u0010Ô\u0001\u001a\u00030Õ\u0001H\u0016J\u0013\u0010Ö\u0001\u001a\u00020h2\b\u0010Ô\u0001\u001a\u00030Õ\u0001H\u0002J\u0013\u0010×\u0001\u001a\u00020h2\b\u0010Ô\u0001\u001a\u00030Õ\u0001H\u0002J\u0013\u0010Ø\u0001\u001a\u00020h2\b\u0010Ô\u0001\u001a\u00030Õ\u0001H\u0002J\t\u0010Ù\u0001\u001a\u00020hH\u0002J\t\u0010Ú\u0001\u001a\u00020hH\u0002J\t\u0010Û\u0001\u001a\u00020hH\u0002J\u0012\u0010Ü\u0001\u001a\u00020\b2\u0007\u0010Ý\u0001\u001a\u00020\bH\u0002J\t\u0010Þ\u0001\u001a\u00020hH\u0016J\u0011\u0010ß\u0001\u001a\u00020\b2\u0006\u0010o\u001a\u00020\bH\u0002J\u000f\u0010à\u0001\u001a\u00020h2\u0006\u0010s\u001a\u00020\bJ\u000f\u0010á\u0001\u001a\u00020h2\u0006\u0010s\u001a\u00020\bR\u0012\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R$\u0010 \u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u001f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010%\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u001f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\u000e\u0010(\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000R$\u00105\u001a\u00020)2\u0006\u0010\u0017\u001a\u00020)@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u000e\u0010:\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020HX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020HX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020HX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020HX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020MX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020OX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020OX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010o\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bp\u0010\u001aR0\u0010 \u0001\u001a\u0005\u0018\u00010¡\u00012\n\u0010 \u0001\u001a\u0005\u0018\u00010¡\u00018F@FX\u000e¢\u0006\u0010\u001a\u0006\b¢\u0001\u0010£\u0001\"\u0006\b¤\u0001\u0010¥\u0001¨\u0006ã\u0001"}, d2 = {"Lcom/blueair/devicedetails/view/CustomWheelView;", "Landroid/view/View;", "Ljava/lang/Runnable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "data", "", "formatter", "Lcom/github/gzuliyujiang/wheelview/contract/WheelFormatter;", "getFormatter", "()Lcom/github/gzuliyujiang/wheelview/contract/WheelFormatter;", "setFormatter", "(Lcom/github/gzuliyujiang/wheelview/contract/WheelFormatter;)V", "defaultItem", "", "visibleItemCount", "defaultItemPosition", "value", "currentPosition", "getCurrentPosition", "()I", "maxWidthText", "", "textColor", "selectedTextColor", "", "textSize", "getTextSize", "()F", "setTextSize", "(F)V", "selectedTextSize", "getSelectedTextSize", "setSelectedTextSize", "selectedTextBold", "", "indicatorSize", "indicatorColor", "curtainColor", "curtainCorner", "curtainRadius", "itemSpace", "textAlign", "sameWidthEnabled", "indicatorEnabled", "curtainEnabled", "atmosphericEnabled", "cyclicEnabled", "getCyclicEnabled", "()Z", "setCyclicEnabled", "(Z)V", "curvedEnabled", "curvedMaxAngle", "curvedIndicatorSpace", "handler", "Landroid/os/Handler;", "paint", "Landroid/graphics/Paint;", "scroller", "Landroid/widget/Scroller;", "tracker", "Landroid/view/VelocityTracker;", "onWheelChangedListener", "Lcom/blueair/devicedetails/view/CustomOnWheelChangedListener;", "rectDrawn", "Landroid/graphics/Rect;", "rectIndicatorHead", "rectIndicatorFoot", "rectCurrentItem", "camera", "Landroid/graphics/Camera;", "matrixRotate", "Landroid/graphics/Matrix;", "matrixDepth", "lastScrollPosition", "drawnItemCount", "halfDrawnItemCount", "textMaxWidth", "textMaxHeight", "itemHeight", "halfItemHeight", "halfWheelHeight", "minFlingYCoordinate", "maxFlingYCoordinate", "wheelCenterXCoordinate", "wheelCenterYCoordinate", "drawnCenterXCoordinate", "drawnCenterYCoordinate", "scrollOffsetYCoordinate", "lastPointYCoordinate", "downPointYCoordinate", "minimumVelocity", "maximumVelocity", "touchSlop", "isClick", "isForceFinishScroll", "initTextPaint", "", "setStyle", "style", "initAttrs", "defStyleRes", "updateVisibleItemCount", "computeTextWidthAndHeight", "itemCount", "getItemCount", "getItem", "T", "position", "(I)Ljava/lang/Object;", "getPosition", "item", "getCurrentItem", "()Ljava/lang/Object;", "setVisibleItemCountReal", "count", "setOnWheelChangedListener", "listener", "setNewData", "newData", "setData", "defaultValue", "defaultPosition", "setDefaultValueReal", "setDefaultPositionReal", "findPosition", "setSameWidthEnabledReal", "setMaxWidthTextReal", "text", "setTextColorReal", "color", "setSelectedTextColorReal", "setSelectedTextBoldReal", "bold", "setItemSpaceReal", "space", "setIndicatorEnabledReal", "setIndicatorSizeReal", "size", "setIndicatorColorReal", "setCurvedIndicatorSpaceReal", "setCurtainEnabledReal", "setCurtainColorReal", "setCurtainCornerReal", "setCurtainRadiusReal", "isAtmosphericEnabled", "setAtmosphericEnabledReal", "setCurvedEnabledReal", "isCurved", "setCurvedMaxAngleReal", "setTextAlignReal", "align", "updatePaintTextAlign", "typeface", "Landroid/graphics/Typeface;", "getTypeface", "()Landroid/graphics/Typeface;", "setTypeface", "(Landroid/graphics/Typeface;)V", "notifyDataSetChanged", "pos", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "measureSize", "mode", "sizeExpect", "sizeActual", "onSizeChanged", "w", "h", "ow", "oh", "computeDrawnCenterCoordinate", "computeFlingLimitYCoordinate", "computeIndicatorRect", "computeCurrentItemRect", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawAllItem", "drawItemRect", "dataPosition", "isCenterItem", "drawCenterYCoordinate", "drawItemText", "computeDegree", "drawnItemCenterYCoordinate", "ratio", "clamp", "min", "max", "obtainItemText", "drawnDataPosition", "formatItem", "computeAndSetAtmospheric", "abs", "drawCurtain", "drawIndicator", "isPositionInRange", "computeYCoordinateAtAngle", "degree", "sinDegree", "computeDepth", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "handleActionDown", "handleActionMove", "handleActionUp", "handleActionCancel", "obtainOrClearTracker", "cancelTracker", "computeDistanceToEndPoint", "remainder", "run", "computePosition", "scrollTo", "smoothScrollTo", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: CustomWheelView.kt */
public final class CustomWheelView extends View implements Runnable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int SCROLL_STATE_DRAGGING = 1;
    /* access modifiers changed from: private */
    public static final int SCROLL_STATE_IDLE = 0;
    /* access modifiers changed from: private */
    public static final int SCROLL_STATE_SCROLLING = 2;
    private boolean atmosphericEnabled;
    private final Camera camera;
    private int currentPosition;
    private int curtainColor;
    private int curtainCorner;
    private boolean curtainEnabled;
    private float curtainRadius;
    private boolean curvedEnabled;
    private int curvedIndicatorSpace;
    private int curvedMaxAngle;
    private boolean cyclicEnabled;
    private List<?> data;
    private Object defaultItem;
    private int defaultItemPosition;
    private int downPointYCoordinate;
    private int drawnCenterXCoordinate;
    private int drawnCenterYCoordinate;
    private int drawnItemCount;
    private WheelFormatter formatter;
    private int halfDrawnItemCount;
    private int halfItemHeight;
    private int halfWheelHeight;
    private final Handler handler;
    private int indicatorColor;
    private boolean indicatorEnabled;
    private float indicatorSize;
    private boolean isClick;
    private boolean isForceFinishScroll;
    private int itemHeight;
    private int itemSpace;
    private int lastPointYCoordinate;
    private int lastScrollPosition;
    private final Matrix matrixDepth;
    private final Matrix matrixRotate;
    private int maxFlingYCoordinate;
    private String maxWidthText;
    private final int maximumVelocity;
    private int minFlingYCoordinate;
    private final int minimumVelocity;
    private CustomOnWheelChangedListener onWheelChangedListener;
    private final Paint paint;
    private final Rect rectCurrentItem;
    private final Rect rectDrawn;
    private final Rect rectIndicatorFoot;
    private final Rect rectIndicatorHead;
    private boolean sameWidthEnabled;
    private int scrollOffsetYCoordinate;
    private final Scroller scroller;
    private boolean selectedTextBold;
    private int selectedTextColor;
    private float selectedTextSize;
    private int textAlign;
    private int textColor;
    private int textMaxHeight;
    private int textMaxWidth;
    private float textSize;
    private final int touchSlop;
    private VelocityTracker tracker;
    private int visibleItemCount;
    private int wheelCenterXCoordinate;
    private int wheelCenterYCoordinate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CustomWheelView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CustomWheelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final boolean isPositionInRange(int i, int i2) {
        return i >= 0 && i < i2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CustomWheelView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R.attr.WheelStyle : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomWheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.data = new ArrayList();
        this.curvedMaxAngle = 90;
        this.handler = new Handler();
        this.paint = new Paint(69);
        this.rectDrawn = new Rect();
        this.rectIndicatorHead = new Rect();
        this.rectIndicatorFoot = new Rect();
        this.rectCurrentItem = new Rect();
        this.camera = new Camera();
        this.matrixRotate = new Matrix();
        this.matrixDepth = new Matrix();
        initAttrs(context, attributeSet, i, R.style.WheelDefault);
        initTextPaint();
        updateVisibleItemCount();
        this.scroller = new Scroller(context);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.minimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.maximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.touchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public final WheelFormatter getFormatter() {
        return this.formatter;
    }

    public final void setFormatter(WheelFormatter wheelFormatter) {
        this.formatter = wheelFormatter;
    }

    public final int getCurrentPosition() {
        return this.currentPosition;
    }

    public final float getTextSize() {
        return this.textSize;
    }

    public final void setTextSize(float f) {
        if (f != this.textSize) {
            this.textSize = f;
            computeTextWidthAndHeight();
            requestLayout();
            invalidate();
        }
    }

    public final float getSelectedTextSize() {
        return this.selectedTextSize;
    }

    public final void setSelectedTextSize(float f) {
        if (this.selectedTextSize != f) {
            this.selectedTextSize = f;
            computeTextWidthAndHeight();
            requestLayout();
            invalidate();
        }
    }

    public final boolean getCyclicEnabled() {
        return this.cyclicEnabled;
    }

    public final void setCyclicEnabled(boolean z) {
        this.cyclicEnabled = z;
        computeFlingLimitYCoordinate();
        invalidate();
    }

    private final void initTextPaint() {
        this.paint.setColor(this.textColor);
        this.paint.setTextSize(this.textSize);
        this.paint.setFakeBoldText(false);
        this.paint.setStyle(Paint.Style.FILL);
    }

    public final void setStyle(int i) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        initAttrs(context, (AttributeSet) null, R.attr.WheelStyle, i);
        initTextPaint();
        updatePaintTextAlign();
        computeTextWidthAndHeight();
        computeFlingLimitYCoordinate();
        computeIndicatorRect();
        computeCurrentItemRect();
        requestLayout();
        invalidate();
    }

    private final void initAttrs(Context context, AttributeSet attributeSet, int i, int i2) {
        float f = context.getResources().getDisplayMetrics().density;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.WheelView, i, i2);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.visibleItemCount = obtainStyledAttributes.getInt(R.styleable.WheelView_wheel_visibleItemCount, 5);
        this.sameWidthEnabled = obtainStyledAttributes.getBoolean(R.styleable.WheelView_wheel_sameWidthEnabled, false);
        this.maxWidthText = obtainStyledAttributes.getString(R.styleable.WheelView_wheel_maxWidthText);
        this.textColor = obtainStyledAttributes.getColor(R.styleable.WheelView_wheel_itemTextColor, -7829368);
        this.selectedTextColor = obtainStyledAttributes.getColor(R.styleable.WheelView_wheel_itemTextColorSelected, ViewCompat.MEASURED_STATE_MASK);
        setTextSize(obtainStyledAttributes.getDimension(R.styleable.WheelView_wheel_itemTextSize, TypedValueCompat.spToPx(15.0f, getResources().getDisplayMetrics())));
        setSelectedTextSize(obtainStyledAttributes.getDimension(R.styleable.WheelView_wheel_itemTextSizeSelected, this.textSize));
        this.selectedTextBold = obtainStyledAttributes.getBoolean(R.styleable.WheelView_wheel_itemTextBoldSelected, false);
        this.textAlign = obtainStyledAttributes.getInt(R.styleable.WheelView_wheel_itemTextAlign, 0);
        this.itemSpace = obtainStyledAttributes.getDimensionPixelSize(R.styleable.WheelView_wheel_itemSpace, (int) (((float) 20) * f));
        setCyclicEnabled(obtainStyledAttributes.getBoolean(R.styleable.WheelView_wheel_cyclicEnabled, false));
        this.indicatorEnabled = obtainStyledAttributes.getBoolean(R.styleable.WheelView_wheel_indicatorEnabled, true);
        this.indicatorColor = obtainStyledAttributes.getColor(R.styleable.WheelView_wheel_indicatorColor, -3552823);
        float f2 = ((float) 1) * f;
        this.indicatorSize = obtainStyledAttributes.getDimension(R.styleable.WheelView_wheel_indicatorSize, f2);
        this.curvedIndicatorSpace = obtainStyledAttributes.getDimensionPixelSize(R.styleable.WheelView_wheel_curvedIndicatorSpace, (int) f2);
        this.curtainEnabled = obtainStyledAttributes.getBoolean(R.styleable.WheelView_wheel_curtainEnabled, false);
        this.curtainColor = obtainStyledAttributes.getColor(R.styleable.WheelView_wheel_curtainColor, -1);
        this.curtainCorner = obtainStyledAttributes.getInt(R.styleable.WheelView_wheel_curtainCorner, 0);
        this.curtainRadius = obtainStyledAttributes.getDimension(R.styleable.WheelView_wheel_curtainRadius, 0.0f);
        this.atmosphericEnabled = obtainStyledAttributes.getBoolean(R.styleable.WheelView_wheel_atmosphericEnabled, false);
        this.curvedEnabled = obtainStyledAttributes.getBoolean(R.styleable.WheelView_wheel_curvedEnabled, false);
        this.curvedMaxAngle = obtainStyledAttributes.getInteger(R.styleable.WheelView_wheel_curvedMaxAngle, 90);
        obtainStyledAttributes.recycle();
    }

    private final void updateVisibleItemCount() {
        int i = this.visibleItemCount;
        if (i >= 2) {
            if (i % 2 == 0) {
                this.visibleItemCount = i + 1;
            }
            int i2 = this.visibleItemCount + 2;
            this.drawnItemCount = i2;
            this.halfDrawnItemCount = i2 / 2;
            return;
        }
        throw new ArithmeticException("Visible item count can not be less than 2");
    }

    private final void computeTextWidthAndHeight() {
        this.textMaxHeight = 0;
        this.textMaxWidth = 0;
        if (this.sameWidthEnabled) {
            this.textMaxWidth = (int) this.paint.measureText(formatItem(0));
        } else if (!TextUtils.isEmpty(this.maxWidthText)) {
            this.textMaxWidth = (int) this.paint.measureText(this.maxWidthText);
        } else {
            int itemCount = getItemCount();
            for (int i = 0; i < itemCount; i++) {
                this.textMaxWidth = Math.max(this.textMaxWidth, (int) this.paint.measureText(formatItem(i)));
            }
        }
        Paint.FontMetrics fontMetrics = this.paint.getFontMetrics();
        this.textMaxHeight = (int) (fontMetrics.bottom - fontMetrics.top);
    }

    public final int getItemCount() {
        return this.data.size();
    }

    private final <T> T getItem(int i) {
        int i2;
        int size = this.data.size();
        if (size != 0 && (i2 = (i + size) % size) >= 0 && i2 <= size - 1) {
            return this.data.get(i2);
        }
        return null;
    }

    public final int getPosition(Object obj) {
        if (obj == null) {
            return 0;
        }
        return this.data.indexOf(obj);
    }

    public final <T> T getCurrentItem() {
        return getItem(this.currentPosition);
    }

    public final void setVisibleItemCountReal(int i) {
        this.visibleItemCount = i;
        updateVisibleItemCount();
        requestLayout();
    }

    public final void setOnWheelChangedListener(CustomOnWheelChangedListener customOnWheelChangedListener) {
        this.onWheelChangedListener = customOnWheelChangedListener;
    }

    public final void setNewData(List<?> list) {
        setData(list, 0);
    }

    public final void setData(List<?> list, Object obj) {
        setData(list, findPosition(obj));
    }

    private final void setData(List<?> list, int i) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.data = list;
        notifyDataSetChanged(i);
    }

    public final void setDefaultValueReal(Object obj) {
        setDefaultPositionReal(findPosition(obj));
    }

    public final void setDefaultPositionReal(int i) {
        notifyDataSetChanged(i);
    }

    private final int findPosition(Object obj) {
        if (obj == null) {
            return 0;
        }
        int i = 0;
        for (Object next : this.data) {
            if (next != null) {
                if (Intrinsics.areEqual((Object) next, obj)) {
                    return i;
                }
                WheelFormatter wheelFormatter = this.formatter;
                if (wheelFormatter != null) {
                    String str = null;
                    String formatItem = wheelFormatter != null ? wheelFormatter.formatItem(next) : null;
                    WheelFormatter wheelFormatter2 = this.formatter;
                    if (wheelFormatter2 != null) {
                        str = wheelFormatter2.formatItem(obj);
                    }
                    if (Intrinsics.areEqual((Object) formatItem, (Object) str)) {
                        return i;
                    }
                }
                if (next instanceof TextProvider) {
                    String provideText = ((TextProvider) next).provideText();
                    Intrinsics.checkNotNullExpressionValue(provideText, "provideText(...)");
                    if (Intrinsics.areEqual((Object) provideText, (Object) obj.toString())) {
                        return i;
                    }
                }
                if (Intrinsics.areEqual((Object) next.toString(), (Object) obj.toString())) {
                    return i;
                }
                i++;
            }
        }
        return 0;
    }

    public final void setSameWidthEnabledReal(boolean z) {
        this.sameWidthEnabled = z;
        computeTextWidthAndHeight();
        requestLayout();
        invalidate();
    }

    public final void setMaxWidthTextReal(String str) {
        if (str != null) {
            this.maxWidthText = str;
            computeTextWidthAndHeight();
            requestLayout();
            invalidate();
            return;
        }
        throw new NullPointerException("Maximum width text can not be null!");
    }

    public final void setTextColorReal(int i) {
        this.textColor = i;
        invalidate();
    }

    public final void setSelectedTextColorReal(int i) {
        this.selectedTextColor = i;
        computeCurrentItemRect();
        invalidate();
    }

    public final void setSelectedTextBoldReal(boolean z) {
        this.selectedTextBold = z;
        computeTextWidthAndHeight();
        requestLayout();
        invalidate();
    }

    public final void setItemSpaceReal(int i) {
        this.itemSpace = i;
        requestLayout();
        invalidate();
    }

    public final void setIndicatorEnabledReal(boolean z) {
        this.indicatorEnabled = z;
        computeIndicatorRect();
        invalidate();
    }

    public final void setIndicatorSizeReal(float f) {
        this.indicatorSize = f;
        computeIndicatorRect();
        invalidate();
    }

    public final void setIndicatorColorReal(int i) {
        this.indicatorColor = i;
        invalidate();
    }

    public final void setCurvedIndicatorSpaceReal(int i) {
        this.curvedIndicatorSpace = i;
        computeIndicatorRect();
        invalidate();
    }

    public final void setCurtainEnabledReal(boolean z) {
        this.curtainEnabled = z;
        if (z) {
            this.indicatorEnabled = false;
        }
        computeCurrentItemRect();
        invalidate();
    }

    public final void setCurtainColorReal(int i) {
        this.curtainColor = i;
        invalidate();
    }

    public final void setCurtainCornerReal(int i) {
        this.curtainCorner = i;
        invalidate();
    }

    public final void setCurtainRadiusReal(float f) {
        this.curtainRadius = f;
        invalidate();
    }

    public final boolean isAtmosphericEnabled() {
        return this.atmosphericEnabled;
    }

    public final void setAtmosphericEnabledReal(boolean z) {
        this.atmosphericEnabled = z;
        invalidate();
    }

    public final void setCurvedEnabledReal(boolean z) {
        this.curvedEnabled = z;
        requestLayout();
        invalidate();
    }

    public final void setCurvedMaxAngleReal(int i) {
        this.curvedMaxAngle = i;
        requestLayout();
        invalidate();
    }

    public final void setTextAlignReal(int i) {
        this.textAlign = i;
        updatePaintTextAlign();
        computeDrawnCenterCoordinate();
        invalidate();
    }

    private final void updatePaintTextAlign() {
        int i = this.textAlign;
        if (i == 0) {
            this.paint.setTextAlign(Paint.Align.CENTER);
        } else if (i == 1) {
            this.paint.setTextAlign(Paint.Align.LEFT);
        } else if (i != 2) {
            this.paint.setTextAlign(Paint.Align.CENTER);
        } else {
            this.paint.setTextAlign(Paint.Align.RIGHT);
        }
    }

    public final Typeface getTypeface() {
        return this.paint.getTypeface();
    }

    public final void setTypeface(Typeface typeface) {
        if (typeface != null) {
            this.paint.setTypeface(typeface);
            computeTextWidthAndHeight();
            requestLayout();
            invalidate();
        }
    }

    private final void notifyDataSetChanged(int i) {
        int max = Math.max(Math.min(i, getItemCount() - 1), 0);
        this.scrollOffsetYCoordinate = 0;
        this.defaultItem = getItem(max);
        this.defaultItemPosition = max;
        this.currentPosition = max;
        updatePaintTextAlign();
        computeFlingLimitYCoordinate();
        computeIndicatorRect();
        computeCurrentItemRect();
        requestLayout();
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i3 = this.textMaxWidth;
        int i4 = this.textMaxHeight;
        int i5 = this.visibleItemCount;
        int i6 = (i4 * i5) + (this.itemSpace * (i5 - 1));
        if (this.curvedEnabled) {
            i6 = (int) (((double) (i6 * 2)) / 3.141592653589793d);
        }
        setMeasuredDimension(measureSize(mode, size, i3 + getPaddingLeft() + getPaddingRight()), measureSize(mode2, size2, i6 + getPaddingTop() + getPaddingBottom()));
    }

    private final int measureSize(int i, int i2, int i3) {
        if (i == 1073741824) {
            return i2;
        }
        return i == Integer.MIN_VALUE ? Math.min(i3, i2) : i3;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.rectDrawn.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        this.wheelCenterXCoordinate = this.rectDrawn.centerX();
        this.wheelCenterYCoordinate = this.rectDrawn.centerY();
        computeDrawnCenterCoordinate();
        this.halfWheelHeight = this.rectDrawn.height() / 2;
        int height = this.rectDrawn.height() / this.visibleItemCount;
        this.itemHeight = height;
        this.halfItemHeight = height / 2;
        computeFlingLimitYCoordinate();
        computeIndicatorRect();
        computeCurrentItemRect();
    }

    private final void computeDrawnCenterCoordinate() {
        int i;
        int i2 = this.textAlign;
        if (i2 == 0) {
            i = this.wheelCenterXCoordinate;
        } else if (i2 == 1) {
            i = this.rectDrawn.left;
        } else if (i2 != 2) {
            i = this.wheelCenterXCoordinate;
        } else {
            i = this.rectDrawn.right;
        }
        this.drawnCenterXCoordinate = i;
        this.drawnCenterYCoordinate = (int) (((float) this.wheelCenterYCoordinate) - ((this.paint.ascent() + this.paint.descent()) / ((float) 2)));
    }

    private final void computeFlingLimitYCoordinate() {
        int i = this.defaultItemPosition;
        int i2 = this.itemHeight;
        int i3 = i * i2;
        this.minFlingYCoordinate = this.cyclicEnabled ? Integer.MIN_VALUE : ((-i2) * (getItemCount() - 1)) + i3;
        if (this.cyclicEnabled) {
            i3 = Integer.MAX_VALUE;
        }
        this.maxFlingYCoordinate = i3;
    }

    private final void computeIndicatorRect() {
        if (this.indicatorEnabled) {
            int i = this.curvedEnabled ? this.curvedIndicatorSpace : 0;
            int i2 = (int) (this.indicatorSize / 2.0f);
            int i3 = this.wheelCenterYCoordinate;
            int i4 = this.halfItemHeight;
            int i5 = i3 + i4 + i;
            int i6 = (i3 - i4) - i;
            this.rectIndicatorHead.set(this.rectDrawn.left, i5 - i2, this.rectDrawn.right, i5 + i2);
            this.rectIndicatorFoot.set(this.rectDrawn.left, i6 - i2, this.rectDrawn.right, i6 + i2);
        }
    }

    private final void computeCurrentItemRect() {
        if (this.curtainEnabled || this.selectedTextColor != 0) {
            this.rectCurrentItem.set(this.rectDrawn.left, this.wheelCenterYCoordinate - this.halfItemHeight, this.rectDrawn.right, this.wheelCenterYCoordinate + this.halfItemHeight);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.itemHeight - this.halfDrawnItemCount > 0) {
            drawCurtain(canvas);
            drawIndicator(canvas);
            drawAllItem(canvas);
        }
    }

    private final void drawAllItem(Canvas canvas) {
        int i = (this.scrollOffsetYCoordinate * -1) / this.itemHeight;
        int i2 = this.halfDrawnItemCount;
        int i3 = i - i2;
        int i4 = this.defaultItemPosition + i3;
        int i5 = i2 * -1;
        while (i4 < this.defaultItemPosition + i3 + this.drawnItemCount) {
            initTextPaint();
            boolean z = i4 == (this.defaultItemPosition + i3) + (this.drawnItemCount / 2);
            int i6 = this.drawnCenterYCoordinate;
            int i7 = this.itemHeight;
            int i8 = (i5 * i7) + i6 + (this.scrollOffsetYCoordinate % i7);
            int abs = Math.abs(i6 - i8);
            float computeDegree = computeDegree(i8, (((float) ((this.drawnCenterYCoordinate - abs) - this.rectDrawn.top)) * 1.0f) / ((float) (this.drawnCenterYCoordinate - this.rectDrawn.top)));
            float computeYCoordinateAtAngle = computeYCoordinateAtAngle(computeDegree);
            if (this.curvedEnabled) {
                int i9 = this.wheelCenterXCoordinate;
                int i10 = this.textAlign;
                if (i10 == 1) {
                    i9 = this.rectDrawn.left;
                } else if (i10 == 2) {
                    i9 = this.rectDrawn.right;
                }
                float f = ((float) this.wheelCenterYCoordinate) - computeYCoordinateAtAngle;
                this.camera.save();
                this.camera.rotateX(computeDegree);
                this.camera.getMatrix(this.matrixRotate);
                this.camera.restore();
                float f2 = (float) i9;
                float f3 = -f2;
                float f4 = -f;
                this.matrixRotate.preTranslate(f3, f4);
                this.matrixRotate.postTranslate(f2, f);
                this.camera.save();
                this.camera.translate(0.0f, 0.0f, (float) computeDepth(computeDegree));
                this.camera.getMatrix(this.matrixDepth);
                this.camera.restore();
                this.matrixDepth.preTranslate(f3, f4);
                this.matrixDepth.postTranslate(f2, f);
                this.matrixRotate.postConcat(this.matrixDepth);
            }
            computeAndSetAtmospheric(abs);
            drawItemRect(canvas, i4, z, this.curvedEnabled ? ((float) this.drawnCenterYCoordinate) - computeYCoordinateAtAngle : (float) i8);
            i4++;
            i5++;
        }
    }

    private final void drawItemRect(Canvas canvas, int i, boolean z, float f) {
        int i2 = this.selectedTextColor;
        if (i2 == 0) {
            canvas.save();
            canvas.clipRect(this.rectDrawn);
            if (this.curvedEnabled) {
                canvas.concat(this.matrixRotate);
            }
            drawItemText(canvas, i, f);
            canvas.restore();
        } else if (this.textSize == this.selectedTextSize && !this.selectedTextBold) {
            canvas.save();
            if (this.curvedEnabled) {
                canvas.concat(this.matrixRotate);
            }
            if (Build.VERSION.SDK_INT >= 26) {
                boolean unused = canvas.clipOutRect(this.rectCurrentItem);
            } else {
                canvas.clipRect(this.rectCurrentItem, Region.Op.DIFFERENCE);
            }
            drawItemText(canvas, i, f);
            canvas.restore();
            this.paint.setColor(this.selectedTextColor);
            canvas.save();
            if (this.curvedEnabled) {
                canvas.concat(this.matrixRotate);
            }
            canvas.clipRect(this.rectCurrentItem);
            drawItemText(canvas, i, f);
            canvas.restore();
        } else if (!z) {
            canvas.save();
            if (this.curvedEnabled) {
                canvas.concat(this.matrixRotate);
            }
            drawItemText(canvas, i, f);
            canvas.restore();
        } else {
            this.paint.setColor(i2);
            this.paint.setTextSize(this.selectedTextSize);
            this.paint.setFakeBoldText(this.selectedTextBold);
            canvas.save();
            if (this.curvedEnabled) {
                canvas.concat(this.matrixRotate);
            }
            drawItemText(canvas, i, f);
            canvas.restore();
        }
    }

    private final void drawItemText(Canvas canvas, int i, float f) {
        canvas.drawText(obtainItemText(i), (float) this.drawnCenterXCoordinate, f, this.paint);
    }

    private final float computeDegree(int i, float f) {
        int i2 = this.drawnCenterYCoordinate;
        int i3 = i > i2 ? 1 : i < i2 ? -1 : 0;
        float f2 = -(((float) 1) - f);
        int i4 = this.curvedMaxAngle;
        return clamp(f2 * ((float) i4) * ((float) i3), -((float) i4), (float) i4);
    }

    private final float clamp(float f, float f2, float f3) {
        return f < f2 ? f2 : Math.min(f, f3);
    }

    private final String obtainItemText(int i) {
        int itemCount = getItemCount();
        if (this.cyclicEnabled) {
            if (itemCount == 0) {
                return "";
            }
            int i2 = i % itemCount;
            if (i2 < 0) {
                i2 += itemCount;
            }
            return formatItem(i2);
        } else if (isPositionInRange(i, itemCount)) {
            return formatItem(i);
        } else {
            return "";
        }
    }

    private final String formatItem(int i) {
        return formatItem(getItem(i));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        r0 = r0.formatItem(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String formatItem(java.lang.Object r2) {
        /*
            r1 = this;
            if (r2 != 0) goto L_0x0005
            java.lang.String r2 = ""
            return r2
        L_0x0005:
            boolean r0 = r2 instanceof com.github.gzuliyujiang.wheelview.contract.TextProvider
            if (r0 == 0) goto L_0x0015
            com.github.gzuliyujiang.wheelview.contract.TextProvider r2 = (com.github.gzuliyujiang.wheelview.contract.TextProvider) r2
            java.lang.String r2 = r2.provideText()
            java.lang.String r0 = "provideText(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            return r2
        L_0x0015:
            com.github.gzuliyujiang.wheelview.contract.WheelFormatter r0 = r1.formatter
            if (r0 == 0) goto L_0x0021
            java.lang.String r0 = r0.formatItem(r2)
            if (r0 != 0) goto L_0x0020
            goto L_0x0021
        L_0x0020:
            return r0
        L_0x0021:
            java.lang.String r2 = r2.toString()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.view.CustomWheelView.formatItem(java.lang.Object):java.lang.String");
    }

    private final void computeAndSetAtmospheric(int i) {
        if (this.atmosphericEnabled) {
            int i2 = this.drawnCenterYCoordinate;
            this.paint.setAlpha(Math.max((int) (((((float) (i2 - i)) * 1.0f) / ((float) i2)) * ((float) 255)), 0));
        }
    }

    private final void drawCurtain(Canvas canvas) {
        float[] fArr;
        if (this.curtainEnabled) {
            this.paint.setColor(this.curtainColor);
            this.paint.setStyle(Paint.Style.FILL);
            if (this.curtainRadius > 0.0f) {
                Path path = new Path();
                int i = this.curtainCorner;
                if (i == 1) {
                    float f = this.curtainRadius;
                    fArr = new float[]{f, f, f, f, f, f, f, f};
                } else if (i == 2) {
                    float f2 = this.curtainRadius;
                    fArr = new float[]{f2, f2, f2, f2, 0.0f, 0.0f, 0.0f, 0.0f};
                } else if (i == 3) {
                    float f3 = this.curtainRadius;
                    fArr = new float[]{0.0f, 0.0f, 0.0f, 0.0f, f3, f3, f3, f3};
                } else if (i == 4) {
                    float f4 = this.curtainRadius;
                    fArr = new float[]{f4, f4, 0.0f, 0.0f, 0.0f, 0.0f, f4, f4};
                } else if (i != 5) {
                    fArr = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                } else {
                    float f5 = this.curtainRadius;
                    fArr = new float[]{0.0f, 0.0f, f5, f5, f5, f5, 0.0f, 0.0f};
                }
                path.addRoundRect(new RectF(this.rectCurrentItem), fArr, Path.Direction.CCW);
                canvas.drawPath(path, this.paint);
                return;
            }
            canvas.drawRect(this.rectCurrentItem, this.paint);
        }
    }

    private final void drawIndicator(Canvas canvas) {
        if (this.indicatorEnabled) {
            this.paint.setColor(this.indicatorColor);
            this.paint.setStyle(Paint.Style.FILL);
            canvas.drawRect(this.rectIndicatorHead, this.paint);
            canvas.drawRect(this.rectIndicatorFoot, this.paint);
        }
    }

    private final float computeYCoordinateAtAngle(float f) {
        return (sinDegree(f) / sinDegree((float) this.curvedMaxAngle)) * ((float) this.halfWheelHeight);
    }

    private final float sinDegree(float f) {
        return (float) Math.sin(Math.toRadians((double) f));
    }

    private final int computeDepth(float f) {
        return (int) (((double) this.halfWheelHeight) - (Math.cos(Math.toRadians((double) f)) * ((double) this.halfWheelHeight)));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        if (isEnabled()) {
            int action = motionEvent.getAction();
            if (action == 0) {
                handleActionDown(motionEvent);
            } else if (action == 1) {
                handleActionUp(motionEvent);
            } else if (action == 2) {
                handleActionMove(motionEvent);
            } else if (action == 3) {
                handleActionCancel();
            }
        }
        if (this.isClick) {
            performClick();
        }
        return true;
    }

    private final void handleActionDown(MotionEvent motionEvent) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        obtainOrClearTracker();
        VelocityTracker velocityTracker = this.tracker;
        Intrinsics.checkNotNull(velocityTracker);
        velocityTracker.addMovement(motionEvent);
        if (!this.scroller.isFinished()) {
            this.scroller.abortAnimation();
            this.isForceFinishScroll = true;
        }
        int y = (int) motionEvent.getY();
        this.lastPointYCoordinate = y;
        this.downPointYCoordinate = y;
    }

    private final void handleActionMove(MotionEvent motionEvent) {
        int computeDistanceToEndPoint = computeDistanceToEndPoint(this.scroller.getFinalY() % this.itemHeight);
        if (Math.abs(((float) this.downPointYCoordinate) - motionEvent.getY()) >= ((float) this.touchSlop) || computeDistanceToEndPoint <= 0) {
            this.isClick = false;
            VelocityTracker velocityTracker = this.tracker;
            if (velocityTracker != null) {
                Intrinsics.checkNotNull(velocityTracker);
                velocityTracker.addMovement(motionEvent);
            }
            float y = motionEvent.getY() - ((float) this.lastPointYCoordinate);
            if (Math.abs(y) >= 1.0f) {
                this.scrollOffsetYCoordinate = (int) (((float) this.scrollOffsetYCoordinate) + y);
                this.lastPointYCoordinate = (int) motionEvent.getY();
                invalidate();
                return;
            }
            return;
        }
        this.isClick = true;
    }

    private final void handleActionUp(MotionEvent motionEvent) {
        int i;
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        if (!this.isClick) {
            VelocityTracker velocityTracker = this.tracker;
            if (velocityTracker != null) {
                Intrinsics.checkNotNull(velocityTracker);
                velocityTracker.addMovement(motionEvent);
                VelocityTracker velocityTracker2 = this.tracker;
                Intrinsics.checkNotNull(velocityTracker2);
                velocityTracker2.computeCurrentVelocity(1000, (float) this.maximumVelocity);
                VelocityTracker velocityTracker3 = this.tracker;
                Intrinsics.checkNotNull(velocityTracker3);
                i = (int) velocityTracker3.getYVelocity();
            } else {
                i = 0;
            }
            this.isForceFinishScroll = false;
            if (Math.abs(i) > this.minimumVelocity) {
                this.scroller.fling(0, this.scrollOffsetYCoordinate, 0, i, 0, 0, this.minFlingYCoordinate, this.maxFlingYCoordinate);
                Scroller scroller2 = this.scroller;
                scroller2.setFinalY(scroller2.getFinalY() + computeDistanceToEndPoint(this.scroller.getFinalY() % this.itemHeight));
            } else {
                this.scroller.startScroll(0, this.scrollOffsetYCoordinate, 0, computeDistanceToEndPoint(this.scrollOffsetYCoordinate % this.itemHeight));
            }
            if (!this.cyclicEnabled) {
                int finalY = this.scroller.getFinalY();
                int i2 = this.maxFlingYCoordinate;
                if (finalY > i2) {
                    this.scroller.setFinalY(i2);
                } else {
                    int finalY2 = this.scroller.getFinalY();
                    int i3 = this.minFlingYCoordinate;
                    if (finalY2 < i3) {
                        this.scroller.setFinalY(i3);
                    }
                }
            }
            this.handler.post(this);
            cancelTracker();
        }
    }

    private final void handleActionCancel() {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        cancelTracker();
    }

    private final void obtainOrClearTracker() {
        VelocityTracker velocityTracker = this.tracker;
        if (velocityTracker == null) {
            this.tracker = VelocityTracker.obtain();
            return;
        }
        Intrinsics.checkNotNull(velocityTracker);
        velocityTracker.clear();
    }

    private final void cancelTracker() {
        VelocityTracker velocityTracker = this.tracker;
        if (velocityTracker != null) {
            Intrinsics.checkNotNull(velocityTracker);
            velocityTracker.recycle();
            this.tracker = null;
        }
    }

    private final int computeDistanceToEndPoint(int i) {
        int i2;
        if (Math.abs(i) <= this.halfItemHeight) {
            return i * -1;
        }
        if (this.scrollOffsetYCoordinate < 0) {
            i2 = -this.itemHeight;
        } else {
            i2 = this.itemHeight;
        }
        return i2 - i;
    }

    public void run() {
        int itemCount;
        CustomOnWheelChangedListener customOnWheelChangedListener;
        if (this.itemHeight != 0 && (itemCount = getItemCount()) != 0) {
            if (this.scroller.isFinished() && !this.isForceFinishScroll) {
                int computePosition = computePosition(itemCount);
                if (computePosition < 0) {
                    computePosition += itemCount;
                }
                this.currentPosition = computePosition;
                CustomOnWheelChangedListener customOnWheelChangedListener2 = this.onWheelChangedListener;
                if (customOnWheelChangedListener2 != null) {
                    customOnWheelChangedListener2.onWheelSelected(this, computePosition);
                }
                postInvalidate();
            } else if (this.scroller.computeScrollOffset()) {
                this.scrollOffsetYCoordinate = this.scroller.getCurrY();
                int computePosition2 = computePosition(itemCount);
                int i = this.lastScrollPosition;
                if (i != computePosition2) {
                    if (computePosition2 == 0 && i == itemCount - 1 && (customOnWheelChangedListener = this.onWheelChangedListener) != null) {
                        customOnWheelChangedListener.onWheelLoopFinished(this);
                    }
                    this.lastScrollPosition = computePosition2;
                }
                postInvalidate();
                this.handler.postDelayed(this, 20);
            }
        }
    }

    private final int computePosition(int i) {
        return (((this.scrollOffsetYCoordinate * -1) / this.itemHeight) + this.defaultItemPosition) % i;
    }

    /* access modifiers changed from: private */
    public static final void scrollTo$lambda$0(CustomWheelView customWheelView, int i) {
        customWheelView.notifyDataSetChanged(i);
    }

    public final void scrollTo(int i) {
        post(new CustomWheelView$$ExternalSyntheticLambda2(this, i));
    }

    public final void smoothScrollTo(int i) {
        if (isInEditMode()) {
            scrollTo(i);
            return;
        }
        int i2 = this.scrollOffsetYCoordinate;
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i2, ((this.currentPosition - i) * this.itemHeight) + i2});
        ofInt.setDuration(300);
        ofInt.addUpdateListener(new CustomWheelView$$ExternalSyntheticLambda1(this));
        ofInt.addListener(new CustomWheelView$smoothScrollTo$2(this, i));
        ofInt.start();
    }

    /* access modifiers changed from: private */
    public static final void smoothScrollTo$lambda$1(CustomWheelView customWheelView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        customWheelView.scrollOffsetYCoordinate = ((Integer) animatedValue).intValue();
        customWheelView.invalidate();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u00020\u00058\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u00020\u00058\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/blueair/devicedetails/view/CustomWheelView$Companion;", "", "<init>", "()V", "SCROLL_STATE_IDLE", "", "getSCROLL_STATE_IDLE$annotations", "getSCROLL_STATE_IDLE", "()I", "SCROLL_STATE_DRAGGING", "getSCROLL_STATE_DRAGGING$annotations", "getSCROLL_STATE_DRAGGING", "SCROLL_STATE_SCROLLING", "getSCROLL_STATE_SCROLLING$annotations", "getSCROLL_STATE_SCROLLING", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: CustomWheelView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Deprecated(message = "")
        public static /* synthetic */ void getSCROLL_STATE_DRAGGING$annotations() {
        }

        @Deprecated(message = "")
        public static /* synthetic */ void getSCROLL_STATE_IDLE$annotations() {
        }

        @Deprecated(message = "")
        public static /* synthetic */ void getSCROLL_STATE_SCROLLING$annotations() {
        }

        private Companion() {
        }

        public final int getSCROLL_STATE_IDLE() {
            return CustomWheelView.SCROLL_STATE_IDLE;
        }

        public final int getSCROLL_STATE_DRAGGING() {
            return CustomWheelView.SCROLL_STATE_DRAGGING;
        }

        public final int getSCROLL_STATE_SCROLLING() {
            return CustomWheelView.SCROLL_STATE_SCROLLING;
        }
    }
}
