package com.dinobotica.portafolio.services.business.IA.search;

import java.util.List;

public class UCS extends AbstSearch{

    public UCS(Nodo rootNode, Nodo targetNode)
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
                breakExploration = true;
            }
            else
            {
                path.add(nextNode);
                for(int i = 0; i < nextNode.getNeighborhoods().size(); i++)
                {
                    Nodo child = nextNode.getNeighborhood(i);
                    if(nextNode.getParent() != null &&  nextNode.getParent().equals(child,true))
                        continue;
                    double newTotalCost = nextNode.getTotalCost() + nextNode.getWeight(i);
                    Nodo pathNode = new Nodo(child, newTotalCost);
                    pathNode.setParent(nextNode);
                    addOrderedPath(pathNode);
                    
                }
                pendingNodes.remove(0);
            }
                
        }

        return path;
    }

    private int addOrderedPath(Nodo node)
    {
        for(int i =0; i < path.size(); i++)
        {
            if(node.equals(path.get(i),true) && node.getTotalCost() >= path.get(i).getTotalCost())
                return -1;

        }

        for(int i =0; i < pendingNodes.size(); i++)
        {
            if(node.equals(pendingNodes.get(i),true) && node.getTotalCost() >= pendingNodes.get(i).getTotalCost())
                return -1;

            if(node.getTotalCost() < pendingNodes.get(i).getTotalCost())
            {
                pendingNodes.add(i, node);
                return i;
            }
        }
        pendingNodes.add(node);
        return pendingNodes.size() - 1;
    }
    
    @Override
    public boolean goalReachCriteria(Nodo goalNode) {
        
        return goalNode.equals(targetNode, true);
    }

    @Override
    public String getName() {
        
        return "Uniform Cost Search (UCS)";
    }
}
