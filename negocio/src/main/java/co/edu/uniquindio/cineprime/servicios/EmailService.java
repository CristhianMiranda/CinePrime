package co.edu.uniquindio.cineprime.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender sender;

    public boolean enviarEmail(String asunto, String contenido,String destinatario,String datos,int descuento)
    {
        MimeMessage mensaje = sender.createMimeMessage();
        /**
         * <div class="">
         *     <div class="aHl"></div>
             *     <div id=":nr" tabindex="-1"></div>
                 *     <div id=":ng" class="ii gt" jslog="20277; u014N:xr6bB; 4:W251bGwsbnVsbCxbXV0.">
                 *         <div id=":nf" class="a3s aiL ">
         *             <div>
         *                 <div class="adM"></div>
                     *     <div id="m_3740794436015188546:1a0" class="adM"></div>
                     *     <div id="m_3740794436015188546:18t">
                     *         <div id="m_3740794436015188546:18u"><u></u>
                 *                  <div style="margin:0;padding:0" dir="ltr" bgcolor="#ffffff">
         *                              <table border="0" cellspacing="0" cellpadding="0" align="center" id="m_3740794436015188546m_2882604173997724892email_table" style="border-collapse:collapse">
         *                                  <tbody>
         *                                      <tr>
         *                                          <td id="m_3740794436015188546m_2882604173997724892email_content" style="font-family:Helvetica Neue,Helvetica,Lucida Grande,tahoma,verdana,arial,sans-serif;background:#ffffff">
         *                                              <table border="0" width="100%" cellspacing="0" cellpadding="0" style="border-collapse:collapse">
         *                                                  <tbody>
         *                                                      <tr>
         *                                                          <td height="20" style="line-height:20px" colspan="3">&nbsp;</td>
         *                                                      </tr>
         *
                         *                                      <tr>
                         *                                          <td height="1" colspan="3" style="line-height:1px">
         *                                                              <span style="color:#ffffff;font-size:1px">&nbsp; Hola,
             *                                                              <a href="mailto:cristhianmirandapro@gmail.com" target="_blank">cristhianmirandapro@
             *                                                                  <wbr>gmail.com
             *                                                              </a>
         *                                                                  : Recibimos una solicitud para recuperar tu contraseña de unitravel. Tu contraseña es: También puedes cambiar la contraseña directamente. &nbsp; Cambiar&nbsp;contraseña &nbsp; ¿No solicitaste este cambio? Si no solicitaste una nueva contraseña, avísanos . &nbsp;
             *                                                              </span>
         *                                                           </td>
                         *                                      </tr>
         *
         *                                                      <tr>
                 *                                                          <td width="15" style="display:block;width:15px">&nbsp;&nbsp;&nbsp;</td>
                 *                                                              <td>
                 *                                                                  <table border="0" width="100%" cellspacing="0" cellpadding="0" style="border-collapse:collapse">
                 *                                                                      <tbody>
                 *                                                                          <tr>
                 *                                                                              <td height="15" style="line-height:15px" colspan="3">&nbsp;</td>
                 *                                                                          </tr>
                 *
                 *                                                      <tr>
                 *                                                          <td width="32" align="left" valign="middle" style="height:32;line-height:0px">
                 *                                                              <img src="https://ci3.googleusercontent.com/proxy/ciaTEUfTNTE6mEKE9mLwuFDlgqapaVdKPPCn6eqI45Ysol2fbPuTbcTAElRu-zFJ9o4RLbEM3C53SBzpJl8Fols-OQ=s0-d-e1-ft#https://i.postimg.cc/m2rRHS35/logo-Unitravel.png" width="32" height="32" style="border:0" class="CToWUd">
                 *                                                          </td>
                 *
                 *
                     *                                                      <td width="15" style="display:block;width:15px">&nbsp;&nbsp;&nbsp;</td>
                     *
                         *                                                      <td width="100%">
                         *                                                          <span style="font-family:Helvetica Neue,Helvetica,Lucida Grande,tahoma,verdana,arial,sans-serif;font-size:19px;line-height:32px;color:#000000">Unitravel</span>
                         *                                                      </td>
                     *
                 *                                                      </tr>
                 *
                 *                                                      <tr style="border-bottom:solid 1px #e5e5e5"><td height="15" style="line-height:15px" colspan="3">&nbsp;</td></tr>
                                 *                                                      </tbody>
                 *                                                                   </table>
                 *                                                               </td>
                 *
                 *                                                      <td width="15" style="display:block;width:15px">&nbsp;&nbsp;&nbsp;</td>
         *
         *                                                      </tr>
         *
         *                                                      <tr>
         *                                                          <td width="15" style="display:block;width:15px">&nbsp;&nbsp;&nbsp;
         *                                                          </td>
         *
         *                                                          <td>
         *                                                              <table border="0" width="100%" cellspacing="0" cellpadding="0" style="border-collapse:collapse">
         *                                                                  <tbody>
         *                                                                      <tr>
         *                                                                          <td height="28" style="line-height:28px">&nbsp;</td>
         *                                                                      </tr>
         *
         *                                                                      <tr>
         *                                                                          <td>
         *                                                                              <span style="font-family:Helvetica Neue,Helvetica,Lucida Grande,tahoma,verdana,arial,sans-serif;font-size:16px;line-height:21px;color:#141823">
         *                                                                                  <p>Hola,
         *                                                                                      <a href="mailto:cristhianmirandapro@gmail.com" target="_blank">cristhianmirandapro@
         *                                                                                          <wbr>gmail.com
         *                                                                                      </a>
         *                                                                                 :</p>
         *
         *                                                                                 <p></p>
                                 *                  <div>Recibimos una solicitud para recuperar tu contraseña de unitravel.</div>
         *          Tu contraseña es:<table border="0" cellspacing="0" cellpadding="0" style="border-collapse:collapse;margin-top:9px;margin-bottom:15px">
         *                              <tbody>
         *                                  <tr>
         *                                      <td style="font-size:11px;font-family:LucidaGrande,tahoma,verdana,arial,sans-serif;padding:10px;background-color:#f2f2f2;border-left:1px solid #ccc;border-right:1px solid #ccc;border-top:1px solid #ccc;border-bottom:1px solid #ccc">
         *                                          <span style="font-family:Helvetica Neue,Helvetica,Lucida Grande,tahoma,verdana,arial,sans-serif;font-size:16px;line-height:21px;color:#141823"></span>
         *                                      </td>
         *                                  </tr>
         *                              </tbody>
         *
         *                              </table>
         *                              <p></p>También puedes cambiar la contraseña directamente.
         *                              <table border="0" width="100%" cellspacing="0" cellpadding="0" style="border-collapse:collapse">
         *                                  <tbody>
         *                                      <tr>
         *                                          <td height="9" style="line-height:9px" colspan="3">&nbsp;</td>
         *                                      </tr>
         *
         *                                      <tr>
         *                                          <td>
         *                                              <a style="color:#3b5998;text-decoration:none">
         *                                                  <table border="0" width="100%" cellspacing="0" cellpadding="0" style="border-collapse:collapse">
         *                                                  <tbody>
         *                                                      <tr>
         *                                                          <td style="border-collapse:collapse;border-radius:2px;text-align:center;display:block;border:solid 1px #344c80;background:#4c649b;padding:7px 16px 11px 16px"><a style="color:#3b5998;text-decoration:none;display:block"><center><font size="3"><span style="font-family:Helvetica Neue,Helvetica,Lucida Grande,tahoma,verdana,arial,sans-serif;white-space:nowrap;font-weight:bold;vertical-align:middle;color:#ffffff;font-size:14px;line-height:14px">Cambiar&nbsp;contraseña</span></font></center></a>
         *                                                          </td>
         *                                                      </tr>
         *                                                  </tbody>
         *                                                  </table>
         *                                              </a>
         *                                           </td>
         *
         *                                                  <td width="100%"></td>
         *                                      </tr>
         *
         *                                      <tr><td height="32" style="line-height:32px" colspan="3">&nbsp;</td></tr>
         *                                      </tbody></table>
         *                                      <br><div><span style="color:#333333;font-weight:bold">¿No solicitaste este cambio?</span></div>
                                         *          Si no solicitaste una nueva contraseña, <a>avísanos</a>.</span></td></tr><tr><td height="28" style="line-height:28px">&nbsp;</td></tr></tbody></table></td><td width="15" style="display:block;width:15px">&nbsp;&nbsp;&nbsp;</td></tr><tr><td width="15" style="display:block;width:15px">&nbsp;&nbsp;&nbsp;</td><td><table border="0" width="100%" cellspacing="0" cellpadding="0" align="left" style="border-collapse:collapse"><tbody><tr style="border-top:solid 1px #e5e5e5"><td height="19" style="line-height:19px">&nbsp;</td></tr><tr><td style="font-family:Helvetica Neue,Helvetica,Lucida Grande,tahoma,verdana,arial,sans-serif;font-size:11px;color:#aaaaaa;line-height:16px">Se envió este mensaje a <a href="mailto:cristhianmirandapro@gmail.com" style="color:#3b5998;text-decoration:none" target="_blank">cristhianmirandapro@gmail.com</a> por pedido tuyo.<br>Unitravel, Inc., Attention: Community Support, 1 Unitravel Oficina, La tebaida, CP 633020</td></tr></tbody></table></td><td width="15" style="display:block;width:15px">&nbsp;&nbsp;&nbsp;</td></tr><tr><td height="20" style="line-height:20px" colspan="3">&nbsp;</td></tr></tbody></table><span><img src="https://ci3.googleusercontent.com/proxy/ciaTEUfTNTE6mEKE9mLwuFDlgqapaVdKPPCn6eqI45Ysol2fbPuTbcTAElRu-zFJ9o4RLbEM3C53SBzpJl8Fols-OQ=s0-d-e1-ft#https://i.postimg.cc/m2rRHS35/logo-Unitravel.png" style="border:0px;width:1px;height:1px;display:none!important" class="CToWUd"></span></td></tr></tbody></table></div><div class="yj6qo"></div><div class="adL"></div>
                                     *                      <div class="adL"></div>
                                 *              </div>
                                     *     </div>
                                     *
                                     *                       <div id="m_3740794436015188546:19w" style="display:none" class="adL">
                                     *                             <div id="m_3740794436015188546:19v"></div></div>
                         *                                          <div class="adL"></div>
                                     * </div>
                                     *                       <div class="adL"></div>
                                     *                       </div>
                                     * </div>
                                     *
                                     *  <div id=":nv" class="ii gt" style="display:none">
                                     *  <div id=":nw" class="a3s aiL "></div>
                                     *  </div>
                                     *
                                     *
                                     *                           <div class="hi"></div>
                                     *
                                     *
                         * </div>
                     */

        MimeMessageHelper helper = new MimeMessageHelper(mensaje);
        try{
            helper.setText("<html style=\"font-size: 16px;\" class=\"u-responsive-lg\"><head>\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "    <meta charset=\"utf-8\">\n" +
                    "    <meta name=\"keywords\" content=\"\">\n" +
                    "    <meta name=\"description\" content=\"\">\n" +
                    "    <meta name=\"page_type\" content=\"np-template-header-footer-from-plugin\">\n" +
                    "    <title>Page 11</title>\n" +
                    "    <link rel=\"stylesheet\" href=\"/nicepage.css?version=0d8a7851-49fd-4437-9f5f-9458695e8444\" media=\"screen\">\n" +
                    "    <script class=\"u-script\" type=\"text/javascript\" src=\"//capp.nicepage.com/assets/jquery-1.9.1.min.js\" defer=\"\"></script>\n" +
                    "    <script class=\"u-script\" type=\"text/javascript\" src=\"//capp.nicepage.com/6df64353a7e84682dc6d93feaf03bc1614b2c76e/nicepage.js\" defer=\"\"></script>\n" +
                    "    <meta name=\"generator\" content=\"Nicepage 4.6.9, nicepage.com\">\n" +
                    "    <link id=\"u-theme-google-font\" rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i\">\n" +
                    "    <style class=\"u-style\"> .u-section-2 {\n" +
                    "  background-image: none;\n" +
                    "}\n" +
                    ".u-section-2 .u-sheet-1 {\n" +
                    "  min-height: 756px;\n" +
                    "}\n" +
                    ".u-section-2 .u-image-1 {\n" +
                    "  width: 225px;\n" +
                    "  height: 225px;\n" +
                    "  margin: 60px auto 0;\n" +
                    "}\n" +
                    ".u-section-2 .u-text-1 {\n" +
                    "  font-weight: 700;\n" +
                    "  text-transform: uppercase;\n" +
                    "  letter-spacing: 4px;\n" +
                    "  width: 655px;\n" +
                    "  margin: 20px auto 0;\n" +
                    "}\n" +
                    ".u-section-2 .u-text-2 {\n" +
                    "  line-height: 2;\n" +
                    "  font-size: 1.25rem;\n" +
                    "  width: 655px;\n" +
                    "  font-weight: 300;\n" +
                    "  margin: 10px auto 0;\n" +
                    "}\n" +
                    ".u-section-2 .u-btn-1 {\n" +
                    "  background-image: none;\n" +
                    "  border-style: none;\n" +
                    "  font-weight: 700;\n" +
                    "  text-transform: uppercase;\n" +
                    "  letter-spacing: 4px;\n" +
                    "  margin: 60px auto;\n" +
                    "  padding: 16px 30px 17px;\n" +
                    "}\n" +
                    "@media (max-width: 767px) {\n" +
                    "  .u-section-2 .u-sheet-1 {\n" +
                    "    min-height: 796px;\n" +
                    "  }\n" +
                    "  .u-section-2 .u-text-1 {\n" +
                    "    width: 540px;\n" +
                    "  }\n" +
                    "  .u-section-2 .u-text-2 {\n" +
                    "    width: 540px;\n" +
                    "  }\n" +
                    "}\n" +
                    "@media (max-width: 575px) {\n" +
                    "  .u-section-2 .u-text-1 {\n" +
                    "    width: 340px;\n" +
                    "  }\n" +
                    "  .u-section-2 .u-text-2 {\n" +
                    "    width: 340px;\n" +
                    "  }\n" +
                    "}</style>\n" +
                    "    \n" +
                    "    <script type=\"application/ld+json\">{\n" +
                    "\t\t\"@context\": \"http://schema.org\",\n" +
                    "\t\t\"@type\": \"Organization\",\n" +
                    "\t\t\"name\": \"\",\n" +
                    "\t\t\"url\": \"https://website1590355.nicepage.io/Page-11.html\"\n" +
                    "}</script>\n" +
                    "    <meta name=\"theme-color\" content=\"#3767f6\">\n" +
                    "    <meta property=\"og:title\" content=\"Page 11\">\n" +
                    "    <meta property=\"og:type\" content=\"website\">\n" +
                    "    <link rel=\"canonical\" href=\"https://website1590355.nicepage.io/Page-11.html\">\n" +
                    "  \n" +
                    "</head>\n" +
                    "  <body class=\"u-body u-xl-mode\" align=\"center\">\n" +
                    "    \n" +
                    "    <section class=\"u-align-center u-clearfix u-grey-5 u-section-2\" id=\"carousel_b1e6\">\n" +
                    "      <div class=\"u-clearfix u-sheet u-sheet-1\">\n" +
                    "        <img src=\"https://i.postimg.cc/Wz0fsHtb/LOGOOO.png\" alt=\"\">\n" +
                    "        <h6 class=\"u-text u-text-1\"> BIENVENIDO A CINEPRIME</h6>\n" +
                    "        <p class=\"u-text u-text-2\">Hola "+datos+", Acabas de unirte al mejor servicio de cine de la región, Nos grata tenerte, Para demostrártelo queremos obsequiarte un cupon de descuento para tu próxima compra.</p> <p style=color:#9A1000; class=\"u-text u-text-2 \"><font size=5 face=nunito,Courier,arial>"+descuento+"% de descuento</font></p>" +"<p class=\"u-text u-text-2 \"><font size=3 face=nunito,Courier,arial>Tu codigo de bono es: "+contenido+"</font></p> "+
                    "        <a href=\"http://localhost:3000\"  class=\"u-active-none u-border-none u-border-palette-2-light-1 u-btn u-btn-rectangle u-button-style u-hover-none u-palette-2-base u-radius-0 u-btn-1\">Activa y Reclama</a>\n" +
                    "      </div>\n" +
                    "    </section>\n" +
                    "    \n" +
                    "    \n" +
                    "  \n" +
                    "<style>.u-disable-duration * {transition-duration: 0s !important;}</style></body></html>",true);
            helper.setTo(destinatario);
            helper.setSubject(asunto);

            sender.send(mensaje);


            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return false;

    }

}
