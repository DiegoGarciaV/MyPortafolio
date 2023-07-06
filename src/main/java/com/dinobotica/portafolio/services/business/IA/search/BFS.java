package com.dinobotica.portafolio.services.business.IA.search;

import java.util.List;

public class BFS extends AbstSearch{

    public BFS()
    {
        super();
    }

    public BFS(Nodo rootNode, Nodo targetNode)
    {
        super(rootNode,targetNode);
    }

    @Override
    public List<Nodo> explore() {
        
        pendingNodes.add(rootNode);
        boolean breakExploration = false;
        while(!pendingNodes.isEmpty() && !breakExploration)
        {
            Nodo nextNode = pendingNodes.get(0);
            if(goalReachCriteria(nextNode))
            {
                path.add(nextNode);
                finalNode = nextNode;
                visitedNodes.add(nextNode);
                breakExploration = true;
            }
            else
            {
                if(visitedNodes.contains(nextNode))
                {
                    pendingNodes.remove(0);
                    continue;
                }
                visitedNodes.add(nextNode);
                path.add(nextNode);
                for(Nodo child : nextNode.getNeighborhoods())
                {
                    if(!visitedNodes.contains(child) && !pendingNodes.contains(child))
                    {
                        child.setParent(nextNode);
                        pendingNodes.add(child);
                    }
                }
                pendingNodes.remove(0);
            }
                
        }

        return path;
    }

    @Override
    public String getName() {
        
        return "Breadth Fisrt Search (BFS)";
    }

}
