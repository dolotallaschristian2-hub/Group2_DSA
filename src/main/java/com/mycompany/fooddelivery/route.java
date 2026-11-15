package com.mycompany.fooddelivery;

import java.util.*;

public class route {
    private Map <String, List<Edge>> graph = new HashMap<>();
    
    static class Edge{
        String diliviry;
        double distance;
        
        Edge(String destination, double distance){
            this.diliviry = destination;
            this.distance = distance;
        }
    }
    
    public void addLocation(String location){
        graph.putIfAbsent(location, new ArrayList<>());
    }
    
    public void addRoad(String from, String to, double distance){
        addLocation(from);
        addLocation(to);
        
        graph.get(from).add(new Edge(to,distance));
        graph.get(to).add(new Edge(from,distance));
        
    }
    
    public LinkedList <String> Shortestroute(String start, String destination){
        if(!graph.containsKey(start)|| !graph.containsKey(destination)){
            System.out.println("Location Not Found");
            return null;
        }
        
        Map<String, Double> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        
        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        
        for (String location : graph.keySet()){
            distances.put(location, Double.MAX_VALUE);
        }
        distances.put(start, 0.0);
        queue.add(start);
        
        while(!queue.isEmpty()){
            String current = queue.poll();
            
                if(current.equals(destination)){
                    break;
                }
                for(Edge edge: graph.get(current)){
                    double newDistance = distances.get(current) + edge.distance;
                    if(newDistance < distances.get(edge.diliviry)){
                    
                    distances.put(edge.diliviry, newDistance);
                    previous.put(edge.diliviry, current);
                    
                    queue.remove(edge.diliviry);
                    queue.add(edge.diliviry);
                }
            }    
        }
        if(distances.get(destination) == Double.MAX_VALUE){
            System.out.println("No Available Route");
           
        }
         LinkedList<String> path = new LinkedList<>();

        String current = destination;

        while (current != null) {
            path.addFirst(current);
            current = previous.get(current);
        }

        System.out.println("Shortest Delivery Route: " + path);
        System.out.println(
            "Total Distance: " +
            distances.get(destination) + " km"
                
        );
        return path;
    
    }
}
