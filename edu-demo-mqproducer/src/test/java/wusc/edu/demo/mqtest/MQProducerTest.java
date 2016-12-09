/** 基于Dubbo的分布式系统架构视频教程，吴水成，wu-sc@foxmail.com，学习交流QQ群：367211134 **/
package wusc.edu.demo.mqtest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import wusc.edu.demo.mqtest.params.MailParam;

/**
 * 
 * @描述: ActiveMQ测试启动类 .
 * @作者: WuShuicheng .
 * @创建时间: 2015-3-17,上午2:25:20 .
 * @版本号: V1.0 .
 */
public class MQProducerTest {
	private static final Log log = LogFactory.getLog(MQProducerTest.class);

	public static void main(String[] args) {
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");
			context.start();

			MQProducer mqProducer = (MQProducer) context.getBean("mqProducer");
			// 邮件发送
			MailParam mail = new MailParam();
			mail.setTo("liuyucang236@163.com");
			mail.setSubject("我的消息队列德莫");
			mail.setContent("通过我的消息队列demo-发送信息！");

			mqProducer.sendMessage(mail);

			context.stop();
		} catch (Exception e) {
			log.error("==>MQ context start error:", e);
			System.exit(0);
		} finally {
			log.info("===>System.exit");
			System.exit(0);
		}
	}
}
