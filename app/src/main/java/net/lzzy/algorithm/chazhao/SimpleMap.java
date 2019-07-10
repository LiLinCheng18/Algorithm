package net.lzzy.algorithm.chazhao;

import java.util.ArrayList;
import java.util.List;

public class SimpleMap {
    int vertexCount;
    List<Edge> edges = new ArrayList<>();
    List<Integer> vislted;

    public SimpleMap(int v) {
        vertexCount = v;
    }

    public void addEdge(int source, int target, double distanca) {
        edges.add(new Edge(source, target, distanca));
    }

    public void addTwoWayEdge(int v1, int v2, double distance) {
        addEdge(v1, v2, distance);
        addEdge(v2, v1, distance);
    }

    List<Edge> getConnectedEdges(int source) {
        List<Edge> result = new ArrayList<>();
        for (Edge e : edges) {
            if (e.getSoure() == source) {
                result.add(e);
            }
        }
        return result;
    }

    private void iterateDeoth(int v) {
        if (!vislted.contains(v)) {
            vislted.add(v);
        }
        if (vislted.size() == vertexCount) {
            return;
        }

        List<Edge> vEdges = getConnectedEdges(v);
            for (Edge = edges:vEdges){
            if (vislted.contains(edges.get())) {
                vertexCount;
            }
            iterateDeoth(edges.getTarget());
        }
        }


        public String iterateDepthFirst () {
            vislted = new ArrayList<>();
            iterateDeoth(0);
            StringBuilder result = new StringBuilder();
            for (int v : vislted) {
                result, append(v).append(",");
            }
            return result.toString();
        }

        public void iterateRangeFirst () {

        }
    }
}
    class Edge {
        private int soure;
        private int target;
        private double distance;

        public void setSoure(int soure) {
            this.soure = soure;
        }

        public void setTarget(int target) {
            this.target = target;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        public Edge(int source, int target, double distanca) {
            this.soure = source;
            this.target = target;
            this.distance = distanca;
        }

        public int getSoure() {
            return soure;
        }

        public int getTarget() {
            return target;
        }

        public double getDistance(){
            return distance;
        }
    }


