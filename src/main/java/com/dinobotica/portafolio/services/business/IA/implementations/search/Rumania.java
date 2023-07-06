package com.dinobotica.portafolio.services.business.IA.implementations.search;

import java.util.ArrayList;
import java.util.List;

import com.dinobotica.portafolio.services.business.IA.search.BFS;
import com.dinobotica.portafolio.services.business.IA.search.DFS;
import com.dinobotica.portafolio.services.business.IA.search.ISearch;
import com.dinobotica.portafolio.services.business.IA.search.Nodo;
import com.dinobotica.portafolio.services.business.IA.search.UCS;

public class Rumania {
    
    public static void main(String[] args) {
    
        Nodo oradea = new Nodo("Oradea");
        Nodo zerind = new Nodo("Zerind");
        Nodo arad = new Nodo("Arad");
        Nodo sibiu = new Nodo("Sibiu");
        Nodo timisoara = new Nodo("Timisoara");
        Nodo lugoj = new Nodo("Lugoj");
        Nodo mehadia = new Nodo("Mehadia");
        Nodo drobeta = new Nodo("Drobeta");
        Nodo fagaras = new Nodo("Fagaras");
        Nodo rimnicu = new Nodo("Rimnicu Vilcea");
        Nodo craiova = new Nodo("Craiova");
        Nodo pitesti = new Nodo("Pitesti");
        Nodo bucharest = new Nodo("Bucharest");
        Nodo giurgiu = new Nodo("Giurgiu");
        Nodo urziceni = new Nodo("Urziceni");
        Nodo hirsova = new Nodo("Hirsova");
        Nodo eforie = new Nodo("Eforie");
        Nodo vaslui = new Nodo("Vaslui");
        Nodo iasi = new Nodo("Iasi");
        Nodo neamt = new Nodo("Neamt");

        oradea.addNeighborhood(zerind, 71);
        oradea.addNeighborhood(sibiu, 151);
        zerind.addNeighborhood(arad, 75);
        arad.addNeighborhood(timisoara, 118);
        arad.addNeighborhood(sibiu, 140);
        timisoara.addNeighborhood(lugoj, 111);
        lugoj.addNeighborhood(mehadia,70);
        mehadia.addNeighborhood(drobeta, 75);
        drobeta.addNeighborhood(craiova, 120);
        craiova.addNeighborhood(rimnicu, 146);
        craiova.addNeighborhood(pitesti,138);
        rimnicu.addNeighborhood(sibiu, 80);
        rimnicu.addNeighborhood(pitesti, 97);
        sibiu.addNeighborhood(fagaras,99);
        bucharest.addNeighborhood(pitesti,101);
        bucharest.addNeighborhood(fagaras,211);
        bucharest.addNeighborhood(giurgiu,90);
        bucharest.addNeighborhood(urziceni,85);
        urziceni.addNeighborhood(hirsova,98);
        urziceni.addNeighborhood(vaslui,142);
        hirsova.addNeighborhood(eforie,86);
        vaslui.addNeighborhood(iasi,92);
        iasi.addNeighborhood(neamt,87);



        ISearch[] exploradores = new ISearch[3];
        Nodo initNode = oradea, endNode = neamt;

        exploradores[0] = new BFS(initNode,endNode);
        exploradores[1] = new DFS(initNode,endNode);
        exploradores[2] = new UCS(initNode,endNode);
        List<Nodo> camino = new ArrayList<>();
        for(ISearch explorador : exploradores)
        {
            System.out.println("\n\nCamino explorado " + explorador.getName());
            camino = explorador.explore();
            for(Nodo nodo : camino)
            {
                System.out.println(nodo.printPathNode() + ",");
            }

            camino = explorador.getRootPath();
            System.out.println("\nCamino directo "  + explorador.getName());
            for(Nodo nodo : camino)
            {
                System.out.println(nodo.printPathNode() + ",");
            }
        }
        
        System.out.println("\nCosto total: " + camino.get(camino.size()-1).getTotalCost());
        
    }
}
