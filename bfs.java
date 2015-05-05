import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
//import java.lang.*;
import java.util.Map;




class LinkDetails
{
	private int hours;
	private int rFactor;
	public LinkDetails(int hours,int rFactor)
	{
		this.hours=hours;
		this.rFactor=rFactor;
	}

	public int getTime() 
	{ 
		return hours;
	}

	public int getrFactor() 
	{ 
		return rFactor;
	}
	
	 @Override
	 public String toString()
     {
       return "("+hours+";"+rFactor+")";
     }

}


public class Search{
	
	
	public static class Node
    {
        String startNode;
        String endNode;
       
        public Node(String startNode, String endNode)
        {
            this.startNode = startNode;
            this.endNode = endNode;
        }
       
        public String toString()
        {
        	return "( Start Node = " + startNode + ";End Node=" + endNode + ")";
        }
    }






	private Map<String, List<String>> mapRelation;
	
	public void populateGraph()
	{
		BufferedReader in=null;
		
		Map<String, List<String>> mapRelation = new HashMap<String, List<String>>();
		Map<Link, LinkDetails> mapLinkInfo= new HashMap<Link,LinkDetails>();
	     
		try
		{
			File file = new File("social-network.txt");
			FileReader reader = new FileReader(file);
			in = new BufferedReader(reader);
			String string;
			String word = null;
			String friend = null;
			int hours = 0;
			int rFactor = 0 ;
			String delims = "[ ]+";
		        
			while ((string = in.readLine()) != null) 
			{
				String[] tokens = string.split(delims);
				//System.out.println(string);
				//string.split(" ");
				word = tokens[0];
				friend = tokens[1];
				hours = Integer.parseInt(tokens[2]);
				// System.out.println(hours);
				rFactor = Integer.parseInt(tokens[3]);
				//System.out.println("token[0]"+word);
				//System.out.println("token[1]"+ friend);
				List<String> l = mapRelation.get(word);
				if (l == null)
					mapRelation.put(word, l=new ArrayList<String>());
	             	l.add(friend);
	             mapLinkInfo.put(new Link(word,friend),new LinkDetails(hours,rFactor));
	             //System.out.println(l);
			}
		        
			for (String key : mapRelation.keySet()) 
			{
	      	   System.out.println("------------------------------------------------");
	      	   System.out.println("key: " + key + " value: " +mapRelation.get(key));
		     
			}
		        
			for (Link key : mapLinkInfo.keySet()) 
			{
	     	   System.out.println("------------------------------------------------");
	     	   //System.out.println("Iterating or looping map using java5 foreach loop");
	     	   System.out.println("key: " + key + " value: " + mapLinkInfo.get(key));
		     
			}
		       
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		finally
		{
			try 
			{
				if(in!=null)
				{
					in.close();
				}
			} 
		    catch (IOException e) 
		    {
		    	e.printStackTrace();
		    }
		        
		}
	}
	
	

	
	public void bfs(Node n1, Node n2)
    {
        Set<String> keys = mapRelation.keySet();
        for (String u : keys) {
            if (u != "n1") {
               
            	
            	
            }
        }
        ;
        Queue<Node> q = new ArrayDeque<Node>();
        q.add(n1);
        while (!q.isEmpty()) {
            Node u = q.remove();
            List<String> adj_u = mapRelation.get(u);
            if (adj_u != null) {
                for (String v : adj_u) {
                    
                        q.add(v);
                    }
                }
            }
            
            System.out.print(u + " ");
        }
    }
	
	
	
	
	
	
	public static void main(String[] args) 
	{
		populateGraph();
	}
}
