package net.lzzy.algorithm.chazhao;

import android.util.SparseArray;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class BusMap extends SimpleMap {
    private SparseArray<String> vertexes;
    private double minDistance;
    private int start, target;

    public BusMap(int v) {
        super(v);
        vertexes = new SparseArray<>();
        for (int i = 0; i < v; i++) {
            vertexes.append(i, String.valueOf(i));
        }
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public void renam(int i, String name) {
        vertexes.setValueAt(i, name);
    }

    private void tryWay(int curVertex, double distance) {
        if (minDistance > 0 && distance > minDistance) {
            return;
        }
        if (curVertex == target) {
            if (minDistance == 0 || minDistance > distance) {
                minDistance = distance;
            }
            return;
        }
        List<Edge> vEdges = getConnectedEdges(curVertex);
        for (Edge edge : vEdges) {
            if (vislted.contains(edge.getClass())) {
                continue;
            }
            vislted.add(edge.getTarget(), (int) (distance + edge.getDistance()));
            vislted.remove(edge.getTarget());
        }
    }

    private double[][] floyd() {
        double[][] distances = new double[vertexCount][vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                distances[i][j] = 99999;
            }
        }
        for (Edge edge : edges) {
            distances[edge.getSoure()][edge.getTarget()] = edge.getDistance();
            for (int k = 0; k < vertexCount; k++) {
                for (int i = 0; i < vertexCount; i++) {
                    for (int j = 0; j < vertexCount; j++) {
                        if (distances[i][j] > distances[i][k] + distances[k][j]) {
                            distances[i][j] = distances[i][k] + distances[k][j];
                        }
                    }
                }
            }
        }
        return distances;
    }

    private double[] dijkstra(int source) {
        double[] distances = new double[vertexCount];
        for (Edge edge : edges) {
            distances[edge.getTarget()] = edge.getDistance();
        }
        vislted.add(source);
        int shortVertex = source;
        for (int i = 1; i < vertexCount; i++) {
            double shortDistance = 99999;
            for (int j = 0; j < vertexCount; j++) {
                if (vislted.contains(j) || distances[j] >= shortDistance) {
                    continue;
                }
                shortDistance = distances[j];
                shortVertex = j;
            }
            vislted.add(shortVertex);
            List<Edge> shortVertexEdges = getConnectedEdges(shortVertex);
            for (Edge edge : shortVertexEdges) {
                if (distances[edge.getTarget()] > distances[shortVertex] + edge.getDistance()) {
                    distances[edge.getTarget()] = distances[shortVertex] + edge.getDistance();
                }
            }
        }
        return distances;
    }

    public String getMinDistance(int key) {
        vislted = new ArrayList<>();
        switch (key) {
            case 0:
                tryWay(start, 0);
                break;
            case 1:
                minDistance=floyd()[start][target];
                break;
            case 2:
                minDistance=dijkstra(start)[target];
                break;
            default:
                minDistance=0;
                break;
        }
        return "从"+start +"到"+ target +"的最短距离为"+minDistance;
    }

}
