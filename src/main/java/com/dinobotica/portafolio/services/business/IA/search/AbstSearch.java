package com.dinobotica.portafolio.services.business.IA.search;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstSearch implements ISearch{
    
    protected Nodo rootNode;
    protected Nodo targetNode;
    protected Nodo finalNode;

    protected List<Nodo> path;
    protected List<Nodo> pendingNodes;
    protected List<Nodo> visitedNodes;

    protected AbstSearch()
    {
        pendingNodes = new LinkedList<>();
        visitedNodes = new LinkedList<>();
        path = new LinkedList<>();
    }

    protected AbstSearch(Nodo rootNode, Nodo targetNode)
    {
        this.rootNode = rootNode;
        this.targetNode = targetNode;
        pendingNodes = new LinkedList<>();
        visitedNodes = new LinkedList<>();
        path = new LinkedList<>();
    }

    @Override
    public Nodo getFinalNode() {
        return finalNode;
    }

    @Override
    public void setRootNode(Nodo rootNode) {
        this.rootNode = rootNode;
    }

    @Override
    public List<Nodo> getPath() {
        return path;
    }

    @Override
    public List<Nodo> getRootPath() {
        
        Nodo currentNode = finalNode;
        List<Nodo> rootPath = new LinkedList<>();
        while(currentNode != null)
        {
            rootPath.add(0,currentNode);
            currentNode = currentNode.getParent();
        }
        return rootPath;
    }

    @Override
    public void setTargetNode(Nodo targetNode) {
        this.targetNode = targetNode;
    }

    public List<Nodo> generateChildrens(Nodo nodo) 
    {
        return nodo.getNeighborhoods();
    }

    @Override
    public boolean goalReachCriteria(Nodo goalNode) {
        
        return goalNode.equals(targetNode, false);
    }

    
}
