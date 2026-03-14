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

@Metadata(
   d1 = {"\u0000©\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0013\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0006\n\u0003\b\u0091\u0001\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\r2\u00020\u000e2\u00020\u000f2\u00020\u00102\u00020\u00112\u00020\u0012Bõ\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010\"\u001a\u00020\u0017\u0012\b\b\u0002\u0010#\u001a\u00020\u001f\u0012\b\b\u0002\u0010$\u001a\u00020\u0017\u0012\b\b\u0002\u0010%\u001a\u00020&\u0012\b\b\u0002\u0010'\u001a\u00020\u0014\u0012\b\b\u0002\u0010(\u001a\u00020\u0014\u0012\b\b\u0002\u0010)\u001a\u00020\u0014\u0012\b\b\u0002\u0010*\u001a\u00020\u0014\u0012\b\b\u0002\u0010+\u001a\u00020\u0014\u0012\b\b\u0002\u0010,\u001a\u00020\u0014\u0012\b\b\u0002\u0010-\u001a\u00020\u0014\u0012\b\b\u0002\u0010.\u001a\u00020\u0014\u0012\b\b\u0002\u0010/\u001a\u00020\u0014\u0012\b\b\u0002\u00100\u001a\u00020\u0014\u0012\b\b\u0002\u00101\u001a\u00020\u0014\u0012\b\b\u0002\u00102\u001a\u000203\u0012\b\b\u0002\u00104\u001a\u000203\u0012\b\b\u0002\u00105\u001a\u000203\u0012\b\b\u0002\u00106\u001a\u000203\u0012\b\b\u0002\u00107\u001a\u000203\u0012\b\b\u0002\u00108\u001a\u00020\u0017\u0012\b\b\u0002\u00109\u001a\u00020\u001f\u0012\b\b\u0002\u0010:\u001a\u00020\u001f\u0012\b\b\u0002\u0010;\u001a\u00020\u0014\u0012\b\b\u0002\u0010<\u001a\u00020\u0014\u0012\b\b\u0002\u0010=\u001a\u00020\u0017\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010@\u0012\b\b\u0002\u0010A\u001a\u00020\u0017\u0012\b\b\u0002\u0010B\u001a\u00020\u0017\u0012\b\b\u0002\u0010C\u001a\u00020\u0017\u0012\b\b\u0002\u0010D\u001a\u00020&\u0012\b\b\u0002\u0010E\u001a\u00020\u0017\u0012\b\b\u0002\u0010F\u001a\u00020\u0017\u0012\b\b\u0002\u0010G\u001a\u00020\u0017\u0012\b\b\u0002\u0010H\u001a\u00020\u0017\u0012\b\b\u0002\u0010I\u001a\u00020\u0017\u0012\b\b\u0002\u0010J\u001a\u00020\u0017\u0012\b\b\u0002\u0010K\u001a\u00020\u0017\u0012\b\b\u0002\u0010L\u001a\u00020\u0017\u0012\b\b\u0002\u0010M\u001a\u00020\u0017\u0012\b\b\u0002\u0010N\u001a\u00020\u0017\u0012\b\b\u0002\u0010O\u001a\u00020P\u0012\b\b\u0002\u0010Q\u001a\u00020P\u0012\b\b\u0002\u0010R\u001a\u00020\u0017\u0012\b\b\u0002\u0010S\u001a\u00020\u0017\u0012\b\b\u0002\u0010T\u001a\u00020\u0017\u0012\b\b\u0002\u0010U\u001a\u000203\u0012\b\b\u0002\u0010V\u001a\u00020\u0017\u0012\b\b\u0002\u0010W\u001a\u000203\u0012\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\bY\u0010ZJ\n\u0010 \u0001\u001a\u00020\u0014HÆ\u0003J\n\u0010¡\u0001\u001a\u00020\u0014HÆ\u0003J\n\u0010¢\u0001\u001a\u00020\u0017HÆ\u0003J\u0011\u0010£\u0001\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0002\u0010aJ\n\u0010¤\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010¥\u0001\u001a\u00020\u0014HÆ\u0003J\f\u0010¦\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\f\u0010§\u0001\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\n\u0010¨\u0001\u001a\u00020\u001fHÆ\u0003J\f\u0010©\u0001\u001a\u0004\u0018\u00010!HÆ\u0003J\n\u0010ª\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010«\u0001\u001a\u00020\u001fHÆ\u0003J\n\u0010¬\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010\u00ad\u0001\u001a\u00020&HÆ\u0003J\n\u0010®\u0001\u001a\u00020\u0014HÆ\u0003J\n\u0010¯\u0001\u001a\u00020\u0014HÆ\u0003J\n\u0010°\u0001\u001a\u00020\u0014HÆ\u0003J\n\u0010±\u0001\u001a\u00020\u0014HÆ\u0003J\n\u0010²\u0001\u001a\u00020\u0014HÆ\u0003J\n\u0010³\u0001\u001a\u00020\u0014HÆ\u0003J\n\u0010´\u0001\u001a\u00020\u0014HÆ\u0003J\n\u0010µ\u0001\u001a\u00020\u0014HÆ\u0003J\n\u0010¶\u0001\u001a\u00020\u0014HÆ\u0003J\n\u0010·\u0001\u001a\u00020\u0014HÆ\u0003J\n\u0010¸\u0001\u001a\u00020\u0014HÆ\u0003J\n\u0010¹\u0001\u001a\u000203HÆ\u0003J\n\u0010º\u0001\u001a\u000203HÆ\u0003J\n\u0010»\u0001\u001a\u000203HÆ\u0003J\n\u0010¼\u0001\u001a\u000203HÆ\u0003J\n\u0010½\u0001\u001a\u000203HÆ\u0003J\n\u0010¾\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010¿\u0001\u001a\u00020\u001fHÆ\u0003J\n\u0010À\u0001\u001a\u00020\u001fHÆ\u0003J\n\u0010Á\u0001\u001a\u00020\u0014HÆ\u0003J\n\u0010Â\u0001\u001a\u00020\u0014HÆ\u0003J\n\u0010Ã\u0001\u001a\u00020\u0017HÆ\u0003J\f\u0010Ä\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\f\u0010Å\u0001\u001a\u0004\u0018\u00010@HÆ\u0003J\n\u0010Æ\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010Ç\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010È\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010É\u0001\u001a\u00020&HÆ\u0003J\n\u0010Ê\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010Ë\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010Ì\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010Í\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010Î\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010Ï\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010Ð\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010Ñ\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010Ò\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010Ó\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010Ô\u0001\u001a\u00020PHÆ\u0003J\n\u0010Õ\u0001\u001a\u00020PHÆ\u0003J\n\u0010Ö\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010×\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010Ø\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010Ù\u0001\u001a\u000203HÆ\u0003J\n\u0010Ú\u0001\u001a\u00020\u0017HÆ\u0003J\n\u0010Û\u0001\u001a\u000203HÆ\u0003J\f\u0010Ü\u0001\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u0080\u0005\u0010Ý\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u00142\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\"\u001a\u00020\u00172\b\b\u0002\u0010#\u001a\u00020\u001f2\b\b\u0002\u0010$\u001a\u00020\u00172\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020\u00142\b\b\u0002\u0010(\u001a\u00020\u00142\b\b\u0002\u0010)\u001a\u00020\u00142\b\b\u0002\u0010*\u001a\u00020\u00142\b\b\u0002\u0010+\u001a\u00020\u00142\b\b\u0002\u0010,\u001a\u00020\u00142\b\b\u0002\u0010-\u001a\u00020\u00142\b\b\u0002\u0010.\u001a\u00020\u00142\b\b\u0002\u0010/\u001a\u00020\u00142\b\b\u0002\u00100\u001a\u00020\u00142\b\b\u0002\u00101\u001a\u00020\u00142\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u00104\u001a\u0002032\b\b\u0002\u00105\u001a\u0002032\b\b\u0002\u00106\u001a\u0002032\b\b\u0002\u00107\u001a\u0002032\b\b\u0002\u00108\u001a\u00020\u00172\b\b\u0002\u00109\u001a\u00020\u001f2\b\b\u0002\u0010:\u001a\u00020\u001f2\b\b\u0002\u0010;\u001a\u00020\u00142\b\b\u0002\u0010<\u001a\u00020\u00142\b\b\u0002\u0010=\u001a\u00020\u00172\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010?\u001a\u0004\u0018\u00010@2\b\b\u0002\u0010A\u001a\u00020\u00172\b\b\u0002\u0010B\u001a\u00020\u00172\b\b\u0002\u0010C\u001a\u00020\u00172\b\b\u0002\u0010D\u001a\u00020&2\b\b\u0002\u0010E\u001a\u00020\u00172\b\b\u0002\u0010F\u001a\u00020\u00172\b\b\u0002\u0010G\u001a\u00020\u00172\b\b\u0002\u0010H\u001a\u00020\u00172\b\b\u0002\u0010I\u001a\u00020\u00172\b\b\u0002\u0010J\u001a\u00020\u00172\b\b\u0002\u0010K\u001a\u00020\u00172\b\b\u0002\u0010L\u001a\u00020\u00172\b\b\u0002\u0010M\u001a\u00020\u00172\b\b\u0002\u0010N\u001a\u00020\u00172\b\b\u0002\u0010O\u001a\u00020P2\b\b\u0002\u0010Q\u001a\u00020P2\b\b\u0002\u0010R\u001a\u00020\u00172\b\b\u0002\u0010S\u001a\u00020\u00172\b\b\u0002\u0010T\u001a\u00020\u00172\b\b\u0002\u0010U\u001a\u0002032\b\b\u0002\u0010V\u001a\u00020\u00172\b\b\u0002\u0010W\u001a\u0002032\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u0014HÆ\u0001¢\u0006\u0003\u0010Þ\u0001J\u0007\u0010ß\u0001\u001a\u00020\u0017J\u0016\u0010à\u0001\u001a\u00020\u001f2\n\u0010á\u0001\u001a\u0005\u0018\u00010â\u0001HÖ\u0003J\n\u0010ã\u0001\u001a\u00020\u0017HÖ\u0001J\n\u0010ä\u0001\u001a\u00020\u0014HÖ\u0001J\u001b\u0010å\u0001\u001a\u00030æ\u00012\b\u0010ç\u0001\u001a\u00030è\u00012\u0007\u0010é\u0001\u001a\u00020\u0017R\u0014\u0010\u0013\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\\R\u0014\u0010\u0015\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010\\R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u0010_R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0096\u0004¢\u0006\n\n\u0002\u0010b\u001a\u0004\b`\u0010aR\u0014\u0010\u0019\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bc\u0010_R\u0014\u0010\u001a\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bd\u0010\\R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010\\R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bf\u0010gR\u0014\u0010\u001e\u001a\u00020\u001fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010iR\u0016\u0010 \u001a\u0004\u0018\u00010!X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bj\u0010kR\u0014\u0010\"\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bl\u0010_R\u0014\u0010#\u001a\u00020\u001fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010iR\u0014\u0010$\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bm\u0010_R\u0014\u0010%\u001a\u00020&X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bn\u0010oR\u0014\u0010'\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bp\u0010\\R\u0014\u0010(\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bq\u0010\\R\u0014\u0010)\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\br\u0010\\R\u0014\u0010*\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bs\u0010\\R\u0014\u0010+\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bt\u0010\\R\u0014\u0010,\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010\\R\u0014\u0010-\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bv\u0010\\R\u0014\u0010.\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bw\u0010\\R\u0014\u0010/\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bx\u0010\\R\u0014\u00100\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\by\u0010\\R\u0014\u00101\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bz\u0010\\R\u0014\u00102\u001a\u000203X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b{\u0010|R\u0014\u00104\u001a\u000203X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b}\u0010|R\u0014\u00105\u001a\u000203X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b~\u0010|R\u0014\u00106\u001a\u000203X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u007f\u0010|R\u0015\u00107\u001a\u000203X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0080\u0001\u0010|R\u0015\u00108\u001a\u00020\u0017X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0081\u0001\u0010_R\u0014\u00109\u001a\u00020\u001fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010iR\u0014\u0010:\u001a\u00020\u001fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010iR\u0015\u0010;\u001a\u00020\u0014X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0082\u0001\u0010\\R\u0015\u0010<\u001a\u00020\u0014X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0083\u0001\u0010\\R\u0015\u0010=\u001a\u00020\u0017X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0084\u0001\u0010_R\u0017\u0010>\u001a\u0004\u0018\u00010\u0014X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0085\u0001\u0010\\R\u0018\u0010?\u001a\u0004\u0018\u00010@X\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0015\u0010A\u001a\u00020\u0017X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0088\u0001\u0010_R\u0015\u0010B\u001a\u00020\u0017X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0089\u0001\u0010_R\u0015\u0010C\u001a\u00020\u0017X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008a\u0001\u0010_R\u0015\u0010D\u001a\u00020&X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008b\u0001\u0010oR\u0015\u0010E\u001a\u00020\u0017X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008c\u0001\u0010_R\u0015\u0010F\u001a\u00020\u0017X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008d\u0001\u0010_R\u0015\u0010G\u001a\u00020\u0017X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008e\u0001\u0010_R\u0015\u0010H\u001a\u00020\u0017X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008f\u0001\u0010_R\u0015\u0010I\u001a\u00020\u0017X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0090\u0001\u0010_R\u0015\u0010J\u001a\u00020\u0017X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0091\u0001\u0010_R\u0015\u0010K\u001a\u00020\u0017X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0092\u0001\u0010_R\u0015\u0010L\u001a\u00020\u0017X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0093\u0001\u0010_R\u0015\u0010M\u001a\u00020\u0017X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0094\u0001\u0010_R\u0015\u0010N\u001a\u00020\u0017X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0095\u0001\u0010_R\u0016\u0010O\u001a\u00020PX\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R\u0016\u0010Q\u001a\u00020PX\u0096\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0098\u0001\u0010\u0097\u0001R\u0015\u0010R\u001a\u00020\u0017X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0099\u0001\u0010_R\u0015\u0010S\u001a\u00020\u0017X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u009a\u0001\u0010_R\u0015\u0010T\u001a\u00020\u0017X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u009b\u0001\u0010_R\u0015\u0010U\u001a\u000203X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u009c\u0001\u0010|R\u0015\u0010V\u001a\u00020\u0017X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u009d\u0001\u0010_R\u0015\u0010W\u001a\u000203X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u009e\u0001\u0010|R\u0017\u0010X\u001a\u0004\u0018\u00010\u0014X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u009f\u0001\u0010\\¨\u0006ê\u0001"},
   d2 = {"Lcom/blueair/core/model/DeviceCombo3in1;", "Lcom/blueair/core/model/Device;", "Lcom/blueair/core/model/HasFanSpeed;", "Lcom/blueair/core/model/HasInfo;", "Lcom/blueair/core/model/HasBlueProvisionCalls;", "Lcom/blueair/core/model/HasSensorData;", "Lcom/blueair/core/model/HasBlueCloudFunctions;", "Lcom/blueair/core/model/HasChildLock;", "Lcom/blueair/core/model/HasBrightness;", "Lcom/blueair/core/model/HasStandBy;", "Lcom/blueair/core/model/HasG4NightMode;", "Lcom/blueair/core/model/HasScheduling;", "Lcom/blueair/core/model/HasSKU;", "Lcom/blueair/core/model/HasWelcomeHome;", "Lcom/blueair/core/model/HasTimer;", "Lcom/blueair/core/model/HasTemperatureUnit;", "Lcom/blueair/core/model/HasOscillation;", "Lcom/blueair/core/model/HasCombo3in1MainMode;", "Lcom/blueair/core/model/HasLocation;", "uid", "", "name", "fanSpeed", "", "filterLife", "brightness", "autoModeText", "info", "deviceUuid", "Lcom/blueair/core/model/DeviceUuid;", "hasFinishedOnboarding", "", "latestSensorDatapoint", "Lcom/blueair/core/model/IndoorDatapoint;", "lastSelectedSensorTypeIndex", "isChildLockOn", "connectivityStatusIndex", "lastConnectivityInMillis", "", "mac", "mcuFirmware", "wifiFirmware", "hardware", "timeZone", "serial", "purchaseDate", "dealerName", "dealerCountry", "filterType", "filterTrigger", "pm1Ranges", "", "pm10Ranges", "pm25Ranges", "vocRanges", "hchoRanges", "updateProgress", "isStandByOn", "isG4NightModeOn", "g4NightModeFilterTrigger", "modelName", "typeIndex", "sku", "welcomeHome", "Lcom/blueair/core/model/WelcomeHomeLocation;", "timerStatus", "timerDuration", "timerLeftTime", "timerLeftTimeUpdateTime", "temperatureUnit", "oscillationState", "oscillationAngle", "oscillationDirection", "oscillationFanSpeed", "mainMode", "apSubMode", "apFanSpeed", "heatSubMode", "heatFanSpeed", "heatAutoTmp", "", "heatEcoTmp", "coolSubMode", "coolFanSpeed", "coolAutoTag", "coolAutoPresets", "coolEcoTag", "coolEcoPresets", "locationId", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/DeviceUuid;ZLcom/blueair/core/model/IndoorDatapoint;IZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[D[D[D[D[DIZZLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/blueair/core/model/WelcomeHomeLocation;IIIJIIIIIIIIIIDDIII[DI[DLjava/lang/String;)V", "getUid", "()Ljava/lang/String;", "getName", "getFanSpeed", "()I", "getFilterLife", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBrightness", "getAutoModeText", "getInfo", "getDeviceUuid", "()Lcom/blueair/core/model/DeviceUuid;", "getHasFinishedOnboarding", "()Z", "getLatestSensorDatapoint", "()Lcom/blueair/core/model/IndoorDatapoint;", "getLastSelectedSensorTypeIndex", "getConnectivityStatusIndex", "getLastConnectivityInMillis", "()J", "getMac", "getMcuFirmware", "getWifiFirmware", "getHardware", "getTimeZone", "getSerial", "getPurchaseDate", "getDealerName", "getDealerCountry", "getFilterType", "getFilterTrigger", "getPm1Ranges", "()[D", "getPm10Ranges", "getPm25Ranges", "getVocRanges", "getHchoRanges", "getUpdateProgress", "getG4NightModeFilterTrigger", "getModelName", "getTypeIndex", "getSku", "getWelcomeHome", "()Lcom/blueair/core/model/WelcomeHomeLocation;", "getTimerStatus", "getTimerDuration", "getTimerLeftTime", "getTimerLeftTimeUpdateTime", "getTemperatureUnit", "getOscillationState", "getOscillationAngle", "getOscillationDirection", "getOscillationFanSpeed", "getMainMode", "getApSubMode", "getApFanSpeed", "getHeatSubMode", "getHeatFanSpeed", "getHeatAutoTmp", "()D", "getHeatEcoTmp", "getCoolSubMode", "getCoolFanSpeed", "getCoolAutoTag", "getCoolAutoPresets", "getCoolEcoTag", "getCoolEcoPresets", "getLocationId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component60", "component61", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/DeviceUuid;ZLcom/blueair/core/model/IndoorDatapoint;IZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[D[D[D[D[DIZZLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/blueair/core/model/WelcomeHomeLocation;IIIJIIIIIIIIIIDDIII[DI[DLjava/lang/String;)Lcom/blueair/core/model/DeviceCombo3in1;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceCombo3in1 implements Device, HasFanSpeed, HasInfo, HasBlueProvisionCalls, HasSensorData, HasBlueCloudFunctions, HasChildLock, HasBrightness, HasStandBy, HasG4NightMode, HasScheduling, HasSKU, HasWelcomeHome, HasTimer, HasTemperatureUnit, HasOscillation, HasCombo3in1MainMode, HasLocation {
   public static final Parcelable.Creator CREATOR = new Creator();
   private final int apFanSpeed;
   private final int apSubMode;
   private final String autoModeText;
   private final int brightness;
   private final int connectivityStatusIndex;
   private final double[] coolAutoPresets;
   private final int coolAutoTag;
   private final double[] coolEcoPresets;
   private final int coolEcoTag;
   private final int coolFanSpeed;
   private final int coolSubMode;
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
   private final double heatAutoTmp;
   private final double heatEcoTmp;
   private final int heatFanSpeed;
   private final int heatSubMode;
   private final String info;
   private final boolean isChildLockOn;
   private final boolean isG4NightModeOn;
   private final boolean isStandByOn;
   private final long lastConnectivityInMillis;
   private final int lastSelectedSensorTypeIndex;
   private final IndoorDatapoint latestSensorDatapoint;
   private final String locationId;
   private final String mac;
   private final int mainMode;
   private final String mcuFirmware;
   private final String modelName;
   private final String name;
   private final int oscillationAngle;
   private final int oscillationDirection;
   private final int oscillationFanSpeed;
   private final int oscillationState;
   private final double[] pm10Ranges;
   private final double[] pm1Ranges;
   private final double[] pm25Ranges;
   private final String purchaseDate;
   private final String serial;
   private final String sku;
   private final int temperatureUnit;
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

   public DeviceCombo3in1(String var1, String var2, int var3, Integer var4, int var5, String var6, String var7, DeviceUuid var8, boolean var9, IndoorDatapoint var10, int var11, boolean var12, int var13, long var14, String var16, String var17, String var18, String var19, String var20, String var21, String var22, String var23, String var24, String var25, String var26, double[] var27, double[] var28, double[] var29, double[] var30, double[] var31, int var32, boolean var33, boolean var34, String var35, String var36, int var37, String var38, WelcomeHomeLocation var39, int var40, int var41, int var42, long var43, int var45, int var46, int var47, int var48, int var49, int var50, int var51, int var52, int var53, int var54, double var55, double var57, int var59, int var60, int var61, double[] var62, int var63, double[] var64, String var65) {
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
      Intrinsics.checkNotNullParameter(var62, "coolAutoPresets");
      Intrinsics.checkNotNullParameter(var64, "coolEcoPresets");
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
      this.temperatureUnit = var45;
      this.oscillationState = var46;
      this.oscillationAngle = var47;
      this.oscillationDirection = var48;
      this.oscillationFanSpeed = var49;
      this.mainMode = var50;
      this.apSubMode = var51;
      this.apFanSpeed = var52;
      this.heatSubMode = var53;
      this.heatFanSpeed = var54;
      this.heatAutoTmp = var55;
      this.heatEcoTmp = var57;
      this.coolSubMode = var59;
      this.coolFanSpeed = var60;
      this.coolAutoTag = var61;
      this.coolAutoPresets = var62;
      this.coolEcoTag = var63;
      this.coolEcoPresets = var64;
      this.locationId = var65;
   }

   // $FF: synthetic method
   public DeviceCombo3in1(String var1, String var2, int var3, Integer var4, int var5, String var6, String var7, DeviceUuid var8, boolean var9, IndoorDatapoint var10, int var11, boolean var12, int var13, long var14, String var16, String var17, String var18, String var19, String var20, String var21, String var22, String var23, String var24, String var25, String var26, double[] var27, double[] var28, double[] var29, double[] var30, double[] var31, int var32, boolean var33, boolean var34, String var35, String var36, int var37, String var38, WelcomeHomeLocation var39, int var40, int var41, int var42, long var43, int var45, int var46, int var47, int var48, int var49, int var50, int var51, int var52, int var53, int var54, double var55, double var57, int var59, int var60, int var61, double[] var62, int var63, double[] var64, String var65, int var66, int var67, DefaultConstructorMarker var68) {
      if ((var66 & 2) != 0) {
         var2 = "Pairing…";
      }

      if ((var66 & 4) != 0) {
         var3 = 0;
      }

      if ((var66 & 8) != 0) {
         var4 = null;
      }

      if ((var66 & 16) != 0) {
         var5 = 0;
      }

      String var71 = "";
      if ((var66 & 32) != 0) {
         var6 = "";
      }

      if ((var66 & 64) != 0) {
         var7 = null;
      }

      if ((var66 & 128) != 0) {
         var8 = null;
      }

      if ((var66 & 256) != 0) {
         var9 = false;
      }

      if ((var66 & 512) != 0) {
         var10 = null;
      }

      if ((var66 & 1024) != 0) {
         var11 = 0;
      }

      if ((var66 & 2048) != 0) {
         var12 = false;
      }

      if ((var66 & 4096) != 0) {
         var13 = ConnectivityStatus.ONLINE.ordinal();
      }

      long var69 = 0L;
      if ((var66 & 8192) != 0) {
         var14 = 0L;
      }

      if ((var66 & 16384) != 0) {
         var16 = "";
      }

      if ((var66 & '耀') != 0) {
         var17 = "";
      }

      if ((var66 & 65536) != 0) {
         var18 = "";
      }

      if ((var66 & 131072) != 0) {
         var19 = "";
      }

      if ((var66 & 262144) != 0) {
         var20 = "";
      }

      if ((var66 & 524288) != 0) {
         var21 = "";
      }

      if ((var66 & 1048576) != 0) {
         var22 = "";
      }

      if ((var66 & 2097152) != 0) {
         var23 = "";
      }

      if ((var66 & 4194304) != 0) {
         var24 = "";
      }

      if ((var66 & 8388608) != 0) {
         var25 = "";
      }

      if ((var66 & 16777216) != 0) {
         var26 = "";
      }

      if ((var66 & 33554432) != 0) {
         var27 = new double[0];
      }

      if ((var66 & 67108864) != 0) {
         var28 = new double[0];
      }

      if ((var66 & 134217728) != 0) {
         var29 = new double[0];
      }

      if ((var66 & 268435456) != 0) {
         var30 = new double[0];
      }

      if ((var66 & 536870912) != 0) {
         var31 = new double[0];
      }

      if ((var66 & 1073741824) != 0) {
         var32 = 0;
      }

      if ((var66 & Integer.MIN_VALUE) != 0) {
         var33 = false;
      }

      if ((var67 & 1) != 0) {
         var34 = false;
      }

      if ((var67 & 2) != 0) {
         var35 = "";
      }

      if ((var67 & 4) != 0) {
         var36 = var71;
      }

      if ((var67 & 8) != 0) {
         var37 = DeviceType.Combo3in1.INSTANCE.getIndex();
      }

      if ((var67 & 16) != 0) {
         var38 = null;
      }

      if ((var67 & 32) != 0) {
         var39 = null;
      }

      if ((var67 & 64) != 0) {
         var40 = 0;
      }

      if ((var67 & 128) != 0) {
         var41 = 0;
      }

      if ((var67 & 256) != 0) {
         var42 = 0;
      }

      if ((var67 & 512) != 0) {
         var43 = var69;
      }

      if ((var67 & 1024) != 0) {
         var45 = 0;
      }

      if ((var67 & 2048) != 0) {
         var46 = 0;
      }

      if ((var67 & 4096) != 0) {
         var47 = 90;
      }

      if ((var67 & 8192) != 0) {
         var48 = 0;
      }

      if ((var67 & 16384) != 0) {
         var49 = 0;
      }

      if ((var67 & '耀') != 0) {
         var50 = 0;
      }

      if ((var67 & 65536) != 0) {
         var51 = 2;
      }

      if ((var67 & 131072) != 0) {
         var52 = 0;
      }

      if ((var67 & 262144) != 0) {
         var53 = 2;
      }

      if ((var67 & 524288) != 0) {
         var54 = 0;
      }

      if ((var67 & 1048576) != 0) {
         var55 = (double)22.0F;
      }

      if ((var67 & 2097152) != 0) {
         var57 = (double)22.0F;
      }

      if ((var67 & 4194304) != 0) {
         var59 = 2;
      }

      if ((var67 & 8388608) != 0) {
         var60 = 0;
      }

      if ((var67 & 16777216) != 0) {
         var61 = 0;
      }

      if ((var67 & 33554432) != 0) {
         var62 = new double[]{(double)20.0F, (double)23.0F, (double)25.0F};
      }

      if ((var67 & 67108864) != 0) {
         var63 = 0;
      }

      if ((var67 & 134217728) != 0) {
         var64 = new double[]{(double)20.0F, (double)25.0F};
      }

      if ((var67 & 268435456) != 0) {
         var65 = null;
      }

      this(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26, var27, var28, var29, var30, var31, var32, var33, var34, var35, var36, var37, var38, var39, var40, var41, var42, var43, var45, var46, var47, var48, var49, var50, var51, var52, var53, var54, var55, var57, var59, var60, var61, var62, var63, var64, var65);
   }

   // $FF: synthetic method
   public static DeviceCombo3in1 copy$default(DeviceCombo3in1 var0, String var1, String var2, int var3, Integer var4, int var5, String var6, String var7, DeviceUuid var8, boolean var9, IndoorDatapoint var10, int var11, boolean var12, int var13, long var14, String var16, String var17, String var18, String var19, String var20, String var21, String var22, String var23, String var24, String var25, String var26, double[] var27, double[] var28, double[] var29, double[] var30, double[] var31, int var32, boolean var33, boolean var34, String var35, String var36, int var37, String var38, WelcomeHomeLocation var39, int var40, int var41, int var42, long var43, int var45, int var46, int var47, int var48, int var49, int var50, int var51, int var52, int var53, int var54, double var55, double var57, int var59, int var60, int var61, double[] var62, int var63, double[] var64, String var65, int var66, int var67, Object var68) {
      if ((var66 & 1) != 0) {
         var1 = var0.uid;
      }

      if ((var66 & 2) != 0) {
         var2 = var0.name;
      }

      if ((var66 & 4) != 0) {
         var3 = var0.fanSpeed;
      }

      if ((var66 & 8) != 0) {
         var4 = var0.filterLife;
      }

      if ((var66 & 16) != 0) {
         var5 = var0.brightness;
      }

      if ((var66 & 32) != 0) {
         var6 = var0.autoModeText;
      }

      if ((var66 & 64) != 0) {
         var7 = var0.info;
      }

      if ((var66 & 128) != 0) {
         var8 = var0.deviceUuid;
      }

      if ((var66 & 256) != 0) {
         var9 = var0.hasFinishedOnboarding;
      }

      if ((var66 & 512) != 0) {
         var10 = var0.latestSensorDatapoint;
      }

      if ((var66 & 1024) != 0) {
         var11 = var0.lastSelectedSensorTypeIndex;
      }

      if ((var66 & 2048) != 0) {
         var12 = var0.isChildLockOn;
      }

      if ((var66 & 4096) != 0) {
         var13 = var0.connectivityStatusIndex;
      }

      if ((var66 & 8192) != 0) {
         var14 = var0.lastConnectivityInMillis;
      }

      if ((var66 & 16384) != 0) {
         var16 = var0.mac;
      }

      if ((var66 & '耀') != 0) {
         var17 = var0.mcuFirmware;
      }

      if ((var66 & 65536) != 0) {
         var18 = var0.wifiFirmware;
      }

      if ((var66 & 131072) != 0) {
         var19 = var0.hardware;
      }

      if ((var66 & 262144) != 0) {
         var20 = var0.timeZone;
      }

      if ((var66 & 524288) != 0) {
         var21 = var0.serial;
      }

      if ((var66 & 1048576) != 0) {
         var22 = var0.purchaseDate;
      }

      if ((var66 & 2097152) != 0) {
         var23 = var0.dealerName;
      }

      if ((var66 & 4194304) != 0) {
         var24 = var0.dealerCountry;
      }

      if ((var66 & 8388608) != 0) {
         var25 = var0.filterType;
      }

      if ((var66 & 16777216) != 0) {
         var26 = var0.filterTrigger;
      }

      if ((var66 & 33554432) != 0) {
         var27 = var0.pm1Ranges;
      }

      if ((var66 & 67108864) != 0) {
         var28 = var0.pm10Ranges;
      }

      if ((var66 & 134217728) != 0) {
         var29 = var0.pm25Ranges;
      }

      if ((var66 & 268435456) != 0) {
         var30 = var0.vocRanges;
      }

      if ((var66 & 536870912) != 0) {
         var31 = var0.hchoRanges;
      }

      if ((var66 & 1073741824) != 0) {
         var32 = var0.updateProgress;
      }

      if ((var66 & Integer.MIN_VALUE) != 0) {
         var33 = var0.isStandByOn;
      }

      if ((var67 & 1) != 0) {
         var34 = var0.isG4NightModeOn;
      }

      if ((var67 & 2) != 0) {
         var35 = var0.g4NightModeFilterTrigger;
      }

      if ((var67 & 4) != 0) {
         var36 = var0.modelName;
      }

      if ((var67 & 8) != 0) {
         var37 = var0.typeIndex;
      }

      if ((var67 & 16) != 0) {
         var38 = var0.sku;
      }

      if ((var67 & 32) != 0) {
         var39 = var0.welcomeHome;
      }

      if ((var67 & 64) != 0) {
         var40 = var0.timerStatus;
      }

      if ((var67 & 128) != 0) {
         var41 = var0.timerDuration;
      }

      if ((var67 & 256) != 0) {
         var42 = var0.timerLeftTime;
      }

      if ((var67 & 512) != 0) {
         var43 = var0.timerLeftTimeUpdateTime;
      }

      if ((var67 & 1024) != 0) {
         var45 = var0.temperatureUnit;
      }

      if ((var67 & 2048) != 0) {
         var46 = var0.oscillationState;
      }

      if ((var67 & 4096) != 0) {
         var47 = var0.oscillationAngle;
      }

      if ((var67 & 8192) != 0) {
         var48 = var0.oscillationDirection;
      }

      if ((var67 & 16384) != 0) {
         var49 = var0.oscillationFanSpeed;
      }

      if ((var67 & '耀') != 0) {
         var50 = var0.mainMode;
      }

      if ((var67 & 65536) != 0) {
         var51 = var0.apSubMode;
      }

      if ((var67 & 131072) != 0) {
         var52 = var0.apFanSpeed;
      }

      if ((var67 & 262144) != 0) {
         var53 = var0.heatSubMode;
      }

      if ((var67 & 524288) != 0) {
         var54 = var0.heatFanSpeed;
      }

      if ((var67 & 1048576) != 0) {
         var55 = var0.heatAutoTmp;
      }

      if ((var67 & 2097152) != 0) {
         var57 = var0.heatEcoTmp;
      }

      if ((var67 & 4194304) != 0) {
         var59 = var0.coolSubMode;
      }

      if ((var67 & 8388608) != 0) {
         var60 = var0.coolFanSpeed;
      }

      if ((var67 & 16777216) != 0) {
         var61 = var0.coolAutoTag;
      }

      if ((var67 & 33554432) != 0) {
         var62 = var0.coolAutoPresets;
      }

      if ((var67 & 67108864) != 0) {
         var63 = var0.coolEcoTag;
      }

      if ((var67 & 134217728) != 0) {
         var64 = var0.coolEcoPresets;
      }

      if ((var67 & 268435456) != 0) {
         var65 = var0.locationId;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26, var27, var28, var29, var30, var31, var32, var33, var34, var35, var36, var37, var38, var39, var40, var41, var42, var43, var45, var46, var47, var48, var49, var50, var51, var52, var53, var54, var55, var57, var59, var60, var61, var62, var63, var64, var65);
   }

   public double[] airRatingsFor(SensorType var1) {
      return HasSensorData$_CC.$default$airRatingsFor(this, var1);
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
      return this.temperatureUnit;
   }

   public final int component44() {
      return this.oscillationState;
   }

   public final int component45() {
      return this.oscillationAngle;
   }

   public final int component46() {
      return this.oscillationDirection;
   }

   public final int component47() {
      return this.oscillationFanSpeed;
   }

   public final int component48() {
      return this.mainMode;
   }

   public final int component49() {
      return this.apSubMode;
   }

   public final int component5() {
      return this.brightness;
   }

   public final int component50() {
      return this.apFanSpeed;
   }

   public final int component51() {
      return this.heatSubMode;
   }

   public final int component52() {
      return this.heatFanSpeed;
   }

   public final double component53() {
      return this.heatAutoTmp;
   }

   public final double component54() {
      return this.heatEcoTmp;
   }

   public final int component55() {
      return this.coolSubMode;
   }

   public final int component56() {
      return this.coolFanSpeed;
   }

   public final int component57() {
      return this.coolAutoTag;
   }

   public final double[] component58() {
      return this.coolAutoPresets;
   }

   public final int component59() {
      return this.coolEcoTag;
   }

   public final String component6() {
      return this.autoModeText;
   }

   public final double[] component60() {
      return this.coolEcoPresets;
   }

   public final String component61() {
      return this.locationId;
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

   public final DeviceCombo3in1 copy(String var1, String var2, int var3, Integer var4, int var5, String var6, String var7, DeviceUuid var8, boolean var9, IndoorDatapoint var10, int var11, boolean var12, int var13, long var14, String var16, String var17, String var18, String var19, String var20, String var21, String var22, String var23, String var24, String var25, String var26, double[] var27, double[] var28, double[] var29, double[] var30, double[] var31, int var32, boolean var33, boolean var34, String var35, String var36, int var37, String var38, WelcomeHomeLocation var39, int var40, int var41, int var42, long var43, int var45, int var46, int var47, int var48, int var49, int var50, int var51, int var52, int var53, int var54, double var55, double var57, int var59, int var60, int var61, double[] var62, int var63, double[] var64, String var65) {
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
      Intrinsics.checkNotNullParameter(var62, "coolAutoPresets");
      Intrinsics.checkNotNullParameter(var64, "coolEcoPresets");
      return new DeviceCombo3in1(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26, var27, var28, var29, var30, var31, var32, var33, var34, var35, var36, var37, var38, var39, var40, var41, var42, var43, var45, var46, var47, var48, var49, var50, var51, var52, var53, var54, var55, var57, var59, var60, var61, var62, var63, var64, var65);
   }

   public int currentFanSpeed() {
      return HasCombo3in1MainMode$_CC.$default$currentFanSpeed(this);
   }

   public FanSpeedEnum currentFanSpeedEnum() {
      return HasCombo3in1MainMode$_CC.$default$currentFanSpeedEnum(this);
   }

   public ApSubMode currentSubMode() {
      return HasCombo3in1MainMode$_CC.$default$currentSubMode(this);
   }

   public final int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DeviceCombo3in1)) {
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
         } else if (this.temperatureUnit != var1.temperatureUnit) {
            return false;
         } else if (this.oscillationState != var1.oscillationState) {
            return false;
         } else if (this.oscillationAngle != var1.oscillationAngle) {
            return false;
         } else if (this.oscillationDirection != var1.oscillationDirection) {
            return false;
         } else if (this.oscillationFanSpeed != var1.oscillationFanSpeed) {
            return false;
         } else if (this.mainMode != var1.mainMode) {
            return false;
         } else if (this.apSubMode != var1.apSubMode) {
            return false;
         } else if (this.apFanSpeed != var1.apFanSpeed) {
            return false;
         } else if (this.heatSubMode != var1.heatSubMode) {
            return false;
         } else if (this.heatFanSpeed != var1.heatFanSpeed) {
            return false;
         } else if (Double.compare(this.heatAutoTmp, var1.heatAutoTmp) != 0) {
            return false;
         } else if (Double.compare(this.heatEcoTmp, var1.heatEcoTmp) != 0) {
            return false;
         } else if (this.coolSubMode != var1.coolSubMode) {
            return false;
         } else if (this.coolFanSpeed != var1.coolFanSpeed) {
            return false;
         } else if (this.coolAutoTag != var1.coolAutoTag) {
            return false;
         } else if (!Intrinsics.areEqual(this.coolAutoPresets, var1.coolAutoPresets)) {
            return false;
         } else if (this.coolEcoTag != var1.coolEcoTag) {
            return false;
         } else if (!Intrinsics.areEqual(this.coolEcoPresets, var1.coolEcoPresets)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.locationId, var1.locationId);
         }
      }
   }

   public IndoorAirRatingRanges getAirRatingRanges() {
      return HasSensorData$_CC.$default$getAirRatingRanges(this);
   }

   public int getApFanSpeed() {
      return this.apFanSpeed;
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

   public ConnectivityStatus getConnectivityStatus() {
      return Device$_CC.$default$getConnectivityStatus(this);
   }

   public int getConnectivityStatusIndex() {
      return this.connectivityStatusIndex;
   }

   public double[] getCoolAutoPresets() {
      return this.coolAutoPresets;
   }

   public int getCoolAutoTag() {
      return this.coolAutoTag;
   }

   public double[] getCoolEcoPresets() {
      return this.coolEcoPresets;
   }

   public int getCoolEcoTag() {
      return this.coolEcoTag;
   }

   public int getCoolFanSpeed() {
      return this.coolFanSpeed;
   }

   public int getCoolSubMode() {
      return this.coolSubMode;
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

   public double getHeatAutoTmp() {
      return this.heatAutoTmp;
   }

   public double getHeatEcoTmp() {
      return this.heatEcoTmp;
   }

   public int getHeatFanSpeed() {
      return this.heatFanSpeed;
   }

   public int getHeatSubMode() {
      return this.heatSubMode;
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

   public String getLocationId() {
      return this.locationId;
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

   public int getOscillationAngle() {
      return this.oscillationAngle;
   }

   public int getOscillationDirection() {
      return this.oscillationDirection;
   }

   public int getOscillationFanSpeed() {
      return this.oscillationFanSpeed;
   }

   public int getOscillationState() {
      return this.oscillationState;
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

   public String getSerial() {
      return this.serial;
   }

   public String getSku() {
      return this.sku;
   }

   public int getTemperatureUnit() {
      return this.temperatureUnit;
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
      int var10 = this.name.hashCode();
      int var9 = this.fanSpeed;
      Integer var62 = this.filterLife;
      int var7 = 0;
      int var1;
      if (var62 == null) {
         var1 = 0;
      } else {
         var1 = var62.hashCode();
      }

      int var12 = this.brightness;
      int var11 = this.autoModeText.hashCode();
      String var63 = this.info;
      int var2;
      if (var63 == null) {
         var2 = 0;
      } else {
         var2 = var63.hashCode();
      }

      DeviceUuid var64 = this.deviceUuid;
      int var3;
      if (var64 == null) {
         var3 = 0;
      } else {
         var3 = var64.hashCode();
      }

      int var13 = AddDeviceState$$ExternalSyntheticBackport0.m(this.hasFinishedOnboarding);
      IndoorDatapoint var65 = this.latestSensorDatapoint;
      int var4;
      if (var65 == null) {
         var4 = 0;
      } else {
         var4 = var65.hashCode();
      }

      int var38 = this.lastSelectedSensorTypeIndex;
      int var20 = AddDeviceState$$ExternalSyntheticBackport0.m(this.isChildLockOn);
      int var29 = this.connectivityStatusIndex;
      int var37 = AddDeviceState$$ExternalSyntheticBackport0.m(this.lastConnectivityInMillis);
      int var28 = this.mac.hashCode();
      int var21 = this.mcuFirmware.hashCode();
      int var25 = this.wifiFirmware.hashCode();
      int var17 = this.hardware.hashCode();
      int var24 = this.timeZone.hashCode();
      int var27 = this.serial.hashCode();
      int var34 = this.purchaseDate.hashCode();
      int var31 = this.dealerName.hashCode();
      int var36 = this.dealerCountry.hashCode();
      int var33 = this.filterType.hashCode();
      int var32 = this.filterTrigger.hashCode();
      int var14 = Arrays.hashCode(this.pm1Ranges);
      int var30 = Arrays.hashCode(this.pm10Ranges);
      int var15 = Arrays.hashCode(this.pm25Ranges);
      int var18 = Arrays.hashCode(this.vocRanges);
      int var16 = Arrays.hashCode(this.hchoRanges);
      int var19 = this.updateProgress;
      int var35 = AddDeviceState$$ExternalSyntheticBackport0.m(this.isStandByOn);
      int var23 = AddDeviceState$$ExternalSyntheticBackport0.m(this.isG4NightModeOn);
      int var22 = this.g4NightModeFilterTrigger.hashCode();
      int var39 = this.modelName.hashCode();
      int var26 = this.typeIndex;
      String var66 = this.sku;
      int var5;
      if (var66 == null) {
         var5 = 0;
      } else {
         var5 = var66.hashCode();
      }

      WelcomeHomeLocation var67 = this.welcomeHome;
      int var6;
      if (var67 == null) {
         var6 = 0;
      } else {
         var6 = var67.hashCode();
      }

      int var42 = this.timerStatus;
      int var58 = this.timerDuration;
      int var43 = this.timerLeftTime;
      int var46 = AddDeviceState$$ExternalSyntheticBackport0.m(this.timerLeftTimeUpdateTime);
      int var51 = this.temperatureUnit;
      int var47 = this.oscillationState;
      int var45 = this.oscillationAngle;
      int var50 = this.oscillationDirection;
      int var60 = this.oscillationFanSpeed;
      int var48 = this.mainMode;
      int var56 = this.apSubMode;
      int var54 = this.apFanSpeed;
      int var53 = this.heatSubMode;
      int var41 = this.heatFanSpeed;
      int var57 = AddDeviceState$$ExternalSyntheticBackport0.m(this.heatAutoTmp);
      int var44 = AddDeviceState$$ExternalSyntheticBackport0.m(this.heatEcoTmp);
      int var61 = this.coolSubMode;
      int var49 = this.coolFanSpeed;
      int var52 = this.coolAutoTag;
      int var55 = Arrays.hashCode(this.coolAutoPresets);
      int var59 = this.coolEcoTag;
      int var40 = Arrays.hashCode(this.coolEcoPresets);
      String var68 = this.locationId;
      if (var68 != null) {
         var7 = var68.hashCode();
      }

      return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((var8 * 31 + var10) * 31 + var9) * 31 + var1) * 31 + var12) * 31 + var11) * 31 + var2) * 31 + var3) * 31 + var13) * 31 + var4) * 31 + var38) * 31 + var20) * 31 + var29) * 31 + var37) * 31 + var28) * 31 + var21) * 31 + var25) * 31 + var17) * 31 + var24) * 31 + var27) * 31 + var34) * 31 + var31) * 31 + var36) * 31 + var33) * 31 + var32) * 31 + var14) * 31 + var30) * 31 + var15) * 31 + var18) * 31 + var16) * 31 + var19) * 31 + var35) * 31 + var23) * 31 + var22) * 31 + var39) * 31 + var26) * 31 + var5) * 31 + var6) * 31 + var42) * 31 + var58) * 31 + var43) * 31 + var46) * 31 + var51) * 31 + var47) * 31 + var45) * 31 + var50) * 31 + var60) * 31 + var48) * 31 + var56) * 31 + var54) * 31 + var53) * 31 + var41) * 31 + var57) * 31 + var44) * 31 + var61) * 31 + var49) * 31 + var52) * 31 + var55) * 31 + var59) * 31 + var40) * 31 + var7;
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

   public boolean isInApSubMode(ApSubMode var1) {
      return HasMainMode$_CC.$default$isInApSubMode(this, var1);
   }

   public boolean isInMainMode(MainMode var1) {
      return HasMainMode$_CC.$default$isInMainMode(this, var1);
   }

   public boolean isInSubMode(ApSubMode var1) {
      return HasCombo3in1MainMode$_CC.$default$isInSubMode(this, var1);
   }

   public boolean isOnline() {
      return Device$_CC.$default$isOnline(this);
   }

   public boolean isOscillationEnabled() {
      return HasOscillation$_CC.$default$isOscillationEnabled(this);
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

   public OscillationDirection oscillationDirection() {
      return HasOscillation$_CC.$default$oscillationDirection(this);
   }

   public OscillationFanSpeed oscillationFanSpeed() {
      return HasOscillation$_CC.$default$oscillationFanSpeed(this);
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
      StringBuilder var1 = new StringBuilder("DeviceCombo3in1(uid=");
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
      var1.append(", temperatureUnit=");
      var1.append(this.temperatureUnit);
      var1.append(", oscillationState=");
      var1.append(this.oscillationState);
      var1.append(", oscillationAngle=");
      var1.append(this.oscillationAngle);
      var1.append(", oscillationDirection=");
      var1.append(this.oscillationDirection);
      var1.append(", oscillationFanSpeed=");
      var1.append(this.oscillationFanSpeed);
      var1.append(", mainMode=");
      var1.append(this.mainMode);
      var1.append(", apSubMode=");
      var1.append(this.apSubMode);
      var1.append(", apFanSpeed=");
      var1.append(this.apFanSpeed);
      var1.append(", heatSubMode=");
      var1.append(this.heatSubMode);
      var1.append(", heatFanSpeed=");
      var1.append(this.heatFanSpeed);
      var1.append(", heatAutoTmp=");
      var1.append(this.heatAutoTmp);
      var1.append(", heatEcoTmp=");
      var1.append(this.heatEcoTmp);
      var1.append(", coolSubMode=");
      var1.append(this.coolSubMode);
      var1.append(", coolFanSpeed=");
      var1.append(this.coolFanSpeed);
      var1.append(", coolAutoTag=");
      var1.append(this.coolAutoTag);
      var1.append(", coolAutoPresets=");
      var1.append(Arrays.toString(this.coolAutoPresets));
      var1.append(", coolEcoTag=");
      var1.append(this.coolEcoTag);
      var1.append(", coolEcoPresets=");
      var1.append(Arrays.toString(this.coolEcoPresets));
      var1.append(", locationId=");
      var1.append(this.locationId);
      var1.append(')');
      return var1.toString();
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
      var1.writeInt(this.temperatureUnit);
      var1.writeInt(this.oscillationState);
      var1.writeInt(this.oscillationAngle);
      var1.writeInt(this.oscillationDirection);
      var1.writeInt(this.oscillationFanSpeed);
      var1.writeInt(this.mainMode);
      var1.writeInt(this.apSubMode);
      var1.writeInt(this.apFanSpeed);
      var1.writeInt(this.heatSubMode);
      var1.writeInt(this.heatFanSpeed);
      var1.writeDouble(this.heatAutoTmp);
      var1.writeDouble(this.heatEcoTmp);
      var1.writeInt(this.coolSubMode);
      var1.writeInt(this.coolFanSpeed);
      var1.writeInt(this.coolAutoTag);
      var1.writeDoubleArray(this.coolAutoPresets);
      var1.writeInt(this.coolEcoTag);
      var1.writeDoubleArray(this.coolEcoPresets);
      var1.writeString(this.locationId);
   }

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Creator implements Parcelable.Creator {
      public final DeviceCombo3in1 createFromParcel(Parcel var1) {
         Intrinsics.checkNotNullParameter(var1, "parcel");
         String var18 = var1.readString();
         String var17 = var1.readString();
         int var2 = var1.readInt();
         int var3 = var1.readInt();
         Object var16 = null;
         Integer var14;
         if (var3 == 0) {
            var14 = null;
         } else {
            var14 = var1.readInt();
         }

         int var5 = var1.readInt();
         String var20 = var1.readString();
         String var19 = var1.readString();
         Object var15;
         if (var1.readInt() == 0) {
            var15 = null;
         } else {
            var15 = DeviceUuid.CREATOR.createFromParcel(var1);
         }

         DeviceUuid var21 = (DeviceUuid)var15;
         boolean var8;
         if (var1.readInt() != 0) {
            var8 = true;
         } else {
            var8 = false;
         }

         if (var1.readInt() == 0) {
            var15 = null;
         } else {
            var15 = IndoorDatapoint.CREATOR.createFromParcel(var1);
         }

         IndoorDatapoint var26 = (IndoorDatapoint)var15;
         int var4 = var1.readInt();
         boolean var9;
         if (var1.readInt() != 0) {
            var9 = true;
         } else {
            var9 = false;
         }

         int var6 = var1.readInt();
         long var12 = var1.readLong();
         String var33 = var1.readString();
         String var27 = var1.readString();
         String var24 = var1.readString();
         String var34 = var1.readString();
         String var39 = var1.readString();
         String var23 = var1.readString();
         String var40 = var1.readString();
         String var36 = var1.readString();
         String var32 = var1.readString();
         String var38 = var1.readString();
         String var41 = var1.readString();
         double[] var22 = var1.createDoubleArray();
         double[] var30 = var1.createDoubleArray();
         double[] var28 = var1.createDoubleArray();
         double[] var31 = var1.createDoubleArray();
         boolean var10 = false;
         double[] var29 = var1.createDoubleArray();
         boolean var11 = true;
         var3 = var1.readInt();
         if (var1.readInt() != 0) {
            var10 = true;
         }

         if (var1.readInt() == 0) {
            var11 = false;
         }

         String var37 = var1.readString();
         String var35 = var1.readString();
         int var7 = var1.readInt();
         String var25 = var1.readString();
         if (var1.readInt() == 0) {
            var15 = var16;
         } else {
            var15 = WelcomeHomeLocation.CREATOR.createFromParcel(var1);
         }

         return new DeviceCombo3in1(var18, var17, var2, var14, var5, var20, var19, var21, var8, var26, var4, var9, var6, var12, var33, var27, var24, var34, var39, var23, var40, var36, var32, var38, var41, var22, var30, var28, var31, var29, var3, var10, var11, var37, var35, var7, var25, (WelcomeHomeLocation)var15, var1.readInt(), var1.readInt(), var1.readInt(), var1.readLong(), var1.readInt(), var1.readInt(), var1.readInt(), var1.readInt(), var1.readInt(), var1.readInt(), var1.readInt(), var1.readInt(), var1.readInt(), var1.readInt(), var1.readDouble(), var1.readDouble(), var1.readInt(), var1.readInt(), var1.readInt(), var1.createDoubleArray(), var1.readInt(), var1.createDoubleArray(), var1.readString());
      }

      public final DeviceCombo3in1[] newArray(int var1) {
         return new DeviceCombo3in1[var1];
      }
   }
}
