package test3;


import java.awt.Dimension;
import javax.swing.JFrame;
import java.util.*;
import java.io.*;
import java.math.*;
import java.text.*;
import java.awt.event.*;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;


public class picha extends JFrame
{
 private static final long serialVersionUID = 1L;  
 
 static ArrayList<String> ext = new ArrayList<String>();  // created ext object of arraylist to get elements into it

 
   public picha() 
    {   
        super("SG");  
      
    }
   
    public String rec(String path)
    {
         String direc = recurse(path);
         return direc;
    }
    
    
    
    public String inputs(String chartTitle)
    {       
        String available = "File available";
        
        if(ext.isEmpty() == false)
       {
        PieDataset dataset = createDataset(ext);              
        JFreeChart chart = createChart(dataset, chartTitle);    
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(400, 270));
        setContentPane(chartPanel);
       }
        else
        {
             available = "Not a single File present in the directory";   
        }
        return available;
    }
    
    
    
     public String inputs2(String chartTitle)
     {
         String available = "File available";
         
          if(ext.isEmpty() == false)
       {
         PieDataset dataset2 = createDataset2(ext);
         JFreeChart chart2 = createChart(dataset2, chartTitle);
         ChartPanel chartPanel2 = new ChartPanel(chart2);
         chartPanel2.setPreferredSize(new java.awt.Dimension(400, 270));
         setContentPane(chartPanel2); 
       }
        else
        {
             available = "Not a single File present in the directory";   
        }
        return available;
     }
    
   public String recurse(String path)
  {  
     String direc = "Provided Directory is correct";
     String pathnames[];
     String extension;   // variable to store extension names.
     
     File directory = new File(path);    //getting the directory path
     if (directory.isDirectory())
     {
     File[] files = directory.listFiles();  //accessing list of files present in directory
     
      pathnames = directory.list();
     
     if (pathnames.length>0) 
      {        
          
    for(File file : files)
    {
      String filename = file.toString();  //converting filename into string    
      int index2 = filename.lastIndexOf('\\');  //changing filename to its orignal form by removing it previous extra path(optional)
      filename = filename.substring(index2+1);

          
      
       if(file.isFile()==true && filename.lastIndexOf('.')>0)  //if here index value is -1 ,means that filename dosent contains '.' ,it may be a folder,etc
      { 
         int index = filename.lastIndexOf('.'); //getting index value of '.' for seprating extension from name.
         extension = filename.substring(index+1);
         ext.add(extension);   //adding extension name to arraylist           
      }
       else if(file.isFile()==false)
      {  
         String newpath = path+"\\"+filename;
         recurse(newpath);       
      }
    }
   }
  }
   else
     {
        direc = "Directory provided is invalid";
     }
     return direc;
  }
   
   
   

  
  
    private  PieDataset createDataset(ArrayList<String> ext1) 
    {
    double totalperc=0;
    double totfiles=0;
    
     Set<String> st = new HashSet<String>(ext1);   // hash set is created and elements of arraylist are insertd into it
     System.out.println("\n-------ACTUAL GRAPH VALUES--------");
     for (String s : st)
     {
      System.out.println(s + " : " + Collections.frequency(ext1, s));     
     }
     System.out.println("\nTotal Files = "+ext.size());
     
     totfiles = ext.size();
     totalperc = 100/totfiles;
     
     DecimalFormat df = new DecimalFormat("#.####");
     df.setRoundingMode(RoundingMode.CEILING);
     totalperc =  Double.parseDouble(df.format(totalperc));

     System.out.println("\nIn Percentage");
     DefaultPieDataset result = new DefaultPieDataset();
     for (String s : st)
     {
          System.out.println(s + " : "+df.format(totalperc*(Collections.frequency(ext1, s)))+"%"); 
          result.setValue(s,Collections.frequency(ext1, s));
     }
     ext.clear();
     return result;
    }
        
 
    
    
    

 
    private  PieDataset createDataset2(ArrayList<String> ext1) 
    {  
        ArrayList<String> Doclist = new ArrayList<String>();
        ArrayList<String> Archlist = new ArrayList<String>();
        ArrayList<String> Imaglist = new ArrayList<String>();
        ArrayList<String> Audiolist = new ArrayList<String>();
        ArrayList<String> Videolist = new ArrayList<String>();
      
        ArrayList<String> General = new ArrayList<String>();
        
     data d1 = new data();
     Doclist = d1.doclist();
     Archlist = d1.archlist();
     Imaglist = d1.imglist();
     Audiolist = d1.audiolist();
     Videolist = d1.vidlist();      
             
    double totalperc = 0;
    double totfiles = 0;
    
    for(String check : ext1)
    {
       if(Doclist.contains(check) == true)
       {
         General.add("Document");  
       }
       else if(Archlist.contains(check) == true)
       {
          General.add("Archive & Compressed"); 
       } 
       else if(Imaglist.contains(check) == true)
       {
           General.add("Image & Graphic");
       } 
       else if(Audiolist.contains(check) == true)
       {
           General.add("Sound & Music");
       }
       else if(Videolist.contains(check) == true)
       {
           General.add("Video");
       }
       else
       {
           General.add("Other");
       }
    }
   
    Set<String> st1 = new HashSet<String>(General);   // hash set is created and elements of arraylist are insertd into it
     System.out.println("\n-------GENERAL GRAPH VALUES--------");
     for (String s : st1)
     {
      System.out.println(s + " : " + Collections.frequency(General, s));     
     }
     System.out.println("\nTotal Files = "+General.size());
     
     
     totfiles = General.size();
     totalperc = 100/totfiles;

     DecimalFormat df = new DecimalFormat("#.####");
     df.setRoundingMode(RoundingMode.FLOOR);
     totalperc =  Double.parseDouble(df.format(totalperc));

     System.out.println("\nIn Percentage");
     DefaultPieDataset result1 = new DefaultPieDataset();
     for (String s : st1)
     {
          System.out.println(s + " : "+df.format(totalperc*(Collections.frequency(General, s)))+"%"); 
          result1.setValue(s,Collections.frequency(General, s));
     }
     ext.clear();
     return result1;
    }
    
    
    
    
    
    
    private JFreeChart createChart(PieDataset dataset, String title) 
    {   
        JFreeChart chart = ChartFactory.createPieChart3D(title,dataset,true,true,false);
        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        return chart;
    }
    
}