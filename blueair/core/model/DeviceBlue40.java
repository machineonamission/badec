package com.blueair.core.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.util.IndoorAirRatingRanges;
import java.util.Arrays;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(
   d1 = {"\u0000\u00ad\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0013\n\u0002\b\f\n\u0002\u0018\u0002\n\u0003\b\u0091\u0001\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\r2\u00020\u000e2\u00020\u000f2\u00020\u00102\u00020\u00112\u00020\u00122\u00020\u00132\u00020\u00142\u00020\u0015B·\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010!\u001a\u00020\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010%\u001a\u00020\u001a\u0012\b\b\u0002\u0010&\u001a\u00020\"\u0012\b\b\u0002\u0010'\u001a\u00020\u001a\u0012\b\b\u0002\u0010(\u001a\u00020)\u0012\b\b\u0002\u0010*\u001a\u00020\u0017\u0012\b\b\u0002\u0010+\u001a\u00020\u0017\u0012\b\b\u0002\u0010,\u001a\u00020\u0017\u0012\b\b\u0002\u0010-\u001a\u00020\u0017\u0012\b\b\u0002\u0010.\u001a\u00020\u0017\u0012\b\b\u0002\u0010/\u001a\u00020\u0017\u0012\b\b\u0002\u00100\u001a\u00020\u0017\u0012\b\b\u0002\u00101\u001a\u00020\u0017\u0012\b\b\u0002\u00102\u001a\u00020\u0017\u0012\b\b\u0002\u00103\u001a\u00020\u0017\u0012\b\b\u0002\u00104\u001a\u00020\u0017\u0012\b\b\u0002\u00105\u001a\u000206\u0012\b\b\u0002\u00107\u001a\u000206\u0012\b\b\u0002\u00108\u001a\u000206\u0012\b\b\u0002\u00109\u001a\u000206\u0012\b\b\u0002\u0010:\u001a\u000206\u0012\b\b\u0002\u0010;\u001a\u00020\u001a\u0012\b\b\u0002\u0010<\u001a\u00020\"\u0012\b\b\u0002\u0010=\u001a\u00020\"\u0012\b\b\u0002\u0010>\u001a\u00020\u0017\u0012\b\b\u0002\u0010?\u001a\u00020\u0017\u0012\b\b\u0002\u0010@\u001a\u00020\u001a\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010C\u0012\b\b\u0002\u0010D\u001a\u00020\u001a\u0012\b\b\u0002\u0010E\u001a\u00020\u001a\u0012\b\b\u0002\u0010F\u001a\u00020\u001a\u0012\b\b\u0002\u0010G\u001a\u00020)\u0012\b\b\u0002\u0010H\u001a\u00020\u001a\u0012\b\b\u0002\u0010I\u001a\u00020\u001a\u0012\b\b\u0002\u0010J\u001a\u00020\u001a\u0012\b\b\u0002\u0010K\u001a\u00020\"\u0012\b\b\u0002\u0010L\u001a\u00020\u001a\u0012\b\b\u0002\u0010M\u001a\u00020\"\u0012\b\b\u0002\u0010N\u001a\u00020\u001a\u0012\b\b\u0002\u0010O\u001a\u00020\u001a\u0012\b\b\u0002\u0010P\u001a\u00020\u001a\u0012\b\b\u0002\u0010Q\u001a\u00020\u001a\u0012\b\b\u0002\u0010R\u001a\u00020\u001a\u0012\b\b\u0002\u0010S\u001a\u00020\u001a\u0012\b\b\u0002\u0010T\u001a\u00020\u001a¢\u0006\u0004\bU\u0010VJ\u0007\u0010\u0095\u0001\u001a\u00020\"J\u0007\u0010\u0096\u0001\u001a\u00020\"J\u0007\u0010\u0097\u0001\u001a\u00020\"J\u0007\u0010\u0098\u0001\u001a\u00020\"J\n\u0010\u0099\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010\u009a\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010\u009b\u0001\u001a\u00020\u001aHÆ\u0003J\u0011\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0002\u0010]J\n\u0010\u009d\u0001\u001a\u00020\u001aHÆ\u0003J\n\u0010\u009e\u0001\u001a\u00020\u0017HÆ\u0003J\f\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\f\u0010 \u0001\u001a\u0004\u0018\u00010 HÆ\u0003J\n\u0010¡\u0001\u001a\u00020\"HÆ\u0003J\f\u0010¢\u0001\u001a\u0004\u0018\u00010$HÆ\u0003J\n\u0010£\u0001\u001a\u00020\u001aHÆ\u0003J\n\u0010¤\u0001\u001a\u00020\"HÆ\u0003J\n\u0010¥\u0001\u001a\u00020\u001aHÆ\u0003J\n\u0010¦\u0001\u001a\u00020)HÆ\u0003J\n\u0010§\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010¨\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010©\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010ª\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010«\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010¬\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010\u00ad\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010®\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010¯\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010°\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010±\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010²\u0001\u001a\u000206HÆ\u0003J\n\u0010³\u0001\u001a\u000206HÆ\u0003J\n\u0010´\u0001\u001a\u000206HÆ\u0003J\n\u0010µ\u0001\u001a\u000206HÆ\u0003J\n\u0010¶\u0001\u001a\u000206HÆ\u0003J\n\u0010·\u0001\u001a\u00020\u001aHÆ\u0003J\n\u0010¸\u0001\u001a\u00020\"HÆ\u0003J\n\u0010¹\u0001\u001a\u00020\"HÆ\u0003J\n\u0010º\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010»\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010¼\u0001\u001a\u00020\u001aHÆ\u0003J\f\u0010½\u0001\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\f\u0010¾\u0001\u001a\u0004\u0018\u00010CHÆ\u0003J\n\u0010¿\u0001\u001a\u00020\u001aHÆ\u0003J\n\u0010À\u0001\u001a\u00020\u001aHÆ\u0003J\n\u0010Á\u0001\u001a\u00020\u001aHÆ\u0003J\n\u0010Â\u0001\u001a\u00020)HÆ\u0003J\n\u0010Ã\u0001\u001a\u00020\u001aHÆ\u0003J\n\u0010Ä\u0001\u001a\u00020\u001aHÆ\u0003J\n\u0010Å\u0001\u001a\u00020\u001aHÆ\u0003J\n\u0010Æ\u0001\u001a\u00020\"HÆ\u0003J\n\u0010Ç\u0001\u001a\u00020\u001aHÆ\u0003J\n\u0010È\u0001\u001a\u00020\"HÆ\u0003J\n\u0010É\u0001\u001a\u00020\u001aHÆ\u0003J\n\u0010Ê\u0001\u001a\u00020\u001aHÆ\u0003J\n\u0010Ë\u0001\u001a\u00020\u001aHÆ\u0003J\n\u0010Ì\u0001\u001a\u00020\u001aHÆ\u0003J\n\u0010Í\u0001\u001a\u00020\u001aHÆ\u0003J\n\u0010Î\u0001\u001a\u00020\u001aHÆ\u0003J\n\u0010Ï\u0001\u001a\u00020\u001aHÆ\u0003JÂ\u0004\u0010Ð\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u00172\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020\u001a2\b\b\u0002\u0010&\u001a\u00020\"2\b\b\u0002\u0010'\u001a\u00020\u001a2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020\u00172\b\b\u0002\u0010+\u001a\u00020\u00172\b\b\u0002\u0010,\u001a\u00020\u00172\b\b\u0002\u0010-\u001a\u00020\u00172\b\b\u0002\u0010.\u001a\u00020\u00172\b\b\u0002\u0010/\u001a\u00020\u00172\b\b\u0002\u00100\u001a\u00020\u00172\b\b\u0002\u00101\u001a\u00020\u00172\b\b\u0002\u00102\u001a\u00020\u00172\b\b\u0002\u00103\u001a\u00020\u00172\b\b\u0002\u00104\u001a\u00020\u00172\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u0002062\b\b\u0002\u00108\u001a\u0002062\b\b\u0002\u00109\u001a\u0002062\b\b\u0002\u0010:\u001a\u0002062\b\b\u0002\u0010;\u001a\u00020\u001a2\b\b\u0002\u0010<\u001a\u00020\"2\b\b\u0002\u0010=\u001a\u00020\"2\b\b\u0002\u0010>\u001a\u00020\u00172\b\b\u0002\u0010?\u001a\u00020\u00172\b\b\u0002\u0010@\u001a\u00020\u001a2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010B\u001a\u0004\u0018\u00010C2\b\b\u0002\u0010D\u001a\u00020\u001a2\b\b\u0002\u0010E\u001a\u00020\u001a2\b\b\u0002\u0010F\u001a\u00020\u001a2\b\b\u0002\u0010G\u001a\u00020)2\b\b\u0002\u0010H\u001a\u00020\u001a2\b\b\u0002\u0010I\u001a\u00020\u001a2\b\b\u0002\u0010J\u001a\u00020\u001a2\b\b\u0002\u0010K\u001a\u00020\"2\b\b\u0002\u0010L\u001a\u00020\u001a2\b\b\u0002\u0010M\u001a\u00020\"2\b\b\u0002\u0010N\u001a\u00020\u001a2\b\b\u0002\u0010O\u001a\u00020\u001a2\b\b\u0002\u0010P\u001a\u00020\u001a2\b\b\u0002\u0010Q\u001a\u00020\u001a2\b\b\u0002\u0010R\u001a\u00020\u001a2\b\b\u0002\u0010S\u001a\u00020\u001a2\b\b\u0002\u0010T\u001a\u00020\u001aHÆ\u0001¢\u0006\u0003\u0010Ñ\u0001J\u0007\u0010Ò\u0001\u001a\u00020\u001aJ\u0016\u0010Ó\u0001\u001a\u00020\"2\n\u0010Ô\u0001\u001a\u0005\u0018\u00010Õ\u0001HÖ\u0003J\n\u0010Ö\u0001\u001a\u00020\u001aHÖ\u0001J\n\u0010×\u0001\u001a\u00020\u0017HÖ\u0001J\u001b\u0010Ø\u0001\u001a\u00030Ù\u00012\b\u0010Ú\u0001\u001a\u00030Û\u00012\u0007\u0010Ü\u0001\u001a\u00020\u001aR\u0014\u0010\u0016\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bW\u0010XR\u0014\u0010\u0018\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010XR\u0014\u0010\u0019\u001a\u00020\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001aX\u0096\u0004¢\u0006\n\n\u0002\u0010^\u001a\u0004\b\\\u0010]R\u0014\u0010\u001c\u001a\u00020\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b_\u0010[R\u0014\u0010\u001d\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b`\u0010XR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\ba\u0010XR\u0016\u0010\u001f\u001a\u0004\u0018\u00010 X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010cR\u0014\u0010!\u001a\u00020\"X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bd\u0010eR\u0016\u0010#\u001a\u0004\u0018\u00010$X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bf\u0010gR\u0014\u0010%\u001a\u00020\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010[R\u0014\u0010&\u001a\u00020\"X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010eR\u0014\u0010'\u001a\u00020\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010[R\u0014\u0010(\u001a\u00020)X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bj\u0010kR\u0014\u0010*\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bl\u0010XR\u0014\u0010+\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bm\u0010XR\u0014\u0010,\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bn\u0010XR\u0014\u0010-\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bo\u0010XR\u0014\u0010.\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bp\u0010XR\u0014\u0010/\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bq\u0010XR\u0014\u00100\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\br\u0010XR\u0014\u00101\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bs\u0010XR\u0014\u00102\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bt\u0010XR\u0014\u00103\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010XR\u0014\u00104\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bv\u0010XR\u0014\u00105\u001a\u000206X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bw\u0010xR\u0014\u00107\u001a\u000206X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\by\u0010xR\u0014\u00108\u001a\u000206X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bz\u0010xR\u0014\u00109\u001a\u000206X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b{\u0010xR\u0014\u0010:\u001a\u000206X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b|\u0010xR\u0014\u0010;\u001a\u00020\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b}\u0010[R\u0014\u0010<\u001a\u00020\"X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010eR\u0014\u0010=\u001a\u00020\"X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010eR\u0014\u0010>\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b~\u0010XR\u0014\u0010?\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u007f\u0010XR\u0015\u0010@\u001a\u00020\u001aX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0080\u0001\u0010[R\u0017\u0010A\u001a\u0004\u0018\u00010\u0017X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0081\u0001\u0010XR\u0018\u0010B\u001a\u0004\u0018\u00010CX\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0015\u0010D\u001a\u00020\u001aX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0084\u0001\u0010[R\u0015\u0010E\u001a\u00020\u001aX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0085\u0001\u0010[R\u0015\u0010F\u001a\u00020\u001aX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0086\u0001\u0010[R\u0015\u0010G\u001a\u00020)X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0087\u0001\u0010kR\u0015\u0010H\u001a\u00020\u001aX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0088\u0001\u0010[R\u0015\u0010I\u001a\u00020\u001aX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0089\u0001\u0010[R\u0015\u0010J\u001a\u00020\u001aX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008a\u0001\u0010[R\u0015\u0010K\u001a\u00020\"X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008b\u0001\u0010eR\u0015\u0010L\u001a\u00020\u001aX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008c\u0001\u0010[R\u0015\u0010M\u001a\u00020\"X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008d\u0001\u0010eR\u0015\u0010N\u001a\u00020\u001aX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008e\u0001\u0010[R\u0015\u0010O\u001a\u00020\u001aX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008f\u0001\u0010[R\u0015\u0010P\u001a\u00020\u001aX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0090\u0001\u0010[R\u0015\u0010Q\u001a\u00020\u001aX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0091\u0001\u0010[R\u0015\u0010R\u001a\u00020\u001aX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0092\u0001\u0010[R\u0015\u0010S\u001a\u00020\u001aX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0093\u0001\u0010[R\u0015\u0010T\u001a\u00020\u001aX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0094\u0001\u0010[¨\u0006Ý\u0001"},
   d2 = {"Lcom/blueair/core/model/DeviceBlue40;", "Lcom/blueair/core/model/Device;", "Lcom/blueair/core/model/HasFanSpeed;", "Lcom/blueair/core/model/HasInfo;", "Lcom/blueair/core/model/HasBlueProvisionCalls;", "Lcom/blueair/core/model/HasSensorData;", "Lcom/blueair/core/model/HasBlueCloudFunctions;", "Lcom/blueair/core/model/HasChildLock;", "Lcom/blueair/core/model/HasBrightness;", "Lcom/blueair/core/model/HasStandBy;", "Lcom/blueair/core/model/HasG4NightMode;", "Lcom/blueair/core/model/HasScheduling;", "Lcom/blueair/core/model/HasSKU;", "Lcom/blueair/core/model/HasTimer;", "Lcom/blueair/core/model/HasMainMode;", "Lcom/blueair/core/model/HasCleanAirEta;", "Lcom/blueair/core/model/HasGestureRecognition;", "Lcom/blueair/core/model/HasDisplayMode;", "Lcom/blueair/core/model/HasWelcomeHome;", "Lcom/blueair/core/model/HasAirRefresh;", "Lcom/blueair/core/model/HasRoom;", "Lcom/blueair/core/model/HasSensorMode;", "uid", "", "name", "fanSpeed", "", "filterLife", "brightness", "autoModeText", "info", "deviceUuid", "Lcom/blueair/core/model/DeviceUuid;", "hasFinishedOnboarding", "", "latestSensorDatapoint", "Lcom/blueair/core/model/IndoorDatapoint;", "lastSelectedSensorTypeIndex", "isChildLockOn", "connectivityStatusIndex", "lastConnectivityInMillis", "", "mac", "mcuFirmware", "wifiFirmware", "hardware", "timeZone", "serial", "purchaseDate", "dealerName", "dealerCountry", "filterType", "filterTrigger", "pm1Ranges", "", "pm10Ranges", "pm25Ranges", "vocRanges", "hchoRanges", "updateProgress", "isStandByOn", "isG4NightModeOn", "g4NightModeFilterTrigger", "modelName", "typeIndex", "sku", "welcomeHome", "Lcom/blueair/core/model/WelcomeHomeLocation;", "timerStatus", "timerDuration", "timerLeftTime", "timerLeftTimeUpdateTime", "mainMode", "apSubMode", "cleanAirEta", "hoverEnabled", "panelDisplayMode", "airRefreshEnabled", "airRefreshStatus", "airRefreshDuration", "airRefreshTimeStamp", "airRefreshStartTimeStamp", "airRefreshEndTimeStamp", "roomType", "sensorMode", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/DeviceUuid;ZLcom/blueair/core/model/IndoorDatapoint;IZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[D[D[D[D[DIZZLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/blueair/core/model/WelcomeHomeLocation;IIIJIIIZIZIIIIIII)V", "getUid", "()Ljava/lang/String;", "getName", "getFanSpeed", "()I", "getFilterLife", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBrightness", "getAutoModeText", "getInfo", "getDeviceUuid", "()Lcom/blueair/core/model/DeviceUuid;", "getHasFinishedOnboarding", "()Z", "getLatestSensorDatapoint", "()Lcom/blueair/core/model/IndoorDatapoint;", "getLastSelectedSensorTypeIndex", "getConnectivityStatusIndex", "getLastConnectivityInMillis", "()J", "getMac", "getMcuFirmware", "getWifiFirmware", "getHardware", "getTimeZone", "getSerial", "getPurchaseDate", "getDealerName", "getDealerCountry", "getFilterType", "getFilterTrigger", "getPm1Ranges", "()[D", "getPm10Ranges", "getPm25Ranges", "getVocRanges", "getHchoRanges", "getUpdateProgress", "getG4NightModeFilterTrigger", "getModelName", "getTypeIndex", "getSku", "getWelcomeHome", "()Lcom/blueair/core/model/WelcomeHomeLocation;", "getTimerStatus", "getTimerDuration", "getTimerLeftTime", "getTimerLeftTimeUpdateTime", "getMainMode", "getApSubMode", "getCleanAirEta", "getHoverEnabled", "getPanelDisplayMode", "getAirRefreshEnabled", "getAirRefreshStatus", "getAirRefreshDuration", "getAirRefreshTimeStamp", "getAirRefreshStartTimeStamp", "getAirRefreshEndTimeStamp", "getRoomType", "getSensorMode", "isLargeSize", "isMediumSize", "isSmallSize", "useTVOCForAqi", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component50", "component51", "component52", "component53", "component54", "component55", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/DeviceUuid;ZLcom/blueair/core/model/IndoorDatapoint;IZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[D[D[D[D[DIZZLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/blueair/core/model/WelcomeHomeLocation;IIIJIIIZIZIIIIIII)Lcom/blueair/core/model/DeviceBlue40;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceBlue40 implements Device, HasFanSpeed, HasInfo, HasBlueProvisionCalls, HasSensorData, HasBlueCloudFunctions, HasChildLock, HasBrightness, HasStandBy, HasG4NightMode, HasScheduling, HasSKU, HasTimer, HasMainMode, HasCleanAirEta, HasGestureRecognition, HasDisplayMode, HasWelcomeHome, HasAirRefresh, HasRoom, HasSensorMode {
   public static final Parcelable.Creator CREATOR = new Creator();
   private final int airRefreshDuration;
   private final boolean airRefreshEnabled;
   private final int airRefreshEndTimeStamp;
   private final int airRefreshStartTimeStamp;
   private final int airRefreshStatus;
   private final int airRefreshTimeStamp;
   private final int apSubMode;
   private final String autoModeText;
   private final int brightness;
   private final int cleanAirEta;
   private final int connectivityStatusIndex;
   private final String dealerCountry;
   private final String dealerName;
   private final DeviceUuid deviceUuid;
   private final int fanSpeed;
   private final Integer filterLife;
   private final String filterTrigger;
   private final String filterType;
   private final String g4NightModeFilterTrigger;
   private final String hardware;
   private final boolean hasFinishedOnboarding;
   private final double[] hchoRanges;
   private final boolean hoverEnabled;
   private final String info;
   private final boolean isChildLockOn;
   private final boolean isG4NightModeOn;
   private final boolean isStandByOn;
   private final long lastConnectivityInMillis;
   private final int lastSelectedSensorTypeIndex;
   private final IndoorDatapoint latestSensorDatapoint;
   private final String mac;
   private final int mainMode;
   private final String mcuFirmware;
   private final String modelName;
   private final String name;
   private final int panelDisplayMode;
   private final double[] pm10Ranges;
   private final double[] pm1Ranges;
   private final double[] pm25Ranges;
   private final String purchaseDate;
   private final int roomType;
   private final int sensorMode;
   private final String serial;
   private final String sku;
   private final String timeZone;
   private final int timerDuration;
   private final int timerLeftTime;
   private final long timerLeftTimeUpdateTime;
   private final int timerStatus;
   private final int typeIndex;
   private final String uid;
   private final int updateProgress;
   private final double[] vocRanges;
   private final WelcomeHomeLocation welcomeHome;
   private final String wifiFirmware;

   public DeviceBlue40(String var1, String var2, int var3, Integer var4, int var5, String var6, String var7, DeviceUuid var8, boolean var9, IndoorDatapoint var10, int var11, boolean var12, int var13, long var14, String var16, String var17, String var18, String var19, String var20, String var21, String var22, String var23, String var24, String var25, String var26, double[] var27, double[] var28, double[] var29, double[] var30, double[] var31, int var32, boolean var33, boolean var34, String var35, String var36, int var37, String var38, WelcomeHomeLocation var39, int var40, int var41, int var42, long var43, int var45, int var46, int var47, boolean var48, int var49, boolean var50, int var51, int var52, int var53, int var54, int var55, int var56, int var57) {
      Intrinsics.checkNotNullParameter(var1, "uid");
      Intrinsics.checkNotNullParameter(var2, "name");
      Intrinsics.checkNotNullParameter(var6, "autoModeText");
      Intrinsics.checkNotNullParameter(var16, "mac");
      Intrinsics.checkNotNullParameter(var17, "mcuFirmware");
      Intrinsics.checkNotNullParameter(var18, "wifiFirmware");
      Intrinsics.checkNotNullParameter(var19, "hardware");
      Intrinsics.checkNotNullParameter(var20, "timeZone");
      Intrinsics.checkNotNullParameter(var21, "serial");
      Intrinsics.checkNotNullParameter(var22, "purchaseDate");
      Intrinsics.checkNotNullParameter(var23, "dealerName");
      Intrinsics.checkNotNullParameter(var24, "dealerCountry");
      Intrinsics.checkNotNullParameter(var25, "filterType");
      Intrinsics.checkNotNullParameter(var26, "filterTrigger");
      Intrinsics.checkNotNullParameter(var27, "pm1Ranges");
      Intrinsics.checkNotNullParameter(var28, "pm10Ranges");
      Intrinsics.checkNotNullParameter(var29, "pm25Ranges");
      Intrinsics.checkNotNullParameter(var30, "vocRanges");
      Intrinsics.checkNotNullParameter(var31, "hchoRanges");
      Intrinsics.checkNotNullParameter(var35, "g4NightModeFilterTrigger");
      Intrinsics.checkNotNullParameter(var36, "modelName");
      super();
      this.uid = var1;
      this.name = var2;
      this.fanSpeed = var3;
      this.filterLife = var4;
      this.brightness = var5;
      this.autoModeText = var6;
      this.info = var7;
      this.deviceUuid = var8;
      this.hasFinishedOnboarding = var9;
      this.latestSensorDatapoint = var10;
      this.lastSelectedSensorTypeIndex = var11;
      this.isChildLockOn = var12;
      this.connectivityStatusIndex = var13;
      this.lastConnectivityInMillis = var14;
      this.mac = var16;
      this.mcuFirmware = var17;
      this.wifiFirmware = var18;
      this.hardware = var19;
      this.timeZone = var20;
      this.serial = var21;
      this.purchaseDate = var22;
      this.dealerName = var23;
      this.dealerCountry = var24;
      this.filterType = var25;
      this.filterTrigger = var26;
      this.pm1Ranges = var27;
      this.pm10Ranges = var28;
      this.pm25Ranges = var29;
      this.vocRanges = var30;
      this.hchoRanges = var31;
      this.updateProgress = var32;
      this.isStandByOn = var33;
      this.isG4NightModeOn = var34;
      this.g4NightModeFilterTrigger = var35;
      this.modelName = var36;
      this.typeIndex = var37;
      this.sku = var38;
      this.welcomeHome = var39;
      this.timerStatus = var40;
      this.timerDuration = var41;
      this.timerLeftTime = var42;
      this.timerLeftTimeUpdateTime = var43;
      this.mainMode = var45;
      this.apSubMode = var46;
      this.cleanAirEta = var47;
      this.hoverEnabled = var48;
      this.panelDisplayMode = var49;
      this.airRefreshEnabled = var50;
      this.airRefreshStatus = var51;
      this.airRefreshDuration = var52;
      this.airRefreshTimeStamp = var53;
      this.airRefreshStartTimeStamp = var54;
      this.airRefreshEndTimeStamp = var55;
      this.roomType = var56;
      this.sensorMode = var57;
   }

   // $FF: synthetic method
   public DeviceBlue40(String var1, String var2, int var3, Integer var4, int var5, String var6, String var7, DeviceUuid var8, boolean var9, IndoorDatapoint var10, int var11, boolean var12, int var13, long var14, String var16, String var17, String var18, String var19, String var20, String var21, String var22, String var23, String var24, String var25, String var26, double[] var27, double[] var28, double[] var29, double[] var30, double[] var31, int var32, boolean var33, boolean var34, String var35, String var36, int var37, String var38, WelcomeHomeLocation var39, int var40, int var41, int var42, long var43, int var45, int var46, int var47, boolean var48, int var49, boolean var50, int var51, int var52, int var53, int var54, int var55, int var56, int var57, int var58, int var59, DefaultConstructorMarker var60) {
      if ((var58 & 2) != 0) {
         var2 = "Pairing…";
      }

      if ((var58 & 4) != 0) {
         var3 = 0;
      }

      if ((var58 & 8) != 0) {
         var4 = null;
      }

      if ((var58 & 16) != 0) {
         var5 = 0;
      }

      String var63 = "";
      if ((var58 & 32) != 0) {
         var6 = "";
      }

      if ((var58 & 64) != 0) {
         var7 = null;
      }

      if ((var58 & 128) != 0) {
         var8 = null;
      }

      if ((var58 & 256) != 0) {
         var9 = false;
      }

      if ((var58 & 512) != 0) {
         var10 = null;
      }

      if ((var58 & 1024) != 0) {
         var11 = 0;
      }

      if ((var58 & 2048) != 0) {
         var12 = false;
      }

      if ((var58 & 4096) != 0) {
         var13 = ConnectivityStatus.ONLINE.ordinal();
      }

      long var61 = 0L;
      if ((var58 & 8192) != 0) {
         var14 = 0L;
      }

      if ((var58 & 16384) != 0) {
         var16 = "";
      }

      if ((var58 & '耀') != 0) {
         var17 = "";
      }

      if ((var58 & 65536) != 0) {
         var18 = "";
      }

      if ((var58 & 131072) != 0) {
         var19 = "";
      }

      if ((var58 & 262144) != 0) {
         var20 = "";
      }

      if ((var58 & 524288) != 0) {
         var21 = "";
      }

      if ((var58 & 1048576) != 0) {
         var22 = "";
      }

      if ((var58 & 2097152) != 0) {
         var23 = "";
      }

      if ((var58 & 4194304) != 0) {
         var24 = "";
      }

      if ((var58 & 8388608) != 0) {
         var25 = "";
      }

      if ((var58 & 16777216) != 0) {
         var26 = "";
      }

      if ((var58 & 33554432) != 0) {
         var27 = new double[0];
      }

      if ((var58 & 67108864) != 0) {
         var28 = new double[0];
      }

      if ((var58 & 134217728) != 0) {
         var29 = new double[0];
      }

      if ((var58 & 268435456) != 0) {
         var30 = new double[0];
      }

      if ((var58 & 536870912) != 0) {
         var31 = new double[0];
      }

      if ((var58 & 1073741824) != 0) {
         var32 = 0;
      }

      if ((var58 & Integer.MIN_VALUE) != 0) {
         var33 = false;
      }

      if ((var59 & 1) != 0) {
         var34 = false;
      }

      if ((var59 & 2) != 0) {
         var35 = "";
      }

      if ((var59 & 4) != 0) {
         var36 = var63;
      }

      if ((var59 & 8) != 0) {
         var37 = DeviceType.Blue40.INSTANCE.getIndex();
      }

      if ((var59 & 16) != 0) {
         var38 = null;
      }

      if ((var59 & 32) != 0) {
         var39 = null;
      }

      if ((var59 & 64) != 0) {
         var40 = 0;
      }

      if ((var59 & 128) != 0) {
         var41 = 0;
      }

      if ((var59 & 256) != 0) {
         var42 = 0;
      }

      if ((var59 & 512) != 0) {
         var43 = var61;
      }

      if ((var59 & 1024) != 0) {
         var45 = 0;
      }

      if ((var59 & 2048) != 0) {
         var46 = 2;
      }

      if ((var59 & 4096) != 0) {
         var47 = 0;
      }

      if ((var59 & 8192) != 0) {
         var48 = true;
      }

      if ((var59 & 16384) != 0) {
         var49 = 0;
      }

      if ((var59 & '耀') != 0) {
         var50 = true;
      }

      if ((var59 & 65536) != 0) {
         var51 = 0;
      }

      if ((var59 & 131072) != 0) {
         var52 = 0;
      }

      if ((var59 & 262144) != 0) {
         var53 = 0;
      }

      if ((var59 & 524288) != 0) {
         var54 = 0;
      }

      if ((var59 & 1048576) != 0) {
         var55 = 0;
      }

      if ((var59 & 2097152) != 0) {
         var56 = 0;
      }

      if ((var59 & 4194304) != 0) {
         var57 = 1;
      }

      this(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26, var27, var28, var29, var30, var31, var32, var33, var34, var35, var36, var37, var38, var39, var40, var41, var42, var43, var45, var46, var47, var48, var49, var50, var51, var52, var53, var54, var55, var56, var57);
   }

   // $FF: synthetic method
   public static DeviceBlue40 copy$default(DeviceBlue40 var0, String var1, String var2, int var3, Integer var4, int var5, String var6, String var7, DeviceUuid var8, boolean var9, IndoorDatapoint var10, int var11, boolean var12, int var13, long var14, String var16, String var17, String var18, String var19, String var20, String var21, String var22, String var23, String var24, String var25, String var26, double[] var27, double[] var28, double[] var29, double[] var30, double[] var31, int var32, boolean var33, boolean var34, String var35, String var36, int var37, String var38, WelcomeHomeLocation var39, int var40, int var41, int var42, long var43, int var45, int var46, int var47, boolean var48, int var49, boolean var50, int var51, int var52, int var53, int var54, int var55, int var56, int var57, int var58, int var59, Object var60) {
      if ((var58 & 1) != 0) {
         var1 = var0.uid;
      }

      if ((var58 & 2) != 0) {
         var2 = var0.name;
      }

      if ((var58 & 4) != 0) {
         var3 = var0.fanSpeed;
      }

      if ((var58 & 8) != 0) {
         var4 = var0.filterLife;
      }

      if ((var58 & 16) != 0) {
         var5 = var0.brightness;
      }

      if ((var58 & 32) != 0) {
         var6 = var0.autoModeText;
      }

      if ((var58 & 64) != 0) {
         var7 = var0.info;
      }

      if ((var58 & 128) != 0) {
         var8 = var0.deviceUuid;
      }

      if ((var58 & 256) != 0) {
         var9 = var0.hasFinishedOnboarding;
      }

      if ((var58 & 512) != 0) {
         var10 = var0.latestSensorDatapoint;
      }

      if ((var58 & 1024) != 0) {
         var11 = var0.lastSelectedSensorTypeIndex;
      }

      if ((var58 & 2048) != 0) {
         var12 = var0.isChildLockOn;
      }

      if ((var58 & 4096) != 0) {
         var13 = var0.connectivityStatusIndex;
      }

      if ((var58 & 8192) != 0) {
         var14 = var0.lastConnectivityInMillis;
      }

      if ((var58 & 16384) != 0) {
         var16 = var0.mac;
      }

      if ((var58 & '耀') != 0) {
         var17 = var0.mcuFirmware;
      }

      if ((var58 & 65536) != 0) {
         var18 = var0.wifiFirmware;
      }

      if ((var58 & 131072) != 0) {
         var19 = var0.hardware;
      }

      if ((var58 & 262144) != 0) {
         var20 = var0.timeZone;
      }

      if ((var58 & 524288) != 0) {
         var21 = var0.serial;
      }

      if ((var58 & 1048576) != 0) {
         var22 = var0.purchaseDate;
      }

      if ((var58 & 2097152) != 0) {
         var23 = var0.dealerName;
      }

      if ((var58 & 4194304) != 0) {
         var24 = var0.dealerCountry;
      }

      if ((var58 & 8388608) != 0) {
         var25 = var0.filterType;
      }

      if ((var58 & 16777216) != 0) {
         var26 = var0.filterTrigger;
      }

      if ((var58 & 33554432) != 0) {
         var27 = var0.pm1Ranges;
      }

      if ((var58 & 67108864) != 0) {
         var28 = var0.pm10Ranges;
      }

      if ((var58 & 134217728) != 0) {
         var29 = var0.pm25Ranges;
      }

      if ((var58 & 268435456) != 0) {
         var30 = var0.vocRanges;
      }

      if ((var58 & 536870912) != 0) {
         var31 = var0.hchoRanges;
      }

      if ((var58 & 1073741824) != 0) {
         var32 = var0.updateProgress;
      }

      if ((var58 & Integer.MIN_VALUE) != 0) {
         var33 = var0.isStandByOn;
      }

      if ((var59 & 1) != 0) {
         var34 = var0.isG4NightModeOn;
      }

      if ((var59 & 2) != 0) {
         var35 = var0.g4NightModeFilterTrigger;
      }

      if ((var59 & 4) != 0) {
         var36 = var0.modelName;
      }

      if ((var59 & 8) != 0) {
         var37 = var0.typeIndex;
      }

      if ((var59 & 16) != 0) {
         var38 = var0.sku;
      }

      if ((var59 & 32) != 0) {
         var39 = var0.welcomeHome;
      }

      if ((var59 & 64) != 0) {
         var40 = var0.timerStatus;
      }

      if ((var59 & 128) != 0) {
         var41 = var0.timerDuration;
      }

      if ((var59 & 256) != 0) {
         var42 = var0.timerLeftTime;
      }

      if ((var59 & 512) != 0) {
         var43 = var0.timerLeftTimeUpdateTime;
      }

      if ((var59 & 1024) != 0) {
         var45 = var0.mainMode;
      }

      if ((var59 & 2048) != 0) {
         var46 = var0.apSubMode;
      }

      if ((var59 & 4096) != 0) {
         var47 = var0.cleanAirEta;
      }

      if ((var59 & 8192) != 0) {
         var48 = var0.hoverEnabled;
      }

      if ((var59 & 16384) != 0) {
         var49 = var0.panelDisplayMode;
      }

      if ((var59 & '耀') != 0) {
         var50 = var0.airRefreshEnabled;
      }

      if ((var59 & 65536) != 0) {
         var51 = var0.airRefreshStatus;
      }

      if ((var59 & 131072) != 0) {
         var52 = var0.airRefreshDuration;
      }

      if ((var59 & 262144) != 0) {
         var53 = var0.airRefreshTimeStamp;
      }

      if ((var59 & 524288) != 0) {
         var54 = var0.airRefreshStartTimeStamp;
      }

      if ((var59 & 1048576) != 0) {
         var55 = var0.airRefreshEndTimeStamp;
      }

      if ((var59 & 2097152) != 0) {
         var56 = var0.roomType;
      }

      if ((var59 & 4194304) != 0) {
         var57 = var0.sensorMode;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26, var27, var28, var29, var30, var31, var32, var33, var34, var35, var36, var37, var38, var39, var40, var41, var42, var43, var45, var46, var47, var48, var49, var50, var51, var52, var53, var54, var55, var56, var57);
   }

   public double[] airRatingsFor(SensorType var1) {
      return HasSensorData$_CC.$default$airRatingsFor(this, var1);
   }

   public AirRefreshState airRefreshStatus() {
      return HasAirRefresh$_CC.$default$airRefreshStatus(this);
   }

   public ApSubMode apSubMode() {
      return HasMainMode$_CC.$default$apSubMode(this);
   }

   public IndoorAirRatingRanges.IndoorAirRating aqiFor(double var1, SensorType var3) {
      return HasSensorData$_CC.$default$aqiFor(this, var1, var3);
   }

   public IndoorAirRatingRanges.IndoorAirRating aqiFor(SensorType var1) {
      return HasSensorData$_CC.$default$aqiFor(this, var1);
   }

   public final String component1() {
      return this.uid;
   }

   public final IndoorDatapoint component10() {
      return this.latestSensorDatapoint;
   }

   public final int component11() {
      return this.lastSelectedSensorTypeIndex;
   }

   public final boolean component12() {
      return this.isChildLockOn;
   }

   public final int component13() {
      return this.connectivityStatusIndex;
   }

   public final long component14() {
      return this.lastConnectivityInMillis;
   }

   public final String component15() {
      return this.mac;
   }

   public final String component16() {
      return this.mcuFirmware;
   }

   public final String component17() {
      return this.wifiFirmware;
   }

   public final String component18() {
      return this.hardware;
   }

   public final String component19() {
      return this.timeZone;
   }

   public final String component2() {
      return this.name;
   }

   public final String component20() {
      return this.serial;
   }

   public final String component21() {
      return this.purchaseDate;
   }

   public final String component22() {
      return this.dealerName;
   }

   public final String component23() {
      return this.dealerCountry;
   }

   public final String component24() {
      return this.filterType;
   }

   public final String component25() {
      return this.filterTrigger;
   }

   public final double[] component26() {
      return this.pm1Ranges;
   }

   public final double[] component27() {
      return this.pm10Ranges;
   }

   public final double[] component28() {
      return this.pm25Ranges;
   }

   public final double[] component29() {
      return this.vocRanges;
   }

   public final int component3() {
      return this.fanSpeed;
   }

   public final double[] component30() {
      return this.hchoRanges;
   }

   public final int component31() {
      return this.updateProgress;
   }

   public final boolean component32() {
      return this.isStandByOn;
   }

   public final boolean component33() {
      return this.isG4NightModeOn;
   }

   public final String component34() {
      return this.g4NightModeFilterTrigger;
   }

   public final String component35() {
      return this.modelName;
   }

   public final int component36() {
      return this.typeIndex;
   }

   public final String component37() {
      return this.sku;
   }

   public final WelcomeHomeLocation component38() {
      return this.welcomeHome;
   }

   public final int component39() {
      return this.timerStatus;
   }

   public final Integer component4() {
      return this.filterLife;
   }

   public final int component40() {
      return this.timerDuration;
   }

   public final int component41() {
      return this.timerLeftTime;
   }

   public final long component42() {
      return this.timerLeftTimeUpdateTime;
   }

   public final int component43() {
      return this.mainMode;
   }

   public final int component44() {
      return this.apSubMode;
   }

   public final int component45() {
      return this.cleanAirEta;
   }

   public final boolean component46() {
      return this.hoverEnabled;
   }

   public final int component47() {
      return this.panelDisplayMode;
   }

   public final boolean component48() {
      return this.airRefreshEnabled;
   }

   public final int component49() {
      return this.airRefreshStatus;
   }

   public final int component5() {
      return this.brightness;
   }

   public final int component50() {
      return this.airRefreshDuration;
   }

   public final int component51() {
      return this.airRefreshTimeStamp;
   }

   public final int component52() {
      return this.airRefreshStartTimeStamp;
   }

   public final int component53() {
      return this.airRefreshEndTimeStamp;
   }

   public final int component54() {
      return this.roomType;
   }

   public final int component55() {
      return this.sensorMode;
   }

   public final String component6() {
      return this.autoModeText;
   }

   public final String component7() {
      return this.info;
   }

   public final DeviceUuid component8() {
      return this.deviceUuid;
   }

   public final boolean component9() {
      return this.hasFinishedOnboarding;
   }

   public final DeviceBlue40 copy(String var1, String var2, int var3, Integer var4, int var5, String var6, String var7, DeviceUuid var8, boolean var9, IndoorDatapoint var10, int var11, boolean var12, int var13, long var14, String var16, String var17, String var18, String var19, String var20, String var21, String var22, String var23, String var24, String var25, String var26, double[] var27, double[] var28, double[] var29, double[] var30, double[] var31, int var32, boolean var33, boolean var34, String var35, String var36, int var37, String var38, WelcomeHomeLocation var39, int var40, int var41, int var42, long var43, int var45, int var46, int var47, boolean var48, int var49, boolean var50, int var51, int var52, int var53, int var54, int var55, int var56, int var57) {
      Intrinsics.checkNotNullParameter(var1, "uid");
      Intrinsics.checkNotNullParameter(var2, "name");
      Intrinsics.checkNotNullParameter(var6, "autoModeText");
      Intrinsics.checkNotNullParameter(var16, "mac");
      Intrinsics.checkNotNullParameter(var17, "mcuFirmware");
      Intrinsics.checkNotNullParameter(var18, "wifiFirmware");
      Intrinsics.checkNotNullParameter(var19, "hardware");
      Intrinsics.checkNotNullParameter(var20, "timeZone");
      Intrinsics.checkNotNullParameter(var21, "serial");
      Intrinsics.checkNotNullParameter(var22, "purchaseDate");
      Intrinsics.checkNotNullParameter(var23, "dealerName");
      Intrinsics.checkNotNullParameter(var24, "dealerCountry");
      Intrinsics.checkNotNullParameter(var25, "filterType");
      Intrinsics.checkNotNullParameter(var26, "filterTrigger");
      Intrinsics.checkNotNullParameter(var27, "pm1Ranges");
      Intrinsics.checkNotNullParameter(var28, "pm10Ranges");
      Intrinsics.checkNotNullParameter(var29, "pm25Ranges");
      Intrinsics.checkNotNullParameter(var30, "vocRanges");
      Intrinsics.checkNotNullParameter(var31, "hchoRanges");
      Intrinsics.checkNotNullParameter(var35, "g4NightModeFilterTrigger");
      Intrinsics.checkNotNullParameter(var36, "modelName");
      return new DeviceBlue40(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26, var27, var28, var29, var30, var31, var32, var33, var34, var35, var36, var37, var38, var39, var40, var41, var42, var43, var45, var46, var47, var48, var49, var50, var51, var52, var53, var54, var55, var56, var57);
   }

   public final int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DeviceBlue40)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.uid, var1.uid)) {
            return false;
         } else if (!Intrinsics.areEqual(this.name, var1.name)) {
            return false;
         } else if (this.fanSpeed != var1.fanSpeed) {
            return false;
         } else if (!Intrinsics.areEqual(this.filterLife, var1.filterLife)) {
            return false;
         } else if (this.brightness != var1.brightness) {
            return false;
         } else if (!Intrinsics.areEqual(this.autoModeText, var1.autoModeText)) {
            return false;
         } else if (!Intrinsics.areEqual(this.info, var1.info)) {
            return false;
         } else if (!Intrinsics.areEqual(this.deviceUuid, var1.deviceUuid)) {
            return false;
         } else if (this.hasFinishedOnboarding != var1.hasFinishedOnboarding) {
            return false;
         } else if (!Intrinsics.areEqual(this.latestSensorDatapoint, var1.latestSensorDatapoint)) {
            return false;
         } else if (this.lastSelectedSensorTypeIndex != var1.lastSelectedSensorTypeIndex) {
            return false;
         } else if (this.isChildLockOn != var1.isChildLockOn) {
            return false;
         } else if (this.connectivityStatusIndex != var1.connectivityStatusIndex) {
            return false;
         } else if (this.lastConnectivityInMillis != var1.lastConnectivityInMillis) {
            return false;
         } else if (!Intrinsics.areEqual(this.mac, var1.mac)) {
            return false;
         } else if (!Intrinsics.areEqual(this.mcuFirmware, var1.mcuFirmware)) {
            return false;
         } else if (!Intrinsics.areEqual(this.wifiFirmware, var1.wifiFirmware)) {
            return false;
         } else if (!Intrinsics.areEqual(this.hardware, var1.hardware)) {
            return false;
         } else if (!Intrinsics.areEqual(this.timeZone, var1.timeZone)) {
            return false;
         } else if (!Intrinsics.areEqual(this.serial, var1.serial)) {
            return false;
         } else if (!Intrinsics.areEqual(this.purchaseDate, var1.purchaseDate)) {
            return false;
         } else if (!Intrinsics.areEqual(this.dealerName, var1.dealerName)) {
            return false;
         } else if (!Intrinsics.areEqual(this.dealerCountry, var1.dealerCountry)) {
            return false;
         } else if (!Intrinsics.areEqual(this.filterType, var1.filterType)) {
            return false;
         } else if (!Intrinsics.areEqual(this.filterTrigger, var1.filterTrigger)) {
            return false;
         } else if (!Intrinsics.areEqual(this.pm1Ranges, var1.pm1Ranges)) {
            return false;
         } else if (!Intrinsics.areEqual(this.pm10Ranges, var1.pm10Ranges)) {
            return false;
         } else if (!Intrinsics.areEqual(this.pm25Ranges, var1.pm25Ranges)) {
            return false;
         } else if (!Intrinsics.areEqual(this.vocRanges, var1.vocRanges)) {
            return false;
         } else if (!Intrinsics.areEqual(this.hchoRanges, var1.hchoRanges)) {
            return false;
         } else if (this.updateProgress != var1.updateProgress) {
            return false;
         } else if (this.isStandByOn != var1.isStandByOn) {
            return false;
         } else if (this.isG4NightModeOn != var1.isG4NightModeOn) {
            return false;
         } else if (!Intrinsics.areEqual(this.g4NightModeFilterTrigger, var1.g4NightModeFilterTrigger)) {
            return false;
         } else if (!Intrinsics.areEqual(this.modelName, var1.modelName)) {
            return false;
         } else if (this.typeIndex != var1.typeIndex) {
            return false;
         } else if (!Intrinsics.areEqual(this.sku, var1.sku)) {
            return false;
         } else if (!Intrinsics.areEqual(this.welcomeHome, var1.welcomeHome)) {
            return false;
         } else if (this.timerStatus != var1.timerStatus) {
            return false;
         } else if (this.timerDuration != var1.timerDuration) {
            return false;
         } else if (this.timerLeftTime != var1.timerLeftTime) {
            return false;
         } else if (this.timerLeftTimeUpdateTime != var1.timerLeftTimeUpdateTime) {
            return false;
         } else if (this.mainMode != var1.mainMode) {
            return false;
         } else if (this.apSubMode != var1.apSubMode) {
            return false;
         } else if (this.cleanAirEta != var1.cleanAirEta) {
            return false;
         } else if (this.hoverEnabled != var1.hoverEnabled) {
            return false;
         } else if (this.panelDisplayMode != var1.panelDisplayMode) {
            return false;
         } else if (this.airRefreshEnabled != var1.airRefreshEnabled) {
            return false;
         } else if (this.airRefreshStatus != var1.airRefreshStatus) {
            return false;
         } else if (this.airRefreshDuration != var1.airRefreshDuration) {
            return false;
         } else if (this.airRefreshTimeStamp != var1.airRefreshTimeStamp) {
            return false;
         } else if (this.airRefreshStartTimeStamp != var1.airRefreshStartTimeStamp) {
            return false;
         } else if (this.airRefreshEndTimeStamp != var1.airRefreshEndTimeStamp) {
            return false;
         } else if (this.roomType != var1.roomType) {
            return false;
         } else {
            return this.sensorMode == var1.sensorMode;
         }
      }
   }

   public IndoorAirRatingRanges getAirRatingRanges() {
      return HasSensorData$_CC.$default$getAirRatingRanges(this);
   }

   public int getAirRefreshDuration() {
      return this.airRefreshDuration;
   }

   public boolean getAirRefreshEnabled() {
      return this.airRefreshEnabled;
   }

   public int getAirRefreshEndTimeStamp() {
      return this.airRefreshEndTimeStamp;
   }

   public int getAirRefreshLeftSeconds(long var1) {
      return HasAirRefresh$_CC.$default$getAirRefreshLeftSeconds(this, var1);
   }

   public int getAirRefreshStartTimeStamp() {
      return this.airRefreshStartTimeStamp;
   }

   public int getAirRefreshStatus() {
      return this.airRefreshStatus;
   }

   public int getAirRefreshTimeStamp() {
      return this.airRefreshTimeStamp;
   }

   public int getApSubMode() {
      return this.apSubMode;
   }

   public AutoMode getAutoMode() {
      return HasFanSpeed$_CC.$default$getAutoMode(this);
   }

   public String getAutoModeText() {
      return this.autoModeText;
   }

   public int getBrightness() {
      return this.brightness;
   }

   public Brightness getBrightnessEnum() {
      return HasBrightness$_CC.$default$getBrightnessEnum(this);
   }

   public int getCleanAirEta() {
      return this.cleanAirEta;
   }

   public ConnectivityStatus getConnectivityStatus() {
      return Device$_CC.$default$getConnectivityStatus(this);
   }

   public int getConnectivityStatusIndex() {
      return this.connectivityStatusIndex;
   }

   public String getDealerCountry() {
      return this.dealerCountry;
   }

   public String getDealerName() {
      return this.dealerName;
   }

   public DeviceUuid getDeviceUuid() {
      return this.deviceUuid;
   }

   public int getFanSpeed() {
      return this.fanSpeed;
   }

   public FanSpeedEnum getFanSpeedEnum() {
      return HasFanSpeed$_CC.$default$getFanSpeedEnum(this);
   }

   public Filter getFilter() {
      return HasFanSpeed$_CC.$default$getFilter(this);
   }

   public Integer getFilterLife() {
      return this.filterLife;
   }

   public String getFilterTrigger() {
      return this.filterTrigger;
   }

   public String getFilterType() {
      return this.filterType;
   }

   public String getG4NightModeFilterTrigger() {
      return this.g4NightModeFilterTrigger;
   }

   public FilterTrigger getG4NightModeTrigger() {
      return HasG4NightMode$_CC.$default$getG4NightModeTrigger(this);
   }

   public String getHardware() {
      return this.hardware;
   }

   public boolean getHasFinishedOnboarding() {
      return this.hasFinishedOnboarding;
   }

   public boolean getHasGear0() {
      return HasFanSpeed$_CC.$default$getHasGear0(this);
   }

   public boolean getHasGear4() {
      return HasFanSpeed$_CC.$default$getHasGear4(this);
   }

   public double[] getHchoRanges() {
      return this.hchoRanges;
   }

   public boolean getHoverEnabled() {
      return this.hoverEnabled;
   }

   public String getInfo() {
      return this.info;
   }

   public long getLastConnectivityInMillis() {
      return this.lastConnectivityInMillis;
   }

   public SensorType getLastSelectedSensorType() {
      return HasSensorData$_CC.$default$getLastSelectedSensorType(this);
   }

   public int getLastSelectedSensorTypeIndex() {
      return this.lastSelectedSensorTypeIndex;
   }

   public IndoorDatapoint getLatestSensorDatapoint() {
      return this.latestSensorDatapoint;
   }

   public int getLeftSeconds() {
      return HasTimer$_CC.$default$getLeftSeconds(this);
   }

   public String getMac() {
      return this.mac;
   }

   public int getMainMode() {
      return this.mainMode;
   }

   public String getMcuFirmware() {
      return this.mcuFirmware;
   }

   public String getModelName() {
      return this.modelName;
   }

   public String getName() {
      return this.name;
   }

   public int getPanelDisplayMode() {
      return this.panelDisplayMode;
   }

   public double[] getPm10Ranges() {
      return this.pm10Ranges;
   }

   public double[] getPm1Ranges() {
      return this.pm1Ranges;
   }

   public double[] getPm25Ranges() {
      return this.pm25Ranges;
   }

   public String getPurchaseDate() {
      return this.purchaseDate;
   }

   public int getRealTimerLeftTime(long var1) {
      return HasTimer$_CC.$default$getRealTimerLeftTime(this, var1);
   }

   public int getRoomType() {
      return this.roomType;
   }

   public int getSensorMode() {
      return this.sensorMode;
   }

   public String getSerial() {
      return this.serial;
   }

   public String getSku() {
      return this.sku;
   }

   public String getTimeZone() {
      return this.timeZone;
   }

   public int getTimerDuration() {
      return this.timerDuration;
   }

   public int getTimerLeftTime() {
      return this.timerLeftTime;
   }

   public long getTimerLeftTimeUpdateTime() {
      return this.timerLeftTimeUpdateTime;
   }

   public int getTimerStatus() {
      return this.timerStatus;
   }

   public TimeZone getTimezone(Context var1) {
      return Device$_CC.$default$getTimezone(this, var1);
   }

   public FilterTrigger getTrigger() {
      return HasFanSpeed$_CC.$default$getTrigger(this);
   }

   public DeviceType getType() {
      return Device$_CC.$default$getType(this);
   }

   public int getTypeIndex() {
      return this.typeIndex;
   }

   public UiAutoMode getUiAutoMode() {
      return HasFanSpeed$_CC.$default$getUiAutoMode(this);
   }

   public UiG4NightMode getUiG4NightMode() {
      return HasG4NightMode$_CC.$default$getUiG4NightMode(this);
   }

   public String getUid() {
      return this.uid;
   }

   public int getUpdateProgress() {
      return this.updateProgress;
   }

   public double[] getVocRanges() {
      return this.vocRanges;
   }

   public WelcomeHomeLocation getWelcomeHome() {
      return this.welcomeHome;
   }

   public String getWifiFirmware() {
      return this.wifiFirmware;
   }

   public int hashCode() {
      int var8 = this.uid.hashCode();
      int var9 = this.name.hashCode();
      int var7 = this.fanSpeed;
      Integer var39 = this.filterLife;
      int var6 = 0;
      int var1;
      if (var39 == null) {
         var1 = 0;
      } else {
         var1 = var39.hashCode();
      }

      int var10 = this.brightness;
      int var11 = this.autoModeText.hashCode();
      String var40 = this.info;
      int var2;
      if (var40 == null) {
         var2 = 0;
      } else {
         var2 = var40.hashCode();
      }

      DeviceUuid var41 = this.deviceUuid;
      int var3;
      if (var41 == null) {
         var3 = 0;
      } else {
         var3 = var41.hashCode();
      }

      int var12 = AddDeviceState$$ExternalSyntheticBackport0.m(this.hasFinishedOnboarding);
      IndoorDatapoint var42 = this.latestSensorDatapoint;
      int var4;
      if (var42 == null) {
         var4 = 0;
      } else {
         var4 = var42.hashCode();
      }

      int var30 = this.lastSelectedSensorTypeIndex;
      int var26 = AddDeviceState$$ExternalSyntheticBackport0.m(this.isChildLockOn);
      int var16 = this.connectivityStatusIndex;
      int var21 = AddDeviceState$$ExternalSyntheticBackport0.m(this.lastConnectivityInMillis);
      int var20 = this.mac.hashCode();
      int var17 = this.mcuFirmware.hashCode();
      int var28 = this.wifiFirmware.hashCode();
      int var23 = this.hardware.hashCode();
      int var27 = this.timeZone.hashCode();
      int var24 = this.serial.hashCode();
      int var15 = this.purchaseDate.hashCode();
      int var36 = this.dealerName.hashCode();
      int var29 = this.dealerCountry.hashCode();
      int var37 = this.filterType.hashCode();
      int var32 = this.filterTrigger.hashCode();
      int var25 = Arrays.hashCode(this.pm1Ranges);
      int var14 = Arrays.hashCode(this.pm10Ranges);
      int var22 = Arrays.hashCode(this.pm25Ranges);
      int var34 = Arrays.hashCode(this.vocRanges);
      int var19 = Arrays.hashCode(this.hchoRanges);
      int var38 = this.updateProgress;
      int var33 = AddDeviceState$$ExternalSyntheticBackport0.m(this.isStandByOn);
      int var31 = AddDeviceState$$ExternalSyntheticBackport0.m(this.isG4NightModeOn);
      int var13 = this.g4NightModeFilterTrigger.hashCode();
      int var35 = this.modelName.hashCode();
      int var18 = this.typeIndex;
      String var43 = this.sku;
      int var5;
      if (var43 == null) {
         var5 = 0;
      } else {
         var5 = var43.hashCode();
      }

      WelcomeHomeLocation var44 = this.welcomeHome;
      if (var44 != null) {
         var6 = var44.hashCode();
      }

      return (((((((((((((((((((((((((((((((((((((((((((((((((((((var8 * 31 + var9) * 31 + var7) * 31 + var1) * 31 + var10) * 31 + var11) * 31 + var2) * 31 + var3) * 31 + var12) * 31 + var4) * 31 + var30) * 31 + var26) * 31 + var16) * 31 + var21) * 31 + var20) * 31 + var17) * 31 + var28) * 31 + var23) * 31 + var27) * 31 + var24) * 31 + var15) * 31 + var36) * 31 + var29) * 31 + var37) * 31 + var32) * 31 + var25) * 31 + var14) * 31 + var22) * 31 + var34) * 31 + var19) * 31 + var38) * 31 + var33) * 31 + var31) * 31 + var13) * 31 + var35) * 31 + var18) * 31 + var5) * 31 + var6) * 31 + this.timerStatus) * 31 + this.timerDuration) * 31 + this.timerLeftTime) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.timerLeftTimeUpdateTime)) * 31 + this.mainMode) * 31 + this.apSubMode) * 31 + this.cleanAirEta) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.hoverEnabled)) * 31 + this.panelDisplayMode) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.airRefreshEnabled)) * 31 + this.airRefreshStatus) * 31 + this.airRefreshDuration) * 31 + this.airRefreshTimeStamp) * 31 + this.airRefreshStartTimeStamp) * 31 + this.airRefreshEndTimeStamp) * 31 + this.roomType) * 31 + this.sensorMode;
   }

   public boolean isChildLockOn() {
      return this.isChildLockOn;
   }

   public boolean isCnDevice() {
      return Device$_CC.$default$isCnDevice(this);
   }

   public boolean isG4NightModeOn() {
      return this.isG4NightModeOn;
   }

   public boolean isInAirRefreshStatus(AirRefreshState var1) {
      return HasAirRefresh$_CC.$default$isInAirRefreshStatus(this, var1);
   }

   public boolean isInApSubMode(ApSubMode var1) {
      return HasMainMode$_CC.$default$isInApSubMode(this, var1);
   }

   public boolean isInMainMode(MainMode var1) {
      return HasMainMode$_CC.$default$isInMainMode(this, var1);
   }

   public final boolean isLargeSize() {
      return StringsKt.equals(this.getHardware(), "l_blue40", true);
   }

   public final boolean isMediumSize() {
      return StringsKt.equals(this.getHardware(), "b40m", true) || StringsKt.equals(this.getHardware(), "m_blue40", true);
   }

   public boolean isOnline() {
      return Device$_CC.$default$isOnline(this);
   }

   public final boolean isSmallSize() {
      return StringsKt.equals(this.getHardware(), "b40s", true);
   }

   public boolean isStandByOn() {
      return this.isStandByOn;
   }

   public boolean isUsDevice() {
      return Device$_CC.$default$isUsDevice(this);
   }

   public MainMode mainMode() {
      return HasMainMode$_CC.$default$mainMode(this);
   }

   public boolean supportResetFilterOnline() {
      return Device$_CC.$default$supportResetFilterOnline(this);
   }

   public boolean supports(SensorType var1) {
      return HasSensorData$_CC.$default$supports(this, var1);
   }

   public TimerState timerStatus() {
      return HasTimer$_CC.$default$timerStatus(this);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DeviceBlue40(uid=");
      var1.append(this.uid);
      var1.append(", name=");
      var1.append(this.name);
      var1.append(", fanSpeed=");
      var1.append(this.fanSpeed);
      var1.append(", filterLife=");
      var1.append(this.filterLife);
      var1.append(", brightness=");
      var1.append(this.brightness);
      var1.append(", autoModeText=");
      var1.append(this.autoModeText);
      var1.append(", info=");
      var1.append(this.info);
      var1.append(", deviceUuid=");
      var1.append(this.deviceUuid);
      var1.append(", hasFinishedOnboarding=");
      var1.append(this.hasFinishedOnboarding);
      var1.append(", latestSensorDatapoint=");
      var1.append(this.latestSensorDatapoint);
      var1.append(", lastSelectedSensorTypeIndex=");
      var1.append(this.lastSelectedSensorTypeIndex);
      var1.append(", isChildLockOn=");
      var1.append(this.isChildLockOn);
      var1.append(", connectivityStatusIndex=");
      var1.append(this.connectivityStatusIndex);
      var1.append(", lastConnectivityInMillis=");
      var1.append(this.lastConnectivityInMillis);
      var1.append(", mac=");
      var1.append(this.mac);
      var1.append(", mcuFirmware=");
      var1.append(this.mcuFirmware);
      var1.append(", wifiFirmware=");
      var1.append(this.wifiFirmware);
      var1.append(", hardware=");
      var1.append(this.hardware);
      var1.append(", timeZone=");
      var1.append(this.timeZone);
      var1.append(", serial=");
      var1.append(this.serial);
      var1.append(", purchaseDate=");
      var1.append(this.purchaseDate);
      var1.append(", dealerName=");
      var1.append(this.dealerName);
      var1.append(", dealerCountry=");
      var1.append(this.dealerCountry);
      var1.append(", filterType=");
      var1.append(this.filterType);
      var1.append(", filterTrigger=");
      var1.append(this.filterTrigger);
      var1.append(", pm1Ranges=");
      var1.append(Arrays.toString(this.pm1Ranges));
      var1.append(", pm10Ranges=");
      var1.append(Arrays.toString(this.pm10Ranges));
      var1.append(", pm25Ranges=");
      var1.append(Arrays.toString(this.pm25Ranges));
      var1.append(", vocRanges=");
      var1.append(Arrays.toString(this.vocRanges));
      var1.append(", hchoRanges=");
      var1.append(Arrays.toString(this.hchoRanges));
      var1.append(", updateProgress=");
      var1.append(this.updateProgress);
      var1.append(", isStandByOn=");
      var1.append(this.isStandByOn);
      var1.append(", isG4NightModeOn=");
      var1.append(this.isG4NightModeOn);
      var1.append(", g4NightModeFilterTrigger=");
      var1.append(this.g4NightModeFilterTrigger);
      var1.append(", modelName=");
      var1.append(this.modelName);
      var1.append(", typeIndex=");
      var1.append(this.typeIndex);
      var1.append(", sku=");
      var1.append(this.sku);
      var1.append(", welcomeHome=");
      var1.append(this.welcomeHome);
      var1.append(", timerStatus=");
      var1.append(this.timerStatus);
      var1.append(", timerDuration=");
      var1.append(this.timerDuration);
      var1.append(", timerLeftTime=");
      var1.append(this.timerLeftTime);
      var1.append(", timerLeftTimeUpdateTime=");
      var1.append(this.timerLeftTimeUpdateTime);
      var1.append(", mainMode=");
      var1.append(this.mainMode);
      var1.append(", apSubMode=");
      var1.append(this.apSubMode);
      var1.append(", cleanAirEta=");
      var1.append(this.cleanAirEta);
      var1.append(", hoverEnabled=");
      var1.append(this.hoverEnabled);
      var1.append(", panelDisplayMode=");
      var1.append(this.panelDisplayMode);
      var1.append(", airRefreshEnabled=");
      var1.append(this.airRefreshEnabled);
      var1.append(", airRefreshStatus=");
      var1.append(this.airRefreshStatus);
      var1.append(", airRefreshDuration=");
      var1.append(this.airRefreshDuration);
      var1.append(", airRefreshTimeStamp=");
      var1.append(this.airRefreshTimeStamp);
      var1.append(", airRefreshStartTimeStamp=");
      var1.append(this.airRefreshStartTimeStamp);
      var1.append(", airRefreshEndTimeStamp=");
      var1.append(this.airRefreshEndTimeStamp);
      var1.append(", roomType=");
      var1.append(this.roomType);
      var1.append(", sensorMode=");
      var1.append(this.sensorMode);
      var1.append(')');
      return var1.toString();
   }

   public final boolean useTVOCForAqi() {
      return !this.isLargeSize() && this.getSensorMode() == 1;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "dest");
      var1.writeString(this.uid);
      var1.writeString(this.name);
      var1.writeInt(this.fanSpeed);
      Integer var3 = this.filterLife;
      if (var3 == null) {
         var1.writeInt(0);
      } else {
         var1.writeInt(1);
         var1.writeInt(var3);
      }

      var1.writeInt(this.brightness);
      var1.writeString(this.autoModeText);
      var1.writeString(this.info);
      DeviceUuid var4 = this.deviceUuid;
      if (var4 == null) {
         var1.writeInt(0);
      } else {
         var1.writeInt(1);
         var4.writeToParcel(var1, var2);
      }

      var1.writeInt(this.hasFinishedOnboarding);
      IndoorDatapoint var5 = this.latestSensorDatapoint;
      if (var5 == null) {
         var1.writeInt(0);
      } else {
         var1.writeInt(1);
         var5.writeToParcel(var1, var2);
      }

      var1.writeInt(this.lastSelectedSensorTypeIndex);
      var1.writeInt(this.isChildLockOn);
      var1.writeInt(this.connectivityStatusIndex);
      var1.writeLong(this.lastConnectivityInMillis);
      var1.writeString(this.mac);
      var1.writeString(this.mcuFirmware);
      var1.writeString(this.wifiFirmware);
      var1.writeString(this.hardware);
      var1.writeString(this.timeZone);
      var1.writeString(this.serial);
      var1.writeString(this.purchaseDate);
      var1.writeString(this.dealerName);
      var1.writeString(this.dealerCountry);
      var1.writeString(this.filterType);
      var1.writeString(this.filterTrigger);
      var1.writeDoubleArray(this.pm1Ranges);
      var1.writeDoubleArray(this.pm10Ranges);
      var1.writeDoubleArray(this.pm25Ranges);
      var1.writeDoubleArray(this.vocRanges);
      var1.writeDoubleArray(this.hchoRanges);
      var1.writeInt(this.updateProgress);
      var1.writeInt(this.isStandByOn);
      var1.writeInt(this.isG4NightModeOn);
      var1.writeString(this.g4NightModeFilterTrigger);
      var1.writeString(this.modelName);
      var1.writeInt(this.typeIndex);
      var1.writeString(this.sku);
      WelcomeHomeLocation var6 = this.welcomeHome;
      if (var6 == null) {
         var1.writeInt(0);
      } else {
         var1.writeInt(1);
         var6.writeToParcel(var1, var2);
      }

      var1.writeInt(this.timerStatus);
      var1.writeInt(this.timerDuration);
      var1.writeInt(this.timerLeftTime);
      var1.writeLong(this.timerLeftTimeUpdateTime);
      var1.writeInt(this.mainMode);
      var1.writeInt(this.apSubMode);
      var1.writeInt(this.cleanAirEta);
      var1.writeInt(this.hoverEnabled);
      var1.writeInt(this.panelDisplayMode);
      var1.writeInt(this.airRefreshEnabled);
      var1.writeInt(this.airRefreshStatus);
      var1.writeInt(this.airRefreshDuration);
      var1.writeInt(this.airRefreshTimeStamp);
      var1.writeInt(this.airRefreshStartTimeStamp);
      var1.writeInt(this.airRefreshEndTimeStamp);
      var1.writeInt(this.roomType);
      var1.writeInt(this.sensorMode);
   }

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Creator implements Parcelable.Creator {
      public final DeviceBlue40 createFromParcel(Parcel var1) {
         Intrinsics.checkNotNullParameter(var1, "parcel");
         String var29 = var1.readString();
         String var28 = var1.readString();
         int var2 = var1.readInt();
         int var3 = var1.readInt();
         Object var27 = null;
         Integer var25;
         if (var3 == 0) {
            var25 = null;
         } else {
            var25 = var1.readInt();
         }

         int var7 = var1.readInt();
         String var31 = var1.readString();
         String var30 = var1.readString();
         Object var26;
         if (var1.readInt() == 0) {
            var26 = null;
         } else {
            var26 = DeviceUuid.CREATOR.createFromParcel(var1);
         }

         DeviceUuid var32 = (DeviceUuid)var26;
         boolean var15;
         if (var1.readInt() != 0) {
            var15 = true;
         } else {
            var15 = false;
         }

         if (var1.readInt() == 0) {
            var26 = null;
         } else {
            var26 = IndoorDatapoint.CREATOR.createFromParcel(var1);
         }

         IndoorDatapoint var44 = (IndoorDatapoint)var26;
         int var8 = var1.readInt();
         boolean var16;
         if (var1.readInt() != 0) {
            var16 = true;
         } else {
            var16 = false;
         }

         int var4 = var1.readInt();
         long var21 = var1.readLong();
         String var48 = var1.readString();
         String var52 = var1.readString();
         String var41 = var1.readString();
         String var47 = var1.readString();
         String var50 = var1.readString();
         String var51 = var1.readString();
         String var45 = var1.readString();
         String var37 = var1.readString();
         String var38 = var1.readString();
         String var43 = var1.readString();
         String var33 = var1.readString();
         double[] var42 = var1.createDoubleArray();
         double[] var39 = var1.createDoubleArray();
         double[] var34 = var1.createDoubleArray();
         double[] var35 = var1.createDoubleArray();
         boolean var17 = false;
         double[] var40 = var1.createDoubleArray();
         boolean var18 = true;
         int var14 = var1.readInt();
         if (var1.readInt() != 0) {
            var17 = true;
         }

         if (var1.readInt() == 0) {
            var18 = false;
         }

         String var46 = var1.readString();
         String var36 = var1.readString();
         int var13 = var1.readInt();
         String var49 = var1.readString();
         if (var1.readInt() == 0) {
            var26 = var27;
         } else {
            var26 = WelcomeHomeLocation.CREATOR.createFromParcel(var1);
         }

         WelcomeHomeLocation var56 = (WelcomeHomeLocation)var26;
         var3 = var1.readInt();
         int var10 = var1.readInt();
         int var5 = var1.readInt();
         long var23 = var1.readLong();
         int var9 = var1.readInt();
         int var6 = var1.readInt();
         boolean var19 = true;
         int var12 = var1.readInt();
         if (var1.readInt() == 0) {
            var19 = false;
         }

         boolean var20 = true;
         int var11 = var1.readInt();
         if (var1.readInt() == 0) {
            var20 = false;
         }

         return new DeviceBlue40(var29, var28, var2, var25, var7, var31, var30, var32, var15, var44, var8, var16, var4, var21, var48, var52, var41, var47, var50, var51, var45, var37, var38, var43, var33, var42, var39, var34, var35, var40, var14, var17, var18, var46, var36, var13, var49, var56, var3, var10, var5, var23, var9, var6, var12, var19, var11, var20, var1.readInt(), var1.readInt(), var1.readInt(), var1.readInt(), var1.readInt(), var1.readInt(), var1.readInt());
      }

      public final DeviceBlue40[] newArray(int var1) {
         return new DeviceBlue40[var1];
      }
   }
}
