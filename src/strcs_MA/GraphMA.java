package strcs_MA;
import java.util.ArrayList;


public class GraphMA<E>  {

	private ArrayList<VertexMA<E>> vertex;
	private int[][] adjacencyMatrix;
	private int size = 0;
	


	public GraphMA(int vertexNum) {
		adjacencyMatrix = new int[vertexNum][vertexNum];
		vertex = new ArrayList<VertexMA<E>>();
	}

	public void add(E e) 
	{
		
		VertexMA<E> toAdd = new VertexMA<>(e,size);
		vertex.add(toAdd);
	}

	public void addEdge(VertexMA<E> vi, VertexMA<E> vf, int cost) 
	{
		int indexI = vi.getIndex();
		int indexF = vf.getIndex();
		boolean added = false;
		for(int i = 0; i < adjacencyMatrix.length && !added; i++ )
		{
			for(int j = 0; j < adjacencyMatrix.length; j++)
			{
				if(i == indexF && j == indexI)
				{
					adjacencyMatrix[i][j] = cost;
					added = true;
				}
			}
		}
	}
	public VertexMA<E> search(int index) 
	{
		
		VertexMA<E> founded = vertex.get(index); 
		return founded;
	}

	public void delete(VertexMA<E> v) 
	{
		vertex.remove(v.getIndex());
		size--;
		boolean deleted = false;		
		for(int i = 0; i < adjacencyMatrix.length && !deleted; i++ )
		{
			for(int j = 0; j < adjacencyMatrix.length; j++)
			{
				if(i == v.getIndex() || j == v.getIndex())
				{
					adjacencyMatrix[i][j] = 0;
					deleted = true;
				}
			}
		}
		
		
	}



	

	
	
}


