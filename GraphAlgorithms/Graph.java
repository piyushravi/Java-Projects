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
import java.util.ArrayList;
import java.util.List;
        
public class Graph {
    private List<Vertex> vertices= new ArrayList<>();
    private List<Edge> edges= new ArrayList<>();
    
    Graph(ArrayList <Vertex> vertices, ArrayList <Edge> edges){
        this.vertices=vertices;
        this.edges=edges;
    }
    
}
