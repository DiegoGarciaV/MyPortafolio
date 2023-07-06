package com.dinobotica.portafolio.services.business.IA.search;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;

public class Nodo {
 
    private Nodo parent;
    private List<Nodo> neighborhoods;
    private List<Double> weights;
    private Object value;
    private double totalCost;
    private double estimatedCost;

    public Nodo(Object value)
    {
        this.value = value;
        neighborhoods = new LinkedList<>();
        weights = new LinkedList<>();
        
    }

    public Nodo(Nodo node, double totalCost)
    {
        this.value = node.value;
        this.neighborhoods = node.getNeighborhoods();
        this.weights = node.getWeights();
        this.totalCost = totalCost;
    }

    public Nodo(Nodo node, double totalCost, double estimatedCost)
    {
        this.value = node.value;
        this.neighborhoods = node.getNeighborhoods();
        this.weights = node.getWeights();
        this.totalCost = totalCost;
        this.estimatedCost = estimatedCost;
    }

    public Nodo getParent() {
        return parent;
    }
    public void setParent(Nodo parent) {
        this.parent = parent;
    }

    public List<Nodo> getNeighborhoods() {
        return neighborhoods;
    }
    public void setNeighborhoods(List<Nodo> neighborhoods) {
        this.neighborhoods = neighborhoods;
    }

    public Object getValue() {
        return value;
    }
    public void setValue(Object value) {
        this.value = value;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public double getEstimatedCost() {
        return estimatedCost;
    }

    public List<Double> getWeights() {
        return weights;
    }
    public void setWeights(List<Double> weights) {
        this.weights = weights;
    }

    public void addWeight(double w)
    {
        weights.add(w);
    }


    public Nodo getNeighborhood(int i)
    {
        return neighborhoods.get(i);
    }

    public double getWeight(int i)
    {
        return weights.get(i);
    }
    
    public void addNeighborhood(Nodo nodo)
    {
        neighborhoods.add(nodo);
        weights.add(1.0);
        nodo.getNeighborhoods().add(this);
        nodo.addWeight(1.0);
    }

    public void addNeighborhood(Nodo nodo, double w)
    {
        neighborhoods.add(nodo);
        weights.add(w);
        nodo.getNeighborhoods().add(this);
        nodo.addWeight(w);
    }

    public void addNeighborhood(Nodo nodo, double w1, double w2)
    {
        neighborhoods.add(nodo);
        weights.add(w1);
        if(w2 > 0)
        {
            nodo.getNeighborhoods().add(this);
            nodo.addWeight(w2);
        }
    }

    public void addChildren(Nodo nodo)
    {
        neighborhoods.add(nodo);
        nodo.setParent(this);
    }


    public void addChildren(Nodo nodo, double w)
    {
        neighborhoods.add(nodo);
        weights.add(w);
        nodo.setParent(this);
    }
    
    /**
     * 
     * @param nodo Node to comapare
     * @param type Type of comparision, if true, value comparision, else reference comparision
     * @return true if nodo and this are equal, false ioc
     */
    public boolean equals(Nodo nodo, boolean type)
    {
        if(type)
            return this.getValue().equals(nodo.getValue());

        return this == nodo;
    }
    
    @Override
    public boolean equals(Object object)
    {
        if(!(object instanceof Nodo))
            return false;

        Nodo oNode = (Nodo)object;
        return oNode.getValue().equals(value);
    }

    @Override
    public int hashCode()
    {   
        return value.toString().hashCode();
    }

    @Override
    public String toString()
    {
        if (value != null && value.getClass().isArray())
        {
            StringBuilder stringBuilder = new StringBuilder("[");
            int length = Array.getLength(value);
            for (int i = 0; i < length; i++) 
            {
                Object element = Array.get(value, i);
                stringBuilder.append("{")
                .append(element)
                .append("}")
                .append(i < length - 1 ? "," : "]");
            }
            return stringBuilder.toString();

        }
        if(value == null)
            return "{}";
            
        return "{" + value.toString() + "}";
    }

    public String printPathNode()
    {
        return "{" + toString() + ", " + totalCost + "}";
    }
}
