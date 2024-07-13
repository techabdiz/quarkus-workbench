package org.packaege;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.packaege.beans.Appearance;
import org.packaege.repository.AppearanceRepository;

import javax.print.attribute.standard.Media;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Path("spackage")
public class EndPoint {

    @ConfigProperty( name = "default.name", defaultValue = "Oliver, Jamie")
    private String defaultName;

    @ConfigProperty(name = "default.color", defaultValue = "White")
    private String defaultColor;

    @ConfigProperty(name="default.height", defaultValue = "5.7")
    private Double defaultHeight;

    @ConfigProperty(name="default.weight", defaultValue = "56")
    private Double defaultWeight;


    @Inject
    private AppearanceRepository repo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Appearance pack(){
        return Appearance.builder()
                .name(defaultName)
                .height(defaultHeight)
                .weight(defaultWeight)
                .skinColor(defaultColor)
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public List<Appearance> getAll() {
        return repo.getAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("count")
    public Map<String, Integer> getCount(){
        return Map.of("count", repo.getCount());
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("get/{id}")
    public Optional<Appearance> getById(@PathParam("id") Integer id){
        return repo.getById(id);
    }

    @POST
    @Path("save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Appearance> addAppearance(Appearance app) {
        return Optional.of(repo.save(app));
    }
}
