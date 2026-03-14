package com.blueair.devicedetails.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
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
import android.graphics.Typeface;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path.Direction;
import android.graphics.Region.Op;
import android.os.Handler;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.View.MeasureSpec;
import android.widget.Scroller;
import androidx.core.util.TypedValueCompat;
import com.blueair.android.BlueairApp$$ExternalSyntheticApiModelOutline0;
import com.github.gzuliyujiang.wheelview.R.attr;
import com.github.gzuliyujiang.wheelview.R.style;
import com.github.gzuliyujiang.wheelview.R.styleable;
import com.github.gzuliyujiang.wheelview.contract.TextProvider;
import com.github.gzuliyujiang.wheelview.contract.WheelFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b8\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 â\u00012\u00020\u00012\u00020\u0002:\u0002â\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010g\u001a\u00020hH\u0002J\u0010\u0010i\u001a\u00020h2\b\b\u0001\u0010j\u001a\u00020\bJ*\u0010k\u001a\u00020h2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010l\u001a\u00020\bH\u0003J\b\u0010m\u001a\u00020hH\u0002J\b\u0010n\u001a\u00020hH\u0002J\u001d\u0010q\u001a\u0004\u0018\u0001Hr\"\u0004\b\u0000\u0010r2\u0006\u0010s\u001a\u00020\bH\u0002¢\u0006\u0002\u0010tJ\u0010\u0010u\u001a\u00020\b2\b\u0010v\u001a\u0004\u0018\u00010\u0014J\u0013\u0010w\u001a\u0004\u0018\u0001Hr\"\u0004\b\u0000\u0010r¢\u0006\u0002\u0010xJ\u0010\u0010y\u001a\u00020h2\b\b\u0001\u0010z\u001a\u00020\bJ\u0010\u0010{\u001a\u00020h2\b\u0010|\u001a\u0004\u0018\u00010FJ\u0014\u0010}\u001a\u00020h2\f\u0010~\u001a\b\u0012\u0002\b\u0003\u0018\u00010\fJ\u001f\u0010\u007f\u001a\u00020h2\f\u0010~\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f2\t\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0014J\u001f\u0010\u007f\u001a\u00020h2\f\u0010~\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f2\u0007\u0010\u0081\u0001\u001a\u00020\bH\u0002J\u0011\u0010\u0082\u0001\u001a\u00020h2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014J\u000f\u0010\u0083\u0001\u001a\u00020h2\u0006\u0010s\u001a\u00020\bJ\u0013\u0010\u0084\u0001\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014H\u0002J\u000f\u0010\u0085\u0001\u001a\u00020h2\u0006\u00101\u001a\u00020)J\u0012\u0010\u0086\u0001\u001a\u00020h2\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u001cJ\u0012\u0010\u0088\u0001\u001a\u00020h2\t\b\u0001\u0010\u0089\u0001\u001a\u00020\bJ\u0012\u0010\u008a\u0001\u001a\u00020h2\t\b\u0001\u0010\u0089\u0001\u001a\u00020\bJ\u0010\u0010\u008b\u0001\u001a\u00020h2\u0007\u0010\u008c\u0001\u001a\u00020)J\u0012\u0010\u008d\u0001\u001a\u00020h2\t\b\u0001\u0010\u008e\u0001\u001a\u00020\bJ\u000f\u0010\u008f\u0001\u001a\u00020h2\u0006\u00102\u001a\u00020)J\u0012\u0010\u0090\u0001\u001a\u00020h2\t\b\u0001\u0010\u0091\u0001\u001a\u00020\u001fJ\u0012\u0010\u0092\u0001\u001a\u00020h2\t\b\u0001\u0010\u0089\u0001\u001a\u00020\bJ\u0012\u0010\u0093\u0001\u001a\u00020h2\t\b\u0001\u0010\u008e\u0001\u001a\u00020\bJ\u000f\u0010\u0094\u0001\u001a\u00020h2\u0006\u00103\u001a\u00020)J\u0012\u0010\u0095\u0001\u001a\u00020h2\t\b\u0001\u0010\u0089\u0001\u001a\u00020\bJ\u000f\u0010\u0096\u0001\u001a\u00020h2\u0006\u0010-\u001a\u00020\bJ\u0011\u0010\u0097\u0001\u001a\u00020h2\b\b\u0001\u0010.\u001a\u00020\u001fJ\u0007\u0010\u0098\u0001\u001a\u00020)J\u000f\u0010\u0099\u0001\u001a\u00020h2\u0006\u00104\u001a\u00020)J\u0010\u0010\u009a\u0001\u001a\u00020h2\u0007\u0010\u009b\u0001\u001a\u00020)J\u000f\u0010\u009c\u0001\u001a\u00020h2\u0006\u0010;\u001a\u00020\bJ\u0010\u0010\u009d\u0001\u001a\u00020h2\u0007\u0010\u009e\u0001\u001a\u00020\bJ\t\u0010\u009f\u0001\u001a\u00020hH\u0002J\u0012\u0010¦\u0001\u001a\u00020h2\u0007\u0010§\u0001\u001a\u00020\bH\u0002J\u001b\u0010¨\u0001\u001a\u00020h2\u0007\u0010©\u0001\u001a\u00020\b2\u0007\u0010ª\u0001\u001a\u00020\bH\u0014J$\u0010«\u0001\u001a\u00020\b2\u0007\u0010¬\u0001\u001a\u00020\b2\u0007\u0010\u00ad\u0001\u001a\u00020\b2\u0007\u0010®\u0001\u001a\u00020\bH\u0002J-\u0010¯\u0001\u001a\u00020h2\u0007\u0010°\u0001\u001a\u00020\b2\u0007\u0010±\u0001\u001a\u00020\b2\u0007\u0010²\u0001\u001a\u00020\b2\u0007\u0010³\u0001\u001a\u00020\bH\u0014J\t\u0010´\u0001\u001a\u00020hH\u0002J\t\u0010µ\u0001\u001a\u00020hH\u0002J\t\u0010¶\u0001\u001a\u00020hH\u0002J\t\u0010·\u0001\u001a\u00020hH\u0002J\u0013\u0010¸\u0001\u001a\u00020h2\b\u0010¹\u0001\u001a\u00030º\u0001H\u0014J\u0013\u0010»\u0001\u001a\u00020h2\b\u0010¹\u0001\u001a\u00030º\u0001H\u0002J.\u0010¼\u0001\u001a\u00020h2\b\u0010¹\u0001\u001a\u00030º\u00012\u0007\u0010½\u0001\u001a\u00020\b2\u0007\u0010¾\u0001\u001a\u00020)2\u0007\u0010¿\u0001\u001a\u00020\u001fH\u0002J%\u0010À\u0001\u001a\u00020h2\b\u0010¹\u0001\u001a\u00030º\u00012\u0007\u0010½\u0001\u001a\u00020\b2\u0007\u0010¿\u0001\u001a\u00020\u001fH\u0002J\u001b\u0010Á\u0001\u001a\u00020\u001f2\u0007\u0010Â\u0001\u001a\u00020\b2\u0007\u0010Ã\u0001\u001a\u00020\u001fH\u0002J#\u0010Ä\u0001\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u001f2\u0007\u0010Å\u0001\u001a\u00020\u001f2\u0007\u0010Æ\u0001\u001a\u00020\u001fH\u0002J\u0012\u0010Ç\u0001\u001a\u00020\u001c2\u0007\u0010È\u0001\u001a\u00020\bH\u0002J\u0011\u0010É\u0001\u001a\u00020\u001c2\u0006\u0010s\u001a\u00020\bH\u0002J\u0013\u0010É\u0001\u001a\u00020\u001c2\b\u0010v\u001a\u0004\u0018\u00010\u0014H\u0002J\u0012\u0010Ê\u0001\u001a\u00020h2\u0007\u0010Ë\u0001\u001a\u00020\bH\u0002J\u0013\u0010Ì\u0001\u001a\u00020h2\b\u0010¹\u0001\u001a\u00030º\u0001H\u0002J\u0013\u0010Í\u0001\u001a\u00020h2\b\u0010¹\u0001\u001a\u00030º\u0001H\u0002J\u0019\u0010Î\u0001\u001a\u00020)2\u0006\u0010s\u001a\u00020\b2\u0006\u0010o\u001a\u00020\bH\u0002J\u0012\u0010Ï\u0001\u001a\u00020\u001f2\u0007\u0010Ð\u0001\u001a\u00020\u001fH\u0002J\u0012\u0010Ñ\u0001\u001a\u00020\u001f2\u0007\u0010Ð\u0001\u001a\u00020\u001fH\u0002J\u0012\u0010Ò\u0001\u001a\u00020\b2\u0007\u0010Ð\u0001\u001a\u00020\u001fH\u0002J\u0013\u0010Ó\u0001\u001a\u00020)2\b\u0010Ô\u0001\u001a\u00030Õ\u0001H\u0016J\u0013\u0010Ö\u0001\u001a\u00020h2\b\u0010Ô\u0001\u001a\u00030Õ\u0001H\u0002J\u0013\u0010×\u0001\u001a\u00020h2\b\u0010Ô\u0001\u001a\u00030Õ\u0001H\u0002J\u0013\u0010Ø\u0001\u001a\u00020h2\b\u0010Ô\u0001\u001a\u00030Õ\u0001H\u0002J\t\u0010Ù\u0001\u001a\u00020hH\u0002J\t\u0010Ú\u0001\u001a\u00020hH\u0002J\t\u0010Û\u0001\u001a\u00020hH\u0002J\u0012\u0010Ü\u0001\u001a\u00020\b2\u0007\u0010Ý\u0001\u001a\u00020\bH\u0002J\t\u0010Þ\u0001\u001a\u00020hH\u0016J\u0011\u0010ß\u0001\u001a\u00020\b2\u0006\u0010o\u001a\u00020\bH\u0002J\u000f\u0010à\u0001\u001a\u00020h2\u0006\u0010s\u001a\u00020\bJ\u000f\u0010á\u0001\u001a\u00020h2\u0006\u0010s\u001a\u00020\bR\u0012\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010 \u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u001f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010%\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u001f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R$\u00105\u001a\u00020)2\u0006\u0010\u0017\u001a\u00020)@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u000e\u0010:\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020HX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020HX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020HX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020HX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020MX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020OX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020OX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010o\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bp\u0010\u001aR0\u0010 \u0001\u001a\u0005\u0018\u00010¡\u00012\n\u0010 \u0001\u001a\u0005\u0018\u00010¡\u00018F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b¢\u0001\u0010£\u0001\"\u0006\b¤\u0001\u0010¥\u0001¨\u0006ã\u0001"},
   d2 = {"Lcom/blueair/devicedetails/view/CustomWheelView;", "Landroid/view/View;", "Ljava/lang/Runnable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "data", "", "formatter", "Lcom/github/gzuliyujiang/wheelview/contract/WheelFormatter;", "getFormatter", "()Lcom/github/gzuliyujiang/wheelview/contract/WheelFormatter;", "setFormatter", "(Lcom/github/gzuliyujiang/wheelview/contract/WheelFormatter;)V", "defaultItem", "", "visibleItemCount", "defaultItemPosition", "value", "currentPosition", "getCurrentPosition", "()I", "maxWidthText", "", "textColor", "selectedTextColor", "", "textSize", "getTextSize", "()F", "setTextSize", "(F)V", "selectedTextSize", "getSelectedTextSize", "setSelectedTextSize", "selectedTextBold", "", "indicatorSize", "indicatorColor", "curtainColor", "curtainCorner", "curtainRadius", "itemSpace", "textAlign", "sameWidthEnabled", "indicatorEnabled", "curtainEnabled", "atmosphericEnabled", "cyclicEnabled", "getCyclicEnabled", "()Z", "setCyclicEnabled", "(Z)V", "curvedEnabled", "curvedMaxAngle", "curvedIndicatorSpace", "handler", "Landroid/os/Handler;", "paint", "Landroid/graphics/Paint;", "scroller", "Landroid/widget/Scroller;", "tracker", "Landroid/view/VelocityTracker;", "onWheelChangedListener", "Lcom/blueair/devicedetails/view/CustomOnWheelChangedListener;", "rectDrawn", "Landroid/graphics/Rect;", "rectIndicatorHead", "rectIndicatorFoot", "rectCurrentItem", "camera", "Landroid/graphics/Camera;", "matrixRotate", "Landroid/graphics/Matrix;", "matrixDepth", "lastScrollPosition", "drawnItemCount", "halfDrawnItemCount", "textMaxWidth", "textMaxHeight", "itemHeight", "halfItemHeight", "halfWheelHeight", "minFlingYCoordinate", "maxFlingYCoordinate", "wheelCenterXCoordinate", "wheelCenterYCoordinate", "drawnCenterXCoordinate", "drawnCenterYCoordinate", "scrollOffsetYCoordinate", "lastPointYCoordinate", "downPointYCoordinate", "minimumVelocity", "maximumVelocity", "touchSlop", "isClick", "isForceFinishScroll", "initTextPaint", "", "setStyle", "style", "initAttrs", "defStyleRes", "updateVisibleItemCount", "computeTextWidthAndHeight", "itemCount", "getItemCount", "getItem", "T", "position", "(I)Ljava/lang/Object;", "getPosition", "item", "getCurrentItem", "()Ljava/lang/Object;", "setVisibleItemCountReal", "count", "setOnWheelChangedListener", "listener", "setNewData", "newData", "setData", "defaultValue", "defaultPosition", "setDefaultValueReal", "setDefaultPositionReal", "findPosition", "setSameWidthEnabledReal", "setMaxWidthTextReal", "text", "setTextColorReal", "color", "setSelectedTextColorReal", "setSelectedTextBoldReal", "bold", "setItemSpaceReal", "space", "setIndicatorEnabledReal", "setIndicatorSizeReal", "size", "setIndicatorColorReal", "setCurvedIndicatorSpaceReal", "setCurtainEnabledReal", "setCurtainColorReal", "setCurtainCornerReal", "setCurtainRadiusReal", "isAtmosphericEnabled", "setAtmosphericEnabledReal", "setCurvedEnabledReal", "isCurved", "setCurvedMaxAngleReal", "setTextAlignReal", "align", "updatePaintTextAlign", "typeface", "Landroid/graphics/Typeface;", "getTypeface", "()Landroid/graphics/Typeface;", "setTypeface", "(Landroid/graphics/Typeface;)V", "notifyDataSetChanged", "pos", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "measureSize", "mode", "sizeExpect", "sizeActual", "onSizeChanged", "w", "h", "ow", "oh", "computeDrawnCenterCoordinate", "computeFlingLimitYCoordinate", "computeIndicatorRect", "computeCurrentItemRect", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawAllItem", "drawItemRect", "dataPosition", "isCenterItem", "drawCenterYCoordinate", "drawItemText", "computeDegree", "drawnItemCenterYCoordinate", "ratio", "clamp", "min", "max", "obtainItemText", "drawnDataPosition", "formatItem", "computeAndSetAtmospheric", "abs", "drawCurtain", "drawIndicator", "isPositionInRange", "computeYCoordinateAtAngle", "degree", "sinDegree", "computeDepth", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "handleActionDown", "handleActionMove", "handleActionUp", "handleActionCancel", "obtainOrClearTracker", "cancelTracker", "computeDistanceToEndPoint", "remainder", "run", "computePosition", "scrollTo", "smoothScrollTo", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class CustomWheelView extends View implements Runnable {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final int SCROLL_STATE_DRAGGING = 1;
   private static final int SCROLL_STATE_IDLE = 0;
   private static final int SCROLL_STATE_SCROLLING = 2;
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
   private List data;
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

   // $FF: synthetic method
   public static void $r8$lambda$KG_G4VwCqLidhAnVLeix4AtL_PM/* $FF was: $r8$lambda$KG_G4VwCqLidhAnVLeix4AtL-PM*/(CustomWheelView var0, int var1) {
      scrollTo$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$xHnEAABOjUe6YZI_fPDwzxzI_U8/* $FF was: $r8$lambda$xHnEAABOjUe6YZI-fPDwzxzI-U8*/(CustomWheelView var0, ValueAnimator var1) {
      smoothScrollTo$lambda$1(var0, var1);
   }

   public CustomWheelView(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      this(var1, (AttributeSet)null, 0, 6, (DefaultConstructorMarker)null);
   }

   public CustomWheelView(Context var1, AttributeSet var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      this(var1, var2, 0, 4, (DefaultConstructorMarker)null);
   }

   public CustomWheelView(Context var1, AttributeSet var2, int var3) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super(var1, var2, var3);
      this.data = (List)(new ArrayList());
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
      this.initAttrs(var1, var2, var3, style.WheelDefault);
      this.initTextPaint();
      this.updateVisibleItemCount();
      this.scroller = new Scroller(var1);
      ViewConfiguration var4 = ViewConfiguration.get(var1);
      this.minimumVelocity = var4.getScaledMinimumFlingVelocity();
      this.maximumVelocity = var4.getScaledMaximumFlingVelocity();
      this.touchSlop = var4.getScaledTouchSlop();
   }

   // $FF: synthetic method
   public CustomWheelView(Context var1, AttributeSet var2, int var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 2) != 0) {
         var2 = null;
      }

      if ((var4 & 4) != 0) {
         var3 = attr.WheelStyle;
      }

      this(var1, var2, var3);
   }

   private final void cancelTracker() {
      VelocityTracker var1 = this.tracker;
      if (var1 != null) {
         Intrinsics.checkNotNull(var1);
         var1.recycle();
         this.tracker = null;
      }

   }

   private final float clamp(float var1, float var2, float var3) {
      return var1 < var2 ? var2 : Math.min(var1, var3);
   }

   private final void computeAndSetAtmospheric(int var1) {
      if (this.atmosphericEnabled) {
         int var2 = this.drawnCenterYCoordinate;
         var1 = Math.max((int)((float)(var2 - var1) * 1.0F / (float)var2 * (float)255), 0);
         this.paint.setAlpha(var1);
      }

   }

   private final void computeCurrentItemRect() {
      if (this.curtainEnabled || this.selectedTextColor != 0) {
         this.rectCurrentItem.set(this.rectDrawn.left, this.wheelCenterYCoordinate - this.halfItemHeight, this.rectDrawn.right, this.wheelCenterYCoordinate + this.halfItemHeight);
      }
   }

   private final float computeDegree(int var1, float var2) {
      int var3 = this.drawnCenterYCoordinate;
      if (var1 > var3) {
         var1 = 1;
      } else if (var1 < var3) {
         var1 = -1;
      } else {
         var1 = 0;
      }

      var2 = -((float)1 - var2);
      var3 = this.curvedMaxAngle;
      return this.clamp(var2 * (float)var3 * (float)var1, -((float)var3), (float)var3);
   }

   private final int computeDepth(float var1) {
      return (int)((double)this.halfWheelHeight - Math.cos(Math.toRadians((double)var1)) * (double)this.halfWheelHeight);
   }

   private final int computeDistanceToEndPoint(int var1) {
      if (Math.abs(var1) > this.halfItemHeight) {
         int var2;
         if (this.scrollOffsetYCoordinate < 0) {
            var2 = -this.itemHeight;
         } else {
            var2 = this.itemHeight;
         }

         return var2 - var1;
      } else {
         return var1 * -1;
      }
   }

   private final void computeDrawnCenterCoordinate() {
      int var1 = this.textAlign;
      if (var1 != 0) {
         if (var1 != 1) {
            if (var1 != 2) {
               var1 = this.wheelCenterXCoordinate;
            } else {
               var1 = this.rectDrawn.right;
            }
         } else {
            var1 = this.rectDrawn.left;
         }
      } else {
         var1 = this.wheelCenterXCoordinate;
      }

      this.drawnCenterXCoordinate = var1;
      this.drawnCenterYCoordinate = (int)((float)this.wheelCenterYCoordinate - (this.paint.ascent() + this.paint.descent()) / (float)2);
   }

   private final void computeFlingLimitYCoordinate() {
      int var2 = this.defaultItemPosition;
      int var1 = this.itemHeight;
      var2 *= var1;
      if (this.cyclicEnabled) {
         var1 = Integer.MIN_VALUE;
      } else {
         var1 = -var1 * (this.getItemCount() - 1) + var2;
      }

      this.minFlingYCoordinate = var1;
      var1 = var2;
      if (this.cyclicEnabled) {
         var1 = Integer.MAX_VALUE;
      }

      this.maxFlingYCoordinate = var1;
   }

   private final void computeIndicatorRect() {
      if (this.indicatorEnabled) {
         int var1;
         if (this.curvedEnabled) {
            var1 = this.curvedIndicatorSpace;
         } else {
            var1 = 0;
         }

         int var3 = (int)(this.indicatorSize / 2.0F);
         int var5 = this.wheelCenterYCoordinate;
         int var4 = this.halfItemHeight;
         int var2 = var5 + var4 + var1;
         var1 = var5 - var4 - var1;
         this.rectIndicatorHead.set(this.rectDrawn.left, var2 - var3, this.rectDrawn.right, var2 + var3);
         this.rectIndicatorFoot.set(this.rectDrawn.left, var1 - var3, this.rectDrawn.right, var1 + var3);
      }
   }

   private final int computePosition(int var1) {
      return (this.scrollOffsetYCoordinate * -1 / this.itemHeight + this.defaultItemPosition) % var1;
   }

   private final void computeTextWidthAndHeight() {
      int var1 = 0;
      this.textMaxHeight = 0;
      this.textMaxWidth = 0;
      if (this.sameWidthEnabled) {
         this.textMaxWidth = (int)this.paint.measureText(this.formatItem(0));
      } else if (!TextUtils.isEmpty((CharSequence)this.maxWidthText)) {
         this.textMaxWidth = (int)this.paint.measureText(this.maxWidthText);
      } else {
         for(int var2 = this.getItemCount(); var1 < var2; ++var1) {
            int var3 = (int)this.paint.measureText(this.formatItem(var1));
            this.textMaxWidth = Math.max(this.textMaxWidth, var3);
         }
      }

      Paint.FontMetrics var4 = this.paint.getFontMetrics();
      this.textMaxHeight = (int)(var4.bottom - var4.top);
   }

   private final float computeYCoordinateAtAngle(float var1) {
      return this.sinDegree(var1) / this.sinDegree((float)this.curvedMaxAngle) * (float)this.halfWheelHeight;
   }

   private final void drawAllItem(Canvas var1) {
      int var9 = this.scrollOffsetYCoordinate * -1 / this.itemHeight;
      int var8 = this.halfDrawnItemCount;
      int var11 = var9 - var8;
      int var10 = this.defaultItemPosition + var11;

      for(int var20 = var8 * -1; var10 < this.defaultItemPosition + var11 + this.drawnItemCount; ++var20) {
         this.initTextPaint();
         boolean var15;
         if (var10 == this.defaultItemPosition + var11 + this.drawnItemCount / 2) {
            var15 = true;
         } else {
            var15 = false;
         }

         var8 = this.drawnCenterYCoordinate;
         int var12 = this.itemHeight;
         var12 = var20 * var12 + var8 + this.scrollOffsetYCoordinate % var12;
         int var13 = Math.abs(var8 - var12);
         float var3 = this.computeDegree(var12, (float)(this.drawnCenterYCoordinate - var13 - this.rectDrawn.top) * 1.0F / (float)(this.drawnCenterYCoordinate - this.rectDrawn.top));
         float var5 = this.computeYCoordinateAtAngle(var3);
         if (this.curvedEnabled) {
            var8 = this.wheelCenterXCoordinate;
            int var14 = this.textAlign;
            if (var14 != 1) {
               if (var14 == 2) {
                  var8 = this.rectDrawn.right;
               }
            } else {
               var8 = this.rectDrawn.left;
            }

            float var2 = (float)this.wheelCenterYCoordinate - var5;
            this.camera.save();
            this.camera.rotateX(var3);
            this.camera.getMatrix(this.matrixRotate);
            this.camera.restore();
            Matrix var16 = this.matrixRotate;
            float var4 = (float)var8;
            float var7 = -var4;
            float var6 = -var2;
            var16.preTranslate(var7, var6);
            this.matrixRotate.postTranslate(var4, var2);
            this.camera.save();
            this.camera.translate(0.0F, 0.0F, (float)this.computeDepth(var3));
            this.camera.getMatrix(this.matrixDepth);
            this.camera.restore();
            this.matrixDepth.preTranslate(var7, var6);
            this.matrixDepth.postTranslate(var4, var2);
            this.matrixRotate.postConcat(this.matrixDepth);
         }

         this.computeAndSetAtmospheric(var13);
         float var17;
         if (this.curvedEnabled) {
            var17 = (float)this.drawnCenterYCoordinate - var5;
         } else {
            var17 = (float)var12;
         }

         this.drawItemRect(var1, var10, var15, var17);
         ++var10;
      }

   }

   private final void drawCurtain(Canvas var1) {
      if (this.curtainEnabled) {
         this.paint.setColor(this.curtainColor);
         this.paint.setStyle(Style.FILL);
         if (this.curtainRadius > 0.0F) {
            Path var5 = new Path();
            int var3 = this.curtainCorner;
            float[] var4;
            if (var3 != 1) {
               if (var3 != 2) {
                  if (var3 != 3) {
                     if (var3 != 4) {
                        if (var3 != 5) {
                           var4 = new float[]{0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F};
                        } else {
                           var4 = new float[8];
                           var4[0] = 0.0F;
                           var4[1] = 0.0F;
                           float var2 = this.curtainRadius;
                           var4[2] = var2;
                           var4[3] = var2;
                           var4[4] = var2;
                           var4[5] = var2;
                           var4[6] = 0.0F;
                           var4[7] = 0.0F;
                        }
                     } else {
                        var4 = new float[8];
                        float var6 = this.curtainRadius;
                        var4[0] = var6;
                        var4[1] = var6;
                        var4[2] = 0.0F;
                        var4[3] = 0.0F;
                        var4[4] = 0.0F;
                        var4[5] = 0.0F;
                        var4[6] = var6;
                        var4[7] = var6;
                     }
                  } else {
                     var4 = new float[8];
                     var4[0] = 0.0F;
                     var4[1] = 0.0F;
                     var4[2] = 0.0F;
                     var4[3] = 0.0F;
                     float var7 = this.curtainRadius;
                     var4[4] = var7;
                     var4[5] = var7;
                     var4[6] = var7;
                     var4[7] = var7;
                  }
               } else {
                  var4 = new float[8];
                  float var8 = this.curtainRadius;
                  var4[0] = var8;
                  var4[1] = var8;
                  var4[2] = var8;
                  var4[3] = var8;
                  var4[4] = 0.0F;
                  var4[5] = 0.0F;
                  var4[6] = 0.0F;
                  var4[7] = 0.0F;
               }
            } else {
               var4 = new float[8];
               float var9 = this.curtainRadius;
               var4[0] = var9;
               var4[1] = var9;
               var4[2] = var9;
               var4[3] = var9;
               var4[4] = var9;
               var4[5] = var9;
               var4[6] = var9;
               var4[7] = var9;
            }

            var5.addRoundRect(new RectF(this.rectCurrentItem), var4, Direction.CCW);
            var1.drawPath(var5, this.paint);
         } else {
            var1.drawRect(this.rectCurrentItem, this.paint);
         }
      }
   }

   private final void drawIndicator(Canvas var1) {
      if (this.indicatorEnabled) {
         this.paint.setColor(this.indicatorColor);
         this.paint.setStyle(Style.FILL);
         var1.drawRect(this.rectIndicatorHead, this.paint);
         var1.drawRect(this.rectIndicatorFoot, this.paint);
      }
   }

   private final void drawItemRect(Canvas var1, int var2, boolean var3, float var4) {
      int var5 = this.selectedTextColor;
      if (var5 == 0) {
         var1.save();
         var1.clipRect(this.rectDrawn);
         if (this.curvedEnabled) {
            var1.concat(this.matrixRotate);
         }

         this.drawItemText(var1, var2, var4);
         var1.restore();
      } else if (this.textSize == this.selectedTextSize && !this.selectedTextBold) {
         var1.save();
         if (this.curvedEnabled) {
            var1.concat(this.matrixRotate);
         }

         if (VERSION.SDK_INT >= 26) {
            BlueairApp$$ExternalSyntheticApiModelOutline0.m(var1, this.rectCurrentItem);
         } else {
            var1.clipRect(this.rectCurrentItem, Op.DIFFERENCE);
         }

         this.drawItemText(var1, var2, var4);
         var1.restore();
         this.paint.setColor(this.selectedTextColor);
         var1.save();
         if (this.curvedEnabled) {
            var1.concat(this.matrixRotate);
         }

         var1.clipRect(this.rectCurrentItem);
         this.drawItemText(var1, var2, var4);
         var1.restore();
      } else if (!var3) {
         var1.save();
         if (this.curvedEnabled) {
            var1.concat(this.matrixRotate);
         }

         this.drawItemText(var1, var2, var4);
         var1.restore();
      } else {
         this.paint.setColor(var5);
         this.paint.setTextSize(this.selectedTextSize);
         this.paint.setFakeBoldText(this.selectedTextBold);
         var1.save();
         if (this.curvedEnabled) {
            var1.concat(this.matrixRotate);
         }

         this.drawItemText(var1, var2, var4);
         var1.restore();
      }
   }

   private final void drawItemText(Canvas var1, int var2, float var3) {
      var1.drawText(this.obtainItemText(var2), (float)this.drawnCenterXCoordinate, var3, this.paint);
   }

   private final int findPosition(Object var1) {
      if (var1 == null) {
         return 0;
      } else {
         Iterator var5 = this.data.iterator();
         int var2 = 0;

         while(var5.hasNext()) {
            Object var6 = var5.next();
            if (var6 != null) {
               if (Intrinsics.areEqual(var6, var1)) {
                  return var2;
               }

               WheelFormatter var3 = this.formatter;
               if (var3 != null) {
                  String var4 = null;
                  String var8;
                  if (var3 != null) {
                     var8 = var3.formatItem(var6);
                  } else {
                     var8 = null;
                  }

                  WheelFormatter var7 = this.formatter;
                  if (var7 != null) {
                     var4 = var7.formatItem(var1);
                  }

                  if (Intrinsics.areEqual(var8, var4)) {
                     return var2;
                  }
               }

               if (var6 instanceof TextProvider) {
                  String var9 = ((TextProvider)var6).provideText();
                  Intrinsics.checkNotNullExpressionValue(var9, "provideText(...)");
                  if (Intrinsics.areEqual(var9, var1.toString())) {
                     return var2;
                  }
               }

               if (Intrinsics.areEqual(var6.toString(), var1.toString())) {
                  return var2;
               }

               ++var2;
            }
         }

         return 0;
      }
   }

   private final String formatItem(int var1) {
      return this.formatItem(this.getItem(var1));
   }

   private final String formatItem(Object var1) {
      if (var1 == null) {
         return "";
      } else if (var1 instanceof TextProvider) {
         String var3 = ((TextProvider)var1).provideText();
         Intrinsics.checkNotNullExpressionValue(var3, "provideText(...)");
         return var3;
      } else {
         WheelFormatter var2 = this.formatter;
         if (var2 != null) {
            String var4 = var2.formatItem(var1);
            if (var4 != null) {
               return var4;
            }
         }

         return var1.toString();
      }
   }

   private final Object getItem(int var1) {
      int var2 = this.data.size();
      if (var2 == 0) {
         return null;
      } else {
         var1 = (var1 + var2) % var2;
         return var1 >= 0 && var1 <= var2 - 1 ? this.data.get(var1) : null;
      }
   }

   private final void handleActionCancel() {
      if (this.getParent() != null) {
         this.getParent().requestDisallowInterceptTouchEvent(false);
      }

      this.cancelTracker();
   }

   private final void handleActionDown(MotionEvent var1) {
      if (this.getParent() != null) {
         this.getParent().requestDisallowInterceptTouchEvent(true);
      }

      this.obtainOrClearTracker();
      VelocityTracker var3 = this.tracker;
      Intrinsics.checkNotNull(var3);
      var3.addMovement(var1);
      if (!this.scroller.isFinished()) {
         this.scroller.abortAnimation();
         this.isForceFinishScroll = true;
      }

      int var2 = (int)var1.getY();
      this.lastPointYCoordinate = var2;
      this.downPointYCoordinate = var2;
   }

   private final void handleActionMove(MotionEvent var1) {
      int var3 = this.computeDistanceToEndPoint(this.scroller.getFinalY() % this.itemHeight);
      if (Math.abs((float)this.downPointYCoordinate - var1.getY()) < (float)this.touchSlop && var3 > 0) {
         this.isClick = true;
      } else {
         this.isClick = false;
         VelocityTracker var4 = this.tracker;
         if (var4 != null) {
            Intrinsics.checkNotNull(var4);
            var4.addMovement(var1);
         }

         float var2 = var1.getY() - (float)this.lastPointYCoordinate;
         if (!(Math.abs(var2) < 1.0F)) {
            this.scrollOffsetYCoordinate = (int)((float)this.scrollOffsetYCoordinate + var2);
            this.lastPointYCoordinate = (int)var1.getY();
            this.invalidate();
         }
      }
   }

   private final void handleActionUp(MotionEvent var1) {
      if (this.getParent() != null) {
         this.getParent().requestDisallowInterceptTouchEvent(false);
      }

      if (!this.isClick) {
         VelocityTracker var4 = this.tracker;
         int var2;
         if (var4 != null) {
            Intrinsics.checkNotNull(var4);
            var4.addMovement(var1);
            VelocityTracker var5 = this.tracker;
            Intrinsics.checkNotNull(var5);
            var5.computeCurrentVelocity(1000, (float)this.maximumVelocity);
            var5 = this.tracker;
            Intrinsics.checkNotNull(var5);
            var2 = (int)var5.getYVelocity();
         } else {
            var2 = 0;
         }

         this.isForceFinishScroll = false;
         if (Math.abs(var2) > this.minimumVelocity) {
            this.scroller.fling(0, this.scrollOffsetYCoordinate, 0, var2, 0, 0, this.minFlingYCoordinate, this.maxFlingYCoordinate);
            Scroller var7 = this.scroller;
            var7.setFinalY(var7.getFinalY() + this.computeDistanceToEndPoint(this.scroller.getFinalY() % this.itemHeight));
         } else {
            var2 = this.computeDistanceToEndPoint(this.scrollOffsetYCoordinate % this.itemHeight);
            this.scroller.startScroll(0, this.scrollOffsetYCoordinate, 0, var2);
         }

         if (!this.cyclicEnabled) {
            int var3 = this.scroller.getFinalY();
            var2 = this.maxFlingYCoordinate;
            if (var3 > var2) {
               this.scroller.setFinalY(var2);
            } else {
               var2 = this.scroller.getFinalY();
               var3 = this.minFlingYCoordinate;
               if (var2 < var3) {
                  this.scroller.setFinalY(var3);
               }
            }
         }

         this.handler.post(this);
         this.cancelTracker();
      }
   }

   private final void initAttrs(Context var1, AttributeSet var2, int var3, int var4) {
      float var5 = var1.getResources().getDisplayMetrics().density;
      TypedArray var6 = var1.obtainStyledAttributes(var2, styleable.WheelView, var3, var4);
      Intrinsics.checkNotNullExpressionValue(var6, "obtainStyledAttributes(...)");
      this.visibleItemCount = var6.getInt(styleable.WheelView_wheel_visibleItemCount, 5);
      this.sameWidthEnabled = var6.getBoolean(styleable.WheelView_wheel_sameWidthEnabled, false);
      this.maxWidthText = var6.getString(styleable.WheelView_wheel_maxWidthText);
      this.textColor = var6.getColor(styleable.WheelView_wheel_itemTextColor, -7829368);
      this.selectedTextColor = var6.getColor(styleable.WheelView_wheel_itemTextColorSelected, -16777216);
      this.setTextSize(var6.getDimension(styleable.WheelView_wheel_itemTextSize, TypedValueCompat.spToPx(15.0F, this.getResources().getDisplayMetrics())));
      this.setSelectedTextSize(var6.getDimension(styleable.WheelView_wheel_itemTextSizeSelected, this.textSize));
      this.selectedTextBold = var6.getBoolean(styleable.WheelView_wheel_itemTextBoldSelected, false);
      this.textAlign = var6.getInt(styleable.WheelView_wheel_itemTextAlign, 0);
      this.itemSpace = var6.getDimensionPixelSize(styleable.WheelView_wheel_itemSpace, (int)((float)20 * var5));
      this.setCyclicEnabled(var6.getBoolean(styleable.WheelView_wheel_cyclicEnabled, false));
      this.indicatorEnabled = var6.getBoolean(styleable.WheelView_wheel_indicatorEnabled, true);
      this.indicatorColor = var6.getColor(styleable.WheelView_wheel_indicatorColor, -3552823);
      var3 = styleable.WheelView_wheel_indicatorSize;
      var5 = (float)1 * var5;
      this.indicatorSize = var6.getDimension(var3, var5);
      this.curvedIndicatorSpace = var6.getDimensionPixelSize(styleable.WheelView_wheel_curvedIndicatorSpace, (int)var5);
      this.curtainEnabled = var6.getBoolean(styleable.WheelView_wheel_curtainEnabled, false);
      this.curtainColor = var6.getColor(styleable.WheelView_wheel_curtainColor, -1);
      this.curtainCorner = var6.getInt(styleable.WheelView_wheel_curtainCorner, 0);
      this.curtainRadius = var6.getDimension(styleable.WheelView_wheel_curtainRadius, 0.0F);
      this.atmosphericEnabled = var6.getBoolean(styleable.WheelView_wheel_atmosphericEnabled, false);
      this.curvedEnabled = var6.getBoolean(styleable.WheelView_wheel_curvedEnabled, false);
      this.curvedMaxAngle = var6.getInteger(styleable.WheelView_wheel_curvedMaxAngle, 90);
      var6.recycle();
   }

   private final void initTextPaint() {
      this.paint.setColor(this.textColor);
      this.paint.setTextSize(this.textSize);
      this.paint.setFakeBoldText(false);
      this.paint.setStyle(Style.FILL);
   }

   private final boolean isPositionInRange(int var1, int var2) {
      return var1 >= 0 && var1 < var2;
   }

   private final int measureSize(int var1, int var2, int var3) {
      if (var1 == 1073741824) {
         return var2;
      } else {
         return var1 == Integer.MIN_VALUE ? Math.min(var3, var2) : var3;
      }
   }

   private final void notifyDataSetChanged(int var1) {
      var1 = Math.max(Math.min(var1, this.getItemCount() - 1), 0);
      this.scrollOffsetYCoordinate = 0;
      this.defaultItem = this.getItem(var1);
      this.defaultItemPosition = var1;
      this.currentPosition = var1;
      this.updatePaintTextAlign();
      this.computeFlingLimitYCoordinate();
      this.computeIndicatorRect();
      this.computeCurrentItemRect();
      this.requestLayout();
      this.invalidate();
   }

   private final String obtainItemText(int var1) {
      int var3 = this.getItemCount();
      if (this.cyclicEnabled) {
         if (var3 != 0) {
            int var2 = var1 % var3;
            var1 = var2;
            if (var2 < 0) {
               var1 = var2 + var3;
            }

            return this.formatItem(var1);
         }
      } else if (this.isPositionInRange(var1, var3)) {
         return this.formatItem(var1);
      }

      return "";
   }

   private final void obtainOrClearTracker() {
      VelocityTracker var1 = this.tracker;
      if (var1 == null) {
         this.tracker = VelocityTracker.obtain();
      } else {
         Intrinsics.checkNotNull(var1);
         var1.clear();
      }
   }

   private static final void scrollTo$lambda$0(CustomWheelView var0, int var1) {
      var0.notifyDataSetChanged(var1);
   }

   private final void setData(List var1, int var2) {
      List var3 = var1;
      if (var1 == null) {
         var3 = (List)(new ArrayList());
      }

      this.data = var3;
      this.notifyDataSetChanged(var2);
   }

   private final float sinDegree(float var1) {
      return (float)Math.sin(Math.toRadians((double)var1));
   }

   private static final void smoothScrollTo$lambda$1(CustomWheelView var0, ValueAnimator var1) {
      Intrinsics.checkNotNullParameter(var1, "animation");
      Object var2 = var1.getAnimatedValue();
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type kotlin.Int");
      var0.scrollOffsetYCoordinate = (Integer)var2;
      var0.invalidate();
   }

   private final void updatePaintTextAlign() {
      int var1 = this.textAlign;
      if (var1 != 0) {
         if (var1 != 1) {
            if (var1 != 2) {
               this.paint.setTextAlign(Align.CENTER);
            } else {
               this.paint.setTextAlign(Align.RIGHT);
            }
         } else {
            this.paint.setTextAlign(Align.LEFT);
         }
      } else {
         this.paint.setTextAlign(Align.CENTER);
      }
   }

   private final void updateVisibleItemCount() {
      int var1 = this.visibleItemCount;
      if (var1 >= 2) {
         if (var1 % 2 == 0) {
            this.visibleItemCount = var1 + 1;
         }

         var1 = this.visibleItemCount + 2;
         this.drawnItemCount = var1;
         this.halfDrawnItemCount = var1 / 2;
      } else {
         throw new ArithmeticException("Visible item count can not be less than 2");
      }
   }

   public final Object getCurrentItem() {
      return this.getItem(this.currentPosition);
   }

   public final int getCurrentPosition() {
      return this.currentPosition;
   }

   public final boolean getCyclicEnabled() {
      return this.cyclicEnabled;
   }

   public final WheelFormatter getFormatter() {
      return this.formatter;
   }

   public final int getItemCount() {
      return this.data.size();
   }

   public final int getPosition(Object var1) {
      return var1 == null ? 0 : this.data.indexOf(var1);
   }

   public final float getSelectedTextSize() {
      return this.selectedTextSize;
   }

   public final float getTextSize() {
      return this.textSize;
   }

   public final Typeface getTypeface() {
      return this.paint.getTypeface();
   }

   public final boolean isAtmosphericEnabled() {
      return this.atmosphericEnabled;
   }

   protected void onDraw(Canvas var1) {
      Intrinsics.checkNotNullParameter(var1, "canvas");
      if (this.itemHeight - this.halfDrawnItemCount > 0) {
         this.drawCurtain(var1);
         this.drawIndicator(var1);
         this.drawAllItem(var1);
      }
   }

   protected void onMeasure(int var1, int var2) {
      int var4 = MeasureSpec.getMode(var1);
      int var3 = MeasureSpec.getMode(var2);
      int var5 = MeasureSpec.getSize(var1);
      int var7 = MeasureSpec.getSize(var2);
      int var6 = this.textMaxWidth;
      var1 = this.textMaxHeight;
      var2 = this.visibleItemCount;
      var2 = var1 * var2 + this.itemSpace * (var2 - 1);
      var1 = var2;
      if (this.curvedEnabled) {
         var1 = (int)((double)(var2 * 2) / Math.PI);
      }

      int var8 = this.getPaddingLeft();
      var2 = this.getPaddingRight();
      int var9 = this.getPaddingTop();
      int var10 = this.getPaddingBottom();
      this.setMeasuredDimension(this.measureSize(var4, var5, var6 + var8 + var2), this.measureSize(var3, var7, var1 + var9 + var10));
   }

   protected void onSizeChanged(int var1, int var2, int var3, int var4) {
      this.rectDrawn.set(this.getPaddingLeft(), this.getPaddingTop(), this.getWidth() - this.getPaddingRight(), this.getHeight() - this.getPaddingBottom());
      this.wheelCenterXCoordinate = this.rectDrawn.centerX();
      this.wheelCenterYCoordinate = this.rectDrawn.centerY();
      this.computeDrawnCenterCoordinate();
      this.halfWheelHeight = this.rectDrawn.height() / 2;
      var1 = this.rectDrawn.height() / this.visibleItemCount;
      this.itemHeight = var1;
      this.halfItemHeight = var1 / 2;
      this.computeFlingLimitYCoordinate();
      this.computeIndicatorRect();
      this.computeCurrentItemRect();
   }

   public boolean onTouchEvent(MotionEvent var1) {
      Intrinsics.checkNotNullParameter(var1, "event");
      if (this.isEnabled()) {
         int var2 = var1.getAction();
         if (var2 != 0) {
            if (var2 != 1) {
               if (var2 != 2) {
                  if (var2 == 3) {
                     this.handleActionCancel();
                  }
               } else {
                  this.handleActionMove(var1);
               }
            } else {
               this.handleActionUp(var1);
            }
         } else {
            this.handleActionDown(var1);
         }
      }

      if (this.isClick) {
         this.performClick();
      }

      return true;
   }

   public void run() {
      if (this.itemHeight != 0) {
         int var3 = this.getItemCount();
         if (var3 != 0) {
            if (this.scroller.isFinished() && !this.isForceFinishScroll) {
               int var6 = this.computePosition(var3);
               int var5 = var6;
               if (var6 < 0) {
                  var5 = var6 + var3;
               }

               this.currentPosition = var5;
               CustomOnWheelChangedListener var7 = this.onWheelChangedListener;
               if (var7 != null) {
                  var7.onWheelSelected(this, var5);
               }

               this.postInvalidate();
               return;
            }

            if (this.scroller.computeScrollOffset()) {
               this.scrollOffsetYCoordinate = this.scroller.getCurrY();
               int var2 = this.computePosition(var3);
               int var1 = this.lastScrollPosition;
               if (var1 != var2) {
                  if (var2 == 0 && var1 == var3 - 1) {
                     CustomOnWheelChangedListener var4 = this.onWheelChangedListener;
                     if (var4 != null) {
                        var4.onWheelLoopFinished(this);
                     }
                  }

                  this.lastScrollPosition = var2;
               }

               this.postInvalidate();
               this.handler.postDelayed(this, 20L);
            }
         }
      }

   }

   public final void scrollTo(int var1) {
      this.post(new CustomWheelView$$ExternalSyntheticLambda2(this, var1));
   }

   public final void setAtmosphericEnabledReal(boolean var1) {
      this.atmosphericEnabled = var1;
      this.invalidate();
   }

   public final void setCurtainColorReal(int var1) {
      this.curtainColor = var1;
      this.invalidate();
   }

   public final void setCurtainCornerReal(int var1) {
      this.curtainCorner = var1;
      this.invalidate();
   }

   public final void setCurtainEnabledReal(boolean var1) {
      this.curtainEnabled = var1;
      if (var1) {
         this.indicatorEnabled = false;
      }

      this.computeCurrentItemRect();
      this.invalidate();
   }

   public final void setCurtainRadiusReal(float var1) {
      this.curtainRadius = var1;
      this.invalidate();
   }

   public final void setCurvedEnabledReal(boolean var1) {
      this.curvedEnabled = var1;
      this.requestLayout();
      this.invalidate();
   }

   public final void setCurvedIndicatorSpaceReal(int var1) {
      this.curvedIndicatorSpace = var1;
      this.computeIndicatorRect();
      this.invalidate();
   }

   public final void setCurvedMaxAngleReal(int var1) {
      this.curvedMaxAngle = var1;
      this.requestLayout();
      this.invalidate();
   }

   public final void setCyclicEnabled(boolean var1) {
      this.cyclicEnabled = var1;
      this.computeFlingLimitYCoordinate();
      this.invalidate();
   }

   public final void setData(List var1, Object var2) {
      this.setData(var1, this.findPosition(var2));
   }

   public final void setDefaultPositionReal(int var1) {
      this.notifyDataSetChanged(var1);
   }

   public final void setDefaultValueReal(Object var1) {
      this.setDefaultPositionReal(this.findPosition(var1));
   }

   public final void setFormatter(WheelFormatter var1) {
      this.formatter = var1;
   }

   public final void setIndicatorColorReal(int var1) {
      this.indicatorColor = var1;
      this.invalidate();
   }

   public final void setIndicatorEnabledReal(boolean var1) {
      this.indicatorEnabled = var1;
      this.computeIndicatorRect();
      this.invalidate();
   }

   public final void setIndicatorSizeReal(float var1) {
      this.indicatorSize = var1;
      this.computeIndicatorRect();
      this.invalidate();
   }

   public final void setItemSpaceReal(int var1) {
      this.itemSpace = var1;
      this.requestLayout();
      this.invalidate();
   }

   public final void setMaxWidthTextReal(String var1) {
      if (var1 != null) {
         this.maxWidthText = var1;
         this.computeTextWidthAndHeight();
         this.requestLayout();
         this.invalidate();
      } else {
         throw new NullPointerException("Maximum width text can not be null!");
      }
   }

   public final void setNewData(List var1) {
      this.setData(var1, 0);
   }

   public final void setOnWheelChangedListener(CustomOnWheelChangedListener var1) {
      this.onWheelChangedListener = var1;
   }

   public final void setSameWidthEnabledReal(boolean var1) {
      this.sameWidthEnabled = var1;
      this.computeTextWidthAndHeight();
      this.requestLayout();
      this.invalidate();
   }

   public final void setSelectedTextBoldReal(boolean var1) {
      this.selectedTextBold = var1;
      this.computeTextWidthAndHeight();
      this.requestLayout();
      this.invalidate();
   }

   public final void setSelectedTextColorReal(int var1) {
      this.selectedTextColor = var1;
      this.computeCurrentItemRect();
      this.invalidate();
   }

   public final void setSelectedTextSize(float var1) {
      if (this.selectedTextSize != var1) {
         this.selectedTextSize = var1;
         this.computeTextWidthAndHeight();
         this.requestLayout();
         this.invalidate();
      }
   }

   public final void setStyle(int var1) {
      Context var2 = this.getContext();
      Intrinsics.checkNotNullExpressionValue(var2, "getContext(...)");
      this.initAttrs(var2, (AttributeSet)null, attr.WheelStyle, var1);
      this.initTextPaint();
      this.updatePaintTextAlign();
      this.computeTextWidthAndHeight();
      this.computeFlingLimitYCoordinate();
      this.computeIndicatorRect();
      this.computeCurrentItemRect();
      this.requestLayout();
      this.invalidate();
   }

   public final void setTextAlignReal(int var1) {
      this.textAlign = var1;
      this.updatePaintTextAlign();
      this.computeDrawnCenterCoordinate();
      this.invalidate();
   }

   public final void setTextColorReal(int var1) {
      this.textColor = var1;
      this.invalidate();
   }

   public final void setTextSize(float var1) {
      if (var1 != this.textSize) {
         this.textSize = var1;
         this.computeTextWidthAndHeight();
         this.requestLayout();
         this.invalidate();
      }
   }

   public final void setTypeface(Typeface var1) {
      if (var1 != null) {
         this.paint.setTypeface(var1);
         this.computeTextWidthAndHeight();
         this.requestLayout();
         this.invalidate();
      }
   }

   public final void setVisibleItemCountReal(int var1) {
      this.visibleItemCount = var1;
      this.updateVisibleItemCount();
      this.requestLayout();
   }

   public final void smoothScrollTo(int var1) {
      if (this.isInEditMode()) {
         this.scrollTo(var1);
      } else {
         int var2 = this.currentPosition;
         int var3 = this.scrollOffsetYCoordinate;
         ValueAnimator var4 = ValueAnimator.ofInt(new int[]{var3, (var2 - var1) * this.itemHeight + var3});
         var4.setDuration(300L);
         var4.addUpdateListener(new CustomWheelView$$ExternalSyntheticLambda1(this));
         var4.addListener((Animator.AnimatorListener)(new AnimatorListenerAdapter(this, var1) {
            final int $position;
            final CustomWheelView this$0;

            {
               this.this$0 = var1;
               this.$position = var2;
            }

            public void onAnimationEnd(Animator var1) {
               Intrinsics.checkNotNullParameter(var1, "animation");
               this.this$0.scrollTo(this.$position);
            }
         }));
         var4.start();
      }
   }

   @Metadata(
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\b¨\u0006\u000f"},
      d2 = {"Lcom/blueair/devicedetails/view/CustomWheelView$Companion;", "", "<init>", "()V", "SCROLL_STATE_IDLE", "", "getSCROLL_STATE_IDLE$annotations", "getSCROLL_STATE_IDLE", "()I", "SCROLL_STATE_DRAGGING", "getSCROLL_STATE_DRAGGING$annotations", "getSCROLL_STATE_DRAGGING", "SCROLL_STATE_SCROLLING", "getSCROLL_STATE_SCROLLING$annotations", "getSCROLL_STATE_SCROLLING", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }

      // $FF: synthetic method
      @Deprecated(
         message = ""
      )
      public static void getSCROLL_STATE_DRAGGING$annotations() {
      }

      // $FF: synthetic method
      @Deprecated(
         message = ""
      )
      public static void getSCROLL_STATE_IDLE$annotations() {
      }

      // $FF: synthetic method
      @Deprecated(
         message = ""
      )
      public static void getSCROLL_STATE_SCROLLING$annotations() {
      }

      public final int getSCROLL_STATE_DRAGGING() {
         return CustomWheelView.SCROLL_STATE_DRAGGING;
      }

      public final int getSCROLL_STATE_IDLE() {
         return CustomWheelView.SCROLL_STATE_IDLE;
      }

      public final int getSCROLL_STATE_SCROLLING() {
         return CustomWheelView.SCROLL_STATE_SCROLLING;
      }
   }
}
