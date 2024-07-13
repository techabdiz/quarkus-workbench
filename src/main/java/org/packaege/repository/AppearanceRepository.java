package org.packaege.repository;

import jakarta.enterprise.context.ApplicationScoped;
import org.packaege.beans.Appearance;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@ApplicationScoped
public class AppearanceRepository {

    List<Appearance> appearanceList = new ArrayList<>(List.of(
            Appearance.builder().id(1).name("Corby, James").height(6.11).weight(67.4)
                    .skinColor("Light Brown").build(),
            Appearance.builder().id(2).name("Andre, Eric").height(6d).weight(54d)
                    .skinColor("Pale White").build()
    ));

    public List<Appearance> getAll(){
        return appearanceList;
    }

    public Integer getCount() {
        return appearanceList.size();
    }

    public Optional<Appearance> getById(Integer id){
        return appearanceList.stream().filter(s-> Objects.equals(s.getId(), id)).findFirst();
    }

    public Appearance save(Appearance app) {
         appearanceList.add(app);
        return app;
    }
}
