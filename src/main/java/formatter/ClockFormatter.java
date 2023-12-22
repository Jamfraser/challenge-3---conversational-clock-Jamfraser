package formatter;

import com.time.ConversationTime;

// interface for DefaultClockFormatter to extend
public interface ClockFormatter {
    String format(ConversationTime conversationTime);
}
