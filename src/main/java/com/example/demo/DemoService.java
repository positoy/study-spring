package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;

@Service
public class DemoService {

    DemoRepository repository;

    public DemoService(DemoRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public Demo addDemo(Demo demo) {
        repository.demos.add(demo);
        return demo;
    }

    public ArrayList<Demo> addDemos(ArrayList<Demo> demos) {
        for (Demo d : demos)
            repository.demos.add(d);
        return demos;
    }

    // READ
    public ArrayList<Demo> getAll() {
        return repository.demos;
    }

    public Demo getDemo(int id) {
        return repository.demos.get(id);
    }

    public ArrayList<Demo> getDemoWithData(String data) {
        ArrayList<Demo> demos = new ArrayList<>();
        for (Demo d : repository.demos) {
            if (d.getData().equals(data))
                demos.add(d);
        }
        demos.sort(new Comparator<Demo>() {
            @Override
            public int compare(Demo o1, Demo o2) {
                return o1.getId() - o2.getId();
            }
        });
        return demos;
    }

    // UPDATE
    public Demo updateDemo(int id, Demo demo) {
        for (int i=0; i<repository.demos.size(); i++)
            if (repository.demos.get(i).getId() == demo.getId()) {
                repository.demos.set(i, demo);
            }
        return demo;
    }

    // DELETE
    public Demo deleteDemo(int id) {
        Demo d = null;
        try {
            d = repository.demos.get(id).clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
        repository.demos.remove(id);
        return d;
    }
}
