/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphalgorithms;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author piyush
 */
public class Node {
    private Node parent;
    private List<Node> children= new ArrayList<>();
    private Vertex vertex;
    
    Node(Vertex vertex, Node parent, List<Node> children){
        this.vertex=vertex;
        this.parent=parent;
        this.children=children;
    }
    
    private void appendChild (Node child){
        this.children.add(child);
    }
    
}
