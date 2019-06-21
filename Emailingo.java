package EmailSender;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Emailingo extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2557947065985298520L;

	JButton b_attach, b_send;
	JLabel l_to, l_cc, l_bcc, l_sub, l_msg;
	JTextArea a_to, a_cc, a_bcc, a_msg;
	JTextField tf_path, tf_sub, tf_status;
	JScrollPane p_to, p_cc, p_bcc, p_sub, p_msg;
	static String filepath;

	private void prepare() {
		super.setBounds(100, 100, 600, 600);
		super.setTitle("Email");
		super.setResizable(false);
		// ---------------------------------

		l_to = new JLabel("TO :");
		l_to.setBounds(30, 30, 100, 35);
		super.add(l_to);

		l_cc = new JLabel("CC :");
		l_cc.setBounds(30, 60, 100, 35);
		super.add(l_cc);

		l_bcc = new JLabel("BCC :");
		l_bcc.setBounds(30, 90, 100, 35);
		super.add(l_bcc);

		l_sub = new JLabel("Subject :");
		l_sub.setBounds(30, 140, 100, 35);
		super.add(l_sub);

		l_msg = new JLabel("Message :");
		l_msg.setBounds(30, 170, 100, 35);
		super.add(l_msg);

		a_to = new JTextArea();
		p_to = new JScrollPane(a_to);
		p_to.setBounds(160, 30, 280, 25);
		super.add(p_to);

		a_cc = new JTextArea();
		p_cc = new JScrollPane(a_cc);
		p_cc.setBounds(160, 60, 280, 25);
		super.add(p_cc);

		a_bcc = new JTextArea();
		p_bcc = new JScrollPane(a_bcc);
		p_bcc.setBounds(160, 90, 280, 25);
		super.add(p_bcc);

		tf_sub = new JTextField();
		p_sub = new JScrollPane(tf_sub);
		p_sub.setBounds(160, 140, 280, 25);
		super.add(p_sub);

		a_msg = new JTextArea();
		p_msg = new JScrollPane(a_msg);
		p_msg.setBounds(160, 170, 280, 150);
		super.add(p_msg);

		tf_path = new JTextField();
		tf_path.setBounds(160, 380, 280, 25);
		tf_path.setEditable(false);
		super.add(tf_path);

		b_attach = new JButton("Attach");
		b_attach.setBounds(30, 380, 100, 30);
		super.add(b_attach);
		b_attach.addActionListener(this);

		b_send = new JButton("SEND");
		b_send.setBounds(160, 430, 100, 30);
		super.add(b_send);
		b_send.addActionListener(this);

		tf_status = new JTextField("Status....");
		tf_status.setBounds(280, 430, 280, 30);
		tf_status.setEditable(false);
		super.add(tf_status);

		// ---------------------------------
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	class JrAuth extends Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			System.out.println("Login to your Gmail ID");
			String usr_username = "gmail_username_here";
			String usr_password = "gmail_password_here";
			PasswordAuthentication pa = new PasswordAuthentication(usr_username, usr_password);
			return pa;
		}
	}

	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == b_attach) {
				FileDialog fd = new FileDialog(this, "open your file", FileDialog.LOAD);
				fd.setVisible(true);
				String location = fd.getDirectory();
				String filename = fd.getFile();
				filepath = location.concat(filename);
				tf_path.setText(filepath); // passing the location to the text field
				tf_status.setText("File Attached !");
			} else if (e.getSource() == b_send) {
				File file = new File(filepath);
				Properties p = new Properties();
				p.put("mail.smtp.host", "smtp.gmail.com"); // assign host
				p.put("mail.smtp.port", "587"); // assign host's working port
				p.put("mail.smtp.starttls.enable", "true"); // start transport layer security = active
				p.put("mail.smtp.auth", "true"); // set authentication type
				p.put("mail.smtp.ssl.trust", "smtp.gmail.com"); // set trusted host to secure socket layer
				
				JrAuth ja = new JrAuth();
				Session ses = Session.getInstance(p, ja);
				MimeMessage message = new MimeMessage(ses);
				String mailReceiverTo = a_to.getText();
				String mailReceiverCC = a_cc.getText();
				String mailReceiverBCC = a_bcc.getText();

				if ((!(mailReceiverTo.isEmpty())) && (!(mailReceiverCC.isEmpty())) && (!(mailReceiverBCC.isEmpty()))) {

					// conver to internet address
					InternetAddress addressTo = new InternetAddress(mailReceiverTo);
					InternetAddress addressCC = new InternetAddress(mailReceiverCC);
					InternetAddress addressBCC = new InternetAddress(mailReceiverBCC);

					// assign all internet address as RecipientType
					message.setRecipient(Message.RecipientType.TO, addressTo);
					message.setRecipient(Message.RecipientType.CC, addressCC);
					message.setRecipient(Message.RecipientType.BCC, addressBCC);
					
					tf_status.setText("Receiver TO, CC, BCC");

				} else if ((!(mailReceiverTo.isEmpty())) && ((mailReceiverCC.isEmpty()))
						&& ((mailReceiverBCC.isEmpty()))) {
					// conver to internet address
					InternetAddress addressTo = new InternetAddress(mailReceiverTo);

					// assign all internet address as RecipientType
					message.setRecipient(Message.RecipientType.TO, addressTo);
					tf_status.setText("Receiver TO");
					
				} else if (((mailReceiverTo.isEmpty())) && (!(mailReceiverCC.isEmpty()))
						&& ((mailReceiverBCC.isEmpty()))) {
					// conver to internet address
					InternetAddress addressCC = new InternetAddress(mailReceiverCC);

					// assign all internet address as RecipientType
					message.setRecipient(Message.RecipientType.CC, addressCC);
					tf_status.setText("Receiver CC");
					
				} else if (((mailReceiverTo.isEmpty())) && ((mailReceiverCC.isEmpty()))
						&& (!(mailReceiverBCC.isEmpty()))) {

					// conver to internet address
					InternetAddress addressBCC = new InternetAddress(mailReceiverBCC);

					// assign all internet address as RecipientType
					message.setRecipient(Message.RecipientType.BCC, addressBCC);
					tf_status.setText("Receiver BCC");
				}

				// assign Mail subject
				String mailSubject = tf_sub.getText();
				message.setSubject(mailSubject);

				// creating MimeBodyPart parts
				MimeBodyPart body1 = new MimeBodyPart();
				MimeBodyPart body2 = new MimeBodyPart();

				body1.setContent(a_msg.getText(), "text/html"); // first attachment in email
				body2.attachFile(file); // second attachment in email as file(object)

				MimeMultipart parts = new MimeMultipart();
				parts.addBodyPart(body1); // attach bodypart1 to multipart
				parts.addBodyPart(body2); // attach bodypart2 to multipart
				message.setContent(parts);
				Transport.send(message);

				JOptionPane.showMessageDialog(null, "Sent !!");
				System.exit(0);
			}
		} catch (Exception ex) {
			System.out.println("Error: " + ex);
			tf_status.setText("Error Occured !!");
		}
	}

	public static void main(String[] args) {
		Emailingo em = new Emailingo();
		em.prepare();
	}
}

//in order to run this code please attach    ####java_mail_api.jar###
