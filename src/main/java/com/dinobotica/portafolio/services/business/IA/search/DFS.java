package com.dinobotica.portafolio.services.business.IA.search;

import java.util.List;

public class DFS extends AbstSearch{

    public DFS()
    {
        super();
    }

    public DFS(Nodo rootNode, Nodo targetNode)
    {
        super(rootNode,targetNode);
    }

    @Override
    public List<Nodo> explore() {
        
        recursiveExploration(rootNode);
        return path;
    }

    private boolean recursiveExploration(Nodo node)
    {
        if(visitedNodes.contains(node))
            return false;

        path.add(node);
        visitedNodes.add(node);

        if(goalReachCriteria(node))
        {
            finalNode = node;
            return true;
        }
        for(Nodo child : node.getNeighborhoods())
        {
            boolean breakExploration = false;
            breakExploration = recursiveExploration(child);
            if(breakExploration)
            {
                child.setParent(node);
                node.setParent(null);
                return true;
            }   
                
        }
        
        return false;
    }
    
    @Override
    public String getName() {
        
        return "Depth First Search (DFS)";
    }
}
