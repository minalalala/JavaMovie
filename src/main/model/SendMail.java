package main.model;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail implements Serializable{
	private static final long serialVersionUID = 1L;
	private int port;
    private String username;
    private String password;
    private Properties props;
    private String from;
    private String to;
    private String subject;
    private String content;
    private String msg;
    
	public void setTo(String to) {this.to = to;}
	public String getTo() {return to;}
	
	public void setSubject(String subject) {this.subject = subject;}
	public String getSubject() {return subject;}
	
	public void setContent(String content) {this.content = content;}
    public String getContent() {return content;}
    
	public String getMsg() {return msg;}
	
	public SendMail() {
		port=587;//25 ��SMTP 465 ��Ӫ��[�K��SMTP 587�̷s���w���� Outlook�BApple Mail���Υ�
		username="javafreemovie@gmail.com";
		password="java0609";
		from=username;
		
		props = new Properties();//�إ���-�ȹ�� �M���ѼƳ]�n
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.auth", "true");//�ϥ�SMTP��w��AUTH�X�R �w���ʥ��n �e�H�e�����ұK�X
	    props.put("mail.smtp.starttls.enable", "true");//�ϥ�SMTP ��STARTTLS�X�R �����e�[�K
	    props.put("mail.smtp.port", port);
	    props.put("mail.smtp.ssl.trust", "smtp.gmail.com");//�H����host�A�S�]�w���ܫH���P�_�|�Ѧ��A�����]�w�M�w
	}
	
	//�H�X
    public void execute() throws UnsupportedEncodingException {
    	try {
    		//�Φۭq��k�إ߭n�ǰe��Message
            Message message = createMessage(from, to, subject, content);//�U��ۭq����k �DMessageFactory.createMessage(MimeHeaders, java.io.InputStream) 
            Transport.send(message); //�ǰe
            
            System.out.println("�l��ǰe���\");
            msg="3";
        } catch (MessagingException e) {
        	msg="2";
            throw new RuntimeException(e);
        }
    }
    
    private Message createMessage(
            String from, String to, String subject, String content)
                              throws MessagingException, UnsupportedEncodingException {
    	//Field
    	//Seesion �̭��]�t�F...
    	//�ѼƳ]�w�s(props)�B�H�Τ@�ӻ{�Ҫ���(Authenticator)...
    	//�䦳�Ӥ�k��get�a���b�K����������(PasswordAuthentication)
        Session session = Session.getInstance(props, new Authenticator() {  
            protected PasswordAuthentication getPasswordAuthentication() {  
                return new PasswordAuthentication(username, password);  
            }}
        );
        
        Multipart multiPart = multiPart(content);//�ۭq����k�@�Ы�Multipart��Ҥ��e�O�ۭq��content ���I��JMessage��Content��
        Message message = new MimeMessage(session);//�ЭӰ򥻤W�Ū�Message �̭���session�]�t�b�K�{�ҦӤw
/*from*/message.setFrom(new InternetAddress(from));
/*to*/  message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
/*subj*/message.setSubject(subject);
/*date*/message.setSentDate(new Date());
/*cotn*/message.setContent(multiPart);
        
        return message;
    }
    //�ۭq����k
    //�гy�@��Multipart ���OMime����Multipart �B�̭��]�t�F�@�� MimeBodyPart�Hhtml�榡�]�t�F���econtent
    private Multipart multiPart(String content)
            throws MessagingException, UnsupportedEncodingException {
        Multipart multiPart = new MimeMultipart();//�Ф@��Mime����Mutipart
        
        MimeBodyPart htmlPart = new MimeBodyPart();//�Э�MimeBodyPart���I��iMutipart
        htmlPart.setContent(content, "text/html;charset=UTF-8");//BodyPart�Ohtml�榡�A���e��content
        multiPart.addBodyPart(htmlPart);//�NMutiBodyPart��i�D��Mutipart
        
        return multiPart;
    }
    //^^^ method
}
