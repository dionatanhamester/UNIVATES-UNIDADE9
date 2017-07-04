/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Dionatan
 */
import java.io.BufferedReader;  
    import java.io.IOException;  
    import java.io.InputStreamReader;  
    import java.util.ArrayList;  
    import java.util.List;  
import javax.swing.JOptionPane;
    public class PostgresBackup {
        
        /**
         * Realiza o backup dos dados do sistema ( Backup realizado no diretório do sistema )
         * @throws IOException Exception
         * @throws InterruptedException Exceptio
         */
        public static void realizaBackup() throws IOException, InterruptedException{      
           final List<String> comandos = new ArrayList<String>();      
           comandos.add("C:\\Arquivos de programas\\PostgreSQL\\9.5\\bin\\pg_dump.exe");  
           //comandos.add("-i");      
           comandos.add("-h");      
           comandos.add("localhost");   
           comandos.add("-p");      
           comandos.add("5432");      
           comandos.add("-U");      
           comandos.add("postgres");      
           comandos.add("-F");      
           comandos.add("c");      
           comandos.add("-b");      
           comandos.add("-v");      
           comandos.add("-f");      
           comandos.add(System.getProperty("user.dir")+ "\\" + Convert.getCurrentDateTime()+"_bkp.backup");                   
           comandos.add("db_vendas");      
           ProcessBuilder pb = new ProcessBuilder(comandos);      
           pb.environment().put("PGPASSWORD", "postgres");      //Somente coloque sua senha         
           try {      
               final Process process = pb.start();      
               final BufferedReader r = new BufferedReader(      
                   new InputStreamReader(process.getErrorStream()));      
               String line = r.readLine();      
               while (line != null) {      
               System.err.println(line);      
               line = r.readLine();      
               }      
               r.close();      
               process.waitFor();    
               process.destroy(); 
               JOptionPane.showMessageDialog(null,"backup realizado com sucesso.");  
           } catch (IOException e) {      
               e.printStackTrace();      
           } catch (InterruptedException ie) {      
               ie.printStackTrace();      
           }         
       }      
        
        public static void main(String[] args) {  
            try {  
                PostgresBackup.realizaBackup();           
            } catch (IOException e) {  
                e.printStackTrace();  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
    }