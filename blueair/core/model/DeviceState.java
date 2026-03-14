package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000)\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\bP\n\u0002\u0010\t\n\u0003\bå\u0001\b\u0086\b\u0018\u00002\u00020\u0001B·\t\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010W\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010]\u0012\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010c\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010d\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010e\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010g\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010h\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010i\u001a\u0004\u0018\u00010\f¢\u0006\u0004\bj\u0010kJ\f\u0010Ø\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010Ù\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010oJ\u0011\u0010Ú\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010oJ\u0011\u0010Û\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010oJ\u0011\u0010Ü\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010oJ\u0011\u0010Ý\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010oJ\u0011\u0010Þ\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010oJ\u0011\u0010ß\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010à\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010oJ\u0011\u0010á\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010oJ\f\u0010â\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010ã\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010oJ\f\u0010ä\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010å\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010æ\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010oJ\u0011\u0010ç\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010è\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010oJ\u0011\u0010é\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010ê\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010oJ\u0011\u0010ë\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010oJ\u0011\u0010ì\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010í\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010î\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010ï\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010oJ\u0011\u0010ð\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010ñ\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010ò\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010ó\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010ô\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010õ\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010ö\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010÷\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010ø\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010ù\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010ú\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010û\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010ü\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010ý\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010þ\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010ÿ\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010\u0080\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010\u0081\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010\u0082\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010\u0083\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010\u0084\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010\u0085\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010\u0086\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010\u0087\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010\u0088\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010\u0089\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010\u008a\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010\u008b\u0002\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010oJ\u0011\u0010\u008c\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010\u008d\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010\u008e\u0002\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010oJ\u0011\u0010\u008f\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010\u0090\u0002\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010oJ\u0011\u0010\u0091\u0002\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010oJ\u0011\u0010\u0092\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010\u0093\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010\u0094\u0002\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010oJ\u0011\u0010\u0095\u0002\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010oJ\u0011\u0010\u0096\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010\u0097\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010\u0098\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010\u0099\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010\u009a\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010\u009b\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010\u009c\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010\u009d\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010\u009e\u0002\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010oJ\u0011\u0010\u009f\u0002\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010oJ\u0011\u0010 \u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010¡\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\f\u0010¢\u0002\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010£\u0002\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010¤\u0002\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010¥\u0002\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010¦\u0002\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010§\u0002\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0011\u0010¨\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010©\u0002\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010oJ\u0011\u0010ª\u0002\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010oJ\u0011\u0010«\u0002\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010oJ\u0011\u0010¬\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010\u00ad\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010®\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0012\u0010¯\u0002\u001a\u0004\u0018\u00010]HÆ\u0003¢\u0006\u0003\u0010Ê\u0001J\u0011\u0010°\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010±\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010²\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010³\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010´\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010µ\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010¶\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010·\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010¸\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010¹\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010º\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJ\u0011\u0010»\u0002\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010wJÀ\t\u0010¼\u0002\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\f2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\f2\n\b\u0002\u00101\u001a\u0004\u0018\u00010\f2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\f2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\f2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\f2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\f2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\f2\n\b\u0002\u00107\u001a\u0004\u0018\u00010\f2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u00109\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010W\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010]2\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010c\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010d\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010g\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010h\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010i\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0003\u0010½\u0002J\u0015\u0010¾\u0002\u001a\u00020\u00052\t\u0010¿\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010À\u0002\u001a\u00020\fHÖ\u0001J\n\u0010Á\u0002\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bl\u0010mR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010p\u001a\u0004\bn\u0010oR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010p\u001a\u0004\bq\u0010oR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010p\u001a\u0004\br\u0010oR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010p\u001a\u0004\bs\u0010oR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010p\u001a\u0004\bt\u0010oR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010p\u001a\u0004\bu\u0010oR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010x\u001a\u0004\bv\u0010wR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010p\u001a\u0004\by\u0010oR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010p\u001a\u0004\bz\u0010oR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b{\u0010mR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010p\u001a\u0004\b|\u0010oR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b}\u0010mR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010x\u001a\u0004\b~\u0010wR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010p\u001a\u0004\b\u007f\u0010oR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b\u0080\u0001\u0010wR\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\u000b\n\u0002\u0010p\u001a\u0005\b\u0081\u0001\u0010oR\u0016\u0010\u0016\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b\u0082\u0001\u0010wR\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0005¢\u0006\u000b\n\u0002\u0010p\u001a\u0005\b\u0083\u0001\u0010oR\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u0005¢\u0006\u000b\n\u0002\u0010p\u001a\u0005\b\u0084\u0001\u0010oR\u0016\u0010\u0019\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b\u0085\u0001\u0010wR\u0016\u0010\u001a\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b\u0086\u0001\u0010wR\u0016\u0010\u001b\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b\u0087\u0001\u0010wR\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u0005¢\u0006\u000b\n\u0002\u0010p\u001a\u0005\b\u0088\u0001\u0010oR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b\u0089\u0001\u0010wR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b\u008a\u0001\u0010wR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b\u008b\u0001\u0010wR\u0016\u0010 \u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b\u008c\u0001\u0010wR\u0016\u0010!\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b\u008d\u0001\u0010wR\u0016\u0010\"\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b\u008e\u0001\u0010wR\u0016\u0010#\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b\u008f\u0001\u0010wR\u0016\u0010$\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b\u0090\u0001\u0010wR\u0016\u0010%\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b\u0091\u0001\u0010wR\u0016\u0010&\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b\u0092\u0001\u0010wR\u0016\u0010'\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b\u0093\u0001\u0010wR\u0016\u0010(\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b\u0094\u0001\u0010wR\u0016\u0010)\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b\u0095\u0001\u0010wR\u0016\u0010*\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b\u0096\u0001\u0010wR\u0016\u0010+\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b\u0097\u0001\u0010wR\u0016\u0010,\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b\u0098\u0001\u0010wR\u0016\u0010-\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b\u0099\u0001\u0010wR\u0016\u0010.\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b\u009a\u0001\u0010wR\u0016\u0010/\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b\u009b\u0001\u0010wR\u0016\u00100\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b\u009c\u0001\u0010wR\u0016\u00101\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b\u009d\u0001\u0010wR\u0016\u00102\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b\u009e\u0001\u0010wR\u0016\u00103\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b\u009f\u0001\u0010wR\u0016\u00104\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b \u0001\u0010wR\u0016\u00105\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b¡\u0001\u0010wR\u0016\u00106\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b¢\u0001\u0010wR\u0016\u00107\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b£\u0001\u0010wR\u0016\u00108\u001a\u0004\u0018\u00010\u0005¢\u0006\u000b\n\u0002\u0010p\u001a\u0005\b¤\u0001\u0010oR\u0016\u00109\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b¥\u0001\u0010wR\u0016\u0010:\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b¦\u0001\u0010wR\u0016\u0010;\u001a\u0004\u0018\u00010\u0005¢\u0006\u000b\n\u0002\u0010p\u001a\u0005\b§\u0001\u0010oR\u0016\u0010<\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b¨\u0001\u0010wR\u0016\u0010=\u001a\u0004\u0018\u00010\u0005¢\u0006\u000b\n\u0002\u0010p\u001a\u0005\b©\u0001\u0010oR\u0016\u0010>\u001a\u0004\u0018\u00010\u0005¢\u0006\u000b\n\u0002\u0010p\u001a\u0005\bª\u0001\u0010oR\u0016\u0010?\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b«\u0001\u0010wR\u0016\u0010@\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b¬\u0001\u0010wR\u0016\u0010A\u001a\u0004\u0018\u00010\u0005¢\u0006\u000b\n\u0002\u0010p\u001a\u0005\b\u00ad\u0001\u0010oR\u0016\u0010B\u001a\u0004\u0018\u00010\u0005¢\u0006\u000b\n\u0002\u0010p\u001a\u0005\b®\u0001\u0010oR\u0016\u0010C\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b¯\u0001\u0010wR\u0016\u0010D\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b°\u0001\u0010wR\u0016\u0010E\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b±\u0001\u0010wR\u0016\u0010F\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b²\u0001\u0010wR\u0016\u0010G\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b³\u0001\u0010wR\u0016\u0010H\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b´\u0001\u0010wR\u0016\u0010I\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\bµ\u0001\u0010wR\u0016\u0010J\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b¶\u0001\u0010wR\u0016\u0010K\u001a\u0004\u0018\u00010\u0005¢\u0006\u000b\n\u0002\u0010p\u001a\u0005\b·\u0001\u0010oR\u0016\u0010L\u001a\u0004\u0018\u00010\u0005¢\u0006\u000b\n\u0002\u0010p\u001a\u0005\b¸\u0001\u0010oR\u0016\u0010M\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b¹\u0001\u0010wR\u0016\u0010N\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\bº\u0001\u0010wR\u0015\u0010O\u001a\u0004\u0018\u00010\u0001¢\u0006\n\n\u0000\u001a\u0006\b»\u0001\u0010¼\u0001R\u0015\u0010P\u001a\u0004\u0018\u00010\u0001¢\u0006\n\n\u0000\u001a\u0006\b½\u0001\u0010¼\u0001R\u0015\u0010Q\u001a\u0004\u0018\u00010\u0001¢\u0006\n\n\u0000\u001a\u0006\b¾\u0001\u0010¼\u0001R\u0015\u0010R\u001a\u0004\u0018\u00010\u0001¢\u0006\n\n\u0000\u001a\u0006\b¿\u0001\u0010¼\u0001R\u0015\u0010S\u001a\u0004\u0018\u00010\u0001¢\u0006\n\n\u0000\u001a\u0006\bÀ\u0001\u0010¼\u0001R\u0015\u0010T\u001a\u0004\u0018\u00010\u0001¢\u0006\n\n\u0000\u001a\u0006\bÁ\u0001\u0010¼\u0001R\u0016\u0010U\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\bÂ\u0001\u0010wR\u0016\u0010V\u001a\u0004\u0018\u00010\u0005¢\u0006\u000b\n\u0002\u0010p\u001a\u0005\bÃ\u0001\u0010oR\u0016\u0010W\u001a\u0004\u0018\u00010\u0005¢\u0006\u000b\n\u0002\u0010p\u001a\u0005\bÄ\u0001\u0010oR\u0016\u0010X\u001a\u0004\u0018\u00010\u0005¢\u0006\u000b\n\u0002\u0010p\u001a\u0005\bÅ\u0001\u0010oR\u0016\u0010Y\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\bÆ\u0001\u0010wR\u0016\u0010Z\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\bÇ\u0001\u0010wR\u0016\u0010[\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\bÈ\u0001\u0010wR\u0018\u0010\\\u001a\u0004\u0018\u00010]¢\u0006\r\n\u0003\u0010Ë\u0001\u001a\u0006\bÉ\u0001\u0010Ê\u0001R\u0016\u0010^\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\bÌ\u0001\u0010wR\u0016\u0010_\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\bÍ\u0001\u0010wR\u0016\u0010`\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\bÎ\u0001\u0010wR\u0016\u0010a\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\bÏ\u0001\u0010wR\u0016\u0010b\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\bÐ\u0001\u0010wR\u0016\u0010c\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\bÑ\u0001\u0010wR\u0016\u0010d\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\bÒ\u0001\u0010wR\u0016\u0010e\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\bÓ\u0001\u0010wR\u0016\u0010f\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\bÔ\u0001\u0010wR\u0016\u0010g\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\bÕ\u0001\u0010wR\u0016\u0010h\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\bÖ\u0001\u0010wR\u0016\u0010i\u001a\u0004\u0018\u00010\f¢\u0006\u000b\n\u0002\u0010x\u001a\u0005\b×\u0001\u0010w¨\u0006Â\u0002"},
   d2 = {"Lcom/blueair/core/model/DeviceState;", "", "cfv", "", "germshield", "", "gsnm", "standby", "eco", "hins", "nmhins", "fanspeed", "", "childlock", "nightmode", "mfv", "automode", "ofv", "brightness", "safetyswitch", "filterusage", "disinfection", "disinftime", "wickdrye", "wickdrys", "wickdryl", "wickdryts", "wickusage", "wshortage", "autorh", "timstate", "timdur", "timl", "timts", "tu", "oscstate", "osc", "oscdir", "oscfs", "mainmode", "apsubmode", "fsp0", "heatsubmode", "heatfs", "heattemp", "ecoheattemp", "coolsubmode", "coolfs", "coolautotag", "coolautofs1", "coolautofs2", "coolautofs3", "coolecotag", "coolecofs1", "coolecofs2", "mode", "hummode", "wlevel", "dehsubmode", "watertankfailure", "smartsubmode", "detectcat", "bodymounted", "aireta", "displaymode", "hover", "airrefresh", "arstate", "ardur", "arts", "startts", "endts", "roomtype", "nlbrightness", "wickdrydur", "wickdrydone", "ywrme", "ywrmusage", "nlstepless", "alarm1", "alarm2", "alarm3", "alarm4", "alarm5", "alarm6", "humsubmode", "hourformat", "wtankfail", "waterinfill", "sensormode", "coolfslevel", "coolauto", "nightstartts", "", "rpm", "oscmode", "oscstateh", "oscfixh", "oscminh", "oscmaxh", "oscstatev", "oscfixv", "oscminv", "oscmaxv", "calibrationh", "calibrationv", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getCfv", "()Ljava/lang/String;", "getGermshield", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getGsnm", "getStandby", "getEco", "getHins", "getNmhins", "getFanspeed", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getChildlock", "getNightmode", "getMfv", "getAutomode", "getOfv", "getBrightness", "getSafetyswitch", "getFilterusage", "getDisinfection", "getDisinftime", "getWickdrye", "getWickdrys", "getWickdryl", "getWickdryts", "getWickusage", "getWshortage", "getAutorh", "getTimstate", "getTimdur", "getTiml", "getTimts", "getTu", "getOscstate", "getOsc", "getOscdir", "getOscfs", "getMainmode", "getApsubmode", "getFsp0", "getHeatsubmode", "getHeatfs", "getHeattemp", "getEcoheattemp", "getCoolsubmode", "getCoolfs", "getCoolautotag", "getCoolautofs1", "getCoolautofs2", "getCoolautofs3", "getCoolecotag", "getCoolecofs1", "getCoolecofs2", "getMode", "getHummode", "getWlevel", "getDehsubmode", "getWatertankfailure", "getSmartsubmode", "getDetectcat", "getBodymounted", "getAireta", "getDisplaymode", "getHover", "getAirrefresh", "getArstate", "getArdur", "getArts", "getStartts", "getEndts", "getRoomtype", "getNlbrightness", "getWickdrydur", "getWickdrydone", "getYwrme", "getYwrmusage", "getNlstepless", "getAlarm1", "()Ljava/lang/Object;", "getAlarm2", "getAlarm3", "getAlarm4", "getAlarm5", "getAlarm6", "getHumsubmode", "getHourformat", "getWtankfail", "getWaterinfill", "getSensormode", "getCoolfslevel", "getCoolauto", "getNightstartts", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getRpm", "getOscmode", "getOscstateh", "getOscfixh", "getOscminh", "getOscmaxh", "getOscstatev", "getOscfixv", "getOscminv", "getOscmaxv", "getCalibrationh", "getCalibrationv", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component60", "component61", "component62", "component63", "component64", "component65", "component66", "component67", "component68", "component69", "component70", "component71", "component72", "component73", "component74", "component75", "component76", "component77", "component78", "component79", "component80", "component81", "component82", "component83", "component84", "component85", "component86", "component87", "component88", "component89", "component90", "component91", "component92", "component93", "component94", "component95", "component96", "component97", "component98", "component99", "component100", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/blueair/core/model/DeviceState;", "equals", "other", "hashCode", "toString", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceState {
   private final Integer aireta;
   private final Boolean airrefresh;
   private final Object alarm1;
   private final Object alarm2;
   private final Object alarm3;
   private final Object alarm4;
   private final Object alarm5;
   private final Object alarm6;
   private final Integer apsubmode;
   private final Integer ardur;
   private final Integer arstate;
   private final Integer arts;
   private final Boolean automode;
   private final Integer autorh;
   private final Boolean bodymounted;
   private final Integer brightness;
   private final Integer calibrationh;
   private final Integer calibrationv;
   private final String cfv;
   private final Boolean childlock;
   private final Integer coolauto;
   private final Integer coolautofs1;
   private final Integer coolautofs2;
   private final Integer coolautofs3;
   private final Integer coolautotag;
   private final Integer coolecofs1;
   private final Integer coolecofs2;
   private final Integer coolecotag;
   private final Integer coolfs;
   private final Integer coolfslevel;
   private final Integer coolsubmode;
   private final Integer dehsubmode;
   private final Boolean detectcat;
   private final Boolean disinfection;
   private final Integer disinftime;
   private final Integer displaymode;
   private final Boolean eco;
   private final Integer ecoheattemp;
   private final Integer endts;
   private final Integer fanspeed;
   private final Integer filterusage;
   private final Integer fsp0;
   private final Boolean germshield;
   private final Boolean gsnm;
   private final Integer heatfs;
   private final Integer heatsubmode;
   private final Integer heattemp;
   private final Boolean hins;
   private final Boolean hourformat;
   private final Boolean hover;
   private final Boolean hummode;
   private final Integer humsubmode;
   private final Integer mainmode;
   private final String mfv;
   private final Integer mode;
   private final Boolean nightmode;
   private final Long nightstartts;
   private final Integer nlbrightness;
   private final Integer nlstepless;
   private final Boolean nmhins;
   private final String ofv;
   private final Integer osc;
   private final Integer oscdir;
   private final Integer oscfixh;
   private final Integer oscfixv;
   private final Integer oscfs;
   private final Integer oscmaxh;
   private final Integer oscmaxv;
   private final Integer oscminh;
   private final Integer oscminv;
   private final Integer oscmode;
   private final Integer oscstate;
   private final Integer oscstateh;
   private final Integer oscstatev;
   private final Integer roomtype;
   private final Integer rpm;
   private final Boolean safetyswitch;
   private final Integer sensormode;
   private final Integer smartsubmode;
   private final Boolean standby;
   private final Integer startts;
   private final Integer timdur;
   private final Integer timl;
   private final Integer timstate;
   private final Integer timts;
   private final Integer tu;
   private final Boolean waterinfill;
   private final Boolean watertankfailure;
   private final Boolean wickdrydone;
   private final Integer wickdrydur;
   private final Boolean wickdrye;
   private final Integer wickdryl;
   private final Boolean wickdrys;
   private final Integer wickdryts;
   private final Integer wickusage;
   private final Integer wlevel;
   private final Boolean wshortage;
   private final Boolean wtankfail;
   private final Boolean ywrme;
   private final Integer ywrmusage;

   public DeviceState() {
      this((String)null, (Boolean)null, (Boolean)null, (Boolean)null, (Boolean)null, (Boolean)null, (Boolean)null, (Integer)null, (Boolean)null, (Boolean)null, (String)null, (Boolean)null, (String)null, (Integer)null, (Boolean)null, (Integer)null, (Boolean)null, (Integer)null, (Boolean)null, (Boolean)null, (Integer)null, (Integer)null, (Integer)null, (Boolean)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Boolean)null, (Integer)null, (Integer)null, (Boolean)null, (Integer)null, (Boolean)null, (Boolean)null, (Integer)null, (Integer)null, (Boolean)null, (Boolean)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Boolean)null, (Boolean)null, (Integer)null, (Integer)null, (Object)null, (Object)null, (Object)null, (Object)null, (Object)null, (Object)null, (Integer)null, (Boolean)null, (Boolean)null, (Boolean)null, (Integer)null, (Integer)null, (Integer)null, (Long)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, (Integer)null, -1, -1, -1, 15, (DefaultConstructorMarker)null);
   }

   public DeviceState(String var1, Boolean var2, Boolean var3, Boolean var4, Boolean var5, Boolean var6, Boolean var7, Integer var8, Boolean var9, Boolean var10, String var11, Boolean var12, String var13, Integer var14, Boolean var15, Integer var16, Boolean var17, Integer var18, Boolean var19, Boolean var20, Integer var21, Integer var22, Integer var23, Boolean var24, Integer var25, Integer var26, Integer var27, Integer var28, Integer var29, Integer var30, Integer var31, Integer var32, Integer var33, Integer var34, Integer var35, Integer var36, Integer var37, Integer var38, Integer var39, Integer var40, Integer var41, Integer var42, Integer var43, Integer var44, Integer var45, Integer var46, Integer var47, Integer var48, Integer var49, Integer var50, Integer var51, Boolean var52, Integer var53, Integer var54, Boolean var55, Integer var56, Boolean var57, Boolean var58, Integer var59, Integer var60, Boolean var61, Boolean var62, Integer var63, Integer var64, Integer var65, Integer var66, Integer var67, Integer var68, Integer var69, Integer var70, Boolean var71, Boolean var72, Integer var73, Integer var74, Object var75, Object var76, Object var77, Object var78, Object var79, Object var80, Integer var81, Boolean var82, Boolean var83, Boolean var84, Integer var85, Integer var86, Integer var87, Long var88, Integer var89, Integer var90, Integer var91, Integer var92, Integer var93, Integer var94, Integer var95, Integer var96, Integer var97, Integer var98, Integer var99, Integer var100) {
      this.cfv = var1;
      this.germshield = var2;
      this.gsnm = var3;
      this.standby = var4;
      this.eco = var5;
      this.hins = var6;
      this.nmhins = var7;
      this.fanspeed = var8;
      this.childlock = var9;
      this.nightmode = var10;
      this.mfv = var11;
      this.automode = var12;
      this.ofv = var13;
      this.brightness = var14;
      this.safetyswitch = var15;
      this.filterusage = var16;
      this.disinfection = var17;
      this.disinftime = var18;
      this.wickdrye = var19;
      this.wickdrys = var20;
      this.wickdryl = var21;
      this.wickdryts = var22;
      this.wickusage = var23;
      this.wshortage = var24;
      this.autorh = var25;
      this.timstate = var26;
      this.timdur = var27;
      this.timl = var28;
      this.timts = var29;
      this.tu = var30;
      this.oscstate = var31;
      this.osc = var32;
      this.oscdir = var33;
      this.oscfs = var34;
      this.mainmode = var35;
      this.apsubmode = var36;
      this.fsp0 = var37;
      this.heatsubmode = var38;
      this.heatfs = var39;
      this.heattemp = var40;
      this.ecoheattemp = var41;
      this.coolsubmode = var42;
      this.coolfs = var43;
      this.coolautotag = var44;
      this.coolautofs1 = var45;
      this.coolautofs2 = var46;
      this.coolautofs3 = var47;
      this.coolecotag = var48;
      this.coolecofs1 = var49;
      this.coolecofs2 = var50;
      this.mode = var51;
      this.hummode = var52;
      this.wlevel = var53;
      this.dehsubmode = var54;
      this.watertankfailure = var55;
      this.smartsubmode = var56;
      this.detectcat = var57;
      this.bodymounted = var58;
      this.aireta = var59;
      this.displaymode = var60;
      this.hover = var61;
      this.airrefresh = var62;
      this.arstate = var63;
      this.ardur = var64;
      this.arts = var65;
      this.startts = var66;
      this.endts = var67;
      this.roomtype = var68;
      this.nlbrightness = var69;
      this.wickdrydur = var70;
      this.wickdrydone = var71;
      this.ywrme = var72;
      this.ywrmusage = var73;
      this.nlstepless = var74;
      this.alarm1 = var75;
      this.alarm2 = var76;
      this.alarm3 = var77;
      this.alarm4 = var78;
      this.alarm5 = var79;
      this.alarm6 = var80;
      this.humsubmode = var81;
      this.hourformat = var82;
      this.wtankfail = var83;
      this.waterinfill = var84;
      this.sensormode = var85;
      this.coolfslevel = var86;
      this.coolauto = var87;
      this.nightstartts = var88;
      this.rpm = var89;
      this.oscmode = var90;
      this.oscstateh = var91;
      this.oscfixh = var92;
      this.oscminh = var93;
      this.oscmaxh = var94;
      this.oscstatev = var95;
      this.oscfixv = var96;
      this.oscminv = var97;
      this.oscmaxv = var98;
      this.calibrationh = var99;
      this.calibrationv = var100;
   }

   // $FF: synthetic method
   public DeviceState(String var1, Boolean var2, Boolean var3, Boolean var4, Boolean var5, Boolean var6, Boolean var7, Integer var8, Boolean var9, Boolean var10, String var11, Boolean var12, String var13, Integer var14, Boolean var15, Integer var16, Boolean var17, Integer var18, Boolean var19, Boolean var20, Integer var21, Integer var22, Integer var23, Boolean var24, Integer var25, Integer var26, Integer var27, Integer var28, Integer var29, Integer var30, Integer var31, Integer var32, Integer var33, Integer var34, Integer var35, Integer var36, Integer var37, Integer var38, Integer var39, Integer var40, Integer var41, Integer var42, Integer var43, Integer var44, Integer var45, Integer var46, Integer var47, Integer var48, Integer var49, Integer var50, Integer var51, Boolean var52, Integer var53, Integer var54, Boolean var55, Integer var56, Boolean var57, Boolean var58, Integer var59, Integer var60, Boolean var61, Boolean var62, Integer var63, Integer var64, Integer var65, Integer var66, Integer var67, Integer var68, Integer var69, Integer var70, Boolean var71, Boolean var72, Integer var73, Integer var74, Object var75, Object var76, Object var77, Object var78, Object var79, Object var80, Integer var81, Boolean var82, Boolean var83, Boolean var84, Integer var85, Integer var86, Integer var87, Long var88, Integer var89, Integer var90, Integer var91, Integer var92, Integer var93, Integer var94, Integer var95, Integer var96, Integer var97, Integer var98, Integer var99, Integer var100, int var101, int var102, int var103, int var104, DefaultConstructorMarker var105) {
      if ((var101 & 1) != 0) {
         var1 = null;
      }

      if ((var101 & 2) != 0) {
         var2 = null;
      }

      if ((var101 & 4) != 0) {
         var3 = null;
      }

      if ((var101 & 8) != 0) {
         var4 = null;
      }

      if ((var101 & 16) != 0) {
         var5 = null;
      }

      if ((var101 & 32) != 0) {
         var6 = null;
      }

      if ((var101 & 64) != 0) {
         var7 = null;
      }

      if ((var101 & 128) != 0) {
         var8 = null;
      }

      if ((var101 & 256) != 0) {
         var9 = null;
      }

      if ((var101 & 512) != 0) {
         var10 = null;
      }

      if ((var101 & 1024) != 0) {
         var11 = null;
      }

      if ((var101 & 2048) != 0) {
         var12 = null;
      }

      if ((var101 & 4096) != 0) {
         var13 = null;
      }

      if ((var101 & 8192) != 0) {
         var14 = null;
      }

      if ((var101 & 16384) != 0) {
         var15 = null;
      }

      if ((var101 & '耀') != 0) {
         var16 = null;
      }

      if ((var101 & 65536) != 0) {
         var17 = null;
      }

      if ((var101 & 131072) != 0) {
         var18 = null;
      }

      if ((var101 & 262144) != 0) {
         var19 = null;
      }

      if ((var101 & 524288) != 0) {
         var20 = null;
      }

      if ((var101 & 1048576) != 0) {
         var21 = null;
      }

      if ((var101 & 2097152) != 0) {
         var22 = null;
      }

      if ((var101 & 4194304) != 0) {
         var23 = null;
      }

      if ((var101 & 8388608) != 0) {
         var24 = null;
      }

      if ((var101 & 16777216) != 0) {
         var25 = null;
      }

      if ((var101 & 33554432) != 0) {
         var26 = null;
      }

      if ((var101 & 67108864) != 0) {
         var27 = null;
      }

      if ((var101 & 134217728) != 0) {
         var28 = null;
      }

      if ((var101 & 268435456) != 0) {
         var29 = null;
      }

      if ((var101 & 536870912) != 0) {
         var30 = null;
      }

      if ((var101 & 1073741824) != 0) {
         var31 = null;
      }

      if ((var101 & Integer.MIN_VALUE) != 0) {
         var32 = null;
      }

      if ((var102 & 1) != 0) {
         var33 = null;
      }

      if ((var102 & 2) != 0) {
         var34 = null;
      }

      if ((var102 & 4) != 0) {
         var35 = null;
      }

      if ((var102 & 8) != 0) {
         var36 = null;
      }

      if ((var102 & 16) != 0) {
         var37 = null;
      }

      if ((var102 & 32) != 0) {
         var38 = null;
      }

      if ((var102 & 64) != 0) {
         var39 = null;
      }

      if ((var102 & 128) != 0) {
         var40 = null;
      }

      if ((var102 & 256) != 0) {
         var41 = null;
      }

      if ((var102 & 512) != 0) {
         var42 = null;
      }

      if ((var102 & 1024) != 0) {
         var43 = null;
      }

      if ((var102 & 2048) != 0) {
         var44 = null;
      }

      if ((var102 & 4096) != 0) {
         var45 = null;
      }

      if ((var102 & 8192) != 0) {
         var46 = null;
      }

      if ((var102 & 16384) != 0) {
         var47 = null;
      }

      if ((var102 & '耀') != 0) {
         var48 = null;
      }

      if ((var102 & 65536) != 0) {
         var49 = null;
      }

      if ((var102 & 131072) != 0) {
         var50 = null;
      }

      if ((var102 & 262144) != 0) {
         var51 = null;
      }

      if ((var102 & 524288) != 0) {
         var52 = null;
      }

      if ((var102 & 1048576) != 0) {
         var53 = null;
      }

      if ((var102 & 2097152) != 0) {
         var54 = null;
      }

      if ((var102 & 4194304) != 0) {
         var55 = null;
      }

      if ((var102 & 8388608) != 0) {
         var56 = null;
      }

      if ((var102 & 16777216) != 0) {
         var57 = null;
      }

      if ((var102 & 33554432) != 0) {
         var58 = null;
      }

      if ((var102 & 67108864) != 0) {
         var59 = null;
      }

      if ((var102 & 134217728) != 0) {
         var60 = null;
      }

      if ((var102 & 268435456) != 0) {
         var61 = null;
      }

      if ((var102 & 536870912) != 0) {
         var62 = null;
      }

      if ((var102 & 1073741824) != 0) {
         var63 = null;
      }

      if ((var102 & Integer.MIN_VALUE) != 0) {
         var64 = null;
      }

      if ((var103 & 1) != 0) {
         var65 = null;
      }

      if ((var103 & 2) != 0) {
         var66 = null;
      }

      if ((var103 & 4) != 0) {
         var67 = null;
      }

      if ((var103 & 8) != 0) {
         var68 = null;
      }

      if ((var103 & 16) != 0) {
         var69 = null;
      }

      if ((var103 & 32) != 0) {
         var70 = null;
      }

      if ((var103 & 64) != 0) {
         var71 = null;
      }

      if ((var103 & 128) != 0) {
         var72 = null;
      }

      if ((var103 & 256) != 0) {
         var73 = null;
      }

      if ((var103 & 512) != 0) {
         var74 = null;
      }

      if ((var103 & 1024) != 0) {
         var75 = null;
      }

      if ((var103 & 2048) != 0) {
         var76 = null;
      }

      if ((var103 & 4096) != 0) {
         var77 = null;
      }

      if ((var103 & 8192) != 0) {
         var78 = null;
      }

      if ((var103 & 16384) != 0) {
         var79 = null;
      }

      if ((var103 & '耀') != 0) {
         var80 = null;
      }

      if ((var103 & 65536) != 0) {
         var81 = null;
      }

      if ((var103 & 131072) != 0) {
         var82 = null;
      }

      if ((var103 & 262144) != 0) {
         var83 = null;
      }

      if ((var103 & 524288) != 0) {
         var84 = null;
      }

      if ((var103 & 1048576) != 0) {
         var85 = null;
      }

      if ((var103 & 2097152) != 0) {
         var86 = null;
      }

      if ((var103 & 4194304) != 0) {
         var87 = null;
      }

      if ((var103 & 8388608) != 0) {
         var88 = null;
      }

      if ((var103 & 16777216) != 0) {
         var89 = null;
      }

      if ((var103 & 33554432) != 0) {
         var90 = null;
      }

      if ((var103 & 67108864) != 0) {
         var91 = null;
      }

      if ((var103 & 134217728) != 0) {
         var92 = null;
      }

      if ((var103 & 268435456) != 0) {
         var93 = null;
      }

      if ((var103 & 536870912) != 0) {
         var94 = null;
      }

      if ((var103 & 1073741824) != 0) {
         var95 = null;
      }

      if ((var103 & Integer.MIN_VALUE) != 0) {
         var96 = null;
      }

      if ((var104 & 1) != 0) {
         var97 = null;
      }

      if ((var104 & 2) != 0) {
         var98 = null;
      }

      if ((var104 & 4) != 0) {
         var99 = null;
      }

      if ((var104 & 8) != 0) {
         var100 = null;
      }

      this(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26, var27, var28, var29, var30, var31, var32, var33, var34, var35, var36, var37, var38, var39, var40, var41, var42, var43, var44, var45, var46, var47, var48, var49, var50, var51, var52, var53, var54, var55, var56, var57, var58, var59, var60, var61, var62, var63, var64, var65, var66, var67, var68, var69, var70, var71, var72, var73, var74, var75, var76, var77, var78, var79, var80, var81, var82, var83, var84, var85, var86, var87, var88, var89, var90, var91, var92, var93, var94, var95, var96, var97, var98, var99, var100);
   }

   // $FF: synthetic method
   public static DeviceState copy$default(DeviceState var0, String var1, Boolean var2, Boolean var3, Boolean var4, Boolean var5, Boolean var6, Boolean var7, Integer var8, Boolean var9, Boolean var10, String var11, Boolean var12, String var13, Integer var14, Boolean var15, Integer var16, Boolean var17, Integer var18, Boolean var19, Boolean var20, Integer var21, Integer var22, Integer var23, Boolean var24, Integer var25, Integer var26, Integer var27, Integer var28, Integer var29, Integer var30, Integer var31, Integer var32, Integer var33, Integer var34, Integer var35, Integer var36, Integer var37, Integer var38, Integer var39, Integer var40, Integer var41, Integer var42, Integer var43, Integer var44, Integer var45, Integer var46, Integer var47, Integer var48, Integer var49, Integer var50, Integer var51, Boolean var52, Integer var53, Integer var54, Boolean var55, Integer var56, Boolean var57, Boolean var58, Integer var59, Integer var60, Boolean var61, Boolean var62, Integer var63, Integer var64, Integer var65, Integer var66, Integer var67, Integer var68, Integer var69, Integer var70, Boolean var71, Boolean var72, Integer var73, Integer var74, Object var75, Object var76, Object var77, Object var78, Object var79, Object var80, Integer var81, Boolean var82, Boolean var83, Boolean var84, Integer var85, Integer var86, Integer var87, Long var88, Integer var89, Integer var90, Integer var91, Integer var92, Integer var93, Integer var94, Integer var95, Integer var96, Integer var97, Integer var98, Integer var99, Integer var100, int var101, int var102, int var103, int var104, Object var105) {
      if ((var101 & 1) != 0) {
         var1 = var0.cfv;
      }

      if ((var101 & 2) != 0) {
         var2 = var0.germshield;
      }

      if ((var101 & 4) != 0) {
         var3 = var0.gsnm;
      }

      if ((var101 & 8) != 0) {
         var4 = var0.standby;
      }

      if ((var101 & 16) != 0) {
         var5 = var0.eco;
      }

      if ((var101 & 32) != 0) {
         var6 = var0.hins;
      }

      if ((var101 & 64) != 0) {
         var7 = var0.nmhins;
      }

      if ((var101 & 128) != 0) {
         var8 = var0.fanspeed;
      }

      if ((var101 & 256) != 0) {
         var9 = var0.childlock;
      }

      if ((var101 & 512) != 0) {
         var10 = var0.nightmode;
      }

      if ((var101 & 1024) != 0) {
         var11 = var0.mfv;
      }

      if ((var101 & 2048) != 0) {
         var12 = var0.automode;
      }

      if ((var101 & 4096) != 0) {
         var13 = var0.ofv;
      }

      if ((var101 & 8192) != 0) {
         var14 = var0.brightness;
      }

      if ((var101 & 16384) != 0) {
         var15 = var0.safetyswitch;
      }

      if ((var101 & '耀') != 0) {
         var16 = var0.filterusage;
      }

      if ((var101 & 65536) != 0) {
         var17 = var0.disinfection;
      }

      if ((var101 & 131072) != 0) {
         var18 = var0.disinftime;
      }

      if ((var101 & 262144) != 0) {
         var19 = var0.wickdrye;
      }

      if ((var101 & 524288) != 0) {
         var20 = var0.wickdrys;
      }

      if ((var101 & 1048576) != 0) {
         var21 = var0.wickdryl;
      }

      if ((var101 & 2097152) != 0) {
         var22 = var0.wickdryts;
      }

      if ((var101 & 4194304) != 0) {
         var23 = var0.wickusage;
      }

      if ((var101 & 8388608) != 0) {
         var24 = var0.wshortage;
      }

      if ((var101 & 16777216) != 0) {
         var25 = var0.autorh;
      }

      if ((var101 & 33554432) != 0) {
         var26 = var0.timstate;
      }

      if ((var101 & 67108864) != 0) {
         var27 = var0.timdur;
      }

      if ((var101 & 134217728) != 0) {
         var28 = var0.timl;
      }

      if ((var101 & 268435456) != 0) {
         var29 = var0.timts;
      }

      if ((var101 & 536870912) != 0) {
         var30 = var0.tu;
      }

      if ((var101 & 1073741824) != 0) {
         var31 = var0.oscstate;
      }

      if ((var101 & Integer.MIN_VALUE) != 0) {
         var32 = var0.osc;
      }

      if ((var102 & 1) != 0) {
         var33 = var0.oscdir;
      }

      if ((var102 & 2) != 0) {
         var34 = var0.oscfs;
      }

      if ((var102 & 4) != 0) {
         var35 = var0.mainmode;
      }

      if ((var102 & 8) != 0) {
         var36 = var0.apsubmode;
      }

      if ((var102 & 16) != 0) {
         var37 = var0.fsp0;
      }

      if ((var102 & 32) != 0) {
         var38 = var0.heatsubmode;
      }

      if ((var102 & 64) != 0) {
         var39 = var0.heatfs;
      }

      if ((var102 & 128) != 0) {
         var40 = var0.heattemp;
      }

      if ((var102 & 256) != 0) {
         var41 = var0.ecoheattemp;
      }

      if ((var102 & 512) != 0) {
         var42 = var0.coolsubmode;
      }

      if ((var102 & 1024) != 0) {
         var43 = var0.coolfs;
      }

      if ((var102 & 2048) != 0) {
         var44 = var0.coolautotag;
      }

      if ((var102 & 4096) != 0) {
         var45 = var0.coolautofs1;
      }

      if ((var102 & 8192) != 0) {
         var46 = var0.coolautofs2;
      }

      if ((var102 & 16384) != 0) {
         var47 = var0.coolautofs3;
      }

      if ((var102 & '耀') != 0) {
         var48 = var0.coolecotag;
      }

      if ((var102 & 65536) != 0) {
         var49 = var0.coolecofs1;
      }

      if ((var102 & 131072) != 0) {
         var50 = var0.coolecofs2;
      }

      if ((var102 & 262144) != 0) {
         var51 = var0.mode;
      }

      if ((var102 & 524288) != 0) {
         var52 = var0.hummode;
      }

      if ((var102 & 1048576) != 0) {
         var53 = var0.wlevel;
      }

      if ((var102 & 2097152) != 0) {
         var54 = var0.dehsubmode;
      }

      if ((var102 & 4194304) != 0) {
         var55 = var0.watertankfailure;
      }

      if ((var102 & 8388608) != 0) {
         var56 = var0.smartsubmode;
      }

      if ((var102 & 16777216) != 0) {
         var57 = var0.detectcat;
      }

      if ((var102 & 33554432) != 0) {
         var58 = var0.bodymounted;
      }

      if ((var102 & 67108864) != 0) {
         var59 = var0.aireta;
      }

      if ((var102 & 134217728) != 0) {
         var60 = var0.displaymode;
      }

      if ((var102 & 268435456) != 0) {
         var61 = var0.hover;
      }

      if ((var102 & 536870912) != 0) {
         var62 = var0.airrefresh;
      }

      if ((var102 & 1073741824) != 0) {
         var63 = var0.arstate;
      }

      if ((var102 & Integer.MIN_VALUE) != 0) {
         var64 = var0.ardur;
      }

      if ((var103 & 1) != 0) {
         var65 = var0.arts;
      }

      if ((var103 & 2) != 0) {
         var66 = var0.startts;
      }

      if ((var103 & 4) != 0) {
         var67 = var0.endts;
      }

      if ((var103 & 8) != 0) {
         var68 = var0.roomtype;
      }

      if ((var103 & 16) != 0) {
         var69 = var0.nlbrightness;
      }

      if ((var103 & 32) != 0) {
         var70 = var0.wickdrydur;
      }

      if ((var103 & 64) != 0) {
         var71 = var0.wickdrydone;
      }

      if ((var103 & 128) != 0) {
         var72 = var0.ywrme;
      }

      if ((var103 & 256) != 0) {
         var73 = var0.ywrmusage;
      }

      if ((var103 & 512) != 0) {
         var74 = var0.nlstepless;
      }

      if ((var103 & 1024) != 0) {
         var75 = var0.alarm1;
      }

      if ((var103 & 2048) != 0) {
         var76 = var0.alarm2;
      }

      if ((var103 & 4096) != 0) {
         var77 = var0.alarm3;
      }

      if ((var103 & 8192) != 0) {
         var78 = var0.alarm4;
      }

      if ((var103 & 16384) != 0) {
         var79 = var0.alarm5;
      }

      if ((var103 & '耀') != 0) {
         var80 = var0.alarm6;
      }

      if ((var103 & 65536) != 0) {
         var81 = var0.humsubmode;
      }

      if ((var103 & 131072) != 0) {
         var82 = var0.hourformat;
      }

      if ((var103 & 262144) != 0) {
         var83 = var0.wtankfail;
      }

      if ((var103 & 524288) != 0) {
         var84 = var0.waterinfill;
      }

      if ((var103 & 1048576) != 0) {
         var85 = var0.sensormode;
      }

      if ((var103 & 2097152) != 0) {
         var86 = var0.coolfslevel;
      }

      if ((var103 & 4194304) != 0) {
         var87 = var0.coolauto;
      }

      if ((var103 & 8388608) != 0) {
         var88 = var0.nightstartts;
      }

      if ((var103 & 16777216) != 0) {
         var89 = var0.rpm;
      }

      if ((var103 & 33554432) != 0) {
         var90 = var0.oscmode;
      }

      if ((var103 & 67108864) != 0) {
         var91 = var0.oscstateh;
      }

      if ((var103 & 134217728) != 0) {
         var92 = var0.oscfixh;
      }

      if ((var103 & 268435456) != 0) {
         var93 = var0.oscminh;
      }

      if ((var103 & 536870912) != 0) {
         var94 = var0.oscmaxh;
      }

      if ((var103 & 1073741824) != 0) {
         var95 = var0.oscstatev;
      }

      if ((var103 & Integer.MIN_VALUE) != 0) {
         var96 = var0.oscfixv;
      }

      if ((var104 & 1) != 0) {
         var97 = var0.oscminv;
      }

      if ((var104 & 2) != 0) {
         var98 = var0.oscmaxv;
      }

      if ((var104 & 4) != 0) {
         var99 = var0.calibrationh;
      }

      if ((var104 & 8) != 0) {
         var100 = var0.calibrationv;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26, var27, var28, var29, var30, var31, var32, var33, var34, var35, var36, var37, var38, var39, var40, var41, var42, var43, var44, var45, var46, var47, var48, var49, var50, var51, var52, var53, var54, var55, var56, var57, var58, var59, var60, var61, var62, var63, var64, var65, var66, var67, var68, var69, var70, var71, var72, var73, var74, var75, var76, var77, var78, var79, var80, var81, var82, var83, var84, var85, var86, var87, var88, var89, var90, var91, var92, var93, var94, var95, var96, var97, var98, var99, var100);
   }

   public final String component1() {
      return this.cfv;
   }

   public final Boolean component10() {
      return this.nightmode;
   }

   public final Integer component100() {
      return this.calibrationv;
   }

   public final String component11() {
      return this.mfv;
   }

   public final Boolean component12() {
      return this.automode;
   }

   public final String component13() {
      return this.ofv;
   }

   public final Integer component14() {
      return this.brightness;
   }

   public final Boolean component15() {
      return this.safetyswitch;
   }

   public final Integer component16() {
      return this.filterusage;
   }

   public final Boolean component17() {
      return this.disinfection;
   }

   public final Integer component18() {
      return this.disinftime;
   }

   public final Boolean component19() {
      return this.wickdrye;
   }

   public final Boolean component2() {
      return this.germshield;
   }

   public final Boolean component20() {
      return this.wickdrys;
   }

   public final Integer component21() {
      return this.wickdryl;
   }

   public final Integer component22() {
      return this.wickdryts;
   }

   public final Integer component23() {
      return this.wickusage;
   }

   public final Boolean component24() {
      return this.wshortage;
   }

   public final Integer component25() {
      return this.autorh;
   }

   public final Integer component26() {
      return this.timstate;
   }

   public final Integer component27() {
      return this.timdur;
   }

   public final Integer component28() {
      return this.timl;
   }

   public final Integer component29() {
      return this.timts;
   }

   public final Boolean component3() {
      return this.gsnm;
   }

   public final Integer component30() {
      return this.tu;
   }

   public final Integer component31() {
      return this.oscstate;
   }

   public final Integer component32() {
      return this.osc;
   }

   public final Integer component33() {
      return this.oscdir;
   }

   public final Integer component34() {
      return this.oscfs;
   }

   public final Integer component35() {
      return this.mainmode;
   }

   public final Integer component36() {
      return this.apsubmode;
   }

   public final Integer component37() {
      return this.fsp0;
   }

   public final Integer component38() {
      return this.heatsubmode;
   }

   public final Integer component39() {
      return this.heatfs;
   }

   public final Boolean component4() {
      return this.standby;
   }

   public final Integer component40() {
      return this.heattemp;
   }

   public final Integer component41() {
      return this.ecoheattemp;
   }

   public final Integer component42() {
      return this.coolsubmode;
   }

   public final Integer component43() {
      return this.coolfs;
   }

   public final Integer component44() {
      return this.coolautotag;
   }

   public final Integer component45() {
      return this.coolautofs1;
   }

   public final Integer component46() {
      return this.coolautofs2;
   }

   public final Integer component47() {
      return this.coolautofs3;
   }

   public final Integer component48() {
      return this.coolecotag;
   }

   public final Integer component49() {
      return this.coolecofs1;
   }

   public final Boolean component5() {
      return this.eco;
   }

   public final Integer component50() {
      return this.coolecofs2;
   }

   public final Integer component51() {
      return this.mode;
   }

   public final Boolean component52() {
      return this.hummode;
   }

   public final Integer component53() {
      return this.wlevel;
   }

   public final Integer component54() {
      return this.dehsubmode;
   }

   public final Boolean component55() {
      return this.watertankfailure;
   }

   public final Integer component56() {
      return this.smartsubmode;
   }

   public final Boolean component57() {
      return this.detectcat;
   }

   public final Boolean component58() {
      return this.bodymounted;
   }

   public final Integer component59() {
      return this.aireta;
   }

   public final Boolean component6() {
      return this.hins;
   }

   public final Integer component60() {
      return this.displaymode;
   }

   public final Boolean component61() {
      return this.hover;
   }

   public final Boolean component62() {
      return this.airrefresh;
   }

   public final Integer component63() {
      return this.arstate;
   }

   public final Integer component64() {
      return this.ardur;
   }

   public final Integer component65() {
      return this.arts;
   }

   public final Integer component66() {
      return this.startts;
   }

   public final Integer component67() {
      return this.endts;
   }

   public final Integer component68() {
      return this.roomtype;
   }

   public final Integer component69() {
      return this.nlbrightness;
   }

   public final Boolean component7() {
      return this.nmhins;
   }

   public final Integer component70() {
      return this.wickdrydur;
   }

   public final Boolean component71() {
      return this.wickdrydone;
   }

   public final Boolean component72() {
      return this.ywrme;
   }

   public final Integer component73() {
      return this.ywrmusage;
   }

   public final Integer component74() {
      return this.nlstepless;
   }

   public final Object component75() {
      return this.alarm1;
   }

   public final Object component76() {
      return this.alarm2;
   }

   public final Object component77() {
      return this.alarm3;
   }

   public final Object component78() {
      return this.alarm4;
   }

   public final Object component79() {
      return this.alarm5;
   }

   public final Integer component8() {
      return this.fanspeed;
   }

   public final Object component80() {
      return this.alarm6;
   }

   public final Integer component81() {
      return this.humsubmode;
   }

   public final Boolean component82() {
      return this.hourformat;
   }

   public final Boolean component83() {
      return this.wtankfail;
   }

   public final Boolean component84() {
      return this.waterinfill;
   }

   public final Integer component85() {
      return this.sensormode;
   }

   public final Integer component86() {
      return this.coolfslevel;
   }

   public final Integer component87() {
      return this.coolauto;
   }

   public final Long component88() {
      return this.nightstartts;
   }

   public final Integer component89() {
      return this.rpm;
   }

   public final Boolean component9() {
      return this.childlock;
   }

   public final Integer component90() {
      return this.oscmode;
   }

   public final Integer component91() {
      return this.oscstateh;
   }

   public final Integer component92() {
      return this.oscfixh;
   }

   public final Integer component93() {
      return this.oscminh;
   }

   public final Integer component94() {
      return this.oscmaxh;
   }

   public final Integer component95() {
      return this.oscstatev;
   }

   public final Integer component96() {
      return this.oscfixv;
   }

   public final Integer component97() {
      return this.oscminv;
   }

   public final Integer component98() {
      return this.oscmaxv;
   }

   public final Integer component99() {
      return this.calibrationh;
   }

   public final DeviceState copy(String var1, Boolean var2, Boolean var3, Boolean var4, Boolean var5, Boolean var6, Boolean var7, Integer var8, Boolean var9, Boolean var10, String var11, Boolean var12, String var13, Integer var14, Boolean var15, Integer var16, Boolean var17, Integer var18, Boolean var19, Boolean var20, Integer var21, Integer var22, Integer var23, Boolean var24, Integer var25, Integer var26, Integer var27, Integer var28, Integer var29, Integer var30, Integer var31, Integer var32, Integer var33, Integer var34, Integer var35, Integer var36, Integer var37, Integer var38, Integer var39, Integer var40, Integer var41, Integer var42, Integer var43, Integer var44, Integer var45, Integer var46, Integer var47, Integer var48, Integer var49, Integer var50, Integer var51, Boolean var52, Integer var53, Integer var54, Boolean var55, Integer var56, Boolean var57, Boolean var58, Integer var59, Integer var60, Boolean var61, Boolean var62, Integer var63, Integer var64, Integer var65, Integer var66, Integer var67, Integer var68, Integer var69, Integer var70, Boolean var71, Boolean var72, Integer var73, Integer var74, Object var75, Object var76, Object var77, Object var78, Object var79, Object var80, Integer var81, Boolean var82, Boolean var83, Boolean var84, Integer var85, Integer var86, Integer var87, Long var88, Integer var89, Integer var90, Integer var91, Integer var92, Integer var93, Integer var94, Integer var95, Integer var96, Integer var97, Integer var98, Integer var99, Integer var100) {
      return new DeviceState(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19, var20, var21, var22, var23, var24, var25, var26, var27, var28, var29, var30, var31, var32, var33, var34, var35, var36, var37, var38, var39, var40, var41, var42, var43, var44, var45, var46, var47, var48, var49, var50, var51, var52, var53, var54, var55, var56, var57, var58, var59, var60, var61, var62, var63, var64, var65, var66, var67, var68, var69, var70, var71, var72, var73, var74, var75, var76, var77, var78, var79, var80, var81, var82, var83, var84, var85, var86, var87, var88, var89, var90, var91, var92, var93, var94, var95, var96, var97, var98, var99, var100);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DeviceState)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.cfv, var1.cfv)) {
            return false;
         } else if (!Intrinsics.areEqual(this.germshield, var1.germshield)) {
            return false;
         } else if (!Intrinsics.areEqual(this.gsnm, var1.gsnm)) {
            return false;
         } else if (!Intrinsics.areEqual(this.standby, var1.standby)) {
            return false;
         } else if (!Intrinsics.areEqual(this.eco, var1.eco)) {
            return false;
         } else if (!Intrinsics.areEqual(this.hins, var1.hins)) {
            return false;
         } else if (!Intrinsics.areEqual(this.nmhins, var1.nmhins)) {
            return false;
         } else if (!Intrinsics.areEqual(this.fanspeed, var1.fanspeed)) {
            return false;
         } else if (!Intrinsics.areEqual(this.childlock, var1.childlock)) {
            return false;
         } else if (!Intrinsics.areEqual(this.nightmode, var1.nightmode)) {
            return false;
         } else if (!Intrinsics.areEqual(this.mfv, var1.mfv)) {
            return false;
         } else if (!Intrinsics.areEqual(this.automode, var1.automode)) {
            return false;
         } else if (!Intrinsics.areEqual(this.ofv, var1.ofv)) {
            return false;
         } else if (!Intrinsics.areEqual(this.brightness, var1.brightness)) {
            return false;
         } else if (!Intrinsics.areEqual(this.safetyswitch, var1.safetyswitch)) {
            return false;
         } else if (!Intrinsics.areEqual(this.filterusage, var1.filterusage)) {
            return false;
         } else if (!Intrinsics.areEqual(this.disinfection, var1.disinfection)) {
            return false;
         } else if (!Intrinsics.areEqual(this.disinftime, var1.disinftime)) {
            return false;
         } else if (!Intrinsics.areEqual(this.wickdrye, var1.wickdrye)) {
            return false;
         } else if (!Intrinsics.areEqual(this.wickdrys, var1.wickdrys)) {
            return false;
         } else if (!Intrinsics.areEqual(this.wickdryl, var1.wickdryl)) {
            return false;
         } else if (!Intrinsics.areEqual(this.wickdryts, var1.wickdryts)) {
            return false;
         } else if (!Intrinsics.areEqual(this.wickusage, var1.wickusage)) {
            return false;
         } else if (!Intrinsics.areEqual(this.wshortage, var1.wshortage)) {
            return false;
         } else if (!Intrinsics.areEqual(this.autorh, var1.autorh)) {
            return false;
         } else if (!Intrinsics.areEqual(this.timstate, var1.timstate)) {
            return false;
         } else if (!Intrinsics.areEqual(this.timdur, var1.timdur)) {
            return false;
         } else if (!Intrinsics.areEqual(this.timl, var1.timl)) {
            return false;
         } else if (!Intrinsics.areEqual(this.timts, var1.timts)) {
            return false;
         } else if (!Intrinsics.areEqual(this.tu, var1.tu)) {
            return false;
         } else if (!Intrinsics.areEqual(this.oscstate, var1.oscstate)) {
            return false;
         } else if (!Intrinsics.areEqual(this.osc, var1.osc)) {
            return false;
         } else if (!Intrinsics.areEqual(this.oscdir, var1.oscdir)) {
            return false;
         } else if (!Intrinsics.areEqual(this.oscfs, var1.oscfs)) {
            return false;
         } else if (!Intrinsics.areEqual(this.mainmode, var1.mainmode)) {
            return false;
         } else if (!Intrinsics.areEqual(this.apsubmode, var1.apsubmode)) {
            return false;
         } else if (!Intrinsics.areEqual(this.fsp0, var1.fsp0)) {
            return false;
         } else if (!Intrinsics.areEqual(this.heatsubmode, var1.heatsubmode)) {
            return false;
         } else if (!Intrinsics.areEqual(this.heatfs, var1.heatfs)) {
            return false;
         } else if (!Intrinsics.areEqual(this.heattemp, var1.heattemp)) {
            return false;
         } else if (!Intrinsics.areEqual(this.ecoheattemp, var1.ecoheattemp)) {
            return false;
         } else if (!Intrinsics.areEqual(this.coolsubmode, var1.coolsubmode)) {
            return false;
         } else if (!Intrinsics.areEqual(this.coolfs, var1.coolfs)) {
            return false;
         } else if (!Intrinsics.areEqual(this.coolautotag, var1.coolautotag)) {
            return false;
         } else if (!Intrinsics.areEqual(this.coolautofs1, var1.coolautofs1)) {
            return false;
         } else if (!Intrinsics.areEqual(this.coolautofs2, var1.coolautofs2)) {
            return false;
         } else if (!Intrinsics.areEqual(this.coolautofs3, var1.coolautofs3)) {
            return false;
         } else if (!Intrinsics.areEqual(this.coolecotag, var1.coolecotag)) {
            return false;
         } else if (!Intrinsics.areEqual(this.coolecofs1, var1.coolecofs1)) {
            return false;
         } else if (!Intrinsics.areEqual(this.coolecofs2, var1.coolecofs2)) {
            return false;
         } else if (!Intrinsics.areEqual(this.mode, var1.mode)) {
            return false;
         } else if (!Intrinsics.areEqual(this.hummode, var1.hummode)) {
            return false;
         } else if (!Intrinsics.areEqual(this.wlevel, var1.wlevel)) {
            return false;
         } else if (!Intrinsics.areEqual(this.dehsubmode, var1.dehsubmode)) {
            return false;
         } else if (!Intrinsics.areEqual(this.watertankfailure, var1.watertankfailure)) {
            return false;
         } else if (!Intrinsics.areEqual(this.smartsubmode, var1.smartsubmode)) {
            return false;
         } else if (!Intrinsics.areEqual(this.detectcat, var1.detectcat)) {
            return false;
         } else if (!Intrinsics.areEqual(this.bodymounted, var1.bodymounted)) {
            return false;
         } else if (!Intrinsics.areEqual(this.aireta, var1.aireta)) {
            return false;
         } else if (!Intrinsics.areEqual(this.displaymode, var1.displaymode)) {
            return false;
         } else if (!Intrinsics.areEqual(this.hover, var1.hover)) {
            return false;
         } else if (!Intrinsics.areEqual(this.airrefresh, var1.airrefresh)) {
            return false;
         } else if (!Intrinsics.areEqual(this.arstate, var1.arstate)) {
            return false;
         } else if (!Intrinsics.areEqual(this.ardur, var1.ardur)) {
            return false;
         } else if (!Intrinsics.areEqual(this.arts, var1.arts)) {
            return false;
         } else if (!Intrinsics.areEqual(this.startts, var1.startts)) {
            return false;
         } else if (!Intrinsics.areEqual(this.endts, var1.endts)) {
            return false;
         } else if (!Intrinsics.areEqual(this.roomtype, var1.roomtype)) {
            return false;
         } else if (!Intrinsics.areEqual(this.nlbrightness, var1.nlbrightness)) {
            return false;
         } else if (!Intrinsics.areEqual(this.wickdrydur, var1.wickdrydur)) {
            return false;
         } else if (!Intrinsics.areEqual(this.wickdrydone, var1.wickdrydone)) {
            return false;
         } else if (!Intrinsics.areEqual(this.ywrme, var1.ywrme)) {
            return false;
         } else if (!Intrinsics.areEqual(this.ywrmusage, var1.ywrmusage)) {
            return false;
         } else if (!Intrinsics.areEqual(this.nlstepless, var1.nlstepless)) {
            return false;
         } else if (!Intrinsics.areEqual(this.alarm1, var1.alarm1)) {
            return false;
         } else if (!Intrinsics.areEqual(this.alarm2, var1.alarm2)) {
            return false;
         } else if (!Intrinsics.areEqual(this.alarm3, var1.alarm3)) {
            return false;
         } else if (!Intrinsics.areEqual(this.alarm4, var1.alarm4)) {
            return false;
         } else if (!Intrinsics.areEqual(this.alarm5, var1.alarm5)) {
            return false;
         } else if (!Intrinsics.areEqual(this.alarm6, var1.alarm6)) {
            return false;
         } else if (!Intrinsics.areEqual(this.humsubmode, var1.humsubmode)) {
            return false;
         } else if (!Intrinsics.areEqual(this.hourformat, var1.hourformat)) {
            return false;
         } else if (!Intrinsics.areEqual(this.wtankfail, var1.wtankfail)) {
            return false;
         } else if (!Intrinsics.areEqual(this.waterinfill, var1.waterinfill)) {
            return false;
         } else if (!Intrinsics.areEqual(this.sensormode, var1.sensormode)) {
            return false;
         } else if (!Intrinsics.areEqual(this.coolfslevel, var1.coolfslevel)) {
            return false;
         } else if (!Intrinsics.areEqual(this.coolauto, var1.coolauto)) {
            return false;
         } else if (!Intrinsics.areEqual(this.nightstartts, var1.nightstartts)) {
            return false;
         } else if (!Intrinsics.areEqual(this.rpm, var1.rpm)) {
            return false;
         } else if (!Intrinsics.areEqual(this.oscmode, var1.oscmode)) {
            return false;
         } else if (!Intrinsics.areEqual(this.oscstateh, var1.oscstateh)) {
            return false;
         } else if (!Intrinsics.areEqual(this.oscfixh, var1.oscfixh)) {
            return false;
         } else if (!Intrinsics.areEqual(this.oscminh, var1.oscminh)) {
            return false;
         } else if (!Intrinsics.areEqual(this.oscmaxh, var1.oscmaxh)) {
            return false;
         } else if (!Intrinsics.areEqual(this.oscstatev, var1.oscstatev)) {
            return false;
         } else if (!Intrinsics.areEqual(this.oscfixv, var1.oscfixv)) {
            return false;
         } else if (!Intrinsics.areEqual(this.oscminv, var1.oscminv)) {
            return false;
         } else if (!Intrinsics.areEqual(this.oscmaxv, var1.oscmaxv)) {
            return false;
         } else if (!Intrinsics.areEqual(this.calibrationh, var1.calibrationh)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.calibrationv, var1.calibrationv);
         }
      }
   }

   public final Integer getAireta() {
      return this.aireta;
   }

   public final Boolean getAirrefresh() {
      return this.airrefresh;
   }

   public final Object getAlarm1() {
      return this.alarm1;
   }

   public final Object getAlarm2() {
      return this.alarm2;
   }

   public final Object getAlarm3() {
      return this.alarm3;
   }

   public final Object getAlarm4() {
      return this.alarm4;
   }

   public final Object getAlarm5() {
      return this.alarm5;
   }

   public final Object getAlarm6() {
      return this.alarm6;
   }

   public final Integer getApsubmode() {
      return this.apsubmode;
   }

   public final Integer getArdur() {
      return this.ardur;
   }

   public final Integer getArstate() {
      return this.arstate;
   }

   public final Integer getArts() {
      return this.arts;
   }

   public final Boolean getAutomode() {
      return this.automode;
   }

   public final Integer getAutorh() {
      return this.autorh;
   }

   public final Boolean getBodymounted() {
      return this.bodymounted;
   }

   public final Integer getBrightness() {
      return this.brightness;
   }

   public final Integer getCalibrationh() {
      return this.calibrationh;
   }

   public final Integer getCalibrationv() {
      return this.calibrationv;
   }

   public final String getCfv() {
      return this.cfv;
   }

   public final Boolean getChildlock() {
      return this.childlock;
   }

   public final Integer getCoolauto() {
      return this.coolauto;
   }

   public final Integer getCoolautofs1() {
      return this.coolautofs1;
   }

   public final Integer getCoolautofs2() {
      return this.coolautofs2;
   }

   public final Integer getCoolautofs3() {
      return this.coolautofs3;
   }

   public final Integer getCoolautotag() {
      return this.coolautotag;
   }

   public final Integer getCoolecofs1() {
      return this.coolecofs1;
   }

   public final Integer getCoolecofs2() {
      return this.coolecofs2;
   }

   public final Integer getCoolecotag() {
      return this.coolecotag;
   }

   public final Integer getCoolfs() {
      return this.coolfs;
   }

   public final Integer getCoolfslevel() {
      return this.coolfslevel;
   }

   public final Integer getCoolsubmode() {
      return this.coolsubmode;
   }

   public final Integer getDehsubmode() {
      return this.dehsubmode;
   }

   public final Boolean getDetectcat() {
      return this.detectcat;
   }

   public final Boolean getDisinfection() {
      return this.disinfection;
   }

   public final Integer getDisinftime() {
      return this.disinftime;
   }

   public final Integer getDisplaymode() {
      return this.displaymode;
   }

   public final Boolean getEco() {
      return this.eco;
   }

   public final Integer getEcoheattemp() {
      return this.ecoheattemp;
   }

   public final Integer getEndts() {
      return this.endts;
   }

   public final Integer getFanspeed() {
      return this.fanspeed;
   }

   public final Integer getFilterusage() {
      return this.filterusage;
   }

   public final Integer getFsp0() {
      return this.fsp0;
   }

   public final Boolean getGermshield() {
      return this.germshield;
   }

   public final Boolean getGsnm() {
      return this.gsnm;
   }

   public final Integer getHeatfs() {
      return this.heatfs;
   }

   public final Integer getHeatsubmode() {
      return this.heatsubmode;
   }

   public final Integer getHeattemp() {
      return this.heattemp;
   }

   public final Boolean getHins() {
      return this.hins;
   }

   public final Boolean getHourformat() {
      return this.hourformat;
   }

   public final Boolean getHover() {
      return this.hover;
   }

   public final Boolean getHummode() {
      return this.hummode;
   }

   public final Integer getHumsubmode() {
      return this.humsubmode;
   }

   public final Integer getMainmode() {
      return this.mainmode;
   }

   public final String getMfv() {
      return this.mfv;
   }

   public final Integer getMode() {
      return this.mode;
   }

   public final Boolean getNightmode() {
      return this.nightmode;
   }

   public final Long getNightstartts() {
      return this.nightstartts;
   }

   public final Integer getNlbrightness() {
      return this.nlbrightness;
   }

   public final Integer getNlstepless() {
      return this.nlstepless;
   }

   public final Boolean getNmhins() {
      return this.nmhins;
   }

   public final String getOfv() {
      return this.ofv;
   }

   public final Integer getOsc() {
      return this.osc;
   }

   public final Integer getOscdir() {
      return this.oscdir;
   }

   public final Integer getOscfixh() {
      return this.oscfixh;
   }

   public final Integer getOscfixv() {
      return this.oscfixv;
   }

   public final Integer getOscfs() {
      return this.oscfs;
   }

   public final Integer getOscmaxh() {
      return this.oscmaxh;
   }

   public final Integer getOscmaxv() {
      return this.oscmaxv;
   }

   public final Integer getOscminh() {
      return this.oscminh;
   }

   public final Integer getOscminv() {
      return this.oscminv;
   }

   public final Integer getOscmode() {
      return this.oscmode;
   }

   public final Integer getOscstate() {
      return this.oscstate;
   }

   public final Integer getOscstateh() {
      return this.oscstateh;
   }

   public final Integer getOscstatev() {
      return this.oscstatev;
   }

   public final Integer getRoomtype() {
      return this.roomtype;
   }

   public final Integer getRpm() {
      return this.rpm;
   }

   public final Boolean getSafetyswitch() {
      return this.safetyswitch;
   }

   public final Integer getSensormode() {
      return this.sensormode;
   }

   public final Integer getSmartsubmode() {
      return this.smartsubmode;
   }

   public final Boolean getStandby() {
      return this.standby;
   }

   public final Integer getStartts() {
      return this.startts;
   }

   public final Integer getTimdur() {
      return this.timdur;
   }

   public final Integer getTiml() {
      return this.timl;
   }

   public final Integer getTimstate() {
      return this.timstate;
   }

   public final Integer getTimts() {
      return this.timts;
   }

   public final Integer getTu() {
      return this.tu;
   }

   public final Boolean getWaterinfill() {
      return this.waterinfill;
   }

   public final Boolean getWatertankfailure() {
      return this.watertankfailure;
   }

   public final Boolean getWickdrydone() {
      return this.wickdrydone;
   }

   public final Integer getWickdrydur() {
      return this.wickdrydur;
   }

   public final Boolean getWickdrye() {
      return this.wickdrye;
   }

   public final Integer getWickdryl() {
      return this.wickdryl;
   }

   public final Boolean getWickdrys() {
      return this.wickdrys;
   }

   public final Integer getWickdryts() {
      return this.wickdryts;
   }

   public final Integer getWickusage() {
      return this.wickusage;
   }

   public final Integer getWlevel() {
      return this.wlevel;
   }

   public final Boolean getWshortage() {
      return this.wshortage;
   }

   public final Boolean getWtankfail() {
      return this.wtankfail;
   }

   public final Boolean getYwrme() {
      return this.ywrme;
   }

   public final Integer getYwrmusage() {
      return this.ywrmusage;
   }

   public int hashCode() {
      String var101 = this.cfv;
      int var100 = 0;
      int var1;
      if (var101 == null) {
         var1 = 0;
      } else {
         var1 = var101.hashCode();
      }

      Boolean var102 = this.germshield;
      int var2;
      if (var102 == null) {
         var2 = 0;
      } else {
         var2 = var102.hashCode();
      }

      var102 = this.gsnm;
      int var3;
      if (var102 == null) {
         var3 = 0;
      } else {
         var3 = var102.hashCode();
      }

      var102 = this.standby;
      int var4;
      if (var102 == null) {
         var4 = 0;
      } else {
         var4 = var102.hashCode();
      }

      var102 = this.eco;
      int var5;
      if (var102 == null) {
         var5 = 0;
      } else {
         var5 = var102.hashCode();
      }

      var102 = this.hins;
      int var6;
      if (var102 == null) {
         var6 = 0;
      } else {
         var6 = var102.hashCode();
      }

      var102 = this.nmhins;
      int var7;
      if (var102 == null) {
         var7 = 0;
      } else {
         var7 = var102.hashCode();
      }

      Integer var108 = this.fanspeed;
      int var8;
      if (var108 == null) {
         var8 = 0;
      } else {
         var8 = var108.hashCode();
      }

      Boolean var109 = this.childlock;
      int var9;
      if (var109 == null) {
         var9 = 0;
      } else {
         var9 = var109.hashCode();
      }

      var109 = this.nightmode;
      int var10;
      if (var109 == null) {
         var10 = 0;
      } else {
         var10 = var109.hashCode();
      }

      String var111 = this.mfv;
      int var11;
      if (var111 == null) {
         var11 = 0;
      } else {
         var11 = var111.hashCode();
      }

      Boolean var112 = this.automode;
      int var12;
      if (var112 == null) {
         var12 = 0;
      } else {
         var12 = var112.hashCode();
      }

      String var113 = this.ofv;
      int var13;
      if (var113 == null) {
         var13 = 0;
      } else {
         var13 = var113.hashCode();
      }

      Integer var114 = this.brightness;
      int var14;
      if (var114 == null) {
         var14 = 0;
      } else {
         var14 = var114.hashCode();
      }

      Boolean var115 = this.safetyswitch;
      int var15;
      if (var115 == null) {
         var15 = 0;
      } else {
         var15 = var115.hashCode();
      }

      Integer var116 = this.filterusage;
      int var16;
      if (var116 == null) {
         var16 = 0;
      } else {
         var16 = var116.hashCode();
      }

      Boolean var117 = this.disinfection;
      int var17;
      if (var117 == null) {
         var17 = 0;
      } else {
         var17 = var117.hashCode();
      }

      Integer var118 = this.disinftime;
      int var18;
      if (var118 == null) {
         var18 = 0;
      } else {
         var18 = var118.hashCode();
      }

      Boolean var119 = this.wickdrye;
      int var19;
      if (var119 == null) {
         var19 = 0;
      } else {
         var19 = var119.hashCode();
      }

      var119 = this.wickdrys;
      int var20;
      if (var119 == null) {
         var20 = 0;
      } else {
         var20 = var119.hashCode();
      }

      Integer var121 = this.wickdryl;
      int var21;
      if (var121 == null) {
         var21 = 0;
      } else {
         var21 = var121.hashCode();
      }

      var121 = this.wickdryts;
      int var22;
      if (var121 == null) {
         var22 = 0;
      } else {
         var22 = var121.hashCode();
      }

      var121 = this.wickusage;
      int var23;
      if (var121 == null) {
         var23 = 0;
      } else {
         var23 = var121.hashCode();
      }

      Boolean var124 = this.wshortage;
      int var24;
      if (var124 == null) {
         var24 = 0;
      } else {
         var24 = var124.hashCode();
      }

      Integer var125 = this.autorh;
      int var25;
      if (var125 == null) {
         var25 = 0;
      } else {
         var25 = var125.hashCode();
      }

      var125 = this.timstate;
      int var26;
      if (var125 == null) {
         var26 = 0;
      } else {
         var26 = var125.hashCode();
      }

      var125 = this.timdur;
      int var27;
      if (var125 == null) {
         var27 = 0;
      } else {
         var27 = var125.hashCode();
      }

      var125 = this.timl;
      int var28;
      if (var125 == null) {
         var28 = 0;
      } else {
         var28 = var125.hashCode();
      }

      var125 = this.timts;
      int var29;
      if (var125 == null) {
         var29 = 0;
      } else {
         var29 = var125.hashCode();
      }

      var125 = this.tu;
      int var30;
      if (var125 == null) {
         var30 = 0;
      } else {
         var30 = var125.hashCode();
      }

      var125 = this.oscstate;
      int var31;
      if (var125 == null) {
         var31 = 0;
      } else {
         var31 = var125.hashCode();
      }

      var125 = this.osc;
      int var32;
      if (var125 == null) {
         var32 = 0;
      } else {
         var32 = var125.hashCode();
      }

      var125 = this.oscdir;
      int var33;
      if (var125 == null) {
         var33 = 0;
      } else {
         var33 = var125.hashCode();
      }

      var125 = this.oscfs;
      int var34;
      if (var125 == null) {
         var34 = 0;
      } else {
         var34 = var125.hashCode();
      }

      var125 = this.mainmode;
      int var35;
      if (var125 == null) {
         var35 = 0;
      } else {
         var35 = var125.hashCode();
      }

      var125 = this.apsubmode;
      int var36;
      if (var125 == null) {
         var36 = 0;
      } else {
         var36 = var125.hashCode();
      }

      var125 = this.fsp0;
      int var37;
      if (var125 == null) {
         var37 = 0;
      } else {
         var37 = var125.hashCode();
      }

      var125 = this.heatsubmode;
      int var38;
      if (var125 == null) {
         var38 = 0;
      } else {
         var38 = var125.hashCode();
      }

      var125 = this.heatfs;
      int var39;
      if (var125 == null) {
         var39 = 0;
      } else {
         var39 = var125.hashCode();
      }

      var125 = this.heattemp;
      int var40;
      if (var125 == null) {
         var40 = 0;
      } else {
         var40 = var125.hashCode();
      }

      var125 = this.ecoheattemp;
      int var41;
      if (var125 == null) {
         var41 = 0;
      } else {
         var41 = var125.hashCode();
      }

      var125 = this.coolsubmode;
      int var42;
      if (var125 == null) {
         var42 = 0;
      } else {
         var42 = var125.hashCode();
      }

      var125 = this.coolfs;
      int var43;
      if (var125 == null) {
         var43 = 0;
      } else {
         var43 = var125.hashCode();
      }

      var125 = this.coolautotag;
      int var44;
      if (var125 == null) {
         var44 = 0;
      } else {
         var44 = var125.hashCode();
      }

      var125 = this.coolautofs1;
      int var45;
      if (var125 == null) {
         var45 = 0;
      } else {
         var45 = var125.hashCode();
      }

      var125 = this.coolautofs2;
      int var46;
      if (var125 == null) {
         var46 = 0;
      } else {
         var46 = var125.hashCode();
      }

      var125 = this.coolautofs3;
      int var47;
      if (var125 == null) {
         var47 = 0;
      } else {
         var47 = var125.hashCode();
      }

      var125 = this.coolecotag;
      int var48;
      if (var125 == null) {
         var48 = 0;
      } else {
         var48 = var125.hashCode();
      }

      var125 = this.coolecofs1;
      int var49;
      if (var125 == null) {
         var49 = 0;
      } else {
         var49 = var125.hashCode();
      }

      var125 = this.coolecofs2;
      int var50;
      if (var125 == null) {
         var50 = 0;
      } else {
         var50 = var125.hashCode();
      }

      var125 = this.mode;
      int var51;
      if (var125 == null) {
         var51 = 0;
      } else {
         var51 = var125.hashCode();
      }

      Boolean var152 = this.hummode;
      int var52;
      if (var152 == null) {
         var52 = 0;
      } else {
         var52 = var152.hashCode();
      }

      Integer var153 = this.wlevel;
      int var53;
      if (var153 == null) {
         var53 = 0;
      } else {
         var53 = var153.hashCode();
      }

      var153 = this.dehsubmode;
      int var54;
      if (var153 == null) {
         var54 = 0;
      } else {
         var54 = var153.hashCode();
      }

      Boolean var155 = this.watertankfailure;
      int var55;
      if (var155 == null) {
         var55 = 0;
      } else {
         var55 = var155.hashCode();
      }

      Integer var156 = this.smartsubmode;
      int var56;
      if (var156 == null) {
         var56 = 0;
      } else {
         var56 = var156.hashCode();
      }

      Boolean var157 = this.detectcat;
      int var57;
      if (var157 == null) {
         var57 = 0;
      } else {
         var57 = var157.hashCode();
      }

      var157 = this.bodymounted;
      int var58;
      if (var157 == null) {
         var58 = 0;
      } else {
         var58 = var157.hashCode();
      }

      Integer var159 = this.aireta;
      int var59;
      if (var159 == null) {
         var59 = 0;
      } else {
         var59 = var159.hashCode();
      }

      var159 = this.displaymode;
      int var60;
      if (var159 == null) {
         var60 = 0;
      } else {
         var60 = var159.hashCode();
      }

      Boolean var161 = this.hover;
      int var61;
      if (var161 == null) {
         var61 = 0;
      } else {
         var61 = var161.hashCode();
      }

      var161 = this.airrefresh;
      int var62;
      if (var161 == null) {
         var62 = 0;
      } else {
         var62 = var161.hashCode();
      }

      Integer var163 = this.arstate;
      int var63;
      if (var163 == null) {
         var63 = 0;
      } else {
         var63 = var163.hashCode();
      }

      var163 = this.ardur;
      int var64;
      if (var163 == null) {
         var64 = 0;
      } else {
         var64 = var163.hashCode();
      }

      var163 = this.arts;
      int var65;
      if (var163 == null) {
         var65 = 0;
      } else {
         var65 = var163.hashCode();
      }

      var163 = this.startts;
      int var66;
      if (var163 == null) {
         var66 = 0;
      } else {
         var66 = var163.hashCode();
      }

      var163 = this.endts;
      int var67;
      if (var163 == null) {
         var67 = 0;
      } else {
         var67 = var163.hashCode();
      }

      var163 = this.roomtype;
      int var68;
      if (var163 == null) {
         var68 = 0;
      } else {
         var68 = var163.hashCode();
      }

      var163 = this.nlbrightness;
      int var69;
      if (var163 == null) {
         var69 = 0;
      } else {
         var69 = var163.hashCode();
      }

      var163 = this.wickdrydur;
      int var70;
      if (var163 == null) {
         var70 = 0;
      } else {
         var70 = var163.hashCode();
      }

      Boolean var171 = this.wickdrydone;
      int var71;
      if (var171 == null) {
         var71 = 0;
      } else {
         var71 = var171.hashCode();
      }

      var171 = this.ywrme;
      int var72;
      if (var171 == null) {
         var72 = 0;
      } else {
         var72 = var171.hashCode();
      }

      Integer var173 = this.ywrmusage;
      int var73;
      if (var173 == null) {
         var73 = 0;
      } else {
         var73 = var173.hashCode();
      }

      var173 = this.nlstepless;
      int var74;
      if (var173 == null) {
         var74 = 0;
      } else {
         var74 = var173.hashCode();
      }

      Object var175 = this.alarm1;
      int var75;
      if (var175 == null) {
         var75 = 0;
      } else {
         var75 = var175.hashCode();
      }

      var175 = this.alarm2;
      int var76;
      if (var175 == null) {
         var76 = 0;
      } else {
         var76 = var175.hashCode();
      }

      var175 = this.alarm3;
      int var77;
      if (var175 == null) {
         var77 = 0;
      } else {
         var77 = var175.hashCode();
      }

      var175 = this.alarm4;
      int var78;
      if (var175 == null) {
         var78 = 0;
      } else {
         var78 = var175.hashCode();
      }

      var175 = this.alarm5;
      int var79;
      if (var175 == null) {
         var79 = 0;
      } else {
         var79 = var175.hashCode();
      }

      var175 = this.alarm6;
      int var80;
      if (var175 == null) {
         var80 = 0;
      } else {
         var80 = var175.hashCode();
      }

      Integer var181 = this.humsubmode;
      int var81;
      if (var181 == null) {
         var81 = 0;
      } else {
         var81 = var181.hashCode();
      }

      Boolean var182 = this.hourformat;
      int var82;
      if (var182 == null) {
         var82 = 0;
      } else {
         var82 = var182.hashCode();
      }

      var182 = this.wtankfail;
      int var83;
      if (var182 == null) {
         var83 = 0;
      } else {
         var83 = var182.hashCode();
      }

      var182 = this.waterinfill;
      int var84;
      if (var182 == null) {
         var84 = 0;
      } else {
         var84 = var182.hashCode();
      }

      Integer var185 = this.sensormode;
      int var85;
      if (var185 == null) {
         var85 = 0;
      } else {
         var85 = var185.hashCode();
      }

      var185 = this.coolfslevel;
      int var86;
      if (var185 == null) {
         var86 = 0;
      } else {
         var86 = var185.hashCode();
      }

      var185 = this.coolauto;
      int var87;
      if (var185 == null) {
         var87 = 0;
      } else {
         var87 = var185.hashCode();
      }

      Long var188 = this.nightstartts;
      int var88;
      if (var188 == null) {
         var88 = 0;
      } else {
         var88 = var188.hashCode();
      }

      Integer var189 = this.rpm;
      int var89;
      if (var189 == null) {
         var89 = 0;
      } else {
         var89 = var189.hashCode();
      }

      var189 = this.oscmode;
      int var90;
      if (var189 == null) {
         var90 = 0;
      } else {
         var90 = var189.hashCode();
      }

      var189 = this.oscstateh;
      int var91;
      if (var189 == null) {
         var91 = 0;
      } else {
         var91 = var189.hashCode();
      }

      var189 = this.oscfixh;
      int var92;
      if (var189 == null) {
         var92 = 0;
      } else {
         var92 = var189.hashCode();
      }

      var189 = this.oscminh;
      int var93;
      if (var189 == null) {
         var93 = 0;
      } else {
         var93 = var189.hashCode();
      }

      var189 = this.oscmaxh;
      int var94;
      if (var189 == null) {
         var94 = 0;
      } else {
         var94 = var189.hashCode();
      }

      var189 = this.oscstatev;
      int var95;
      if (var189 == null) {
         var95 = 0;
      } else {
         var95 = var189.hashCode();
      }

      var189 = this.oscfixv;
      int var96;
      if (var189 == null) {
         var96 = 0;
      } else {
         var96 = var189.hashCode();
      }

      var189 = this.oscminv;
      int var97;
      if (var189 == null) {
         var97 = 0;
      } else {
         var97 = var189.hashCode();
      }

      var189 = this.oscmaxv;
      int var98;
      if (var189 == null) {
         var98 = 0;
      } else {
         var98 = var189.hashCode();
      }

      var189 = this.calibrationh;
      int var99;
      if (var189 == null) {
         var99 = 0;
      } else {
         var99 = var189.hashCode();
      }

      var189 = this.calibrationv;
      if (var189 != null) {
         var100 = var189.hashCode();
      }

      return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((var1 * 31 + var2) * 31 + var3) * 31 + var4) * 31 + var5) * 31 + var6) * 31 + var7) * 31 + var8) * 31 + var9) * 31 + var10) * 31 + var11) * 31 + var12) * 31 + var13) * 31 + var14) * 31 + var15) * 31 + var16) * 31 + var17) * 31 + var18) * 31 + var19) * 31 + var20) * 31 + var21) * 31 + var22) * 31 + var23) * 31 + var24) * 31 + var25) * 31 + var26) * 31 + var27) * 31 + var28) * 31 + var29) * 31 + var30) * 31 + var31) * 31 + var32) * 31 + var33) * 31 + var34) * 31 + var35) * 31 + var36) * 31 + var37) * 31 + var38) * 31 + var39) * 31 + var40) * 31 + var41) * 31 + var42) * 31 + var43) * 31 + var44) * 31 + var45) * 31 + var46) * 31 + var47) * 31 + var48) * 31 + var49) * 31 + var50) * 31 + var51) * 31 + var52) * 31 + var53) * 31 + var54) * 31 + var55) * 31 + var56) * 31 + var57) * 31 + var58) * 31 + var59) * 31 + var60) * 31 + var61) * 31 + var62) * 31 + var63) * 31 + var64) * 31 + var65) * 31 + var66) * 31 + var67) * 31 + var68) * 31 + var69) * 31 + var70) * 31 + var71) * 31 + var72) * 31 + var73) * 31 + var74) * 31 + var75) * 31 + var76) * 31 + var77) * 31 + var78) * 31 + var79) * 31 + var80) * 31 + var81) * 31 + var82) * 31 + var83) * 31 + var84) * 31 + var85) * 31 + var86) * 31 + var87) * 31 + var88) * 31 + var89) * 31 + var90) * 31 + var91) * 31 + var92) * 31 + var93) * 31 + var94) * 31 + var95) * 31 + var96) * 31 + var97) * 31 + var98) * 31 + var99) * 31 + var100;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DeviceState(cfv=");
      var1.append(this.cfv);
      var1.append(", germshield=");
      var1.append(this.germshield);
      var1.append(", gsnm=");
      var1.append(this.gsnm);
      var1.append(", standby=");
      var1.append(this.standby);
      var1.append(", eco=");
      var1.append(this.eco);
      var1.append(", hins=");
      var1.append(this.hins);
      var1.append(", nmhins=");
      var1.append(this.nmhins);
      var1.append(", fanspeed=");
      var1.append(this.fanspeed);
      var1.append(", childlock=");
      var1.append(this.childlock);
      var1.append(", nightmode=");
      var1.append(this.nightmode);
      var1.append(", mfv=");
      var1.append(this.mfv);
      var1.append(", automode=");
      var1.append(this.automode);
      var1.append(", ofv=");
      var1.append(this.ofv);
      var1.append(", brightness=");
      var1.append(this.brightness);
      var1.append(", safetyswitch=");
      var1.append(this.safetyswitch);
      var1.append(", filterusage=");
      var1.append(this.filterusage);
      var1.append(", disinfection=");
      var1.append(this.disinfection);
      var1.append(", disinftime=");
      var1.append(this.disinftime);
      var1.append(", wickdrye=");
      var1.append(this.wickdrye);
      var1.append(", wickdrys=");
      var1.append(this.wickdrys);
      var1.append(", wickdryl=");
      var1.append(this.wickdryl);
      var1.append(", wickdryts=");
      var1.append(this.wickdryts);
      var1.append(", wickusage=");
      var1.append(this.wickusage);
      var1.append(", wshortage=");
      var1.append(this.wshortage);
      var1.append(", autorh=");
      var1.append(this.autorh);
      var1.append(", timstate=");
      var1.append(this.timstate);
      var1.append(", timdur=");
      var1.append(this.timdur);
      var1.append(", timl=");
      var1.append(this.timl);
      var1.append(", timts=");
      var1.append(this.timts);
      var1.append(", tu=");
      var1.append(this.tu);
      var1.append(", oscstate=");
      var1.append(this.oscstate);
      var1.append(", osc=");
      var1.append(this.osc);
      var1.append(", oscdir=");
      var1.append(this.oscdir);
      var1.append(", oscfs=");
      var1.append(this.oscfs);
      var1.append(", mainmode=");
      var1.append(this.mainmode);
      var1.append(", apsubmode=");
      var1.append(this.apsubmode);
      var1.append(", fsp0=");
      var1.append(this.fsp0);
      var1.append(", heatsubmode=");
      var1.append(this.heatsubmode);
      var1.append(", heatfs=");
      var1.append(this.heatfs);
      var1.append(", heattemp=");
      var1.append(this.heattemp);
      var1.append(", ecoheattemp=");
      var1.append(this.ecoheattemp);
      var1.append(", coolsubmode=");
      var1.append(this.coolsubmode);
      var1.append(", coolfs=");
      var1.append(this.coolfs);
      var1.append(", coolautotag=");
      var1.append(this.coolautotag);
      var1.append(", coolautofs1=");
      var1.append(this.coolautofs1);
      var1.append(", coolautofs2=");
      var1.append(this.coolautofs2);
      var1.append(", coolautofs3=");
      var1.append(this.coolautofs3);
      var1.append(", coolecotag=");
      var1.append(this.coolecotag);
      var1.append(", coolecofs1=");
      var1.append(this.coolecofs1);
      var1.append(", coolecofs2=");
      var1.append(this.coolecofs2);
      var1.append(", mode=");
      var1.append(this.mode);
      var1.append(", hummode=");
      var1.append(this.hummode);
      var1.append(", wlevel=");
      var1.append(this.wlevel);
      var1.append(", dehsubmode=");
      var1.append(this.dehsubmode);
      var1.append(", watertankfailure=");
      var1.append(this.watertankfailure);
      var1.append(", smartsubmode=");
      var1.append(this.smartsubmode);
      var1.append(", detectcat=");
      var1.append(this.detectcat);
      var1.append(", bodymounted=");
      var1.append(this.bodymounted);
      var1.append(", aireta=");
      var1.append(this.aireta);
      var1.append(", displaymode=");
      var1.append(this.displaymode);
      var1.append(", hover=");
      var1.append(this.hover);
      var1.append(", airrefresh=");
      var1.append(this.airrefresh);
      var1.append(", arstate=");
      var1.append(this.arstate);
      var1.append(", ardur=");
      var1.append(this.ardur);
      var1.append(", arts=");
      var1.append(this.arts);
      var1.append(", startts=");
      var1.append(this.startts);
      var1.append(", endts=");
      var1.append(this.endts);
      var1.append(", roomtype=");
      var1.append(this.roomtype);
      var1.append(", nlbrightness=");
      var1.append(this.nlbrightness);
      var1.append(", wickdrydur=");
      var1.append(this.wickdrydur);
      var1.append(", wickdrydone=");
      var1.append(this.wickdrydone);
      var1.append(", ywrme=");
      var1.append(this.ywrme);
      var1.append(", ywrmusage=");
      var1.append(this.ywrmusage);
      var1.append(", nlstepless=");
      var1.append(this.nlstepless);
      var1.append(", alarm1=");
      var1.append(this.alarm1);
      var1.append(", alarm2=");
      var1.append(this.alarm2);
      var1.append(", alarm3=");
      var1.append(this.alarm3);
      var1.append(", alarm4=");
      var1.append(this.alarm4);
      var1.append(", alarm5=");
      var1.append(this.alarm5);
      var1.append(", alarm6=");
      var1.append(this.alarm6);
      var1.append(", humsubmode=");
      var1.append(this.humsubmode);
      var1.append(", hourformat=");
      var1.append(this.hourformat);
      var1.append(", wtankfail=");
      var1.append(this.wtankfail);
      var1.append(", waterinfill=");
      var1.append(this.waterinfill);
      var1.append(", sensormode=");
      var1.append(this.sensormode);
      var1.append(", coolfslevel=");
      var1.append(this.coolfslevel);
      var1.append(", coolauto=");
      var1.append(this.coolauto);
      var1.append(", nightstartts=");
      var1.append(this.nightstartts);
      var1.append(", rpm=");
      var1.append(this.rpm);
      var1.append(", oscmode=");
      var1.append(this.oscmode);
      var1.append(", oscstateh=");
      var1.append(this.oscstateh);
      var1.append(", oscfixh=");
      var1.append(this.oscfixh);
      var1.append(", oscminh=");
      var1.append(this.oscminh);
      var1.append(", oscmaxh=");
      var1.append(this.oscmaxh);
      var1.append(", oscstatev=");
      var1.append(this.oscstatev);
      var1.append(", oscfixv=");
      var1.append(this.oscfixv);
      var1.append(", oscminv=");
      var1.append(this.oscminv);
      var1.append(", oscmaxv=");
      var1.append(this.oscmaxv);
      var1.append(", calibrationh=");
      var1.append(this.calibrationh);
      var1.append(", calibrationv=");
      var1.append(this.calibrationv);
      var1.append(')');
      return var1.toString();
   }
}
