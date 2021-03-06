package org.enodeframework.rocketmq.message;

import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.enodeframework.common.utilities.BitConverter;
import org.enodeframework.queue.QueueMessage;

import java.util.List;

/**
 * @author anruence@gmail.com
 */
public class RocketMQTool {
    public static QueueMessage covertToQueueMessage(List<MessageExt> msg) {
        MessageExt messageExt = msg.get(0);
        QueueMessage queueMessage = new QueueMessage();
        queueMessage.setBody(BitConverter.toString(messageExt.getBody()));
        queueMessage.setTopic(messageExt.getTopic());
        queueMessage.setKey(messageExt.getKeys());
        queueMessage.setTags(messageExt.getTags());
        queueMessage.setCode(messageExt.getFlag());
        return queueMessage;
    }

    public static Message covertToProducerRecord(QueueMessage queueMessage) {
        return new Message(queueMessage.getTopic(), queueMessage.getTags(), queueMessage.getKey(), queueMessage.getCode(), BitConverter.getBytes(queueMessage.getBody()), true);
    }
}
