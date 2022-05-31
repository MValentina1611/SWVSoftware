package strcs_LA;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class GraphLA<E>  {
	
	private HashMap<VertexLA<E>,ArrayList<VertexLA<E>>> graph;


	/*
	public void createVertex(E e) {
		
		VertexLA<E> newVertex = new VertexLA<>(e,size);
		size++;
	}

	*/
	public void addEdgeHelper(VertexLA<E> vi, VertexLA<E> vf, int cost) 
	{
	    ArrayList<VertexLA<E>> tmp = graph.get(vi);
	    vf.setAdjacencyCost(cost);
	    if (tmp != null) 
	    {
	        tmp.remove(vf);
	    }
	    else 
	    { 
	    	tmp = new ArrayList<VertexLA<E>>();
	    	tmp.add(vf);
	    }
	    graph.put(vi,tmp);
	}

	public void addEdge(VertexLA<E> vi, VertexLA<E> vf, int cost) 
	{

	    if (!graph.keySet().contains(vi))
	    {
	        graph.put(vi, null);
	    }
	    
	    if (!graph.keySet().contains(vf))
	    {
	        graph.put(vf, null);
	    }
	    
	    addEdgeHelper(vi, vf,cost);
	}

	
	public void delete(VertexLA<E> v) 
	{
		
		Collection<ArrayList<VertexLA<E>>> values = graph.values();
		
		for (ArrayList<VertexLA<E>> arrayList : values) {
			
			if(arrayList.contains(v))
			{
				arrayList.remove(v);
			}
		}
		graph.remove(v);
	
	}
	
	
	public ArrayList<VertexLA<E>> search(VertexLA<E> v) 
	{
		return graph.get(v);
	}

	
	public GraphLA<E> bfs(VertexLA<E> origin, Object characteristic) {

		GraphLA<E> graphBFS = new GraphLA<E>();
	    if (origin != null)
	    {	
	    	Queue<VertexLA<E>> queue = new LinkedList<>();
	    	origin.setpDistance(0);
	    	origin.setAncestor(null);
	    	queue.add(origin);

	    	while (!queue.isEmpty()) 
	    	{
	    		VertexLA<E> current = queue.poll();
	    		if (current.isVisited())
	    		{
	    			continue;
	    		}
	    		current.setVisited(true);
	    		

	    		ArrayList<VertexLA<E>> neighbors = graph.get(current);

	    		if (neighbors == null)
	    		{
	    			continue;
	    		}
	    		for (VertexLA<E> neighbor : neighbors) 
	    		{
	    			neighbor.setAncestor(current);
	    			neighbor.setpDistance(current.getpDistance()+1);
	    			if(neighbor.getElement().toString().equals(characteristic))
	    			{
	    				graphBFS.addEdge(current, neighbor, neighbor.getAdjacencyCost());
	    			}
	    			if (!neighbor.isVisited()) {
	    				queue.add(neighbor);
	    			}
	    		}
	    	}
	    }
	    
	    return graphBFS;
	}
	
	
}
