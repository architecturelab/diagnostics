package com.architecturelab.diagnostics.application.config.health;

import com.architecturelab.diagnostics.infra.config.DatabaseHealthContributor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.CompositeHealthContributor;
import org.springframework.boot.actuate.health.HealthContributor;
import org.springframework.boot.actuate.health.NamedContributor;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

@Component("InventoryAPI")
public class DiagnosticsAPIHealthContributor implements CompositeHealthContributor {

    private Map<String, HealthContributor>
            contributors = new LinkedHashMap<>();

    @Autowired
    public DiagnosticsAPIHealthContributor(
            DatabaseHealthContributor
                    databaseHealthContributor) {

        contributors.put("database",
                databaseHealthContributor);
    }

    @Override
    public HealthContributor getContributor(String name) {
        return contributors.get(name);
    }

    @Override
    public Iterator<NamedContributor<HealthContributor>> iterator() {
        return contributors.entrySet().stream()
                .map((entry) ->
                        NamedContributor.of(entry.getKey(),
                                entry.getValue())).iterator();
    }
}
