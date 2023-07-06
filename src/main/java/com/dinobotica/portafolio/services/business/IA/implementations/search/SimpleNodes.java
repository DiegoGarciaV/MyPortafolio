package com.dinobotica.portafolio.services.business.IA.implementations.search;

import java.util.List;

import com.dinobotica.portafolio.services.business.IA.search.BFS;
import com.dinobotica.portafolio.services.business.IA.search.DFS;
import com.dinobotica.portafolio.services.business.IA.search.ISearch;
import com.dinobotica.portafolio.services.business.IA.search.Nodo;
import com.dinobotica.portafolio.services.business.IA.search.UCS;

public class SimpleNodes {
    
    public static void main(String[] args) {
        
        Nodo n1 = new Nodo(1);
        Nodo n2 = new Nodo(2);
        Nodo n3 = new Nodo(3);
        Nodo n4 = new Nodo(4);
        Nodo n5 = new Nodo(5);
        Nodo n6 = new Nodo(6);
        Nodo n7 = new Nodo(7);
        Nodo n8 = new Nodo(8);
        Nodo n9 = new Nodo(9);
        Nodo n10 = new Nodo(10);
        Nodo n11 = new Nodo(11);
        Nodo n12 = new Nodo(12);
        Nodo n13 = new Nodo(13);
        Nodo n14 = new Nodo(14);
        Nodo n15 = new Nodo(15);
        Nodo n16 = new Nodo(16);
        Nodo n17 = new Nodo(17);
        Nodo n18 = new Nodo(18);
        Nodo n19 = new Nodo(19);
        Nodo n20 = new Nodo(20);
        Nodo n21 = new Nodo(21);

        n1.addChildren(n2, 1);
        n1.addChildren(n3, 1);
        n1.addChildren(n4, 1);
        n1.addChildren(n5, 1);


        n2.addChildren(n6, 1);
        n2.addChildren(n7, 1);
        n2.addChildren(n8, 1);

        n3.addChildren(n9, 1);
        n3.addChildren(n10, 1);

        n4.addChildren(n11, 1);
        n4.addChildren(n12, 1);

        n5.addChildren(n13, 1);
        n5.addChildren(n14, 1);
        n5.addChildren(n15, 1);
        n5.addChildren(n16, 1);

        n6.addChildren(n17, 1);
        n6.addChildren(n18, 1);
        n6.addChildren(n19, 1);


        n7.addChildren(n20, 1);
        n7.addChildren(n21, 1);

        ISearch explorator = new BFS(n1,n21);
        System.out.println("Camino explorado BFS");
        List<Nodo> camino = explorator.explore();
        for(Nodo nodo : camino)
        {
            System.out.print(nodo + ",");
        }

        camino = explorator.getRootPath();
        System.out.println("\nCamino directo BFS");
        for(Nodo nodo : camino)
        {
            System.out.print(nodo + ",");
        }

        explorator = new DFS(n1,n21);
        System.out.println("\n\nCamino explorado DFS");
        camino = explorator.explore();
        for(Nodo nodo : camino)
        {
            System.out.print(nodo + ",");
        }

        camino = explorator.getRootPath();
        System.out.println("\nCamino directo UCS");
        for(Nodo nodo : camino)
        {
            System.out.print(nodo + ",");
        }


        explorator = new UCS(n1,n21);
        System.out.println("\n\nCamino explorado UCS");
        camino = explorator.explore();
        for(Nodo nodo : camino)
        {
            System.out.print(nodo + ",");
        }

        camino = explorator.getRootPath();
        System.out.println("\nCamino directo UCS");
        for(Nodo nodo : camino)
        {
            System.out.print(nodo + ",");
        }
    }
}
