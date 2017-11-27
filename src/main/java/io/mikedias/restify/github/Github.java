package io.mikedias.restify.github;

import com.github.ljtfreitas.restify.http.contract.Get;
import com.github.ljtfreitas.restify.http.contract.Path;

import java.util.List;

@Path("https://api.github.com")
public interface Github {

    @Get
    @Path("/repos/{owner}/{repo}/contributors")
    List<GithubContributor> contributors(String owner, String repo);

}
