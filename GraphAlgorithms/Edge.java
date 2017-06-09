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
public class Edge {
    private Vertex start;
    private Vertex end;
    
    Edge(Vertex start, Vertex end){
        this.start=start;
        this.end=end;
    }
    
    public Vertex getStart(){
        return this.start;
    }
    
    public Vertex getEnd(){
        return this.end;
    }
}
