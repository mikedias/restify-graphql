package io.mikedias.restify;

import com.github.ljtfreitas.restify.http.contract.Get;
import com.github.ljtfreitas.restify.http.contract.Path;
import com.github.ljtfreitas.restify.http.contract.PathParameter;

import java.util.List;

@Path("https://api.github.com")
public interface GitHub {

    @Get
    @Path("/repos/{owner}/{repo}/contributors")
    List<Contributor> contributors(String owner, String repo);

}
