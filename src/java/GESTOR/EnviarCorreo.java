/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GESTOR;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class EnviarCorreo {
    public static String generarContrasena(String correro,String Asunto,String mensajee) {
        Properties propiedad = new Properties();
        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.setProperty("mail.smtp.port", "587");
        propiedad.setProperty("mail.smtp.auth", "true");
        Session sesion = Session.getDefaultInstance(propiedad);
        String correoEnvia = "cuentaempresarial526@gmail.com";
        String contrasena = "drcsfkzfhgjxwtjm";
        String destinatario = correro;
        String asunto = Asunto;
        String mensaje = mensajee;
        MimeMessage mail = new MimeMessage(sesion);
        try {
            mail.setFrom(new InternetAddress (correoEnvia));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            mail.setSubject(asunto);
            mail.setText(mensaje);
            MimeMultipart mp = new MimeMultipart();
            BodyPart html = new MimeBodyPart();
            html.setContent(""
                    + "<h1>Se le a proporcionado una nueva contraseña!</h1><br>"
                    + "<h2>Se le ha asignado una contraseña: "+mensaje+"</h2><br>"
                    + "<a href='http://localhost:8080/PVENTA/_MenuPrincipal.jsp'>Ingresar al sistema</a><br>"
                    , "text/html");
            mp.addBodyPart(html);
            mail.setContent(mp);
            Transport transporte = sesion.getTransport("smtp");
            transporte.connect(correoEnvia,contrasena);
            transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            transporte.close();
            return "Correo enviado";
        } catch (Exception ex) {}
        return null;
    }
    public static String reestablecerContrasena(String correro,String Asunto,String mensajee){
        Properties propiedad = new Properties();
        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.setProperty("mail.smtp.port", "587");
        propiedad.setProperty("mail.smtp.auth", "true");
        Session sesion = Session.getDefaultInstance(propiedad);
        String correoEnvia = "cuentaempresarial526@gmail.com";
        String contrasena = "drcsfkzfhgjxwtjm";
        String destinatario = correro;
        String asunto = Asunto;
        String mensaje = mensajee;
        MimeMessage mail = new MimeMessage(sesion);
        try {
            mail.setFrom(new InternetAddress (correoEnvia));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            mail.setSubject(asunto);
            mail.setText(mensaje);
            MimeMultipart mp = new MimeMultipart();
            BodyPart html = new MimeBodyPart();
            html.setContent(""
                    + "<h1>Se ha reestablecido su contraseña!</h1><br>"
                    + "<h2>Nueva contraseña: "+mensaje+"</h2><br>"
                    + "<a href='http://localhost:8080/PVENTA/_MenuPrincipal.jsp'>Ingresar al sistema</a><br>"
                    , "text/html");
            mp.addBodyPart(html);
            mail.setContent(mp);
            Transport transporte = sesion.getTransport("smtp");
            transporte.connect(correoEnvia,contrasena);
            transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            transporte.close();
            return "Correo enviado";
        } catch (Exception ex) {}
        return null;
    }
}
