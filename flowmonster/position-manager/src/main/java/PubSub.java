import javax.jms.JMSException;

/**
 * Created by chineduokafor on 11/12/2015.
 */
public interface PubSub {

    public void publish(byte[] bytes) throws JMSException;

    public byte[] receive() throws JMSException;

    public void close();
}
