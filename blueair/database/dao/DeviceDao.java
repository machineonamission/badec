package com.blueair.database.dao;

import androidx.lifecycle.LiveData;
import com.blueair.database.entity.DeviceEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Metadata(
   d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b:\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0003\b \u0001\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\b2\u0006\u0010\u0010\u001a\u00020\u0011H'J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u0011H'J\u0018\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\f2\u0006\u0010\u0010\u001a\u00020\u0011H'J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@¢\u0006\u0002\u0010\u0014J\u001e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0019Jn\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\"\u001a\u0004\u0018\u00010 2\b\u0010#\u001a\u0004\u0018\u00010 2\b\u0010$\u001a\u0004\u0018\u00010 2\b\u0010%\u001a\u0004\u0018\u00010 2\b\u0010&\u001a\u0004\u0018\u00010 2\b\u0010'\u001a\u0004\u0018\u00010 H§@¢\u0006\u0002\u0010(J \u0010)\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010*\u001a\u0004\u0018\u00010\u0016H§@¢\u0006\u0002\u0010+J \u0010,\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010-\u001a\u0004\u0018\u00010\u0016H§@¢\u0006\u0002\u0010+J*\u0010.\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010-\u001a\u0004\u0018\u00010\u00162\b\u0010/\u001a\u0004\u0018\u00010\u0011H§@¢\u0006\u0002\u00100J \u00101\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010/\u001a\u0004\u0018\u00010\u0011H§@¢\u0006\u0002\u0010\u0019J \u00102\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\b\u00103\u001a\u0004\u0018\u00010\u0016H§@¢\u0006\u0002\u0010+J\u001e\u00104\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u00105\u001a\u000206H§@¢\u0006\u0002\u00107J \u00108\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\b\u00109\u001a\u0004\u0018\u00010\u0011H§@¢\u0006\u0002\u0010\u0019J\u001e\u0010:\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010;\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J\u001e\u0010=\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010=\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010>\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010?\u001a\u0004\u0018\u00010\u0016H§@¢\u0006\u0002\u0010+J\u001e\u0010@\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010A\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0019J\u001e\u0010B\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010C\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0019J>\u0010D\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010E\u001a\u00020\u00112\u0006\u0010F\u001a\u00020\u00112\u0006\u0010G\u001a\u00020\u00112\u0006\u0010H\u001a\u00020\u00112\u0006\u0010I\u001a\u00020\u0011H§@¢\u0006\u0002\u0010JJ\u001e\u0010K\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010L\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0019J\u001e\u0010M\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0019J\u001e\u0010O\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010P\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0019J\u001e\u0010Q\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010R\u001a\u000206H§@¢\u0006\u0002\u00107J\u001e\u0010S\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010T\u001a\u000206H§@¢\u0006\u0002\u00107J\u001e\u0010U\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010V\u001a\u000206H§@¢\u0006\u0002\u00107J\u001e\u0010W\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010X\u001a\u000206H§@¢\u0006\u0002\u00107J\u001e\u0010Y\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010Z\u001a\u000206H§@¢\u0006\u0002\u00107J\u001e\u0010[\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\\\u001a\u000206H§@¢\u0006\u0002\u00107J \u0010]\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010^\u001a\u0004\u0018\u000106H§@¢\u0006\u0002\u0010_J\u001e\u0010`\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010a\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0019J\u001e\u0010b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010c\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0019J\u001e\u0010d\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010e\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0019J\u001e\u0010f\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010g\u001a\u000206H§@¢\u0006\u0002\u00107J\u001e\u0010h\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010i\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0019J\u001e\u0010j\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010k\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0019J\u001e\u0010l\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010m\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0019J\u001e\u0010n\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010o\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<JH\u0010p\u001a\u00020q2\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010r\u001a\u0004\u0018\u00010s2\b\u0010t\u001a\u0004\u0018\u00010s2\b\u0010u\u001a\u0004\u0018\u00010\u00162\b\u0010v\u001a\u0004\u0018\u00010\u00112\b\u0010w\u001a\u0004\u0018\u000106H§@¢\u0006\u0002\u0010xJ \u0010y\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010z\u001a\u0004\u0018\u000106H§@¢\u0006\u0002\u0010_J*\u0010{\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010|\u001a\u0004\u0018\u00010\u00162\b\u0010}\u001a\u0004\u0018\u00010\u001eH§@¢\u0006\u0002\u0010~J\u001f\u0010\u007f\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010\u0080\u0001\u001a\u000206H§@¢\u0006\u0002\u00107J \u0010\u0081\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010\u0082\u0001\u001a\u000206H§@¢\u0006\u0002\u00107J*\u0010\u0083\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010\u0084\u0001\u001a\u00020\u00162\u0007\u0010\u0085\u0001\u001a\u00020\u001eH§@¢\u0006\u0003\u0010\u0086\u0001J \u0010\u0087\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010\u0088\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010\u0089\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010\u008a\u0001\u001a\u000206H§@¢\u0006\u0002\u00107J \u0010\u008b\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010\u008c\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010\u008d\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010\u008e\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010\u008f\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010\u0090\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J*\u0010\u0091\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010\u0092\u0001\u001a\u00020\u00162\u0007\u0010\u0093\u0001\u001a\u00020\u001eH§@¢\u0006\u0003\u0010\u0086\u0001J \u0010\u0094\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010\u0095\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010\u0096\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010\u0097\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010\u0098\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010\u0099\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010\u009a\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010\u009b\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010\u009c\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010\u009d\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010\u009e\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010\u009f\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010 \u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010¡\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010¢\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010£\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010¤\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010¥\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010¦\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010§\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J!\u0010¨\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010©\u0001\u001a\u00020sH§@¢\u0006\u0003\u0010ª\u0001J!\u0010«\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010¬\u0001\u001a\u00020sH§@¢\u0006\u0003\u0010ª\u0001J \u0010\u00ad\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010®\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010¯\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010°\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010±\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010²\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010³\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010´\u0001\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0019J \u0010µ\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010¶\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010·\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010¸\u0001\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0019J\"\u0010¹\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\t\u0010º\u0001\u001a\u0004\u0018\u00010\u0011H§@¢\u0006\u0002\u0010\u0019J\u001b\u0010»\u0001\u001a\u00020\u00162\t\u0010º\u0001\u001a\u0004\u0018\u00010\u0011H§@¢\u0006\u0003\u0010¼\u0001J \u0010½\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010¾\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010¿\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010À\u0001\u001a\u000206H§@¢\u0006\u0002\u00107J \u0010Á\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010Â\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010Ã\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010Ä\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010Å\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010Æ\u0001\u001a\u000206H§@¢\u0006\u0002\u00107J \u0010Ç\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010È\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010É\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010Ê\u0001\u001a\u000206H§@¢\u0006\u0002\u00107J \u0010Ë\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010Ì\u0001\u001a\u000206H§@¢\u0006\u0002\u00107J \u0010Í\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010Î\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010Ï\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010Ð\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010Ñ\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010Ò\u0001\u001a\u000206H§@¢\u0006\u0002\u00107J \u0010Ó\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010Ô\u0001\u001a\u000206H§@¢\u0006\u0002\u00107J \u0010Õ\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010Ö\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010×\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010Ø\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010Ù\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010Ú\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010Û\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010Ü\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010Ý\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010Þ\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010ß\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010à\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010á\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010â\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010ã\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010ä\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010å\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010æ\u0001\u001a\u000206H§@¢\u0006\u0002\u00107J\"\u0010ç\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\t\u0010è\u0001\u001a\u0004\u0018\u000106H§@¢\u0006\u0002\u0010_J \u0010é\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010ê\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010ë\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010ì\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010í\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010î\u0001\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0019J \u0010ï\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010ð\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010ñ\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010ò\u0001\u001a\u000206H§@¢\u0006\u0002\u00107J \u0010ó\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010ô\u0001\u001a\u000206H§@¢\u0006\u0002\u00107J \u0010õ\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010ö\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010÷\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010ø\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J \u0010ù\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010ø\u0001\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J!\u0010ú\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010û\u0001\u001a\u00020\u001eH§@¢\u0006\u0003\u0010ü\u0001J \u0010ý\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010þ\u0001\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0019J \u0010ÿ\u0001\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010\u0080\u0002\u001a\u00020\u0016H§@¢\u0006\u0002\u0010<J{\u0010\u0081\u0002\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00112\u0007\u0010\u0082\u0002\u001a\u00020\u00162\u0007\u0010\u0083\u0002\u001a\u00020\u00162\u0007\u0010\u0084\u0002\u001a\u00020\u00162\u0007\u0010\u0085\u0002\u001a\u00020\u00162\u0007\u0010\u0086\u0002\u001a\u00020\u00162\u0007\u0010\u0087\u0002\u001a\u00020\u00162\u0007\u0010\u0088\u0002\u001a\u00020\u00162\u0007\u0010\u0089\u0002\u001a\u00020\u00162\u0007\u0010\u008a\u0002\u001a\u00020\u00162\u0007\u0010\u008b\u0002\u001a\u00020\u00162\u0007\u0010\u008c\u0002\u001a\u00020\u0016H§@¢\u0006\u0003\u0010\u008d\u0002J\u0011\u0010\u008e\u0002\u001a\u00020q2\u0006\u0010\u0012\u001a\u00020\u0004H'J\u0011\u0010\u008f\u0002\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0004H'J\u0011\u0010\u0090\u0002\u001a\u00020q2\u0006\u0010\u0010\u001a\u00020\u0011H'J\u0012\u0010\u0091\u0002\u001a\u00020q2\u0007\u0010\u0092\u0002\u001a\u000206H'J\t\u0010\u0091\u0002\u001a\u00020qH'R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\b8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR \u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\f8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0093\u0002À\u0006\u0003"},
   d2 = {"Lcom/blueair/database/dao/DeviceDao;", "", "devices", "", "Lcom/blueair/database/entity/DeviceEntity;", "getDevices", "()Ljava/util/List;", "liveDevices", "Landroidx/lifecycle/LiveData;", "getLiveDevices", "()Landroidx/lifecycle/LiveData;", "flowDevices", "Lkotlinx/coroutines/flow/Flow;", "getFlowDevices", "()Lkotlinx/coroutines/flow/Flow;", "liveDevice", "id", "", "device", "getFlowDevice", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateName", "", "deviceId", "name", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTimezone", "timezone", "updateLatestSensorDataPoint", "timeInSeconds", "", "pm1", "", "pm10", "pm25", "voc", "hcho", "tmp", "hum", "fan", "(Ljava/lang/String;JLjava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLastSelectedSensorType", "lastSelectedSensorType", "(Ljava/lang/String;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateFanSpeed", "fanSpeed", "updateFanSpeedAndAutoMode", "autoModeText", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAutoMode", "updateBrightness", "brightness", "updateChildLock", "isChildLockOn", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLinkedDeviceUid", "linkedDeviceUid", "updateConnectivityStatus", "connectivityStatus", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateProgress", "updateFilterLife", "filterLife", "updateSku", "sku", "updateCompatibility", "compatibility", "updateSensorRange", "pm1Ranges", "pm10Ranges", "pm25Ranges", "vocRanges", "hchoRanges", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateWifiFirmware", "wifiFirmware", "updateMcuFirmware", "mcuFirmware", "updateHardware", "hardware", "updateStandByMode", "isStandByOn", "updateEcoMode", "isEcoModeOn", "updateHinsMode", "isHinsModeOn", "updateHinsNightMode", "isHinsNightModeOn", "updateG4NightMode", "isG4NightModeOn", "updateGermShieldMode", "isGermShieldOn", "updateGermShieldNightMode", "isGermShieldNightModeOn", "(Ljava/lang/String;Ljava/lang/Boolean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSerialNumber", "serialNumber", "updateFilterTrigger", "filterTrigger", "updateG4NightModeFilterTrigger", "g4NightModeFilterTrigger", "updateSafetySwitch", "isSafetySwitchOn", "updateMacAddress", "macAddress", "updateModelName", "modelName", "updateFilterType", "filterType", "updateDeviceType", "deviceType", "updateWelcomeHome", "", "lat", "", "lng", "radius", "textValue", "enabled", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDisinfection", "disinfection", "updateDisinfectLeftTime", "disinfectLeftTime", "disinfectLeftTimeUpdateTime", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateWickdryEnabled", "wickdryEnabled", "updateWickdryOn", "wickdryOn", "updateWickdryLeftTime", "wickdryLeftTime", "wickdryLeftTimeUpdateTime", "(Ljava/lang/String;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateWickUsage", "wickUsage", "updateWaterShortage", "waterShortage", "updateAutoRh", "autoRh", "updateTimerStatus", "timerStatus", "updateTimerDuration", "timerDuration", "updateTimerLeftTime", "timerLeftTime", "timerLeftTimeUpdateTime", "updateTemperatureUnit", "temperatureUnit", "updateOscillationState", "oscillationState", "updateOscillationAngle", "oscillationAngle", "updateOscillationDirection", "oscillationDirection", "updateOscillationFanSpeed", "oscillationFanSpeed", "updateMainMode", "mainMode", "updateApSubMode", "apSubMode", "updateApFanSpeed", "apFanSpeed", "updateHeatSubMode", "heatSubMode", "updateHeatFanSpeed", "heatFanSpeed", "updateHeatAutoTmp", "heatAutoTmp", "(Ljava/lang/String;DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateHeatEcoTmp", "heatEcoTmp", "updateCoolSubMode", "coolSubMode", "updateCoolFanSpeed", "coolFanSpeed", "updateCoolAutoTag", "coolAutoTag", "updateCoolAutoPresets", "coolAutoPresets", "updateCoolEcoTag", "coolEcoTag", "updateCoolEcoPresets", "coolEcoPresets", "updateLocationId", "locationId", "deleteLocationId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateMode", "mode", "updateHumMode", "humMode", "updateWaterLevel", "waterLevel", "updateDehSubMode", "dehSubMode", "updateWaterTankFailure", "waterTankFailure", "updateSmartSubMode", "smartSubMode", "updateDetectCat", "detectCat", "updateBodyMounted", "bodyMounted", "updateCleanAirEta", "cleanAirEta", "updatePanelDisplayMode", "panelDisplayMode", "updateHoverEnabled", "hoverEnabled", "updateAirRefreshEnabled", "airRefreshEnabled", "updateAirRefreshStatus", "airRefreshStatus", "updateAirRefreshDuration", "airRefreshDuration", "updateAirRefreshTimeStamp", "airRefreshTimeStamp", "updateAirRefreshStartTimeStamp", "airRefreshStartTimeStamp", "updateAirRefreshEndTimeStamp", "airRefreshEndTimeStamp", "updateRoomType", "roomType", "updateNightLampBrightness", "nightLampBrightness", "updateWickdryDuration", "wickdryDuration", "updateWickdryDone", "wickdryDone", "updateYwrmEnabled", "ywrmEnabled", "updateYwrmUsage", "ywrmUsage", "updateNightLampSteplessBrightness", "nightLampSteplessBrightness", "updateAlarms", "alarms", "updateHumSubMode", "humSubMode", "updateUse24Hour", "use24Hour", "updatWaterInfill", "waterInfill", "updateSensorMode", "sensorMode", "updateCoolAutoLevel", "level", "updateCoolFanSpeedLevel", "updateNightModeStartTime", "startTime", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNightPeriods", "nightPeriods", "updateRpm", "rpm", "updateDualOscillationConfig", "oscillationMode", "horizontalOscillationState", "horizontalOscillationFixAngle", "horizontalOscillationMinAngle", "horizontalOscillationMaxAngle", "verticalOscillationState", "verticalOscillationFixAngle", "verticalOscillationMinAngle", "verticalOscillationMaxAngle", "horizontalCalibrationState", "verticalCalibrationState", "(Ljava/lang/String;IIIIIIIIIIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "update", "delete", "deleteAll", "isAblDevice", "database_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface DeviceDao {
   void delete(String var1);

   void deleteAll();

   void deleteAll(boolean var1);

   Object deleteLocationId(String var1, Continuation var2);

   DeviceEntity device(String var1);

   Object getDevices(Continuation var1);

   List getDevices();

   Flow getFlowDevice(String var1);

   Flow getFlowDevices();

   LiveData getLiveDevices();

   void insert(DeviceEntity var1);

   LiveData liveDevice(String var1);

   Object updatWaterInfill(String var1, boolean var2, Continuation var3);

   int update(DeviceEntity var1);

   Object updateAirRefreshDuration(String var1, int var2, Continuation var3);

   Object updateAirRefreshEnabled(String var1, boolean var2, Continuation var3);

   Object updateAirRefreshEndTimeStamp(String var1, int var2, Continuation var3);

   Object updateAirRefreshStartTimeStamp(String var1, int var2, Continuation var3);

   Object updateAirRefreshStatus(String var1, int var2, Continuation var3);

   Object updateAirRefreshTimeStamp(String var1, int var2, Continuation var3);

   Object updateAlarms(String var1, String var2, Continuation var3);

   Object updateApFanSpeed(String var1, int var2, Continuation var3);

   Object updateApSubMode(String var1, int var2, Continuation var3);

   Object updateAutoMode(String var1, String var2, Continuation var3);

   Object updateAutoRh(String var1, int var2, Continuation var3);

   Object updateBodyMounted(String var1, boolean var2, Continuation var3);

   Object updateBrightness(String var1, Integer var2, Continuation var3);

   Object updateChildLock(String var1, boolean var2, Continuation var3);

   Object updateCleanAirEta(String var1, int var2, Continuation var3);

   Object updateCompatibility(String var1, String var2, Continuation var3);

   Object updateConnectivityStatus(String var1, int var2, Continuation var3);

   Object updateCoolAutoLevel(String var1, int var2, Continuation var3);

   Object updateCoolAutoPresets(String var1, String var2, Continuation var3);

   Object updateCoolAutoTag(String var1, int var2, Continuation var3);

   Object updateCoolEcoPresets(String var1, String var2, Continuation var3);

   Object updateCoolEcoTag(String var1, int var2, Continuation var3);

   Object updateCoolFanSpeed(String var1, int var2, Continuation var3);

   Object updateCoolFanSpeedLevel(String var1, int var2, Continuation var3);

   Object updateCoolSubMode(String var1, int var2, Continuation var3);

   Object updateDehSubMode(String var1, int var2, Continuation var3);

   Object updateDetectCat(String var1, boolean var2, Continuation var3);

   Object updateDeviceType(String var1, int var2, Continuation var3);

   Object updateDisinfectLeftTime(String var1, Integer var2, Long var3, Continuation var4);

   Object updateDisinfection(String var1, Boolean var2, Continuation var3);

   Object updateDualOscillationConfig(String var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, Continuation var13);

   Object updateEcoMode(String var1, boolean var2, Continuation var3);

   Object updateFanSpeed(String var1, Integer var2, Continuation var3);

   Object updateFanSpeedAndAutoMode(String var1, Integer var2, String var3, Continuation var4);

   Object updateFilterLife(String var1, Integer var2, Continuation var3);

   Object updateFilterTrigger(String var1, String var2, Continuation var3);

   Object updateFilterType(String var1, String var2, Continuation var3);

   Object updateG4NightMode(String var1, boolean var2, Continuation var3);

   Object updateG4NightModeFilterTrigger(String var1, String var2, Continuation var3);

   Object updateGermShieldMode(String var1, boolean var2, Continuation var3);

   Object updateGermShieldNightMode(String var1, Boolean var2, Continuation var3);

   Object updateHardware(String var1, String var2, Continuation var3);

   Object updateHeatAutoTmp(String var1, double var2, Continuation var4);

   Object updateHeatEcoTmp(String var1, double var2, Continuation var4);

   Object updateHeatFanSpeed(String var1, int var2, Continuation var3);

   Object updateHeatSubMode(String var1, int var2, Continuation var3);

   Object updateHinsMode(String var1, boolean var2, Continuation var3);

   Object updateHinsNightMode(String var1, boolean var2, Continuation var3);

   Object updateHoverEnabled(String var1, boolean var2, Continuation var3);

   Object updateHumMode(String var1, boolean var2, Continuation var3);

   Object updateHumSubMode(String var1, int var2, Continuation var3);

   Object updateLastSelectedSensorType(String var1, Integer var2, Continuation var3);

   Object updateLatestSensorDataPoint(String var1, long var2, Float var4, Float var5, Float var6, Float var7, Float var8, Float var9, Float var10, Float var11, Continuation var12);

   Object updateLinkedDeviceUid(String var1, String var2, Continuation var3);

   Object updateLocationId(String var1, String var2, Continuation var3);

   Object updateMacAddress(String var1, String var2, Continuation var3);

   Object updateMainMode(String var1, int var2, Continuation var3);

   Object updateMcuFirmware(String var1, String var2, Continuation var3);

   Object updateMode(String var1, int var2, Continuation var3);

   Object updateModelName(String var1, String var2, Continuation var3);

   Object updateName(String var1, String var2, Continuation var3);

   Object updateNightLampBrightness(String var1, int var2, Continuation var3);

   Object updateNightLampSteplessBrightness(String var1, int var2, Continuation var3);

   Object updateNightModeStartTime(String var1, long var2, Continuation var4);

   Object updateNightPeriods(String var1, String var2, Continuation var3);

   Object updateOscillationAngle(String var1, int var2, Continuation var3);

   Object updateOscillationDirection(String var1, int var2, Continuation var3);

   Object updateOscillationFanSpeed(String var1, int var2, Continuation var3);

   Object updateOscillationState(String var1, int var2, Continuation var3);

   Object updatePanelDisplayMode(String var1, int var2, Continuation var3);

   Object updateProgress(String var1, int var2, Continuation var3);

   Object updateRoomType(String var1, int var2, Continuation var3);

   Object updateRpm(String var1, int var2, Continuation var3);

   Object updateSafetySwitch(String var1, boolean var2, Continuation var3);

   Object updateSensorMode(String var1, int var2, Continuation var3);

   Object updateSensorRange(String var1, String var2, String var3, String var4, String var5, String var6, Continuation var7);

   Object updateSerialNumber(String var1, String var2, Continuation var3);

   Object updateSku(String var1, String var2, Continuation var3);

   Object updateSmartSubMode(String var1, int var2, Continuation var3);

   Object updateStandByMode(String var1, boolean var2, Continuation var3);

   Object updateTemperatureUnit(String var1, int var2, Continuation var3);

   Object updateTimerDuration(String var1, int var2, Continuation var3);

   Object updateTimerLeftTime(String var1, int var2, long var3, Continuation var5);

   Object updateTimerStatus(String var1, int var2, Continuation var3);

   Object updateTimezone(String var1, String var2, Continuation var3);

   Object updateUse24Hour(String var1, boolean var2, Continuation var3);

   Object updateWaterLevel(String var1, int var2, Continuation var3);

   Object updateWaterShortage(String var1, boolean var2, Continuation var3);

   Object updateWaterTankFailure(String var1, boolean var2, Continuation var3);

   Object updateWelcomeHome(String var1, Double var2, Double var3, Integer var4, String var5, Boolean var6, Continuation var7);

   Object updateWickUsage(String var1, int var2, Continuation var3);

   Object updateWickdryDone(String var1, boolean var2, Continuation var3);

   Object updateWickdryDuration(String var1, int var2, Continuation var3);

   Object updateWickdryEnabled(String var1, boolean var2, Continuation var3);

   Object updateWickdryLeftTime(String var1, int var2, long var3, Continuation var5);

   Object updateWickdryOn(String var1, boolean var2, Continuation var3);

   Object updateWifiFirmware(String var1, String var2, Continuation var3);

   Object updateYwrmEnabled(String var1, Boolean var2, Continuation var3);

   Object updateYwrmUsage(String var1, int var2, Continuation var3);
}
