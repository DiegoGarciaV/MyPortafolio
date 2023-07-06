package com.dinobotica.portafolio.services.business.IA.implementations.search;

import java.util.ArrayList;
import java.util.List;

import com.dinobotica.portafolio.services.business.IA.search.ISearch;
import com.dinobotica.portafolio.services.business.IA.search.Nodo;
import com.dinobotica.portafolio.services.business.IA.search.UCS;

public class Laberinto {

    private int n;
    private Nodo[][] laberintoNodos;
    private List<int[]> unaccesibleNodes;
    

    public Laberinto(int n)
    {
        this.n = n;
        unaccesibleNodes = new ArrayList<>();
        laberintoNodos = initLaberinto();
    }

    public Nodo getRootnode()
    {
        return laberintoNodos[0][0];
    }

    
    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
        laberintoNodos = initLaberinto();
    }


    public Nodo getNode(int i, int j)
    {
        return laberintoNodos[i][j];
    }

    public void addUnaccessiblePoint(int i, int j)
    {
        int[] uPoint = new int[]{i,j};
        boolean skipNode = false;
        for(int[] uNode : unaccesibleNodes)
        {
            if(uNode[0] == i && uNode[1] == j)
            {
                skipNode = true;
                break;
            }
        }
        if(!skipNode)
            unaccesibleNodes.add(uPoint);

        laberintoNodos = initLaberinto();
    }
    public Nodo[][] initLaberinto()
    {
        Nodo[][] laberinto = new Nodo[n][n];

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
            {
                boolean skipNode = false;
                for(int[] uNode : unaccesibleNodes)
                {
                    if(uNode[0] == i && uNode[1] == j)
                    {
                        skipNode = true;
                        break;
                    }
                }
                if(skipNode)
                    continue;

                laberinto[i][j] = new Nodo(new int[]{i,j});
                if(i > 0 && laberinto[i-1][j] != null)
                    laberinto[i][j].addNeighborhood(laberinto[i-1][j],1);

                if(j > 0 && laberinto[i][j-1] != null)
                    laberinto[i][j].addNeighborhood(laberinto[i][j-1],1);
            }

        return laberinto;
    }

    public static void main(String[] args) {
        
        Laberinto laberinto = new Laberinto(10);
      
        for(int i =0; i < 7; i ++)
        {
            laberinto.addUnaccessiblePoint(9-i,7);
            laberinto.addUnaccessiblePoint(i,2);
            if(i != 4 && i != 5)
                laberinto.addUnaccessiblePoint(8-i,5);

        }

        laberinto.addUnaccessiblePoint(0,7);
        laberinto.addUnaccessiblePoint(1,7);

        
        Nodo rootNode = laberinto.getNode(0, 0);
        Nodo targetNode = laberinto.getNode(9, 9);

        ISearch explorador = new UCS(rootNode,targetNode);

        List<Nodo> camino;
        
        System.out.println("\n\nCamino explorado " + explorador.getName() );
        camino = explorador.explore();
        for(Nodo nodo : camino)
        {
            System.out.println(nodo.printPathNode() + ",");
        }

        System.out.println(camino.size() + " nodos explorados");

        camino = explorador.getRootPath();
        System.out.println("\nCamino directo "  + explorador.getName());
        for(Nodo nodo : camino)
        {
            System.out.println(nodo.printPathNode() + ",");
        }

        System.out.println(camino.size() + " nodos recorridos");

    }

}
