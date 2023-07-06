package com.dinobotica.portafolio.services.business.IA.search;

import java.util.List;

public interface ISearch {
    
    public List<Nodo> explore();
    public void setRootNode(Nodo rootNode);
    public List<Nodo> getPath();
    public List<Nodo> getRootPath();
    public Nodo getFinalNode();
    public void setTargetNode(Nodo targetNode);
    public boolean goalReachCriteria(Nodo goalNode);
    public String getName();
}
