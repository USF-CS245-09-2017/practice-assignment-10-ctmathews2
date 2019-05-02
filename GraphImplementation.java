import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class GraphImplementation implements Graph{
	public int[][] adjMatrix;

	public GraphImplementation(int verticies){
		adjMatrix = new int[verticies][verticies];
	}

	public void addEdge(int src, int tar){
		adjMatrix[src][tar] = 1;
	}

	public int[] neighbors(int vertex){ //Go through [vertx][i]
		int[] neighborsArr = new int[adjMatrix[vertex].length];
		for(int i = 0; i < adjMatrix[vertex].length; i++){
			if(adjMatrix[vertex][i] == 1){ //If it has an edge add that vertex to neighbors array
				neighborsArr[i] = i;
			}else{
				neighborsArr[i] = -1; //else make it -1 to remove later
			}
		}
		
		int targetIndex = 0; //Code to remove -1 from arrays. newArray will only contain neighbors
		for( int sourceIndex = 0;  sourceIndex < neighborsArr.length;  sourceIndex++ ){
			if( neighborsArr[sourceIndex] != -1 )
				neighborsArr[targetIndex++] = neighborsArr[sourceIndex];
		}
		int[] newArray = new int[targetIndex];
		System.arraycopy( neighborsArr, 0, newArray, 0, targetIndex );

		return newArray;
	}

	public List<Integer> topologicalSort(){ //Add up the columns and add the sum to list
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < adjMatrix.length; i++){
			int sum = 0;
			for(int n = 0; n < adjMatrix.length; n++){
				sum += adjMatrix[n][i];
			}
			list.add(sum);
		}

		return list;
	}

	public static void main(String[] args){
		GraphImplementation g = new GraphImplementation(3);
		g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(1,0);
		g.addEdge(2,1);
		g.addEdge(2,0);
		//System.out.println(Arrays.deepToString(g.adjMatrix));
		//List<Integer> list1 = g.topologicalSort();
		//System.out.println(g.topologicalSort());
	}


}