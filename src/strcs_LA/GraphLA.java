package strcs_LA;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class GraphLA<E>  {
	
	private HashMap<VertexLA<E>,ArrayList<VertexLA<E>>> graph = new HashMap<>();
	private HashMap<VertexLA<E>,Integer> graphIndex = new HashMap<>();
	private int index = 0;


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

	public void addEdge(VertexLA<E> vi, VertexLA<E> vf, int cost) {
		
	    if (!graph.keySet().contains(vi))
	    {
	        graph.put(vi, null);
	        
	        index++;
		    graphIndex.put(vi, index);
	    }
	    
	    if (!graph.keySet().contains(vf))
	    {
	        graph.put(vf, null);
	        
	        index++;
		    graphIndex.put(vf, index);
	    }
	    
	    addEdgeHelper(vi, vf,cost);
		}
	

	 public void removeVertex(VertexLA<E> vertex){
         graph.remove(vertex);
         graphIndex.remove(vertex);
      }
	
	public ArrayList<VertexLA<E>> search(VertexLA<E> v) {
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
	
	public ArrayList<VertexLA<E>> DijkstraShortestPath(VertexLA<E> origin, VertexLA<E> end) 
	{
		
		ArrayList<VertexLA<E>> shortestPath = new ArrayList<VertexLA<E>>();
	   
	    HashMap<VertexLA<E>, VertexLA<E>> changedAt = new HashMap<>();
	    changedAt.put(origin, null);
	    
	    HashMap<VertexLA<E>, Integer> shortestPathMap = new HashMap<>();

	    for (VertexLA<E> node : graph.keySet()) {
	        if (node == origin)
	            shortestPathMap.put(origin, 0);
	        else shortestPathMap.put(node, Integer.MAX_VALUE);
	    }

	    for (VertexLA<E> adjacent : origin.getAdyacencyList()) {
	        shortestPathMap.put(adjacent, adjacent.getAdjacencyCost());
	        changedAt.put(adjacent, origin);
	    }

	    origin.setVisitedD(true);

	    while (true) {
	    	VertexLA<E> currentNode = closestReachableUnvisited(shortestPathMap);

	        if (currentNode == null) 
	        {
	            return null;
	        }

	        if (currentNode == end) 
	        {
	            
	            VertexLA<E> child = end;

	            shortestPath.add(end);
	            while (true) {
	            	VertexLA<E> parent = changedAt.get(child);
	                if (parent == null) {
	                    break;
	                }
	                shortestPath.add(parent);
	                child = parent;
	            }
	            
	           //"The path costs: " + shortestPathMap.get(end);
	            return shortestPath;
	        }
	        currentNode.setVisitedD(true);
	        
	        for (VertexLA<E> adjacent : currentNode.getAdyacencyList()) {
	            if (adjacent.isVisitedD())
	                continue;

	            if (shortestPathMap.get(currentNode) + adjacent.getAdjacencyCost() < shortestPathMap.get(adjacent)) {
	                shortestPathMap.put(adjacent, shortestPathMap.get(currentNode) + adjacent.getAdjacencyCost());
	                changedAt.put(adjacent, currentNode);
	            }
	        }
	    }
	}
	
	
	private VertexLA<E> closestReachableUnvisited(HashMap<VertexLA<E>, Integer> shortestPathMap) {

	    int shortestDistance = Integer.MAX_VALUE;
	    VertexLA<E> closestReachableNode = null;
	    for (VertexLA<E> node : graph.keySet()) 
	    {
	        if (node.isVisitedD())
	            continue;

	        int currentDistance = shortestPathMap.get(node);
	        if (currentDistance == Integer.MAX_VALUE)
	            continue;

	        if (currentDistance < shortestDistance) 
	        {
	            shortestDistance = currentDistance;
	            closestReachableNode = node;
	        }
	    }
	    return closestReachableNode;
	}
	
	public HashMap<VertexLA<E>, ArrayList<VertexLA<E>>> getGraph() {
		return graph;
	}
	
	public HashMap<VertexLA<E>, Integer> getGraphIndex() {
		return graphIndex;
	}
}
