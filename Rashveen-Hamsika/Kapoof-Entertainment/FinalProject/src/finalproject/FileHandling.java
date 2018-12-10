
package finalproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FileHandling {
  private String type;  
  File file;

  public FileHandling() {
  }

  public FileHandling(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
  //function will return the showData based on month and year
  public ArrayList<String> getShowData(String month, String year) {
    String path = System.getProperty("user.dir") + "\\show.txt";
    FileReader fr;
    ArrayList<String> arrayList = new ArrayList<String>();
    String[] tmp1, tmp2;
    try {
      //create file reader for reading show.txt file  
      fr = new FileReader(path);
      BufferedReader br = new BufferedReader(fr);
      String  line;
      String mon,yr;
      //go through all the records of show.txt file
      while ((line =br.readLine())!= null) {
        tmp1=line.split(";");//split the semi-colon separated records
        tmp2=tmp1[2].split("-");//get the performance date
        mon=tmp2[0];//get month
        yr=tmp2[2];//get year 
        //check if the month and year matches the one user entered 
        if (mon.equals(month) && yr.equals(year)) {          
          //if the record is found, add it to show  
          arrayList.add(line);
        }                   
      }         
      br.close();
      fr.close();
      return arrayList;
              
    } catch (FileNotFoundException ex) {
        System.out.println("Add shows first");
        
      } catch (IOException ex) {
          System.out.println("Add shows first");
          
      }
    return arrayList;
  }
    
  //this function returns the client data from client.txt file corresponding to the email
  //this function is called from ShowReport to get client details corresponding to client
  public String getClientDataByEmail(String email) {
    String path = System.getProperty("user.dir") + "\\client.txt";
    String line="";
    FileReader fr;
    try {
      fr = new FileReader(path);
      BufferedReader br = new BufferedReader(fr);
      String[] tmp;
      while ((line =br.readLine())!= null) {
        tmp = line.split(";");
        //check if email is found
        if (tmp[7].equals(email)) {
          break;
        }                  
      }         
    br.close();
    fr.close();
    return line;             
    } catch (FileNotFoundException ex) {
        System.out.println("Add Client first");
        
      } 
      catch (IOException ex) {
        System.out.println("Add Client first");
        
      }
    return line;
  }
  
  //this function returns all the client information from client.txt. It is used to show client report
  public ArrayList<String> getClientData() {
    ArrayList<String> arrayList = new ArrayList<String>();
    String path = System.getProperty("user.dir") + "\\client.txt";
    FileReader fr;
    try {
      fr = new FileReader(path);
      BufferedReader br = new BufferedReader(fr);
      String line;
      //read the entire client.txt file
      while ((line =br.readLine())!= null) {
        //add client details in arrayList  
        arrayList.add(line);                   
      }         
      br.close();
      fr.close();
      //return the entire client details
      return arrayList;
               
    } catch (FileNotFoundException ex) {
        System.out.println("Add Client first");        
      } 
      catch (IOException ex) {
        System.out.println("Add Client first");
      }
    return arrayList;
  }
  
  //this function is used to update the record. str is the string to update and recordUpdate is the record to be updated
  public void updateRecord(String str, String recordUpdate) {
    String path;
    if (type.equalsIgnoreCase("Client"))
      path = System.getProperty("user.dir") + "\\client.txt";
    else
      path = System.getProperty("user.dir") + "\\show.txt";
       
    file = new File(path);
    FileReader fr;
    try {
      fr = new FileReader(path);
      BufferedReader br = new BufferedReader(fr);
      String line;
      String oldContent = "";
      String[] arr;
      String tmp;
      //read the entire file
      while ((line =br.readLine())!= null) {
        arr = line.split(";");
        if (type.equalsIgnoreCase("Client"))
          tmp = arr[7];
        else
          tmp = arr[10];// If it's show ID use arr[10]
        //if we find the record, then append the new one 
        if (tmp.equalsIgnoreCase(recordUpdate)) {
          oldContent = oldContent + str + System.lineSeparator();
        }
        //concatenating the original data
        else 
          oldContent = oldContent + line + System.lineSeparator();
      }
      //creating a file writer and writing it to a file
      FileWriter fw = new FileWriter(file);
      fw.write(oldContent);
      fw.close();
      br.close();
      fr.close();
               
    } 
    catch (FileNotFoundException ex) {
      System.out.println("Error in database. Please try again");
    } 
    catch (IOException ex) {
      System.out.println("Error in database. Please try again");
    }
  }
   
  public void deleteRecord (String str) {
    try {
      String inputFileName;
      String outputFileName;
      String showinFileName="";
      String showopFileName="";
       
      File showinputFileName = null;
      File showoutputFileName = null;
       
      //when deleting client, we need to delete corresponding shows as well
      if (type.equalsIgnoreCase("Client")) {
        inputFileName = System.getProperty("user.dir") + "\\client.txt";
        outputFileName = System.getProperty("user.dir") + "\\client1.txt";
        showinFileName = System.getProperty("user.dir") + "\\show.txt";
        showopFileName = System.getProperty("user.dir") + "\\show1.txt";
        showinputFileName = new File(showinFileName);
        showoutputFileName = new File(showopFileName);
      }
      else {
        inputFileName = System.getProperty("user.dir") + "\\show.txt";
        outputFileName = System.getProperty("user.dir") + "\\show1.txt";
      }
      File inputFile = new File(inputFileName);
      File outputFile = new File(outputFileName);
        
      try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile)))        
              {
        
        String line = null;
        String tmp;
        String[] arr;
        //read the file till the end
        while ((line = reader.readLine()) != null) {
          arr = line.split(";");
          if (type.equalsIgnoreCase("Client"))
            tmp = arr[7];
          else
            tmp = arr[10];
          //if the record is not the one to be deleted, write it to the temporary file. It can be client1 or show1.txt
          if (!tmp.equals(str)) {
            writer.write(line);
            writer.newLine();
          }
        }
        //if we are deleting client, we need to delete corresponding shows as well
        if (type.equalsIgnoreCase("Client")) {
         
          if(showinputFileName.exists()) {
            BufferedReader showReader = new BufferedReader(new FileReader(showinputFileName));  
            BufferedWriter ShowWriter = new BufferedWriter(new FileWriter(showoutputFileName));
            //go through the show file to delete shows corresponding to client  
            while ((line = showReader.readLine()) != null) {
              arr = line.split(";");
              tmp = arr[9];//fetch client email from show.txt
              //write all the records to the temporary show1.txt file where the email is not the same as that of client to be deleted
              if (!tmp.equals(str)) {
                ShowWriter.write(line);
                ShowWriter.newLine();
              }
            }
            showReader.close();
            ShowWriter.close();
          }    
        }
      }        
     
      //delete client.txt and rename client1.txt to client.txt
      if (inputFile.delete()) {
        // Rename the output file to the input file
        if (!outputFile.renameTo(inputFile)) {
          throw new IOException("Could not rename " + outputFileName + " to " + inputFileName);
        }
      }
      else {
        throw new IOException("Could not delete original input file " + inputFileName);
      }
    
      //delete show.txt and then rename show1.txt to show.txt
      if (type.equalsIgnoreCase("Client")) {
        if (showinputFileName.delete()) {
          // Rename the output file to the input file
          if (!showoutputFileName.renameTo(showinputFileName)) {
            throw new IOException("Could not rename " + outputFileName + " to " + inputFileName);
          }
        } 
        else {
          throw new IOException("Could not delete original input file " + inputFileName);
        }
      }
     
    }
    catch (IOException ex) {
      // Handle any exceptions
        System.out.println("No show exists");
      //ex.printStackTrace();
    }
 }
    
 public boolean writeToFile(String str) {
   try { 
     String path;
     if (type.equalsIgnoreCase("Client"))
       path = System.getProperty("user.dir") + "\\client.txt";
     else
       path = System.getProperty("user.dir") + "\\show.txt";
     file = new File(path);
        
     if (!file.exists()) {
       file.createNewFile();
     }
        
     FileWriter fw = new FileWriter(path,true);
        
     BufferedWriter bw = new BufferedWriter(fw);
     bw.append(str);
     bw.newLine();

     bw.close();
         
   } 
   catch (IOException ex) {
     System.out.println("Could not write to file. Please try again");
     return false;
   }
   return true;
}
   
   //check if client with the email exists in client.txt file or not 
   public boolean validate(String str) {
     String path;
     path = System.getProperty("user.dir") + "\\client.txt";
     file = new File(path);
        
     if (!file.exists())
       return false;
       
     try {
       FileReader fr = new FileReader(path);
          
       BufferedReader br = new BufferedReader(fr);
       String line;
       while ((line =br.readLine())!= null) {
         String[] arr = line.split(";");
         String email = arr[7];
         //email is not null
         if(email != null) {
           if (email.equalsIgnoreCase(str)) {
             br.close();
             fr.close();
             return true;
           }
         }
         else
           return false;           
     }
     br.close();
     fr.close();
     } catch (FileNotFoundException ex) {
          System.out.println("Could not open file. Please try again");
          
      } catch (IOException ex) {
          System.out.println("Could not open file. Please try again");
          
  }
     return false;
}
   
   //check if client already has a show 
   public boolean validateShow(String str) {
       String path;
        //if (type.equalsIgnoreCase("Client"))
           path = System.getProperty("user.dir") + "\\show.txt";
        //else
          //  path = System.getProperty("user.dir") + "\\show.txt";
        
        file = new File(path);
        
        if (!file.exists())
            return false;
       
      try {
          FileReader fr = new FileReader(path);
          
          BufferedReader br = new BufferedReader(fr);
          String line;
          while ((line =br.readLine())!= null) {
            String[] arr = line.split(";");
            String showNum = arr[10];
            if (showNum.equalsIgnoreCase(str)) {
                br.close();
                fr.close();
                return true;
            }
            
          }
          
          br.close();
          fr.close();
      } catch (FileNotFoundException ex) {
          System.out.println("Could not open file. Please try again");
          Logger.getLogger(FileHandling.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IOException ex) {
          System.out.println("Could not open file. Please try again");
          Logger.getLogger(FileHandling.class.getName()).log(Level.SEVERE, null, ex);
      }
        
       return false;
   }
   
   public boolean validateShowbyID(String str) {
     String path;
     path = System.getProperty("user.dir") + "\\show.txt";
     file = new File(path);
        
     if (!file.exists())
       return false;
       
     try {
       FileReader fr = new FileReader(path);
       BufferedReader br = new BufferedReader(fr);
       String line;
       while ((line =br.readLine())!= null) {
         String[] arr = line.split(";");
         String showNum = arr[10];
         if (showNum.equalsIgnoreCase(str)) {
           br.close();
           fr.close();
           return true;
         }            
      }
      br.close();
      fr.close();
      } catch (FileNotFoundException ex) {
          System.out.println("Could not open file. Please try again");
          
      } catch (IOException ex) {
         System.out.println("Could not open file. Please try again");
      } 
       return false;
   }   
}
