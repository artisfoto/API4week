package programa;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
 
import javax.swing.JOptionPane;
 
public class Conexion {
  
 //Creamos un m�todo que recibe 2 parametros, el nombre de usuario y la contrase�a
 public void Login(String usr, String cont){
  
 try{
 //Obtenemos una referencia al driver de MySQL que nos permitir� realizar la conexi�n
 DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
  
 /*Creamos la conexi�n donde lo unico que se tiene que cambiar es el NOMBRE DE USUARIO Y LA CONTRASE�A
 del servidor, en este caso localhost para poder realizar las pruebas desde nuestra computadora, tambi�n se debe colocar el nombre de la base de datos, es este caso registros*/
 Connection conexion = DriverManager.getConnection (&quot;jdbc:mysql://localhost/registros&quot;,&quot;NOMBREDEUSUARIO&quot;, &quot;CONTRASE�A&quot;);
  
 Statement s = conexion.createStatement();
  
 //Aqu� es donde realizamos una consulta para poder comparar los resultados de los parametros y la base de datos
 ResultSet rs = s.executeQuery (&quot;select * from usuarios&quot;);
  
 while(rs.next()){
 int valor = rs.getRow();
 //Se el valor de usuario coincide con alguno de los usuarios registrados
 if(rs.getString(valor).equals(usr)){
 valor++;
 //Si el valor de la contrase�a conincide con la del usuario
 if(rs.getString(valor).equals(cont)){
 //Si todo es correcto, este mensaje aparecer� si se trata de un usuario registrado
 JOptionPane.showMessageDialog(null, &quot;Eres un usuario registrado&quot;);
 }
 else{
 JOptionPane.showMessageDialog(null, &quot;Contrase�a incorrecta&quot;);
 }
 break;
 }
 else{
 JOptionPane.showMessageDialog(null, &quot;No eres un usuario registrado&quot;);
 }
 break;
 }
  
 /*Cerramos la conexi�n que abrimos con la base de datos, es muy importante 
 para no consumir recursos al terminar la conexi�n */
 conexion.close();
  
 }
 catch(Exception e){
 e.printStackTrace();
 }
 }

public void Login(String usuario, char[] contra) {
	// TODO Auto-generated method stub
	
}
 
}