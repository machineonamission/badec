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
   d1 = {"\u0000¥\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0013\n\u0002\b\n\n\u0002\u0018\u0002\n\u0003\b\u0084\u0001\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\r2\u00020\u000e2\u00020\u000f2\u00020\u00102\u00020\u00112\u00020\u00122\u00020\u0013B\u0091\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010\u001f\u001a\u00020 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010#\u001a\u00020\u0018\u0012\b\b\u0002\u0010$\u001a\u00020 \u0012\b\b\u0002\u0010%\u001a\u00020\u0018\u0012\b\b\u0002\u0010&\u001a\u00020'\u0012\b\b\u0002\u0010(\u001a\u00020\u0015\u0012\b\b\u0002\u0010)\u001a\u00020\u0015\u0012\b\b\u0002\u0010*\u001a\u00020\u0015\u0012\b\b\u0002\u0010+\u001a\u00020\u0015\u0012\b\b\u0002\u0010,\u001a\u00020\u0015\u0012\b\b\u0002\u0010-\u001a\u00020\u0015\u0012\b\b\u0002\u0010.\u001a\u00020\u0015\u0012\b\b\u0002\u0010/\u001a\u00020\u0015\u0012\b\b\u0002\u00100\u001a\u00020\u0015\u0012\b\b\u0002\u00101\u001a\u00020\u0015\u0012\b\b\u0002\u00102\u001a\u00020\u0015\u0012\b\b\u0002\u00103\u001a\u000204\u0012\b\b\u0002\u00105\u001a\u000204\u0012\b\b\u0002\u00106\u001a\u000204\u0012\b\b\u0002\u00107\u001a\u000204\u0012\b\b\u0002\u00108\u001a\u000204\u0012\b\b\u0002\u00109\u001a\u00020\u0018\u0012\b\b\u0002\u0010:\u001a\u00020 \u0012\b\b\u0002\u0010;\u001a\u00020\u0015\u0012\b\b\u0002\u0010<\u001a\u00020\u0018\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?\u0012\b\b\u0002\u0010@\u001a\u00020 \u0012\b\b\u0002\u0010A\u001a\u00020 \u0012\b\b\u0002\u0010B\u001a\u00020\u0018\u0012\b\b\u0002\u0010C\u001a\u00020'\u0012\b\b\u0002\u0010D\u001a\u00020\u0018\u0012\b\b\u0002\u0010E\u001a\u00020 \u0012\b\b\u0002\u0010F\u001a\u00020\u0018\u0012\b\b\u0002\u0010G\u001a\u00020\u0018\u0012\b\b\u0002\u0010H\u001a\u00020\u0018\u0012\b\b\u0002\u0010I\u001a\u00020\u0018\u0012\b\b\u0002\u0010J\u001a\u00020'\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010L\u001a\u00020\u0018\u0012\b\b\u0002\u0010M\u001a\u00020 \u0012\b\b\u0002\u0010N\u001a\u00020\u0018¢\u0006\u0004\bO\u0010PJ\n\u0010\u008c\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u008d\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u008e\u0001\u001a\u00020\u0018HÆ\u0003J\u0011\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u0010WJ\n\u0010\u0090\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010\u0091\u0001\u001a\u00020\u0015HÆ\u0003J\f\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\f\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\n\u0010\u0094\u0001\u001a\u00020 HÆ\u0003J\f\u0010\u0095\u0001\u001a\u0004\u0018\u00010\"HÆ\u0003J\n\u0010\u0096\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010\u0097\u0001\u001a\u00020 HÆ\u0003J\n\u0010\u0098\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010\u0099\u0001\u001a\u00020'HÆ\u0003J\n\u0010\u009a\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u009b\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u009c\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u009d\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u009e\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u009f\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010 \u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010¡\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010¢\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010£\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010¤\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010¥\u0001\u001a\u000204HÆ\u0003J\n\u0010¦\u0001\u001a\u000204HÆ\u0003J\n\u0010§\u0001\u001a\u000204HÆ\u0003J\n\u0010¨\u0001\u001a\u000204HÆ\u0003J\n\u0010©\u0001\u001a\u000204HÆ\u0003J\n\u0010ª\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010«\u0001\u001a\u00020 HÆ\u0003J\n\u0010¬\u0001\u001a\u00020\u0015HÆ\u0003J\n\u0010\u00ad\u0001\u001a\u00020\u0018HÆ\u0003J\f\u0010®\u0001\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\f\u0010¯\u0001\u001a\u0004\u0018\u00010?HÆ\u0003J\n\u0010°\u0001\u001a\u00020 HÆ\u0003J\n\u0010±\u0001\u001a\u00020 HÆ\u0003J\n\u0010²\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010³\u0001\u001a\u00020'HÆ\u0003J\n\u0010´\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010µ\u0001\u001a\u00020 HÆ\u0003J\n\u0010¶\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010·\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010¸\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010¹\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010º\u0001\u001a\u00020'HÆ\u0003J\f\u0010»\u0001\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\n\u0010¼\u0001\u001a\u00020\u0018HÆ\u0003J\n\u0010½\u0001\u001a\u00020 HÆ\u0003J\n\u0010¾\u0001\u001a\u00020\u0018HÆ\u0003J\u009c\u0004\u0010¿\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u00152\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\b\b\u0002\u0010#\u001a\u00020\u00182\b\b\u0002\u0010$\u001a\u00020 2\b\b\u0002\u0010%\u001a\u00020\u00182\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u00152\b\b\u0002\u0010)\u001a\u00020\u00152\b\b\u0002\u0010*\u001a\u00020\u00152\b\b\u0002\u0010+\u001a\u00020\u00152\b\b\u0002\u0010,\u001a\u00020\u00152\b\b\u0002\u0010-\u001a\u00020\u00152\b\b\u0002\u0010.\u001a\u00020\u00152\b\b\u0002\u0010/\u001a\u00020\u00152\b\b\u0002\u00100\u001a\u00020\u00152\b\b\u0002\u00101\u001a\u00020\u00152\b\b\u0002\u00102\u001a\u00020\u00152\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002042\b\b\u0002\u00106\u001a\u0002042\b\b\u0002\u00107\u001a\u0002042\b\b\u0002\u00108\u001a\u0002042\b\b\u0002\u00109\u001a\u00020\u00182\b\b\u0002\u0010:\u001a\u00020 2\b\b\u0002\u0010;\u001a\u00020\u00152\b\b\u0002\u0010<\u001a\u00020\u00182\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?2\b\b\u0002\u0010@\u001a\u00020 2\b\b\u0002\u0010A\u001a\u00020 2\b\b\u0002\u0010B\u001a\u00020\u00182\b\b\u0002\u0010C\u001a\u00020'2\b\b\u0002\u0010D\u001a\u00020\u00182\b\b\u0002\u0010E\u001a\u00020 2\b\b\u0002\u0010F\u001a\u00020\u00182\b\b\u0002\u0010G\u001a\u00020\u00182\b\b\u0002\u0010H\u001a\u00020\u00182\b\b\u0002\u0010I\u001a\u00020\u00182\b\b\u0002\u0010J\u001a\u00020'2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010L\u001a\u00020\u00182\b\b\u0002\u0010M\u001a\u00020 2\b\b\u0002\u0010N\u001a\u00020\u0018HÆ\u0001¢\u0006\u0003\u0010À\u0001J\u0007\u0010Á\u0001\u001a\u00020\u0018J\u0016\u0010Â\u0001\u001a\u00020 2\n\u0010Ã\u0001\u001a\u0005\u0018\u00010Ä\u0001HÖ\u0003J\n\u0010Å\u0001\u001a\u00020\u0018HÖ\u0001J\n\u0010Æ\u0001\u001a\u00020\u0015HÖ\u0001J\u001b\u0010Ç\u0001\u001a\u00030È\u00012\b\u0010É\u0001\u001a\u00030Ê\u00012\u0007\u0010Ë\u0001\u001a\u00020\u0018R\u0014\u0010\u0014\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010RR\u0014\u0010\u0016\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010RR\u0014\u0010\u0017\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u0018X\u0096\u0004¢\u0006\n\n\u0002\u0010X\u001a\u0004\bV\u0010WR\u0014\u0010\u001a\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010UR\u0014\u0010\u001b\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010RR\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010RR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u0014\u0010\u001f\u001a\u00020 X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u0010_R\u0016\u0010!\u001a\u0004\u0018\u00010\"X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b`\u0010aR\u0014\u0010#\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010UR\u0014\u0010$\u001a\u00020 X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010_R\u0014\u0010%\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bc\u0010UR\u0014\u0010&\u001a\u00020'X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bd\u0010eR\u0014\u0010(\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bf\u0010RR\u0014\u0010)\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bg\u0010RR\u0014\u0010*\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010RR\u0014\u0010+\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bi\u0010RR\u0014\u0010,\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bj\u0010RR\u0014\u0010-\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bk\u0010RR\u0014\u0010.\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bl\u0010RR\u0014\u0010/\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bm\u0010RR\u0014\u00100\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bn\u0010RR\u0014\u00101\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bo\u0010RR\u0014\u00102\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bp\u0010RR\u0014\u00103\u001a\u000204X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bq\u0010rR\u0014\u00105\u001a\u000204X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bs\u0010rR\u0014\u00106\u001a\u000204X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bt\u0010rR\u0014\u00107\u001a\u000204X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010rR\u0014\u00108\u001a\u000204X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bv\u0010rR\u0014\u00109\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bw\u0010UR\u0014\u0010:\u001a\u00020 X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010_R\u0014\u0010;\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bx\u0010RR\u0014\u0010<\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\by\u0010UR\u0016\u0010=\u001a\u0004\u0018\u00010\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bz\u0010RR\u0016\u0010>\u001a\u0004\u0018\u00010?X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b{\u0010|R\u0014\u0010@\u001a\u00020 X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b}\u0010_R\u0014\u0010A\u001a\u00020 X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b~\u0010_R\u0014\u0010B\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u007f\u0010UR\u0015\u0010C\u001a\u00020'X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0080\u0001\u0010eR\u0015\u0010D\u001a\u00020\u0018X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0081\u0001\u0010UR\u0015\u0010E\u001a\u00020 X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0082\u0001\u0010_R\u0015\u0010F\u001a\u00020\u0018X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0083\u0001\u0010UR\u0015\u0010G\u001a\u00020\u0018X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0084\u0001\u0010UR\u0015\u0010H\u001a\u00020\u0018X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0085\u0001\u0010UR\u0015\u0010I\u001a\u00020\u0018X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0086\u0001\u0010UR\u0015\u0010J\u001a\u00020'X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0087\u0001\u0010eR\u0017\u0010K\u001a\u0004\u0018\u00010\u0015X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0088\u0001\u0010RR\u0015\u0010L\u001a\u00020\u0018X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0089\u0001\u0010UR\u0015\u0010M\u001a\u00020 X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008a\u0001\u0010_R\u0015\u0010N\u001a\u00020\u0018X\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u008b\u0001\u0010U¨\u0006Ì\u0001"},
   d2 = {"Lcom/blueair/core/model/DeviceCombo2in1;", "Lcom/blueair/core/model/Device;", "Lcom/blueair/core/model/HasFanSpeed;", "Lcom/blueair/core/model/HasInfo;", "Lcom/blueair/core/model/HasBlueProvisionCalls;", "Lcom/blueair/core/model/HasSensorData;", "Lcom/blueair/core/model/HasBlueCloudFunctions;", "Lcom/blueair/core/model/HasChildLock;", "Lcom/blueair/core/model/HasBrightness;", "Lcom/blueair/core/model/HasStandBy;", "Lcom/blueair/core/model/HasScheduling;", "Lcom/blueair/core/model/HasSKU;", "Lcom/blueair/core/model/HasWelcomeHome;", "Lcom/blueair/core/model/HasWick;", "Lcom/blueair/core/model/HasAutoRh;", "Lcom/blueair/core/model/HasTimer;", "Lcom/blueair/core/model/HasLocation;", "Lcom/blueair/core/model/HasMode;", "Lcom/blueair/core/model/HasWaterLevel;", "Lcom/blueair/core/model/HasHumMode;", "uid", "", "name", "fanSpeed", "", "filterLife", "brightness", "autoModeText", "info", "deviceUuid", "Lcom/blueair/core/model/DeviceUuid;", "hasFinishedOnboarding", "", "latestSensorDatapoint", "Lcom/blueair/core/model/IndoorDatapoint;", "lastSelectedSensorTypeIndex", "isChildLockOn", "connectivityStatusIndex", "lastConnectivityInMillis", "", "mac", "mcuFirmware", "wifiFirmware", "hardware", "timeZone", "serial", "purchaseDate", "dealerName", "dealerCountry", "filterType", "filterTrigger", "pm1Ranges", "", "pm10Ranges", "pm25Ranges", "vocRanges", "hchoRanges", "updateProgress", "isStandByOn", "modelName", "typeIndex", "sku", "welcomeHome", "Lcom/blueair/core/model/WelcomeHomeLocation;", "wickdryEnabled", "wickdryOn", "wickdryLeftTime", "wickdryLeftTimeUpdateTime", "wickUsage", "waterShortage", "autoRh", "timerStatus", "timerDuration", "timerLeftTime", "timerLeftTimeUpdateTime", "locationId", "mode", "humMode", "waterLevel", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/DeviceUuid;ZLcom/blueair/core/model/IndoorDatapoint;IZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[D[D[D[D[DIZLjava/lang/String;ILjava/lang/String;Lcom/blueair/core/model/WelcomeHomeLocation;ZZIJIZIIIIJLjava/lang/String;IZI)V", "getUid", "()Ljava/lang/String;", "getName", "getFanSpeed", "()I", "getFilterLife", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBrightness", "getAutoModeText", "getInfo", "getDeviceUuid", "()Lcom/blueair/core/model/DeviceUuid;", "getHasFinishedOnboarding", "()Z", "getLatestSensorDatapoint", "()Lcom/blueair/core/model/IndoorDatapoint;", "getLastSelectedSensorTypeIndex", "getConnectivityStatusIndex", "getLastConnectivityInMillis", "()J", "getMac", "getMcuFirmware", "getWifiFirmware", "getHardware", "getTimeZone", "getSerial", "getPurchaseDate", "getDealerName", "getDealerCountry", "getFilterType", "getFilterTrigger", "getPm1Ranges", "()[D", "getPm10Ranges", "getPm25Ranges", "getVocRanges", "getHchoRanges", "getUpdateProgress", "getModelName", "getTypeIndex", "getSku", "getWelcomeHome", "()Lcom/blueair/core/model/WelcomeHomeLocation;", "getWickdryEnabled", "getWickdryOn", "getWickdryLeftTime", "getWickdryLeftTimeUpdateTime", "getWickUsage", "getWaterShortage", "getAutoRh", "getTimerStatus", "getTimerDuration", "getTimerLeftTime", "getTimerLeftTimeUpdateTime", "getLocationId", "getMode", "getHumMode", "getWaterLevel", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component50", "component51", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/DeviceUuid;ZLcom/blueair/core/model/IndoorDatapoint;IZIJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[D[D[D[D[DIZLjava/lang/String;ILjava/lang/String;Lcom/blueair/core/model/WelcomeHomeLocation;ZZIJIZIIIIJLjava/lang/String;IZI)Lcom/blueair/core/model/DeviceCombo2in1;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceCombo2in1 implements Device, HasFanSpeed, HasInfo, HasBlueProvisionCalls, HasSensorData, HasBlueCloudFunctions, HasChildLock, HasBrightness, HasStandBy, HasScheduling, HasSKU, HasWelcomeHome, HasWick, HasAutoRh, HasTimer, HasLocation, HasMode, HasWaterLevel, HasHumMode {
   public static final Parcelable.Creator CREATOR = new Creator();
   private final String autoModeText;
   private final int autoRh;
   private final int brightness;
   private final int connectivityStatusIndex;
   private final String dealerCountry;
   private final String dealerName;
   private final DeviceUuid deviceUuid;
   private final int fanSpeed;
   private final Integer filterLife;
   private final String filterTrigger;
   private final String filterType;
   private final String hardware;
   private final boolean hasFinishedOnboarding;
   private final double[] hchoRanges;
   private final boolean humMode;
   private final String info;
   private final boolean isChildLockOn;
   private final boolean isStandByOn;
   private final long lastConnectivityInMillis;
   private final int lastSelectedSensorTypeIndex;
   private final IndoorDatapoint latestSensorDatapoint;
   private final String locationId;
   private final String mac;
   private final String mcuFirmware;
   private final int mode;
   private final String modelName;
   private final String name;
   private final double[] pm10Ranges;
   private final double[] pm1Ranges;
   private final double[] pm25Ranges;
   private final String purchaseDate;
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
   private final int waterLevel;
   private final boolean waterShortage;
   private final WelcomeHomeLocation welcomeHome;
   private final int wickUsage;
   private final boolean wickdryEnabled;
   private final int wickdryLeftTime;
   private final long wickdryLeftTimeUpdateTime;
   private final boolean wickdryOn;
   private final String wifiFirmware;

   public DeviceCombo2in1(String var1, String var2, int var3, Integer var4, int var5, String var6, String var7, DeviceUuid var8, boolean var9, IndoorDatapoint var10, int var11, boolean var12, int var13, long var14, String var16, String var17, String var18, String var19, String var20, String var21, String var22, String var23, String var24, String var25, String var26, double[] var27, double[] var28, double[] var29, double[] var30, double[] var31, int var32, boolean var33, String var34, int var35, String var36, WelcomeHomeLocation var37, boolean var38, boolean var39, int var40, long var41, int var43, boolean var44, int var45, int var46, int var47, int var48, long var49, String var51, int var52, boolean var53, int var54) {
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
      Intrinsics.checkNotNullParameter(var34, "modelName");
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
      this.modelName = var34;
      this.typeIndex = var35;
      this.sku = var36;
      this.welcomeHome = var37;
      this.wickdryEnabled = var38;
      this.wickdryOn = var39;
      this.wickdryLeftTime = var40;
      this.wickdryLeftTimeUpdateTime = var41;
      this.wickUsage = var43;
      this.waterShortage = var44;
      this.autoRh = var45;
      this.timerStatus = var46;
      this.timerDuration = var47;
      this.timerLeftTime = var48;
      this.timerLeftTimeUpdateTime = var49;
      this.locationId = var51;
      this.mode = var52;
      this.humMode = var53;
      this.waterLevel = var54;
   }

   // $FF: synthetic method
   public DeviceCombo2in1(String var1, String var2, int var3, Integer var4, int var5, String var6, String var7, DeviceUuid var8, boolean var9, IndoorDatapoint var10, int var11, boolean var12, int var13, long var14, String var16, String var17, String var18, String var19, String var20, String var21, String var22, String var23, String var24, String var25, String var26, double[] var27, double[] var28, double[] var29, double[] var30, double[] var31, int var32, boolean var33, String var34, int var35, String var36, WelcomeHomeLocation var37, boolean var38, boolean var39, int var40, long var41, int var43, boolean var44, int var45, int var46, int var47, int var48, long var49, String var51, int var52, boolean var53, int var54, int var55, int var56, DefaultConstructorMarker var57) {
      if ((var55 & 2) != 0) {
         var2 = "Pairing…";
      }

      if ((var55 & 4) != 0) {
         var3 = 0;
      }

      if ((var55 & 8) != 0) {
         var4 = null;
      }

      if ((var55 & 16) != 0) {
         var5 = 0;
      }

      String var60 = "";
      if ((var55 & 32) != 0) {
         var6 = "";
      }

      if ((var55 & 64) != 0) {
         var7 = null;
      }

      if ((var55 & 128) != 0) {
         var8 = null;
      }

      if ((var55 & 256) != 0) {
         var9 = false;
      }

      if ((var55 & 512) != 0) {
         var10 = null;
      }

      if ((var55 & 1024) != 0) {
         var11 = 0;
      }

      if ((var55 & 2048) != 0) {
         var12 = false;
      }

      if ((var55 & 4096) != 0) {
         var13 = ConnectivityStatus.ONLINE.ordinal();
      }

      long var58 = 0L;
      if ((var55 & 8192) != 0) {
         var14 = 0L;
      }

      if ((var55 & 16384) != 0) {
         var16 = "";
      }

      if ((var55 & '耀') != 0) {
         var17 = "";
      }

      if ((var55 & 65536) != 0) {
         var18 = "";
      }

      if ((var55 & 131072) != 0) {
         var19 = "";
      }

      if ((var55 & 262144) != 0) {
         var20 = "";
      }

      if ((var55 & 524288) != 0) {
         var21 = "";
      }

      if ((var55 & 1048576) != 0) {
         var22 = "";
      }

      if ((var55 & 2097152) != 0) {
         var23 = "";
      }

      if ((var55 & 4194304) != 0) {
         var24 = "";
      }

      if ((var55 & 8388608) != 0) {
         var25 = "";
      }

      if ((var55 & 16777216) != 0) {
         var26 = "";
      }

      if ((var55 & 33554432) != 0) {
         var27 = new double[0];
      }

      if ((var55 & 67108864) != 0) {
         var28 = new double[0];
      }

      if ((var55 & 134217728) != 0) {
         var29 = new double[0];
      }

      if ((var55 & 268435456) != 0) {
         var30 = new double[0];
      }

      if ((var55 & 536870912) != 0) {
         var31 = new double[0];
      }

      if ((var55 & 1073741824) != 0) {
         var32 = 0;
      }

      if ((var55 & Integer.MIN_VALUE) != 0) {
         var33 = false;
      }

      if ((var56 & 1) != 0) {
         var34 = var60;
      }

      if ((var56 & 2) != 0) {
         var35 = DeviceType.Combo2in1.INSTANCE.getIndex();
      }

      if ((var56 & 4) != 0) {
         var36 = null;
      }

      if ((var56 & 8) != 0) {
         var37 = null;
      }

      if ((var56 & 16) != 0) {
         var38 = false;
      }

      if ((var56 & 32) != 0) {
         var39 = false;
      }

      if ((var56 & 64) != 0) {
         var40 = 0;
      }

      if ((var56 & 128) != 0) {
         var41 = 0L;
      }

      if ((var56 & 256) != 0) {
         var43 = 0;
      }

      if ((var56 & 512) != 0) {
         var44 = false;
      }

      if ((var56 & 1024) != 0) {
         var45 = 50;
      }

      if ((var56 & 2048) != 0) {
         var46 = 0;
      }

      if ((var56 & 4096) != 0) {
         var47 = 0;
      }

      if ((var56 & 8192) != 0) {
         var48 = 0;
      }

      if ((var56 & 16384) != 0) {
         var49 = var58;
      }

      if ((var56 & '耀') != 0) {
         var51 = null;
      }

      if ((var56 & 65536) != 0) {
         var52 = 0;
      }

      if ((var56 & 131072) != 0) {
         var53 = false;
      }

      if ((var56 & 262144) != 0) {
         var54 = 0;
      }

      this(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26, var27, var28, var29, var30, var31, var32, var33, var34, var35, var36, var37, var38, var39, var40, var41, var43, var44, var45, var46, var47, var48, var49, var51, var52, var53, var54);
   }

   // $FF: synthetic method
   public static DeviceCombo2in1 copy$default(DeviceCombo2in1 var0, String var1, String var2, int var3, Integer var4, int var5, String var6, String var7, DeviceUuid var8, boolean var9, IndoorDatapoint var10, int var11, boolean var12, int var13, long var14, String var16, String var17, String var18, String var19, String var20, String var21, String var22, String var23, String var24, String var25, String var26, double[] var27, double[] var28, double[] var29, double[] var30, double[] var31, int var32, boolean var33, String var34, int var35, String var36, WelcomeHomeLocation var37, boolean var38, boolean var39, int var40, long var41, int var43, boolean var44, int var45, int var46, int var47, int var48, long var49, String var51, int var52, boolean var53, int var54, int var55, int var56, Object var57) {
      if ((var55 & 1) != 0) {
         var1 = var0.uid;
      }

      if ((var55 & 2) != 0) {
         var2 = var0.name;
      }

      if ((var55 & 4) != 0) {
         var3 = var0.fanSpeed;
      }

      if ((var55 & 8) != 0) {
         var4 = var0.filterLife;
      }

      if ((var55 & 16) != 0) {
         var5 = var0.brightness;
      }

      if ((var55 & 32) != 0) {
         var6 = var0.autoModeText;
      }

      if ((var55 & 64) != 0) {
         var7 = var0.info;
      }

      if ((var55 & 128) != 0) {
         var8 = var0.deviceUuid;
      }

      if ((var55 & 256) != 0) {
         var9 = var0.hasFinishedOnboarding;
      }

      if ((var55 & 512) != 0) {
         var10 = var0.latestSensorDatapoint;
      }

      if ((var55 & 1024) != 0) {
         var11 = var0.lastSelectedSensorTypeIndex;
      }

      if ((var55 & 2048) != 0) {
         var12 = var0.isChildLockOn;
      }

      if ((var55 & 4096) != 0) {
         var13 = var0.connectivityStatusIndex;
      }

      if ((var55 & 8192) != 0) {
         var14 = var0.lastConnectivityInMillis;
      }

      if ((var55 & 16384) != 0) {
         var16 = var0.mac;
      }

      if ((var55 & '耀') != 0) {
         var17 = var0.mcuFirmware;
      }

      if ((var55 & 65536) != 0) {
         var18 = var0.wifiFirmware;
      }

      if ((var55 & 131072) != 0) {
         var19 = var0.hardware;
      }

      if ((var55 & 262144) != 0) {
         var20 = var0.timeZone;
      }

      if ((var55 & 524288) != 0) {
         var21 = var0.serial;
      }

      if ((var55 & 1048576) != 0) {
         var22 = var0.purchaseDate;
      }

      if ((var55 & 2097152) != 0) {
         var23 = var0.dealerName;
      }

      if ((var55 & 4194304) != 0) {
         var24 = var0.dealerCountry;
      }

      if ((var55 & 8388608) != 0) {
         var25 = var0.filterType;
      }

      if ((var55 & 16777216) != 0) {
         var26 = var0.filterTrigger;
      }

      if ((var55 & 33554432) != 0) {
         var27 = var0.pm1Ranges;
      }

      if ((var55 & 67108864) != 0) {
         var28 = var0.pm10Ranges;
      }

      if ((var55 & 134217728) != 0) {
         var29 = var0.pm25Ranges;
      }

      if ((var55 & 268435456) != 0) {
         var30 = var0.vocRanges;
      }

      if ((var55 & 536870912) != 0) {
         var31 = var0.hchoRanges;
      }

      if ((var55 & 1073741824) != 0) {
         var32 = var0.updateProgress;
      }

      if ((var55 & Integer.MIN_VALUE) != 0) {
         var33 = var0.isStandByOn;
      }

      if ((var56 & 1) != 0) {
         var34 = var0.modelName;
      }

      if ((var56 & 2) != 0) {
         var35 = var0.typeIndex;
      }

      if ((var56 & 4) != 0) {
         var36 = var0.sku;
      }

      if ((var56 & 8) != 0) {
         var37 = var0.welcomeHome;
      }

      if ((var56 & 16) != 0) {
         var38 = var0.wickdryEnabled;
      }

      if ((var56 & 32) != 0) {
         var39 = var0.wickdryOn;
      }

      if ((var56 & 64) != 0) {
         var40 = var0.wickdryLeftTime;
      }

      if ((var56 & 128) != 0) {
         var41 = var0.wickdryLeftTimeUpdateTime;
      }

      if ((var56 & 256) != 0) {
         var43 = var0.wickUsage;
      }

      if ((var56 & 512) != 0) {
         var44 = var0.waterShortage;
      }

      if ((var56 & 1024) != 0) {
         var45 = var0.autoRh;
      }

      if ((var56 & 2048) != 0) {
         var46 = var0.timerStatus;
      }

      if ((var56 & 4096) != 0) {
         var47 = var0.timerDuration;
      }

      if ((var56 & 8192) != 0) {
         var48 = var0.timerLeftTime;
      }

      if ((var56 & 16384) != 0) {
         var49 = var0.timerLeftTimeUpdateTime;
      }

      if ((var56 & '耀') != 0) {
         var51 = var0.locationId;
      }

      if ((var56 & 65536) != 0) {
         var52 = var0.mode;
      }

      if ((var56 & 131072) != 0) {
         var53 = var0.humMode;
      }

      if ((var56 & 262144) != 0) {
         var54 = var0.waterLevel;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26, var27, var28, var29, var30, var31, var32, var33, var34, var35, var36, var37, var38, var39, var40, var41, var43, var44, var45, var46, var47, var48, var49, var51, var52, var53, var54);
   }

   public double[] airRatingsFor(SensorType var1) {
      return HasSensorData$_CC.$default$airRatingsFor(this, var1);
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

   public final String component33() {
      return this.modelName;
   }

   public final int component34() {
      return this.typeIndex;
   }

   public final String component35() {
      return this.sku;
   }

   public final WelcomeHomeLocation component36() {
      return this.welcomeHome;
   }

   public final boolean component37() {
      return this.wickdryEnabled;
   }

   public final boolean component38() {
      return this.wickdryOn;
   }

   public final int component39() {
      return this.wickdryLeftTime;
   }

   public final Integer component4() {
      return this.filterLife;
   }

   public final long component40() {
      return this.wickdryLeftTimeUpdateTime;
   }

   public final int component41() {
      return this.wickUsage;
   }

   public final boolean component42() {
      return this.waterShortage;
   }

   public final int component43() {
      return this.autoRh;
   }

   public final int component44() {
      return this.timerStatus;
   }

   public final int component45() {
      return this.timerDuration;
   }

   public final int component46() {
      return this.timerLeftTime;
   }

   public final long component47() {
      return this.timerLeftTimeUpdateTime;
   }

   public final String component48() {
      return this.locationId;
   }

   public final int component49() {
      return this.mode;
   }

   public final int component5() {
      return this.brightness;
   }

   public final boolean component50() {
      return this.humMode;
   }

   public final int component51() {
      return this.waterLevel;
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

   public final DeviceCombo2in1 copy(String var1, String var2, int var3, Integer var4, int var5, String var6, String var7, DeviceUuid var8, boolean var9, IndoorDatapoint var10, int var11, boolean var12, int var13, long var14, String var16, String var17, String var18, String var19, String var20, String var21, String var22, String var23, String var24, String var25, String var26, double[] var27, double[] var28, double[] var29, double[] var30, double[] var31, int var32, boolean var33, String var34, int var35, String var36, WelcomeHomeLocation var37, boolean var38, boolean var39, int var40, long var41, int var43, boolean var44, int var45, int var46, int var47, int var48, long var49, String var51, int var52, boolean var53, int var54) {
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
      Intrinsics.checkNotNullParameter(var34, "modelName");
      return new DeviceCombo2in1(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26, var27, var28, var29, var30, var31, var32, var33, var34, var35, var36, var37, var38, var39, var40, var41, var43, var44, var45, var46, var47, var48, var49, var51, var52, var53, var54);
   }

   public final int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DeviceCombo2in1)) {
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
         } else if (!Intrinsics.areEqual(this.modelName, var1.modelName)) {
            return false;
         } else if (this.typeIndex != var1.typeIndex) {
            return false;
         } else if (!Intrinsics.areEqual(this.sku, var1.sku)) {
            return false;
         } else if (!Intrinsics.areEqual(this.welcomeHome, var1.welcomeHome)) {
            return false;
         } else if (this.wickdryEnabled != var1.wickdryEnabled) {
            return false;
         } else if (this.wickdryOn != var1.wickdryOn) {
            return false;
         } else if (this.wickdryLeftTime != var1.wickdryLeftTime) {
            return false;
         } else if (this.wickdryLeftTimeUpdateTime != var1.wickdryLeftTimeUpdateTime) {
            return false;
         } else if (this.wickUsage != var1.wickUsage) {
            return false;
         } else if (this.waterShortage != var1.waterShortage) {
            return false;
         } else if (this.autoRh != var1.autoRh) {
            return false;
         } else if (this.timerStatus != var1.timerStatus) {
            return false;
         } else if (this.timerDuration != var1.timerDuration) {
            return false;
         } else if (this.timerLeftTime != var1.timerLeftTime) {
            return false;
         } else if (this.timerLeftTimeUpdateTime != var1.timerLeftTimeUpdateTime) {
            return false;
         } else if (!Intrinsics.areEqual(this.locationId, var1.locationId)) {
            return false;
         } else if (this.mode != var1.mode) {
            return false;
         } else if (this.humMode != var1.humMode) {
            return false;
         } else {
            return this.waterLevel == var1.waterLevel;
         }
      }
   }

   public IndoorAirRatingRanges getAirRatingRanges() {
      return HasSensorData$_CC.$default$getAirRatingRanges(this);
   }

   public AutoMode getAutoMode() {
      return HasFanSpeed$_CC.$default$getAutoMode(this);
   }

   public String getAutoModeText() {
      return this.autoModeText;
   }

   public int getAutoRh() {
      return this.autoRh;
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

   public boolean getHumMode() {
      return this.humMode;
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

   public String getMcuFirmware() {
      return this.mcuFirmware;
   }

   public int getMode() {
      return this.mode;
   }

   public String getModelName() {
      return this.modelName;
   }

   public String getName() {
      return this.name;
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

   public String getUid() {
      return this.uid;
   }

   public int getUpdateProgress() {
      return this.updateProgress;
   }

   public double[] getVocRanges() {
      return this.vocRanges;
   }

   public int getWaterLevel() {
      return this.waterLevel;
   }

   public boolean getWaterShortage() {
      return this.waterShortage;
   }

   public WelcomeHomeLocation getWelcomeHome() {
      return this.welcomeHome;
   }

   public int getWickDryLeftSeconds() {
      return HasWick$_CC.$default$getWickDryLeftSeconds(this);
   }

   public int getWickLifeLeft() {
      return HasWick$_CC.$default$getWickLifeLeft(this);
   }

   public int getWickUsage() {
      return this.wickUsage;
   }

   public boolean getWickdryEnabled() {
      return this.wickdryEnabled;
   }

   public int getWickdryLeftTime() {
      return this.wickdryLeftTime;
   }

   public long getWickdryLeftTimeUpdateTime() {
      return this.wickdryLeftTimeUpdateTime;
   }

   public boolean getWickdryOn() {
      return this.wickdryOn;
   }

   public String getWifiFirmware() {
      return this.wifiFirmware;
   }

   public int hashCode() {
      int var8 = this.uid.hashCode();
      int var9 = this.name.hashCode();
      int var10 = this.fanSpeed;
      Integer var49 = this.filterLife;
      int var7 = 0;
      int var1;
      if (var49 == null) {
         var1 = 0;
      } else {
         var1 = var49.hashCode();
      }

      int var11 = this.brightness;
      int var12 = this.autoModeText.hashCode();
      String var50 = this.info;
      int var2;
      if (var50 == null) {
         var2 = 0;
      } else {
         var2 = var50.hashCode();
      }

      DeviceUuid var51 = this.deviceUuid;
      int var3;
      if (var51 == null) {
         var3 = 0;
      } else {
         var3 = var51.hashCode();
      }

      int var13 = AddDeviceState$$ExternalSyntheticBackport0.m(this.hasFinishedOnboarding);
      IndoorDatapoint var52 = this.latestSensorDatapoint;
      int var4;
      if (var52 == null) {
         var4 = 0;
      } else {
         var4 = var52.hashCode();
      }

      int var29 = this.lastSelectedSensorTypeIndex;
      int var21 = AddDeviceState$$ExternalSyntheticBackport0.m(this.isChildLockOn);
      int var25 = this.connectivityStatusIndex;
      int var28 = AddDeviceState$$ExternalSyntheticBackport0.m(this.lastConnectivityInMillis);
      int var32 = this.mac.hashCode();
      int var31 = this.mcuFirmware.hashCode();
      int var20 = this.wifiFirmware.hashCode();
      int var14 = this.hardware.hashCode();
      int var15 = this.timeZone.hashCode();
      int var36 = this.serial.hashCode();
      int var37 = this.purchaseDate.hashCode();
      int var23 = this.dealerName.hashCode();
      int var19 = this.dealerCountry.hashCode();
      int var33 = this.filterType.hashCode();
      int var30 = this.filterTrigger.hashCode();
      int var35 = Arrays.hashCode(this.pm1Ranges);
      int var22 = Arrays.hashCode(this.pm10Ranges);
      int var16 = Arrays.hashCode(this.pm25Ranges);
      int var27 = Arrays.hashCode(this.vocRanges);
      int var34 = Arrays.hashCode(this.hchoRanges);
      int var17 = this.updateProgress;
      int var26 = AddDeviceState$$ExternalSyntheticBackport0.m(this.isStandByOn);
      int var24 = this.modelName.hashCode();
      int var18 = this.typeIndex;
      String var53 = this.sku;
      int var5;
      if (var53 == null) {
         var5 = 0;
      } else {
         var5 = var53.hashCode();
      }

      WelcomeHomeLocation var54 = this.welcomeHome;
      int var6;
      if (var54 == null) {
         var6 = 0;
      } else {
         var6 = var54.hashCode();
      }

      int var46 = AddDeviceState$$ExternalSyntheticBackport0.m(this.wickdryEnabled);
      int var47 = AddDeviceState$$ExternalSyntheticBackport0.m(this.wickdryOn);
      int var40 = this.wickdryLeftTime;
      int var39 = AddDeviceState$$ExternalSyntheticBackport0.m(this.wickdryLeftTimeUpdateTime);
      int var45 = this.wickUsage;
      int var38 = AddDeviceState$$ExternalSyntheticBackport0.m(this.waterShortage);
      int var44 = this.autoRh;
      int var48 = this.timerStatus;
      int var43 = this.timerDuration;
      int var42 = this.timerLeftTime;
      int var41 = AddDeviceState$$ExternalSyntheticBackport0.m(this.timerLeftTimeUpdateTime);
      String var55 = this.locationId;
      if (var55 != null) {
         var7 = var55.hashCode();
      }

      return (((((((((((((((((((((((((((((((((((((((((((((((((var8 * 31 + var9) * 31 + var10) * 31 + var1) * 31 + var11) * 31 + var12) * 31 + var2) * 31 + var3) * 31 + var13) * 31 + var4) * 31 + var29) * 31 + var21) * 31 + var25) * 31 + var28) * 31 + var32) * 31 + var31) * 31 + var20) * 31 + var14) * 31 + var15) * 31 + var36) * 31 + var37) * 31 + var23) * 31 + var19) * 31 + var33) * 31 + var30) * 31 + var35) * 31 + var22) * 31 + var16) * 31 + var27) * 31 + var34) * 31 + var17) * 31 + var26) * 31 + var24) * 31 + var18) * 31 + var5) * 31 + var6) * 31 + var46) * 31 + var47) * 31 + var40) * 31 + var39) * 31 + var45) * 31 + var38) * 31 + var44) * 31 + var48) * 31 + var43) * 31 + var42) * 31 + var41) * 31 + var7) * 31 + this.mode) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.humMode)) * 31 + this.waterLevel;
   }

   public boolean isChildLockOn() {
      return this.isChildLockOn;
   }

   public boolean isCnDevice() {
      return Device$_CC.$default$isCnDevice(this);
   }

   public boolean isInMode(Mode var1) {
      return HasMode$_CC.$default$isInMode(this, var1);
   }

   public boolean isInWaterLevel(WaterLevel var1) {
      return HasWaterLevel$_CC.$default$isInWaterLevel(this, var1);
   }

   public boolean isOnline() {
      return Device$_CC.$default$isOnline(this);
   }

   public boolean isStandByOn() {
      return this.isStandByOn;
   }

   public boolean isUsDevice() {
      return Device$_CC.$default$isUsDevice(this);
   }

   public Mode mode() {
      return HasMode$_CC.$default$mode(this);
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
      StringBuilder var1 = new StringBuilder("DeviceCombo2in1(uid=");
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
      var1.append(", modelName=");
      var1.append(this.modelName);
      var1.append(", typeIndex=");
      var1.append(this.typeIndex);
      var1.append(", sku=");
      var1.append(this.sku);
      var1.append(", welcomeHome=");
      var1.append(this.welcomeHome);
      var1.append(", wickdryEnabled=");
      var1.append(this.wickdryEnabled);
      var1.append(", wickdryOn=");
      var1.append(this.wickdryOn);
      var1.append(", wickdryLeftTime=");
      var1.append(this.wickdryLeftTime);
      var1.append(", wickdryLeftTimeUpdateTime=");
      var1.append(this.wickdryLeftTimeUpdateTime);
      var1.append(", wickUsage=");
      var1.append(this.wickUsage);
      var1.append(", waterShortage=");
      var1.append(this.waterShortage);
      var1.append(", autoRh=");
      var1.append(this.autoRh);
      var1.append(", timerStatus=");
      var1.append(this.timerStatus);
      var1.append(", timerDuration=");
      var1.append(this.timerDuration);
      var1.append(", timerLeftTime=");
      var1.append(this.timerLeftTime);
      var1.append(", timerLeftTimeUpdateTime=");
      var1.append(this.timerLeftTimeUpdateTime);
      var1.append(", locationId=");
      var1.append(this.locationId);
      var1.append(", mode=");
      var1.append(this.mode);
      var1.append(", humMode=");
      var1.append(this.humMode);
      var1.append(", waterLevel=");
      var1.append(this.waterLevel);
      var1.append(')');
      return var1.toString();
   }

   public WaterLevel waterLevel() {
      return HasWaterLevel$_CC.$default$waterLevel(this);
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

      var1.writeInt(this.wickdryEnabled);
      var1.writeInt(this.wickdryOn);
      var1.writeInt(this.wickdryLeftTime);
      var1.writeLong(this.wickdryLeftTimeUpdateTime);
      var1.writeInt(this.wickUsage);
      var1.writeInt(this.waterShortage);
      var1.writeInt(this.autoRh);
      var1.writeInt(this.timerStatus);
      var1.writeInt(this.timerDuration);
      var1.writeInt(this.timerLeftTime);
      var1.writeLong(this.timerLeftTimeUpdateTime);
      var1.writeString(this.locationId);
      var1.writeInt(this.mode);
      var1.writeInt(this.humMode);
      var1.writeInt(this.waterLevel);
   }

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Creator implements Parcelable.Creator {
      public final DeviceCombo2in1 createFromParcel(Parcel var1) {
         Intrinsics.checkNotNullParameter(var1, "parcel");
         String var31 = var1.readString();
         String var32 = var1.readString();
         int var2 = var1.readInt();
         int var3 = var1.readInt();
         Object var30 = null;
         Integer var28;
         if (var3 == 0) {
            var28 = null;
         } else {
            var28 = var1.readInt();
         }

         int var10 = var1.readInt();
         String var33 = var1.readString();
         String var34 = var1.readString();
         Object var29;
         if (var1.readInt() == 0) {
            var29 = null;
         } else {
            var29 = DeviceUuid.CREATOR.createFromParcel(var1);
         }

         DeviceUuid var35 = (DeviceUuid)var29;
         boolean var17;
         if (var1.readInt() != 0) {
            var17 = true;
         } else {
            var17 = false;
         }

         if (var1.readInt() == 0) {
            var29 = null;
         } else {
            var29 = IndoorDatapoint.CREATOR.createFromParcel(var1);
         }

         IndoorDatapoint var49 = (IndoorDatapoint)var29;
         int var9 = var1.readInt();
         boolean var18;
         if (var1.readInt() != 0) {
            var18 = true;
         } else {
            var18 = false;
         }

         int var6 = var1.readInt();
         long var26 = var1.readLong();
         String var36 = var1.readString();
         String var42 = var1.readString();
         String var54 = var1.readString();
         String var43 = var1.readString();
         String var45 = var1.readString();
         String var40 = var1.readString();
         String var48 = var1.readString();
         String var46 = var1.readString();
         String var47 = var1.readString();
         String var41 = var1.readString();
         String var38 = var1.readString();
         double[] var37 = var1.createDoubleArray();
         double[] var50 = var1.createDoubleArray();
         double[] var53 = var1.createDoubleArray();
         double[] var51 = var1.createDoubleArray();
         boolean var19 = false;
         double[] var39 = var1.createDoubleArray();
         int var11 = var1.readInt();
         if (var1.readInt() != 0) {
            var19 = true;
         }

         String var52 = var1.readString();
         int var12 = var1.readInt();
         boolean var20 = true;
         String var44 = var1.readString();
         if (var1.readInt() == 0) {
            var29 = var30;
         } else {
            var29 = WelcomeHomeLocation.CREATOR.createFromParcel(var1);
         }

         WelcomeHomeLocation var60 = (WelcomeHomeLocation)var29;
         if (var1.readInt() == 0) {
            var20 = false;
         }

         boolean var15 = true;
         boolean var16;
         if (var1.readInt() != 0) {
            var16 = var15;
         } else {
            var16 = false;
         }

         boolean var21 = var16;
         int var8 = var1.readInt();
         long var22 = var1.readLong();
         var16 = var15;
         var3 = var1.readInt();
         if (var1.readInt() == 0) {
            var16 = false;
         }

         int var5 = var1.readInt();
         int var14 = var1.readInt();
         int var4 = var1.readInt();
         int var7 = var1.readInt();
         long var24 = var1.readLong();
         String var59 = var1.readString();
         int var13 = var1.readInt();
         if (var1.readInt() == 0) {
            var15 = false;
         }

         return new DeviceCombo2in1(var31, var32, var2, var28, var10, var33, var34, var35, var17, var49, var9, var18, var6, var26, var36, var42, var54, var43, var45, var40, var48, var46, var47, var41, var38, var37, var50, var53, var51, var39, var11, var19, var52, var12, var44, var60, var20, var21, var8, var22, var3, var16, var5, var14, var4, var7, var24, var59, var13, var15, var1.readInt());
      }

      public final DeviceCombo2in1[] newArray(int var1) {
         return new DeviceCombo2in1[var1];
      }
   }
}
