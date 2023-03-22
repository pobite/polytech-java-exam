package com.pobitecoding.algorithm.roadroadpark.service;

import java.util.ArrayList;
import java.util.List;
import com.pobitecoding.roadroadpark.obj.ConstructionImpl;

public class ConstructionService {
    
    private List<ConstructionImpl> constructions;

    public ConstructionService(List<ConstructionImpl> constructions) {
        constructions = new ArrayList<>();
    }
}
