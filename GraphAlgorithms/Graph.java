/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphalgorithms;

/**
 *
 * @author piyush
 */
import java.util.*;
        
public class Graph {
    private List<Vertex> vertices= new ArrayList<>();
    private List<Edge> edges= new ArrayList<>();
    private Map adjMat= new HashMap();
    private boolean madeAdjacencyMatrix= false;
    private boolean isSparse;
    
    Graph(ArrayList <Vertex> vertices, ArrayList <Edge> edges){
        this.vertices=vertices;
        this.edges=edges;
    }
    
    public void addVertex(Vertex vertex){
        this.vertices.add(vertex);
    }
    
    public void addEdge(Edge edge){
        this.edges.add(edge);
        if (this.madeAdjacencyMatrix){
            this.updateAdjacencyMatrix(edge);
        }
    }
    
    public void updateAdjacencyMatrix(Edge edge){
        //do nothing
    }
    
    public void updateAdjacecyMatrix(Vertex vertex){
        //do nothing
    }
    
    public void makeAdjacencyMatrix(){
        this.madeAdjacencyMatrix=true;
        for (int i=0; i<0; i++){
        //do nothing
        
        }
    
    }
    
    public Map getAdjacencyMatrix(){
        if (madeAdjacencyMatrix==false){
            this.makeAdjacencyMatrix();
            
        }
        
        return this.adjMat;
    }
    
    public boolean isSparse(){
        return 2*this.edges.size()<this.vertices.size()*this.vertices.size();
    }
    
}
