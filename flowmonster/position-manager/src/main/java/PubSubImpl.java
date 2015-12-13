import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by chineduokafor on 11/12/2015.
 */
public class PubSubImpl implements PubSub {

    private static Connection connection;
    private static Session session;
    private static Context context;
    private static Topic priceTopic;
    private static MessageConsumer consumer;
    private static MessageProducer producer;

    public PubSubImpl(String topic){
        try {
            Properties properties = new Properties();
            properties.load(this.getClass().getResourceAsStream("stocks.properties"));
            context = new InitialContext(properties);

            ConnectionFactory connectionFactory
                    = (ConnectionFactory) context.lookup("qpidConnectionFactory");
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(true, Session.SESSION_TRANSACTED);
            priceTopic = (Topic) context.lookup(topic);
            producer = session.createProducer(priceTopic);
            consumer  = session.createDurableSubscriber(priceTopic, "sub");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void publish(byte[] bytes) throws JMSException {
        BytesMessage message = session.createBytesMessage();
        message.writeBytes(bytes);
        producer.send(message);
        session.commit();
    }

    public byte[] receive() throws JMSException {
        BytesMessage message = (BytesMessage) consumer.receive(1000);
        byte[] serialisedMessage = new byte[(int) message.getBodyLength()];
        message.readBytes(serialisedMessage);
        System.out.println("Subscriber received : " + new String(serialisedMessage));
        session.commit();
        return  serialisedMessage;
    }

    public void close() {

    }

}
